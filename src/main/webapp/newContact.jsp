<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
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
		<div class="row justify-content-md-center">
			<div class="col-md-6">
				<c:if test="${contact != null }">
					<h1 class="mx-auto text-center my-3">Edit Contact</h1>
					<form action="contact?action=update" method="post">
				</c:if>
				<c:if test="${contact == null }">
					<h1 class="mx-auto text-center my-3">Add New Contact</h1>
					<form action="contact?action=insert" method="post">
				</c:if>
					<c:if test="${contact != null }">
						<div class="form-group">
							<input type="hidden" class="form-control" name="id" value="${contact.id}">
						</div>
					</c:if>
						<div class="form-group">
							<label>First Name</label>
							<input type="text" class="form-control" name="firstName" value="${contact.firstName}">
						</div>
						<div class="form-group">
							<label>Last Name</label>
							<input type="text" class="form-control" name="lastName" value="${contact.lastName}">
						</div>
						<div class="form-group">
							<label>Birth date</label>
							<input type="date" class="form-control" name="birthDate" value="${contact.birthdate}">
						</div>
						<div class="form-group">
						<label>Sex</label>
						<select class="form-control" name="sex">
							<option <c:if test="${contact.sex == true}"> selected</c:if>>Male</option>
							<option <c:if test="${contact.sex == false}"> selected</c:if>>Female</option>
						</select>
					</div>
						<div class="form-group">
							<label>Phone Number</label>
							<input type="text" class="form-control" name="phoneNumber" value="${contact.phoneNumber}">
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Description</label>
							<textarea class="form-control" rows="3" name="description"><c:out value="${contact.description}" /></textarea>
						</div>
						
						<div class="text-center">
							<button type="submit" class="btn btn-primary"><c:out value="${contact != null ? 'Edit Contact' : 'Add Contact'}" /></button>
						</div>
					</form>
			</div>
		</div>
	</div>
</body>
</html>