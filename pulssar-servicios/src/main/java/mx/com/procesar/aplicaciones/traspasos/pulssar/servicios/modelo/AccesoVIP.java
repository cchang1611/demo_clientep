package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Modulo de reporte para la pantalla sici
 * 
 * @author dbarbosa
 */
public class AccesoVIP implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -3962333356214607067L;

	/**
	 * ID de la entidad
	 */
	private Long idAcceso;
	
	/**
	 * Nombre del modulo
	 */
	private String ipAfore;
	
	/**
	 * 1 Activo  0 Inactivo
	 */
	private String cvAfore;
	
	/**
	 * 1 Activo  0 Inactivo
	 */
	private Integer nuActivo;
	
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
	 * plataforma
	 */
	private Integer idPlataforma;

	/**
	 * @return the idAcceso
	 */
	public Long getIdAcceso() {
		return idAcceso;
	}

	/**
	 * @param idAcceso the idAcceso to set
	 */
	public void setIdAcceso(Long idAcceso) {
		this.idAcceso = idAcceso;
	}

	/**
	 * @return the ipAfore
	 */
	public String getIpAfore() {
		return ipAfore;
	}

	/**
	 * @param ipAfore the ipAfore to set
	 */
	public void setIpAfore(String ipAfore) {
		this.ipAfore = ipAfore;
	}

	/**
	 * @return the cvAfore
	 */
	public String getCvAfore() {
		return cvAfore;
	}

	/**
	 * @param cvAfore the cvAfore to set
	 */
	public void setCvAfore(String cvAfore) {
		this.cvAfore = cvAfore;
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

	/**
	 * @return the idPlataforma
	 */
	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	/**
	 * @param idPlataforma the idPlataforma to set
	 */
	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccesoVIP [idAcceso=");
		builder.append(idAcceso);
		builder.append(", ipAfore=");
		builder.append(ipAfore);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append(", cvAfore=");
		builder.append(cvAfore);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", idPlataforma=");
		builder.append(idPlataforma);
		builder.append("]");
		return builder.toString();
	}
}
