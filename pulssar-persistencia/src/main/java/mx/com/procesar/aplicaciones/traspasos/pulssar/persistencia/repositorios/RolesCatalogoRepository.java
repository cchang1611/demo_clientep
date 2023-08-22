package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;

/**
 * Repositorio para el manejo de correo corporativo
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface RolesCatalogoRepository extends JpaRepository<RolesCatalogo, Long> {
	
	/**
	 * Busqueda de rol por rol y afore
	 * @param claveRol
	 * @param claveAfore
	 * @return
	 */
	@Query("SELECT rol FROM RolesCatalogo rol WHERE rol.claveRol = :claveRol AND rol.claveAfore = :claveAfore")
	RolesCatalogo findRolByClaveRolAfore(@Param("claveRol") String claveRol, @Param("claveAfore")String claveAfore);
	
	/**
	 * Busqueda de rol por afore
	 * @param claveAfore 
	 */
	@Query("SELECT rol FROM RolesCatalogo rol WHERE rol.claveAfore = :claveAfore")
	List<RolesCatalogo> findRolByAfore(@Param("claveAfore")String claveAfore);
	
	/**
	 * Busqueda de roles especificos
	 */
	@Query("SELECT rol FROM RolesCatalogo rol WHERE rol.claveRol IN :roles ORDER BY rol.claveRol ASC")
	List<RolesCatalogo> findRolByRoles(@Param("roles") List<String> roles);
	
	/**
	 * Busqueda de roles especificos
	 */
	@Query("SELECT rol FROM RolesCatalogo rol WHERE rol.claveRol IN :roles AND rol.claveAfore = :claveAfore ORDER BY rol.claveRol ASC")
	List<RolesCatalogo> findRolByRolesClaveAfore(@Param("roles") List<String> roles, @Param("claveAfore")String claveAfore);
}