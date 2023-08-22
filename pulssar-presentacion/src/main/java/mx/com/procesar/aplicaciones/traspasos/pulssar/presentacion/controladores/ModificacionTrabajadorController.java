package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraMovimientoModificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CargaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CargaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CuerpoPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CuerpoPermanenciaProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseFormulario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DomicilioLaboral;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FiltroData;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivoDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarMunicipio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencias;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SelloVirtualEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramiteComparadorInformacionGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador para el manejo de peticiones de modificacion de datos
 * @author Maria Elena Dominguez Dominguez (medoming@inet.procesar.com.mx)
 * @version 1.0
 * @since
 */
@Controller
public class ModificacionTrabajadorController{
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ModificacionTrabajadorController.class);
	
	/**
	 * Inyeccion de ModificacionTrabajadorService
	 */
	@Autowired
	private ModificacionTrabajadorService modificacionTrabajadorService;

	/**
	 * Inyección de CatalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * FechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Notificacio de actualizacion de datos
	 */
	@Autowired
	private NotificacionExpedienteService notificacionExpedienteService;
	
	/**
	 * servicio folio
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Inyeccion de service expediente
	 */
	@Autowired
	private EstatusExpedienteService expedienteService;
	
	/**
	 * Inyeccion de utileria de cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
    /**
     * ConsultaSelloProxyService
     */
    @Autowired
	private ConsultaSelloService consultaSelloService;
    
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion servicio proceso pendiente
	 */
	@Autowired
	private ProcesoPendienteService serviceProcesoPendiente;
	
	/**
	 * Service bitacora movimiento
	 */
	@Autowired
	private BitacoraMovimientoModificacionService bitacoraMovimientoModificacionService;
	
	/**
	 * Service de consulta persona
	 */
	@Autowired
	private ConsultarPersonaCertificablesService consultaPersonaService;
	
	/**
	 * service expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicioService;
	
	  /**
     * reimpresionTramitesService
     */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	/**
	 * Vista principal de Bienvenida
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/modificaTrabajador.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView consultarDatosTrabajador(HttpServletRequest request) {
		logger.info("Inicio modificacion trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());

		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		logger.info("consulta datos: {}",consulta);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Folio folioSesion = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String curpFaltante = request.getParameter("curpFaltante");
		if(!utileriaValidador.isEmpty(curpFaltante)) {
			curpFaltante = curpFaltante.toUpperCase();
			logger.info("curp faltante {}",curpFaltante);
		}
		Folio folioHijo = null;
		Folio folioPadre = null;
		Date fechaNacimientoModificadaDate = null;
		Boolean reconsultaRenapo = false;
		RespuestaServicio respuestaServicio = null;
		Boolean consultaPendiente = null;
		String estatusIdentificacion = NumerosConstants.C_CERO;

		try {
			request.getSession().removeAttribute(ParametrosConstants.BANDERA_13);
			request.getSession().removeAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
			request.getSession().removeAttribute(ParametrosConstants.BANDERA_ENTRADA_ENROLAMIENTO);
			request.getSession().removeAttribute(ParametrosConstants.BANDERA_ENTRADA_IDENTIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.ENROLAMIENTO_CORRECTO);
			request.getSession().removeAttribute(ParametrosConstants.IDENTIFICACION_CORRECTO);
			request.getSession().removeAttribute(ModificacionTrabajadorConstants.BANDERA_MESA_CONTROL);
			request.getSession().removeAttribute(ModificacionTrabajadorConstants.BANDERA_NO_TITULAR);
			request.getSession().removeAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
			request.getSession().removeAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
			request.getSession().removeAttribute(ServiciosConstants.TIPO_EXPEDIENTE_SERVICIO_MDD);
			request.getSession().removeAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			request.getSession().removeAttribute(ModificacionTrabajadorConstants.BANDERA_RECONFORMACION_IDENTIFICACION);
			request.getSession().removeAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);
			request.getSession().removeAttribute(ParametrosConstants.NO_DESIGNA_BENEFICIARIOS);
			request.getSession().removeAttribute(GeneradorPdfConstants.PDF_SESION);
			request.getSession().removeAttribute(ParametrosConstants.FLUJO_DIGITALIZADOR);
			request.getSession().removeAttribute(ParametrosConstants.ENTRADA_SOLICITANTE);
			
			ExpedienteSalida expedienteSolicitante = expedienteService.validarRestExpedienteTipoSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO),trabajador.getTipoSolicitante());
			if(utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) && !utileriaValidador.validarVacio(curpFaltante)) {
				String valorCurpActual = trabajador.getDatosCertificables().getCurp();
				trabajador.getDatosCertificables().setCurp(curpFaltante);
				trabajador.setRenapo(consultaPersonaService.obtenerDatosRenapo(trabajador));
				trabajador.setDatosExpediente(consultaPersonaService.validarExpediente(curpFaltante, trabajador.getClaveAfore(), null, null, user.getCurpAgente()));
				trabajador.getDatosCertificables().setCurp(valorCurpActual);
				consultaPendiente = modificacionTrabajadorService.validaPendientePersona(curpFaltante);
				expedienteSolicitante = expedienteService.validarRestExpedienteTipoSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(curpFaltante, ExpresionesConstants.VACIO),trabajador.getTipoSolicitante());
				modificacionTrabajadorService.validarRespuestaPendiente(consultaPendiente);

				reconsultaRenapo = true;			
			}

			consultaPendiente =modificacionTrabajadorService.validaPendientePersona(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()));
			modificacionTrabajadorService.validarRespuestaPendiente(consultaPendiente);
			DatosTrabajador auxiliarTrabajador = new DatosTrabajador();
			DatosCertificables datosCertificables = this.asignarDatosCertificables(trabajador);
			auxiliarTrabajador.setDatosCertificables(datosCertificables);
			logger.info("DatosTrabajador: {}",trabajador);
			logger.info("Datos auxiliares : {}",auxiliarTrabajador);
			EntradaModificacion entrada = new EntradaModificacion();
			FolioActivoDetalle detalleFolioModificacion = modificacionTrabajadorService.consultaFolioActivo(trabajador.getDatosCertificables().getCurp(), trabajador.getNss(),user.getAforeUsuario(),false);

			
			FolioActivoDetalle detalleFolioPermanencia = modificacionTrabajadorService.consultaFolioActivo(trabajador.getDatosCertificables().getCurp(), trabajador.getNss(),user.getAforeUsuario(),true);

			FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()), utileriaCadena.asignarValor(trabajador.getNss()),ServiciosConstants.DESCRIPCION_FOLIO_MODIFICACION, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
			if(!reconsultaRenapo) {
				modificacionTrabajadorService.validaDetalleFolioModifcacionPermanencia(detalleFolioModificacion, detalleFolioPermanencia);
				folioHijo = servicioFolio.obtenerFolio(folioEntrada, user.getDatoUsuario(), ServiciosConstants.SUCURSAL_FOLIO_DEFAULT, ServiciosConstants.FOLIO_SERVICIO_MODIFICACION_DATOS, ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO,folioHijo);
			}else {
				folioHijo = folioSesion;
				request.getSession().setAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO,folioHijo);
			}
			
			if(!Constants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
				ExpedienteSalida salidaNoTitular = modificacionTrabajadorService.validarExpedientesNoTitularInicio(trabajador);
				estatusIdentificacion = salidaNoTitular.getEstatusExpedienteIdentificacion();
			}else {
				estatusIdentificacion = expedienteSolicitante.getEstatusExpedienteIdentificacion();
			}
			
			FolioEntrada auxiliar = new FolioEntrada();
			auxiliar.setFolio(folioHijo.getChFolio());
			
			folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
			request.getSession().setAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION, folioPadre);
			
			FolioEntrada entradaFolio = new FolioEntrada();
			entradaFolio.setCurp(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()));
			entradaFolio.setNss(utileriaCadena.asignarValor(trabajador.getNss()));
			request.getSession().setAttribute(ParametrosConstants.ENTRADA_FOLIO_MODIFICACION, entradaFolio);
			logger.info("Folio MDD: {}", folioHijo);
			request.getSession().setAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS, folioHijo);
			model = new ModelAndView(NavegacionEnum.MODIFICACION_GENERALES.getNavegacion()); 
			request.getSession().setAttribute("datosTrabajador",auxiliarTrabajador);
			request.getSession().setAttribute("entrada", entrada);
			trabajador.getDatosNoCertificables().setFolioSolicitud(folioPadre.getChFolio());
			
			DatosCertificables datosActualizados = new DatosCertificables();
			if(!utileriaValidador.validarObjetoNulo(trabajador.getRenapo()) && !utileriaValidador.validarVacio(trabajador.getRenapo().getNombre()) && !utileriaValidador.validarVacio(trabajador.getRenapo().getApellidoPaterno())){				
				datosActualizados.setCurp(trabajador.getRenapo().getCurp());
				datosActualizados.setNombre(trabajador.getRenapo().getNombre());
				datosActualizados.setApellidoPaterno(trabajador.getRenapo().getApellidoPaterno());
				datosActualizados.setApellidoMaterno(trabajador.getRenapo().getApellidoMaterno());
				datosActualizados.setFechaNacimiento(trabajador.getRenapo().getFechaNacmiento());
			}else{
				datosActualizados.setCurp(utileriaValidador.validarVacio(trabajador.getDatosCertificables().getCurp()) ? curpFaltante : trabajador.getDatosCertificables().getCurp());
				datosActualizados.setNombre(trabajador.getDatosCertificables().getNombre());
				datosActualizados.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
				datosActualizados.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
				datosActualizados.setFechaNacimiento(trabajador.getDatosCertificables().getFechaNacimiento());
			}
			if(!utileriaValidador.validarObjetoNulo(trabajador.getRenapo())) {
				model.addObject("sexo", ModificacionTrabajadorConstants.GENERO_FEMENINO.equals(utileriaValidador.validarVacio(trabajador.getRenapo().getSexo()) ? trabajador.getDatosCertificables().getGenero() :trabajador.getRenapo().getSexo()) ? ModificacionTrabajadorConstants.MUJER_2 : ModificacionTrabajadorConstants.HOMBRE_1);
				fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(utileriaValidador.validarVacio(trabajador.getRenapo().getFechaNacmiento()) ? trabajador.getDatosCertificables().getFechaNacimiento() : trabajador.getRenapo().getFechaNacmiento(),  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;

			}else {
				model.addObject("sexo", ModificacionTrabajadorConstants.GENERO_FEMENINO.equals(trabajador.getDatosCertificables().getGenero()) ? ModificacionTrabajadorConstants.MUJER_2 : ModificacionTrabajadorConstants.HOMBRE_1);
				fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(),  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;

			}
			model.addObject("sexoCompara", ModificacionTrabajadorConstants.GENERO_FEMENINO.equals(trabajador.getDatosCertificables().getGenero()) ? ModificacionTrabajadorConstants.MUJER_2 : ModificacionTrabajadorConstants.HOMBRE_1);
		
			String fechaNacimientoTrabajador = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_SERVICIO_MODIFICACION);
			model.addObject("fechaNacimiento", fechaNacimientoTrabajador );
			
			EntidadFederativa  entidadFederativa  = catalogoService.obtenerEntidad(utileriaCadena.asignarValor(!utileriaValidador.validarObjetoNulo(trabajador.getRenapo()) ?  trabajador.getRenapo().getCveEntidadNacimiento() : trabajador.getDatosCertificables().getClaveEntidadN()));
			model.addObject("entidad", utileriaValidador.validarObjetoNulo(entidadFederativa) ? trabajador.getDatosCertificables().getClaveEntidadN() : entidadFederativa.getChCvEntidadFederativa());
	
			model.addObject("entidadCompara", utileriaCadena.asignarValor(trabajador.getDatosCertificables().getClaveEntidadN()));
			
			model.addObject("entidadesNacimiento", catalogoService.obtenerEntidades());
			model.addObject("genero", catalogoService.obtenerParametroDdbpose(ModificacionTrabajadorConstants.T00004));
			model.addObject("trabajador", trabajador);
			model.addObject("certificables", datosActualizados);
			model.addObject(ParametrosConstants.TIPO_SOLICITANTE, consulta.getCvTipoSolicitante());
			if(!utileriaValidador.validarObjetoNulo(trabajador.getDatosExpediente())) {
				model.addObject("expIden", estatusIdentificacion);
				model.addObject("expEnrolamiento", trabajador.getDatosExpediente().getEstatusEnrolamiento());
			}
			if(utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) && utileriaValidador.isEmpty(curpFaltante)) {
				model.addObject("faltaCurp", "1");
			}else {
				model.addObject("faltaCurp", "0");
			}
			model.addObject("folio", auxiliar);
			model.addObject(ParametrosConstants.CURP_BUSQUEDA, consulta.getCurp());
			model.addObject(ParametrosConstants.CLAVE_TIPO_SOLICITANTE_BUSQUEDA, consulta.getCvTipoSolicitante());
			model.addObject(ParametrosConstants.NSS_BUSQUEDA, consulta.getNss());
			model.addObject(ParametrosConstants.TIMER_BUSQUEDA, consulta.getTimerPicker());
			model.addObject(ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
			if(!utileriaValidador.validarObjetoNulo(trabajador.getRenapo()) && !utileriaValidador.validarVacio(trabajador.getRenapo().getNacionalidad())){
				model.addObject(ParametrosConstants.NACIONALIDAD_TRABAJADOR , catalogoService.obtenerNacionalidadPorClaveCorta(trabajador.getRenapo().getNacionalidad()));
			}else{
				model.addObject(ParametrosConstants.NACIONALIDAD_TRABAJADOR , catalogoService.obtenerNacionalidadPorClave(String.valueOf(trabajador.getDatosNoCertificables().getClaveNacionalidad())));
			}
			model.addObject("nssTrabajador", trabajador.getNss());
			model.addObject("banderaSecciones", this.obtenerValorBanderaSecciones(trabajador.getClaveAfore()));
			model.addObject("idProcesar", trabajador.getProcesar());
			model.addObject("numeroBeneficiariosPermitidos", modificacionTrabajadorService.obtenerNumeroBeneficiariosPermitido());
			model.addObject("bloqueoEditar",modificacionTrabajadorService.obtenerBotonEditarPermitido());
			//Carga complementario
			this.cargaNoCertificados(trabajador, model);
			this.cargaComplementarios(trabajador, model);
			bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, "Inicio vista Modificacion de datos", null, null, trabajador.getNss(), trabajador.getDatosCertificables().getCurp(), folioPadre.getChFolio(), folioHijo.getChFolio(), "Exito");
		}catch (BusinessException be) {
			logger.error("BusinessException inicio modificacion datos: {}",be);
			model = new ModelAndView(NavegacionEnum.MODIFICACION_GENERALES.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta()); 
			 respuestaServicio = servicioCatalogo.obtenerRespuesta(null,be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			 model.addObject("respuesta", respuestaServicio);

		} catch(Exception e) {
			model = new ModelAndView(NavegacionEnum.MODIFICACION_GENERALES.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta()); 
			 respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			 model.addObject("respuesta", respuestaServicio);
			 logger.error("Se presento un problema no controlado al consultar el trabajador", e);
		}
		

		return model;
	}
	/**
	 * Se valida contra Renapo para el flujo de servicio 13+
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/private/validaRenapo.do")
	public ModelAndView validacionContraRenapo(HttpServletRequest request) {
		logger.info("Inicio - ValidacionContraRenapo");
		ModelAndView model = new ModelAndView(NavegacionEnum.MODIFICACION_GENERALES.getNavegacion());
		try {
			EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
			logger.info("entradaModificacion: {}", entradaModificacion);
			EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			logger.info("DatosTrabajador: {}", trabajador);
			Folio folio = (Folio)request.getSession().getAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS);
			Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);

			FolioEntrada auxiliar = new FolioEntrada();
			auxiliar.setFolio(folio.getChFolio());
			logger.info("Folio: {}", folio);
			
			Renapo renapo = this.obtenerDatosRenapo(entradaModificacion);
			String curp = utileriaValidador.isEmpty(utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO)) ? entradaModificacion.getDatosBaseCurp().getCurpNueva() : utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO);
			ExpedienteSalida expedienteSolicitante = expedienteService.validarRestExpedienteTipoSolicitante(curp,trabajador.getTipoSolicitante());
			
		
			trabajador.getDatosNoCertificables().setFolioSolicitud(folioPadre.getChFolio());
			DatosCertificables datosActualizados = new DatosCertificables();
			if(!utileriaValidador.validarObjetoNulo(trabajador.getRenapo()) && !utileriaValidador.validarVacio(trabajador.getRenapo().getNombre()) && !utileriaValidador.validarVacio(trabajador.getRenapo().getApellidoPaterno())){				
				datosActualizados.setCurp(trabajador.getRenapo().getCurp());
				datosActualizados.setNombre(trabajador.getRenapo().getNombre());
				datosActualizados.setApellidoPaterno(trabajador.getRenapo().getApellidoPaterno());
				datosActualizados.setApellidoMaterno(trabajador.getRenapo().getApellidoMaterno());
				datosActualizados.setFechaNacimiento(trabajador.getRenapo().getFechaNacmiento());
			}else{
				datosActualizados.setCurp(curp);
				datosActualizados.setNombre(trabajador.getDatosCertificables().getNombre());
				datosActualizados.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
				datosActualizados.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
				datosActualizados.setFechaNacimiento(trabajador.getDatosCertificables().getFechaNacimiento());
			}
			
			model.addObject("entidadCompara", utileriaCadena.asignarValor(trabajador.getDatosCertificables().getClaveEntidadN()));
			model.addObject("sexoCompara", ModificacionTrabajadorConstants.GENERO_FEMENINO.equals(trabajador.getDatosCertificables().getGenero()) ? ModificacionTrabajadorConstants.MUJER_2 : ModificacionTrabajadorConstants.HOMBRE_1);
			model.addObject("sexo", entradaModificacion.getDatosBaseCurp().getSexo());
			model.addObject("fechaNacimiento", entradaModificacion.getDatosBaseCurp().getFechaDeNacimiento());
			model.addObject("entidad", entradaModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento());			
			model.addObject("entidadesNacimiento", catalogoService.obtenerEntidades());
			model.addObject("genero", catalogoService.obtenerParametroDdbpose(ModificacionTrabajadorConstants.T00004));
			model.addObject("trabajador", trabajador);
			model.addObject("certificables", datosActualizados);
			model.addObject(ParametrosConstants.TIPO_SOLICITANTE, consulta.getCvTipoSolicitante());
			model.addObject("expIden", expedienteSolicitante.getEstatusExpedienteIdentificacion());
			model.addObject("expEnrolamiento", trabajador.getDatosExpediente().getEstatusEnrolamiento());
			model.addObject("folio", auxiliar);
			model.addObject(ParametrosConstants.CURP_BUSQUEDA, consulta.getCurp());
			model.addObject(ParametrosConstants.CLAVE_TIPO_SOLICITANTE_BUSQUEDA, consulta.getCvTipoSolicitante());
			model.addObject(ParametrosConstants.NSS_BUSQUEDA, consulta.getNss());
			model.addObject(ParametrosConstants.TIMER_BUSQUEDA, consulta.getTimerPicker());
			model.addObject(ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
			model.addObject(ParametrosConstants.NACIONALIDAD_TRABAJADOR , catalogoService.obtenerNacionalidadPorClave(String.valueOf(trabajador.getDatosNoCertificables().getClaveNacionalidad())));
			
			model.addObject("renapo" , renapo);
			model.addObject("nssTrabajador", trabajador.getNss());
			model.addObject("banderaSecciones", this.obtenerValorBanderaSecciones(trabajador.getClaveAfore()));
			model.addObject("banderaValidoRenapo" ,  NumerosConstants.INT_UNO);
			model.addObject("idProcesar", trabajador.getProcesar());
			model.addObject("numeroBeneficiariosPermitidos", modificacionTrabajadorService.obtenerNumeroBeneficiariosPermitido());


			//Carga complementario
			this.cargaNoCertificados(trabajador, model);
			this.cargaComplementarios(trabajador, model);
			
			//Carga Flujo Validacion
			this.recuperaFlujoEntrada(request,trabajador, entradaModificacion, model);
			

			
			//        
			if(entradaModificacion.getDatosDomicilioParticularTrabajador() == null){
				model.addObject("banderaNuloDomicilioParticularTrabajador" ,  NumerosConstants.INT_UNO);
			}else{
				model.addObject("banderaNuloDomicilioParticularTrabajador" ,  NumerosConstants.INT_CERO);
			}
			consultarExpedientesFlujo(request);
			ExpedienteSalida expediente = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
			if(ParametrosConstants.VALOR_COPPEL.equals(user.getAforeUsuario())) {
				String estatusExpeIdentificacion = expediente.getEstatusExpedienteIdentificacion();
				boolean respuestaValidacion = validaDatosGenerarNuevoIde(trabajador, entradaModificacion, null, request);
				estatusExpeIdentificacion = modificacionTrabajadorService.validarCambioCurpCoppel(estatusExpeIdentificacion, user.getAforeUsuario(), trabajador, entradaModificacion, bandera13);
				if(NumerosConstants.C_CINCO.equals(estatusExpeIdentificacion) && respuestaValidacion) {
					model.addObject("reconformaExpediente", NumerosConstants.C_UNO);
				}
			}
			
		} catch (Exception e) {
			logger.error("Se presento un problema no controlado al validar los datos certificables contra Renapo",e);
		}
		return model;
	}
	
	private void cargaComplementarios(DatosTrabajador trabajador, ModelAndView model){
		model.addObject("contacto", trabajador.getDatosComplementarios().getTelefonos());
		model.addObject("correo", trabajador.getDatosComplementarios().getCorreoElectronico());
		model.addObject("paises", catalogoService.obtenerPaises());
		model.addObject("parentescos", catalogoService.obtenerParentescos());
		model.addObject("listaBeneficiarios", trabajador.getDatosComplementarios().getListaBeneficiario());
		model.addObject("numBeneficiariosExistentes", utileriaValidador.validarListaVacia(trabajador.getDatosComplementarios().getListaBeneficiario()) ? 0 : trabajador.getDatosComplementarios().getListaBeneficiario().size());
		model.addObject("referencias", trabajador.getDatosComplementarios().getListaReferencias());
		this.transformarReferencias(trabajador.getDatosComplementarios().getListaReferencias(),model);
		
		if(!utileriaValidador.validarObjetoNulo(trabajador.getDatosComplementarios().getParticular()) || trabajador.getDatosComplementarios().getParticular() != null){
			model.addObject("domParticular", trabajador.getDatosComplementarios().getParticular());
			if("568".equals(trabajador.getClaveAfore())) {
				model.addObject("domSolicitante", trabajador.getDatosComplementarios().getParticular());
			}
			model.addObject("paisParticularAct",  trabajador.getDatosComplementarios().getParticular().getClavePais());
			model.addObject("entidadParticularAct", "NO IDENTIFICADOS".equals(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa()) ? null : trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());//falta agregar clave entidad en consulta
			model.addObject("municipiosParticular", catalogoService.obtenerMunicipiosPorEntidad(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa()));
			model.addObject("municipioParticularAct", "OTRO".equals(trabajador.getDatosComplementarios().getParticular().getMunicipio()) ? null : trabajador.getDatosComplementarios().getParticular().getMunicipio());
		}
		
		if(!utileriaValidador.validarObjetoNulo(trabajador.getDatosComplementarios().getLaboral()) || trabajador.getDatosComplementarios().getLaboral() != null){
			model.addObject("domLaboral", trabajador.getDatosComplementarios().getLaboral());
			model.addObject("entidadLaboralAct", "NO IDENTIFICADOS".equals(utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosComplementarios().getLaboral().getEntidadFederativa(), ExpresionesConstants.VACIO)) ? null : trabajador.getDatosComplementarios().getLaboral().getEntidadFederativa());//falta agregar clave entidad en consulta
			model.addObject("paisLaboralAct", trabajador.getDatosComplementarios().getLaboral().getClavePais());
			model.addObject("municipiosLaboral", catalogoService.obtenerMunicipiosPorEntidad(trabajador.getDatosComplementarios().getLaboral().getEntidadFederativa()));
			model.addObject("municipioLaboralAct", "OTRO".equals(utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosComplementarios().getLaboral().getMunicipio(), ExpresionesConstants.VACIO) ) ? null : trabajador.getDatosComplementarios().getLaboral().getMunicipio());
		}		
	}
	
	/**
	 * Agrega Referencias a pantalla de modificacion
	 * 
	 * @param lista
	 * @return
	 */
	private void transformarReferencias(List<Referencia> lista, ModelAndView model) {
		if(!utileriaValidador.validarListaVacia(lista)) {
			Integer contador = 0;
			for(Referencia referencia : lista) {
				contador = contador+1;
				model.addObject("referencia"+contador.toString(), referencia);
				model.addObject("parentescoRefAct"+contador.toString(), referencia.getClaveParentesco());
			}
		}
	}
	
	/**
	 * Carga Datos No Certificados
	 * @param trabajador
	 * @param model
	 */
	private void cargaNoCertificados(DatosTrabajador trabajador, ModelAndView model){
		model.addObject("noCertificables", trabajador.getDatosNoCertificables());
		model.addObject("nacionalidades", catalogoService.obtenerNacionalidades());
		if(!utileriaValidador.validarObjetoNulo(trabajador.getRenapo()) && !utileriaValidador.validarVacio(trabajador.getRenapo().getNacionalidad())){
			model.addObject("nacionalidadAct", catalogoService.obtenerNacionalidadPorClaveCorta(trabajador.getRenapo().getNacionalidad()).getCvNacionalidad());
		}else{
			model.addObject("nacionalidadAct", trabajador.getDatosNoCertificables().getClaveNacionalidad());
		}
		model.addObject("tiposDoctos", catalogoService.obtenerTiposDoctos());
		model.addObject("tipoDoctoAct", trabajador.getDatosNoCertificables().getClaveTipoDocProbatorio());
		model.addObject("ocupaciones", catalogoService.obtenerOcupaciones());
		model.addObject("ocupacionAct", trabajador.getDatosNoCertificables().getClaveOcupacion());
		model.addObject("giros", catalogoService.obtenerGirosNegocios());
		model.addObject("giroAct", trabajador.getDatosNoCertificables().getClaveGiro());
		model.addObject("niveles", catalogoService.obtenerGradoEstudios());
		model.addObject("nivelAct", trabajador.getDatosNoCertificables().getEstudios());
	}
	
	/**
	 * Metodo encargadop de cargar objeto para servicio de modificacion de datos 
	 * @param entradaModificacion
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/private/cargaEntradaModificacion13Plus.do")
	@ResponseBody
	public RespuestaServicio cargaEntradaModificacion13Plus(@RequestBody CargaModificacion cargaModificacion,  HttpServletRequest request, Model model){
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		logger.info("cargaEntradaModificacion13Plus: {} ",cargaModificacion);
		this.validarNssModificacion(request, cargaModificacion.getEntradaModificacion());
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, cargaModificacion.getEntradaModificacion());
		respuestaServicio.setMensaje(ParametrosConstants.SUCCESS);
		if(utileriaValidador.validarObjetoNulo(cargaModificacion.getEntradaModificacion().getListaBeneficiariosTrabajador())) {
			request.getSession().setAttribute(ParametrosConstants.NO_DESIGNA_BENEFICIARIOS, "1");
		}
		
		if(!utileriaValidador.validarObjetoNulo(cargaModificacion.getEntradaSolicitante())) {
			cargaModificacion.getEntradaSolicitante().setTipoSolicitante(trabajador.getTipoSolicitante());
			cargaModificacion.getEntradaSolicitante().setTipoProceso(NumerosConstants.C_UNO);
			request.getSession().setAttribute(ParametrosConstants.ENTRADA_SOLICITANTE, cargaModificacion.getEntradaSolicitante());
		}
		

		return respuestaServicio;
	}
	
	/**
	 * Metodo encargadop de cargar objeto para servicio de modificacion de datos 
	 * @param entradaModificacion
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/private/cargaEntradaModificacionPDF.do")
	@ResponseBody
	public RespuestaServicio cargaEntradaModificacionPDF(@RequestBody EntradaModificacion datosModificacion,  HttpServletRequest request, Model model){
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		logger.info("cargaEntradaModificacion13PlusExpe: {}",datosModificacion);
		request.getSession().setAttribute(ParametrosConstants.SESION_EXPEDIENTE, datosModificacion);
		respuestaServicio.setMensaje(ParametrosConstants.SUCCESS);
		return respuestaServicio;
	}
	
	
	/**
	 * Realiza Actualizacion de Datos
	 * 
	 * @author María Elena Domínguez (medoming@procesar.com)
	 * @param locale
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/private/actualizaTrabajador")
	@ResponseBody
	public SalidaActualizaDatos ejecutarModificacion(HttpServletRequest request,Model model){
		logger.info("<<<<<<<<<<Ingreso a /actualizaTrabajador>>>>>>>>>>");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		FlujoModificacion flujoModificacion = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		String banderaFlujo9B = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);
		logger.info("ejecutarModificacion cargaEntradaModificacion13Plus: {}", entradaModificacion);
		entradaModificacion.setEntidadOrigen(utileriaValidador.validarVacio(user.getAforeUsuario()) ? ModificacionTrabajadorConstants.VACIO : user.getAforeUsuario());
		ExpedienteSalida expedienteSalida = null;
		FlujosEntrada flujo = null;
		SalidaActualizaDatos salidaRespuesta = new SalidaActualizaDatos();
		try{
			validarEntradaExpedientes(request,flujoModificacion);
			validarExpeIdentificacionMesa(request);
			consultarExpedientesFlujo(request);
			expedienteSalida = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
			 expedienteSalida = modificacionTrabajadorService.validarEstatusExpedientes(flujoModificacion, expedienteSalida);
			String banderaMesa = (String)request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_MESA_CONTROL);
			logger.info("Bandera mesa control :: ejecutarModificacion: {}",banderaMesa);

			String validacionEnrolamiento = (String)request.getSession().getAttribute(ParametrosConstants.ENROLAMIENTO_CORRECTO);
			String validacionIdentificacion = (String)request.getSession().getAttribute(ParametrosConstants.IDENTIFICACION_CORRECTO);
			String noTitular = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_NO_TITULAR);
			String reconformacionIdentificacion = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_RECONFORMACION_IDENTIFICACION);
			EntradaSolicitante entradaSolicitante = (EntradaSolicitante) request.getSession().getAttribute(ParametrosConstants.ENTRADA_SOLICITANTE);

			if(ParametrosConstants.VALOR_COPPEL.equals(user.getAforeUsuario()) && utileriaCadena.obtenerContenidoCadenaSinEspacios(reconformacionIdentificacion,ExpresionesConstants.VACIO).equals(NumerosConstants.C_UNO) && utileriaCadena.obtenerContenidoCadenaSinEspacios(validacionIdentificacion, ExpresionesConstants.VACIO).equals(NumerosConstants.C_UNO) || !utileriaValidador.validarObjetoNulo(banderaMesa) && ParametrosConstants.VALOR_COPPEL.equals(user.getAforeUsuario())){
				expedienteSalida.setEstatusExpedienteIdentificacion(NumerosConstants.C_UNO);
			}
		    flujo = modificacionTrabajadorService.obtenerRespuestaFlujo(entradaModificacion,trabajador, expedienteSalida);
			if(!utileriaValidador.validarObjetoNulo(flujo)) {
				entradaModificacion.getDatosBaseCurp().setFlujoDeValidacion(flujo.getFlujoValidacion());
				entradaModificacion.setTipoDeMovimiento(flujo.getMovimiento());
			}
			
			if(!utileriaValidador.isEmpty(banderaFlujo9B)) {
				entradaModificacion.getDatosBaseCurp().setFlujoDeValidacion(ModificacionTrabajadorConstants.FLUJO_9B);
				entradaModificacion.setTipoDeMovimiento(ModificacionTrabajadorConstants.TIPO_MOVIMIENTO);
			}
			entradaModificacion.getDatosBaseCurp().setIndicadorEnrolamiento(modificacionTrabajadorService.validarIndicadorEnrolamiento9B(banderaFlujo9B, expedienteSalida.getEstatusEnrolamiento()));
		    logger.info("ejecutarModificacion :: validacionEnrolamiento: {}",validacionEnrolamiento);
			logger.info("ejecutarModificacion :: validacionIdentificacion: {}",validacionIdentificacion);
		   logger.info("Resultado validarExpedienteTipoSolicitante: {}", expedienteSalida);
			bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, "Inicio De Lanzado 13+", null, utileriaCadena.obtenerCadenaConcatenada(false, "13+","-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), null);
			modificacionTrabajadorService.validaNumeroMovimientoBeneficiario(entradaModificacion);
			if(utileriaValidador.validarObjetoNulo(banderaMesa)){
			   if(utileriaCadena.asignarValor(validacionIdentificacion).equals(NumerosConstants.C_UNO) || !NumerosConstants.C_CERO.equals(expedienteSalida.getEstatusExpedienteIdentificacion()) && user.getAforeUsuario().equals(utileriaCadena.asignarValor(expedienteSalida.getClaveAforeExpIdentificacion())) || NumerosConstants.C_CINCO.equals(expedienteSalida.getEstatusExpedienteIdentificacion())){
				   if(utileriaCadena.asignarValor(validacionEnrolamiento).equals(NumerosConstants.C_UNO) || NumerosConstants.C_UNO.equals(utileriaCadena.asignarValor(noTitular)) || !NumerosConstants.C_CERO.equals(expedienteSalida.getEstatusEnrolamiento()) && user.getAforeUsuario().equals(utileriaCadena.asignarValor(expedienteSalida.getClaveAforeExpBiometrico())) || NumerosConstants.C_CINCO.equals(expedienteSalida.getEstatusEnrolamiento())){
					   if(!utileriaValidador.validarVacio(flujo.getFlujoValidacion())){
						   entradaModificacion.getDatosBaseCurp().setIndicadorEnrolamiento(modificacionTrabajadorService.validarIndicadorEnrolamiento9B(banderaFlujo9B, expedienteSalida.getEstatusEnrolamiento()));
							FlujosEntrada flujoValida9B = modificacionTrabajadorService.asignarFlujoCaso9B(banderaFlujo9B);
							if(!utileriaValidador.validarObjetoNulo(flujoValida9B)) {
								flujo.setMovimiento(flujoValida9B.getMovimiento());
								flujo.setFlujoValidacion(flujoValida9B.getFlujoValidacion());
							}
							entradaModificacion.getDatosBaseCurp().setFlujoDeValidacion(flujo.getFlujoValidacion());
							entradaModificacion.setTipoDeMovimiento(flujo.getMovimiento());
							bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, "Paso val exp 13+", null, utileriaCadena.obtenerCadenaConcatenada(false, "13+","-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), null);
							String respuestaSellos = modificacionTrabajadorService.consultarSellos(entradaModificacion, user,trabajador.getTipoSolicitante());
							if(ModificacionTrabajadorConstants.RESULTADO_OK.equals(respuestaSellos) || NumerosConstants.C_UNO.equals(noTitular)){
								SalidaActualizaDatos respuestaActualizacion = modificacionTrabajadorService.ejecutarModificacion(entradaModificacion, trabajador,null);						
								SalidaActualizaDatos respuestaRelanzamiento = modificacionTrabajadorService.validarRespuestaModificacion(respuestaActualizacion, entradaModificacion, trabajador);
								salidaRespuesta = utileriaValidador.validarObjetoNulo(respuestaRelanzamiento) ? respuestaActualizacion : respuestaRelanzamiento;
								salidaRespuesta.getObjetoRespuesta().getDatosBaseCurp().setRfc(entradaModificacion.getDatosBaseCurp().getRfc());
								if(utileriaValidador.validarObjetoNulo(salidaRespuesta.getObjetoRespuesta().getDatosBaseCurp().getClaveDeAgentePromotor())) {
									salidaRespuesta.getObjetoRespuesta().getDatosBaseCurp().setClaveDeAgentePromotor(new BigInteger(user.getUsuario()));
								}
								modificacionTrabajadorService.registraSolicitudReimpresionModificacion(entradaModificacion, null, salidaRespuesta.getObjetoRespuesta().getDatosBaseCurp().getDiagnosticoDeRecepcion(), folioHijo.getChFolio(), null);
								modificacionTrabajadorService.notificarTiempoTramite(folioPadre.getChFolio(), consulta.getFolioPrevio(),trabajador.getClaveAfore());
								notificacionExpedienteService.envioNotificacionActualiza(salidaRespuesta, trabajador,folioPadre,flujoModificacion);
								String diagnosticoCorto = modificacionTrabajadorService.obtenerDiagnosticoCorto(salidaRespuesta.getObjetoRespuesta().getDatosBaseCurp().getDiagnosticoDeRecepcion());
								bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, "13+ Ejecutada", diagnosticoCorto, utileriaCadena.obtenerCadenaConcatenada(true, "13+-",flujo.getFlujoValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), "Ejecutado");
								modificacionTrabajadorService.cerrarFolioOrigen(flujoModificacion);
								servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_TRES);
								request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
							}else{
								servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
								request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
								salidaRespuesta.setResultadoActualizacion(ModificacionTrabajadorConstants.SIN_SELLO);
							}
						}else{
							bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Lanzado 13+ ","Falta Flujo"), null, "13+", entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), null);
							servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
							request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
							salidaRespuesta.setResultadoActualizacion(ModificacionTrabajadorConstants.SIN_FLUJO);

						}
				   } else {
						bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Lanzado 13+ ","Falta Enrolamiento"), null,  utileriaCadena.obtenerCadenaConcatenada(true, "13+-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), null);
						servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
						request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
					   salidaRespuesta.setResultadoActualizacion(ServiciosConstants.TEXTO_SIN_ENROLAMIENTO);   
				   }
			   } else {
					bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Lanzado 13+ ","Falta Identificacion"), null, utileriaCadena.obtenerCadenaConcatenada(true, "13+-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), null);
					servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
					request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
				   salidaRespuesta.setResultadoActualizacion(ServiciosConstants.TEXTO_SIN_EXPEDIENTE);

			   }
			}else{
				String respuestaSellos = modificacionTrabajadorService.consultarSellos(entradaModificacion, user,trabajador.getTipoSolicitante());
				if(ModificacionTrabajadorConstants.RESULTADO_OK.equals(respuestaSellos)){
					bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Lanzado 13+ ","Entra mesa control"), null,"13+", entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), "MESA");
					this.insertarBitacoraProcesosPendientesModificacion(entradaModificacion, trabajador, null, flujoModificacion.getFolioIdentificacion(), user,folioPadre,flujoModificacion,entradaSolicitante);
					modificacionTrabajadorService.notificarTiempoTramite(folioPadre.getChFolio(), consulta.getFolioPrevio(),trabajador.getClaveAfore());
					salidaRespuesta.setResultadoActualizacion(ServiciosConstants.MESA_CONTROL);
					RespuestaServicio  resultado = servicioCatalogo.obtenerRespuesta(null, ParametrosConstants.RECHAZO_MESA_ACLARACION, user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
					request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, resultado);
				}else{
					servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),2);
					request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
					salidaRespuesta.setResultadoActualizacion(ModificacionTrabajadorConstants.SIN_SELLO);
				}
			}
		}catch(Exception e){
			logger.error("Error sello {}",e.getMessage());
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
			if(!utileriaValidador.validarObjetoNulo(e.getMessage()) && ("EL TRABAJADOR NO CUENTA CON SELLO".equals(e.getMessage()) || "EL EMPLEADO NO CUENTA CON SELLO".equals(e.getMessage()))) {
				salidaRespuesta.setResultadoActualizacion(e.getMessage());
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Lanzado 13+ ",e.getMessage()), null, utileriaCadena.obtenerCadenaConcatenada(false, "13+","-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(), ModificacionTrabajadorConstants.SIN_SELLO);

			} else {
				salidaRespuesta.setResultadoActualizacion(ModificacionTrabajadorConstants.RESULTADO_ERROR);
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDEXPESERVICIO, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Lanzado 13+ ",e.getMessage()), null, utileriaCadena.obtenerCadenaConcatenada(false, "13+","-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folioHijo.getChFolio(),ModificacionTrabajadorConstants.RESULTADO_ERROR);

			}
			logger.error("Exception al actualizar datos de trabajador: {} ", e.getCause());
			logger.error("Exception al actualizar: {}",e);
		}
		logger.info("Se regresa respuestaActualizacion: {}",salidaRespuesta);
		return salidaRespuesta;
	}
	
	
	/**
	 * Realiza Permanencia Expediente
	 * 
	 * @author María Elena Domínguez (medoming@procesar.com)
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/private/permanenciaExp", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String ejecutarPermanenciaExp(HttpServletRequest request){
		logger.info("<<<<<<<<<<Ingreso a /ejecutarPermanenciaExp>>>>>>>>>>");
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Folio folio = (Folio)request.getSession().getAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		StringBuilder respuesta = new StringBuilder();
		VerificacionSello verificacion = null;
		try {
			validarExpeIdentificacionMesa(request);
			String banderaMesa = (String)request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_MESA_CONTROL);
			FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
			EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			EntradaSolicitante entradaSolicitante = (EntradaSolicitante) request.getSession().getAttribute(ParametrosConstants.ENTRADA_SOLICITANTE);

			
			Integer entradaMesa = NumerosConstants.INT_CERO;
	
			logger.info("Bandera mesa control :: ejecutarPermanenciaExp: {}",banderaMesa);
			
			SalidaPermanencia respuestaPermanencia = null;
			ExpedienteSalida salida = validarExpedientesPermanencia(entradaPermanencia.getCurpTrabajador(), trabajador.getTipoSolicitante(), trabajador, request);
			String noTitular = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_NO_TITULAR);
			bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, "Inicio Proceso Ejecucion Op17 ", null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), "ENPROCESO");
	
			if(utileriaValidador.validarObjetoNulo(banderaMesa)){
				if(NumerosConstants.C_UNO.equals(salida.getEstatusExpedienteIdentificacion()) && user.getAforeUsuario().equals(utileriaCadena.asignarValor(salida.getClaveAforeExpIdentificacion())) || NumerosConstants.C_CINCO.equals(salida.getEstatusExpedienteIdentificacion())){
					if(NumerosConstants.C_DOS.equals(salida.getEstatusEnrolamiento()) && user.getAforeUsuario().equals(utileriaCadena.asignarValor(salida.getClaveAforeExpBiometrico())) || NumerosConstants.C_CINCO.equals(salida.getEstatusEnrolamiento()) || NumerosConstants.C_UNO.equals(noTitular)){
						 verificacion = modificacionTrabajadorService.validaSelloPermanencia(user.getCurpAgente(),entradaPermanencia.getCurpTrabajador(),user.getAforeUsuario(),trabajador.getTipoSolicitante());
						if(!utileriaValidador.validarObjetoNulo(verificacion.getSello()) || NumerosConstants.C_UNO.equals(noTitular)){
							 respuestaPermanencia = modificacionTrabajadorService.ejecutarPermanencia(entradaPermanencia);
		
						}else{
							respuesta.append(ModificacionTrabajadorConstants.SIN_SELLO);
							bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Ejecucion Op17 ",ModificacionTrabajadorConstants.SIN_SELLO), null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), ModificacionTrabajadorConstants.SIN_SELLO);
	
						}
					}else{
						respuesta.append(ServiciosConstants.TEXTO_SIN_ENROLAMIENTO);
						bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Ejecucion Op17 ","NOENROLAMIENTO"), null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), "FALTANTE");
	
					}
				}else{
					respuesta.append(ServiciosConstants.TEXTO_SIN_EXPEDIENTE);
					bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso Ejecucion Op17 ","NOIDENTIFICACION"), null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), "FALTANTE");
	
				}	
			}else{
				RespuestaServicio resultado = null;
				entradaMesa = NumerosConstants.INT_UNO;
				logger.info("Entrada mesa control: {}",entradaMesa);
				modificacionTrabajadorService.notificarTiempoTramite(folioPadre.getChFolio(), consulta.getFolioPrevio(),trabajador.getClaveAfore());
				this.insertarBitacoraProcesoPendientesPermanencia(entradaPermanencia, trabajador, flujo.getFolioIdentificacion(), user,folioPadre,flujo,entradaSolicitante);
				resultado = servicioCatalogo.obtenerRespuesta(null, ParametrosConstants.RECHAZO_MESA_ACLARACION, user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
				respuesta.append(ServiciosConstants.MESA_CONTROL);
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, utileriaCadena.obtenerCadenaConcatenada(true, "Proceso ejecucion Op17 ",ServiciosConstants.MESA_CONTROL), null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), "MCONTROL");
				request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, resultado);
			}
			if(respuestaPermanencia != null){
				logger.info("Se ejecuto permanencia ");
				logger.error("SALIDA PERMANENCIA :::: {}", respuestaPermanencia.getSsnrop().getCodRespuesta());
				if(ModificacionTrabajadorConstants.RESULTADO_OK.equals(respuestaPermanencia.getSsnrop().getCodRespuesta())){
					respuesta.append(ModificacionTrabajadorConstants.RESULTADO_OPERACION.equals(respuestaPermanencia.getObjetoRespuesta().getResultadoDeLaOperacion()) ? "RECHAZADO" : "ACEPTADO");
					respuesta.append("|");
					respuesta.append(respuestaPermanencia.getObjetoRespuesta().getDiagnosticoDeRecepcion());
					respuesta.append("|");
					logger.info("Resultado Permanencia :: {}",respuesta);
					String selloPermanencia = null;
					if(NumerosConstants.C_UNO.equals(noTitular)) {
						selloPermanencia = "00000000000000";
					}else {
						selloPermanencia = String.valueOf(verificacion.getSello().getId());
					}
					modificacionTrabajadorService.registraSolicitudReimpresionModificacion(null, entradaPermanencia, respuestaPermanencia.getObjetoRespuesta().getDiagnosticoDeRecepcion(), folio.getChFolio(), selloPermanencia);

					String diagnosticoCorto = modificacionTrabajadorService.obtenerDiagnosticoCorto(respuestaPermanencia.getObjetoRespuesta().getDiagnosticoDeRecepcion());
					bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, "Op17 Ejecutada", diagnosticoCorto, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), "Ejecutada");
					
					modificacionTrabajadorService.notificarTiempoTramite(folioPadre.getChFolio(), consulta.getFolioPrevio(),trabajador.getClaveAfore());
					notificacionExpedienteService.envioNotificacionPermanencia(respuestaPermanencia.getObjetoRespuesta(), entradaPermanencia,folioPadre,flujo);
					modificacionTrabajadorService.cerrarFolioOrigen(flujo);
					servicioFolio.cerrarFolio(folio.getIdFolioPulssar(),NumerosConstants.INT_TRES);
				}else{
					respuesta.append(ModificacionTrabajadorConstants.RESULTADO_ERROR);
					bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, "Op17 Ejecutada ERROR", null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), ModificacionTrabajadorConstants.RESULTADO_ERROR);
					servicioFolio.cerrarFolio(folio.getIdFolioPulssar(),NumerosConstants.INT_DOS);
				}
			}else if(NumerosConstants.INT_CERO.equals(entradaMesa)){
					servicioFolio.cerrarFolio(folio.getIdFolioPulssar(),NumerosConstants.INT_DOS);
			}
		}catch (Exception e) {
			logger.error("Ocurrio un error al ejecutar permanencia: {}",e);
			respuesta.append(ModificacionTrabajadorConstants.RESULTADO_ERROR);
			bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MODIFICACION_DATOS, "Op17 Exeption", null, "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio.getChFolio(), ModificacionTrabajadorConstants.RESULTADO_ERROR);
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(),NumerosConstants.INT_DOS);
		}
		logger.info("Respuesta Final permanencia :: {}",respuesta);
		return respuesta.toString();
	}
	
	/**
	 * Metodo encargadop de cargar objeto para servicio de modificacion de datos 
	 * @param entradaModificacion
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/private/cargaEntradaPermanencia.do")
	@ResponseBody
	public RespuestaServicio cargaEntradaPermanencia(@RequestBody CargaPermanencia cargaPermanencia, HttpServletRequest request, Model model){
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);

		RespuestaServicio respuestaServicio = new RespuestaServicio();
		logger.info("cargaEntradaPermanencia: {} ",cargaPermanencia);
		this.validarNssPermanencia(request, cargaPermanencia.getEntradaPermanencia());
		request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, cargaPermanencia.getEntradaPermanencia());		
		respuestaServicio.setMensaje(ParametrosConstants.SUCCESS);
		
		if(!utileriaValidador.validarObjetoNulo(cargaPermanencia.getEntradaSolicitante())) {
			cargaPermanencia.getEntradaSolicitante().setTipoSolicitante(trabajador.getTipoSolicitante());
			cargaPermanencia.getEntradaSolicitante().setTipoProceso(NumerosConstants.C_DOS);
			request.getSession().setAttribute(ParametrosConstants.ENTRADA_SOLICITANTE, cargaPermanencia.getEntradaSolicitante());
		}
		
		return respuestaServicio;
	}
	
	/**
	 * Realiza la carga del combo Municipios
	 * 
	 * @author María Elena Domínguez (medoming@procesar.com)
	 * @param entidad
	 * @return List<EntidadFederativa>
	 */
	@GetMapping(value = "/private/cargaEntidades")
	@ResponseBody
	public List<EntidadFederativa> cargaEntidades(){
		logger.info("<<<<<<<<<<Ingreso a /cargaMunicipios>>>>>>>>>>");	
		return catalogoService.obtenerEntidades();
	}

	
	/**
	 * Realiza la carga del combo Municipios
	 * 
	 * @author María Elena Domínguez (medoming@procesar.com)
	 * @param entidad
	 * @return List<NsarMunicipio>
	 */
	@GetMapping(value = "/private/cargaMunicipios")
	@ResponseBody
	public List<NsarMunicipio> cargaMunicipios(String entidad){
		logger.info("<<<<<<<<<<Ingreso a /cargaMunicipios>>>>>>>>>>");	
		return catalogoService.obtenerMunicipiosPorEntidad(entidad);
	}
	
	/**
	 * Realiza carga de nacionalidad
	 * @param cveNacionalidad
	 * @return
	 */
	@GetMapping(value = "/private/cargaNacionalidad")
	@ResponseBody 
	public Nacionalidad cargaNacionalidad(String cveNacionalidad){
		logger.info("<<<<<<<<<<Ingreso a /cargaNacionalidad>>>>>>>>>>");
		Nacionalidad nacionalidad = catalogoService.obtenerNacionalidadPorClave(cveNacionalidad);
        logger.info("Nacionalidad: {}",nacionalidad);		
		return nacionalidad;
	}
	
	/**
	 * Metodo encarga de obtener el valor de la bandera que indica si se mostrara la seccion de Referencias y Beneficiarios
	 * @param afore
	 * @return
	 */
	public String obtenerValorBanderaSecciones(String afore){
		String result = NumerosConstants.C_CERO;
		try {
			List<Parametro> listaParametros = catalogoService.obtenerParametroDdbpose(ModificacionTrabajadorConstants.P00009);
			for (Parametro parametro : listaParametros) {
				if(parametro.getChValorParametro().equals(afore)){
					result = NumerosConstants.C_UNO;
				}
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error inesperado al obtenerValorBanderaSecciones",e);
		}
		return result;
	}
	
	/**
	 * Obtiene los datos del Renapo 
	 * @param entradaModificacion
	 * @return
	 */
	private Renapo obtenerDatosRenapo(EntradaModificacion entradaModificacion){
		Renapo result = null;
		try{
			DatosTrabajador datosTrabajadorAux = new DatosTrabajador();
			
			DatosNoCertificables datosNoCertificablesAux = new DatosNoCertificables();
			DatosCertificables datosCertificablesAux = new DatosCertificables();
			datosCertificablesAux.setNombre(entradaModificacion.getDatosBaseCurp().getNombreTrabajador());
			datosCertificablesAux.setApellidoPaterno(entradaModificacion.getDatosBaseCurp().getApellidoPaterno());
			datosCertificablesAux.setApellidoMaterno(entradaModificacion.getDatosBaseCurp().getApellidoMaterno());
			datosTrabajadorAux.setDatosCertificables(datosCertificablesAux);
			
			String generoTrabajador = null;
			if(entradaModificacion.getDatosBaseCurp().getSexo().equals(ModificacionTrabajadorConstants.MUJER_2)){
				generoTrabajador = ModificacionTrabajadorConstants.GENERO_FEMENINO; 
			}else if(entradaModificacion.getDatosBaseCurp().getSexo().equals(ModificacionTrabajadorConstants.HOMBRE_1)){
				generoTrabajador = ModificacionTrabajadorConstants.GENERO_MASCULINO;
			}
			
			String fechaNacimientoTrabajador = entradaModificacion.getDatosBaseCurp().getFechaDeNacimiento();
			Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(fechaNacimientoTrabajador,  FormatoConstants.FORMATO_SERVICIO_MODIFICACION) ;
			fechaNacimientoTrabajador = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_FECHA_NACIMIENTO);
			
			String cveEntidadNacimientoTrabajador = entradaModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento();
			EntidadFederativa  entidadFederativa = catalogoService.obtenerEntidadFederativa(cveEntidadNacimientoTrabajador);
			
			datosTrabajadorAux.getDatosCertificables().setCurp(entradaModificacion.getDatosBaseCurp().getCurpNueva());
			datosTrabajadorAux.getDatosCertificables().setGenero(generoTrabajador);
			datosTrabajadorAux.getDatosCertificables().setFechaNacimiento(fechaNacimientoTrabajador);
			datosTrabajadorAux.getDatosCertificables().setEntidadNacimiento(entidadFederativa.getDescripcion());
			
			if(!utileriaValidador.validarObjetoNulo(entradaModificacion.getDatosBaseCurp().getNacionalidad())){
				datosNoCertificablesAux.setClaveNacionalidad(Long.parseLong(entradaModificacion.getDatosBaseCurp().getNacionalidad()));
				datosTrabajadorAux.setDatosNoCertificables(datosNoCertificablesAux);
			}
			
			result = modificacionTrabajadorService.obtenerDatosRenapo(datosTrabajadorAux); 
		}catch(Exception e){
			logger.error("Ocurrio un error inesperado al obtener los datos del Renapo",e);
		}
		return result;
	}
	
	/**
	 * Recupera flujo de entrada
	 * @param request
	 * @param datosTrabajador
	 * @param entradaModificacion
	 * @param model
	 * @return
	 */
	private FlujosEntrada recuperaFlujoEntrada(HttpServletRequest request,DatosTrabajador datosTrabajador, EntradaModificacion entradaModificacion, ModelAndView model){
		logger.info("Inicio - recuperaFlujoEntrada");
		FlujosEntrada flujoEntrada = null;
		try {
			consultarExpedientesFlujo(request);
			ExpedienteSalida expediente = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
			logger.info("Resultado validarExpedienteTipoSolicitante: {}", expediente);
					   flujoEntrada = modificacionTrabajadorService.obtenerRespuestaFlujo(entradaModificacion,datosTrabajador, expediente);
					   if(!utileriaValidador.validarVacio(flujoEntrada.getFlujoValidacion())){
						   logger.info("Flujo Validacion:  {}",flujoEntrada.getFlujoValidacion());
						   model.addObject("flujoValidacion", flujoEntrada.getFlujoValidacion());
					   }	      
		} catch (Exception e) {
			logger.error("Ocurrio un error inesperado al recuperar el Flujo: ", e);
 		}
		return flujoEntrada;
	}
	
	
	@GetMapping(value = { "/private/validaMarcasOperativas.do" }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarMarcasOperativasTrabajador(@RequestParam("idProcesar") Long idProcesar, @RequestParam("cveProceso") String cveProceso,  HttpServletRequest request){
		logger.info("Inicio validarMarcasOperativasTrabajador");
		logger.info("idProcesar >> {} cveProceso >> {}",idProcesar, cveProceso);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);


			if("A001".equals(cveProceso)){
				request.getSession().setAttribute(ParametrosConstants.BANDERA_13, NumerosConstants.C_UNO);
			}else if("A005".equals(cveProceso)){
				request.getSession().setAttribute(ParametrosConstants.BANDERA_PERMANENCIA, NumerosConstants.C_UNO);
			}
		
		if(Constants.TIPO_SOLICITANTE_BENEFICIARIO.equals(trabajador.getTipoSolicitante())) {
			String claveBeneficiario = "A001";
			cveProceso = claveBeneficiario;
			request.getSession().setAttribute(ParametrosConstants.BANDERA_13, NumerosConstants.C_UNO);
		}
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try {
			respuestaServicio = modificacionTrabajadorService.validarMarcasOperativasTrabajador(idProcesar, cveProceso,folioHijo);
		} catch (Exception e) {
			logger.error("Error existen marcas operativas que impiden la operacion " , e);
		}
		return respuestaServicio;
	}
	
	
	/**
	 * Consulta expediente de Identificación para validacion de domicilio Particular
	 * @param curp
	 * @param cveProceso
	 * @param estatus
	 * @return
	 */
	public Boolean verificarExpedienteIdentificacionParaValidarDomicilio(String curp, String cveProceso,String estatus){
		logger.info("Inicio verificarExpedienteIdentificacionParaValidarDomicilio");
		logger.info("Curp>> {}",curp);
		logger.info("CveProceso>> {}",cveProceso);
		logger.info("Estatus>> {}",estatus);
		Boolean isValidoExpedienteIdentificacion = null;
		try{
			ExpedienteDetail expedienteDetail = expedienteService.consultarExpedienteProcesoSinAfore(curp, cveProceso,estatus);
			logger.info("expedienteDetail: {}",expedienteDetail);
		}catch(Exception e){
			logger.error("Ocurrio un error inesperado al verificar expediente de identificación para validar el domicilio", e);
		}
		logger.info("isValidoExpedienteIdentificacion: {}",isValidoExpedienteIdentificacion);
		return isValidoExpedienteIdentificacion;
	}
	
	
	
	/**
	 * Valida la existencia del expediente de identificacion
	 * @param curp
	 * @param cveProceso
	 * @param estatus
	 * @return
	 */
	public Boolean validaExistenciaExpedienteIdentificacion(String curp, String cveProceso,String estatus){
		logger.info("Inicio validaExistenciaExpedienteIdentificacion");
		logger.info("Curp>> {}",curp);
		logger.info("CveProceso>> {}",cveProceso);
		logger.info("Estatus>> {}",estatus);
		Boolean isValidoExpedienteIdentificacion = null;
		try{
			ExpedienteDetail expedienteDetail = expedienteService.consultarExpedienteProcesoSinAfore(curp, cveProceso,estatus);
			logger.info("expedienteDetail: {}",expedienteDetail);
		}catch(Exception e){
			logger.error("Ocurrio un error inesperado al validar la existencia del expediente de identificación {}", e);
		}
		logger.info("isValidoExpedienteIdentificacion: {}",isValidoExpedienteIdentificacion);
		return isValidoExpedienteIdentificacion;
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

	/**
	 * Asignar datos certificables
	 * @param trabajador
	 * @return
	 */
	private DatosCertificables asignarDatosCertificables(DatosTrabajador trabajador){
		DatosCertificables datosCertificables = new DatosCertificables();

		datosCertificables.setCurp(trabajador.getDatosCertificables().getCurp());
		datosCertificables.setNombre(trabajador.getDatosCertificables().getNombre());
		datosCertificables.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
		datosCertificables.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
		datosCertificables.setFechaNacimiento(trabajador.getDatosCertificables().getFechaNacimiento());
		datosCertificables.setClaveGenero(trabajador.getDatosCertificables().getClaveGenero());
		datosCertificables.setGenero(trabajador.getDatosCertificables().getGenero());
		datosCertificables.setClaveEntidadN(trabajador.getDatosCertificables().getClaveEntidadN());
		datosCertificables.setEntidadNacimiento(trabajador.getDatosCertificables().getEntidadNacimiento());
		datosCertificables.setIdTipoDoctoProbatorio(trabajador.getDatosCertificables().getIdTipoDoctoProbatorio());
		datosCertificables.setGenero(trabajador.getDatosCertificables().getGenero());
		return datosCertificables;
		
	}
	
	
	/**
	 * Metodo encargadop de cargar objeto para servicio de modificacion de datos 
	 * @param entradaModificacion
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/private/validaExpedientesFlujo.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void validarExpedientesFlujo(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException{
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String banderaFlujo9B = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);

		
		logger.info("13 :: {}",bandera13);
		logger.info("P :: {}", banderaP);
		FlujoModificacion flujoModificacion = new FlujoModificacion();
		flujoModificacion.setTipoAfiliacion(trabajador.getTipoAfiliacion());
		request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoModificacion);
		Folio folio = (Folio)request.getSession().getAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS);

		RespuestaServicio respuesta = null;
		
		ExpedienteSalida expediente = null;
		String controladorBiometrico = null;
		String controladorIdentificacion = null;
		Integer respuestaMarca = NumerosConstants.INT_CERO;
		String controlador = ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO;
		try{

				consultarExpedientesFlujo(request);
				expediente = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
				if(!utileriaValidador.validarVacio(bandera13)) {
					expedienteServicioService.validaArregloCambiosBeneficiarios(trabajador.getDatosComplementarios(), entradaModificacion.getListaBeneficiariosTrabajador(), entradaModificacion,NumerosConstants.C_UNO);
					logger.info("objeto 13+ despues validaArregloCambiosBeneficiarios: {}",entradaModificacion);
					request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
					FlujosEntrada flujo = modificacionTrabajadorService.obtenerRespuestaFlujo(entradaModificacion, trabajador, expediente);
					entradaModificacion.getDatosBaseCurp().setFlujoDeValidacion(flujo.getFlujoValidacion());
					entradaModificacion.setTipoDeMovimiento(flujo.getMovimiento());
				}
				controladorBiometrico = modificacionTrabajadorService.validarExpedienteBiometrico(expediente, user,trabajador,entradaModificacion,flujoModificacion,banderaFlujo9B);
				controladorIdentificacion = modificacionTrabajadorService.validarExpedienteIdentificacion(expediente, user,trabajador,entradaModificacion,flujoModificacion,banderaFlujo9B);
				String estatusExpeIdentificacion = expediente.getEstatusExpedienteIdentificacion();
				boolean respuestaValidacion = validaDatosGenerarNuevoIde(trabajador, entradaModificacion, entradaPermanencia, request);
				estatusExpeIdentificacion = modificacionTrabajadorService.validarCambioCurpCoppel(estatusExpeIdentificacion, user.getAforeUsuario(), trabajador, entradaModificacion, bandera13);
				controladorIdentificacion= validaActualizaImagenes(request,user.getAforeUsuario(), estatusExpeIdentificacion, respuestaValidacion, controladorIdentificacion);
				if(!utileriaValidador.validarVacio(bandera13) && ParametrosConstants.VALOR_COPPEL.equals(user.getAforeUsuario())) {
					boolean validaNombre = modificacionTrabajadorService.validarNombreCompleto(trabajador, entradaModificacion);
					boolean validaDatosBase = modificacionTrabajadorService.varlidarDatosBase(trabajador, entradaModificacion);
					if(!validaNombre && !validaDatosBase && NumerosConstants.C_CINCO.equals(estatusExpeIdentificacion) && respuestaValidacion) {
						request.getSession().setAttribute(ParametrosConstants.BANDERA_13, null);
						request.getSession().removeAttribute(ParametrosConstants.BANDERA_13);
						bandera13 = null;
						entradaModificacion = null;
						request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, null);	
						request.getSession().removeAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
						request.getSession().setAttribute(ParametrosConstants.SESION_EXPEDIENTE, null);
						request.getSession().removeAttribute(ParametrosConstants.SESION_EXPEDIENTE);
						request.getSession().setAttribute(ParametrosConstants.BANDERA_PERMANENCIA, NumerosConstants.C_UNO);
						RespuestaServicio respuestaServicio = modificacionTrabajadorService.validarMarcasOperativasTrabajador(trabajador.getProcesar(), "A005", folio);
						respuestaMarca = respuestaServicio.getFlujo();
						modificacionTrabajadorService.validaMarcasProcesoPermanencia(respuestaMarca);
					}else {
						entradaPermanencia = null;
						request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, null);
					}
				}
				
				controladorIdentificacion = modificacionTrabajadorService.validaExpedienteCambioCurp(trabajador, entradaModificacion, bandera13, controladorIdentificacion, ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION, user.getAforeUsuario());
				if(!utileriaValidador.validarObjetoNulo(controladorBiometrico)){
			    	controlador = controladorBiometrico;
			    }else if(!utileriaValidador.validarObjetoNulo(controladorIdentificacion) && utileriaValidador.validarObjetoNulo(controladorBiometrico)){
			    	controlador = controladorIdentificacion;
			    }
			    
			    if(ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO.equals(controlador) && !utileriaValidador.validarVacio(bandera13)){
			    	controlador = validarSelloFlujo(request);
			    	if(utileriaValidador.validarVacio(controlador)){
			    		controlador = ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO;
			    	}			    		
			    }else if (ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO.equals(controlador) && !utileriaValidador.validarVacio(banderaP)){
			    	controlador = validarSelloFlujo(request);
			    	if(utileriaValidador.validarVacio(controlador)){
				    	controlador = ModificacionTrabajadorConstants.CONTINUAR_PERMANENCIA;
			    	}
			    }
			    String flujo = modificacionTrabajadorService.validaFlujoDigitalizador(flujoModificacion, expediente, entradaModificacion, trabajador, bandera13,banderaFlujo9B);
			    request.getSession().setAttribute(ParametrosConstants.FLUJO_DIGITALIZADOR, flujo);
			    String folioPadreOrigen = modificacionTrabajadorService.recuperarFolioOrigenPorProceso(user, trabajador, bandera13, banderaP, entradaModificacion, entradaPermanencia,flujoModificacion);
			   flujoModificacion.setFolioPulssarOrigen(utileriaCadena.obtenerContenidoCadenaSinEspacios(folioPadreOrigen, null));
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoModificacion);
			   modificacionTrabajadorService.guardarFlujoBitacora(controlador, entradaModificacion, folioPadre,entradaPermanencia,bandera13,banderaP);
		}catch(Exception e){
			if(NumerosConstants.INT_DOS.equals(respuestaMarca)) {
				RespuestaServicio mensajeMarcas = new RespuestaServicio();
				mensajeMarcas.setFlujo(NumerosConstants.INT_DOS);
				mensajeMarcas.setTitulo("Modificacion de datos");
				mensajeMarcas.setMensaje("Existen marcas operativas que impiden la operación");
				
				controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
				request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, mensajeMarcas);
			}else {
				servicioFolio.cerrarFolio(folio.getIdFolioPulssar(),2);
				logger.error("Ocurrio un error al validarExpedientesFlujo {}",e);
				respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
				controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
				request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuesta);
			}
			
		}
		logger.info("controlador validarExpedientesFlujo {} ",controlador);
		response.sendRedirect(utileriaCadena.obtenerCadenaConcatenada(false, request.getContextPath(),controlador));
	}
	
	/**
	 * Metodo que valida Flujo para continuacion de modificacion de datos
	 * @param response
	 * @param request
	 * @param model
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "/private/continuarFlujoModificacion.do", method = {RequestMethod.GET, RequestMethod.POST})
	public void continuarFlujoModificacion(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException{
		FlujoModificacion flujo = (FlujoModificacion)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		logger.info("flujo continuarFlujoModificacion {} ",flujo);
		String controlador = null;
		ExpedienteSalida expediente = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		Folio folio = (Folio)request.getSession().getAttribute(ParametrosConstants.FOLIO_MODIFICACION_DATOS);
		RespuestaServicio respuesta = null;
		try {
			logger.info("Entrada a bloque de validaciones");
			controlador = validarEnrolamiento(request,expediente,flujo,user);
			controlador = validarExpeIdentificacion(request,flujo,user,controlador);
			controlador = validarSelloTrabajador(request,flujo,user,controlador);
			logger.info("controlador continuarFlujoModificacion {} ",controlador);
		}catch (BusinessException be) {
			controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
			logger.error("Business Excepcion en  continuarFlujoModificacion{} {}", be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(),user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			String motivoRechazo = modificacionTrabajadorService.acortarMotivoRechazo(be.getCodigo());

			if(BusinessErrorEnum.SOLICITUD_RECHAZADA.getClave().equals(be.getCodigo())) {
				respuesta.setMensaje(respuesta.getMensaje().replace("{rechazo}", flujo.getMotivoRechazo()));
				motivoRechazo = modificacionTrabajadorService.acortarMotivoRechazo(flujo.getMotivoRechazo());

			}
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS, motivoRechazo);
			request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuesta);

		}catch (Exception e) {
			logger.error("Ocurrio un error al continuar flujo modificacion {}",e);
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS, null);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
			request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuesta);
		}
		response.sendRedirect(utileriaCadena.obtenerCadenaConcatenada(false, request.getContextPath(),controlador));

	}
	
	/**
	 * Metodo que valida recepcion de enrolamiento
	 * @param expediente
	 * @param flujo
	 * @param user
	 * @return
	 */
	private String validarEnrolamiento(HttpServletRequest request,ExpedienteSalida expediente,FlujoModificacion flujo,UsuarioLogin user){
		String controlador = null;
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		String banderaFlujo9B = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);


		logger.info("flujo validarEnrolamiento {} ",flujo);
		
		logger.info("13 Valida Enrolamiento :: {}",bandera13);
		logger.info("P Valida Entolamiento :: {}", banderaP);
		if(!utileriaValidador.validarVacio(flujo.getBanderaEnrolamiento()) && NumerosConstants.C_UNO.equals(flujo.getBanderaEnrolamiento())){
			request.getSession().setAttribute(ParametrosConstants.BANDERA_ENTRADA_ENROLAMIENTO, NumerosConstants.C_UNO);
			if(NumerosConstants.C_UNO.equals(flujo.getBanderaRespuestaEnrolamiento())){
				controlador = modificacionTrabajadorService.validarExpedienteIdentificacion(expediente, user,trabajador,entradaModificacion,flujo,banderaFlujo9B);
				String estatusExpeIdentificacion = expediente.getEstatusExpedienteIdentificacion();
				boolean respuestaValidacion = validaDatosGenerarNuevoIde(trabajador, entradaModificacion, entradaPermanencia, request);
				estatusExpeIdentificacion = modificacionTrabajadorService.validarCambioCurpCoppel(estatusExpeIdentificacion, user.getAforeUsuario(), trabajador, entradaModificacion, bandera13);
				controlador = validaActualizaImagenes(request,user.getAforeUsuario(), estatusExpeIdentificacion, respuestaValidacion, controlador);
				controlador = modificacionTrabajadorService.validaExpedienteCambioCurp(trabajador, entradaModificacion, bandera13, controlador, ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION, user.getAforeUsuario());
				if(utileriaValidador.validarVacio(controlador)){
					controlador = validarFlujoEnrolamiento(request, controlador, flujo, bandera13, banderaP);
				}
				flujo.setBanderaEnrolamiento(NumerosConstants.C_CERO);
				flujo.setBanderaRespuestaEnrolamiento(NumerosConstants.C_CERO);
				guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDBIOMETRICO, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Biometrico Ejecutado", folioPadre,flujo.getFolioEnrolamiento().getChFolio());
				String flujo13 = modificacionTrabajadorService.validaFlujoDigitalizador(flujo, expediente, entradaModificacion, trabajador, bandera13,banderaFlujo9B);
			    request.getSession().setAttribute(ParametrosConstants.FLUJO_DIGITALIZADOR, flujo13);
			}else if(NumerosConstants.C_DOS.equals(flujo.getBanderaRespuestaEnrolamiento())){
				logger.error("Error en enrolamiento modificacion :: validarEnrolamiento");
				RespuestaServicio respuesta = flujo.getRespuesta();
				guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDBIOMETRICO, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Error Proceso Biometrico", folioPadre,flujo.getFolioEnrolamiento().getChFolio());
				controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
				request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuesta);
			}
		}
		logger.info("controlador validarEnrolamiento {} ",controlador);
		return controlador;
	}
	
	/**
	 * Metodo que valida flujo enrolamiento
	 * @param request
	 * @param controlador
	 * @param flujo
	 * @param bandera13
	 * @param banderaP
	 * @return
	 */
	private String validarFlujoEnrolamiento(HttpServletRequest request,String controlador,FlujoModificacion flujo,String bandera13,String banderaP) {
		controlador = validarSelloFlujo(request);
		if(utileriaValidador.validarVacio(controlador)){
			if(!utileriaValidador.validarVacio(bandera13)){
				controlador = ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO;
			}else if(!utileriaValidador.validarVacio(banderaP)){
				controlador = ModificacionTrabajadorConstants.CONTINUAR_PERMANENCIA;
			}
		}
		return controlador;
	}
	
	/**
	 * Metodo que valida recepcion identificacion
	 * @param expediente
	 * @param flujo
	 * @param user
	 * @return
	 */
	private String validarExpeIdentificacion(HttpServletRequest request,FlujoModificacion flujo,UsuarioLogin user,String controladorEnrolamiento){
		String controlador = controladorEnrolamiento;
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		
		logger.info("flujo validarExpeIdentificacion {} ",flujo);
		if(Constants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
			if(!utileriaValidador.validarVacio(flujo.getBanderaIdentificacion()) && NumerosConstants.C_UNO.equals(flujo.getBanderaIdentificacion())){
				request.getSession().setAttribute(ParametrosConstants.BANDERA_ENTRADA_IDENTIFICACION, NumerosConstants.C_UNO);
				if(NumerosConstants.C_UNO.equals(flujo.getBanderaRespuestaIdentificacion())){
					controlador = this.validarRespuestaIDentificacion(request, flujo, controlador, bandera13, banderaP);
					guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Identificacion Ejecutado", folioPadre,flujo.getFolioIdentificacion().getChFolio());
				}else if(NumerosConstants.C_DOS.equals(flujo.getBanderaRespuestaIdentificacion())){
					if(!ModificacionTrabajadorConstants.RECHAZO_MESA_CONTROL.equals(utileriaCadena.asignarValor(flujo.getMotivoRechazo()))){
						logger.error("Error en identificacion modificacion :: validarExpeIdentificacion");
						guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Error Proceso Identificacion", folioPadre,flujo.getFolioIdentificacion().getChFolio());
						RespuestaServicio respuestaErrorIdentificacion = flujo.getRespuesta();
						controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
						request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuestaErrorIdentificacion);
					}else{
						request.getSession().setAttribute(ModificacionTrabajadorConstants.BANDERA_MESA_CONTROL, NumerosConstants.C_UNO);
						controlador = this.validarRespuestaIDentificacion(request, flujo, controlador, bandera13, banderaP);
					}
				}
			}
		}else{
			if(!utileriaValidador.validarVacio(flujo.getBanderaIdentificacion()) && NumerosConstants.C_UNO.equals(flujo.getBanderaIdentificacion())){
				request.getSession().setAttribute(ParametrosConstants.BANDERA_ENTRADA_IDENTIFICACION, "1");
				if(NumerosConstants.C_UNO.equals(flujo.getBanderaRespuestaIdentificacion())){
					guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Identificacion Ejecutado", folioPadre,flujo.getFolioIdentificacion().getChFolio());
					controlador = modificacionTrabajadorService.validarBanderaFlujo(controlador, bandera13, banderaP);
				
					flujo.setBanderaIdentificacion(NumerosConstants.C_CERO);
					flujo.setBanderaRespuestaIdentificacion(NumerosConstants.C_CERO);
				}else if(NumerosConstants.C_DOS.equals(flujo.getBanderaRespuestaIdentificacion())){
					if(!ModificacionTrabajadorConstants.RECHAZO_MESA_CONTROL.equals(utileriaCadena.asignarValor(flujo.getMotivoRechazo()))){
						logger.error("Error en identificacion modificacion :: validarExpeIdentificacion");
						guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Error Proceso Identificacion", folioPadre,flujo.getFolioIdentificacion().getChFolio());
						RespuestaServicio respuesta = flujo.getRespuesta();
						controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
						request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuesta);
					}else{
						request.getSession().setAttribute(ModificacionTrabajadorConstants.BANDERA_MESA_CONTROL, NumerosConstants.C_UNO);

						controlador = modificacionTrabajadorService.validarBanderaFlujo(controlador, bandera13, banderaP);

						flujo.setBanderaIdentificacion(NumerosConstants.C_CERO);
						flujo.setBanderaRespuestaIdentificacion(NumerosConstants.C_CERO);

					}
				}
			}
		}
		logger.info("controlador validarExpeIdentificacion {} ",controlador);
		return controlador;
	}
	
	/**
	 * Metodo que valida recepcion sello
	 * @param expediente
	 * @param flujo
	 * @param user
	 * @return
	 */
	private String validarSelloTrabajador(HttpServletRequest request,FlujoModificacion flujo,UsuarioLogin user,String controldorIdentificacion){
		String controlador = controldorIdentificacion;
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		
		if(!utileriaValidador.validarObjetoNulo(flujo.getBanderaExistenciabiometrico())) {
			if(NumerosConstants.INT_UNO_NEGATIVO.equals(flujo.getBanderaExistenciabiometrico())) {
				throw new BusinessException(BusinessErrorEnum.SOLICITUD_RECHAZADA);

			}else if(NumerosConstants.INT_DOS.equals(flujo.getBanderaExistenciabiometrico())) {
				throw new BusinessException(BusinessErrorEnum.PROCESO_CONFORMACION_BIOMETTICO);
			}
		}
		logger.info("flujo validarSelloTrabajador {} ",flujo);
		if(ServiciosConstants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
			if(!utileriaValidador.validarVacio(flujo.getBanderaSelloTrabajador()) && NumerosConstants.C_UNO.equals(flujo.getBanderaSelloTrabajador())){
				if(NumerosConstants.C_UNO.equals(flujo.getBanderaRespuestaSelloTrabajador())){
						if(!utileriaValidador.validarVacio(bandera13)){
							controlador = ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO;
						}else if(!utileriaValidador.validarVacio(banderaP)){
							controlador = ModificacionTrabajadorConstants.CONTINUAR_PERMANENCIA;
						}
					guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDVERIFICACION, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Sello ejecutado", folioPadre,flujo.getFolioSelloTrabajador().getChFolio());
					flujo.setBanderaSelloTrabajador(NumerosConstants.C_CERO);
					flujo.setBanderaRespuestaSelloTrabajador(NumerosConstants.C_CERO);
				}else if(NumerosConstants.C_DOS.equals(flujo.getBanderaRespuestaSelloTrabajador())){
					guardarBitacoraFlujo(ServiciosConstants.FOLIO_PROCESO_MDVERIFICACION, bandera13, banderaP, flujo, entradaPermanencia, entradaModificacion, "Error Proceso Sello", folioPadre,flujo.getFolioSelloTrabajador().getChFolio());
					logger.error("Error en sello modificacion :: validarSelloTrabajador");
					RespuestaServicio respuesta = flujo.getRespuesta();
					controlador = ModificacionTrabajadorConstants.DATOS_GENERALES;
					request.getSession().setAttribute(ParametrosConstants.ERROR_MODIFICACION, respuesta);
				}
			}
		}
		logger.info("controlador validarSelloTrabajador {} ",controlador);
		return controlador;
	}	
	
	/**
	 * Metodo que valida expedientes para manejo de flujo
	 * @param request
	 */
	private void consultarExpedientesFlujo(HttpServletRequest request){	
		logger.info("contenido expedientes : {}",request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE));
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);

		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);

		
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		if(Constants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
			if(!utileriaValidador.validarObjetoNulo(bandera13) && NumerosConstants.C_UNO.equals(bandera13)){
				String curp =  utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) ? utileriaCadena.asignarValor(entradaModificacion.getDatosBaseCurp().getCurpNueva()) : utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp());
					ExpedienteSalida salidaCurpIgual = expedienteService.validarRestExpedienteTipoSolicitante(curp,trabajador.getTipoSolicitante());
					request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salidaCurpIgual);
			}else if(!utileriaValidador.validarObjetoNulo(banderaP) && NumerosConstants.C_UNO.equals(banderaP)){
				ExpedienteSalida salidaPermanencia = expedienteService.validarRestExpedienteTipoSolicitante(entradaPermanencia.getCurpTrabajador(),trabajador.getTipoSolicitante());
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salidaPermanencia);
			}
		}else{
			validarExpedientesNoTitular(trabajador, request);
		}
	}
	
	/**
	 * Metodo que valida sello de trabajador
	 * @param request
	 * @return
	 */
	private String validarSelloFlujo(HttpServletRequest request){
		String controlador = null;
		String curp = null;
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String banderaEntradaEnrolamiento = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_ENTRADA_ENROLAMIENTO);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		FlujoModificacion flujo = (FlujoModificacion)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);

		
		if(ServiciosConstants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
			logger.info("13 Valida sello flujo :: {}",bandera13);
			logger.info("P Valida sello flujo :: {}", banderaP);
	    	if(!utileriaValidador.validarVacio(bandera13)){
	    		curp = entradaModificacion.getDatosBaseCurp().getCurpNueva();
	    		controlador = validarSelloCurp(request);
	    	}else{
	    		curp = entradaPermanencia.getCurpTrabajador();
	    		controlador = validarSelloCurp(request);
	    	}
			flujo.setBanderaExistenciabiometrico(1);

			if(!utileriaValidador.validarObjetoNulo(banderaEntradaEnrolamiento) && NumerosConstants.C_UNO.equals(banderaEntradaEnrolamiento) && ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR.equals(controlador)){
					ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(curp, "67", "2,5");
					if(utileriaValidador.validarObjetoNulo(respuesta)){
						flujo.setBanderaExistenciabiometrico(0);
					}else {
						flujo.setBanderaExistenciabiometrico(1);
					}
					request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujo);
			}
		}
		logger.info("controlador validarSelloFlujo {} ",controlador);
		return controlador;
	}
	
	/**
	 * Metodo para continuar permanencia
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/private/continuarPermanencia.do")
	public ModelAndView continuarPermanencia(HttpServletRequest request) {
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Folio folioPadre = (Folio) request.getSession().getAttribute(ParametrosConstants.FOLIO_PADRE_MODIFICACION);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);

		FolioEntrada auxiliar = new FolioEntrada();
		auxiliar.setFolio(folioPadre.getChFolio());
		logger.info("Inicio vista continuarPermanencia");
		ModelAndView model = new ModelAndView(NavegacionEnum.CONTINUACION_PERMANENCIA.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		servicioFolio.actualizarFolio(folioPadre.getChFolio(), ModificacionTrabajadorConstants.CLAVE_SERVICIO_FOLIO_MODIFICACION, ModificacionTrabajadorConstants.PERMANNECIA);
		
		model.addObject(ParametrosConstants.TIPO_SOLICITANTE, consulta.getCvTipoSolicitante());
		model.addObject(ParametrosConstants.CURP_BUSQUEDA, entradaPermanencia.getCurpTrabajador());
		model.addObject(ParametrosConstants.CLAVE_TIPO_SOLICITANTE_BUSQUEDA, consulta.getCvTipoSolicitante());
		model.addObject(ParametrosConstants.NSS_BUSQUEDA, consulta.getNss());
		model.addObject(ParametrosConstants.TIMER_BUSQUEDA, consulta.getTimerPicker());
		model.addObject(ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		model.addObject("idProcesar", trabajador.getProcesar());
		model.addObject("folio", auxiliar);


		return model;
	}
	
	/**
	 * Metodo que valida flujo de sellos
	 * @param request
	 * @return
	 */
	private String validarSelloCurp(HttpServletRequest request){
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String controlador = null;
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);

		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		
		if(!utileriaValidador.validarObjetoNulo(bandera13)){	
			if(!entradaModificacion.getDatosBaseCurp().getCurpNueva().equalsIgnoreCase(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp())) && !utileriaValidador.validarVacio(trabajador.getDatosCertificables().getCurp())) {
				VerificacionSello verificacion = verificarCambioCurpSello(user, utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()));
				if(!utileriaValidador.validarObjetoNulo(verificacion.getSello())) {
					SelloVirtualEntrada selloVirtual = new SelloVirtualEntrada();
					selloVirtual.setClaveAfore(user.getAforeUsuario());
					selloVirtual.setClaveServicio("0901");
					selloVirtual.setCurpEmpleado(user.getCurpAgente());
					selloVirtual.setCurpActualTrabajador(trabajador.getDatosCertificables().getCurp());
					selloVirtual.setCurpNuevaTrabajador(entradaModificacion.getDatosBaseCurp().getCurpNueva());
					consultaSelloService.generarSelloVirtual(selloVirtual);
				}else {
					verificacion = verificarCambioCurpSello(user, utileriaCadena.asignarValor(entradaModificacion.getDatosBaseCurp().getCurpNueva()));
					if(utileriaValidador.validarObjetoNulo(verificacion.getSello())){
						controlador = ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR;
					}

				}				

			}else {
				VerificacionSello verificacion = verificarCambioCurpSello(user, utileriaCadena.asignarValor(entradaModificacion.getDatosBaseCurp().getCurpNueva()));
				if(utileriaValidador.validarObjetoNulo(verificacion.getSello())){
					controlador = ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR;
				}
			}
		}else if(!utileriaValidador.validarObjetoNulo(banderaP)){
			VerificacionSello verificacionP = consultaSelloService.consultarSelloFlujoModificacion(user.getCurpAgente(),entradaPermanencia.getCurpTrabajador(),user.getAforeUsuario());
	    	 if(utileriaValidador.validarObjetoNulo(verificacionP.getSello())){
	    		 controlador = ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR;
	    	 }
		}
		logger.info("controlador validarSelloCurp {} ",controlador);
		return controlador;

	}
	
	/**
	 * Metodo que valida cambio curp sello
	 * @param trabajador
	 * @param user
	 * @param entradaModificacion
	 * @return
	 */
	private VerificacionSello verificarCambioCurpSello(UsuarioLogin user,String curp){
		return consultaSelloService.consultarSelloFlujoModificacion(user.getCurpAgente(),curp,user.getAforeUsuario());
	}
	
	/**
	 * Validacion para asiganar nss por tipo de afiliacion
	 * @param request
	 * @param datosPersona
	 * @param entrada
	 */
	private void validarNssModificacion(HttpServletRequest request,EntradaModificacion entradaModificacion){
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);

		logger.error("Nss trabajador: {}", trabajador.getNss());
		if (!"4".equals(trabajador.getTipoAfiliacion())&& !"5".equals(trabajador.getTipoAfiliacion())&& !"9".equals(trabajador.getTipoAfiliacion())) {
			logger.info("tipo afiliacion nss {} {}",trabajador.getTipoAfiliacion(),trabajador.getNss());
			entradaModificacion.setNss(trabajador.getNss());
			request.getSession().setAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS, entradaModificacion);
			logger.info("Obj-Sesion validarNssModificacion {} ", entradaModificacion);
		}
	}
	
	
	/**
	 * Validacion para asiganar nss por tipo de afiliacion
	 * @param request
	 * @param datosPersona
	 * @param entrada
	 */
	private void validarNssPermanencia(HttpServletRequest request,EntradaPermanencia entradaPermanencia){
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);

		logger.info("Nss trabajador: {}", trabajador.getNss());
		if (!"4".equals(trabajador.getTipoAfiliacion())&& !"5".equals(trabajador.getTipoAfiliacion())&& !"9".equals(trabajador.getTipoAfiliacion())) {
			logger.info("tipo afiliacion nss {} {}",trabajador.getTipoAfiliacion(),trabajador.getNss());
			entradaPermanencia.setNssTrabajador(trabajador.getNss());
			request.getSession().setAttribute(ParametrosConstants.ENTRADA_PERMANENCIA, entradaPermanencia);
			logger.info("Obj-Sesion validarNssPermanencia {} ", entradaPermanencia);
		}
	}
	
	/**
	 * Metodo que valida expedientes en caso de cambio de curp
	 * @param request
	 */
	private void validarEntradaExpedientes(HttpServletRequest request,FlujoModificacion flujoModificacion){
		logger.info("entrando a validarEntradaExpedientes");
		String banderaEntradaIdentificacion = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_ENTRADA_IDENTIFICACION);
		String banderaEntradaEnrolamiento = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_ENTRADA_ENROLAMIENTO);
		
		logger.info("banderaEntradaIdentificacion :: validarEntradaExpedientes: {}",banderaEntradaIdentificacion);
		logger.info("banderaEntradaEnrolamiento :: validarEntradaExpedientes: {}",banderaEntradaEnrolamiento);
		
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

		
		if(!utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()).equals(entradaModificacion.getDatosBaseCurp().getCurpNueva())){		
			if(!utileriaValidador.validarObjetoNulo(banderaEntradaEnrolamiento)){
				this.validarEnrolamientoCambioCurp(request,user,entradaModificacion,flujoModificacion);
			}
			if(!utileriaValidador.validarObjetoNulo(banderaEntradaIdentificacion)){
				this.validarIdentificacionCambioCurp(request, user, entradaModificacion,flujoModificacion);
			}
		}
	}
	
	/**
	 * Metodo que valida expediente de enrolamiento en caso de cambio de curp
	 * @param request
	 * @param user
	 * @param entradaModificacion
	 */
	private void validarEnrolamientoCambioCurp(HttpServletRequest request,UsuarioLogin user,EntradaModificacion entradaModificacion,FlujoModificacion flujoModificacion){
		logger.info("Entrando validarEnrolamientoCambioCurp");
		ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), "67", "2,5");
		logger.info("Respuesta validarEnrolamientoCambioCurp: {}",respuesta);
		if(!utileriaValidador.validarObjetoNulo(respuesta)){
			if(NumerosConstants.C_DOS.equals(respuesta.getCvEstatusExpe()) && user.getAforeUsuario().equals(respuesta.getAfore().getClaveAfore()) || NumerosConstants.C_CINCO.equals(respuesta.getCvEstatusExpe())){				
				flujoModificacion.setEstatusExpeBiometrico(respuesta.getCvEstatusExpe());
				flujoModificacion.setCvAforeExpeBiometrico(respuesta.getAfore().getClaveAfore());
				request.getSession().setAttribute(ParametrosConstants.ENROLAMIENTO_CORRECTO, NumerosConstants.C_UNO);
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoModificacion);
				logger.info("Se carga bandera enrolamiento correcto validarEnrolamientoCambioCurp");
			}
		}
	}
	
	/**
	 * Metodo que valida expediente de identificacion en caso de camvio de curp
	 * @param request
	 * @param user
	 * @param entradaModificacion
	 */
	private void validarIdentificacionCambioCurp(HttpServletRequest request,UsuarioLogin user,EntradaModificacion entradaModificacion,FlujoModificacion flujoModificacion){
		logger.info("Entrando validarIdentificacionCambioCurp");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String cvProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
		ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), cvProceso, "1,5");
		logger.info("Respuesta validarIdentificacionCambioCurp: {}",respuesta);
		if(!utileriaValidador.validarObjetoNulo(respuesta)){
			if(NumerosConstants.C_UNO.equals(respuesta.getCvEstatusExpe()) && user.getAforeUsuario().equals(respuesta.getAfore().getClaveAfore()) || NumerosConstants.C_CINCO.equals(respuesta.getCvEstatusExpe())){
				flujoModificacion.setEstatusExpeIdentificacion(respuesta.getCvEstatusExpe());
				flujoModificacion.setCvAforExpeIdentificacion(respuesta.getAfore().getClaveAfore());
				request.getSession().setAttribute(ParametrosConstants.IDENTIFICACION_CORRECTO, NumerosConstants.C_UNO);
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoModificacion);
				logger.info("Se carga bandera identificacion correcto validarIdentificacionCambioCurp");
			}
		}
	}
	
	/**
	 * Controlador para consulta de informacion de codigo postal
	 * @param request
	 * @param locale
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/private/consultarCodigoPostal.do",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SalidaCatalogoCodigoPostal consultarCodigoPostal(@RequestParam("codigo")String codigo, HttpServletRequest request,Locale locale, Model model){
		EntradaCatalogoCodigoPostal entrada = new EntradaCatalogoCodigoPostal();
		FiltroData filtro = new FiltroData();
		List<FiltroData> listaFiltro = new ArrayList<>();
		entrada.setNombreCatalogo("codigo-postal");
		
		filtro.setNombreFiltro("codigoPostal");
		filtro.setValorFiltro(codigo);
		listaFiltro.add(filtro);
		entrada.setFiltros(listaFiltro);
		return catalogoService.consultarCatalogoCodigoPostal(entrada);		
	}
	
	/**
	 * Metodo que valida Respuesta metodo expe identificacion
	 * @param request
	 * @param flujo
	 * @param controlador
	 * @param bandera13
	 * @param banderaP
	 * @return
	 */
	private String validarRespuestaIDentificacion(HttpServletRequest request, FlujoModificacion flujo,String controlador,String bandera13,String banderaP){
		controlador = validarSelloFlujo(request);
		if(utileriaValidador.validarVacio(controlador)){
			if(!utileriaValidador.validarVacio(bandera13)){
				controlador = ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO;
			}else if(!utileriaValidador.validarVacio(banderaP)){
				controlador = ModificacionTrabajadorConstants.CONTINUAR_PERMANENCIA;
			}
		}
		flujo.setBanderaIdentificacion(NumerosConstants.C_CERO);
		flujo.setBanderaRespuestaIdentificacion(NumerosConstants.C_CERO);
		return controlador;
	}
	
	/**
	 * Metodo para capturar bitacoreo de procesos pendientes modificacion
	 * @param entradaModificacion
	 * @param trabajador
	 * @param banderaRelanzamiento
	 * @param folio
	 * @param user
	 */
	private void insertarBitacoraProcesosPendientesModificacion(EntradaModificacion entradaModificacion,DatosTrabajador trabajador,String banderaRelanzamiento,Folio folioIdentificacion,UsuarioLogin user,Folio folioPadre,FlujoModificacion flujo,EntradaSolicitante entradaSolicitante){
		entradaModificacion.setFolioCliente(folioPadre.getChFolio());
		entradaModificacion.setCurp(trabajador.getDatosCertificables().getCurp());
		entradaModificacion.getDatosBaseCurp().setIndicadorDeDuplicidad(ModificacionTrabajadorConstants.INDICADOR_DE_DUPLICIDAD);
		entradaModificacion.getDatosBaseCurp().setIndicadorDeServicioBiometrico(ModificacionTrabajadorConstants.INDICADOR_BIOMETRICO);
		
		if(!trabajador.getTipoAfiliacion().equals(ModificacionTrabajadorConstants.TIPO_AFILIACION_ISSSTE) &&
				!trabajador.getTipoAfiliacion().equals(ModificacionTrabajadorConstants.TIPO_AFILIACION_INDEPENDIENTE_ISSSTE) &&
				!trabajador.getTipoAfiliacion().equals(ModificacionTrabajadorConstants.TIPO_AFILIACION_ISSSTE_ASIGNADO)){
			entradaModificacion.setNss(trabajador.getNss());
		}
		logger.info("Entrada modificacion: {} ",entradaModificacion);
		String fechaNacimiento = fechaUtils.ObtenerFechas(entradaModificacion.getDatosBaseCurp().getFechaDeNacimiento());
		entradaModificacion.getDatosBaseCurp().setFechaDeNacimiento(fechaNacimiento);
		if(utileriaValidador.validarObjetoNulo(banderaRelanzamiento)){
			Nacionalidad nacionalidad = catalogoService.obtenerNacionalidadPorClave(entradaModificacion.getDatosBaseCurp().getNacionalidad());
			if(!utileriaValidador.validarObjetoNulo(nacionalidad)) {
				entradaModificacion.getDatosBaseCurp().setNacionalidad(nacionalidad.getChValorDespliegue());
			}
		}
		
		EntradaModificacion entradaFiltradaModificacion = modificacionTrabajadorService.validaDatosModificacionComparador(entradaModificacion);
		
		CargaModificacion cargaModificacion = new CargaModificacion();
		cargaModificacion.setEntradaModificacion(entradaFiltradaModificacion);
		cargaModificacion.setEntradaSolicitante(entradaSolicitante);
		
		
		ProcesoPendienteEntrada<EntradaModificacion> entradaProceso = new ProcesoPendienteEntrada<>();
		entradaProceso.setSolicitante(trabajador.getTipoSolicitante());
		entradaProceso.setProceso("01");
		entradaProceso.setFlujo(entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion());
		entradaProceso.setCurp(utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) ? null : utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()));
		entradaProceso.setCurpNueva(entradaModificacion.getDatosBaseCurp().getCurpNueva());
		entradaProceso.setAfore(user.getAforeUsuario());
		entradaProceso.setCurpEmpleado(user.getCurpAgente());
		entradaProceso.setIdFolioPulssar(folioIdentificacion.getIdFolioPulssar());
		entradaProceso.setPeticion(entradaFiltradaModificacion);
		entradaProceso.setIdFolioPulssarOrigen(utileriaValidador.validarObjetoNulo(flujo.getIdFolioHijoPulssarOrigen()) ? null : flujo.getIdFolioHijoPulssarOrigen());
		
		insertarSolicitudComparadorModificacion(entradaFiltradaModificacion, folioIdentificacion, user,trabajador.getTipoSolicitante(),cargaModificacion);
		serviceProcesoPendiente.insertarProcesoPendiente(entradaProceso);
	}
	
	/**
	 * Metodo para capturar bitacoreo de proceso pendiente permanencia
	 * @param entradaPermanencia
	 * @param trabajador
	 * @param banderaRelanzamiento
	 * @param folio
	 * @param user
	 */
	private void insertarBitacoraProcesoPendientesPermanencia(EntradaPermanencia entradaPermanencia,DatosTrabajador trabajador,Folio folioIdentificacion,UsuarioLogin user,Folio folioPadre,FlujoModificacion flujo,EntradaSolicitante entradaSolicitante){
		entradaPermanencia.setFechaDeNacimiento(fechaUtils.ObtenerFechas(entradaPermanencia.getFechaDeNacimiento()));

		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!utileriaValidador.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
		}

		DatosParticulares datosParticulares = notificacionExpedienteService.validaEntradaDatosParticulares(entradaPermanencia, caracterHomologado);
		DomicilioLaboral domicilioLaboral = notificacionExpedienteService.validaDomicilioLaboralPermanencia(entradaPermanencia, caracterHomologado);
		Referencias referencias = notificacionExpedienteService.validaReferenciasPermanencia(entradaPermanencia, caracterHomologado);
		Beneficiarios beneficiarios = notificacionExpedienteService.validaBeneficiariosPermanencia(entradaPermanencia, caracterHomologado);
		CargaPermanencia cargaPermanenciaComparador = new CargaPermanencia();
		EntradaPermanencia entradaPermanenciaComparador = new EntradaPermanencia();
		entradaPermanenciaComparador.setEntidadOrigen(entradaPermanencia.getEntidadOrigen());
		entradaPermanenciaComparador.setCurpTrabajador(entradaPermanencia.getCurpTrabajador());
		entradaPermanenciaComparador.setNssTrabajador(entradaPermanencia.getNssTrabajador());
		entradaPermanenciaComparador.setRfc(entradaPermanencia.getRfc());
		entradaPermanenciaComparador.setApellidoPaterno(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getApellidoPaterno(), caracterHomologado));
		entradaPermanenciaComparador.setApellidoMaterno(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getApellidoMaterno(),caracterHomologado));
		entradaPermanenciaComparador.setNombreTrabajador(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getNombreTrabajador(),caracterHomologado));
		entradaPermanenciaComparador.setFechaDeNacimiento(entradaPermanencia.getFechaDeNacimiento());
		entradaPermanenciaComparador.setGenero(entradaPermanencia.getGenero());
		entradaPermanenciaComparador.setEntidadFederativaDeNacimiento(entradaPermanencia.getEntidadFederativaDeNacimiento());
		entradaPermanenciaComparador.setNacionalidad(entradaPermanencia.getNacionalidad());
		entradaPermanenciaComparador.setOcupacionOProfesionTrabajador(entradaPermanencia.getOcupacionOProfesionTrabajador());
		entradaPermanenciaComparador.setActividadOGiroNegocioTrabajador(entradaPermanencia.getActividadOGiroNegocioTrabajador());
		entradaPermanenciaComparador.setNivelDeEstudioTrabajador(entradaPermanencia.getNivelDeEstudioTrabajador());
		entradaPermanenciaComparador.setCurpSolicitante(entradaPermanencia.getCurpSolicitante());
		entradaPermanenciaComparador.setTipoSolicitante(entradaPermanencia.getTipoSolicitante());
		entradaPermanenciaComparador.setDatosParticulares(datosParticulares);
		entradaPermanenciaComparador.setDomicilioLaboral(domicilioLaboral);
		entradaPermanenciaComparador.setReferencias(referencias);
		entradaPermanenciaComparador.setBeneficiarios(beneficiarios);
		
		cargaPermanenciaComparador.setEntradaPermanencia(entradaPermanenciaComparador);
		cargaPermanenciaComparador.setEntradaSolicitante(entradaSolicitante);
