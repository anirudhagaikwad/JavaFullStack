import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { BookService } from '../../services/book.service';
import { Book } from '../../models/book';
import { Router, ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common'; // Added for *ngIf

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    CommonModule, // Added CommonModule
  ],
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.scss'],
})
export class BookFormComponent implements OnInit {
  bookForm: FormGroup;
  isEdit = false;

  constructor(
    private fb: FormBuilder,
    private bookService: BookService,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
    this.bookForm = this.fb.group({
      id: [null],
      title: ['', [Validators.required, Validators.minLength(2)]],
      isbn: ['', [Validators.required, Validators.pattern(/^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|[0-9X]{10}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$/)]],
      author: ['', [Validators.required, Validators.minLength(2)]],
      publicationDate: ['', Validators.required],
      quantity: [0, [Validators.required, Validators.min(0)]],
    });
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.bookService.getBooks().subscribe((books) => {
        const foundBook = books.find((b) => b.id === +id);
        if (foundBook) this.bookForm.patchValue(foundBook);
      });
    }
  }

  onSubmit() {
    if (this.bookForm.valid) {
      const book = this.bookForm.value;
      const action = this.isEdit
        ? this.bookService.updateBook(book.id, book)
        : this.bookService.createBook(book);

      action.subscribe({
        next: () => {
          this.snackBar.open(this.isEdit ? 'Book updated' : 'Book created', 'Close', { duration: 2000 });
          this.router.navigate(['/books']);
        },
        error: (err) => this.snackBar.open('Operation failed: ' + err.message, 'Close', { duration: 3000 }),
      });
    }
  }
}