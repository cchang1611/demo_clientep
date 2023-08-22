package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenWrapper;

@Controller
@RequestMapping(value = { "/private" })
public class FinController {

	private static final Logger logger = LoggerFactory.getLogger(FinController.class);

	@PostMapping(value = "/receptorImagen")
	public ModelAndView receptorArchivos(HttpServletRequest request, @ModelAttribute("wrapper") ImagenWrapper wrapper)  {
		ModelAndView modelAndView = new ModelAndView(NavegacionEnum.MENU.getNavegacion());
		logger.info("visorImagenes");

		for (ImagenDocumento img : wrapper.getImagenes()) {
			logger.info("nombre -> {}",img.getNombreDocumento());
			logger.info("contenido -> {}", img.getContenidoDocumento());
		}
		
		return modelAndView;
	}

}
