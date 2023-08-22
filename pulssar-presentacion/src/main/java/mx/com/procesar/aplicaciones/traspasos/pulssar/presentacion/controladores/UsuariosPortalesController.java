package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SucursalAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogosInternosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GestionUsuariosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AccesoVIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosOrganizacionIPs;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ModuloReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RolesModuloAccesoIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador para el manejo de peticiones de la gestion de usuarios
 * 
 * @version 1.0
 * @since
 */
/**
 * @Author dbarbosa
 */
@Controller
@RequestMapping(value = {"/", "/{value}"})
public class UsuariosPortalesController {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(UsuariosPortalesController.class);

	/**
	 * Inyeccion de Servicio Catalogo usuario
	 */
	@Autowired
	private CatalogoUsuarioService servicioCatalogoUsuario;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

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
	 * Inyeccion de servicio catalogo internos
	 */
	@Autowired
	private CatalogosInternosService servicioCatalogoInt;
	
	/**
	 * Css configurables
	 */
	@Value("${css.configurables}")
	private String cssConfigurable;
	
	/**
	 * Servicio de Alta usuarios
	 */
	@Autowired
	private GestionUsuariosService servicioGestion;

	/**
	 * Vista principal de Bienvenida
	 * 
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/alta.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ejecutarAltaUsuario(HttpServletRequest request) {
		logger.info("Modulo de alta de usuarios");
		ModelAndView model = new ModelAndView(NavegacionEnum.ALTA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ALTA_USUARIO, new DatosRegistro());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = null;
		List<Combo> lSucursales = null;
		List<Combo> lZonas = null;
		List<Combo> lReportes = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			model = this.obtenerRolesPorClaveAfore(user.getRoles().get(NumerosConstants.INT_CERO), user.getAforeUsuario(), NumerosConstants.C_UNO, model);			
			
			lSucursales = this.obtenerComboSucursales(user.getAforeUsuario());
			lZonas = servicioCatalogoInt.obtenerZonasOficina(user.getAforeUsuario(), null, NumerosConstants.INT_CERO);
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, "");
			String rolesLista = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_AGENTE, RolesConstants.PERFILES_ADMIN);
			model.addObject("dato", rolesLista);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al mostrar el alta de usuario", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarComboAModel(model, "listaSucursales", lSucursales, null);
		model = utileriaConversion.agregarComboAModel(model, "zonas", lZonas, null);
		model = utileriaConversion.agregarComboAModel(model, "reportes", lReportes, null);
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Realiza la carga de los roles de acuerdo a la afore seleccionada
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/admin/obtenerDatosAlta.do", method= RequestMethod.GET)
	@ResponseBody Respuesta obtenerDatosAlta(String claveAfore, String plataforma, HttpServletRequest request){
		logger.info("Obtiene los perfiles para el alta de la plataforma {}", plataforma, claveAfore);
		Respuesta respuesta = new Respuesta();
		String clave = claveAfore;
		UsuarioLogin user = null;
		try{
			Map<String, Object> mapaRespuesta = new HashMap<String, Object>();
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			Rol rolAdmin = user.getRoles().get(NumerosConstants.INT_CERO);
			Integer isAdmin = NumerosConstants.INT_CERO;
			if(RolesEnum.SUPER_ADMINISTRADOR.getRol().equals(rolAdmin.getClaveRol())) {
				isAdmin = NumerosConstants.INT_UNO;
			}
			List<RolesCatalogo> listaCatalogo = servicioCatalogoUsuario.obtenerRolesAdministracion(rolAdmin.getClaveRol(), clave, plataforma, isAdmin);

			if(!utileriaValidador.validarVacio(clave) && !ActivacionConstants.CLAVE_PROCESAR.equals(clave)) {
				List<Combo> listaSucursales = this.obtenerComboSucursales(clave);
				mapaRespuesta.put("listaSucursales", listaSucursales);
			}
			
			if(!utileriaValidador.validarVacio(clave) && !ActivacionConstants.CLAVE_PROCESAR.equals(clave)) {
				List<Combo> listaZonas = servicioCatalogoInt.obtenerZonasOficina(clave, null, NumerosConstants.INT_CERO);
				mapaRespuesta.put("listaZonas", listaZonas);
			}
			
			List<Combo> listaRoles = utileriaConversion.obtenerCatalogoGenerico(listaCatalogo, "claveRol", "descripcionRol");
			mapaRespuesta.put("listaRoles", listaRoles);
			
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			respuesta.setMapaRespuesta(mapaRespuesta);

		}catch(Exception e){
			logger.error("Exception en asignaAfore >>", e);
			respuesta.setFlujo(NumerosConstants.INT_DOS);
		}
		return respuesta;
	}
	
	/**
	 * Realiza la carga de los roles de acuerdo a la afore seleccionada
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/admin/obtenerModulos.do", method= RequestMethod.GET)
	@ResponseBody Respuesta obtenerModulos(String claveAfore, String[] valoresCheck, String plataforma, HttpServletRequest request) {
		logger.info("Valida si tiene modulos el perfil: {} <<< {}", valoresCheck, claveAfore);
		Respuesta respuesta = new Respuesta();
		UsuarioLogin user = null;
		try{
			String clave = claveAfore;
			Map<String, Object> mapaRespuesta = new HashMap<String, Object>();
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			if(utileriaValidador.validarVacio(clave)) {
				clave = user.getAforeUsuario();
			}
			
			RolesModuloAccesoIP rolModuloAcceso = servicioCatalogoUsuario.obtenerRolModuloAcceso(valoresCheck[NumerosConstants.INT_CERO], clave, plataforma);
			if(!utileriaValidador.isEmpty(rolModuloAcceso)) {
				mapaRespuesta.put("ipAcceso", Boolean.TRUE);
				
				if(NumerosConstants.INT_UNO.intValue() == rolModuloAcceso.getModulo().intValue()) {
					List<ModuloReporte> lstModulos = servicioCatalogoUsuario.obtenerModuloReportes();
					List<Combo> listaCombo = utileriaConversion.obtenerCatalogoGenerico(lstModulos, "idModuloReporte", "nombreModulo");
					mapaRespuesta.put("listaReportes", listaCombo);
				}
				respuesta.setMapaRespuesta(mapaRespuesta);
			}
		}catch(Exception e){
			logger.error("Exception en asignaAfore >>", e);
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
	@RequestMapping(value = "/admin/altaUsuario.do", method = RequestMethod.POST)
	public ModelAndView registrarAltaUsuario(@ModelAttribute DatosRegistro datosUsuario, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.ALTA_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_ALTA_USUARIO, new DatosRegistro());
		logger.info("Inicio de registro de usuarios");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = null;
		String rolesLista = RolesEnum.AGENTE_VENTANILLA.getRol();
		List<Combo> lSucursales = null;
		List<Combo> lZonas = null;
		List<Combo> lReportes = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			String[] arregloRoles = request.getParameterValues(ParametrosConstants.CHECK_ROLES);
			String[] arregloModulos = request.getParameterValues(ParametrosConstants.CHECK_MODULO_REPORTE);
			
			String afore = user.getAforeUsuario();
			boolean isAdmin = this.validarRolAdministrador(user.getRoles().get(NumerosConstants.INT_CERO));
			if (isAdmin) { 
				if(!utileriaValidador.validarVacio(datosUsuario.getClaveAfore())) {
					afore = datosUsuario.getClaveAfore();
				}
			}
			lSucursales = this.obtenerComboSucursales(user.getAforeUsuario());
			lZonas = servicioCatalogoInt.obtenerZonasOficina(user.getAforeUsuario(), null, NumerosConstants.INT_CERO);
			
			datosUsuario.setClaveAfore(afore);
			datosUsuario.setRoles(Arrays.asList(arregloRoles));
			if(arregloModulos != null) {
				datosUsuario.setPerfilSici(Arrays.asList(arregloModulos));
			}
			
			respuesta = this.validarRolAgente(arregloRoles, rolesLista, afore, datosUsuario.getNumeroAgente());
			if(NumerosConstants.INT_UNO == respuesta.getFlujo()) {
				respuesta = servicioGestion.guardarUsuario(datosUsuario, user.getUsuario());
				lSucursales = this.obtenerComboSucursales(user.getAforeUsuario());
				lZonas = servicioCatalogoInt.obtenerZonasOficina(user.getAforeUsuario(), null, NumerosConstants.INT_CERO);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema al realizar el registro de usuario nuevo", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = utileriaConversion.agregarComboAModel(model, "listaSucursales", lSucursales, null);
		model = utileriaConversion.agregarComboAModel(model, "zonas", lZonas, null);
		model = utileriaConversion.agregarComboAModel(model, "reportes", lReportes, null);
		model.addObject("dato", rolesLista);
		model = this.obtenerRolesPorClaveAfore(user.getRoles().get(NumerosConstants.INT_CERO), user.getAforeUsuario(), datosUsuario.getIdPlataforma(), model);
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Controlador encargado de buscar ips corporativo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/consultaIPs.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ejecutarAdministraCorreo(HttpServletRequest request) {
		RespuestaServicio respuesta = new RespuestaServicio();
		ModelAndView model = new ModelAndView(NavegacionEnum.IPS_CORPORATIVO.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_IPS, new DatosOrganizacionIPs());
		UsuarioLogin user = null;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			model.addObject("afores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ExpresionesConstants.VACIO)));
			model.addObject("plataformas", utileriaConversion.obtenerCatalogoGenerico(servicioCatalogoUsuario.obtenerPlataformas(), "idPlataforma", "nombrePlataforma"));
			
			respuesta.setFlujo(NumerosConstants.INT_TRES);
		} catch (Exception e) {
			logger.error("Se presento un problema al consultar las IPs", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS,null);
		}
		model = this.obtenerVistaFinal(model, user, respuesta);
		return model;
	}
	
	/**
	 * Controlador encargado de ejecutar busqueda por organizacion
	 * @param claveOrganizacion
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/administraIP.do", method = RequestMethod.GET, produces = { "application/json" } )
	@ResponseBody
	public RespuestaServicio consultarAdministraIps(@RequestParam("cvAfore") String claveAfore, @RequestParam("plataforma") String plataforma, HttpServletRequest request){
		logger.info("consultando correos corporativos");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = null;
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			
			if(utileriaValidador.isEmpty(claveAfore)) {
				claveAfore = user.getAforeUsuario();
			}
			
			if(utileriaValidador.isEmpty(plataforma)) {
				plataforma = String.valueOf(NumerosConstants.INT_UNO);
		}
		
		List<AccesoVIP> accesos = servicioGestion.consultarIpsAforePlataforma(claveAfore, plataforma);
		respuesta.setMensaje(obtenerIPs(accesos));
		respuesta.setFlujo(NumerosConstants.INT_UNO);
	} catch(Exception e) {
		logger.error("Exception en administrarIps >>", e);
		respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
	}
		return respuesta;
	}
	
	/**
	 * Controlador encargado de editar correos
	 * @param correo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/editaIPs.do",method = RequestMethod.POST)
	public ModelAndView registrarAdministraCorreo(@ModelAttribute DatosOrganizacionIPs datosIp, HttpServletRequest request){
		ModelAndView model = new ModelAndView(NavegacionEnum.IPS_CORPORATIVO.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_IPS, new DatosOrganizacionIPs());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = null;
		try{
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_TRES);
			if(utileriaValidador.isEmpty(datosIp.getClave()) || utileriaValidador.isEmpty(datosIp.getIdPlataforma())) {
				respuesta.setFlujo(NumerosConstants.INT_DOS);
				respuesta.setMensaje("Favor de seleccionar Afore y Plataforma para registrar las IP's");
				respuesta.setTitulo("Solicitud Rechazada");
			} else if(!utileriaValidador.isEmpty(datosIp.getIpsPlataforma())) {
				String[] ips = datosIp.getIpsPlataforma().split("\r\n");
				
				List<String> ipsGuardar = servicioGestion.validarIps(Arrays.asList(ips), datosIp.getClave(), datosIp.getIdPlataforma());
				
				if(!utileriaValidador.validarListaVacia(ipsGuardar)) {
					servicioGestion.guardarIps(ipsGuardar, datosIp.getClave(), datosIp.getIdPlataforma(), user.getUsuario());
					respuesta.setFlujo(NumerosConstants.INT_UNO);
					StringBuilder cadenaMensaje = new StringBuilder();
					cadenaMensaje.append("Se guardó correctamente ");
					cadenaMensaje.append(ipsGuardar.size());
					cadenaMensaje.append(" registro(s)");
					respuesta.setMensaje(cadenaMensaje.toString());
					respuesta.setTitulo("Solicitud Aceptada");
				} else {
					respuesta.setMensaje("La(s) IP('s) ya se encontraba(n) guardada(s), favor de intentar con otra.");
					respuesta.setTitulo("Informativo");
					respuesta.setFlujo(NumerosConstants.INT_CUATRO);
				}
			} else {
				respuesta.setFlujo(NumerosConstants.INT_DOS);
				respuesta.setMensaje("Favor de capturar las IP's a guardar");
				respuesta.setTitulo("Solicitud Rechazada");
			}
			
			model.addObject("afores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ExpresionesConstants.VACIO)));
			model.addObject("plataformas", utileriaConversion.obtenerCatalogoGenerico(servicioCatalogoUsuario.obtenerPlataformas(), "idPlataforma", "nombrePlataforma"));
		}catch(Exception e){
			logger.error("Exception en consultaCorreos >>", e);
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
	@RequestMapping(value = "/admin/validarPerfil.do", method= RequestMethod.GET)
	@ResponseBody Respuesta validarPerfilModificacion(String claveAfore, String rol, HttpServletRequest request){
		logger.info("Obtiene los perfiles para el alta de la plataforma {}", claveAfore);
		Respuesta respuesta = new Respuesta();
		try{
			respuesta.setFlujo(NumerosConstants.INT_DOS);
			RolesModuloAccesoIP rolModuloAcceso = servicioCatalogoUsuario.obtenerRolModuloAccesoModificacion(rol, claveAfore);
			if(!utileriaValidador.isEmpty(rolModuloAcceso)) {
				if(NumerosConstants.INT_UNO.intValue() == rolModuloAcceso.getModulo().intValue()) {
					respuesta.setFlujo(NumerosConstants.INT_UNO);
				}
			}
		}catch(Exception e){
			logger.error("Exception en asignaAfore >>", e);
			respuesta.setFlujo(NumerosConstants.INT_DOS);
		}
		return respuesta;
	}

	/**obtenerRolesPorClaveAfore
	 * Metodo encargado de obtener los roles dependiendo del tipo de administrador
	 * 
	 * @param rolUser
	 * @param model
	 * @return
	 */
	private ModelAndView obtenerRolesPorClaveAfore(Rol rol, String claveAfore, String plataforma, ModelAndView model) {
		ModelAndView auxiliar = model;
		
		boolean isAdmin = this.validarRolAdministrador(rol);
		List<RolesCatalogo> listaCatalogo = servicioCatalogoUsuario.obtenerRolesAdministracion(rol.getClaveRol(), claveAfore, plataforma, isAdmin ? NumerosConstants.INT_UNO: NumerosConstants.INT_CERO);
		List<Combo> listaPlataforma = utileriaConversion.obtenerCatalogoGenerico(servicioCatalogoUsuario.obtenerPlataformas(), "idPlataforma", "nombrePlataforma");
		
		auxiliar = utileriaConversion.agregarComboAModel(auxiliar, ParametrosConstants.PARAMETRO_ROLES, utileriaConversion.obtenerRolesUsuario(listaCatalogo), null);
		auxiliar = utileriaConversion.agregarComboAModel(auxiliar, "plataformas", listaPlataforma, null);
		if (isAdmin) {
			auxiliar = utileriaConversion.agregarComboAModel(auxiliar, "afores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ActivacionConstants.CLAVE_SICI)), null);
			auxiliar = utileriaConversion.agregarComboAModel(auxiliar, "listaAfores", utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ActivacionConstants.CLAVE_PROCESAR, ActivacionConstants.CLAVE_SICI)), null);
		}	
		return auxiliar;
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
	
