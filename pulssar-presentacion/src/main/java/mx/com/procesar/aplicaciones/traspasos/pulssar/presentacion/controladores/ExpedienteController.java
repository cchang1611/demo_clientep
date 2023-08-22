package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ArchivosUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BiometricoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HuellasService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIdenExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaBiometricoCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaHuella;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPDF;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaBase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TabletBanorte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Controlador para el manejo de petciones de expediente
 * 
 * @version 1.0
 * @since
 */
@Controller
@RequestMapping(value = "/private")
public class ExpedienteController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExpedienteController.class);
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Inyeccion de expediente
	 */
	@Autowired
	private ExpedienteService servicioExpediente;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * service
	 */
	@Autowired
	private DocumentosGenericoService service;
	
	/**
	 * Variable para el jnlp huellas
	 */
	@Value("${jnlp.capturaHuellas}")
	private String jnlpHuellas;
	
	/**
	 * Variable para el jnlp host
	 */
	@Value("${jnlp.url.host}")
	private String jnlpHost;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ArchivosUtils utileriaArchivos;

	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Inyeccion de huellas servicio
	 */
	@Autowired
	private HuellasService huellasServicio;
	
	/**
	 * Web Socket Coppel
	 */
	@Value("${web.socket.coppel}")
	private String webSocketCoppel;
	
	/**
	 * Web Socket Procesar
	 */
	@Value("${web.socket.procesar}")
	private String webSocketProcesar;
	
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['banorte.tablet.ambiente']}")
	private String ambiente;
	
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['url.ambiente.portal']}")
	private String ambientePortal;
	
	/**
	 * Inyeccion de servicio de biometrico
	 */
	@Autowired
	private BiometricoService biometricoService;
	
	/**|
	 * Vista generacion de expediente Biometrico
	 * a partir de modificación de datos
	 */
	@RequestMapping(value="/enrolamiento.do", method = RequestMethod.GET)
	public ModelAndView ejecutarBiometricoModificacion(HttpServletRequest request) {
		logger.info("Iniciando proceso Expediente Biometrico por Modificación de Datos");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		EntradaModificacion entradaModificacion = null;
		FlujoModificacion flujo = null;
		EntradaPermanencia entradaPermanencia = null;
		FolioEntrada folioSesion = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			folioSesion = (FolioEntrada)request.getSession().getAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION);
			
			Object auxiliar = entradaModificacion;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			
			datosExpediente.setCurp(folioSesion.getCurp());
			datosExpediente.setNss(folioSesion.getNss());
			respuesta = obtenerVistaBiometrico(folioSesion, model, request, datosExpediente, user.getDatoUsuario(), user.getAforeUsuario(), ServiciosConstants.DESCRIPCION_SERVICIO_MDBIOMETRICOS, ServiciosConstants.FOLIO_SERVICIO_MODIFICACION_DATOS, ServiciosConstants.FOLIO_PROCESO_MDBIOMETRICO);
		}  catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute("redirecHuellas", "continuarFlujoModificacion.do");
		model.addObject("socket", "");
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
		request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION, folioSesion);
		request.getSession().setAttribute(ParametrosConstants.FLUJO_FUNCION, "rHuellasMDBiometrico.do");
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Metodo encargado de obtener los valores para la vista de biometricos
	 * @param trabajador
	 * @return
	 */
	private RespuestaServicio obtenerVistaBiometrico(FolioEntrada folioSesion, ModelAndView model, HttpServletRequest request, DatosIdenExpediente trabajador, Long idUsuario, String afore, String desc, String servicio, String proceso) {
		String curp = trabajador.getCurp();
		String nss = trabajador.getNss();
		if(!utileriaValidador.validarObjetoNulo(folioSesion)) {
			curp = folioSesion.getCurp();
			nss = folioSesion.getNss();
		}
		
		EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
		String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
		
		FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(curp, nss, desc, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
		Folio folioHijo = servicioFolio.obtenerFolio(folioEntrada, idUsuario, sucursal, servicio, proceso);
		
		FolioEntrada auxiliar = new FolioEntrada();
		auxiliar.setFolio(folioHijo.getChFolio());
		
		model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, auxiliar);
		
		RespuestaServicio respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.EXCEPCION_BIOMETRICO.getClave(), afore, NumerosConstants.INT_CERO, null);
		
		model.addObject("tituloContenedor", respuesta.getTitulo());
		model.addObject("mensajeDatos", respuesta.getMensaje());
		request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
		return respuesta;
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/biometricos.do", method = RequestMethod.GET)
	public ModelAndView ejecutarBiometrico(HttpServletRequest request) {
		logger.info("Iniciando proceso Expediente Biometrico");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			
			List<String> estatusEnrolamiento = new ArrayList<>();
			estatusEnrolamiento.add(NumerosConstants.C_DOS);
			estatusEnrolamiento.add(NumerosConstants.C_CINCO);
			
			List<String> estatusTransito = new ArrayList<>();
			estatusTransito.add(NumerosConstants.C_SEIS);
			estatusTransito.add(NumerosConstants.C_UNO);
			estatusTransito.add(NumerosConstants.C_TRES);
			
			logger.info("Estatus Enrolamiento: {}",trabajador.getDatosExpediente().getEstatusEnrolamiento());
			
			if(!estatusEnrolamiento.contains(trabajador.getDatosExpediente().getEstatusEnrolamiento()) && !estatusTransito.contains(trabajador.getDatosExpediente().getEstatusEnrolamiento()) ) {
				DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(trabajador, null);
				respuesta = obtenerVistaBiometrico(null, model, request, datosExpediente, user.getDatoUsuario(), user.getAforeUsuario(), ServiciosConstants.DESCRIPCION_SERVICIO_BIOMETRICOS, ServiciosConstants.FOLIO_SERVICIO_ENROLAMIENTO, ServiciosConstants.FOLIO_PROCESO_ENROLAMIENTO);
			} else if(estatusTransito.contains(trabajador.getDatosExpediente().getEstatusEnrolamiento())) {
				logger.info("Rechazo Enrolamiento: 6, 1 o 3");
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.EXPEDIENTE_EN_TRANSITO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DIEZ, null);
				model.addObject(ParametrosConstants.REDIRECCIONAMIENTO, ParametrosConstants.METODO_MENU);
			}else {
				logger.info("Rechazo Enrolamiento: 5 o 2");
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.TIENE_EXPEDIENTE_ENROLAMIENTO_PERMANENTE.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DIEZ, null);
				model.addObject(ParametrosConstants.REDIRECCIONAMIENTO, ParametrosConstants.METODO_MENU);
			}
			
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
			
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute("redirecHuellas", "amenu.do");
		model.addObject("socket", "");
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		request.getSession().setAttribute(ParametrosConstants.FLUJO_FUNCION, "rHuellasBiometrico.do");
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Modelo para mostrar el documeto de acuse
	 * @param request
	 * @param flagsExpediente
	 * @return
	 */
	@RequestMapping(value="/aplicarExcepcion.do", method = RequestMethod.POST)
	public ModelAndView validarExcepcionHuellas(HttpServletRequest request, @ModelAttribute Expediente flagsExpediente) {
		logger.info("Iniciando proceso Expediente Biometrico");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		RespuestaBase respuesta = new RespuestaBase();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			EntradaModificacion entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			EntradaPermanencia entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			DatosIdenExpediente datosExpediente = obtenerObjetoDatosExpediente(trabajador, entradaModificacion, entradaPermanencia, flujo);
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			respuesta = biometricoService.validarExcepcionPantalla(folioHijo.getCurp(), flagsExpediente.getClaveExcep(), ServiciosConstants.TIPO_HUELLAS_TRABAJADOR, user.getAforeUsuario());
			Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
			EntradaPDF pdf = new EntradaPDF();
			boolean isExcepcion = false;
			if(NumerosConstants.INT_NOVENTAYNUEVE != Integer.parseInt(flagsExpediente.getClaveExcep())) {
				isExcepcion = true;
				respuesta.setFlujo(NumerosConstants.INT_CERO);
			}
			pdf.setFolio(folioPadre.getChFolio());
			pdf.setIdFolio(folioHijo.getIdFolioPulssar());
			pdf.setExcepcion(isExcepcion);
			pdf.setImagenFirma(ExpresionesConstants.VACIO);
			pdf.setMotivos(respuesta.getMensaje());
			pdf.setImagenFirmaEmpleado(ExpresionesConstants.VACIO);
			String documentoAcuseImagen = this.obtenerDocumentoAcuse(datosExpediente, user, flujo, pdf);
			
			RespuestaServicio respuestaServicio = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.ACUSE_BIOMETRICO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CERO, null);
			respuesta.setTitulo(respuestaServicio.getTitulo());
			respuesta.setMensaje(respuestaServicio.getMensaje());
			model.addObject(ParametrosConstants.DOCUMENTO_ACUSE, documentoAcuseImagen);
