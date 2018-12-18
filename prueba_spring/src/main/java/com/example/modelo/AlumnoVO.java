package com.example.modelo;

import java.util.Set;

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
@Table(name="alumnos")
public class AlumnoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idalumno;
	private String nombre;
	
	@OneToMany(mappedBy="alumno", cascade=CascadeType.PERSIST)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Set <AlumnoCursoVO> acVO;

	public AlumnoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlumnoVO(String nombre, Set<AlumnoCursoVO> acVO) {
		super();
		this.nombre = nombre;
		this.acVO = acVO;
	}

	public AlumnoVO(int idalumno, String nombre, Set<AlumnoCursoVO> acVO) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.acVO = acVO;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public Set<AlumnoCursoVO> getAcVO() {
		return acVO;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAcVO(Set<AlumnoCursoVO> acVO) {
		this.acVO = acVO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acVO == null) ? 0 : acVO.hashCode());
		result = prime * result + idalumno;
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
		AlumnoVO other = (AlumnoVO) obj;
		if (acVO == null) {
			if (other.acVO != null)
				return false;
		} else if (!acVO.equals(other.acVO))
			return false;
		if (idalumno != other.idalumno)
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
		return "AlumnoVO [idalumno=" + idalumno + ", nombre=" + nombre + ", acVO=" + acVO + "]";
	}

	
	
}
