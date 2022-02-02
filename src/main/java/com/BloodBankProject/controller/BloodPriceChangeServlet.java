package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter writer=null;
		try {
			writer = response.getWriter();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
    	String bloodtype=request.getParameter("bloodtype");    	
    	double bloodPrice=0;
		try {
			bloodPrice = Double.parseDouble(request.getParameter("Price"));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}    
    BloodStackDAOlmpl bloodStackDAOlmpl=new BloodStackDAOlmpl();
    if(bloodStackDAOlmpl.bloodPriceChange(bloodtype, bloodPrice)>0) {
    	
    	writer.println("<script type=\"text/javascript\">");
		writer.println("alert('price has been changed');");
		writer.println("location='ShowStakServlet';");
		writer.println("</script>");
    	
    	
    }
    
	}


}
