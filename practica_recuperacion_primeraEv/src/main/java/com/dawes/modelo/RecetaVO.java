package com.dawes.modelo;

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
@Table(name="recetas")
public class RecetaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreceta;
	private String denominacion;
	
	@OneToMany(mappedBy="rec", cascade=CascadeType.PERSIST)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Set <RecetaIngredienteVO> rivo;

	public RecetaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecetaVO(String denominacion, Set<RecetaIngredienteVO> rivo) {
		super();
		this.denominacion = denominacion;
		this.rivo = rivo;
	}

	public RecetaVO(int idreceta, String denominacion, Set<RecetaIngredienteVO> rivo) {
		super();
		this.idreceta = idreceta;
		this.denominacion = denominacion;
		this.rivo = rivo;
	}

	public int getIdreceta() {
		return idreceta;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public Set<RecetaIngredienteVO> getRivo() {
		return rivo;
	}

	public void setIdreceta(int idreceta) {
		this.idreceta = idreceta;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setRivo(Set<RecetaIngredienteVO> rivo) {
		this.rivo = rivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + idreceta;
		result = prime * result + ((rivo == null) ? 0 : rivo.hashCode());
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
		RecetaVO other = (RecetaVO) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (idreceta != other.idreceta)
			return false;
		if (rivo == null) {
			if (other.rivo != null)
				return false;
		} else if (!rivo.equals(other.rivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecetaVO [idreceta=" + idreceta + ", denominacion=" + denominacion + ", rivo=" + rivo + "]";
	}
	
	
}
