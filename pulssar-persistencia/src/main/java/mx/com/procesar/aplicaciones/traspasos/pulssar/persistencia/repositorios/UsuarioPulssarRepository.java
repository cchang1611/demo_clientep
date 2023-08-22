package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;

/**
 * Repositorio para el manejo de usuario
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface UsuarioPulssarRepository  extends JpaRepository<UsuarioPulssar, Long> {
	
	/**
	 * Consulta de usuario 
	 * 
	 * @param usuario
	 * @return
	 */
	List<UsuarioPulssar> findByUsuario(String usuario);
	
	/**
	 * Consulta de usuario activo
	 * 
	 * @param usuario
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.usuario = :user AND usuarioPulssar.estatus IN :estatus ORDER BY usuarioPulssar.identificador DESC")
	List<UsuarioPulssar> findUsuarioActivo(@Param("user") String usuario, @Param("estatus") List<String> estatus);
	
	/**
	 * Busqueda de usuario por usuario y estatus
	 * 
	 * @param usuario
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.usuario = :usuario AND usuarioPulssar.estatus = :estatus ORDER BY usuarioPulssar.identificador DESC" )
	List<UsuarioPulssar> findUsuarioByUsuarioAndEstatus(@Param("usuario")String usuario, @Param("estatus") String estatus);
	
	/**
	 * Consulta de usuarios por compania y estatus
	 * @param claveOrganizacion
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.claveOrganizacion = :clave AND usuarioPulssar.estatus IN :estatus")
	List<UsuarioPulssar> findByOrganizacion(@Param("clave")String claveOrganizacion,@Param("estatus") List<String> estatus);
	
	/**
	 * Consulta de roles del usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@Query("SELECT usuario.identificador, usuario.usuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.estatus, usuario.claveOrganizacion, usuario.fecha, userRol.rolUsuario.claveRol, userRol.rolUsuario.descripcionRol FROM UsuarioPulssar usuario "
			+"INNER JOIN UsuarioRol userRol ON usuario.identificador = userRol.identificadorUsuario "
			+"WHERE usuario.usuario = :usuario")
	List<Object[]> findUsuariosRoles(@Param("usuario")String usuario);
	
	/**
	 * Consulta encargado de buscar usuarios 00 con codigos existentes
	 * @param organizacion
	 * @param estatus
	 * @return
	 */
	@Query("SELECT DISTINCT usuario.identificador, usuario.usuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.claveOrganizacion, usuario.fecha, codigo.fechaVigencia "
			+ "FROM UsuarioPulssar usuario "
			+ "JOIN FETCH CodigoUsuario codigo ON usuario.identificador = codigo.identificadorUsuario "
			+ "WHERE usuario.claveOrganizacion = :corg AND usuario.estatus = :cstatus AND codigo.estatus = :estatusC AND codigo.tipoCodigo = :tipoC ORDER BY usuario.identificador DESC")
	List<Object[]> findUsuariosInactivosCodigoVencido(@Param("corg") String organizacion, @Param("cstatus") String estatus, @Param("estatusC") Integer estatusCodigo, @Param("tipoC") String tipoCodigo);
	
	/**
	 * Consulta nativa para obtener los usuarios dependiendo de su estatus y rol
	 * 
	 * @param claveAfore
	 * @param estatusUsuario
	 * @param rol
	 * @param estatusRol
	 * @return
	 */
	@Query(name = "findUsuarios", nativeQuery = true)
	List<UsuarioPulssar> findUsuariosAdministradores(String claveAfore, String estatusUsuario, String rol, Integer estatusRol);
	
	/**
	 * Busqueda de usuarios
	 * 
	 * @param claveAfore
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	@Query(" SELECT usuario.identificador, usuario.usuario, userNick.nickUsuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.estatus, usuario.claveOrganizacion, usuario.fecha, userRol.rolUsuario.claveRol, userRol.rolUsuario.descripcionRol, usuario.chSucursal, usuario.chOficina, usuario.zona"
			+ " FROM UsuarioPulssar usuario "
			+ " INNER JOIN UsuarioRol userRol ON usuario.identificador = userRol.identificadorUsuario "
			+ " LEFT OUTER JOIN UsuarioNickPulssar userNick ON usuario.identificador = userNick.identificadorUsuario " 
			+ " WHERE usuario.claveOrganizacion = :corg AND userRol.estatus = :nstatus AND usuario.estatus IN :cstatus ORDER BY usuario.identificador ASC")
	List<Object[]> findUsuariosConRol(@Param("corg") String claveOrganizacion, @Param("nstatus") Integer estatusRol, @Param("cstatus") List<String> estatus);
	
	/**
	 * Busqueda de usuarios
	 * 
	 * @param claveAfore
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	@Query(" SELECT usuario.identificador, usuario.usuario, userNick.nickUsuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.estatus, usuario.claveOrganizacion, usuario.fecha, userRol.rolUsuario.claveRol, userRol.rolUsuario.descripcionRol, usuario.chSucursal, usuario.chOficina, usuario.zona"
			+ " FROM UsuarioPulssar usuario "
			+ " INNER JOIN UsuarioRol userRol ON usuario.identificador = userRol.identificadorUsuario "
			+ " LEFT OUTER JOIN UsuarioNickPulssar userNick ON usuario.identificador = userNick.identificadorUsuario " 
			+ " WHERE userRol.rolUsuario.claveRol = :crol AND userRol.estatus = :nstatus AND usuario.estatus IN :cstatus ORDER BY usuario.identificador ASC")
	List<Object[]> findUsuariosConRol(@Param("nstatus") Integer estatusRol, @Param("cstatus") List<String> estatus, @Param("crol") String claveRol);
	
	/**
	 * metodo para busqueda de usuarios para baja
	 * @param claveAfore
	 * @param estatus
	 * @return
	 */
	@Query(" SELECT usuario.identificador, usuario.usuario, userNick.nickUsuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.claveOrganizacion, usuario.fecha "
			+ " FROM UsuarioPulssar usuario "
			+ " LEFT OUTER JOIN UsuarioNickPulssar userNick ON usuario.identificador = userNick.identificadorUsuario " 
			+ " WHERE usuario.claveOrganizacion = :corg AND usuario.estatus IN :cstatus ORDER BY usuario.identificador ASC")
	List<Object[]> findUsuariosSinRol(@Param("corg") String claveAfore, @Param("cstatus") List<String> estatus);
	
	/**
	 * metodo para busqueda de usuarios para baja
	 * @param claveAfore
	 * @param estatus
	 * @return
	 */
	@Query(" SELECT usuario.identificador, usuario.usuario, userNick.nickUsuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.claveOrganizacion, usuario.fecha "
			+ " FROM UsuarioPulssar usuario "
			+ " INNER JOIN UsuarioRol userRol ON usuario.identificador = userRol.identificadorUsuario "
			+ " LEFT OUTER JOIN UsuarioNickPulssar userNick ON usuario.identificador = userNick.identificadorUsuario " 
			+ " WHERE userRol.rolUsuario.claveRol = :crol AND userRol.estatus = :cestatus AND usuario.estatus IN :cstatus ORDER BY usuario.identificador ASC")
	List<Object[]> findUsuariosSinRolSICI(@Param("cstatus") List<String> estatus, @Param("crol") String claveRol, @Param("cestatus") Integer status);

	/**
	 * Realiza la consulta por clave de organizacion y estatus
	 * @param usuraio
	 * @param claveOrganizacion
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar "
			+ " WHERE usuarioPulssar.claveOrganizacion = :clave AND usuarioPulssar.estatus IN :estatus ORDER BY usuarioPulssar.identificador DESC")
	List<UsuarioPulssar> findByUsuarioAndEstatus(@Param("clave")String claveOrganizacion, @Param("estatus") List<String> estatus);
	
	/**
	 * Realiza la consulta de usuarios por clave de organizacion y estatus
	 * @param usuario
	 * @param claveOrganizacion
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar "
			+ " WHERE usuarioPulssar.usuario = :usuario AND usuarioPulssar.claveOrganizacion = :clave AND usuarioPulssar.estatus IN :estatus ORDER BY usuarioPulssar.identificador DESC")
	List<UsuarioPulssar> findByUsuarioAndEstatus(@Param("usuario") String usuario, @Param("clave")String claveOrganizacion, @Param("estatus") List<String> estatus);

	/**
	 * Realiza la consulta para validar si el correo se encuentra para otro usuario
	 * 
	 * @param correo
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.email = :correo AND usuarioPulssar.estatus in :estatus ORDER BY usuarioPulssar.identificador DESC")
	List<UsuarioPulssar> findByEmail(@Param("correo") String correo, @Param("estatus") List<String> estatus);
	
	/**
	 * Realiza la consulta para validar si el celular se encuentra para otro usuario
	 * 
	 * @param celular
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.celular = :telefono AND usuarioPulssar.estatus IN :estatus ORDER BY usuarioPulssar.identificador DESC")
	List<UsuarioPulssar> findByCelular(@Param("telefono") String telefono, @Param("estatus") List<String> estatus);
	
	/**
	 * Metodo encargado de buscar usuarios inactivos
	 * @param claveAfore
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.claveOrganizacion = :clave AND usuarioPulssar.estatus = :estatus ORDER BY usuarioPulssar.identificador DESC")
	List<UsuarioPulssar> findUsuariosInactivos(@Param("clave") String claveOrganizacion, @Param("estatus") String estatus);
	
	/**
	  * Busqueda de usuario por id y estatus
	  * @param id
	  * @param estatus
	  * @return
	  */
	@Query("SELECT usuario FROM UsuarioPulssar usuario WHERE usuario.identificador = :id AND usuario.estatus IN :estatus")
	UsuarioPulssar findByIdAndEstatus(@Param("id") Long id, @Param("estatus") List<String> estatus);
	
	/**
	 * Busqueda de usuario por clave organizacion y estatus
	 * @param claveOrganizacion
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuario FROM UsuarioPulssar usuario WHERE usuario.claveOrganizacion = :clave AND usuario.estatus = :estatus")
	List<UsuarioPulssar> findByClaveOrganizacionAndEstatus(@Param("clave") String claveOrganizacion, @Param("estatus") String estatus);
	
	/**
	 * Busqueda de usuario a modificar
	 * 
	 * @param claveAfore
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	@Query(" SELECT usuario.identificador, usuario.usuario, userNick.nickUsuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.estatus, usuario.claveOrganizacion, usuario.fecha, userRol.rolUsuario.claveRol, userRol.rolUsuario.descripcionRol, usuario.chSucursal, usuario.chOficina, usuario.zona"
			+ " FROM UsuarioPulssar usuario "
			+ " INNER JOIN UsuarioRol userRol ON usuario.identificador = userRol.identificadorUsuario "
			+ " LEFT OUTER JOIN UsuarioNickPulssar userNick ON usuario.identificador = userNick.identificadorUsuario " 
			+ " WHERE usuario.claveOrganizacion = :corg AND userRol.estatus = :nstatus AND usuario.estatus IN :cstatus "
			+ " AND (usuario.usuario = :userMod OR userNick.nickUsuario = :userMod)ORDER BY usuario.identificador ASC")
	List<Object[]> findUsuarioModificar(@Param("corg") String claveOrganizacion, @Param("nstatus") Integer estatusRol, @Param("cstatus") List<String> estatus, @Param("userMod") String usuario);
	
	/**
	 * Busqueda de usuario a modificar
	 * 
	 * @param claveAfore
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	@Query(" SELECT usuario.identificador, usuario.usuario, userNick.nickUsuario, usuario.nombre, usuario.apellidoPaterno, usuario.apellidoMaterno, usuario.email, usuario.celular, usuario.estatus, usuario.claveOrganizacion, usuario.fecha, userRol.rolUsuario.claveRol, userRol.rolUsuario.descripcionRol, usuario.chSucursal, usuario.chOficina, usuario.zona"
			+ " FROM UsuarioPulssar usuario "
			+ " INNER JOIN UsuarioRol userRol ON usuario.identificador = userRol.identificadorUsuario "
			+ " LEFT OUTER JOIN UsuarioNickPulssar userNick ON usuario.identificador = userNick.identificadorUsuario " 
			+ " WHERE userRol.rolUsuario.claveRol = :crol AND userRol.estatus = :nstatus AND usuario.estatus IN :cstatus "
			+ " AND (usuario.usuario = :userMod OR userNick.nickUsuario = :userMod)ORDER BY usuario.identificador ASC")
	List<Object[]> findUsuarioModificarSICI(@Param("nstatus") Integer estatusRol, @Param("cstatus") List<String> estatus, @Param("userMod") String usuario, @Param("crol") String claveRol);
}