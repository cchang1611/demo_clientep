/**
 * GeneracionZipService.java
 * Fecha de creación: Oct 4, 2021, 10:02:13 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
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
	 *  TODO [Agregar documentacion al método]
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param objetoImagen
	 *  @param datosRecepcion
	 *  @throws IOException
	 */
	String validarArchivosRecibidos(ImagenWrapper objetoImagen, EnvioArchivos datosRecepcion)
			throws IOException;
}
