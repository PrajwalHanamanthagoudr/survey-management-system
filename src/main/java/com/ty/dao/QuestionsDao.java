package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Question;
import com.ty.dto.Survey;

public class QuestionsDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Question saveQuestion(int id, Question question) {
		Survey survey = entityManager.find(Survey.class, id);
		if (survey != null) {
			entityTransaction.begin();
			entityManager.persist(question);
			entityTransaction.commit();
			return question;
		} else {
			return null;
		}
	}

	public Question getQuestionById(int id) {
		return entityManager.find(Question.class, id);
	}

	public List<Question> getAllQuestionsBySurveyId(int id) {
		Query query = entityManager.createQuery("SELECT q FROM Question Q WHERE q.survey_id.id=" + id);
		return query.getResultList();
	}

	public boolean deleteQuestion(int id) {
		Question question = entityManager.find(Question.class, id);

		if (question != null) {
			entityTransaction.begin();
			entityManager.remove(question);
			return true;
		} else
			return false;
	}

	public Question updateQuestions(int id, Question question) {
		Question question1 = entityManager.find(Question.class, id);
		if (question1 != null) {
			entityTransaction.begin();
			entityManager.merge(question);
			entityTransaction.commit();
			return question;
		} else
			return null;
	}
}
