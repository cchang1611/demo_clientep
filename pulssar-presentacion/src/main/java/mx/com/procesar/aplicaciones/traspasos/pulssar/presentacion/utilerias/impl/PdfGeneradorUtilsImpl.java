/**
 * PdfUtilsImpl.java
 * Fecha de creación: Nov 8, 2021, 1:29:32 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PdfGeneradorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;

/**
 * Implementacion Utilerias para pdfs
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Nov 8, 2021
 */
@Component
public class PdfGeneradorUtilsImpl implements PdfGeneradorUtils {

	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(PdfGeneradorUtilsImpl.class);
    
	/**
	 * url Digitaliza
	 */
	@Value("${url.ruta.digitaliza}")
	private String urlDigitaliza;
	
	/**
	 * serive para expediente de servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicioService;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PdfUtils#generarPdfLocal(javax.servlet.http.HttpServletRequest, byte[], java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void generarPdfLocal(HttpServletRequest request, byte[] pdf, String claveAfore, String folio,
			String documento) {
		request.getSession().setAttribute(GeneradorPdfConstants.PDF_SESION, ArrayUtils.toObject(pdf));
		String urlEnvio = expedienteServicioService.generarUrlGuardadoArchivos(claveAfore, "40");
		
		StringBuilder rutaTemporalParaEscribir = new StringBuilder(urlEnvio).append(folio).append(documento).append(".pdf");
		logger.info("se guarda documento en sesion: {}", rutaTemporalParaEscribir);
		try (FileOutputStream salida = new FileOutputStream(rutaTemporalParaEscribir.toString())) {
			salida.write(pdf);
		} catch (Exception e) {
			logger.error("Error al generar el archivo", e);
		}
	}

}
