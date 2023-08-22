/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * @author jcgarces
 *
 */
public class VerificacionSello implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6942007569480326413L;
	
	/**
	 * resultado de la operacion
	 */
	private Boolean existeSolicitud;
	
	/**
	 * Sello generado
	 */
	private Sello sello;
	/**
	 * @return the existeSolicitud
	 */
	public Boolean getExisteSolicitud() {
		return existeSolicitud;
	}

	/**
	 * @param existeSolicitud the existeSolicitud to set
	 */
	public void setExisteSolicitud(Boolean existeSolicitud) {
		this.existeSolicitud = existeSolicitud;
	}

	/**
	 * @return the sello
	 */
	public Sello getSello() {
		return sello;
	}

	/**
	 * @param sello the sello to set
	 */
	public void setSello(Sello sello) {
		this.sello = sello;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VerificacionSello [existeSolicitud=");
		builder.append(existeSolicitud);
		builder.append(", sello=");
		builder.append(sello);
		builder.append("]");
		return builder.toString();
	}
	


}
