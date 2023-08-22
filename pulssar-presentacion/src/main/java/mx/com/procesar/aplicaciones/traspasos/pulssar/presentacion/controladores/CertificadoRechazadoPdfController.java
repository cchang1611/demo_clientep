package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoRechazadoPdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Oct 10, 2019
 */
@Controller
public class CertificadoRechazadoPdfController {

	/**
	 * service
	 */
	@Autowired
	private CertificadoRechazadoPdfService service;
	
	
	/**
	 *  generaRechazadoPdf
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param request
	 *  @param map
	 *  @return
	 */
	@GetMapping(value = "/generaRechazadoPdf", produces = { "application/pdf" })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public byte[] generaRechazadoPdf(HttpServletRequest request, ModelMap map) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuario = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		return service.generaReporte(trabajador, usuario);
	}

	
}
