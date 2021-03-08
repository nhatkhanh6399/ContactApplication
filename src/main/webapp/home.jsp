<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Management</title>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light bg-dark justify-content-between">
	  	<a class="navbar-brand text-light" href="contact">Home</a>
	  	<form class="form-inline">
		    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	  	</form>
	</nav>
	<div class="container-fluid">
		<h1 class="mx-auto text-center my-3">Contact Management</h1>
		
		<a class="btn btn-success mb-3 mr-0 float-right" href="contact?action=new">Add contact</a>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
				<th>Sex</th>
				<th>Phone number</th>
				<th>About</th>
				<th>Action</th>
			<tr>
			
			<c:forEach var="i" items="${listContact}">
				<tr>
					<td>${i.id}</td>
					<td>${i.firstName}</td>
					<td>${i.lastName}</td>
					<td>${i.birthdate}</td>
					<td><c:out value="${i.sex == true ? 'Male' : 'Female'}" /></td>
					<td>${i.phoneNumber}</td>
					<td>${i.description}</td>
					<td>
						<a class="" href="contact?action=getInfo&id=<c:out value="${i.id}" />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="" href="contact?action=delete&id=<c:out value="${i.id}" />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>