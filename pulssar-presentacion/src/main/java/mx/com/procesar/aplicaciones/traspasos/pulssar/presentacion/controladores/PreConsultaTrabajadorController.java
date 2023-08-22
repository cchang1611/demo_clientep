package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since May 15, 2020
 */
@Controller
public class PreConsultaTrabajadorController {

	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PreConsultaTrabajadorController.class);
	
	/**
	 * service
	 */
	@Autowired
	private PreConsultaTrabajadorService service;
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 *  preConsultaTrabajador
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param request
	 *  @param nss
	 *  @param curp
	 *  @return
	 */
	@ResponseBody
	@GetMapping(value="/private/preconsulta.do", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> preConsultaTrabajador(HttpServletRequest request, @RequestParam(required = false) String nss, @RequestParam(required = false) String curp ){
		logger.error("consulta trabajador curp:{}, nss:{}",curp,nss);	
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		HashMap<String, Object> response = new HashMap<>();
		logger.error("consulta trabajador curp:{}, nss:{}, Afore:{}",curp,nss,user.getAforeUsuario());	
		List<PersonaSalida> persona = null;
		
String valoresExtras = servicioCatalogo.consultaValorParametro(NumerosConstants.C_UNO, AgenteConstants.PARAMETRO_AFORES_PROSPECTOS);
		
		if(valoresExtras != null && !valoresExtras.contains(user.getAforeUsuario())) {
			persona = service.getPersonaConsulta(nss,curp,user.getAforeUsuario());
		}else {
			persona = service.getPersonaConsulta(nss,curp);
			
		}
		
		response.put("success", true);
		response.put("persona", persona);
		response.put("size", persona.size());
		return response;
	}
}
