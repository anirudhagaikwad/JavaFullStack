package dao;

import entity.Author;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import app.JPAUtil;

public class AuthorDAO {

    // Adds a new author to the database
    public static void addAuthor(Scanner sc) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            sc.nextLine(); // clear buffer
            System.out.print("Enter Author Name: ");
            String name = sc.nextLine();

            Author author = new Author(name);

            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();

            System.out.println("✅ Author added successfully.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Error adding author: " + e.getMessage());
        } finally {
            em.close(); // Always close the EntityManager
        }
    }

    // Lists all authors in the database
    public static void listAuthors() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();

            if (authors.isEmpty()) {
                System.out.println("⚠️ No authors found.");
                return;
            }

            System.out.println("\n📚 List of Authors:");
            for (Author author : authors) {
                System.out.println(author.getAuthorId() + ". " + author.getName());
            }
        } catch (Exception e) {
            System.err.println("❌ Error listing authors: " + e.getMessage());
        } finally {
            em.close(); // Always close the EntityManager
        }
    }
}
