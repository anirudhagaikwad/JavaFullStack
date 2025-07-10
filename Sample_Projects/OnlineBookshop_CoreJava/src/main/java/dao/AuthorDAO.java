package dao;
import java.sql.*;
import java.util.Scanner;
import app.DBConnection;

public class AuthorDAO {
    public static void addAuthor(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            sc.nextLine();
            System.out.print("Enter author name: ");
            String name = sc.nextLine();
            String sql = "INSERT INTO Authors(name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("Author added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listAuthors() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Authors";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("author_id") + ": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}