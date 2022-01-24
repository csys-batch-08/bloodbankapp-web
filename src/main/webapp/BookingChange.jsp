<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Change</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<style>
nav.header {
	background: #160101;
}

a {
	text-decoration: none
}

.book {
	height: 100vh;
	justify-content: center;
}

.book form h1 {
	margin: 0px 0px 20px;
	color: white;
}

.book form {
	text-align: center;
	padding: 25px;
}

.inputtype input, textarea, select {
	border: none;
	padding: 10px;
	background: #ffffff;
	border-radius: 3px;
	color: black;
	font-weight: bold;
	box-shadow: 0px 0px 8px 0px #d1d1d1;
	margin-bottom: 10px;
}

.submit button, .submit input {
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

.bookinner {
	background: linear-gradient(141deg, black 50%, white 50%);
	padding: 11Spx;
	border-radius: 6px;
}

body {
	background-image: url(Images/background.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: bottom;
	margin: 0px;
	overflow: hidden;
}
</style>
</head>
<body>
	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			<li><a href="DonorIndex.jsp">Donor</a></li>
			<li><a href="SeekerIndex.jsp">Seeker</a></li>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>
	<div class="d-flex book align-items-center">
		<div class="col-sm-5"></div>
		<div class="bookinner cal-sm-5">

			<form action="BookingChangeServlet" onmouseover="check()"
				method="post">

				<h1>BOOKING</h1>
				<div>
					<div class="inputtype">
						<input type="date" id="bookingDate" name="bookingDate"
							required="required" placeholder="">

					</div>
					<div class="inputtype">
						<select name="Choice" id="Choice" value="center"
							required="required">
							<option disabled="disabled">Select any one</option>

							<option value="center">center</option>
							<option value="home">Home</option>
						</select>
					</div>

					<div class="inputtype">
						<textarea style="visibility: hidden;" id="address" name="address"
							maxlength="50" placeholder="Enter the Home Address"></textarea>

					</div>
				</div>

				<div class="submit">

					<input type="submit" value="submit">
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
		document.getElementById("bookingDate").setAttribute("max", maxdate);
		console.log(maxdate);
		console.log(mindate);
		document.getElementById("bookingDate").setAttribute("min", mindate);
	}

	function check() {

		var address = document.getElementById("Choice");

		if (address.value == "home") {

			document.getElementById("address").style.visibility = "visible";

		} else if (address.value == "center") {

			document.getElementById("address").style.visibility = "hidden";

		}

	}
</script>

</html>