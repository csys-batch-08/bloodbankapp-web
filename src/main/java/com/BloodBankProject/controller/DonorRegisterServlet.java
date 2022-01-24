package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.DonorDAOImpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonorRegisterServlet() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastName");
		// String email = request.getParameter("email");
		String address = request.getParameter("address");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		Long aadharcard = Long.parseLong(request.getParameter("ADHARCARD"));
		String bloodType = request.getParameter("bloodtype");

		try {

			date = sdf.parse(request.getParameter("bio"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DonorDAOImpl donorDao = new DonorDAOImpl();
		Donor donor1 = donorDao.validAadharcardNumber(aadharcard);
		try {
			if (donor1 == null) {

				Donor donor = new Donor(firstName, lastName, address, aadharcard, phoneNumber, date, bloodType);

				int check = donorDao.insertDonor(donor);

				if (check > 0) {

					PrintWriter pw = response.getWriter();
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Register success');");
					pw.println("location='DonorLogin.jsp';");
					pw.println("</script>");
					// response.sendRedirect("DonorLogin.jsp");

				}

			} else {

				throw new ExeceptionHandle();

			}

		} catch (ExeceptionHandle e) {

			HttpSession session = request.getSession();
			session.setAttribute("aadharcardNumber", e.AadharcardNumber());

			response.sendRedirect("DonorRegister.jsp");
		}

	}

}
