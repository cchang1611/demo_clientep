/**
 * ReintegroSemanasFlujosFoliosServices.java
 * Fecha de creación: May 8, 2020 11:59:29 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase para controlar flujo de los folios para Reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public interface ReintegroSemanasFlujosFoliosServices {

	/**
	 * Generar folio padre para el flujo de Historico
	 * 
	 * @param entrada
	 */
	void generarFolioPadreHistorico(SolicitudReintegroResarcimiento entrada);

	/**
	 * Generar folio hijo paso 2 y cerrar folio paso 1
	 * 
	 * @param entrada
	 */
	void generarFolioHijoDosHistorico(SolicitudReintegroResarcimiento entrada);

	/**
	 * Generar folio hijo paso 3 y cerrar folio paso 2
	 * 
	 * @param entrada
	 */
	void generarFolioHijoTresHistorico(SolicitudReintegroResarcimiento entrada);

	/**
	 * Cerrar folio hijo paso 1 y padre con estado rechazado
	 * 
	 * @param entrada
	 */
	void cerrarFolioRechazado(SolicitudReintegroResarcimiento entrada);

}
