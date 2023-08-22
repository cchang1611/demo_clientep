package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MEDOMING
 * @version 1.0
 */
public class TipoDoctoProbatorio implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -4807125307567315428L;
	
	/**
	 * idTipoDoctoProbatorio
	 */
	private Long idTipoDoctoProbatorio;

	/**
	 * descripcion
	 */
	private String descripcion;
	
	/**
	 * fecha control
	 */
	private Date fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;
	
	/**
	 * @return idTipoDoctoProbatorio
	 */
	public Long getIdTipoDoctoProbatorio() {
		return idTipoDoctoProbatorio;
	}

	/**
	 * @param idTipoDoctoProbatorio the idTipoDoctoProbatorio to set
	 */
	public void setIdTipoDoctoProbatorio(Long idTipoDoctoProbatorio) {
		this.idTipoDoctoProbatorio = idTipoDoctoProbatorio;
	}

	/**
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return fechaControl
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
	 * @return usuarioModificador
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
		StringBuilder cadena = new StringBuilder();
		cadena.append("TipoDoctoProbatorio [idTipoDoctoProbatorio=");
		cadena.append(idTipoDoctoProbatorio);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaControl =");
		cadena.append(fechaControl);
		cadena.append("]");

		return cadena.toString();
	}

}
