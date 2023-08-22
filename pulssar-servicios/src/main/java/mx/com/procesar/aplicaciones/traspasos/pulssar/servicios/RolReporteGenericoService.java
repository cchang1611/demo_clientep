package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteGenerico;



/**
 * Definicion de metodos de operaciones en catalogo de reportes genericos por idRol
 * 
 * @author DGSANCHEZ
 * @version 1.0
 */
public interface RolReporteGenericoService {

	/**
	 * Metodo para recuperar la lista de reportes genericos a partir del idRol,
	 * tipo de reporte y tipo de flujo
	 * 
	 * @author DGSANCHEZ
	 * @param idRoles
	 * @return List<RolReporteGenerico>
	 */
	List<RolReporteGenerico> recuperarIdReportePorRol(String idRoles);

}
