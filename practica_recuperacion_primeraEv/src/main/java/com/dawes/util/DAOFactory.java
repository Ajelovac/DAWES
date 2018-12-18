package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;
import com.dawes.daoImp.IngredienteDAOImpl;
import com.dawes.daoImp.RecetaDAOImpl;

public class DAOFactory {

	private EntityManagerFactory emf;
	private EntityManager em;
	static private DAOFactory f;
	
	private DAOFactory() {
		Persistence.generateSchema("jpa", null);
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
	}
	
	public static DAOFactory getF() {
		if (f == null) {
			f = new DAOFactory();
		}
		return f;
	}
	
	public RecetaDAO getRecetaDAO() {
		return new RecetaDAOImpl(em);
	}
	
	public IngredienteDAO getIngredienteDAO() {
		return new IngredienteDAOImpl(em);
	}
	
}
