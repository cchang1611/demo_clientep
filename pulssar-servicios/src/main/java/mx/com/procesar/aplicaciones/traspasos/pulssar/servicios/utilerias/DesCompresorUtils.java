/**
 * DesCompresorUtils.java
 * Fecha de creaci�n: Feb 10, 2021 11:24:12 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.util.Map;

/**
 * Clase para
 *
 * @author Williams Alejandro Mart�nez (walejand)
 * @version 1.0
 */
public interface DesCompresorUtils {

	/**
	 * Descomprimir archivo zip Multipart
	 * 
	 * @param archivoZip
	 * @return
	 */
	public Map<String, byte[]> descomprimirMultipart(byte[] byteArchivoZip);
}