	/**
	 * Metodo encargado de validar el Rol de Administrador
	 * 
	 * @param rolUser
	 * @return
	 */
	private boolean validarRolAdministrador(Rol rolUser) {
		boolean isAdmin = false;
		if(RolesEnum.SUPER_ADMINISTRADOR.getRol().equals(rolUser.getClaveRol())) {
			
			isAdmin = true;
		}
		
		return isAdmin;
	}
	
	/**
	 * Metodo encargado de validar el Rol de Agente
	 * 
	 * @param arregloRoles
	 * @param rolesLista
	 * @param claveAfore
	 * @return
	 */
	private RespuestaServicio validarRolAgente(String[] arregloRoles, String rolesLista, String claveAfore, String numAgente) {
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_UNO);
		if(!utileriaValidador.validarObjetoNulo(arregloRoles)) {
			boolean isAgente = false;
			int i = 0;
			do {
				String rol = arregloRoles[i];
				if(rolesLista.contains(rol)) {
					isAgente = true;
				}
				i++;
			} while(i < arregloRoles.length && !isAgente);
			
			if(isAgente && utileriaValidador.validarVacio(numAgente)) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.AGENTE_NO_CAPTURADO.getClave(), claveAfore, NumerosConstants.INT_DOS, null);
			}
		}
		return respuesta;
	}
	
	/**
	 * Obtener las IPs
	 */
	private String obtenerIPs(List<AccesoVIP> accesos) {
		StringBuilder cadena = new StringBuilder();
		if(!utileriaValidador.validarListaVacia(accesos)) {
			for(AccesoVIP acceso : accesos) {
				cadena.append(acceso.getIpAfore());
				cadena.append(ExpresionesConstants.SALTO);
			}
		}
		return cadena.toString();
	}
}