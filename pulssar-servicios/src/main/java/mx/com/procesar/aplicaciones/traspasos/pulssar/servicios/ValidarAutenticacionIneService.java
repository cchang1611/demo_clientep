/**
 * ValidarAutenticacionIneService.java
 * Fecha de creaci�n: Jun 24, 2021, 12:41:02 PM
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionEntrada;

/**
 * Interfaz Validar Autenticacion Ine
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Jun 24, 2021
 */
public interface ValidarAutenticacionIneService {
	
	/**
	 * validaciones consumo servicio INE
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param notificarAutenticacionEntrada
	 *  @param huellaDactilar
	 *  @return
	 */
	String validarIne(NotificarAutenticacionEntrada notificarAutenticacionEntrada, HuellaDactilar huellaDactilar);

}
