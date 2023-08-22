package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants.AFORE_COPPEL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants.ATRIBUTO_CALCULO_TIPO_RETIRO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.BOTON_CERTIFICADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.BOTON_CUS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.DOC_ADICIONAL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.DATOS_CERTIFICACION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_MATRIMONIO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_UNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.CLAVE_DERECHO_PAGO_CALCULO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.TIPO_RETIRO_A_VALOR;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MatrimonioLineaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetiroParcialCalculoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoRetiroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidaResolucionParcialService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseSalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialMatrimonio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrimonioLinea;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Mensualidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Peticion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Controller
public class AyudaMatrimonioImssController extends BaseController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(AyudaMatrimonioImssController.class);
	

	/**
	 * selloService
	 */
	@Autowired
	private ConsultaSelloService selloService;

	/**
	 * Inyeccion dependencia CusService
	 */
	@Autowired
	private CusService cusService;

	/**
	 * Inyeccion disposicionService
	 */
	@Autowired
	private DisposicionTotalImssService disposicionService;

	/**
	 * Atributo matrimonioLineaService
	 */
	@Autowired
	private MatrimonioLineaService matrimonioLineaService;

	/**
	 * Atributo consultarMatrizDerechoService
	 */
	@Autowired
	private ConsultarMatrizDerechoService consultarMatrizDerechoService;

	/**
	 * Atributo validaResolucionParcialService
	 */
	@Autowired
	private ValidaResolucionParcialService validaResolucionParcialService;
	
	/**
	 * Atributo catalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;
	
	/**
	 * tipoRetiroService
	 */
	@Autowired
	private TipoRetiroService tipoRetiroService;
	/**
	 * Inyeccion dependencia folioService
	 */
	@Autowired
	private FolioService folioService;
	
	/**
	 * Inyeccion dependencia ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion dependencia RechazoService
	 */
	@Autowired
	private RechazoService rechazoService;
	
	/**
	 * inyeccion dependencia NotificacionService
	 */
	@Autowired
	private NotificacionService notificacionService;
	
	/**
	 * servicio de RetiroParcialCalculo
	 */
	@Autowired
	private RetiroParcialCalculoService retiroParcialCalculoService;
	/**
	 * solicitud12Service
	 */
	@Autowired
	private SolicitudDisposicionService solicitud12Service;
	
	 /**
   * inyeccion procesoPendienteService
   */
	@Autowired
	private ProcesoPendienteService procesoPendienteService;
	
	
	/**
	 * muestra la pantalla de ayuda por desempleo
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@GetMapping(value = "/private/ayudaMatrimonio.do")
	public ModelAndView ayudaMatrimonio(HttpServletRequest request, ModelMap map, @ModelAttribute String mensaje, @ModelAttribute RetiroDesempleoImss<Peticion> retiroMatrimonioImss) {
		ConsultaCusSalida cusSalida;
		ModelAndView mav = new ModelAndView(NavegacionEnum.MATRIMONIO_CUS.getNavegacion());
		try {

			String pasoUnoRetiros = (String) request.getSession().getAttribute(ParametrosConstants.PASO_UNO_RETIROS);
			if (!validadorUtils.validarVacio(pasoUnoRetiros)) {
				throw new BusinessException("SE HA DETECTADO UNA ACCIÓN ILEGAL EN EL PROCESO");
			}
			request.getSession().setAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS, retiroMatrimonioImss);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

			DatosCertificables datos = trabajador.getDatosCertificables();
			if (isEmpty(datos)) {
				throw new BusinessException("Datos certificables nulos");
			}
			/*
			 * no debe pedir sello cuando sean terceros
			 * 01 TITULAR 
			 * 02 BENEFICIARIO 
			 * 03 REPRESENTANTE LEGAL
			 */
			
			if("01".equals(trabajador.getTipoSolicitante())) {
				Sello sello = selloService.obtenerSelloTrabajador(usuarioLogin.getCurpAgente(), datos.getCurp(), trabajador.getClaveAfore());
				trabajador.setSello(sello);
				retiroMatrimonioImss.setSelloTrabajador(trabajador.getSello().getId().toString());
			}
			

			// 3.4 Validar solicitud en trámite
			// Agregar servicio de validacion de solicitud en tramite
			MatrimonioLinea solicitudMatrimonio = matrimonioLineaService.buscarTramitesMatrimonio(trabajador.getNss());

			/// CAMBIAR validacion
			if (solicitudMatrimonio != null && solicitudMatrimonio.getNss() != null && !solicitudMatrimonio.getNss().isEmpty()) {
				throw new BusinessException("El trabajador ya se encuentra en un proceso de Retiro por Matrimonio con el IMSS");
			}

			// ya no modificar
			BaseSalidaGenerica<MatrizDerecho> matrizDerecho = consultarMatrizDerechoService.validarMatrizDerechos("I", "07");
			if ("01".equals(matrizDerecho.getCodigoOperacion())) {
				MatrizDerecho matriz = matrizDerecho.getResponse();
				SalidaGenerica resolucion = validaResolucionParcialService.obtenerResolucion(new BigDecimal(trabajador.getProcesar()), matriz.getId(), new BigDecimal(6));

				if ("01".equals(resolucion.getCodigoOperacion())) {
					throw new BusinessException("El trabajador ya efectuó un Retiro por Matrimonio y no podra realizar el tramite");
				}
			}
			// ya no modificar

			FolioEntrada folio = matrimonioLineaService.crearFolio(trabajador, usuarioLogin.getDatoUsuario().toString(), "S", "S18", "S18P1", "SUC1", Constants.TIEMPO_LLEGADA, "O");
			FolioEntrada folioRespuesta = folioService.procesarFolio(folio, trabajador);
			retiroMatrimonioImss.setFolio(folioRespuesta.getFolio());
			retiroMatrimonioImss.setIdFolio(folioRespuesta.getIdFolio());

			/**
			 * GENERACION DE CUS
			 */
			RespuestaGeneraCusSalida salidaGenera;
			cusSalida = cusService.solicitarConsultaCus(datos.getCurp(), Constants.ESTATUS, folioRespuesta.getFolio(), trabajador.getClaveAfore(), "1");
