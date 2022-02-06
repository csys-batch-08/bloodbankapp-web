package com.BloodBankProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.BillingDAOlmpl;
import com.bloodbank.model.BillingModel;

@WebServlet("/ShowBillingAdminServlet")
public class ShowBillingAdminServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		BillingDAOlmpl billingDAOlmpl = new BillingDAOlmpl();

		List<BillingModel> billingList = billingDAOlmpl.biilingShowAdmin();
		request.setAttribute("billingList", billingList);

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("showBillAdminjsp.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

}
