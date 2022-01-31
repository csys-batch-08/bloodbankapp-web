<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SeekerIndex</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<style>
.seakerindex {
	text-align: right;
	background: black !important;
}

.homeContent {
	padding: 0px;
	text-align: justify;
	line-height: 2;
	height: 570px;
}

nav.header ul {
	list-style: none;
	padding: 10px;
	margin: 0px;
}

.homeContent img {
	width: 100%;
	height: -webkit-fill-available;
}

body {
	background-repeat: no-repeat;
	background-size: cover;
}

.seakerindex {
	text-align: right !important;
	background: black !important;
	justify-content: end !important;
	padding: 0px;
	align-items: center !important;
}
</style>
</head>
<body>
	<nav class="header seakerindex">
		<ul>
			<li><a href="seekerLogin.jsp">Login</a></li>
			<li><a href="seekerRegister.jsp">Register</a></li>
		</ul>
	</nav>
	<div class="homeContent">
		<img src="Images/002.jpg" calss="img-fluid">
	</div>
</body>
</html>