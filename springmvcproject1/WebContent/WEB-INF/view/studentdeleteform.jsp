<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete  student form</title>
</head>
<body>
<form action="http://localhost:8080/springmvcproject1/students/deleteStudent/" method="get">
Id<input type="text" name="id">
<input type="submit" value="Delete student">
</form>

</body>
</html>