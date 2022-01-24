package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SeekerRigester
 */
@WebServlet("/SeekerRigester")
public class SeekerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeekerRegisterServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastName");
		String address = request.getParameter("address");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		Long PATIENT = Long.parseLong(request.getParameter("PATIENT"));
		String HOSPITAL = request.getParameter("HOSPITAL");
		String bloodtype = request.getParameter("bloodtype");
		String password = request.getParameter("PASSWORD");

		SeekerDetails seeker = new SeekerDetails(firstname, lastname, address, phoneNumber, password, PATIENT, HOSPITAL,
				bloodtype);
		// System.out.println("Seeker register"+seeker);
		SeekerDAOlmpl Dao = new SeekerDAOlmpl();

		Long phone = Dao.PhoneNumberValid(phoneNumber);
		try {
			if (phone == null) {
				// Dao.insertSeekerDetails(seeker);
				if (Dao.insertSeekerDetails(seeker) > 0) {

					PrintWriter pw = response.getWriter();

					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Register success');");
					pw.println("location='SeekerLogin.jsp';");
					pw.println("</script>");
					// response.sendRedirect("SeekerLogin.jsp");

				}
			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			HttpSession session = request.getSession();
			session.setAttribute("phoneNumber", e.PhoneNumber());

			response.sendRedirect("Seeker.jsp");
		}

	}

}
