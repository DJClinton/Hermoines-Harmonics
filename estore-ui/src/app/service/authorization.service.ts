import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthorizationService {
  constructor(private http: HttpClient, private router: Router) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  private authUrl = 'http://localhost:8080/auth';

  login(email: string, password: string): void {
    this.http
      .post(
        this.authUrl,
        { email: email, password: password },
        this.httpOptions
      )
      .subscribe((data: any) => {
        console.log('data: ', data);
        localStorage.setItem('token', data.token);
        this.router.navigate(['/']);
      });
  }

  signup(email: string, password: string): void {
    this.http
      .put(
        this.authUrl + '/register',
        { email: email, password: password },
        this.httpOptions
      )
      .subscribe((data: any) => {
        localStorage.setItem('token', data.token);
        console.log(data.token);
        this.router.navigate(['/']);
      });
  }
}
