package com.dawes.ejercicio1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEjercicio1 {

	static Ejercicio1 e;
	
	@BeforeClass
	public static void testEjercicio1() {
		e=new Ejercicio1();
		e.conectar();
		e.eliminarTodo();
		e.insertarPS("jesus", 24);
		e.insertarPS("tomas", 20);
	}

	@Test
	public void m1conexionOK() {
		assertNotNull(e.getCon());
	}
	
	@Test
	public void m2insertarOK() {
		assertEquals(1,e.insertar());
	}
	
	@Test
	public void m3insertarPSOK() {
		assertEquals(1,e.insertarPS("jesusa", 24));
		assertEquals(1,e.insertarPS("tomasa", 21));
	}
	
	@Test
	public void m4updateOK() {
		
		assertEquals(1,e.actualizar("jesusa", 44));
	}
	
	@Test
	public void m5leerTodoOK() {
		assertEquals(5,e.leerTodos().size());
	}
	
	@Test
	public void m6leerIgualOK() {
		assertEquals(44,e.leerIgual("jesusa").getEdad());
	}
	
//	@Test
//	public void m7transaccionOK() {
//		e.transaccion();
//	}
	
	
	@Test
	public void m8procedimientoAlmacenadoOK() throws SQLException {
		ResultSet rs=e.procedimientoAlmacenado(15);
		if (rs.last()) assertEquals(5,rs.getRow());
		
	}
	
	@Test
	public void m9TransaccionOK() {
		try {
			e.getCon().setAutoCommit(false);
			e.insertarTransaccion("tomasa", 20).executeUpdate();
			e.insertarTransaccion("javier", 20).executeUpdate();

			e.getCon().commit();
		} catch (SQLException b) {
			try {
				e.getCon().rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertNull(e.leerIgual("javier"));
		
	}
	
	@Test
	public void maTransaccion2OK() {
		e.pruebaTransaccion();
		assertNull(e.leerIgual("javier"));
	}
}
