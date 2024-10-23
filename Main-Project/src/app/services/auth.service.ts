import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable,Subject } from 'rxjs';
import { Student } from '../models/student.model';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    private refreshSubject = new Subject<void>();
  private apiUrl = 'http://localhost:8080/api'; 
  private loggedIn: boolean = false;
  refresh$ = this.refreshSubject.asObservable();

  constructor(private http: HttpClient) {}

  register(student: Student): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, student);
  }

  
isAuthenticated(): boolean {
    return localStorage.getItem('isLoggedIn') === 'true';
  }
  refreshComponent() {
    this.refreshSubject.next();
  }
  
  login(credentials: { email: string; password: string }): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/userlogin`, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }).pipe(
      tap((response: any) => {
        localStorage.setItem('isLoggedIn', 'true');
        localStorage.setItem('user', JSON.stringify(response)); 
        this.refreshComponent();
      })
    );
  }
  
  
  forgotPassword(email: string): Observable<string> {
    const payload = { email };  
    
    return this.http.post<string>(`${this.apiUrl}/forgot-password`, payload, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'  
      }),
      responseType: 'text' as 'json'  
    });
}

  resetPassword(token: string, newPassword: string, confirmPassword: string): Observable<any> {
    const payload = { token, newPassword, confirmPassword };
    return this.http.post<any>(`${this.apiUrl}/reset-password`, payload, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
  

  logout(): void {
    localStorage.clear();

  }

  isLoggedIn(): boolean {
    return this.isAuthenticated();
  }

  setLoggedIn(status: boolean): void {
    this.loggedIn = status;
  }
}