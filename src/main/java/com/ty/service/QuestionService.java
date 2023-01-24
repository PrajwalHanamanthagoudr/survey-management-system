package com.ty.service;

import java.util.List;

import com.ty.dao.QuestionsDao;
import com.ty.dto.Question;

public class QuestionService {

	QuestionsDao dao = new QuestionsDao();

	public Question saveQuestion(int id, Question question) {

		return dao.saveQuestion(id, question);
	}

	public Question getQuestionById(int id) {

		return dao.getQuestionById(id);
	}

	public List<Question> getAllQuestionsBySurveyId(int id) {

		return dao.getAllQuestionsBySurveyId(id);
	}

	public boolean deleteQuestion(int id) {

		return dao.deleteQuestion(id);
	}

	public Question updateQuestions(int id, Question question) {

		return dao.updateQuestions(id, question);
	}
}
