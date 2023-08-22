package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;

/**
 * @author medoming
 *
 */
public class BaseController {
	
	/**
	 * Logger;
	 */
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * Manejador de excepciones por permisos
	 * @param ex
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ SecurityException.class })
	protected ModelAndView manejarUncheckedExceptions(SecurityException ex, HttpServletResponse response) {
		return new ModelAndView(NavegacionEnum.PERMISO_DENEGADO.getNavegacion());	
	}
	
	/**
	 * Manejador de excepciones por permisos
	 * @param ex
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ IOException.class, GenericException.class, Exception.class })
	protected ModelAndView manejadorExcepciones(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		logger.error(new StringBuilder().append("Se produjo un error inesperado: ").append(ex).toString(), ex);
		return new ModelAndView(NavegacionEnum.ERROR_INESPERADO.getNavegacion());	
	}
}
