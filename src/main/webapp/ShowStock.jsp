<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.model.BloodStack"%>
<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Stock</title>
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
	/* box-shadow: 0px 0px 8px 0px #ffffff; */
	padding: 14px;
}

table, th {
	background: #e90a0a;
	color: white !important;
	font-size: 20px;
	font-weight: bold;
}

.adminCard table {
	width: 100%;
	background: white;
	color: black;
	text-align: center
}

.backBtn a {
	text-decoration: none;
	color: white;
}

.backBtn {
	float: right;
	margin-top: 10px;
	font-size: 19px;
	background: black;
	padding: 5px 20px;
}
</style>
</head>
<body>
	<div class="adminCard">
		<table style="text-align: center;" class="center">
			<tr>
				<th><strong>Blood Type</strong></th>
				<th><strong>Quantity</strong></th>
				<th><strong>PRICE</strong></th>

			</tr>
			<%
			BloodStackDAOlmpl Dao = new BloodStackDAOlmpl();

			BloodStack stack = null;
			List<BloodStack> stockDetails = Dao.showStack();
			for (int i = 0; i < stockDetails.size(); i++) {
				stack = stockDetails.get(i);
			%>
			<tr>
				<td><%=stack.getBloodType()%></td>
				<td><%=stack.getQuantity()%></td>
				<td><%=stack.getPrice()%></td>
			</tr>
			<%
			}
			%>

		</table>

		<div class="backBtn">
			<a href="AdminWork.jsp">Back </a>
		</div>
	</div>
</body>
</html>