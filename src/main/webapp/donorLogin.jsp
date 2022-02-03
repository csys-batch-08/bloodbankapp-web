
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Login</title>
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/donorLoginpage.css">


<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
			<li><a href="donorRegister.jsp">Register</a></li>
			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>



	<div class="loginForm">

		<div class="cardContent">

			<form action="login" method="post">
				<h1>Login</h1>
				<div class="formcontrol">
					<input type="text" id="aadharcard" name="aadharcard" autofocus
						required="required" pattern="[0-9]{12}"
						placeholder="Enter the Aadharcard Number"
						title="enter the valid Aadharcard number"><br /> <br />

				</div>

				<div class="formbtn">
					<input type="submit" value="Login">

				</div>

				<c:if test="${requestScope.DonorError!=null }">
					<p class="text-primary">${DonorError}</p>
				</c:if>

			</form>
		</div>
	</div>

</body>
</html>