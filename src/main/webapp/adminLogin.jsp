<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title dir="ltr">AdminLogin</title>
<link rel="stylesheet" type="text/css" href="assets/css/form.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<script type="text/javascript">
$(document).ready(function(){
  $("p").click(function(){
    $(this).hide();
  });
});
</script>
	<div class="loginForm">
		<div class="cardContent">
			<form action="AdminController" method="post"
				style="text-align: center;">
				<h1>Admin login</h1>
				<div class="formcontrol">
					<input type="email" id="email"
						name="email" required="required" placeholder="Enter the Email" />
				</div>
				<div class="formcontrol">
				<input type="password" id="password"
						name="password" required="required"
						placeholder="Enter the password"
						pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
						title=" mininum 8characters may includes @#$%&*_?/" />
				</div>
				<div class="formbtn">
					<input type="submit" value="Login" /> <input type="reset"
						value="Reset" id="reset" />
				</div>
				<c:if test="${requestScope.error!=null }">
					<p class="text-primary">${error}</p>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>
