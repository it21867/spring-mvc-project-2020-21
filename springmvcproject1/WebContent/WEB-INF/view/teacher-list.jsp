<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher list</title>
</head>
<body>
<div>
<table>
<tr>
<th>First name</th>
<th>Last Name</th>
<th>Email</th>
<th>Course</th>
</tr>
<c:forEach var="tempTeacher" items="${teachers}">
<td>${tempTeacher.firstname}</td>
<td>${tempTeacher.lastname}</td>
<td>${tempTeacher.email}</td>
<td>${tempTeacher.course}</td>
</c:forEach>
</table>
</div>

</body>
</html>