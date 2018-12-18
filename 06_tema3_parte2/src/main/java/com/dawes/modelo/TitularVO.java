package com.dawes.modelo;

import java.time.LocalDate;
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
@Table(name="titulares")
public class TitularVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtitular;
	private float credito;
	private LocalDate fecha;
	private String nombre;
	
	@OneToMany(mappedBy="titular", cascade= {CascadeType.PERSIST})
//	@OnDelete(action=OnDeleteAction.CASCADE)
	List<TitularCuentaVO> cuentas;

	public int getIdtitular() {
		return idtitular;
	}

	public void setIdtitular(int idtitular) {
		this.idtitular = idtitular;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TitularCuentaVO> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<TitularCuentaVO> cuentas) {
		this.cuentas = cuentas;
	}

	public TitularVO(int idtitular, float credito, LocalDate fecha, String nombre, List<TitularCuentaVO> cuentas) {
		super();
		this.idtitular = idtitular;
		this.credito = credito;
		this.fecha = fecha;
		this.nombre = nombre;
		this.cuentas = cuentas;
	}

	public TitularVO(float credito, LocalDate fecha, String nombre, List<TitularCuentaVO> cuentas) {
		super();
		this.credito = credito;
		this.fecha = fecha;
		this.nombre = nombre;
		this.cuentas = cuentas;
	}

	public TitularVO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(credito);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idtitular;
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
		TitularVO other = (TitularVO) obj;
		if (Float.floatToIntBits(credito) != Float.floatToIntBits(other.credito))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idtitular != other.idtitular)
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
		return "TitularVO [idtitular=" + idtitular + ", credito=" + credito + ", fecha=" + fecha + ", nombre=" + nombre
				+ "]";
	}
	
	

}
