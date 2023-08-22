/**
 * MarcaOperativaService.java
 * Fecha de creación: Nov 26, 2021, 2:44:00 PM
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
