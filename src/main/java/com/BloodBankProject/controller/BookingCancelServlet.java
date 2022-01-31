package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.BookingDAOlmpl;

@WebServlet("/BookingCancelServlet")
public class BookingCancelServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long aadharcard=null;
		try {
			aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}

		BookingDAOlmpl  bookingDAOlmpl = new BookingDAOlmpl();
		
		
		PrintWriter  writer = response.getWriter();
		
		if (bookingDAOlmpl.deleteBooking(aadharcard) > 0) {

			

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Request deleted ');");
			writer.println("location='index.jsp';");
			writer.println("</script>");
		}else {
			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('invalid Aadharcard Number');");
			writer.println("location='bloodBookingCancel.jsp';");
			writer.println("</script>");
			
		}

	}

}
