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

/**
 * Servlet implementation class SeekerRequestServlet
 */
@WebServlet("/SeekerRequestServlet")
public class SeekerRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeekerRequestServlet() {
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String collectorName = request.getParameter("NAME");
		Long aadharcard = Long.parseLong(request.getParameter("number"));
		String hospitalName = request.getParameter("HOSPITAL");
		String bloodtype = request.getParameter("bloodtype");

		int unit = Integer.parseInt(request.getParameter("UNIT"));
		Date date = null;
		// System.out.println(aadharcard);
	//	try {

			try {
				date = sdf.parse(request.getParameter("currentdate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDAOlmpl Dao = new RequestDAOlmpl();

			HttpSession htp = request.getSession();
			SeekerDetails seeker = (SeekerDetails) htp.getAttribute("seeker");

			// System.out.println(date);
			// System.out.println(request.getParameter("currentdate"));

			BloodStackDAOlmpl stockDao = new BloodStackDAOlmpl();

		//	if (Dao.AadharcardValid(aadharcard) == null) {
				

				if (stockDao.checkOfQuantity(bloodtype) > unit) {

					String status = "approved";

					RequestModel model = new RequestModel(hospitalName, bloodtype, unit, collectorName,
							seeker.getPhoneNumber(), aadharcard, date, status);

					htp.setAttribute("requestModel", model);

					int n = Dao.insertRequest(model);
					// System.out.println(n+"insert request");
					if (n > 0) {

						// System.out.println("request insert");

						// System.out.println("unit check");
						RequestDispatcher rd = request.getRequestDispatcher("BillingSeekerServlet");
						rd.forward(request, response);

					}
				} else {
					String status = "pending";

					RequestModel model = new RequestModel(hospitalName, bloodtype, unit, collectorName,
							seeker.getPhoneNumber(), aadharcard, date, status);

					htp.setAttribute("requestModel", model);

					// RequestDAOlmpl Dao=new RequestDAOlmpl();

					if (Dao.insertRequest(model) > 0) {
						PrintWriter pw = response.getWriter();
						pw.println("<script type=\"text/javascript\">");
						pw.println("alert('your request accepted and status is pending');");
						pw.println("location='RequestIndex.jsp';");
						pw.println("</script>");
						// response.sendRedirect("RequestIndex.jsp");

					}

				}

//			} else {
//
//				throw new ExeceptionHandle();
//
//			}
//		} catch (ExeceptionHandle e) {
//
//			HttpSession session = request.getSession();
//			session.setAttribute("Aadharcard", e.AadharcardNumber());
//			response.sendRedirect("requestSeeker.jsp");
//
		//}

	}

}
