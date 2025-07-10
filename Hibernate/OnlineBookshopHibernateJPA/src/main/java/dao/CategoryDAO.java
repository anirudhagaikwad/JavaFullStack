package dao;

import entity.Category;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import app.JPAUtil;

public class CategoryDAO {

    // Add a new book category
    public static void addCategory(Scanner sc) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            sc.nextLine(); // clear buffer
            System.out.print("Enter Category Name: ");
            String name = sc.nextLine();

            Category category = new Category(name);

            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();

            System.out.println("✅ Category added successfully.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Error adding category: " + e.getMessage());
        } finally {
            em.close(); // always close EM
        }
    }

    // List all categories
    public static void listCategories() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            List<Category> list = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();

            if (list.isEmpty()) {
                System.out.println("⚠️ No categories found.");
                return;
            }

            System.out.println("\n📂 Book Categories:");
            for (Category c : list) {
                System.out.println(c.getCategoryId() + ". " + c.getName());
            }
        } catch (Exception e) {
            System.err.println("❌ Error listing categories: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
