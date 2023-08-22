package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;


import java.util.List;
import java.util.Map.Entry;
import java.util.zip.ZipOutputStream;

import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoEntradaArchivo;



/**
 * Interfaz de la utileria compresor
 * @author JMGUTIER
 *
 */
public interface CompresorUtils {
	
	/**
	 * Metodo encargado de agregar nombre carpeta a comprimido
	 * @param ruta
	 * @param carpeta
	 * @param zip
	 */
	public void agregarCarpeta(String ruta, String carpeta, ZipOutputStream zip);
	
	/**
	 * Metodo encargado de agrefar archivos al comprimido
	 * @param ruta
	 * @param directorio
	 * @param zip
	 */
	public void agregarArchivos(String ruta, String directorio, ZipOutputStream zip);
	
	/**
	 * Metodo encargado de comprimir archivos
	 * @param archivo
	 * @param archivoZip
	 * @return 
	 */
	public byte[] comprimirCarpeta(String archivo,String archivoZip);
	
	
	/**
	 * Lee InputStream de archivos en memoria para generar zip en la ruta
	 * especifica
	 * 
	 * @param entrada
	 * @param directorioZip
	 */
	String guardarZip(List<FlujoEntradaArchivo> entrada, String directorioZip);
	
	/**
	 * Genera InputStream de una entidad MultipartFile
	 * 
	 * @param archivo
	 * @param nombreArchivo
	 * @return
	 */
	FlujoEntradaArchivo generarFlujoEntrada(Entry<String, MultipartFile> archivo, String nombreArchivo);
}