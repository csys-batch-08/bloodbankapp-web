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

@WebServlet("/SeekerRigester")
public class SeekerRegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastName");
		String address = request.getParameter("address");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		Long PATIENT = Long.parseLong(request.getParameter("PATIENT"));
		String HOSPITAL = request.getParameter("HOSPITAL");
		String bloodtype = request.getParameter("bloodtype");
		String password = request.getParameter("PASSWORD");

		SeekerDetails seekerDetails = new SeekerDetails(firstname, lastname, address, phoneNumber, password, PATIENT, HOSPITAL,
				bloodtype);
		// System.out.println("Seeker register"+seeker);
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();
		PrintWriter writer = response.getWriter();
		
		
		try {
			if (seekerDAOlmpl.PhoneNumberValid(phoneNumber) == null) {
				// Dao.insertSeekerDetails(seeker);
				if (seekerDAOlmpl.insertSeekerDetails(seekerDetails) > 0) {

				

					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('Register success');");
					writer.println("location='SeekerLogin.jsp';");
					writer.println("</script>");
					// response.sendRedirect("SeekerLogin.jsp");

				}
			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			
			request.setAttribute("phoneNumber", e.PhoneNumber());
           RequestDispatcher dispatcher=request.getRequestDispatcher("Seeker.jsp");
           dispatcher.forward(request, response);
			
		}

	}

}
