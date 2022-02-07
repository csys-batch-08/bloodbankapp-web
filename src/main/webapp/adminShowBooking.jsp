<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@page import="com.bloodbank.DaoImpl.BookingDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AdminShowBooking</title>
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
		<table id="table_id" aria-describedby="bookig table">
			<thead>
				<tr>
					<th id=""><strong>AADHARCARD</strong></th>
					<th id=""><strong>ADDRESS</strong></th>
					<th id=""><strong>BOOK DATE</strong></th>
					<th id=""><strong>BLOOD TYPE</strong></th>
					<th id=""><strong>BLOOD COLLECT CHOICE</strong></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.bookingList }" var="List">
					<tr>
						<td>${List.donor.aadharcard }</td>
						<td>${List.address }</td>
						<td><fmt:parseDate value="${List.appdate }"
								pattern="yyyy-MM-dd" var="appdate" type="date" /> <fmt:formatDate
								pattern="dd/MM/yyyy" value="${appdate}" /></td>
						<td>${List.bloodType }</td>
						<td>${List.bloodCollectChoice }</td>



					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div class="backBtn">
			<a href="adminWork.jsp">back</a>
		</div>
	</div>
</body>
</html>




