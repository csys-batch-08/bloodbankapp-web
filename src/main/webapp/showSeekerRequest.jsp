<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@page import="com.bloodbank.model.RequestModel"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.RequestDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Show Request Seeker</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/tableandsubmit.css">

</head>
<body>


<div class="adminCard">
		<div class="flexbox">
			<div class="adminImage">

		<table>

			<tr>
				<th>HOSPITAL NAME</th>
				<th>BLOOD TYPE</th>
				<th>UNIT</th>
				<th>BLOOD COLLECTER NAME</th>
				<th>PHONE NUMBER</th>
				<th>AADHARCARD NUMBER</th>
				<th>DATE</th>
				<th style="width:100px">STATUS</th>
			</tr>

			<c:forEach items="${requestScope.requestList }" var="List">
				<tr>
					<td>${List.hospitalName}</td>
					<td>${List.bloodType}</td>
					<td>${List.unit}</td>
					<td>${List.bloodCollectorName}</td>
					<td>${List.phoneNumber}</td>
					<td>${List.aadharcard}</td>
					<td><fmt:parseDate value="${List.requestDate}"
							pattern="yyyy-MM-dd" var="requestDate" type="date" /> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${requestDate}" /></td>



					<td>${List.status}</td>


				</tr>
			</c:forEach>

		</table>
		</div>
		
		<div class="content">
			<form action="SeekerRequestDelete" method="post"
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


				<input type="text" id="ADHARCARD" name="ADHARCARD" required
					pattern="[456789][0-9]{11}"
					placeholder="Enter the Aadharcard Number"
					title="enter the valid Aadharcard number"> <input
					type="submit" value="confirm" />
			</form>
		</div>
</div>

		<div class="backBtn">
			<a href="requestIndex.jsp">back</a>

		</div>
	</div>
</body>
</html>