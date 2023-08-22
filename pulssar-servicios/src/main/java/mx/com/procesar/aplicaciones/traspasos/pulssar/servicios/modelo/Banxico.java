package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Clase para mostrar datos con derecho y sin derecho 
 * @author ANOSORIO
 *
 */
public class Banxico implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 4485090926410621638L;

	/**
	 * idDerecho
	 */
	
	private String idDerecho;
	
	/**
	 * descripcionDerecho
	 */
	private String descripcionDerecho;

	/**
	 * @return the idDerecho
	 */
	public String getIdDerecho() {
		return idDerecho;
	}

	/**
	 * @param idDerecho the idDerecho to set
	 */
	public void setIdDerecho(String idDerecho) {
		this.idDerecho = idDerecho;
	}

	/**
	 * @return the descripcionDerecho
	 */
	public String getDescripcionDerecho() {
		return descripcionDerecho;
	}

	/**
	 * @param descripcionDerecho the descripcionDerecho to set
	 */
	public void setDescripcionDerecho(String descripcionDerecho) {
		this.descripcionDerecho = descripcionDerecho;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banxico [idDerecho=");
		builder.append(idDerecho);
		builder.append(", descripcionDerecho=");
		builder.append(descripcionDerecho);
		builder.append("]");
		return builder.toString();
	}
	
	
}
