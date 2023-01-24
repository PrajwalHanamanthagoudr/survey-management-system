package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.service.SurveyService;

@WebServlet("/deleteSurvey")
public class DeleteSurveryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		SurveyService service = new SurveyService();
		boolean b = service.deleteSurveyById(id);

		RequestDispatcher dispatcher = req.getRequestDispatcher("viewsurveyor.jsp");
		dispatcher.forward(req, resp);

	}
}
