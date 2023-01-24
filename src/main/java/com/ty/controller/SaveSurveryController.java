package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Survey;
import com.ty.service.SurveyService;

@WebServlet(value = "/survey")
public class SaveSurveryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");

		Survey survey = new Survey();
		survey.setId(id);
		survey.setName(name);
		survey.setDescription(description);

		SurveyService service = new SurveyService();
		service.saveSurveyor(survey.getId(), survey);

		RequestDispatcher dispatcher = req.getRequestDispatcher("viewsurveyor.jsp");
		dispatcher.forward(req, resp);
	}

}
