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
<link rel="stylesheet" type="text/css" href="assets/css/tableformat.css">

</head>
<body>

   
       
	<div class="adminCard">
  
       
     
		<table>

			<tr>
				<th>HOSPITAL NAME</th>
				<th>BLOOD TYPE</th>
				<th>UNIT</th>
				<th>BLOOD COLLECTER NAME</th>
				<th>PHONE NUMBER</th>
				<th>AADHARCARD NUMBER</th>
				<th>DATE</th>
				<th>STATUS</th>
			</tr>
			
			<c:forEach items="${requestScope.requestList }" var="List">
              <tr>
              <td>${List.hospitalName}</td>
              <td>${List.bloodType}</td>
              <td>${List.unit}</td>
              <td>${List.bloodCollectorName}</td>
              <td>${List.phoneNumber}</td>
              <td>${List.aadharcard}</td>
              <td>
					<fmt:parseDate value="${List.requestDate}" pattern="yyyy-MM-dd" var="requestDate" type="date"/>   
      
                     <fmt:formatDate pattern="dd/MM/yyyy" value="${requestDate}"/>  </td>
              
            
              
              <td>${List.status}</td>       
              
            
              </tr>
              </c:forEach>
            
		</table>
		<br>

		<div class="backBtn">
			<a href="requestCancel.jsp">REQUEST CANCEL </a>
		</div>	<div class="backBtn">			
			<a href="requestIndex.jsp">back</a>
		
		</div>
	</div>
</body>
</html>