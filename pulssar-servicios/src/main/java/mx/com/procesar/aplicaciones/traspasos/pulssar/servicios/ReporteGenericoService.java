package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;



/**
 * Definicion de metodos de operaciones en catalogo de reportes genericos
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 12:26:36
 */
public interface ReporteGenericoService {

	/**
	 * Metodo para recuperar la lista de reportes genericos a partir del subproceso,
	 * tipo de reporte y tipo de flujo
	 * 
	 * @author hjramire
	 * @param idSubpruceso
	 * @param idTipoReporte
	 * @param tipoProcesamiento
	 * @param idRoles
	 * @return List<ReporteCompleto>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 09/01/2020, 18:30:10
	 */
	List<ReporteCompleto> obtenerListaReportesPorSubprocesoTipoReporte(Long idSubproceso, Long idTipoReporte,
			Integer tipoProcesamiento, String idRoles) throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo que recupera lista de reportes genericos a partir del subproceso y
	 * tipo de reporte
	 * 
	 * @author hjramire
	 * @param idSubpruceso
	 * @param idTipoReporte
	 * @return List<ReporteGenerico>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 09/01/2020, 18:32:06
	 */
	List<ReporteGenerico> obtenerTotalReportesPorSubprocesoTipoReporte(Long idSubproceso, Long idTipoReporte)
			throws PlataformaServiciosOperativaServiceException;
	
	/**
	 * Metodo que recupera tipo de reporte por ID
	 * 
	 * @author hjramire
	 * @param cvTipoReporte
	 * @return ReporteGenerico
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 09/01/2020, 18:30:34
	 */
	ReporteCompleto obtenerTipoReportePorClave(Long cvTipoReporte) throws PlataformaServiciosOperativaServiceException;

}
