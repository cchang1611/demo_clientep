package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;


/**
 * Definicion de metodos de operaciones en catalogo de Proceso
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 10:22:12
 */
public interface ProcesoService {

	/**
	 * Metodo que obtiene la lista de Procesos correspondientes al identificador
	 * de Modulo
	 * 
	 * @author hjramire
	 * @param idModulo
	 * @return
	 * @throws PlataformaServiciosOperativaServiceException
	 *             List<ProcesoNegocio>
	 * @since 03/01/2020, 10:22:24
	 */
	List<ProcesoNegocio> recuperaProcesosPorIdModulo(Long idModulo) throws PlataformaServiciosOperativaServiceException;
}
