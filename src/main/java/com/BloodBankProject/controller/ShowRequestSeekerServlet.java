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

import com.bloodbank.DaoImpl.RequestDAOlmpl;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

@WebServlet("/ShowRequestSeekerServlet")
public class ShowRequestSeekerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDAOlmpl requestDAOlmpl = new RequestDAOlmpl();

		HttpSession session = request.getSession();
		SeekerDetails seeker = (SeekerDetails) session.getAttribute("seeker");
		List<RequestModel> requestList = requestDAOlmpl.showRequestSeeker(seeker.getPhoneNumber());

		if (requestList.isEmpty()) {

			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("requestIndex.jsp?noDate=noDate");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}

		} else {

			request.setAttribute("requestList", requestList);

			if (request.getAttribute("approved") != null) {

				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("showSeekerRequest.jsp?approved");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			} else if (request.getAttribute("Requestcancel") != null) {

				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("showSeekerRequest.jsp?Requestcancel");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}

			} else if (request.getAttribute("InvalidAadharcardNumber") != null) {

				try {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("showSeekerRequest.jsp?InvalidAadharcardNumber");
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
