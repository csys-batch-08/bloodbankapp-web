<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Check-up</title>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/requestSeeker.css">
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


	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>

			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="DonorLogoutServlet">Logout</a></li>

		</ul>
	</nav>



	<div class="loginForm">
		<div class="cardContent">

			<form action="CheckDonorServlet" method="post"
				style="text-align: center;">


				<h1>CHECK-UP</h1>
				<div class="formcontrol">
					<input type="text " id="Height" name="Height" required="required"
						autofocus="autofocus" pattern="[0-9]{2,}"
						placeholder="Enter the Height" title="it should be in number"><br />
					<br />
				</div>
				<div class="formcontrol">

					<input type="text " id="weight" name="weight" required="required"
						pattern="[0-9]{2,}" placeholder="Enter the weight"
						title="it should be in number"><br /> <br />
					<div class="formcontrol">
						<input type="text " id="temperature" name="temperature"
							required="required" pattern="[0-9]{2,}"
							placeholder="Enter the Temperature"
							title="it should be in number"><br /> <br />
					</div>
					<div class="formcontrol"></div>
					<div class="formcontrol">
						<input type="text " id="pressure" name="pressure"
							required="required" pattern="[0-9]{2,}"
							placeholder="Enter the blood pressure"
							title="it should be in number"><br /> <br />
					</div>
					<div class="formcontrol">
						<input type="text " id="pulse" name="pulse" required="required"
							pattern="[0-9]{2,}" placeholder="Enter the pulse"
							title="it should be in number"><br /> <br />

					</div>
					<div class="formbtn">
						<input id="submit" type="submit"> <input id="reset"
							type="reset">
					</div>
					</div>
			</form>
		</div>
	</div>



</body>
</html>