package dao;
import java.sql.*;
import java.util.Scanner;
import app.DBConnection;

public class OrderDAO {
    public static void placeOrder(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter user ID: ");
            int userId = sc.nextInt();
            String insertOrder = "INSERT INTO Orders(user_id) VALUES (?) RETURNING order_id";
            PreparedStatement ps = con.prepareStatement(insertOrder);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            int orderId = 0;
            if (rs.next()) orderId = rs.getInt("order_id");
            while (true) {
                BookDAO.listBooks();
                System.out.print("Enter book ID (0 to finish): ");
                int bookId = sc.nextInt();
                if (bookId == 0) break;
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                String insertItem = "INSERT INTO Order_Items(order_id, book_id, quantity) VALUES (?, ?, ?)";
                PreparedStatement psItem = con.prepareStatement(insertItem);
                psItem.setInt(1, orderId);
                psItem.setInt(2, bookId);
                psItem.setInt(3, qty);
                psItem.executeUpdate();
            }
            System.out.println("Order placed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}