<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css" href="assets/css/form.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<body>
	<script>
$(document).ready(function(){
  $("p").click(function(){
    $(this).hide();
  });
});
</script>
	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="donorIndex.jsp">Donor</a></li>
			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>



	<div class="loginForm">
		<div class="cardContent">
			<form action="Forgotpassword" method="post">
				<h1 style="text-align: center;">Forgot Password</h1>


				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[0-9]{10}" placeholder="Enter the PhoneNumber"
						title=" mininum 10characters" /><br /> <br />

				</div>
				<div class="formcontrol">
					<input type="password" id="PASSWORD" name="PASSWORD" required
						placeholder="Enter the Password"
						pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
						title=" mininum 8characters may includes @#$%&*_?/ " /><br /> <br />

				</div>
				<div class="formcontrol">
					<input type="password" id="CONFIRM" name="CONFIRM" required
						placeholder="Enter the Confirm Password"
						pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
						title=" mininum 8characters may includes @#$%&*_?/ " /><br /> <br />

				</div>



				<div class="formbtn">
					<input type="submit" value="submit" /> <input type="reset"
						value="reset" />
				</div>



				<c:if test="${requestScope.PasswordError!=null }">
					<p class="text-primary">${PasswordError}</p>
				</c:if>



				<c:if test="${requestScope.numbererror!=null }">
					<p class="text-primary">${numbererror}</p>
				</c:if>


			</form>
		</div>
	</div>

</body>
</html>