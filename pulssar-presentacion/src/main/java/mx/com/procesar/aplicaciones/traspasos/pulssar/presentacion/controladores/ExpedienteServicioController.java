package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraMovimientoModificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BanderaDatosModificadosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurp;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentosAdicionales;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioLaboralTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioParticularTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosReferenciasTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudModificacionPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoCompletoRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Controller
public class ExpedienteServicioController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExpedienteServicioController.class);
	/**
	 * Inyeccion de ModificacionTrabajadorService
	 */
	@Autowired
	private ModificacionTrabajadorService modificacionTrabajadorService;
	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Inyeccion fechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;
	/**
	 * Inyección de CatalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	/**
	 * Inyeccion de expediente
	 */
	@Autowired
	private ExpedienteService servicioExpediente;
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
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
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de service expediente
	 */
	@Autowired
	private EstatusExpedienteService expedienteService;
	
	/**
	 * Service bitacora movimiento
	 */
	@Autowired
	private BitacoraMovimientoModificacionService bitacoraMovimientoModificacionService;
	
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['banorte.tablet.ambiente']}")
	private String ambiente;
	/**
	 * Validar Expediente Servicio
	 */
	@Autowired
	private ValidarExpedienteServicio validarExpedienteServicio;
	
	
	/**
	 * Metodo encargado de mostrar vista de expediente de servicio
	 * @param request
	 * @return
	 */
	@GetMapping(value ="/private/mostrarExpedienteServicio.do")
	public ModelAndView mostrarVistaExpedienteServicio(HttpServletRequest request){
		logger.info("<<<<<<Entrando a /mostrarVistaExpedienteServicio>>>>>>");
		FolioEntrada folioSesion = (FolioEntrada)request.getSession().getAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		ModelAndView model = new ModelAndView(NavegacionEnum.EXPEDIENTE_SERVICIO_MODIFICACION.getNavegacion(),"entradaRecepcionImagenes",new EntradaRecepcionImagenes());
		EntradaModificacion objetoModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaModificacion datosModificacionExpediente = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.SESION_EXPEDIENTE);
		String banderaFlujo9B = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);
		logger.info("banderaFlujo9B mostrarVistaExpedienteServicio: {}",banderaFlujo9B);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);

	try {
			FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(folioSesion.getCurp(), folioSesion.getNss(), ServiciosConstants.DESCRIPCION_FOLIO_EXPESERVICIO_MODIFICACION, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
			Folio folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), ServiciosConstants.SUCURSAL_FOLIO_DEFAULT, ServiciosConstants.FOLIO_SERVICIO_MODIFICACION_DATOS, ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO, folioHijo);
			FolioEntrada auxiliar = new FolioEntrada();
			auxiliar.setFolio(folioHijo.getChFolio());
			String tipoProcesoSolicitante = expedienteServicio.obtenerProcesoExpedienteServicio(trabajador.getTipoSolicitante());
			request.getSession().setAttribute(ServiciosConstants.TIPO_EXPEDIENTE_SERVICIO_MDD, tipoProcesoSolicitante);
			FlujosEntrada flujoEntrada = recuperaFlujoEntrada(request,trabajador, objetoModificacion );
			FlujosEntrada flujoValida9B = modificacionTrabajadorService.asignarFlujoCaso9B(banderaFlujo9B);
			if(!utileriaValidador.validarObjetoNulo(flujoValida9B)) {
				flujoEntrada = new FlujosEntrada(); 
				flujoEntrada.setMovimiento(flujoValida9B.getMovimiento());
				flujoEntrada.setFlujoValidacion(flujoValida9B.getFlujoValidacion());
			}
			
			Parametro parametro = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_INTENTOS_CONSULTA_IMAGENES);
			String valorRfc = expedienteServicio.validarIgualdadRfc(trabajador, objetoModificacion);
			bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, "Inicio Vista Formato Solicitud Modificacion", null, utileriaCadena.obtenerCadenaConcatenada(false, "13+","-",flujoEntrada.getFlujoValidacion()), objetoModificacion.getNss(), objetoModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), null);
			String idSello = expedienteServicio.consultaSelloSolicitud(user, objetoModificacion.getDatosBaseCurp().getCurpNueva(),trabajador.getTipoSolicitante());
			datosModificacionExpediente.getDatosBaseCurp().setSelloVoluntadTramite(idSello);
			model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, auxiliar);
			model.addObject("procesoModificacion",tipoProcesoSolicitante);
			model.addObject("tipoSolicitante",trabajador.getTipoSolicitante());
			model.addObject("nssProceso",trabajador.getNss());
			model.addObject("curpProceso",objetoModificacion.getDatosBaseCurp().getCurpNueva());
			model.addObject("intentos", parametro);
			model.addObject("ambienteBanorte", ambiente);
			model.addObject("agente", user.getUsuario());
			model.addObject("curpSolicitante", objetoModificacion.getDatosBaseCurp().getCurpSolicitante());
			model.addObject("cambioRfc", valorRfc);
			
	}catch(Exception e){
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Error Vista Solicitud Modificacion ",e.getMessage()), e.getMessage(), null, objetoModificacion.getNss(), objetoModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), null, "Error");
		logger.error("Ocurrio un error al entrar a vista  mostrarVistaExpedienteServicio" , e);
		servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(), 2);
		model = new ModelAndView(NavegacionEnum.EXPEDIENTE_SERVICIO_MODIFICACION.getNavegacion(),"entradaRecepcionImagenes",new EntradaRecepcionImagenes());
		RespuestaServicio respuestaServicio = catalogoService.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		model.addObject("respuesta", respuestaServicio);


	}
		return model;
	}
	
	/**
	 * Metodo que genera el pdf de solicitud de modificacion de datos
	 * @param datosModificacion
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/private/generarSolicitudModifDatosPdf.do")
	@ResponseBody
	public DatosSolicitudModificacionPdf generarSolicitudDatosPdf(@RequestBody EntradaModificacion entradaFirmas,HttpServletRequest request,Model model,HttpServletResponse response){
		logger.info("<<<<<<<<<<Ingreso a /generarSolicitudDatosPDF>>>>>>>>>>");		
		logger.info("Entrada modificacion generarSolicitudModifDatosPdf :: {}", entradaFirmas);
		logger.info("Firma trabajador generarSolicitudModifDatosPdf :: {}",entradaFirmas.getFirmaTrabajador());
		logger.info("Firma agente generarSolicitudModifDatosPdf :: {}",entradaFirmas.getFirmaAgente());
		DatosTrabajador datosTrabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);	
		EntradaModificacion datosModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.SESION_EXPEDIENTE);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		EntradaModificacion datosExpediente = new EntradaModificacion();
		datosExpediente.setFirmaTrabajador(entradaFirmas.getFirmaTrabajador());
		datosExpediente.setFirmaAgente(entradaFirmas.getFirmaAgente());
		datosModificacion.setFirmaTrabajador(entradaFirmas.getFirmaTrabajador());
		datosModificacion.setFirmaAgente(entradaFirmas.getFirmaAgente());
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		String banderaFlujo9B = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);
		String banderaCheck = (String) request.getSession().getAttribute(ParametrosConstants.NO_DESIGNA_BENEFICIARIOS);
		EntradaSolicitante entradaSolicitante = (EntradaSolicitante) request.getSession().getAttribute(ParametrosConstants.ENTRADA_SOLICITANTE);


		RespuestaServicio respuestaServicio = null;
				
		this.validarDatosExpediente(datosModificacion, datosExpediente);
		DatosSolicitudModificacionPdf result = null;
		EntradaModificacion objetoModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		logger.info("entrada expediente: {}",datosModificacion);
		logger.info("entrada modificacion: {}",objetoModificacion);
		logger.info("banderaFlujo9B generarSolicitudDatosPdf: {}",banderaFlujo9B);

		try{
			this.validarDatosExpediente(datosModificacion, datosExpediente);
			FlujosEntrada flujoEntrada = recuperaFlujoEntrada(request,datosTrabajador, datosModificacion );
			insertaDatosFlujo(request, flujoEntrada, objetoModificacion,banderaFlujo9B);
			if(!utileriaValidador.isEmpty(banderaFlujo9B)) {
				flujoEntrada.setMovimiento(ModificacionTrabajadorConstants.TIPO_MOVIMIENTO);
				flujoEntrada.setFlujoValidacion(ModificacionTrabajadorConstants.FLUJO_9B);
			}
			
			DatosDocumentosAdicionales datosDocumentoAdicional = new DatosDocumentosAdicionales();
			datosDocumentoAdicional.setCurp(objetoModificacion.getDatosBaseCurp().getCurpNueva());
			datosDocumentoAdicional.setNombre(objetoModificacion.getDatosBaseCurp().getNombreTrabajador());
			datosDocumentoAdicional.setApellidoPaterno(objetoModificacion.getDatosBaseCurp().getApellidoPaterno());
			datosDocumentoAdicional.setApellidoMaterno(objetoModificacion.getDatosBaseCurp().getApellidoMaterno());
			datosDocumentoAdicional.setNss(datosTrabajador.getNss());
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS_BASECURP_MODIFICADO, datosDocumentoAdicional);
			
			//Ejemplo: 1965-02-28
			String fechaNacimientoModificada = datosModificacion.getDatosBaseCurp().getFechaDeNacimiento();
			Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(fechaNacimientoModificada,  FormatoConstants.FORMATO_SERVICIO_MODIFICACION) ;
			fechaNacimientoModificada = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_FECHA_NACIMIENTO);
			
			//Ejemplo: 29 TLAXCALA
			String entidadFederativaNacimientoModificada = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().substring(datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().indexOf(ExpresionesConstants.ESPACIO)); 

			
			//Ejemplo: 1 MEXICANA:MEXICO
			String nacionalidadModificada = ExpresionesConstants.VACIO;
			String[] nacionalidadModificadaArreglo = datosModificacion.getDatosBaseCurp().getNacionalidad().split(":");
			if(nacionalidadModificadaArreglo!= null && nacionalidadModificadaArreglo.length==2){
				nacionalidadModificada= nacionalidadModificadaArreglo[0];
				nacionalidadModificada = nacionalidadModificada.substring(nacionalidadModificada.indexOf(ExpresionesConstants.ESPACIO)); 	
			}
			
			BanderaDatosModificadosCertificables banderaDatosModificadosCertificables = new BanderaDatosModificadosCertificables();
			banderaDatosModificadosCertificables.setModificacionDatosCertificables(true);
			banderaDatosModificadosCertificables.setModificadoCurp(true);
			banderaDatosModificadosCertificables.setModificadoRfc(true);
			banderaDatosModificadosCertificables.setModificadoApellidoPaterno(true);
			banderaDatosModificadosCertificables.setModificadoApellidoMaterno(true);
			banderaDatosModificadosCertificables.setModificadoNombre(true);
			banderaDatosModificadosCertificables.setModificadoFechaNacimiento(true);
			banderaDatosModificadosCertificables.setModificadoSexo(true);
			banderaDatosModificadosCertificables.setModificadoEntidadNacimiento(true);
			banderaDatosModificadosCertificables.setModificadoNacionalidad(true);
			banderaDatosModificadosCertificables.setModificadoNivelEstudios(true);
			banderaDatosModificadosCertificables.setModificadoActividadEconomica(true);
			banderaDatosModificadosCertificables.setModificadoOcupacion(true);
			banderaDatosModificadosCertificables.setFolioSolicitud(folioHijo);
			banderaDatosModificadosCertificables.setFolioPadre(folioPadre);
			
			realizarBloqueValidacionesUno(datosTrabajador, banderaDatosModificadosCertificables, datosModificacion, datosExpediente);
			
			realizarBloqueValidacionesDos(datosTrabajador,banderaDatosModificadosCertificables,datosModificacion,datosExpediente);
	
			if(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getEntidadNacimiento(),ExpresionesConstants.VACIO).equalsIgnoreCase(entidadFederativaNacimientoModificada.trim())){
				banderaDatosModificadosCertificables.setModificadoEntidadNacimiento(false);
				entidadFederativaNacimientoModificada = ExpresionesConstants.VACIO;
			}
			if(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getNacionalidad(), ExpresionesConstants.VACIO).equalsIgnoreCase(nacionalidadModificada.trim())){
				banderaDatosModificadosCertificables.setModificadoNacionalidad(false);
				nacionalidadModificada=ExpresionesConstants.VACIO;
			}
			
			if(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getFechaNacimiento(),ExpresionesConstants.VACIO).equalsIgnoreCase(fechaNacimientoModificada.trim())){
				banderaDatosModificadosCertificables.setModificadoFechaNacimiento(false);
				fechaNacimientoModificada = ExpresionesConstants.VACIO;
			}
			boolean resultadoValidacion = validarCambiosDatosCertificables( banderaDatosModificadosCertificables);
			banderaDatosModificadosCertificables.setModificacionDatosCertificables(resultadoValidacion);

			if(Constants.AFORE_PEIS.equals(user.getAforeUsuario())){
				result = expedienteServicio.generarSolicitudDatosPDFPeis(flujoEntrada, datosTrabajador, datosExpediente, banderaDatosModificadosCertificables, fechaNacimientoModificada, entidadFederativaNacimientoModificada, nacionalidadModificada,objetoModificacion,user);
			}else if(Constants.AFORE_BANORTE.equals(user.getAforeUsuario())){
				result = expedienteServicio.generarSolicitudDatosPDFBanorte(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables, fechaNacimientoModificada, entidadFederativaNacimientoModificada, nacionalidadModificada, objetoModificacion,user);
			}else if(Constants.AFORE_COPPEL.equals(user.getAforeUsuario())) {
				result = expedienteServicio.generarSolicitudDatosPDFCoppel(datosTrabajador, datosExpediente, banderaDatosModificadosCertificables, fechaNacimientoModificada, entidadFederativaNacimientoModificada, nacionalidadModificada, objetoModificacion,user,entradaSolicitante,banderaCheck);
			}			
			validaRespuestaPdf(result, request);
		}catch(Exception e){
			bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Error Generacion Formato Modificacion ",e.getMessage()), e.getMessage(), null, objetoModificacion.getNss(), objetoModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), "Error");
			logger.error("Ocurrio un error al generar el pdf de solicitud de modificacion de datos del trabajador con Curp:" , e);
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(), 2);
			respuestaServicio = catalogoService.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			model.addAttribute("respuesta", respuestaServicio);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);

		}
		return result;
	}

	/**
	 * Recupera el flujo de entrada
	 * @param datosTrabajador
	 * @param entradaModificacion
	 * @return
	 */
	private FlujosEntrada recuperaFlujoEntrada(HttpServletRequest request,DatosTrabajador datosTrabajador, EntradaModificacion entradaModificacion){
		logger.info("Inicio - recuperaFlujoEntrada");
		FlujosEntrada flujoEntrada = null;
		try {
			consultarExpedientesFlujo(request);
			ExpedienteSalida expediente = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
			logger.info("Resultado validarExpedienteTipoSolicitante: {}",expediente);
					   flujoEntrada = modificacionTrabajadorService.obtenerRespuestaFlujo(entradaModificacion,datosTrabajador, expediente);   
		} catch (Exception e) {
			logger.error("Ocurrio un error inesperado al recuperar el Flujo: ", e);
 		}
		return flujoEntrada;
	}
	/**
	 * Presenta la pantalla de documentos adicionales del expediente servicio
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/private/documentosAdicionalesExpedienteServicio.do")
	public ModelAndView documentosAdicionalesExpedienteServicio(HttpServletRequest request) {
		logger.info("<<<<<<<<<<Ingreso a /documentosAdicionalesExpedienteServicio.do >>>>>>>>>>");
		ModelAndView model = new ModelAndView(NavegacionEnum.DOCUMENTOS_ADICIONALES_EXPEDIENTE_SERVICIO.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RespuestaServicio respuesta = new RespuestaServicio();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion objetoModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		DatosDocumentosAdicionales datosDocAdici = (DatosDocumentosAdicionales)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_BASECURP_MODIFICADO);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		FolioEntrada auxiliar = new FolioEntrada();
		auxiliar.setFolio(folioHijo.getChFolio());
		List<Combo> comboObligatorios = new ArrayList<>();
		List<Combo> comboNoObligatorios = new ArrayList<>();
		
		try{
			consulta.setCurp(objetoModificacion.getDatosBaseCurp().getCurpNueva());
			String tipoProcesoSolicitante = expedienteServicio.obtenerProcesoExpedienteServicio(trabajador.getTipoSolicitante());
			logger.info(ParametrosConstants.LOG_TIPO_PROCESO_SOLICITANTE, tipoProcesoSolicitante);
			List<DocumentoCompletoRequerido> documentos = catalogoService.obtenerTipoDocumento(tipoProcesoSolicitante);
			utileriaConversion.obtenerComboDocumentosModificacionDatosSinSolicitudDeModificacion(documentos, comboObligatorios, comboNoObligatorios, user);
		}catch (Exception e) {
			logger.error("Ocurrio un error inesperado al presentar los datos de la pantalla de documentos adicionales" , e);
			respuesta = catalogoService.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS , null);
		}
		
		model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, auxiliar);
		model.addObject(ParametrosConstants.CURP_TRABAJADOR , datosDocAdici.getCurp());
		model.addObject(ParametrosConstants.NOMBRE_TRABAJADOR , datosDocAdici.getNombre());
		model.addObject(ParametrosConstants.APELLIDO_PATERNO , datosDocAdici.getApellidoPaterno());
		model.addObject(ParametrosConstants.APELLIDO_MATERNO , datosDocAdici.getApellidoMaterno());
		model.addObject(ParametrosConstants.NSS_TRABAJADOR, datosDocAdici.getNss());
		model.addObject(ParametrosConstants.CH_TIPO_SOLICITANTE , catalogoService.obtenerTipoSolicitante(consulta.getCvTipoSolicitante()).get(0).getChTipoSolicitante());
		model.addObject(ParametrosConstants.DOCUMENTOS, comboObligatorios);
		model.addObject(ParametrosConstants.DOCUMENTOS_N, comboNoObligatorios);
		model.addObject(ParametrosConstants.CURP_BUSQUEDA, objetoModificacion.getDatosBaseCurp().getCurpNueva());
		model.addObject(ParametrosConstants.CLAVE_TIPO_SOLICITANTE_BUSQUEDA, consulta.getCvTipoSolicitante());
		model.addObject(ParametrosConstants.NSS_BUSQUEDA, consulta.getNss());
		model.addObject(ParametrosConstants.TIMER_BUSQUEDA, consulta.getTimerPicker());
		model.addObject(ParametrosConstants.ID_PROCESOR, trabajador.getProcesar());
		model.addObject(ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}

	/**
	 * Enviar los documentos que se agregan en pantalla para el expediente de servicio
	 * @param request
	 * @param requestMultipart
	 * @return
	 */
	@RequestMapping(value= "/private/enviarArchivosExpedienteServicio.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView enviarArchivosExpedienteServicio(HttpServletRequest request,MultipartHttpServletRequest requestMultipart){
		logger.info("<<<<<<<<<<   Ingreso a /enviarArchivosExpedienteServicio.do   >>>>>>>>>>");
		ModelAndView model = new ModelAndView(NavegacionEnum.DOCUMENTOS_ADICIONALES_EXPEDIENTE_SERVICIO.getNavegacion());

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		DatosDocumentosAdicionales datosDocAdici = (DatosDocumentosAdicionales)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_BASECURP_MODIFICADO);
		String contenidoSolicitudModifDatosPdf = (String)request.getSession().getAttribute(ParametrosConstants.REQUEST_CONTENIDO_SOLICITUD_MOD_PDF);
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);



		RespuestaServicio respuesta = new RespuestaServicio();
		List<Combo> comboObligatorios = new ArrayList<>();
		List<Combo> comboNoObligatorios = new ArrayList<>();
		FolioEntrada auxiliar = new FolioEntrada();
		auxiliar.setFolio(folioHijo.getChFolio());
		try{
			String tipoProcesoSolicitante = expedienteServicio.obtenerProcesoExpedienteServicio(trabajador.getTipoSolicitante());
			logger.info(ParametrosConstants.LOG_TIPO_PROCESO_SOLICITANTE,tipoProcesoSolicitante);
			List<DocumentoCompletoRequerido> documentos = catalogoService.obtenerTipoDocumento(tipoProcesoSolicitante);
			utileriaConversion.obtenerComboDocumentosModificacionDatosSinSolicitudDeModificacion(documentos, comboObligatorios, comboNoObligatorios, user);
			
			logger.info("folioHijo: {}",folioHijo);
			String folioDocumento = servicioExpediente.obtenerValoresPantalla(folioHijo.getChFolio(), null);
			logger.info("folioDocumento:{}",folioDocumento);
			String tipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, trabajador.getTipoAfiliacion());
			logger.info("tipoTrabajador: {}",tipoTrabajador);
			
			Map<String, Map<String, MultipartFile>> arregloArchivos = new HashMap<>();
			this.obtenerDocumentos(comboObligatorios, requestMultipart, arregloArchivos);
			if(arregloArchivos.keySet().size() != comboObligatorios.size()) {
				logger.info("Los archivos obligatorios no se agregaron");
				respuesta = catalogoService.obtenerRespuesta(null, BusinessErrorEnum.ARCHIVOS_FALTANTES.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
				logger.info("Archivos Faltantes - Respuesta:  {}",respuesta);
			}else{
				this.obtenerDocumentos(comboNoObligatorios, requestMultipart, arregloArchivos);
				EnvioArchivos datosRecepcion = obtenerDatosrecepcionArchivos(folioHijo, tipoTrabajador, user, entradaModificacion, tipoProcesoSolicitante, folioDocumento,trabajador,flujo);
				
				logger.info("datosRecepcion: {}",datosRecepcion);
				respuesta = expedienteServicio.enviarArchivos(arregloArchivos, contenidoSolicitudModifDatosPdf,datosRecepcion,folioHijo.getIdFolioPulssar());
				logger.info("Respuesta de enviar archivos: {}",respuesta);
			}
			
		}catch(Exception e){
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(), 2);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			logger.error("Ocurrio un error inesperado al enviar los archivos" ,e);
			respuesta = catalogoService.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			
		}
		model.addObject(ParametrosConstants.CURP_TRABAJADOR , datosDocAdici.getCurp());
		model.addObject(ParametrosConstants.NOMBRE_TRABAJADOR , datosDocAdici.getNombre());
		model.addObject(ParametrosConstants.APELLIDO_PATERNO , datosDocAdici.getApellidoPaterno());
		model.addObject(ParametrosConstants.APELLIDO_MATERNO , datosDocAdici.getApellidoMaterno());
		model.addObject(ParametrosConstants.NSS_TRABAJADOR, datosDocAdici.getNss());
		model.addObject(ParametrosConstants.CH_TIPO_SOLICITANTE , catalogoService.obtenerTipoSolicitante(consulta.getCvTipoSolicitante()).get(0).getChTipoSolicitante());
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, auxiliar);
		model.addObject(ParametrosConstants.DOCUMENTOS, comboObligatorios);
		model.addObject(ParametrosConstants.DOCUMENTOS_N, comboNoObligatorios);
		model.addObject(ParametrosConstants.CURP_BUSQUEDA, entradaModificacion.getDatosBaseCurp().getCurpNueva());
		model.addObject(ParametrosConstants.CLAVE_TIPO_SOLICITANTE_BUSQUEDA, consulta.getCvTipoSolicitante());
		model.addObject(ParametrosConstants.NSS_BUSQUEDA, consulta.getNss());
		model.addObject(ParametrosConstants.TIMER_BUSQUEDA, consulta.getTimerPicker());
		model.addObject(ParametrosConstants.ID_PROCESOR, trabajador.getProcesar());
		model.addObject(ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		
		return model;
	}
	
	
	/**
	 * Metodo encargado de obtener los Documentos
	 * 
	 * @param combo
	 * @param requestMultipart
	 * @param arregloArchivos
	 */
	private void obtenerDocumentos(List<Combo> combo, MultipartHttpServletRequest requestMultipart, Map<String, Map<String, MultipartFile>> arregloArchivos) {
		for(Combo cvFileObligatorio : combo) {
			for(String archivo : requestMultipart.getFileMap().keySet()) {
				if(requestMultipart.getFile(archivo).getSize() != NumerosConstants.INT_CERO.longValue() && archivo.contains(cvFileObligatorio.getClave())) {
						Map<String, MultipartFile> auxiliarArchivo = validaArregloArchivos(requestMultipart, archivo, cvFileObligatorio, arregloArchivos);
						this.validarTamanioExtension(auxiliarArchivo);
						arregloArchivos.put(cvFileObligatorio.getClave(), auxiliarArchivo);
				}
			}
		}
	}
	
	/**
	 * Metodo que valida arreglo de archivos
	 * @param requestMultipart
	 * @param archivo
	 * @param cvFileObligatorio
	 * @param arregloArchivos
	 * @return
	 */
	private Map<String, MultipartFile> validaArregloArchivos(MultipartHttpServletRequest requestMultipart,String archivo,Combo cvFileObligatorio,Map<String, Map<String, MultipartFile>> arregloArchivos){
		Map<String, MultipartFile> auxiliarArchivo;
		if(arregloArchivos.containsKey(cvFileObligatorio.getClave())) {
			auxiliarArchivo = arregloArchivos.get(cvFileObligatorio.getClave());
			auxiliarArchivo.put(archivo, requestMultipart.getFile(archivo));
		} else {
			auxiliarArchivo = new HashMap<>();
			auxiliarArchivo.put(archivo, requestMultipart.getFile(archivo));
		}
		return auxiliarArchivo;
	}
	
	/**
	 * Metodo encargado de validar el tamaño y extension de los archivos
	 * 
	 * @param auxiliarArchivo
	 */
	private void validarTamanioExtension(Map<String, MultipartFile> auxiliarArchivo){
		for(String auxarchivo : auxiliarArchivo.keySet()){
			MultipartFile archivo = auxiliarArchivo.get(auxarchivo);
			String extension = archivo.getOriginalFilename().substring(archivo.getOriginalFilename().indexOf(AgenteConstants.PUNTO));
			Integer maximoTamanio = 1 * 1024 * 1024;
			Integer minimoTamanio = 2 * 1024;
			Integer tamanio = Integer.valueOf((int) archivo.getSize());
			if(extension.contains(ParametrosConstants.EXTENSIONES_ACEPTADAS)){
				throw new BusinessException(BusinessErrorEnum.ARCHIVO_NO_PERMITIDO);
			}
			if(tamanio > maximoTamanio || tamanio < minimoTamanio){
				throw new BusinessException(BusinessErrorEnum.ARCHIVO_TAMANIO_NO_PERMITIDO);
			}			
		}
			
	}
	
	/**
	 * Metodo que valida expedientes para manejo de flujo
	 * @param request
	 */
	private void consultarExpedientesFlujo(HttpServletRequest request){	
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);

		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		if(Constants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
			if(!utileriaValidador.validarObjetoNulo(bandera13) && NumerosConstants.C_UNO.equals(bandera13)){
				 consultarValidacionesExpedientes(entradaModificacion, request, trabajador);
			}else if(!utileriaValidador.validarObjetoNulo(banderaP) && NumerosConstants.C_UNO.equals(banderaP)){
				ExpedienteSalida salida = expedienteService.validarRestExpedienteTipoSolicitante(entradaPermanencia.getCurpTrabajador(),trabajador.getTipoSolicitante());
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salida);
			}
		}else{
			ExpedienteSalida salidaTipoSolicitante = new ExpedienteSalida();
			String curp = null;
			ExpedienteDetail respuesta = null;
			String cveProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
			if(!utileriaValidador.validarObjetoNulo(bandera13) && NumerosConstants.C_UNO.equals(bandera13)){
				curp =  utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) ? utileriaCadena.asignarValor(entradaModificacion.getDatosBaseCurp().getCurpNueva()) : utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp());	
				respuesta = expedienteService.consultarExpedienteProcesoSinAfore(curp, cveProceso, "1,5");
				if(utileriaValidador.validarObjetoNulo(respuesta)) {
					curp = entradaModificacion.getDatosBaseCurp().getCurpNueva();
				}
				
			}else if(!utileriaValidador.validarObjetoNulo(banderaP) && NumerosConstants.C_UNO.equals(banderaP)){
				curp = entradaPermanencia.getCurpTrabajador();
			}
			respuesta = expedienteService.consultarExpedienteProcesoSinAfore(curp, cveProceso, "1,5");
			if(utileriaValidador.validarObjetoNulo(respuesta)){
				salidaTipoSolicitante.setEstatusExpedienteIdentificacion("0");
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salidaTipoSolicitante);

			}else{
				salidaTipoSolicitante.setEstatusExpedienteIdentificacion(respuesta.getCvEstatusExpe());
				salidaTipoSolicitante.setClaveExpedienteIdentificacion(respuesta.getAfore().getClaveAfore());
				salidaTipoSolicitante.setClaveAforeExpIdentificacion(respuesta.getAfore().getClaveAfore());
				salidaTipoSolicitante.setClaveTipoProcesoExpIdentificacion(cveProceso);
				salidaTipoSolicitante.setTipoIDE("0");
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salidaTipoSolicitante);
			}
		}
	}
	
	
	/**
	 * Regresa el numero de proceso de expediente de identificacion por el tipo de solicitante
	 * @param tipoSolicitante
	 * @return
	 */
	public String obtenerProcesoTipoExpedienteIdentificacion(String tipoSolicitante){
		logger.info("tipoSolicitante: {}",tipoSolicitante);
		String proceso = null;
		if(Constants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante.trim())){
			proceso = "01";
		}else if(Constants.TIPO_SOLICITANTE_BENEFICIARIO.equals(tipoSolicitante.trim())){
			proceso = "02";
		}else if(Constants.TIPO_SOLICITANTE_REPRESENTANTE_LEGAL.equals(tipoSolicitante.trim())){
			proceso = "04";
		}else if(Constants.TIPO_SOLICITANTE_CURADOR.equals(tipoSolicitante.trim())){
			proceso = "10";
		}
		logger.info("Proceso Expediente Identificacion: {}",proceso);
		return proceso;
	}
	
	private EntradaModificacion validarDatosExpediente(EntradaModificacion datosModificacion,EntradaModificacion datosExpediente){
		DatosBaseCurp datosBase = new DatosBaseCurp();
		DatosDomicilioParticularTrabajador domicilio;
		DatosDomicilioLaboralTrabajador laboral;
		DatosReferenciasTrabajador referencias;
		ListaBeneficiariosTrabajador beneficiarios;
		
		datosBase.setCurpNueva(datosModificacion.getDatosBaseCurp().getCurpNueva());
		datosBase.setRfc(datosModificacion.getDatosBaseCurp().getRfc());
		datosBase.setApellidoPaterno(datosModificacion.getDatosBaseCurp().getApellidoPaterno());
		datosBase.setApellidoMaterno(datosModificacion.getDatosBaseCurp().getApellidoMaterno());
		datosBase.setNombreTrabajador(datosModificacion.getDatosBaseCurp().getNombreTrabajador());
		datosBase.setFechaDeNacimiento(datosModificacion.getDatosBaseCurp().getFechaDeNacimiento());
		datosBase.setSexo(datosModificacion.getDatosBaseCurp().getSexo());
		datosBase.setEntidadFederativaDeNacimiento(datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento());
		datosBase.setNacionalidad(datosModificacion.getDatosBaseCurp().getNacionalidad());
		datosBase.setClaveDeTipoDeDocumentoProbatorio(datosModificacion.getDatosBaseCurp().getClaveDeTipoDeDocumentoProbatorio());
		datosBase.setFolioDeLaSolicitud(datosModificacion.getDatosBaseCurp().getFolioDeLaSolicitud());
		datosBase.setDocumentoProbatorio(datosModificacion.getDatosBaseCurp().getDocumentoProbatorio());
		datosBase.setFolioDeDocumentoProbatorio(datosModificacion.getDatosBaseCurp().getFolioDeDocumentoProbatorio());
		datosBase.setOcupacionOProfesionTrabajador(datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador());
		datosBase.setActividadOGiroNegocioTrabajador(datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador());
		datosBase.setNivelDeEstudioTrabajador(datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador());
		datosBase.setFlujoDeValidacion(datosModificacion.getDatosBaseCurp().getFlujoDeValidacion());
		datosBase.setSelloVerificacionBiometrica(datosModificacion.getDatosBaseCurp().getSelloVerificacionBiometrica());
		datosBase.setSelloVoluntadTramite(datosModificacion.getDatosBaseCurp().getSelloVoluntadTramite());
		datosBase.setIndicadorDeDuplicidad(datosModificacion.getDatosBaseCurp().getIndicadorDeDuplicidad());
		datosBase.setIndicadorDeServicioBiometrico(datosModificacion.getDatosBaseCurp().getIndicadorDeServicioBiometrico());
		datosBase.setCurpSolicitante(datosModificacion.getDatosBaseCurp().getCurpSolicitante());
		datosBase.setTipoSolicitante(datosModificacion.getDatosBaseCurp().getTipoSolicitante());
		
		
		domicilio = datosModificacion.getDatosDomicilioParticularTrabajador();
		laboral = datosModificacion.getDatosDomicilioLaboralTrabajador();
		referencias = datosModificacion.getDatosReferenciasTrabajador();
		beneficiarios = datosModificacion.getListaBeneficiariosTrabajador();
		
		datosExpediente.setDatosBaseCurp(datosBase);
		datosExpediente.setDatosDomicilioParticularTrabajador(domicilio);
		datosExpediente.setDatosDomicilioLaboralTrabajador(laboral);
		datosExpediente.setDatosReferenciasTrabajador(referencias);
		datosExpediente.setListaBeneficiariosTrabajador(beneficiarios);
		
		return datosExpediente;	
	}
	
	/**
	 * Metodo uno que realiza bloque de validaciones para datos certificables 
	 * @param datosTrabajador
	 * @param banderaDatosModificadosCertificables
	 * @param datosModificacion
	 * @param datosExpediente
	 */
	private void realizarBloqueValidacionesUno(DatosTrabajador datosTrabajador,BanderaDatosModificadosCertificables banderaDatosModificadosCertificables,EntradaModificacion datosModificacion,EntradaModificacion datosExpediente){
		if (utileriaCadena.asignarValor(datosTrabajador.getDatosCertificables().getCurp()).equalsIgnoreCase(datosModificacion.getDatosBaseCurp().getCurpNueva().trim())){
			banderaDatosModificadosCertificables.setModificadoCurp(false);
			datosExpediente.getDatosBaseCurp().setCurpNueva(ExpresionesConstants.VACIO);
		}
		
		if(datosTrabajador.getDatosCertificables().getApellidoPaterno().trim().equalsIgnoreCase(datosModificacion.getDatosBaseCurp().getApellidoPaterno().toUpperCase().trim())){
			banderaDatosModificadosCertificables.setModificadoApellidoPaterno(false);
			datosExpediente.getDatosBaseCurp().setApellidoPaterno(ExpresionesConstants.VACIO);
		}
		if(utileriaCadena.asignarValor(datosTrabajador.getDatosCertificables().getApellidoMaterno()).equalsIgnoreCase(utileriaCadena.asignarValor(datosModificacion.getDatosBaseCurp().getApellidoMaterno()).toUpperCase())){
			banderaDatosModificadosCertificables.setModificadoApellidoMaterno(false);
			datosExpediente.getDatosBaseCurp().setApellidoMaterno(ExpresionesConstants.VACIO);
		}
	}
	
	
	/**\
	 * Metodo encargado de relizar segundo bloque de validaciones 
	 * @param datosTrabajador
	 * @param banderaDatosModificadosCertificables
	 * @param datosModificacion
	 * @param datosExpediente
	 */
	private void realizarBloqueValidacionesDos(DatosTrabajador datosTrabajador,BanderaDatosModificadosCertificables banderaDatosModificadosCertificables,EntradaModificacion datosModificacion,EntradaModificacion datosExpediente){
		if(datosTrabajador.getDatosCertificables().getNombre().trim().equalsIgnoreCase(datosModificacion.getDatosBaseCurp().getNombreTrabajador().toUpperCase().trim())){
			banderaDatosModificadosCertificables.setModificadoNombre(false);
			datosExpediente.getDatosBaseCurp().setNombreTrabajador(ExpresionesConstants.VACIO);
		}

		if(utileriaCadena.asignarValor(datosTrabajador.getDatosCertificables().getGenero()).trim().equalsIgnoreCase(utileriaCadena.asignarValor(datosModificacion.getDatosBaseCurp().getSexo()).toUpperCase().trim())){
			banderaDatosModificadosCertificables.setModificadoSexo(false);
			datosExpediente.getDatosBaseCurp().setSexo(ExpresionesConstants.VACIO);
		}
		
		if(utileriaCadena.asignarValor(datosTrabajador.getDatosNoCertificables().getRfc()).equalsIgnoreCase(utileriaCadena.asignarValor(datosModificacion.getDatosBaseCurp().getRfc()).toUpperCase())){
			banderaDatosModificadosCertificables.setModificadoRfc(false);
			datosExpediente.getDatosBaseCurp().setRfc(ExpresionesConstants.VACIO);
		}
	}
	
	/**
	 * Metodo que valida cambios en datos certificables 
	 * @param banderaDatosModificadosCertificables
	 * @return
	 */
	private boolean validarCambiosDatosCertificables(BanderaDatosModificadosCertificables banderaDatosModificadosCertificables){
		return banderaDatosModificadosCertificables.isModificadoCurp() || banderaDatosModificadosCertificables.isModificadoRfc() 
				|| banderaDatosModificadosCertificables.isModificadoApellidoPaterno() || banderaDatosModificadosCertificables.isModificadoApellidoMaterno()
				|| banderaDatosModificadosCertificables.isModificadoNombre() || banderaDatosModificadosCertificables.isModificadoFechaNacimiento()
				|| banderaDatosModificadosCertificables.isModificadoSexo() || banderaDatosModificadosCertificables.isModificadoEntidadNacimiento()
				|| banderaDatosModificadosCertificables.isModificadoNacionalidad();	
	}
	
	/**
	 * Invoca validacion a expedientes
	 * @param salida
	 * @param entradaModificacion
	 * @param request
	 * @param trabajador
	 * @return
	 */
	private ExpedienteSalida consultarValidacionesExpedientes(EntradaModificacion entradaModificacion,HttpServletRequest request,DatosTrabajador trabajador){
		String curp =  utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) ? utileriaCadena.asignarValor(entradaModificacion.getDatosBaseCurp().getCurpNueva()) : utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp());	
		ExpedienteSalida salida = expedienteService.validarRestExpedienteTipoSolicitante(curp,trabajador.getTipoSolicitante());
		request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salida);
		return salida;
	}
	

	
	private void validaRespuestaPdf(DatosSolicitudModificacionPdf result, HttpServletRequest request){
		if(!utileriaValidador.validarObjetoNulo(result)){
			String contenidoSolicitudModificacion = result.getContenido();
			byte[] bytesSolicitud = result.getContenidoBytes();
			request.getSession().setAttribute(ParametrosConstants.REQUEST_CONTENIDO_SOLICITUD_MOD_PDF, contenidoSolicitudModificacion);			
			request.getSession().setAttribute(GeneradorPdfConstants.PDF_SESION, ArrayUtils.toObject(bytesSolicitud));
		}
	}
	
	/**
	 * Metodo que genera el pdf de solicitud de modificacion de datos
	 * @param datosModificacion
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@PostMapping(value = "/private/recuperarFirmasPdf.do")
	@ResponseBody
	public DatosSolicitud recuperarImagenesFirmas(@RequestBody RecepcionImagenes recepcionImagenes, HttpServletRequest request,Model model) throws IOException{
		logger.info("recepcion recuperarImagenesFirmas: {}",recepcionImagenes);
		DatosSolicitud datosSolicitud = null;
		try {
		datosSolicitud = expedienteServicio.recuperarFirmasProceso(null,recepcionImagenes);
		}catch (Exception e) {
			logger.error("Ocurrio un problema en recuperarImagenesFirmas: {}",e);
				datosSolicitud = new DatosSolicitud();
				datosSolicitud.setMensaje("Ha ocurrido un problema en la recuperacion de firmas");
		}
		return datosSolicitud;
	}
	
	/**
	 * Metodo que genera el pdf de solicitud de modificacion de datos Generico
	 * 
	 * @param datosModificacion
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/private/recuperarFirmasPdfGenerico.do")
	@ResponseBody
	public DatosSolicitud recuperarImagenesFirmasGenerico(@RequestBody RecepcionImagenes recepcionImagenes,
			HttpServletRequest request, Model model) throws IOException {
		logger.info("recepcion recuperarImagenesFirmas: {}", recepcionImagenes);
		DatosSolicitud datosSolicitud = null;
		try {
			datosSolicitud = expedienteServicio.recuperarFirmasProcesoGenerico(null, recepcionImagenes);
		} catch (Exception e) {
			logger.error("Ocurrio un problema en recuperarImagenesFirmas: {}", e);
			datosSolicitud = new DatosSolicitud();
			datosSolicitud.setMensaje("Ha ocurrido un problema en la recuperacion de firmas");
		}
		return datosSolicitud;
	}
	
	/**
	 * Enviar los documentos que se agregan en pantalla para el expediente de servicio
	 * @param request
	 * @param requestMultipart
	 * @return
	 */
	@RequestMapping(value= "/private/enviarSolicitudBan.do",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView enviarSolicitudBanorte(HttpServletRequest request){
		logger.info("<<<<<<<<<<   Ingreso a /enviarSolicitudBan.do   >>>>>>>>>>");
		ModelAndView model = new ModelAndView(NavegacionEnum.DOCUMENTOS_ADICIONALES_EXPEDIENTE_SERVICIO.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		DatosDocumentosAdicionales datosDocAdici = (DatosDocumentosAdicionales)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_BASECURP_MODIFICADO);
		FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		String rutaZip = (String) request.getSession().getAttribute("destinoArchivo");

		
		RespuestaServicio respuesta = new RespuestaServicio();
		FolioEntrada auxiliar = new FolioEntrada();
		auxiliar.setFolio(folioHijo.getChFolio());
		try{

			
			String tipoProcesoSolicitante = expedienteServicio.obtenerProcesoExpedienteServicio(trabajador.getTipoSolicitante());
			logger.info(ParametrosConstants.LOG_TIPO_PROCESO_SOLICITANTE,tipoProcesoSolicitante);
			
			logger.info("folioHijo: {}",folioHijo);
			String folioDocumento = servicioExpediente.obtenerValoresPantalla(folioHijo.getChFolio(), null);
			logger.info("folioDocumento:{}",folioDocumento);
			String tipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, trabajador.getTipoAfiliacion());
			logger.info("tipoTrabajador: {}",tipoTrabajador);
				
				EnvioArchivos datosRecepcion = obtenerDatosrecepcionArchivos(folioHijo, tipoTrabajador, user, entradaModificacion, tipoProcesoSolicitante, folioDocumento,trabajador,flujo);
				
				logger.info("datosRecepcion: {}",datosRecepcion);
				respuesta = expedienteServicio.enviarSolicitudBanorte(datosRecepcion,rutaZip);
				logger.info("Respuesta de enviar archivos: {}",respuesta);
			
		}catch(Exception e){
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(), 2);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			logger.error("Ocurrio un error inesperado al enviar los archivos" ,e);
			respuesta = catalogoService.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			
		}

		model.addObject(ParametrosConstants.REQUEST_SESSION_FOLIO, auxiliar);
		model.addObject(ParametrosConstants.CURP_TRABAJADOR , datosDocAdici.getCurp());
		model.addObject(ParametrosConstants.NOMBRE_TRABAJADOR , datosDocAdici.getNombre());
		model.addObject(ParametrosConstants.APELLIDO_PATERNO , datosDocAdici.getApellidoPaterno());
		model.addObject(ParametrosConstants.APELLIDO_MATERNO , datosDocAdici.getApellidoMaterno());
		model.addObject(ParametrosConstants.NSS_TRABAJADOR, datosDocAdici.getNss());
		model.addObject(ParametrosConstants.CH_TIPO_SOLICITANTE , catalogoService.obtenerTipoSolicitante(consulta.getCvTipoSolicitante()).get(0).getChTipoSolicitante());
		model.addObject(ParametrosConstants.CURP_BUSQUEDA, entradaModificacion.getDatosBaseCurp().getCurpNueva());
		model.addObject(ParametrosConstants.CLAVE_TIPO_SOLICITANTE_BUSQUEDA, consulta.getCvTipoSolicitante());
		model.addObject(ParametrosConstants.NSS_BUSQUEDA, consulta.getNss());
		model.addObject(ParametrosConstants.TIMER_BUSQUEDA, consulta.getTimerPicker());
		model.addObject(ParametrosConstants.ID_PROCESOR, trabajador.getProcesar());
		model.addObject(ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		
		return model;
	}
	
	/**
	 * Metodo encargado de generar objetos folio complemento y envio archivos
	 * @param folioHijo
	 * @param tipoTrabajador
	 * @param user
	 * @param entradaModificacion
	 * @param tipoProcesoSolicitante
	 * @param folioDocumento
	 * @return
	 */
	private EnvioArchivos obtenerDatosrecepcionArchivos(Folio folioHijo,String tipoTrabajador,UsuarioLogin user,EntradaModificacion entradaModificacion,String tipoProcesoSolicitante,String folioDocumento,DatosTrabajador trabajador,FlujoModificacion flujo) {
		FolioComplemento folioComp = new FolioComplemento();
		folioComp.setIdFolio(folioHijo.getIdFolioPulssar());
		folioComp.setTipoTrabajador(tipoTrabajador);
		String agente = utileriaValidador.validarVacio(user.getUsuarioAgente()) ? user.getUsuario() : user.getUsuarioAgente();
		folioComp.setAgentePromotor(agente);
		folioComp.setFechaControl(new Date());
		folioComp.setUsuarioModificador(user.getUsuario());
		folioComp.setTipoSolicitante(trabajador.getTipoSolicitante());
		folioComp.setCurpSolicitante(entradaModificacion.getDatosBaseCurp().getCurpSolicitante());
		if(!utileriaValidador.validarObjetoNulo(flujo)) {
			folioComp.setFolioProcesarOrigen(utileriaCadena.obtenerContenidoCadenaSinEspacios(flujo.getFolioPulssarOrigen(), null));
		}
		servicioArchivos.guardarDatosFolioComplementario(folioComp);
		
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore(user.getAforeUsuario());
		datosRecepcion.setCurpEmpleado(user.getCurpAgente());
		datosRecepcion.setCurpTrabajador(entradaModificacion.getDatosBaseCurp().getCurpNueva());
		datosRecepcion.setProceso(tipoProcesoSolicitante);
		datosRecepcion.setTipoArchivo(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		datosRecepcion.setFolio(folioHijo.getChFolio());
		datosRecepcion.setFolioIdentificacion(folioDocumento);
		datosRecepcion.setTipoTrabajador(tipoTrabajador);
		return datosRecepcion;
	}
	
	/**
	 * Controlador encargado de cambiar de estatus folio
	 * @param idFolio
	 * @param estatus
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/private/terminarFolio.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio terminarFolio(@RequestParam("idFolio") String idFolio,@RequestParam("estatus") String estatus, HttpServletRequest request,Model model){
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		servicioFolio.cerrarFolio(Long.valueOf(idFolio), Integer.valueOf(estatus));
		respuestaServicio.setMensaje(ParametrosConstants.SUCCESS);
		return respuestaServicio;
	}
	
	/**
	 * Controlador encargado de convertir multipart a base64 para visor
	 * @param request
	 * @param requestMultipart
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value= "/private/convertirArchivos.do", produces = { "application/json" })
	@ResponseBody
	public List<ImagenDocumento> convertirArchivos(HttpServletRequest request,MultipartHttpServletRequest requestMultipart) throws IOException {
		List<ImagenDocumento> listaContenidoArchivos = new ArrayList<>();
	
		Map<String, MultipartFile> archivosObjeto = requestMultipart.getFileMap();
		for(MultipartFile archivo : archivosObjeto.values()) {
			ImagenDocumento contenidoArchivos = new ImagenDocumento();
			contenidoArchivos.setContenidoDocumento(StringUtils.newStringUtf8(Base64.encodeBase64(archivo.getBytes())));
			contenidoArchivos.setNombreDocumento(archivo.getOriginalFilename());
			listaContenidoArchivos.add(contenidoArchivos);
		}
		return listaContenidoArchivos;
	}
	
	/**
	 * Metodo que verica proceso expediente
	 * @param request
	 * @return
	 */
	@GetMapping(value="/private/verificarProcesoExpediente.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio verificarProcesoExpediente(HttpServletRequest request) {
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		String cveProceso = (String) request.getSession().getAttribute(ServiciosConstants.TIPO_EXPEDIENTE_SERVICIO_MDD);
		RespuestaServicio respuesta = null;
		try {
			respuesta = expedienteServicio.validarEstatusExpediente(entradaModificacion, cveProceso, user.getAforeUsuario(), folioHijo.getChFolio());
		}catch (Exception e) {
			logger.error("Ocurrio un problema al verificarProcesoExpediente: {}",e);
			respuesta = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(),NumerosConstants.INT_DOS);
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(), 2);
		}
		return respuesta;
	}
	
	private void insertaDatosFlujo(HttpServletRequest request, FlujosEntrada flujoEntrada,EntradaModificacion objetoModificacion,String bandera9B) {
		if(!utileriaValidador.validarObjetoNulo(flujoEntrada)) {
			objetoModificacion.getDatosBaseCurp().setFlujoDeValidacion(flujoEntrada.getFlujoValidacion());
			objetoModificacion.setTipoDeMovimiento(flujoEntrada.getMovimiento());
			if(!utileriaValidador.isEmpty(bandera9B)) {
				objetoModificacion.getDatosBaseCurp().setFlujoDeValidacion(ModificacionTrabajadorConstants.FLUJO_9B);
				objetoModificacion.setTipoDeMovimiento(ModificacionTrabajadorConstants.TIPO_MOVIMIENTO );
			}
			request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, objetoModificacion);
		}
	}

	/**
	 *  consultar Recepcion Imagenes
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param request
	 *  @param model
	 *  @param folio
	 *  @return
	 */
	@RequestMapping(value="/private/consultarResultadoRecepcion.do", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public String consultarRecepcionImagenes(HttpServletRequest request, Model model) {
		FolioEntrada folio = (FolioEntrada) request.getSession().getAttribute("folioEntrada");
		logger.info("datos recibidos consultarRecepcionImagenes controlador: {}",folio);
		return validarExpedienteServicio.consultarRespuestaArchivo(folio.getFolioHijo());
	}

}
