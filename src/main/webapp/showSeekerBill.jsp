<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BillingDAOlmpl"%>
<%@page import="com.bloodbank.model.BillingModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Seeker Bill</title>
<link rel="stylesheet" type="text/css" href="assets/css/tableformat.css">

</head>
<body>
	<div class="adminCard">
		<table aria-describedby="seeker report">

			<tr>
				<th><strong>BLOODTYPE</strong></th>
				<th><strong>SEEKER NAME</strong></th>
				<th><strong>SEEKER PHONENUMBER</strong></th>
				<th><strong>QUANTITY</strong></th>
				<th><strong>PRICE</strong></th>
				<th><strong>Date</strong></th>
			</tr>

			<c:forEach items="${requestScope.billingList }" var="billingList">
				<tr>
					<td>${billingList.bloodType}</td>
					<td>${billingList.seeker.firstName}</td>
					<td>${billingList.seeker.phoneNumber}</td>
					<td>${billingList.unit}</td>
					<td>${billingList.totalprice}</td>

					<td><fmt:parseDate value="${billingList.billDate}"
							pattern="yyyy-MM-dd" var="billDate" type="date" /> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${billDate}" /></td>


				</tr>
			</c:forEach>


		</table>

		<div class="backBtn">
			<a href="index.jsp">Back</a>

		</div>
	</div>
</body>
</html>