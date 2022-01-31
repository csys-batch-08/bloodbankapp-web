<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@page import="com.bloodbank.model.BloodDetailsModel"%>
<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Seeker Request</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<style>
nav.header {
	background: #160101;
}

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
	overflow: hidden;
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

.formcontrol input {
	border: none;
	width: 90%;
	padding: 10px;
	background: #ffffff;
	border-radius: 3px;
	color: black;
	font-weight: bold;
	box-shadow: 0px 0px 8px 0px #d1d1d1;
	margin-bottom: 10px;
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
	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="donorIndex.jsp">Donor</a></li>

			<li><a href="SeekerLogoutServlet">Logout</a></li>
		</ul>
	</nav>
	<div class="loginForm">
	
		<div class="cardContent">

			<form action="SeekerRequestServlet" >
				<h1>Request</h1>
				<div class="formcontrol">

					<input type="text" id="NAME" name="NAME" required autofocus
						pattern="[A-Za-z]{3,}" title="enter the Name"
						placeholder=" Enter the Blood Collector Name">
				</div>



				<div class="formcontrol">
					<input type="text" id="number" name="number" required
						pattern="[987654321][0-9]{11}"
						title="enter the valid Aadharcard number"
						placeholder=" Enter the Aadharcard Number">
				</div>


				<div class="formcontrol">
					<input type="TEXT" id="HOSPITAL" name="HOSPITAL" required
						pattern="[A-Za-z]{3,}" title="enter the valid hospital name"
						placeholder=" Enter the hospital Name">
				</div>

				<div class="formcontrol">
					<p class="text-secondary" style="font-family: fantasy;"> Request Date 
						</p>
					<input type="date" id="Date" name="currentdate" required="required"
						placeholder="Date">
				</div>

				<div class="formcontrol">
					<input list="blood type" id="bloodtype" name="bloodtype" required
						placeholder="choose the Blood Type">
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
						required placeholder="Enter the Unit">


				</div>




				<div class="formbtn">
					<button type="submit">Submit</button>


					<button type="reset">Reset</button>
				</div>			
			
		</div>

		</form>
	</div>
	
</body>


<script type="text/javascript">
	today();
	function today() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
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