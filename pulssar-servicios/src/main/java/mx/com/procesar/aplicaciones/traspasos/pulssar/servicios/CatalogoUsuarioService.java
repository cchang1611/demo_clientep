package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ModuloReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PlataformasPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RolesModuloAccesoIP;

/**
 * Interfaz para el catalogo de usuarios
 * @author DBARBOSA
 *
 */
public interface CatalogoUsuarioService {
	
	/**
	 * Obtener Plataformas
	 * 
	 * @return
	 */
	List<PlataformasPulssar> obtenerPlataformas();
	
	/**
	 * Obtener Roles administrador
	 * 
	 * @param idRol
	 * @param plataforma
	 * @return
	 */
	List<RolesCatalogo> obtenerRolesAdministracion(String cvRol, String cvAfore, String plataforma, Integer isAdmin);
	
	/**
	 * Obtener el rol para la validacion de modulos y acceso de ip
	 * 
	 * @param cvRol
	 * @param cvAfore
	 * @param plataforma
	 * @return
	 */
	RolesModuloAccesoIP obtenerRolModuloAcceso(String cvRol, String cvAfore, String plataforma);
	
	/**
	 * Obtiene los modulos de los reportes
	 * 
	 */
	List<ModuloReporte> obtenerModuloReportes();
	
	/**
	 * Metodo encargado de obtener los roles por administrador y afore
	 * @param cvRol
	 * @param cvAfore
	 * @return
	 */
	List<RolesCatalogo> obtenerRolesAdministracion(String cvRol, String cvAfore);
	
	/**
	 * Metodo encargado de consultar la validacion de modulos
	 * @param cvRol
	 * @param cvAfore
	 * @return
	 */
	RolesModuloAccesoIP obtenerRolModuloAccesoModificacion(String cvRol, String cvAfore);
}