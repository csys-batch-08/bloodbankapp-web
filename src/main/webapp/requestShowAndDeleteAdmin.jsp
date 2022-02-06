<%@page import="com.bloodbank.model.RequestModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.RequestDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Request Show And Delete</title>
<link rel="stylesheet" type="text/css" href="assets/css/tableformat.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
</head>
<body>
<script src="assets/javascript/popupMessage.js"></script>
<c:if test="${param.approvedRequest!=null}">
	<script type="text/javascript"> showMessage('approvedRequest')</script>
	</c:if>
	<div class="adminCard">
		<table class="center" >

			<tr>
				<th>HOSPITAL NAME</th>
				<th>BLOOD TYPE</th>
				<th>UNIT</th>
				<th>BLOOD COLLECTER NAME</th>
				<th>PHONE NUMBER</th>
				<th>AADHARCARD NUMBER</th>
				<th>DATE</th>
				<th>STATUS</th>
				<th>APPROVED</th>
				<th>REMOVE</th>
			</tr>

			<c:forEach items="${requestScope.requestList }" var="List">
				<tr>
					<td>${List.hospitalName}</td>
					<td>${List.bloodType}</td>
					<td>${List.unit}</td>
					<td>${List.bloodCollectorName}</td>
					<td>${List.phoneNumber}</td>
					<td>${List.aadharcard}</td>
					<td><fmt:parseDate value="${List.requestDate}"
							pattern="yyyy-MM-dd" var="requestDate" type="date" /> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${requestDate}" /></td>
					<td>${List.status}</td>


					<td class="rowlink"><a
						href="RequestUpdateAdminServlet?phoneNumber=${List.getPhoneNumber()}&bloodtype=${List.bloodType}">Approved        
					</a></td>
					<td class="rowlink"><a
						href="RequestDeleteAdminServlet?Aadharcard=${List.getAadharcard()}&bloodtype=${List.bloodType}">Remove</a></td>

				</tr>
			</c:forEach>

		</table>
		<div class="backBtn">
			<a href="AdminShowRequestServelt">Back </a>
		</div>
	</div>

</body>
</html>