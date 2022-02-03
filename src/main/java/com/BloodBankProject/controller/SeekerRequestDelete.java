package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.RequestDAOlmpl;

@WebServlet("/SeekerRequestDelete")
public class SeekerRequestDelete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bloodType = request.getParameter("bloodtype");
		Long aadharcardNumber = null;
		try {
			aadharcardNumber = Long.parseLong(request.getParameter("ADHARCARD"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();

		if (requestDAOlmpl.aadharcardValid(aadharcardNumber) != null) {

			if (requestDAOlmpl.statusCheck(aadharcardNumber, bloodType).equals("approved")) {

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('can t delete the request it is approved');");
				writer.println("location='ShowRequestSeekerServlet';");
				writer.println("</script>");

			} else {

				if (requestDAOlmpl.deleteRequest(aadharcardNumber, bloodType) > 0) {

					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('Request cancel');");
					writer.println("location='ShowRequestSeekerServlet';");
					writer.println("</script>");

					session.setAttribute("seeker", null);

				}

			}
		} else {

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Invalid Aadharcard Number. ');");
			writer.println("location='ShowRequestSeekerServlet';");
			writer.println("</script>");

		}

	}

}
