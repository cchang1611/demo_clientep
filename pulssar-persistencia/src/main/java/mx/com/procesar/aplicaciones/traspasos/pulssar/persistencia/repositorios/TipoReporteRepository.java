package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoReporte;


/**
 * Repositorio para consulta de catalogo de tipo de reportes
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 13:13:15
 */
public interface TipoReporteRepository extends JpaRepository<TipoReporte, Long> {

	/**
	 * Metodo que recupera el total de tipos de reporte catalogados. Si parametro
	 * flujo = 1, entonces busca tipos Batch; Si parametro flujo = 0, entonces busca
	 * tipos Linea
	 * 
	 * @author hjramire
	 * @param flujoBachLinea
	 * @param Activo
	 * @return List<TipoReporte>
	 * @since 03/01/2020, 12:01:22
	 */
	List<TipoReporte> getByFlujoBatchAndActivo(int flujoBachLinea, int activo);

}
