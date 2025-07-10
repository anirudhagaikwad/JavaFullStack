package dao;

import entity.User;
import jakarta.persistence.EntityManager;
import app.JPAUtil;

import java.util.Scanner;

public class UserDAO {

    // Register a new user
    public static void registerUser(Scanner sc) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            sc.nextLine(); // clear scanner buffer
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = new User(name, email, password);

            em.getTransaction().begin();
            em.persist(user); // persist user entity to database
            em.getTransaction().commit();

            System.out.println("✅ User registered successfully.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Error registering user: " + e.getMessage());
        } finally {
            em.close(); // Always close EM
        }
    }
}
