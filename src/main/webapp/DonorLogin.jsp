
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Login</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<style>
a {
	text-decoration: none
}

p {
	margin-bottom: 0px;
}

.loginForm form h1 {
	margin: 0px 0px 20px;
	color: white;
}

.loginForm form {
	text-align: center;
	padding: 25px;
}

label {
	width: 130px;
	display: inline-block;
}

body {
	background-image: url(Images/background.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: bottom;
	margin: 0px;
}

.loginForm form {
	text-align: center;
}

.loginForm {
	width: 50%;
	padding: 0px;
	margin: auto;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: end;
}

.formcontrol input {
	border: none;
	padding: 10px;
	background: #ffffff;
	border-radius: 3px;
	color: black;
	font-weight: bold;
	box-shadow: 0px 0px 8px 0px #d1d1d1;
}

.formbtn button, .formbtn input {
	border: none;
	padding: 10px;
	text-decoration: none;
}

.formbtn button a {
	color: white;
}

.formbtn button, .formbtn input {
	border: none;
	padding: 10px;
	text-decoration: none;
	background: black;
	color: white;
	border-radius: 3px;
	padding: 10px 20px;
	font-weight: bold;
	box-shadow: 0px 0px 3px 0px #606060;
}

.formbtn {
	display: flex;
	justify-content: center;
}

.formcard {
	display: flex;
	background: linear-gradient(41deg, #ffffff 50%, #000000 48%);
	padding: 15px;
	border-radius: 9px;
}

.cardimg {
	width: 50%;
}

.cardimg img {
	width: 100%;
}

.cardContent {
	background: linear-gradient(141deg, black 50%, white 50%);
	padding: 30px;
	border-radius: 6px;
}
</style>
</head>
<body>




	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="DonorRegister.jsp">Register</a></li>
			<li><a href="SeekerIndex.jsp">Seeker</a></li>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>



	<div class="loginForm">

		<div class="cardContent">

			<form action="login">
				<h1>login</h1>
				<div class="formcontrol">
					<input type="text" id="aadharcard" name="aadharcard" autofocus
						required="required" pattern="[0-9]{12}"
						placeholder="Enter the Aadharcard Number"
						title="enter the valid Aadharcard number"><br>
					<br>

				</div>

				<div class="formbtn">
					<input type="submit" value="login">

				</div>
				
<c:if test="${requestScope.DonorError!=null }">
				<p class="text-primary">${DonorError}</p>
				</c:if>

			</form>
		</div>
	</div>

</body>
</html>