package mx.com.procesar.aplicaciones.traspasos.pulssar.exposicion.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * 
 * Servicio rest para validar usuario , obtener roles, obtener menus Pagina

 * @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
 * @version 1.0
 * @since Jan 28, 2020
 */
@RestController
@RequestMapping(value = "/portalservicios/v3")
public class ValidarUsuarioRestService {

	/**
	 * Log
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidarUsuarioRestService.class);

	/**
	 * Inyeccion servicio Administracion
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdministracion;
	
	/**
	 * 
	 * Metodo encargado de validar usuario inicia session
	 * 
	 * @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
	 * @param usuario
	 * @return
	 */
	@GetMapping(value = "/validarUsuario/{usuario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public RespuestaServicio validarUsuarioLogin(@PathVariable String usuario) {
		logger.info("entrada datos {} ", usuario);
		return servicioAdministracion.validarUsuarioLogin(usuario, "");

	}

	/**
	 * 
	 * Metodo encargado de obtener el rol del usuario Pulsar
	 * 
	 * @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
	 * @param usuario
	 * @return UsuarioLogin
	 */
	@GetMapping(value = "/obtenerRolUsuario/{usuario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UsuarioLogin obtenerRolUsuario(@PathVariable String usuario) {
		logger.info("entrada datos {} ", usuario);
		return servicioAdministracion.obtenerRolUsuario(usuario);
	}

	/**
	 * 
	 *  metodo encargado  obtener los menusPagina
	 *  @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
	 *  @param claveRol
	 *  @param claveAfore
	 *  @param menu
	 *  @return
	 */
	@GetMapping(value = "/obtenerMenus/{claveRol}/{claveAfore}/{menu}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<MenuPagina> obtenerMenus(@PathVariable String claveRol, @PathVariable String claveAfore,@PathVariable Long menu) {
		logger.info("ObtenerMenus claveRol: {} claveAfore: {} menu: {}", claveRol, claveAfore, menu);
		return servicioAdministracion.obtenerMenus(claveRol, claveAfore, menu);
	}
	
	
	
	/**
	 * Metodo para obtener los menus con base la clave afore
	 * @author Ricardo Alcantara Ramirez (ralcanra@procesar.com)
	 * Jun 8, 2021
	 * @param claveRol
	 * @param claveAfore
	 * @return
	 */
	@GetMapping(value = "/obtenerMenuComparador/{claveAfore}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<MenuPagina> obtenerMenusAfore(@PathVariable String claveAfore) {
		logger.info("ObtenerMenus claveAfore: {}", claveAfore);
		return servicioAdministracion.obtenerMenuRol(claveAfore);
		
	}
		
		/**
		 * Metodo para obtener los menus con base al rol y la clave afore
		 * @author Ricardo Alcantara Ramirez (ralcanra@procesar.com)
		 * Jun 8, 2021
		 * @param claveRol
		 * @param claveAfore
		 * @return
		 */
	@GetMapping(value = "/obtenerMenus/{claveRol}/{claveAfore}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<MenuPagina> obtenerMenusRolAfore(@PathVariable String claveRol, @PathVariable String claveAfore) {
		logger.info("ObtenerMenus claveRol: {} claveAfore: {}", claveRol, claveAfore);
		return servicioAdministracion.obtenerMenuRol(claveRol, claveAfore);
	}
	
	
	
}
