package com.dawes.ejercicio3;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class TestEjercicio3 {

	Date f1,f2;
	Ejercicio3 ej;
	LocalDate f3,f4;
	
	@Before
	public void antesDeCadaTest() {
		ej=new Ejercicio3();
		f1=new GregorianCalendar(2018,9,23).getTime();
		f2=new GregorianCalendar(2018,9,20).getTime();
		f3=LocalDate.of(2018, 10, 23);
		f4=LocalDate.of(2018, 10, 20);
	}

	@Test
	public void diferenciaFechasJava7() {
		assertEquals(3,ej.restaFechas(f1, f2));
	}
	
	@Test
	public void diferenciaFechasJava8() {
		assertEquals(3,ej.restaFechaJava8(f4, f3));
	}
}
