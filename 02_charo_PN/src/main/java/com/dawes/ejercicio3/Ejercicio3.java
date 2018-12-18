package com.dawes.ejercicio3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Ejercicio3 {
	
	// Calcular la diferencia entre fechas en Java7
	
	public long restaFechas(Date f1, Date f2) {
		return TimeUnit.MILLISECONDS.toDays(f1.getTime()-f2.getTime());
	}
	
	// Calcular la diferencia entre fechas en Java 8
	
	public long restaFechaJava8(LocalDate f1, LocalDate f2) {
		return ChronoUnit.DAYS.between(f1, f2);
	}

}
