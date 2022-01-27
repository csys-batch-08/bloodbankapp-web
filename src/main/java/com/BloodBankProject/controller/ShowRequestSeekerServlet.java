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

import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

@WebServlet("/ShowRequestSeekerServlet")
public class ShowRequestSeekerServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();
	
		HttpSession session = request.getSession();
		SeekerDetails seeker = (SeekerDetails) session.getAttribute("seeker");
		List<RequestModel> requestList =requestDAOlmpl.ShowRequestSeeker(seeker.getPhoneNumber());
		request.setAttribute("requestList", requestList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowRequestSeeker.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
