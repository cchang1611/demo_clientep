package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;


import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.BOTON_CERTIFICADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.BOTON_CUS;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionCalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controller Retiro Desempleo Issste
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 07/08/2019
 */
@RestController
public class RetiroDesempleoIsssteController extends BaseController {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetiroDesempleoIsssteController.class);
	/**
	 * Inyeccion dependencia ConsultaSelloService
	 */
	@Autowired
	private ConsultaSelloService consultaSelloService;
	/**
	 * Inyeccion dependencia CusService
	 */
	@Autowired
	private CusService cusService;
	
	/**
	 *Inyeccion dependencia RetirosDesempleoIsssteService
	 */
	@Autowired
	private RetirosDesempleoIsssteService retirosDesempleoIsssteService;

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
	 * Inyeccion disposicionService
	 */
	@Autowired
	private DisposicionTotalImssService disposicionService;
	
	
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
	 * solicitudParcialIssste
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param request
	 * @param map
	 * @return
	 */
	@GetMapping(value = "/private/solicitudParcialIssste.do")
	public ModelAndView solicitudParcialIssste(HttpServletRequest request, ModelMap map) {

		ModelAndView modelAndView;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		Resolucion resolucion = (Resolucion) request.getSession().getAttribute(ParametrosConstants.RESOLUCION_ISSSTE);
		
		Sello sello = null;
		String direccionamiento = null;
		RespuestaGeneraCusSalida salidaGenera;
		try {
			logger.info("trabajador {}", trabajador);
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

			DatosCertificables datos = trabajador.getDatosCertificables();
			
			if (isEmpty(datos)) {
				throw new BusinessException("Datos certificables nulos");
			}
			
			FolioEntrada folio = new FolioEntrada();
			folio.setIdUsuario(Long.valueOf(usuarioLogin.getDatoUsuario()));
			folio.setOperacion("S");
			folio.setServicio("S6");
			folio.setProceso("S6P1");
			folio.setSucursal("SUC1");
			folio.setNss(trabajador.getNss());
			folio.setCurp(trabajador.getDatosCertificables().getCurp());
			folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
			folio.setOrigen("O");

			FolioEntrada folioRespuesta = folioService.procesarFolio(folio, trabajador);
			map.addAttribute("folio", folioRespuesta);
			
			
			sello = consultaSelloService.obtenerSelloTrabajador(user.getCurpAgente(),datos.getCurp(),trabajador.getClaveAfore());
			consultaSelloService.guardarSello(sello.getId(), "40");

			logger.info("sello {}", sello);
			direccionamiento = "1";
			
			RetiroDesempleoIssste retiroDesempleoIssste = new RetiroDesempleoIssste();
			retiroDesempleoIssste.setResolucion(resolucion);
			retiroDesempleoIssste.setSelloTrabajador(sello.getId());

			HashMap<String, Object> saldos = (HashMap<String, Object>) retirosDesempleoIsssteService.consultarTipoRetiro(resolucion, trabajador.getSaldos());
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_RESOLUCION, retiroDesempleoIssste);
			map.addAttribute("resolucion", resolucion);
			map.addAttribute("tipoTramite", resolucion.getIretMatrizDerecho().getClaveTipoRegimen());
			map.addAttribute("saldos", saldos);

			NotificacionCalculoTipoRetiro calculo = (NotificacionCalculoTipoRetiro) saldos.get("calculo");
			calculo.setAfore(trabajador.getClaveAfore());
			calculo.setCurp(datos.getCurp());
			calculo.setNotificado(0l);
			calculo.setFechaControl(new Date());
			calculo.setUsuarioModificador(user.getUsuario());
			calculo.setFolio(folioRespuesta.getFolio());
			logger.info("calculo: {}", calculo);
			request.getSession().setAttribute("montoAGuardar", calculo);
			
			ConsultaCusSalida cusSalida = cusService.solicitarConsultaCus(datos.getCurp(), "1", folioRespuesta.getFolio(), trabajador.getClaveAfore(), null);

			if (!isEmpty(cusSalida) && "01".equals(cusSalida.getCodigo())) {
				// map.addAttribute("cus", cusSalida.getRespuesta().get("cus"));
				// map.addAttribute("botoncus", false);
				// map.addAttribute(BOTON_CERTIFICADO, false);
				retiroDesempleoIssste.setCus(cusSalida.getRespuesta().get(Constants.CUS));
				map.addAttribute(Constants.RETIRO_DESEMPLEO_ISSSTE, retiroDesempleoIssste);
				request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoIssste);
				List<Parametro> listaControlInstitucionBancaria = catalogoService
						.obtenerParametroDdbpose(Constants.T00003);
				ObjectMapper mapeador = new ObjectMapper();
				String jsonInstitucionBanacaria = "";

				try {
					jsonInstitucionBanacaria = mapeador.writeValueAsString(listaControlInstitucionBancaria);
					logger.info("jsonInstitucionBanacaria: {}", jsonInstitucionBanacaria);
				} catch (JsonProcessingException e) {
					logger.error("JsonProcessingException", e);
					throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
				}

				List<Parametro> formasPago = catalogoService.obtenerParametroDdbpose(Constants.T00005);

				map.addAttribute("jsonInstitucionBancaria", jsonInstitucionBanacaria);
				map.addAttribute("formasPago", formasPago);
				 map.addAttribute("boton", true);
			} else {
				/*
				 * map.addAttribute("mensaje", "Favor de generar una CUS");
				 * map.addAttribute("resultadoOperacion", "02"); map.addAttribute("botoncus",
				 * true); map.addAttribute(BOTON_CERTIFICADO, true);
				 */

				logger.info("NO Existe CUS:Favor de generar una CUS");
				folioService.cerrarFolio(folioRespuesta.getIdFolio(), null);
				FolioEntrada folioGenera = new FolioEntrada();

				folioGenera.setIdUsuario(usuarioLogin.getDatoUsuario());
				folioGenera.setOperacion("S");
				folioGenera.setServicio("S6");
				folioGenera.setProceso("S6P2");
				folioGenera.setSucursal("SUC1");
				folioGenera.setNss(trabajador.getNss());
				folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
				folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
				folioGenera.setOrigen("O");

				folioGenera = folioService.generarFolio(folioGenera);
				logger.info("Folio genera Cus:{}", folioGenera.getIdFolio());
				salidaGenera = disposicionService.generarCus(trabajador, usuarioLogin, Constants.ISSSTE, folioGenera.getIdFolio());

				retiroDesempleoIssste.setCus(salidaGenera.getCus());
				logger.info("CUS -GENERADO:{}", retiroDesempleoIssste.getCus());
				if (validadorUtils.isEmpty(retiroDesempleoIssste.getCus())) {
					folioService.cerrarFolio(folioGenera.getIdFolio(), 2);
					String diagnostico = null;
					StringBuilder sb = new StringBuilder("C").append(salidaGenera.getDiagnosticoProcesar());
					RechazoPulssar rechazo = rechazoService.obtenerRechazo(sb.toString(),
							usuarioLogin.getAforeUsuario());
					diagnostico = rechazo.getMensaje();
					map.addAttribute(Constants.MENSAJE, diagnostico);
					map.addAttribute(BOTON_CUS, false);
					map.addAttribute(BOTON_CERTIFICADO, false);
				} else {
					notificacionService.notificarCus(salidaGenera, usuarioLogin.getAforeUsuario(), folioGenera.getFolio(), "3");
					map.addAttribute("boton", true);
				}
				map.addAttribute(Constants.RETIRO_DESEMPLEO_ISSSTE, retiroDesempleoIssste);
				request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoIssste);

			}
			modelAndView = new ModelAndView(NavegacionEnum.SOLICITUD_PARCIAL_ISSSTE.getNavegacion());

		} catch (BusinessException e) {
			logger.error("Error", e);
			map.addAttribute("error", e.getMessage());
			map.addAttribute("folio", trabajador.getFolio());
			map.addAttribute("direccionamiento", direccionamiento);
			
			
			modelAndView = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL.getNavegacion());
		}
		return modelAndView;
	}

	/**
	 *  solicitud Parcial Issste
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param request
	 *  @param map
	 *  @param retiroDesempleoIssste
	 *  @return
	 */
	@PostMapping(value = "/private/solicitudParcialIsssteSalida.do")
	public ModelAndView solicitarParcialIsssteSalida(HttpServletRequest request, ModelMap map, @ModelAttribute("retiroDesempleoIssste") RetiroDesempleoIssste retiroDesempleoIssste) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RetiroDesempleoIssste resolucion = (RetiroDesempleoIssste) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_RESOLUCION);
		NotificacionCalculoTipoRetiro calculo = (NotificacionCalculoTipoRetiro) request.getSession().getAttribute("montoAGuardar");
		String  nti = (String) request.getSession().getAttribute("nti");
		folioService.cerrarFolio(retiroDesempleoIssste.getIdFolio(), 1);
		logger.info("retiroDesempleoIssste: {}", retiroDesempleoIssste);
		retirosDesempleoIsssteService.guardarTipoRetiroIssste(resolucion.getResolucion(), retiroDesempleoIssste, trabajador.getSaldos());
		calculo.setNumeroCuenta(retiroDesempleoIssste.getCuentaTipoRetiro());
		calculo.setCuentaClabe(retiroDesempleoIssste.getClabeTipoRetiro());
		calculo.setClaveBanco(retiroDesempleoIssste.getCtrlInstBancariaTipoRetiro());
