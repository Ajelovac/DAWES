package com.dawes.modelo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="fincastratamientos")
public class FincaTratamientoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfincatratamiento;

	
	@ManyToOne
	@JoinColumn(name="idfinca")
	private FincaVO finca;
	
	@ManyToOne
	@JoinColumn(name="idtratamiento")
	private TratamientoVO tratamiento;

	private LocalDate fecha;

	public FincaTratamientoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FincaTratamientoVO(FincaVO finca, TratamientoVO tratamiento, LocalDate fecha) {
		super();
		this.finca = finca;
		this.tratamiento = tratamiento;
		this.fecha = fecha;
	}

	public FincaTratamientoVO(int idfincatratamiento, FincaVO finca, TratamientoVO tratamiento, LocalDate fecha) {
		super();
		this.idfincatratamiento = idfincatratamiento;
		this.finca = finca;
		this.tratamiento = tratamiento;
		this.fecha = fecha;
	}

	public int getIdfincatratamiento() {
		return idfincatratamiento;
	}

	public FincaVO getFinca() {
		return finca;
	}

	public TratamientoVO getTratamiento() {
		return tratamiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setIdfincatratamiento(int idfincatratamiento) {
		this.idfincatratamiento = idfincatratamiento;
	}

	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}

	public void setTratamiento(TratamientoVO tratamiento) {
		this.tratamiento = tratamiento;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((finca == null) ? 0 : finca.hashCode());
		result = prime * result + idfincatratamiento;
		result = prime * result + ((tratamiento == null) ? 0 : tratamiento.hashCode());
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
		if (finca == null) {
			if (other.finca != null)
				return false;
		} else if (!finca.equals(other.finca))
			return false;
		if (idfincatratamiento != other.idfincatratamiento)
			return false;
		if (tratamiento == null) {
			if (other.tratamiento != null)
				return false;
		} else if (!tratamiento.equals(other.tratamiento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FincaTratamientoVO [idfincatratamiento=" + idfincatratamiento + ", finca=" + finca + ", tratamiento="
				+ tratamiento + ", fecha=" + fecha + "]";
	}
	
	
	
}
