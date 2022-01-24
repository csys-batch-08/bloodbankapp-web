package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class BookingChangeServlet
 */
@WebServlet("/BookingChangeServlet")
public class BookingChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocalDate BookingDate = null;
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String address = request.getParameter("address");
		String choice = request.getParameter("Choice");

		try {
			String BookingDateStr = request.getParameter("bookingDate");
			BookingDate = LocalDate.parse(BookingDateStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		HttpSession htp = request.getSession();
		Donor donor = (Donor) htp.getAttribute("Donor");
		// System.out.println("sorry"+donor.getFirstName());

		if (address != null) {

			BookingModel model = new BookingModel(donor, address, BookingDate, donor.getBloodType(), choice);
			BookingDAOlmpl Dao = new BookingDAOlmpl();
			if (Dao.updateBooking(model) > 0) {

				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Booking changed');");
				pw.println("location='BookingProcess.jsp';");
				pw.println("</script>");

				// response.sendRedirect("BookingProcess.jsp");

			}
		} else {

			// System.out.println("jo"+donor.getAddress());
			String address1 = donor.getAddress();
			BookingModel model = new BookingModel(donor, address1, BookingDate, donor.getBloodType(), choice);
			BookingDAOlmpl Dao = new BookingDAOlmpl();
			if (Dao.updateBooking(model) > 0) {

				// response.sendRedirect("");

				// PrintWriter pw=response.getWriter();

				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Booking changed');");
				pw.println("location='BookingProcess.jsp';");
				pw.println("</script>");

			}
		}

	}

}
