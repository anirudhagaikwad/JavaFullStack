package report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.DBConnection;

public class ReportDAO {

    public static void salesByCategory() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT c.name AS category, SUM(oi.quantity * b.price) AS total_sales
                FROM Categories c
                JOIN Books b ON c.category_id = b.category_id
                JOIN Order_Items oi ON b.book_id = oi.book_id
                GROUP BY c.name
                ORDER BY total_sales DESC
            """;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("\\n%-20s | %-10s\\n", "Category", "Total Sales");
            System.out.println("---------------------+------------");
            while (rs.next()) {
                System.out.printf("%-20s | ₹%-10.2f\\n",
                    rs.getString("category"),
                    rs.getDouble("total_sales"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bestSellingBooks() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT b.title, a.name AS author, SUM(oi.quantity) AS total_sold
                FROM Books b
                JOIN Order_Items oi ON b.book_id = oi.book_id
                JOIN Authors a ON b.author_id = a.author_id
                GROUP BY b.title, a.name
                ORDER BY total_sold DESC
                LIMIT 5
            """;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("\\n%-30s | %-20s | %-10s\\n", "Book", "Author", "Total Sold");
            System.out.println("--------------------------------+----------------------+------------");
            while (rs.next()) {
                System.out.printf("%-30s | %-20s | %-10d\\n",
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("total_sold"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

