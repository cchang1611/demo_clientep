package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static com.google.common.base.Preconditions.checkNotNull;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.AdministracionTurnosConstants.ELEMENTO_PRIMERO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.ADMIN_PANTALLA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.CLAVE_TODOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.ES_ADMINISTRADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.ES_EJECUTIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.FORMATO_FECHA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.LEYENDA_TODOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.MES_ADMINISTRADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.MSG_TIEMPO_ADMINISTRADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.MSG_TIEMPO_EJECUTIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.OPCION_MES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.OPCION_SEMANA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.PAGINA_CONSULTA_REPORTERIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.PAGINA_INICIO_REPORTERIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.PERFIL_ADMINISTRADOR_AFORE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.SEMANAS_EJECUTIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.REPORTE_WEB;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.REPORTE_XLS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.CLAVE_ROL_EJECUTIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.CLAVE_ROL_EJECUTIVO_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.CLAVE_ROL_EJECUTIVO_UNITARIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.ERROR_INESPERADO_MENSAJE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.SESION_CADUCADA;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteriaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaForm;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaInformacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioSesion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.TipoServicioService;

/**
 * <p>
 * Controlador para reporteria, que permite consultar y generar reporter.
 * </p>
 * 
 * @author ERICK HECTOR LUNA RAMIREZ <ehlunara@inet.procesar.com.mx>
 *
 */

@Controller
public class ReporteriaController {
	
	
	/**
	 * Logger para el controlador <b>Reporteria - Citibanamex</b> 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ReporteriaController.class);
	
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * Servicio encargado de las operaciones con el tipo de servicio.
	 */
	@Autowired
	private TipoServicioService tipoServicioService;
	
	/**
	 * Servicio encargado del negocio de reporteria
	 */
	@Autowired
	private ReporteriaService reporteriaServicio;
	
	/**
	 * Utileria para el manejo de fechas.
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	
	/**
	 * <p>
	 * Muestra la pantalla de inicio de reporteria.
	 * 
	 *
	 * </p>
	 * 
	 * @param request
	 *            Una petisión válida.
	 * 
	 * @return Modelo y vista para la pantalla <b>Reporteria</b>.
	 * 
	 * @author ERICK HECTOR LUNA RAMIREZ <ehlunara@inet.procesar.com.mx>
	 */
	@RequestMapping(
		value = { "/private/inicioReporteria.do","/admin/inicioReporteria.do" }, 
		method = { POST, GET }
	)
	public ModelAndView inicioReporteria(HttpServletRequest request) {
		
		LOG.info("Se inicializa la pantalla: {}",PAGINA_INICIO_REPORTERIA );
		
		
		final UsuarioSesion usuarioEnSession = obtenerUsuarioEnSesion(request);
		
		ReporteriaForm reporteria= new ReporteriaForm();
		
		
		ModelAndView modelo = new ModelAndView(PAGINA_INICIO_REPORTERIA);
		utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		// En caso de no existir Usuario regresa el flujo de error.
		
		if (EXITOSO.getClave() != usuarioEnSession.getFlujo()) {

			agregarInformacionSobreFlujoSesion(modelo, usuarioEnSession);
			return modelo;
		}
		
		List<Servicio> tipoServicios = tipoServicioService.buscarServiciosTurnos();
		List<Combo> comboTipoServicio= utileriaConversion.obtenerComboTipoServicio(tipoServicios);
		
		Combo opcionCombo=new Combo();
		opcionCombo.setClave(CLAVE_TODOS);
		opcionCombo.setDescripcion(LEYENDA_TODOS);
		comboTipoServicio.add(opcionCombo);
		
		modelo.addObject("comboTipoServicio", comboTipoServicio);
	
		
		final Rol rolPrimero = usuarioEnSession.getRoles().get(ELEMENTO_PRIMERO);

		agregarValoresRol(modelo,rolPrimero.getClaveRol(),reporteria,usuarioEnSession);
		
		
		modelo.addObject("ES_EJECUTIVO", ES_EJECUTIVO);
		modelo.addObject("commandReporteria", reporteria);
		modelo.addObject("flujo", usuarioEnSession.getFlujo());
		
		return modelo;
	}
	
