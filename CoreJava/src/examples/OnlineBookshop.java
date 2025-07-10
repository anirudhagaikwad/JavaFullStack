import java.sql.*;
import java.util.Scanner;
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
public class OnlineBookshop {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/bookshop";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123"; // Replace with your PostgreSQL password
    private static Connection conn;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            createTables(); // Initialize database tables
            showMenu();
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Create necessary tables
    private static void createTables() throws SQLException {
        String[] sqlStatements = {
            "CREATE TABLE IF NOT EXISTS Categories (" +
            "category_id SERIAL PRIMARY KEY, " +
            "category_name VARCHAR(100) NOT NULL)",

            "CREATE TABLE IF NOT EXISTS Authors (" +
            "author_id SERIAL PRIMARY KEY, " +
            "author_name VARCHAR(100) NOT NULL)",

            "CREATE TABLE IF NOT EXISTS Users (" +
            "user_id SERIAL PRIMARY KEY, " +
            "username VARCHAR(50) UNIQUE NOT NULL, " +
            "email VARCHAR(100) NOT NULL, " +
            "password VARCHAR(100) NOT NULL)",

            "CREATE TABLE IF NOT EXISTS Books (" +
            "book_id SERIAL PRIMARY KEY, " +
            "title VARCHAR(200) NOT NULL, " +
            "author_id INT REFERENCES Authors(author_id), " +
            "category_id INT REFERENCES Categories(category_id), " +
            "price DECIMAL(10,2) NOT NULL, " +
            "stock_quantity INT NOT NULL)",

            "CREATE TABLE IF NOT EXISTS Orders (" +
            "order_id SERIAL PRIMARY KEY, " +
            "user_id INT REFERENCES Users(user_id), " +
            "order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            "total_amount DECIMAL(10,2) NOT NULL)",

            "CREATE TABLE IF NOT EXISTS Order_Items (" +
            "order_item_id SERIAL PRIMARY KEY, " +
            "order_id INT REFERENCES Orders(order_id), " +
            "book_id INT REFERENCES Books(book_id), " +
            "quantity INT NOT NULL, " +
            "unit_price DECIMAL(10,2) NOT NULL)"
        };

