/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Tabla de roles administracion para la pantalla admon
 * 
 * @author dbarbosa
 */
public class RolesAdministracion implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8619492675331791054L;

	/**
	 * ID de la entidad
	 */
	private Long idAdmon;
	
	/**
	 * Id rol pulsar
	 */
	private Long idRol;
	
	/**
	 * Id rol pulsar
	 */
	private Long idPlataforma;
	
	/**
	 * Id rol pulsar
	 */
	private Integer activo;
	
	/**
	 * Id rol pulsar
	 */
	private Long idRolAdmin;
	
	/**
	 * fecha de control
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the idAdmon
	 */
	public Long getIdAdmon() {
		return idAdmon;
	}

	/**
	 * @param idAdmon the idAdmon to set
	 */
	public void setIdAdmon(Long idAdmon) {
		this.idAdmon = idAdmon;
	}

	/**
	 * @return the idRol
	 */
	public Long getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the idPlataforma
	 */
	public Long getIdPlataforma() {
		return idPlataforma;
	}

	/**
	 * @param idPlataforma the idPlataforma to set
	 */
	public void setIdPlataforma(Long idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	/**
	 * @return the activo
	 */
	public Integer getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	/**
	 * @return the idRolAdmin
	 */
	public Long getIdRolAdmin() {
		return idRolAdmin;
	}

	/**
	 * @param idRolAdmin the idRolAdmin to set
	 */
	public void setIdRolAdmin(Long idRolAdmin) {
		this.idRolAdmin = idRolAdmin;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
