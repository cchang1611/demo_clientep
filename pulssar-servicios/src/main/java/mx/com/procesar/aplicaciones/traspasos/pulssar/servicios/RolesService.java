package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;

/**
 * interfaz RolesService para consultas a roles
 * @author JMGUTIER
 * @version 1.0
 */
public interface RolesService {
	/**
	 * Metodo para consultar roles
	 * @return
	 */
	List<RolesCatalogo> consultarRoles();
	
	/**
	 * Obtiene los roles de una lista
	 * 
	 * @param roles
	 * @return
	 */
	List<RolesCatalogo> buscarRoles(List<String> roles);
	
	/**
	 * Obtiene el rol por clave rol y afore
	 * 
	 * @param roles
	 * @param claveAfore
	 * @return
	 */
	List<RolesCatalogo> buscarRolesPorAfore(List<String> roles, String claveAfore);
	
	/**
	 * Obtiene el rol por afore
	 * 
	 * @param claveAfore
	 * @return
	 */
	List<RolesCatalogo> buscarRolPorAfore(String claveAfore);
	
	/**
	 * Obtiene el rol por clave rol y afore
	 * 
	 * @param roles
	 * @return
	 */
	RolesCatalogo buscarRolPorRolClaveAfore(String claveRol, String claveAfore);

	/**
	 * Obtiene el rol por clave rol y afore
	 * 
	 * @param roles
	 * @return
	 */
	Rol obtenerRolPorRolClaveAfore(String claveRol, String claveAfore);


}