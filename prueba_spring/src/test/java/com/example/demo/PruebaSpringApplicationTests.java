package com.example.demo;

import static org.junit.Assert.assertNotNull;

import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.services.ServiceAlumno;
import com.example.services.ServiceCurso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaSpringApplicationTests {

	
	@Autowired
	ServiceAlumno sa;
	
	@Autowired
	ServiceCurso sc;
	
	@BeforeClass
	public static void crearesquema() {
		Persistence.generateSchema("jpa", null);
	}
	
	@Test
	public void m0inyeccionDeDependencias() {
		assertNotNull(sa);
	}

	
}
