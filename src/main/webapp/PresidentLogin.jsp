<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PresidentLoginPage</title>
</head>
<body>
<form action="presidentLogin"></form>

<% String saved=(String) request.getAttribute("saved"); %>

<%if (saved!=null) { %>
<span style="color:yellow"><%=saved %></span><br>
<% } %>

<label id="email">Email: </label>
<input name="email" type="email" placeholder="Enter email ID"><br>
<label id="password">Password: </label>
<input name="password" type="password" placeholder="Enter passowrd"><br>
<input name="submit" type="submit" value="Login"><br>
<a href="ResidenceRegister.html" >New User</a><br>
<a href="login.html">Login as Residence</a>
</body>
</html>