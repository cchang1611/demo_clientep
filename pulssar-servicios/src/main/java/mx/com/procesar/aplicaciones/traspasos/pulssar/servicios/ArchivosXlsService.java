package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.InputStream;
import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCargaMasiva;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Servicio para el proceso de los archivos de excel
 * @Author Ricardo Alcantara Ramirez Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)@procesar.com
 * May 4, 2022
 */
public interface ArchivosXlsService {

	/**
	 * metodo para obtener y mappear los datos del excel
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 5, 2022
	 * @param nomArchivo
	 * @param inputStream
	 * @param usuario
	 * @return
	 */
	Map<String, Object> obtenerDatosExcel(String nomArchivo, InputStream inputStream, UsuarioLogin usuario);

	/**
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 28, 2022
	 * @param registros
	 * @return 
	 */
	RespuestaGenerica guardarCargaUsuarios(DatosCargaMasiva registros);

	/**metodo para obtener el archivoa descargar 
	 * @param user
	 * @return 
	 */
	DatosCargaMasiva obtenerArchivoUsuarios(String fechaBusqueda, UsuarioLogin user);
	
}