        Statement stmt = conn.createStatement();
        for (String sql : sqlStatements) {
            stmt.execute(sql);
        }
        stmt.close();
    }

    // Display main menu
    private static void showMenu() throws SQLException {
        while (true) {
            System.out.println("\n=== Online Bookshop Management System ===");
            System.out.println("1. Add User");
            System.out.println("2. Add Author");
            System.out.println("3. Add Category");
            System.out.println("4. Add Book");
            System.out.println("5. Place Order");
            System.out.println("6. View All Books");
            System.out.println("7. View User Orders");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addUser(); break;
                case 2: addAuthor(); break;
                case 3: addCategory(); break;
                case 4: addBook(); break;
                case 5: placeOrder(); break;
                case 6: viewAllBooks(); break;
                case 7: viewUserOrders(); break;
                case 8: return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    // Add a new user
    private static void addUser() throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String sql = "INSERT INTO Users (username, email, password) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, email);
        pstmt.setString(3, password);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("User added successfully!");
    }

    // Add a new author
    private static void addAuthor() throws SQLException {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();

        String sql = "INSERT INTO Authors (author_name) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, authorName);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Author added successfully!");
    }

    // Add a new category
    private static void addCategory() throws SQLException {
        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine();

        String sql = "INSERT INTO Categories (category_name) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, categoryName);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Category added successfully!");
    }

    // Add a new book
    private static void addBook() throws SQLException {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author ID: ");
        int authorId = scanner.nextInt();
        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "INSERT INTO Books (title, author_id, category_id, price, stock_quantity) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setInt(2, authorId);
        pstmt.setInt(3, categoryId);
        pstmt.setDouble(4, price);
        pstmt.setInt(5, stockQuantity);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Book added successfully!");
    }

    // Place a new order
    private static void placeOrder() throws SQLException {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create new order
        String orderSql = "INSERT INTO Orders (user_id, total_amount) VALUES (?, 0.0) RETURNING order_id";
        PreparedStatement orderStmt = conn.prepareStatement(orderSql);
        orderStmt.setInt(1, userId);
        ResultSet rs = orderStmt.executeQuery();
        rs.next();
        int orderId = rs.getInt("order_id");
        orderStmt.close();

        double totalAmount = 0.0;
        while (true) {
            System.out.print("Enter book ID (0 to finish): ");
            int bookId = scanner.nextInt();
            if (bookId == 0) break;
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            // Get book price
            String bookSql = "SELECT price, stock_quantity FROM Books WHERE book_id = ?";
            PreparedStatement bookStmt = conn.prepareStatement(bookSql);
            bookStmt.setInt(1, bookId);
            ResultSet bookRs = bookStmt.executeQuery();
            if (bookRs.next()) {
                double unitPrice = bookRs.getDouble("price");
                int stock = bookRs.getInt("stock_quantity");
                if (stock >= quantity) {
                    // Add order item
                    String itemSql = "INSERT INTO Order_Items (order_id, book_id, quantity, unit_price) VALUES (?, ?, ?, ?)";
                    PreparedStatement itemStmt = conn.prepareStatement(itemSql);
                    itemStmt.setInt(1, orderId);
                    itemStmt.setInt(2, bookId);
                    itemStmt.setInt(3, quantity);
                    itemStmt.setDouble(4, unitPrice);
                    itemStmt.executeUpdate();
                    itemStmt.close();

                    totalAmount += unitPrice * quantity;

                    // Update stock
                    String updateStockSql = "UPDATE Books SET stock_quantity = stock_quantity - ? WHERE book_id = ?";
                    PreparedStatement stockStmt = conn.prepareStatement(updateStockSql);
                    stockStmt.setInt(1, quantity);
                    stockStmt.setInt(2, bookId);
                    stockStmt.executeUpdate();
                    stockStmt.close();
                } else {
                    System.out.println("Insufficient stock for book ID " + bookId);
                }
            }
            bookStmt.close();
        }

        // Update order total
        String updateOrderSql = "UPDATE Orders SET total_amount = ? WHERE order_id = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateOrderSql);
        updateStmt.setDouble(1, totalAmount);
        updateStmt.setInt(2, orderId);
        updateStmt.executeUpdate();
        updateStmt.close();
        System.out.println("Order placed successfully! Total: $" + totalAmount);
    }

    // View all books
    private static void viewAllBooks() throws SQLException {
        String sql = "SELECT b.book_id, b.title, a.author_name, c.category_name, b.price, b.stock_quantity " +
                     "FROM Books b " +
                     "JOIN Authors a ON b.author_id = a.author_id " +
                     "JOIN Categories c ON b.category_id = c.category_id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n=== All Books ===");
        while (rs.next()) {
            System.out.printf("ID: %d, Title: %s, Author: %s, Category: %s, Price: $%.2f, Stock: %d%n",
                rs.getInt("book_id"),
                rs.getString("title"),
                rs.getString("author_name"),
                rs.getString("category_name"),
                rs.getDouble("price"),
                rs.getInt("stock_quantity"));
        }
        stmt.close();
    }

    // View user orders
    private static void viewUserOrders() throws SQLException {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "SELECT o.order_id, o.order_date, o.total_amount, b.title, oi.quantity, oi.unit_price " +
                     "FROM Orders o " +
                     "JOIN Order_Items oi ON o.order_id = oi.order_id " +
                     "JOIN Books b ON oi.book_id = b.book_id " +
                     "WHERE o.user_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("\n=== User Orders ===");
        while (rs.next()) {
            System.out.printf("Order ID: %d, Date: %s, Total: $%.2f, Book: %s, Quantity: %d, Unit Price: $%.2f%n",
                rs.getInt("order_id"),
                rs.getTimestamp("order_date"),
                rs.getDouble("total_amount"),
                rs.getString("title"),
                rs.getInt("quantity"),
                rs.getDouble("unit_price"));
        }
        pstmt.close();
    }
}