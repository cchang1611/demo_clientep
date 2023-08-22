package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;
import java.text.ParseException;

import org.apache.pdfbox.pdmodel.PDDocument;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;

public interface PeisPdfService {

	/**
	 * 
	 * se agregan los datos de la pagina uno de la solicitud de retiro parcial de
	 * desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 */
	void agregarSolicitudRetiroParcialDesempleoPaginaUno(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException;

	/**
	 * 
	 * se agregan los datos de la pagina dos de la solicitud de retiro parcial de
	 * desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 * @throws ParseException 
	 */
	void agregarSolicitudRetiroParcialDesempleoPaginaDos(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException, ParseException;

	/**
	 * 
	 * se genera el contentido de la solicitud de disposicion parcial del issste
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	void generarSolicitudDisposicionParcialIssste(DatosSolicitudRetiroParcialDesempleoIssste solicitud, PDDocument pdfDocument, int numeroPagina) throws IOException;

}
