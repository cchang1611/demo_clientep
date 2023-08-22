package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivosDescargados;


/**
 * Archivo Zip Service
 * @author jmordone
 *
 */
public interface ArchivoZipService {
    
	/**
	 * llenarDatosZip
	 * @param in
	 * @return
	 */
	List<DatosArchivosDescargados> llenarDatosZip(InputStream in);
	
	/**
	 * abrir
	 * @param archivo
	 * @return
	 */
	ZipInputStream abrir(InputStream archivo);
	
	/**
	 * abrir
	 * @param rutaArchivo
	 * @return
	 * @throws FileNotFoundException
	 */
	ZipInputStream abrirObjecto(String rutaArchivo);
	
	/**
	 * listar
	 * @param inputStream
	 * @param archivoRecibido
	 * @param documentos
	 * @return
	 * @throws IOException
	 */
	List<DatosArchivos> listar(ZipInputStream inputStream) throws IOException;
	
	/**
	 * pdf
	 * @param archivoPdf
	 * @return
	 */
	ByteArrayOutputStream pdf(byte [] archivoPdf);
	
	/**
	 * obtenerPdfPermanencia
	 * @param pdDocument
	 * @return
	 * @throws IOException
	 */
	byte[] obtenerPdfPermanencia(PDDocument pdDocument) throws IOException;
	
	/**
	 * Abrir zip consentimiento
	 * @param rutaArchivo
	 * @return
	 */
	 ZipInputStream abrirZipConsentimiento(String rutaArchivo);
}
