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

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		AdminModel model = new AdminModel(username, password, 0);
		AdminDAOlmpl Dao = new AdminDAOlmpl();
		try {
			 //ADMIN Email and password validation
			if (Dao.verificationAdmin(model) != null) {

				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Login success');");
				pw.println("location='AdminWork.jsp';");
				pw.println("</script>");

			} else {

				throw new ExeceptionHandle();

			}
		} catch (ExeceptionHandle e) {

			HttpSession session = request.getSession();
			session.setAttribute("error", e.AdminMessage());
			response.sendRedirect("Adminlogin.jsp");

		}

	}

}
