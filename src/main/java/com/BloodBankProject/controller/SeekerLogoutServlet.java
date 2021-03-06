package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SeekerLogoutServlet")
public class SeekerLogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// seeker logout
		session.setAttribute("seeker", null);
		session.setAttribute("requestModel", null);
		session.setAttribute("biilingProces", null);
		response.sendRedirect("index.jsp");

	}

}
