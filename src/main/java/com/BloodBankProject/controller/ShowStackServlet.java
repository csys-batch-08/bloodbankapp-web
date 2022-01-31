package com.BloodBankProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.model.BloodStack;

@WebServlet("/ShowStakServlet")
public class ShowStackServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		BloodStackDAOlmpl bloodStackDAOlmpl= new BloodStackDAOlmpl();

	
		List<BloodStack> stockDetails = bloodStackDAOlmpl.showStack();
		
		request.setAttribute("stockList", stockDetails);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("showStack.jsp");
		dispatcher.forward(request, response);
	
	}
}
