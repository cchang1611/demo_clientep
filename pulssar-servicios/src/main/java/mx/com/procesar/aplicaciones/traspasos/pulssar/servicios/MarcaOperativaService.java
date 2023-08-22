/**
 * MarcaOperativaService.java
 * Fecha de creaci�n: Nov 26, 2021, 2:44:00 PM
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizConvivencia;

/**
 * Servicios MarcaOperativa
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Nov 26, 2021
 */
public interface MarcaOperativaService {

	/**
	 *  marcaOperativaValida
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param procesar
	 *  @param claves
	 *  @return
	 */
	MatrizConvivencia marcaOperativaValida(Long procesar, String claves); 
}
