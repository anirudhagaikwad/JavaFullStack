package app;

import dao.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Online Bookshop Menu =====");
            System.out.println("1. Register User");
            System.out.println("2. Add Author");
            System.out.println("3. List Authors");
            System.out.println("4. Add Category");
            System.out.println("5. List Categories");
            System.out.println("6. Add Book");
            System.out.println("7. List Books");
            System.out.println("8. Place Order");
            System.out.println("9. List Orders");
            System.out.println("10. Report: Sales by Category");
            System.out.println("11. Report: Best-Selling Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            
            // Input check
            while (!sc.hasNextInt()) {
System.out.print("Invalid input. Enter number: ");
                sc.next();
            }

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
                case 9 -> OrderDAO.listOrders();
                case 10 -> ReportDAO.salesByCategory();
                case 11 -> ReportDAO.bestSellingBooks();
                case 0 -> System.out.println("👋 Exiting the application...");
                default -> System.out.println("⚠️ Invalid choice. Please try again.");
            }

        } while (choice != 0);

        // Close all factories
        app.JPAUtil.shutdown();


        sc.close();
    }
}
