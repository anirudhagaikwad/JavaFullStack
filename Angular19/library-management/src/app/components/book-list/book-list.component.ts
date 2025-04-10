import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { BookService } from '../../services/book.service';
import { BorrowingService } from '../../services/borrowing.service';
import { Book } from '../../models/book';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common'; // Added for *ngIf

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [MatTableModule, MatButtonModule, MatSnackBarModule, RouterLink, CommonModule], // Added CommonModule
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss'],
})
export class BookListComponent implements OnInit {
  books: Book[] = [];
  displayedColumns: string[] = ['title', 'author', 'quantity', 'actions'];
  isAdmin = false;
  memberId = 1; // Hardcoded for demo

  constructor(
    private bookService: BookService,
    private borrowingService: BorrowingService,
    private authService: AuthService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit() {
    this.isAdmin = this.authService.getUserRole().includes('ROLE_ADMIN');
    this.loadBooks();
  }

  loadBooks() {
    this.bookService.getBooks().subscribe({
      next: (books) => (this.books = books),
      error: (err) => this.snackBar.open('Failed to load books: ' + err.message, 'Close', { duration: 3000 }),
    });
  }

  borrowBook(bookId: number) {
    this.borrowingService.borrowBook(bookId, this.memberId).subscribe({
      next: () => {
        this.snackBar.open('Book borrowed successfully', 'Close', { duration: 2000 });
        this.loadBooks();
      },
      error: (err) => this.snackBar.open('Failed to borrow book: ' + err.message, 'Close', { duration: 3000 }),
    });
  }

  deleteBook(id: number) {
    if (confirm('Are you sure you want to delete this book?')) {
      this.bookService.deleteBook(id).subscribe({
        next: () => {
          this.snackBar.open('Book deleted successfully', 'Close', { duration: 2000 });
          this.loadBooks();
        },
        error: (err) => this.snackBar.open('Failed to delete book: ' + err.message, 'Close', { duration: 3000 }),
      });
    }
  }
}