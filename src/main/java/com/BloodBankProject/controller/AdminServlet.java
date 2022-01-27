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

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.AdminModel;

@WebServlet("/AdminController")
public class AdminServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  writer = response.getWriter();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		AdminModel  adminModel = new AdminModel(username, password, 0);
		AdminDAOlmpl  adminDAOlmpl = new AdminDAOlmpl();
		try {
			 //ADMIN Email and password validation
			if (adminDAOlmpl.verificationAdmin(adminModel) != null) {

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Login success');");
				writer.println("location='AdminWork.jsp';");
				writer.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

		
			request.setAttribute("error", e.AdminMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);
			

		}

	}

}
