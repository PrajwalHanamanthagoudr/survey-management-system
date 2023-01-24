package com.ty.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.OptionsDao;
import com.ty.dto.Options;
import com.ty.dto.Question;
import com.ty.service.QuestionService;

@WebServlet(value = "/createQuestion")
public class SaveQuestionsBySurveyId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int s_id = Integer.parseInt(req.getParameter("s_id"));
		String question = req.getParameter("question");
		int type = Integer.parseInt(req.getParameter("type"));
		String o1  =req.getParameter("option1");
		String o2  =req.getParameter("option2");
		String o3  =req.getParameter("option3");
		String o4  =req.getParameter("option4");

		Question question2 = new Question();
		question2.setQuestion(question);
		question2.setType(type);
		
		List<Options> options = new ArrayList<Options>();
		
		question2.setOptions(options);
		QuestionService questionService = new QuestionService();
		questionService.saveQuestion(s_id, question2);

		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.forward(req, resp);

	}
}
