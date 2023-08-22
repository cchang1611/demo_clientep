/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contiene los datos base de una respuesta.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class RespuestaBase implements Serializable {

	/**
	 * Serialización de la clase.
	 */
	private static final long serialVersionUID = -2156160145681422955L;

	/**
	 * Flujo de la respuesta
	 */
	private Integer flujo;

	/**
	 * Mensaje para la respuesta en caso de que sea diferente de exitoso.
	 */
	private String mensaje;
	
	/**
	 * Titulo
	 */
	private String titulo;
	
	/**
	 * Respuesta del servicio.
	 */
	private Object respuesta;
	
	/**
	 * Constructor de la clase.
	 */
	public RespuestaBase() {
		flujo = EXITOSO.getClave();
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

	/**
	 * @return the mensajeError
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensaje(String mensajeError) {
		this.mensaje = mensajeError;
	}
	
	/**
	 * @return the respuesta
	 */
	public Object getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Object respuesta) {
		this.respuesta = respuesta;
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
