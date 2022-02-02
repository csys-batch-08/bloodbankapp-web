package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.AdminModel;

@WebServlet("/AdminController")
public class AdminServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String username = request.getParameter("email");
		String password = request.getParameter("password");
		AdminModel adminModel = new AdminModel(username, password, 0);
		AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();
		try {

			if (adminDAOlmpl.verificationAdmin(adminModel) != null) {

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Login success');");
				writer.println("location='adminWork.jsp';");
				writer.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			try {
				request.setAttribute("error", e.adminMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminLogin.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {

				e1.printStackTrace();
			}

		}

	}

}
