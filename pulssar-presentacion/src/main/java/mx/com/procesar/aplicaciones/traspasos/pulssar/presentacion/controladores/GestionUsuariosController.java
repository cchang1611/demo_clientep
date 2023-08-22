package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Zona;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SucursalAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.Usuarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosModificar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ZonaRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.TextoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.ModificacionUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.UsuarioControlador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivosXlsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogosInternosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RegistroUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.MensajeConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NipConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosUsuariosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCargaMasiva;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosOrganizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ModuloReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PlataformasPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador para el manejo de peticiones de la gestion de usuarios
 * 
 * @version 1.0
 * @since
 */
/**
 * @Author Ricardo Alcantara Ramirez Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)@procesar.com
 * Apr 28, 2022
 */
@Controller
@RequestMapping(value = {"/", "/{value}"})
public class GestionUsuariosController {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(GestionUsuariosController.class);
	
	/**
	 * Inyeccion de Servicio Catalogo usuario
	 */
	@Autowired
	private CatalogoUsuarioService servicioCatalogoUsuario;
	
	/**
	 * Inyeccion de Servicio registro
	 */
	@Autowired
	private RegistroUsuarioService servicioRegistro;

	/**
	 * Inyeccion de servicio administracion
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdministracion;
	
	/**
	 * Inyeccion de service roles
	 */
	@Autowired
	private RolesService servicioRoles;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CadenasUtils utileriaCadena;

	/**
	 * Inyeccion de servicio catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * Inyeccion de servicio directorio
	 */
	@Autowired
	private DirectorioUsuarioService servicioDirectorio;
	
	/**
	 * Inyeccion de servicio catalogo internos
	 */
	@Autowired
	private CatalogosInternosService servicioCatalogoInt;
	
	/**
	 * Inyeccion de repositorio zona
	 */
	@Autowired
	private ZonaRepository repositorioZona;
	
	/**
	 * Css configurables
	 */
	@Value("${css.configurables}")
	private String cssConfigurable;
	
	
	@Autowired
	private ArchivosXlsService procesarArchivoXlsService;

