/**
 * DesCompresorUtilsImpl.java
 * Fecha de creación: Feb 10, 2021 11:24:55 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;


import java.util.HashMap;
import java.util.Map;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.DesCompresorUtils;
/**
 * Clase para utileria para descomprimir archivos zip
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
@Component
public class DesCompresorUtilsImpl implements DesCompresorUtils {

	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DesCompresorUtils.class);

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
	 * DesCompresorUtils#descomprimirMultipart(org.springframework.web.multipart.
	 * MultipartFile)
	 */
	@Override
	public Map<String, byte[]> descomprimirMultipart(byte[] byteArchivoZip) {
		Map<String, byte[]> salida = new HashMap<>();
		try (ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArchivoZip);
				ZipInputStream zipIput = new ZipInputStream(inputStream)) {
			// Lista archivos
			ZipEntry zipEntry = zipIput.getNextEntry();
			logger.error("Tamaño de archivos zip:{}",zipEntry.getSize());
			while (zipEntry != null) {
				String name = zipEntry.getName();
				String[] extension = name.split("\\.");
			    String ext=(extension[extension.length - 1]);
				logger.error("Archivo name {}", name);

				//Archivo nuevo
				ByteArrayOutputStream archivoTempByteZip = new ByteArrayOutputStream();
				ByteArrayOutputStream tiff = new ByteArrayOutputStream();
				// Tamaño de lectura
				byte[] bytes = new byte[1024];
				int length;
				if(ServiciosConstants.FORMATO_TIF_MAYUSCULA.equals(ext) || ServiciosConstants.FORMATO_TIF_MINUSCULA.equals(ext) 
						|| ServiciosConstants.FORMATO_TIFF_MINUSCULA.equals(ext) 
							|| ServiciosConstants.FORMATO_TIFF_MAYUSCULA.equals(ext)) {
					logger.error("********************************");
					logger.error("*** Inicia escritura en  ByteArrayOutputStream***:{}",name);
					while ((length = zipIput.read(bytes)) >= 0) {
						tiff.write(bytes, 0, length);
					}			
					transformacionTiff(tiff,archivoTempByteZip);
				}else {
					while ((length = zipIput.read(bytes)) >= 0) {
						archivoTempByteZip.write(bytes, 0, length);
					}
				}
			
				archivoTempByteZip.flush();
				archivoTempByteZip.close();

				salida.put(name, archivoTempByteZip.toByteArray());
				zipEntry = zipIput.getNextEntry();
			}

			zipIput.closeEntry();
			inputStream.close();

		} catch (IOException e) {
			logger.error("Error {}", e);
		}

		return salida;
	}
	
	/**
	 * transformacionTiff
	 * @param tiff
	 * @param archivoTempByteZip
	 * @return
	 */
	private void transformacionTiff(ByteArrayOutputStream tiff,ByteArrayOutputStream archivoTempByteZip) {
		logger.error("*** Entra a transformacion en Formato ***");
		InputStream input = new ByteArrayInputStream(tiff.toByteArray());
		try {
			escrituraTiffTransparencia(archivoTempByteZip,input);
		}catch(Exception e) {
			logger.error("Error transformacion tiff: {}", e);
		}
	
	}



	/**
	 * convertirTif
	 * @param nombreArchivo
	 * @param archivoTempByteZip
	 * @param archivoNuevo
	 * @param fos
	 * @return
	 */
	private void escrituraTiffTransparencia(ByteArrayOutputStream archivoTempByteZip,InputStream input) {
		logger.error("*** Entra a escrituraTiffTransparencia ***");
		byte[] con=null;
		try {
			con=convertTiffTransparencias(input);
	        archivoTempByteZip.write(con);     
		} catch (Exception e) {
			logger.error("Termina Encode Imagen Error: {}", e);
		}
	}
	
	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private  byte [] convertTiffTransparencias(InputStream inputStream) throws IOException {
		ByteArrayOutputStream outputStream = null;
		ImageOutputStream iosCatch=null;
        logger.error("********************************Inicia conversion tiff con transparencia*************");
        try {
        	BufferedImage input = ImageIO.read(inputStream); 
        	int width = input.getWidth();
        	int height = input.getHeight(); 
        	BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        	int px[] = new int[width * height]; 
        	input.getRGB(0, 0, width, height, px, 0, width);
        	bufferedImage.setRGB(0, 0, width, height, px, 0, width); 
      	    outputStream = new ByteArrayOutputStream();
      	    iosCatch = ImageIO.createImageOutputStream(outputStream);
        	ImageIO.write(bufferedImage, ServiciosConstants.FORMATO_JPG, iosCatch);
        	logger.error("********************************Termina conversion tiff con transparencia*************");
        }catch(Exception e) {
        	logger.error("convertTiffCatch Error: {}", e);
        	throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
        }
        return outputStream.toByteArray();
    }
    
}