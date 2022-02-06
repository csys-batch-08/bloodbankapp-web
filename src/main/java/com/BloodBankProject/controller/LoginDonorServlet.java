package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.DonorDAOImpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.Donor;

@WebServlet("/login")
public class LoginDonorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long aadharcard = null;
		try {
			aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		}

		HttpSession session = request.getSession();
		DonorDAOImpl donorDAOImpl = new DonorDAOImpl();

		Donor donor = donorDAOImpl.validAadharcardNumber(aadharcard);

		try {

			if (donor != null) {
				request.setAttribute("Login", "Success");
				session.setAttribute("Donor", donor);

				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("donorCheckUp.jsp?loginStatus=sucess");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			request.setAttribute("DonorError", e.donorMessage());

			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("donorLogin.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {

				e1.printStackTrace();
			}
		}

	}

}
