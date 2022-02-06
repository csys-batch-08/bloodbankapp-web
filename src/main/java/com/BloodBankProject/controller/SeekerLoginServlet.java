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
import com.bloodbank.model.SeekerDetails;

@WebServlet("/SeekerLoginServlet")
public class SeekerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String password = request.getParameter("PASSWORD");
		Long phoneNumber = null;
		try {
			phoneNumber = Long.parseLong(request.getParameter("number"));
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		}

		session.setAttribute("SeekerPhoneNumber", phoneNumber);

		SeekerDetails seekerDetails = null;
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();

		seekerDetails = seekerDAOlmpl.seekerObject(password, phoneNumber);

		try {
			if (seekerDetails != null) {

				session.setAttribute("seeker", seekerDetails);

				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("requestIndex.jsp?loginStatus=sucess");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			} else {

				throw new ExeceptionHandle();

			}

		} catch (ExeceptionHandle e) {

			request.setAttribute("SeekerError", e.seekerMessage());
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("seekerLogin.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {

				e1.printStackTrace();
			}

		}

	}

}
