/**
 * ConsultarMatrizDerechoService.java
 * Fecha de creaci�n: Aug 12, 2020 5:45:51 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseSalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;

/**
 * Clase para
 *
 * @author Williams Alejandro Mart�nez (WALEJAND)
 * @version 1.0
 */
public interface ConsultarMatrizDerechoService {
	/**
	 * Valida que exista la matriz de derechos por tipo retiro y tipo de prestacion
	 * 
	 * @param tipoRetiro
	 * @param tipoPrestacion
	 * @return
	 */
	BaseSalidaGenerica<MatrizDerecho> validarMatrizDerechos(String tipoRetiro, String tipoPrestacion);
}
