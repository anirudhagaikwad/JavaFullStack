package dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import app.JPAUtil;

public class ReportDAO {

    // Report 1: Sales by Category
    public static void salesByCategory() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            System.out.println("\n📊 Sales by Category:");
            String jpql = """
                SELECT c.name, SUM(oi.quantity * b.price)
                FROM OrderItem oi
                JOIN oi.book b
                JOIN b.category c
                GROUP BY c.name
                ORDER BY SUM(oi.quantity * b.price) DESC
            """;

            List<Object[]> result = em.createQuery(jpql, Object[].class).getResultList();
            if (result.isEmpty()) {
                System.out.println("⚠️ No sales data available.");
                return;
            }

            System.out.printf("%-20s | %-10s%n", "Category", "Total Sales");
            System.out.println("----------------------+------------");
            for (Object[] row : result) {
                System.out.printf("%-20s | ₹%.2f%n", row[0], row[1]);
            }

        } catch (Exception e) {
            System.err.println("❌ Error generating sales report: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Report 2: Best-Selling Books
    public static void bestSellingBooks() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            System.out.println("\n📈 Best-Selling Books:");
            String jpql = """
                SELECT b.title, SUM(oi.quantity) as totalSold
                FROM OrderItem oi
                JOIN oi.book b
                GROUP BY b.title
                ORDER BY totalSold DESC
            """;

            List<Object[]> result = em.createQuery(jpql, Object[].class).getResultList();
            if (result.isEmpty()) {
                System.out.println("⚠️ No sales data available.");
                return;
            }

            System.out.printf("%-30s | %-10s%n", "Book Title", "Total Sold");
            System.out.println("--------------------------------+------------");
            for (Object[] row : result) {
                System.out.printf("%-30s | %d%n", row[0], row[1]);
            }

        } catch (Exception e) {
            System.err.println("❌ Error generating book report: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
