package com.BloodBankProject.controller;

import java.io.IOException;
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
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 * 
	 *      /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("welcome gowtham");

		SeekerDAOlmpl Dao = new SeekerDAOlmpl();
		String password1 = request.getParameter("CONFIRM");
		String password2 = request.getParameter("PASSWORD");

		Long PhoneNumber = Long.parseLong(request.getParameter("number"));

		// System.out.println(PhoneNumber+"gowtham");

		HttpSession session = request.getSession();

		try {

			if (Dao.PhoneNumberValid(PhoneNumber) != null) {

				try {

					if (password1.equals(password2)) {

						// Long phoneNumber= (Long) request.getAttribute("SeekerPhoneNumber");

						Dao.ForgotPassword(PhoneNumber, password2);

						response.sendRedirect("SeekerLogin.jsp");

					} else {
						throw new ExeceptionHandle();

					}
				} catch (ExeceptionHandle e) {

					session.setAttribute("PasswordError", e.ForgotPassword());

					response.sendRedirect("Forgotpassword.jsp");

				}

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			session.setAttribute("numbererror", e.SeekerPhoneNumberFind());

			response.sendRedirect("Forgotpassword.jsp");

		}

	}

}
