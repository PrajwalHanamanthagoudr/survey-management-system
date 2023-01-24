package com.ty.controller;

import java.io.IOException;


import com.ty.dto.Surveyor;
import com.ty.service.SurveyorService;

@WebServlet("/surveyorid")
public class GetSurveyourById extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		SurveyorService service = new SurveyorService();
		Surveyor surveyor = service.getSurveyorById(id);
		req.setAttribute("surveyor", surveyor);
		RequestDispatcher dispatcher = req.getRequestDispatcher("updatesurveyor.jsp");
		dispatcher.forward(req, resp);
	}
}
