package com.dawes.ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	
	private ArrayList<Contacto> agenda;
	private Contacto c;
	Scanner teclado;
	
	public Menu() {
		agenda=new ArrayList();
		teclado=new Scanner(System.in);
	}
	
	public void insertarContacto() {
		c=new Contacto();
		System.out.println("Introduce un nombre");
		c.setNombre(teclado.nextLine());
		System.out.println("Introduce un telefono");
		c.setTelefono(teclado.nextLine());
		agenda.add(c);
	}

	public ArrayList<Contacto> getAgenda() {
		return agenda;
	}

	public void setAgenda(ArrayList<Contacto> agenda) {
		this.agenda = agenda;
	}
	
	public void eliminarPorIndice() {
		System.out.println("Introduce el indice a eliminar");
		int eliminar=teclado.nextInt();
		try {
			agenda.remove(eliminar);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Ese indice no existe");
		}
		teclado.nextLine();
	}

	public void eliminarPorNombre() {
		
		System.out.println("Introduce el nombre a eliminar");
		String eliminar=teclado.nextLine();
		Iterator<Contacto> it=agenda.iterator();
		while (it.hasNext()) {
			if (it.next().getNombre().equals(eliminar))
				it.remove();
		}
	}
	
	public void mostrarTodos() {
		for(Contacto c:agenda)
			System.out.println(c);
	}
	
	public void eliminarTodos() {
		agenda.clear();
	}
	
	public void menu() {
		String opcion=null;
		do {
			System.out.println("1.- Insertar contacto");
			System.out.println("2.- Eliminar por indice");
			System.out.println("3.- Eliminar por nombre");
			System.out.println("4.- Eliminar todos");
			System.out.println("5.- Mostrar todos");
			System.out.println("6.- salir");
			System.out.println("Elige una opcion: ");
			opcion=teclado.nextLine();
			switch(opcion) {
			case "1":insertarContacto();break;
			case "2":eliminarPorIndice();break;
			case "3":eliminarPorNombre();break;
			case "4":eliminarTodos();break;
			case "5":mostrarTodos();break;
			}
		} while (!opcion.equals("6"));
		
	}
	public static void main(String[] args) {
		Menu m=new Menu();
		m.menu();
	}
}
