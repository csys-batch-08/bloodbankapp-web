<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="bloodbank" content="bloodbank web app">

<title>Home</title>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css" href="assets/css/Main.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
</head>
<body>
	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.RequestDeleted!=null}">
		<script type="text/javascript"> showMessage('RequestDeleted')</script>
	</c:if>

	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="donorIndex.jsp">Donor</a></li>
			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="adminLogin.jsp">Admin</a></li>
		</ul>
	</nav>
	<div class="homeContent">
		<img src="assets/images/002.jpg" class="img-fluid" alt="img">
	</div>





</body>
</html>