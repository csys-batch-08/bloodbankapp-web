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

@WebServlet("/login")
public class LoginDonorServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		Long aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		HttpSession session = request.getSession();
		DonorDAOImpl donorDAOImpl = new DonorDAOImpl();
		// System.out.println(aadharcard);
		// Donor donor =new Donor();
		
		Donor donor = donorDAOImpl.validAadharcardNumber(aadharcard);
		
		
		try {

			if (donor != null) {
				
				// System.out.println("dfghjnmk,l");
			
				session.setAttribute("Donor", donor);

				// System.out.println(donor.getAddress()+"longin");

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Login success');");
				writer.println("location='PhysicalCheck.jsp';");
				writer.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			
			request.setAttribute("DonorError", e.DonorMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher("DonorLogin.jsp");
			dispatcher.forward(request, response);
		}

	}

}
