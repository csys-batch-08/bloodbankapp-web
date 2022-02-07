package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.RequestDAOlmpl;

@WebServlet("/SeekerRequestDelete")
public class SeekerRequestDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final String APPROVED = "approved";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bloodType = request.getParameter("bloodtype");
		Long aadharcardNumber = null;
		try {
			aadharcardNumber = Long.parseLong(request.getParameter("ADHARCARD"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();

		if (requestDAOlmpl.aadharcardValid(aadharcardNumber) != null) {

			if (requestDAOlmpl.statusCheck(aadharcardNumber, bloodType).equals(APPROVED)) {

				request.setAttribute(APPROVED, APPROVED);
				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("ShowRequestSeekerServlet");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			} else {

				if (requestDAOlmpl.deleteRequest(aadharcardNumber, bloodType) > 0) {

					request.setAttribute("Requestcancel", "Requestcancel");
					try {
						RequestDispatcher dispatcher = request.getRequestDispatcher("ShowRequestSeekerServlet");
						dispatcher.forward(request, response);
					} catch (ServletException | IOException e) {

						e.printStackTrace();
					}

					session.setAttribute("seeker", null);

				}

			}
		} else {
			request.setAttribute("InvalidAadharcardNumber", "InvalidAadharcardNumber");
			try {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("ShowRequestSeekerServlet?InvalidAadharcardNumber");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}

		}

	}

}
