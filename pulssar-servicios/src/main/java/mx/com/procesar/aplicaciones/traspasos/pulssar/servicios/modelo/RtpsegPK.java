package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * 
 * llave primaria de RtpSeg
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jan 10, 2020
 */
public class RtpsegPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String wsUsuario;

	private String aforeUsuario;

	private java.util.Date horaSolicitud;

	/**
	 * @return el atributo wsUsuario
	 */
	public String getWsUsuario() {
		return wsUsuario;
	}

	/**
	 * @param wsUsuario parametro wsUsuario a actualizar
	 */
	public void setWsUsuario(String wsUsuario) {
		this.wsUsuario = wsUsuario;
	}

	/**
	 * @return el atributo aforeUsuario
	 */
	public String getAforeUsuario() {
		return aforeUsuario;
	}

	/**
	 * @param aforeUsuario parametro aforeUsuario a actualizar
	 */
	public void setAforeUsuario(String aforeUsuario) {
		this.aforeUsuario = aforeUsuario;
	}

	/**
	 * @return el atributo horaSolicitud
	 */
	public java.util.Date getHoraSolicitud() {
		return horaSolicitud;
	}

	/**
	 * @param horaSolicitud parametro horaSolicitud a actualizar
	 */
	public void setHoraSolicitud(java.util.Date horaSolicitud) {
		this.horaSolicitud = horaSolicitud;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RtpsegPK)) {
			return false;
		}
		RtpsegPK castOther = (RtpsegPK)other;
		return 
			this.wsUsuario.equals(castOther.wsUsuario)
			&& this.aforeUsuario.equals(castOther.aforeUsuario)
			&& this.horaSolicitud.equals(castOther.horaSolicitud);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.wsUsuario.hashCode();
		hash = hash * prime + this.aforeUsuario.hashCode();
		hash = hash * prime + this.horaSolicitud.hashCode();
		
		return hash;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RtpsegPK [wsUsuario=");
		builder.append(wsUsuario);
		builder.append(", aforeUsuario=");
		builder.append(aforeUsuario);
		builder.append(", horaSolicitud=");
		builder.append(horaSolicitud);
		builder.append("]");
		return builder.toString();
	}
	
	
}