package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.RequestDAOlmpl;

@WebServlet("/RequestDeleteAdminServlet")
public class RequestDeleteAdminServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long aadharcard = Long.parseLong(request.getParameter("Aadharcard"));
		String bloodType = request.getParameter("bloodtype");
		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();

		PrintWriter writer = response.getWriter();
		String status = requestDAOlmpl.statusCheck(aadharcard, bloodType);

		if (status.equals("approved")) {

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('can t delete the request it is approved');");
			writer.println("location='requestShowAndDeleteAdmin.jsp';");
			writer.println("</script>");

		} else {

			if (requestDAOlmpl.deleteRequest(aadharcard, bloodType) > 0) {

				response.sendRedirect("requestShowAndDeleteAdmin.jsp");

			}

		}

	}
}
