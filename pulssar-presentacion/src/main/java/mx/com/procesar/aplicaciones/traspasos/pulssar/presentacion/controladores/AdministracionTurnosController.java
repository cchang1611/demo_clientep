package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static com.google.common.base.Preconditions.checkNotNull;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.AdministracionTurnosConstants.PAGINA_ASIGNAR_TURNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.AdministracionTurnosConstants.PAGINA_DETALLE_ADMINSTRACION_TURNOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.AdministracionTurnosConstants.PAGINA_DISPONIBILIDAD;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.AdministracionTurnosConstants.PAGINA_FINALIZAR_TURNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.AdministracionTurnosConstants.PAGINA_TURNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants.ADMIN_PANTALLA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.ERROR_INESPERADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.ERROR_INESPERADO_MENSAJE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.ERROR_NEGOCIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.SESION_CADUCADA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.ERROR_ADMINISTRACION_TURNO_EN_ATENCION;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioSesion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.RespuestaUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AdministracionTurnoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AsignaTurnoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.DisponibilidadTurnoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.TipoServicioService;

/**
 * <p>
 * Controlador que permite la administración de TURNOS. Permite registrar las
 * opetaciones del cliente en la Administración de TURNOS de los clientes en los
 * Centros de Atención de Retiro (CARE's) de Citi Banamex Afore además de
 * obtener los tiempos de espera y de atención a partir de la hora de inicio y
 * finalización de trámites.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Controller
public class AdministracionTurnosController extends BaseController {
	
	/**
	 * Logger para el controlador <b>Administración de Filas y Citas - Citibanamex</b> 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AdministracionTurnosController.class);
	
	/**
	 * Servicio que expone las operaciones con el turno.
	 */
	@Autowired
	private AdministracionTurnoService administracionTurnoService;
	
	/**
	 * Servicio encargado de la asignación del turno.
	 */
	@Autowired
	private AsignaTurnoService asignaTurnoService;
	
	/**
	 * Servicio encargado de las operaciones con el tipo de servicio.
	 */
	@Autowired
	private TipoServicioService tipoServicioService;
	
	/**
	 * Servicio engargado para las operaciones para la disponibilidad.
	 */
	@Autowired
	private DisponibilidadTurnoService disponibilidadTurnoService;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * Utileria para el manejo de vaalidaciones.
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion de servicio de rechazo
	 */
	@Autowired
	RechazoService rechazoService;
	
	/**
	 * Inyeccion de servicio de respuesta
	 */
	@Autowired
	RespuestaUtilsImpl respuestaUtils;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Vista principal de Bienvenida
	 * 
	 * @author mahernan
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/menuPrincipal.do", method = RequestMethod.GET)
	public ModelAndView ejecutarMenuPrincipalr(HttpServletRequest request) {
		LOG.info("Inicio de menu de principal.");
		ModelAndView model = new ModelAndView(NavegacionEnum.MENU.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			// Se carga la diferencia de horas de la sucursa vs la hora del servidor
			request.getSession().setAttribute(ParametrosConstants.HORAS_A_RESTAR, obtenerDiferenciaHoras(user.getSucursal()));
			
			if(!RolesEnum.ADMINISTRADOR_AFORE.getRol().equals(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol()) && validadorUtils.validarVacio(user.getSucursal())){
				respuesta.setFlujo(NumerosConstants.INT_DOS);
				respuesta.setTitulo("Error al loguearse.");
				respuesta.setMensaje("El usuario no tiene asignado un CARE.");
			}else{
				respuesta.setFlujo(NumerosConstants.INT_TRES);
			}		
			request.getSession().setAttribute("menuPrincipal", "menuPrincipal.do");
			
		} catch (Exception e) {
			LOG.error("Se presento un problema al mostrar el menu", e);
			respuesta.setFlujo(NumerosConstants.INT_DOS);
			respuesta.setTitulo("Tu solicitud no fue aceptada.");
			respuesta.setMensaje("Se presento un problema al mostrar el menu.");
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * <p>
	 * Inicializa la pantalla para <b>asiganar el turno al Trabajador</b> que
	 * acude al Centro de Atención de Retiro (CARE's) de Citi Banamex.
	 * </p>
	 * 
	 * @param request
	 *            Una petisión válida.
	 * 
	 * @return Modelo y vista para la pantalla <b>Asignar Turno</b>.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@RequestMapping(
			value = { "/private/turno.do" }, 
			method = { POST, GET }
		)
	public ModelAndView inicializarTurnoTrabajador(HttpServletRequest request) {
		
		LOG.info("Se inicializa la pantalla: {}", PAGINA_TURNO);
		
		ModelAndView modelo = new ModelAndView(PAGINA_TURNO, "commandValidarTurno", new AdministracionTurno());
		final UsuarioLogin usuarioEnSession = obtenerUsuarioEnSesion(request);
		modelo = utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		
		return modelo;
	}
	
	/**
	 * <p>
	 * Muestra la administración para los Turnos registrados. Dicha información
	 * se muestra en dos secciones: La primera corresponde para usuarios Con
	 * Cita; La segunda para Usuarios Sin Cita
	 * </p>
	 * 
	 * @param request
	 *            Una petisión válida.
	 * 
	 * @return Modelo y vista para la pantalla <b>Asignar Turno</b>.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@RequestMapping(
		value = { "/private/consultaTurnoRegistrado.do" }, 
		method = { POST, GET }
	)
	public ModelAndView consultarTurnoRegistrado(HttpServletRequest request) {

		LOG.info("Se inicializa la pantalla: Consulta de Turno Registrados");

		ModelAndView modelo = new ModelAndView(PAGINA_DETALLE_ADMINSTRACION_TURNOS, "commandTurnoEnAtencion",
				new AdministracionTurno());
		
		Respuesta respuesta;
		
		final UsuarioSesion usuarioEnSession = obtenerUsuarioEnSesion(request);
		utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		
		// En caso de no existir Usuario regresa el flujo de error.
		if(EXITOSO.getClave() != usuarioEnSession.getFlujo()) {
			
			agregarInformacionSobreFlujoSesion(modelo, usuarioEnSession);
			return modelo;
		}
		
		try {
			
			final String claveAforeEnSesion = usuarioEnSession.getAforeUsuario();
			final Long usuarioEnSesion =    usuarioEnSession.getDatoUsuario();
			final String sucursalEnSesion =   usuarioEnSession.getSucursal();
			
			respuesta = new Respuesta();
			// Consulta el servicio de administracion de turnos.
			respuesta = administracionTurnoService
					.construirRespuestaTurnosRegistrados(claveAforeEnSesion, usuarioEnSesion, sucursalEnSesion);

			respuesta.setFlujo(EXITOSO.getClave());
			
		}
		catch (Exception e) {
			LOG.error("AdministracionTurnosController. Consulta de turnos Registrados (Exception): ", e);
			respuesta = generarRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					usuarioEnSession.getAforeUsuario());
		}
		
		modelo.addObject("respuesta", respuesta);
		
		return modelo;
	}
	
	/**
	 * Permite pasar el tueno con estatus <b>En Atención</b>.
	 * 
	 * @param request
	 *            Una petisión válida.
	 * 
	 * @return Modelo y vista para la pantalla <b>Datos del Trabajador</b>.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@RequestMapping(
			value = { "/private/actualizarTurnoEnAtencion.do" }, 
			method = { POST, GET }
		)
	public ModelAndView actualizarTurnoEnAtencion(HttpServletRequest request,
			@ModelAttribute AdministracionTurno administracionTurno) {

		LOG.info("Se inicializa la pantalla: Consulta de Turno Registrado");
		
		Respuesta respuesta;
		ModelAndView modelo = new ModelAndView(PAGINA_DETALLE_ADMINSTRACION_TURNOS, "commandTurnoEnAtencion",
			administracionTurno);
		
		final UsuarioSesion usuarioEnSession = obtenerUsuarioEnSesion(request);
		utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		
		// En caso de no existir Usuario regresa el flujo de error.
		if(EXITOSO.getClave() != usuarioEnSession.getFlujo()) {			
			agregarInformacionSobreFlujoSesion(modelo, usuarioEnSession);
			return modelo;
		}
		
		try {
			
			// Se obtiene el dato de la diferencia de horas de la sucursal vs la hora del servidor
			int horas = (Integer) request.getSession().getAttribute(ParametrosConstants.HORAS_A_RESTAR);
			
			respuesta = administracionTurnoService.obtenerTurno(usuarioEnSession.getDatoUsuario(), usuarioEnSession.getAforeUsuario(), usuarioEnSession.getSucursal());
			if(!NumerosConstants.INT_UNO.equals( respuesta.getFlujo())){
				Respuesta respuestaActualizacionTurno = asignaTurnoService.actualizarCitaEnAtencion(usuarioEnSession.getSucursal(), administracionTurno.getFolioServicio(), usuarioEnSession.getDatoUsuario(), horas);
				
				final String claveAforeEnSesion = usuarioEnSession.getAforeUsuario();
				final Long idUsuario =    usuarioEnSession.getDatoUsuario();
				final String sucursalEnSesion =   usuarioEnSession.getSucursal();
		
				// Consulta el servicio de administracion de turnos.
				Respuesta informacionAdministracionTurnos = administracionTurnoService.construirRespuestaTurnosRegistrados(claveAforeEnSesion, idUsuario, sucursalEnSesion);
				
				respuesta.setObjetoRespuesta(informacionAdministracionTurnos);
				
				if(EXITOSO.getClave() != respuestaActualizacionTurno.getFlujo()) {				
					return modelo;
				}
				
				modelo = new ModelAndView(utileriaCadena.obtenerCadenaConcatenada(true, ParametrosConstants.REDIRECT, ParametrosConstants.DIAGONAL, ParametrosConstants.CONTEXTO_PRIVADO, ParametrosConstants.MAPEO_MENU_PRINCIPAL));
			}else{
				respuesta = administracionTurnoService
						.construirRespuestaTurnosRegistrados(usuarioEnSession.getAforeUsuario(), usuarioEnSession.getDatoUsuario(), usuarioEnSession.getSucursal());
				Respuesta mensaje = generarRespuesta(ERROR_ADMINISTRACION_TURNO_EN_ATENCION.getClave(),	usuarioEnSession.getAforeUsuario());				
				respuesta.setFlujo(mensaje.getFlujo());
				respuesta.setTitulo(mensaje.getTitulo());
				respuesta.setMensaje(mensaje.getMensaje());
			}			
			
		}
		catch (Exception e) {
			
			LOG.error("AdministracionTurnosController. Actualizar turno en atencion (Exception): ", e);
			respuesta = generarRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					usuarioEnSession.getAforeUsuario());
		}
		
		modelo.addObject("respuesta", respuesta);
		
		return modelo;
	}
	
	/**
	 * <p>
	 * Pantalla para la valiación para <b>asiganar el turno al Trabajador</b> que
	 * acude al Centro de Atención de Retiro (CARE's) de Citi Banamex.
	 * </p>
	 * 
	 * @param request
	 *            Una petisión válida.
	 * 
	 * @return Modelo y vista para la pantalla <b>Asignar Turno</b>.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@RequestMapping(
			value = { "/private/validarTurno.do" }, 
			method = { POST, GET }
		)
	public ModelAndView validarTurnoTrabajador(HttpServletRequest request, @ModelAttribute AdministracionTurno admTurno) {
		ModelAndView modelo;
		LOG.info("Se inicializa la pantalla: Validar Turno, Datos:{}",admTurno);
		
		UsuarioLogin usuarioEnSession = new UsuarioLogin();
		Respuesta respuesta = new Respuesta();
		AdministracionTurno administracionTurno  = admTurno;
		RechazoPulssar respuestaMensaje;
		
		try {
			usuarioEnSession = obtenerUsuarioEnSesion(request);				
			// Se obtiene el dato de la diferencia de horas de la sucursal vs la hora del servidor
			int horas = (Integer) request.getSession().getAttribute(ParametrosConstants.HORAS_A_RESTAR);

			administracionTurno.setServicioSolicitado(null);
			administracionTurno.setSolicitante(null);			
			administracionTurno.setNumeroSucursal(usuarioEnSession.getSucursal());
			administracionTurno.setClaveOrganizacion(usuarioEnSession.getAforeUsuario());
			administracionTurno = administracionTurnoService.validarDatosCita(administracionTurno);	
			administracionTurno.setDiferenciaHora(horas);
			modelo = new ModelAndView(PAGINA_ASIGNAR_TURNO, "commandAsiganarTurno", administracionTurno);	
			modelo = utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
			
			respuesta.setFlujo(EXITOSO.getClave());
			
		} 
		catch (BusinessException e) {
			
			LOG.error("AdministracionTurnosController. validarTurnoTrabajador (Exception de negocio): {} \n, {}",e.getCodigo(), e);
			respuestaMensaje = rechazoService.obtenerRechazo(e.getCodigo(), usuarioEnSession.getAforeUsuario());			
			modelo = validarCodigoPersonalizado(e.getCodigo(),administracionTurno, respuestaMensaje.getClaveRechazo());			
			respuesta = respuestaUtils.obtenerRespuesta(ERROR_INESPERADO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());			
		}
		catch (Exception e) {
			
			LOG.error("AdministracionTurnosController. validarTurnoTrabajador (Exception): ", e);
			modelo = new ModelAndView(PAGINA_TURNO, "commandValidarTurno", administracionTurno);			
			respuestaMensaje = rechazoService.obtenerRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), usuarioEnSession.getAforeUsuario());
			respuesta = respuestaUtils.obtenerRespuesta(ERROR_INESPERADO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());			
		}

		obtenerListaServicios(modelo);
		modelo.addObject("respuesta", respuesta);
		
		return modelo;
	}

	/**
	 * Servicio para validar los codigos personalizados
	 * @param codigo
	 */
	private ModelAndView validarCodigoPersonalizado(String codigo, AdministracionTurno administracionTurno,String claveRechazo) {
		ModelAndView modelo = null;
		LOG.error("Entro en validarCodigoPersonalizado los datos son: codigo:{}, \ndatos: {} , \nRechazo: {}", codigo, administracionTurno, claveRechazo);
		
		LOG.error("\nSe valida BusinessErrorEnum.TRABAJADOR_DUPLICADO.getClave().equals(codigo) ::: ");
		if (BusinessErrorEnum.TRABAJADOR_DUPLICADO.getClave().equals(codigo)) {
			LOG.error("Se valida BusinessErrorEnum.TRABAJADOR_DUPLICADO.getClave().equals(codigo) ::: YES");
			administracionTurno.setIndicadorTipoCita(TurnoConstants.FLAG_TIPO_SIN_DATOS_CITA);
		}
		LOG.error("Se valida BusinessErrorEnum.TRABAJADOR_DUPLICADO.getClave().equals(codigo) ::: NOT");
		if (BusinessErrorEnum.TRABAJADOR_DUPLICADO.getClave().equals(codigo) && !GenericErrorEnum.EXCEPTION_GENERICA.getClave().equals(claveRechazo)) {
			
			modelo = new ModelAndView(PAGINA_ASIGNAR_TURNO, "commandAsiganarTurno", administracionTurno);
		}else {
			modelo = new ModelAndView(PAGINA_TURNO, "commandValidarTurno", administracionTurno);
		}
		LOG.error("\nLos datos finales de validarCodigoPersonalizado son: codigo:{}, \ndatos: {} , \nRechazo: {} \nmodelo:{}", codigo, administracionTurno, claveRechazo, modelo);
		return modelo;
	}

	/**
	 * <p>
	 * Inicializa la pantalla para <b>asiganar el turno al Trabajador</b> que
	 * acude al Centro de Atención de Retiro (CARE's) de Citi Banamex.
	 * </p>
	 * 
	 * @param request
	 *            Una petisión válida.
	 * 
	 * @return Modelo y vista para la pantalla <b>Asignar Turno</b>.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@RequestMapping(
		value = { "/private/asignarTurno.do" }, 
		method = { POST, GET }
	)
	public ModelAndView asignarTurnoDelTrabajador(HttpServletRequest request, 
			@ModelAttribute AdministracionTurno administracionTurno) {
		
		LOG.info("Se inicializa la pantalla: Registro de Turno");
		
		Respuesta respuesta;
		ModelAndView modelo = new ModelAndView(PAGINA_ASIGNAR_TURNO, "commandAsiganarTurno", administracionTurno);
		
		final UsuarioSesion usuarioEnSession = obtenerUsuarioEnSesion(request);
		utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		
		// En caso de no existir Usuario regresa el flujo de error.
		if(EXITOSO.getClave() != usuarioEnSession.getFlujo()) {
			
			agregarInformacionSobreFlujoSesion(modelo, usuarioEnSession);
			return modelo;
		}
		
		try {
 			obtenerListaServicios(modelo);
			
			administracionTurno.setClaveOrganizacion(usuarioEnSession.getAforeUsuario());
			administracionTurno.setIdUsuario(usuarioEnSession.getDatoUsuario());
			administracionTurno.setNumeroSucursal(usuarioEnSession.getSucursal());
			
			respuesta = asignaTurnoService.crearCita(administracionTurno);
			
		}
		catch (Exception e) {			
			LOG.error("AdministracionTurnosController. Asignar turno del trabajador (Exception): ", e);
			respuesta = generarRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					usuarioEnSession.getAforeUsuario());
		}
		
		modelo.addObject("respuesta", respuesta);
		
		return modelo;
	}
	
	
	/**
	 * Metodo que obtiene la diferencia de las horas de la sucursal
	 * y se sube a sesion para evitar la consulta cada vez que entre
	 * @param sucursal
	 * @return
	 */
	private Integer obtenerDiferenciaHoras(String sucursal) {
		Integer valorHoras = administracionTurnoService.obtenterDiferenciaHoras(sucursal);
		return valorHoras;
	}

	/**
	 * Vita para finalizar un turno.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/private/finalizarTurno.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView finalizarTurno(HttpServletRequest request) {

		LOG.info("AdministracionTurnosController. Inicia Finalizar turno.");
		ModelAndView model = new ModelAndView(PAGINA_FINALIZAR_TURNO, "adminTurno", new AdministracionTurno());
		AdministracionTurno adminTurno = new AdministracionTurno();
		Respuesta respuesta;
		RechazoPulssar respuestaMensaje = new RechazoPulssar();
		UsuarioLogin user = obtenerUsuarioLoginAuxiliar();

		try {
			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			if(!validadorUtils.validarObjetoNulo(user)){
				respuesta = administracionTurnoService.obtenerTurno(user.getDatoUsuario(), user.getAforeUsuario(), user.getSucursal());
				if(NumerosConstants.INT_UNO.equals( respuesta.getFlujo())){
					LOG.error("AdministracionTurnosController. Se obtuvo la informacion del turno. OK");	
					respuesta.setFlujo(NumerosConstants.INT_CERO);
					adminTurno = (AdministracionTurno) respuesta.getObjetoRespuesta();
					request.getSession().setAttribute("adminTurno", adminTurno);
					model = new ModelAndView(PAGINA_FINALIZAR_TURNO, "adminTurno",  adminTurno);
					obtenerListaServicios(model);	
				}
			}else{
				LOG.error("AdministracionTurnosController. FinalizarTurno Error al obtener el usuario en sesion.");				
				respuestaMensaje = rechazoService.obtenerRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario());
				respuesta = respuestaUtils.obtenerRespuesta(ERROR_NEGOCIO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
				
			}
		} catch (Exception e) {
			LOG.error("AdministracionTurnosController. FinalizarTurno (Exception): ", e);
			respuestaMensaje = rechazoService.obtenerRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario());
			respuesta = respuestaUtils.obtenerRespuesta(ERROR_INESPERADO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
		}
		
		model.addObject("respuesta", respuesta);
		return model;
	}
	
	/**
	 * Vita para finalizar un turno.
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/private/actualizarTurno.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView actualizarTurno(HttpServletRequest request, @ModelAttribute AdministracionTurno administracionTurno) {

		LOG.info("AdministracionTurnosController. Inicia Actualizar Turno.");
		ModelAndView model = new ModelAndView(PAGINA_FINALIZAR_TURNO, "adminTurno", administracionTurno);
		AdministracionTurno adminTurno = administracionTurno;
		UsuarioLogin user = obtenerUsuarioLoginAuxiliar();
		Respuesta respuesta = new Respuesta();
		RechazoPulssar respuestaMensaje = new RechazoPulssar();
		
		try {
			// Se obtiene el dato de la diferencia de horas de la sucursal vs la hora del servidor
			int horas = (Integer) request.getSession().getAttribute(ParametrosConstants.HORAS_A_RESTAR);
			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			AdministracionTurno adminTurnoSesion = (AdministracionTurno) request.getSession().getAttribute("adminTurno");
			
			if(!validadorUtils.validarObjetoNulo(user)){
				if(!validadorUtils.validarObjetoNulo(adminTurnoSesion) ){
					adminTurno.setIdentificadorTurno(adminTurnoSesion.getIdentificadorTurno());
					adminTurno.setIdUsuario(user.getDatoUsuario());
			
					respuesta = asignaTurnoService.actualizarTurno(adminTurno, user.getAforeUsuario(), horas);
					
					model = new ModelAndView(PAGINA_FINALIZAR_TURNO, "adminTurno", adminTurno);
					
				}				
			}else{
				LOG.error("AdministracionTurnosController. actualizarTurno Error al obtener el usuario en sesion.");
				respuestaMensaje = rechazoService.obtenerRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario());
				respuesta = respuestaUtils.obtenerRespuesta(ERROR_NEGOCIO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
			}			

		} catch (Exception e) {
			LOG.error("AdministracionTurnosController. ActualizarTurno (Exception): ", e);
			respuestaMensaje = rechazoService.obtenerRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario());
			respuesta = respuestaUtils.obtenerRespuesta(ERROR_INESPERADO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
		}
		
		model.addObject("respuesta", respuesta);
		return model;
	}
	
	/**
	 * Obtener combo sucursal 
	 * @param claveAfore
	 * @return
	 */
	private List<Combo> obtenerComboServicios() {
		List<Servicio> listaServicios = tipoServicioService.buscarServiciosTurnos();
		return utileriaConversion.obtenerCatalogoGenerico(listaServicios, "id", "descripcionServicio");
	}
	
	/**
	 * Metodo para agregar la lista de servicios al modelo de la vista
	 * 
	 * @param model
	 * @return
	 */
	public ModelAndView obtenerListaServicios(ModelAndView model) {
		ModelAndView auxiliarModel = model;
		List<Combo> comboServicios = obtenerComboServicios();		
		auxiliarModel.addObject("listaServicios", comboServicios);
		return auxiliarModel;
	}
	
	
	/**
	 * <p>Se realiza la busqueda de los datos de la persona</p>
	 * 
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Sep 18, 2019
	 * @param request
	 * @return
	 */
	@RequestMapping(
			value = { "/private/disponibilidadTurno.do" }, 
			method = { POST, GET }
		)
	public ModelAndView consultarDisponibilidadTurno(HttpServletRequest request) {
		
		LOG.info("Se inicializa la pantalla: Disponibilidada de Turno");

		Respuesta respuesta;
		
		ModelAndView modelo = new ModelAndView(PAGINA_DISPONIBILIDAD);
	
		final UsuarioSesion usuarioEnSession = obtenerUsuarioEnSesion(request);
		utileriaConversion.obtenerImagenNombreUsuario(modelo, usuarioEnSession);
		
		// En caso de no existir Usuario regresa el flujo de error.
		if(EXITOSO.getClave() != usuarioEnSession.getFlujo()) {
			
			agregarInformacionSobreFlujoSesion(modelo, usuarioEnSession);
			return modelo;
		}
		
		try {
			
			String sucursal = utileriaCadena.armarAforeSucursalInvert(usuarioEnSession.getSucursal(), usuarioEnSession.getAforeUsuario(), true);
			respuesta = disponibilidadTurnoService.obtenerDiponilidad(sucursal);
			respuesta.setFlujo(EXITOSO.getClave());
			
		}
		catch (Exception e) {
			
			LOG.error("AdministracionTurnosController. Asignar turno del trabajador (Exception): ", e);
			respuesta = generarRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					usuarioEnSession.getAforeUsuario());
		}
		
		modelo.addObject("respuesta", respuesta);
		
		return modelo;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@RequestMapping(value = "/private/finalizaSesion.do", method = GET)
	public ModelAndView homelogut(HttpServletRequest request, HttpServletResponse response) {
		
		LOG.info("<<<<<<<<<<Ingreso a /index>>>>>>>>>>");
		
		ModelAndView model = new ModelAndView(NavegacionEnum.LOGOUT.getNavegacion());
		
		try {
		
			response.sendRedirect("/pulssar/logout");
		}
		catch (Exception e) {
			LOG.error("Error al finalizar la contraseña", e);
		}
		return model;	
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
	private UsuarioSesion obtenerUsuarioEnSesion(HttpServletRequest request) {

		final UsuarioLogin usuarioEnSession = (UsuarioLogin) request.getSession().getAttribute(ADMIN_PANTALLA);
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
	private void agregarInformacionSobreFlujoSesion(ModelAndView modelo, final UsuarioSesion usuarioEnSession) {
		
		checkNotNull(modelo,           "El modelo es un paramtro requerido requerido");
		checkNotNull(usuarioEnSession, "La usuario es requerida");
		
		modelo.addObject("flujo", usuarioEnSession.getFlujo());
		modelo.addObject("mensajeError", usuarioEnSession.getMensajeError());
	}
	
	/**
	 * Obtiene un usuario Auxiliar en caso de que el original se pierda
	 * 
	 * @return
	 */
	private UsuarioLogin obtenerUsuarioLoginAuxiliar() {
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(RolesConstants.CLAVE_BANAMEX);
		return user;
	}
	
	/**
	 * Genera la respuesta del diagnostico.
	 * 
	 * @param codigoDiagnostico
	 * @param claveAfore
	 * @return
	 */
	protected Respuesta generarRespuesta(final String codigoDiagnostico, final String claveAfore) {

		Respuesta respuesta;
		RechazoPulssar respuestaMensaje = new RechazoPulssar();
		respuestaMensaje = rechazoService.obtenerRechazo(codigoDiagnostico, claveAfore);
		respuesta = respuestaUtils.obtenerRespuesta(ERROR_INESPERADO.getClave(), respuestaMensaje.getTituloMensaje(),
				respuestaMensaje.getMensaje());
		return respuesta;
	}

}
