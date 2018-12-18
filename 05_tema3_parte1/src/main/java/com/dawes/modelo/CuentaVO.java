package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuentas")
public class CuentaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcuenta;
	private String numero;
	private double saldo;
	
	@ManyToOne
	@JoinColumn(name="idtitular")
	private TitularVO titular;
	public CuentaVO(int idcuenta, String numero, double saldo, TitularVO titular) {
		super();
		this.idcuenta = idcuenta;
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}
	public CuentaVO(String numero, double saldo, TitularVO titular) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}
	public CuentaVO() {
		super();
	}
	public CuentaVO(String numero, double saldo) {
		this.numero=numero;
		this.saldo=saldo;
	}
	public int getIdcuenta() {
		return idcuenta;
	}
	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public TitularVO getTitular() {
		return titular;
	}
	public void setTitular(TitularVO titular) {
		this.titular = titular;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcuenta;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
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
		if (idcuenta != other.idcuenta)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CuentaVO [idcuenta=" + idcuenta + ", numero=" + numero + ", saldo=" + saldo + "Titular"+titular.getNombre()+"]";
	}
	
	
	
	

}
