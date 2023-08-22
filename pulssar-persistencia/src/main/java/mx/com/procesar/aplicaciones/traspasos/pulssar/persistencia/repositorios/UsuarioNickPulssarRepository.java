package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssarPK;

/**
 * Repositorio para el manejo del nick usuario
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface UsuarioNickPulssarRepository extends JpaRepository<UsuarioNickPulssar, UsuarioNickPulssarPK> {
	
	/**
	 * Consutla el nick usuario de un trabajador
	 * 
	 * @param usuario
	 * @param estatus
	 * @return
	 */	
	List<UsuarioNickPulssar> findByNickUsuarioAndEstatus(String usuario, Integer estatus);
	
	/**
	 * Buscar usuarios por nickUsuario
	 * @param usuario
	 * @return
	 */
	@Query("SELECT userNick, userRol FROM UsuarioNickPulssar userNick "
			+ " INNER JOIN UsuarioRol userRol ON userNick.identificadorUsuario = userRol.identificadorUsuario "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = userRol.rolUsuario.identificadorRol "
			+ " INNER JOIN UsuarioPulssar usuario ON userNick.identificadorUsuario = usuario.identificador"
			+ " WHERE usuario.usuario = :usuario")
	List<Object[]> findByNickUsuario(@Param("usuario") String usuario);
	/**
	 * 
	 * @param nickUsuario
	 * @param estatus
	 * @return
	 */
	@Query("SELECT userNick FROM UsuarioNickPulssar userNick WHERE userNick.nickUsuario = :usuario AND userNick.estatus = :estatus")
	UsuarioNickPulssar findByIdUsuarioAndEstatus(@Param("usuario") String nickUsuario, @Param("estatus") Integer estatus);
}