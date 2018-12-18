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
@Table(name="Tratamiento")
public class TratamientoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtratamiento;
	private String producto;
	private float dosis;
	
	@ManyToMany
	@JoinTable(name="Tratamiento")
	Set<FincaVO> fincas;

	public TratamientoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TratamientoVO(int idtratamiento) {
		super();
		this.idtratamiento = idtratamiento;
	}

	public TratamientoVO(int idtratamiento, String producto, float dosis, Set<FincaVO> fincas) {
		super();
		this.idtratamiento = idtratamiento;
		this.producto = producto;
		this.dosis = dosis;
		this.fincas = fincas;
	}

	public int getIdtratamiento() {
		return idtratamiento;
	}

	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public float getDosis() {
		return dosis;
	}

	public void setDosis(float dosis) {
		this.dosis = dosis;
	}

	public Set<FincaVO> getFincas() {
		return fincas;
	}

	public void setFincas(Set<FincaVO> fincas) {
		this.fincas = fincas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(dosis);
		result = prime * result + ((fincas == null) ? 0 : fincas.hashCode());
		result = prime * result + idtratamiento;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		TratamientoVO other = (TratamientoVO) obj;
		if (Float.floatToIntBits(dosis) != Float.floatToIntBits(other.dosis))
			return false;
		if (fincas == null) {
			if (other.fincas != null)
				return false;
		} else if (!fincas.equals(other.fincas))
			return false;
		if (idtratamiento != other.idtratamiento)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TratamientoVO [idtratamiento=" + idtratamiento + ", producto=" + producto + ", dosis=" + dosis
				+ ", fincas=" + fincas + "]";
	}

	

}
