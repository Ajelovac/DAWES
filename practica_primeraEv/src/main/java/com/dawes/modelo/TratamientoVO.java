package com.dawes.modelo;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="tratamientos")
public class TratamientoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtratamiento;
	private String producto;
	private float dosis;
	
	@OneToMany(mappedBy="fincas", cascade={CascadeType.PERSIST})
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List <FincaTratamientoVO> ftVO;

	public TratamientoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TratamientoVO(String producto, float dosis, List<FincaTratamientoVO> ftVO) {
		super();
		this.producto = producto;
		this.dosis = dosis;
		this.ftVO = ftVO;
	}

	public TratamientoVO(int idtratamiento, String producto, float dosis, List<FincaTratamientoVO> ftVO) {
		super();
		this.idtratamiento = idtratamiento;
		this.producto = producto;
		this.dosis = dosis;
		this.ftVO = ftVO;
	}

	public int getIdtratamiento() {
		return idtratamiento;
	}

	public String getProducto() {
		return producto;
	}

	public float getDosis() {
		return dosis;
	}

	public List<FincaTratamientoVO> getFtVO() {
		return ftVO;
	}

	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setDosis(float dosis) {
		this.dosis = dosis;
	}

	public void setFtVO(List<FincaTratamientoVO> ftVO) {
		this.ftVO = ftVO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(dosis);
		result = prime * result + ((ftVO == null) ? 0 : ftVO.hashCode());
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
		if (ftVO == null) {
			if (other.ftVO != null)
				return false;
		} else if (!ftVO.equals(other.ftVO))
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
				+ ", ftVO=" + ftVO + "]";
	}

	

	
}
