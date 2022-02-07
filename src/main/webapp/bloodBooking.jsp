<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">
	<title><fmt:message key="Booking" /></title>
</fmt:bundle>
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css" href="assets/css/bookingPage.css">
</head>
<body>
	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">
				<li><a href="seekerIndex.jsp"><fmt:message key="Seeker" /></a></li>
				<li><a href="DonorLogoutServlet"><fmt:message key="Logout" /></a></li>
			</fmt:bundle>
		</ul>
	</nav>
	<div class="d-flex book align-items-center">
		<div class="col-sm-5"></div>
		<div class="bookinner col-sm-3" onMouseover="check()">

			<form action="BloodBookingServlet " method="post">
				<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">
					<h1>
						<fmt:message key="BOOKING" />
					</h1>
					<fmt:message key="BOOKING" />
				</fmt:bundle>
				<div>
					<div class="inputtype">
						<label for="bookingDate" class="d-none"></label><input type="date"
							id="bookingDate" name="bookingDate" required="required"
							placeholder="" />

					</div>
					<div class="inputtype">
						<label for="Choice" class="d-none"></label> <select name="Choice"
							id="Choice" required="required">
							<option disabled="disabled">Select any one</option>

							<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">
								<option value="center"><fmt:message key="center" /></option>
								<option value="home"><fmt:message key="Home" /></option>
							</fmt:bundle>
						</select>
						<div class="inputtype">
							<label for="address" class="d-none"></label>
							<textarea style="visibility: hidden;" id="address" name="address"
								maxlength="50" placeholder="Enter the Home Address"></textarea>
						</div>
					</div>
				</div>

				<div class="submit">
					<input type="submit" value="submit">
				</div>
			</form>
		</div>

	</div>
</body>

<script type="text/javascript">
	today();
	function today() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0');
		var yyyy = today.getFullYear();
		var max = today.setMonth(today.getMonth() + 1);
		maxdate = today.getFullYear() + '-' + 0 + (today.getMonth() + 1) + '-'
				+ 0 + today.getDate();
		mindate = yyyy + '-' + mm + '-' + dd;
		document.getElementById("bookingDate").setAttribute("max", maxdate);
		console.log(maxdate);
		console.log(mindate);
		document.getElementById("bookingDate").setAttribute("min", mindate);
	}

	function check() {

		var address = document.getElementById("Choice");

		if (address.value == "home") {

			document.getElementById("address").style.visibility = "visible";

		} else if (address.value == "center") {

			document.getElementById("address").style.visibility = "hidden";

		}

	}
</script>

</html>