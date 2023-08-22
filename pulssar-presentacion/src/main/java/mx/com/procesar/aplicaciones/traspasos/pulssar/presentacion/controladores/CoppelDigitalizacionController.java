/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DigitalizacionCoppel;

/**
 * Controlador pra dispositivos coppel
 * @author jmcabrer
 *
 */
@Controller
public class CoppelDigitalizacionController {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CoppelDigitalizacionController.class);


	/**
	 * servicio de 
	 */
	@Autowired
	private CoppelService coppelService;
	/**
	 * Genera la peticion para el padFirma
	 * @return
	 */
	@RequestMapping(value = "/private/generaPeticionDigitalizacion.do", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })	
	@ResponseBody
	public LinkedHashMap<String,String> generarPeticionDigitalizacion(HttpServletRequest request, @RequestBody DigitalizacionCoppel digitalizacionCoppel) {
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		logger.info("Entrada a la digitalizacion: {}, {}",digitalizacionCoppel, origen);
		return coppelService.generarPeticionDigitalizacion(digitalizacionCoppel, origen);
	}
	/**
	 *  mostrarSubMenuRetiroReintegroRecursosParcialDesempleo
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param request
	 *  @param map
	 *  @return
	 */
	@RequestMapping(value="/private/pruebaDigitalizador.do", method = RequestMethod.GET)
	public ModelAndView mostrarSubMenuRetiroReintegroRecursosParcialDesempleo(HttpServletRequest request, ModelMap map) {
		return new ModelAndView("/mx/com/procesar/plataforma/servicios/retiro/pruebaDigitalizador");
	}

	
}
