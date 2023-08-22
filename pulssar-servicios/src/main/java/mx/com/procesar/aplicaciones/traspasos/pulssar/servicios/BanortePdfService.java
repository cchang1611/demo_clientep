package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;

public interface BanortePdfService {

	
	/**
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 */
	public void agregarSolicitudRetiroParcialDesempleoPaginaUnoBanorte(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException;
		
	
	/**
	 * @param solicitud
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	void generarSolicitudDisposicionParcialIsssteBanorte(DatosSolicitudRetiroParcialDesempleoIssste solicitud, PDDocument pdfDocument, int numeroPagina) throws IOException;
}
