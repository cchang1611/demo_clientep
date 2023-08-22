package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.io.IOException;

/**
 * Interface de Utileria lector de archivos 
 * @author JMGUTIEG
 *
 */
public interface LectorArchivoUtils {

	/**
	 * Utileria encargada de leer contenido de archivo
	 * @param ubicacion
	 * @return
	 * @throws IOException
	 */
	String obtenerContenidoArchivo(String ubicacion);

}
