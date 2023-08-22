package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivosDescargados;

/**
 * ReimpresionServiceImpl
 * @author jmordone
 *
 */
@Service
public class ArchivoZipServiceImpl implements ArchivoZipService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ArchivoZipServiceImpl.class);

	 /**
	    * Llenar objeto por zip	
	    * @param in
	    * @return
	    */
	@Override
	public List<DatosArchivosDescargados> llenarDatosZip(InputStream in) {
			
			ZipInputStream zipInput = null;
			List<DatosArchivosDescargados> lista= new ArrayList<>();
			try {		
				zipInput = abrir(in);
				lista= listarDatos(zipInput);
			}catch(Exception e ) {
				throw new BusinessException("Existe un error en la apertura del zip",e);
			}
			return lista;
	}
	   
	   
	   /**
	    * Abrir Archivo Zip 
	    * @param archivo
	    * @return
	    */
	@Override
	public ZipInputStream abrir(InputStream archivo) {
			logger.info("abriendo contenido como zip: ");
			return new ZipInputStream(archivo);
	}
	
	/**
	 * abrir
	 */
	@Override
	public ZipInputStream abrirObjecto(String rutaArchivo) {
		try {
			return abrir(rutaArchivo);
		}catch(Exception fe) {
			throw new BusinessException("Existe un error en la apertura del zip",fe);
		}
		
	}
	
	/**
	 * abrir
	 */
	@Override
	public ZipInputStream abrirZipConsentimiento(String rutaArchivo) {
		try {
			return abrir(rutaArchivo);
		}catch(FileNotFoundException fe) {
			throw new GenericException("Error no encuentra ruta en el servidor:",fe);
		}catch (Exception e) {
			throw new BusinessException("Existe un error en la apertura del zip",e);
		}
		
	}
	
	/**
	 * abrir
	 * @param nombreArchivo
	 * @return
	 * @throws FileNotFoundException
	 */
	public ZipInputStream abrir(String nombreArchivo) throws FileNotFoundException{
		logger.error("abriendo archivo: {}", nombreArchivo);		
		return new ZipInputStream(new FileInputStream(nombreArchivo));
	}
	/**
	 * listarDatos
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public List<DatosArchivosDescargados> listarDatos(ZipInputStream inputStream) throws IOException {
		List<DatosArchivosDescargados> listaArch = new ArrayList<>();
		DatosArchivosDescargados datosArchivo;
		String archivoByte;
		ZipEntry entrada;
		while (( entrada = inputStream.getNextEntry()) != null) {
			datosArchivo = new DatosArchivosDescargados();
			
			datosArchivo.setNombreArchivo(entrada.getName());	
			String[] arrayFormatos = entrada.getName().split("\\.");
			datosArchivo.setFormato(arrayFormatos[1]);
			
			ByteArrayOutputStream contenidoOS = new ByteArrayOutputStream();			
			IOUtils.copy(inputStream, contenidoOS);			
			archivoByte = DatatypeConverter.printBase64Binary(contenidoOS.toByteArray());
			datosArchivo.setByteArchivo(archivoByte);
			listaArch.add(datosArchivo);
			contenidoOS.close();
			inputStream.closeEntry();
		}
		inputStream.close();	
		logger.error("listaArchivos size tamanio{}" , listaArch.size());
		return listaArch;
	}
	
	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException 
	 * @throws RecepcionArchivoException 
	 */
	@Override
	public List<DatosArchivos> listar(ZipInputStream inputStream) throws IOException {
		List<DatosArchivos> lstArchivos = new ArrayList<>();
		DatosArchivos datos;
		ZipEntry entry;
		while (( entry = inputStream.getNextEntry()) != null) {
			datos = generarArchivo(entry,inputStream);
			lstArchivos.add(datos);
			inputStream.closeEntry();
		}
		inputStream.close();
		return lstArchivos;
	}
	
	/**
	 * Genera informacion del zip
	 * @param entrada
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private DatosArchivos generarArchivo(ZipEntry entrada,ZipInputStream inputStream)throws IOException {
		DatosArchivos datosArchivo = new DatosArchivos();
		datosArchivo.setNombreArchivo(entrada.getName());		
		datosArchivo.setFormato(separarNombreArchivo(entrada.getName())[1]);
		ByteArrayOutputStream contenidoOS = obtenerContenidoArchivo(inputStream);
		String archivoByte = obtieneArregloBytes(datosArchivo.getFormato(),contenidoOS);	
		datosArchivo.setByteArchivo(archivoByte);
		contenidoOS.close();
		return datosArchivo;
	}
	
	/**
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.traspasos.comparador.servicios.ArchivoZipService#separarNombreArchivo(java.lang.String)
	 */
	private String[] separarNombreArchivo(String nombre) {
		return nombre.split("\\.");
		
	}
	
	/**
	 * Obtien la informacion del archivo
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private ByteArrayOutputStream obtenerContenidoArchivo(ZipInputStream inputStream)throws IOException {
		ByteArrayOutputStream contenidoOS = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int len;
		while ((len = inputStream.read(buffer)) > 0) {
			contenidoOS.write(buffer, 0, len);
		}
		return contenidoOS;

	}
	
	/**
	 * Tranforma archivo en arreglo de bytes
	 * @param formato
	 * @param contenidoOS
	 * @return
	 */
	private String obtieneArregloBytes(String formato,ByteArrayOutputStream contenidoOS) {		
		String archivoByte = null;
		try {
			archivoByte = DatatypeConverter.printBase64Binary(contenidoOS.toByteArray());
		} catch (Exception e) {
			throw new BusinessException("Existe un error en la transformacion en Base 64",e);
		}
		return archivoByte;
		
	}
	
	/**
	 * convierte a pdf
	 * @param archivoPdf
	 * @return
	 */
	@Override
	public ByteArrayOutputStream pdf(byte [] archivoPdf) {
		ByteArrayOutputStream salida= new ByteArrayOutputStream();
		try {
			salida.write(archivoPdf);
		} catch (Exception e) {	
			logger.error("Error en escribir pdf",e);
		}
		return salida;	
	}
	
	
	/**
	 * obtenerPdfPermanencia
	 * @param pdDocument
	 * @return
	 * @throws IOException
	 */
	@Override
    public byte[] obtenerPdfPermanencia(PDDocument pdDocument) throws IOException {
    	 logger.error("Inicia guardado de pdf modificado"); 
    	 ByteArrayOutputStream output= new ByteArrayOutputStream();
		 pdDocument.save(output);
		 pdDocument.close();
		return output.toByteArray();
	}
	
}
