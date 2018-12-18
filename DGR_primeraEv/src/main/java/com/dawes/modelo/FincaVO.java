package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="fincas")
public class FincaVO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFinca;
	
	private String nombre;
	
	@OneToMany(mappedBy="finca", cascade=CascadeType.PERSIST)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<FincaTratamientoVO> lFincaTratamiento;
	
	public FincaVO() {
		super();
		
		lFincaTratamiento = new ArrayList<FincaTratamientoVO>();
	}

	public FincaVO(String nombre, List<FincaTratamientoVO> lFincaTratamiento) {
		super();
		this.nombre = nombre;
		this.lFincaTratamiento = lFincaTratamiento;
	}

	public FincaVO(int idFinca, String nombre, List<FincaTratamientoVO> lFincaTratamiento) {
		super();
		this.idFinca = idFinca;
		this.nombre = nombre;
		this.lFincaTratamiento = lFincaTratamiento;
	}

	public int getIdFinca() {
		return idFinca;
	}

	public void setIdFinca(int idFinca) {
		this.idFinca = idFinca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<FincaTratamientoVO> getlFincaTratamiento() {
		return lFincaTratamiento;
	}

	public void setlFincaTratamiento(List<FincaTratamientoVO> lFincaTratamiento) {
		this.lFincaTratamiento = lFincaTratamiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFinca;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (idFinca != other.idFinca)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FincaVO [idFinca=" + idFinca + ", nombre=" + nombre + ", lFincaTratamiento=" + lFincaTratamiento + "]";
	}

}
