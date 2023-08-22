/**
 * GuardarArchivosReintegroService.java
 * Fecha de creaci�n: Apr 29, 2020 1:02:43 AM
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

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase para guardar los archivos de reintegro
 *
 * @author Williams Alejandro Mart�nez (WALEJAND)
 * @version 1.0
 */
public interface GuardarArchivosReintegroService {

	/**
	 * Consulta documentos requeridos
	 * 
	 * @param entrada
	 */
	void consultarDocumentosRequeridos(SolicitudReintegroResarcimiento entrada);

	/**
	 * Se encarga de guardar y validar los archivos
	 * 
	 * @param archivos
	 * @param entrada
	 * @return
	 */
	RespuestaServicio obtenerArchivos(Map<String, MultipartFile> archivos, SolicitudReintegroResarcimiento entrada);

	/**
	 * Genera mascar de archivo zip
	 * 
	 * @param entrada
	 * @return
	 */
	String generarMascaraArchivo(SolicitudReintegroResarcimiento entrada);
}
