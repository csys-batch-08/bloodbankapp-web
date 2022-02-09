package com.BloodBankProject.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

@WebServlet("/BloodBookingServlet")
public class BloodBookingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final String LOCALDATE = "bookingDate";
	static final String LOCATION = "BookingProcess.jsp?bookingStatus=sucess";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String address = request.getParameter("address");

		String choice = request.getParameter("Choice");

		BookingDAOlmpl bookingDAOlmpl = new BookingDAOlmpl();

		LocalDate date = null;
		try {
			date = LocalDate.parse(request.getParameter(LOCALDATE));
		} catch (NullPointerException e) {

			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		Donor donor = (Donor) session.getAttribute("Donor");

		AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();
		// check the date for Donor validation

		try {

			LocalDate date1 = bookingDAOlmpl.dateCheck(donor);

			if (date1 != null && date.isAfter(date1) && adminDAOlmpl.checkWallet() > 300) {

				// User select by Center Address is Null On time work this condition
				if (address.isEmpty()) {

					String address2 = "1/71 Gokula Nagar ,Devipattinam," + "ramanathapuram," + "pincode:623513";
					BookingModel bookingModel = new BookingModel(donor, address2, date, donor.getBloodType(), choice);

					session.setAttribute(LOCALDATE, bookingModel);

					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						try {
							RequestDispatcher dispatcher = request.getRequestDispatcher(LOCATION);
							dispatcher.forward(request, response);
						} catch (ServletException | IOException e) {

							e.printStackTrace();
						}

					}

				}

				else {

					// User select by Home On time work this condition

					BookingModel bookingModel = new BookingModel(donor, address, date, donor.getBloodType(), choice);
					session.setAttribute(LOCALDATE, bookingModel);

					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						try {
							RequestDispatcher dispatcher = request.getRequestDispatcher(LOCATION);
							dispatcher.forward(request, response);
						} catch (ServletException | IOException e) {

							e.printStackTrace();
						}

					}

				}
			}
			// check the amount in ADMIN wallet to above 300 to Allowed

			else if (date1 == null && adminDAOlmpl.checkWallet() > 300) {

				// User select by Center Address is Null On time work this condition

				if (address.isEmpty()) {

					String address2 = "1/71 Gokula Nagar ,Devipattinam," + "ramanathapuram," + "pincode:623513";

					BookingModel bookingModel = new BookingModel(donor, address2, date, donor.getBloodType(), choice);
					session.setAttribute(LOCALDATE, bookingModel);

					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						try {
							RequestDispatcher dispatcher = request.getRequestDispatcher(LOCATION);
							dispatcher.forward(request, response);
						} catch (ServletException | IOException e) {

							e.printStackTrace();
						}
					}

				} else {
					// User select by Home On time work this condition

					BookingModel bookingModel = new BookingModel(donor, address, date, donor.getBloodType(), choice);
					session.setAttribute(LOCALDATE, bookingModel);

					if (bookingDAOlmpl.booking(bookingModel) > 0) {

						try {
							RequestDispatcher dispatcher = request.getRequestDispatcher(LOCATION);
							dispatcher.forward(request, response);
						} catch (ServletException | IOException e) {

							e.printStackTrace();
						}

					}

				}

			} else {

				try {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("donorNotQualified.jsp?bookingDate=sucess");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		// check the amount in admin wallet to above 300 to Allowed

		// Donor once donated to come next Donate check the last Donating Date to 90day
		// after come to allow

	}

}
