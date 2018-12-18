package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="titularescuentas")
public class TitularCuentaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtitularcuenta;
	
	@ManyToOne
	@JoinColumn(name="idtitular")
	private TitularVO titular;
	
	@ManyToOne
	@JoinColumn(name="idcuenta")
	private CuentaVO cuenta;
	
	private LocalDate fecha;
	public TitularCuentaVO(int idtitularcuenta, TitularVO titular, CuentaVO cuenta, LocalDate fecha) {
		super();
		this.idtitularcuenta = idtitularcuenta;
		this.titular = titular;
		this.cuenta = cuenta;
		this.fecha = fecha;
	}
	public TitularCuentaVO(TitularVO titular, CuentaVO cuenta, LocalDate fecha) {
		super();
		this.titular = titular;
		this.cuenta = cuenta;
		this.fecha = fecha;
	}
	public TitularCuentaVO() {
		super();
	}
	public int getIdtitularcuenta() {
		return idtitularcuenta;
	}
	public void setIdtitularcuenta(int idtitularcuenta) {
		this.idtitularcuenta = idtitularcuenta;
	}
	public TitularVO getTitular() {
		return titular;
	}
	public void setTitular(TitularVO titular) {
		this.titular = titular;
	}
	public CuentaVO getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaVO cuenta) {
		this.cuenta = cuenta;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idtitularcuenta;
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
		TitularCuentaVO other = (TitularCuentaVO) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idtitularcuenta != other.idtitularcuenta)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TitularCuentaVO [idtitularcuenta=" + idtitularcuenta + ", fecha=" + fecha + "]";
	}
	
	

}
