package com.example.is_projekt.controllers;

import com.example.is_projekt.modelDTO.RegionDTO;
import com.example.is_projekt.modelDTO.StatisticsDTO;
import com.example.is_projekt.repositories.StatisticsRepository;
import com.example.is_projekt.services.RegionService;
import com.example.is_projekt.services.StatisticsService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/stats")
public class StatisticsController  {
    private final StatisticsRepository statisticsRepository;
    private final StatisticsService statisticsService;
    private final RegionService regionService;

    /**
     * Endpoint do pobierania wszystikch danych
     */
    @GetMapping("/all")
    private ResponseEntity<List<StatisticsDTO>> getAllStats(){
        return ResponseEntity.ok(statisticsService.getAllStats());
    }

    @GetMapping("/regions")
    private ResponseEntity<List<RegionDTO>> getRegions(){
            return ResponseEntity.ok(regionService.getRegions());
    }

    /**
     * Endpoint do pobierania pliku xml
     */
    @GetMapping(value = "data.xml" ,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> saveToXML()throws ParserConfigurationException, TransformerException,IOException {

        statisticsService.saveToXML();

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:stats.xml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return statisticsService.getResourceResponseEntity(file);
    }

    /**
     * Endpoint do pobierania pliku json
     */
    @GetMapping(value = "/data.json",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadJSON() throws IOException {

        statisticsService.saveToJSON();

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:stats.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return statisticsService.getResourceResponseEntity(file);
    }

    @GetMapping("/stats/{year}")
    public ResponseEntity<List<StatisticsDTO>> getStatsByYear(@PathVariable int year){

        return ResponseEntity.ok(statisticsService.getStatsForYear(year));
    }

    @GetMapping("/stats/boot")
    public ResponseEntity<List<StatisticsDTO>> bootData(){
        return ResponseEntity.ok(statisticsService.loadDataToDatabase());
    }

    @GetMapping("/stats/reloadData")
    public ResponseEntity<List<StatisticsDTO>> removeData(){
        return ResponseEntity.ok(statisticsService.removeAllData());
    }

}
