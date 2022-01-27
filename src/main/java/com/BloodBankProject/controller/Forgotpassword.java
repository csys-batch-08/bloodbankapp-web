package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.SeekerDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;

@WebServlet("/Forgotpassword")
public class Forgotpassword extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("welcome gowtham");

		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();
		String password1 = request.getParameter("CONFIRM");
		String password2 = request.getParameter("PASSWORD");

		Long PhoneNumber = Long.parseLong(request.getParameter("number"));

		// System.out.println(PhoneNumber+"gowtham");

		try {

			if (seekerDAOlmpl.PhoneNumberValid(PhoneNumber) != null) {

				try {

					if (password1.equals(password2)) {

						// Long phoneNumber= (Long) request.getAttribute("SeekerPhoneNumber");

						seekerDAOlmpl.ForgotPassword(PhoneNumber, password2);

						response.sendRedirect("SeekerLogin.jsp");

					} else {
						throw new ExeceptionHandle();

					}
				} catch (ExeceptionHandle e) {

					request.setAttribute("PasswordError", e.ForgotPassword());
					RequestDispatcher dispatcher = request.getRequestDispatcher("Forgotpassword.jsp");
					dispatcher.forward(request, response);

				}

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			request.setAttribute("numbererror", e.SeekerPhoneNumberFind());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Forgotpassword.jsp");
			dispatcher.forward(request, response);

		}

	}

}
