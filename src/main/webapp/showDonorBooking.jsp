<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BookingDAOlmpl"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Show Booking</title>
<link rel="stylesheet" type="text/css" href="assets/css/tableformat.css">
</head>
<body>
	<div class="adminCard">
		<table aria-describedby="blood booking">
			<thead>
				<tr>
					<th><strong>AADHARCARD</strong></th>
					<th><strong>ADDRESS</strong></th>
					<th><strong>BOOK DATE</strong></th>
					<th><strong>BLOOD TYPE</strong></th>
					<th><strong>BLOOD COLLECT CHOICE</strong></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.bookingList }" var="List">
					<tr>
						<td>${List.donor.aadharcard }</td>
						<td>${List.address }</td>
						<td><fmt:parseDate value="${List.appdate }"
								pattern="yyyy-MM-dd" var="appdate" type="date" /> <fmt:formatDate
								pattern="dd/MM/yyyy" value="${appdate}" /></td>
						<td>${List.bloodType }</td>
						<td>${List.bloodCollectChoice }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <br>

		<div class="backBtn">
			<a href="bloodBookingProcess.jsp">back</a>
		</div>


	</div>

</body>
</html>