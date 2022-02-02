<%@page import="java.util.List"%>
<%@page import="com.bloodbank.DaoImpl.BillingDAOlmpl"%>
<%@page import="com.bloodbank.model.BillingModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>show Billing Admin</title>

<link rel="stylesheet" type="text/css"
	href="assets/css/tableandsubmit.css">


</head>
<body>

	<div class="adminCard">
		<div class="flexbox">
			<div class="adminImage">
				<table style="text-align: center;" class="center">
					<tr>
						<th><strong>BLOODTYPE</strong></th>
						<th><strong>SEEKER NAME</strong></th>
						<th><strong>SEEKER PHONENUMBER</strong></th>
						<th><strong>QUANTITY</strong></th>
						<th><strong>PRICE</strong></th>
						<th><strong>Date</strong></th>
					</tr>



					<c:forEach items="${requestScope.billingList}" var="billingList">


						<tr>
							<td>${billingList.bloodType}</td>
							<td>${billingList.seeker.firstName}</td>
							<td>${billingList.seeker.phoneNumber}</td>
							<td>${billingList.unit}</td>
							<td>${billingList.totalprice}</td>
							
							<td>
					<fmt:parseDate value="${billingList.billDate}" pattern="yyyy-MM-dd" var="billDate" type="date"/>   
      
                     <fmt:formatDate pattern="dd/MM/yyyy" value="${billDate}"/>
					</td>

						</tr>
					</c:forEach>





				</table>
			</div>
			
			<div class="content">
				<form action="ShowForBillingDateServlet" method="post"
					style="text-align: center;">

					<label for="date">Date</label> <input type="date" id="date"
						name="date" required="required"> <input type="submit"
						value="submit">




				</form>

			</div>
		</div>
		<div class="backBtn">
			<a href="adminWork.jsp">back</a>
		</div>
	</div>

	<script type="text/javascript">
		today();
		function today() {
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0');
			var yyyy = today.getFullYear();
			var max = today.setMonth(today.getMonth() + 1);
			maxdate = today.getFullYear() + '-' + mm + '-' + dd;

			document.getElementById("date").setAttribute("max", maxdate);
			console.log(maxdate);

		}
	</script>

</body>



</html>