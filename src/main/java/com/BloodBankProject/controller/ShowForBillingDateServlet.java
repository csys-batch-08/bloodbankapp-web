package com.BloodBankProject.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.BillingDAOlmpl;
import com.bloodbank.model.BillingModel;

@WebServlet("/ShowForBillingDateServlet")
public class ShowForBillingDateServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		LocalDate date = null;

		// date=sdf.parse(request.getParameter("date"));
		date = LocalDate.parse(request.getParameter("date"));

		// System.out.println(date);
	

		BillingDAOlmpl billingDAOlmpl = new BillingDAOlmpl();
		
		List<BillingModel> billingList = billingDAOlmpl.biilingShowAdminDate(date);
		request.setAttribute("billingList", billingList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowForBillingDate.jsp");
	     dispatcher.forward(request, response);
		

		

	}

}
