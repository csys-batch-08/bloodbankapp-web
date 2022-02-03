<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Seeker Login</title>

<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css" href="assets/css/formformat.css">
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
			<li><a href="donorIndex.jsp">Donor</a></li>
			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>



	<div class="loginForm">
		<div class="cardContent">
			<form action="SeekerLoginServlet" method="post"
				style="text-align: center;">





				<h1>LOGIN</h1>
				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[0-9]{10}" title=" mininum 10characters"
						placeholder="Enter the Phone Number">

				</div>
				<div class="formcontrol">
					<input type="password" id="PASSWORD" name="PASSWORD" required
						placeholder="Enter the Password"
						pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
						title=" mininum 8characters may includes @#$%&*_?/ ">

				</div>
				<div class="formbtn">
					<button>Submit</button>

					<button>
						<a href="forgotPassword.jsp">Forgot password</a>
					</button>

				</div>

				<c:if test="${requestScope.SeekerError!=null }">
					<p class="text-primary">${SeekerError}</p>
				</c:if>




			</form>
		</div>
	</div>
</body>
</html>