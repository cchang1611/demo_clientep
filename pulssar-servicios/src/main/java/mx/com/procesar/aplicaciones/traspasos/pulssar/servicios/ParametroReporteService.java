package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;


/**
 * Definicion de servicios para Parametros de Reporte
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 22/07/2020
 */
public interface ParametroReporteService {
	
	/**
	 *  Metodo que recupera 
	 *  @author Arturo Eduardo de la Cruz Perez
	 *  @param idReportePadre
	 *  @param TipoReporte
	 *  @return List<ParametroReporte>
	 *  @since 22/07/2020
	 */
	List<ParametroReporte> recuperarListaParametrosPorIdReportePadreTipoReporte(Long idReportePadre, String tipoReporte);

}
