/**
 * PdfUtils.java
 * Fecha de creaci�n: Nov 8, 2021, 1:28:20 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import javax.servlet.http.HttpServletRequest;

/**
 * Utilerias para pdfs
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Nov 8, 2021
 */
public interface PdfGeneradorUtils {

	/**
	 *  generar Pdf Local
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param request
	 *  @param pdf
	 *  @param claveAfore
	 *  @param folio
	 *  @param documento
	 */
	void generarPdfLocal(HttpServletRequest request, byte[] pdf, String claveAfore, String folio,
			String documento);
}