	/**
	 * Muestra la pantalla de consulta de reporteria
	 * @param request
	 * 					 Una petisión válida.
	 * @param form 
	 * @return Modelo y vista para la pantalla <b>Reporteria</b>.
	 * 
	 * @author ERICK HECTOR LUNA RAMIREZ <ehlunara@inet.procesar.com.mx>
	 */
	@RequestMapping(
			value = { "/private/consultarReporteria.do", "/admin/consultarReporteria.do"}, 
			method = { POST, GET }
		)
	public ModelAndView consultarReporteria(HttpServletRequest request,@ModelAttribute ReporteriaForm reporteriaForm) {
		
		LOG.info("Se inicializa la pantalla: {} ",PAGINA_CONSULTA_REPORTERIA );
		
		final UsuarioSesion usuarioEnSession = obtenerUsuarioEnSesion(request);
		
		ModelAndView modelo = new ModelAndView(PAGINA_CONSULTA_REPORTERIA);
		
		
		utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		// En caso de no existir Usuario regresa el flujo de error.
		if (EXITOSO.getClave() != usuarioEnSession.getFlujo()) {

			agregarInformacionSobreFlujoSesion(modelo, usuarioEnSession);
			return modelo;
		}		
		
		reporteriaForm.setTipoReporte(REPORTE_WEB);
		List<ReporteriaInformacion> listaReporteria = reporteriaServicio.consultarReporteria(reporteriaForm);		
		
		modelo.addObject("listaReporteria",listaReporteria);
		modelo.addObject("fechaInicioFormato", fechaUtils.convertirFechaACadena(reporteriaForm.getFechaInicio(), FORMATO_FECHA));
		modelo.addObject("fechaFinFormato", fechaUtils.convertirFechaACadena(reporteriaForm.getFechaFin(), FORMATO_FECHA));
		modelo.addObject("consultaReporteria", reporteriaForm);
		modelo.addObject("flujo", usuarioEnSession.getFlujo());
		
		return modelo;
	}
	
	
	/**
	 * Metodo para descargar el reporte en xls.
	 * @param request
	 * 					 Una petisión válida.
	 * @param form       {@link ReporteriaForm  }
	 * 
	 */
	@RequestMapping(
			value = { "/private/descargarReporteria.do" ,"/admin/descargarReporteria.do" }, 
			method = { POST, GET }
		)
	public void descargarReporte(HttpServletRequest request,HttpServletResponse response, @ModelAttribute ReporteriaForm reporteriaForm) throws IOException{

		LOG.info("Prueba de descarga {}",reporteriaForm.toString());
		reporteriaForm.setTipoReporte(REPORTE_XLS);
		List<ReporteriaInformacion> listaReporteria = reporteriaServicio.consultarReporteria(reporteriaForm);
		
		HSSFWorkbook workExcel = reporteriaServicio.generarReporteriaExcel(listaReporteria);
		response.setContentType("application/xls");
		response.setHeader("Content-Disposition", "attachment; filename=Reporteria.xls");
		workExcel.write(response.getOutputStream());	
	}
	
	
	/**
	 * Obtiene de la sesón los datos el usuario logeado. En caso de que el
	 * usuario no contenga una instancia se considera que no cuenta con los
	 * permisos suficientes o que su sesion ha caducado.
	 * 
	 * @param request
	 * 
	 * @return Los datos del Usuario en sesion.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	protected UsuarioSesion obtenerUsuarioEnSesion(HttpServletRequest request) {

		/*final*/ UsuarioLogin usuarioEnSession = (UsuarioLogin) request.getSession().getAttribute(ADMIN_PANTALLA);
		
		
		UsuarioSesion usuarioSesionRespuesta = new UsuarioSesion();
		
