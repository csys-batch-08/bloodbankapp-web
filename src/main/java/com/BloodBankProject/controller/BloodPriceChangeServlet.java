package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.BloodStackDAOlmpl;

@WebServlet("/BloodPriceChangeServlet")
public class BloodPriceChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bloodtype = request.getParameter("bloodtype");
		double bloodPrice = 0;
		try {
			bloodPrice = Double.parseDouble(request.getParameter("Price"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
		BloodStackDAOlmpl bloodStackDAOlmpl = new BloodStackDAOlmpl();
		if (bloodStackDAOlmpl.bloodPriceChange(bloodtype, bloodPrice) > 0) {

			request.setAttribute("priceChange", "priceChange");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShowStakServlet");
			dispatcher.forward(request, response);

		}

	}

}
