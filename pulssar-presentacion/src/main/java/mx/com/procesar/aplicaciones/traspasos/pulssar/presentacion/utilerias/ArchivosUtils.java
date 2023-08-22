package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Feb 21, 2020
 */
public interface ArchivosUtils {

	
	/**
	 *  obtenerDocumentos
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param combo
	 *  @param requestMultipart
	 *  @return
	 */
	Map<String, Map<String, MultipartFile>> obtenerDocumentos(List<Combo> combo, Map<String, MultipartFile> multipart, Map<String, Map<String, MultipartFile>> arregloArchivos );
	
	
	/**
	 *  obtenerProcesoExpediente
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param solicitante
	 *  @return
	 */
	String obtenerProcesoExpediente(String solicitante);



	/**
	 *  getArchivoExclusion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param map
	 *  @param sol
	 *  @return
	 *  @throws IOException
	 */
	public MockMultipartFile getArchivoExclusionIssste(List<Combo> exclusion, DatosSolicitudRetiroParcialDesempleoIssste sol, String afore) throws IOException;

	
	
	/**
	 * @param exclusion
	 * @param sol
	 * @param afore
	 * @return
	 * @throws IOException
	 */
	public MockMultipartFile getArchivoExclusionMatrimonioImss(DatosTrabajador datosTrabajador) throws IOException ;
}
