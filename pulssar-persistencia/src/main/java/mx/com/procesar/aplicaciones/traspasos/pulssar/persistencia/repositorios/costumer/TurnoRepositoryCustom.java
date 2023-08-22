package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.costumer;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.ReporteriaDatosConsulta;



/**
 * Interface para crear repositorio personalizado de Turno
 * 
 * @author EHLUNARA
 *
 */
public interface TurnoRepositoryCustom {
	
	
	/**
	 * Metodo para obtener la información para reporteria
	 * @param datosConsulta - Modelo con lo campos de con la consulta
	 * @return
	 */
	List<Object[]> obtenerReporte(ReporteriaDatosConsulta datosConsulta);
	
	

}
