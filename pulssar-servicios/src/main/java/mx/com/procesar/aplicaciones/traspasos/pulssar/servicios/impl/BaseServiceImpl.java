/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * servicio base con operaciones y objetos comunes.
 * 
 * @author jcgarces
 *
 */
public class BaseServiceImpl {
	
	/**
	 * logger
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * utileria json
	 */
	@Autowired
	protected JsonUtils jsonUtil;
	
	/**
	 * utileria json
	 */
	@Autowired
	protected ValidadorUtils validadorUtils;
	
	/**
	 * utileria json
	 */
	@Autowired
	protected CadenasUtils utileriaCadena;
	
	/**
	 * utileria
	 * 
	 * @param peticion
	 */
	@Autowired
	protected RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * uriComunes
	 */
	@Value("${uri.comunes}")
	protected String uriComunes;
	
	/**
	 * uriComunesTransaccional
	 */
	 @Value("${uri.comunes.transaccional}")
	 protected String uriComunesTransaccional;
	 
	 /**
	  * uriComunesNotificacion
	  */
	 @Value("${uri.comunes.notificacion}")
	 protected String uriComunesNotificacion;
	 
	 /**
	  * uri usuarios
	  */
	 @Value("${url.servicio.usuarios}")
	 protected String uriUsuariosPulssar;
}
