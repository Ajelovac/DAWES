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

@Entity
@Table(name="tratamientos")
public class TratamientoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTratamiento;
	
	private String producto;
	private float dosis;
	
	@OneToMany(mappedBy="tratamiento", cascade=CascadeType.REMOVE)
	private List<FincaTratamientoVO> lFincaTratamiento;

	public TratamientoVO() {
		super();
		
		lFincaTratamiento = new ArrayList<FincaTratamientoVO>();
	}

	public TratamientoVO(String producto, float dosis, List<FincaTratamientoVO> lFincaTratamiento) {
		super();
		this.producto = producto;
		this.dosis = dosis;
		this.lFincaTratamiento = lFincaTratamiento;
	}

	public TratamientoVO(int idTratamiento, String producto, float dosis, List<FincaTratamientoVO> lFincaTratamiento) {
		super();
		this.idTratamiento = idTratamiento;
		this.producto = producto;
		this.dosis = dosis;
		this.lFincaTratamiento = lFincaTratamiento;
	}

	public int getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
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
		result = prime * result + Float.floatToIntBits(dosis);
		result = prime * result + idTratamiento;
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
		if (idTratamiento != other.idTratamiento)
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
		return "TratamientoVO [idTratamiento=" + idTratamiento + ", producto=" + producto + ", dosis=" + dosis
				+ ", lFincaTratamiento=" + lFincaTratamiento + "]";
	}

}
