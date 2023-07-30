import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, throwError } from 'rxjs';
import { AuthorizationService } from './authorization.service';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {
  private cartUrl = 'http://localhost:8080/account/cart'

  constructor(
    private http: HttpClient,
    private auth: AuthorizationService
  ) {}


  private getHttpOptions(): {headers: HttpHeaders} {
    const token = localStorage.getItem('token');
    if (!token){
      return {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    }

    return{
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token,
      }),
    };
  }

  
  getCart(userID: number): Observable<any>{
    try{
      const httpOptions = this.getHttpOptions();
      console.log('API URL:', this.cartUrl + '/' + userID);
      return this.http.get(this.cartUrl + '/' + userID, httpOptions)
    }
    catch(error){
      console.error('Error parsing token:', error);
      return throwError('Error getting cart');
    }
  }
}
