package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.EstadoSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SolicitudReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SubProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.PresentacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.excepciones.PlataformaOperativaWebException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.CombosCatalogosPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstadoSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SubProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Controlador de Pantalla de Consultas Masivas
 * 
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
@Controller
@RequestMapping(value = { "/private" })
public class MasivosPlataformaOperativaController {

	/**
	 * Log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(MasivosPlataformaOperativaController.class);

	/**
	 * Instancia de servicio de solcitudes
	 */
	@Autowired
	private SolicitudReporteService solicitudReporteService;

	/**
	 * Instancia de servicio de esattus de Solicitud
	 */
	@Autowired
	private EstadoSolicitudService estatusSolicitudService;

	/**
	 * Instancia para servicio de Tipo de Reporte
	 */
	@Autowired
	private TipoReporteService tipoReporteService;

	/**
	 * Servicio para obtener los procesos.
	 */
	@Autowired
	private ProcesoService procesoService;

	/**
	 * Servicio de solicitud de reporte
	 */
	@Autowired
	private ReporteGenericoService reporteGenericoService;

	/**
	 * Servicio para obtener los sub procesos.
	 */
	@Autowired
	private SubProcesoService subprocesoService;

    /**
     * Servicio de directorio de usuarios
     */
	@Autowired
	private DirectorioUsuarioService directorioUsuarioService;

    /**
     * Servicio de la plataforma de servicios
     */
	@Autowired
	private PlataformaOperativaService plataformaOperativaService;

	/**
     * Regresa el control a la pagina de inicio
     * 
     * @author Edgar Alberto Perez Villegas (eaperezv@inet.procesar.com.mx)
     * @param locale Objeto que indica la zona geografica
     * @param model Objeto con el modelo que contiene los datos de la pantalla
     * @param request Informacion general de la peticion
     * @param response Objeto que contiene los datos de la respuesta
     * @return mapping de la pantalla de inicio
     */
	@RequestMapping(value = { "/menumasivo.do" }, method = RequestMethod.GET)
	public String homeMasivo(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("<<<<<<<<<<Ingreso a /homeMasivo>>>>>>>>>>");
		List<EstadoSolicitud> listaEstadosSolicitud;
		try {

			model.addAttribute(PresentacionConstants.PLATAFORMA_OPERATIVA_FORM, new DatosConsultaPlataformaServicios());
			// RECUPERA CATALOGO DE ESTADOS
			listaEstadosSolicitud = estatusSolicitudService.recuperarListaEstadosSolicitud();
			request.getSession().setAttribute("listaEstados", listaEstadosSolicitud);

			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			String roles = directorioUsuarioService.consultarRolesOID(user.getUsuario());
			model.addAttribute("employeeType", directorioUsuarioService.obtenerEmployeeType(user.getUsuario()));
			model.addAttribute("roles", roles);

		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("Error al realizar cargar inicial: {}", e);
			request.getSession().setAttribute("listaEstados", new ArrayList<String>());
		}

		return PresentacionConstants.MASIVOS;
	}

