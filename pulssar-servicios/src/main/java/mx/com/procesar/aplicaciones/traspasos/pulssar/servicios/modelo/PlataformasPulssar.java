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
 * Tabla de plataformas para la pantalla sici
 * 
 * @author dbarbosa
 */
public class PlataformasPulssar implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8875810310912542761L;

	/**
	 * ID de la entidad
	 */
	private Long idPlataforma;
	
	/**
	 * Nombre del modulo
	 */
	private String nombrePlataforma;
	
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
	 * @return the nombrePlataforma
	 */
	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	/**
	 * @param nombrePlataforma the nombrePlataforma to set
	 */
	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
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
