<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Birth Date</th>
			<th>Sex</th>
			<th>Phone number</th>
			<th>About</th>
		<tr>
		
		<c:forEach var="i" items="${listContact}">
			<tr>
				<td>${i.id}</td>
				<td>${i.firstName}</td>
				<td>${i.lastName}</td>
				<td>${i.birthdate}</td>
				<td>${i.sex}</td>
				<td>${i.phoneNumber}</td>
				<td>${i.description}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>