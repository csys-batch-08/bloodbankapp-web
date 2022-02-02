<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="assets/css/donorRegister.css">

</head>

<body>
	<div class="loginForm">
		<div class="cardContent">



			<form action="Register" method="post">
				<h1>Register</h1>
				<div class="formcontrol">

					<input type="text" id="name" name="firstname" required autofocus
						placeholder="Enter the First Name" pattern="[A-Za-z]{3,}"
						title="mininum 3 character">
				</div>
				<div class="formcontrol">
					<input type="text" id="lastName" name="lastName" required
						placeholder="Enter the lastName" pattern="[A-Za-z]+"
						title="must enter the last name">

				</div>
				<div class="formcontrol">

					<textarea id="address" name="address" maxlength="50" required
						placeholder="Enter the Address:"></textarea>

				</div>
				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[9876][0-9]{9}" placeholder="Enter the PhoneNumber"
						title=" mininum 10characters">
				</div>
				<div class="formcontrol">
					<p class="text-secondary" style="font-family: fantasy;">Date of
						Birth</p>
					<input type="date" id="bio" name="bio" required="required"
						placeholder="BIO">

				</div>
				<div class="formcontrol">
					<input type="text" id="ADHARCARD" name="ADHARCARD" required
						pattern="[123456789][0-9]{11}"
						placeholder="Enter the Aadharcard Number"
						title="enter the valid Aadharcard number">
				</div>
				<div class="formcontrol">
					<input list="blood type" id="bloodtype" name="bloodtype" required
						placeholder="Choose the Blood Type">

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


					<c:if test="${requestScope.aadharcardNumber!=null }">
						<p class="text-primary">${aadharcardNumber}</p>
					</c:if>

				</div>
				<div class="formbtn">
					<button>Submit</button>
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
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		var yyyy1 = today.getFullYear() - 18;
		maxdate = yyyy1 + '-' + mm + '-' + dd;

		document.getElementById("bio").setAttribute("max", maxdate);
	}
</script>
</html>