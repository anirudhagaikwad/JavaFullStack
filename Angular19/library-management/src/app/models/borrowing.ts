import { Book } from './book';

export interface Borrowing {
  id?: number;
  book: Book;
  borrowDate: string;
  dueDate: string;
  returnDate?: string;
  returned: boolean;
  fineAmount: number;
}