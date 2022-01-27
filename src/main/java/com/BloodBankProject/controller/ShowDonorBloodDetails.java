package com.BloodBankProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.Dao.BloodDetailsDAO;
import com.bloodbank.DaoImpl.BloodDetailsDAOlmpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class ShowDonorBloodDetails
 */
@WebServlet("/ShowDonorBloodDetails")
public class ShowDonorBloodDetails extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		HttpSession session = request.getSession();
		Donor donor = (Donor) session.getAttribute("Donor");
		BookingModel bookingModel = (BookingModel) session.getAttribute("bookingDate");

		BloodDetailsDAOlmpl bloodDetailsDAOlmpl = new BloodDetailsDAOlmpl();

		List<BloodDetailsModel> DetailsList = bloodDetailsDAOlmpl.ShowBloodDetails(donor);
		request.setAttribute("DetailsList", DetailsList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowDonorBloodDetails.jsp");
		dispatcher.forward(request, response);

		
	}

}
