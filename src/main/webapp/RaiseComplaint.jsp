<%@page import="com.model.ResidencePersonalDetails"%>
<%@page import="com.dto.ResidencePersonalDetailsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RaiseComplaints</title>
</head>
<body>

<form action="registerComplaint" method="post">
<%  ResidencePersonalDetailsDTO  details= (ResidencePersonalDetailsDTO) request.getAttribute("residence"); %>

<input name="residenceId" type="text" value="<%=(int)details.getResidenceId()%> ">

<h1><%=details.getResidenceId() %> </h1>




<label>Name: </label>
<input name="name" type="text" value="<%=details.getName()%>" readonly="readonly"><br>

<label>HouseNumber: </label>
<input name="houseNumber" type="text" value="<%= details.getHouseNumber() %>" readonly="readonly"><br>

<label>PhoneNumber: </label>
<input name="phoneNumber" type="number" value="<%= details.getPhoneNumber() %>" readonly="readonly"><br>

<label>Category: </label>
<select name="category">
    <option value="">Select Category</option>
    <option value="Water">Water</option>
    <option value="Electricity">Electricity</option>
    <option value="Security">Security</option>
    <option value="Parking">Parking</option>
    <option value="Maintenance">Maintenance</option>
    <option value="Billing">Billing</option>
</select>

<label>Subject: </label>
<select name="subject">
<option value="water leakage">Water Leakage</option>
<option value="Power cut">Power cut</option>
</select>

<label>Description: </label>
<input name="description" type="text" >

<input name="submit" type="submit">

</form>


</body>
</html>