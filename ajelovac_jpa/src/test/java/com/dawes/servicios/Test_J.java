package com.dawes.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.daoImpl.MovimientoDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.service.ServiceCuentas;
import com.dawes.service.ServiceMovimientos;
import com.dawes.serviceImpl.ServiceCuentasImpl;
import com.dawes.serviceImpl.ServiceMovimientosImpl;
import com.dawes.util.DAOFactory;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_J {
	
	static DAOFactory f;
	
	@BeforeClass
	public static void antesDelTest() {
		f = f.getFactoria();
		
	}
	
	@Test
	public void m1conexionOK() {
		assertNotNull(f);
	}

	
}
