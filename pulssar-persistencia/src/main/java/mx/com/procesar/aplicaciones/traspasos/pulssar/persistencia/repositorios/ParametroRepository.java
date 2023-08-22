package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;


/**
 * Repositorio para pamatros de consulta generica
 * 
 * @author hjramire
 * @version 1.0
 * @since 14/01/2020, 20:53:10
 */
public interface ParametroRepository extends JpaRepository<ParametroReporte, Long> {

	/**
	 * Metodo que realiza consulta de parametros de reporte por idReporteGenerico y
	 * Tipo de Parametro
	 * 
	 * @author hjramire
	 * @param idReporteGenerico
	 * @param sort
	 * @return List<ParametroReporte>
	 * @since 22/01/2020, 16:42:06
	 */
	List<ParametroReporte> getByIdReporteGenericoAndTipoParametro(Long idReporteGenerico, String tipoReporte,
			Sort sort);

}
