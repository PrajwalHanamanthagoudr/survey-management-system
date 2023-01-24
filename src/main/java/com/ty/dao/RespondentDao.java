package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Respondent;


public class RespondentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public boolean saveRespondent(Respondent respondent) {
		entityTransaction.begin();
		entityManager.persist(respondent);
		entityTransaction.commit();
		return true;
	}
	
	public boolean deleteRespondent(int id) {
		Query query = entityManager.createQuery("DELETE FROM Respondent s where s.id = "+id);
		return query.executeUpdate() < 0 ? true : false;
	}
	
	public boolean updateRespondent(Respondent respondent) {
		entityTransaction.begin();
		entityManager.merge(respondent);
		entityTransaction.commit();
		return true;
	}
	
	public Respondent getRespondentById(int id) {
		return entityManager.find(Respondent.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Respondent>getAllRespondent() {
		Query query = entityManager.createQuery("SELECT s FROM Respondent s");
		return query.getResultList();
	}
	
	public Respondent validateRespondent(String email, String password) {
		
		Query query = entityManager.createQuery("SELECT s FROM Respondent s WHERE s.email = ?1 and s.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		Respondent respondent = (Respondent)query.getSingleResult();
		if(respondent!=null) {
			return respondent;
		}
		return null;
	}
	
}
