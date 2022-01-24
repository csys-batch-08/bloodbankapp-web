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

import com.bloodbank.Dao.DonorDAO;
import com.bloodbank.DaoImpl.DonorDAOImpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginDonorServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		// System.out.println("sdfghjkl");
		Long aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		// Donor donor =new Donor();
		DonorDAOImpl donorDao = new DonorDAOImpl();
		// System.out.println(aadharcard);

		Donor donor = donorDao.validAadharcardNumber(aadharcard);
		// System.out.println(donor.getAddress()+"cvbnm");
		try {

			if (donor != null) {
				// System.out.println("dfghjnmk,l");
				HttpSession session = request.getSession();
				session.setAttribute("Donor", donor);

				// System.out.println(donor.getAddress()+"longin");

				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Login success');");
				pw.println("location='PhysicalCheck.jsp';");
				pw.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			HttpSession session = request.getSession();
			session.setAttribute("DonorError", e.DonorMessage());
			response.sendRedirect("DonorLogin.jsp");
		}

	}

}
