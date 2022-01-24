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

import com.bloodbank.DaoImpl.SeekerDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.SeekerDetails;

/**
 * Servlet implementation class SeekerLoginServlet
 */
@WebServlet("/SeekerLoginServlet")
public class SeekerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeekerLoginServlet() {
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

		String password = request.getParameter("PASSWORD");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		HttpSession session = request.getSession();
		session.setAttribute("SeekerPhoneNumber", phoneNumber);
		SeekerDetails seeker = new SeekerDetails();
		SeekerDAOlmpl dao = new SeekerDAOlmpl();

		seeker = dao.seekerObject(password, phoneNumber);

		try {
			if (seeker != null) {

				session.setAttribute("seeker", seeker);

				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Login success');");
				pw.println("location='RequestIndex.jsp';");
				pw.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}

		} catch (ExeceptionHandle e) {

			session.setAttribute("SeekerError", e.SeekerMessage());

			response.sendRedirect("SeekerLogin.jsp");

		}

	}

}
