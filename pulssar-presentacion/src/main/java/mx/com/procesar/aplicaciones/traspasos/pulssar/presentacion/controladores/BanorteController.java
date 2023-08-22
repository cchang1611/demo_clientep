/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanorteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Clase para controrar la tablet de banorte
 * @author dhernand
 *
 */
@Controller
public class BanorteController {
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BanorteController.class);
	
	/**
	 * Servicio de banorte
	 */
	@Autowired
	private BanorteService banorteServicio;


	/**
	 * Metodo de prueba para pantalla
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/private/tabletBanorte.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView tabletBanorte(HttpServletRequest request, ModelMap map) {
		logger.info("visorImagenes");
		return new ModelAndView("/mx/com/procesar/plataforma/servicios/tabletBanorte");
	}
	
	/**
	 * Genera url de peticion tablet
	 * @param request
	 * @param parametros
	 * @return
	 */
	@RequestMapping(value = "/private/urlTabletBanorte.do", method = RequestMethod.POST,consumes= { "application/json"}, produces = {MediaType.TEXT_PLAIN_VALUE })	
	@ResponseBody
	public String urlTabletBanorte(HttpServletRequest request,@RequestBody Map<String,String> parametros){
		logger.info("obteniendo url tablet");
		UsuarioLogin usuario = (UsuarioLogin)request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);		
		return banorteServicio.generarUrlPeticionTablet(parametros,usuario);
	}
	
	/**
	 * Genera url de peticion tablet
	 * @param request
	 * @param parametros
	 * @return
	 */
	@RequestMapping(value = "/public/huellasBanorte.do", method = RequestMethod.POST,consumes= { "application/json"}, produces = {MediaType.TEXT_PLAIN_VALUE })	
	@ResponseBody
	public String urlTabletBanorte(HttpServletRequest request, @RequestBody String data) {
		logger.info(data);
		return "bueno";
	}
}
