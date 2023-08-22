package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * clase que contiene los atributos para la respuesta de los servicios
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class RespuestaServicio implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2897589045277772400L;
	
	/**
	 * titulo pop up
	 */
	private String titulo;
	
	/**
	 * mensaje de pop up
	 */
	private String mensaje;
	
	/**
	 * tipo de flujo
	 */
	private Integer flujo;
	
	/**
	 * tipo de flujo
	 */
	private String datos;
	
	/**
	 * Lista de objectos
	 */
	private List<?> lstObRespuesta;
	
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

	/**
	 * @return the datos
	 */
	public String getDatos() {
		return datos;
	}

	/**
	 * @param datos the datos to set
	 */
	public void setDatos(String datos) {
		this.datos = datos;
	}

	/**
	 * @return the lstObRespuesta
	 */
	public List<?> getLstObRespuesta() {
		return lstObRespuesta;
	}

	/**
	 * @param lstObRespuesta the lstObRespuesta to set
	 */
	public void setLstObRespuesta(List<?> lstObRespuesta) {
		this.lstObRespuesta = lstObRespuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("RespuestaServicio [titulo=");
		builder.append(titulo);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", flujo=");
		builder.append(flujo);
		builder.append(", datos=");
		builder.append(datos);
		builder.append("]");

		return builder.toString();
	}

}