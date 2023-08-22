package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionesTotalesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Controlador para el manejo de peticiones de la consulta de trabajadors
 * 
 * @version 1.0
 * @since
 */
@Controller
public class MenuController {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	@Autowired
	private RetirosDesempleoIsssteService retirosDesempleoIsssteService;
	
	/**
	 * selloService
	 */
	@Autowired
	private ConsultaSelloService selloService;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdmin;
	/**
	 * Inyeccion dependencia RetirosDesempleoImssService
	 */
	@Autowired
	private RetirosDesempleoImssService retirosDesempleoImssService;

	/**
	 * service
	 */
	@Autowired
	private DisposicionesTotalesService service;
	/**
	 * Inyeccion disposicionTotalImssService
	 */
	@Autowired
	private DisposicionTotalImssService disposicionTotalImssService;
	
	/**
	 * Curps duoplc
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/menuRetiroParcial.do", method = RequestMethod.GET)
	public ModelAndView mostrarMenuretiroParcial(HttpServletRequest request, ModelMap map) {
		logger.info("Menu de retiro Parcial");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		map.addAttribute(Constants.FOLIO, trabajador.getFolio());
		ModelAndView model = new ModelAndView(NavegacionEnum.MENU_RETIRO_PARCIAL.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

		List<MenuPagina> menuUsuario = servicioAdmin.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario(), 3L);
		request.getSession().setAttribute("menuUsuario", menuUsuario);
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		return model;
	}
	
	/**
	 * SubMenu Ayuda Matrimonio
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/private/menuAyudaMatrimonio.do", method = RequestMethod.GET)
	public ModelAndView mostrarsubMenuAyudaMatrimonio(HttpServletRequest request, ModelMap map) {
		logger.info("Sub menu de retiro Parcial");
		request.getSession().removeAttribute(ParametrosConstants.PASO_UNO_RETIROS);
		request.getSession().removeAttribute(ParametrosConstants.PASO_DOS_RETIROS);
		request.getSession().removeAttribute(ParametrosConstants.PASO_TRES_RETIROS);
		request.getSession().removeAttribute(ParametrosConstants.PASO_CUATRO_RETIROS);
		request.getSession().removeAttribute(ParametrosConstants.DATOS_CERTIFICACION);

		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);

		ModelAndView model = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL_AYUDA_MATRIMONIO.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String activoImss = null;
		List<String> imssClaves = new ArrayList<>();
		imssClaves.add(ActivacionConstants.CLAVE_IMSS_RETIRO);
		String tipoAfiliacion = trabajador.getTipoAfiliacion();

		boolean imss = (ActivacionConstants.TIPO_AFILIACION_2.equals(tipoAfiliacion) || ActivacionConstants.TIPO_AFILIACION_3.equals(tipoAfiliacion)) ? true : false;

		map.addAttribute(ActivacionConstants.IMSS, imss);
		map.addAttribute(ActivacionConstants.ACTIVO_IMSS, activoImss);

		try {

			activoImss = retirosDesempleoImssService.validarPrecondicionesImss(trabajador.getDatosExpediente(), imssClaves, trabajador.getProcesar(), trabajador.getClaveAfore(), trabajador.getTipoSolicitante());
			activoImss = retirosDesempleoImssService.validarSolicitante(trabajador.getTipoSolicitante(), activoImss);
			activoImss = retirosDesempleoImssService.validarProcesoPendiente(trabajador.getDatosCertificables().getCurp(), activoImss, "matrimonio");
			DatosSaldos datosSaldos = trabajador.getSaldos();

			request.getSession().setAttribute("datosSaldos", datosSaldos);
			activoImss = retirosDesempleoImssService.validarSaldos(activoImss, datosSaldos);

			map.addAttribute(ActivacionConstants.IMSS, imss);
			logger.info("MenuretiroParcial activoImss:{}", activoImss);
			if(!"01".equals(trabajador.getTipoSolicitante())) {
				activoImss = "R|Solo el titular puede realizar el tramite";
			}
			map.addAttribute(ActivacionConstants.ACTIVO_IMSS, activoImss);

			model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		} catch (BusinessException e) {
			logger.error("Error", e);
			map.addAttribute(ActivacionConstants.ERROR, e.getMessage());
		}
		return model;
	}
	
	/**
	 * SubMenu Retiro Parcial Desempleo
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/private/menuRetiroParcialDesempleo.do", method = RequestMethod.GET)
	public ModelAndView mostrarsubMenuRetiroParcial(HttpServletRequest request, ModelMap map) {
		logger.info("Sub menu de retiro Parcial");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);

		ModelAndView model = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String activoImss = null;
		String activoIssste = null;
		String tipoTramite  = null;
		List<String> imssClaves = new ArrayList<>();
		imssClaves.add(ActivacionConstants.CLAVE_IMSS_RETIRO);
		
		
		String tipoAfiliacion = trabajador.getTipoAfiliacion();
		boolean imss = (ActivacionConstants.TIPO_AFILIACION_2.equals(tipoAfiliacion) || ActivacionConstants.TIPO_AFILIACION_3.equals(tipoAfiliacion)) ? true : false;
		boolean issste = ActivacionConstants.TIPO_AFILIACION_3.equals(tipoAfiliacion) || ActivacionConstants.TIPO_AFILIACION_4.equals(tipoAfiliacion) || ActivacionConstants.TIPO_AFILIACION_5.equals(tipoAfiliacion);

		
		try {
			if (imss) {
				activoImss = retirosDesempleoImssService.validarPrecondicionesImss(trabajador.getDatosExpediente(), imssClaves, trabajador.getProcesar(), trabajador.getClaveAfore(), trabajador.getTipoSolicitante());
				activoImss = retirosDesempleoImssService.validarSolicitante(trabajador.getTipoSolicitante(), activoImss);
				activoImss = retirosDesempleoImssService.validarProcesoPendiente(trabajador.getDatosCertificables().getCurp(), activoImss, "desempleo");
				DatosSaldos datosSaldos= trabajador.getSaldos();
//				datosSaldos = new DatosSaldos();
//				datosSaldos.setSaldoCesantiaVejez("1");
//				datosSaldos.setSaldoCuotaSocial("2");
//				datosSaldos.setSaldoRetiro97("3");
				request.getSession().setAttribute("datosSaldos", datosSaldos);
				activoImss = retirosDesempleoImssService.validarSaldos(activoImss, datosSaldos);
			}
			if (issste) {
				//1 ambos 0 ordinario
				tipoTramite = retirosDesempleoIsssteService.obtenerParametroOpcionTramite(trabajador.getClaveAfore());
				if(StringUtils.isNotBlank(tipoTramite)){
					activoIssste = retirosDesempleoIsssteService.validarIssste(trabajador.getProcesar(), trabajador, ActivacionConstants.CLAVE_4_ISSSTE_DISPOSICION);
					activoIssste = retirosDesempleoIsssteService.validarSaldos(activoIssste, trabajador.getSaldos());
					//TODO descomentar para consulta de trabajador
					//activoIssste = retirosDesempleoIsssteService.consultaRegimen(trabajador.getDatosCertificables().getCurp());
					if(!StringUtils.contains(activoIssste, "N|")) {
						request.getSession().setAttribute("nti", activoIssste);
						activoIssste = null;
					}
				} else {
					issste = false;
				}
			}
			
			map.addAttribute(ActivacionConstants.IMSS, imss);
			map.addAttribute(ActivacionConstants.ISSSTE, issste);
			logger.info("MenuretiroParcial activoImss:{}", activoImss);
			logger.info("MenuretiroParcial activoIssste:{}", activoIssste);
			logger.info("MenuretiroParcial regimenIssste:{}", tipoTramite);
			
			
			map.addAttribute(ActivacionConstants.ACTIVO_IMSS, activoImss);
			map.addAttribute(ActivacionConstants.ACTIVO_ISSSTE, activoIssste);
			map.addAttribute(ActivacionConstants.TIPO_TRAMITE, tipoTramite);
			
			model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		} catch (BusinessException e) {
			logger.error("Error", e);
			map.addAttribute(ActivacionConstants.ERROR, e.getMessage());
		}
		return model;
	}
	
	/**
	 * SubMenu Disposicion Total
	 * @param request
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/private/menuDisposicionTotal.do", method = RequestMethod.GET)
	public ModelAndView mostrarMenuretiroTotal(HttpServletRequest request, ModelMap map, Model model) {
		logger.info("Menu de retiro Total");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		DatosCertificables datos = trabajador.getDatosCertificables();		
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		
		ArrayList<String> imssClaves = new ArrayList<>();
		imssClaves.add(ActivacionConstants.CLAVE_1_IMSS_DISPOSICION);
		imssClaves.add(ActivacionConstants.CLAVE_3_IMSS_DISPOSICION);
		imssClaves.add(ActivacionConstants.CLAVE_2_IMSS_DISPOSICION);

		ArrayList<String> isssteClaves = new ArrayList<>();
		isssteClaves.add(ActivacionConstants.CLAVE_1_ISSSTE_DISPOSICION);
		isssteClaves.add(ActivacionConstants.CLAVE_2_ISSSTE_DISPOSICION);
		isssteClaves.add(ActivacionConstants.CLAVE_3_ISSSTE_DISPOSICION);
		
		String tipoAfiliacion = trabajador.getTipoAfiliacion();  
		
		boolean imss = (ActivacionConstants.TIPO_AFILIACION_2.equals(tipoAfiliacion) || ActivacionConstants.TIPO_AFILIACION_3.equals(tipoAfiliacion)) ? true : false;
		boolean issste = (ActivacionConstants.TIPO_AFILIACION_3.equals(tipoAfiliacion) || ActivacionConstants.TIPO_AFILIACION_4.equals(tipoAfiliacion)|| ActivacionConstants.TIPO_AFILIACION_5.equals(tipoAfiliacion)) ? true : false;
		String activoImss = null;
		String activoIssste = null;
		
		map.addAttribute("imss", imss);
		map.addAttribute("issste", issste);
		try {
			Sello sello = selloService.obtenerSelloTrabajador(user.getCurpAgente(), datos.getCurp(), trabajador.getClaveAfore());
			selloService.guardarSello(sello.getId(), "40");
			trabajador.setSello(sello);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
			if(imss) {
				activoImss = retirosDesempleoImssService.validarPrecondicionesImss(trabajador.getDatosExpediente(), imssClaves, trabajador.getProcesar(), trabajador.getClaveAfore(), trabajador.getTipoSolicitante());
			}
			
			if(issste){
				activoIssste = disposicionTotalImssService.validarPrecondicionesDisposicionesImss(trabajador.getDatosExpediente(), isssteClaves, trabajador.getProcesar(), trabajador.getClaveAfore());
			}
			
			map.addAttribute(ActivacionConstants.FOLIO, trabajador.getFolio());
			map.addAttribute(ActivacionConstants.ACTIVO_IMSS, activoImss);
			map.addAttribute(ActivacionConstants.ACTIVO_ISSSTE, activoIssste);
			
			logger.info("folio: {}", trabajador.getFolio());
			logger.info("tipo de afiliacion: {}", tipoAfiliacion);
			logger.info("boton imss activo: {}", imss);
			logger.info("botom issste activo: {}", issste);
			logger.info("validacion marca Imss: {}", activoImss);
			logger.info("validacion marca Issste: {}", activoIssste);
			
		}catch (BusinessException e) {
			logger.error("Error en la consulta de sello", e);
			map.addAttribute(ActivacionConstants.ERROR, e.getMessage());
			
		}
		logger.info("Respuesta Servicio:{}",respuestaServicio);
		ModelAndView modelnview = new ModelAndView(NavegacionEnum.SUB_MENU_DISPOSICION_TOTAL.getNavegacion());
		modelnview = utileriaConversion.obtenerImagenNombreUsuario(modelnview, user);
		modelnview = utileriaConversion.agregarRespuestaModel(modelnview, respuestaServicio);  
		
		return modelnview;
	}

		
	/**
	 * Metodo para mostrar vista pagos por Parcialidad
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/private/menuRetiroParcialPagoParcialidad.do", method = RequestMethod.GET)
	public ModelAndView mostrarsubMenuretiroParcialPagoParcialiadad(HttpServletRequest request, ModelMap map) {
		logger.info("Sub menu de retiro Parcial Pago Parcialidad");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		map.addAttribute(ActivacionConstants.FOLIO, trabajador.getFolio());
		ModelAndView model = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL_PAGO_PARCIALIDAD.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		
		return model;
	}
	
	/**
	 * Metodo para mostrar la vista Reintegro Recursos Desempleo
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/private/menuRetiroParcialReintegroRecursos.do", method = RequestMethod.GET)
	public ModelAndView mostrarSubMenuRetiroReintegroRecursosParcialDesempleo(HttpServletRequest request, ModelMap map) {
		logger.info("Sub menu de retiro Parcial Reintegro Recursos");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		map.addAttribute(ActivacionConstants.FOLIO, trabajador.getFolio());
		ModelAndView model = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL_REINTEGRO_RECURSOS_DESEMPLEO.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		return model;
	}
	
	
	@GetMapping(value = "/private/validaTramiteIssste/{tramite}")
	@ResponseBody
	public String consultaTipoTramiteValido(HttpServletRequest request, ModelMap map, Model model, @PathVariable String tramite) {
		String respuesta = null;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Resolucion resolucion =null;
		try {
			
			respuesta = retirosDesempleoIsssteService.validarSaldosPorRegimen(tramite, trabajador.getSaldos());
			if(!StringUtils.isEmpty(respuesta)) {
				return respuesta;
			}
			resolucion = retirosDesempleoIsssteService.consultaTipoTramiteValido(trabajador.getProcesar(), tramite);
			
			request.getSession().setAttribute(ParametrosConstants.RESOLUCION_ISSSTE, resolucion);
			if(tramite.equals("RO")) {
				request.getSession().setAttribute(ParametrosConstants.TIPO_TRAMITE, "01");
			}else {
				request.getSession().setAttribute(ParametrosConstants.TIPO_TRAMITE, "02");
			}
			
			respuesta =  "01";
		}catch(BusinessException e) {
			respuesta = e.getMessage();
		}
		
		return respuesta;
	}
}
