package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.TipoReporteMasivoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;


/**
 * Definicion de metodos de operaciones sobre repositorio de Tipo Reporte
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 11:52:50
 */
public interface TipoReporteService {

	/**
	 * Metodo que recupera lista de tipos de reporte activos que se encuentren
	 * catalogados para cada uno de los flujos (1 : Batch o 0 : Linea)
	 * 
	 * @author hjramire
	 * @return List<TipoReporte>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 03/01/2020, 11:53:01
	 */
	List<TipoReporte> recuperarTotalDeTiposReportePorFlujo(int flujoBatchLinea) throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo que recupera lista de tipos de reporte activos que se encuentren
	 * catalogados
	 * 
	 * @author hjramire
	 * @return List<TipoReporte>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 09/01/2020, 18:25:23
	 */
	List<TipoReporte> recuperarTotalDeTiposReporte() throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo para definir el tipo de reporte masivo (NSS, CURP, ID_PROCESAR, Rango
	 * de Fechas) utilizando un Enum
	 * 
	 * @author hjramire
	 * @param tipoArchivo
	 * @return TipoReporteMasivoEnum
	 * @since 03/01/2020, 11:53:30
	 */
	TipoReporteMasivoEnum obtenerTipoArchivo(String tipoArchivo);

}
