/**
 * SolicitudReintegroService.java
 * Fecha de creaci�n: Mar 30, 2020 3:09:07 PM
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

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase service guardar solicitud de reintegro
 *
 * @author Williams Alejandro Mart�nez (WALEJAND)
 * @version 1.0
 */
public interface SolicitudReintegroService {

	/**
	 * Generar solicitud de reintegro
	 * 
	 * @param entrada
	 */
	void guardarSolicitud(SolicitudReintegroEntrada entrada);

	/**
	 * Generar solicitud de reintegro
	 * 
	 * @param entrada
	 * @return
	 */
	void guardarSolicitud(SolicitudReintegroResarcimiento entrada);

	/**
	 * Generar pdf en base a la informacion capturada
	 * 
	 * @param entrada
	 * @return
	 */
	BaseRespuesta<byte[]> generarDatosReferencia(SolicitudReintegroResarcimiento entrada);

	/**
	 * Buscar solicitudes reintegro
	 * 
	 * @param entrada
	 * @return
	 */
	List<SolicitudReintegroEntrada> buscarSolicitudes(String entrada);

	/**
	 * Buscar solicitudes por numero de resolucion y reintegro
	 * 
	 * @param numeroReintegro
	 * @param numeroResolucion
	 * @return
	 */
	SolicitudReintegroEntrada buscarSolicitudes(String numeroReintegro, String numeroResolucion);
}
