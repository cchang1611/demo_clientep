package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.util.HashMap;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ConsultaCusSalida {

	/**
	 * codigo
	 */
	private String codigo;

	/**
	 * mensaje
	 */
	private String mensaje;
	
	/**
	 * respuesta
	 */
	private HashMap<String,String> respuesta;

	/**
	 *  getCodigo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 *  setCodigo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 *  getMensaje
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 *  setMensaje
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	/**
	 *  getRespuesta
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public HashMap<String,String> getRespuesta() {
		return respuesta;
	}

	/**
	 *  setRespuesta
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param respuesta
	 */
	public void setRespuesta(HashMap<String,String> respuesta) {
		this.respuesta = respuesta;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
