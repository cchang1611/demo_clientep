package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.File;
import java.util.Map;
/**
 * Interfaz para eliminar archivos
 * @author ANOSORIO
 *
 */
public interface ObtenerValorMapaService {

	/**
	 * Borrar un archivo en una ruta
	 * @param nombreArchivo
	 */
	void recorrerListadoMapa(Map<String, String> nombreArchivo);
	
	/**
	 * Borrar un directorio
	 * @param borrar
	 */
	public void borrarDirectorio(File borrar);

	
}
