package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

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
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession htp = request.getSession();

		AdminDAOlmpl admin = new AdminDAOlmpl();

		int unit = 1;
		int price = 300;

		Donor donor = (Donor) htp.getAttribute("Donor");

		BloodDetailsModel bloodDetails = new BloodDetailsModel(donor, unit, donor.getBloodType(), price);
		BloodDetailsDAOlmpl Dao = new BloodDetailsDAOlmpl();

		// htp.setAttribute("currentModel", model);

		if (Dao.insertBloodDetails(bloodDetails) > 0) {

			BloodStackDAOlmpl bloodStock = new BloodStackDAOlmpl();

			BloodStack stack = new BloodStack(bloodDetails.getUnit(), bloodDetails.getBloodType(), 0);

			int num = bloodStock.updateStack(stack);

			if (num > 0) {

				admin.updateWallet();

				response.sendRedirect("ShowBooking.jsp");

			}

		}

	}
}
