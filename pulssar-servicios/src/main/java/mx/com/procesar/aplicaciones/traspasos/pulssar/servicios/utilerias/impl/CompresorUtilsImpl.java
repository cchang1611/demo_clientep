package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoEntradaArchivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CompresorUtils;

/**
 * Utileria para comprimir archivos contenidos en una carpeta
 * @author JMGUTIER
 *
 */
@Component
public class CompresorUtilsImpl implements CompresorUtils {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CompresorUtilsImpl.class);
	
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void agregarCarpeta(String ruta, String carpeta, ZipOutputStream zip){
		File directorio = new File(carpeta);
		for(String nombreArchivo : directorio.list()){
			if(ruta.equals(ExpresionesConstants.VACIO)){
				agregarArchivos(directorio.getName(), utileriaCadena.obtenerCadenaConcatenada(true, carpeta,ActivacionConstants.DIAGONAL,nombreArchivo), zip);
			}else{
				agregarArchivos(utileriaCadena.obtenerCadenaConcatenada(true, ruta,ActivacionConstants.DIAGONAL,directorio.getName()),  utileriaCadena.obtenerCadenaConcatenada(true, carpeta,ActivacionConstants.DIAGONAL,nombreArchivo), zip);

			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void agregarArchivos(String ruta, String directorio, ZipOutputStream zip){
		File archivo = new File(directorio);
		try(FileInputStream entrada = new FileInputStream(archivo)){
		if(archivo.isDirectory()){
			agregarCarpeta(ruta, directorio, zip);
		} else {
			byte[] buf = new byte[1024];
			int tamanio;
			zip.putNextEntry(new ZipEntry(archivo.getName()));
				while ((tamanio = entrada.read(buf))>0) {
					zip.write(buf,0,tamanio);
				}
		}
		}catch(Exception e){
			logger.error("Error al agregar archivos al comprimido: ", e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] comprimirCarpeta(String archivo, String archivoZip){
		byte[] resultadozip = null;
		try{
			ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(archivoZip));
			agregarCarpeta("", archivo, zip);
			zip.flush();
			zip.close();
			
			File auxiliarZip = new File(archivoZip);
			byte[] bytesArray = new byte[(int) auxiliarZip.length()]; 
			FileInputStream fis = new FileInputStream(auxiliarZip);
			fis.read(bytesArray);
			fis.close();
			resultadozip = bytesArray;
		}catch(Exception e){
			logger.error("Error en el proceso de compresion de archivos: ", e);
		}
		return resultadozip;
	}
	
	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
	 * CompresorUtils#guardarZip(java.util.List, java.lang.String)
	 */
	@Override
	public String guardarZip(List<FlujoEntradaArchivo> entrada, String directorioZip) {
		try (ByteArrayOutputStream archivoByteZip = new ByteArrayOutputStream();
				FileOutputStream archivoZip = new FileOutputStream(directorioZip);
				ZipOutputStream flujoByteZip = new ZipOutputStream(archivoZip)) {

			for (FlujoEntradaArchivo flujoEntrada : entrada) {
				ZipEntry entidadZip = new ZipEntry(flujoEntrada.getNombreArchivo());
				flujoByteZip.putNextEntry(entidadZip);

				// Tamaño de lectura
				byte[] bytes = new byte[1024];
				int length;

				while ((length = flujoEntrada.getFlujoEntrada().read(bytes)) >= 0) {
					flujoByteZip.write(bytes, 0, length);
					archivoByteZip.write(bytes, 0, length);
				}

				flujoEntrada.getFlujoEntrada().close();
			}

			// Cierra los outputStream
			flujoByteZip.flush();
			flujoByteZip.close();
			archivoZip.flush();
			archivoZip.close();
			archivoByteZip.flush();
			archivoByteZip.close();

			return Base64Utils.encodeToString(archivoByteZip.toByteArray());
		} catch (IOException e) {
			logger.error("Error {}", e);
		}

		return null;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
	 * CompresorUtils#generarFlujoEntrada(java.util.Map.Entry, java.lang.String)
	 */
	@Override
	public FlujoEntradaArchivo generarFlujoEntrada(Entry<String, MultipartFile> archivo, String nombreArchivo) {
		FlujoEntradaArchivo salida = new FlujoEntradaArchivo();
		try {
			salida.setFlujoEntrada(new ByteArrayInputStream(archivo.getValue().getBytes()));
			salida.setNombreArchivo(nombreArchivo);
		} catch (IOException e) {
			logger.error("Error {}", e);
		}

		return salida;
	}

}
