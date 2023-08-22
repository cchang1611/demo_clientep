/**
 * GeneradorPdfUtils.java
 * Fecha de creaci�n: Sep 5, 2019, 12:54:08 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNombreArchivoPdf;

/**
 * utilidades para la generaci�n de los PDF's
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Sep 5, 2019
 */
public interface GeneradorPdfUtils {

	/**
	 * 
	 *  genera el nombre del archivo PDF
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param datosNombre
	 *  @return
	 */
	String obtenerNombreArchivoPdf(DatosNombreArchivoPdf datosNombre);
	
	/**
	 * 
	 *  obtener la fecha en formato dd/MM/yyyy
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param fecha
	 *  @return
	 */
	String obtenerFechaNacimientoFormatoPdf(String fecha);
}
