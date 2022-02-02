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
<link rel="stylesheet" type="text/css" href="asserts/css/stack.css">

<link rel="stylesheet" type="text/css"
	href="assets/css/tableandsubmit.css">
</head>

<body>
	<div class="adminCard">
		<table style="text-align: center;" class="center">
			<tr>
				<th><strong>Blood Type</strong></th>
				<th><strong>Quantity</strong></th>
				<th><strong>PRICE</strong></th>


			</tr>
			<c:forEach items="${requestScope.stockList}" var="stockList">
				<tr>
					<td>${stockList.bloodType}</td>
					<td>${stockList.quantity}</td>
					<td>${stockList.bloodPrice}</td>



				</tr>
			</c:forEach>

		</table>






		<div class="content">
			<form action="BloodPriceChangeServlet" method="post"
				style="text-align: center;">



				<input list="blood type" id="bloodType" name="bloodtype"
					required="required" autofocus="autofocus"
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



				<input type="number" id="Price" value="Enter the Price" name="Price"
					required="required" pattern="[1-9][0-9]+"
					title="plese enter the valid number"> <input type="submit"
					value="confirm">
			</form>
		</div>
		<div class="backBtn">
			<a href="adminWork.jsp">Back </a>
		</div>


	</div>
</body>
</html>