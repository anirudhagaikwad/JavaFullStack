package app;
import java.util.Scanner;
import dao.*;
import report.ReportDAO;
/*
Postgresql Database Menu driven Console Application using Core java and JDBC for Online Bookshop
-- For a basic online bookshop, we’ll need the following tables:

-- Users: Stores customer information (e.g., for login and orders).
-- Books: Stores book details (title, author, price, etc.).
-- Authors: Stores author information (to normalize the data and avoid redundancy).
-- Orders: Tracks customer orders.
-- Order_Items: Links orders to specific books (since an order can contain multiple books).
-- Categories: Stores book categories (e.g., Fiction, Non-Fiction).

-- Relationships:
-- Users to Orders: One-to-Many (One user can place many orders).
-- Books to Authors: Many-to-One (A book has one author, but an author can write many books). (Note: For simplicity, I’ll assume one author per book; in a real system, you might need a many-to-many relationship with a junction table.)
-- Books to Categories: Many-to-One (A book belongs to one category, but a category can have many books).
-- Orders to Order_Items: One-to-Many (One order can have multiple items).
-- Books to Order_Items: Many-to-One (A book can appear in many order items).
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Online Bookshop ===");
            System.out.println("1. Register User");
            System.out.println("2. Add Author");
            System.out.println("3. List Authors");
            System.out.println("4. Add Category");
            System.out.println("5. List Categories");
            System.out.println("6. Add Book");
            System.out.println("7. List Books");
            System.out.println("8. Place Order");
            System.out.println("9. Exit");
            System.out.println("10. Report: Sales by Category");
            System.out.println("11. Report: Best-Selling Books");

            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> UserDAO.registerUser(sc);
                case 2 -> AuthorDAO.addAuthor(sc);
                case 3 -> AuthorDAO.listAuthors();
                case 4 -> CategoryDAO.addCategory(sc);
                case 5 -> CategoryDAO.listCategories();
                case 6 -> BookDAO.addBook(sc);
                case 7 -> BookDAO.listBooks();
                case 8 -> OrderDAO.placeOrder(sc);
                case 9 -> System.out.println("Exiting...");
                case 10 -> ReportDAO.salesByCategory();
                case 11 -> ReportDAO.bestSellingBooks();

                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 9 && choice != 0);  // or only (choice != 9) if Exit is at 9

        sc.close();
    }
}