/**
 * ResolucionParcialService.java
 * Fecha de creaci�n: 27/05/2020, 12:41:00
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
