import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders().append('Content-Type', 'application/json'),
  };

  private orderUrl = 'http://localhost:8080/orders';

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  updateOrder(order: any): Observable<any> {
    return this.http
      .put(this.orderUrl, order, this.httpOptions)
      .pipe(catchError(this.handleError(`updateOrder`)));
  } 
  
  getUser(): string | null{
    const token = localStorage.getItem('token');
    const username = token ? token.split(`:`)[0] : null;
    return username;
  }

  getOrder(id: number): Observable<any>{
    const url = `${this.orderUrl}/${id}`;
    return this.http
    .get(url)
    .pipe(catchError(this.handleError(`getProduct id:${id}`)));
  }

  getOrders(): Observable<any>{
    return this.http.get(this.orderUrl);
  }

  createOrder(order: any): Observable<any>{
    return this.http
    .post(this.orderUrl, order, this.httpOptions)
    .pipe(catchError(this.handleError(`createOrder`)));
  }
}

