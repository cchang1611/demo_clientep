package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants.DDMMYYYY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.IretTcDiagnostico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargadoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionReti;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoClavePensionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPensionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPrestacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoRetiroIretService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoSeguroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretDiagnosticoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretResolucionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDerechoAceptadoImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarIcefaTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoImmsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoCargadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoNoCargadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarResolucionRetiService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerPlanPrivadoPorNssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerRecaudadoraPorNrpService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarMatrizDerechoProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Actuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Banxico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTipoSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDiagnostico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIcefaTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Marca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerechoProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PrecioAccion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoDerechoCargadoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecaudadoraTV;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroPlanPrivado73;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoDoctoProbatorio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Servicio para obtener la disposiciones totales
 * @author ANOSORIO
 *
 */
@Controller
public class DisposicionTotalImssController extends BaseController{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DisposicionTotalImssController.class);

	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;

	/**
	 * Inyeccion catalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * Inyeccion diagnosticoService
	 */
	@Autowired
	private ConsultaIretDiagnosticoService diagnosticoService;

	/**
	 * Inyeccion resolucionService
	 */
	@Autowired
	private ConsultaIretResolucionService resolucionService;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * service
	 */
	@Autowired
	private DisposicionTotalImssService service;

	/**
	 * selloService
	 */
	@Autowired
	private ConsultaSelloService selloService;
	
	/**
	 * cusService
	 */
	@Autowired
	private CusService cusService;
	
	/**
	 * Inyeccion utileriaFecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Inyeccion tipoSeguroService
	 */
	@Autowired
	private CatalogoTipoSeguroService  tipoSeguroService;
	
	/**
	 * Inyeccion tipoPensionService
	 */
	@Autowired
	private CatalogoTipoPensionService  tipoPensionService;
	
	/**
	 * Inyeccion clavePensionService
	 */
	@Autowired
	private CatalogoClavePensionService  clavePensionService;
	
	/**
	 * Inyeccion tipoPrestacionService
	 */
	@Autowired
	private CatalogoTipoPrestacionService tipoPrestacionService;
	
	/**
	 * Inyeccion tipoRetiroService
	 */
	@Autowired
	private CatalogoTipoRetiroIretService tipoRetiroService;
	
	/**
	 * Inyeccion disposicionService
	 */
	@Autowired
	private DisposicionTotalImssService disposicionService;
	
	/**
	 * Inyeccion consultarResolucionRetiService
	 */
    @Autowired
    private ConsultarResolucionRetiService consultarResolucionRetiService;
	
	/**
	 * Inyeccion subCuentastaService
	 */
	@Autowired
	private ObtenerDerechoSubcuentaMatrizDerechoService subCuentastaService;
	
	
    /**
     * Inyeccion consultarProcesoDerechoCargadoService
     */
    @Autowired  
    private ConsultarProcesoDerechoCargadoService consultarProcesoDerechoCargadoService;
   
    /**
     * Inyeccion consultarProcesoDerechoNoCargadoService
     */
    @Autowired
    private ConsultarProcesoDerechoNoCargadoService consultarProcesoDerechoNoCargadoService;
    
    /**
     * Inyeccion obtenerPlanPrivadoPorNssService
     */
    @Autowired
    private ObtenerPlanPrivadoPorNssService obtenerPlanPrivadoPorNssService;
    
    /**
     * Inyeccion obtenerRecaudadoraPorNrpService 
     */    
    @Autowired        
    private ObtenerRecaudadoraPorNrpService obtenerRecaudadoraPorNrpService;
    
    /**
     * Inyeccion consultarMatrizDerechoImmsService
     */
    @Autowired
    private ConsultarMatrizDerechoImmsService consultarMatrizDerechoImmsService;
    
    /**
     * Inyeccion documentoProbatorioService
     */
    @Autowired
    private CatalogoService documentoProbatorioService;

    /**
     * Inyeccion obtenerEdadService
     */
    @Autowired
    private DisposicionTotalIsssteService obtenerEdadService;
    
    /**
     * convierteFechaService
     */
    @Autowired
    private FechaUtils convierteFechaService;
    
    /**
     * validarDerechoProcesoService
     */
    @Autowired
    private ValidarMatrizDerechoProcesoService validarDerechoProcesoService;
    
    
    /**
	 * Inyeccion de servicio consultarIcefaTrabajadorService
	 */
	@Autowired
	private ConsultarIcefaTrabajadorService consultarIcefaTrabajadorService;
    
	/***
	 * derechoAceptadoService
	 */
	@Autowired
	private ConsultarDerechoAceptadoImssService derechoAceptadoService;
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@Autowired
	private DisposicionTotalIsssteService disposicionTotalIsssteService;
	
	/**
	 *  dispTotalImss
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param request
	 *  @param map
	 *  @return
	 */
	/**
	 * Inyeccion de ModificacionTrabajadorService
	 */
	@GetMapping(value = "/private/dispTotalImss.do")
	public ModelAndView dispTotalImss(HttpServletRequest request, ModelMap map) {
		ModelAndView modelAndView = null;
		
		RespuestaServicio respuesta = new RespuestaServicio();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		DatosCertificables datos = trabajador.getDatosCertificables();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		FolioEntrada folioGenera = new FolioEntrada();
		folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
		folioGenera.setIdUsuario(user.getDatoUsuario());
		folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
		folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_IIMSS_S15);
		folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES15P1);
		folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
		folioGenera.setNss(trabajador.getNss());
		folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
		folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folioGenera.setOrigen(ActivacionConstants.ORIGEN);
		folioGenera = folioService.generarFolio(folioGenera);
		trabajador.setFolio(folioGenera);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		
		try {
		Sello sello = selloService.obtenerSelloTrabajador(user.getCurpAgente(), datos.getCurp(), trabajador.getClaveAfore());
		selloService.guardarSello(sello.getId(), "40");
		trabajador.setSello(sello); 
 	    generarCus(datos,map,request,user,trabajador);
		map.addAttribute(ServiciosConstants.FOLIO, trabajador.getFolio());
		List<TipoDoctoProbatorio> obtenerTiposDoctos = documentoProbatorioService.obtenerTiposDoctos();
		map.addAttribute(Constants.DOCUMENTO_PROBATORIO, obtenerTiposDoctos);
		consultarDatosGenerales(map,trabajador,user,request);
		
		respuesta = documentoProbatorioService.obtenerRespuesta(null,Constants.CV_RECHAZO_MDI1, ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_UNO, null);
		if (!utileriaValidador.isEmpty(respuesta)) {
			logger.info("listaCvRechazoParametro: {}", respuesta);
			respuesta.setTitulo(respuesta.getTitulo());
			respuesta.setFlujo(4);
		    respuesta.setMensaje(respuesta.getMensaje());
		   
		}
		
		modelAndView = new ModelAndView(NavegacionEnum.DISPOSICION_TOTAL_IMSS.getNavegacion());
	    modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, user);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuesta);  
		}catch (Exception e) {
			logger.error("error en la consulta resolucion", e);
			map.addAttribute("error", e.getMessage());
			modelAndView = new ModelAndView(NavegacionEnum.SUB_MENU_DISPOSICION_TOTAL.getNavegacion());
		} 
      return modelAndView;
	}
	
	/**
	 *  Metodo que Genera Cus ,sino existe lo genera 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param datos
	 *  @param map
	 *  @param request
	 *  @param user
	 *  @param trabajador
	 */
	private void generarCus(DatosCertificables datos, ModelMap map, HttpServletRequest request,UsuarioLogin user,DatosTrabajador trabajador) {
		RetiroDesempleoImss retiroDesempleoImss = new RetiroDesempleoImss();
		FolioEntrada folioGenera = new FolioEntrada();
		folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
		folioGenera.setIdUsuario(user.getDatoUsuario());
		folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
		folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_IIMSS_S15);
		folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES15P2);
		folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
		folioGenera.setNss(trabajador.getNss());
		folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
		folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folioGenera.setOrigen(ActivacionConstants.ORIGEN);
		folioGenera = folioService.generarFolio(folioGenera);
		trabajador.setFolio(folioGenera);
		ConsultaCusSalida cusSalida;
		cusSalida = cusService.solicitarConsultaCus(datos.getCurp(),Constants.ESTATUS, folioGenera.getFolio(), trabajador.getClaveAfore(), "4");
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		if (!ObjectUtils.isEmpty(cusSalida) && Constants.RESULTADO_OPERACION_01.equals(cusSalida.getCodigo())) {
			logger.info("CUS -EXISTENTE:{}",cusSalida.getRespuesta().get(Constants.CUS));
			retiroDesempleoImss.setCus(cusSalida.getRespuesta().get(Constants.CUS));
			map.addAttribute(Constants.RETIRO_DESEMPLEO_IMSS, retiroDesempleoImss);
     		request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoImss);
     		
		} else {
			logger.info("NO Existe CUS:Se generara CUS en Automatico");
			
			logger.info("Folio genera :{}",folioGenera.getIdFolio());
			RespuestaGeneraCusSalida salidaGeneraCus = disposicionService.generarCus(trabajador, user, Constants.IMSS, folioGenera.getIdFolio());
			retiroDesempleoImss.setCus(salidaGeneraCus.getCus());
			logger.info("CUS -GENERADO:{}", retiroDesempleoImss.getCus());
			map.addAttribute(Constants.RETIRO_DESEMPLEO_IMSS, retiroDesempleoImss);
			request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoImss);
		}
		
	}

	/**
	 *  Metodo genera Cus
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @return
	 */
	@ResponseBody
	@GetMapping(value = "/private/cusDispTotalImss.do", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> cusDispTotalImss(HttpServletRequest request, ModelMap map) {
		
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		FolioEntrada folioRespuesta = service.generarFolio(user, "IMSS", trabajador);
		folioRespuesta = folioService.procesarFolio(folioRespuesta, trabajador);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FOLIO, folioRespuesta);
		
		
		RespuestaGeneraCusSalida salida;
		try {
			salida = service.generarCus(trabajador, user, "IMSS", folioRespuesta.getIdFolio());
		}catch (Exception e) {
			logger.error("Error en la generacion de cus", e);
			salida = new RespuestaGeneraCusSalida();
		}

		
		HashMap<String, String> json = new HashMap<>();

		if("01".equals(salida.getResultadoOperacion())){
			json.put("correcto", "true");
			json.put("descDiagnostico", "CUS generada correctamente");
		} else {
			json.put("correcto", "false");
			json.put("descDiagnostico", "Error ".concat(salida.getDiagnosticoProcesar() + " al generar la CUS" ));
		}
		return json;
	}

	
	/**
	 * Metodo para obtener la disposicion IMSS
	 * @param request
	 * @param map
	 * @param mensaje
	 * @return
	 */

	@GetMapping(value="/private/disposicionTotalImss.do")
	public ModelAndView disposicionTotalImss(HttpServletRequest request, ModelMap map, @ModelAttribute String mensaje) {
	
		ModelAndView modelAndView;  
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		FolioEntrada folioRespuesta = (FolioEntrada) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_FOLIO);
		
		List<BiomTipoSolicitante> listasolicitante  = catalogoService.obtenerTipoSolicitante(trabajador.getTipoSolicitante());
		
		for (BiomTipoSolicitante biomTipoSolicitante : listasolicitante) {
			map.addAttribute("cvtipoSolicitante", biomTipoSolicitante.getCvTipoSolicitante());
			map.addAttribute("solicitante", biomTipoSolicitante.getChTipoSolicitante());
		}
		
		List<Parametro> tipoRegimen = catalogoService.obtenerParametroDdbpose(Constants.T00022);
		 for (Parametro regimen : tipoRegimen) {
			map.addAttribute("tipoRegimen", regimen.getChValorParametro());
		}
		List<Parametro> tipoRetiro = catalogoService.obtenerParametroDdbpose(Constants.T00023);
		for (Parametro retiro : tipoRetiro) {
			map.addAttribute("tipoRetiro", retiro.getChValorParametro());
		}
		
		request.getSession().setAttribute("folioRespuesta",folioRespuesta);
		map.addAttribute(ServiciosConstants.FOLIO, folioRespuesta);
		map.addAttribute(ServiciosConstants.FOLIO, trabajador.getFolio());
		
		modelAndView = new ModelAndView(NavegacionEnum.TRABAJOR_CON_DERECHO_DERECHO_NO_CARGADO_IMSS.getNavegacion());
		modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, usuarioLogin);
		return modelAndView;

	}

	/**
	 * 
	 *  Metodo para obtener la disposicon ISSSTE
	 *  @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param mensaje
	 *  @return
	 */
	@GetMapping(value = "/private/disposicionTotalIssste.do")
	public ModelAndView disposicionTotalIssste(HttpServletRequest request, ModelMap map,
			@ModelAttribute String mensaje) {
		logger.info("disposicionTotalIssste.do");
		ModelAndView modelAndView;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		List<BiomTipoSolicitante> listasolicitante = null;
		DatosCertificables datos = trabajador.getDatosCertificables();
		String fechaEmision=null;
		String fechaInicioPension=null;
		Integer semanasCotizadas=0;
		
		VerificacionSello salida = new VerificacionSello();
		try {
			salida.getSello();

			Sello sello = selloService.obtenerSelloTrabajador(usuarioLogin.getCurpAgente(), datos.getCurp(),trabajador.getClaveAfore());
			selloService.guardarSello(sello.getId(), ActivacionConstants.PROCESO);
			trabajador.setSello(sello);
//			ConsultaCusSalida cusSalida = cusService.solicitarConsultaCus(datos.getCurp(), ActivacionConstants.ACTIVO_UNO, ActivacionConstants.TIPO_SEVICIO);
//
//    		if (!utileriaValidador.isEmpty(cusSalida) && cusSalida.getCodigo().equals(ActivacionConstants.RESULTADO_RESPUESTA_01)) {
//				 map.addAttribute(BOTON_CERTIFICADO, true);
//    		} else {
//				map.addAttribute(BOTON_CERTIFICADO);
//    		}
    		
			IretTcDiagnostico diagnostico = diagnosticoService.consultarIretDiagnostico(ActivacionConstants.CLAVE_PROCCESO,
					ActivacionConstants.CLAVE_TIPO_OPERACION, ActivacionConstants.CODIGO_DIAGNOSTICO,
					ActivacionConstants.ACTIVO_UNO);
			Long idDiagnostico = diagnostico.getIdDiagnostico();
			List<Resolucion> listaResolucion = resolucionService.consultarIretResolucion(trabajador.getProcesar(),
					idDiagnostico);
			for (Resolucion resolucion : listaResolucion) {
		         fechaEmision      =utileriaFecha.convertirFechaACadena(resolucion.getFechaEmision(),FormatoConstants.FORMATO_FECHA_RENAPO);
		         fechaInicioPension=utileriaFecha.convertirFechaACadena(resolucion.getFechaInicioPension(),FormatoConstants.FORMATO_FECHA_RENAPO);
		         semanasCotizadas  =resolucion.getSemanasCotizadas();
		                                
				}
						
			List<Parametro> listaParametros = catalogoService.obtenerParametroDdbpose(Constants.T00024);
			cargarResoluciones(map, listaParametros, listaResolucion,request);

			listasolicitante = catalogoService.obtenerTipoSolicitante(trabajador.getTipoSolicitante());
			for (BiomTipoSolicitante biomTipoSolicitante : listasolicitante) {
				map.addAttribute("cvtipoSolicitante", biomTipoSolicitante.getCvTipoSolicitante());
				map.addAttribute("solicitante", biomTipoSolicitante.getChTipoSolicitante());
			}
			List<Parametro> tipoRetiro = catalogoService.obtenerParametroDdbpose(Constants.T00023);
			
			map.addAttribute("tipoRetiro", tipoRetiro);
			map.addAttribute("fechaInicio",fechaInicioPension);
			map.addAttribute("fechaEmision",fechaEmision);
			map.addAttribute("semanasCotizada",semanasCotizadas);
			
			modelAndView = new ModelAndView(NavegacionEnum.TRABAJOR_CON_DERECHO_CARGADO_ISSSTE.getNavegacion());
			modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, usuarioLogin);

		} catch (BusinessException e) {
			logger.error("Error", e);
			map.addAttribute("error", e.getMessage());
			modelAndView = new ModelAndView(NavegacionEnum.MENU_AGENTE.getNavegacion());

		}
		return modelAndView;
	}

	/**
	 * Metodo para validar cuando el Datamart No esta cargado
	 * @param map
	 * @param listaParametros
	 */
	private void cargarResoluciones(ModelMap map,List<Parametro> listaParametros, List<Resolucion> tiposDisposicion,HttpServletRequest request) {
		List<Banxico> lista = new ArrayList<>();
		for(Parametro parametro : listaParametros){
			String tipo = parametro.getChValorParametro().substring(0, 1);
			validaTipo(tipo,parametro,lista);
			if(Constants.CONSTANTE_1.equals(tipo)){
				boolean listo = false;
				for(Resolucion resolucion : tiposDisposicion){
					String subTipo = parametro.getChValorParametro().substring(0, 2);
					validaSubTipo(listo,subTipo,parametro,lista,resolucion);
				}
			}
		}
		map.addAttribute("tipoDisposicion",lista);
		request.getSession().setAttribute("tipoDisposicionList",lista);
	}

	
	/**
	 *  Valida SubTipo
	 * @param listo
	 * @param subTipo
	 * @param parametro
	 * @param lista
	 * @param resolucio
	 */
   protected void validaSubTipo(boolean listo, String subTipo, Parametro parametro, List<Banxico> lista,
		   Resolucion resolucion) {
	   if(!listo){
			if(Constants.SUB_TIPO_1B.equals(subTipo)){
				validarClaveTipoRetiro(resolucion,lista,parametro);	
			} else {
				Banxico banxico = new Banxico();
				banxico.setIdDerecho(parametro.getChParametro());
				banxico.setDescripcionDerecho(parametro.getChValorParametro().substring(3));
				  lista.add(banxico);
			}
		}
		
	}

 /**
     * Valida Tipo
     * @param tipo
     * @param parametro
     * @param lista
     */
	protected void validaTipo(String tipo, Parametro parametro, List<Banxico> lista) {
		if(Constants.CONSTANTE_2.equals(tipo) || Constants.CONSTANTE_3.equals(tipo)){
			Banxico banxico = new Banxico();
			banxico.setIdDerecho(parametro.getChParametro());
			banxico.setDescripcionDerecho(parametro.getChValorParametro().substring(2));
			  lista.add(banxico);
		}
		
	}

	/**
	 * Valida clave Tipo Retiro
	 * @param resolucion
	 * @param lista
	 * @param listo
	 * @param parametro
	 */
	protected void validarClaveTipoRetiro(Resolucion resolucion, List<Banxico> lista,Parametro parametro) {
		if(Constants.CLAVE_TIPO_RETIRO_B.equals(resolucion.getIretMatrizDerecho().getClaveTipoRetiro())){
			Banxico banxico = new Banxico();
			banxico.setIdDerecho(parametro.getChParametro());
			banxico.setDescripcionDerecho(parametro.getChValorParametro().substring(3));
			  lista.add(banxico);
		}
	}

	/**
	 *  Metodo para obtener la Solicitud Tramite
	 *  @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param mensaje
	 *  @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value="/private/solicitudTramite.do")
	public ModelAndView solicitudTramite(HttpServletRequest request, ModelMap map, @ModelAttribute String mensaje) {
		
		ModelAndView modelAndView;  
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		List<Banxico>  tipoDspo= (List<Banxico>) request.getSession().getAttribute("tipoDisposicionList");
		obtenerParametrosFechas(request,map);
		
		map.addAttribute(ParametrosConstants.LISTA_DISPOSICION,tipoDspo); 
		map.addAttribute(ParametrosConstants.CATALOGO_TIPO_SEGURO,tipoSeguroService.consultaTipoSeguro());
        map.addAttribute(ParametrosConstants.CATALOGO_TIPO_PENSION,tipoPensionService.consultaTipoPension());
        map.addAttribute(ParametrosConstants.CATALOGO_TIPO_CLAVE_PENSION,clavePensionService.consultaClavePension());
        map.addAttribute(ParametrosConstants.CATALOGO_TIPO_PRESTACION,tipoPrestacionService.consultaTipoPrestacion());
        map.addAttribute(ParametrosConstants.CATALOGO_TIPO_RETIRO,tipoRetiroService.consultaTipoRetiro());
		
		modelAndView = new ModelAndView(NavegacionEnum.DISPOSICION_SOLICITUD_TRAMITE.getNavegacion());
		modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, usuarioLogin);
	
		return modelAndView;

	}
	
	/**
	 * Metodo obtiene las fechas
	 * @param request
	 * @param map
	 */
	protected void obtenerParametrosFechas(HttpServletRequest request,ModelMap map) {
		String fechaInicio     =request.getParameter(ParametrosConstants.FECHA_INICIO);
		String fechaEmisionResolucion =request.getParameter(ParametrosConstants.FECHA_EMISION);
		String semanasCotizadas      =request.getParameter(ParametrosConstants.SEMANAS_COTIZADAS);
		map.addAttribute(ParametrosConstants.FECHA_INICIO_PENSION,fechaInicio);
		map.addAttribute(ParametrosConstants.FECHA_EMISION_RESOLUCION,fechaEmisionResolucion);
		map.addAttribute(ParametrosConstants.FECHA_RESOLUCION,utileriaFecha.convertirFechaACadena(new Date(),FormatoConstants.FORMATO_FECHA_RENAPO));
		map.addAttribute(ParametrosConstants.SEMANAS_COTIZADAS,semanasCotizadas);
		
	}

    /**
     *  Metodo que valida el Datamart
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param request
     *  @param map
     *  @return
     */
	@PostMapping(value="/private/validarDatamart.do",produces = { "application/json"})
	@ResponseBody
	public RespuestaTramite validarDataMart(HttpServletRequest request, ModelMap map) {
		RespuestaTramite respuesta = new RespuestaTramite();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		try {
			Long idProcesar=trabajador.getProcesar();
			DatosDiagnostico datosDiagnostico = new DatosDiagnostico();
			datosDiagnostico.setClaveProceso("401");
			datosDiagnostico.setClaveTipoOperacion("40400");
			datosDiagnostico.setCodigoInternoDiagnostico("DI101");
			diagnosticoService.consultarDiagnostico(datosDiagnostico);
			ResolucionReti cargaResoluciones=consultarResolucionRetiService.consultarResolucionReti(idProcesar, "31000", "301");			     
	    	if(!utileriaValidador.isEmpty(cargaResoluciones)) {
			map.addAttribute(Constants.CARGA_RESOLUCION, cargaResoluciones);
            respuesta.setObRespuesta(cargaResoluciones);
          
			
			}
		 
		}catch (BusinessException e) {
		  logger.error("Error Exception en la Consulta Datamart Derecho Cargado:{}",e);
		 
		}
		return respuesta;
    }
	
	/**
	 * 
	 *  Metodo que valida Procesos para ventanilla Afore Para Cargado
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @return
	 */
	@PostMapping(value="/private/validarMatrizDerechoProceso.do",produces = { "application/json"})
	@ResponseBody
	public RespuestaTramite validaMatrizDerechoProceso(HttpServletRequest request, ModelMap map) {
		RespuestaTramite respuesta = new RespuestaTramite();
		try {
			List<String> listaClaveProceso = new ArrayList<>(); 
			List<MatrizDerechoProceso> listaMatrizDerechoProceso =consultarMatrizDerechoImmsService.consultarMatrizDerechoProceso(Constants.ID_MATRIZ_PROCESO);
			for (MatrizDerechoProceso matrizDerechoProceso : listaMatrizDerechoProceso) {
			    List<String> claves = new ArrayList<>(Arrays.asList(matrizDerechoProceso.getClaveProceso().split(",")));
			    listaClaveProceso = validarDerechoProcesoService.validarMatrizDerecho(claves);
			       
			}
			if(utileriaValidador.validarListaVacia(listaClaveProceso)){
		        	 logger.info("No esta habilitado para Ventanilla Afore");
		       }
			map.addAttribute(Constants.LISTA_CLAVES_PROCESO, listaClaveProceso);
			respuesta.setLstObRespuesta(listaClaveProceso);
			
		 
		}catch (BusinessException e) {
		  logger.error("Error Exception en la validar MatrizDerechoProceso:{}",e);
		 
		}
		return respuesta;
    }
	
	
	/**
     *  Muestra la ventana Modal Consulta de derecho Cargado 
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param request
     *  @param map
     *  @return
     */
	@GetMapping(value = "/private/derechoCargado.do")
	public ModelAndView consultarDerechoCargadoImss(HttpServletRequest request, ModelMap map) {
		ModelAndView modelAndView; 
		List<ProcesoDerechoCargadoEntrada> listaSolicitante= new ArrayList<>();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		DatosCertificables datos = trabajador.getDatosCertificables();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		RespuestaTramite respuesta = new RespuestaTramite();
		generarCus(datos,map,request,user,trabajador);
		consultarDatosGenerales(map,trabajador,user,request);	
				List<ProcesoDerechoCargado> listaDerechoCargado = consultarProcesoDerechoCargadoService.consultarDerechoCargado(trabajador.getProcesar());
		              
		        List<Parametro> listaParametro =catalogoService.obtenerParametroDdbpose(Constants.T00066);
		         if(!utileriaValidador.validarListaVacia(listaParametro) && !utileriaValidador.validarListaVacia(listaDerechoCargado)) {
				        String tipoRegimenSol = new StringBuilder().append(listaDerechoCargado.get(0).getCvTipoRegimen()).append(trabajador.getTipoSolicitante()).toString();
		        	 listaSolicitante = service.setearDerechoCargado(tipoRegimenSol,listaParametro,listaDerechoCargado);
		        	  }
		      
         map.addAttribute(Constants.LISTA_SOLICITANTE, listaSolicitante);
         respuesta.setLstObRespuesta(listaSolicitante);
         request.getSession().setAttribute(Constants.LISTA_SOLICITANTE,listaSolicitante);
      
        respuestaServicio.setFlujo(5);
        modelAndView = new ModelAndView(NavegacionEnum.DISPOSICION_TOTAL_IMSS.getNavegacion());
        modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, user);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuestaServicio);
		
      
		return modelAndView;
		      
}		      
	
	/**
	 *  Metodo que consulta los datos generales del Trabajador
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param map
	 *  @param trabajador
	 *  @param user
	 */
	protected void consultarDatosGenerales(ModelMap map,DatosTrabajador trabajador,UsuarioLogin user,HttpServletRequest request) {
         
		Date fechaActual = new Date();
		String fechaSolicitud= convierteFechaService.convertirFechaACadena(fechaActual, FormatoConstants.FORMATO_FECHA_RENAPO);
		map.addAttribute(Constants.FECHA_SOLICITUD, fechaSolicitud);   
		Date fechaNacimiento = convierteFechaService.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(), FormatoConstants.FORMATO_FECHA_NACIMIENTO);
		map.addAttribute(Constants.FECHA_NACIMIENTO, convierteFechaService.convertirFechaACadena(fechaNacimiento, ActivacionConstants.DDMMYYYY));
		Integer edadTrabajdor = obtenerEdadService.obtenerEdadTrabajador(trabajador.getDatosCertificables().getFechaNacimiento());
		map.addAttribute(Constants.EDAD_TRABAJADOR, edadTrabajdor);
		map.addAttribute(Constants.NOMBRE_TRABAJDOR, trabajador.getDatosCertificables().getNombre());
		map.addAttribute(Constants.APELLIDO_PATERNO, trabajador.getDatosCertificables().getApellidoPaterno());
		map.addAttribute(Constants.APELLIDO_MATERNO, trabajador.getDatosCertificables().getApellidoMaterno());
		List<Afore> listaAseguradoras = catalogoService.obtenerAfores();
		Long idAfore = null;
		if(!utileriaValidador.validarListaVacia(listaAseguradoras) ) {
			
			  for (Afore afore : listaAseguradoras) {
				   if(afore.getClaveAfore().equals(trabajador.getClaveAfore())) {
					   idAfore = afore.getId(); 
				   break;
				   }
			}
		  map.addAttribute(Constants.LISTA_ASEGURADORAS, listaAseguradoras);	
		}
		
		List<Siefore> listaSiefores = obtenerEdadService.obtenerSiefores(idAfore);
		map.addAttribute(Constants.LISTA_SIEFORES, listaSiefores);	
		request.getSession().setAttribute(Constants.LISTA_SIEFORES, listaSiefores);
		  
		List<Actuario> listaActuarios = catalogoService.obtenerActuarios();
		if(!utileriaValidador.validarListaVacia(listaActuarios) ) {
		   map.addAttribute(Constants.LISTA_ACTUARIOS, listaActuarios);
		}
		map.addAttribute(Constants.NOMBRE_TRABAJDOR, trabajador.getDatosCertificables().getNombre());
		map.addAttribute(Constants.APELLIDO_PATERNO, trabajador.getDatosCertificables().getApellidoPaterno());
		map.addAttribute(Constants.APELLIDO_MATERNO, trabajador.getDatosCertificables().getApellidoMaterno());
		List<BiomTipoSolicitante> tipoSolicitante  = catalogoService.obtenerTipoSolicitante(trabajador.getTipoSolicitante());
		for (BiomTipoSolicitante biomTipoSolicitante : tipoSolicitante) {
			map.addAttribute(Constants.CLAVE_TIPO_SOLICITANTE, biomTipoSolicitante.getCvTipoSolicitante());
			map.addAttribute(Constants.DESCRIPCION_SOLICITANTE, biomTipoSolicitante.getChTipoSolicitante());
		}
		String curpAgenteServicio=null;
		if("01".equals(trabajador.getTipoSolicitante())) {
			curpAgenteServicio =user.getCurpAgente();
		  map.addAttribute(Constants.CURP_AGENTE_SERVICIO,curpAgenteServicio);
		}else {
		  map.addAttribute(" ",curpAgenteServicio);	
		}
		
	}

	

	/**
	 *  consulta Derecho No Cargado
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
     *  @param mensaje
	 *  @return
	 */
	@PostMapping(value="/private/derechoNoCargado.do",produces = { "application/json"})
	@ResponseBody
 public RespuestaTramite consultarDerechoNoCargadoImss(HttpServletRequest request, ModelMap map) {
		RespuestaTramite respuesta = new RespuestaTramite();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Long idProcesar = trabajador.getProcesar();
	    String fechaNacimiento=	trabajador.getDatosCertificables().getFechaNacimiento();		
		List<DatosIcefaTrabajador> icefasTrabajador =consultarIcefaTrabajadorService.obtenerIcefasTrabajadorSaldoSares(idProcesar, fechaNacimiento);
		for(DatosIcefaTrabajador icefa : icefasTrabajador){
			logger.info("pruebaIcefa: {}",icefa);
		}
		if(!icefasTrabajador.isEmpty()) {
			map.addAttribute(Constants.LISTA_ICEFAS_TRABAJADOR,icefasTrabajador );
		    respuesta.setLstObIcefas(icefasTrabajador);
		}
	    
	    List<Parametro> listaDerechoNoCargado = catalogoService.obtenerParametroDdbpose(Constants.T00063);
		if(!utileriaValidador.validarListaVacia(listaDerechoNoCargado)  ) {
			respuesta.setLstObRespuesta(listaDerechoNoCargado);
						
			map.addAttribute(Constants.LISTA_DERECHO_NO_CARGADO, respuesta.getLstObRespuesta());
		    respuesta.setLstObRespuesta(respuesta.getLstObRespuesta());
		}
		
	    return respuesta;
	}
		
	/**
	 *  Se envia cvTipoRegimen para obtener el combo de TipoRetiro
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param claveRegimen
	 *  @return
	 */
	@PostMapping(value="/private/derechoNoCargadoClave.do",produces = { "application/json"})
	@ResponseBody
 public RespuestaTramite consultarDerechoNoCargadoClaveImss(HttpServletRequest request, ModelMap map,@RequestParam(value="cvRegimen",required=false) String cvRegimen ) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		RespuestaTramite respuesta = new RespuestaTramite();
		ProcesoDerechoNoCargado entradaDatos =  new ProcesoDerechoNoCargado();
		
		if(Constants.TIPO_REGIMEN_73.equals(cvRegimen)) {
			entradaDatos.setCvTipoRegimen(cvRegimen);		
		    	List<ProcesoDerechoCargadoSalida> listaDerechoNoCargado = consultarProcesoDerechoNoCargadoService.consultarDerechoNoCargado(entradaDatos);
		        String tipoRegimenSol = new StringBuilder().append(cvRegimen).append(trabajador.getTipoSolicitante()).toString();
		      	List<Parametro> listaParametro =catalogoService.obtenerParametroDdbpose(Constants.T00066);
				if(!utileriaValidador.validarObjetoNulo(listaParametro) && !utileriaValidador.validarObjetoNulo(listaDerechoNoCargado)) {
					for (ProcesoDerechoCargadoSalida procesoDerechoCargadoSalida : listaDerechoNoCargado) {
						HashMap <String,String> mapa= obtenerListaParametro(listaParametro,tipoRegimenSol,map,procesoDerechoCargadoSalida);
					respuesta.setMapString(mapa); 
				  }
			   }
		}
	   return respuesta;
	}
	
	/**
	 *  Metodo que obtiene lista de paprametos 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param listaParametro
	 *  @param tipoRegimenSol
	 *  @param map
	 *  @param procesoDerechoCargadoSalida
	 *  @return
	 */
	protected  HashMap <String,String> obtenerListaParametro(List<Parametro> listaParametro, String tipoRegimenSol, ModelMap map, ProcesoDerechoCargadoSalida procesoDerechoCargadoSalida) {
		 HashMap <String,String> mapa = new HashMap<>();
		for (Parametro parametro : listaParametro) {
			  if(tipoRegimenSol.equals(parametro.getChParametro())) {
		    	  List<String> listaRetiros = new ArrayList<>(Arrays.asList(parametro.getChValorParametro().split(",")));
		       	    if(listaRetiros.contains(procesoDerechoCargadoSalida.getClave())) {
		    		      mapa.put(procesoDerechoCargadoSalida.getClave(), procesoDerechoCargadoSalida.getDescripcion());
		    		      map.addAttribute("map",mapa);
		          	 }
		      }
			  
		}
		return mapa;
	}

	/**
	 *  Metodo Consulta Dereno No cargadp 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param cvRegimen
	 *  @return
	 */
	@PostMapping(value="/private/derechoNoCargadoClave97.do",produces = { "application/json"})
	@ResponseBody
 public RespuestaTramite consultarDerechoNoCargadoClaveImss97(HttpServletRequest request, ModelMap map,@RequestParam(value="cvRegimen",required=false) String cvRegimen ) {
		RespuestaTramite respuesta = new RespuestaTramite();
		ProcesoDerechoNoCargado entradaDatos =  new ProcesoDerechoNoCargado();
			entradaDatos.setCvTipoRegimen(cvRegimen);
			List<ProcesoDerechoCargadoSalida> listaDerechoNoCargado = consultarProcesoDerechoNoCargadoService.consultarDerechoNoCargado(entradaDatos);
	        if(!utileriaValidador.validarObjetoNulo(listaDerechoNoCargado)) {
	          map.addAttribute(Constants.LISTA_DERECHO_NO_CARGADO, listaDerechoNoCargado);
	          respuesta.setLstObRespuesta(listaDerechoNoCargado);
	     }
		
	   return respuesta;
	}
	

	/**
	 *   Consulta combo TipoRetiro
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param clave
	 *  @return
	 */
	@PostMapping(value="/private/derechoNoCargadoRetiro.do",produces = { "application/json"})
	@ResponseBody
	public RespuestaTramite consultarDerechoNoCargadoRetiroImss(HttpServletRequest request, ModelMap map,@RequestBody ProcesoDerechoCargadoEntrada data) {	
	logger.info("CONTROLLER TIPO RETIRO");
		RespuestaTramite respuesta = new RespuestaTramite();
		ProcesoDerechoNoCargado entradaDatos =  new ProcesoDerechoNoCargado();
		
		entradaDatos.setAgregarAuxTipoRegimen(data.getCvTipoRegimen());
		entradaDatos.setCvTipoRetiro(data.getCvTipoRetiro());
		List<ProcesoDerechoCargadoSalida> listaDerechoNoCargado = consultarProcesoDerechoNoCargadoService.consultarDerechoNoCargado(entradaDatos);
	      if(!utileriaValidador.validarObjetoNulo(listaDerechoNoCargado)) {
	            map.addAttribute(Constants.LISTA_DERECHO_NO_CARGADO, listaDerechoNoCargado);
	            respuesta.setLstObRespuesta(listaDerechoNoCargado);
	         }  
       return respuesta;

	}
	
	
	/**
	 *  Consulta combo Tipo Seguro
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param cvSeguro
	 *  @return
	 */
	@PostMapping(value="/private/derechoNoCargadoSeguro.do",produces = { "application/json"})
	@ResponseBody
 public RespuestaTramite consultarDerechoNoCargadoSeguroImss(HttpServletRequest request, ModelMap map,@RequestBody ProcesoDerechoCargadoEntrada data) {
		logger.info("CONTROLLER TIPO SEGURO");
		RespuestaTramite respuesta = new RespuestaTramite();
		ProcesoDerechoNoCargado entradaDatos =  new ProcesoDerechoNoCargado();
		entradaDatos.setAgregarAuxTipoRegimen(data.getCvTipoRegimen());
		entradaDatos.setAgregarAuxTipoRetiro(data.getCvTipoRetiro());
		entradaDatos.setCvTipoSeguro(data.getCvTipoSeguro());
		List<ProcesoDerechoCargadoSalida> listaDerechoNoCargado = consultarProcesoDerechoNoCargadoService.consultarDerechoNoCargado(entradaDatos);
	        if(!utileriaValidador.validarObjetoNulo(listaDerechoNoCargado)) {
	            map.addAttribute(Constants.LISTA_DERECHO_NO_CARGADO, listaDerechoNoCargado);
	            respuesta.setLstObRespuesta(listaDerechoNoCargado);
	       }  
       	return respuesta;

	}
	
	
	
	/**
	 *  Consulta combo Tipo Pension 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param clave
	 *  @return
	 */
	@PostMapping(value="/private/derechoNoCargadoPension.do",produces = { "application/json"})
	@ResponseBody
 	public RespuestaTramite consultarDerechoNoCargadoPensionImss(HttpServletRequest request, ModelMap map,@RequestBody ProcesoDerechoCargadoEntrada data) {
		logger.info("CONTROLLER TIPO PENSION");
		RespuestaTramite respuesta = new RespuestaTramite();
		ProcesoDerechoNoCargado entradaDatos =  new ProcesoDerechoNoCargado();
		entradaDatos.setAgregarAuxTipoRegimen(data.getCvTipoRegimen());
		entradaDatos.setAgregarAuxTipoRetiro(data.getCvTipoRetiro());
		entradaDatos.setAgregarAuxTipoSeguro(data.getCvTipoSeguro());
		entradaDatos.setCvTipoPension(data.getCvTipoPension());
		List<ProcesoDerechoCargadoSalida> listaDerechoNoCargado = consultarProcesoDerechoNoCargadoService.consultarDerechoNoCargado(entradaDatos);
	        if(!utileriaValidador.validarObjetoNulo(listaDerechoNoCargado)) {
	            map.addAttribute(Constants.LISTA_DERECHO_NO_CARGADO, listaDerechoNoCargado);
	            respuesta.setLstObRespuesta(listaDerechoNoCargado);
	    }
	       
	        
	        
	  	return respuesta;

	}
    
	/**
	 *   Metodo que consulta por NRP
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param nrp
	 *  @return
	 */
	@PostMapping(value="/private/recaudadoraNrp.do",produces = { "application/json"})
	@ResponseBody
	public RespuestaTramite recaudadoraNrp(HttpServletRequest request, ModelMap map,@RequestParam(value="nrp",required=false) String nrp,@RequestParam(value="numeroPlan",required=false) String numeroPlan) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		
		RespuestaTramite respuesta = new RespuestaTramite();
		RecaudadoraTV consultaNRP = new RecaudadoraTV();
		try {
		 consultaNRP = obtenerRecaudadoraPorNrpService.obtenerRecaudadoraPorNrp(nrp);//C5337226109
		   RetiroPlanPrivado73 consultaPorNss = obtenerPlanPrivadoPorNssService.obtenerPlanPrivadoPorNss(trabajador.getNss()); 
		if( !utileriaValidador.validarObjetoNulo(consultaNRP) && !utileriaValidador.validarObjetoNulo(consultaPorNss) ) { 
        	map.addAttribute("consultaNRP", consultaNRP);
            respuesta.setObRespuesta(consultaNRP);
                      
            map.addAttribute(ActivacionConstants.CONSULTA_POR_NSS, consultaPorNss);
            respuesta.setObRespuesta(consultaPorNss);
        }
		 
		}catch (BusinessException e) {
		  logger.error("Error Exception en la consulta Recaudadora :{}",e);
		 
		}
		return respuesta;
    }
	
	/**
	 *  Metodo  que reidrecciona para mostrar el Modal para captura del nrp
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param data
	 *  @return
	 */
	@GetMapping(value = "/private/validarNrpPlanActuario.do")
	public ModelAndView validarConsultaNrpPlanActuario(HttpServletRequest request, ModelMap map,@ModelAttribute("datra") ProcesoDerechoCargadoEntrada data){
		ModelAndView modelAndView = null; 
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try{
		modelAndView = new ModelAndView(NavegacionEnum.DISPOSICION_TOTAL_IMSS.getNavegacion());
        modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, user);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuestaServicio);
		}catch (Exception ge) {
	    	  logger.error("Error al Consultar Plan Actuario:{}",ge);
	      }	
		
		return modelAndView; 
	}
	
	/**
	 *  Metodo que muestra error del modal,cuando de valida el nss,nrp y numero plan 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param data
	 *  @return
	 */
	@GetMapping(value = "/private/mostrarResultadoModal.do")
	public ModelAndView mostrarResultadoModal(HttpServletRequest request, ModelMap map,@ModelAttribute("datra") ProcesoDerechoCargadoEntrada data){
		ModelAndView modelAndView = null; 
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try{
		
			respuestaServicio.setTitulo("");
			respuestaServicio.setFlujo(3);
		    respuestaServicio.setMensaje("No existe relación laboral");	
		
		modelAndView = new ModelAndView(NavegacionEnum.DISPOSICION_TOTAL_IMSS.getNavegacion());
        modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, user);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuestaServicio);
		
		 
		}catch (Exception ge) {
	    	  logger.error("Error al Consultar Mostrar Modal:{}",ge);
	      }	
		return modelAndView; 
	}
	
	
	/**
	 *  Metodo Obtiene Subcuentas Matriz 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param regimen
	 *  @param retiro
	 *  @param seguro
	 *  @param pension
	 *  @param prestacion
	 *  @return
	 */
	@PostMapping(value = "/private/subCuentasMatriz.do",produces = { "application/json"})
	@ResponseBody
	public RespuestaTramite obtenerSubCuentasMatriz(HttpServletRequest request, ModelMap map,@RequestBody ProcesoDerechoCargadoEntrada data)  {
		RespuestaTramite respuesta = new RespuestaTramite();                              
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
     try {
    	 
     	 
			Long idProcesar = trabajador.getProcesar();
			Marca marcasVivienda = subCuentastaService.consultarMarcasViviendaImss(idProcesar);
			respuesta.setObRespuesta(marcasVivienda);
			map.addAttribute(ActivacionConstants.MARCAS_VIVIENDA, marcasVivienda);
			MatrizDerecho matrizDerecho = consultarMatrizDerechoImmsService.consultarMatrizDerecho(
					data.getCvTipoRegimen(), data.getCvTipoRetiro(), data.getCvTipoSeguro(), data.getCvTipoPension(),
					data.getCvTipoPrestacion());
			List<DerechoSubcuenta> listaSubCuentas = subCuentastaService
					.obtenerDerechoSubcuentaPorIdMatrizDerecho(matrizDerecho.getId());
			listaSubCuentas = service.obtenerAgruparSuBcuentas(listaSubCuentas);
			if (trabajador.getSaldos() != null) {
				trabajador.getSaldos().setSaldoVivienda72("0.00");
				List<DatosCalculosMontos> listaRcv = subCuentastaService.obtenerSubCuentasSaldosImssRcv(listaSubCuentas,
						trabajador.getSaldos());
				if (!utileriaValidador.validarListaVacia(listaRcv)) {
					respuesta.setLstObRespuesta(listaRcv);
					map.addAttribute(ActivacionConstants.LISTA_SUBCUENTAS, listaRcv);
					logger.info("Final listaRcv:{}", respuesta.getLstObRespuesta());
					request.getSession().setAttribute(ActivacionConstants.LISTA_SUBCUENTAS, listaRcv);
				}
				List<DatosCalculosMontos> listaViendaImss = subCuentastaService
						.obtenerSubCuentasSaldosImssViv(listaSubCuentas, trabajador.getSaldos());
				if (!utileriaValidador.validarListaVacia(listaViendaImss)) {
					logger.info("listaViendaImss:{}", listaViendaImss);
					respuesta.setLstObRespuestaDos(listaViendaImss);
					respuesta.setMensaje(listaViendaImss.get(0).getMontoTotalSuma());
					request.getSession().setAttribute(ActivacionConstants.LISTA_SUBCUENTAS_VIVIENDA, listaViendaImss);

				}
			}
    	   	          
        }catch (BusinessException ge) {
    	  logger.error("Error en la consulta de las SubCuentas Matriz:{}",ge);
      }	
     return respuesta;
   }
	
	/**
	 *  Metodo que obtiene la sesion del trabajador y formulario 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param data
	 *  @return
	 */
	@PostMapping(value = "/private/obtenerDatosSessionNoCargado.do",produces = { "application/json"})
	@ResponseBody
	public RespuestaTramite obtenerDatosSession(HttpServletRequest request, ModelMap map,@RequestBody ProcesoDerechoCargadoEntrada data)  {
		RespuestaTramite respuesta = new RespuestaTramite();
     try {
    	  respuesta = obterDatosSolicitudDisposicionTotalImss(request,data);
    	  request.getSession().setAttribute(ActivacionConstants.FORMULARIO_NO_CARGADO, respuesta);
         
        }catch (BusinessException ge) {
    	  logger.error("Error en la consulta de las SubCuentas Matriz:{}",ge);
      }	
     return respuesta;
   }

	
	
	/**
	 *  Redirecciona pagina  
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/private/generarExpedienteImss.do")
	public String enviarDatosExpediente(HttpServletRequest request, ModelMap map,
			@ModelAttribute("datra") ProcesoDerechoCargadoEntrada data) {
		RespuestaTramite disposicionTotal = new RespuestaTramite();
		try {

			disposicionTotal = (RespuestaTramite) request.getSession()
					.getAttribute(ActivacionConstants.FORMULARIO_NO_CARGADO);
			request.getSession().setAttribute(ParametrosConstants.ORIGEN, Constants.TOTAL_IMSS);
			List<Siefore> listaSiefores = (List<Siefore>) request.getSession().getAttribute("listaSiefores");
			disposicionTotal.getProcesoNocargado().setSieforesLista(listaSiefores);
			request.getSession().setAttribute(ActivacionConstants.FORMULARIO_NO_CARGADO, disposicionTotal);
			request.getSession().setAttribute("tipoDocumento", "39");

			List<Parametro> adicionales = catalogoService.obtenerParametroDdbpose(Constants.P00021);
			if (!utileriaValidador.isEmpty(adicionales)
					&& !utileriaValidador.isEmpty(adicionales.get(0).getChValorParametro())) {
				String[] adicional = adicionales.get(0).getChValorParametro().split("\\|");
				request.getSession().setAttribute(ParametrosConstants.DOC_ADICIONAL, adicional);
			}

			DatosDocumentoPdf datosPdf = new DatosDocumentoPdf();
			datosPdf.setDatos(disposicionTotal);
			datosPdf.setUrlPaginaSiguiente(NavegacionEnum.SOLICITUD_DISPOSICION_PARCIAL_SALIDA.getNavegacion());
			datosPdf.setMetodoPaginaSiguiente(HttpMethod.POST.toString());
			request.getSession().setAttribute(ParametrosConstants.DATOS_PDF, datosPdf);

			request.getSession().setAttribute("destino", "/private/consultarDisposicionesImss.do");
			logger.info("entro a ventana general id Pdf: {}", datosPdf);
		} catch (Exception ge) {
			logger.error("Error al Enviar datos Expediente:{}", ge);
		}
	       DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
	        UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
	       FolioEntrada folioGenera = new FolioEntrada();
			folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
			folioGenera.setIdUsuario(user.getDatoUsuario());
			folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
			folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_IIMSS_S15);
			folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES15P3);
			folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
			folioGenera.setNss(trabajador.getNss());
			folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
			folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
			folioGenera.setOrigen(ActivacionConstants.ORIGEN);
			folioGenera = folioService.generarFolio(folioGenera);
			request.getSession().setAttribute("folioEntrada", folioGenera);

		return new StringBuilder().append("redirect:")
				.append(NavegacionEnum.FORWARD_PDF_DISPOSICION_TOTAL_IMSS.getNavegacion()).toString();
	}
 
	/**
	 *  Metodo que setea los datos de sesion del trabajador y el Formaulario NoCargado
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param entrada
	 *  @return
	 */
	private RespuestaTramite obterDatosSolicitudDisposicionTotalImss(HttpServletRequest request,ProcesoDerechoCargadoEntrada entrada) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RespuestaTramite solicitudTotal = new RespuestaTramite();
		
		solicitudTotal.setProcesoNocargado(entrada);
		
		if (trabajador.getDatosCertificables() != null) {
			solicitudTotal.setNombre(trabajador.getDatosCertificables().getNombre());
			solicitudTotal.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
			solicitudTotal.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
			solicitudTotal.setFechaNacimiento(trabajador.getDatosCertificables().getFechaNacimiento());
			solicitudTotal.setGenero(trabajador.getDatosCertificables().getClaveGenero());
			solicitudTotal.setCurp(trabajador.getDatosCertificables().getCurp());
		}
		
		if (trabajador.getDatosNoCertificables() != null) {
			solicitudTotal.setRfc(trabajador.getDatosNoCertificables().getRfc());
		}
		solicitudTotal.setFechaSolicitud(convierteFechaService.convertirFechaACadena(new Date(), DDMMYYYY));
		solicitudTotal.setNumeroFolio(request.getParameter("folio1"));
		solicitudTotal.setNumeroUnidad("");
		solicitudTotal.setNss(trabajador.getNss());
		
		if (trabajador.getDatosComplementarios() != null) {
			if (trabajador.getDatosComplementarios().getTelefonos() != null) {
				solicitudTotal.setTelefono(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
				solicitudTotal.setCelular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
			}

			solicitudTotal.setEmail(trabajador.getDatosComplementarios().getCorreoElectronico());

			if (trabajador.getDatosComplementarios().getParticular() != null) {
				solicitudTotal.setCalle(trabajador.getDatosComplementarios().getParticular().getCalle());
				solicitudTotal.setNumeroExterior(trabajador.getDatosComplementarios().getParticular().getNoExterior());
				solicitudTotal.setNumeroInterior(trabajador.getDatosComplementarios().getParticular().getNoInterior());
				solicitudTotal.setCodigoPostal(trabajador.getDatosComplementarios().getParticular().getCodigoPostal());
				solicitudTotal.setPais(trabajador.getDatosComplementarios().getParticular().getPais());
				solicitudTotal.setColonia(trabajador.getDatosComplementarios().getParticular().getColonia());
				solicitudTotal.setEntidadFederativa(
						trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
				solicitudTotal.setDelegacionMunicipio(trabajador.getDatosComplementarios().getParticular().getMunicipio());
				solicitudTotal.setPoblacion(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
			}
		}

		solicitudTotal.setCompaniaCelular("");
		solicitudTotal.setNombreAsesor(user.getNombre());
		solicitudTotal.setCurpAsesor(user.getCurpAgente());
	
	return solicitudTotal;
		
	}
	
	
	@PostMapping(value="/private/consultarPlanPrivadoImss.do",produces = { "application/json"})
	@ResponseBody
 public RespuestaTramite consultarPlanPrivadoImss(HttpServletRequest request, ModelMap map,@RequestBody ProcesoDerechoCargadoEntrada data) {
		logger.info("CONTROLLER PLAN PRIVADO PENSION");
		RespuestaTramite respuesta = new RespuestaTramite();
		ProcesoDerechoNoCargado entradaDatos =  new ProcesoDerechoNoCargado();
				
		entradaDatos.setAgregarAuxTipoRegimen(data.getCvTipoRegimen());
		entradaDatos.setAgregarAuxTipoRetiro(data.getCvTipoRetiro());
		entradaDatos.setAgregarAuxTipoSeguro(data.getCvTipoSeguro());
        
		entradaDatos.setAgregarAuxTipoPension(data.getCvTipoPension());
		entradaDatos.setAgregarAuxTipoPrestacion(data.getCvTipoPrestacion());
		
		
		entradaDatos.setDiagnostico("101");
		entradaDatos.setClaveProceso("301");
		entradaDatos.setClaveTipoPrestacion("05");
		entradaDatos.setClaveTipoEntidad("");
		entradaDatos.setRjp("1");
		
		SalidaGenerica  salida = derechoAceptadoService.consultarDerechoAceptado(entradaDatos);
        if(!utileriaValidador.validarObjetoNulo(salida)) {
	            map.addAttribute("derechoAceptado", salida);
	            respuesta.setObRespuesta(salida);
	       }  
	      
 		return respuesta;

	}
	
	/**
	 *  Relacion de SubCuentas para obtener precion accion  
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param claveSiefore
	 *  @return
	 */
	@RequestMapping(value = { "/private/obtenerPrecioAccionSiefore.do" }, method = {RequestMethod.GET}, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite obtenerPrecioAccionSiefore(HttpServletRequest request, @RequestParam(value = "claveSiefore") String claveSiefore) {
		logger.info("Controller obtenerPrecioAccionSiefore");
		RespuestaTramite respuesta = new RespuestaTramite();

		try {
			List<PrecioAccion> listaPrecio  = obtenerEdadService.obtenerPrecioAccion(claveSiefore, "2");
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			if(!utileriaValidador.validarListaVacia(listaPrecio)) {
					respuesta.setObRespuesta(listaPrecio.get(0));
					respuesta.setTitulo(convierteFechaService.convertirFechaACadena(listaPrecio.get(0).getFechaValorTitulo(), ActivacionConstants.DDMMYYYY));
				}else{
					respuesta.setMensaje(ActivacionConstants.SIN_PRECIO_ACCION);
				}
		
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarPrecioAccionSiefore: Se presento un problema al consultar la informacion de precio accion", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		 }
		return respuesta;
	}
	
	/**
	 *No cargado issste
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarCancelacionImss.do" }, method = {RequestMethod.GET}, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarCancelacionImss(HttpServletRequest request) {
		logger.info("Inicio de consultar consultarCancelacion");
		RespuestaTramite respuesta = new RespuestaTramite();
		DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
		try {
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			List<ParametroEntrada> datosCan = (List<ParametroEntrada>) request.getSession().getAttribute("datosCancelacionImss");
			
			entradaParams.setCurp(trabajador.getDatosCertificables().getCurp());
			entradaParams.setNss(datosCan.get(0).getNss());
			entradaParams.setSecuenciaPension(datosCan.get(0).getSecuenciaPension());
			entradaParams.setFolioSol(datosCan.get(0).getTramiteProcesar());
			entradaParams.setAforeTrabajador(trabajador.getClaveAfore());
			CancelacionSalida cancelacionSalida = service.consultarCancelacion(entradaParams);
			respuesta.setMensaje(cancelacionSalida.getResultadoOperacion());
			respuesta.setTitulo(cancelacionSalida.getDescripcionDiagnostico());
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarCancelacion: Se presento un problema al consultar la informacion de cancelacion", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		 }
		return respuesta;
	}
	
	/**
	 *  Redirecciona al Modal de Beneficiario 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param request
	 *  @param map
	 *  @param data
	 *  @return
	 */
	@RequestMapping(value = { "/private/validarBeneficiarios.do" }, method = {RequestMethod.GET}, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite validarBeneficiarios(HttpServletRequest request){
		RespuestaTramite respuesta = new RespuestaTramite();
		try{
		List<Parametro> listaBancos = catalogoService.obtenerParametroDdbpose(Constants.T00003);
		List<Parametro> listaBancosNuevas = new ArrayList<>();
		for(Parametro obj: listaBancos){
			if(Constants.CLABES_BANCO_ISSSTE.contains(obj.getChParametro())){
				listaBancosNuevas.add(obj);
			}
		}
		respuesta.setLstObRespuesta(listaBancosNuevas);
	
		}catch (Exception ge) {
	    	  logger.error("Error al Consultar:{}",ge);
	      }	
		
		return respuesta; 
	}
	
	
	/**
	 *No cargado issste
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultarDisposicionesImss.do", method = { RequestMethod.GET,
				RequestMethod.POST })
	public ModelAndView consultarDisposiciones(HttpServletRequest request, ModelMap map) {
		logger.info("Inicio de consultar disposiciones");
		
		RespuestaTramite disposicionTotal   = (RespuestaTramite) request.getSession().getAttribute(ActivacionConstants.FORMULARIO_NO_CARGADO);	
    	RespuestaTramite respuesta = new RespuestaTramite();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		ModelAndView model = new ModelAndView(NavegacionEnum.DISPOSICION_RESP_IMSS.getNavegacion());
		FolioEntrada folio = (FolioEntrada) request.getSession().getAttribute("folioEntrada");
		try {
			
			String respuestaExpe = disposicionTotalIsssteService.validarExpedienteServicio(folio.getFolioHijo(), trabajador, user);
			if (!ActivacionConstants.RESULTADO_OPERACION_01.equals(respuestaExpe)) {
					folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), 2);
					respuestaExpe = "El expediente no se ha generado";
					map.addAttribute(ActivacionConstants.RESULTADO_OPERACION_ISSSTE, ActivacionConstants.RESULTADO_OPERACION_02);
					map.addAttribute(ActivacionConstants.DESCRIPCION_ISSSTE, respuestaExpe);
			} else {
				folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
				FolioEntrada folioGenera = new FolioEntrada();
				folioGenera.setIdUsuario(user.getDatoUsuario());
				folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
				folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_IIMSS_S15);
				folioGenera.setProceso(ActivacionConstants.SERVICIO_S15P4);
				folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
				folioGenera.setNss(trabajador.getNss());
				folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
				folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
				folioGenera.setOrigen(ActivacionConstants.ORIGEN);
				folioGenera = folioService.generarFolio(folioGenera);
				request.getSession().setAttribute("folioEntrada", folioGenera);
				request.getSession().setAttribute(ActivacionConstants.DATOS_GENERALES_ISSSTE, disposicionTotal);
				trabajador.setFolio(folioGenera);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
				
				disposicionTotal.getProcesoNocargado().setSelloUnico(trabajador.getSello().getId().toString());
				disposicionTotal.getProcesoNocargado().setIdSolcitante(trabajador.getTipoSolicitante());
				disposicionTotal.getProcesoNocargado().setCurpAgenteServicio(user.getCurpAgente());
				SalidaDisposicionTotalImss salidaDisposicionTotalImss = service.consultarImssDisposicionTotal(disposicionTotal.getProcesoNocargado(), trabajador);
				request.getSession().setAttribute("resultadoDisposicionImss", salidaDisposicionTotalImss);
				validarRespuestaServicio(trabajador, salidaDisposicionTotalImss);
				map.addAttribute(ActivacionConstants.RESULTADO_OPERACION_ISSSTE, salidaDisposicionTotalImss.getResultadoOperacion());
				map.addAttribute(ActivacionConstants.DESCRIPCION_ISSSTE, salidaDisposicionTotalImss.getDiagnosticoSolicitud());
			 
			}
			disposicionTotal.getProcesoNocargado().setCurp(trabajador.getDatosCertificables().getCurp());
			String montoRcv = disposicionTotal.getProcesoNocargado().getMontoTotalRcv();
			String montoViv = disposicionTotal.getProcesoNocargado().getMontoTotalViv();
			montoRcv = montoRcv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
			montoViv = montoViv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
			Double sumaLiq = Double.valueOf(montoRcv)+Double.valueOf(montoViv);
			StringBuilder bui = new StringBuilder();
			String sum = bui.append(ExpresionesConstants.SIGNO_PESOS).append(sumaLiq).toString();
			
			map.addAttribute("datosForm", disposicionTotal.getProcesoNocargado());
			map.addAttribute("montoDisponer", sum);
				
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarDisposiciones: Se presento un problema al consultar la informacion de cargado issste", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder al consultar la informacion ", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		 }
		return model;
	}
	
	
	/**
	 * Validar resultado servicio 46
	 * @param trabajador
	 * @param salidaRegimenOrdinarioIssste
	 */
	private void validarRespuestaServicio(DatosTrabajador trabajador,
			SalidaDisposicionTotalImss salidaDisposicionTotalImss) {
		if (ActivacionConstants.RESULTADO_OPERACION_01.equals(salidaDisposicionTotalImss.getResultadoOperacion())) {
			folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), 3);
		}else{
			folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), 2);
		}
	}

	
}	