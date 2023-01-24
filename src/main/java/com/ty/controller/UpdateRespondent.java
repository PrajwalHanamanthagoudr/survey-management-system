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


@WebServlet(value = "/updaterespondent")
public class UpdateRespondent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String eamil=req.getParameter("email");
		String password=req.getParameter("password");
		
		Respondent respondent=new Respondent();
		respondent.setId(id);
		respondent.setName(name);
		respondent.setEmail(eamil);
		respondent.setPassword(password);
		
		RespondentService respondentService=new RespondentService();
		respondentService.updateRespondent(respondent);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("viewadmin.jsp");
		dispatcher.forward(req, resp);
		
	}
}
