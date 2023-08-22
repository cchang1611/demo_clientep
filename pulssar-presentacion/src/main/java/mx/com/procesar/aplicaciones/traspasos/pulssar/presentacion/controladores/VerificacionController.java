package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HuellasService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VerificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ArchivosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.PosicionDedoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosHuellas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIdenExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosJasper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaBiometricoCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaHuella;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EstructuraHuellasCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaBase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHuellasCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JasperUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Controlador para el manejo de peticiones de la pagina inicial
 * 
 * @version 1.0
 * @since
 */
@Controller
@RequestMapping(value = {"/private"})
public class VerificacionController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(VerificacionController.class);
	
	/**
	 * Inyeccion de Servicio sello
	 */
	@Autowired
	private ConsultaSelloService servicioSello;
	
	/**
	 * Inyeccion de utileria Conversion
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria fecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Servicio de verificacion
	 */
	@Autowired
	private VerificacionService verificacionService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
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
	 * Inyeccion de servicio
	 */
	@Autowired
	private ConsultarPersonaCertificablesService servicioConsulta;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private ExpedienteService servicioExpediente;
	
	/**
	 * Servicio de Coppel
	 */
	@Autowired
	private CoppelService servicioCoppel;
	
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
	 * Servicio de huellas asincrono
	 */
	@Autowired
	private HuellasService huellasServicio;
	
	  /**
     * Inyeccion de service expediente
     */
    @Autowired
    private EstatusExpedienteService expedienteService;
    
    /**
	 * Variable consulta Recepcion arcvhios
	 */
	@Value("#{propiedades['url.consulta.archivo.recepcion']}")
	private String consultaRecepcionArchivo;
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion de utileria jasper
	 */
	@Autowired
	private JasperUtils utileriaJasper;
	
	/**
	 * Inyeccion de consulta persona servicio
	 */
	@Autowired
	private ConsultarPersonaCertificablesService servicioConsultaPersona;
	
	/**
	 * Vista de la verificacion de empleado
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = {"/verificarEmpleado.do"}, method = RequestMethod.GET)
	public ModelAndView validarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_EMPLEADO.getNavegacion(), "modelValida", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		boolean isRespuesta = false;
		try {
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.HUELLAS_EMPLEDO_CAPTURAR.getClave(), user.getAforeUsuario(), NumerosConstants.INT_TRES, null);
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			model = this.obtenerValoresSelloEmpleado(user.getCurpAgente(), user.getAforeUsuario(), model);
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			FolioActivo folioActivo = servicioFolio.consultarFolioActivo(user.getCurpAgente(), null, ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_1_HUELLA);
			if(folioActivo != null && !folioActivo.getFoliosHijo().isEmpty()) {
				servicioFolio.cerrarFolio(folioActivo.getFoliosHijo().get(NumerosConstants.INT_CERO).getIdFolioPulssar(), NumerosConstants.INT_TRES);
			}
			
			List<Parametro> lEjecucionJava = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_EJECUCION_JAVA_LAUNCHER);
			if(lEjecucionJava.size() > 0) {
				String launcher = utileriaValidador.obtenerValorParametro(lEjecucionJava, AgenteConstants.CH_FLAG_LAUNCHER, ExpresionesConstants.VACIO);
				model.addObject("cambioJnlp", launcher);
			}
			
			String webSocket = webSocketProcesar;
			if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
				webSocket = webSocketCoppel;
			}
			model.addObject("socket", webSocket);
			model.addObject("isEjecuta", "1");
			isRespuesta = validarRespuesta(model, "respuesta");
			agregarJnlp(user.getAforeUsuario(), model);
		} catch(Exception e) {
			logger.error("Error al al validar los datos del empleado par auna huella.", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute("redirecHuellas", "consultaTrabajador.do");
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		
		if(!isRespuesta) {
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		
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
	 * Vista de la verificacion de empleado
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = {"/verificarTrabajador.do"}, method = RequestMethod.GET)
	public ModelAndView validarTrabajador(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_TRABAJADOR.getNavegacion(), "modelValida", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		boolean isRespuesta = false;
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			FolioActivo folioActivo = servicioFolio.consultarFolioActivo(trabajador.getDatosCertificables().getCurp(), trabajador.getNss(), ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_4_HUELLAS);
			if(folioActivo != null && !folioActivo.getFoliosHijo().isEmpty()) {
				servicioFolio.cerrarFolio(folioActivo.getFoliosHijo().get(NumerosConstants.INT_CERO).getIdFolioPulssar(), NumerosConstants.INT_TRES);
			}
			
			List<Parametro> lEjecucionJava = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_EJECUCION_JAVA_LAUNCHER);
			if(lEjecucionJava.size() > 0) {
				String launcher = utileriaValidador.obtenerValorParametro(lEjecucionJava, AgenteConstants.CH_FLAG_LAUNCHER, ExpresionesConstants.VACIO);
				model.addObject("cambioJnlp", launcher);
			}
			
			respuesta.setFlujo(NumerosConstants.INT_TRES);
			agregarJnlp(user.getAforeUsuario(), model);
			model = this.obtenerValoresSelloEmpleado(user.getCurpAgente(), user.getAforeUsuario(), model);
			model = this.obtenerValoresSelloTrabajador(trabajador.getDatosCertificables().getCurp(), user.getCurpAgente(), user.getAforeUsuario(), model, false);
			model.addObject("imagenHuellas", trabajador.getDatosExpediente().getImagenHuellas());
			isRespuesta = this.validarRespuesta(model, "respuesta");
		} catch (BusinessException e) {
			logger.error("No cuenta con sello {} {} ", user.getCurpAgente(), user.getAforeUsuario(), e);
		} catch(Exception e) {
			logger.error("Error al al validar los datos del empleado par auna huella.", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute("redirecHuellas", "consultaTrabajador.do");
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		
		if(!isRespuesta) {
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		
		String webSocket = webSocketProcesar;
		if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			webSocket = webSocketCoppel;
		}
		model.addObject("socket", webSocket);
		
		return model;
	}
	
	/**
	 * Vista de la verificacion de empleado
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = {"/validarTrabajadorModificacion.do"}, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView validarTrabajadorMD(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_TRABAJADOR_MOD.getNavegacion(), "modelValida", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		boolean isRespuesta = false;
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		FolioEntrada folioSesion = null;
		Folio folioHijo = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			folioSesion = (FolioEntrada)request.getSession().getAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			agregarJnlp(user.getAforeUsuario(), model);
			List<Parametro> lEjecucionJava = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_EJECUCION_JAVA_LAUNCHER);
			if(lEjecucionJava.size() > 0) {
				String launcher = utileriaValidador.obtenerValorParametro(lEjecucionJava, AgenteConstants.CH_FLAG_LAUNCHER, ExpresionesConstants.VACIO);
				model.addObject("cambioJnlp", launcher);
			}
			
			if(flujo.getBanderaExistenciabiometrico().intValue() == NumerosConstants.INT_UNO.intValue()) {
				Object auxMod = entradaModificacion;
				if(utileriaValidador.validarObjetoNulo(auxMod)) {
					auxMod = entradaPermanencia;
				}
				DatosIdenExpediente datosIdeExpediente = servicioExpediente.obtenerDatosExpediente(auxMod, flujo);
				boolean expediente = servicioConsultaPersona.validarExpedienteEnrolamiento(datosIdeExpediente.getCurp());
				if(expediente) {
					respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.HUELLAS_EMPLEDO_CAPTURAR.getClave(), user.getAforeUsuario(), NumerosConstants.INT_TRES, null);
					
					model = this.obtenerValoresSelloEmpleado(user.getCurpAgente(), user.getAforeUsuario(), model);
					
					String descripcion = ServiciosConstants.DESCRIPCION_SERVICIO_VERIFICACION_HUELLA;
					String servicio = ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_1_HUELLA;
					String proceso = ServiciosConstants.FOLIO_PROCESO_VERIFICACION_1_HUELLA;
					isRespuesta = this.validarRespuesta(model, "respuesta");
					String curp = user.getCurpAgente();
					String nss = null;
					if(isRespuesta) {
						Object auxiliar = entradaModificacion;
						if(utileriaValidador.validarObjetoNulo(auxiliar)) {
							auxiliar = entradaPermanencia;
						}
						DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
						
						model = this.obtenerValoresSelloTrabajador(datosExpediente.getCurp(), user.getCurpAgente(), user.getAforeUsuario(), model, false);
						
						descripcion = ServiciosConstants.DESCRIPCION_SERVICIO_MDVERIFICACION;
						servicio = ServiciosConstants.FOLIO_SERVICIO_MODIFICACION_DATOS;
						proceso = ServiciosConstants.FOLIO_PROCESO_MDVERIFICACION;
						
						DatosExpediente datos = servicioConsulta.validarExpediente(datosExpediente.getCurp(), user.getAforeUsuario(), null, null, user.getCurpAgente());
						model.addObject("imagenHuellas", datos.getImagenHuellas());
						request.getSession().setAttribute("auxVarSello", NumerosConstants.C_UNO);
						request.getSession().setAttribute("hMDD", datos);
						
						curp = folioSesion.getCurp();
						nss = folioSesion.getNss();
					}
					
					EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
					String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
					
					FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(curp, nss, descripcion, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
					folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), sucursal, servicio, proceso);
					
					FolioEntrada folioPantalla = new FolioEntrada();
					folioPantalla.setFolio(folioHijo.getChFolio());
					
					model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, folioPantalla);
					
					isRespuesta = this.validarRespuesta(model, "respuesta");
					request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
					model.addObject("intBiom", new Integer(-1));
				} else {
					model.addObject("intBiom", new Integer(0));
					model.addObject("redirec", "continuarFlujoModificacion.do");
				}
			} else {
				model.addObject("intBiom", new Integer(0));
				model.addObject("redirec", "continuarFlujoModificacion.do");
			}
		} catch (BusinessException e) {
			logger.error("No cuenta con sello {} {} ", user.getCurpAgente(), user.getAforeUsuario(), e);
		} catch(Exception e) {
			logger.error("Error al al validar los datos del empleado par auna huella.", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		request.getSession().setAttribute("redirecHuellas", "continuarFlujoModificacion.do");
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		 
		if(!isRespuesta) {
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		
		String webSocket = webSocketProcesar;
		if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			webSocket = webSocketCoppel;
		}
		model.addObject("socket", webSocket);
		
		return model;
	}
	
	/**
	 * validar biometrico conformado
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/biomConformado.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaBase validarBiomConformado(HttpServletRequest request, @RequestParam("intento") int intento) {
		RespuestaBase respuesta = new RespuestaBase();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			intento++;
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
			
			EntradaModificacion entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);;
			EntradaPermanencia entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			Object auxiliar = entradaModificacion;
			if(utileriaValidador.validarObjetoNulo(auxiliar)) {
				auxiliar = entradaPermanencia;
			}
			DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
			boolean expediente = servicioConsultaPersona.validarExpedienteEnrolamiento(datosExpediente.getCurp());
			if(expediente) {
				flujo.setBanderaExistenciabiometrico(NumerosConstants.INT_UNO);
				respuesta.setFlujo(NumerosConstants.INT_UNO);
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
			} else {
				boolean isContador = true;
				HttpHeaders headerMedia = new HttpHeaders();
				headerMedia.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<String> entidadValidacion = new HttpEntity<>(headerMedia);

				String url = consultaRecepcionArchivo;
				if(flujo != null && flujo.getFolioEnrolamiento() != null) {
					url = url.replace("{foliopulssar}", flujo.getFolioEnrolamiento().getChFolio());
					url = url.replace("{tipoArchivo}", ServiciosConstants.CLAVE_HUELLAS_DIGITALES);
					logger.info("Peticion de validacion de archivo {}", url);
					ResponseEntity<ArchivoRecibido> respuestaCliente = servicioCliente.exchange(url, HttpMethod.GET, entidadValidacion, ArchivoRecibido.class);
					if (!utileriaValidador.validarObjetoNulo(respuestaCliente.getBody())) {
						logger.info(respuestaCliente.getBody().toString());
						ArchivoRecibido archivoRecepcion = respuestaCliente.getBody();
						if (ServiciosConstants.RESULTADO_NOK.equals(archivoRecepcion.getResultadoOperacion())) {
							flujo.setBanderaExistenciabiometrico(NumerosConstants.INT_UNO_NEGATIVO);
							flujo.setMotivoRechazo(archivoRecepcion.getDiagnostico());
							respuesta.setFlujo(NumerosConstants.INT_DOS);
							request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
							isContador = false;
						}
					}
				}
				if(isContador) {
					if(intento <= NumerosConstants.INT_CINCO.intValue()) {
						respuesta.setRespuesta(intento);
					} else {
						flujo.setBanderaExistenciabiometrico(NumerosConstants.INT_DOS);
						respuesta.setFlujo(NumerosConstants.INT_CUATRO);
						request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
					}
				}
			}
		} catch(Exception e) {
			logger.error("Error en la validacion de conformacion de expediente biometrico", e);
			RespuestaServicio respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			respuesta.setFlujo(respuestaServicio.getFlujo());
			respuesta.setMensaje(respuestaServicio.getMensaje());
			respuesta.setTitulo(respuestaServicio.getTitulo());
		}
		return respuesta;
	}
	
	/**
	 * Vista para la generacion del archivo del JNLP del Empleado
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/huellas.do", method = {RequestMethod.POST})
	public void obtenerJnlpEmpleado(HttpServletRequest request, HttpServletResponse response) {
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			String valorMain = ServiciosConstants.CLASE_MAIN;
			String valorJar = ServiciosConstants.JAR_BIOMETRICO;
			
			if(ParametrosConstants.VALOR_BANORTE.equals(user.getAforeUsuario())) {
				valorMain = ServiciosConstants.CLASE_BANORTE_MAIN;
				valorJar = utileriaCadena.obtenerCadenaConcatenada(true, valorJar, ServiciosConstants.JAR_BANORTE);
			}
			
			List<Parametro> lparametro = servicioCatalogo.obtenerParametro(ParametrosConstants.PARAMETRO_HOST_JNLP, null);
			String hostParam = utileriaValidador.obtenerValorParametro(lparametro, null, jnlpHost);
			
			String jnlp = StringUtils.replace(jnlpHuellas, ServiciosConstants.VALOR_URL_HOST_REPLACE, hostParam);
			jnlp = StringUtils.replace(jnlp, ServiciosConstants.VALOR_URL_AFORE_REPLACE, valorMain);
			jnlp = StringUtils.replace(jnlp, ServiciosConstants.VALOR_URL_JARBIO_REPLACE, valorJar);
			
			String attachment = ServiciosConstants.ARCHIVO_JNLP_WEB;
			response.setContentType(ServiciosConstants.CONTENT_TYPE_WEB);
			response.setHeader(ServiciosConstants.ENCABEZADO_WEB_JNLP_PRAGMA, ServiciosConstants.ENCABEZADO_WEB_JNLP_VALOR_PRAGMA);
			response.setHeader(ServiciosConstants.ENCABEZADO_WEB_JNLP_EXPIRES , NumerosConstants.C_CERO);
			response.setHeader(ServiciosConstants.ENCABEZADO_WEB_JNLP_DISPOSITION , attachment);
			
			OutputStreamWriter out = new OutputStreamWriter(response.getOutputStream());
			out.write(jnlp);
			out.flush();
			out.close();
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
		}
	}
	
	/**
	 * Ajax de la verificacion respuesta del archivo de Empleado
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/vRespuesta.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarRespuestaHuellasEmpleado(@RequestParam("response") String response, HttpServletRequest request) {
		logger.info("Se realiza la validacion de la respuesta del websocket huellas");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			if(response.contains(ActivacionConstants.RESPUESTA_SIN_HUELLAS)) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.HUELLAS_NO_CAPTURADAS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_TRES, null);
			} else if(response.contains(ActivacionConstants.RESPUESTA_RESULTADO_COPPEL)) {
				JsonUtilsImpl<RespuestaHuellasCoppel> peticionJson = new JsonUtilsImpl<>();
				RespuestaHuellasCoppel respuestaCoppel = peticionJson.parseJsonToObject(response, RespuestaHuellasCoppel.class);
				if(!utileriaValidador.validarObjetoNulo(respuestaCoppel)) {
					logger.info("Peticion respuesta {}", respuestaCoppel.toString());
					if(NumerosConstants.C_CERO.equals(respuestaCoppel.getResultado())) {
						respuesta.setFlujo(NumerosConstants.INT_CUATRO);
					} else if(NumerosConstants.C_NEGATIVO_10.equals(respuestaCoppel.getResultado())) {
						respuesta.setFlujo(NumerosConstants.INT_DIEZ);
					} else if(!NumerosConstants.C_UNO.equals(respuestaCoppel.getResultado())) {
						throw new BusinessException(respuestaCoppel.getResultado(), BusinessErrorEnum.ERROR_DISPOSITIVO_COPPEL.getClave());
					}
				}
			}
		} catch(BusinessException be) {
			logger.error("Error de negocio al validar la respuesta de huellas", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			respuesta.setMensaje(StringUtils.replace(respuesta.getMensaje(), "{motivo}", be.getMessage()));
		} catch(Exception e) {
			logger.error("Se presento una excepcion al validar la respuesta de huellas", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		return respuesta;
	}
	
	/**
	 * Vista para envio de recepcion de archivos
	 * 
	 * @param request
	 * @param response
	 * @param consulta
	 * @return
	 */
	@RequestMapping(value = "/validarEmpleado.do", method = {RequestMethod.POST})
	public ModelAndView enviarHuellasEmpleado(HttpServletRequest request, @ModelAttribute Expediente expediente) {
		logger.info("metodo encargado de validar las huellas del trabajador desde verificacion de empleado");
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_EMPLEADO.getNavegacion(), "modelValida", new Expediente());
		
		return this.validaEmpleadoVista(model, request, expediente);
	}
	
     /**
      * Realiza la validacion de huellas
      * @param request
      * @param expediente
      * @return
      */
	@RequestMapping(path = "/validarHuellaEmpleado.do", method = {RequestMethod.POST} )
	public ModelAndView validarHuellasEmpleado1(HttpServletRequest request,@ModelAttribute Expediente expediente) {
		logger.info("metodo encargado de validar las huellas del trabajador desde verificacion de empleado");
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_EMPLEADO.getNavegacion(), "modelValida", new Expediente());
		
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {

			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);

			respuesta = verificacionService.validaEmpleadoVistaJson(folioHijo, user, expediente);

			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO,ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_08);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.FINALIZA_VERIFICACION_EMPLEADO.getClave());
			request.getSession().setAttribute("datoBucle", "1");
			agregarJnlp(user.getAforeUsuario(), model);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(),	user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
     * Realiza la validacion de huellas
     * 
     * @param request
     * @param expediente
     * @return
     */
	@RequestMapping(path = "/obtenerHuellasINE.do", method = {RequestMethod.POST, RequestMethod.GET} )
	public ModelAndView obtenerHuellasINE(HttpServletRequest request, @ModelAttribute("datosINE") EntradaHuella datosINE) {
		logger.info("Metodo encargado de validar las huellas de verificacion INE: {}", datosINE);
		ModelAndView model = new ModelAndView(NavegacionEnum.OBTENER_HUELLAS_INE.getNavegacion(), "modelValida", datosINE);
		
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			
			model.addObject("curpEmpleado", datosINE.getCurpEmpleado());
			model.addObject("curp", datosINE.getCurp());
			model.addObject("nss", datosINE.getNss());
			model.addObject("urlFinal", datosINE.getUriHuellas());
			String datoLlave = utileriaValidador.validarVacio(datosINE.getCurp()) ? datosINE.getNss() : datosINE.getCurp();
			String imagen = obtenerPDFHuellas(datoLlave, Arrays.asList(NumerosConstants.C_DOS, NumerosConstants.C_SIETE));
			model.addObject("imagenHuellas", imagen);
			model.addObject("datos", obtenerDatosHuellas(datoLlave, datosINE.getCurpEmpleado()));
			
			agregarJnlp(user.getAforeUsuario(), model);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(),	user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Metodo encargado de obtener los datos huella
	 * 
	 * @param curp
	 * @param curpEmpleado
	 * @param huellasTrabajador
	 * @param dedos
	 * @return
	 */
	private String obtenerDatosHuellas(String curp, String curpEmpleado) {
		EntradaHuella entrada = new EntradaHuella();
		entrada.setCurp(curp);
		entrada.setTipo(ServiciosConstants.TIPO_HUELLAS_TRABAJADOR);
		entrada.setFolio(curpEmpleado);
		entrada.setCurpEmpleado(curpEmpleado);
		entrada.setHuellas(utileriaCadena.obtenerCadenaConcatenada(true, NumerosConstants.C_DOS, ServiciosConstants.COMA, NumerosConstants.C_SIETE));
		JsonUtilsImpl<EntradaHuella> utileriaJson = new JsonUtilsImpl<>();
		String datoJson = utileriaJson.parseObjectToJson(entrada);
		datoJson = StringUtils.replace(datoJson, "\"", "'");
		return datoJson;
	}
	
	/**
	 * {@inheritDoc}
	 * @throws IOException 
	 * @throws InvalidPasswordException 
	 **/
	private String obtenerPDFHuellas(String curp, List<String> lstDedos) throws InvalidPasswordException, IOException {
		logger.info("Obteniendo datos para PDF {}", curp);
		Map<String, Object> mapaDatos = new HashMap<>();
		Map<String, String> mapaImagenes = new HashMap<>();
		
		if(!utileriaValidador.validarListaVacia(lstDedos) && lstDedos.size() > NumerosConstants.INT_CERO) {
			for(String dedo : lstDedos) {
				PosicionDedoEnum dedoEnum = PosicionDedoEnum.obtenerDedo(Integer.parseInt(dedo));
				String key = utileriaCadena.obtenerCadenaConcatenada(true, "d", dedo);
				mapaImagenes.put(key, dedoEnum.getImagen());
			}
		}
		
		mapaImagenes.put("imgDerecha", PosicionDedoEnum.MANO_DERECHA.getImagen());
		mapaImagenes.put("imgIzquierda", PosicionDedoEnum.MANO_IZQUIERDA.getImagen());
		
		DatosJasper datos = new DatosJasper();
		
		datos.setDocJasper(ArchivosEnum.HUELLAS_PDF.getNombreArchivo());
		datos.setMapObjects(mapaDatos);
		datos.setMapImagenes(mapaImagenes);
		
		byte[] arregloByte = utileriaJasper.generarArchivoJasper(datos, "");
		
		return DatatypeConverter.printBase64Binary(arregloByte);
	}
	
	
	/**
	 * Vista para envio de recepcion de archivos
	 * 
	 * @param request
	 * @param response
	 * @param consulta
	 * @return
	 */
	@RequestMapping(value = "/validarETrabajador.do", method = {RequestMethod.POST})
	public ModelAndView enviarHuellaEmpleadoTrabajador(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Expediente expediente) {
		logger.info("metodo encargado de validar las huellas del trabajador desde verificacion de trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_TRABAJADOR.getNavegacion(), "modelValida", new Expediente());
		model.addObject("redirec", "verificarTrabajador.do");
		return this.validaEmpleadoVista(model, request, expediente);
	}
	
	/**
	 * Vista para envio de recepcion de archivos
	 * 
	 * @param request
	 * @param response
	 * @param consulta
	 * @return
	 */
	@RequestMapping(value = "/validaTrabajadorMod.do", method = RequestMethod.POST)
	private ModelAndView validarTrabajadorHuellasMD(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Expediente expediente) {
		logger.info("Metodo encargado de realizar la peticion para la validacion de las huellas del trabajador por modificacion de datos");
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_TRABAJADOR_MOD.getNavegacion(), "modelValida", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		FlujoModificacion flujo = null;
		Folio folioHijo = null;
		EntradaModificacion entradaModificacion = null;
		EntradaPermanencia entradaPermanencia = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			String auxiliarSello = (String) request.getSession().getAttribute("auxVarSello");
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			
			String curp = null;
			String tipoArchivos = ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1;
			
			String sesionArchivo = ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1;
			String sesionMensaje = MensajesExitoEnum.FINALIZA_VERIFICACION_EMPLEADO.getClave();
			String redireccionamiento = "validarTrabajadorModificacion.do";
			
			if(!utileriaValidador.validarObjetoNulo(auxiliarSello)) {
				Object auxiliar = entradaModificacion;
				if(utileriaValidador.validarObjetoNulo(auxiliar)) {
					auxiliar = entradaPermanencia;
				}
				DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
				logger.info("Se valida el flujo para 4 huellas del trabajador curp {}, nss {}", datosExpediente.getCurp(), datosExpediente.getNss());
				flujo.setBanderaSelloTrabajador(NumerosConstants.C_UNO);
				flujo.setFolioSelloTrabajador(folioHijo);
				curp = datosExpediente.getCurp();
				tipoArchivos = ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_4;
				
				sesionArchivo = ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_4;
				sesionMensaje = MensajesExitoEnum.FINALIZA_VERIFICACION_TRABAJADOR.getClave();
				redireccionamiento = "continuarFlujoModificacion.do";
				
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, NumerosConstants.C_TRES);
				flujo.setBanderaRespuestaSelloTrabajador(NumerosConstants.INT_UNO == respuesta.getFlujo() ? NumerosConstants.C_UNO : NumerosConstants.C_DOS);
			}
			
			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, sesionArchivo);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_08);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, sesionMensaje);
			request.getSession().setAttribute("datoBucle", "1");
			
			huellasServicio.procesarHuellasRecibidas(user, folioHijo, expediente, curp, tipoArchivos, null);
			agregarJnlp(user.getAforeUsuario(), model);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_NOVENTAYOCHO, null);
			model.addObject("redirec", redireccionamiento);
			request.getSession().setAttribute("redirecHuellas", redireccionamiento);
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			if(!utileriaValidador.validarObjetoNulo(flujo)) {
				flujo.setBanderaRespuestaSelloTrabajador(NumerosConstants.C_DOS);
			}
		}
		
		request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista para envio de recepcion de archivos
	 * 
	 * @param request
	 * @param response
	 * @param consulta
	 * @return
	 */
	@RequestMapping(value = "/validarTrabajador.do", method = RequestMethod.POST)
	private ModelAndView validarTrabajadorHuellas(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Expediente expediente) {
		logger.info("Metodo encargado de realizar la peticion para la validacion de las huellas del trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.VERIFICACION_TRABAJADOR.getNavegacion(), "modelValida", new Expediente());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			
			Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			
			if(utileriaValidador.validarObjetoNulo(folioHijo)) {
				EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
				String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
				
				FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(trabajador.getDatosCertificables().getCurp(), trabajador.getNss(), 
						ServiciosConstants.DESCRIPCION_SERVICIO_VERIFICACION_HUELLAS, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
				folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), sucursal, 
						ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_4_HUELLAS, ServiciosConstants.FOLIO_PROCESO_VERIFICACION_4_HUELLAS);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
			}
			
			huellasServicio.procesarHuellasRecibidas(user, folioHijo, expediente, trabajador.getDatosCertificables().getCurp(), ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_4, null);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_NOVENTAYOCHO, null);
			model.addObject("redirec", "muestraConsulta.do");
			agregarJnlp(user.getAforeUsuario(), model);
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista para la obtencio de la firma en el acuse
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/validarDato.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaBase validarRespuestaHuellas(HttpServletRequest request, @RequestParam("tipo") String tipo, @RequestParam("proceso") String proceso) {
		logger.info("Se realiza la validacion de la respuesta del websocket 4 huellas");
		RespuestaBase respuesta = new RespuestaBase();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			if(NumerosConstants.C_UNO.equals(tipo) || NumerosConstants.C_DOS.equals(tipo)) {
				if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
					EntradaBiometricoCoppel peticion = new EntradaBiometricoCoppel();
					peticion.setNss("");
					peticion.setCurp(user.getCurpAgente());
					peticion.setTipoPersona(tipo);
					peticion.setTipoToma(proceso);
					
					Folio folioHijo = null;
					if(NumerosConstants.C_CUATRO.equals(proceso)) {
						folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
						if(folioHijo == null) {
							folioHijo = verificacionService.obtenerFolioHijo(user);
							request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
						}
					} else {
						folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
					}
					Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
					peticion.setFolioProcesar(folioPadre.getChFolio());
					Integer dedoEmpleado = Integer.parseInt(user.getDedoSello());
					String mano = NumerosConstants.C_UNO;
					if(dedoEmpleado.intValue() > NumerosConstants.INT_CINCO.intValue()) {
						mano = NumerosConstants.C_DOS;
					}
					peticion.setIdMano(mano);
					List<EstructuraHuellasCoppel> huellasDactilares = new ArrayList<>();
					EstructuraHuellasCoppel huellaDactilar = new EstructuraHuellasCoppel();
					huellaDactilar.setIdDedo(user.getDedoSello());
					huellaDactilar.setCodigoFaltaDedo(user.getCodigoFaltaDedo());
					huellaDactilar.setMotivoSinHuella(user.getMotivoSinHuella());
					huellasDactilares.add(huellaDactilar);
					peticion.setHuellasDactilares(huellasDactilares);
					respuesta.setRespuesta(peticion);
				} else {
					EntradaHuella entrada = new EntradaHuella();
					entrada.setTipo(ServiciosConstants.TIPO_HUELLAS_EMPLEADO);
					if(user.getAforeUsuario().equals(ParametrosConstants.VALOR_BANORTE)) {
						Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
						Folio folioPadre = null;
						if(utileriaValidador.validarObjetoNulo(folioHijo)) {
							FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(user.getCurpAgente(), null, 
									ServiciosConstants.DESCRIPCION_SERVICIO_VERIFICACION_HUELLA, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
							folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), ServiciosConstants.SUCURSAL_FOLIO_DEFAULT, 
									ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_1_HUELLA, ServiciosConstants.FOLIO_PROCESO_VERIFICACION_1_HUELLA);
							request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
							folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
						} else {
							folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
						}
						entrada.setFolio(folioPadre.getChFolio());
						entrada.setCurpEmpleado(user.getCurpAgente());
					} else {
						entrada.setCurp(user.getCurpAgente());
						entrada.setServicio(ServiciosConstants.BIOMETRICO_FINGER);
					}
					JsonUtilsImpl<EntradaHuella> utileriaJson = new JsonUtilsImpl<>();
					String datoJson = utileriaJson.parseObjectToJson(entrada);
					if(ParametrosConstants.VALOR_BANORTE.equals(user.getAforeUsuario())) {
						datoJson = StringUtils.replace(datoJson, "\"", "'");
					}
					respuesta.setMensaje(datoJson);
				}
			} else {
				DatosTrabajador datos = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
				EntradaModificacion entradaModificacion = (EntradaModificacion) request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
				EntradaPermanencia entradaPermanencia = (EntradaPermanencia) request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
				FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
				FolioEntrada folioSesion = (FolioEntrada)request.getSession().getAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION);
				
				List<String> dedos = datos.getDatosExpediente().getDedosCalidad();
				DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(datos, flujo);
				String cadenaHuella = obtenerHuellasBanorteJar(datos.getDatosExpediente().getHuellasTrabajador(), dedos);
				
				if(!utileriaValidador.validarObjetoNulo(entradaModificacion) || !utileriaValidador.validarObjetoNulo(entradaPermanencia)) {
					Object auxiliar = entradaModificacion;
					if(utileriaValidador.validarObjetoNulo(auxiliar)) {
						auxiliar = entradaPermanencia;
					}
					datosExpediente = servicioExpediente.obtenerDatosExpediente(auxiliar, flujo);
					DatosExpediente datosHuellas = servicioConsulta.validarExpediente(datosExpediente.getCurp(), user.getCurpAgente(), null, null, user.getCurpAgente());
					dedos = datosHuellas.getDedosCalidad();
					cadenaHuella = obtenerHuellasBanorteJar(datosHuellas.getHuellasTrabajador(), dedos);
				}
				
				if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
					EntradaBiometricoCoppel peticion = new EntradaBiometricoCoppel();
					peticion.setNss(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getNss(), ""));
					peticion.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosExpediente.getCurp(), ""));
					peticion.setTipoPersona(tipo);
					peticion.setTipoToma(proceso);
					
					Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
					if(utileriaValidador.validarObjetoNulo(folioHijo)) {
						if(NumerosConstants.C_CUATRO.equals(proceso)) {
							folioHijo = verificacionService.obtenerFolioHijo(user);
						} else {
							String curpTrab = folioSesion != null ? folioSesion.getCurp() : datosExpediente.getCurp();
							String nssTrab = folioSesion != null ? folioSesion.getNss() : datosExpediente.getNss();
							
							EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
							String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
							
							FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(utileriaCadena.obtenerContenidoCadenaSinEspacios(curpTrab, ""), utileriaCadena.obtenerContenidoCadenaSinEspacios(nssTrab, ""), 
									ServiciosConstants.DESCRIPCION_SERVICIO_VERIFICACION_HUELLAS, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
							folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), sucursal, 
									ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_4_HUELLAS, ServiciosConstants.FOLIO_PROCESO_VERIFICACION_4_HUELLAS);
						}
						request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
					}
					Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
					peticion.setFolioProcesar(folioPadre.getChFolio());
					DatosExpediente expeHuellas = (DatosExpediente) request.getSession().getAttribute("hMDD");
					if(expeHuellas == null && (!utileriaValidador.validarListaVacia(dedos) || !utileriaValidador.validarListaVacia(datos.getDatosExpediente().getHuellasTrabajador()))) {
						peticion.setIdMano(NumerosConstants.C_CERO);
						List<EstructuraHuellasCoppel> huellasCalidad = obtenerDedosMejorCalidad(dedos);
						List<EstructuraHuellasCoppel> huellasError = obtenerDedosAdicionales(huellasCalidad, datos.getDatosExpediente().getHuellasTrabajador(), dedos);
						Collections.sort(huellasError, new Comparator<EstructuraHuellasCoppel>() {
							/**
							 * Comparacion de objetos de estructura huellas coppel
							 */
							@Override
							public int compare(EstructuraHuellasCoppel o1, EstructuraHuellasCoppel o2) {
								Integer idO1 = Integer.parseInt(o1.getIdDedo());
								Integer idO2 = Integer.parseInt(o2.getIdDedo());
								return idO1.compareTo(idO2);
							}
						});
						peticion.setHuellasDactilares(huellasError);
					} else {
						if(!utileriaValidador.validarObjetoNulo(expeHuellas)) {
							peticion.setIdMano(NumerosConstants.C_CERO);
							List<EstructuraHuellasCoppel> huellasCalidad = obtenerDedosMejorCalidad(expeHuellas.getDedosCalidad());
							List<EstructuraHuellasCoppel> huellasError = obtenerDedosAdicionales(huellasCalidad, expeHuellas.getHuellasTrabajador(), expeHuellas.getDedosCalidad());
							Collections.sort(huellasError, new Comparator<EstructuraHuellasCoppel>() {
								/**
								 * Comparacion de objetos de estructura huellas coppel
								 */
								@Override
								public int compare(EstructuraHuellasCoppel o1, EstructuraHuellasCoppel o2) {
									Integer idO1 = Integer.parseInt(o1.getIdDedo());
									Integer idO2 = Integer.parseInt(o2.getIdDedo());
									return idO1.compareTo(idO2);
								}
							});
							peticion.setHuellasDactilares(huellasError);
						}
					}
					respuesta.setRespuesta(peticion);
				} else {
					Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
					Folio folioPadre = null;
					if(utileriaValidador.validarObjetoNulo(folioHijo)) {
						FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(datosExpediente.getCurp(), datosExpediente.getNss(), 
								ServiciosConstants.DESCRIPCION_SERVICIO_VERIFICACION_HUELLAS, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
						folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), ServiciosConstants.SUCURSAL_FOLIO_DEFAULT, 
								ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_4_HUELLAS, ServiciosConstants.FOLIO_PROCESO_VERIFICACION_4_HUELLAS);
						request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
						folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
					} else {
						folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
					}
					
					EntradaHuella entrada = new EntradaHuella();
					entrada.setCurp(datosExpediente.getCurp());
					entrada.setTipo(tipo);
					if(user.getAforeUsuario().equals(ParametrosConstants.VALOR_BANORTE)) {
						entrada.setFolio(folioPadre.getChFolio());
						entrada.setCurpEmpleado(user.getCurpAgente());
						entrada.setHuellas(cadenaHuella);
					} else {
						entrada.setServicio(ServiciosConstants.BIOMETRICO_FOUR);
						if(utileriaValidador.validarListaVacia(dedos)) {
							dedos = new ArrayList<>();
							dedos.add("0");
						}
						entrada.setCalidad(dedos);
					}
					JsonUtilsImpl<EntradaHuella> utileriaJson = new JsonUtilsImpl<>();
					String datoJson = utileriaJson.parseObjectToJson(entrada);
					if(ParametrosConstants.VALOR_BANORTE.equals(user.getAforeUsuario())) {
						datoJson = StringUtils.replace(datoJson, "\"", "'");
					}
					respuesta.setMensaje(datoJson);
				}
			}
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			RespuestaServicio respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			respuesta.setFlujo(respuestaServicio.getFlujo());
			respuesta.setMensaje(respuestaServicio.getMensaje());
			respuesta.setTitulo(respuestaServicio.getTitulo());
		}
		
		return respuesta;
	}
	
	/**
	 * MEtodo encargado de obtener los dedos de mejor calidad coppel
	 * 
	 * @param dedos
	 * @return
	 */
	private List<EstructuraHuellasCoppel> obtenerDedosMejorCalidad(List<String> dedos) {
		List<EstructuraHuellasCoppel> huellasDactilares = new ArrayList<>();
		
		if(!utileriaValidador.validarListaVacia(dedos)) {
			EstructuraHuellasCoppel huellaDactilar;
			for(String dedo : dedos) {
				huellaDactilar = new EstructuraHuellasCoppel();
				huellaDactilar.setIdDedo(dedo);
				huellaDactilar.setCodigoFaltaDedo("");
				huellaDactilar.setMotivoSinHuella("");
				huellasDactilares.add(huellaDactilar);
			}
		}
		
		return huellasDactilares;
	}
	
	/**
	 * Metodo encargado de obtenr los dedos adicionales para la captura de huellas coppel
	 * 
	 * @param huellasMejores
	 * @param huellas
	 * @return
	 */
	private List<EstructuraHuellasCoppel> obtenerDedosAdicionales(List<EstructuraHuellasCoppel> huellasMejores, List<DatosHuellas> huellas, List<String> dedos) {
		List<EstructuraHuellasCoppel> huellasDactilares = new ArrayList<>(huellasMejores);
		
		if(!utileriaValidador.validarListaVacia(huellas) && (utileriaValidador.validarListaVacia(huellasDactilares) || (!utileriaValidador.validarListaVacia(huellasDactilares) && huellasDactilares.size() < NumerosConstants.INT_CUATRO))) {
			EstructuraHuellasCoppel huellaDactilar;
			List<Integer> dedosExcepcion = new ArrayList<>(); 
			for(int i = huellasDactilares.size(); i < NumerosConstants.INT_CUATRO; i++) {
				int j = 0;
				huellaDactilar = new EstructuraHuellasCoppel();
				boolean isDedo = true;
				do {
					isDedo = true;
					DatosHuellas huella = huellas.get(j);
					if(!dedosExcepcion.contains(huella.getPosicionDedo())) {
						if(utileriaValidador.validarListaVacia(dedos) || !dedos.contains(String.valueOf(huella.getPosicionDedo()))) {
							huellaDactilar = new EstructuraHuellasCoppel();
							huellaDactilar.setIdDedo(String.valueOf(huella.getPosicionDedo()));
							huellaDactilar.setCodigoFaltaDedo(utileriaCadena.obtenerContenidoCadenaSinEspacios(huella.getCodigoFaltaDedo(), ""));
							huellaDactilar.setMotivoSinHuella(utileriaCadena.obtenerContenidoCadenaSinEspacios(huella.getMotivo(), ""));
							huellasDactilares.add(huellaDactilar);
							dedosExcepcion.add(huella.getPosicionDedo());
							isDedo = false;
						}
					}
					j++;
				} while(j < huellas.size() && isDedo);
			}
		}
		
		return huellasDactilares;
	
	}
	
	/**
	 * Metodo encargado de obtener la cadena de huellas 
	 * para banorte
	 */
	private String obtenerHuellasBanorteJar(List<DatosHuellas> huellas, List<String> dedos) {
		String cadenaHuellas = "";
		if(huellas != null && huellas.size() > 0) {
			for(DatosHuellas datoHuella : huellas) {
				String dato = String.valueOf(datoHuella.getCalidadHuella());
				if(!utileriaValidador.validarVacio(datoHuella.getMotivo())) {
					dato = datoHuella.getMotivo();
				}
				cadenaHuellas = utileriaCadena.obtenerCadenaConcatenada(true, cadenaHuellas, String.valueOf(datoHuella.getPosicionDedo()), ExpresionesConstants.COMA, dato, ExpresionesConstants.PUNTO_COMA);
			}
			
			if(dedos != null && dedos.size() > 0) {
				for(String dedo : dedos) {
					cadenaHuellas = utileriaCadena.obtenerCadenaConcatenada(true, cadenaHuellas, dedo, ExpresionesConstants.COMA);
				}
				cadenaHuellas.substring(NumerosConstants.INT_CERO, cadenaHuellas.length() - 2);
			}
		}
		return cadenaHuellas;
	}
	
	/**
	 * Metodo encargado para el manejo de la vista de la peticion de
	 * validacion de empleado
	 * 
	 * @param vista
	 * @param request
	 * @param expediente
	 * @return
	 */
	private ModelAndView validaEmpleadoVista(ModelAndView vista, HttpServletRequest request, Expediente expediente) {
		logger.info("Metodo encargado de realizar la peticion para la validacion de las huellas del empleado");
		ModelAndView model = vista;
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			agregarJnlp(user.getAforeUsuario(), model);
			Folio folioHijo = null;
			String cadenaDecodificada = "";
			if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
				logger.info("Respuesta Coppel: {}", expediente.getBiometricos());
				folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
				JsonUtilsImpl<RespuestaHuellasCoppel> peticionJson = new JsonUtilsImpl<>();
				RespuestaHuellasCoppel respuestaCoppel = peticionJson.parseJsonToObject(expediente.getBiometricos(), RespuestaHuellasCoppel.class);
				logger.info("Peticion respuesta OK {}", respuestaCoppel.toString());
				
				cadenaDecodificada = servicioCoppel.guadarHuellasCoppel(user.getCurpAgente(), respuestaCoppel, ServiciosConstants.TIPO_HUELLAS_EMPLEADO, ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1);
				
			} else if(!utileriaValidador.validarObjetoNulo(expediente)) {
				logger.info("Respuesta Afore Huella {}: {}", user.getAforeUsuario(), expediente.getBiometricos());
				if(expediente.getBiometricos().contains("/DATOS/AT")) {
					File archivoZip = new File(expediente.getBiometricos());
					FileInputStream imageInFile = new FileInputStream(archivoZip);
					byte fileData[] = new byte[(int) archivoZip.length()];
					imageInFile.read(fileData);
					cadenaDecodificada = Base64Utils.encodeToString(fileData);
					imageInFile.close();
					archivoZip.delete();
					folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
				} else {
					logger.info("Respuesta afores huellas: {}", expediente.getBiometricos());
					cadenaDecodificada = URLDecoder.decode(expediente.getBiometricos(), RegistroUsuarioConstants.UTF_8);
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.BIOMETRICO_RESULTADO_BANORTE, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.FIN_RESPUESTA_HUELLAS, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_ZIP_HUELLAS, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_ZIP_HUELLASB, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_SIN_HUELLAS, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_HUELLAS_LESIONADAS, "");
					
					folioHijo = verificacionService.obtenerFolioHijo(user);
				}
				
			}
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			
			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(user.getAforeUsuario());
			objetoArchivo.setFolioTramiteProcesar(folioHijo.getChFolio());
			objetoArchivo.setFolioCliente(folioHijo.getChFolio().substring(NumerosConstants.INT_UNO));
			objetoArchivo.setCurpEmpleado(user.getCurpAgente());
			objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1);
			
			respuesta = servicioArchivos.enviarArchivoRecepcion(folioHijo, objetoArchivo, cadenaDecodificada, ServiciosConstants.RUTA_HUELLA);
			
			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, ServiciosConstants.CLAVE_08);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, MensajesExitoEnum.FINALIZA_VERIFICACION_EMPLEADO.getClave());
			request.getSession().setAttribute("datoBucle", "1");
		} catch(BusinessException be) {
			logger.error("Uno de los datos se encuentra vacio al momento de mapear", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		String webSocket = webSocketProcesar;
		if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			webSocket = webSocketCoppel;
		}
		model.addObject("socket", webSocket);
		model.addObject("isEjecuta", "0");
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	
	/**
	 * Controlador Ajax para la validación de la respuesta de la recepcion de archivos
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/respuestaWS.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarRespuestaWS(HttpServletRequest request) {
		logger.info("Validando conformación de Expediente Rcepcion de archivos");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			Folio folioEntrada = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			logger.info("Informacion folio entrada {}", folioEntrada);
			String tipoArchivo = (String) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO);
			logger.info("Informacion fotipo archivo", tipoArchivo);
			String flujo = (String) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO);
			logger.info("Informacion flujo {}", flujo);
			String mensajeOK = (String) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE);
			logger.info("Informacion mensaje {}", mensajeOK);
			String bucle = (String) request.getSession().getAttribute("datoBucle");
			logger.info("Informacion bucle {}", bucle);
			FlujoModificacion flujoMod = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			logger.info("Informacion flujo modificacion", flujoMod);
			String fMod = (String) request.getSession().getAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD);
			logger.info("Informacion fModificacion {}", fMod);
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE);
			request.getSession().removeAttribute("datoBucle");
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD);
			
			respuesta = servicioArchivos.validarRecepcionArchivo(folioEntrada, tipoArchivo, user.getAforeUsuario(), bucle, flujo, mensajeOK, flujoMod);
			logger.info("Respuesta de validacion de archivos con informacion", folioEntrada);
			request.getSession().setAttribute("datoBucle", respuesta.getDatos());
			if(respuesta.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue() || respuesta.getFlujo().intValue() == NumerosConstants.INT_DOS.intValue()) {
				request.getSession().removeAttribute(ParametrosConstants.FOLIO_DOCUMENTOS);
				request.getSession().removeAttribute(ParametrosConstants.TIPO_TRABAJADOR);
			} else {
				request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioEntrada);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_ARCHIVO, tipoArchivo);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO, flujo);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_MENSAJE, mensajeOK);
			}
			
			logger.info("validacion de flujo de modificacion {}", flujoMod);
			if(!utileriaValidador.validarObjetoNulo(flujoMod)) {
				if(NumerosConstants.INT_TRES != respuesta.getFlujo()) {
					String valorFlujo = NumerosConstants.C_UNO;
					if(respuesta.getFlujo() == NumerosConstants.INT_DOS) {
						valorFlujo = NumerosConstants.C_DOS;
						flujoMod.setMotivoRechazo(respuesta.getDatos());
					}
					logger.info("proceso modificacion {} >>> {}", fMod, flujoMod);
					if(!utileriaValidador.validarObjetoNulo(fMod)) {
						if(NumerosConstants.C_UNO.equals(fMod)) {
							flujoMod.setBanderaRespuestaEnrolamiento(valorFlujo);
						} else if(NumerosConstants.C_DOS.equals(fMod)) {
							flujoMod.setBanderaRespuestaIdentificacion(valorFlujo);
						} else {
							flujoMod.setBanderaRespuestaSelloTrabajador(valorFlujo);
						}
					}
				}
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoMod);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_SESSION_FLUJO_MOD, fMod);
			}
		} catch(Exception e) {
			logger.error("Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		return respuesta;
	}
	
	/**
	 * obtiene los valores del sello generado para empleado
	 * 
	 * @param selloEmpleado
	 * @param auxiliarModel
	 * @return
	 */
	private ModelAndView obtenerValoresSelloEmpleado(String curpAgente, String afore, ModelAndView auxiliarModel) {
		ModelAndView model = auxiliarModel;
		try {
			logger.info("Se consulta el sello del empleado curp :: {} -- afore :: {}", curpAgente, afore);
			Sello selloEmpleado = servicioSello.obtenerSelloEmpleado(curpAgente, afore);
			
			Date fechaValidacion = utileriaValidador.validarObjetoNulo(selloEmpleado.getFechaCreacionSello()) ? null : new Date(Long.parseLong(selloEmpleado.getFechaCreacionSello()));
			Date fechaVigencia = utileriaValidador.validarObjetoNulo(selloEmpleado.getFechaVigenciaFin()) ? null : new Date(Long.parseLong(selloEmpleado.getFechaVigenciaFin()));		
			
			model.addObject("curpEmpleado", selloEmpleado.getCurpEmpleado());
			model.addObject("fechaValidacion", utileriaFecha.convertirFechaACadena(fechaValidacion, FormatoConstants.FORMATO_FECHA_SELLO));
			model.addObject("fechaVigencia", utileriaFecha.convertirFechaACadena(fechaVigencia, FormatoConstants.FORMATO_FECHA_SELLO));
			
			RespuestaServicio respuesta = new RespuestaServicio();
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		} catch (BusinessException be) {
			logger.error("No cuenta con sello el empleado curp :: {} -- afore :: {}", curpAgente, afore, be);
		}
		
		return model;
	}
	
	/**
	 * obtiene los valores del sello generado para trabajador
	 * 
	 * @param selloEmpleado
	 * @param auxiliarModel
	 * @return
	 */
	private ModelAndView obtenerValoresSelloTrabajador(String curpTrabajador, String curpAgente, String afore, ModelAndView auxiliarModel, boolean isSello) {
		ModelAndView model = auxiliarModel;
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			logger.info("Se consulta el sello del Trabajador curp :: {} -- curpEmpleado :: {} -- afore :: {}", curpTrabajador, curpAgente, afore);
			boolean isRespuesta = this.validarRespuesta(model, "respuesta");
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.HUELLAS_TRABAJADOR_CAPTURAR.getClave(), afore, NumerosConstants.INT_CUATRO, null);
			if(isRespuesta) {
				Sello selloTrabajador = servicioSello.obtenerSelloTrabajador(curpAgente, curpTrabajador, afore);
				
				if(isSello) {
					Date fechaValidacion = utileriaValidador.validarObjetoNulo(selloTrabajador.getFechaCreacionSello()) ? null : new Date(Long.parseLong(selloTrabajador.getFechaCreacionSello()));
					Date fechaVigencia = utileriaValidador.validarObjetoNulo(selloTrabajador.getFechaVigenciaFin()) ? null : new Date(Long.parseLong(selloTrabajador.getFechaVigenciaFin()));		
					
					model.addObject("curpTrabajador", selloTrabajador.getCurpEmpleado());
					model.addObject("fechaValidacionTrab", utileriaFecha.convertirFechaACadena(fechaValidacion, FormatoConstants.FORMATO_FECHA_SELLO));
					model.addObject("fechaVigenciaTrab", utileriaFecha.convertirFechaACadena(fechaVigencia, FormatoConstants.FORMATO_FECHA_SELLO));
					respuesta.setFlujo(NumerosConstants.INT_CERO);
				}
			} else {
				respuesta.setFlujo(NumerosConstants.INT_TRES);
			}
		} catch(BusinessException be) {
			logger.error("No cuenta con sello del trabajador curp :: {} -- curpEmpleado :: {} -- afore :: {}", curpTrabajador, curpAgente, afore, be);
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Metodo encargado de validar si se encuentra un objeto en el modelandview
	 * 
	 * @param vista
	 * @param key
	 * @return
	 */
	private boolean validarRespuesta(ModelAndView vista, String key) {
		ModelAndView model = vista;
		boolean isRespuesta = false;
		Map<String, Object> mapaModel = model.getModel();
		
		if(mapaModel.containsKey(key)) {
			isRespuesta = true;
		}
		return isRespuesta;
	}
	

} 