package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DonorLogoutServlet")
public class DonorLogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Donor logout
		HttpSession session = request.getSession();
		session.setAttribute("Donor", null);
		session.setAttribute("currentModel", null);
		response.sendRedirect("index.jsp");
	}

}
