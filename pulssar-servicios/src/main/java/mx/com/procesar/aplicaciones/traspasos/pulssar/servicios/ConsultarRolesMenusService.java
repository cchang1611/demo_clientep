package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenu;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenuLista;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaRolesUrl;

/**
 * Servicio que consulta los menus dependiendo al rol
 * @author RARREOLA
 *
 */
public interface ConsultarRolesMenusService {
	
	/**
	 * Consulta los menus por identificador rol y url
	 * @param identificador roles
	 * @param url
	 * @return
	 */
	DatosSalidaRolesUrl consultarMenusIdentificadorRolUrl(String identificadorRol, String url);

	
	/**
	 * Consulta los menus por lista de roles
	 * @param identificador roles
	 * @return
	 */
	List<MenuPagina> consultarMenusIdentificadoresRoles(DatosEntradaRolesMenu datosEntradaRolesMenu);
		
	/**
	 * Consulta los menus por url
	 * @param identificador roles
	 * @param url
	 * @return
	 */
	DatosSalidaRolesUrl consultarUrl(String url);
	
	/**
	 * Consultar menus
	 * @param identificadoresRoles
	 * @return
	 */
	List<MenuPagina> consultarMenusIdentificadoresRolesLista(DatosEntradaRolesMenuLista identificadoresRoles);

	/**
	 * MEnus
	 * @return
	 */
	List<MenuPagina> consultarMenusTodasLista();
}
