<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
<h2>Student</h2><br>
First name:${student.firstname}<br>
Last name:${student.lastname}<br>
Email:${student.email}<br>
Points:${student.points}<br>
</body>
</html>