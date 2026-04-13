import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AHDatabaseWrite {
    public static void main(String[] args) {
        // 1. Same Student object as your file example
        int id = 1;
        String name = "Mohit Kumar";

        // 2. Database credentials (use your actual MySQL password)
        String url = "jdbc:mysql://localhost:3306/project_db";
        String user = "root";
        String pass = "your_password";

        // 3. The "SQL" way to write data
        String query = "INSERT INTO students (id, name) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the values into the '?' placeholders
            pstmt.setInt(1, id);
            pstmt.setString(2, name);

            // Execute the write
            pstmt.executeUpdate();

            System.out.println("Data saved to MySQL successfully!");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}