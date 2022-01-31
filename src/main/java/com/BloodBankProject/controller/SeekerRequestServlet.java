package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;
import com.bloodbank.model.Donor;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

@WebServlet("/SeekerRequestServlet")
public class SeekerRequestServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String collectorName = request.getParameter("NAME");
		Long aadharcard = Long.parseLong(request.getParameter("number"));
		String hospitalName = request.getParameter("HOSPITAL");
		String bloodtype = request.getParameter("bloodtype");

		int unit = Integer.parseInt(request.getParameter("UNIT"));
		Date date = null;
	

			try {
				date = sdf.parse(request.getParameter("currentdate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

			RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();
			PrintWriter writer = response.getWriter();
			HttpSession session = request.getSession();
			SeekerDetails seekerDetails = (SeekerDetails) session.getAttribute("seeker");

		
			BloodStackDAOlmpl stackDAOlmpl = new BloodStackDAOlmpl();
	

				if (stackDAOlmpl.checkOfQuantity(bloodtype) > unit) {

					String status = "approved";

					RequestModel requestModel = new RequestModel(hospitalName, bloodtype, unit, collectorName,
							seekerDetails.getPhoneNumber(), aadharcard, date, status);

					session.setAttribute("requestModel", requestModel);

					
					
					if (requestDAOlmpl.insertRequest(requestModel) > 0) {

						
						RequestDispatcher rd = request.getRequestDispatcher("BillingSeekerServlet");
						rd.forward(request, response);

					}
				} else {
					String status = "pending";

					RequestModel requestModel = new RequestModel(hospitalName, bloodtype, unit, collectorName,
							seekerDetails.getPhoneNumber(), aadharcard, date, status);

					session.setAttribute("requestModel", requestModel);

					if (requestDAOlmpl.insertRequest(requestModel) > 0) {
						
						writer.println("<script type=\"text/javascript\">");
						writer.println("alert('your request accepted and status is pending');");
						writer.println("location='requestIndex.jsp';");
						writer.println("</script>");
					

					}

				}

	}

}
