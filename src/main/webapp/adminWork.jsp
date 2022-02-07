<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">
	<title><fmt:message key="AdminWork" /></title>
</fmt:bundle>
<link rel="stylesheet" type="text/css"
	href="assets/css/adminworkpagestyle.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.loginStatus!=null}">
		<script type="text/javascript">
			showMessage('loginSucess')
		</script>
	</c:if>
	<div class="adminCard">
		<div class="adminImage">
			<img src="assets/images/004.png" alt="img" width="" height="">
		</div>
		<div class="content">

			<h1 style="text-align: center;">Admin Work</h1>
			<a href="ShowStakServlet"> ShowStock</a> <a
				href="ShowBillingAdminServlet"> ShowBilling</a> <a
				href="AdminShowRequestServelt"> ShowRequest </a>

			<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">
				<a href="AdminShowBookingServlet"><fmt:message key="Booking" /></a>
			</fmt:bundle>
		</div>
		<div class="backBtn">
		<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">		
			<a href="index.jsp"><fmt:message key="Back" /></a>
			</fmt:bundle>
		</div>
	</div>

</body>
<script type="text/javascript">
	
</script>
</html>