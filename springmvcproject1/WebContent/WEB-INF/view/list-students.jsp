<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student list</title>
</head>
<body>
<div>
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Points</th>
</tr>
<c:forEach var="tempStudent" items="${students}">
<tr>
<td>${tempStudent.firstname}</td>
<td>${tempStudent.lastname}</td>
<td>${tempStudent.email}</td>
<td>${tempStudent.points}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>