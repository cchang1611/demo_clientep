package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Interface de para obtener la lista de Modulos
 * @author EMARTINEZ
 */
public interface RolesReporteService {

	/**
	 * Metodo encargado de obtener la lista de modulos por idRol
	 * @param idRoles
	 * @return List<RolReporte>
	 */
	List<RolReporte> obtenerIdModuloReporte(String idRoles) throws PlataformaServiciosOperativaServiceException;
}
