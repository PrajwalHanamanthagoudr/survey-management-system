package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Respondent;
import com.ty.dto.Surveyor;
import com.ty.service.RespondentService;
import com.ty.service.SurveyorService;

@WebServlet("/login")
public class ValidateUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (user.equals("admin") && email.equals("admin@gmail.com") && password.equals("admin123")) {
			SurveyorService surveyorService = new SurveyorService();
			List<Surveyor> list = surveyorService.getAllSurveyor();
			RespondentService respondentService = new RespondentService();
			List<Respondent> list2 = respondentService.getAllRespondent();
			req.setAttribute("email", email);
			req.setAttribute("password", password);
			req.setAttribute("user", user);
			req.setAttribute("Surveyors", list);
			req.setAttribute("Respondents", list2);
			RequestDispatcher dispatch = req.getRequestDispatcher("viewadmin.jsp");
			dispatch.forward(req, resp);
		} else if (user.equals("surveyor")) {
			SurveyorService service = new SurveyorService();
			Surveyor surveyor = service.validateSurveyor(email, password);
			if (surveyor != null) {
				req.setAttribute("surveyor", surveyor);
				RequestDispatcher dispatch = req.getRequestDispatcher("viewsurveyor.jsp");
				dispatch.forward(req, resp);
			} else {
				PrintWriter p = resp.getWriter();
				p.println("<html><body><h1>Incorrect user/password</h1></body></html>");
				RequestDispatcher dispatch = req.getRequestDispatcher("LoginUser.jsp");
				dispatch.include(req, resp);
			}
		} else if (user.equals("respondent")) {
			RespondentService service = new RespondentService();
			Respondent respondent = service.validateRespondent(email, password);
			if (respondent != null) {
				req.setAttribute("respondent", respondent);
				RequestDispatcher dispatch = req.getRequestDispatcher("viewrespondent.jsp");
				dispatch.forward(req, resp);
			} else {
				PrintWriter p = resp.getWriter();
				p.println("<html><body><h1>Incorrect user/password</h1></body></html>");
				RequestDispatcher dispatch = req.getRequestDispatcher("LoginUser.jsp");
				dispatch.include(req, resp);
			}
		} else {
			PrintWriter p = resp.getWriter();
			p.println("<html><body><h1>Incorrect user/password</h1></body></html>");
			RequestDispatcher dispatch = req.getRequestDispatcher("LoginUser.jsp");
			dispatch.include(req, resp);
		}

	}
}
