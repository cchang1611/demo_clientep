package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.ATRIBUTO_FOLIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.ATRIBUTO_MENSAJE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.ATRIBUTO_NUMERO_REINTEGRO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.ATRIBUTO_RESOLUCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.SESSION_SOLICITUD;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.SOLICITUD;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReintegroSemanasFlujosFoliosServices;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReintegroSemanasResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Controller para mostrar el servicio de Reintegro Recursos
 * 
 * @author ANOSORIO
 *
 */
@Controller
public class RetiroDesempleoReintegroRecursosImssController extends BaseController {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetiroDesempleoReintegroRecursosImssController.class);

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;

	/**
	 * Inyeccion ReintegroSemanasResarcimientoService
	 */
	@Autowired
	private ReintegroSemanasResarcimientoService reintegroSemanasResarcimientoService;

	/**
	 * Reintegro flujo de folio
	 */
	@Autowired
	private ReintegroSemanasFlujosFoliosServices reintegroSemanasFlujosFoliosServices;

	/**
	 * Metodo para obtener el Reintegro de Recursos
	 * 
	 * @param solicitud
	 * @param map
	 * @param mensaje
	 * @return
	 */
	@GetMapping(value = "/private/reintegroRecursos.do")
	public ModelAndView reintegroRecursos(HttpServletRequest solicitud) {
		logger.info("Controller >> reintegroRecursos");
		ModelAndView salida = new ModelAndView(NavegacionEnum.REINTEGRO_RECURSOS_DESEMPLEO.getNavegacion());
		SolicitudReintegroResarcimiento entrada = iniciarTramite(solicitud, salida);

		reintegroSemanasFlujosFoliosServices.generarFolioPadreHistorico(entrada);
		reintegroSemanasResarcimientoService.consultarHistoricoRetiros(entrada);
		return salida;
	}

	@GetMapping(value = "/private/confirmarReintegroRecursos.do")
	public ModelAndView confirmarReintegroRecursos(HttpServletRequest solicitud) {
		logger.info("Controller >> confirmarReintegroRecursos");
		ModelAndView salida = new ModelAndView(
				NavegacionEnum.CONFIRMACION_REINTEGRO_RECURSOS_DESEMPLEO.getNavegacion());
		SolicitudReintegroResarcimiento entrada = iniciarTramite(solicitud, salida);

		reintegroSemanasResarcimientoService.consultarHistoricoConfirmacion(entrada);
		return salida;
	}

	@GetMapping(value = "/private/documentosReintegroRecursos.do")
	public ModelAndView documentosReintegroRecursos(HttpServletRequest solicitud) {
		logger.info("Controller >> documentosReintegroRecursos");
		ModelAndView salida = new ModelAndView(
				NavegacionEnum.DOCUMENTOS_REQUERIDOS_REINTEGRO_RECURSOS_DESEMPLEO.getNavegacion());
		SolicitudReintegroResarcimiento entrada = iniciarTramite(solicitud, salida);
		logger.info("Parametro {}", solicitud.getParameter(ATRIBUTO_RESOLUCION));
		entrada.setResolucion(solicitud.getParameter(ATRIBUTO_RESOLUCION));
		entrada.setNumeroReintegro(solicitud.getParameter(ATRIBUTO_NUMERO_REINTEGRO));

		reintegroSemanasResarcimientoService.consultarDocumentosRequeridos(entrada);

		return salida;
	}

	/**
	 * Controlador encargado de capturar archivos
	 * 
	 * @param solicitud
	 */
	@RequestMapping(value = "/private/guardarArchivoReintegrar.do", method = RequestMethod.POST)
	public String guardarArchivos(HttpServletRequest solicitud, MultipartHttpServletRequest requestMultipart,
			ModelMap modelo, @SessionAttribute(SESSION_SOLICITUD) SolicitudReintegroResarcimiento entrada) {
		logger.info("Controller >> guardarArchivos");
		entrada.setNumeroReintegro(solicitud.getParameter(ATRIBUTO_NUMERO_REINTEGRO));
		entrada.setResolucion(solicitud.getParameter(ATRIBUTO_RESOLUCION));
		RespuestaServicio salida = reintegroSemanasResarcimientoService.obtenerArchivos(requestMultipart.getFileMap(),
				entrada);

		solicitud.getSession().setAttribute("respuesta", salida);
		modelo.put(ATRIBUTO_RESOLUCION, solicitud.getParameter(ATRIBUTO_RESOLUCION));
		modelo.put(ATRIBUTO_NUMERO_REINTEGRO, solicitud.getParameter(ATRIBUTO_NUMERO_REINTEGRO));

		return "redirect:/private/documentosReintegroRecursos.do";
	}

	/**
	 * Genrar datos de referencias
	 * 
	 * @param solicitud
	 * @return
	 */
	@GetMapping(value = "/private/generarDatosReferenciaReintegro.do")
	public ModelAndView generarLineaCaptura(HttpServletRequest solicitud) {
		logger.info("Controller >> generarLineaCaptura");
		ModelAndView salida = new ModelAndView(
				NavegacionEnum.GENERAR_DATOS_REFERENCIA_REINTEGRO_RECURSOS_DESEMPLEO.getNavegacion());
		iniciarTramite(solicitud, salida);
		return salida;
	}

	/**
	 * 
	 * confirmacion de reintegro
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param notificacionReintegro
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/private/generarDatosReferenciaPdf", method = { RequestMethod.GET }, produces = {
			"application/pdf" })
	@ResponseStatus(value = HttpStatus.OK)
	public void generarDatosReferenciaPdf(@SessionAttribute(SESSION_SOLICITUD) SolicitudReintegroResarcimiento entrada,
			HttpServletResponse response) {
		logger.info("Controller >> generarDatosReferenciaPdf");
		reintegroSemanasFlujosFoliosServices.generarFolioHijoDosHistorico(entrada);
		utileriaConversion.imprimirReporte(
				reintegroSemanasResarcimientoService.generarLineaCaptura(entrada).getObjetoRespuesta(), response);
	}

	/**
	 * Se encarga de generar la notificacion del flujo de historico
	 * 
	 * @param solicitud
	 * @return
	 */
	@PutMapping(value = "/private/generarNotificacionHistorico.do")
	public void generarNotificacionHistorico(HttpServletRequest solicitud) {
		logger.info("Controller >> generarNotificacionHistorico");
		SolicitudReintegroResarcimiento entrada = iniciarTramite(solicitud, null);
		reintegroSemanasFlujosFoliosServices.generarFolioHijoTresHistorico(entrada);
		reintegroSemanasResarcimientoService.generarNotificacionHistorico(entrada);
	}

	/**
	 * Obtener el calculo del monto a reintegrar
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param cuerpo
	 * @return
	 */
	@PostMapping(value = "/private/obtenerCalculoMontoReintegrar", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public BaseRespuesta<RespuestaMontoReintegrar> obtenerCalculoMontoReintegrar(HttpServletRequest solicitud,
			@SessionAttribute(SESSION_SOLICITUD) SolicitudReintegroResarcimiento entrada,
			@RequestBody CalculoMontoReintegrar cuerpo) {
		logger.info("Controller >> obtenerCalculoMontoReintegrar");
		cuerpo.setNssTrabajador(entrada.getTrabajador().getNss());
		cuerpo.setClaveAfore(entrada.getTrabajador().getClaveAfore());
		BaseRespuesta<RespuestaMontoReintegrar> salida = reintegroSemanasResarcimientoService
				.obtenerCalculoMontoReintegrar(cuerpo, entrada);
		entrada.setMontoReintegrar(salida.getObjetoRespuesta());
		solicitud.getSession().setAttribute(SESSION_SOLICITUD, entrada);
		return salida;
	}

	/**
	 * Terminar tramite
	 * 
	 * @param solicitud
	 * @return
	 */
	@GetMapping(value = "/private/terminarTramiteConfirmacion.do")
	public ModelAndView terminarTramiteConfirmacion(HttpServletRequest solicitud) {
		logger.info("Controller >> generarLineaCaptura");
		ModelAndView salida = new ModelAndView(
				NavegacionEnum.MENU_AGENTE.getNavegacion());
		solicitud.getSession().setAttribute("respuesta", null);
		solicitud.getSession().setAttribute(SESSION_SOLICITUD, null);
		return salida;
	}
	
	/**
	 * Se encargar de cargar variablaes iniciales del tramite
	 * 
	 * @param solicitud
	 * @param modelo
	 * @return
	 */
	private SolicitudReintegroResarcimiento iniciarTramite(HttpServletRequest solicitud, ModelAndView modelo) {
		SolicitudReintegroResarcimiento salida = (SolicitudReintegroResarcimiento) solicitud.getSession()
				.getAttribute(SESSION_SOLICITUD);

		if (salida == null) {
			salida = new SolicitudReintegroResarcimiento();
			DatosTrabajador trabajador = (DatosTrabajador) solicitud.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS);
			UsuarioLogin usuarioLogin = (UsuarioLogin) solicitud.getSession()
					.getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			salida.setTrabajador(trabajador);
			salida.setUsuarioLogin(usuarioLogin);

			solicitud.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		}

		solicitud.getSession().setAttribute(SESSION_SOLICITUD, salida);
		if (modelo != null) {
			modelo.addObject(ATRIBUTO_FOLIO, salida.getTrabajador().getFolio());
			modelo.addObject(SOLICITUD, salida);
			utileriaConversion.obtenerImagenNombreUsuario(modelo, salida.getUsuarioLogin());
		}

		logger.info("Iniciar Tramite {}", salida);
		return salida;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores
	 * .BaseController#manejadorExcepciones(java.lang.Exception,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView manejadorExcepciones(Exception ex, HttpServletRequest request,
			HttpServletResponse response) {
		SolicitudReintegroResarcimiento entrada = (SolicitudReintegroResarcimiento) request.getSession()
				.getAttribute(SESSION_SOLICITUD);
		reintegroSemanasFlujosFoliosServices.cerrarFolioRechazado(entrada);
		return super.manejadorExcepciones(ex, request, response);
	}

	/**
	 * Manejador de business excepciones por permisos
	 * 
	 * @param ex
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ BusinessException.class })
	protected ModelAndView manejadorBusinessExcepciones(BusinessException ex, HttpServletRequest request,
			HttpServletResponse response) {
		logger.error(new StringBuilder().append("Se produjo un error de negocio: ").append(ex).toString(), ex);
		SolicitudReintegroResarcimiento entrada = (SolicitudReintegroResarcimiento) request.getSession()
				.getAttribute(SESSION_SOLICITUD);
		reintegroSemanasFlujosFoliosServices.cerrarFolioRechazado(entrada);
		ModelAndView model = new ModelAndView(NavegacionEnum.ERROR_BUSINESS.getNavegacion());
		model.addObject(ATRIBUTO_MENSAJE, ex.getDescripcion());
		return model;
	}

}