//		calculo.setTipoRetiroSeleccion(retiroDesempleoI);
		calculo.setFechaProcesamiento(new Date());
//		calculo.setDiagnosticoRecepcion(diagnosticoRecepcion);
		retirosDesempleoIsssteService.guardarCalculoTipoRetiroIssste(calculo);
		
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(Long.valueOf(usuarioLogin.getDatoUsuario()));
		folio.setOperacion("S");
		folio.setServicio("S6");
		folio.setProceso("S6P3");
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folio.setOrigen("O");
		folio.setEstatus(0L);
		FolioEntrada folioRespuesta = folioService.generarFolio(folio);

		request.getSession().setAttribute("folioEntrada",folioRespuesta);
		request.getSession().setAttribute("tipoDocumento", "40");
		request.getSession().setAttribute("destino", "/private/solicitudDisposicionParcialIsssteOperacion12");
		DatosDocumentoPdf datosPdf = new DatosDocumentoPdf();
		DatosSolicitudRetiroParcialDesempleoIssste datosSolicitud = obtenerDatosSolicitud(request, folioRespuesta.getFolio());
		datosSolicitud.setNti(nti);
		datosPdf.setDatos(datosSolicitud);
		logger.info("los datos del pdf solicitud de disposicion parcial: {}", datosPdf);
		request.getSession().setAttribute(ParametrosConstants.DATOS_PDF, datosPdf);
		request.getSession().setAttribute(ParametrosConstants.DOC_OBLIG_A_QUITAR, "62");
		List<Parametro> adicionales = catalogoService.obtenerParametroDdbpose(Constants.P00022);
		logger.info("Adicionales: {}", adicionales);
		String [] adicional = adicionales.get(0).getChValorParametro().split("\\|");
		request.getSession().setAttribute(ParametrosConstants.DOC_ADICIONAL, adicional);
		return new ModelAndView(NavegacionEnum.FORWARD_PDF_SOLICITUD_RETIRO_ISSSTE_GEN.getNavegacion());
	}
	
	/**
	 *  generar Solicitud Disposicion Parcial Operacion 12
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param request
	 *  @return
	 */
	@GetMapping(value="/private/solicitudDisposicionParcialIsssteOperacion12")
	public ModelAndView generarSolicitudDisposicionParcialOperacion12(HttpServletRequest request, ModelMap map) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RetiroDesempleoIssste retiroDesempleoIssste = (RetiroDesempleoIssste) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_RESOLUCION);
		FolioEntrada folioentrada = (FolioEntrada) request.getSession().getAttribute("folioEntrada");
		Boolean inicioFlujo = (Boolean) request.getSession().getAttribute(ParametrosConstants.TERMINO_FLUJO);
		String tipoTramite = (String) request.getSession().getAttribute(ParametrosConstants.TIPO_TRAMITE);
		
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(Long.valueOf(usuarioLogin.getDatoUsuario()));
		folio.setOperacion("S");
		folio.setServicio("S6");
		folio.setProceso("S6P4");
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folio.setOrigen("O");
		FolioEntrada folioRespuesta = folioService.generarFolio(folio);
		
		trabajador.setFolio(folioRespuesta);

		SolicitudDisposicionParcialSalida disposicion = retirosDesempleoIsssteService.solicitarDisposicionParcialIssste(trabajador, usuarioLogin ,retiroDesempleoIssste, folioentrada, tipoTramite);
		
		ModelAndView mnv = new ModelAndView(NavegacionEnum.SOLICITUD_PARCIAL_ISSSTE.getNavegacion());
		
		map.addAttribute("resultadoOperacion", disposicion.getResultadoOperacion());
		map.addAttribute("mensaje", "Aceptado");
		if("02".equals(disposicion.getResultadoOperacion())) {
			map.addAttribute("mensaje", disposicion.getDescripcionDiagnostico());
			logger.info("##### mensaje: {}", disposicion.getDescripcionDiagnostico());
		}
		map.addAttribute("boton", false);
		if(inicioFlujo) {
			EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
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
			
			mnv.addObject("commandConsulta",commandConsulta );
		} 
		
		return mnv;

	}
	
	@PostMapping(value="/private/generarPdfSolicitudDisposicionParcialIssste")
	public ModelAndView generarSolicitudDisposicionParcial(HttpServletRequest request) {
		DatosDocumentoPdf datosPdf = new DatosDocumentoPdf();
		DatosSolicitudRetiroParcialDesempleoIssste datosSolicitud = obtenerDatosSolicitud(request, null);
		datosPdf.setDatos(datosSolicitud);
		logger.info("los datos del pdf solicitud de disposicion parcial: {}", datosPdf);
		request.getSession().setAttribute(ParametrosConstants.DATOS_PDF, datosPdf);
		
		return new ModelAndView(NavegacionEnum.FORWARD_PDF_SOLICITUD_RETIRO_ISSSTE.getNavegacion());
	}
	
	
	private DatosSolicitudRetiroParcialDesempleoIssste obtenerDatosSolicitud(HttpServletRequest request, String folio) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosSolicitudRetiroParcialDesempleoIssste datosSolicitud = new DatosSolicitudRetiroParcialDesempleoIssste();
		
		if(trabajador!=null) {
			datosSolicitud.setNumeroFolio(folio);
			
			datosSolicitud.setVentanilla("");//TODO FALTA ESTE CAMPO
			
			if(trabajador.getDatosCertificables()!=null) {
				datosSolicitud.setNombre(trabajador.getDatosCertificables().getNombre());
				datosSolicitud.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
				datosSolicitud.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
				datosSolicitud.setCurp(trabajador.getDatosCertificables().getCurp());
			}
			
			datosSolicitud.setNss(trabajador.getNss());
			datosSolicitud.setNti("");//TODO FALTA ESTE CAMPO
			
			if(trabajador.getDatosNoCertificables()!=null) {
				datosSolicitud.setRfc(trabajador.getDatosNoCertificables().getRfc());			
			}
			
			if(trabajador.getDatosComplementarios()!=null&&trabajador.getDatosComplementarios().getParticular()!=null) {
				datosSolicitud.setCalle(trabajador.getDatosComplementarios().getParticular().getCalle());
				datosSolicitud.setNumeroExterior(trabajador.getDatosComplementarios().getParticular().getNoExterior());
				datosSolicitud.setNumeroInterior(trabajador.getDatosComplementarios().getParticular().getNoInterior());
				datosSolicitud.setColonia(trabajador.getDatosComplementarios().getParticular().getColonia());
				datosSolicitud.setCiudad(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
				datosSolicitud.setDelegacionMunicipio(trabajador.getDatosComplementarios().getParticular().getMunicipio());
				datosSolicitud.setCodigoPostal(trabajador.getDatosComplementarios().getParticular().getCodigoPostal());
				datosSolicitud.setEntidadFederativa(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
				datosSolicitud.setEmail(trabajador.getDatosComplementarios().getCorreoElectronico());
				
				if(trabajador.getDatosComplementarios().getTelefonos()!=null) {
					datosSolicitud.setCelular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
				}
				
			}
			
			//TODO hace falta los datos del contacto
			//TODO faltan los check boxes de autorizacion
			//TODO falta la solicitud de servicio
			//TODO falta la documentacion entregada
			//TODO falta beneficiario
			
		}

		if(user!=null) {
			datosSolicitud.setNombreAgente(user.getNombre());
		}
		
		return datosSolicitud;
	}
	
	

}