		// En caso de que no llegue la el usuario en sesión se considera que 
		// la sesión ha finalizado.
		if (usuarioEnSession == null || StringUtils.isBlank(usuarioEnSession.getNombre())) {
			usuarioSesionRespuesta.setFlujo(SESION_CADUCADA.getClave());
			return usuarioSesionRespuesta;
		}
		
		// Si el rol no existe se considera un error inesperado ya que el Rol.
		// Es requerido para las operaciones de turnos.
		BeanUtils.copyProperties(usuarioEnSession, usuarioSesionRespuesta, new String[] {"flujo"});
		List<Rol> rolesDelUsuario = usuarioEnSession.getRoles();
		if (rolesDelUsuario == null || rolesDelUsuario.isEmpty()) {
			
			usuarioSesionRespuesta.setFlujo(ERROR_INESPERADO_MENSAJE.getClave());
			usuarioSesionRespuesta.setMensajeError("El usuario no cuenta con roles");
		}
		
		LOG.debug("Usuario en session: {}", ToStringBuilder.reflectionToString(usuarioSesionRespuesta));
		
		return usuarioSesionRespuesta;
	}
	
	/**
	 * <p>
	 * Permite agregar información repecto al flujo del usuario.
	 * </p>
	 * 
	 * @param modelo El modelo.
	 * @param usuarioEnSession Datos del usurio en sesion.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * 
	 */
	protected void agregarInformacionSobreFlujoSesion(ModelAndView modelo, final UsuarioSesion usuarioEnSession) {
		
		checkNotNull(modelo,           "El modelo es un paramtro requerido requerido");
		checkNotNull(usuarioEnSession, "La usuario es requerida");
		
		modelo.addObject("flujo", usuarioEnSession.getFlujo());
		modelo.addObject("mensajeError", usuarioEnSession.getMensajeError());
	}
	
	
	/**
	 * <p>
	 * Permite agregar valores dependiendo el rol del usuario
	 * </p>
	 * @param modelo
	 * @param rolUsuario
	 * @param reporteria
	 * @param usuarioEnSession
	 * @author EHLUNARA
	 */
	protected void agregarValoresRol(ModelAndView modelo, final String rolUsuario,
			ReporteriaForm reporteria,UsuarioSesion usuarioEnSession) {
		
		Integer banderaMostrar=null;
		
		
		if(rolUsuario.equals(CLAVE_ROL_EJECUTIVO) || rolUsuario.equals(CLAVE_ROL_EJECUTIVO_ATENCION) || rolUsuario.equals(CLAVE_ROL_EJECUTIVO_UNITARIO)){
			
			modelo.addObject("fechaLimite",fechaUtils.convertirFechaACadena( 
					utileriaConversion.modificarFecha(OPCION_SEMANA,SEMANAS_EJECUTIVO, new Date()),FORMATO_FECHA ));
			modelo.addObject("mensajeBusqueda", MSG_TIEMPO_EJECUTIVO);
			
			
					
			reporteria.setNumeroSucursal(usuarioEnSession.getSucursal());				
			reporteria.setEjecutivoAtencion(usuarioEnSession.getNombre()!=null?usuarioEnSession.getNombre():"");
			
			
			banderaMostrar=ES_EJECUTIVO;
			
		}else if(rolUsuario.equals(PERFIL_ADMINISTRADOR_AFORE)){
			
			
			banderaMostrar=ES_ADMINISTRADOR;
			modelo.addObject("fechaLimite",fechaUtils.convertirFechaACadena(utileriaConversion.modificarFecha(OPCION_MES,MES_ADMINISTRADOR, new Date()),FORMATO_FECHA));
			modelo.addObject("mensajeBusqueda", MSG_TIEMPO_ADMINISTRADOR);
		}
		
		
		modelo.addObject("fechaHoy", fechaUtils.convertirFechaACadena(new Date(),FORMATO_FECHA));
		modelo.addObject("banderaMostrar", banderaMostrar);
	
	}

}
