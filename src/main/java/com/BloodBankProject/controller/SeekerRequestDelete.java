package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;

@WebServlet("/SeekerRequestDelete")
public class SeekerRequestDelete extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();
		
		if(requestDAOlmpl.aadharcardValid(aadharcard)!=null) {
		
		
		
	
		if(requestDAOlmpl.statusCheck(aadharcard).equals("approved")) {
     
			

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('can t delete the request it is approved');");
			writer.println("location='showSeekerRequest.jsp';");
			writer.println("</script>");
                
			
			
		

			
	}else {

		
		if (requestDAOlmpl.deleteRequest(aadharcard) > 0) {


			

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Request cancel');");
			writer.println("location='requestIndex.jsp';");
			writer.println("</script>");

			
			session.setAttribute("seeker", null);

		}
		
		}
		}else{
			
			

			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('invalid Aadharcard ');");
			writer.println("location='requestCancel.jsp';");
			writer.println("</script>");
			
		}

	}
		

}
