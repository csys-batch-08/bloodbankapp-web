<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BillingDAOlmpl"%>
<%@page import="com.bloodbank.model.BillingModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show Billing Admin</title>
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

.flexbox {
	display: flex;
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
	background: black;
	padding: 5px 10px;
	border-radius: 3px
}

.backBtn {
	float: right;
	margin-top: 10px;
	font-size: 19px;
	padding: 5px 0px;
}
</style>
</head>
<body>

	<div class="adminCard">
		<div class="flexbox">
			<div class="adminImage">
				<table style="text-align: center;" class="center">
					<tr>
						<th><strong>BLOODTYPE</strong></th>
						<th><strong>SEEKER NAME</strong></th>
						<th><strong>SEEKER PHONENUMBER</strong></th>
						<th><strong>QUANTITY</strong></th>
						<th><strong>PRICE</strong></th>
						<th><strong>Date</strong></th>
					</tr>
					
					
					
					<c:forEach items="${requestScope.billingList}" var="billingList">
					
					
				<tr>
					<td>${billingList.bloodType}</td>
					<td>${billingList.seeker.firstName}</td>
					<td>${billingList.seeker.phoneNumber}</td>
					<td>${billingList.unit}</td>
					<td>${billingList.totalprice}</td>
					<td>${billingList.billDate}</td>
					
					</tr>
					</c:forEach>
					
					
					
					
				
				</table>
			</div>
			<div class="content">
				<form action="ShowForBillingDateServlet" method="post"
					style="text-align: center;">

					<label for="date">Date</label> <input type="date" id="date"
						name="date" required="required"> <input type="submit"
						value="submit">




				</form>

			</div>
		</div>
		<div class="backBtn">
			<a href="AdminWork.jsp">back</a>
		</div>
	</div>

	<script type="text/javascript">
		today();
		function today() {
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0');
			var yyyy = today.getFullYear();
			var max = today.setMonth(today.getMonth() + 1);
			maxdate = today.getFullYear() + '-' + mm + '-' + dd;

			document.getElementById("date").setAttribute("max", maxdate);
			console.log(maxdate);

		}
	</script>

</body>



</html>