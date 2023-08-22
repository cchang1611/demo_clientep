package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;

public interface CoppelPdfService {

	/**
	 * se agregan los datos de la pagina uno de la solicitud de retiro parcial de
	 * desempleo
	 * 
	 * @author Manuel González Valdez (mgonzava@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 */
	void agregarSolicitudRetiroPorDesempleoPaginaUnoCoppel(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException;

	/**
	 * @param solicitud
	 * @param pdfDocument
	 * @param flujo532
	 * @throws IOException
	 */
	void agregarSolicitudRetiroPorDesempleoPaginaDosCoppel(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument, Boolean flujo532) throws IOException;

}
