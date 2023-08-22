package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioRol;

/**
 * Repositorio para el manejo de la relacion de usuario y roles asginados
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
	
	/**
	 * buscar roles por id
	 * @param identificador
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioRol FROM UsuarioRol usuarioRol WHERE usuarioRol.identificadorUsuario = :id AND usuarioRol.estatus = :estatus ORDER BY  usuarioRol.rolUsuario.claveRol ASC")
	List<UsuarioRol> findRolesById(@Param("id") Long identificador,@Param("estatus") Integer estatus);
	/**
	 * Consultar si un usuario se encuantra activo con el rol
	 * @param identificador
	 * @param claveRol
	 * @param estatus
	 * @return
	 */
	@Query("SELECT usuarioRol FROM UsuarioRol usuarioRol WHERE usuarioRol.identificadorUsuario = :id AND usuarioRol.rolUsuario.claveRol = :clave  AND usuarioRol.estatus = :estatus")
	UsuarioRol findRolesByIdAndRol(@Param("id") Long identificador,@Param("clave") String claveRol,@Param("estatus") Integer estatus);

	
	}