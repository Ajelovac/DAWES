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
@Table(name="cursos")
public class CursoVO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcurso;
	private String denominacion;
	
	@OneToMany(mappedBy="curso", cascade=CascadeType.PERSIST)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Set <AlumnoCursoVO> acVO;

	public CursoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoVO(String denominacion, Set<AlumnoCursoVO> acVO) {
		super();
		this.denominacion = denominacion;
		this.acVO = acVO;
	}

	public CursoVO(int idcurso, String denominacion, Set<AlumnoCursoVO> acVO) {
		super();
		this.idcurso = idcurso;
		this.denominacion = denominacion;
		this.acVO = acVO;
	}

	public int getIdcurso() {
		return idcurso;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public Set<AlumnoCursoVO> getAcVO() {
		return acVO;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setAcVO(Set<AlumnoCursoVO> acVO) {
		this.acVO = acVO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acVO == null) ? 0 : acVO.hashCode());
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + idcurso;
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
		CursoVO other = (CursoVO) obj;
		if (acVO == null) {
			if (other.acVO != null)
				return false;
		} else if (!acVO.equals(other.acVO))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (idcurso != other.idcurso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CursoVO [idcurso=" + idcurso + ", denominacion=" + denominacion + ", acVO=" + acVO + "]";
	}

	
	
}