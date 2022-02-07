<%@page import="java.time.LocalDate"%>

<%@page import="com.bloodbank.model.BillingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BillingDAOlmpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ShowForBillingDate</title>
<link rel="stylesheet" type="text/css" href="assets/css/tableformat.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
	<div class="adminCard">
		<table id="table_id" aria-describedby="bill">
			<thead>
				<tr>
					<th id=""><strong>BLOODTYPE</strong></th>
					<th id=""><strong>SEEKER NAME</strong></th>
					<th id=""><strong>SEEKER PHONENUMBER</strong></th>
					<th id=""><strong>QUANTITY</strong></th>
					<th id=""><strong>PRICE</strong></th>
					<th id=""><strong>Date</strong></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.billingList}" var="billingList">
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
			</tbody>
		</table>

		<div class="backBtn">
			<a href="ShowBillingAdminServlet">back</a>
		</div>
	</div>

</body>
</html>