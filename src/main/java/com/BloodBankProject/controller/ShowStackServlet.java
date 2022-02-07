package com.BloodBankProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.model.BloodStack;

@WebServlet("/ShowStakServlet")
public class ShowStackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BloodStackDAOlmpl bloodStackDAOlmpl = new BloodStackDAOlmpl();
		// Show the stack details in admin
		List<BloodStack> stackDetails = bloodStackDAOlmpl.showStack();
		// Stack blood price change to show the stack details
		if (request.getAttribute("priceChange") != null) {

			request.setAttribute("stackDetails", stackDetails);

			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("showStack.jsp?priceChange=sucess");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}

		} else {

			try {
				request.setAttribute("stackDetails", stackDetails);

				RequestDispatcher dispatcher = request.getRequestDispatcher("showStack.jsp");
				dispatcher.forward(request, response);

			} catch (IOException | ServletException e) {

				e.printStackTrace();
			}
		}
	}
}
