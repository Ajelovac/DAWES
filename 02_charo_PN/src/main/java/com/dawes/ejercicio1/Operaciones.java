package com.dawes.ejercicio1;

public class Operaciones {
	
	public Racional suma(Racional r1, Racional r2) {
		return new Racional(r1.getNum()*r2.getDen()+r2.getNum()*r1.getDen(),r1.getDen()*r2.getDen());
	}

	public Racional multiplicar(Racional r1,Racional r2) {
		return new Racional(r1.getNum()*r2.getNum(),r1.getDen()*r2.getDen());
	}
}
