/**
 * GeneradorPdfsService.java
 * Fecha de creación: Oct 4, 2019, 4:43:53 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.File;
import java.io.IOException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GenerarPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;

/**
 * servicios para generar archivos pdf
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Oct 4, 2019
 */
public interface GeneradorPdfsService {
	/**
	 * 
	 * genera el pdf de la plantilla 01 solicitud de retiro parcial de desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @return
	 */
	public byte[] generarSolicitudRetiroParcialDesempleo(DatosSolicitudRetiroParcialDesempleo solicitud, String afore,
			Boolean flujo532);

	/**
	 * 
	 * guarda el archivo en el servidor
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param contenidoArchivo
	 * @param nombreArchivo
	 * @throws IOException
	 */
	File guardarArchivoServidor(byte[] contenidoArchivo, String nombreArchivo) throws IOException;

	/**
	 * 
	 * genera el pdf de solicitud de disposicion parcial del issste
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @return
	 */
	byte[] generarSolicitudRetiroParcialDesempleoIssste(DatosSolicitudRetiroParcialDesempleoIssste solicitud,
			String afore);

	/**
	 * Servicio para generar PDF en base a una plantilla
	 * 
	 * @param generarPdf
	 * @return
	 */
	byte[] generarPdf(GenerarPdf generarPdf);

	/**
	 * 
	 * guarda el archivo en el servidor
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param contenidoArchivo
	 * @param nombreArchivo
	 * @throws IOException
	 */
	File guardarArchivo(byte[] contenidoArchivo, String rutaNombreArchivo) throws IOException;
	
	/**
	 * Metodo para generar Solicitud Retiro 
	 * @author RARREOLA
	 * @param entrada
	 * @param datosTrabajador
	 * @param datos
	 * @return
	 */
	byte[] generaSolicitudIssstePdf(DatosGeneralesDispIssste entradaParams);
	
	
	/**
	 * Generar datos pdf
	 * @param entradaParams
	 * @param trabajador
	 * @return
	 */
	byte[] generaSolicitudImssPdf(RespuestaTramite disposicionTotal, DatosTrabajador trabajador);
	
}
