import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of, tap } from 'rxjs';
import { Product } from './type';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  private inverntoryUrl = 'http://localhost:8080/inventory';

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  getProducts(): Observable<any> {
    return this.http
      .get<Product[]>(this.inverntoryUrl)
      .pipe(catchError(this.handleError<any>('getProducts')));
  }

  getProduct(id: number): Observable<Product> {
    const url = `${this.inverntoryUrl}/${id}`;
    return this.http
      .get<Product>(url)
      .pipe(catchError(this.handleError<any>(`getProduct id:${id}`)));
  }

  addProduct(product: Product): Observable<any> {
    return this.http
      .post<Product>(this.inverntoryUrl, product, this.httpOptions)
      .pipe(catchError(this.handleError<any>('addProduct')));
  }

  updateProduct(product: Product): Observable<Product> {
    return this.http
      .put<Product>(this.inverntoryUrl, product, this.httpOptions)
      .pipe(catchError(this.handleError<any>('updateProduct')));
  }

  deleteProduct(id: number): Observable<Product> {
    const url = `${this.inverntoryUrl}/${id}`;
    return this.http
      .delete<Product>(url, this.httpOptions)
      .pipe(catchError(this.handleError<any>('deleteProduct')));
  }

  searchProductsByName(term: string): Observable<any> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http
      .get<Product[]>(`${this.inverntoryUrl}/?name=${term}`)
      .pipe(
        catchError(this.handleError<any>(`searchProducts term:${term}`, []))
      );
  }
}
