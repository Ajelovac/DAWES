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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreceta;
	private String denominacion;
	
	@OneToMany(mappedBy="rec", cascade=CascadeType.PERSIST)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Set <RecetaIngredienteVO> rec;

	public RecetaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecetaVO(String denominacion, Set<RecetaIngredienteVO> rec) {
		super();
		this.denominacion = denominacion;
		this.rec = rec;
	}

	public RecetaVO(int idreceta, String denominacion, Set<RecetaIngredienteVO> rec) {
		super();
		this.idreceta = idreceta;
		this.denominacion = denominacion;
		this.rec = rec;
	}

	public int getIdreceta() {
		return idreceta;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public Set<RecetaIngredienteVO> getRec() {
		return rec;
	}

	public void setIdreceta(int idreceta) {
		this.idreceta = idreceta;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setRec(Set<RecetaIngredienteVO> rec) {
		this.rec = rec;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + idreceta;
		result = prime * result + ((rec == null) ? 0 : rec.hashCode());
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
		if (rec == null) {
			if (other.rec != null)
				return false;
		} else if (!rec.equals(other.rec))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecetaVO [idreceta=" + idreceta + ", denominacion=" + denominacion + ", rec=" + rec + "]";
	}

	
	
}
