<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Request index</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/requestIndex.css">


<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>



</head>
<body>
	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.loginStatus!=null}">
		<script type="text/javascript"> showMessage('loginSucess')</script>

	</c:if>
	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.noDate!=null}">
		<script type="text/javascript"> showMessage('noDate')</script>
	</c:if>
	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.pending!=null}">
		<script type="text/javascript"> showMessage('pending')</script>
	</c:if>

	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="donorIndex.jsp">Donor</a></li>
			<li><a href="SeekerLogoutServlet">Logout</a></li>

		</ul>
	</nav>
	<div class="problem">
		<nav>
			<div class="bookinner">
				<h1 class="text-center">REQUISITION</h1>
				<a href="requestSeeker.jsp">REQUEST</a> <a
					href="ShowRequestSeekerServlet">SHOW REQUEST</a>
			</div>
		</nav>


	</div>
</body>
</html>