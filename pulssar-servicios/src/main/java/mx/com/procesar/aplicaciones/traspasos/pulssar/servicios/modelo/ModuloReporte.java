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
public class ModuloReporte implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -2394650144045500098L;

	/**
	 * ID de la entidad
	 */
	private Long idModuloReporte;
	
	/**
	 * Nombre del modulo
	 */
	private String nombreModulo;
	
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
	 * @return the idModuloReporte
	 */
	public Long getIdModuloReporte() {
		return idModuloReporte;
	}

	/**
	 * @param idModuloReporte the idModuloReporte to set
	 */
	public void setIdModuloReporte(Long idModuloReporte) {
		this.idModuloReporte = idModuloReporte;
	}

	/**
	 * @return the nombreModulo
	 */
	public String getNombreModulo() {
		return nombreModulo;
	}

	/**
	 * @param nombreModulo the nombreModulo to set
	 */
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModuloReporte [idModuloReporte=");
		builder.append(idModuloReporte);
		builder.append(", nombreModulo=");
		builder.append(nombreModulo);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	
}
