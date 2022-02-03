
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
</head>
<body>

<c:if test="${Login!=null }">

<script>

function(){
	  toastMixin.fire({
	    animation: true,
	    title: 'Signed in Successfully'
	  });
	  var toastMixin = Swal.mixin({
		    toast: true,
		    icon: 'success',
		    title: 'General Title',
		    animation: false,
		    position: 'top-right',
		    showConfirmButton: false,
		    timer: 3000,
		    timerProgressBar: true,
		    didOpen: (toast) => {
		      toast.addEventListener('mouseenter', Swal.stopTimer)
		      toast.addEventListener('mouseleave', Swal.resumeTimer)
		    }
	  </script>


</c:if>


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
				<h1>login</h1>
				<div class="formcontrol">
					<input type="text" id="aadharcard" name="aadharcard" autofocus
						required="required" pattern="[0-9]{12}"
						placeholder="Enter the Aadharcard Number"
						title="enter the valid Aadharcard number"><br /> <br />

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