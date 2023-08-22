/**
 * FolioPulssarSalida.java
 * Fecha de creación: Nov 21, 2019, 12:55:24 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * respuesta de la consulta del folio pulssar
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Nov 21, 2019
 */
public class FolioPulssarSalida implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -161808504128310065L;

	/**
	 * Codigo de respuesta
	 * 01- Aceptado <br>
	 * 02 - Rechazado <br>
	 */
	private String codigoOperacion;
	
	/**
	 * Mensaje de respuesta
	 */
	private String mensaje;
	
	/**
	 * id del folio pulssar
	 */
	private Long idFolioPulssar;
	
	/**
	 * id del folio pulssar padre
	 */
	private Long idFolioPulssarPadre;
	
	/**
	 * @return el atributo idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}




	/**
	 * @param idFolioPulssar parametro idFolioPulssar a actualizar
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}




	/**
	 * @return el atributo idFolioPulssarPadre
	 */
	public Long getIdFolioPulssarPadre() {
		return idFolioPulssarPadre;
	}




	/**
	 * @param idFolioPulssarPadre parametro idFolioPulssarPadre a actualizar
	 */
	public void setIdFolioPulssarPadre(Long idFolioPulssarPadre) {
		this.idFolioPulssarPadre = idFolioPulssarPadre;
	}




	/**
	 * @return el atributo codigoOperacion
	 */
	public String getCodigoOperacion() {
		return codigoOperacion;
	}




	/**
	 * @param codigoOperacion parametro codigoOperacion a actualizar
	 */
	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}




	/**
	 * @return el atributo mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}




	/**
	 * @param mensaje parametro mensaje a actualizar
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}




	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolioPulssarSalida [codigoOperacion=");
		builder.append(codigoOperacion);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", idFolioPulssarPadre=");
		builder.append(idFolioPulssarPadre);
		builder.append("]");
		return builder.toString();
	}
	
}
