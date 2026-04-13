import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/addStudent")
public class AHStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. Capture the data from the form
        String id = request.getParameter("studentId");
        String name = request.getParameter("studentName");
        String dbPass = request.getParameter("dbPass"); // <-- Catch the password here!

        String url = "jdbc:mysql://localhost:3306/project_db";
        String user = "root";

        jakarta.servlet.http.HttpSession session = request.getSession();
        session.setAttribute("savedPass", dbPass);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Use the variable 'dbPass' instead of a hardcoded string
            Connection conn = DriverManager.getConnection(url, user, dbPass);

            String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, name);

            pstmt.executeUpdate();
            conn.close();

            response.getWriter().println("<h1>Connection Successful!</h1>");
            response.getWriter().println("<p>Student " + name + " has been added to MySQL.</p>");

        } catch (Exception e) {
            // If the password was wrong, it will show the 'Access Denied' error here
            response.getWriter().println("<h1 style='color:red;'>Database Error</h1>");
            response.getWriter().println("<p>" + e.getMessage() + "</p>");
            e.printStackTrace();
        }
    }
}