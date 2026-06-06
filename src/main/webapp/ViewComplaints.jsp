<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.dto.ViewComplaintsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewAllComplaints</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    margin: 20px;
}

h1{
    text-align: center;
    color: #333;
}

table{
    width: 100%;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0px 2px 10px rgba(0,0,0,0.1);
}

th{
    background-color: #2c3e50;
    color: white;
    padding: 12px;
    text-align: left;
}

td{
    padding: 10px;
    border-bottom: 1px solid #ddd;
}

tr:nth-child(even){
    background-color: #f8f9fa;
}

tr:hover{
    background-color: #e8f4ff;
}

button{
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #3498db;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 14px;
}

button:hover{
    background-color: #2980b9;
}

.container{
    width: 95%;
    margin: auto;
}

</style>

</head>
<body>

<% List<ViewComplaintsDTO> complaints= (List<ViewComplaintsDTO>)request.getAttribute("complaints"); %>

<table>
<tr>
<th>Id</th>
<th>Category</th>
<th>Subject</th>
<th>Description</th>
<th>Status</th>
<th>Date</th>
</tr>

<% 

DateTimeFormatter formater=DateTimeFormatter.ofPattern("yyyy-MM-dd");

for(int i=0; i<complaints.size(); i++){ %>
<tr>
<td><%= i+1 %></td>
<td><%= complaints.get(i).getCategory() %></td>
<td><%= complaints.get(i).getSubject() %></td>
<td><%= complaints.get(i).getDescription() %></td>
<td><%= complaints.get(i).getStatus() %></td>
<td><%= complaints.get(i).getCreatedAt().format(formater) %></td>
</tr>
<% } %>
</table>

<button onclick="history.back()">Goback</button>

</body>
</html>