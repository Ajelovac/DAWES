package com.dawes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.TitularVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJPA1 {

	// una factoria de entity manager
	// crea la conexion a la base de datos
	static EntityManagerFactory emf;
	
	
	// el em se encarga de las tareas de persistencia
	static EntityManager em;
	
	@BeforeClass
	public static void antesDelTest() {
		
		// genera el esquema a partir de la clase VO y del fichero data.sql
		Persistence.generateSchema("jpa", null);
		
		// creamos la factoria
		emf=Persistence.createEntityManagerFactory("jpa");
		
		// creamos el entity manager
		em=emf.createEntityManager();
	}

	@Test
	public void m1emOK() {
		assertNotNull(em);
	}
	
	@Test
	public void m2saveOK() {
		
		// comienzo de transacción
		em.getTransaction().begin();
		em.persist(new TitularVO(100f,LocalDate.now(),"pedro",null));
		
		// finaliza la transacción
		em.getTransaction().commit();
		
		// realizo el test
		assertEquals("pedro",em.find(TitularVO.class, 3).getNombre());
	}
	
	@Test
	public void m3removeOK() {
		em.getTransaction().begin();
		em.remove(em.find(TitularVO.class, 1));
		em.getTransaction().commit();
		assertNull(em.find(TitularVO.class, 1));
	}
	
	@Test
	public void m4mergeOK() {
		TitularVO pedro=em.find(TitularVO.class, 3);
		em.getTransaction().begin();
		pedro.setNombre("peter");
		em.merge(pedro);
		em.getTransaction().commit();
		assertEquals("peter",em.find(TitularVO.class, 3).getNombre());
		
	}
	
	@Test
	public void m5findAll() {
		TypedQuery<TitularVO> consulta=(TypedQuery<TitularVO>) em.createQuery("select t from TitularVO t");
		List<TitularVO> lista=consulta.getResultList();
		//lista.forEach(x->System.out.println(x));
		for(TitularVO t:lista)
			System.out.println(t);
		assertEquals(2,lista.size());
	}
	
	@Test
	public void m6findByNombre() {
		TypedQuery<TitularVO> consulta=(TypedQuery<TitularVO>) em.createQuery("select t from TitularVO t where nombre=:nombre");
		consulta.setParameter("nombre", "peter");
		assertEquals("peter",consulta.getSingleResult().getNombre());
	}
	
	@Test
	public void m7totaliza() {
		Query totaliza=em.createQuery("select sum(t.credito) from TitularVO t");
		
		assertEquals(300,(double)totaliza.getSingleResult(),0);
	}
}