//			cusSalida = new ConsultaCusSalida();
//			HashMap hm =new HashMap<>();
//			hm.put(Constants.CUS, "15027720049091");
//			cusSalida.setCodigo("01");
//			cusSalida.setRespuesta(hm);

			mav.addObject(BOTON_CERTIFICADO, true);

			if (!isEmpty(cusSalida) && cusSalida.getCodigo().equals(Constants.RESULTADO_OPERACION_01)) {
				logger.info("Existe CUS");
				retiroMatrimonioImss.setCus(cusSalida.getRespuesta().get(Constants.CUS));
				logger.info("CUS -EXISTENTE:{}", retiroMatrimonioImss.getCus());

			} else {
				logger.info("NO Existe CUS:Favor de generar una CUS");
				folioService.cerrarFolio(folioRespuesta.getIdFolio(), null);
				FolioEntrada folioGenera = new FolioEntrada();

				folioGenera = matrimonioLineaService.crearFolio(trabajador, usuarioLogin.getDatoUsuario().toString(), "S", "S18", "S18P2", "SUC1", Constants.TIEMPO_LLEGADA, "O");

				folioGenera = folioService.generarNuevoFolio(folioGenera);

				logger.info("Folio genera Cus:{}", folioGenera.getIdFolio());
				salidaGenera = disposicionService.generarCus(trabajador, usuarioLogin, Constants.IMSS, folioGenera.getIdFolio());

				retiroMatrimonioImss.setCus(salidaGenera.getCus());
				logger.info("CUS -GENERADO:{}", retiroMatrimonioImss.getCus());
				if (validadorUtils.isEmpty(retiroMatrimonioImss.getCus())) {
					folioService.cerrarFolio(folioGenera.getIdFolio(), 2);
					String diagnostico = null;
					StringBuilder sb = new StringBuilder("C").append(salidaGenera.getDiagnosticoProcesar());
					RechazoPulssar rechazo = rechazoService.obtenerRechazo(sb.toString(), usuarioLogin.getAforeUsuario());
					diagnostico = rechazo.getMensaje();
					mav.addObject(Constants.MENSAJE, diagnostico);
					mav.addObject(BOTON_CUS, false);
					mav.addObject(BOTON_CERTIFICADO, false);
				} else {
					notificacionService.notificarCus(salidaGenera, usuarioLogin.getAforeUsuario(), folioGenera.getFolio(), "1");
				}
			}
			mav.addObject(Constants.FOLIO, folioRespuesta);
			mav.addObject(DATOS_RETIRO_PARCIAL_IMSS, retiroMatrimonioImss);
			
			request.getSession().setAttribute(Constants.FOLIO, folioRespuesta);
			request.getSession().setAttribute(DATOS_RETIRO_PARCIAL_IMSS, retiroMatrimonioImss);
			if (AFORE_COPPEL.equals(trabajador.getClaveAfore())) {
				List<Parametro> telefonias = catalogoService.obtenerParametroDdbpose(Constants.T00074);
				mav.addObject(Constants.TELEFONIAS, telefonias);
			}
			request.getSession().setAttribute(ParametrosConstants.PASO_UNO_RETIROS, NumerosConstants.C_UNO);
		} catch (BusinessException e) {
			mav = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL_AYUDA_MATRIMONIO.getNavegacion());
			logger.error("Error en la pantalla inicial", e);
			mav.addObject(Constants.ERROR, e.getMessage());
		}
		return mav;
	}

	
	@PostMapping(value = "/private/capturaDatosConyuge.do")
	public ModelAndView solicitaCertificado(ModelAndView mav, @ModelAttribute RetiroDesempleoImss<Peticion> retiroMatrimonioImss, HttpServletRequest request) {
		String pasoDosRetiros = (String) request.getSession().getAttribute(ParametrosConstants.PASO_DOS_RETIROS);
		if (!validadorUtils.validarVacio(pasoDosRetiros)) {
			throw new BusinessException("SE HA DETECTADO UNA ACCIÓN ILEGAL EN EL PROCESO");
		}
		
		mav.setViewName(NavegacionEnum.MATRIMONIO_CAPTURA_CONYUGE.getNavegacion());
		if (validadorUtils.isEmpty(retiroMatrimonioImss.getCus())) {
			folioService.cerrarFolio(retiroMatrimonioImss.getIdFolio(), null);
			mav = new ModelAndView("redirect:/private/generaCus.do?origen=IMSS");
		} 
		mav.addObject("lstGenero", catalogoService.obtenerCatalogoGenero());
		mav.addObject("lstEntidadFederativa", catalogoService.obtenerCatalogoEntidadFederativa());
		request.getSession().setAttribute(ParametrosConstants.PASO_DOS_RETIROS, NumerosConstants.C_UNO);
		return mav;

	}
	
	/**
	 *  ayudaMatrimonioSalida
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param request
	 *  @param map
	 *  @param agmConyuge
	 *  @return
	 */
	@PostMapping(value = "/private/validarSolicitudRetiroMatrimonio.do")
	public ModelAndView validaAyudaMatrimonio(Model model, HttpServletRequest request, @ModelAttribute SolicitarCertificacionMatrimonioEntrada agmConyuge) {
		
		logger.info("##validaAyudaMatrimonio## {}", agmConyuge);
		ModelAndView mav = new ModelAndView(NavegacionEnum.MATRIMONIO_SALIDA.getNavegacion());

		SolicitarCertificacionMatrimonioSalida salida = new SolicitarCertificacionMatrimonioSalida();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>  retiroMatrimonioImss =  (RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		SolicitudDisposicionParcial entradaOp12 = new SolicitudDisposicionParcial();
		ObjectMapper mapeador = new ObjectMapper();
		String jsonInstitucionBanacaria = "";
		try {
			agmConyuge.setNombreConyuge(StringUtils.upperCase(agmConyuge.getNombreConyuge()));
			agmConyuge.setApellidoMaternoConyuge(StringUtils.upperCase(agmConyuge.getApellidoMaternoConyuge()));
			agmConyuge.setApellidoPaternoConyuge(StringUtils.upperCase(agmConyuge.getApellidoPaternoConyuge()));

			agmConyuge.setFolioTramiteProcesar(retiroMatrimonioImss.getFolio());
			agmConyuge.setIdFolio(retiroMatrimonioImss.getIdFolio());

			try {
				salida = matrimonioLineaService.validarCertificado(trabajador, user, retiroMatrimonioImss, retiroMatrimonioImss.getFolio(), entradaOp12, agmConyuge   );
				logger.info("Salida validarCertificado:{}", salida);
				logger.info("SolicitudDisposicionParcial:{}", entradaOp12);
			} catch (Exception e) {
				logger.error("Error en la generacion del certificado", e);
				throw new BusinessException("Error en la generacion del certificado");
			}
			
			if (isEmpty(salida)) {
				throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
			}
			
			retiroMatrimonioImss.setNumeroResolucion(salida.getResolucion());
			logger.info("certificadoSalida  {}", salida);
			salida.setSelloTrabajador(retiroMatrimonioImss.getSelloTrabajador());
//				if(!isEmpty(salida.getDiagnosticoProcesar())){
//					if("532".equals(salida.getDiagnosticoProcesar())){
			mav.addObject(Constants.MENSAJE, "La Solicitud se encuentra en atención, favor de continuar ");
			request.getSession().setAttribute(ParametrosConstants.SESSION_RESPUESTA_532, true);
			request.getSession().setAttribute(ParametrosConstants.SESSION_RESPUESTA_532_OBJETO, entradaOp12);
//					} else {
//						mav.addObject(Constants.MENSAJE, "El certificado se genero correctamente");
//						request.getSession().setAttribute(ParametrosConstants.SESSION_RESPUESTA_532, false);
//					}
//				}
			request.getSession().setAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS, retiroMatrimonioImss);
			
			mav.addObject(BOTON_CERTIFICADO, true);

			List<Parametro> formasPago = catalogoService.obtenerParametroDdbpose(Constants.T00005);
			List<Parametro> listaControlInstitucionBancaria = catalogoService.obtenerParametroDdbpose(Constants.T00003);
			try {
				jsonInstitucionBanacaria = mapeador.writeValueAsString(listaControlInstitucionBancaria);
				logger.info("jsonInstitucionBanacaria: {}", jsonInstitucionBanacaria);
			} catch (JsonProcessingException e) {
				logger.error("Error json", e);
				throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
			}

			CalculoTipoRetiro calculoTipoRetiro =  tipoRetiroService.obtenerTipoRetiroMatrimonio(agmConyuge.getFechaMatrimonio());
			
			Double monto = NumberUtils.toDouble(calculoTipoRetiro.getMontoADisponerA());
			if(monto < 10000) {
				Parametro param = new Parametro();
				param.setChParametro("01");
				param.setChValorParametro("Ventanilla");
				formasPago.add(param);
			}
			request.getSession().setAttribute(ATRIBUTO_CALCULO_TIPO_RETIRO, calculoTipoRetiro);
			request.getSession().setAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS, retiroMatrimonioImss);
			request.getSession().setAttribute(DATOS_RETIRO_PARCIAL_IMSS, retiroMatrimonioImss);
			request.getSession().setAttribute("agmCertEntrada", agmConyuge);
			request.getSession().setAttribute("agmCertSalida", salida);
			
			mav.addObject("formasPago", formasPago);
			mav.addObject("jsonInstitucionBancaria", jsonInstitucionBanacaria);
		} catch (BusinessException e) {
			mav = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL_AYUDA_MATRIMONIO.getNavegacion());
			logger.error("Error en la pantalla inicial", e);
			mav.addObject(Constants.ERROR, e.getMessage());
			
		}

		return mav;
	}
	
	/**
	 * tipoRetiro
	 * 
	 * @param request
	 * @param mav
	 * @param salida
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = "/private/tipoRetiroMatrimonio.do", consumes = "application/json")
	@ResponseBody
	public Map<String, Object> tipoRetiro(ModelMap map, HttpServletRequest request, @RequestBody ParametrosRetiroParcialCalculoImss calculoEntrada) {
		Map<String, Object> mapa = new HashMap<>();

//		SolicitarCertificacionMatrimonioSalida salida = new SolicitarCertificacionMatrimonioSalida();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RetiroDesempleoImss<Peticion> retiroMatrimonioImss = (RetiroDesempleoImss<Peticion>) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		CalculoTipoRetiro calculoTipoRetiro = (CalculoTipoRetiro) request.getSession().getAttribute("calculoTipoRetiro");
		DatosSaldos datosSaldos = (DatosSaldos) request.getSession().getAttribute("datosSaldos");
		request.getSession().setAttribute(ParametrosConstants.ORIGEN, Constants.MATRIMONIO);
		retiroMatrimonioImss.setOrigen(Constants.MATRIMONIO);
		logger.info("salida: {}", retiroMatrimonioImss);

		FolioEntrada folio = matrimonioLineaService.crearFolio(trabajador, user.getDatoUsuario().toString(), "S", "S18", "S18P3", "SUC1", Constants.TIEMPO_LLEGADA, "O");
//		FolioEntrada folioRespuesta = folioService.generarFolioAutoClose(folio);
		FolioEntrada folioRespuesta = folioService.generarNuevoFolio(folio);
//		FolioEntrada folioRespuesta = folioService.generarFolio(folio);

		calculoEntrada.setFolio(folioRespuesta.getFolio());
		calculoEntrada.setFolioHijo(folioRespuesta.getFolioHijo());
		calculoEntrada.setIdFolio(folioRespuesta.getIdFolio());
		calculoEntrada.setClave("1");
		calculoEntrada.setCuenta(StringUtils.substring(calculoEntrada.getCuentaClabe(), 6, 17));
		calculoEntrada.setProcesoReferencia(!isEmpty(retiroMatrimonioImss.getNumeroResolucion()) ? retiroMatrimonioImss.getNumeroResolucion() : null);

		List<String> mensualidades = null;
		List<Mensualidad> mensualidadesEnviar = new ArrayList<>();

		if (datosSaldos != null) {
			calculoEntrada.setSaldoCuotaSocial(NumberUtils.toDouble(datosSaldos.getSaldoCuotaSocial()));
			calculoEntrada.setSaldoRetiro97(NumberUtils.toDouble(datosSaldos.getSaldoRetiro97()));
			calculoEntrada.setSaldoRcv(NumberUtils.toDouble(datosSaldos.getSaldoCesantiaVejez()));
		}

		if (calculoTipoRetiro != null) {
			calculoEntrada.setMontoCalculoA(Double.parseDouble(calculoTipoRetiro.getMontoADisponerA()));
			calculoEntrada.setTipoRetiro(TIPO_RETIRO_A_VALOR);
			Mensualidad mensualidadEnviar = new Mensualidad();
			mensualidadEnviar.setParcialidad(INT_UNO);
			mensualidadEnviar.setMontoParcialidad(calculoEntrada.getMontoCalculoA());
			mensualidadEnviar.setFechaPago(new Date());
			mensualidadEnviar.setDerechoPago(CLAVE_DERECHO_PAGO_CALCULO);
			mensualidadesEnviar.add(mensualidadEnviar);
			calculoEntrada.setNumeroParcialidad(1);
			validarDatos(calculoEntrada.getMontoCalculoA(), calculoEntrada.getFormaPago(), trabajador.getClaveAfore());

			calculoEntrada.setMensualidad(mensualidadesEnviar);
		} else {
			throw new BusinessException("Error al obtener el cálculo del tipo de retiro");
		}

		request.getSession().setAttribute(PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS, calculoEntrada);

		return mapa;
	}

	@PostMapping(value = "/private/guardarCalculo.do", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, String> retiroSolicitudDisposicion(HttpServletRequest request, ModelAndView mav, 
			 @SessionAttribute( "calculoTipoRetiro") CalculoTipoRetiro calculoTipoRetiro){

		logger.info("solicitudDisposicion");

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		Boolean respuesta532 = (Boolean) request.getSession().getAttribute(ParametrosConstants.SESSION_RESPUESTA_532);
		ParametrosRetiroParcialCalculoImss calculoEntrada = (ParametrosRetiroParcialCalculoImss) request.getSession().getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		Map<String, String> mapa = new HashMap<>();
		logger.info("respuesta532 -> {}", respuesta532);

//		ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss = obtenerParametrosEntrada(request, trabajador.getClaveAfore());
		calculoEntrada.setIdProcesar(trabajador.getProcesar());

		try {
			retiroParcialCalculoService.guardarCalculo(calculoEntrada, trabajador, origen, respuesta532);
		}catch(BusinessException e) {
			mapa.put(Constants.ERROR, e.getMessage());
			return mapa;
		}
		request.getSession().setAttribute("cuentaClabe", calculoEntrada.getCuentaClabe());
		

		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(user.getDatoUsuario());
		folio.setOperacion("S");
		folio.setServicio("S18");
		folio.setProceso("S18P4");
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folio.setOrigen("O");
//		folio.setEstatus(0L);

		FolioEntrada folioRespuesta = folioService.generarNuevoFolio(folio);
		mav.addObject("folioConformacion", folioRespuesta);

		calculoEntrada.setFolio(folioRespuesta.getFolio());
		calculoEntrada.setFolioHijo(folioRespuesta.getFolioHijo());
		calculoEntrada.setIdFolio(folioRespuesta.getIdFolio());
		request.getSession().setAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS, calculoEntrada);
		request.getSession().setAttribute("folioEntrada", folioRespuesta);
		
		request.getSession().setAttribute("tipoDocumento", "40");
		request.getSession().setAttribute(ParametrosConstants.DOC_OBLIG_A_QUITAR, "62");
		
		List<Parametro> adicionales = catalogoService.obtenerParametroDdbpose(Constants.P00021);
		logger.info("Adicionales: {}", trabajador.getTipoSolicitante());
		if(!"01".equals(trabajador.getTipoSolicitante())){
			if(validadorUtils.isEmpty(adicionales)){
				Parametro parametro = new Parametro();
				parametro.setChValorParametro("31|0");
				adicionales = new ArrayList<>();
				adicionales.add(parametro);
			} else {
				logger.info("Adicionales: {}", adicionales.get(0).getChValorParametro());
				adicionales.get(0).setChValorParametro(adicionales.get(0).getChValorParametro().concat("|31|0"));
			}
		}
		
		if(!validadorUtils.isEmpty(adicionales) && !validadorUtils.isEmpty(adicionales.get(0).getChValorParametro())){
			String [] adicional = adicionales.get(0).getChValorParametro().split("\\|");
			mav.addObject(DOC_ADICIONAL, adicional);
			logger.info("Adicionales: {}", adicionales.get(0).getChValorParametro());
		}
		
		if (respuesta532) {
			request.getSession().setAttribute(Constants.DESTINO, "/private/solicituddisposicionsalida2.do");
		} else {
			request.getSession().setAttribute(Constants.DESTINO, "/private/solicituddisposicionsalida.do");
		}
		
		DatosSolicitudRetiroParcialMatrimonio  datosSolicitudPdf = obterDatosSolicitudRetiroParcialMatrimonio(trabajador, user,
				calculoEntrada);
		
//		if(ParametrosConstants.MATRIMONIO.equals(origen)) {
		mapa.put(Constants.DESTINO, NavegacionEnum.FORWARD_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS_GEN.getNavegacion());
		request.getSession().setAttribute(ATRIBUTO_DATOS_SOLICITUD_MATRIMONIO_IMSS, datosSolicitudPdf);
//		}
		DatosDocumentoPdf datosPdf = new DatosDocumentoPdf();
		datosPdf.setDatos(datosSolicitudPdf);
		datosPdf.setUrlPaginaSiguiente(NavegacionEnum.SOLICITUD_DISPOSICION_PARCIAL_SALIDA.getNavegacion());
		datosPdf.setMetodoPaginaSiguiente(HttpMethod.POST.toString());
		
		logger.info("los datos del pdf solicitud de disposicion parcial: {}", datosPdf);
		
//		mav.addObject(ParametrosConstants.DATOS_PDF, datosPdf);
		request.getSession().setAttribute(ParametrosConstants.DATOS_PDF_MATRIMONIO, datosPdf);
		request.getSession().setAttribute(ParametrosConstants.DATOS_PDF, datosPdf);
		request.getSession().setAttribute("folioEntrada", folioRespuesta);
		return mapa;
	}
	
	

		private void validarDatos(Double monto, String formaPago, String afore ){
			if(monto>10000 && formaPago.equals("01") && afore.equals("568")){	
				logger.info("monto: {}\nformaPago:{}\nafore:{}", monto, formaPago, afore);
				throw new BusinessException("Los datos con los que se esta realizando el calculo son incorrectos");
			}
		}

		private DatosSolicitudRetiroParcialMatrimonio obterDatosSolicitudRetiroParcialMatrimonio(DatosTrabajador trabajador, UsuarioLogin user,
				ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss) {
//			DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
//					.getAttribute(ParametrosConstants.REQUEST_DATOS);
//			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

			DatosSolicitudRetiroParcialMatrimonio solicitud = new DatosSolicitudRetiroParcialMatrimonio();

			if (trabajador.getDatosCertificables() != null) {
				solicitud.setFechaNacimiento(trabajador.getDatosCertificables().getFechaNacimiento());
				solicitud.setGenero(trabajador.getDatosCertificables().getClaveGenero());
				solicitud.setCurp(trabajador.getDatosCertificables().getCurp());
				solicitud.setNombre(trabajador.getDatosCertificables().getNombre());
				solicitud.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
				solicitud.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
				if(!trabajador.getTipoSolicitante().equals("01") && "568".equals(user.getAforeUsuario())){
//					EntradaConsulta entradaConsulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL);
//					solicitud.setNombreFirma(entradaConsulta.getNombre());
//					solicitud.setApFirma(entradaConsulta.getApellidoPaterno());
//					solicitud.setAmFirma(entradaConsulta.getApellidoMaterno());
				} else {
					solicitud.setNombreFirma(trabajador.getDatosCertificables().getNombre());
					solicitud.setApFirma(trabajador.getDatosCertificables().getApellidoPaterno());
					solicitud.setAmFirma(trabajador.getDatosCertificables().getApellidoMaterno());
				}

			}

			if (trabajador.getDatosNoCertificables() != null) {
				solicitud.setRfc(trabajador.getDatosNoCertificables().getRfc());
			}

//			solicitud.setFechaSolicitud(fechaUtils.convertirFechaACadena(new Date(), DDMMYYYY));

			solicitud.setNumeroFolio(parametrosRetiroParcialCalculoImss.getFolio());

			solicitud.setNumeroUnidad("");
			solicitud.setNss(trabajador.getNss());
			solicitud.setClabe(parametrosRetiroParcialCalculoImss.getCuentaClabe());
			solicitud.setFormaPago(parametrosRetiroParcialCalculoImss.getFormaPago());
			
			if (trabajador.getDatosComplementarios() != null) {
				if (trabajador.getDatosComplementarios().getTelefonos() != null) {
					solicitud.setTelefono(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
					solicitud.setCelular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
				}

				solicitud.setEmail(trabajador.getDatosComplementarios().getCorreoElectronico());

				if (trabajador.getDatosComplementarios().getParticular() != null) {
					solicitud.setCalle(trabajador.getDatosComplementarios().getParticular().getCalle());
					solicitud.setNumeroExterior(trabajador.getDatosComplementarios().getParticular().getNoExterior());
					solicitud.setNumeroInterior(trabajador.getDatosComplementarios().getParticular().getNoInterior());
					solicitud.setCodigoPostal(trabajador.getDatosComplementarios().getParticular().getCodigoPostal());
					solicitud.setPais(trabajador.getDatosComplementarios().getParticular().getPais());
					solicitud.setColonia(trabajador.getDatosComplementarios().getParticular().getColonia());
					solicitud.setEntidadFederativa(
							trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
					solicitud.setDelegacionMunicipio(trabajador.getDatosComplementarios().getParticular().getMunicipio());
					solicitud.setPoblacion(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
				}
			}

			solicitud.setCompaniaCelular("");

//			agregarFormaPago(solicitud, parametrosRetiroParcialCalculoImss);
//			agregarTipoRetiro(solicitud, parametrosRetiroParcialCalculoImss, request);
			solicitud.setNombreAsesor(user.getNombre());
			solicitud.setCurpAsesor(user.getCurpAgente());
			logger.info("solicitud entrada : ##### {}", solicitud);

			return solicitud;
		}

		@GetMapping(value = "/private/solicitudCertificado.do", produces = "application/json")
		@ResponseBody
		public Map<String, Object> solicitarCertificado(ModelMap map,HttpServletRequest request) {
			
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS);
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
			ParametrosRetiroParcialCalculoImss calculoEntrada = (ParametrosRetiroParcialCalculoImss) request.getSession().getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
			Map<String, Object> mapa = (Map<String, Object>) request.getSession().getAttribute(DATOS_CERTIFICACION);
			if(!MapUtils.isEmpty(mapa)) {
				if(MapUtils.getBooleanValue(mapa, "exec", false)) {
					return mapa;
				}
			}else {
				mapa = new HashMap<>(); 
			}
			procesoPendienteService.eliminarProcesoPendiente(trabajador.getDatosCertificables().getCurp(), "09,10");
			RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>  retiroMatrimonioImss =
					(RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
			ProcesoPendienteEntrada<Peticion<SolicitarCertificacionMatrimonioEntrada>> procesoPendienteOp07 = (ProcesoPendienteEntrada<Peticion<SolicitarCertificacionMatrimonioEntrada>>)retiroMatrimonioImss.getPeticion07();
			Peticion<SolicitarCertificacionMatrimonioEntrada> entrada = (Peticion<SolicitarCertificacionMatrimonioEntrada>)procesoPendienteOp07.getPeticion();
			SolicitarCertificacionMatrimonioSalida  salida = matrimonioLineaService.consultarMatrimonio(entrada.getPeticion());
			if("02".equals(salida.getResultadoOperacion())){
				RechazoPulssar rechazo = rechazoService.obtenerRechazo(salida.getMotivoRechazo(), user.getAforeUsuario());
				mapa.put("error", rechazo.getMensaje());
			} else {
				matrimonioLineaService.notificarTipoRetiroMatrimonio(trabajador, salida.getResolucion(), entrada.getPeticion().getFolioTramiteProcesar(), calculoEntrada);
				ProcesoPendienteEntrada<SolicitudDisposicionParcial> procesoPendienteOp12 = 
						(ProcesoPendienteEntrada<SolicitudDisposicionParcial>)retiroMatrimonioImss.getPeticion12();
				procesoPendienteOp12.getPeticion();
				RetiroDesempleoImss datosRetiroDesempleoImss = new RetiroDesempleoImss<Peticion<SolicitudDisposicionParcial>>();
				datosRetiroDesempleoImss.setNumeroResolucion(salida.getResolucion());
				datosRetiroDesempleoImss.setSelloTrabajador(trabajador.getSello().getId().toString());
				SolicitudDisposicionParcialRespuesta disposicion = solicitud12Service.solicitudDisposicion(trabajador,
						user.getCurpAgente(), datosRetiroDesempleoImss, user, entrada.getPeticion().getFolioTramiteProcesar(), origen);
				if("02".equals(disposicion.getResultadoOperacion())){
					RechazoPulssar rechazo = rechazoService.obtenerRechazo(salida.getMotivoRechazo(), user.getAforeUsuario());
					mapa.put("error", rechazo.getMensaje());
				} else {
					mapa.put("mensajeMat", "Su tramite se realizó con exito");
					mapa.put("numResolucion", salida.getResolucion());
				}
				mapa.put("exec", true);
			}
			
			request.getSession().setAttribute(DATOS_CERTIFICACION, mapa);
			
			return mapa;	
		}
}
