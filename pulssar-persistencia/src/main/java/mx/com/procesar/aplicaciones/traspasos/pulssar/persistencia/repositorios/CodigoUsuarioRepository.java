package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
/**
 * Repositoprio de codigo Usuario
 * @author JMGUTIER
 *
 */
public interface CodigoUsuarioRepository extends JpaRepository<CodigoUsuario, Long> {
	
	/**
	 * busqueda de codigo de activacion de usuario
	 * @param identificador
	 * @return
	 */
	@Query("SELECT codigoUsuario FROM CodigoUsuario codigoUsuario WHERE codigoUsuario.identificadorUsuario = :id AND codigoUsuario.tipoCodigo = :tipoC ORDER BY codigoUsuario.fechaVigencia DESC")
	List<CodigoUsuario> findByIdUsuarioAndTipoCodigo(@Param("id") Long identificador, @Param("tipoC") String tipoCodigo);
	
	/**
	 * Consulta de codigo de usuario
	 * 
	 * @param identificador
	 * @param folio
	 * @param tipoC
	 * @return
	 */
	@Query("SELECT codigoUsuario FROM CodigoUsuario codigoUsuario WHERE codigoUsuario.identificadorUsuario = :id AND codigoUsuario.folio = :folio AND codigoUsuario.tipoCodigo = :tipoC ORDER BY codigoUsuario.fechaVigencia DESC")
	List<CodigoUsuario> findByIdUsuarioAndFolioAndTipo(@Param("id") Long identificador, @Param("folio") String folio, @Param("tipoC") String tipoC);
	
	/**
	 * Consulta para obtener codigos sin usar
	 * @param estatus
	 * @param tipoCodigo
	 * @return
	 */
	@Query("SELECT codigoUsuario FROM CodigoUsuario codigoUsuario WHERE codigoUsuario.identificadorUsuario = :id AND codigoUsuario.estatus IN :estatus AND codigoUsuario.tipoCodigo = :tipoC ORDER BY codigoUsuario.fechaVigencia DESC")
	List<CodigoUsuario> findByEstatusAndTipoCodigoOrderByFechaVigenciaDesc(@Param("id") Long identificador, @Param("estatus") List<Integer> estatus, @Param("tipoC") String tipoCodigo);
}