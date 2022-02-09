package com.BloodBankProject.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.DonorDAOImpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.Donor;

@WebServlet("/Register")
public class DonorRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastName");

		String address = request.getParameter("address");
		Long phoneNumber = null;
		Long aadharcard = null;
		try {
			phoneNumber = Long.parseLong(request.getParameter("number"));
			aadharcard = Long.parseLong(request.getParameter("ADHARCARD"));

			String bloodType = request.getParameter("bloodtype");

			date = sdf.parse(request.getParameter("bio"));

			DonorDAOImpl donorDAOImpl = new DonorDAOImpl();
			Donor donor = donorDAOImpl.validAadharcardNumber(aadharcard);
			// Donor is null new donor register

			if (donor == null) {

				donor = new Donor(firstName, lastName, address, aadharcard, phoneNumber, date, bloodType);

				if (donorDAOImpl.insertDonor(donor) > 0) {

					try {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("donorLogin.jsp?registerSucces=sucess");
						dispatcher.forward(request, response);
					} catch (ServletException | IOException e) {

						e.printStackTrace();
					}
				}

				else {
					try {

						throw new ExeceptionHandle();
					} catch (ExeceptionHandle e) {

						request.setAttribute("aadharcardNumber", e.aadharcardNumber());

						try {
							RequestDispatcher dispatcher = request.getRequestDispatcher("donorRegister.jsp");
							dispatcher.forward(request, response);
						} catch (ServletException | IOException e1) {

							e1.printStackTrace();
						}

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}