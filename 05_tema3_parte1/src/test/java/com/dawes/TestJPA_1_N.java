package com.dawes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.TitularVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJPA_1_N {

	static EntityManagerFactory emf;
	static EntityManager em;
	
	@BeforeClass
	public static void antesDelTest() {
		Persistence.generateSchema("jpa", null);
		emf=Persistence.createEntityManagerFactory("jpa");
		em=emf.createEntityManager();
	}

	@Test
	public void conexionOK() {
		assertNotNull(em);
	}
	
	@Test
	public void insertarCuentaOK() {
		em.getTransaction().begin();
		TitularVO javier=em.find(TitularVO.class, 1);
		CuentaVO c1=new CuentaVO("4",400,javier);
		em.persist(c1);
		em.getTransaction().commit();
		assertEquals("4",em.find(CuentaVO.class, 4).getNumero());
	}
}
