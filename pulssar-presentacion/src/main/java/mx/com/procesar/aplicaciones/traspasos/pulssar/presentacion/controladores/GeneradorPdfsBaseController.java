/**
 * GeneradorPdfsBaseController.java
 * Fecha de creación: Oct 4, 2019, 7:11:29 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * clase que contiene funciones comunes para enviar PDF's
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Oct 4, 2019
 */
public abstract class GeneradorPdfsBaseController {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(GeneradorPdfsBaseController.class);
	
	/**
	 * 
	 * envio del contenido del archivo PDF
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param contenido
	 * @param response
	 */
	protected void enviarPdf(byte[] contenido, HttpServletResponse response) {
		response.setContentType("application/pdf");

		if (contenido != null) {
			ServletOutputStream out;
			try {
				out = response.getOutputStream();
				BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(contenido));
				byte[] buffer = new byte[1024];

				while (input.read(buffer, 0, buffer.length) > 0) {
					out.write(buffer);
				}

				out.flush();
				input.close();

			} catch (IOException e) {
				logger.error("error al enviar el archivo: {}", e);
			}
		}
	}
	
}
