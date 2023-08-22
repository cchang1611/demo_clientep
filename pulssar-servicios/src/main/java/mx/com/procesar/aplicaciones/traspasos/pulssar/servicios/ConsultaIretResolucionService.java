package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIssste;


/**
 * Interfaz paa la consulta Resolucion 
 * @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 29, 2020
 */
public interface ConsultaIretResolucionService {
    
	/**
	 * Metodo para consulta resolucion
	 *  @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
	 *  @param procesar
	 *  @param l
	 */
	List<Resolucion> consultarIretResolucion(Long procesar, Long idDiagnostico);
	
	
	
	 
		/**
		 * Metodo para consulta resolucion
		 *  @author rarreola
		 *  @param procesar
		 *  @param l
		 */
		List<ResolucionDisposicionIssste> consultarDatosResol(Long procesar);
		

}
