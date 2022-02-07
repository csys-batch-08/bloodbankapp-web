package com.BloodBankProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckDonorServlet")
public class CheckDonorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final String DONORNOTQUALIFIEDWEB = "donorNotQualified.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int temp = 0;
		int pressure = 0;
		int pluse = 0;
		int height = 0;
		int weight = 0;

		try {
			height = Integer.parseInt(request.getParameter("Height"));
			weight = Integer.parseInt(request.getParameter("weight"));

			temp = Integer.parseInt(request.getParameter("temperature"));

			pressure = Integer.parseInt(request.getParameter("pressure"));
			pluse = Integer.parseInt(request.getParameter("pulse"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
		// donor check-up in physicaly

		if (temp <= 100 && temp >= 80) {

			if (pressure <= 180 && pressure >= 90) {

				if (pluse <= 100 && pluse >= 50) {

					if (height <= 200 && height >= 100) {
						if (weight <= 150 && weight >= 35) {

							try {
								RequestDispatcher dispatcher = request
										.getRequestDispatcher("bloodBookingProcess.jsp?qualified=sucess");
								dispatcher.forward(request, response);
							} catch (ServletException | IOException e) {

								e.printStackTrace();
							}

						} else {

							try {
								response.sendRedirect(DONORNOTQUALIFIEDWEB);
							} catch (IOException e) {

								e.printStackTrace();
							}
						}
					} else {

						try {
							response.sendRedirect(DONORNOTQUALIFIEDWEB);
						} catch (IOException e) {

							e.printStackTrace();
						}
					}

				} else {

					try {
						response.sendRedirect(DONORNOTQUALIFIEDWEB);
					} catch (IOException e) {

						e.printStackTrace();
					}
				}

			} else {

				try {
					response.sendRedirect(DONORNOTQUALIFIEDWEB);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		} else {

			try {
				response.sendRedirect(DONORNOTQUALIFIEDWEB);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
}
