package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.zone.ZoneRulesException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BloodDetailsDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.DaoImpl.DonorDAOImpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

@WebServlet("/BloodBookingServlet")
public class BloodBookingServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocalDate date = null;
		String address = request.getParameter("address");

		String choice = request.getParameter("Choice");

		BookingDAOlmpl  bookingDAOlmpl = new BookingDAOlmpl();
		PrintWriter  writer = response.getWriter();
		try {
			date = LocalDate.parse(request.getParameter("bookingDate"));

			HttpSession  session = request.getSession();

			Donor donor = (Donor) session.getAttribute("Donor");

			AdminDAOlmpl   adminDAOlmpl = new AdminDAOlmpl();
               // check the date for Donor validation
			LocalDate date1 = bookingDAOlmpl.dateCheck(donor);

			
                   //check the amount in ADMIN wallet to above 300 to Allowed
		
			//Donor once Donated to come next Donate check the last Donating Date to  90day  after  come to allow

			if (date1 != null && date.isAfter(date1) && adminDAOlmpl.CheckWallet() > 300) {
				
				
				
				//User select by Center Address is Null  On time work this condition
				if (address.isEmpty()) {

					String address2 = "1/71 Gokula Nagar ,Devipattinam," + "ramanathapuram," + "pincode:623513";
					BookingModel bookingModel  = new BookingModel(donor, address2, date, donor.getBloodType(), choice);
					session.setAttribute("bookingDate", bookingModel);

					

					if (bookingDAOlmpl.booking(bookingModel)> 0) {

						writer.println("<script type=\"text/javascript\">");
						writer.println("alert('Booking Successfully');");
						writer.println("location='BookingProcess.jsp';");
						writer.println("</script>");
						
					}

				}

				else {

					//User select by Home  On time work this condition

					BookingModel bookingModel  = new BookingModel(donor, address, date, donor.getBloodType(), choice);
					session.setAttribute("bookingDate", bookingModel);
					

					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						writer.println("<script type=\"text/javascript\">");
						writer.println("alert('Booking Successfully');");
						writer.println("location='BookingProcess.jsp';");
						writer.println("</script>");
						// response.sendRedirect("");
						// System.out.println("Hello Peter");
						// response.sendRedirect("BookingProcess.jsp");

					}

				}
			}
			 //check the amount in ADMIN wallet to above 300 to Allowed
			
			else if (date1 == null && adminDAOlmpl.CheckWallet() > 300) {
				
				//User select by Center Address is Null  On time work this condition
				
				if (address.isEmpty()) {

					String address2 = "1/71 Gokula Nagar ,Devipattinam," + "ramanathapuram," + "pincode:623513";

					BookingModel  bookingModel = new BookingModel(donor, address2, date, donor.getBloodType(), choice);
					session.setAttribute("bookingDate", bookingModel);

					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						

						writer.println("<script type=\"text/javascript\">");
						writer.println("alert('Booking Successfully');");
						writer.println("location='BookingProcess.jsp';");
						writer.println("</script>");

						// System.out.println("Hello Peter");

						// response.sendRedirect("BookingProcess.jsp");

					}

				} else {
					//User select by Home  On time work this condition

					BookingModel bookingModel = new BookingModel(donor, address, date, donor.getBloodType(), choice);
					session.setAttribute("bookingDate", bookingModel);
					
					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						

						writer.println("<script type=\"text/javascript\">");
						writer.println("alert('Booking Successfully');");
						writer.println("location='BookingProcess.jsp';");
						writer.println("</script>");
						//System.out.println("Hello Peter 2");
						// response.sendRedirect("BookingProcess.jsp");

					}

				}

				
				//User Not Qualified by Blood Donate to Exit
			} else {

				
				
			

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('your previous donated date is with in 90 days,so please donate after 90 days ');");
				writer.println("location='NotQualified.jsp';");
				writer.println("</script>");
				
				
				// System.out.println("Joh Wick");
				// response.sendRedirect("BookingProcess.jsp");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
