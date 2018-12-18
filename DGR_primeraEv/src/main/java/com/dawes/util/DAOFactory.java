package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.dao.FincaDAO;
import com.dawes.dao.TratamientoDAO;
import com.dawes.daoImp.FincaDAOImpl;
import com.dawes.daoImp.TratamientoDAOImpl;

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
	
	public FincaDAO getFincaDAO() {
		return new FincaDAOImpl(em);
	}
	
	public TratamientoDAO getTratamientoDAO() {
		return new TratamientoDAOImpl(em);
	}
}
