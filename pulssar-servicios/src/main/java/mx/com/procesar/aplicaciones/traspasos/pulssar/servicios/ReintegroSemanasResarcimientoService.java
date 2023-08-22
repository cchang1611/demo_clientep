/**
 * ReintegroSemanasResarcimientoService.java
 * Fecha de creación: Jan 3, 2020, 2:32:14 PM
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

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Servicios de reintegro semanas resarcimiento
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jan 3, 2020
 */
public interface ReintegroSemanasResarcimientoService {

	/**
	 * 
	 * Servicio de la consulta de historico de retiros
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param entrada
	 * @return
	 */
	void consultarHistoricoRetiros(SolicitudReintegroResarcimiento entrada);

	/**
	 * Se encarga de consultar historico de confirmaciones para reintegros
	 * 
	 * @param entrada
	 */
	void consultarHistoricoConfirmacion(SolicitudReintegroResarcimiento entrada);

	/**
	 * Se encarga de generar archivo PDF y linea de captura
	 * 
	 * @param entrada
	 */
	BaseRespuesta<byte[]> generarLineaCaptura(SolicitudReintegroResarcimiento entrada);
	
	
	/**
	 * Se encarga de generar la primera notificacion del flujo de historico
	 * 
	 * @param entrada
	 */
	void generarNotificacionHistorico(SolicitudReintegroResarcimiento entrada);

	/**
	 * 
	 * Obtiene el calculo del monto a reintegrar
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud 
	 * @param calculoMontoReintegrar
	 * @return
	 */
	BaseRespuesta<RespuestaMontoReintegrar> obtenerCalculoMontoReintegrar(CalculoMontoReintegrar entrada, SolicitudReintegroResarcimiento solicitud);

	/**
	 * Consulta documentos requeridos
	 * 
	 * @param entrada
	 * @return
	 */
	void consultarDocumentosRequeridos(SolicitudReintegroResarcimiento entrada);

	/**
	 * Se encarga de validar los archivos adjuntos en el flujo de confirmacion
	 * 
	 * @param archivos
	 * @param entrada
	 * @return
	 */
	RespuestaServicio obtenerArchivos(Map<String, MultipartFile> archivos, SolicitudReintegroResarcimiento entrada);

}
