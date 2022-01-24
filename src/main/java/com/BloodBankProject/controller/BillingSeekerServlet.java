package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BillingDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

/**
 * Servlet implementation class BillingSeekerServlet
 */
@WebServlet("/BillingSeekerServlet")
public class BillingSeekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillingSeekerServlet() {
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

		PrintWriter pw = response.getWriter();

		HttpSession hp = request.getSession();
		
		RequestModel requestModel = (RequestModel) hp.getAttribute("requestModel");
		SeekerDetails seeker = (SeekerDetails) hp.getAttribute("seeker");

		BloodStackDAOlmpl stack = new BloodStackDAOlmpl();
                           // unit of blood and multiple blood price
		
		double unitPrice = stack.findPrice(requestModel.getBloodType()) * requestModel.getUnit();
              // Request model object to get the blood type and unit ofm blood
		BillingModel BillingModel = new BillingModel(requestModel.getBloodType(), seeker, requestModel.getUnit(),
				unitPrice, null);

		hp.setAttribute("billingProces", BillingModel);
		

		BillingDAOlmpl billing = new BillingDAOlmpl();
             //insert the billing table
		int n = billing.insertBilling(BillingModel);

		if (n > 0) {
                     //Stack table reduce the blood quantity  
			int num = stack.updateStackReduce(requestModel.getBloodType(), requestModel.getUnit());

			if (num > 0) {

				AdminDAOlmpl admin = new AdminDAOlmpl();
				
				if (admin.seekerPayment(unitPrice) > 0) {

					// PrintWriter pw=response.getWriter();
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('your request success');");
					pw.println("location='seekerbill.jsp';");
					pw.println("</script>");
					// response.sendRedirect("seekerbill.jsp");

				}

			}

		}

	}

}
