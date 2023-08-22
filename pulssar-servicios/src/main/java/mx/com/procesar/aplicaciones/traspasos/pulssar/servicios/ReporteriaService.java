package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaForm;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaInformacion;


/**
 * 
 * Servicio para el modulo de reporteria
 * 
 * @author EHLUNARA
 *
 */
public interface ReporteriaService {
	
	/**
	 * Metodo para  obtener la información del reporte
	 * @param form- Datos de busqueda
	 * @return
	 */
	List<ReporteriaInformacion> consultarReporteria(ReporteriaForm form);

	/**
	 * Metodo que genera los datos obtenido en excel
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Nov 19, 2019
	 * @param listaReporteria
	 * @return
	 */
	HSSFWorkbook generarReporteriaExcel(List<ReporteriaInformacion> listaReporteria);
	

}
