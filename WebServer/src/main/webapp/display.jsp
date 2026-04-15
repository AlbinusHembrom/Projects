<%@ page import="java.util.*" %>
<html>
<body>
<h2>Student Records from MySQL</h2>
<table border="1" cellpadding="10">
    <tr>
        <th>Roll No</th>
        <th>Full Name</th>
        <th>Subject</th>
        <th>Marks</th>
    </tr>
    <%
        List<Map<String, String>> students = (List<Map<String, String>>) request.getAttribute("students");
        if (students != null) {
            for (Map<String, String> s : students) {
    %>
    <tr>
        <td><%= s.get("id") %></td>
        <td><%= s.get("name") %></td>
        <td><%= s.get("subject")%></td>
        <td><%= s.get("marks") %></td>
    </tr>
    <%
            }
        }
    %>
</table>
<br>
<a href="index.jsp">Add Another Student</a>
</body>
</html>