package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.SeekerDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.SeekerDetails;

@WebServlet("/SeekerRigester")
public class SeekerRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastName");
		String address = request.getParameter("address");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		Long patient = Long.parseLong(request.getParameter("PATIENT"));
		String hospital = request.getParameter("HOSPITAL");
		String bloodtype = request.getParameter("bloodtype");
		String password = request.getParameter("PASSWORD");

		SeekerDetails seekerDetails = new SeekerDetails(firstname, lastname, address, phoneNumber, password, patient,
				hospital, bloodtype);

		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();

		try {
			if (seekerDAOlmpl.phoneNumberValid(phoneNumber) == null) {

				if (seekerDAOlmpl.insertSeekerDetails(seekerDetails) > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("seekerLogin.jsp?registerSucces=sucess");
					dispatcher.forward(request, response);

				}
			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			request.setAttribute("phoneNumber", e.phoneNumber());
			RequestDispatcher dispatcher = request.getRequestDispatcher("seekerRegister.jsp");
			dispatcher.forward(request, response);

		}

	}

}
