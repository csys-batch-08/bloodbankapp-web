<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.model.BloodStack"%>
<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Show Stock</title>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="assets/css/tableandsubmit.css">
</head>

<body>

	<script src="assets/javascript/popupMessage.js"></script>
	<c:if test="${param.priceChange!=null}">
		<script type="text/javascript">
			showMessage('productUpdated')
		</script>
	</c:if>



	<div class="adminCard">
		<div class="flexbox">
			<div class="adminImage">
				<table style="text-align: center;" aria-describedby="Stack details">
					<tr>
						<th><strong>Blood Type</strong></th>
						<th><strong>Quantity</strong></th>
						<th><strong>Price</strong></th>


					</tr>
					<c:forEach items="${requestScope.stackDetails}" var="stackList">
						<tr>
							<td>${stackList.bloodType}</td>
							<td>${stackList.quantity}</td>
							<td>${stackList.bloodPrice}</td>



						</tr>
					</c:forEach>

				</table>

			</div>
			<div class="content">
				<h2 style="color: black;">PRICE CHANGE</h2>

				<form action="BloodPriceChangeServlet" style="text-align: center;">
					<input list="blood type" id="bloodType" name="bloodtype"
						required="required" autofocus="autofocus"
						placeholder="Choose the Blood Type" />

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
					<input type="number" id="Price" value="Enter the Price"
						name="Price" required="required" pattern="[1-9][0-9]+"
						title="plese enter the valid number" placeholder="Blood Price">
					<input type="submit" value="confirm" />
				</form>

			</div>

		</div>



		<div class="backBtn">
			<a href="adminWork.jsp"><label for="back">back</label></a>
		</div>




	</div>



</body>
</html>