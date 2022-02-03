package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		PrintWriter writer = response.getWriter();

		writer.println("<script type=\"text/javascript\">");
		writer.println("alert('are you delete now');");
		// writer.println("location='index.jsp';");
		writer.println("</script>");

		if (bookingDAOlmpl.deleteBooking(donor.getAadharcard()) > 0) {

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Request deleted ');");
			writer.println("location='index.jsp';");
			writer.println("</script>");
		}
	}

}
