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

	// Paso 1: Implementar el patrón Singleton (un único objeto), para lo cual el
	// objeto de la clase debe de ser privado y estático
	private static MySqlDAOFactory f;

	// Paso 2: en el constructor de la factoría realizamos la conexión. Debe de ser
	// privado.
	private MySqlDAOFactory() {
		Persistence.generateSchema("jpa", null);
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
	}

	// Paso 3: declaro un método estático que me devuelve la factoría y que obliga a
	// que exista una sola instancia de la factoría
	public static MySqlDAOFactory getFactoria() {

		if (f == null)
			f = new MySqlDAOFactory();
		return f;
	}

	// métodos get que devuelven implementaciones de dao con la conexión inyectada
	// -> inyección de dependencias
	public CuentaDAO getCuentaDAO() {

		return new CuentaDAOImpl(em);
	}

	public MovimientoDAO getMovimientoDAO() {

		return new MovimientoDAOImpl(em);
	}

}
