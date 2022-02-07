<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BloodDetailsDAOlmpl"%>
<%@page import="com.bloodbank.model.BloodDetailsModel"%>
<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ShowDonorBloodDetails</title>
<link rel="stylesheet" type="text/css" href="assets/css/tableformat.css">
</head>
<body>
	<div class="adminCard">
		<table class="center" aria-describedby="Donor blooddetails">
			<tr>
				<th><strong>AADHARCARD</strong></th>
				<th><strong>ADDRESS</strong></th>
				<th><strong>UNIT</strong></th>
				<th><strong>BLOOD TYPE</strong></th>
				<th><strong>CASH</strong></th>

			</tr>
			<c:forEach items="${requestScope.detailsList }" var="List">
				<tr>
					<td>${List.donor.aadharcard }</td>
					<td>${List.donor.address }</td>
					<td>${List.unit }</td>
					<td>${List.bloodType }</td>
					<td>${List.bloodPrice }</td>


				</tr>
			</c:forEach>



		</table>
		<div class="backBtn">
			<a href="DonorLogoutServlet">logout</a>

		</div>
	</div>
</body>
</html>