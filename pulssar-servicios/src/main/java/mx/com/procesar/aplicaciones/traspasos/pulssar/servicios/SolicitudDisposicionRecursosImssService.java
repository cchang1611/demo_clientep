package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;

/**
 * SolicitudDisposicionRecursosIsssteService
 * @author RARREOLA
 *
 */
public interface SolicitudDisposicionRecursosImssService {

	/**
	 * @param entradaParams
	 * @param pdfDocument
	 * @throws IOException
	 */
	void agregarSolicitudImss(RespuestaTramite disposicionTotal, DatosTrabajador trabajador,PDDocument pdfDocument)  throws IOException;
}
