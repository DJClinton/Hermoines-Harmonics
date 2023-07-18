import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { BuyerInfo } from './type';

@Injectable({
  providedIn: 'root',
})
export class BuyerInfoService {
  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  private accountsURL = 'http://localhost:8080/account';

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  getBuyerInfos(): Observable<Array<BuyerInfo>> {
    return this.http.get<Array<BuyerInfo>>(this.accountsURL);
  }

  getBuyerInfo(id: number): Observable<BuyerInfo> {
    const url = `${this.accountsURL}/${id}`;
    return this.http
      .get<BuyerInfo>(url)
      .pipe(catchError(this.handleError<any>(`getBuyerInfo id:${id}`)));
  }

  getBuyerInfosByUserId(userid: number): Observable<Array<BuyerInfo>> {
    return this.http
      .get<Array<BuyerInfo>>(`${this.accountsURL}/?name=${userid}`)
      .pipe(
        catchError(
          this.handleError<any>(`getBuyerInfosByUserId userid:${userid}`, [])
        )
      );
  }

  addBuyerInfo(buyerInfo: any): Observable<BuyerInfo> {
    return this.http
      .post<BuyerInfo>(this.accountsURL, buyerInfo, this.httpOptions)
      .pipe(catchError(this.handleError<any>('addBuyerInfo')));
  }

  updateBuyerInfo(buyerInfo: any): Observable<BuyerInfo> {
    return this.http
      .put<BuyerInfo>(this.accountsURL, buyerInfo, this.httpOptions)
      .pipe(catchError(this.handleError<any>('updateBuyerInfo')));
  }

  deleteBuyerInfo(id: number): Observable<BuyerInfo> {
    const url = `${this.accountsURL}/${id}`;
    return this.http
      .delete<BuyerInfo>(url, this.httpOptions)
      .pipe(catchError(this.handleError<any>('deleteBuyerInfo')));
  }
}
