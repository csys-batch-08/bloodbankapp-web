package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/BillingSeekerServlet")
public class BillingSeekerServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter  writer = response.getWriter();

		HttpSession  session = request.getSession();
		
		RequestModel requestModel = (RequestModel) session.getAttribute("requestModel");
		SeekerDetails  seekerDetails = (SeekerDetails) session.getAttribute("seeker");

		BloodStackDAOlmpl  bloodStackDAOlmpl = new BloodStackDAOlmpl();
                           // unit of blood and multiple blood price
		
		double unitPrice = bloodStackDAOlmpl.findPrice(requestModel.getBloodType()) * requestModel.getUnit();
              // Request model object to get the blood type and unit ofm blood
		BillingModel billingModel = new BillingModel(requestModel.getBloodType(), seekerDetails, requestModel.getUnit(),
				unitPrice, null);

		
		

		BillingDAOlmpl  billingDAOlmpl = new BillingDAOlmpl();
             //insert the billing table
		

		if (billingDAOlmpl.insertBilling(billingModel) > 0) {
			
                     //Stack table reduce the blood quantity  			

			if ( bloodStackDAOlmpl.updateStackReduce(requestModel.getBloodType(), requestModel.getUnit()) > 0) {

				AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();
				
				if (adminDAOlmpl.seekerPayment(unitPrice) > 0) {					
					
					List<BillingModel> billingList = billingDAOlmpl.biilingShow(billingModel);

					request.setAttribute("billingList", billingList);

					RequestDispatcher dispatcher=request.getRequestDispatcher("showSeekerBill.jsp");
					dispatcher.forward(request, response);	
				

				}

			}

		}

	}

}
