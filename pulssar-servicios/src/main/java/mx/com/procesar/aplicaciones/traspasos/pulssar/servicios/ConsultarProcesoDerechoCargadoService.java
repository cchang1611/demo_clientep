package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
/**
 * 
 * TODO [Agregar documentacion de la clase]
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 12, 2021
 */
public interface ConsultarProcesoDerechoCargadoService {
      
	/**
	 * 
	 *  TODO [Agregar documentacion al método]
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param idProcesar
	 *  @return
	 */
	List<ProcesoDerechoCargado> consultarDerechoCargado(Long idProcesar);
}
