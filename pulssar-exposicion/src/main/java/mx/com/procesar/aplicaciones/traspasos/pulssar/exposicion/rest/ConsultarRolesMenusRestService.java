package mx.com.procesar.aplicaciones.traspasos.pulssar.exposicion.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarRolesMenusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ConsultarRolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolUrl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenu;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenuLista;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaUrl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaRolesUrl;
/**
 * Servicio que consulta los menus dependiendo al rol
 * @author RARREOLA
 *
 */
@RestController
@RequestMapping(value = "/portalservicios/v2")
public class ConsultarRolesMenusRestService{
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarRolesMenusRestService.class);
	
	/**
	 * ConsultarRolesMenusService
	 */
	@Autowired
	private ConsultarRolesMenusService consultarRolesMenusService;
	
	
	@Autowired
	private CacheManager cacheManager;
	
	
	
	/**
	 * Consultar menu por clave rol y url
	 * @param datosEntradaRolUrl
	 * @return
	 */
	@RequestMapping(value = "/consultarMenusIdentificadorRolUrl", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public DatosSalidaRolesUrl consultarMenusIdentificadorRolUrl(@RequestBody DatosEntradaRolUrl datosEntradaRolUrl) {
		logger.info("consultarMenusIdentificadorRolUrl :: {}", datosEntradaRolUrl.toString());
		return consultarRolesMenusService.consultarMenusIdentificadorRolUrl(datosEntradaRolUrl.getIdentificadorRol(), datosEntradaRolUrl.getUrl());
	}
	
	/**
	 * Consultar menu por identificador de roles
	 * @param identificadorRoles
	 * @return
	 */
	@RequestMapping(value = "/consultarMenusIdentificadoresRoles", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<MenuPagina> consultarMenusIdentificadoresRoles(@RequestBody DatosEntradaRolesMenu identificadoresRoles) {
		logger.info("consultarMenusIdentificadoresRoles :: {}", identificadoresRoles.toString());
		return consultarRolesMenusService.consultarMenusIdentificadoresRoles(identificadoresRoles);
		
		
	}

	
	
	
	
	/**
	 * Limpiar cache
	 */
	@RequestMapping(value = "/limpiarCache", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public String limpiarCache() {
		 for (String name : cacheManager.getCacheNames()){
			 cacheManager.getCache(name).clear();
	  		}
		 
		 return ConsultarRolesConstants.MENSAJE_EXITO_CACHE;
	}
	

	/**
	 * Consultar menu por url
	 * @param datosEntradaRolUrl
	 * @return
	 */
	@RequestMapping(value = "/consultarUrl", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public DatosSalidaRolesUrl consultarUrl(@RequestBody DatosEntradaUrl datosEntradaUrl) {
		
		return consultarRolesMenusService.consultarUrl(datosEntradaUrl.getUrl());
	}
	
	
	/**
	 * Consultar menu por identificador de roles
	 * @param identificadorRoles
	 * @return
	 */
	@RequestMapping(value = "/consultarMenusLista", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<MenuPagina> consultarMenusIdentificadoresRolesLista(@RequestBody DatosEntradaRolesMenuLista identificadoresRoles) {
		
		return consultarRolesMenusService.consultarMenusIdentificadoresRolesLista(identificadoresRoles);
		
		
	}
	
	
	
	/**
	 * Consultar menu por identificador de roles
	 * @param identificadorRoles
	 * @return
	 */
	@RequestMapping(value = "/consultarTodasMenusLista", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<MenuPagina> consultarMenusTodasLista() {
		
		return consultarRolesMenusService.consultarMenusTodasLista();
		
		
	}
}
