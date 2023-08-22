/**
 * CanaseService.java
 * Fecha de creaci�n: 07/04/2020, 09:52:28
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Canase;

/**
 * Interfaz de metods hacia CANASE
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 07/04/2020
 */
public interface CanaseService {
	
	/**
	 *  Metodo consultar Canase
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param nss
	 *  @return
	 */
	Canase consultarCanase(String nss);

}
