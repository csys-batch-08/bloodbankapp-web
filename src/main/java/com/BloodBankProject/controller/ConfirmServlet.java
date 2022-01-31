package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BloodDetailsDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		HttpSession  session = request.getSession();

		AdminDAOlmpl  adminDAOlmpl = new AdminDAOlmpl();

		int unit = 1;
		int price = 300;

		Donor donor = (Donor) session.getAttribute("Donor");

		BloodDetailsModel bloodDetails = new BloodDetailsModel(donor, unit, donor.getBloodType(), price);
		BloodDetailsDAOlmpl  bloodDetailsDAOlmpl = new BloodDetailsDAOlmpl();

		if (bloodDetailsDAOlmpl.insertBloodDetails(bloodDetails) > 0) {

			BloodStackDAOlmpl bloodStackDAOlmpl = new BloodStackDAOlmpl();

			BloodStack bloodStack = new BloodStack(bloodDetails.getUnit(), bloodDetails.getBloodType(), 0);

			if (bloodStackDAOlmpl.updateStack(bloodStack) > 0) {

				adminDAOlmpl.updateWallet();
				
				List<BloodDetailsModel> detailsList  = bloodDetailsDAOlmpl.showBloodDetails(donor);
				request.setAttribute("detailsList", detailsList);
				RequestDispatcher  dispatcher=request.getRequestDispatcher("showDonorBloodDetails.jsp");
				dispatcher.forward(request, response);
				

			}

		}

	}
		
		
		
		
		
		
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
}
}