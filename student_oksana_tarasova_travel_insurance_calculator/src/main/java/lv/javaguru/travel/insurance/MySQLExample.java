package lv.javaguru.travel.insurance;
import java.sql.*;
public class MySQLExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java-real-practice-insurance";
        String user = "root";
        String password = "fkmdbyjdbx383";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classifier_values");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("ic"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
