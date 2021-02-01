<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher add form</title>
</head>
<body>
<h2>Add new teacher</h2><br>
<form action="http://localhost:8080/springmvcproject1/teachers/saveTeacher" method="POST">
First name<input type="text" name="firstname"><br>
Last name<input type="text" name="lastname"><br>
Email<input type="text" name="email"><br>
Course<input type="text" name="course"><br>
<input type="submit" value="Add teacher"><br>
</form>

</body>
</html>