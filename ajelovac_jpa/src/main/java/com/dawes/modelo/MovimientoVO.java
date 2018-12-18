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
@Table(name="movimientos")
public class MovimientoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovimiento;
	private LocalDate fecha;
	private String tipo;
	private double importe;
	
	@ManyToOne
	@JoinColumn(name="idcuenta")
	private CuentaVO cuenta;
	
	

	public MovimientoVO(int idMovimiento, LocalDate fecha, String tipo, double importe, CuentaVO cuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.cuenta = cuenta;
	}

	

	public MovimientoVO(LocalDate fecha, String tipo, double importe, CuentaVO cuenta) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.cuenta = cuenta;
	}



	public MovimientoVO() {
		super();
	}


	public int getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}



	public CuentaVO getCuenta() {
		return cuenta;
	}



	public void setCuenta(CuentaVO cuenta) {
		this.cuenta = cuenta;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idMovimiento;
		long temp;
		temp = Double.doubleToLongBits(importe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		MovimientoVO other = (MovimientoVO) obj;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idMovimiento != other.idMovimiento)
			return false;
		if (Double.doubleToLongBits(importe) != Double.doubleToLongBits(other.importe))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "MovimientosVO [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", tipo=" + tipo + ", importe="
				+ importe + "]";
	}

	
	


	


	

}
