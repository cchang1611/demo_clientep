package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


public class TramiteComparadorDetalle<T> implements Serializable{
	
	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -6911292571407710311L;

	/** Identificador del Tramite **/
	private Long idTramiteCompInf;
	
	/** Peticion */
	private T peticion;
	
	/** Fecha de Control **/
	private Date fechaControl;

	/** Usuario Modificador **/
	private String usuarioModificador;

	/**
	 * @return the idTramiteCompInf
	 */
	public Long getIdTramiteCompInf() {
		return idTramiteCompInf;
	}

	/**
	 * @param idTramiteCompInf the idTramiteCompInf to set
	 */
	public void setIdTramiteCompInf(Long idTramiteCompInf) {
		this.idTramiteCompInf = idTramiteCompInf;
	}

	/**
	 * @return the peticion
	 */
	public T getPeticion() {
		return peticion;
	}

	/**
	 * @param peticion the peticion to set
	 */
	public void setPeticion(T peticion) {
		this.peticion = peticion;
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
		builder.append("TramiteComparadorDetalle [idTramiteCompInf=");
		builder.append(idTramiteCompInf);
		builder.append(", peticion=");
		builder.append(peticion);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

	
}
