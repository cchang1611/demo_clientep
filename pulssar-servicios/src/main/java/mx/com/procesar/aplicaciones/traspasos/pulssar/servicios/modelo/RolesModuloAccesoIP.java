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
 * Tabla de roles admon
 * 
 * @author dbarbosa
 */
public class RolesModuloAccesoIP implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 5697177026655056269L;

	/**
	 * ID de la entidad
	 */
	private Long idRolAcceso;
	
	/**
	 * Identficador de PSER_Tc_ROL_PULSSAR
	 */
	private Long idRol;
	
	/**
	 * Identificdor de la tabla PSER_TC_PLATAFORMA
	 */
	private Long idPlataforma;
	
	/**
	 * 0 Inactivo / 1 Activo
	 */
	private Integer activo;
	
	/**
	 * 0 Sin Modulo 1 Con Modulo
	 */
	private Integer modulo;
	
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
	 * @return the idRolAcceso
	 */
	public Long getIdRolAcceso() {
		return idRolAcceso;
	}

	/**
	 * @param idRolAcceso the idRolAcceso to set
	 */
	public void setIdRolAcceso(Long idRolAcceso) {
		this.idRolAcceso = idRolAcceso;
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
	 * @return the modulo
	 */
	public Integer getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(Integer modulo) {
		this.modulo = modulo;
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
