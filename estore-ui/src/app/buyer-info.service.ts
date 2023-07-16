import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuyerInfoService {

  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  private accountsURL = 'http://localhost:8080/account'

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  getBuyerInfos(): Observable<any> {
    return this.http.get(this.accountsURL);
  }

  getBuyerInfo(id: number): Observable<any> {
    const url = `${this.accountsURL}/${id}`;
    return this.http
      .get(url)
      .pipe(catchError(this.handleError<any>(`getBuyerInfo id:${id}`)));
  }

  getBuyerInfosByUserId(userid: number): Observable<any> {
    return this.http
      .get(`${this.accountsURL}/?name=${userid}`)
      .pipe(
        catchError(this.handleError<any>(`getBuyerInfosByUserId userid:${userid}`, []))
      );
  }

  addBuyerInfo(buyerInfo: any): Observable<any> {
    return this.http
      .post(this.accountsURL, buyerInfo, this.httpOptions)
      .pipe(catchError(this.handleError<any>('addBuyerInfo')));
  }

  updateBuyerInfo(buyerInfo: any): Observable<any> {
    return this.http
      .put(this.accountsURL, buyerInfo, this.httpOptions)
      .pipe(catchError(this.handleError<any>('updateBuyerInfo')));
  }

  deleteBuyerInfo(id: number): Observable<any> {
    const url = `${this.accountsURL}/${id}`;
    return this.http
      .delete(url, this.httpOptions)
      .pipe(catchError(this.handleError<any>('deleteBuyerInfo')));
  }


}
