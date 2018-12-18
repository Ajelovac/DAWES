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

public class MySqlDAOFactory {

	private EntityManagerFactory emf;
	private EntityManager em;

	// Paso 1: Implementar el patr�n Singleton (un �nico objeto), para lo cual el
	// objeto de la clase debe de ser privado y est�tico
	private static MySqlDAOFactory f;

	// Paso 2: en el constructor de la factor�a realizamos la conexi�n. Debe de ser
	// privado.
	private MySqlDAOFactory() {
		Persistence.generateSchema("jpa", null);
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
	}

	// Paso 3: declaro un m�todo est�tico que me devuelve la factor�a y que obliga a
	// que exista una sola instancia de la factor�a
	public static MySqlDAOFactory getFactoria() {

		if (f == null)
			f = new MySqlDAOFactory();
		return f;
	}

	// m�todos get que devuelven implementaciones de dao con la conexi�n inyectada
	// -> inyecci�n de dependencias
	public CuentaDAO getCuentaDAO() {

		return new CuentaDAOImpl(em);
	}

	public MovimientoDAO getMovimientoDAO() {

		return new MovimientoDAOImpl(em);
	}

}
