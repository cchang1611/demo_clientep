package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;

/**
 * SolicitudDisposicionRecursosIsssteService
 * @author RARREOLA
 *
 */
public interface SolicitudDisposicionRecursosIsssteService {

	/**
	 * @param entradaParams
	 * @param pdfDocument
	 * @throws IOException
	 */
	void agregarSolicitudIssste(DatosGeneralesDispIssste entradaParams,PDDocument pdfDocument)  throws IOException;
}
