<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BookingDAOlmpl"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Booking</title>
<style type="text/css">
body {
	height: 100vh;
	margin: 0px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.adminCard {
	padding: 25px;
	background: linear-gradient(40deg, #e90a0a 41%, white 9%);
	box-shadow: 0px 0px 6px 0px black;
	color: white;
	margin: 50px;
	width: 100%;
}

th, td {
	padding: 15px;
}

table, th, td {
	border: 1px solid #e1e1e1;
	border-collapse: collapse;
	color: black !important;
	color: navy;
	font-size: 16px;
	font-weight: bold;
	word-break: break-word;
	padding: 5px 0px;
}

table, th {
	background: #e90a0a;
	color: white !important;
	font-size: 15px;
	font-weight: bold;
}

.adminCard table {
	width: 100%;
	background: white;
	color: black;
	text-align: center;
	height: 460px;
	display: block;
	overflow: auto;
}

tbody {
	width: 100%;
	display: table;
}

.backBtn a {
	text-decoration: none;
	color: white;
	margin-right: 14px;
	background: black;
	padding: 5px 10px;
	border-radius: 3px
}

.backBtn {
	float: right;
	margin-top: 10px;
	font-size: 19px;
	padding: 5px 20px;
}
</style>
</head>
<body>

	<div class="adminCard">
		<table class="center">

			<tr>
				<th><strong>AADHARCARD</strong></th>
				<th><strong>ADDRESS</strong></th>
				<th><strong>BOOK DATE</strong></th>
				<th><strong>BLOOD TYPE</strong></th>
				<th><strong>BLOOD COLLECT CHOICE</strong></th>

			</tr>
			<c:forEach items="${requestScope.bookingList }" var="List">
			<tr>
			 <td>${List.donor.aadharcard }</td>
               <td>${List.address }</td>
               <td>${List.appdate }</td>
               <td>${List.bloodType }</td>
               <td>${List.bloodCollectChoice }</td>
			
			
			</tr>
</c:forEach>
			
		</table>
		<br>
		<br>

		<div class="backBtn">
			<a href="bloodBookingProcess.jsp">back</a>
		</div>

		</form>
	</div>
	</div>
</body>
</html>