<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update teacher form</title>
</head>
<body>
<form action="http://localhost:8080/springmvcproject1/teachers/updateTeacher/" method="get">
Id<input type="text" name=id>
First name<input type="text" name="firstname"><br>
Last name<input type="text" name="lastname"><br>
Email<input type="text" name="email"><br>
Course<input type="text" name="course">

<input type="submit" value="Update student"><br>
</form>
</body>
</html>