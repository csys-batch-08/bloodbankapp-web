<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Request index</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/requestIndex.css">
</head>
<body>


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