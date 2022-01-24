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

/**
 * Servlet implementation class SeekerRequestDelete
 */
@WebServlet("/SeekerRequestDelete")
public class SeekerRequestDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeekerRequestDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long aadharcard = Long.parseLong(request.getParameter("aadharcard"));
		
		PrintWriter pw = response.getWriter();
		RequestDAOlmpl dao = new RequestDAOlmpl();
		
		if(dao.AadharcardValid(aadharcard)!=null) {
		
		String status=dao.StatusCheck(aadharcard);
		
	
		if(status.equals("approved")) {
     
			

			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('can t delete the request it is approved');");
			pw.println("location='ShowRequestSeeker.jsp';");
			pw.println("</script>");
                
			
			
		

			
	}else {

		
		if (dao.deleteRequest(aadharcard) > 0) {


			

			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Request cancel');");
			pw.println("location='RequestIndex.jsp';");
			pw.println("</script>");

			HttpSession htp = request.getSession();
			htp.setAttribute("seeker", null);

		}
		
		}
		}else{
			
			

			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('invalid Aadharcard ');");
			pw.println("location='RequestCancel.jsp';");
			pw.println("</script>");
			
		}

	}
		

}
