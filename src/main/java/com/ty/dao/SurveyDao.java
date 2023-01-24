package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Survey;

public class SurveyDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Survey saveSurvey(int id, Survey survey) {
		Survey survey2 = entityManager.find(Survey.class, id);
		if (survey2 != null) {
			entityTransaction.begin();
			entityManager.persist(survey);
			entityTransaction.commit();
			return survey;
		} else
			return null;
	}

	public boolean deleteSurvey(int id) {
		Survey survey = entityManager.find(Survey.class, id);
		if (survey != null) {
			entityTransaction.begin();
			entityManager.remove(survey);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	public Survey getSurveyById(int id) {
		Survey survey = entityManager.find(Survey.class, id);
		if (survey != null) {
			return survey;
		} else
			return survey;
	}

	public Survey updateSurvey(int id, Survey survey) {
		Survey s = getSurveyById(id);
		if (s != null) {
			entityTransaction.begin();
			entityManager.merge(survey);
			entityTransaction.commit();
			return s;
		} else
			return s;
	}

	@SuppressWarnings("unchecked")
	public List<Survey> getAllSurveys() {
		String jpql = "SELECT s FROM Survey s";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
