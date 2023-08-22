package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase encargada del objeto de salida para el websocket
 * @author DBARBOSA
 *
 */
public class SalidaHuella implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -769026895271516327L;
	
	/**
	 * Respuesta
	 */
	private String respuesta;
	
	/**
	 * cadena
	 */
	private String cadena;

	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the cadena
	 */
	public String getCadena() {
		return cadena;
	}

	/**
	 * @param cadena the cadena to set
	 */
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	/**
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("SalidaHuella [");
		cadena.append("respuesta =");
		cadena.append(respuesta);
		cadena.append("cadena =");
		cadena.append(cadena);
		cadena.append("]");
		
		return cadena.toString();
	}
}