<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BloodDetailsDAOlmpl"%>
<%@page import="com.bloodbank.model.BloodDetailsModel"%>
<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowDonorBloodDetails</title>
<style type="text/css">
body {
	height: 100vh;
	margin: 0px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.adminCard {
	padding: 25px;
	background: linear-gradient(40deg, #e90a0a 41%, white 9%);
	box-shadow: 0px 0px 6px 0px black;
	color: white;
	margin: 50px;
	width: 100%;
}

th, td {
	padding: 15px;
}

table, th, td {
	border: 1px solid #e1e1e1;
	border-collapse: collapse;
	color: black !important;
	color: navy;
	font-size: 16px;
	font-weight: bold;
	word-break: break-word;
	padding: 5px 0px;
}

table, th {
	background: #e90a0a;
	color: white !important;
	font-size: 15px;
	font-weight: bold;
}

.adminCard table {
	width: 100%;
	background: white;
	color: black;
	text-align: center;
	height: 460px;
	display: block;
	overflow: auto;
}

tbody {
	width: 100%;
	display: table;
}

.backBtn a {
	text-decoration: none;
	color: white;
	margin-right: 14px;
	background: black;
	padding: 5px 10px;
	border-radius: 3px
}

.backBtn {
	float: right;
	margin-top: 10px;
	font-size: 19px;
	padding: 5px 20px;
}
</style>
</head>
<body>
	<div class="adminCard">
		<table class="center">
			<tr>
				<th><strong>Aadharcard</strong></th>
				<th><strong> BLOODTYPE</strong></th>
				<th><strong> UNIT</strong></th>
				<th><strong>PRICE</strong></th>
				<th><strong>Date</strong></th>
			</tr>
			<%
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			HttpSession htp = request.getSession();
			Donor donor = (Donor) htp.getAttribute("Donor");
			BookingModel book = (BookingModel) htp.getAttribute("bookingDate");

			BloodDetailsDAOlmpl Dao = new BloodDetailsDAOlmpl();

			List<BloodDetailsModel> DetailsList = Dao.ShowBloodDetails(donor);

			for (int i = 0; i < DetailsList.size(); i++) {

				BloodDetailsModel details = DetailsList.get(i);
			%>


			<tr>

				<td><%=details.getDonor().getAadharcard()%></td>
				<td><%=details.getDonor().getBloodType()%></td>
				<td><%=details.getUnit()%></td>
				<td><%=details.getPrice()%></td>
				<td><%=sdf.format(book.getAppdate())%></td>


			</tr>

			<%
			}
			%>



		</table>
		<div class="backBtn">
			<a href="DonorLogoutServlet">logout</a>

		</div>
	</div>
</body>
</html>