package com.BloodBankProject.controller;

import java.io.IOException;

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

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email");
		String password = request.getParameter("password");
		AdminModel adminModel = new AdminModel(username, password, 0);
		AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();

		if (adminDAOlmpl.verificationAdmin(adminModel) != null) {

			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("adminWork.jsp?loginStatus=sucess");
				dispatcher.forward(request, response);

			} catch (IOException | ServletException e) {

				e.printStackTrace();
			}

		} else {

			try {
				throw new ExeceptionHandle();
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

}
