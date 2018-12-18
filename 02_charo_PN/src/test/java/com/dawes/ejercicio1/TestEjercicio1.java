package com.dawes.ejercicio1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dawes.ejercicio1.Operaciones;
import com.dawes.ejercicio1.Racional;

public class TestEjercicio1 {
	
	Racional r1,r2;
	Operaciones op;

	@Before
	public void antesDeCadaTest() {
		op=new Operaciones();
		r1=new Racional(1,2);
		r2=new Racional(2,3);
	}

	@Test
	public void sumarOK() {
		assertEquals(new Racional(7,6),op.suma(r1, r2));
	}
	
	@Test
	public void multiplicarOK() {
		assertEquals(new Racional(2,6),op.multiplicar(r1, r2));
	}
}
