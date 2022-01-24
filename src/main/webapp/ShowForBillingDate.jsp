<%@page import="java.time.LocalDate"%>

<%@page import="com.bloodbank.model.BillingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BillingDAOlmpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowForBillingDate</title>
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
		<table>
			<tr>
				<th><strong>BLOODTYPE</strong></th>
				<th><strong>SEEKER NAME</strong></th>
				<th><strong>SEEKER PHONENUMBER</strong></th>
				<th><strong>QUANTITY</strong></th>
				<th><strong>PRICE</strong></th>
				<th><strong>Date</strong></th>
			</tr>


			<%
			LocalDate date = (LocalDate) session.getAttribute("billingdate");

			BillingDAOlmpl billigDao = new BillingDAOlmpl();
			//System.out.println(date);
			List<BillingModel> billingList = billigDao.biilingShowAdminDate(date);
			for (int i = 0; i < billingList.size(); i++) {

				BillingModel model = billingList.get(i);
			%>
			<tr>
				<td><%=model.getBloodType()%></td>
				<td><%=model.getSeeker().getFirstName()%></td>
				<td><%=model.getSeeker().getPhoneNumber()%></td>
				<td><%=model.getUnit()%></td>
				<td><%=model.getTotalprice()%></td>
				<td><%=model.getBillDate()%></td>
				<%
				}
				%>



			</tr>
		</table>

		<div class="backBtn">
			<a href="ShowbillingAdmin.jsp">back</a>
		</div>
	</div>

</body>
</html>