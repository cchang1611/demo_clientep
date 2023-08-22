/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * datos de Entidad para asociacion de sello con folio.
 * @author jcgarces
 *
 */
public class SelloProceso implements Serializable{

	/**
	 * seriable
	 */
	private static final long serialVersionUID = -2373766145042448812L;
	
	/**
	 * id
	 */
	private Long id;

	/**
	 * Identificador del Sello
	 */
	private Long idSello;
	
	/**
	 * clave del tipo de proceso
	 */
	private String tipoProceso;
	
	/**
	 * Fecha de control
	 */
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idSello
	 */
	public Long getIdSello() {
		return idSello;
	}

	/**
	 * @param idSello the idSello to set
	 */
	public void setIdSello(Long idSello) {
		this.idSello = idSello;
	}

	/**
	 * @return the tipoProceso
	 */
	public String getTipoProceso() {
		return tipoProceso;
	}

	/**
	 * @param tipoProceso the tipoProceso to set
	 */
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
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
		builder.append("SelloProceso [id=");
		builder.append(id);
		builder.append(", idSello=");
		builder.append(idSello);
		builder.append(", tipoProceso=");
		builder.append(tipoProceso);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	
}
