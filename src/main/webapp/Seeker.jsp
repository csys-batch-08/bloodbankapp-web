<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
a {
	text-decoration: none
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
	width: 58%;
	padding: 0px;
	margin: auto;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: end;
}

.formcontrol input, textarea {
	border: none;
	width: 90%;
	padding: 10px;
	background: #ffffff;
	border-radius: 3px;
	color: black;
	font-weight: bold;
	box-shadow: 0px 0px 8px 0px #d1d1d1;
	margin-bottom: 0px;
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
	margin-right: 5px;
	padding: 10px 20px;
	font-weight: bold;
	box-shadow: 0px 0px 3px 0px #606060;
}

.formbtn {
	display: flex;
	justify-content: space-between;
}

p {
	margin-bottom: 0px;
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
	padding: 11Spx;
	border-radius: 6px;
	width: 50%;
}
</style>
</head>
<body>




	<div class="loginForm">
		<div class="cardContent">
			<form action="SeekerRigester" method="post">
				<h1 style="text-align: center;">RIGESTER</h1>
				<div class="formcontrol">


					<input type="text" id="name" name="firstname" required autofocus
						placeholder="First Name" pattern="[A-Za-z]{3,}"
						title="mininum 3 character"><br>
					<br>
				</div>
				<div class="formcontrol">
					<input type="text" id="lastName" name="lastName" required
						placeholder="lastName" pattern="[A-Za-z]{3,}"
						title="mininum 3 character"><br>
					<br>
				</div>
				<div class="formcontrol">
					<textarea id="address" name="address" maxlength="50" required
						placeholder="Address"></textarea>
					<br>
					<br>
				</div>
				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[0-9]{10}" placeholder="PhoneNumber"
						title=" mininum 10characters"><br>
					<br>

				</div>
				<div class="formcontrol">
					<input type="password" id="PASSWORD" name="PASSWORD" required
						placeholder="PASSWORD" pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
						title=" mininum 8characters may includes @#$%&*_?/ "><br>
					<br>

				</div>
				<div class="formcontrol">
					<input type="TEXT" id="PATIENT" name="PATIENT"
						placeholder="PATIENT ID" pattern="[0-9A-Za-z]{5,}"><br>
					<br>
				</div>
				<div class="formcontrol">

					<input type="TEXT" id="HOSPITAL" name="HOSPITAL" required
						placeholder="HOSPITAL NAME" pattern="[A-Za-z]{5,}"
						title="mininum 3 character"><br> <br>
				</div>
				<div class="formcontrol">
					<input list="blood type" id="bloodtype" name="bloodtype" required
						placeholder="Blood Type"><br>
					<br>
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
					<br>

				</div>

				<div class="formbtn">
					<button>Submit</button>

					<button type="reset">Reset</button>
				</div>
				<%
				String error = (String) session.getAttribute("phoneNumber");
				if (error != null) {
				%>

				<p class="text-primary">
					<%=error%></p>
				<%
				session.setAttribute("phoneNumber", null);
				%>
				<%
				}
				%>





			</form>
		</div>
	</div>

</body>
</html>