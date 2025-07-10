package dao;

import entity.*;
import jakarta.persistence.EntityManager;
import app.JPAUtil;

import java.util.List;
import java.util.Scanner;

public class OrderDAO {

    // Place a new order
    public static void placeOrder(Scanner sc) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            List<User> users = em.createQuery("FROM User", User.class).getResultList();
            if (users.isEmpty()) {
                System.out.println("❌ No users found. Please register a user.");
                return;
            }

            System.out.println("Select User ID to place order:");
            for (User u : users) {
                System.out.println(u.getUserId() + ". " + u.getName());
            }

            int userId = sc.nextInt();
            User user = em.find(User.class, userId);
            if (user == null) {
                System.out.println("❌ Invalid user ID.");
                return;
            }

            Order order = new Order(user);

            while (true) {
                List<Book> books = em.createQuery("FROM Book", Book.class).getResultList();
                if (books.isEmpty()) {
                    System.out.println("❌ No books found.");
                    return;
                }

                System.out.println("Select Book ID (or 0 to finish):");
                for (Book b : books) {
                    System.out.printf("%d. %s (₹%.2f)%n", b.getBookId(), b.getTitle(), b.getPrice());
                }

                int bookId = sc.nextInt();
                if (bookId == 0) break;

                Book book = em.find(Book.class, bookId);
                if (book == null) {
                    System.out.println("❌ Invalid book ID.");
                    continue;
                }

                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();

                OrderItem item = new OrderItem(book, quantity);
                order.addItem(item);
            }

            if (order.getItems().isEmpty()) {
                System.out.println("⚠️ Order is empty. Cancelled.");
                return;
            }

            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();

            System.out.println("✅ Order placed successfully. Order ID: " + order.getOrderId());

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Error placing order: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // List all orders with items
    public static void listOrders() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            List<Order> orders = em.createQuery("FROM Order", Order.class).getResultList();

            if (orders.isEmpty()) {
                System.out.println("⚠️ No orders found.");
                return;
            }

            for (Order o : orders) {
                System.out.println("\n🧾 Order #" + o.getOrderId() + " | User: " + o.getUser().getName() + " | Date: " + o.getOrderDate());
                double total = 0;
                for (OrderItem item : o.getItems()) {
                    double subTotal = item.getTotalPrice();
                    System.out.printf(" - %s x %d = ₹%.2f%n",
                            item.getBook().getTitle(),
                            item.getQuantity(),
                            subTotal);
                    total += subTotal;
                }
                System.out.printf("Total: ₹%.2f%n", total);
            }

        } catch (Exception e) {
            System.err.println("❌ Error listing orders: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
