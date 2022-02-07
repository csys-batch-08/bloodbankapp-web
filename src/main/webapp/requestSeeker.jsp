<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@page import="com.bloodbank.model.BloodDetailsModel"%>
<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Seeker Request</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/requestSeeker.css">
</head>
<body>
	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>

			<fmt:bundle basename="com.bloodbank.bundle.Lable" prefix="nav.">


				<li><a href="donorIndex.jsp"> <fmt:message key="donor" />
				</a></li>
			</fmt:bundle>

			<li><a href="SeekerLogoutServlet">Logout</a></li>
		</ul>
	</nav>
	<div class="loginForm">

		<div class="cardContent">

			<form action="SeekerRequestServlet" method="post">
				<h1>
					<label>Request</label>
				</h1>
				<div class="formcontrol">

					<input type="text" id="NAME" name="FIRSTNAME" required="required"
						autofocus="autofocus" pattern="[A-Za-z]{3,}"
						title="enter the Name" placeholder=" Enter the Fisrt Name" />
				</div>
				<div class="formcontrol">

					<input type="text" id="NAME" name="LASTNAME" required="required"
						autofocus="autofocus" pattern="[A-Za-z]+" title="enter the Name"
						placeholder=" Enter the Last Name" />
				</div>



				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[987654321][0-9]{11}"
						title="enter the valid Aadharcard number"
						placeholder=" Enter the Aadharcard Number" />
				</div>


				<div class="formcontrol">
					<input type="TEXT" id="HOSPITAL" name="HOSPITAL" required
						pattern="[A-Za-z]{3,}" title="enter the valid hospital name"
						placeholder=" Enter the hospital Name" />
				</div>

				<div class="formcontrol">
					<p class="text-secondary" style="font-family: fantasy;">
						Request Date</p>
					<input type="date" id="Date" name="currentdate" required="required"
						placeholder="Date" />
				</div>

				<div class="formcontrol">
					<input list="blood type" id="bloodtype" name="bloodtype" required
						placeholder="choose the Blood Type" />
				</div>
				<datalist id="blood type">
					<option value="a+">a+</option>
					<option value="a-">a-</option>
					<option value="b+">b+</option>
					<option value="b-">b-</option>
					<option value="ab+">ab+</option>
					<option value="ab-">ab-</option>
					<option value="o+">o+</option>
					<option value="o-">o-</option>
					<option value="bombay">bombay</option>
				</datalist>

				<div class="formcontrol">
					<input type="NUMBER" ID="UNIT" NAME="UNIT" min="0" max="10"
						required placeholder="Enter the Unit" />


				</div>




				<div class="formbtn">
					<button type="submit">Submit</button>


					<button type="reset">Reset</button>
				</div>
			</form>
		</div>


	</div>

</body>


<script type="text/javascript">
	today();
	function today() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0');
		var yyyy = today.getFullYear();
		var max = today.setMonth(today.getMonth() + 1);
		maxdate = today.getFullYear() + '-' + 0 + (today.getMonth() + 1) + '-'
				+ 0 + today.getDate();
		mindate = yyyy + '-' + mm + '-' + dd;
		document.getElementById("Date").setAttribute("max", maxdate);
		console.log(maxdate);
		console.log(mindate);
		document.getElementById("Date").setAttribute("min", mindate);
	}
</script>

</html>