//			if(documentoAcuseImagen.size() > NumerosConstants.INT_UNO.intValue()) {
//				model.addObject(ParametrosConstants.DOCUMENTO_ACUSE_EXCEPCION, documentoAcuseImagen.get(NumerosConstants.INT_UNO));
//			}
			model.addObject(ParametrosConstants.BANDERA_EXCEPCION, isExcepcion);
			FolioEntrada auxiliar = new FolioEntrada();
			auxiliar.setFolio(folioHijo.getChFolio());
			
			model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, auxiliar);
			
			request.getSession().setAttribute(ParametrosConstants.HUELLAS_EXCEPCION, respuesta.getRespuesta());
			request.getSession().setAttribute(ParametrosConstants.PDF_ENTRADA_SESION, pdf);
			
			List<Parametro> lparametro = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_URI_IE);
			if(lparametro.size() > 0) {
				String uriIE = utileriaValidador.obtenerValorParametro(lparametro, AgenteConstants.CHPARAMETRO_IE_URI, ExpresionesConstants.VACIO);
				String clsid = utileriaValidador.obtenerValorParametro(lparametro, AgenteConstants.CHPARAMETRO_IE_CLSID, ExpresionesConstants.VACIO);
				
				model.addObject("urlIE", uriIE);
				model.addObject("clsid", clsid);
			}
			
			List<Parametro> lEjecucionJava = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_EJECUCION_JAVA_LAUNCHER);
			if(lEjecucionJava.size() > 0) {
				String launcher = utileriaValidador.obtenerValorParametro(lEjecucionJava, AgenteConstants.CH_FLAG_LAUNCHER, ExpresionesConstants.VACIO);
				model.addObject("cambioJnlp", launcher);
			}
		} catch(Exception e) {
			logger.error("Error en la aplicacion de excepcion de toma de huellas biometrico", e);
		}
		
		agregarJnlp(user.getAforeUsuario(), model);
		
		model.addObject("respuesta", respuesta);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		
		String webSocket = webSocketProcesar;
		if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			webSocket = webSocketCoppel;
		}
		logger.info("socket ::: {} ", webSocket);
		model.addObject("socket", webSocket);
		
		return model;
	}
	
	/**
	 * Metodo para agregar el jnlp a la pagina
	 * 
	 * @param afore
	 */
	private void agregarJnlp(String afore, ModelAndView model) {
		List<Parametro> parametroJNLP = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.PARAMETRO_URI_JNLP);
		String jnlpAfore = utileriaValidador.obtenerValorParametro(parametroJNLP, afore, jnlpHost);
		model.addObject("jnlpAfore", jnlpAfore);
	}
	
	/**
	 * Modelo para mostrar el documeto de acuse
	 * @param request
	 * @param flagsExpediente
	 * @return
	 */
	@RequestMapping(value = { "/datosTablet" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public TabletBanorte obtenerDatosTablet(HttpServletRequest request) {
		logger.info("Obteniendo datos para la tablet");
		TabletBanorte tablet = new TabletBanorte();
		try {
			EntradaModificacion entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			EntradaPermanencia entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			
			DatosIdenExpediente datosExpediente = obtenerObjetoDatosExpediente(trabajador, entradaModificacion, entradaPermanencia, flujo);
			Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
			
			tablet.setFolioPadre(folioPadre.getChFolio());
			tablet.setCurp(datosExpediente.getCurp());
			tablet.setNss(utileriaValidador.validarVacio(datosExpediente.getNss()) ? ExpresionesConstants.NSS_VACIO : datosExpediente.getNss());
			tablet.setClaveServicio(ServiciosConstants.TRAMITE_BIOMETRICO_TABLET);
			Integer tipoParentesco = Integer.parseInt(trabajador.getTipoSolicitante());
			tablet.setTipoParentesco(String.valueOf(tipoParentesco));
			tablet.setTramitePresencial(ServiciosConstants.TRAMITE_NO_PRESENCIAL);
		} catch(Exception e) {
			logger.error("Error en la aplicacion de excepcion de toma de huellas biometrico", e);
		}
		return tablet;
	}
	
	/**
	 * Metodo que genera el pdf de solicitud de modificacion de datos
	 * @param datosModificacion
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = { "/recuperaAcuseFirmado.do" }, method = {RequestMethod.POST}, consumes = {"application/json"} ,  produces = { "application/json" })
	@ResponseBody
	public DatosSolicitud recuperarAcuseFirmado(@RequestBody RecepcionImagenes recepcionImagenes, HttpServletRequest request,Model model) throws IOException{
		logger.info("recepcion recuperarImagenesFirmas: {}",recepcionImagenes);
		DatosSolicitud datosSolicitud = null;
		try {
			datosSolicitud = biometricoService.recuperarFirmasProceso(recepcionImagenes);
			logger.info("Obtiene la firma del acuse banorte ::: {}", datosSolicitud);
		}catch (Exception e) {
			logger.error("Ocurrio un problema en recuperarImagenesFirma acuse: {}",e);
				datosSolicitud = new DatosSolicitud();
				datosSolicitud.setMensaje("Ha ocurrido un problema en la recuperacion de firma acuse");
		}
		return datosSolicitud;
	}
	
	/**
	 * Metodo encargado de obtener el objeto mapeado con los valores
	 * 
	 * @param trabajador
	 * @param entradaModificacion
	 * @param entradaPermanencia
	 * @param flujo
	 * @return
	 */
	private DatosIdenExpediente obtenerObjetoDatosExpediente(DatosTrabajador trabajador, EntradaModificacion entradaModificacion, EntradaPermanencia entradaPermanencia, FlujoModificacion flujo) {
		Object auxiliar = entradaModificacion;
		if(utileriaValidador.validarObjetoNulo(auxiliar)) {
			auxiliar = entradaPermanencia;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = trabajador;
			}
		}
		return servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/firmaCapturada.do" }, method = {RequestMethod.POST},consumes = {"application/json"} ,  produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio ejecutarFirmaPdf( @RequestBody LinkedHashMap<String,Object> parametros, HttpServletRequest request) {		
		logger.info("Iniciando proceso de generacion de PDF y obtenecion de Imagen de PDF con firma Expediente Biometrico");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		Folio folioEntrada = null;
		FlujoModificacion flujo = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			folioEntrada = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			EntradaPDF entradaPdf = (EntradaPDF) request.getSession().getAttribute(ParametrosConstants.PDF_ENTRADA_SESION);
			
			entradaPdf.setImagenFirma((String) parametros.get("response"));
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			DatosIdenExpediente datosExpediente = obtenerObjetoDatosExpediente(trabajador, entradaModificacion, entradaPermanencia, flujo);
			
			logger.info("Valores {}", folioEntrada.toString());
			logger.info("Valores PDF {}", entradaPdf.toString());
			String documentoAcuseImagen = this.obtenerDocumentoAcuse(datosExpediente, user, flujo, entradaPdf);
			respuesta.setMensaje(documentoAcuseImagen);
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		return respuesta;
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/firmaExcepcion.do" }, method = {RequestMethod.POST},consumes = {"application/json"} ,  produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio ejecutarFirmaExcepcion(@RequestBody LinkedHashMap<String,Object> parametros, HttpServletRequest request) {
		logger.info("Iniciando proceso de generacion de PDF y obtenecion de Imagen de PDF con firma Expediente Biometrico");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		Folio folioEntrada = null;
		FlujoModificacion flujo = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			folioEntrada = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			EntradaPDF entradaPdf = (EntradaPDF) request.getSession().getAttribute(ParametrosConstants.PDF_ENTRADA_SESION);
			
			entradaPdf.setImagenFirma((String) parametros.get("resFirTrab"));
			entradaPdf.setImagenFirmaEmpleado((String) parametros.get("resFirAgen"));
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			DatosIdenExpediente datosExpediente = obtenerObjetoDatosExpediente(trabajador, entradaModificacion, entradaPermanencia, flujo);
			
			logger.info("Valores {}", folioEntrada.toString());
			logger.info("Valores PDF {}", entradaPdf.toString());
			String documentoAcuseImagen = this.obtenerDocumentoAcuse(datosExpediente, user, flujo, entradaPdf);
			
			respuesta.setMensaje(documentoAcuseImagen);
			respuesta.setDatos(documentoAcuseImagen);
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		return respuesta;
	}
	
	/**
	 * Vista para la obtencio de la firma en el acuse
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/obtenerDato.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaBase validarRespuestaHuellas(HttpServletRequest request, @RequestParam("tipo") String tipo, @RequestParam("proceso") String proceso) {
		logger.info("Se realiza la peticion para la captura de las huellas");
		RespuestaBase respuesta = new RespuestaBase();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			
			String curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosCertificables().getCurp(), "");
			String nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getNss(), "");
			Object auxiliar = entradaModificacion;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			if(!utileriaValidador.validarObjetoNulo(datosExpediente)) {
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCurp(), "");
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNss(), "");
			}
			
			if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
				Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
				Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
				
				EntradaBiometricoCoppel peticion = new EntradaBiometricoCoppel();
				peticion.setNss(nss);
				peticion.setCurp(curp);
				peticion.setTipoPersona(tipo);
				peticion.setTipoToma(proceso);
				peticion.setFolioProcesar(folioPadre.getChFolio());
				respuesta.setRespuesta(peticion);
			} else {
				EntradaHuella entrada = new EntradaHuella();
				entrada.setCurp(curp);
				entrada.setTipo(tipo);
				if(user.getAforeUsuario().equals(ParametrosConstants.VALOR_BANORTE)) {
					Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
					Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
					
					entrada.setCurpEmpleado(user.getCurpAgente());
					entrada.setFolio(folioPadre.getChFolio());
				} else {
					
					entrada.setServicio(ServiciosConstants.BIOMETRICO_TEN);
					entrada.setCalidad(null);
				}
				JsonUtilsImpl<EntradaHuella> utileriaJson = new JsonUtilsImpl<>();
				String datoJson = utileriaJson.parseObjectToJson(entrada);
				if(ParametrosConstants.VALOR_BANORTE.equals(user.getAforeUsuario())) {
					datoJson = StringUtils.replace(datoJson, "\"", "'");
				}
				respuesta.setMensaje(datoJson);
			}
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			RespuestaServicio respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			respuesta.setFlujo(respuestaServicio.getFlujo());
			respuesta.setMensaje(respuestaServicio.getMensaje());
			respuesta.setTitulo(respuestaServicio.getTitulo());
		}
		
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
		
		return respuesta;
	}
	
	/**
	 * Vista para la obtencio de la firma en el acuse
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/rHuellasMDBiometrico.do" }, method = {RequestMethod.POST})
	public ModelAndView obtenerRespuestaHuellasMDBiometrico(HttpServletRequest request, @ModelAttribute Expediente flagsExpediente) {
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		logger.info("Iniciando proceso Biometrico");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			
			Object auxiliar = entradaModificacion;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			String curp = datosExpediente.getCurp();
			
			model = obtenerVistaBiometrico(flagsExpediente, curp, user, folioHijo);
			model.addObject(ParametrosConstants.REDIRECCIONAMIENTO, ParametrosConstants.CONTINUAR_MODIFICACION);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
		
		return model;
	}
	
	/**
	 * Vista para la obtencio de la firma en el acuse
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/rHuellasBiometrico.do" }, method = {RequestMethod.POST})
	public ModelAndView obtenerRespuestaHuellasBiometrico(HttpServletRequest request, @ModelAttribute Expediente flagsExpediente) {
		logger.info("Iniciando proceso Biometrico Modificacion de Datos");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		logger.info("Iniciando proceso Biometrico");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			
			model = obtenerVistaBiometrico(flagsExpediente, trabajador.getDatosCertificables().getCurp(), user, folioHijo);
			model.addObject(ParametrosConstants.REDIRECCIONAMIENTO, ParametrosConstants.METODO_MENU);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		return model;
	}
	
	/**
	 * Vista generacion de expediente Biometrico
	 * a partir de modificación de datos
	 */
	@RequestMapping(value="/conformaIdentificacion.do", method = RequestMethod.GET)
	public ModelAndView inicioExpedienteIdentificacionModificacion(HttpServletRequest request, Model model) {
		logger.info("Inicio de Expediente Identificacion desde modificacion de datos");
		ModelAndView modelAndView = new ModelAndView(NavegacionEnum.EXPEDIENTE_IDENTIFICACION.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		EntradaModificacion entradaModificacion = null;
		FlujoModificacion flujo = null;
		EntradaPermanencia entradaPermanencia = null;
		FolioEntrada folioSesion = null;
		Parametro parametro = null;
		EntradaRecepcionImagenes entradaRecepcion = new EntradaRecepcionImagenes();
		DatosTrabajador trabajador = null;
		String indicadorRfc = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			folioSesion = (FolioEntrada)request.getSession().getAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			
			Object auxiliar = entradaModificacion;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			

			parametro = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_INTENTOS_CONSULTA_IMAGENES);
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			modelAndView = this.obtenerModelIdentificacion(folioSesion, datosExpediente, user, request, 
					ServiciosConstants.DESCRIPCION_SERVICIO_MDIDENTIFICACION, ServiciosConstants.FOLIO_SERVICIO_MODIFICACION_DATOS, ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION);
			indicadorRfc = servicioExpediente.obtenerIndicadorRfc(entradaModificacion, entradaPermanencia, trabajador.getDatosNoCertificables());
		}  catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
		request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION, folioSesion);
		
		modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, user);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuesta);
		model.addAttribute("entradaRecepcionImagenes",entradaRecepcion);
		model.addAttribute("intentos", parametro);
		model.addAttribute("ambienteBanorte", ambiente);
		model.addAttribute("agente", user.getUsuario());
		model.addAttribute("cambioRfc", indicadorRfc);

		modelAndView.addObject(ParametrosConstants.FLUJO_FUNCION, ParametrosConstants.CONTINUAR_MODIFICACION);
		
		return modelAndView;
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/expedienteIdentificacion.do", method = RequestMethod.GET)
	public ModelAndView ejecutarExpedienteIdentificacion(HttpServletRequest request, Model model) {
		logger.info("Iniciando proceso de Expediente Identificacion");
		ModelAndView modelAndView = new ModelAndView(NavegacionEnum.EXPEDIENTE_IDENTIFICACION.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		Parametro parametro = null;
		EntradaRecepcionImagenes entradaRecepcion = new EntradaRecepcionImagenes();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			
			logger.error("Estatus Expediente Identificacion: {}", trabajador.getDatosExpediente().getEstatusExpedienteIdentificacion());
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(trabajador, flujo);
			datosExpediente = servicioExpediente.obtenerDatosExpediente(datosExpediente, trabajador);
			logger.info("Validar Renapo Domicilio: {}",datosExpediente);
			
			respuesta = this.validarRenapoDomicilio(trabajador.getRenapo(), datosExpediente, user.getAforeUsuario(),trabajador.getDatosExpediente());
			parametro = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_INTENTOS_CONSULTA_IMAGENES);

			logger.error("Expediente Identificacion Flujo: {}", respuesta.getFlujo());
			
			if(NumerosConstants.INT_TRES != respuesta.getFlujo()) {
				modelAndView = this.obtenerModelIdentificacion(null, datosExpediente, user, request, 
						ServiciosConstants.DESCRIPCION_SERVICIO_IDENTIFICACION, ServiciosConstants.FOLIO_SERVICIO_IDENTIFICACION, ServiciosConstants.FOLIO_PROCESO_IDENTIFICACION);
				modelAndView.addObject(ParametrosConstants.TRABAJADOR, trabajador);
			}
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, user);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuesta);
		model.addAttribute("entradaRecepcionImagenes",entradaRecepcion);
		model.addAttribute("intentos", parametro);
		model.addAttribute("ambienteBanorte", ambiente);
		model.addAttribute("agente", user.getUsuario());
		modelAndView.addObject(ParametrosConstants.FLUJO_FUNCION, ParametrosConstants.METODO_MENU);
		
		
		
		return modelAndView;
	}
	
	/**
	 * Controlador encargado de capturar archivos
	 * @param request
	 */
	@RequestMapping(value = "/enviarIdentificacion.do", method = RequestMethod.POST)
	public ModelAndView capturarArchivos(HttpServletRequest request, MultipartHttpServletRequest requestMultipart) {
		logger.info("Iniciando Recepcion Archivos Expediente Identificacion");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_IDENTIFICACION.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		FlujoModificacion flujo = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			Folio folioEntrada = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			String folioDocumentos = (String) request.getSession().getAttribute(ParametrosConstants.FOLIO_DOCUMENTOS);
			String tipoTrabajador = (String) request.getSession().getAttribute(ParametrosConstants.TIPO_TRABAJADOR);
			
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			request.getSession().removeAttribute(ParametrosConstants.FOLIO_DOCUMENTOS);
			request.getSession().removeAttribute(ParametrosConstants.TIPO_TRABAJADOR);
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			
			Object auxiliar = entradaModificacion;
			String flujoIdentificacion = ParametrosConstants.CONTINUAR_MODIFICACION;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = trabajador;
				flujoIdentificacion = ParametrosConstants.METODO_MENU;
			}
			
			model.addObject(ParametrosConstants.FLUJO_FUNCION, flujoIdentificacion);
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			datosExpediente = servicioExpediente.obtenerDatosExpediente(datosExpediente, auxiliar);
			String radioTipoTrabajador = request.getParameter("tipo");
			if(!utileriaValidador.validarVacio(radioTipoTrabajador)) {
				tipoTrabajador = radioTipoTrabajador;
			}
			EntradaSolicitante entradaSolicitante = (EntradaSolicitante) request.getSession().getAttribute(ParametrosConstants.ENTRADA_SOLICITANTE);

			Map<String, Map<String, MultipartFile>> arregloArchivos = new HashMap<>();
			List<Combo> docs = service.obtenerTipoDocumento(servicioExpediente.obtenerProcesoExpediente(datosExpediente.getTipoSolicitante()), user.getAforeUsuario());
			arregloArchivos = utileriaArchivos.obtenerDocumentos(docs, requestMultipart.getFileMap(), arregloArchivos);
			
			FolioComplemento folioComp = new FolioComplemento();
			folioComp.setIdFolio(folioEntrada.getIdFolioPulssar());
			folioComp.setTipoTrabajador(tipoTrabajador);
			String agente = utileriaValidador.validarVacio(user.getUsuarioAgente()) ? user.getUsuario() : user.getUsuarioAgente();
			folioComp.setAgentePromotor(agente);
			folioComp.setFechaControl(new Date());
			folioComp.setUsuarioModificador(user.getUsuario());
			folioComp.setApellioPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getApellidoPaterno(), null));
			folioComp.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getApellidoMaterno(), null));
			folioComp.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNombre(), null));
			folioComp.setCalle(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCalle(), null));
			folioComp.setNumeroExterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNoExterior(), null));
			folioComp.setNumeroInterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNoInterior(), null));
			folioComp.setColonia(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getColonia(), null));
			folioComp.setMunicipio(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getMunicipio(), null));
			folioComp.setCodigo(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCodigoPostal(), null));
			folioComp.setEntidadFederativa(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getEntidadFed(), null));
			folioComp.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCurp(), null));
			folioComp.setTipoSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getTipoSolicitante(), null));
			folioComp.setCurpSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCurpSolicitante(), null));
			if(!utileriaValidador.validarObjetoNulo(flujo)) {
				folioComp.setFolioProcesarOrigen(utileriaCadena.obtenerContenidoCadenaSinEspacios(flujo.getFolioPulssarOrigen(), null));
			}
			servicioArchivos.guardarDatosFolioComplementario(folioComp);
			
			if(!"01".equals(trabajador.getTipoSolicitante())) {
				FolioComplemento folioComplementoSolicitante = servicioExpediente.obtenerDatosSolicitanteExpediente(entradaSolicitante, folioEntrada, tipoTrabajador, user,datosExpediente.getCurp());
				servicioArchivos.guardarDatosFolioComplementario(folioComplementoSolicitante);

			}
			
			EnvioArchivos datosRecepcion = new EnvioArchivos();
			datosRecepcion.setClaveAfore(user.getAforeUsuario());
			datosRecepcion.setCurpEmpleado(user.getCurpAgente());
			datosRecepcion.setCurpTrabajador(datosExpediente.getCurp());
			datosRecepcion.setFolio(folioEntrada.getChFolio());
			datosRecepcion.setFolioIdentificacion(folioDocumentos);
			datosRecepcion.setProceso(servicioExpediente.obtenerProcesoExpediente(datosExpediente.getTipoSolicitante()));
			datosRecepcion.setTipoArchivo(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			datosRecepcion.setTipoTrabajador(tipoTrabajador);
			
			respuesta = servicioArchivos.verificarArchivos(folioEntrada, arregloArchivos, datosRecepcion, docs, null);
			if(NumerosConstants.INT_UNO.intValue() == respuesta.getFlujo().intValue()) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CINCO, null);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_06);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.FINALIZA_CONFORMACION_EXPEDIENTE.getClave());
				request.getSession().setAttribute(ParametrosConstants.DATO_BUCLE, NumerosConstants.C_UNO);
			}
			
			String auxiliarTipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, datosExpediente.getTipoAfiliacion());
			model.addObject(ParametrosConstants.FOLIO_DOCUMENTO, folioDocumentos);
			model.addObject(ParametrosConstants.PARAMETRO_TIPO_TRABAJADOR, auxiliarTipoTrabajador);
			request.getSession().setAttribute(ParametrosConstants.TIPO_TRABAJADOR, tipoTrabajador);
			request.getSession().setAttribute(ParametrosConstants.FOLIO_DOCUMENTOS, folioDocumentos);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioEntrada);
			
			if(!utileriaValidador.validarObjetoNulo(flujo)) {
				flujo.setFolioIdentificacion(folioEntrada);
				flujo.setBanderaIdentificacion(NumerosConstants.C_UNO);
				String flujoValor = NumerosConstants.C_UNO;
				if(NumerosConstants.INT_UNO != respuesta.getFlujo()) {
					flujoValor = NumerosConstants.C_DOS;
				}
				flujo.setBanderaRespuestaIdentificacion(flujoValor);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, NumerosConstants.C_DOS);
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
				request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
				request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
			}
			model.addObject(ParametrosConstants.TRABAJADOR, trabajador);
		} catch(Exception e) {
			logger.error("Se presento un problema al capturar archivos ", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		model.addObject("respuesta", respuesta);
		return model;
	}
	
	
	/**
	 * Controlador encargado del envio de archivos Digitalizados para
	 * conformación de Expediente
	 * @param request
	 * @param model
	 * @param wrapper
	 * @return
	 */
	@RequestMapping(value = "/enviarIdentificacionDigitalizacion.do", method = RequestMethod.POST)
	public ModelAndView capturarArchivosDigitalizacion(HttpServletRequest request, Model model) {
		logger.info("Iniciando Recepcion Archivos Expediente Identificacion Digitalizacion");
		ModelAndView modelAndView = new ModelAndView(NavegacionEnum.EXPEDIENTE_IDENTIFICACION.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		FlujoModificacion flujo = null;
		EntradaSolicitante entradaSolicitante = null;
		EntradaRecepcionImagenes entradaRecepcion = new EntradaRecepcionImagenes();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			Folio folioEntrada = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			String folioDocumentos = (String) request.getSession().getAttribute(ParametrosConstants.FOLIO_DOCUMENTOS);
			String tipoTrabajador = (String) request.getSession().getAttribute(ParametrosConstants.TIPO_TRABAJADOR);
			String rutaZip = (String) request.getSession().getAttribute("destinoArchivo");
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			entradaSolicitante = (EntradaSolicitante) request.getSession().getAttribute(ParametrosConstants.ENTRADA_SOLICITANTE);

			respuesta.setFlujo(NumerosConstants.INT_CERO);
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			request.getSession().removeAttribute(ParametrosConstants.FOLIO_DOCUMENTOS);
			request.getSession().removeAttribute(ParametrosConstants.TIPO_TRABAJADOR);
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			
			Object auxiliar = entradaModificacion;
			String flujoIdentificacion = ParametrosConstants.CONTINUAR_MODIFICACION;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = trabajador;
				flujoIdentificacion = ParametrosConstants.METODO_MENU;
			}
			
			modelAndView.addObject(ParametrosConstants.FLUJO_FUNCION, flujoIdentificacion);
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			datosExpediente = servicioExpediente.obtenerDatosExpediente(datosExpediente, auxiliar);
			String radioTipoTrabajador = (String) request.getSession().getAttribute(ParametrosConstants.SESSION_TIPO_TRABAJADOR_RADIO);
			if(!utileriaValidador.validarVacio(radioTipoTrabajador)) {
				tipoTrabajador = radioTipoTrabajador;
			}
			
			FolioComplemento folioComp = new FolioComplemento();
			folioComp.setIdFolio(folioEntrada.getIdFolioPulssar());
			folioComp.setTipoTrabajador(tipoTrabajador);
			String agente = utileriaValidador.validarVacio(user.getUsuarioAgente()) ? user.getUsuario() : user.getUsuarioAgente();
			folioComp.setAgentePromotor(agente);
			folioComp.setFechaControl(new Date());
			folioComp.setUsuarioModificador(user.getUsuario());
			folioComp.setApellioPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getApellidoPaterno(), null));
			folioComp.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getApellidoMaterno(), null));
			folioComp.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNombre(), null));
			folioComp.setCalle(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCalle(), null));
			folioComp.setNumeroExterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNoExterior(), null));
			folioComp.setNumeroInterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNoInterior(), null));
			folioComp.setColonia(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getColonia(), null));
			folioComp.setMunicipio(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getMunicipio(), null));
			folioComp.setCodigo(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCodigoPostal(), null));
			folioComp.setEntidadFederativa(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getEntidadFed(), null));
			folioComp.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCurp(), null));
			folioComp.setTipoSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getTipoSolicitante(), null));
			folioComp.setCurpSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCurpSolicitante(), null));
			if(!utileriaValidador.validarObjetoNulo(flujo)) {
				folioComp.setFolioProcesarOrigen(utileriaCadena.obtenerContenidoCadenaSinEspacios(flujo.getFolioPulssarOrigen(), null));
			}
			servicioArchivos.guardarDatosFolioComplementario(folioComp);
			if(!"01".equals(trabajador.getTipoSolicitante())) {
				FolioComplemento folioComplementoSolicitante = servicioExpediente.obtenerDatosSolicitanteExpediente(entradaSolicitante, folioEntrada, tipoTrabajador, user,datosExpediente.getCurp());
				
				servicioArchivos.guardarDatosFolioComplementario(folioComplementoSolicitante);

			}
			
			
			EnvioArchivos datosRecepcion = new EnvioArchivos();
			datosRecepcion.setClaveAfore(user.getAforeUsuario());
			datosRecepcion.setCurpEmpleado(user.getCurpAgente());
			datosRecepcion.setCurpTrabajador(datosExpediente.getCurp());
			datosRecepcion.setFolio(folioEntrada.getChFolio());
			datosRecepcion.setFolioIdentificacion(folioDocumentos);
			datosRecepcion.setProceso(servicioExpediente.obtenerProcesoExpediente(datosExpediente.getTipoSolicitante()));
			datosRecepcion.setTipoArchivo(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			datosRecepcion.setTipoTrabajador(tipoTrabajador);
			
			respuesta = servicioArchivos.enviarArchivosDigitalizados(folioEntrada, datosRecepcion, rutaZip);
			
			if(NumerosConstants.INT_UNO.intValue() == respuesta.getFlujo().intValue()) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CINCO, null);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_06);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.FINALIZA_CONFORMACION_EXPEDIENTE.getClave());
				request.getSession().setAttribute(ParametrosConstants.DATO_BUCLE, NumerosConstants.C_UNO);
			}
			
			String auxiliarTipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, datosExpediente.getTipoAfiliacion());
			modelAndView.addObject(ParametrosConstants.FOLIO_DOCUMENTO, folioDocumentos);
			modelAndView.addObject(ParametrosConstants.PARAMETRO_TIPO_TRABAJADOR, auxiliarTipoTrabajador);
			request.getSession().setAttribute(ParametrosConstants.TIPO_TRABAJADOR, tipoTrabajador);
			request.getSession().setAttribute(ParametrosConstants.FOLIO_DOCUMENTOS, folioDocumentos);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioEntrada);
			
			if(!utileriaValidador.validarObjetoNulo(flujo)) {
				flujo.setFolioIdentificacion(folioEntrada);
				flujo.setBanderaIdentificacion(NumerosConstants.C_UNO);
				String flujoValor = NumerosConstants.C_UNO;
				if(NumerosConstants.INT_UNO != respuesta.getFlujo()) {
					flujoValor = NumerosConstants.C_DOS;
				}
				flujo.setBanderaRespuestaIdentificacion(flujoValor);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, NumerosConstants.C_DOS);
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
				request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
				request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
			}
			
			modelAndView.addObject(ParametrosConstants.TRABAJADOR, trabajador);
		} catch(Exception e) {
			logger.error("Se presento un problema al capturar archivos ", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		model.addAttribute("entradaRecepcionImagenes",entradaRecepcion);
		modelAndView.addObject("respuesta", respuesta);
		return modelAndView;
	}
	
	/**
	 * Metodo encargado de obtener la vista de identifciacion
	 * 
	 * @param datosExpediente
	 * @param user
	 * @param request
	 * @return
	 */
	private ModelAndView obtenerModelIdentificacion(FolioEntrada folioSesion, DatosIdenExpediente datosExpediente, UsuarioLogin user, HttpServletRequest request, String desc, String servicio, String proceso) {
		logger.error("Entra a obtenerModelIdentificacion");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_IDENTIFICACION.getNavegacion());
		Folio folioPadre = null;
		String tipoProceso = servicioExpediente.obtenerProcesoExpediente(datosExpediente.getTipoSolicitante());
		Map<String, List<Combo>> docs = service.obtenerCombo(tipoProceso, user.getAforeUsuario(), null, null);
		
		String curp = datosExpediente.getCurp();
		String nss = datosExpediente.getNss();
		
		if(!utileriaValidador.validarObjetoNulo(folioSesion)) {
			curp = folioSesion.getCurp();
			nss = folioSesion.getNss();
		}
		
		EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
		String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
		
		FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(curp, nss, 
				desc, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
		Folio folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), sucursal, 
				servicio, proceso);
		if(!utileriaValidador.validarObjetoNulo(folioHijo)) {
			folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
		}
		
		FolioEntrada auxiliar = new FolioEntrada();
		auxiliar.setFolio(folioHijo.getChFolio());
		
		String tipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, datosExpediente.getTipoAfiliacion());
		String folioDocumento = servicioExpediente.obtenerValoresPantalla(folioHijo.getChFolio(), null);
		
		model.addObject("obligatorios", docs.get("obligatorios"));
		model.addObject("noObligatorios", limpiarComboFirmaPEIS(docs.get("noObligatorios"), user.getAforeUsuario()));
		model.addObject(ParametrosConstants.FOLIO_DOCUMENTO, folioDocumento);
		model.addObject(ParametrosConstants.PARAMETRO_TIPO_TRABAJADOR, tipoTrabajador);
		model.addObject("expediente", datosExpediente);
		model.addObject("folio", auxiliar);
		model.addObject("folioPadre", folioPadre);
		model.addObject("tipoSolicitante", datosExpediente.getTipoSolicitante());
		model.addObject("tipoProceso", tipoProceso);
		model.addObject("nssProceso", datosExpediente.getNss());
		model.addObject("curpProceso", datosExpediente.getCurp());
		model.addObject("curpSolicitante", datosExpediente.getCurpSolicitante());

		
		request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
		request.getSession().setAttribute(ParametrosConstants.TIPO_TRABAJADOR, tipoTrabajador);
		request.getSession().setAttribute(ParametrosConstants.FOLIO_DOCUMENTOS, folioDocumento);
		
		return model;
	}
	
	/**
	 * Metodo encargado de limpiar los datos opcionales
	 * 
	 * @param lstOpcional
	 * @param cvAfore
	 * @return
	 */
	private List<Combo> limpiarComboFirmaPEIS(List<Combo> lstOpcional, String cvAfore) {
		List<Combo> lsComboOpcional = new ArrayList<>();
		
		if(PdfConstants.PEIS.equals(cvAfore)) {
			for(Combo combo : lstOpcional) {
				if(!ServiciosConstants.DATOS_FIRMA.contains(combo.getClave())) {
					lsComboOpcional.add(combo);
				}
			}
		} else {
			lsComboOpcional = new ArrayList<>(lstOpcional);
		}
		return lsComboOpcional;
	}
	
	/**
	 * Metodo encargado de obtener la vista del Biometrico
	 * @param request
	 * @param flagsExpediente
	 * @param curp
	 * @param user
	 * @param folioHijo
	 * @return
	 */
	private ModelAndView obtenerVistaBiometrico(Expediente flagsExpediente, String curp, UsuarioLogin user, Folio folioHijo) {
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			huellasServicio.procesarHuellasRecibidas(user, folioHijo, flagsExpediente, curp, ServiciosConstants.CLAVE_HUELLAS_DIGITALES, null);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_NOVENTAYOCHO, null);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Controlador Ajax para validar la respuesta del envio de huellas
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/validarHuellasRespuesta.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarRespuestaHuellas(HttpServletRequest request, @RequestParam("servicio") String servicio) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			respuesta.setFlujo(NumerosConstants.INT_TRES);
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			if(folioHijo != null) {
				respuesta = validarRespuestaHuellasMapeada(respuesta, request, servicio, folioHijo);
			} else {
				respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
			}
			
			if(respuesta.getFlujo().intValue() == NumerosConstants.INT_DOS.intValue()) {
				String redirec = (String) request.getSession().getAttribute("redirecHuellas");
				respuesta.setDatos(redirec);
				FlujoModificacion flujoMod = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
				String fMod = (String) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD);
				if(!utileriaValidador.validarObjetoNulo(flujoMod) && !utileriaValidador.validarObjetoNulo(fMod)) {
					if(NumerosConstants.C_UNO.equals(fMod)) {
						flujoMod.setBanderaRespuestaEnrolamiento("G001");
					} else if(NumerosConstants.C_DOS.equals(fMod)) {
						flujoMod.setBanderaRespuestaIdentificacion("G001");
					} else {
						flujoMod.setBanderaRespuestaSelloTrabajador("G001");
					}
					
					request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoMod);
					request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, fMod);
				}
			}
		} catch(Exception e) {
			logger.error("Exception en executeUsuario >>", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar las huellas mapeadas
	 * 
	 * @param respuesta
	 * @param request
	 * @param servicio
	 * @param folioHijo
	 */
	private RespuestaServicio validarRespuestaHuellasMapeada(RespuestaServicio respuesta, HttpServletRequest request, String servicio, Folio folioHijo) {
		RespuestaServicio respuestaMapeo = respuesta;
		RespuestaServicio respuestaHuellas = huellasServicio.validarRespuestaFolio(folioHijo.getChFolio());
		
		if(!utileriaValidador.validarObjetoNulo(respuestaHuellas)) {
			RespuestaServicio respuestaAuxiliarHuellas = validarRespuestaTipoServicio(respuestaHuellas, servicio, folioHijo, request);
			respuestaMapeo = respuestaAuxiliarHuellas;
		}
		return respuestaMapeo;
	}
	
	/**
	 * Metodo encargado de validar las respuesta de la huella
	 * 
	 * @param respuestaHuellas
	 * @param servicio
	 * @param folioHijo
	 * @param request
	 * @return
	 */
	private RespuestaServicio validarRespuestaTipoServicio(RespuestaServicio respuestaHuellas, String servicio, Folio folioHijo, HttpServletRequest request) {
		RespuestaServicio auxiliarHuellas = respuestaHuellas;
		if(NumerosConstants.C_UNO.equals(servicio)) {
			validarServicioUno(request, auxiliarHuellas, folioHijo);
		} else if(NumerosConstants.C_DOS.equals(servicio)) {
			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_4);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_08);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.FINALIZA_VERIFICACION_TRABAJADOR.getClave());
			request.getSession().setAttribute(ParametrosConstants.DATO_BUCLE, NumerosConstants.C_UNO);
			if(auxiliarHuellas.getFlujo().intValue() == NumerosConstants.INT_DOS.intValue()) {
				auxiliarHuellas.setDatos("consultaTrabajador.do");
			}
		}
		return auxiliarHuellas;
	}
	
	/**
	 * Validar servicio uno en la respuesta de huellas
	 * 
	 * @param request
	 * @param respuestaHuellas
	 * @param folioHijo
	 */
	private void validarServicioUno(HttpServletRequest request, RespuestaServicio respuestaHuellas, Folio folioHijo) {
		FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		
		if(!utileriaValidador.validarObjetoNulo(flujo)) {
			flujo.setFolioEnrolamiento(folioHijo);
			flujo.setBanderaEnrolamiento(NumerosConstants.C_UNO);
			flujo.setBanderaRespuestaEnrolamiento((NumerosConstants.INT_UNO.intValue() == respuestaHuellas.getFlujo().intValue()) ? NumerosConstants.C_UNO : NumerosConstants.C_DOS);
			request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
		}
		
		request.getSession().setAttribute(ParametrosConstants.DATO_BUCLE, NumerosConstants.C_UNO);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, NumerosConstants.C_UNO);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, ServiciosConstants.CLAVE_HUELLAS_DIGITALES);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_09);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.EXPEDIENTE_ENROLAMIENTO_ENVIADO.getClave());
	}
	
	/**
	 * Metodo encargado de obtener el documento del Acuse
	 * 
	 * @param nombre
	 * @param curp
	 * @param afore
	 * @param isResize
	 * @param isConsentimiento
	 * @return
	 */
	private String obtenerDocumentoAcuse(DatosIdenExpediente datosExpediente, UsuarioLogin user, FlujoModificacion flujo, EntradaPDF auxiliar) {
		logger.info("Creando PDF >>> {} : {} : {} ", datosExpediente, user, auxiliar.getIdFolio());
		EntradaPDF entradaPDF = auxiliar;
		if(!utileriaValidador.validarObjetoNulo(datosExpediente)) {
			entradaPDF.setCurp(datosExpediente.getCurp());
			entradaPDF.setNombreTrabajador(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
					 utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
					 utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getApellidoMaterno(), ExpresionesConstants.VACIO)));
			entradaPDF.setCvAfore(user.getAforeUsuario());
			entradaPDF.setClaveAgente(user.getUsuario());
			entradaPDF.setNombreAgente(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(user.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
					 utileriaCadena.obtenerContenidoCadenaSinEspacios(user.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
					 utileriaCadena.obtenerContenidoCadenaSinEspacios(user.getApellidoMaterno(), ExpresionesConstants.VACIO)));
		}
		
		boolean isConsentimiento = false;
		if(!utileriaValidador.validarVacio(entradaPDF.getImagenFirma())) {
			logger.info("Con firma {} {} {} ", entradaPDF.getNombreTrabajador(), entradaPDF.getCurp(), entradaPDF.getCvAfore());
			isConsentimiento = true;
		}
		entradaPDF.setConsentimiento(isConsentimiento);
		
		return biometricoService.generarAcuseBiometrico(entradaPDF);
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/finalizaEnrolamiento.do", method = {RequestMethod.GET,  RequestMethod.POST})
	public ModelAndView ejecutarFinProceso(HttpServletRequest request) {
		logger.info("Iniciando proceso Expediente Biometrico");
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_BIOMETRICO.getNavegacion(), "expeBiom", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		DatosTrabajador trabajador = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			EntradaModificacion entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			EntradaPermanencia entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			DatosIdenExpediente datosExpediente = obtenerObjetoDatosExpediente(trabajador, entradaModificacion, entradaPermanencia, flujo);
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			HuellasDactilares objHuellas = (HuellasDactilares)request.getSession().getAttribute(ParametrosConstants.HUELLAS_EXCEPCION);
			
			request.getSession().setAttribute(ParametrosConstants.DATO_BUCLE, NumerosConstants.C_CERO);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, NumerosConstants.C_UNO);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, ServiciosConstants.CLAVE_HUELLAS_DIGITALES);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_09);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.EXPEDIENTE_ENROLAMIENTO_ENVIADO.getClave());
			
			String redireccion = ParametrosConstants.METODO_MENU;
			if(entradaModificacion != null || entradaPermanencia != null || flujo != null) {
				redireccion = ParametrosConstants.CONTINUAR_MODIFICACION;
			}
			model.addObject(ParametrosConstants.REDIRECCIONAMIENTO, redireccion);
			
			huellasServicio.procesarHuellasRecibidas(user, folioHijo, null, datosExpediente.getCurp(), ServiciosConstants.CLAVE_HUELLAS_DIGITALES, objHuellas);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_NOVENTAYOCHO, null);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Metodo encargado de validar los datos antes de un
	 * @param renapoTrab
	 * @param domParticular
	 * @return
	 */
	private RespuestaServicio validarRenapoDomicilio(Renapo renapoTrab, DatosIdenExpediente datosTrabajador, String claveAfore, DatosExpediente datosExpediente) {
		String clave = MensajesExitoEnum.CONFIRMACION_EXPEDIENTE.getClave();
		Integer flujo = NumerosConstants.INT_UNO;
		if(ServiciosConstants.PROCESO_TIPO_SOLICITANTE_TITULAR.equals(datosTrabajador.getTipoSolicitante())) {
			flujo = NumerosConstants.INT_CUATRO;
			List<String> banderasRenapo = new ArrayList<>();
			banderasRenapo.add(renapoTrab.getBanderaCurp().toString());
			banderasRenapo.add(renapoTrab.getBanderaNombre().toString());
			banderasRenapo.add(renapoTrab.getBanderaGenero().toString());
			banderasRenapo.add(renapoTrab.getBanderaFechaNacimiento().toString());
			banderasRenapo.add(renapoTrab.getBanderaEntidadNacimiento().toString());
			
			List<String> estatusTransito = new ArrayList<>();
			estatusTransito.add(NumerosConstants.C_TRES);
			
				/** Valida Estatus Expediente Identificacion sea Distinto de  2 y 3**/
			if(!estatusTransito.contains(datosExpediente.getEstatusExpedienteIdentificacion())) {
				
				if(banderasRenapo.contains(NumerosConstants.INT_UNO.toString())) {
					clave = MensajesExitoEnum.EXPEDIENTE_DIFERENCIAS_RENAPO.getClave();
					flujo = NumerosConstants.INT_TRES;
				} else if(utileriaValidador.validarVacio(datosTrabajador.getCalle())) {
					clave = MensajesExitoEnum.EXPEDIENTE_SIN_DOMICILIO.getClave();
					flujo = NumerosConstants.INT_TRES;
				} 
				
			}else {
				clave = MensajesExitoEnum.EXPEDIENTE_TRANS_TEMP.getClave();
				flujo = NumerosConstants.INT_DOS;
			}
		}
		
		return servicioCatalogo.obtenerRespuesta(null, clave, claveAfore, flujo, null);
	}

	

}