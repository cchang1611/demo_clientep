package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.BOTON_CERTIFICADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.BOTON_CUS;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoRetiroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.TipoRetiroCoopelEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * Controlador Retiro Desempleo Imss
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 20/02/2020
 */
@Controller
public class RetiroDesempleoImssController extends BaseController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetiroDesempleoImssController.class);

	/**
	 * constante del atributo calculo tipo de retiro
	 */
	private static final String ATRIBUTO_CALCULO_TIPO_RETIRO = "calculoTipoRetiro";

	/**
	 * service
	 */
	@Autowired
	private CertificadoService certificadoService;
	/**
	 * Inyeccion dependencia CusService
	 */
	@Autowired
	private CusService cusService;
	/**
	 * solicitudService
	 */
	@Autowired
	private SolicitudDisposicionService solicitudService;

	/**
	 * tipoRetiroService
	 */
	@Autowired
	private TipoRetiroService tipoRetiroService;

	/**
	 * selloService
	 */
	@Autowired
	private ConsultaSelloService selloService;

	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;
	/**
	 * servicio de catalogos
	 */
	@Autowired
	private CatalogoService catalogoService;


	/**
	 * Inyeccion dependencia ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;

	/**
	 * Inyeccion disposicionService
	 */
	@Autowired
	private DisposicionTotalImssService disposicionService;
	/**
	 * inyeccion dependencia NotificacionService
	 */
	@Autowired
	private NotificacionService notificacionService;
	/**
	 * Inyeccion dependencia RechazoService
	 */
	@Autowired
	private RechazoService rechazoService;
	
	 /**
     * reimpresionTramitesService
     */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	 /**
    * inyeccion procesoPendienteService
    */
	@Autowired
	private ProcesoPendienteService procesoPendienteService;

	/**
	 * muestra el menu de retiro parcial
	 * 
	 * @param requestmenuRetiroParcialDesempleo.do
	 * @return
	 */
	@GetMapping(value = "/private/menuretiroparcial.do")
	public ModelAndView mostrarMenuRetiroParcial(HttpServletRequest request) {
		logger.info("menu retiro parcial");
		return new ModelAndView(NavegacionEnum.MENU_RETIRO_PARCIAL.getNavegacion());
	}

	/**
	 * muestra la pantalla de ayuda por desempleo
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@GetMapping(value = "/private/ayudaDesempleo.do")
	public ModelAndView ayudaDesempleo(HttpServletRequest request, ModelMap map, @ModelAttribute String mensaje,
			@ModelAttribute("retiroDesempleoImss") RetiroDesempleoImss retiroDesempleoImss) {
		ModelAndView modelAndView;
		ConsultaCusSalida cusSalida;
		Sello sello = null;

		try {
			logger.info("Ayuda Desempleo {}", mensaje);
			request.getSession().setAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS, retiroDesempleoImss);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS);
			UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession()
					.getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			RespuestaGeneraCusSalida salidaGenera;
			DatosCertificables datos = trabajador.getDatosCertificables();
			if (isEmpty(datos)) {
				throw new BusinessException("Datos certificables nulos");
			}

			if(trabajador.getTipoSolicitante().equals("01")){
				sello = selloService.obtenerSelloTrabajador(usuarioLogin.getCurpAgente(), datos.getCurp(),
						trabajador.getClaveAfore());
				trabajador.setSello(sello);
				retiroDesempleoImss.setSelloTrabajador(trabajador.getSello().getId().toString());
			}
//			retirosDesempleoImssService.borrarProcesoPendiente(datos.getCurp());

			FolioEntrada folio = new FolioEntrada();
			folio.setIdUsuario(usuarioLogin.getDatoUsuario());
			folio.setOperacion("S");
			folio.setServicio("S1");
			folio.setProceso("S1P1");
			folio.setSucursal("SUC1");
			folio.setNss(trabajador.getNss());
			folio.setCurp(trabajador.getDatosCertificables().getCurp());
			folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
			folio.setOrigen("O");
			FolioEntrada folioRespuesta = folioService.procesarFolio(folio, trabajador);
			retiroDesempleoImss.setFolio(folioRespuesta.getFolio());

			cusSalida = cusService.solicitarConsultaCus(datos.getCurp(), Constants.ESTATUS, folioRespuesta.getFolio(), trabajador.getClaveAfore(), null);
			
			modelAndView = new ModelAndView(NavegacionEnum.AYUDA_DESEMPLEO.getNavegacion());
			map.addAttribute(BOTON_CERTIFICADO, true);

			if (!isEmpty(cusSalida) && cusSalida.getCodigo().equals(Constants.RESULTADO_OPERACION_01)) {
				logger.info("Existe CUS");
				retiroDesempleoImss.setCus(cusSalida.getRespuesta().get(Constants.CUS));
				logger.info("CUS -EXISTENTE:{}", retiroDesempleoImss.getCus());

				map.addAttribute(Constants.RETIRO_DESEMPLEO_IMSS, retiroDesempleoImss);
				request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoImss);

			} else {
				logger.info("NO Existe CUS:Favor de generar una CUS");
				folioService.cerrarFolio(folioRespuesta.getIdFolio(), null);
				FolioEntrada folioGenera = new FolioEntrada();

				folioGenera.setIdUsuario(usuarioLogin.getDatoUsuario());
				folioGenera.setOperacion("S");
				folioGenera.setServicio("S1");
				folioGenera.setProceso("S1P2");
				folioGenera.setSucursal("SUC1");
				folioGenera.setNss(trabajador.getNss());
				folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
				folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
				folioGenera.setOrigen("O");

				folioGenera = folioService.generarNuevoFolio(folioGenera);
				logger.info("Folio genera Cus:{}", folioGenera.getIdFolio());
				salidaGenera = disposicionService.generarCus(trabajador, usuarioLogin, Constants.IMSS,
						folioGenera.getIdFolio());

				retiroDesempleoImss.setCus(salidaGenera.getCus());
				logger.info("CUS -GENERADO:{}", retiroDesempleoImss.getCus());
				if(validadorUtils.isEmpty(retiroDesempleoImss.getCus())){
					folioService.cerrarFolio(folioGenera.getIdFolio(), 2);
					String diagnostico = null;
					StringBuilder sb = new StringBuilder("C").append(salidaGenera.getDiagnosticoProcesar());
					RechazoPulssar rechazo = rechazoService.obtenerRechazo(sb.toString(), usuarioLogin.getAforeUsuario());
					diagnostico = rechazo.getMensaje();
					map.addAttribute(Constants.MENSAJE, diagnostico);
					map.addAttribute(BOTON_CUS, false);
					map.addAttribute(BOTON_CERTIFICADO, false);
				} else {
					notificacionService.notificarCus(salidaGenera, usuarioLogin.getAforeUsuario(), folioGenera.getFolio(),null);
				}
				map.addAttribute(Constants.RETIRO_DESEMPLEO_IMSS, retiroDesempleoImss);
				request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoImss);
			}
			map.addAttribute(Constants.FOLIO, folioRespuesta);
			if("568".equals(trabajador.getClaveAfore())){
				List<Parametro> telefonias = catalogoService.obtenerParametroDdbpose(Constants.T00074);
				map.addAttribute(Constants.TELEFONIAS, telefonias);
			}


		} catch (BusinessException e) {
			logger.error("Error en la pantalla inicial", e);
			map.addAttribute(Constants.ERROR, e.getMessage());
			modelAndView = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL.getNavegacion());
		}
		return modelAndView;
	}

	/**
	 * peticion asincrona para verificar certificado
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/private/solicitaCertificado.do")
	public ModelAndView solicitaCertificado(HttpServletRequest request, ModelMap map,
			@ModelAttribute("retiroDesempleoImss") RetiroDesempleoImss retiroDesempleoImss) {
		ModelAndView modelnView;
		if (validadorUtils.isEmpty(retiroDesempleoImss.getCus())) {
			folioService.cerrarFolio(retiroDesempleoImss.getIdFolio(), null);
			modelnView = new ModelAndView("redirect:/private/generaCus.do?origen=IMSS");
		} else {
			modelnView = solicitaCertificadoRetiros(request, map, retiroDesempleoImss);
		}
		return modelnView;

	}

	/**
	 * Solicitud del certificado de retiro
	 * 
	 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 * @param request
	 * @param map
	 * @param retiroDesempleoImss
	 * @return
	 */
	public ModelAndView solicitaCertificadoRetiros(HttpServletRequest request, ModelMap map,
			@ModelAttribute("retiroDesempleoImss") RetiroDesempleoImss retiroDesempleoImss) {
		logger.info("Solicita Certificado con sello {}", retiroDesempleoImss);
		request.getSession().removeAttribute(GeneradorPdfConstants.PDF_SESION);  
		request.getSession().removeAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);  
		ValidarSolicitudCertificacionAforeSalida salida = null;
		EntradaConsulta entradaConsulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL);
		ModelAndView modelnView;

		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession()
				.getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		SolicitudDisposicionParcial entradaOp12 = new SolicitudDisposicionParcial();
		try {
			salida = certificadoService.validarCertificado(trabajador, usuarioLogin,retiroDesempleoImss, retiroDesempleoImss.getFolio(), entradaOp12, entradaConsulta);
			logger.info("Salida validarCertificado:{}", salida);
			logger.info("SolicitudDisposicionParcial:{}", entradaOp12);
			
		} catch (Exception e) {
			map.addAttribute("error", e.getMessage());
			logger.error("Error en la generacion del certificado", e);
		}
		if (isEmpty(salida)) {
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		}

		FolioEntrada folio = new FolioEntrada();
		folio.setFolio(retiroDesempleoImss.getFolio());
		map.addAttribute("folio", folio);			
		 
		if (!isEmpty(salida) && "01".equals(salida.getResultadoOperacion())) {
			logger.info("certificadoSalida  {}", salida);
			salida.setSelloTrabajador(retiroDesempleoImss.getSelloTrabajador());
			modelnView = new ModelAndView(NavegacionEnum.AYUDA_DESEMPLEO_SALIDA.getNavegacion(),
					ParametrosConstants.FORMULARIO_SALIDA_CERTIFICADO, salida);
			if(!isEmpty(salida.getDiagnosticoProcesar())){
				if("532".equals(salida.getDiagnosticoProcesar())){
					modelnView.addObject(Constants.MENSAJE, "La Solicitud se encuentra en atención, favor de continuar ");
					request.getSession().setAttribute(ParametrosConstants.SESSION_RESPUESTA_532, true);
					request.getSession().setAttribute(ParametrosConstants.SESSION_RESPUESTA_532_OBJETO, entradaOp12);
				} else {
					modelnView.addObject(Constants.MENSAJE, "El certificado se genero correctamente");
					request.getSession().setAttribute(ParametrosConstants.SESSION_RESPUESTA_532, false);
				}
			}
			request.getSession().setAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS, retiroDesempleoImss);
			map.addAttribute(BOTON_CERTIFICADO, true);

		} else {
			String diagnostico = null;
			if(!validadorUtils.isEmpty(salida)){
				RechazoPulssar rechazo = rechazoService.obtenerRechazo(salida.getDiagnosticoProcesar(), usuarioLogin.getAforeUsuario());
				diagnostico = rechazo.getMensaje();

			}
			modelnView = new ModelAndView(NavegacionEnum.AYUDA_DESEMPLEO.getNavegacion(), Constants.MENSAJE,
					diagnostico);
			if("568".equals(trabajador.getClaveAfore())){
				List<Parametro> telefonias = catalogoService.obtenerParametroDdbpose(Constants.T00074);
				modelnView.addObject(Constants.TELEFONIAS, telefonias);
			}
			modelnView.addObject(BOTON_CUS, false);
			modelnView.addObject(BOTON_CERTIFICADO, false);
		}
		request.getSession().setAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS, retiroDesempleoImss);
	return modelnView;
	}

	/**
	 * envia a pantalla de salida ayuda por desempleo
	 * 
	 * @param request
	 * @param map
	 * @param salida
	 * @return
	 */
	@GetMapping(value = "/private/ayudaDesempleoSalida.do")
	public ModelAndView certificadoSalida(HttpServletRequest request, ModelMap map,
			@ModelAttribute ValidarSolicitudCertificacionAforeSalida salida) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		logger.info("certificadoSalida  {}", salida);
		logger.info("certificadoSalida trabajador {}", trabajador);

		return new ModelAndView(NavegacionEnum.AYUDA_DESEMPLEO_SALIDA.getNavegacion(),
				ParametrosConstants.FORMULARIO_SALIDA_CERTIFICADO, salida);
	}

	/**
	 * tipoRetiro
	 * 
	 * @param request
	 * @param map
	 * @param salida
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = "/private/tiporetiro.do")
	public ModelAndView tipoRetiro(HttpServletRequest request, ModelMap map) {

		RetiroDesempleoImss retiroDesempleoImss = (RetiroDesempleoImss) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		request.getSession().setAttribute(ParametrosConstants.ORIGEN, "desempleo_imss");
		logger.info("salida: {}", retiroDesempleoImss);

		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession()
				.getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosSaldos saldos = (DatosSaldos) request.getSession().getAttribute("datosSaldos");

		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(usuarioLogin.getDatoUsuario());
		folio.setOperacion("S");
		folio.setServicio("S1");
		folio.setProceso("S1P3");
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folio.setOrigen("O");

		FolioEntrada folioRespuesta = folioService.generarFolioAutoClose(folio);
		map.addAttribute("folio", folioRespuesta);

		logger.info("tiporetiro entrada : ##### {}", retiroDesempleoImss);
		CalculoTipoRetiro calculoTipoRetiro = new CalculoTipoRetiro();
       
		try {
	
		 calculoTipoRetiro = tipoRetiroService.obtenerTipoRetiro(retiroDesempleoImss, saldos);
		 request.getSession().setAttribute(ATRIBUTO_CALCULO_TIPO_RETIRO, calculoTipoRetiro);
			
		} catch (IllegalAccessException e) {
			logger.error("IlegalAccessException", e);
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		}

		List<Parametro> listaControlInstitucionBancaria = catalogoService.obtenerParametroDdbpose(Constants.T00003);
		ObjectMapper mapeador = new ObjectMapper();
		String jsonInstitucionBanacaria = "";

		try {
			jsonInstitucionBanacaria = mapeador.writeValueAsString(listaControlInstitucionBancaria);
		} catch (JsonProcessingException e) {
			logger.error("Error json", e);
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		}

		List<Parametro> formasPago = catalogoService.obtenerParametroDdbpose(Constants.T00005);

		map.addAttribute("tipoRetiro", calculoTipoRetiro);
		map.addAttribute("salida", retiroDesempleoImss);
		map.addAttribute("jsonInstitucionBancaria", jsonInstitucionBanacaria);
		map.addAttribute("formasPago", formasPago);
		
		return new ModelAndView(NavegacionEnum.TIPO_RETIRO.getNavegacion());
	}

	

	/**
	 * retiroSolicitudDisposicionSalida
	 * 
	 * @param request
	 * @param map
	 * @param salida
	 * @param mapping
	 * @return
	 */
	@RequestMapping(value = "/private/solicituddisposicionsalida.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView retiroSolicitudDisposicionSalida(HttpServletRequest request, ModelMap map,
			@ModelAttribute("retiroDesempleoImss") RetiroDesempleoImss retiroDesempleoImss) {
		
		logger.info("retiroSolicitudDisposicionSalida {}", retiroDesempleoImss);
		RespuestaServicioNotificacion notificacion=null;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		ParametrosRetiroParcialCalculoImss calculo = (ParametrosRetiroParcialCalculoImss) request.getSession()
				.getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		Boolean inicioFlujo = (Boolean) request.getSession().getAttribute(ParametrosConstants.TERMINO_FLUJO);

		trabajador.getFolio().setIdFolio(calculo.getIdFolio());
		trabajador.getFolio().setFolioHijo(calculo.getFolioHijo());
		trabajador.getFolio().setFolio(calculo.getFolio());

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RetiroDesempleoImss datosRetiroDesempleoImss = (RetiroDesempleoImss) request.getSession()
				.getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		String respuesta = solicitudService.generarExpedientes(trabajador, user, datosRetiroDesempleoImss);
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		logger.info("origen: {}", origen);
		if (!"01".equals(respuesta)) {
			if(!"03".equals(respuesta)){//SE ENVIA NOTIFICACION RECHAZO = RECHAZO 02
				if("04".equals(respuesta)){
					respuesta = "La validación de tu expediente sigue en proceso. Hemos registrado tu trámite para continuar al obtener el resultado de la verificación de documentos";
				} else {
					folioService.cerrarFolio(calculo.getIdFolio(), 2);
					RechazoPulssar rechazo = rechazoService.obtenerRechazo(respuesta, user.getAforeUsuario());
					respuesta = rechazo.getMensaje();
					notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(trabajador.getClaveAfore(), trabajador.getDatosCertificables().getCurp(), 
							calculo.getFolio(), TipoRetiroCoopelEnum.obtenerClave(origen).getClaveRetiro(), FormatoConstants.RESULTADO_OPERACION_RECHAZADO, trabajador.getTipoSolicitante(),rechazo.getClaveRechazo()));
					logger.error("Se envio notificacion retiros respuesta retiroSolicitudDisposicionSalida rechazo :::{} ", notificacion);	
					procesoPendienteService.eliminarProcesoPendiente(trabajador.getDatosCertificables().getCurp(), "03,04");
				}
			} else {//SE ENVIA NOTIFICACION COMPARADOR = MESA 03
				respuesta = "El expediente se ha enviado a comparador";
				notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(trabajador.getClaveAfore(), trabajador.getDatosCertificables().getCurp(), 
						calculo.getFolioHijo(), TipoRetiroCoopelEnum.obtenerClave(origen).getClaveRetiro(), FormatoConstants.RESULTADO_OPERACION_MESA, trabajador.getTipoSolicitante(),""));
				logger.error("Se envio notificacion retiros respuesta retiroSolicitudDisposicionSalida mesa::{} ", notificacion);	

			}
			retiroDesempleoImss.setResultadoOperacion("02");
			retiroDesempleoImss.setMensajeOperacion(respuesta);
			map.addAttribute(Constants.MENSAJE, respuesta);
			logger.info("##### mensaje: {}", respuesta);
		} else {

			SolicitudDisposicionParcialRespuesta disposicion = solicitudService.solicitudDisposicion(trabajador,
					user.getCurpAgente(), datosRetiroDesempleoImss, user, datosRetiroDesempleoImss.getFolio12().getFolio(), origen);
			if ("01".equals(disposicion.getResultadoOperacion())) {//SE ENVIA NOTIFICACION ACEPTADO = ACEPTADO 01
				notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(trabajador.getClaveAfore(), trabajador.getDatosCertificables().getCurp(), 
						datosRetiroDesempleoImss.getFolio12().getFolio(), TipoRetiroCoopelEnum.obtenerClave(origen).getClaveRetiro(), FormatoConstants.RESULTADO_OPERACION_ACEPTADO, trabajador.getTipoSolicitante(),""));
				logger.error("Se envio notificacion cero papel respuesta retiroSolicitudDisposicionSalida aceptado::{} ", notificacion);	
				FolioEntrada folioOperacion16 = new FolioEntrada();
				folioOperacion16.setIdUsuario(user.getDatoUsuario());
				folioOperacion16.setOperacion("S");
				if (Constants.MATRIMONIO.equals(origen)) {
					folioOperacion16.setServicio("S18");
					folioOperacion16.setProceso("S18P6");
					retiroDesempleoImss.setNumeroResolucion(disposicion.getNumeroResolucion());
					} else {
					folioOperacion16.setServicio("S1");
					folioOperacion16.setProceso("S1P6");
					retiroDesempleoImss.setNumeroResolucion(disposicion.getNumeroResolucion());
				}
				folioOperacion16.setSucursal("SUC1");
				folioOperacion16.setNss(trabajador.getNss());
				folioOperacion16.setCurp(trabajador.getDatosCertificables().getCurp());
				folioOperacion16.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
				folioOperacion16.setOrigen("O");
				folioOperacion16.setEstatus(0L);
				folioService.generarNuevoFolio(folioOperacion16);

				retiroDesempleoImss.setResultadoOperacion("01");
				retiroDesempleoImss.setMensajeOperacion("Tu solicitud se realizó con éxito");
				procesoPendienteService.eliminarProcesoPendiente(trabajador.getDatosCertificables().getCurp(), "03,04");
			} else {//SE ENVIA NOTIFICACION RECHAZO = RECHAZO 02
				if(!ServiciosConstants.RESPUESTA_532.equals(disposicion.getDiagnosticoProcesar())){
					procesoPendienteService.eliminarProcesoPendiente(trabajador.getDatosCertificables().getCurp(), "03,04");
					folioService.cerrarFolio(datosRetiroDesempleoImss.getFolio12().getIdFolio(), 2, disposicion.getDiagnosticoProcesar());
					retiroDesempleoImss.setResultadoOperacion("02");
					RechazoPulssar rechazo = rechazoService.obtenerRechazo(disposicion.getDiagnosticoProcesar(), user.getAforeUsuario());
					retiroDesempleoImss.setMensajeOperacion(rechazo.getMensaje());
					map.addAttribute(Constants.MENSAJE, rechazo.getMensaje());
					retiroDesempleoImss.setNumeroResolucion(disposicion.getNumeroResolucion());
					logger.info("##### mensaje: {}", disposicion.getDiagnosticoProcesar());
					notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(trabajador.getClaveAfore(), trabajador.getDatosCertificables().getCurp(), 
							datosRetiroDesempleoImss.getFolio12().getFolio(), TipoRetiroCoopelEnum.obtenerClave(origen).getClaveRetiro(), FormatoConstants.RESULTADO_OPERACION_RECHAZADO, trabajador.getTipoSolicitante(),rechazo.getClaveRechazo()));
					logger.error("Se envio notificacion cero papel respuesta retiroSolicitudDisposicionSalida rechazo::{} ", notificacion);
				} else {
					retiroDesempleoImss.setResultadoOperacion("01");
					retiroDesempleoImss.setMensajeOperacion("Tu solicitud se encuentra pendiente");
				}
			}
		}

		ModelAndView model = new ModelAndView(NavegacionEnum.SOLICITUD_DISPOSICION.getNavegacion());
		logger.info("retiroSolicitudDisposicion salida : ##### {}", retiroDesempleoImss);
		if(ParametrosConstants.MATRIMONIO.equals(origen)){
			origen = "matrimonio";
			
		} else {
			origen = "desempleo";
		}
		model.addObject("retiroDesempleoImss", retiroDesempleoImss);
		model.addObject("origen", origen);
		model.addObject("curpAgente", user.getCurpAgente());
		if (inicioFlujo) {
			EntradaConsulta consulta = (EntradaConsulta) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			map.addAttribute("boton", false);
			logger.info("##### curpBusqueda: {}", trabajador.getDatosCertificables().getCurp());
			logger.info("##### nssBusqueda: {}", trabajador.getNss());
			logger.info("##### cvTipoSolicitanteBusqueda: {}", consulta.getCvTipoSolicitante());
			logger.info("##### timerPikerBusqueda: {}", consulta.getTimerPicker());
			EntradaConsulta commandConsulta = new EntradaConsulta();
			commandConsulta.setCurp(trabajador.getDatosCertificables().getCurp());
			commandConsulta.setNss(trabajador.getNss());
			commandConsulta.setCvTipoSolicitante(consulta.getCvTipoSolicitante());
			commandConsulta.setTimerPicker(consulta.getCvTipoSolicitante());

			model.addObject("commandConsulta", commandConsulta);
		}

		return model;
	}


	/**
	 * retiroSolicitudDisposicionSalida
	 * 
	 * @param request
	 * @param map
	 * @param salida
	 * @param mapping
	 * @return
	 */
	@RequestMapping(value = "/private/solicituddisposicionsalida2.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView retiroSolicitudDisposicionSalida532(HttpServletRequest request, ModelMap map) {
		
		RespuestaServicioNotificacion notificacion=null;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		Boolean inicioFlujo = (Boolean) request.getSession().getAttribute(ParametrosConstants.TERMINO_FLUJO);

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		ParametrosRetiroParcialCalculoImss calculo = (ParametrosRetiroParcialCalculoImss) request.getSession()
				.getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		RetiroDesempleoImss retiroDesempleoImss = new RetiroDesempleoImss();
		trabajador.getFolio().setIdFolio(calculo.getIdFolio());
		trabajador.getFolio().setFolioHijo(calculo.getFolioHijo());
		trabajador.getFolio().setFolio(calculo.getFolio());
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);

