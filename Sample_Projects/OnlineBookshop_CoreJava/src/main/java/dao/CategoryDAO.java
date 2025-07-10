package dao;
import java.sql.*;
import java.util.Scanner;
import app.DBConnection;

public class CategoryDAO {
    public static void addCategory(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            sc.nextLine();
            System.out.print("Enter category name: ");
            String name = sc.nextLine();
            String sql = "INSERT INTO Categories(name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("Category added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listCategories() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Categories";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("category_id") + ": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}