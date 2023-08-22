package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SubProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;


/**
 * Definicion de metodos de operacion en repositorio de Subproceso
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 11:37:39
 */
public interface SubProcesoService {

	/**
	 * Metodo que recupera la lista de subprocesos catalogados correspondientes al
	 * proceso
	 * 
	 * @author hjramire
	 * @param idProceso
	 * @return
	 * @throws PlataformaServiciosOperativaServiceException
	 *             List<SubProcesoNegocio>
	 * @since 03/01/2020, 11:37:50
	 */
	List<SubProcesoNegocio> recuperaSubprocesosPorIdProceso(Long idProceso) throws PlataformaServiciosOperativaServiceException;

}
