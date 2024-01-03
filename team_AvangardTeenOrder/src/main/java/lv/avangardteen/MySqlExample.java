package lv.avangardteen;

import java.sql.*;

public class MySqlExample{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/avangard_teen_order";
        String user = "root";
        String password = "fkmdbyjdbx383";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM category");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("title"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
