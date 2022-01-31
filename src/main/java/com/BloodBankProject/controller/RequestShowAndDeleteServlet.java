package com.BloodBankProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.model.RequestModel;

@WebServlet("/RequestShowAndDeleteServlet")
public class RequestShowAndDeleteServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();
		List<RequestModel> requestList = requestDAOlmpl.requestUpdateAndDelete();
		 request.setAttribute("requestList",requestList );
		RequestDispatcher dispatcher=request.getRequestDispatcher("requestShowAndDeleteAdmin.jsp");
	   dispatcher.forward(request, response);
	    
	
	}


}
