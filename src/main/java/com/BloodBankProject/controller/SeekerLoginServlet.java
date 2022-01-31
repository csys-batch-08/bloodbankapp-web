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

@WebServlet("/SeekerLoginServlet")
public class SeekerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(); 
		PrintWriter writer = response.getWriter();

		String password = request.getParameter("PASSWORD");
		Long phoneNumber = Long.parseLong(request.getParameter("number"));
		
		session.setAttribute("SeekerPhoneNumber", phoneNumber);
		
		SeekerDetails seekerDetails = null;
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();

		seekerDetails = seekerDAOlmpl.seekerObject(password, phoneNumber);

		try {
			if (seekerDetails != null) {

				session.setAttribute("seeker", seekerDetails);

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Login success');");
				writer.println("location='requestIndex.jsp';");
				writer.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}

		} catch (ExeceptionHandle e) {

			request.setAttribute("SeekerError", e.seekerMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher("seekerLogin.jsp");
            dispatcher.forward(request, response);
			

		}

	}

}
