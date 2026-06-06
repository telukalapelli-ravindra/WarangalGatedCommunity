<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResidenceHomePage</title>
</head>
<body>
<% Integer residenceId= (Integer)session.getAttribute("residenceId"); %>
<marquee><%= (String) session.getAttribute("residenceName") %></marquee>
<a href="raiseComplaint">raise a complaint</a> |
 <a href="viewUnSolvedComplaints"> view complaints</a>
 <a href="viewSolvedComplaints">solved complaints</a>
</body>
</html>