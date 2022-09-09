# Temat projektu: System do katalogowania i zarządzania książkami z funkcjami społecznościowymi.

 
## SPIS TREŚCI

1. PROJEKT APLIKACJI – OPIS I WSTĘPNE ZAŁOŻENIA PROJEKTOWE
2. WYKORZYSTANE TECHNOLOGIE
3. PROJEKT BAZY DANYCH
4. INTERFEJS REST API
5. WDROŻENIE SYSTEMU
6. INTERFEJS UŻYTKOWNIKA
7. PODSUMOWANIE

# 1. PROJEKT APLIKACJI – OPIS I WSTĘPNE ZAŁOŻENIA PROJEKTOWE

## 1.1. Wstęp

Celem pracy jest opracowanie i implementacja projektu aplikacji internetowej, na wzór takich serwisów jak lubimyczytac.pl lub goodreads.com, której zadaniem jest umożliwienie użytkownikowi prowadzenia katalogu książek, które przeczytał. Poszczególni użytkownicy będą mogli ocenić daną książkę w skali 1-5 oraz wystawić jej opcjonalną recenzję. Ponadto jeżeli użytkownik nie znajdzie interesującej go książki w bazie danych aplikacji, będzie mógł ją dodać samodzielnie. Aby mieć dostęp do wyżej wymienionych funkcjonalności użytkownik musi najpierw założyć konto a następnie się na nie zalogować. W systemie zalogowani użytkownicy będą podzieleni na dwie kategorię: user i admin. Admin poza wszystkimi prawami przysługującymi zwykłemu użytkownikowi będzie miał dostęp do funkcjonalności która jest zarezerwowana tylko dla niego tj. możliwość usuwania książek oraz edycji i usuwania ocen i komentarzy innych użytkowników. W przypadku użytkowników nieposiadających konta w serwisie ich możliwości będą ograniczały się jedynie do przeglądania książek oraz profili innych użytkowników.
<br />

 # 1.2. Aktorzy

## 1.2.1. Opis aktorów

1.	Gość - aktor odwiedzający serwis który nie posiada konta, ma ograniczone uprawnienia. Ma możliwość samodzielnego założenia konta w celu zwiększenia swoich uprawnień.

2.	Użytkownik - aktor posiadający wszystkie uprawnienia aktora Gość oraz uprawnienia pozwalające mu na zarządzanie swoim profilem. Może mieć wpływ na stan wewnętrzny systemu poprzez np. dodanie nowych treści do serwisu.
3.	Administrator - aktor posiadający najwyższe uprawnienia w systemie, pozwalające mu na zarządzanie tym systemem. Posiada również wszystkie uprawnienia przysługujące innym aktorom.
<br />

 ## 1.2.2. Hierarchia aktorów

<div align="center">
  Gość ←Użytkownik←Administrator
  
  Gdzie ← oznacza kierunek dziedziczenia: nadklasa ← podklasa.
</div>
<br />
 
 ## 1.3. Wymagania funkcjonalne

1.	Rejestracja i logowanie - funkcjonalność umożliwiająca Gościowi założenie konta a następnie zalogowanie się na nie w celu uzyskania dostępu do funkcjonalności przeznaczonych tylko dla zarejestrowanych użytkowników.

2.	Przeglądanie katalogu książek - funkcjonalność umożliwiająca Gościowi i wszystkim aktorom od niego dziedziczącym na przeglądanie dostępnego katalogu książek w systemie.

3.	Przeglądanie ocen użytkowników - funkcjonalność umożliwiająca Gościowi i wszystkim aktorom od niego dziedziczącym przeglądanie ocen i komentarzy wystawionych przez Użytkownika i Administratora.

4.	Przeglądanie danych użytkownika - funkcjonalność umożliwiająca Gościowi i wszystkim aktorom od niego dziedziczącym przeglądanie danych na temat danego Użytkownika i Administratora.
5.	Dodawanie książki do systemu - funkcjonalność umożliwiająca Użytkownikowi i wszystkim aktorom od niego dziedziczącym dodanie do systemu nowej książki
6.	Usunięcie i modyfikacja książki - funkcjonalność umożliwiająca Administratorowi usunięcie lub modyfikację książki która znajduje się w systemie.
7.	Dodanie oceny i komentarza do systemu - funkcjonalność umożliwiająca Użytkownikowi i wszystkim aktorom od niego dziedziczącym dodanie oceny i opcjonalnego komentarza na temat wybranej książki.
8.	Usuwanie i modyfikacja komentarzy i ocen książki - funkcjonalność umożliwiająca Użytkownikowi usunięcie i modyfikację oceny i komentarza którego jest autorem. Administrator posiada tą samą funkcjonalność jednak umożliwia mu ona również zarządzanie komentarzami i ocenami dodanymi przez innych użytkowników.
<br />

