package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Surveyor;
import com.ty.service.SurveyorService;

@WebServlet(value = "/surveyor")
public class SaveSurveyor extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name =req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Surveyor surveyor=new Surveyor();
		surveyor.setName(name);
		surveyor.setEmail(email);
		surveyor.setPassword(password);
		
		SurveyorService service=new SurveyorService();
		service.saveSurveyor(surveyor);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.forward(req, resp);
		
	}
}
