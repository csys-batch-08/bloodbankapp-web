package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		PrintWriter writer = response.getWriter();

		Long aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		HttpSession session = request.getSession();
		DonorDAOImpl donorDAOImpl = new DonorDAOImpl();

		Donor donor = donorDAOImpl.validAadharcardNumber(aadharcard);

		try {

			if (donor != null) {
				request.setAttribute("Login", "Success");
				session.setAttribute("Donor", donor);
				RequestDispatcher dispatcher = request.getRequestDispatcher("donorCheckUp.jsp");
				dispatcher.forward(request, response);
//
//
//				writer.println("<script type=\"text/javascript\">");
//				writer.println("alert('Login success');");
//				writer.println("location='donorCheckUp.jsp';");
//				writer.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			request.setAttribute("DonorError", e.donorMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("donorLogin.jsp");
			dispatcher.forward(request, response);
		}

	}

}
