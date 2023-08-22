package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad que representa el tipo de solicitante 
 * @author JMGUTIER
 *
 */

public class BiomTipoSolicitante implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 6201318828876281891L;
	
	/**
	 * Clave tipo solicitante
	 */

	private String cvTipoSolicitante;
	
	/**
	 * Descripcion tipo solicidate
	 */

	private String chTipoSolicitante;
	
	/**
	 * Fecha de control
	 */
	private Date fechaControl;
	
	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the cvTipoSolicitante
	 */
	public String getCvTipoSolicitante() {
		return cvTipoSolicitante;
	}

	/**
	 * @param cvTipoSolicitante the cvTipoSolicitante to set
	 */
	public void setCvTipoSolicitante(String cvTipoSolicitante) {
		this.cvTipoSolicitante = cvTipoSolicitante;
	}

	/**
	 * @return the chTipoSolicitante
	 */
	public String getChTipoSolicitante() {
		return chTipoSolicitante;
	}

	/**
	 * @param chTipoSolicitante the chTipoSolicitante to set
	 */
	public void setChTipoSolicitante(String chTipoSolicitante) {
		this.chTipoSolicitante = chTipoSolicitante;
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
		builder.append("BiomTipoSolicitante [cvTipoSolicitante=");
		builder.append(cvTipoSolicitante);
		builder.append(", chTipoSolicitante=");
		builder.append(chTipoSolicitante);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
