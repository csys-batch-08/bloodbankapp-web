<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/seekerRegister.css">
</head>
<body>
	<div class="loginForm">
		<div class="cardContent">
			<form action="SeekerRigester" method="post">
				<h1 style="text-align: center;">REGISTER</h1>
				<div class="formcontrol">


					<input type="text" id="name" name="firstname" required autofocus
						placeholder="First Name" pattern="[A-Za-z]{3,}"
						title="mininum 3 character"><br /> <br />
				</div>
				<div class="formcontrol">
					<input type="text" id="lastName" name="lastName"
						required="required" placeholder="lastName" pattern="[A-Za-z]+"
						title=" must enter the last name"><br /> <br />
				</div>
				<div class="formcontrol">
					<textarea id="address" name="address" maxlength="50" required
						placeholder="Address"></textarea>
					<br /> <br />
				</div>
				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[0-9]{10}" placeholder="PhoneNumber"
						title=" mininum 10characters"><br /> <br />

				</div>
				<div class="formcontrol">
					<input type="password" id="PASSWORD" name="PASSWORD" required
						placeholder="Password" pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
						title=" mininum 8characters may includes @#$%&*_?/ "><br />
					<br />

				</div>
				<div class="formcontrol">
					<input type="TEXT" id="PATIENT" name="PATIENT"
						placeholder="Patient Id" pattern="[0-9A-Za-z]{5,}"><br />
					<br />
				</div>
				<div class="formcontrol">

					<input type="TEXT" id="HOSPITAL" name="HOSPITAL" required
						placeholder="Hospital Name" pattern="[A-Za-z]{5,}"
						title="mininum 3 character"><br /> <br />
				</div>
				<div class="formcontrol">
					<input list="blood type" id="bloodtype" name="bloodtype" required
						placeholder="Blood Type"><br /> <br />
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
					<br />

				</div>

				<div class="formbtn">
					<button>Submit</button>

					<button type="reset">Reset</button>
				</div>

				<c:if test="${requestScope.phoneNumber!=null }">
					<p class="text-primary">${phoneNumber}</p>
				</c:if>

			</form>
		</div>
	</div>

</body>
</html>