package usuarios;

import java.time.LocalDateTime;

public class CorreosVO {
	
	private int idcorreo;
	private String remitente;
	private String mensaje;
	private LocalDateTime fechahora;
	private UsuarioVO usuario;
	
	public CorreosVO(int idcorreo, String remitente, String mensaje, LocalDateTime fechahora, UsuarioVO usuario) {
		super();
		this.idcorreo = idcorreo;
		this.remitente = remitente;
		this.mensaje = mensaje;
		this.fechahora = fechahora;
		this.usuario = usuario;
	}
	
	public CorreosVO(String remitente, String mensaje, LocalDateTime fechahora, UsuarioVO usuario) {
		super();
		this.remitente = remitente;
		this.mensaje = mensaje;
		this.fechahora = fechahora;
		this.usuario = usuario;
	}

	public int getIdcorreo() {
		return idcorreo;
	}
	public void setIdcorreo(int idcorreo) {
		this.idcorreo = idcorreo;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getFechahora() {
		return fechahora;
	}
	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}
	public UsuarioVO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "CorreosVO [idcorreo=" + idcorreo + ", remitente=" + remitente + ", mensaje=" + mensaje + ", fechahora="
				+ fechahora + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechahora == null) ? 0 : fechahora.hashCode());
		result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
		CorreosVO other = (CorreosVO) obj;
		if (fechahora == null) {
			if (other.fechahora != null)
				return false;
		} else if (!fechahora.equals(other.fechahora))
			return false;
		if (mensaje == null) {
			if (other.mensaje != null)
				return false;
		} else if (!mensaje.equals(other.mensaje))
			return false;
		return true;
	}
	
	
}
