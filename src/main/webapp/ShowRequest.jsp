
<%@page import="com.bloodbank.model.RequestModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.RequestDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
	padding: 10px;
}

table, th {
	background: #e90a0a;
	color: white !important;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 5px;
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
	margin: 10px;
}

.rowlink a {
	text-decoration: none;
	font-size: 15px;
	padding: 10px 0px;
}
</style>
</head>
<body>


	<div class="adminCard">
		<table class="center">

			<tr>
				<th>HOSPITAL NAME</th>
				<th>BLOOD TYPE</th>
				<th>UNIT</th>
				<th>BLOOD COLLECTER NAME</th>
				<th>PHONE NUMBER</th>
				<th>AADHARCARD NUMBER</th>
				<th>DATE</th>
				<th>STATUS</th>

			</tr>

			<%
			RequestDAOlmpl Dao = new RequestDAOlmpl();
			List<RequestModel> requestList = Dao.ShowRequest();

			RequestModel requestModel = null;
			for (int i = 0; i < requestList.size(); i++) {
				requestModel = requestList.get(i);
			%>
			<tr>
				<td><%=requestModel.getHospitalName()%></td>
				<td><%=requestModel.getBloodType()%></td>
				<td><%=requestModel.getUnit()%></td>
				<td><%=requestModel.getBloodCollectorName()%></td>
				<td><%=requestModel.getPhoneNumber()%></td>
				<td><%=requestModel.getAadharcard()%></td>
				<td><%=requestModel.getRequestDate()%></td>
				<td><%=requestModel.getStatus()%></td>

			</tr>

			<%
			}
			%>

		</table>
		<div class="backBtn">
			<a href="RequestShowAndDeleteAdmin.jsp">Request Pending </a>
		</div>
		<div class="backBtn">
			<a href="AdminWork.jsp">Back </a>
		</div>
	</div>


</body>
</html>
