import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/viewStudents")
public class AHViewStudentsServlet extends HttpServlet {

    // 1. Handle POST: Triggered when you submit the "View All" form with the password
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String formPass = request.getParameter("dbPass");

        // Save the password in a Session so it lasts until the browser is closed
        HttpSession session = request.getSession();
        session.setAttribute("savedPass", formPass);

        // After saving, run the display logic (doGet)
        doGet(request, response);
    }

    // 2. Handle GET: Triggered when you click a link or after the doPost finishes
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String dbPass = (String) session.getAttribute("savedPass");

        // Safety Check: If no password is found in session, send them back to login
        if (dbPass == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        List<Map<String, String>> studentList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/project_db";
        String user = "root";

        try {
            // Load the MySQL Driver (Crucial for offline/E-drive setups)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, dbPass);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

                while (rs.next()) {
                    Map<String, String> student = new HashMap<>();
                    student.put("id", rs.getString("id"));
                    student.put("name", rs.getString("name"));
                    student.put("subject", rs.getString("subject"));
                    student.put("marks", rs.getString("marks"));
                    studentList.add(student);
                }
            }

            // Pass the list to display.jsp
            request.setAttribute("students", studentList);
            request.getRequestDispatcher("display.jsp").forward(request, response);

        } catch (ClassNotFoundException e) {
            response.getWriter().println("<h1>Driver Error:</h1><p>Check if Connector J is in WEB-INF/lib</p>");
        } catch (SQLException e) {
            // This will catch "Access Denied" if the password was wrong
            response.getWriter().println("<h1>Database Error:</h1><p>" + e.getMessage() + "</p>");
            response.getWriter().println("<a href='index.jsp'>Try again with correct password</a>");
        }
    }
}