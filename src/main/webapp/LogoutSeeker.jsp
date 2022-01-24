<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	
HttpSession hpt = request.getSession();
hpt.setAttribute("seeker", null);
hpt.setAttribute("requestModel", null);
hpt.setAttribute("biilingProces", null);
PrintWriter   pw = response.getWriter(); 

pw.println("<script type=\"text/javascript\">");
pw.println("alert('Logout success');");
pw.println("location='index.jsp';");
pw.println("</script>"); %>
</body>
</html>