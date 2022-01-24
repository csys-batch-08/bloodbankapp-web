<%@page import="com.bloodbank.DaoImpl.AdminDAOlmpl"%>
<%@page import="com.bloodbank.DaoImpl.BillingDAOlmpl"%>
<%@page import="com.bloodbank.model.BillingModel"%>
<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@page import="com.bloodbank.DaoImpl.SeekerDAOlmpl"%>
<%@page import="com.bloodbank.DaoImpl.BloodStackDAOlmpl"%>
<%@page import="com.bloodbank.model.RequestModel"%>
<%@page import="com.bloodbank.DaoImpl.RequestDAOlmpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Update Admin</title>
</head>
<body>
	<%
	Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
	RequestDAOlmpl requestModelDao = new RequestDAOlmpl();
	RequestModel requestModel = requestModelDao.RequestObject(phoneNumber);
	String status = "approved";
	HttpSession hp = request.getSession();

	//System.out.println(phoneNumber);

	RequestModel requestMoel = new RequestModel(requestModel.getHospitalName(), requestModel.getBloodType(),
			requestModel.getUnit(), requestModel.getBloodCollectorName(), requestModel.getPhoneNumber(),
			requestModel.getAadharcard(), requestModel.getRequestDate(), status);

	BloodStackDAOlmpl stack = new BloodStackDAOlmpl();

	double unitPrice = stack.findPrice(requestModel.getBloodType()) * requestModel.getUnit();

	SeekerDAOlmpl dao = new SeekerDAOlmpl();
	SeekerDetails seeker = dao.FindSeekerObjectId(phoneNumber);

	BillingModel BillingModel = new BillingModel(requestModel.getBloodType(), seeker, requestModel.getUnit(), unitPrice,
			null);

	hp.setAttribute("billingProces", BillingModel);

	BillingDAOlmpl biiling = new BillingDAOlmpl();

	int n = biiling.insertBilling(BillingModel);

	if (n > 0) {

		int num = stack.updateStackReduce(requestModel.getBloodType(), requestModel.getUnit());

		if (num > 0) {

			AdminDAOlmpl admin = new AdminDAOlmpl();
			if (admin.seekerPayment(unitPrice) > 0) {

		response.sendRedirect("seekerbill.jsp");

			}

		}

	}
	%>





</body>
</html>