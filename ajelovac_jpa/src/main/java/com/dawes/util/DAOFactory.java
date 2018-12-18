package com.dawes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.dawes.dao.CuentaDAO;
import com.dawes.dao.MovimientoDAO;
import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.daoImpl.MovimientoDAOImpl;

public class DAOFactory {
		
	private static DAOFactory f;
	
	static EntityManagerFactory emf;
	static EntityManager em;

	private DAOFactory(){
		Persistence.generateSchema("jpa", null);
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();	
	}
	
	public static DAOFactory getFactoria() {
		if (f == null) 
			f=new DAOFactory();
		return f;
	}
	
	public CuentaDAO getCuentaDAO() {
	
		return new CuentaDAOImpl(em);
	}
	
	public MovimientoDAO getMovimientoDAO() {
		
		return new MovimientoDAOImpl(em);
	}
	

}
