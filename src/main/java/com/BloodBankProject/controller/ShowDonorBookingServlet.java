package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Donor donor = (Donor) session.getAttribute("Donor");
		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();

		PrintWriter writer = response.getWriter();

		List<BookingModel> bookingList = bookingDAOlmpl.showBookingDonor(donor);
		if (bookingList.isEmpty()) {

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('You are a New Comer');");
			writer.println("location='bloodBookingProcess.jsp';");
			writer.println("</script>");

		} else {
			request.setAttribute("bookingList", bookingList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showDonorBooking.jsp");
			dispatcher.forward(request, response);

		}

	}

}