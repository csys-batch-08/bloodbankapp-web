<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>not qualified</title>
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
<style type="text/css">
#not {
	background-color: tomato;
	color: white;
}

.alertMassage {
	background: linear-gradient(141deg, black 50%, white 50%);
}

.alertMassage {
	background: orange;
	color: white;
	font-weight: bold;
}

.bodycontent {
	justify-content: center;
	height: 100vh;
}

.bodycontent p {
	font-family: cursive;
}
nav.header {
	background: #160101;
}

</style>
</head>
<body>

<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			
			<li><a href="SeekerIndex.jsp">Seeker</a></li>
			<li><a href="DonorLogoutServlet">Logout</a></li>
		</ul>
	</nav>
	<div class="d-flex bodycontent align-items-center">
		<div class="text-center">
			<p>The donor must be fit and healthy, and should not be
				suffering from transmittable diseases.</p>


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