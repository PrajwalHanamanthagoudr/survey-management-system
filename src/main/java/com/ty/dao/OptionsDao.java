package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Options;
import com.ty.dto.Question;

public class OptionsDao {


	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Options saveOptions(int id,Options options) {
		Question question=entityManager.find(Question.class, id);
		if(question != null) {
			entityTransaction.begin();
			entityManager.persist(options);
			entityTransaction.commit();
			return options;
		}else
			return null;
	}
	public List<Options> getAllOptions()
	{
		Query query=entityManager.createQuery("SELECT o FROM Options o ");
		return query.getResultList();
	}
	
}