//		
		CuerpoPermanencia cuerpoPermanenciaComparador = new CuerpoPermanencia();
		cuerpoPermanenciaComparador.setFolioCliente(folioPadre.getChFolio());
		cuerpoPermanenciaComparador.setCuerpo(cargaPermanenciaComparador);
		
		
		CuerpoPermanenciaProcesoPendiente cuerpoPermanenciaProcesosPendientes = new CuerpoPermanenciaProcesoPendiente();
		cuerpoPermanenciaProcesosPendientes.setFolioCliente(folioPadre.getChFolio());
		cuerpoPermanenciaProcesosPendientes.setCuerpo(entradaPermanenciaComparador);
		
		ProcesoPendienteEntrada<CuerpoPermanenciaProcesoPendiente> entradaProceso = new ProcesoPendienteEntrada<>();
		entradaProceso.setSolicitante(trabajador.getTipoSolicitante());
		entradaProceso.setProceso("02");
		entradaProceso.setCurp(trabajador.getDatosCertificables().getCurp());
		entradaProceso.setCurpNueva(entradaPermanencia.getCurpTrabajador());
		entradaProceso.setAfore(user.getAforeUsuario());
		entradaProceso.setCurpEmpleado(user.getCurpAgente());
		entradaProceso.setIdFolioPulssar(folioIdentificacion.getIdFolioPulssar());
		entradaProceso.setPeticion(cuerpoPermanenciaProcesosPendientes);
		entradaProceso.setIdFolioPulssarOrigen(utileriaValidador.validarObjetoNulo(flujo.getIdFolioHijoPulssarOrigen()) ? null : flujo.getIdFolioHijoPulssarOrigen());
		
		insertarSolicitudComparadorPermanencia(entradaPermanencia, folioIdentificacion, user, cuerpoPermanenciaComparador);
		serviceProcesoPendiente.insertarProcesoPendiente(entradaProceso);
	}
	
	/**
	 * Metodo encargado de validar mesa de control
	 * @param request
	 */
	private void validarExpeIdentificacionMesa(HttpServletRequest request){
		
		logger.info("Entrando a validar validarExpeIdentificacionMesa");
		String banderaEntradaIdentificacion = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_ENTRADA_IDENTIFICACION);
		logger.info("banderaEntradaIdentificacion :: validarExpeIdentificacionMesa: {}",banderaEntradaIdentificacion);
		FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		logger.info("flujo :: validarExpeIdentificacionMesa: {}",flujo);

		if(!utileriaValidador.validarObjetoNulo(banderaEntradaIdentificacion)){
			String respuesta = modificacionTrabajadorService.consultarRecepcionExpeIdentificacion(flujo.getFolioIdentificacion(), ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			logger.info("Respuesta :: validarExpeIdentificacionMesa: {}",respuesta);
			if(!utileriaValidador.validarObjetoNulo(respuesta) && NumerosConstants.C_UNO.equals(utileriaCadena.asignarValor(respuesta))){
				request.getSession().setAttribute(ModificacionTrabajadorConstants.BANDERA_MESA_CONTROL, NumerosConstants.C_UNO);

			}
		}
	}
	
	/**
	 * Metodo encargado de generar solicitud comparador modificacion de datos
	 * @param entradaModificacion
	 * @param folio
	 * @param user
	 */
	private void insertarSolicitudComparadorModificacion(EntradaModificacion entradaModificacion,Folio folio,UsuarioLogin user,String tipoSolicitante,CargaModificacion cargaModificacion){
		logger.info("Generando entrada Solicitud Comparador Generico");
		RespuestaServicioNotificacion notificacion=null;
		TramiteComparadorInformacionGenerico<CargaModificacion> solicitud = new TramiteComparadorInformacionGenerico<>();	
		solicitud.setFolioProcesar(folio.getChFolio());
		solicitud.setFolioServicio(ModificacionTrabajadorConstants.CLAVE_SERVICIO_MODIFICACION);
		solicitud.setClaveServicio("S4");
		solicitud.setCurp(utileriaValidador.isEmpty(entradaModificacion.getCurp()) ? entradaModificacion.getDatosBaseCurp().getCurpNueva() :  entradaModificacion.getCurp());
		solicitud.setNss(entradaModificacion.getNss());
		solicitud.setNombreTrabajador(entradaModificacion.getDatosBaseCurp().getNombreTrabajador());
		solicitud.setApellidoPaterno(entradaModificacion.getDatosBaseCurp().getApellidoPaterno());
		solicitud.setApellidoMaterno(entradaModificacion.getDatosBaseCurp().getApellidoMaterno());
		solicitud.setOrganizacion(user.getAforeUsuario());
		solicitud.setTipoSolicitud(ModificacionTrabajadorConstants.CLAVE_SOLICITUD_PRESENCIAL);
		solicitud.setClaveAgentePromotor(user.getUsuario());
		solicitud.setCurpAgentePromotor(user.getCurpAgente());
		solicitud.setClaveTipoAsignacion(ModificacionTrabajadorConstants.CLAVE_SOLICITUD_PRESENCIAL);
		solicitud.setClaveTipoSolicitante(tipoSolicitante);
		solicitud.setPeticion(cargaModificacion);
		notificacion=reimpresionTramitesService.envioNotificacionTramites(obtenerObjetoTramitesCocluidosModificadorDatos(entradaModificacion,folio,ModificacionTrabajadorConstants.OPERACION_13, "",tipoSolicitante,user));
		logger.error("Se envio notificacion modificador de datos mesa insertarSolicitudComparadorModificacion ::{} ", notificacion);
		RespuestaSolicitud respuestaSolicitud = serviceProcesoPendiente.insertarProcesoSolicitudComparador(solicitud);
		if(!utileriaValidador.validarObjetoNulo(respuestaSolicitud)) {
			if(!ModificacionTrabajadorConstants.SOLICITUD_COMPARADOR_ACEPTADA.equals(respuestaSolicitud.getResultadoOperacion())) {
				throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA); 
			}
		}
	}
	
	/**
	 * 
	 * @param entradaPermanencia
	 * @param folio
	 * @param user
	 * @param cuerpoPermanencia
	 */
	private void insertarSolicitudComparadorPermanencia(EntradaPermanencia entradaPermanencia,Folio folio,UsuarioLogin user,CuerpoPermanencia cuerpoPermanencia){
		TramiteComparadorInformacionGenerico<CuerpoPermanencia> solicitud = new TramiteComparadorInformacionGenerico<>();
		RespuestaServicioNotificacion notificacion=null;
		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!utileriaValidador.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
		}
		solicitud.setFolioProcesar(folio.getChFolio());
		solicitud.setFolioServicio(ModificacionTrabajadorConstants.CLAVE_SERVICIO_PERMANENCIA);
		solicitud.setClaveServicio("S4");
		solicitud.setCurp(entradaPermanencia.getCurpTrabajador());
		solicitud.setNss(entradaPermanencia.getNssTrabajador());
		solicitud.setNombreTrabajador(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getNombreTrabajador(), caracterHomologado));
		solicitud.setApellidoPaterno(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getApellidoPaterno(),caracterHomologado));
		solicitud.setApellidoMaterno(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getApellidoMaterno(),caracterHomologado));
		solicitud.setOrganizacion(user.getAforeUsuario());
		solicitud.setTipoSolicitud(ModificacionTrabajadorConstants.CLAVE_SOLICITUD_PRESENCIAL);
		solicitud.setClaveAgentePromotor(user.getUsuario());
		solicitud.setCurpAgentePromotor(user.getCurpAgente());
		solicitud.setClaveTipoAsignacion(ModificacionTrabajadorConstants.CLAVE_SOLICITUD_PRESENCIAL);
		solicitud.setClaveTipoSolicitante(entradaPermanencia.getTipoSolicitante());
		solicitud.setPeticion(cuerpoPermanencia);
		notificacion=reimpresionTramitesService.envioNotificacionTramites(obtenerObjetoTramitesCocluidosPermanencia(solicitud,entradaPermanencia.getTipoSolicitante()));
		logger.error("Se envio notificacion permanencia mesa insertarSolicitudComparadorPermanencia ::{} ", notificacion);
		RespuestaSolicitud respuestaSolicitud = serviceProcesoPendiente.insertarProcesoSolicitudComparador(solicitud);	
		if(!utileriaValidador.validarObjetoNulo(respuestaSolicitud)) {
			if(!ModificacionTrabajadorConstants.SOLICITUD_COMPARADOR_ACEPTADA.equals(respuestaSolicitud.getResultadoOperacion())) {
				throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA); 
			}
		}
	}
	
	/**
	 * Metodo encargado para validar expedientes no titular
	 * @param trabajador
	 * @param request
	 * @return
	 */
	private ExpedienteSalida validarExpedientesNoTitular(DatosTrabajador trabajador,HttpServletRequest request) {
		String banderaFlujo9B = (String) request.getSession().getAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		FlujoModificacion flujoModificacion = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		String curp = null;
		ExpedienteSalida salidaTipoSolicitante = new ExpedienteSalida();
		String cveProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
		
		if(!utileriaValidador.validarObjetoNulo(bandera13) && NumerosConstants.C_UNO.equals(bandera13)){
			curp =  utileriaValidador.isEmpty(trabajador.getDatosCertificables().getCurp()) ? utileriaCadena.asignarValor(entradaModificacion.getDatosBaseCurp().getCurpNueva()) : utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp());	
		}else if(!utileriaValidador.validarObjetoNulo(banderaP) && NumerosConstants.C_UNO.equals(banderaP)){
			curp = entradaPermanencia.getCurpTrabajador();
		}
		ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(curp, cveProceso, "1,5");
		respuesta = modificacionTrabajadorService.validaExpedienteIdentificacionNoTitularCurpNueva(trabajador, entradaModificacion, respuesta, cveProceso);
		if(utileriaValidador.validarObjetoNulo(respuesta)){
			salidaTipoSolicitante.setEstatusExpedienteIdentificacion(NumerosConstants.C_CERO);
			request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salidaTipoSolicitante);
		}else{
			salidaTipoSolicitante.setEstatusExpedienteIdentificacion(respuesta.getCvEstatusExpe());
			salidaTipoSolicitante.setClaveExpedienteIdentificacion(respuesta.getAfore().getClaveAfore());
			salidaTipoSolicitante.setClaveAforeExpIdentificacion(respuesta.getAfore().getClaveAfore());
			salidaTipoSolicitante.setClaveTipoProcesoExpIdentificacion(cveProceso);
			salidaTipoSolicitante.setTipoIDE(NumerosConstants.C_CERO);
			
			flujoModificacion.setEstatusExpeIdentificacion(respuesta.getCvEstatusExpe());
			flujoModificacion.setCvAforExpeIdentificacion(respuesta.getAfore().getClaveAfore());
			request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoModificacion);
			request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE, salidaTipoSolicitante);
		}
		
		if(!utileriaValidador.isEmpty(banderaFlujo9B)) {
			ExpedienteDetail respuestaEntolamiento = modificacionTrabajadorService.validaExpedienteEnrolamientoNoTitular9B(trabajador, entradaModificacion, banderaFlujo9B);
			if(!utileriaValidador.validarObjetoNulo(respuestaEntolamiento)) {
				flujoModificacion.setEstatusExpeBiometrico(respuestaEntolamiento.getCvEstatusExpe());
				flujoModificacion.setCvAforeExpeBiometrico(respuestaEntolamiento.getAfore().getClaveAfore());
				request.getSession().setAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION, flujoModificacion);
			}
		}
		request.getSession().setAttribute(ModificacionTrabajadorConstants.BANDERA_NO_TITULAR, NumerosConstants.C_UNO);
		return salidaTipoSolicitante;
	}
	
	/**
	 * Metodo encargado de validar expedientes para permanencia
	 * @param curp
	 * @param tipoSolicitante
	 * @param trabajador
	 * @param request
	 * @return
	 */
	private ExpedienteSalida validarExpedientesPermanencia(String curp,String tipoSolicitante,DatosTrabajador trabajador,HttpServletRequest request) {
		if(Constants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante)) {
			return expedienteService.validarRestExpedienteTipoSolicitante(curp,tipoSolicitante);
		}else {
			return validarExpedientesNoTitular(trabajador, request);
		}
	}
	
	/**
	 * Metodo que guarda segun flujo
	 * @param proceso
	 * @param bandera13
	 * @param banderaP
	 * @param flujo
	 * @param entradaPermanencia
	 * @param entradaModificacion
	 * @param descripcion
	 * @param folioPadre
	 */
	private void guardarBitacoraFlujo(String proceso,String bandera13,String banderaP,FlujoModificacion flujo,EntradaPermanencia entradaPermanencia,EntradaModificacion entradaModificacion,String descripcion,Folio folioPadre,String folio) {
		if(!utileriaValidador.validarVacio(bandera13)){
			bitacoraMovimientoModificacionService.generaObjetoModificacion(proceso, descripcion, flujo.getMotivoRechazo(), utileriaCadena.obtenerCadenaConcatenada(true, "13+-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), folio, null);

		}else if(!utileriaValidador.validarVacio(banderaP)){
			bitacoraMovimientoModificacionService.generaObjetoModificacion(proceso, descripcion, flujo.getMotivoRechazo(), "Op 17 permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), folio, null);

		}
	}
	
	/**
	 * Metodo encargado de validar pendiente trabajador
	 * @param curpTrabajador
	 * @param request
	 * @return
	 */
	@GetMapping(value = { "/private/validaPendienteTrabajador.do" }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarPendienteTrabajador(@RequestParam("curpTrabajador") String curpTrabajador,HttpServletRequest request){
		logger.info("Inicio validarPendienteTrabajador");
		logger.info("curpTrabajador >> {} ",curpTrabajador);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		Boolean respuestaValida = null;                        
		try {
			respuestaValida =  modificacionTrabajadorService.validaPendientePersona(curpTrabajador);
			if(respuestaValida) {
				respuestaServicio.setFlujo(1);
			}else {
				 modificacionTrabajadorService.validarRespuestaPendiente(respuestaValida);
			}
		}catch (BusinessException be) {
			logger.error("BusinessException validarPendienteTrabajador {}",be);
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
			 respuestaServicio = servicioCatalogo.obtenerRespuesta(null,be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch (Exception e) {
			servicioFolio.cerrarFolio(folioHijo.getIdFolioPulssar(),NumerosConstants.INT_DOS);
			 respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			logger.error("Ocurrio un error al  validarPendienteTrabajador" , e);
		}
		return respuestaServicio;
	}

	/**
	 * Metodo que valida respuesta para mandar a conformar expe de identificacion
	 * @param claveAfore
	 * @param estatusExpediente
	 * @param respuestaValidaciones
	 * @param controladorIdentificacion
	 * @return
	 */
	public String validaActualizaImagenes(HttpServletRequest request,String claveAfore,String estatusExpediente,boolean respuestaValidaciones,String controladorIdentificacion) {
		String controlador = controladorIdentificacion;
		
		if(NumerosConstants.C_CINCO.equals(estatusExpediente) && ParametrosConstants.VALOR_COPPEL.equals(claveAfore) && respuestaValidaciones) {
			controlador = ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION;
			request.getSession().setAttribute(ModificacionTrabajadorConstants.BANDERA_RECONFORMACION_IDENTIFICACION, NumerosConstants.C_UNO);
		}
		
		return controlador;		
	}
	
	/**
	 * Metodo encargado de validar si se generara nuevo ide para coppel
	 * @param trabajador
	 * @param entradaModificacion
	 * @param entradaPermanencia
	 * @param request
	 * @return
	 */
	public boolean validaDatosGenerarNuevoIde(DatosTrabajador trabajador,EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia,HttpServletRequest request) {
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		boolean validaNombre;
		boolean validaBaseCurp;
		boolean validaDomicilio;
		boolean validaRfc;
		boolean respuestaValidaciones = false;
		if(!utileriaValidador.validarVacio(bandera13)) {
			validaNombre = modificacionTrabajadorService.validarNombreCompleto(trabajador, entradaModificacion);
			validaBaseCurp = modificacionTrabajadorService.varlidarDatosBaseMasNacionalidad(trabajador, entradaModificacion);
			validaDomicilio = modificacionTrabajadorService.validaDomicilio(trabajador, entradaModificacion);
			validaRfc = modificacionTrabajadorService.validarCambiosRfc(trabajador, entradaModificacion);
			respuestaValidaciones = modificacionTrabajadorService.validaActualizacionModificacion(validaNombre, validaBaseCurp, validaDomicilio, validaRfc);
		}else if(!utileriaValidador.validarVacio(banderaP)) {
			validaNombre = modificacionTrabajadorService.validarNombreCompleto(trabajador, entradaPermanencia);
			validaBaseCurp = modificacionTrabajadorService.varlidarDatosBaseMasNacionalidad(trabajador, entradaPermanencia);
			validaDomicilio = modificacionTrabajadorService.validaDomicilio(trabajador, entradaPermanencia);
			validaRfc = modificacionTrabajadorService.validarCambiosRfc(trabajador, entradaPermanencia);
			respuestaValidaciones = modificacionTrabajadorService.validaActualizacionModificacion(validaNombre, validaBaseCurp, validaDomicilio, validaRfc);
		}
		return respuestaValidaciones;
	}
	
	/**
	 * Metodo encargado de validar si se reconforma expediente identificacion permanencia
	 * @param request
	 * @return
	 */
	@GetMapping(value = { "/private/validaReconformaExpediente.do" }, produces = { "application/json" })
	@ResponseBody
	public String validaReconformaExpediente(HttpServletRequest request){
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		String respuesta = NumerosConstants.C_CERO;
		if(ParametrosConstants.VALOR_COPPEL.equals(user.getAforeUsuario())) {
			consultarExpedientesFlujo(request);
			ExpedienteSalida expediente = (ExpedienteSalida)request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_EXPEDIENTE);
				String estatusExpeIdentificacion = expediente.getEstatusExpedienteIdentificacion();
				boolean respuestaValidacion = validaDatosGenerarNuevoIde(trabajador, entradaModificacion, entradaPermanencia, request);
				if(NumerosConstants.C_CINCO.equals(estatusExpeIdentificacion) && respuestaValidacion) {
					respuesta = NumerosConstants.C_UNO;
				}
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de comparar datos base curp para determinar flujo modificacion de datos
	 * @param datosBaseFormulario
	 * @param request
	 * @return
	 */
	@PostMapping(value = { "/private/validaComparacionDatosBase.do" }, produces = { "application/json" })
	@ResponseBody
	public String validaComparacionDatosBase(@RequestBody DatosBaseFormulario datosBaseFormulario,HttpServletRequest request) {
		logger.info("Datos entrantes validaComparacionDatosBase: {}",datosBaseFormulario);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaModificacion entradaModificacion = modificacionTrabajadorService.regresaDatosBaseModificacion(datosBaseFormulario);
		boolean validaNombre = modificacionTrabajadorService.validarNombreCompleto(trabajador, entradaModificacion);
		boolean validaDatosBase = modificacionTrabajadorService.varlidarDatosBase(trabajador, entradaModificacion);
		return modificacionTrabajadorService.regresarRespuestaValidaDatosBase(validaNombre, validaDatosBase);
	}
	
	/**
	 * Controlador encargado de validar flujo 9B
	 * @param curpNueva
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param request
	 * @return
	 */
	@GetMapping(value = { "/private/validaFlujo9B.do" }, produces = { "application/json" })
	@ResponseBody
	public String validaLanzadoFlujo9B(@RequestParam("curpNueva") String curpNueva,@RequestParam("nombre") String nombre,@RequestParam("apellidoPaterno") String apellidoPaterno,@RequestParam("apellidoMaterno") String apellidoMaterno,HttpServletRequest request) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		logger.info("entrada validaLanzadoFlujo9B curpNueva: {}, Nombre: {}, ApellidoPaterno: {}, ApellidoMaterno: {}",curpNueva,nombre,apellidoPaterno,apellidoMaterno);
		String respuestaServicio = null;
		try {
			respuestaServicio = modificacionTrabajadorService.validaFlujo9B(trabajador, curpNueva, nombre, apellidoPaterno, apellidoMaterno,user.getAforeUsuario());
			if(NumerosConstants.C_UNO.equals(respuestaServicio)) {
				request.getSession().setAttribute(ModificacionTrabajadorConstants.BANDERA_FLUJO_9B, NumerosConstants.C_UNO);
			}
		}catch (Exception e) {
			logger.error("Ocurrio un error en controlador validaLanzadoFlujo9B {}",e);
			respuestaServicio = NumerosConstants.C_DOS;
		}
		return respuestaServicio;
	}
	
	@GetMapping(value = { "/private/validaCurpRenapo.do" }, produces = { "application/json" })
	@ResponseBody
	public Renapo validaCurpRenapo(@RequestParam("curpBeneficiario") String curpBeneficiario) {
		logger.info("Entrada validaCurpRenapo: {}",curpBeneficiario);
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp(curpBeneficiario);
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosCertificables(datosCertificables);
		return consultaPersonaService.obtenerDatosRenapo(trabajador);
		
	}
	
	/**
	 * obtenerObjetoTramitesCocluidosModificadorDatos
	 * @param entradaModificacion
	 * @param folio
	 * @param subtipoSolicitante
	 * @param peticion
	 * @return
	 */
	private TramitesConcluidosEntrada obtenerObjetoTramitesCocluidosModificadorDatos(EntradaModificacion entradaModificacion,Folio folio,String subtipoSolicitante,String peticion,String tipoSolicitante,UsuarioLogin user) {
		TramitesConcluidosEntrada entradaTramiteConcluido = new TramitesConcluidosEntrada();
		entradaTramiteConcluido.setCurp(utileriaValidador.isEmpty(entradaModificacion.getCurp()) ? entradaModificacion.getDatosBaseCurp().getCurpNueva() :  entradaModificacion.getCurp());
		entradaTramiteConcluido.setTipoSolicitante(tipoSolicitante);
		entradaTramiteConcluido.setSubTipoSolicitante(subtipoSolicitante);
		entradaTramiteConcluido.setAfore(user.getAforeUsuario());
		entradaTramiteConcluido.setFolioProcesar(folio.getChFolio());
		entradaTramiteConcluido.setUsuarioModificador(ModificacionTrabajadorConstants.OP13_CODOPER);
		entradaTramiteConcluido.setFcControl(new Date());
		entradaTramiteConcluido.setResultadoOperacion(FormatoConstants.RESULTADO_OPERACION_MESA);
		logger.error("Peticion modificador de datos mesa:{} ", entradaTramiteConcluido);
		return entradaTramiteConcluido;
	}
	
	/**
	 * obtenerObjetoTramitesCocluidosPermanencia
	 * @param entradaProceso
	 * @return
	 */
	private TramitesConcluidosEntrada obtenerObjetoTramitesCocluidosPermanencia(TramiteComparadorInformacionGenerico<CuerpoPermanencia>entradaProceso,String tipoSolicitante) {
		TramitesConcluidosEntrada entradaTramiteConcluido = new TramitesConcluidosEntrada();
		entradaTramiteConcluido.setCurp(entradaProceso.getCurp());
		entradaTramiteConcluido.setTipoSolicitante(tipoSolicitante);
		entradaTramiteConcluido.setSubTipoSolicitante(ModificacionTrabajadorConstants.OPERACION_17);
		entradaTramiteConcluido.setAfore(entradaProceso.getOrganizacion());
		entradaTramiteConcluido.setFolioProcesar(entradaProceso.getFolioProcesar());
		entradaTramiteConcluido.setPeticion(reimpresionTramitesService.convertirObjetoToJson(entradaProceso.getPeticion().getCuerpo().getEntradaPermanencia()));
		entradaTramiteConcluido.setUsuarioModificador(ModificacionTrabajadorConstants.OP13_CODOPER);
		entradaTramiteConcluido.setFcControl(new Date());
		entradaTramiteConcluido.setResultadoOperacion(FormatoConstants.RESULTADO_OPERACION_MESA);
		logger.error("Peticion permanencia mesa:{} ", entradaTramiteConcluido);
		return entradaTramiteConcluido;
	}
	
	
	/**
	 * controlador que valida designacion de beneficiarios
	 * @param curp
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param request
	 * @return
	 */
	@GetMapping(value = { "/private/validaBeneficiarioDesignado.do" }, produces = { "application/json" })
	@ResponseBody
	public boolean validaBeneficiariosDesignados(@RequestParam("curp") String curp,@RequestParam("nombre") String nombre,@RequestParam("apellidoPaterno") String apellidoPaterno,@RequestParam("apellidoMaterno") String apellidoMaterno,HttpServletRequest request) {
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaConsulta consultaActual = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);		
		EntradaConsulta consulta = new EntradaConsulta();
			consulta.setCurpSolicitante(curp);
			consulta.setNombre(nombre);
			consulta.setApellidoPaterno(apellidoPaterno);
			consulta.setApellidoMaterno(apellidoMaterno);
			consulta.setCvTipoSolicitante(consultaActual.getCvTipoSolicitante());	
		return modificacionTrabajadorService.validaBeneficiarioDesignado(trabajador.getDatosComplementarios().getListaBeneficiario(), consulta, user.getAforeUsuario());
		
	}
	

}
