/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Simple transporte  de la respuesta generada por el proceso de solicitud de generación de NIP
 * Viaja del controlador a la vista
 * @author MALOPEZT
 * @since 2022/02/03
 */
public class RespuestaGeneraNip implements Serializable {

	/** ID Serial */
	private static final long serialVersionUID = -4557774774136694837L;

	/**
	 * mensaje de pop up
	 */
	private String mensaje;
	
	/**
	 * tipo de flujo
	 */
	private Integer flujo;

	/** Sobrecarga toString */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ 'flujo' : '").append(flujo).append("',");
		sb.append("mensaje' : ").append(mensaje).append("' }");
		return sb.toString();
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
	 * @return the flujo
	 */
	public Integer getFlujo() {
		return flujo;
	}

	/**
	 * @param flujo the flujo to set
	 */
	public void setFlujo(Integer flujo) {
		this.flujo = flujo;
	}
}
