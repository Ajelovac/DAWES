package com.dawes.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Finca")
public class FincaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfinca;
	private String nombre;
	    

	@ManyToMany
	@JoinTable(name="Finca")
	Set<TratamientoVO> tratamientos;

	
	

	public FincaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FincaVO(int idfinca) {
		super();
		this.idfinca = idfinca;
	}


	public FincaVO(int idfinca, String nombre, Set<TratamientoVO> tratamientos) {
		super();
		this.idfinca = idfinca;
		this.nombre = nombre;
		this.tratamientos = tratamientos;
	}


	public int getIdfinca() {
		return idfinca;
	}


	public void setIdfinca(int idfinca) {
		this.idfinca = idfinca;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<TratamientoVO> getTratamientos() {
		return tratamientos;
	}


	public void setTratamientos(Set<TratamientoVO> tratamientos) {
		this.tratamientos = tratamientos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idfinca;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tratamientos == null) ? 0 : tratamientos.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FincaVO other = (FincaVO) obj;
		if (idfinca != other.idfinca)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tratamientos == null) {
			if (other.tratamientos != null)
				return false;
		} else if (!tratamientos.equals(other.tratamientos))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "FincaVO [idfinca=" + idfinca + ", nombre=" + nombre + ", tratamientos=" + tratamientos + "]";
	}
	
	
	

}

