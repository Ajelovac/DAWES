package com.dawes.modelo;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="ingredientes")
public class IngredienteVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idingrediente;
	private String denominacion;
	
	
	@OneToMany(mappedBy="ing", cascade=CascadeType.PERSIST)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Set <RecetaIngredienteVO> rec;


	public IngredienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IngredienteVO(String denominacion, Set<RecetaIngredienteVO> rec) {
		super();
		this.denominacion = denominacion;
		this.rec = rec;
	}


	public IngredienteVO(int idingrediente, String denominacion, Set<RecetaIngredienteVO> rec) {
		super();
		this.idingrediente = idingrediente;
		this.denominacion = denominacion;
		this.rec = rec;
	}


	public int getIdingrediente() {
		return idingrediente;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public Set<RecetaIngredienteVO> getRec() {
		return rec;
	}


	public void setIdingrediente(int idingrediente) {
		this.idingrediente = idingrediente;
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
		result = prime * result + idingrediente;
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
		IngredienteVO other = (IngredienteVO) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (idingrediente != other.idingrediente)
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
		return "IngredienteVO [idingrediente=" + idingrediente + ", denominacion=" + denominacion + ", rec=" + rec
				+ "]";
	}

	
	
}
