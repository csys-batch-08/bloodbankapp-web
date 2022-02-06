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

@WebServlet("/Forgotpassword")
public class Forgotpassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();
		String password1 = request.getParameter("CONFIRM");
		String password2 = request.getParameter("PASSWORD");

		Long phoneNumber = null;
		try {
			phoneNumber = Long.parseLong(request.getParameter("number"));
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		}

		try {

			if (seekerDAOlmpl.phoneNumberValid(phoneNumber) != null) {

				try {

					if (password1.equals(password2)) {

						seekerDAOlmpl.forgotPassword(phoneNumber, password2);

						RequestDispatcher dispatcher = request
								.getRequestDispatcher("seekerLogin.jsp?forgotpassword=sucess");
						dispatcher.forward(request, response);

					} else {
						throw new ExeceptionHandle();

					}
				} catch (ExeceptionHandle e) {

					request.setAttribute("PasswordError", e.forgotPassword());

					try {
						RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
						dispatcher.forward(request, response);
					} catch (ServletException | IOException e1) {

						e1.printStackTrace();
					}

				}

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			request.setAttribute("numbererror", e.seekerPhoneNumberFind());

			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {

				e1.printStackTrace();
			}

		}

	}

}
