/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.io.IOException;

/**
 * Interface de utilerias del zip
 * @author dhernand
 *
 */
public interface ZipUtils {

	/**
	 * Genera un zip entry con el nombre y los datos propcionadas 
	 * y regresa el arreglo del bytes del mismo
	 * @param datos
	 * @param nombreZipInterno
	 * @return
	 * @throws IOException
	 */
	byte[] generaZipEntry(String datos, String nombreZipInterno) throws IOException;

}
