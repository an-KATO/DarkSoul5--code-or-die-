<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container" style="width: 30%;">
	<h1 style="text-align: center;">Login</h1>
	<h6 style="color: red;">
		<% 
			if(request.getAttribute("error")!=null)
				out.print(request.getAttribute("error").toString()); 
		%>
	</h6>
	<form action="login" method="post">
		<div class="mb-3 mt-3">
			<label for="email" class="form-label">Email:</label> <input
				type="email" class="form-control" id="email"
				placeholder="Enter email" name="email">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password:</label> <input
				type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="password">
		</div>
		
		<button type="submit" class="btn btn-primary" >Login</button>
	</form>
	</div>
</body>
</html>