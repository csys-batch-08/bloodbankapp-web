package com.BloodBankProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.model.BookingModel;

@WebServlet("/AdminShowBookingServlet")
public class AdminShowBookingServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();

		List<BookingModel> bookingList = bookingDAOlmpl.ShowBookingAdmin();

		request.setAttribute("bookingList", bookingList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("AdminShowBooking.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
	}

	
	

}
