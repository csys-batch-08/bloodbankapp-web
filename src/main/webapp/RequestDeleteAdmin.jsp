<%@page import="java.io.PrintWriter"%>
<%@page import="com.bloodbank.DaoImpl.RequestDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Delete Admin</title>
</head>
<body>
	<%
	Long aadharcard = Long.parseLong(request.getParameter("Aadharcard"));

	RequestDAOlmpl dao = new RequestDAOlmpl();
	
	PrintWriter pw = response.getWriter();
	String status=dao.StatusCheck(aadharcard);
	if(status.equals("approved")){
		
		

		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('can t delete the request it is approved');");
		pw.println("location='RequestShowAndDeleteAdmin.jsp';");
		pw.println("</script>");
            
		
		
	}else{
	
	
	if (dao.deleteRequest(aadharcard) > 0) {

		response.sendRedirect("RequestShowAndDeleteAdmin.jsp");

	}
	
	}
	
	%>
</body>
</html>