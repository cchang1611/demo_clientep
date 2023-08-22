/**
 * ExpedienteRecertificacionService.java
 * Fecha de creaci�n: 27/05/2020, 10:54:10
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteRecertificacion;

/**
 * Serrvicio Expediente Recertificacion
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 27/05/2020
 */
public interface ExpedienteRecertificacionService {
	
	/**
	 *  obtener Dato Recertificacion
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param id
	 *  @return
	 */
	ExpedienteRecertificacion obtenerDatoRecertificacion(Long id);

}
