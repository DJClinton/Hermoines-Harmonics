import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpEventType,
} from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private router: Router) {}
  token: string | null = null;

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (
      request.url.includes('authenticate') ||
      request.url.includes('signup')
    ) {
      console.log('auth');
      return next.handle(request);
    }
    if (this.token === null) {
      this.setToken(localStorage.getItem('token'));
      if (this.token === null) {
        this.router.navigate(['/login']);
        throw new Error('Unauthorized');
      }
    }
    request.headers.append('Authorization', this.token);
    return next.handle(request);
  }

  setToken(token: string | null): void {
    this.token = token;
  }
}
