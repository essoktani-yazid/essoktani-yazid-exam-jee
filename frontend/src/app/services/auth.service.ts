import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

interface LoginResponse { token: string }

@Injectable({ providedIn: 'root' })
export class AuthService {
  private backendHost = 'http://localhost:8085';
  private tokenKey = 'auth_token';

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.backendHost}/auth/login`, { username, password })
      .pipe(tap(res => this.setToken(res.token)));
  }

  setToken(token: string) {
    localStorage.setItem(this.tokenKey, token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  getPayload(): any | null {
    const token = this.getToken();
    if (!token) return null;
    try {
      const payload = token.split('.')[1];
      const decoded = atob(payload.replace(/-/g, '+').replace(/_/g, '/'));
      return JSON.parse(decodeURIComponent(escape(decoded)));
    } catch (e) {
      return null;
    }
  }

  getRole(): string | null {
    const p = this.getPayload();
    if (!p) return null;
    const scope = p['scope'];
    if (!scope) return null;
    return scope.split(' ')[0];
  }

  getUsername(): string | null {
    const p = this.getPayload();
    return p ? p['sub'] : null;
  }
}
