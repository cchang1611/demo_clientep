package mx.com.procesar.aplicaciones.traspasos.pulssar.exposicion.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RegistroUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;

/**
 * Servicio Rest para el consumo del
 * alta de usuario en el pulssar para 
 * afores que no registren desde el portal
 */
@RestController
@RequestMapping(value = "/portalservicios/v1")
public class AltaUsuarioRestService {

	/**
	 * Log
	 */
	private static final Logger logger = LoggerFactory.getLogger(AltaUsuarioRestService.class);

	/**
	 * Inyeccion servicioAforeAgente
	 */
	@Autowired
	private RegistroUsuarioService servicioRegistro;
	
	/**
	 * Inyeccion servicio Administracion
	 */
	@Autowired 
	private AdministracionUsuarioService servicioAdministracion;
	
	/**
	 * servicio expuesto consulta de agente promotor
	 * @param afoAgente
	 * @return
	 */
	@RequestMapping(value = "usuarios", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public RespuestaAlta buscaAgentePromotor(@RequestBody String afoAgente) {
		logger.info("entrada datos {} ", afoAgente);
		return servicioRegistro.registrarUsuarioRest(afoAgente, true);
	}
	
	/**
	 * servicio expuesto consulta de agente 
	 * @param claveAfore
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/buscarAgente/{claveAfore}/{usuario}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public AgentePromotor buscarAgente(@PathVariable String claveAfore, @PathVariable String usuario){
		logger.info("busqueda se agente");
		return servicioAdministracion.buscarUsuarioNick(claveAfore, usuario);
	}
	
	/**
	 * servicio expuesto consulta de agente 
	 * @param claveAfore
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/encriptarPassword/{cipher}/{password}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public String encriptarCadena(@PathVariable boolean cipher, @PathVariable String password) {
		logger.info("Metodo encargado de encriptar una cadena");
		return servicioRegistro.cifrarDescifrarCadena(password, cipher);
	}
}