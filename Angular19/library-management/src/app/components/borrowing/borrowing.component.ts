import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { BorrowingService } from '../../services/borrowing.service';
import { Borrowing } from '../../models/borrowing';
import { CommonModule } from '@angular/common'; // Added for *ngIf and pipes

@Component({
  selector: 'app-borrowing',
  standalone: true,
  imports: [MatTableModule, MatButtonModule, MatSnackBarModule, CommonModule], // Added CommonModule
  templateUrl: './borrowing.component.html',
  styleUrls: ['./borrowing.component.scss'],
})
export class BorrowingComponent implements OnInit {
  borrowings: Borrowing[] = [];
  displayedColumns: string[] = ['title', 'borrowDate', 'dueDate', 'fineAmount', 'actions'];

  constructor(private borrowingService: BorrowingService, private snackBar: MatSnackBar) {}

  ngOnInit() {
    this.loadBorrowings();
  }

  loadBorrowings() {
    this.borrowingService.getBorrowings().subscribe({
      next: (borrowings) => (this.borrowings = borrowings),
      error: (err) => this.snackBar.open('Failed to load borrowings: ' + err.message, 'Close', { duration: 3000 }),
    });
  }

  returnBook(borrowingId: number) {
    this.borrowingService.returnBook(borrowingId).subscribe({
      next: () => {
        this.snackBar.open('Book returned successfully', 'Close', { duration: 2000 });
        this.loadBorrowings();
      },
      error: (err) => this.snackBar.open('Failed to return book: ' + err.message, 'Close', { duration: 3000 }),
    });
  }
}