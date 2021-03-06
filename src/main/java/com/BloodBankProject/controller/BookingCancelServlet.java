package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.model.Donor;

@WebServlet("/BookingCancelServlet")
public class BookingCancelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Donor donor = (Donor) session.getAttribute("Donor");

		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();
		// Donor cancel the booking
		if (bookingDAOlmpl.deleteBooking(donor.getAadharcard()) > 0) {

			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?RequestDeleted=sucess");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
		}
	}

}
