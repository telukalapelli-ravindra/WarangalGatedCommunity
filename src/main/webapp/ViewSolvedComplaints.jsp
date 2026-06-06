<%@page import="com.dto.ViewComplaintsDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<% List<ViewComplaintsDTO> complaints= (List<ViewComplaintsDTO>)request.getAttribute("solvedComplaints"); %>

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


</body>
</html>