//		SolicitudDisposicionParcial salida = (SolicitudDisposicionParcial) request.getSession().getAttribute(ParametrosConstants.SESSION_RESPUESTA_532_OBJETO);
////		Boolean flujo532 = (Boolean) request.getSession().getAttribute(ParametrosConstants.SESSION_RESPUESTA_532);
//		salida.setFolioTramiteProcesar(calculo.getFolio());
//		salida.setFolioCliente(calculo.getFolio());
		RetiroDesempleoImss datosRetiroDesempleoImss = (RetiroDesempleoImss) request.getSession()
				.getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
	String respuesta = solicitudService.generarExpedientes(trabajador, user, datosRetiroDesempleoImss);
		
		
		
		if ("01".equals(respuesta)) {
			FolioEntrada folioOperacion16 = new FolioEntrada();
			folioOperacion16.setIdUsuario(user.getDatoUsuario());
			folioOperacion16.setOperacion("S");
			if (Constants.MATRIMONIO.equals(origen)) {
				folioOperacion16.setServicio("S18");
				folioOperacion16.setProceso("S18P6");
			} else {
				folioOperacion16.setServicio("S1");
				folioOperacion16.setProceso("S1P6");
			}
			folioOperacion16.setSucursal("SUC1");
			folioOperacion16.setNss(trabajador.getNss());
			folioOperacion16.setCurp(trabajador.getDatosCertificables().getCurp());
			folioOperacion16.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
			folioOperacion16.setOrigen("O");
			folioOperacion16.setEstatus(0L);
			folioService.generarNuevoFolio(folioOperacion16);

			retiroDesempleoImss.setResultadoOperacion("01");
			retiroDesempleoImss.setMensajeOperacion("Tu solicitud se encuentra en proceso");
		} else if(!"03".equals(respuesta)){// SE ENVIA NOTIFICACION RECHAZO = RECHAZO 02 
			if("04".equals(respuesta)){
				respuesta = "La validación de tu expediente sigue en proceso. Hemos registrado tu trámite para continuar al obtener el resultado de la verificación de documentos";
			} else {
				folioService.cerrarFolio(calculo.getIdFolio(), 2);
				RechazoPulssar rechazo = rechazoService.obtenerRechazo(respuesta, user.getAforeUsuario());
				respuesta = rechazo.getMensaje();
				retiroDesempleoImss.setResultadoOperacion("02");
				retiroDesempleoImss.setMensajeOperacion(respuesta);
				notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(trabajador.getClaveAfore(), trabajador.getDatosCertificables().getCurp(), 
						calculo.getFolio(), TipoRetiroCoopelEnum.obtenerClave(origen).getClaveRetiro(), FormatoConstants.RESULTADO_OPERACION_RECHAZADO, trabajador.getTipoSolicitante(),rechazo.getClaveRechazo()));
				logger.error("Se envio notificacion retiros respuesta retiroSolicitudDisposicionSalida532 rechazo::{} ", notificacion);	
			}
		} else {// SE ENVIA NOTIFICACION HACIA COMPARADOR = MESA 03
			retiroDesempleoImss.setResultadoOperacion("02");
			respuesta = "El expediente se ha enviado a comparador";
			retiroDesempleoImss.setMensajeOperacion(respuesta);
			notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(trabajador.getClaveAfore(), trabajador.getDatosCertificables().getCurp(), 
					calculo.getFolioHijo(), TipoRetiroCoopelEnum.obtenerClave(origen).getClaveRetiro(), FormatoConstants.RESULTADO_OPERACION_MESA, trabajador.getTipoSolicitante(),""));
			logger.error("Se envio notificacion retiros respuesta retiroSolicitudDisposicionSalida532 mesa::{} ", notificacion);	
		}
		map.addAttribute(Constants.MENSAJE, respuesta);
		logger.info("##### mensaje: {}", respuesta);
		if(Constants.MATRIMONIO.equals(origen)){
			origen = "matrimonio";
		} else {
			origen = "desempleo";
		}

		ModelAndView model = new ModelAndView(NavegacionEnum.SOLICITUD_DISPOSICION.getNavegacion());
		logger.info("retiroSolicitudDisposicion salida : ##### {}", retiroDesempleoImss);
		model.addObject("retiroDesempleoImss", retiroDesempleoImss);

		if (inicioFlujo) {
			EntradaConsulta consulta = (EntradaConsulta) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			map.addAttribute("boton", false);
			map.addAttribute("origen", origen);
			logger.info("##### curpBusqueda: {}", trabajador.getDatosCertificables().getCurp());
			logger.info("##### nssBusqueda: {}", trabajador.getNss());
			logger.info("##### cvTipoSolicitanteBusqueda: {}", consulta.getCvTipoSolicitante());
			logger.info("##### timerPikerBusqueda: {}", consulta.getTimerPicker());
			EntradaConsulta commandConsulta = new EntradaConsulta();
			commandConsulta.setCurp(trabajador.getDatosCertificables().getCurp());
			commandConsulta.setNss(trabajador.getNss());
			commandConsulta.setCvTipoSolicitante(consulta.getCvTipoSolicitante());
			commandConsulta.setTimerPicker(consulta.getCvTipoSolicitante());

			model.addObject("commandConsulta", commandConsulta);
		}

		return model;
	}

	/**
	 * llenarObjetoTramitesConcluidosEntradas
	 * @param entradaCeroPapel
	 * @return
	 */
	private TramitesConcluidosEntrada llenarObjetoTramitesConcluidosEntradas(String afore,String curp, String folioProcesar,
			String subTipoSolicitante,String resultadoOperacion,String tipoSolicitante,String diagnostico) {
		logger.error("Afore retiros::{} ", afore);
		logger.error("Curp retiros::{} ", curp);
		logger.error("Folio Procesar retiros::{} ", folioProcesar);
		logger.error("Subtipo retiros::{} ", subTipoSolicitante);	
		TramitesConcluidosEntrada entradaTramiteConcluido= new TramitesConcluidosEntrada();
		entradaTramiteConcluido.setAfore(afore);
		entradaTramiteConcluido.setCurp(curp);
		entradaTramiteConcluido.setFolioProcesar(folioProcesar);
		entradaTramiteConcluido.setSubTipoSolicitante(subTipoSolicitante);
		entradaTramiteConcluido.setResultadoOperacion(resultadoOperacion);
		entradaTramiteConcluido.setTipoSolicitante(tipoSolicitante);
		entradaTramiteConcluido.setUsuarioModificador(ModificacionTrabajadorConstants.RETIROS);
		entradaTramiteConcluido.setFcControl(new Date());
		entradaTramiteConcluido.setDiagnostico(diagnostico);
		logger.error("Retiros::{} ", entradaTramiteConcluido);
		return entradaTramiteConcluido;
		
	}
}
