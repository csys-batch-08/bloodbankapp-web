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

/**
 * Servlet implementation class CheckDonorServlet
 */
@WebServlet("/CheckDonorServlet")
public class CheckDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckDonorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int height = Integer.parseInt(request.getParameter("Height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int temp = Integer.parseInt(request.getParameter("temperature"));
		// String value=request.getParameter("health");
		int pressure = Integer.parseInt(request.getParameter("pressure"));
		int pluse = Integer.parseInt(request.getParameter("pulse"));
		PrintWriter pw = response.getWriter();

		if (temp <= 100 && temp >= 80) {

			if (pressure <= 180 && pressure >= 90) {

				if (pluse <= 100 && pluse >= 50) {

					// PrintWriter pw=response.getWriter();

					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('you are eligible to blood donate');");
					pw.println("location='BookingIndex.jsp';");
					pw.println("</script>");

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
