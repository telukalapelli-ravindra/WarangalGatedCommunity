<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>President Registration Page</title>

<style type="text/css">

body {
	background-color: black;
	color:yellow;
	
	display: flex;
	align-items: center;
	justify-content: center;
	
	height: 100vh;
	margin: 0;
}

form{
	border: 2px solid white;
	padding: 60px;
	border-radius: 60px;
}

input {
	background-color: #222;
	 color: white;
	 
	
	margin-bottom: 10px;
	padding: 10px;
}

</style>

</head>
<body>

<form action="presidentRegistration" method="post">
<label>Enter Name: </label><br>
<input name="name" type="text"><br>

<label>Enter Age: </label><br>
<input name="age" type="number"><br>

<label>Enter EmailId: </label><br>
<input name="emailId" type="email"><br>

<label>Enter Password: </label><br>
<input name="password" type="password"><br>

<% String errorMessage=(String) request.getAttribute("errorMessage"); %>

<%if (errorMessage!=null) { %>
<span style="color: red"><%= errorMessage%> </span><br>
<% } %>

<label>Enter Secret Key</label><br>
<input name="secretKey" type="text"><br>

<input name="submit" type="submit" value="Register">

</form>

</body>
</html>