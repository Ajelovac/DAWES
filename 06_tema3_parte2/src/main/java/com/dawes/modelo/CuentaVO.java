package com.dawes.modelo;

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
@Table(name="cuentas")
public class CuentaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcuenta;
	private String numero;
	private double saldo;
	
	@OneToMany(mappedBy="cuenta",cascade=CascadeType.REMOVE)
	@OnDelete(action=OnDeleteAction.CASCADE)
	List<TitularCuentaVO> titulares;

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

	public List<TitularCuentaVO> getTitulares() {
		return titulares;
	}

	public void setTitulares(List<TitularCuentaVO> titulares) {
		this.titulares = titulares;
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
		return true;
	}

	@Override
	public String toString() {
		return "CuentaVO [idcuenta=" + idcuenta + ", numero=" + numero + ", saldo=" + saldo + "]";
	}

	public CuentaVO(int idcuenta, String numero, double saldo, List<TitularCuentaVO> titulares) {
		super();
		this.idcuenta = idcuenta;
		this.numero = numero;
		this.saldo = saldo;
		this.titulares = titulares;
	}

	public CuentaVO(String numero, double saldo, List<TitularCuentaVO> titulares) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.titulares = titulares;
	}

	public CuentaVO() {
		super();
	}
	
	

}
