/**
 * ValidaResolucionParcialService.java
 * Fecha de creación: Aug 12, 2020 10:46:38 PM
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

import java.math.BigDecimal;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;

/**
 * Clase para 
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public interface ValidaResolucionParcialService {
	/**
	 * @param idProcesar
	 * @param idMatrizDerecho
	 * @param idEstatus
	 * @return
	 */
	SalidaGenerica obtenerResolucion(BigDecimal idProcesar, Long idMatrizDerecho, BigDecimal idEstatus);
}
