package com.qsp.food_app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.qsp.food_app.dto.User;

public class UserDao
{
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vaishnavi").createEntityManager();
	}

	public User saveUser(User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;
	}

	public User getUserByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		return user;
	}
	public User updateUser(User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;
	}
	public User getUserById(int id) {
		EntityManager entityManager = getEntityManager();
		User user = entityManager.find(User.class, id);
		return user;
	}
}
