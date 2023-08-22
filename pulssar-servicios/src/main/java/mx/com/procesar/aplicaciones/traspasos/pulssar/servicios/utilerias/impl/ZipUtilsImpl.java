/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ZipUtils;

/**
 * Utileria de zip
 * 
 * @author dhernand
 *
 */
@Component
public class ZipUtilsImpl implements ZipUtils {

	
	/**
	 * Revisar la interface 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ZipUtils#generaZipEntry(java.lang.String, java.lang.String)
	 */
	@Override
	public byte[] generaZipEntry(String datos,String nombreZipInterno) throws IOException {

		ByteArrayOutputStream baos  = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(baos);		
		// Obtiene los bytes de la cadena
		byte[] cadenaByte = datos.getBytes();
		zip.putNextEntry(new ZipEntry(nombreZipInterno));
		zip.write(cadenaByte, 0, cadenaByte.length);
		// cerramos las entradas
		zip.closeEntry();
		zip.flush();
		zip.close();
		
		return baos.toByteArray();

	}	
}