	/**
	 * Vista principal de Bienvenida
	 * 
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/menu.do", method = RequestMethod.GET)
	public ModelAndView ejecutarMenuAdministrador(HttpServletRequest request) {
		logger.info("Inicio de menu de Administracion de usaurios");
		ModelAndView model = new ModelAndView(NavegacionEnum.MENU.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			request.getSession().setAttribute("menuPrincipal", "menu.do");
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar el menu de gestion de usuarios", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}

	
	
	/**
	 * Realiza la carga de los roles de acuerdo a la afore seleccionada
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/admin/obtenerDatosSICI.do", method= RequestMethod.GET)
	@ResponseBody Respuesta obtenerDatosAforeSICI(String claveAfore, HttpServletRequest request){
		logger.info("GestionUsuariosController. Obtiene los perfiles por clave afore: {}", claveAfore);
		Respuesta respuesta = new Respuesta();
		String clave = claveAfore;
		try{
			Map<String, Object> mapaRespuesta = new HashMap<String, Object>();
			if(!utileriaValidador.validarVacio(clave) && !ActivacionConstants.CLAVE_PROCESAR.equals(clave)) {
				List<Combo> listaSucursales = this.obtenerComboSucursales(clave);
				mapaRespuesta.put("listaSucursales", listaSucursales);
			}
			
			if(!utileriaValidador.validarVacio(clave) && !ActivacionConstants.CLAVE_PROCESAR.equals(clave)) {
				List<Combo> listaZonas = servicioCatalogoInt.obtenerZonasOficina(clave, null, NumerosConstants.INT_CERO);
				mapaRespuesta.put("listaZonas", listaZonas);
			}
			
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			respuesta.setMapaRespuesta(mapaRespuesta);

		}catch(Exception e){
			logger.error("Exception en obtener datos sici >>", e);
			respuesta.setFlujo(NumerosConstants.INT_DOS);
		}
		return respuesta;
	}

	/**
	 * Vista principal de Bienvenida
	 * 
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/baja.do", method = RequestMethod.GET)
	public ModelAndView ejecutarBajaUsuario(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.BAJA_USUARIOS.getNavegacion(), "bajaUsuario", new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);
			
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(user.getAforeUsuario(), user.getUsuario(), RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, false, isAdmin);
			
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_BAJA, usuarioRol);
			model.addObject(ParametrosConstants.USUARIOS_BAJA, usuarioRol);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar la baja de usuarios", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Vista principal de Bienvenida
	 * 
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/bajaUsuario.do", method = RequestMethod.POST)
	public ModelAndView registrarBajaUsuario(@ModelAttribute DatosRegistro datos, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.BAJA_USUARIOS.getNavegacion(), "bajaUsuario", new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);
			
			String[] arregloUserBaja = request.getParameterValues("chBoxBaja");
			
			String afore = user.getAforeUsuario();
			if (!utileriaValidador.validarVacio(datos.getClaveAfore())) {
				afore = datos.getClaveAfore();
			}
			
			respuesta = servicioAdministracion.bajaUsuarios(Arrays.asList(arregloUserBaja), afore, user.getUsuario());
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(afore, user.getUsuario(), RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, false, isAdmin);
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_BAJA, usuarioRol);
		} catch (Exception e) {
			logger.error("Se presento un problema al ejecuar la baja de usuarios", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de consulta la baja de una afore
	 * @param clave
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/bajaAfore.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public List<UsuarioControlador> consultarBajaClaveAfore(@RequestParam("cvAfore") String claveAfore, HttpServletRequest request) {
		logger.info("consulta de clave de afore usuarios baja");
		List<UsuarioControlador> usuarios = null;
		String clave = claveAfore;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			List<Usuarios> usuariosBaja = servicioAdministracion.consultarUsuarioSinRol(clave, user.getUsuario(), RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, false, isAdmin);
			usuarios = utileriaConversion.mapearUsuariosAjax(usuariosBaja);
		}catch(Exception e){
			logger.error("Exception en bajaAfore >>", e);
		}
		return usuarios;
	}
	
	/**
	 * Metodo para asignar perfiles
	 * 
	 * @param usuarioPulssar
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/admin/asigna.do", method = RequestMethod.GET)
	public ModelAndView ejecutarAsginacionUsuario(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.ASIGNACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ASIGNA_PERFIL, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, RolesConstants.PARAM_PERFILES_ASIGNAR);
			String listaRoles = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_ASIGNAR, RolesConstants.PERFIL_ASIGNAR);
			
			model = this.obtenerRolesVista(listaRoles, user.getAforeUsuario(), model);
			model = this.obtenerAforesAdministrador(user.getRoles(), model, true);
			
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(user.getAforeUsuario(), user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario()), true, isAdmin);
			
			model.addObject(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consulta la asginacion de perfiles", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Vista para asignar roles
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/asignaPerfil.do", method = RequestMethod.POST)
	public ModelAndView registrarAsignacionUsuario(@ModelAttribute DatosRegistro datos, HttpServletRequest request) {
		DatosRegistro datosNuevos = new DatosRegistro();
		ModelAndView model = new ModelAndView(NavegacionEnum.ASIGNACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ASIGNA_PERFIL, datosNuevos);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			String[] arregloUserAsigna = request.getParameterValues("chBoxAsigna");
			String[] arregloRoles = request.getParameterValues(ParametrosConstants.CHECK_ROLES);
			
			String afore = user.getAforeUsuario();
			if (!utileriaValidador.validarVacio(datos.getClaveAfore())) {
				afore = datos.getClaveAfore();
			}
			logger.info("afore para asignar {}", afore);
			List<UsuariosEnum> listaRoles = servicioRegistro.obtenerOUDUsuarios(Arrays.asList(arregloRoles));
			respuesta = servicioAdministracion.asignarPerfil(Arrays.asList(arregloUserAsigna), Arrays.asList(arregloRoles), listaRoles, afore, user.getUsuario());
			
			datosNuevos.setClaveAfore(afore);
			model = new ModelAndView(NavegacionEnum.ASIGNACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ASIGNA_PERFIL, datosNuevos);
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, RolesConstants.PARAM_PERFILES_ASIGNAR);
			String listaRolesAsignar = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_ASIGNAR, RolesConstants.PERFIL_ASIGNAR);
			model = this.obtenerRolesVista(listaRolesAsignar, user.getAforeUsuario(), model);
			model = this.obtenerAforesAdministrador(user.getRoles(), model, true);
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(afore, user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario()), true, isAdmin);
			
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			model.addObject(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
		} catch (Exception e) {
			logger.error("Se presento un problema al asignar perfil", e);
			model = new ModelAndView(NavegacionEnum.ASIGNACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ASIGNA_PERFIL, datos);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de consulta la baja de una afore
	 * @param clave
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/asignaAfore.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public Respuesta consultarAsignaClaveAfore(@RequestParam("cvAfore") String claveAfore, HttpServletRequest request) {
		logger.info("ConsultarAsignaClaveAfore. {}", claveAfore);
		Respuesta respuesta = new Respuesta();		
		String clave = claveAfore;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			Map<String, Object> mapaRespuesta = new HashMap<String, Object>();
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, RolesConstants.PARAM_PERFILES_ASIGNAR);
			String listaRolesAsignar = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_ASIGNAR, RolesConstants.PERFIL_ASIGNAR);
			List<RolesCatalogo> catalogoRol = this.obtenerRolesPorAfore(clave, listaRolesAsignar);
			List<Combo> listaCombo = utileriaConversion.obtenerCatalogoGenerico(catalogoRol, "claveRol", "descripcionRol");
			mapaRespuesta.put("listaRoles", listaCombo);
						
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(clave, user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario()), true, isAdmin);
			List<UsuarioControlador> usuarios = utileriaConversion.mapearUsuariosAjax(usuarioRol);
			mapaRespuesta.put("listaUsuarios", usuarios);
			
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			respuesta.setMapaRespuesta(mapaRespuesta);
			
		}catch(Exception e){
			logger.error("Exception en asignaAfore >>", e);
			respuesta.setFlujo(NumerosConstants.INT_DOS);
		}
		return respuesta;
	}
	
	/**
	 * Controlador encargado de consultar usuarios activos con rol
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/modifica.do", method = RequestMethod.GET)
	public ModelAndView ejecutarModicaUsuarios(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.MODIFICACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_MODIFICA_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

			List<UsuariosModificar> usuariosActivosRol = servicioAdministracion.consultarUsuariosRoles(user.getAforeUsuario(), user.getUsuario(), NumerosConstants.INT_UNO, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
			
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);
			request.getSession().setAttribute("usuariosModifica", usuariosActivosRol);
			
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consultar para la modificacion de datos", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Controlador encargado de consultar usuarios activos con rol
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/modificaUsuario.do", method = RequestMethod.POST)
	public ModelAndView obtenerModificaUsuario(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.MODIFICACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_MODIFICA_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		List<Combo> lSucursal = null;
		List<Combo> lZonas = null;
		List<Combo> lDescZona = null;
		List<Combo> lOficina = null;
		List<Combo> lmodulos = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			ModificacionUsuario objetoModificacion = obtenerUsuariosoModificar(user, request, datosUsuario, isAdmin);
			
			if(!utileriaValidador.validarObjetoNulo(objetoModificacion.getModeloVista()) && utileriaValidador.validarObjetoNulo(objetoModificacion.getRespuesta())) {
				lSucursal = objetoModificacion.getListaSucursales();
				lZonas = !utileriaValidador.validarObjetoNulo(objetoModificacion.getListaZonas()) ? objetoModificacion.getListaZonas() : null;
				if(!utileriaValidador.validarListaVacia(objetoModificacion.getListaDescripcionZona())) {
					lDescZona = objetoModificacion.getListaDescripcionZona();
					lOficina = objetoModificacion.getListaOficina();
				}
				model = objetoModificacion.getModeloVista();
			} else {
				respuesta = objetoModificacion.getRespuesta();
				String afore = user.getAforeUsuario();
				if(!utileriaValidador.validarVacio(datosUsuario.getClaveAfore())) {
					request.getSession().setAttribute("usuariosModifica", servicioAdministracion.consultarUsuariosRoles(afore, user.getUsuario(), NumerosConstants.INT_UNO, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE));
				}
				if(isAdmin) {
					List<ModuloReporte> lsReporte = servicioCatalogo.obtenerModuloReportes();
					List<Combo> listaCombo = utileriaConversion.obtenerCatalogoGenerico(lsReporte, "idModuloReporte", "nombreModulo");
					model.addObject("lmodulos", listaCombo);
					model.addObject("flagmodulo", NumerosConstants.INT_DOS);
				}
			}
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);
		} catch (Exception e) {
			logger.error("Se presento un problema al modificar usuario", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.agregarComboAModel(model, "listaSucursales", lSucursal, null);
		model = utileriaConversion.agregarComboAModel(model, "lzonas", lZonas, null);
		model = utileriaConversion.agregarComboAModel(model, "ldesczona", lDescZona, null);
		model = utileriaConversion.agregarComboAModel(model, "loficinas", lOficina, null);
		model = utileriaConversion.agregarComboAModel(model, "lmodulos", lmodulos, null);
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de consultar los usuarios a modificar
	 * 
	 * @param user
	 * @param request
	 * @param datosUsuario
	 */
	private ModificacionUsuario obtenerUsuariosoModificar(UsuarioLogin user, HttpServletRequest request, DatosRegistro datosUsuario, boolean isAdmin) {
		user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String usuarioModificar = request.getParameter("nTexto");
		String clave = datosUsuario.getClaveAfore();
		if(utileriaValidador.validarVacio(clave)) {
			clave = user.getAforeUsuario();
		}
		
		List<UsuariosModificar> usuarioMod = servicioAdministracion.consultarUsuarioModificar(clave, usuarioModificar, NumerosConstants.INT_UNO, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
		return validarUsuariosModificar(request, usuarioMod, usuarioModificar, user.getAforeUsuario(), isAdmin);
	}
	
	/**
	 * Metodo encargado de validar usuario a modificar
	 * 
	 * @param request
	 * @param lstModificar
	 * @param usuarioModificar
	 * @return
	 */
	private ModificacionUsuario validarUsuariosModificar(HttpServletRequest request, List<UsuariosModificar> lstModificar, String usuarioModificar, String aforeLogin, boolean isAdmin) {
		ModificacionUsuario objetoModificacion = new ModificacionUsuario();
		if(!utileriaValidador.validarListaVacia(lstModificar)) {
			UsuariosModificar auxiliarUserMod = lstModificar.get(NumerosConstants.INT_CERO);
//			boolean isOperativoSici = isOperativoSICI(auxiliarUserMod);
//			if(isOperativoSici && !isAdmin) {
//				RespuestaServicio respuesta = new RespuestaServicio();
//				respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.USUARIO_SIN_PRIVILEGIOS_SICI.getClave(), aforeLogin, NumerosConstants.INT_DOS, null);
//				objetoModificacion.setRespuesta(respuesta);
//			} else {
				DatosRegistro dUsuarios = new DatosRegistro();
				dUsuarios.setNickUsuario(usuarioModificar);
				dUsuarios.setNombre(auxiliarUserMod.getNombre());
				dUsuarios.setApellidoPaterno(auxiliarUserMod.getApellidoPaterno());
				dUsuarios.setApellidoMaterno(auxiliarUserMod.getApellidoMaterno());
				dUsuarios.setCelular(auxiliarUserMod.getCelular());
				dUsuarios.setCorreo(auxiliarUserMod.getEmail());
				dUsuarios.setClaveAfore(auxiliarUserMod.getClaveOrganizacion());
				dUsuarios.setClaveSucursal(auxiliarUserMod.getClaveSucursal());
				dUsuarios.setClaveOficina(auxiliarUserMod.getClaveOficina());
				
				if(!utileriaValidador.validarObjetoNulo(auxiliarUserMod.getZona())) {
					Zona zona = repositorioZona.findOne(auxiliarUserMod.getZona());
					dUsuarios.setNombreZona(String.valueOf(zona.getIdZona()));
					dUsuarios.setClaveZona(zona.getClave());
					objetoModificacion.setListaDescripcionZona(servicioCatalogoInt.obtenerZonasOficina(auxiliarUserMod.getClaveOrganizacion(), zona.getClave(), NumerosConstants.INT_UNO));
					objetoModificacion.setListaOficina(servicioCatalogoInt.obtenerZonasOficina(auxiliarUserMod.getClaveOrganizacion(), String.valueOf(zona.getIdZona()), NumerosConstants.INT_DOS));
				}
				
				objetoModificacion.setListaSucursales(this.obtenerComboSucursales(auxiliarUserMod.getClaveOrganizacion()));
				objetoModificacion.setListaZonas(servicioCatalogoInt.obtenerZonasOficina(auxiliarUserMod.getClaveOrganizacion(), null, NumerosConstants.INT_CERO));
				
				List<Combo> listaRolesCombo = obtenerRolesUsuarioModificacion(auxiliarUserMod.getClaveOrganizacion(), lstModificar, usuarioModificar);
				
				request.getSession().setAttribute(ParametrosConstants.SELECT_USUARIO, usuarioModificar);
				objetoModificacion.setModeloVista(new ModelAndView(NavegacionEnum.MODIFICA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_EDITA_USUARIO, dUsuarios));
				objetoModificacion.setModeloVista(utileriaConversion.agregarComboAModel(objetoModificacion.getModeloVista(), ParametrosConstants.PARAMETRO_ROLES, listaRolesCombo, null));
				
				List<ModuloReporte> lsReporte = servicioCatalogo.obtenerModuloReportes();
				String employeeType = servicioDirectorio.obtenerEmployeeType(usuarioModificar);
				List<Combo> tipoEmpleado = null;
				if(utileriaValidador.validarVacio(employeeType) || (!utileriaValidador.validarVacio(employeeType) && utileriaValidador.validarVacio(employeeType.trim()))) {
					tipoEmpleado = utileriaConversion.obtenerCatalogoGenerico(lsReporte, "idModuloReporte", "nombreModulo");
					objetoModificacion.getModeloVista().addObject("flagmodulo", NumerosConstants.INT_DOS);
				} else {
					tipoEmpleado = this.obtenerTipoEmpleadoReportes(employeeType, lsReporte);
					objetoModificacion.getModeloVista().addObject("flagmodulo", NumerosConstants.INT_UNO);
				}
				objetoModificacion.getModeloVista().addObject("lmodulos", tipoEmpleado);
//			}
		}
		return objetoModificacion;
	}
	
	/**
	 * Valida operativo sici
	 * 
	 * @param auxiliarUserMod
	 * @return
	 */
	private boolean isOperativoSICI(UsuariosModificar auxiliarUserMod) {
		boolean isoperativo = false;
		if(RolesEnum.OPERATIVO_AFORE.getRol().equals(auxiliarUserMod.getClaveRol())) {
			isoperativo = true;
		}
		return isoperativo;
	}
	
	/**
	 * Metodo encargado de obtener los modulos de reporte de sici asingados a un trabajador
	 * 
	 * @param atributos
	 * @param lsReporte
	 * @return
	 */
	private List<Combo> obtenerTipoEmpleadoReportes(String employeeType, List<ModuloReporte> lsReporte) {
		List<Combo> lstCombo = null;
		if(!utileriaValidador.validarListaVacia(lsReporte)) {
			lstCombo = new ArrayList<>();
			for(ModuloReporte reporte : lsReporte) {
				Combo combo = new Combo();
				int bandera = NumerosConstants.INT_CERO;
				combo.setClave(String.valueOf(reporte.getIdModuloReporte()));
				combo.setDescripcion(reporte.getNombreModulo());
				if(!utileriaValidador.validarVacio(employeeType) && employeeType.contains(String.valueOf(reporte.getIdModuloReporte()))) {
					bandera = NumerosConstants.INT_UNO;
				}
				combo.setBandera(bandera);
				lstCombo.add(combo);
			}
		}
		return lstCombo;
	}
	
	/**
	 * Metodo encargado de obtener lista de roles seleccionados de un usuario
	 * 
	 * @param organizacion
	 * @param lstModificar
	 */
	private List<Combo> obtenerRolesUsuarioModificacion(String organizacion, List<UsuariosModificar> lstModificar, String usuarioModificar) {
		List<RolesCatalogo> rolesCatalogo = servicioCatalogoUsuario.obtenerRolesAdministracion(RolesEnum.ADMINISTRADOR_AFORE.getRol(), organizacion);
		if(utileriaValidador.validarListaVacia(rolesCatalogo)) {
			rolesCatalogo = servicioCatalogoUsuario.obtenerRolesAdministracion(RolesEnum.SUPER_ADMINISTRADOR.getRol(), organizacion);
		}
		List<Combo> listaRolesCombo = utileriaConversion.obtenerRolesUsuario(rolesCatalogo);
		//List<Combo> listaRolesCombo = filtrarComboRolesModificacion(listaRoles, isAdmin, usuarioModificar);
		
		if(!utileriaValidador.validarListaVacia(listaRolesCombo)) {
			for(UsuariosModificar auxUsuarioMod : lstModificar) {
				int i = 0;
				boolean isEncontrado = true;
				do {
					if(listaRolesCombo.get(i).getClave().equals(auxUsuarioMod.getClaveRol())) {
						listaRolesCombo.get(i).setBandera(NumerosConstants.INT_UNO);
						isEncontrado = false;
					}
					i++;
				} while (i < listaRolesCombo.size() && isEncontrado);
			}
		}
		return listaRolesCombo;
	}
	
	/**
	 * nmetodo encargado de filtrar los roles de modificacion
	 * 
	 * @param lstRoles
	 * @param isAdmin
	 * @return
	 */
	private List<Combo> filtrarComboRolesModificacion(List<Combo> lstRoles, boolean isAdmin, String usuarioModificar) {
		List<Combo> listaRoles = new ArrayList<>();
		boolean isAgregar = true;
		for(Combo combo : lstRoles) {
			if(RolesEnum.AGENTE_VENTANILLA.getRol().equals(combo.getClave()) && !org.apache.commons.lang.StringUtils.isNumeric(usuarioModificar)) {
				isAgregar = false;
			} else if(RolesEnum.OPERATIVO_AFORE.getRol().equals(combo.getClave()) && !isAdmin) {
				isAgregar = false;
			}
			
			if(isAgregar) {
				listaRoles.add(combo);
			}
			isAgregar = true;
		}
		return listaRoles;
	}
	
	/**
	 * Controlador encargado de consultar usuarios activos con rol
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/editaUsuario.do", method = RequestMethod.POST)
	public ModelAndView registrarModificaUsuario(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.MODIFICA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_EDITA_USUARIO, datosUsuario);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		List<Combo> lSucursal = null;
		List<Combo> lZonas = null;
		List<Combo> lDescZona = null;
		List<Combo> lOficina = null;
		try {
			String usuarioModificado = (String) request.getSession().getAttribute(ParametrosConstants.SELECT_USUARIO);
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			ModificacionUsuario modifica = obtenerUsuariosModificar(usuarioModificado, user, request, datosUsuario, model, isAdmin);
			lSucursal = modifica.getListaSucursales();
			lZonas = modifica.getListaZonas();
			if(!utileriaValidador.validarListaVacia(modifica.getListaDescripcionZona())) {
				lDescZona = modifica.getListaDescripcionZona();
				lOficina = modifica.getListaOficina();
			}
			respuesta = modifica.getRespuesta();
			model = modifica.getModeloVista();
			
			request.getSession().setAttribute(ParametrosConstants.SELECT_USUARIO, usuarioModificado);
		} catch (Exception e) {
			logger.error("Se presento un problema al editar usuario", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.agregarComboAModel(model, "listaSucursales", lSucursal, null);
		model = utileriaConversion.agregarComboAModel(model, "lzonas", lZonas, null);
		model = utileriaConversion.agregarComboAModel(model, "ldesczona", lDescZona, null);
		model = utileriaConversion.agregarComboAModel(model, "loficinas", lOficina, null);
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de obtener la información para el guardado del usuario modificado
	 * 
	 * @param user
	 * @param request
	 * @param datosUsuario
	 * @param modeloVista
	 * @return
	 */
	private ModificacionUsuario obtenerUsuariosModificar(String usuarioModificado, UsuarioLogin user, HttpServletRequest request, DatosRegistro datosUsuario, ModelAndView modeloVista, boolean isAdmin) {
		user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		datosUsuario.setNickUsuario(usuarioModificado);
		
		String clave = datosUsuario.getClaveAfore();
		if(utileriaValidador.validarVacio(clave)) {
			clave = user.getAforeUsuario();
		}
		
		List<UsuariosModificar> listaUsuariosModificar = servicioAdministracion.consultarUsuarioModificar(clave, usuarioModificado, NumerosConstants.INT_UNO, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
		return registrarUsuarioModificado(listaUsuariosModificar, request, datosUsuario, user, usuarioModificado, modeloVista, isAdmin);
	}
	
	/**
	 * Metodo encargado de registrar al usuario modificado
	 * 
	 * @param listaUsuariosModificar
	 * @param request
	 * @param datosUsuario
	 * @param user
	 * @param usuarioModificado
	 * @param modeloVista
	 * @return
	 */
	private ModificacionUsuario registrarUsuarioModificado(List<UsuariosModificar> listaUsuariosModificar, HttpServletRequest request, DatosRegistro datosUsuario, UsuarioLogin user, String usuarioModificado, ModelAndView modeloVista, boolean isAdmin) {
		ModificacionUsuario objetoModRegistro = new ModificacionUsuario();
		objetoModRegistro.setModeloVista(modeloVista);
		if(!utileriaValidador.validarListaVacia(listaUsuariosModificar)) {
			String[] rolesSelect = request.getParameterValues(ParametrosConstants.CHECK_ROLES);
			List<String> auxRolesMod = Arrays.asList(rolesSelect);
			
			UsuariosModificar auxUsuarioMod = listaUsuariosModificar.get(NumerosConstants.INT_CERO);
			
			List<Combo> rolesCombo = obtenerRolesComboRegistro(auxUsuarioMod.getClaveOrganizacion(), auxRolesMod);
			objetoModRegistro.setListaSucursales(this.obtenerComboSucursales(auxUsuarioMod.getClaveOrganizacion()));
			objetoModRegistro.setListaZonas(servicioCatalogoInt.obtenerZonasOficina(auxUsuarioMod.getClaveOrganizacion(), null, NumerosConstants.INT_CERO));
			if(!utileriaValidador.validarListaVacia(objetoModRegistro.getListaZonas())) {
				objetoModRegistro.setListaDescripcionZona(servicioCatalogoInt.obtenerZonasOficina(auxUsuarioMod.getClaveOrganizacion(), datosUsuario.getClaveZona(), NumerosConstants.INT_UNO));
				objetoModRegistro.setListaOficina(servicioCatalogoInt.obtenerZonasOficina(auxUsuarioMod.getClaveOrganizacion(), datosUsuario.getNombreZona(), NumerosConstants.INT_DOS));
			}
			
			String[] modulos = request.getParameterValues(ParametrosConstants.CHECK_MODULO_REPORTE);
			RespuestaServicio respuesta = servicioAdministracion.modificarDatosUsuario(datosUsuario, auxUsuarioMod, auxRolesMod, auxUsuarioMod.getClaveOrganizacion(), user.getUsuario(), modulos);
			if(NumerosConstants.INT_UNO == respuesta.getFlujo()) {
				List<UsuariosEnum> rolesEnumAsginar = servicioRegistro.obtenerOUDUsuarios(Arrays.asList(rolesSelect));
				List<UsuariosEnum> rolesEnumQuitar = this.obtenerListaRolesUsuarioOIDEliminar(rolesEnumAsginar);
				servicioDirectorio.asignarRoles(usuarioModificado, rolesEnumAsginar);
				servicioDirectorio.eliminarRoles(usuarioModificado, rolesEnumQuitar);
			}
			objetoModRegistro.setRespuesta(respuesta);
			List<Combo> listaRolesCombo = filtrarComboRolesModificacion(rolesCombo, isAdmin, usuarioModificado);
			objetoModRegistro.setModeloVista(utileriaConversion.agregarComboAModel(objetoModRegistro.getModeloVista(), ParametrosConstants.PARAMETRO_ROLES, listaRolesCombo, null));
			
			List<ModuloReporte> lsReporte = servicioCatalogo.obtenerModuloReportes();
			List<Combo> tipoEmpleado = null;
			if((ActivacionConstants.CLAVE_PROCESAR.equals(user.getAforeUsuario()) && ActivacionConstants.CLAVE_SICI.equals(auxUsuarioMod.getClaveOrganizacion())) || RolesEnum.OPERATIVO_AFORE.getRol().equals(rolesSelect[NumerosConstants.INT_CERO])) {
				String employeeType = servicioDirectorio.obtenerEmployeeType(usuarioModificado);
				tipoEmpleado = this.obtenerTipoEmpleadoReportes(employeeType, lsReporte);
				objetoModRegistro.getModeloVista().addObject("flagmodulo", NumerosConstants.INT_UNO);
			} else {
				tipoEmpleado = utileriaConversion.obtenerCatalogoGenerico(lsReporte, "idModuloReporte", "nombreModulo");
				objetoModRegistro.getModeloVista().addObject("flagmodulo", NumerosConstants.INT_DOS);
			}
			objetoModRegistro.getModeloVista().addObject("lmodulos", tipoEmpleado);
			
		}
		return objetoModRegistro;
	}
	
	/**
	 * Metodo encargado de obtener los roles del registro
	 * 
	 * @param organizacion
	 * @param auxRolesMod
	 * @return
	 */
	private List<Combo> obtenerRolesComboRegistro(String organizacion, List<String> auxRolesMod) {
		List<RolesCatalogo> rolesCatalogo = servicioCatalogoUsuario.obtenerRolesAdministracion(RolesEnum.ADMINISTRADOR_AFORE.getRol(), organizacion);
		if(utileriaValidador.validarListaVacia(rolesCatalogo)) {
			rolesCatalogo = servicioCatalogoUsuario.obtenerRolesAdministracion(RolesEnum.SUPER_ADMINISTRADOR.getRol(), organizacion);
		}
		List<Combo> rolesCombo = utileriaConversion.obtenerRolesUsuario(rolesCatalogo);
		
		for(String auxRoles : auxRolesMod) {
			int i = 0;
			boolean isEncontrado = true;
			do {
				if(rolesCombo.get(i).getClave().equals(auxRoles)) {
					rolesCombo.get(i).setBandera(NumerosConstants.INT_UNO);
					isEncontrado = false;
				}
				i++;
			} while (i < rolesCombo.size() && isEncontrado);
		}
		return rolesCombo;
	}
	
	/**
	 * Metodo encargado de consulta la baja de una afore
	 * @param clave
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/modificaAfore.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public List<UsuarioControlador> consultarModificaClaveAfore(@RequestParam("cvAfore") String claveAfore, HttpServletRequest request) {
		logger.info("consulta de clave de afore usuarios modifica");
		List<UsuarioControlador> usuarios = null;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		String clave = claveAfore;
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_LISTA_MODIFICA);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_LISTA_TABLE);
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			List<UsuariosModificar> usuarioRol = servicioAdministracion.consultarUsuariosRoles(clave, user.getUsuario(), NumerosConstants.INT_UNO, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
			
			usuarios = utileriaConversion.mapearUsuariosAjaxModifica(usuarioRol);
		} catch(Exception e){
			logger.error("Exception en modificaAfore >>", e);
		}
		return usuarios;
	}
	
	/**
	 * Controlador encargado de buscar correos corporativos
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/consultaCorreo.do", method = RequestMethod.GET)
	public ModelAndView ejecutarAdministraCorreo(HttpServletRequest request) {
		RespuestaServicio respuesta = new RespuestaServicio();
		ModelAndView model = new ModelAndView(NavegacionEnum.CORREO_CORPORATIVO.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_CORREO, new DatosOrganizacion());
		List<CorreoCorporativo> listaCorreos = null;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);
			
			listaCorreos = servicioAdministracion.obtenerCorreosCorporativos(user.getAforeUsuario());
			model.addObject("correosCorporativos", this.obtenerCadenaCorreo(listaCorreos));
			
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un rproblema al consultar los correos", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Controlador encargado de editar correos
	 * @param correo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/editaCorreo.do",method = RequestMethod.POST)
	public ModelAndView registrarAdministraCorreo(@ModelAttribute DatosOrganizacion correo, HttpServletRequest request){
		ModelAndView model = new ModelAndView(NavegacionEnum.CORREO_CORPORATIVO.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_CORREO, new DatosOrganizacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		List<CorreoCorporativo> lista = null;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			String claveAfore = user.getAforeUsuario();
			List<Rol> rolesUser = user.getRoles();
			boolean isAdmin = this.validarRolAdministrador(rolesUser);
			
			if (isAdmin && !utileriaValidador.validarVacio(correo.getClave())) {
				claveAfore = correo.getClave();
			}
			String[] correos = request.getParameterValues("checkCorreo");
			
			lista = servicioAdministracion.listaCorreos(claveAfore);
			if(!utileriaValidador.validarVacio(correo.getEmail())) {
				respuesta = servicioAdministracion.guardarCorreos(correo, user, claveAfore);
				correo.setEmail(ExpresionesConstants.VACIO);
			}
			
			RespuestaServicio respuesta1 = servicioAdministracion.editarCorreos(correo, user, correos, lista);
			if(utileriaValidador.validarObjetoNulo(respuesta.getFlujo())) {
				respuesta = respuesta1;
			}
			model = new ModelAndView(NavegacionEnum.CORREO_CORPORATIVO.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_CORREO, correo);
			model = this.obtenerAforesAdministrador(rolesUser, model, false);
			lista = servicioAdministracion.listaCorreos(claveAfore);
			model.addObject("correosCorporativos", this.obtenerCadenaCorreo(lista));
		}catch(Exception e){
			logger.error("Exception en consultaCorreos >>", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Controlador encargado de ejecutar busqueda por organizacion
	 * @param claveOrganizacion
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/administraCorreo.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public RespuestaServicio consultarAdministraCorreo(@RequestParam("cvAfore") String claveAfore, HttpServletRequest request){
		logger.info("consultando correos corporativos");
		RespuestaServicio respuesta = new RespuestaServicio();
		List<CorreoCorporativo> listaCorreo = new ArrayList<>();
		String correos = null;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			
			if(utileriaValidador.validarObjetoNulo(claveAfore)) {
				claveAfore = user.getAforeUsuario();
			}
			
			listaCorreo = servicioAdministracion.obtenerCorreosCorporativos(claveAfore);
			correos = this.obtenerCadenaCorreo(listaCorreo);
			respuesta.setMensaje(correos);
		} catch(Exception e) {
			logger.error("Exception en administrarCorreo >>", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de cargar las afores de super administrador
	 * 
	 * @param rolUser
	 * @param model
	 * @return
	 */
	private ModelAndView obtenerAforesAdministrador(List<Rol> rolUser, ModelAndView model, boolean isAfores) {
		ModelAndView auxiliar = model;
		boolean isEncontrado = this.validarRolAdministrador(rolUser);
		if(isEncontrado) {
			List<String> lAfores = new ArrayList<>();
			lAfores.add(ActivacionConstants.CLAVE_SICI);
			auxiliar = utileriaConversion.agregarComboAModel(model, "afores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), lAfores), null);
		}
		return auxiliar;
	}
	
	/**
	 * Metodo encargado de validar el Rol de Administrador
	 * 
	 * @param rolUser
	 * @return
	 */
	private boolean validarRolAdministrador(List<Rol> rolUser) {
		boolean isAdmin = false;
		int i = 0;
		
		do {
			Rol roles = rolUser.get(i);
			if(RolesEnum.SUPER_ADMINISTRADOR.getRol().equals(roles.getClaveRol())) {
				
				isAdmin = true;
			}
			i++;
		} while(i < rolUser.size() && !isAdmin);
		
		return isAdmin;
	}
	
	/**
	 * Metodo para consultar usuario para reenvio de credenciales
	 * 
	 * @param usuarioPulssar
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/admin/reenvio.do", method = RequestMethod.GET)
	public ModelAndView consultarRenvioCredenciales(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.REENVIO_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REENVIO_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);

			List<Usuarios> usuariosInactivos = servicioAdministracion.consultarUsuariosCodigoVencido(user.getAforeUsuario(), EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario(), NumerosConstants.INT_CERO, RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
			
			model.addObject(ParametrosConstants.USUARIOS_REENVIA, usuariosInactivos);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consultar los usuarios inactivos", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Vista para asignar roles
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/reenviaUsuario.do", method = RequestMethod.POST)
	public ModelAndView reenviarUsuario(@ModelAttribute DatosRegistro datos, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.REENVIO_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REENVIO_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);

			String[] arregloUserReenvio = request.getParameterValues("chBoxReenvia");
			
			respuesta = servicioAdministracion.reenviarAltaUsuario(Arrays.asList(arregloUserReenvio), datos, user);
			List<Usuarios> usuariosInactivos = servicioAdministracion.consultarUsuariosCodigoVencido(user.getAforeUsuario(), EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario(), NumerosConstants.INT_CERO, RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_REENVIA, usuariosInactivos);
		} catch (Exception e) {
			logger.error("Se presento un problema al reenviar las credenciales", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de consulta la baja de una afore
	 * @param clave
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/reenvioAfore.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public List<UsuarioControlador> consultarreenvioClaveAfore(@RequestParam("cvAfore") String claveAfore, HttpServletRequest request) {
		logger.info("consulta de clave de afore usuarios reenvio");
		List<UsuarioControlador> usuarios = null;
		String clave = claveAfore;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			List<Usuarios> usuariosInactivos = servicioAdministracion.consultarUsuariosCodigoVencido(clave, EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario(), NumerosConstants.INT_CERO, RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
			usuarios = utileriaConversion.mapearUsuariosAjax(usuariosInactivos);
		}catch(Exception e){
			logger.error("Exception en reenvioAfore >>", e);
		}
		return usuarios;
	}
	
	/**
	 * Metodo para asignar perfiles
	 * 
	 * @param usuarioPulssar
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/admin/reactiva.do", method = RequestMethod.GET)
	public ModelAndView reactivarUsuario(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.REACTIVACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REACTIVA_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);

			List<Usuarios> usuarioBloqueado = servicioAdministracion.consultarUsuarioSinRol(user.getAforeUsuario(), user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario()), false, isAdmin);
			
			model.addObject(ParametrosConstants.USUARIOS_REACTIVA, usuarioBloqueado);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consultar los usuarios bloqueados", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	

	/**
	 * Vista para asignar roles
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/reactivaUsuario.do", method = RequestMethod.POST)
	public ModelAndView reactivarUsuariosBloqueados(@ModelAttribute DatosRegistro datos, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.REACTIVACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REACTIVA_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			model = this.obtenerAforesAdministrador(user.getRoles(), model, false);
			
			String[] arregloUserReactiva = request.getParameterValues("chBoxReactiva");
			String afore = user.getAforeUsuario();
			if (!utileriaValidador.validarVacio(datos.getClaveAfore())) {
				afore = datos.getClaveAfore();
			}
			
			respuesta = servicioAdministracion.reactivarUsuarios(Arrays.asList(arregloUserReactiva), afore, user.getUsuario());
			
			List<Usuarios> usuarioBloqueado = servicioAdministracion.consultarUsuarioSinRol(user.getAforeUsuario(), user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario()), false, isAdmin);
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_REACTIVA, usuarioBloqueado);
		} catch (Exception e) {
			logger.error("Se presento un problema al reactivar el usuario", e);
			model = new ModelAndView(NavegacionEnum.ASIGNACION_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ASIGNA_PERFIL, datos);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de consulta la baja de una afore
	 * @param clave
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/reactivaAfore.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public List<UsuarioControlador> consultarReactivacionClaveAfore(@RequestParam("cvAfore") String claveAfore, HttpServletRequest request) {
		logger.info("consulta de clave de afore usuarios reactiva");
		List<UsuarioControlador> usuarios = null;
		String clave = claveAfore;
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			List<Usuarios> usuarioBloqueado = servicioAdministracion.consultarUsuarioSinRol(clave, user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario()), false, isAdmin);
			usuarios = utileriaConversion.mapearUsuariosAjax(usuarioBloqueado);
		}catch(Exception e){
			logger.error("Exception en reactivaAfore >>", e);
		}
		return usuarios;
	}
	
	/**
	 * Controlador encargado de dar de alta a usuarios
	 * 
	 * @param urlServicio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/public/cambioPassword.do" }, method = RequestMethod.GET)
	public ModelAndView cambiarPassword(@RequestParam(value = "urlKey") String urlServicio,
			HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_CAMBIO_PASSWORD, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		String afore = "";
		try {
			String contextoAfore = "";
			String[] urlValida = request.getRequestURI().split("/");
			if(NumerosConstants.INT_CINCO == urlValida.length) {
				contextoAfore = urlValida[NumerosConstants.INT_DOS];
			}
			
			if(!utileriaValidador.validarVacio(contextoAfore)) {
				List<Parametro> lparametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_REDIRECCION, null);
				boolean isEncontrado = false;
				int i = NumerosConstants.INT_CERO;
				do {
					Parametro param = lparametro.get(i);
					if(param.getChValorParametro().contains(contextoAfore)) {
						afore = param.getChParametro();
						isEncontrado = true;
					}
					i++;
				} while(i < lparametro.size() && !isEncontrado);
			}
			
			if (!utileriaValidador.validarObjetoNulo(urlServicio)) {
				respuesta = servicioAdministracion.validarActivacionUsuario(urlServicio, null, false);
				DatosRegistro registro = new DatosRegistro();
				if(utileriaValidador.validarObjetoNulo(respuesta.getFlujo())) {
					registro.setNickUsuario(respuesta.getMensaje().trim());
				}
				request.getSession().setAttribute(ParametrosConstants.DATA_KEY, urlServicio);
				model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_CAMBIO_PASSWORD, registro);
			} else {
				logger.error("Se presento un problema al momento de validar el usuario");
				respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema al momento de cambiar el password", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, afore);
		request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);

		return model;
	}

	/**
	 * Controlador encargado de dar de alta a usuarios
	 * 
	 * @param urlServicio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/public/guardarCambios.do" }, method = RequestMethod.POST)
	public ModelAndView guardarCambios(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_CAMBIO_PASSWORD, datosUsuario);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String urlKey = (String) request.getSession().getAttribute(ParametrosConstants.DATA_KEY);
			
			respuesta = servicioAdministracion.activarUsuario(datosUsuario, urlKey);
			if (respuesta.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
				model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_CAMBIO_PASSWORD, new DatosRegistro());
				request.getSession().removeAttribute(ParametrosConstants.DATA_KEY);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema al momento de guardar loss cambios", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);

		return model;
	}

	/**
	 * Controlador encargado de dar de alta a usuarios
	 * 
	 * @param urlServicio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/public/activacionUsuario.do" }, method = RequestMethod.GET)
	public ModelAndView asignarContrasenia(@RequestParam(value = "urlKey") String urlServicio, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.ACTIVA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_USUARIO_ACTIVA,
				new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String contextoAfore = "";
			String[] urlValida = request.getRequestURI().split("/");
			if(NumerosConstants.INT_CINCO == urlValida.length) {
				contextoAfore = urlValida[NumerosConstants.INT_DOS];
			}
			
			if(!utileriaValidador.validarVacio(contextoAfore)) {
				List<Parametro> lparametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_REDIRECCION, null);
				boolean isEncontrado = false;
				int i = NumerosConstants.INT_CERO;
				do {
					Parametro param = lparametro.get(i);
					if(param.getChValorParametro().contains(contextoAfore)) {
						user.setAforeUsuario(param.getChParametro());
						List<Combo> listaGenerica = obtenerComboSucursales(param.getChParametro());
						request.getSession().setAttribute("listaSucursales", listaGenerica);
						isEncontrado = true;
					}
					i++;
				} while(i < lparametro.size() && !isEncontrado);
			}
			
			if (!utileriaValidador.validarObjetoNulo(urlServicio)) {
				respuesta = servicioAdministracion.validarActivacionUsuario(urlServicio, null, false);
				DatosRegistro registro = new DatosRegistro();
				if(utileriaValidador.validarObjetoNulo(respuesta.getFlujo())) {
					registro.setNickUsuario(respuesta.getMensaje().trim());
				}
				request.getSession().setAttribute(ParametrosConstants.DATA_KEY, urlServicio);
				
				model = new ModelAndView(NavegacionEnum.ACTIVA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_USUARIO_ACTIVA, registro);
			} else {
				logger.error("Se presento un problema al momento de validar el usuario");
				respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema al momento de asignar contrasenia", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, user.getAforeUsuario());
		request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);

		return model;
	}

	/**
	 * Controlador encargado de dar de alta a usuarios
	 * 
	 * @param urlServicio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/public/guardarActivacion.do" }, method = RequestMethod.POST)
	public ModelAndView guardarActivacion(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.ACTIVA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_USUARIO_ACTIVA,
				datosUsuario);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String urlKey = (String) request.getSession().getAttribute(ParametrosConstants.DATA_KEY);
			respuesta = servicioAdministracion.activarUsuario(datosUsuario, urlKey);
			if(respuesta.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
				model = new ModelAndView(NavegacionEnum.ACTIVA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_USUARIO_ACTIVA, new DatosRegistro());
				request.getSession().removeAttribute(ParametrosConstants.DATA_KEY);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema al momento de guardar la activacion", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);

		return model;
	}
	
	/**
	 * Controlador encargado de reenvias sms con codigo 
	 * 
	 * @param urlServicio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/public/reenviarCodigoActivacion.do" }, method = RequestMethod.POST)
	public ModelAndView reenviarCodigoActivacion(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.ACTIVA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_USUARIO_ACTIVA,
				datosUsuario);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String urlKey = (String) request.getSession().getAttribute(ParametrosConstants.DATA_KEY);
			respuesta = servicioAdministracion.reenviarCodigo(datosUsuario, urlKey);
			if(respuesta.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
				model = new ModelAndView(NavegacionEnum.ACTIVA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_USUARIO_ACTIVA, new DatosRegistro());
				request.getSession().removeAttribute(ParametrosConstants.DATA_KEY);
			}
		}  catch (BusinessException be) {
			logger.error("Se presento un problema de negocio al momento de reenviar el codigo de activacion", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.CODIGO_NO_VALIDO_REENVIO_ACTIVACION.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}catch (Exception e) {
			logger.error("Se presento un problema al momento de reenviar el codigo de activacion", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);

		return model;
	}
	
	/**
	 * Controlador encargado de reenvias sms con codigo 
	 * 
	 * @param urlServicio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/public/reenviarCodigoPassword.do" }, method = RequestMethod.POST)
	public ModelAndView reenviarCodigoPassword(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_CAMBIO_PASSWORD,
				datosUsuario);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String urlKey = (String) request.getSession().getAttribute(ParametrosConstants.DATA_KEY);
			
			respuesta = servicioAdministracion.reenviarCodigo(datosUsuario, urlKey);
			if(respuesta.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
				model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_CAMBIO_PASSWORD, new DatosRegistro());
			}
		}  catch (BusinessException be) {
			logger.error("Se presento un problema de negocio al momento de reenviar el codigo de cambio de password", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.CODIGO_NO_VALIDO_REENVIO_RECUPERACION.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}catch (Exception e) {
			logger.error("Se presento un problema al momento de reenviar el codigo de cambio de password", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);

		return model;
	}
	
	/**
	 * Metodo encargado de mostrar vista para modificar contrasena
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validate/modificarPassword.do",method = RequestMethod.GET)
	public ModelAndView modificarPassword(HttpServletRequest request){
		ModelAndView model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD_AGENTE.getNavegacion(), "modificarPassword", new DatosRegistro());
		try{
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		}catch(Exception e){
			logger.error("Error al modificar la contrasenia", e);
		}
		return model;
		
	}
	
	/**
	 * Metodo encargado de modificar contrasenia
	 * @param datos
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validate/ejecutarModificarPassword.do",method = RequestMethod.POST)
	public ModelAndView ejecutarModificarPassword(@ModelAttribute DatosRegistro datos, HttpServletRequest request){
		logger.info("Se inicia proceso de cambio de passwors");
		ModelAndView model = new ModelAndView(NavegacionEnum.CAMBIO_PASSWORD_AGENTE.getNavegacion(), "modificarPassword", new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			if(datos.getPassword().equals(datos.getConfirmarPassword())){
				servicioDirectorio.recuperaContrasenia(user.getUsuario(), datos.getPassword());
				servicioAdministracion.modificarEstatus(user);			
				respuesta.setFlujo(NumerosConstants.INT_UNO);
				respuesta.setTitulo("Cambio Exitoso");
				respuesta.setMensaje("El cambio de contraseña fue exitoso.");
			}else {
				throw new BusinessException(GenericErrorEnum.PASSWORD_IGUALES.getClave());
			}
		}catch(Exception e){
			logger.error("Error al ejecutar modificar la contraseña", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		return model;
		
	}
	
	/**
	 * Metodo encargado de modificar contrasenia
	 * @param datos
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validate/finalizaCambio.do",method = RequestMethod.GET)
	public ModelAndView redireccionarModificacionPassword(HttpServletRequest request, HttpServletResponse response){
		logger.info("Se valida el redireccionamiento de la pagina");
		ModelAndView model = new ModelAndView(NavegacionEnum.LOGOUT.getNavegacion());
		String redireccion = null;
		UsuarioLogin user = new UsuarioLogin();
		user.setFlujo(NumerosConstants.INT_CERO);
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			switch (user.getFlujo()) {
			case 0:
				redireccion = "/pulssar/logout";
				break;
			case 1:
				redireccion = "/pulssar/admin/menu.do";
				break;
			case 2:
				redireccion = "/pulssar/private/consultaTrabajador.do";
				break;
			default:
				redireccion = "/pulssar/logout";
				break;
			}
			
			request.getSession().setAttribute(ParametrosConstants.ADMIN_PANTALLA, user);
			response.sendRedirect(redireccion);
		} catch (Exception e) {
			logger.error("Error al ejecutar modificar la contraseña", e);
		}
		return model;
	}
	
	/**
	 * Realiza la carga del combo Sucursales por clave afore
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/admin/cargaDescZona.do" , method= RequestMethod.GET)
	@ResponseBody List<Combo> cargarDescZonas(HttpServletRequest request, String claveAfore, String zona) {
		UsuarioLogin user = new UsuarioLogin();
		List<Combo> lCombo = new ArrayList<>();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			String clave = claveAfore;
			if(utileriaValidador.validarVacio(claveAfore)) {
				clave = user.getAforeUsuario();
			}
			logger.info("GestionUsuariosController. Obtiene la descripcion de zonas por clave afore: {} y zona {}", clave, zona);
			lCombo = servicioCatalogoInt.obtenerZonasOficina(clave, zona, NumerosConstants.INT_UNO);
		} catch (Exception e) {
			logger.error("Error al obtener la descripcion de las zonas");
		}
		return lCombo;
	}
	
	/**
	 * Realiza la carga del combo Sucursales por clave afore
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/admin/cargaOficina.do", method= RequestMethod.GET)
	@ResponseBody List<Combo> cargarOficinas(HttpServletRequest request, String claveAfore, String zona){
		UsuarioLogin user = new UsuarioLogin();
		List<Combo> lCombo = new ArrayList<>();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			String clave = claveAfore;
			if(utileriaValidador.validarVacio(claveAfore)) {
				clave = user.getAforeUsuario();
			}
			logger.info("GestionUsuariosController. Obtiene la descripcion de zonas por clave afore: {} y zona {}", clave, zona);
			lCombo = servicioCatalogoInt.obtenerZonasOficina(clave, zona, NumerosConstants.INT_DOS);
		} catch (Exception e) {
			logger.error("Error al obtener la descripcion de las zonas");
		}
		return lCombo;
	}
	
	/**
	 * Obtiene un usuario Auxiliar en caso de que el original se pierda
	 * 
	 * @return
	 */
	private UsuarioLogin obtenerUsuarioLoginAuxiliar() {
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		List<Rol> auxRoles = new ArrayList<>();				
		Rol rol = servicioRoles.obtenerRolPorRolClaveAfore(RolesEnum.AGENTE_VENTANILLA.getRol(), RolesConstants.CLAVE_PROCESAR);		
		auxRoles.add(rol);
		user.setRoles(auxRoles);
		return user;
	}
	
	/**
	 * Metodo encargado de setear los valores de usuario y repsuesta en el modelo de vista
	 * 
	 * @param model
	 * @param user
	 * @param respuesta
	 * @return
	 */
	private ModelAndView obtenerVistaFinal(ModelAndView model, UsuarioLogin user, RespuestaServicio respuesta) {
		ModelAndView auxiliar = model;
		
		auxiliar = utileriaConversion.obtenerImagenNombreUsuario(auxiliar, user);
		auxiliar = utileriaConversion.agregarRespuestaModel(auxiliar, respuesta);
		
		return auxiliar;
	}
	
	/**obtenerRolesPorClaveAfore
	 * Metodo encargado de obtener los roles dependiendo del tipo de administrador
	 * 
	 * @param rolUser
	 * @param model
	 * @return
	 */
	private ModelAndView obtenerRolesPorClaveAfore(List<Rol> rol, String claveAfore, ModelAndView model) {
		ModelAndView auxiliar = model;
		
		List<RolesCatalogo> roles = this.obtenerRolesCatalogo(claveAfore);
		boolean isAdmin = this.validarRolAdministrador(rol);
		List<RolesCatalogo> listaRoles = this.obtenerListaRolesAdministradores(isAdmin, roles);
		List<Combo> listaPlataforma = utileriaConversion.obtenerCatalogoGenerico(servicioCatalogoUsuario.obtenerPlataformas(), "idPlataforma", "nombrePlataforma");
		
		auxiliar = utileriaConversion.agregarComboAModel(auxiliar, ParametrosConstants.PARAMETRO_ROLES, utileriaConversion.obtenerRolesUsuario(listaRoles), null);
		auxiliar = utileriaConversion.agregarComboAModel(auxiliar, "plataformas", listaPlataforma, null);
		if (isAdmin) {
			auxiliar = utileriaConversion.agregarComboAModel(auxiliar, "afores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ExpresionesConstants.VACIO)), null);
			auxiliar = utileriaConversion.agregarComboAModel(auxiliar, "listaAfores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ActivacionConstants.CLAVE_PROCESAR, ActivacionConstants.CLAVE_SICI)), null);
		}	
		return auxiliar;
	}
	
	/**
	 * Metodo encargado de obtener los roles de usuarios distintos a super admin
	 * 
	 * @param rolesLista
	 * @param roles
	 * @return
	 */
	private List<RolesCatalogo> obtenerListaRolesAdministradores(boolean isAdmin, List<RolesCatalogo> roles) {
		List<RolesCatalogo> listaRoles = null;
		
		if(isAdmin) {
			listaRoles = roles;
		} else {
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, "");
			String rolesLista = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_ALTA_USUARIOS, RolesConstants.PERFILES_ALTA_ADMIN);
			listaRoles = new ArrayList<>();
			for (RolesCatalogo rolesCatalogo : roles) {
				if(rolesLista.contains(rolesCatalogo.getClaveRol())) {
					listaRoles.add(rolesCatalogo);
				}
			}
		}
		
		return listaRoles;
	}
	
	/**
	 * Metodo encargado de obtener los roles dependiendo del tipo de administrador
	 * 
	 * @param rolUser
	 * @param claveAfore 
	 * @param model
	 * @return
	 */
	private ModelAndView obtenerRolesVista(String rolUser, String claveAfore, ModelAndView model) {
		ModelAndView auxiliar = model;
		
		List<RolesCatalogo> listaRoles = this.obtenerRolesPorAfore(claveAfore, rolUser);
		auxiliar = utileriaConversion.agregarComboAModel(auxiliar, ParametrosConstants.PARAMETRO_ROLES, utileriaConversion.obtenerRolesUsuario(listaRoles), null);
		
		return auxiliar;
	}
	
	/**
	 * Metodo encargado de obtener los roles opr afore
	 * 
	 * @param claveAfore
	 * @param rolUser
	 * @return
	 */
	private List<RolesCatalogo> obtenerRolesPorAfore(String claveAfore, String rolUser) {
		List<RolesCatalogo> auxListaRoles = servicioRoles.buscarRolPorAfore(claveAfore);
		List<RolesCatalogo> listaRoles = null;
		if(!utileriaValidador.validarListaVacia(auxListaRoles)) {
			listaRoles = new ArrayList<>();
			for(RolesCatalogo rol : auxListaRoles) {
				if(rolUser.contains(rol.getClaveRol())) {
					listaRoles.add(rol);
				}
			}
		}
		return listaRoles;
	}

	/**
	 * Metod encargado de obtener el mapa de los usuarios
	 * 
	 * @param usuarioRol
	 * @return
	 */
	private Map<String, List<UsuariosModificar>> obtenerMapaUsuariosModifica(List<UsuariosModificar> usuarioRol,
			List<UsuariosModificar> auxiliarUsuario) {
		Map<String, List<UsuariosModificar>> listaUsuarios = null;
		if (!utileriaValidador.validarListaVacia(usuarioRol)) {
			listaUsuarios = new HashMap<>();
			for (UsuariosModificar usuario : usuarioRol) {
				String user = utileriaValidador.validarVacio(usuario.getNickUsuario()) ? usuario.getUsuario()
						: usuario.getNickUsuario();
				List<UsuariosModificar> lMap;
				if (!listaUsuarios.containsKey(user)) {
					lMap = new ArrayList<>();
					lMap.add(usuario);
					auxiliarUsuario.add(usuario);
				} else {
					lMap = listaUsuarios.get(user);
					lMap.add(usuario);
				}
				listaUsuarios.put(user, lMap);
			}
		}
		return listaUsuarios;
	}
	
	/**
	 * Obtener la lista de roles
	 * 
	 * @param cadenaRoles
	 * @return
	 */
	private List<UsuariosEnum> obtenerListaRolesUsuarioOIDEliminar(List<UsuariosEnum> rolesEnumAsginar) {
		List<UsuariosEnum> listaRoles = new ArrayList<>();
		
		if(!rolesEnumAsginar.contains(UsuariosEnum.ADMINISTRADORES)) {
			listaRoles.add(UsuariosEnum.ADMINISTRADORES);
		}
		
		if(!rolesEnumAsginar.contains(UsuariosEnum.USUARIOS)) {
			listaRoles.add(UsuariosEnum.USUARIOS);
		}

		
		return listaRoles;
	}
	
	/**
	 * Obtener cadena de correo
	 */
	private String obtenerCadenaCorreo(List<CorreoCorporativo> listaRoles) {
		String cadena = ExpresionesConstants.VACIO;
		if (!utileriaValidador.validarListaVacia(listaRoles)) {
			int contador = 0;
			do {
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.UL_INICIAL);
				List<Object> objeto = this.llenarListaCorreo(listaRoles, contador);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, (String) objeto.get(NumerosConstants.INT_CERO),
						TextoConstants.UL_CERRAR);
				contador = (int) objeto.get(NumerosConstants.INT_UNO);
			} while (contador < listaRoles.size());
		}
		return cadena;
	}
	/**
	 * llenar lista de correo
	 * @param lista
	 * @param contador
	 * @param value
	 * @return
	 */
	private List<Object> llenarListaCorreo(List<CorreoCorporativo> lista, int contador) {
		List<Object> objeto = new ArrayList<>();
		int aux = 0;
		int aContador = contador;
		String cadena = ExpresionesConstants.VACIO;
		String checked;
		do {
			checked = lista.get(aContador).getEstatus().equals(NumerosConstants.INT_UNO) ? TextoConstants.INPUT_CHECKBOX_CIERRE_CHECKED : TextoConstants.INPUT_CHECKBOX_CIERRE;
			cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.LI_INICIAL, TextoConstants.INPUT_CHECKBOX, lista.get(aContador).getEmail(), checked, lista.get(aContador).getEmail(), TextoConstants.LI_CERRAR);
			aContador++;
			aux++;
		} while (aux < NumerosConstants.INT_DIEZ && aContador < lista.size());
		objeto.add(cadena);
		objeto.add(aContador);
		return objeto;
	}
	
