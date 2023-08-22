package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa la entidad de usuarios logueados comparador, mapeado a la tabla PSER_TR_REL_USER_COMPARADOR
 * 
 * @author dbarbosa
 */
public class SessionUsuario implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 540956614642014354L;

	/**
	 * Identificador único de registro
	 */
	private Long identificadorUserComparador;
	
	/**
	 * Usuario.
	 */
	private String usuario;
	
	/**
	 * Identificador de Sesión.
	 */
	private String identificadorSession;
	
	/**
	 * Identificador de Activo 1 / Inactivo 0
	 */
	private Integer nuActivo;
	
	/**
	 * Fecha de inicio de sesion.
	 */
	private Date fechaInicioSesion;
	
	/**
	 * Sesión activa.
	 */
	private Date fechaSesionActiva;
	
	/**
	 * Fecha de fin de sesion.
	 */
	private Date fechaCierreSesion;
	
	/**
	 * Fecha de última modificación
	 */
	private Date fecha;
	
	/**
	 * Usuario de última modificación
	 */
	private String usuarioModificador;

	/**
	 * @return the identificadorUserComparador
	 */
	public Long getIdentificadorUserComparador() {
		return identificadorUserComparador;
	}

	/**
	 * @param identificadorUserComparador the identificadorUserComparador to set
	 */
	public void setIdentificadorUserComparador(Long identificadorUserComparador) {
		this.identificadorUserComparador = identificadorUserComparador;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the identificadorSession
	 */
	public String getIdentificadorSession() {
		return identificadorSession;
	}

	/**
	 * @param identificadorSession the identificadorSession to set
	 */
	public void setIdentificadorSession(String identificadorSession) {
		this.identificadorSession = identificadorSession;
	}

	/**
	 * @return the nuActivo
	 */
	public Integer getNuActivo() {
		return nuActivo;
	}

	/**
	 * @param nuActivo the nuActivo to set
	 */
	public void setNuActivo(Integer nuActivo) {
		this.nuActivo = nuActivo;
	}

	/**
	 * @return the fechaInicioSesion
	 */
	public Date getFechaInicioSesion() {
		return fechaInicioSesion;
	}

	/**
	 * @param fechaInicioSesion the fechaInicioSesion to set
	 */
	public void setFechaInicioSesion(Date fechaInicioSesion) {
		this.fechaInicioSesion = fechaInicioSesion;
	}

	/**
	 * @return the fechaSesionActiva
	 */
	public Date getFechaSesionActiva() {
		return fechaSesionActiva;
	}

	/**
	 * @param fechaSesionActiva the fechaSesionActiva to set
	 */
	public void setFechaSesionActiva(Date fechaSesionActiva) {
		this.fechaSesionActiva = fechaSesionActiva;
	}

	/**
	 * @return the fechaCierreSesion
	 */
	public Date getFechaCierreSesion() {
		return fechaCierreSesion;
	}

	/**
	 * @param fechaCierreSesion the fechaCierreSesion to set
	 */
	public void setFechaCierreSesion(Date fechaCierreSesion) {
		this.fechaCierreSesion = fechaCierreSesion;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SessionUsuario [identificadorUserComparador=");
		builder.append(identificadorUserComparador);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("identificadorSession=");
		builder.append(identificadorSession);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append(", fechaInicioSesion=");
		builder.append(fechaInicioSesion);
		builder.append(", fechaSesionActiva=");
		builder.append(fechaSesionActiva);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}