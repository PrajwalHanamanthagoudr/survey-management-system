package com.ty.service;

import java.util.List;

import com.ty.dao.SurveyDao;
import com.ty.dto.Survey;

public class SurveyService {

	SurveyDao dao=new SurveyDao();
	

	public Survey saveSurveyor(int id,Survey survey) {
		return dao.saveSurvey(id,survey);
	}
	
	public Survey updateSurvey(int id,Survey survey) {
		return dao.updateSurvey(id, survey);
	}
	
	public Survey getSurveyById(int id) {
		return dao.getSurveyById(id);
	}
	
	public Boolean deleteSurveyById(int id) {
		return dao.deleteSurvey(id);
	}
	public List<Survey> getAllSurveys(){
		return dao.getAllSurveys();
	}
}