## 1.4. Wymagania niefunkcjonalne

1.	Jako język programowania po stronie serwera powinien być wykorzystany język Java w wersji co najmniej 17 wraz z szkieletem programistycznym Spring Boot 2.6.7.
2.	System po stronie serwera powinien udostępniać REST API.
3.	Jako serwer webowy system powinien wykorzystywać serwer Tomcat 9.0.12.
4.	Jako narzędzie budowania i zarządzania zależnościami dla języka Java powinien zostać wykorzystany Apache Maven 3.8.
5.	System powinien wykorzystywać MySQL jako system zarządzania bazą danych.
6.	Hasła użytkowników powinny być przechowywane w bazie danych w formie skrótu.
7.	Do obliczania skrótów haseł powinna być wykorzystana funkcja bycrypt.
8.	Do autentykacji i autoryzacji powinny być wykorzystane tokeny JWT weryfikowane po stronie serwera.
9.	Po stronie klienta system powinien wykorzystywać język znaczników HTML5, język arkuszy stylów CSS3 oraz język programowania JavaScript w wersji co najmniej ES6.
10.	Strona internetowa powinna zostać zbudowana w technice SPA (Single-page application), przy wykorzystaniu szkieletu programistycznego Vue.js 3.

11.	Jako menedżer pakietów języka JavaScript powinien być wykorzystany npm.
12.	Do konteneryzacji aplikacji powinno zostać wykorzystane narzędzie Docker 20.10.7 oraz docker-compose 1.29.2.

13.	Strona internetowa powinna posiadać jednolitą oprawę graficzna.
14.	Strona internetowa powinna być responsywna.
15.	System powinien działać na komputerach z systemem Windows, Linux oraz na telefonach i tabletach z systemem Android.
16.	System obsługiwany na komputerach powinien działać na przeglądarkach Chrome, Firefox oraz Opera.
<br />

# 2. WYKORZYSTANE TECHNOLOGIE
## 2.1. Java + Spring
Spring Framework jest szkieletem programistycznym służącym do tworzenia aplikacji
w języku Java. Spring powstał w 2003 roku będąc bezpośrednią odpowiedzią na Java EE
która charakteryzowała się wysokim stopniem złożoności i pewnymi niedociągnięciami. Do
dnia dzisiejszego Java EE otrzymała wiele poprawek które uprościły pracę w tej technologii
jednak Spring pozostała preferowanym wyborem dla większości deweloperów. Zawdzięcza to
nie tylko temu że jest wciąż prostszy w użycia od Java EE ale również ze względu na cały
ekosystem Spring, który jest platformą dla wielu innych projektów takich jak Spring Security,
Spring Data czy Spring Cloud. W prezentowanej pracy zostały wykorzystane liczne projekty
wchodzące w skład platformy Spring.
<br />

## 2.1.1. Spring boot
Spring Boot to projekt którego celem jest dostarczenie gotowych, predefiniowanych
konfiguracji dla Spring Framework w celu uproszczenia uruchomienia aplikacji. W
projektowanej aplikacji Spring wykorzystywany jest do stworzenia i REST API które będzie
wykorzystane do komunikacji pomiędzy backendem i frontendem aplikacji.
<br />

## 2.1.2. Spring Data JPA
Spring Data JPA jest narzędziem które ułatwia korzystanie i interakcję z bazą danych
w projektach pisanych przy użyciu języka Java. Pozwala on na uniknięcie przez programistę
pisania warstwy DAO (Data Access Object), więki dostarczeniu kilku rodzajów interfejsów
repozytoriów. Na podstawie sygnatur metod zdefiniowanych przez programistę w tych
interfejsach zostanie wygenerowanych kod który odpowiada za interakcję z bazą danych.
<br />

## 2.1.3. Spring Security
Spring Security to wysoce konfigurowalne narzędzie do uwierzytelniania i kontroli
dostępu. W prezentowanej pracy Spring Security został użyty w celu implementacji
funkcjonalności logowania, rejestracji oraz autentykacji i autoryzacji na podstawie tokenów
JWT. Spring Security dostarcza również kilka popularny
<br />

## 2.1.4. Spring OpenAPI + Swagger UI
Biblioteka pomagająca w automatyzacji generowania dokumentacji API w projektach
wykorzystujących Spring Boot. W aplikacji biblioteka ta została wykorzystana w połączeniu
ze Swagger UI w celu wygenerowania interfejsu graficznego pozwalającego na bezpośrednią
interakcję z REST API.
<br />

