export interface Book {
    id?: number;
    title: string;
    isbn: string;
    author: string;
    publicationDate: string;
    quantity: number;
    available?: boolean;
  }