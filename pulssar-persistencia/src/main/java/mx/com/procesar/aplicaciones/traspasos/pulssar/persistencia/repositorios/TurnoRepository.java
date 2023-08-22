/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Turno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.TurnoRegistrado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.costumer.TurnoRepositoryCustom;

/**
 * <p>
 * Repositorio para las operaciones relacionadas con la entidad {@link Turno}.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface TurnoRepository extends JpaRepository<Turno, Long>,TurnoRepositoryCustom  {

	/**
	 * <p>
	 * Permite buscar las Turnos para la cita a través de tipo de registro (con
	 * cita o sin cita) y la fecha de registro.
	 * </p>
	 * 
	 * <p>
	 * Para determinar es estado del turno Registrado se realiza por el estatus
	 * <b>03 - Registrado</b>.
	 * </p>
	 * 
	 * @param tipoCita
	 *            El tipo de Cita: Sin Cita o Con Cita.
	 * @param fechaDeRegistro
	 *            Fecha para el registro de consulta.
	 * 
	 * @return Las citas registradas.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * 
	 */
	@Query(name = "buscarTurnosRegistrados", nativeQuery = true)
	List<TurnoRegistrado> buscarTurnosRegistradosPorFechaRegistoYTipoCitaYSucursal(String tipoCita,
			Date fechaDeRegistro, String numeroSucursal);

	/**
	 * <p>
	 * Consulta por el numero de sucursal y una fecha de consulta para obtener
	 * el ultimo registro.
	 * </p>
	 * 
	 * @param numeroSucursal
	 * @param fechaRegistro
	 * @return
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Query("SELECT turno FROM Turno turno "
			+ "INNER JOIN turno.folioPulssar folio ON turno.folioPulssar.id = folio.id "
			+ "WHERE folio.sucursal = :sucursal AND turno.fechaRegistro >= :fechaRegistro ORDER BY turno.id DESC")
	List<Turno> buscarUltimoTurnoRegistrado(@Param("sucursal") String numeroSucursal,
			@Param("fechaRegistro") Date fechaRegistro);


	/**
	 * Consulta los Turnos por el identificador de usuario y el estatus.
	 * 
	 * @param idUSuario Identificador del USuario.
	 * @param estatus Estatus 
	 * 
	 * @return Una lista de {@link Turno}.
	 */
	@Query("SELECT turno FROM Turno turno "
			+ "INNER JOIN turno.usuario usuario ON turno.usuario.identificador = usuario.identificador "
			+ "INNER JOIN turno.claveEstatus estatus ON turno.claveEstatus.id = estatus.id "
			+ "WHERE usuario.identificador = :identificador AND estatus.id = :estatus")
	List<Turno> buscarPorIdUsuarioYEstatus(@Param("identificador") Long idUSuario, @Param("estatus") String estatus);
	
	/**
	 * Consulta los Turnos por el identificador de usuario y el estatus.
	 * 
	 * @param idUSuario Identificador del USuario.
	 * @param estatus Estatus 
	 * 
	 * @return Una lista de {@link Turno}.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Query("SELECT turno FROM Turno turno "
			+ "INNER JOIN turno.usuario usuario ON turno.usuario.identificador = usuario.identificador "
			+ "INNER JOIN turno.claveEstatus estatus ON turno.claveEstatus.id = estatus.id "
			+ "WHERE usuario.identificador = :identificador AND estatus.id = :estatus AND turno.fechaRegistro >= :fechaRegistro")
	List<Turno> buscarPorIdUsuarioYEstatusYFechaRegistro(@Param("identificador") Long idUSuario,
			@Param("estatus") String estatus, @Param("fechaRegistro") Date fechaRegistro);
	
	/**
	 * Permite consultar los Turnos a través del Folio de Servicio y un día.
	 * 
	 * @param folioServicio
	 *            Folio de Servicio.
	 * @param fechaRegistro
	 *            Fecha a consulta en primeras horas del día.
	 * @return Los turnos encontrados.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	List<Turno> findByFolioServicioAndFechaRegistroAfter(String folioServicio, Date fechaRegistro);
	
	/**
	 * Consulta des Turno por folio, sucuarsal y fecha de registro

	 * @param folioServicio
	 * @param sucursal
	 * @param fechaRegistro
	 * @return
	 */
	@Query("SELECT turno FROM Turno turno "
			+ "INNER JOIN turno.folioPulssar folio ON turno.folioPulssar.id = folio.id "
			+ "WHERE turno.folioServicio = :folioServicio AND folio.sucursal = :sucursal AND turno.fechaRegistro >= :fechaRegistro")
	List<Turno> buscarTurnoPorFolioSucursalFecha(@Param("sucursal") String sucursal, @Param("folioServicio") String folioServicio, @Param("fechaRegistro")Date fechaRegistro);
	
	/**
	 * Consulta des Turno por usuario, estatus, sucuarsal y fecha de registro
	 * 
	 * @param usuario
	 * @param estatus
	 * @param sucursal
	 * @param fechaRegistro
	 * @return
	 */
	@Query("SELECT turno FROM Turno turno "
			+ "INNER JOIN turno.folioPulssar folio ON turno.folioPulssar.id = folio.id "
			+ "WHERE turno.usuario.identificador = :idUsuario AND turno.claveEstatus.id = :estatus AND folio.sucursal = :sucursal AND turno.fechaRegistro >= :fechaRegistro")
	List<Turno> buscarTurnoPorUsuarioSucursalFecha(@Param("idUsuario") Long idUsuario, @Param("estatus") String estatus,
			@Param("sucursal") String sucursal,	@Param("fechaRegistro") Date fechaRegistro);

}