# 2.2. Hibernate
Hibernate jest frameworkiem stanowiącym najpopularniejszą implementację Java
Persistance API (JPA) - oficjalny standard dla mapowania relacyjno obiektowego dla języka
Java. Mapowanie relacyjno obiektowe to proces konwersji obiektów na tabele w bazie
danych, bez potrzeby stosowania języka SQL. Hibernate jest implementacją JPA która jest
domyślnie wykorzystywana przez Spring.
<br />

# 2.3. MySQL
MySQL to stworzony przez firmę Oracle otwartoźródłowy system zarządzania
relacyjną bazą danych który wykorzystuje język SQL. Jak we wszystkich relacyjnych bazach
danych opartych na języku SQL, dane przechowywane są w tabelach składających się z
wierszy i kolumn. MySQL umożliwia tworzenie, zarządzanie i odpytywanie bazy danych oraz
zapewnienia zabezpieczenia przed nieautoryzowanym dostępem korzystając z mechanizmów
uwierzytelniających. W prezentowanym projekcie MySQL jest wykorzystywany do
przechowywania i agregowania danych o poszczególnych bytach obecnych w systemie.
<br />

# 2.4. HTML5 + CSS3 + Bootstrap
HTML to hipertekstowy język znaczników który jest stosowany do definiowania
struktury i treści strony internetowej. Przeglądarki internetowe odczytują składnię języka i
interpretują ją, a następnie wyświetlają. CSS czyli kaskadowe arkusze stylów, służą do opisu
prezentacji strony internetowej zdefiniowanej uprzednio przy wykorzystaniu HTML.
Bootstrap to biblioteka CSS która zawiera zestaw przydatnych narzędzi ułatwiających
tworzenie responsywnego interfejsu graficznego użytkownika zgodnie z filozofią mobile-first
design.
<br />

# 2.5. JavaScript + Vue.js
JavaScript to skryptowy oraz wieloparadygmatowy, interpretowany język
programowania, umożliwiający obsługę dynamicznego tworzenia treści na stronie
internetowej. Jest językiem lekkim i najczęściej wykorzystywanym jako język który jest
wykonywany w przeglądarce internetowej, jako część strony internetowej. Vue.js jest
frameworkiem wykorzystującym język JavaScript który upraszcza tworzenie interaktywnych
stron internetowych. Vue.js koncentruje się na ułatwieniu w tworzeniu aplikacji typu SPA -
Single Page Application. W projekcie framework ten został wykorzystany do stworzenia
interfejsu użytkownika w postaci aplikacji internetowej. Dzięki zastosowaniu Vuex
(biblioteka pozwalającą na tworzenie sesji dla użytkownika) możliwe było
zaimplementowanie funkcjonalności autoryzacji użytkownika.
<br />

# 2.6. Docker + Docker Compose
Docker to otwartoźródłowe oprogramowanie do tworzenia oraz zarządzania
wirtualnymi kontenerami aplikacji. Kontenery pozwalają na odseparowanie aplikacji od
wykorzystywanej przez nas infrastruktury co pozwala na łatwiejsze i tańsze budowanie i
uruchamianie aplikacji. Docker Compose jest narzędziem do definiowania i uruchomienia
wielokontenerowej aplikacji. W tworzonym projekcie Docker wraz z Docker Compose
zostały zastosowane do stworzenia konfiguracji która umożliwia zbudowanie i uruchomienie
stworzonego projektu przy pomocy jednego polecenia
<br />

# 3. PROJEKT BAZY DANYCH
## 3.1. Diagram ERD
<div align="center">
 
![image](https://user-images.githubusercontent.com/93988101/189315725-d6299a32-edbb-4fa2-ab9d-a45392f0a767.png)

</div>

## 3.2. Opis Tabel
<div align="center">
 
![image](https://user-images.githubusercontent.com/93988101/189316031-0f6219bb-a6ee-453f-b3e9-980d9eb0c7e6.png)

</div>

<div align="center">
 
![image](https://user-images.githubusercontent.com/93988101/189316266-d38d31c5-4856-4aff-8067-84e892473cf8.png)
 ![image](https://user-images.githubusercontent.com/93988101/189316311-d5cd8e0a-1ae1-4ca3-9484-0456f52fbeab.png)

</div>
<div align="center">
 
![image](https://user-images.githubusercontent.com/93988101/189316352-afb1c251-8ffc-46ce-9df4-376d4c2c1f22.png)
 
</div>
