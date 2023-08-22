/**
 * RetiroParcialCalculoService.java
 * Fecha de creación: Oct 7, 2019, 5:27:51 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;

/**
 * servicios para la tabla RETI_TR_RETIRO_PARCIAL_CALCULO
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Oct 7, 2019
 */
public interface RetiroParcialCalculoService {

	/**
	 *  guarda el calculo del retiro parcial
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param entrada
	 *  @param trabajador
	 *  @param origen
	 *  @param notifica
	 */
	void guardarCalculo(ParametrosRetiroParcialCalculoImss entrada, DatosTrabajador trabajador, String origen, Boolean notifica);
}
