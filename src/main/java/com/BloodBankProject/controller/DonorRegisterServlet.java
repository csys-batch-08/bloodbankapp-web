package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/Register")
public class DonorRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastName");

		String address = request.getParameter("address");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		Long aadharcard = Long.parseLong(request.getParameter("ADHARCARD"));
		String bloodType = request.getParameter("bloodtype");

		try {

			date = sdf.parse(request.getParameter("bio"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		PrintWriter writer = response.getWriter();
		DonorDAOImpl donorDAOImpl = new DonorDAOImpl();
		Donor donor = donorDAOImpl.validAadharcardNumber(aadharcard);

		try {
			if (donor == null) {

				donor = new Donor(firstName, lastName, address, aadharcard, phoneNumber, date, bloodType);

				if (donorDAOImpl.insertDonor(donor) > 0) {

					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('Register success');");
					writer.println("location='donorLogin.jsp';");
					writer.println("</script>");

				}

			} else {

				throw new ExeceptionHandle();

			}

		} catch (ExeceptionHandle e) {

			request.setAttribute("aadharcardNumber", e.aadharcardNumber());
			RequestDispatcher dispatcher = request.getRequestDispatcher("donorRegister.jsp");
			dispatcher.forward(request, response);

		}

	}

}
