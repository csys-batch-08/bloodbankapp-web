package com.BloodBankProject.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.BillingDAOlmpl;
import com.bloodbank.model.BillingModel;

@WebServlet("/ShowForBillingDateServlet")
public class ShowForBillingDateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocalDate date = null;

		date = LocalDate.parse(request.getParameter("date"));

		BillingDAOlmpl billingDAOlmpl = new BillingDAOlmpl();

		List<BillingModel> billingList = billingDAOlmpl.biilingShowAdminDate(date);
		request.setAttribute("billingList", billingList);

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("showBillDateAdmin.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

}
