/**
 * ResarcimientoService.java
 * Fecha de creación: Mar 31, 2020 12:29:25 PM
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

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;

/**
 * Clase para consumo de servicios de resarcimiento
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public interface ResarcimientoService {
	/**
	 * 
	 * Consulta de historicos
	 * 
	 * @param nss
	 * @param claveAfore
	 * @return
	 */
	public List<RespuestaHistoricoRetiros> obtenerResarcimiento(String nss, String claveAfore);

	/**
	 * 
	 * obtiene el calculo del monto a reintegrar
	 * 
	 * @param calculoMontoReintegrar
	 * @return
	 */
	public BaseRespuesta<RespuestaMontoReintegrar> obtenerCalculoMontoReintegrar(CalculoMontoReintegrar entrada);

}
