package dao;
import java.sql.*;
import java.util.Scanner;
import app.DBConnection;

public class BookDAO {
    public static void addBook(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            sc.nextLine();
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            System.out.print("Enter author ID: ");
            int authorId = sc.nextInt();
            System.out.print("Enter category ID: ");
            int categoryId = sc.nextInt();
            String sql = "INSERT INTO Books(title, price, author_id, category_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, authorId);
            ps.setInt(4, categoryId);
            ps.executeUpdate();
            System.out.println("Book added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listBooks() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Books";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("book_id") + ": " + rs.getString("title") + " - ₹" + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}