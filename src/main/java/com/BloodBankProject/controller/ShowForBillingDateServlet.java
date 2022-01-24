package com.BloodBankProject.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowForBillingDateServlet
 */
@WebServlet("/ShowForBillingDateServlet")
public class ShowForBillingDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowForBillingDateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		LocalDate date = null;

		// date=sdf.parse(request.getParameter("date"));
		date = LocalDate.parse(request.getParameter("date"));

		// System.out.println(date);
		HttpSession session = request.getSession();

		session.setAttribute("billingdate", date);

		response.sendRedirect("ShowForBillingDate.jsp");

	}

}
