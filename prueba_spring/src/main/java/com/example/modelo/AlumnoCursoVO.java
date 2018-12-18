package com.example.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="alumnocurso")
public class AlumnoCursoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumnoCurso;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="idalumno")
	private AlumnoVO alumno;
	
	@ManyToOne
	@JoinColumn(name="idcurso")
	private CursoVO curso;

	public AlumnoCursoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlumnoCursoVO(Date fecha, AlumnoVO alumno, CursoVO curso) {
		super();
		this.fecha = fecha;
		this.alumno = alumno;
		this.curso = curso;
	}

	public AlumnoCursoVO(int idAlumnoCurso, Date fecha, AlumnoVO alumno, CursoVO curso) {
		super();
		this.idAlumnoCurso = idAlumnoCurso;
		this.fecha = fecha;
		this.alumno = alumno;
		this.curso = curso;
	}

	public int getIdAlumnoCurso() {
		return idAlumnoCurso;
	}

	public Date getFecha() {
		return fecha;
	}

	public AlumnoVO getAlumno() {
		return alumno;
	}

	public CursoVO getCurso() {
		return curso;
	}

	public void setIdAlumnoCurso(int idAlumnoCurso) {
		this.idAlumnoCurso = idAlumnoCurso;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setAlumno(AlumnoVO alumno) {
		this.alumno = alumno;
	}

	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idAlumnoCurso;
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
		AlumnoCursoVO other = (AlumnoCursoVO) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idAlumnoCurso != other.idAlumnoCurso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlumnoCursoVO [idAlumnoCurso=" + idAlumnoCurso + ", fecha=" + fecha + ", alumno=" + alumno + ", curso="
				+ curso + "]";
	}

	
	

}
