<html>
<body>
<h2>Database Login & Student Entry</h2>
<form action="addStudent" method="post">
    MySQL Password: <input type="password" name="dbPass" required><br><hr>

    ID: <input type="number" name="studentId" required><br><br>
    Name: <input type="text" name="studentName" required><br><br>
    Subject: <input type="text" name="subject" required><br><br>
    Marks: <input type="number" name="marks" required><br><br>

    <input type="submit" value="Connect and Save">
</form>
<hr>
<h2>View Database Records</h2>
<form action="viewStudents" method="post">
    MySQL Password: <input type="password" name="dbPass" required>
    <input type="submit" value="View All Students">
</form>
</body>
</html>