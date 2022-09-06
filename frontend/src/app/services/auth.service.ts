import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserCredentials} from "../models/UserCredentials";
import {Observable} from 'rxjs';

@Injectable({providedIn: 'root'})
export class AuthService {

  authUrl = 'http://localhost:8080/api/v1/auth/login';
  registerUrl = 'http://localhost:8080/api/v1/auth/new-account';
  setupKeyUrl = 'http://localhost:8080/api/v1/auth/key';

  constructor(private http: HttpClient) {
  }

  login(login: string, password: string): Observable<any> {

    const userCredentials = new UserCredentials();
    userCredentials.username = login;
    userCredentials.password = password;

    return this.http.post<TokenResponse>(`${this.authUrl}`, userCredentials);
  }

  logout() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('key');
  }

  getToken(): string {
    return sessionStorage.getItem('token');
  }

  setToken(token: string) {
    sessionStorage.setItem('token', token);
  }

  setPasswordKeyStorage() {
    sessionStorage.setItem('key', 'true');
  }

  getPasswordKeyStorage(): string {
    return sessionStorage.getItem('key');
  }

  flushPasswordKeyStorage(): void {
    return sessionStorage.removeItem('key');
  }

  register(username: string, password: string): Observable<any> {
    return this.http.post<TokenResponse>(this.registerUrl, {username, password});
  }

  setPasswordKey(passwordKey: string): Observable<any> {
    return this.http.post<TokenResponse>(this.setupKeyUrl, {passwordKey});
  }
}

interface TokenResponse {
  token: string
}

