/**
 * GeneracionZipService.java
 * Fecha de creaci�n: Oct 4, 2021, 10:02:13 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenWrapper;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Oct 4, 2021
 */
public interface GeneracionZipService {
	/**
	 *  TODO [Agregar documentacion al m�todo]
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param objetoImagen
	 *  @param datosRecepcion
	 *  @throws IOException
	 */
	String validarArchivosRecibidos(ImagenWrapper objetoImagen, EnvioArchivos datosRecepcion)
			throws IOException;
}
