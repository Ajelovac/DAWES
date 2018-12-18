package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAOFactory {

	private EntityManagerFactory emf;
	private EntityManager em;

	private static DAOFactory f;

	private DAOFactory() {
		Persistence.generateSchema("jpa", null);
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
	}

	public static DAOFactory getFactoria() {

		if (f == null)
			f = new DAOFactory();
		return f;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEm() {
		return em;
	}

	
}