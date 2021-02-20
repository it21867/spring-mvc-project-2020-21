<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student form</title>
</head>
<body>
<h2>Add new student</h2><br>
<form action="http://localhost:8080/springmvcproject1/students/saveStudent" method="post">
First name<input type="text" name="firstname"><br>
Last name<input type="text" name="lastname"><br>
Email<input type="text" name="email"><br>
Points<input type="number" name="points"><br>
<input type="submit" value="Add student"><br>
</form>

</body>
</html>