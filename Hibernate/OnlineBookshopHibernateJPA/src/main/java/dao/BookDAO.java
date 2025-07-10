package dao;

import entity.Author;
import entity.Book;
import entity.Category;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

import app.JPAUtil;

public class BookDAO {

    // Add a new book with author and category
    public static void addBook(Scanner sc) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            sc.nextLine(); // clear buffer
            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            // Fetch authors
            List<Author> authors = em.createQuery("FROM Author", Author.class).getResultList();
            if (authors.isEmpty()) {
                System.out.println("❌ No authors available. Please add an author first.");
                return;
            }

            System.out.println("Select Author ID:");
            for (Author a : authors) {
                System.out.println(a.getAuthorId() + ". " + a.getName());
            }

            int authorId = sc.nextInt();
            Author author = em.find(Author.class, authorId);
            if (author == null) {
                System.out.println("❌ Invalid author ID.");
                return;
            }

            // Fetch categories
            List<Category> categories = em.createQuery("FROM Category", Category.class).getResultList();
            if (categories.isEmpty()) {
                System.out.println("❌ No categories available. Please add a category first.");
                return;
            }

            System.out.println("Select Category ID:");
            for (Category c : categories) {
                System.out.println(c.getCategoryId() + ". " + c.getName());
            }

            int categoryId = sc.nextInt();
            Category category = em.find(Category.class, categoryId);
            if (category == null) {
                System.out.println("❌ Invalid category ID.");
                return;
            }

            // Create book
            Book book = new Book(title, price, author, category);

            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();

            System.out.println("✅ Book added successfully.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Error adding book: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // List all books with details
    public static void listBooks() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            List<Book> books = em.createQuery("FROM Book", Book.class).getResultList();

            if (books.isEmpty()) {
                System.out.println("⚠️ No books found.");
                return;
            }

            System.out.println("\n📖 Book List:");
            for (Book b : books) {
                System.out.printf("ID: %d | %s | ₹%.2f | Author: %s | Category: %s%n",
                        b.getBookId(),
                        b.getTitle(),
                        b.getPrice(),
                        b.getAuthor().getName(),
                        b.getCategory().getName());
            }
        } catch (Exception e) {
            System.err.println("❌ Error listing books: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
