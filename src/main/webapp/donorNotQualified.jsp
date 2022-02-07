<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>not qualified</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/notQualifiedPage.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
</head>
<body>



	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.bookingDate!=null}">
		<script type="text/javascript"> showMessage('bookingDate')</script>
	</c:if>
	<script>
$(document).ready(function(){
  $("p").on({
    mouseenter: function(){
      $(this).css("background-color", "lightgray");
    },  
    mouseleave: function(){
      $(this).css("background-color", "lightblue");
    }, 
    
  });
});
</script>
	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>

			<li><a href="seekerIndex.jsp">Seeker</a></li>
			<li><a href="DonorLogoutServlet">Logout</a></li>
		</ul>
	</nav>
	<div class="d-flex bodycontent align-items-center">
		<div class="text-center">
			<p>The donor must be fit and healthy, and should not be suffering
				from transmittable diseases.</p>


			<p>Age and weight- Between 18 and 65 years old and should weigh a
				minimum of 50 kg</p>

			<p>Pulse rate- Between 50 and 100 without irregularities.</p>
			<p>Hemoglobin level- A minimum of 12.5 g/dL.</p>

			<div class="alert alert-secondary text-center alertMassage"
				role="alert">YOU NOT ELIGIBEL</div>
		</div>



	</div>
</body>
</html>