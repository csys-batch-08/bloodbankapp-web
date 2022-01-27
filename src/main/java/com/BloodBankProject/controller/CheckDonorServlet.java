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
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int height = Integer.parseInt(request.getParameter("Height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int temp = Integer.parseInt(request.getParameter("temperature"));
		// String value=request.getParameter("health");
		int pressure = Integer.parseInt(request.getParameter("pressure"));
		int pluse = Integer.parseInt(request.getParameter("pulse"));
		PrintWriter  writer = response.getWriter();

		if (temp <= 100 && temp >= 80) {

			if (pressure <= 180 && pressure >= 90) {

				if (pluse <= 100 && pluse >= 50) {

					// PrintWriter pw=response.getWriter();

					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('you are eligible to blood donate');");
					writer.println("location='BookingIndex.jsp';");
					writer.println("</script>");

					// response.sendRedirect("BookingIndex.jsp");

				} else {
					// pw.write("you not eligible");
					response.sendRedirect("NotQualification.jsp");
				}

			} else {
				// pw.write("you not eligible");
				response.sendRedirect("NotQualification.jsp");
			}

		} else {
			response.sendRedirect("NotQualified.jsp");
			// pw.write("you not eligible");

		}

	}
}
