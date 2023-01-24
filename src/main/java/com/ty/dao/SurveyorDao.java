package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Survey;
import com.ty.dto.Surveyor;

public class SurveyorDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveSurveyor(Surveyor surveyor) {
		entityTransaction.begin();
		entityManager.persist(surveyor);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteSurSurveyor(int id) {
		entityTransaction.begin();
		Query query = entityManager.createQuery("DELETE FROM Surveyor s where id = " + id);
		entityTransaction.commit();
		return query.executeUpdate() < 0 ? true : false;
	}

	public boolean updateSurveyor(int id, Surveyor surveyor) {
		Surveyor surveyor2 = entityManager.find(Surveyor.class, id);
		if (surveyor2 != null) {

			entityTransaction.begin();
			entityManager.merge(surveyor);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	public Surveyor getSurveyorById(int id) {
		return entityManager.find(Surveyor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Surveyor> getAllSurveyor() {
		Query query = entityManager.createQuery("SELECT s FROM Surveyor s");
		return query.getResultList();
	}

	public Surveyor validateSurveyor(String email, String password) {
		Query query = entityManager.createQuery("SELECT s FROM Surveyor s where email = ?1 and password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		return (Surveyor) query.getSingleResult();
	}

	public List<Survey> getAllSurvey(int id) {
		Query query = entityManager.createQuery("SELECT s FROM Survey s where s.surveyor=" + id);
		return query.getResultList();
	}

}
