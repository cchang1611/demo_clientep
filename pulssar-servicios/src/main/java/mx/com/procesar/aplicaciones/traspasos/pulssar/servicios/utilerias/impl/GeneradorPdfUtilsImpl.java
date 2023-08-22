/**
 * GeneradorPdfUtilsImpl.java
 * Fecha de creación: Sep 5, 2019, 12:58:14 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_FECHA_NACIMIENTO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_FECHA_RENAPO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FORMATO_FECHA_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.LONGUITUD_FOLIO_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.VACIO;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNombreArchivoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.GeneradorPdfUtils;

/**
 * implementacion de las utilidades de GeneradorPdfUtils
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Sep 5, 2019
 */
@Service
public class GeneradorPdfUtilsImpl implements GeneradorPdfUtils {

	/**
	 * utilidades de fecha
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * 
	 * obtiene una cadena valida para agregar al nombre
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param cadena
	 * @return
	 */
	private String obtenerCadenaFormateada(String cadena) {
		if (cadena == null || cadena.trim().isEmpty()) {
			return VACIO;
		}

		return cadena.trim();
	}

	/**
	 * 
	 * devuelve la fecha para el nombre del archivo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param fecha
	 * @return
	 */
	protected String obtenerFechaOperacionProceso(Date fecha) {
		if (fecha == null) {
			return "";
		}

		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA_ARCHIVO);
		return formateador.format(fecha);
	}

	/**
	 * 
	 * obtiene el folio de archivo con el formato necesario
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param folioArchivo
	 * @return
	 */
	protected String obtenerFolioArchivo(String folioArchivo) {
		String folio = obtenerCadenaFormateada(folioArchivo);
		if (folio.length() > LONGUITUD_FOLIO_ARCHIVO) {
			folio = folio.substring(folio.length() - LONGUITUD_FOLIO_ARCHIVO);
		}

		return folio;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.plataformaServiciosAzteca.servicios.
	 * utileria.GeneradorPdfUtils#obtenerNombreArchivoPdf(mx.com.procesar.servicios.
	 * traspasos.plataformaServiciosAzteca.servicios.modelo.DatosNombreArchivoPdf)
	 */
	@Override
	public String obtenerNombreArchivoPdf(DatosNombreArchivoPdf datosNombre) {
		if (datosNombre == null) {
			return "";
		}

		StringBuilder nombreArchivo = new StringBuilder();
		nombreArchivo.append(obtenerCadenaFormateada(datosNombre.getClaveAfore()));
		nombreArchivo.append(obtenerCadenaFormateada(datosNombre.getClaveProceso()));
		nombreArchivo.append(obtenerCadenaFormateada(datosNombre.getCurp()));
		nombreArchivo.append(datosNombre.getTipoTrabajador());
		nombreArchivo.append(datosNombre.getClaveTipoArchivo());
		nombreArchivo.append(datosNombre.getConsecutivo());
		nombreArchivo.append(obtenerFechaOperacionProceso(datosNombre.getFechaOperacion()));
		nombreArchivo.append(obtenerFolioArchivo(datosNombre.getFolioArchivo()));
		nombreArchivo.append(datosNombre.getExtension());

		return nombreArchivo.toString();
	}

	@Override
	public String obtenerFechaNacimientoFormatoPdf(String fecha) {
		if(fecha==null || fecha.isEmpty()) {
			return "";
		}
		
		Date fechaObj = fechaUtils.convertirCadenaAFecha(fecha, FORMATO_FECHA_NACIMIENTO);
		return fechaUtils.convertirFechaACadena(fechaObj, FORMATO_FECHA_RENAPO);
		
	}
}
