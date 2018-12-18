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
@Table(name="fincastratamientos")
public class FincaTratamientoVO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFincaTratamiento;
	
	@ManyToOne
	@JoinColumn(name="idFinca")
	private FincaVO finca;
	
	@ManyToOne
	@JoinColumn(name="idTratamiento")
	private TratamientoVO tratamiento;
	
	private LocalDate fecha;

	public FincaTratamientoVO() {
		super();
	}

	public FincaTratamientoVO(FincaVO finca, TratamientoVO tratamiento, LocalDate fecha) {
		super();
		this.finca = finca;
		this.tratamiento = tratamiento;
		this.fecha = fecha;
	}

	public FincaTratamientoVO(int idFincaTratamiento, FincaVO finca, TratamientoVO tratamiento, LocalDate fecha) {
		super();
		this.idFincaTratamiento = idFincaTratamiento;
		this.finca = finca;
		this.tratamiento = tratamiento;
		this.fecha = fecha;
	}

	public int getIdFincaTratamiento() {
		return idFincaTratamiento;
	}

	public void setIdFincaTratamiento(int idFincaTratamiento) {
		this.idFincaTratamiento = idFincaTratamiento;
	}

	public FincaVO getFinca() {
		return finca;
	}

	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}

	public TratamientoVO getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(TratamientoVO tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idFincaTratamiento;
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
		FincaTratamientoVO other = (FincaTratamientoVO) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idFincaTratamiento != other.idFincaTratamiento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FincaTratamientoVO [idFincaTratamiento=" + idFincaTratamiento + ", fecha=" + fecha + "]";
	}

}
