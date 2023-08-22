/**
 * ConsultaCertificacionSolicitudTraspasoController.java
 * Fecha de creación: Apr 22, 2021, 11:28:19 AM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.OperativoProcesarConstants.URI_ROL_AUTENTICADO_OPERATIVO_PROCESAR;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Controlador para redirigir a las opciones para la consuta de certificadion de
 * solicitudes de traspaso
 * 
 * @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
 * @version 1.0
 * @since Apr 22, 2021
 */
@Controller
@RequestMapping(value = URI_ROL_AUTENTICADO_OPERATIVO_PROCESAR)
public class ConsultaCertificacionSolicitudTraspasoController {

	/**
	 * Logger;
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaPlataformaServiciosController.class);

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	
	/**
	 * Carpeta para archivo temporales
	 */
	@Value("${url.consulta.certificacion.solicitud.traspaso}")
	private String urlConsultaCertificacionTraspaso;

	/**
	 * 
	 *  Metodo para 
	 *  @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
	 *  @param servicio
	 *  @param request
	 *  @return
	 */
	@RequestMapping(value = "/consultaServiciosSolicitudTraspaso.do", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView mostrarConsultaCertificacionSolTraspaso(@RequestParam(value = "servicio", required = false) String servicio, HttpServletRequest request) {
		logger.info("Inicio mostrar Consulta Certificacion Sol Traspaso ");
		logger.info("Url iframe Consulta Certificacion Sol Traspaso{}",urlConsultaCertificacionTraspaso);
		ModelAndView model = new ModelAndView(NavegacionEnum.FORWARD_CERTIFICACION_SOLICITUDES_TRASPASO.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String claveServicio = servicio;
		try {
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.VALIDAR_FILTROS_PLATAFORMA.getClave(),user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
			model.addObject("url", urlConsultaCertificacionTraspaso);
			model.addObject(ActivacionConstants.RESPUESTA, respuesta);
			model.addObject(ActivacionConstants.CLAVE_SERVICIO, claveServicio);
		} catch (BusinessException be) {
			logger.error("BusinessException: Se presento un problema en la  Consulta Certificacion Sol Traspaso {}", be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("ExcepcionSe presento un problema al mostrar Consulta Certificacion Sol Traspaso", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return model;

	}
}
