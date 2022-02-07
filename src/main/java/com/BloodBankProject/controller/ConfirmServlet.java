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

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BloodDetailsDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.Donor;

@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();

		int unit = 1;
		int price = 300;

		Donor donor = (Donor) session.getAttribute("Donor");

		BloodDetailsModel bloodDetails = new BloodDetailsModel(donor, unit, donor.getBloodType(), price);
		BloodDetailsDAOlmpl bloodDetailsDAOlmpl = new BloodDetailsDAOlmpl();

		// Donor confirm the blood donation to insert the blood details

		if (bloodDetailsDAOlmpl.insertBloodDetails(bloodDetails) > 0) {

			BloodStackDAOlmpl bloodStackDAOlmpl = new BloodStackDAOlmpl();

			BloodStack bloodStack = new BloodStack(bloodDetails.getUnit(), bloodDetails.getBloodType(), 0);

			// Stack update the blood quantity 1 and reduce the amount in 300

			if (bloodStackDAOlmpl.updateStack(bloodStack) > 0) {

				adminDAOlmpl.updateWallet();

				List<BloodDetailsModel> detailsList = bloodDetailsDAOlmpl.showBloodDetails(donor);
				request.setAttribute("detailsList", detailsList);

				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("showDonorBloodDetails.jsp");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			}

		}

	}

}