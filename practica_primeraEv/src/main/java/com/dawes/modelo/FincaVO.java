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
@Table(name="fincas")
public class FincaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfinca;
	private String nombre;

	@OneToMany(mappedBy="fincas", cascade={CascadeType.PERSIST})
	@OnDelete(action=OnDeleteAction.CASCADE)
	List<FincaTratamientoVO> ftVO;

	public FincaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FincaVO(String nombre, List<FincaTratamientoVO> ftVO) {
		super();
		this.nombre = nombre;
		this.ftVO = ftVO;
	}

	public FincaVO(int idfinca, String nombre, List<FincaTratamientoVO> ftVO) {
		super();
		this.idfinca = idfinca;
		this.nombre = nombre;
		this.ftVO = ftVO;
	}

	public int getIdfinca() {
		return idfinca;
	}

	public String getNombre() {
		return nombre;
	}

	public List<FincaTratamientoVO> getFtVO() {
		return ftVO;
	}

	public void setIdfinca(int idfinca) {
		this.idfinca = idfinca;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFtVO(List<FincaTratamientoVO> ftVO) {
		this.ftVO = ftVO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ftVO == null) ? 0 : ftVO.hashCode());
		result = prime * result + idfinca;
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
		FincaVO other = (FincaVO) obj;
		if (ftVO == null) {
			if (other.ftVO != null)
				return false;
		} else if (!ftVO.equals(other.ftVO))
			return false;
		if (idfinca != other.idfinca)
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
		return "FincaVO [idfinca=" + idfinca + ", nombre=" + nombre + ", ftVO=" + ftVO + "]";
	}
	
	
}
