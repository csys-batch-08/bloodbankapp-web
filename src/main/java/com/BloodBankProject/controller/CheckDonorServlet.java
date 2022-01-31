package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BloodDetailsDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.Donor;

@WebServlet("/CheckDonorServlet")
public class CheckDonorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int temp = 0;
		int pressure = 0;
		int pluse = 0;
		int height = 0;
		int weight = 0;
		try {
			height = Integer.parseInt(request.getParameter("Height"));
			weight = Integer.parseInt(request.getParameter("weight"));
			temp = Integer.parseInt(request.getParameter("temperature"));

			pressure = Integer.parseInt(request.getParameter("pressure"));
			pluse = Integer.parseInt(request.getParameter("pulse"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

		PrintWriter writer = response.getWriter();

		if (temp <= 100 && temp >= 80) {

			if (pressure <= 180 && pressure >= 90) {

				if (pluse <= 100 && pluse >= 50) {

					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('you are eligible to blood donate');");
					writer.println("location='bloodBookingProcess.jsp';");
					writer.println("</script>");

				} else {

					try {
						response.sendRedirect("donorNotQualified.jsp");
					} catch (IOException e) {

						e.printStackTrace();
					}
				}

			} else {

				try {
					response.sendRedirect("donorNotQualified.jsp");
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		} else {
			try {
				response.sendRedirect("donorNotQualified.jsp");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}
}
