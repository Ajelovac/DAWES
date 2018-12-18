package usuarios;

import java.time.LocalDate;
import java.util.List;

public class UsuarioVO {

	private int idUsuario;
	private String nombre;
	private String nif;
	private double sueldo;
	private LocalDate fecha;
	private List<CorreosVO> correos;

	public UsuarioVO(int idUsuario, String nombre, String nif, double sueldo, LocalDate fecha,
			List<CorreosVO> correos) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nif = nif;
		this.sueldo = sueldo;
		this.fecha = fecha;
		this.correos = correos;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<CorreosVO> getCorreos() {
		return correos;
	}

	public void setCorreos(List<CorreosVO> correos) {
		this.correos = correos;
	}

	@Override
	public String toString() {
		return "UsuarioVO [idUsuario=" + idUsuario + ", nombre=" + nombre + ", nif=" + nif + ", sueldo=" + sueldo
				+ ", fecha=" + fecha + ", correos=" + correos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		UsuarioVO other = (UsuarioVO) obj;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

	public UsuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioVO(String nombre, String nif, double sueldo, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.nif = nif;
		this.sueldo = sueldo;
		this.fecha = fecha;
	}

	public UsuarioVO(int idUsuario, String nombre, String nif, double sueldo, LocalDate fecha) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nif = nif;
		this.sueldo = sueldo;
		this.fecha = fecha;
	}

}
