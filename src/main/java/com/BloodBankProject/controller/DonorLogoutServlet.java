package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DonorLogoutServlet")
public class DonorLogoutServlet extends HttpServlet {
	  
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		session.setAttribute("Donor", null);
		session.setAttribute("currentModel", null);

		PrintWriter writer = response.getWriter();

		writer.println("<script type=\"text/javascript\">");
		writer.println("alert('Logout success');");
		writer.println("location='index.jsp';");
		writer.println("</script>");
		// response.sendRedirect("index.jsp");
	}


}
