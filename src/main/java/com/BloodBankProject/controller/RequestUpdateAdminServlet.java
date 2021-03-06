package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BillingDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.DaoImpl.SeekerDAOlmpl;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

@WebServlet("/RequestUpdateAdminServlet")
public class RequestUpdateAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String bloodtype = request.getParameter("bloodtype");
		RequestDAOlmpl requestModelDao = new RequestDAOlmpl();
		RequestModel requestModel = requestModelDao.requestObject(phoneNumber);

		String status = "approved";

		requestModel = new RequestModel(requestModel.getHospitalName(), bloodtype, requestModel.getUnit(),
				requestModel.getBloodCollectorName(), requestModel.getPhoneNumber(), requestModel.getAadharcard(),
				requestModel.getRequestDate(), status);

		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();
		// The admin update the request
		requestDAOlmpl.requestUpdate(requestModel);

		BloodStackDAOlmpl stackDAOlmpl = new BloodStackDAOlmpl();

		double unitPrice = stackDAOlmpl.findPrice(requestModel.getBloodType()) * requestModel.getUnit();

		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();

		SeekerDetails seekerDetails = seekerDAOlmpl.findSeekerObjectId(phoneNumber);
		// genarate the bill in seeker
		BillingModel billingModel = new BillingModel(requestModel.getBloodType(), seekerDetails, requestModel.getUnit(),
				unitPrice, null);

		BillingDAOlmpl billingDAOlmpl = new BillingDAOlmpl();

		if (billingDAOlmpl.insertBilling(billingModel) > 0) {

			if (stackDAOlmpl.updateStackReduce(requestModel.getBloodType(), requestModel.getUnit()) > 0) {

				AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();
				// Add the price in admin wallet
				if (adminDAOlmpl.seekerPayment(unitPrice) > 0) {

					response.sendRedirect("RequestShowAndDeleteServlet");

				}

			}

		}
	}

}
