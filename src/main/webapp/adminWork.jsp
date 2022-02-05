<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AdminWork</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/adminworkpagestyle.css">
	
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
	<div class="adminCard">
		<div class="adminImage">
			<img src="assets/images/004.png" alt="img">
		</div>
		<div class="content">

			<h1 style="text-align: center;">Admin Work</h1>
			<a href="ShowStakServlet"> ShowStock</a> <a
				href="ShowBillingAdminServlet"> ShowBilling</a> <a
				href="AdminShowRequestServelt"> ShowRequest </a> <a
				href="AdminShowBookingServlet">Booking</a>
		</div>
		<div class="backBtn">
			<a href="index.jsp">Back</a>
		</div>
	</div>

</body>
<script type="text/javascript">



</script>
</html>