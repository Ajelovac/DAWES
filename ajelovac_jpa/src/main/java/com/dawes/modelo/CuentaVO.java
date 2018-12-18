package com.dawes.modelo;

import java.time.LocalDate;
import java.util.HashSet;
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
@Table(name="cuentas")
public class CuentaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuenta;
	private String numCuenta;
	private double saldo;
	LocalDate fecha;
	
	@OneToMany(mappedBy="cuenta",cascade=CascadeType.REMOVE)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Set<MovimientoVO> movimientos;
	



	public Set<MovimientoVO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<MovimientoVO> movimientos) {
		this.movimientos = movimientos;
	}

	public CuentaVO(String numCuenta, double saldo, LocalDate fecha, Set<MovimientoVO> movimientos) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.fecha = fecha;
		this.movimientos = movimientos;
	}

	public CuentaVO(int idCuenta, String numCuenta, double saldo, LocalDate fecha, Set<MovimientoVO> movimientos) {
		super();
		this.idCuenta = idCuenta;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.fecha = fecha;
		this.movimientos = movimientos;
	}

	public CuentaVO() {
		super();
		movimientos=new HashSet();
	}

	public CuentaVO(int int1) {
		idCuenta=int1;
	}



	public int getIdCuenta() {
		return idCuenta;
	}

	public void setidCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
		result = prime * result + idCuenta;
		result = prime * result + ((numCuenta == null) ? 0 : numCuenta.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CuentaVO other = (CuentaVO) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idCuenta != other.idCuenta)
			return false;
		if (numCuenta == null) {
			if (other.numCuenta != null)
				return false;
		} else if (!numCuenta.equals(other.numCuenta))
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CuentasVO [idCuenta=" + idCuenta + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", fecha="
				+ fecha + "]";
	}

	public void addMovimiento(MovimientoVO m) {
		movimientos.add(m);
		
	}
	
	
	
	

}
