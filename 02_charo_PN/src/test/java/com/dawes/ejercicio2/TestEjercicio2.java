package com.dawes.ejercicio2;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEjercicio2 {

	static Menu m;
	
	@BeforeClass
	public static void antesDeCadaTest() {
		m=new Menu();
		m.insertarContacto();
		m.insertarContacto();
		m.insertarContacto();
	}

	
	@Test
	public void m1insertarOK() {
		assertEquals(3,m.getAgenda().size());
	}
	
	@Test
	public void m2eliminarPorIndiceOK() {
		m.eliminarPorIndice();
		assertEquals(2,m.getAgenda().size());
	}
	
	@Test
	public void m3eliminarPorNombreOK() {
		m.eliminarPorNombre();
		assertEquals(1,m.getAgenda().size());
		
	}
	
	@Test
	public void m0mostrarOK() {
		m.mostrarTodos();
	}
	
	@Test
	public void m4eliminarTodos() {
		m.eliminarTodos();
		assertEquals(0,m.getAgenda().size());
	}
}