	/**
     * Método que va cargando los combos.
     * 
     * @author Hector Joaquin Ramirez Ortiz (hjramire@inet.procesar.com.mx)
     * @param request Informacion general de la peticion
     * @param model Objeto con el modelo que contiene los datos de la pantalla
     * @return Objeto que contiene la informacion del tipo de reporte
     * @throws PlataformaOperativaWebException En caso de error al ejecutar la peticion
     */
	@RequestMapping(value = "/plataforma-operativa/obtenerReportesMasivos", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public RespuestaJson getTipoReporte(HttpServletRequest request, Model model)
			throws PlataformaOperativaWebException {
		RespuestaJson respuesta = new RespuestaJson();
		CombosCatalogosPlataformaServicios combos = new CombosCatalogosPlataformaServicios();
		String idModulo = request.getParameter(PresentacionConstants.ID_MODULO);
		String idProceso = request.getParameter(PresentacionConstants.ID_PROCESO);
		String idSubProceso = request.getParameter(PresentacionConstants.ID_SUB_PROCESO);
		String idTipoConsulta = request.getParameter(PresentacionConstants.ID_TIPO_CONSULTA);
		try {

			if (idModulo != null) {
				List<ProcesoNegocio> procesos = procesoService.recuperaProcesosPorIdModulo(Long.parseLong(idModulo));
				combos.setProcesos(procesos);
			}

			if (idProceso != null) {
				List<SubProcesoNegocio> subprocesos = subprocesoService
						.recuperaSubprocesosPorIdProceso(Long.parseLong(idProceso));
				combos.setSubprocesos(subprocesos);
				List<TipoReporte> tiposReporte;

				tiposReporte = tipoReporteService
						.recuperarTotalDeTiposReportePorFlujo(PresentacionConstants.INT_BANDERA_SERVICIO_BATCH);
				combos.setTiposReporte(tiposReporte);
			}
            String idRoles = PresentacionConstants.CERO_CADENA;
			if (idSubProceso != null && idTipoConsulta != null) {
                if (PresentacionConstants.CERO_CADENA.equals(idTipoConsulta)) {
					List<ReporteCompleto> reporteCompleto = reporteGenericoService
							.obtenerListaReportesPorSubprocesoTipoReporte(Long.parseLong(idSubProceso), null,
									PresentacionConstants.INT_BANDERA_SERVICIO_BATCH, idRoles);
					combos.setReporteCompleto(reporteCompleto);
				} else {
					List<ReporteCompleto> reporteCompleto = reporteGenericoService
							.obtenerListaReportesPorSubprocesoTipoReporte(Long.parseLong(idSubProceso),
									Long.parseLong(idTipoConsulta), PresentacionConstants.INT_BANDERA_SERVICIO_BATCH, idRoles);
					combos.setReporteCompleto(reporteCompleto);
				}
			}

		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("Error al obtener lista de reportes: {}", e);
			respuesta.setDatos(null);
			respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
			respuesta.setMensaje(PresentacionConstants.MSG_ERROR_CONSULTA_INFORMACION);
		}
		respuesta.setDatos(combos);
		respuesta.setExito(PresentacionConstants.RESPUESTA_EXITO);
		respuesta.setMensaje("EXITO");
		return respuesta;
	}

	/**
     * Controller para carga inicial del combo de solicitudes
     * 
     * @author Edgar Alberto Perez Villegas (eaperezv@inet.procesar.com.mx)
     * @param locale Objeto que contiene datos geograficos de la peticon
     * @param model Objeto con el modelo que contiene los datos de la pantalla
     * @param request Informacion general de la peticion
     * @param response Objeto que contiene los datos de la respuesta
     * @return Objeto con los datos de las solicitudes
     */
	@RequestMapping(value = "/plataforma-operativa/obtenerSolicitudes", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<RespuestaJson> cargaSolicitudes(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("<<<<<<<<<<Ingreso a /obtenerSolicitudes>>>>>>>>>>");
		RespuestaJson respuesta = new RespuestaJson();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String areas = directorioUsuarioService.obtenerEmployeeType(user.getUsuario());
		try {
			// RECUPERA LISTA DE NUMEROS DE SOLICITUD
			List<SolicitudReporte> listaSolicitudes = solicitudReporteService.recuperarSolicitudes(areas);

			if (null != listaSolicitudes && !listaSolicitudes.isEmpty()) {
				respuesta.setExito(1);
				respuesta.setDatos(listaSolicitudes);
			} else {
				logger.info(PresentacionConstants.MSG_CONSULTA_SIN_INFORMACION);
				respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
				respuesta.setDatos(new ArrayList<SolicitudReporte>());
				respuesta.setMensaje(PresentacionConstants.MSG_CONSULTA_SIN_INFORMACION);
			}
		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("Error al realizar cargar de solicitudes: {}", e);
			respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
			respuesta.setDatos(false);
			respuesta.setMensaje("Error al realizar cargar de solicitudes");
			return new ResponseEntity<>(respuesta, HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

	/**
     * Metodo que realiza la consulta de detalle de la solicitud
     * 
     * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
     * @param request Objeto con los datos de la peticion
     * @param numSolicitudSel Numero de solicitud seleccionado
     * @param idEstado Identificador del estado
     * @param fechaInicio Fecha que indica el rango inferior de la consulta
     * @param fechaFin Fecha que indica el rango superior de la consulta
     * @return Objeto que contiene el listado de las solicitudes halladas
     */
	@RequestMapping(value = "/plataforma-operativa/consultasolicitud", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<RespuestaJson> consultasolicitud(HttpServletRequest request,
			@RequestParam(value = "numSolicitudSel", required = false) String numSolicitudSel,
			@RequestParam(value = "idEstadoSel", required = false) String idEstado,
			@RequestParam(value = "fechaInicio", required = false) String fechaInicio,
			@RequestParam(value = "fechaFin", required = false) String fechaFin) {
		logger.info("<<<<<<<<<<Ingreso a /consultasolicitud>>>>>>>>>>");
        ResponseEntity<RespuestaJson> respuesta;
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String areas = directorioUsuarioService.obtenerEmployeeType(user.getUsuario());
		respuesta = plataformaOperativaService.consultaSolicitud(areas, numSolicitudSel, idEstado, fechaInicio,
				fechaFin);
		
		return respuesta;
	}

	/**
     * Realiza la ejecucion de proceso Batch para la realizacion del reporte
     * 
     * @author Edgar Alberto Perez Villegas (eaperezv@inet.procesar.com.mx)
     * @param datosConsultaMasiva Objeto que contiene los datos de la consulta
     * @param result Objeto que contiene los datos generados por la consulma masiva
     * @param request Objeto con los datos de la peticion
     * @param response Objeto con los datos de la respuesta http
     * @param model Objeto que contiene los datos del modelo
     * @return Objeto que contiene los datos resultantes de la consulta
     */
	@RequestMapping(value = "/plataforma-operativa/consultamasivo", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<RespuestaJson> consultarMasivo(
			@ModelAttribute(PresentacionConstants.PLATAFORMA_OPERATIVA_FORM) DatosConsultaPlataformaServicios datosConsultaMasiva,
			BindingResult result, HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("<<<<<<<<<<Ingreso a /consultarMasivo>>>>>>>>>>");
		logger.info("datosEntrada: {}", datosConsultaMasiva);
		UsuarioLogin usuarioLogueado = (UsuarioLogin) request.getSession()
				.getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		logger.info("<<<<<<<<<<Termino /homeMasivo>>>>>>>>>>");
		return plataformaOperativaService.consultaMasivos(usuarioLogueado.getUsuario(), datosConsultaMasiva);
		
	}
}
