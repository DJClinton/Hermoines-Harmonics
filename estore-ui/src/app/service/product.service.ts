import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders().append('Content-Type', 'application/json'),
  };

  private inverntoryUrl = 'http://localhost:8080/inventory';

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  getProducts(): Observable<any> {
    return this.http.get(this.inverntoryUrl);
  }

  getProduct(id: number): Observable<any> {
    const url = `${this.inverntoryUrl}/${id}`;
    return this.http
      .get(url)
      .pipe(catchError(this.handleError<any>(`getProduct id:${id}`)));
  }

  addProduct(product: any): Observable<any> {
    return this.http
      .post(this.inverntoryUrl, product, this.httpOptions)
      .pipe(catchError(this.handleError<any>('addProduct')));
  }

  updateProduct(product: any): Observable<any> {
    return this.http
      .put(this.inverntoryUrl, product, this.httpOptions)
      .pipe(catchError(this.handleError<any>('updateProduct')));
  }

  deleteProduct(id: number): Observable<any> {
    const url = `${this.inverntoryUrl}/${id}`;
    return this.http
      .delete(url, this.httpOptions)
      .pipe(catchError(this.handleError<any>('deleteProduct')));
  }

  searchProductsByName(term: string): Observable<any> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http
      .get(`${this.inverntoryUrl}/?name=${term}`)
      .pipe(
        catchError(this.handleError<any>(`searchProducts term:${term}`, []))
      );
  }
}
