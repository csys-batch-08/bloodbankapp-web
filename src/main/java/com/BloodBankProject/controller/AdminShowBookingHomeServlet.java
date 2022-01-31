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

@WebServlet("/AdminShowBookingHomeServlet")
public class AdminShowBookingHomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();

		List<BookingModel> bookingList = bookingDAOlmpl.homeCollection();
		request.setAttribute("bookingList", bookingList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminShowBookingHome.jsp");
		dispatcher.forward(request, response);

	}

}
