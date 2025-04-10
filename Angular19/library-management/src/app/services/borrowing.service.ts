import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Borrowing } from '../models/borrowing';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BorrowingService {
  private apiUrl = `${environment.apiUrl}/borrowings`;

  constructor(private http: HttpClient) {}

  borrowBook(bookId: number, memberId: number): Observable<Borrowing> {
    return this.http.post<Borrowing>(`${this.apiUrl}/borrow/${bookId}/${memberId}`, {});
  }

  returnBook(borrowingId: number): Observable<Borrowing> {
    return this.http.put<Borrowing>(`${this.apiUrl}/return/${borrowingId}`, {});
  }

  getBorrowings(): Observable<Borrowing[]> {
    return this.http.get<Borrowing[]>(this.apiUrl);
  }
}