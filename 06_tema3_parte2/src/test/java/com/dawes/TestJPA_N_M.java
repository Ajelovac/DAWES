package com.dawes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.TitularCuentaVO;
import com.dawes.modelo.TitularVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJPA_N_M {

	static EntityManagerFactory emf;
	static EntityManager em;

	@BeforeClass
	public static void antesDelTest() {
		Persistence.generateSchema("jpa", null);
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
	}

	@Test
	public void m1conexionOK() {
		assertNotNull(em);
	}

	// persistimos un titular nuevo
	@Test
	public void m2saveTitularOK() {
		em.getTransaction().begin();
		em.persist(new TitularVO(1,LocalDate.now(),"alejandro",new ArrayList()));
		em.getTransaction().commit();
		assertEquals("alejandro",em.find(TitularVO.class, 3).getNombre());
	}
	
	// persistimos una cuenta nueva
		@Test
		public void m3saveCuentaOK() {
			em.getTransaction().begin();
			em.persist(new CuentaVO("4",4,null));
			em.getTransaction().commit();
			assertEquals("4",em.find(CuentaVO.class, 4).getNumero());
		}
		
		//asignamos una cuenta que ya existe a un titular que ya existe
		@Test
		public void m4saveCuentaTitularExistentesOK() {
			
			// busco el titular
			TitularVO t=em.find(TitularVO.class,3);
			
			// busco la cuenta
			CuentaVO c=em.find(CuentaVO.class, 4);
			
			// añado a las cuentas del titular una cuenta nueva 
			t.getCuentas().add(new TitularCuentaVO(t,c,LocalDate.now()));
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			// compruebo que alejandro solo tiene una cuenta
			assertEquals(1,em.find(TitularVO.class,3).getCuentas().size());
			
		}
		
		// insertamos un titular nuevo y le asignamos una cuenta nueva
		@Test
		public void m5saveCuentaTitularNuevosOK() {
			em.getTransaction().begin();
			TitularVO t=new TitularVO(4,LocalDate.now(),"vlad",new ArrayList());
			CuentaVO c=new CuentaVO("5",5,null);
			
			// asigno a t la cuenta c
			t.getCuentas().add(new TitularCuentaVO(t,c,LocalDate.now()));
			em.persist(t);
			em.persist(c);
			em.getTransaction().commit();
			assertEquals("vlad",em.find(TitularVO.class,4).getNombre());
		}
		
		// eliminamos una cuenta
		@Test
		public void m6eliminarCuentaOK() {
			em.getTransaction().begin();
			
			// busco la cuenta a eliminar
			CuentaVO c=em.find(CuentaVO.class, 5);
			
			em.remove(em.find(CuentaVO.class,5));
			em.getTransaction().commit();
			assertNull(em.find(CuentaVO.class, 5));
		}
		
		// eliminar un titular que tiene cuentas asociadas
		@Test
		public void m7eliminarTitularOK() {
			try {
			em.getTransaction().begin();
			em.remove(em.find(TitularVO.class, 4));
			em.getTransaction().commit();
			} catch (PersistenceException e) {
				
				System.out.println("ese usuario tiene cuentas asociadas");
				System.out.println("error al eliminar un titular "+e.getMessage());
			}
		}
		
		// Listado: mostrar los titulares que entre todas sus cuentas tengan mas de 1000€
		@Test
		public void m8listado1OK() {
			em.getTransaction();
			Query consulta=em.createQuery("select tc from TitularCuentaVO tc join fetch tc.titular t join fetch tc.cuenta c where sum(tc.saldo>50");
			
			List<TitularCuentaVO> lista=consulta.getResultList();
			for(Object o:lista) {
				System.out.println(o);
			}
		}
		
}
