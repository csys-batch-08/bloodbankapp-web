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

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();

		// Show booking details for admin

		List<BookingModel> bookingList = bookingDAOlmpl.showBookingAdmin();

		request.setAttribute("bookingList", bookingList);

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminShowBooking.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

}
