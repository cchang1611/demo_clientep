/**
 * ResolucionParcialService.java
 * Fecha de creación: 27/05/2020, 12:41:00
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

/**
 * Interfaz Resolucion Parcial
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 27/05/2020
 */
public interface ResolucionParcialService {
	
	/**
	 *  Consultar resolucion parcial
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param idProcesar
	 *  @param tipoPrestacion
	 *  @return
	 */
	String obtenerResolucionParcial(Long idProcesar, String tipoPrestacion);
	
	/**
	 *  Obtener disposicion ISSSTE
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param idProcesar
	 *  @param proceso
	 *  @param tipoOperacion
	 *  @return
	 */
	String obtenerDisposicion(Long idProcesar, String proceso, String tipoOperacion);

}
