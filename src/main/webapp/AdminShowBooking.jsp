<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@page import="com.bloodbank.DaoImpl.BookingDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminShowBooking</title>
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

			<%
			BookingDAOlmpl Dao = new BookingDAOlmpl();

			List<BookingModel> bookingList = Dao.ShowBookingAdmin();

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
			<a href="AdminShowBookingHome.jsp">Home collection</a> 
			<a href="AdminWork.jsp">back</a>
		</div>
	</div>
</body>
</html>




