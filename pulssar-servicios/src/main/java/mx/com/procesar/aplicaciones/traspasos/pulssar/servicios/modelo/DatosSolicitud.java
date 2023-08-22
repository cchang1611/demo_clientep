package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase para datos de firmas de solicitud
 * @author JMGUTIEG
 *
 */
public class DatosSolicitud implements Serializable{

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * cadena de imagen de firma de trabajador
	 */
	private String firmaTrabajador;
	
	/**
	 * cadena de imagen de firma de agente
	 */
	private String firmaAgente;
	
	/**
	 * Mensaje de respuesta
	 */
	private String mensaje;
	
	/**
	 * Numero de archivos
	 */
	private Integer numeroArchivos;

	/**
	 * @return the firmaTrabajador
	 */
	public String getFirmaTrabajador() {
		return firmaTrabajador;
	}

	/**
	 * @param firmaTrabajador the firmaTrabajador to set
	 */
	public void setFirmaTrabajador(String firmaTrabajador) {
		this.firmaTrabajador = firmaTrabajador;
	}

	/**
	 * @return the firmaAgente
	 */
	public String getFirmaAgente() {
		return firmaAgente;
	}

	/**
	 * @param firmaAgente the firmaAgente to set
	 */
	public void setFirmaAgente(String firmaAgente) {
		this.firmaAgente = firmaAgente;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the numeroArchivos
	 */
	public Integer getNumeroArchivos() {
		return numeroArchivos;
	}

	/**
	 * @param numeroArchivos the numeroArchivos to set
	 */
	public void setNumeroArchivos(Integer numeroArchivos) {
		this.numeroArchivos = numeroArchivos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosSolicitud [firmaTrabajador=");
		builder.append(firmaTrabajador);
		builder.append(", firmaAgente=");
		builder.append(firmaAgente);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", numeroArchivos=");
		builder.append(numeroArchivos);
		builder.append("]");
		return builder.toString();
	}
	
	
}
