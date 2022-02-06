package com.BloodBankProject.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

@WebServlet("/SeekerRequestServlet")
public class SeekerRequestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstName = request.getParameter("FIRSTNAME");
		String lastName = request.getParameter("LASTNAME");
		String collectorName = firstName + lastName;

		String hospitalName = request.getParameter("HOSPITAL");
		String bloodtype = request.getParameter("bloodtype");

		Long aadharcardNumber = null;
		int bloodUnit = 0;
		try {
			aadharcardNumber = Long.parseLong(request.getParameter("number"));
			bloodUnit = Integer.parseInt(request.getParameter("UNIT"));
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		}

		Date date = null;

		try {
			date = sdf.parse(request.getParameter("currentdate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();

		HttpSession session = request.getSession();
		SeekerDetails seekerDetails = (SeekerDetails) session.getAttribute("seeker");

		BloodStackDAOlmpl stackDAOlmpl = new BloodStackDAOlmpl();

		if (stackDAOlmpl.checkOfQuantity(bloodtype) > bloodUnit) {

			String status = "approved";

			RequestModel requestModel = new RequestModel(hospitalName, bloodtype, bloodUnit, collectorName,
					seekerDetails.getPhoneNumber(), aadharcardNumber, date, status);

			session.setAttribute("requestModel", requestModel);

			if (requestDAOlmpl.insertRequest(requestModel) > 0) {

				try {
					RequestDispatcher rd = request.getRequestDispatcher("BillingSeekerServlet");
					rd.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			}
		} else {
			String status = "pending";

			RequestModel requestModel = new RequestModel(hospitalName, bloodtype, bloodUnit, collectorName,
					seekerDetails.getPhoneNumber(), aadharcardNumber, date, status);

			session.setAttribute("requestModel", requestModel);

			if (requestDAOlmpl.insertRequest(requestModel) > 0) {

				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("requestIndex.jsp?pending=pending");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			}

		}

	}

}
