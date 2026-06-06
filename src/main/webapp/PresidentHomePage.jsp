<%@page import="com.dto.PresidentViewComplaintsResponseDTO"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.dto.ViewComplaintsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PresidentHomePage</title>

<style>
body{
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(135deg,#0f172a,#1e293b);
    margin: 0;
    padding: 30px;
    color: white;
}

h1{
    text-align:center;
    margin-bottom:30px;
    color:#38bdf8;
    letter-spacing:2px;
}

table{
    width:100%;
    border-collapse:collapse;
    background:rgba(255,255,255,0.08);
    backdrop-filter: blur(10px);
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 8px 32px rgba(0,0,0,0.3);
}

th{
    background:#0284c7;
    color:white;
    padding:15px;
    font-size:15px;
    text-transform:uppercase;
    letter-spacing:1px;
}

td{
    padding:15px;
    border-bottom:1px solid rgba(255,255,255,0.1);
}

tr:nth-child(even){
    background:rgba(255,255,255,0.03);
}

tr:hover{
    background:rgba(56,189,248,0.15);
    transition:0.3s;
}

select{
    background:#1e293b;
    color:white;
    border:1px solid #38bdf8;
    border-radius:8px;
    padding:8px;
    width:130px;
}

input[type="submit"]{
    background:linear-gradient(45deg,#06b6d4,#3b82f6);
    color:white;
    border:none;
    padding:8px 16px;
    border-radius:8px;
    cursor:pointer;
    font-weight:bold;
    margin-left:5px;
}

input[type="submit"]:hover{
    transform:scale(1.05);
    transition:0.2s;
}

.status-solved{
    color:#22c55e;
    font-weight:bold;
}

.status-progress{
    color:#f59e0b;
    font-weight:bold;
}

.status-registered{
    color:#ef4444;
    font-weight:bold;
}

.dashboard-title{
    text-align:center;
    font-size:35px;
    font-weight:bold;
    margin-bottom:20px;
    color:#38bdf8;
    text-shadow:0 0 10px rgba(56,189,248,0.5);
}

</style>
</head>
<body>

<h1>
<div class="dashboard-title">
    President Complaint Dashboard
</div>
</h1>

<% List<PresidentViewComplaintsResponseDTO> complaints= (List<PresidentViewComplaintsResponseDTO>)request.getAttribute("allComplaints"); %>

<table border="1">
<tr>
<th>Id</th>
<th>Category</th>
<th>Subject</th>
<th>Description</th>
<th>Status</th>
<th>Date</th>
<th>Resident Name</th>
<th>Resident PhoneNumber</th>
<th>Resident HouseNumber</th>
</tr>

<% 

DateTimeFormatter formater=DateTimeFormatter.ofPattern("yyyy-MM-dd");

for(int i=0; i<complaints.size(); i++){ %>
<tr>
<td><%= i+1 %></td>
<td><%= complaints.get(i).getCategory() %></td>
<td><%= complaints.get(i).getSubject() %></td>
<td><%= complaints.get(i).getDescription() %></td>


    <td>
        <form action="updateComplaintStatus" method="post">
		
		<input name="complaintId" type="hidden" value="<%= complaints.get(i).getComplaintId() %>">
		
			<% if( !"solved".equalsIgnoreCase(complaints.get(i).getStatus())) { %>
           
            <select name="status">

    			<option value=""><%= complaints.get(i).getStatus()%></option>
    			<option class="status-progress" value="In_PROGRESS">In Progress</option>
    			<option value="Solved">Solved</option>

            </select>

            <input type="submit" value="Update">
            
            <% } else {
           %>
           <input type="text"  class="status-solved" value="<%= complaints.get(i).getStatus() %>" readonly="readonly">
				<%} %>
        </form>
    </td>

<td><%= complaints.get(i).getCreatedAt().format(formater) %></td>
<td><%= complaints.get(i).getResidencePersonalDetailsDTO().getName() %></td>
<td><%= complaints.get(i).getResidencePersonalDetailsDTO().getPhoneNumber() %></td>
<td><%= complaints.get(i).getResidencePersonalDetailsDTO().getHouseNumber() %></td>
</tr>
<% } %>
</table>

</body>
</html>