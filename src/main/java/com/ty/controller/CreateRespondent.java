package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Respondent;
import com.ty.service.RespondentService;

@WebServlet(value = "/respodent")
public class CreateRespondent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Respondent respondent = new Respondent();
		respondent.setEmail(email);
		respondent.setName(name);
		respondent.setPassword(password);
		
		RespondentService service = new RespondentService();
		service.saveRespondent(respondent);
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.forward(req, resp);
	
	}

}