	/**
	 * Obtener roles por clave afore 
	 * @param claveAfore
	 * @return
	 */
	private List<RolesCatalogo> obtenerRolesCatalogo(String claveAfore){
		List<RolesCatalogo> rolesCatalogo = servicioRoles.buscarRolPorAfore(claveAfore);
		return rolesCatalogo;
	}
	
	/**
	 * Obtener combo sucursal 
	 * @param claveAfore
	 * @return
	 */
	private List<Combo> obtenerComboSucursales(String claveAfore) {
		if(!utileriaValidador.validarVacio(claveAfore)) {
			List<SucursalAfore> listaServicios = servicioCatalogo.obtenerSucursales(claveAfore);
			return Lists.newArrayList(Collections2.transform(listaServicios, new Function<SucursalAfore, Combo>() {
				@Override
				public Combo apply(SucursalAfore tipoServicio) {
					Combo combo = new Combo();
					combo.setClave(String.valueOf(tipoServicio.getClaveSucursal()));
					combo.setDescripcion(tipoServicio.getClaveSucursal());

					return combo;
				}
			}));
		}
		return new ArrayList<>();
	}
	
	
	/**
	 * Servicio Rest para la CArga de usuarios masivos
	 * @Author Ricardo Alcantara Ramirez Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)@procesar.com
	 * Apr 28, 2022
	 * @param claveAfore
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/admin/cargaUsuarios.do")
	public ModelAndView cargaUsuarios(HttpServletRequest request){
		logger.info("GestionUsuariosController. cargaUsuarios.do");
		ModelAndView model = new ModelAndView(NavegacionEnum.SUB_MENU_CARGA_MASIVA.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		List<MenuPagina> menuUsuario = servicioAdministracion.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
		request.getSession().setAttribute("menuUsuario", menuUsuario);
		
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		MenuPagina enlaceToNip = devolverLinkToVistaNip(menuUsuario);
		if(enlaceToNip != null) { // Se trata de un usuario con permisos por Rol para ver el enlace de Genreación de NIP
			if(!isUsuarioTitular(trabajador)) { // No se trata del titular de la cuenta, por lo que se retira el enlace: Genraciónde Nip
				logger.info("[AMenu] -  Usuario No Titular. No tiene permiso para ver enlace: generaciónde Nip");
				menuUsuario.remove(enlaceToNip);
			}
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		// Al mostrar la vista amenu: Lanzar la respuesta (modal) encaso de ser diferente de Nulo
		RespuestaServicio respuesta = (RespuestaServicio)request.getAttribute("respuesta");
		if (respuesta != null) {
			
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		return model;
	}
	
	/**
	 * Devuelve el elemento MenuPagina asociado al enlace del Ménú que lleva a la vsita de generaciónde Nip
	 * @param menuUsuario
	 * @return MenuPagina
	 */
	private MenuPagina devolverLinkToVistaNip(List<MenuPagina> menuUsuario) {
		MenuPagina enlaceRespuesta = null;
		for(MenuPagina enlace : menuUsuario) {
			if (enlace.getChRutaMenu() != null && enlace.getChRutaMenu().equals(NipConstants.URI_VISTA_NIP)){
				logger.info("[AMenu] -  Usuario tiene permiso por Rol para ver enlace: generaciónde Nip");
				enlaceRespuesta = enlace;
			}
		}
		return enlaceRespuesta;
	}
	/** Se trata de un usuario de cuenta Titular.
	 * Nota. Lo determina el Agente promotor al seleccionar el Check de la página de consulta 360.
	 * @param trabajador
	 * @return
	 */
	private boolean isUsuarioTitular(DatosTrabajador trabajador) {
		// No es titular: Eliminamos de la vista enlace de generación de NIP
		return trabajador != null && ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante()); 
	}
	
	/**
	 * Metodo para asignar perfiles
	 * 
	 * @param usuarioPulssar
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/admin/usuariosCarga.do", method = RequestMethod.GET)
	public ModelAndView cargaUsuariosExcel(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CARGA_MASIVA_USURIOS.getNavegacion(), ParametrosConstants.FORMULARIO_ASIGNA_PERFIL, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, RolesConstants.PARAM_PERFILES_ASIGNAR);
			String listaRoles = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_ASIGNAR, RolesConstants.PERFIL_ASIGNAR);
			
			model = this.obtenerRolesVista(listaRoles, user.getAforeUsuario(), model);
			model = this.obtenerAforesAdministrador(user.getRoles(), model, true);
			
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(user.getAforeUsuario(), user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario()), true, isAdmin);
			
			model.addObject(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consulta la asginacion de perfiles", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	
	/**
	 * @param request
	 * @param chooseFile
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/cargaExcelUsuarios.do")
	public ModelAndView cargaArchivoUsuarioMasivo(HttpServletRequest request,@RequestParam CommonsMultipartFile chooseFile, HttpSession session) throws IOException {
		logger.error("cargaExcelUsuarios");
		ModelAndView model = new ModelAndView(NavegacionEnum.CARGA_MASIVA_USURIOS.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			logger.info("El nombre del Archivo es:: {}", chooseFile.getFileItem().getName());
			// Se extraen los datos del archivo
			Map<String, Object> mapDatos = procesarArchivoXlsService.obtenerDatosExcel(chooseFile.getFileItem().getName(), chooseFile.getInputStream(), user);
			model.addObject("respuesta", mapDatos.get("dtoRespuesta"));
		} catch (Exception e) {
			logger.error("Ocurrio un Exception en la carga confirmacion Screening Traspasos: Error :: {}",e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
			model = this.obtenerVistaFinal(model, user, respuesta);
		}
		return model;
	}
	
	
	/**
	 * @param request
	 * @param chooseFile
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value = "/admin/usuariosDescarga.do")
	public ModelAndView descargaArchivoUsuarios(HttpServletRequest request) {
		logger.error("usuariosDescarga.do");
		ModelAndView model = new ModelAndView(NavegacionEnum.DESCARGA_USUARIOS.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, RolesConstants.PARAM_PERFILES_ASIGNAR);
			String listaRoles = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_ASIGNAR, RolesConstants.PERFIL_ASIGNAR);
			
			model = this.obtenerRolesVista(listaRoles, user.getAforeUsuario(), model);
			model = this.obtenerAforesAdministrador(user.getRoles(), model, true);
			
			List<Usuarios> usuarioRol = servicioAdministracion.consultarUsuarioSinRol(user.getAforeUsuario(), user.getUsuario(), Arrays.asList(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario()), true, isAdmin);
			
			model.addObject(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			request.getSession().setAttribute(ParametrosConstants.USUARIOS_ASIGNA, usuarioRol);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consulta la asginacion de perfiles", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * @param request
	 * @param chooseFile
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/obtenerArchivoUser.do")
	public void obtenerArchivoUsuario(HttpServletRequest request, HttpServletResponse response,@RequestParam String fechaBusqueda) throws IOException {
		logger.error("cargaExcelUsuarios");
		ModelAndView model = new ModelAndView(NavegacionEnum.DESCARGA_USUARIOS.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		try {
			String usuarioModificado = (String) request.getSession().getAttribute(ParametrosConstants.SELECT_USUARIO);
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean isAdmin = this.validarRolAdministrador(user.getRoles());
			logger.info("LA fecha es:: {}", fechaBusqueda);
			
			// Se extraen los datos del archivo
//			Map<String, Object> mapDatos = 
			DatosCargaMasiva datos = procesarArchivoXlsService.obtenerArchivoUsuarios(fechaBusqueda,user);
			
			response.setContentType("application/xls");
			response.setHeader("Content-Disposition", "attachment; filename=".concat(datos.getNomArchivo()));
			ServletOutputStream out = response.getOutputStream();
			out.write(datos.getArchivo());
			out.flush();
			out.close();
		} catch (BusinessException be) {
			logger.error("Ocurrio un BusinessException en obtenerArchivoUsuario el error es :: {}", be);
			respuesta.setFlujo(NumerosConstants.INT_DOS);
			respuesta.setTitulo(MensajeConstants.ERROR_TITULO_GENERICO);
			respuesta.setMensaje(be.getMessage());
			request.getSession().setAttribute("respuestaDto", respuesta);
			response.sendRedirect("usuariosDescargaView.do");
			
		} catch (Exception e) {
			logger.error("Ocurrio un Exception en obtenerArchivoUser: Error :: {}",e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
			request.getSession().setAttribute("respuestaDto", respuesta);
			response.sendRedirect("usuariosDescargaView.do");
		}
	}
	
	/**
	 * @param request
	 * @param wrapper
	 * @return
	 */
	@GetMapping(value = "/usuariosDescargaView.do")
	public ModelAndView receptorArchivos(HttpServletRequest request)  {
		ModelAndView model = new ModelAndView(NavegacionEnum.DESCARGA_USUARIOS.getNavegacion());
		logger.info("usuariosDescargaView.do");
		UsuarioLogin user = this.obtenerUsuarioLoginAuxiliar();
		user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		RespuestaServicio respuesta = (RespuestaServicio) request.getSession().getAttribute("respuestaDto");
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
}