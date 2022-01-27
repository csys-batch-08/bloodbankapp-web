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

import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

@WebServlet("/ShowDonorBookingServlet")
public class ShowDonorBookingServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
          HttpSession session=request.getSession();
		Donor donor = (Donor) session.getAttribute("Donor");
		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();

		List<BookingModel> bookingList = bookingDAOlmpl.ShowBookingDonor(donor);
		request.setAttribute("bookingList", bookingList);
		RequestDispatcher  dispatcher=request.getRequestDispatcher("ShowBooking.jsp");
		dispatcher.forward(request, response);

		
		
	}


}