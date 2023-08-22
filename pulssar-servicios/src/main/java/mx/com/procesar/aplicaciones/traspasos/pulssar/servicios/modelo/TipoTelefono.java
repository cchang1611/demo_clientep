package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;



/**
 * Mapeo de la tabla NSAR_TR_TELEFONO
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class TipoTelefono implements Serializable {

	/**
	 * Serializacion 
	 */
	private static final long serialVersionUID = 225410093923765789L;

	/**
	 * Identificador Tipo Telefono
	 */
	private Long idTipoTelefono;

	/**
	 * Clave Tipo Telefono
	 */
	private String claveTipoTelefono;

	/**
	 * Descripcion Tipo Telefono
	 */
	private String descTipoTelefono;

	/**
	 * /** Fecha de control
	 */
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the idTipoTelefono
	 */
	public Long getIdTipoTelefono() {
		return idTipoTelefono;
	}

	/**
	 * @param idTipoTelefono
	 *            the idTipoTelefono to set
	 */
	public void setIdTipoTelefono(Long idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}

	/**
	 * @return the claveTipoTelefono
	 */
	public String getClaveTipoTelefono() {
		return claveTipoTelefono;
	}

	/**
	 * @param claveTipoTelefono
	 *            the claveTipoTelefono to set
	 */
	public void setClaveTipoTelefono(String claveTipoTelefono) {
		this.claveTipoTelefono = claveTipoTelefono;
	}

	/**
	 * @return the descTipoTelefono
	 */
	public String getDescTipoTelefono() {
		return descTipoTelefono;
	}

	/**
	 * @param descTipoTelefono
	 *            the descTipoTelefono to set
	 */
	public void setDescTipoTelefono(String descTipoTelefono) {
		this.descTipoTelefono = descTipoTelefono;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            the fechaControl to set
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
	 * @param usuarioModificador
	 *            the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoTelefono [idTipoTelefono=");
		builder.append(idTipoTelefono);
		builder.append(", claveTipoTelefono=");
		builder.append(claveTipoTelefono);
		builder.append(", descTipoTelefono="); 
		builder.append(descTipoTelefono);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
