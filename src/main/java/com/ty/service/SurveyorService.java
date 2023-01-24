package com.ty.service;

import java.util.List;

import com.ty.dao.SurveyorDao;
import com.ty.dto.Survey;
import com.ty.dto.Surveyor;

public class SurveyorService {

	SurveyorDao dao = new SurveyorDao();
	public boolean saveSurveyor(Surveyor surveyor) {
		return dao.saveSurveyor(surveyor);
	}
	
	public boolean deleteSurSurveyor(int id) {
		return dao.deleteSurSurveyor(id);
	}
	
	public boolean updateSurveyor(int id,Surveyor surveyor) {
		return dao.updateSurveyor(id,surveyor);
	}
	
	public Surveyor getSurveyorById(int id) {
		return dao.getSurveyorById(id);
	}
	
	public List<Surveyor>getAllSurveyor() {
		return dao.getAllSurveyor();
	}
	public Surveyor validateSurveyor(String email, String password) {
		return dao.validateSurveyor(email, password);
	}
	public List<Survey> getAllSurvey(int id) {
		return dao.getAllSurvey(id);
	}
}
