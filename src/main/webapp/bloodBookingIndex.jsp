<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking Process</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/bloodBookingPage.css">
</head>
<body>
	<nav class="header seakerindex" >
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="DonorLogoutServlet">Logout</a></li>
		</ul>
	</nav>
	<div class="problem">
		<nav>
			<div class="bookinner">
				<a class="BookingChange" href="ConfirmServlet">CONFIRM</a><br /> <br />
				<a class="BookingChange" href="BookingCancelServlet">BOOKING
					CANCEL</a>
			</div>
		</nav>
	</div>

</body>
</html>