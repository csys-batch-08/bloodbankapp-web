<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BookingDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminShowBookingHome</title>
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

.adminImage {
	width: 75%;
}

table, th, td {
	border: 1px solid #e1e1e1;
	border-collapse: collapse;
	color: black !important;
	color: navy;
	font-size: 16px;
	font-weight: bold;
	/* box-shadow: 0px 0px 8px 0px #ffffff; */
	padding: 10px !important;
}

table, th {
	background: #e90a0a;
	color: white !important;
	font-size: 16px;
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
	display: table;
	width: 100%;
}

.content {
	width: 25%;
	box-shadow: -3px 3px 8px 0px #d9d9d9;
	border-radius: 4px;
}

.adminImage {
	width: 75%;
}

.content label {
	width: 100%;
	display: block;
	color: black;
	font-size: 33px;
	margin: 25px 0px;
	color: red;
	font-weight: bold;
}

.content input {
	border: none;
	background: #787878;
	color: white;
	font-weight: bold;
	padding: 11px 20px;
	width: 45%;
	margin-bottom: 13px;
	border-radius: 3px;
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

			<%
			BookingDAOlmpl Dao = new BookingDAOlmpl();

			List<BookingModel> bookingList = Dao.HomeCollection();

			for (int i = 0; i < bookingList.size(); i++) {

				BookingModel booking = bookingList.get(i);
			%>
			<tr>
				<td><%=booking.getDonor().getAadharcard()%></td>
				<td><%=booking.getAddress()%></td>
				<td><%=booking.getAppdate()%></td>
				<td><%=booking.getBloodType()%></td>
				<td><%=booking.getBloodCollectChoice()%></td>

			</tr>
			<%
			}
			%>
		</table>
		<div class="backBtn">
			<a href="AdminWork.jsp">back</a>
		</div>
	</div>
</body>
</html>