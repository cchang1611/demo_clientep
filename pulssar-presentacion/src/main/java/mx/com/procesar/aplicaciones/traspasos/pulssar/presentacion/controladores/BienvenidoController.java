package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SucursalAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.TextoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogosInternosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RegistroUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SessionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAltaUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosUsuariosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RolesModuloAccesoIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SessionUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Usuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador para el manejo de peticiones de la pagina inicial
 * 
 * @version 1.0
 * @since
 */
@Controller
@RequestMapping(value = {"/", "/{value}"})
public class BienvenidoController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BienvenidoController.class);
	
	/**
	 * Inyeccion de Servicio registro
	 */
	@Autowired
	private RegistroUsuarioService servicioRegistro;
	
	/**
	 * Inyeccion de Servicio registro
	 */
	@Autowired
	private ValidarAltaUsuarioService servicioAlta;
	
	/**
	 * Inyeccion de Servicio registro
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdmin;
	
	/**
	 * Inyeccion de servicio catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de servicio catalogo internos
	 */
	@Autowired
	private CatalogosInternosService serviciosIntCatalogo;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;

	/**
	 * Inyeccion de utileria
	 */
	@Value("${css.configurables}")
	private String cssConfigurable;
	
	/**
	 * Encriptacion
	 */
	@Autowired
	private EncriptacionUtils utileriaEncripta;
	
	/**
	 * servicio usuario sesion
	 */
	@Autowired
	private SessionUsuarioService usuarioService;
	
	/**
	 * servicio usuario sesion
	 */
	@Autowired
	private CatalogoUsuarioService servicioCatalogoUsuario;
	
	/**
	 * Ruta imagenes
	 */
	@Value("${ruta.imagenes}")
	private String rutaImagenes;
	
	/**
     * Url del comparador para la redireccion de logout
     */
    @Value("${uri.comparador.banamex}")
    private String urlComparador;
    
    /**
	 * Key seguridad
	 */
	@Value("${key.seguridad.encriptacion.usuario}")
	private String keySeguridadEncriptacion;

    /**
     * Vista principal de Bienvenida
     * @author DBARBOSA
     * @return
     */
	@RequestMapping(value = {"/", "/public/bienvenido.do"}, method = RequestMethod.GET)
	public ModelAndView validarBienvenido(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.BIENVENIDA.getNavegacion());
		String afore = null;
		try {
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			logger.error("Entra (/public/bienvenido.do): {}", user);
			
			String contextoAfore = this.validarCookie(request, response);
			logger.error("Contexto Afore (/public/bienvenido.do): {}", contextoAfore);
			
			if(utileriaValidador.validarVacio(contextoAfore)) {				
				String[] urlValida = request.getRequestURI().split("/");
				logger.error("URL Valida (/public/bienvenido.do): {} - Longitud: {}",  request.getRequestURI(), urlValida.length);
				
				if(NumerosConstants.INT_CINCO == urlValida.length) {
					contextoAfore = urlValida[NumerosConstants.INT_DOS];
				}
			} else{

				logger.error("Contexto Afore No Vacio: {}",contextoAfore);
				response.sendRedirect(utileriaCadena.obtenerCadenaConcatenada(true, ParametrosConstants.DIAGONAL, ParametrosConstants.CONTEXTO_PULSSAR, contextoAfore, ParametrosConstants.CONTEXTO_PUBLICO, ParametrosConstants.MAPEO_BIENVENIDO));
			}
				
			afore = obtenerAforeUrl(request, contextoAfore);
			
			logger.error("Afore: {}",afore);
			if(!utileriaValidador.validarObjetoNulo(user)) {
				model = paginaRedireccion(request, model, user, true);
				afore = user.getAforeUsuario();
			}
			model.addObject("ipEjemplo", obtenerDireccionIpCliente(request));
		} catch(Exception e) {
			logger.error("Error al obtener el cookie.", e);
		}
		request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, afore);
		request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);

		return model;
	}
	
	/**
	 * Metodo 
	 * @return
	 */
	private String obtenerAforeUrl(HttpServletRequest request, String contextoAfore) {
		String afore = null;
		
		logger.error("Contexto Afore (obtenerAforeUrl): {}", contextoAfore);
		
		if(!utileriaValidador.validarVacio(contextoAfore)) {	
			List<Parametro> lparametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_REDIRECCION, null);
			boolean isEncontrado = false;
			int i = NumerosConstants.INT_CERO;
			do {
				Parametro param = lparametro.get(i);
				if(param.getChValorParametro().contains(contextoAfore)) {
					afore = param.getChParametro();
					List<Combo> listaGenerica = obtenerComboSucursales(param.getChParametro());
					request.getSession().setAttribute("listaSucursales", listaGenerica);
					isEncontrado = true;
				}
				i++;
			} while(i < lparametro.size() && !isEncontrado);
		}
		return afore;
	}
	
	/**
	 * Metodo encargado de validar una cookie
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private String validarCookie(HttpServletRequest request, HttpServletResponse response) {
		String contextoAfore = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ParametrosConstants.COOKIE_SARU.equals(cookie.getName())) {
					contextoAfore = cookie.getValue();
					response.setContentType("text/html");
					Cookie cookR = new Cookie(cookie.getName(), "");
					cookR.setMaxAge(NumerosConstants.INT_CERO);
					cookR.setPath(getPaginaPrincipal());
					response.addCookie(cookR);
				}
			}
		}
		return contextoAfore;
	}
	
	/**
	 * Vista principal de Bienvenida
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = {"/**/logout.do"}, method = RequestMethod.GET)
	public ModelAndView ejecutarLogoutPulssar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.LOGOUT.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String valorContexto = servicioCatalogo.obtenerRedireccionAfore(user.getAforeUsuario());
		
		if(user != null) {
        	SessionUsuario sesionUsuario = usuarioService.obtenerUsuarioSesion(user.getUsuario());
        	String id = request.getSession().getId();
        	if(sesionUsuario != null && sesionUsuario.getIdentificadorSession().equals(id)) {
        		usuarioService.guardarCierreSesion(sesionUsuario);
        	}        	
        }
		if(!utileriaValidador.validarObjetoNulo(user) && PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, PdfConstants.COPPEL);
			model = new ModelAndView(NavegacionEnum.LOGOUT_COPPEL.getNavegacion());
			RespuestaServicio respuesta = new RespuestaServicio();
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			if(!StringUtils.isNumeric(user.getUsuario())) {
				respuesta.setFlujo(NumerosConstants.INT_DOS);
				respuesta.setMensaje(valorContexto);
			} else {
				EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
				if(objetoCoppel != null) {
					Map<String, String> mapa = (Map<String, String>) request.getSession().getAttribute(ParametrosConstants.REDIRECCION_COPPEL_PORTAL);
					model.addObject("bFinaliza", "1");
					model.addAllObjects(mapa);
					request.getSession().removeAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
					request.getSession().removeAttribute(ParametrosConstants.REDIRECCION_COPPEL_PORTAL);
				}
			}
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		} else {
			Cookie galleta = new Cookie(ParametrosConstants.COOKIE_SARU, valorContexto);
			galleta.setPath(getPaginaPrincipal());
			galleta.setMaxAge(1);
			
			response.addCookie(galleta);
			
			this.validarCookieTimeOut(response, request);
		}
		return model;
	}
	
	/**
     * Vista principal de Bienvenida
     * @author DBARBOSA
     * @return
     */
    @RequestMapping(value = { "/**/logoutBOB.do" }, method = RequestMethod.GET)
    public void ejecutarLogoutBOB(HttpServletRequest request, HttpServletResponse response) {
        UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
        if (user != null) {
            SessionUsuario sesionUsuario = usuarioService.obtenerUsuarioSesion(user.getUsuario());
            String id = request.getSession().getId();
            if (sesionUsuario != null && sesionUsuario.getIdentificadorSession().equals(id)) {
                usuarioService.guardarCierreSesion(sesionUsuario);
            }
        }
        this.validarCookieTimeOut(response, request);
        String redireccion = new StringBuilder(urlComparador).append("A552/private/logout.do").toString();
        logger.info("Despues del logout se redirige a {}", redireccion);
        try {
            response.sendRedirect(redireccion);
        } catch(IOException e) {
            logger.error("Error al realizar la redireccion a {}", redireccion, e);
        }
    }

    /**
     * Vista principal de Bienvenida
     * @author DBARBOSA
     * @return
     */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void mostrarBienvenidaLogin(HttpServletResponse response, HttpServletRequest request) {
		try {
			String afore = this.validarCookieTimeOut(response, request);
			if(!utileriaValidador.validarVacio(afore)) {
				String valorContexto = servicioCatalogo.obtenerRedireccionAfore(afore);
				Cookie galleta = new Cookie(ParametrosConstants.COOKIE_SARU, valorContexto);
				galleta.setPath(getPaginaPrincipal());
				galleta.setMaxAge(1);
				
				response.addCookie(galleta);
			}
			response.sendRedirect(this.getPaginaPrincipal());
		} catch (IOException e) {
			logger.error("Exception en executeUsuario >>", e);
		}
	}
	
	/**
	 * Validar la cookie del time out
	 * @param response
	 */
	private String validarCookieTimeOut(HttpServletResponse response, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String valorAforeTO = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ParametrosConstants.COOKIE_TO.equals(cookie.getName())) {
					valorAforeTO = utileriaEncripta.obtieneDesencriptacion(cookie.getValue(), keySeguridadEncriptacion);
					response.setContentType("text/html");
					Cookie cook = new Cookie(cookie.getName(), "");
					cook.setMaxAge(NumerosConstants.INT_CERO);
					cook.setPath(utileriaCadena.obtenerCadenaConcatenada(true, ParametrosConstants.DIAGONAL, ParametrosConstants.CONTEXTO_PULSSAR));
					response.addCookie(cook);
				}
			}
		}
		return valorAforeTO;
	}
	
	/**
	 * Metodo encargado de las validaciones del login de usuarios
	 * 
	 * @param usuario
	 * @param request
	 * @return
	 *  
	 */
	@RequestMapping(value = { "/public/usuarioAdmin.do/{user}" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio ejecutarUsuario(@PathVariable String user, @RequestParam(required= false) String claveSucursal,
			HttpServletRequest request, HttpServletResponse response){
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			String contextoAfore = "";
			String[] urlValida = request.getRequestURI().split("/");
			if(NumerosConstants.INT_SEIS == urlValida.length) {
				contextoAfore = urlValida[NumerosConstants.INT_DOS];
			}
			
			respuesta = servicioAdmin.validarUsuarioLogin(user, contextoAfore);
			if(respuesta.getFlujo() == NumerosConstants.INT_CINCO) {
				respuesta.setMensaje("recupera.do");
			} else if(respuesta.getFlujo() == NumerosConstants.INT_CERO) {
				obtenerDatosUsuario(user, claveSucursal, request, respuesta);
			}
			
			if(!utileriaValidador.validarVacio(contextoAfore)) {
				Cookie galleta = new Cookie(ParametrosConstants.COOKIE_SARU, utileriaCadena.obtenerCadenaConcatenada(true, contextoAfore, ParametrosConstants.DIAGONAL));
				galleta.setPath(getPaginaPrincipal());
				galleta.setMaxAge(1);
				
				response.addCookie(galleta);
			}
		} catch(Exception e) {
			logger.error("Exception en executeUsuario >>", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
		}
			
		return respuesta;
	}
	
	/**
	 * Metodo para generar bloqueo de usaurio
	 * @param user
	 * @param reques
	 */
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = { "/**/imagenAfore.do" }, method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio obtenerImagenAfore(HttpServletRequest request) {
		RespuestaServicio servicio = new RespuestaServicio();
		try {
			String afore = (String) request.getSession().getAttribute(ParametrosConstants.USUARIO_ORGANIZACION);
			String ruta;
			if(utileriaValidador.validarVacio(afore)) {
				ruta = utileriaCadena.obtenerCadenaConcatenada(true, rutaImagenes, AgenteConstants.LOGO_ACCESAR, ExpresionesConstants.PUNTO_DOMINIO, ExpresionesConstants.VALOR_PNG);
			} else {
				ruta = utileriaCadena.obtenerCadenaConcatenada(true, rutaImagenes, afore, ExpresionesConstants.VALOR_JPG);
			}
			File imagenAfore = new File(ruta);
			byte[] archivoArreglo = new byte[(int) imagenAfore.length()];
			
			InputStream imagenStream = new FileInputStream(imagenAfore);
			ByteArrayOutputStream arregloBytes = new ByteArrayOutputStream();
			
			int tamanio;
			while ((tamanio = imagenStream.read(archivoArreglo)) != -1) {
				arregloBytes.write(archivoArreglo, 0, tamanio);
			}
			servicio.setDatos(Base64Utils.encodeToString(arregloBytes.toByteArray()));
			imagenStream.close();
		} catch(Exception e) {
			logger.error("Exception error al mapear la imagen de la afore", e);
		}
		return servicio;
	}

	/**
	 * Metodo que valida daros del usuario
	 * 
	 * @param usuario
	 * @param request
	 * @return
	 *  
	 */
	private void obtenerDatosUsuario(String user, String claveSucursal, HttpServletRequest request,	RespuestaServicio respuesta) {
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		if(!utileriaValidador.validarObjetoNulo(usuarioLogin)) {
			String redireccion;
			List<MenuPagina> pagPortal = servicioAdmin.redireccionarPagina(usuarioLogin.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), usuarioLogin.getAforeUsuario());
			
			if(pagPortal.isEmpty()){
				redireccion = ParametrosConstants.LOGOUT;
			}else{
				request.getSession().setAttribute("menuUsuario", pagPortal);
				request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, usuarioLogin.getAforeUsuario());
				
				redireccion = pagPortal.get(NumerosConstants.INT_CERO).getChRutaMenu();
				request.getSession().setAttribute("tituloMenu", StringEscapeUtils.escapeHtml(pagPortal.get(NumerosConstants.INT_CERO).getChDescMenuPagina()));
			}
			if(usuarioLogin.getEstatus().equals(EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario())){
				redireccion = "/pulssar/validate/modificarPassword.do";
			}
			request.getSession().setAttribute(ParametrosConstants.ADMIN_PANTALLA, user);
			request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
			respuesta.setMensaje(redireccion);
		}
		if (!utileriaValidador.validarVacio(claveSucursal)){
			Usuario usuario = new Usuario();
			usuario.setUsername(user);
			usuario.setClaveSucursal(claveSucursal);
			request.getSession().setAttribute(ParametrosConstants.SESSION_USUARIO_LOGIN, usuario);
		}

	}
	
	/**
	 * Metodo para generar bloqueo de usaurio
	 * @param user
	 * @param reques
	 */
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = { "/public/bloqueoUsuario.do" }, method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio ejecutarBloqueoUsuario(@RequestParam("salida") String salidaSpring, HttpServletRequest request, HttpServletResponse response) {		
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			 respuesta = servicioAdmin.buscarBloqueoUsuario(salidaSpring);
		} catch(Exception e) {
			logger.error("Exception en bloqueo usuario", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
		}
		return respuesta;
	}
	
	/**
	 * Vista de registro de bienvenida
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/public/recupera.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView olvidarPasword() {
		return new ModelAndView(NavegacionEnum.OLVIDA_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_OLVIDA, new DatosRegistro());
	}
	
	/**
	 * Vista del Aviso de privacidad
	 * @author JOSORIO
	 * 
	 * @return
	 */
	@RequestMapping(value = "/public/avisoPrivacidadGral.do", method = {RequestMethod.GET})
	public ModelAndView ConsultarAvisoPrivacidadGral() {
		return new ModelAndView(NavegacionEnum.AVISO_PRIVACIDAD_GRAL.getNavegacion());
	}
	
	/**
	 * Vista de registro de bienvenida
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/public/recuperaPassword.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recuperarPasswordPassword(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario) {
		ModelAndView model = new ModelAndView(NavegacionEnum.OLVIDA_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_OLVIDA, datosUsuario);
		
		RespuestaServicio respuestaRecupera = servicioAdmin.recuperarContrasenia(datosUsuario);
		if(respuestaRecupera.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
			model = new ModelAndView(NavegacionEnum.OLVIDA_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_OLVIDA, new DatosRegistro());
		}
		model = utileriaConversion.agregarRespuestaModel(model, respuestaRecupera);
		return model;
	}
	
	/**
	 * Vista de registro de bienvenida
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/public/registrate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registrarBienvenido(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.REGISTRAR_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REGISTRAR, new DatosRegistro());
		RespuestaServicio respuestaRegistrate = new RespuestaServicio();
		String afore = null;
		List<Combo> lAfores = null;
		List<Combo> lZonas = null;
		List<Combo> lSucursales = null;
		try {
			lAfores = utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ActivacionConstants.CLAVE_PROCESAR, ActivacionConstants.CLAVE_SICI));
			respuestaRegistrate.setFlujo(NumerosConstants.INT_TRES);
			
			afore = this.obtenerAforeUrl(request);
			if(!utileriaValidador.validarVacio(afore)) {
				DatosRegistro datos = new DatosRegistro();
				datos.setClaveAfore(afore);
				model = new ModelAndView(NavegacionEnum.REGISTRAR_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REGISTRAR, datos);
				lZonas = serviciosIntCatalogo.obtenerZonasOficina(afore, null, NumerosConstants.INT_CERO);
				lSucursales = obtenerComboSucursales(afore);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema en la carga de afores", e);
			lAfores = new ArrayList<>();
			respuestaRegistrate = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
		}
		request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, afore);
		request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
		model = utileriaConversion.agregarComboAModel(model, "afores", lAfores, afore);
		model = utileriaConversion.agregarComboAModel(model, "zonas", lZonas, null);
		model = utileriaConversion.agregarComboAModel(model, "lsucursal", lSucursales, null);
		model = utileriaConversion.agregarRespuestaModel(model, respuestaRegistrate);
		return model;
	}
	
	/**
	 * Pagina de registro de usuario
	 * 
	 * @param datosUsuario
	 * @return
	 */
	@RequestMapping(value = "/public/registro.do", method = RequestMethod.POST)
	public ModelAndView registrarAgente(@ModelAttribute DatosRegistro datosUsuario, HttpServletRequest request) {
		ModelAndView modelAgente = new ModelAndView(NavegacionEnum.REGISTRAR_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REGISTRAR, datosUsuario);
		RespuestaServicio respuestaRegistro = new RespuestaServicio();
		List<Combo> lAfores = null;
		List<Combo> lZonas = null;
		List<Combo> lSucursales = null;
		List<Combo> lDescZonas = null;
		List<Combo> lOficina = null;
		String afore = null;
		try {
			lAfores = utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ActivacionConstants.CLAVE_PROCESAR, ActivacionConstants.CLAVE_SICI));
			afore = this.obtenerAforeUrl(request);
			if(utileriaValidador.validarVacio(afore)) {
				afore = datosUsuario.getClaveAfore();
			}
			
			if(!utileriaValidador.validarVacio(afore)) {
				lSucursales = obtenerComboSucursales(afore);
				lZonas = serviciosIntCatalogo.obtenerZonasOficina(afore, null, NumerosConstants.INT_CERO);
				if(!utileriaValidador.validarListaVacia(lZonas)) {
					lDescZonas = serviciosIntCatalogo.obtenerZonasOficina(afore, datosUsuario.getClaveZona(), NumerosConstants.INT_UNO);
					lOficina = serviciosIntCatalogo.obtenerZonasOficina(afore, datosUsuario.getNombreZona(), NumerosConstants.INT_DOS);
				}
			}
			
			UsuarioLogin user = new UsuarioLogin();
			user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
			user.setUsuario(RegistroUsuarioConstants.USUARIO_ALTA);
			logger.info("{}", datosUsuario.toString());
			
			servicioAlta.validarAdministradorAfore(datosUsuario);
			respuestaRegistro = servicioRegistro.registrarAltaUsuario(datosUsuario, user, MensajesExitoEnum.USUARIO_REGISTRADO_CORRECTAMENTE.getClave(), 
					EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario(), false, false);
			
			DatosRegistro registro = new DatosRegistro();
			if(!utileriaValidador.validarVacio(afore)) {
				registro.setClaveAfore(afore);
			}
			if(respuestaRegistro.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
				modelAgente = new ModelAndView(NavegacionEnum.REGISTRAR_USUARIO.getNavegacion(), ParametrosConstants.FORMULARIO_REGISTRAR, registro);
			}
		} catch (BusinessException be) {
			logger.error("Se presento un error de negocio", be);
			respuestaRegistro = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS, null);
		} catch (Exception e) {
			logger.error("Se presento un problema al registrar el agente", e);
			respuestaRegistro.setFlujo(NumerosConstants.INT_DOS);
			respuestaRegistro.setTitulo(TextoConstants.TITULO_EXCEPTION);
			respuestaRegistro.setMensaje(TextoConstants.MENSAJE_EXCEPTION);
		}
		modelAgente = utileriaConversion.agregarComboAModel(modelAgente, "afores", lAfores, afore);
		modelAgente = utileriaConversion.agregarComboAModel(modelAgente, "zonas", lZonas, null);
		modelAgente = utileriaConversion.agregarComboAModel(modelAgente, "lsucursal", lSucursales, null);
		modelAgente = utileriaConversion.agregarComboAModel(modelAgente, "ldesczona", lDescZonas, null);
		modelAgente = utileriaConversion.agregarComboAModel(modelAgente, "loficinas", lOficina, null);
		modelAgente = utileriaConversion.agregarRespuestaModel(modelAgente, respuestaRegistro);
		
		return modelAgente;
	}
	
	/**
	 * Metodo encargado de reenviar correo de recuperacion password
	 * @param request
	 * @param datosUsuario
	 * @return
	 */
	@RequestMapping(value = "/public/reenvioCorreo.do", method = RequestMethod.POST)
	public ModelAndView reenviarCorreoPassword(HttpServletRequest request, @ModelAttribute DatosRegistro datosUsuario){
		ModelAndView model = new ModelAndView(NavegacionEnum.OLVIDA_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_OLVIDA,new DatosRegistro());
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try{
			logger.info("Inicia proceso para reenvio de correo {} ", datosUsuario.getNickUsuario());
			respuestaServicio = servicioAdmin.reenviarCorreoPassword(datosUsuario.getNickUsuario());
			if(respuestaServicio.getFlujo().intValue() == NumerosConstants.INT_UNO.intValue()) {
				model = new ModelAndView(NavegacionEnum.OLVIDA_PASSWORD.getNavegacion(), ParametrosConstants.FORMULARIO_OLVIDA, new DatosRegistro());
			}
		}catch(BusinessException be) {
			logger.error("Se presento un error de negocio", be);
			respuestaServicio = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS, null);
		}catch(Exception e){
			logger.error("Se presento un problema en el reenvio del correo ", e);
			respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);

		}
		model = utileriaConversion.agregarRespuestaModel(model, respuestaServicio);

		return model;
	}
	
	/**
	 * Vista principal de Bienvenida
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/validate/validaUsuario.do", method = {RequestMethod.GET, RequestMethod.POST})
	public void mostrarValidacionUsuario(HttpServletRequest request, HttpServletResponse response) {
		String redireccion = ParametrosConstants.LOGOUT;
		try {
			UsuarioLogin user = servicioAdmin.obtenerRolUsuario(request.getRemoteUser());
			if(!utileriaValidador.validarObjetoNulo(user)) {
				Usuario usuario = (Usuario) request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_LOGIN);	
				if(!utileriaValidador.validarObjetoNulo(usuario) && user.getUsuario().equalsIgnoreCase(usuario.getUsername())){
						user.setSucursal(usuario.getClaveSucursal());
						request.getSession().removeAttribute(ParametrosConstants.SESSION_USUARIO_LOGIN);
				}
				redireccion = validarUsuarioLogin(request.getRemoteUser(), request.getSession().getId());
				if(utileriaValidador.validarVacio(redireccion)) {
					RolesModuloAccesoIP rolModulo = servicioCatalogoUsuario.obtenerRolModuloAccesoModificacion(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
					boolean continuar = true;
					if(!utileriaValidador.isEmpty(rolModulo)) {
						List<MenuPagina> pagportal = servicioAdmin.redireccionarPagina(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
						if(pagportal.isEmpty()) {
							redireccion = ParametrosConstants.LOGOUT;
							continuar = false;
						} else {
							String[] rutas = pagportal.get(NumerosConstants.INT_CERO).getChRutaMenu().split(ExpresionesConstants.DIAGONAL);
							String plataforma = ServiciosUsuariosConstants.MAP_PAGINAS.get(rutas[rutas.length - 1]);
							if(!utileriaValidador.isEmpty(plataforma) && plataforma.equals(String.valueOf(rolModulo.getIdPlataforma()))) {
								continuar = servicioCatalogo.validarIPAccesoSICI(this.obtenerDireccionIpCliente(request), user.getAforeUsuario());
								redireccion = ParametrosConstants.LOGOUT;
							}
						}
					}
					if(continuar) {
						List<MenuPagina> pagPortal = servicioAdmin.redireccionarPagina(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
						List<MenuPagina> menuUsuario = servicioAdmin.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
						
						logger.error("Menu Usuario: {}", menuUsuario);
						
						request.getSession().setAttribute("menuUsuario", menuUsuario);
						request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, user.getAforeUsuario());
						request.getSession().setAttribute(ParametrosConstants.BANDERA_MENU, servicioAdmin.menuReimpresion(user.getAforeUsuario()));
						request.getSession().setAttribute(ParametrosConstants.BANDERA_COOPEL_EXPEDIENTE_MOVIL,servicioAdmin.menuExpedienteUnicoCoopel(user.getAforeUsuario(),user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol()));
						this.cookieSesion(response, user.getAforeUsuario());
						
						redireccion = pagPortal.get(NumerosConstants.INT_CERO).getChRutaMenu();
						request.getSession().setAttribute("tituloMenu", StringEscapeUtils.escapeHtml(pagPortal.get(NumerosConstants.INT_CERO).getChDescMenuPagina()));

						if(user.getEstatus().equals(EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario())){
							redireccion = "/pulssar/validate/modificarPassword.do";
						}
					}
				}
				request.getSession().setAttribute(ParametrosConstants.ADMIN_PANTALLA, user);
			}
			request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
			response.sendRedirect(redireccion);
		} catch (IOException e) {
			logger.error("IOException", e);
		}  catch (Exception e) {
			logger.error("Exception", e);
		}
	}
	
	/**
	 * Usuario Logueado con exito
	 * @param usuario
	 */
	private String validarUsuarioLogin(String usuario, String idSession) {
		String redireccion = null;
//		int flujo = usuarioService.validarSesionActivaUsuario(usuario);
//		if(flujo == ActivacionConstants.TRES) {
//			redireccion = ParametrosConstants.LOGOUT;
//		} else {
//			usuarioService.guardarInformacionSesion(flujo, usuario, idSession);
//		}
		return redireccion;
	}
	
	/**
	 * Metodo encargado de obtener la Direccion IP del cliente
	 * @param request
	 * @return
	 */
	private String obtenerDireccionIpCliente(HttpServletRequest request) {
		String xForwardedForHeader = request.getHeader(ParametrosConstants.X_FORWARDED_FOR);
		if (xForwardedForHeader == null) {
			xForwardedForHeader = request.getRemoteAddr();
		} else {
			xForwardedForHeader = new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
		}
		logger.info("IP del cliente: {}", xForwardedForHeader);
		return xForwardedForHeader;
	}
	
	/**
	 * Cookie para el almacen de la url de sesion
	 * @param response
	 */
	protected void cookieSesion(HttpServletResponse response, String url) {
		String cadenaEncriptada = utileriaEncripta.obtieneEncriptacion(url, keySeguridadEncriptacion);
		Cookie cook = new Cookie(ParametrosConstants.COOKIE_TO, cadenaEncriptada);
		cook.setPath(utileriaCadena.obtenerCadenaConcatenada(true, ParametrosConstants.DIAGONAL, ParametrosConstants.CONTEXTO_PULSSAR));
		cook.setMaxAge(60 * 60 * 24);
		
		response.addCookie(cook);
	}
	


	/**
	 * Metodo que valida la redireccion de la pagina
	 * 
	 * @param request
	 * @param model
	 * @param user
	 * @param redirect
	 * @return
	 */
	private ModelAndView paginaRedireccion(HttpServletRequest request, ModelAndView model, UsuarioLogin user, Boolean redirect) {
		ModelAndView modelRedireccion = model;
		List<MenuPagina> pagPortal = servicioAdmin.redireccionarPagina(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
		if(!pagPortal.isEmpty()){
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, user.getAforeUsuario());
			
			String redireccion = pagPortal.get(NumerosConstants.INT_CERO).getChRutaMenu();
			if (redirect){
				String pRedireccion = pagPortal.get(NumerosConstants.INT_CERO).getChRutaMenu();
				pRedireccion = pRedireccion.replace(ParametrosConstants.CONTEXTO_PULSSAR, ExpresionesConstants.VACIO);
				redireccion = utileriaCadena.obtenerCadenaConcatenada(true, "redirect:", pRedireccion);
			}	
			
			modelRedireccion = new ModelAndView(redireccion);
		}
		return modelRedireccion;
	}
	
	/**
	 * Realiza la carga del combo Sucursales por clave afore
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/public/cargaSucursales.do", method= RequestMethod.GET)
	@ResponseBody List<Combo> cargaSucursales(String claveAfore){
		logger.info("BienvenidoController. Obtiene las sucursales por clave afore: {}", claveAfore);
		return obtenerComboSucursales(claveAfore);
	}
	
	/**
	 * Realiza la carga del combo Sucursales por clave afore
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/public/cargaZonas.do", method= RequestMethod.GET)
	@ResponseBody List<Combo> cargaZonas(String claveAfore){
		logger.info("BienvenidoController. Obtiene las zonas por clave afore: {}", claveAfore);
		return serviciosIntCatalogo.obtenerZonasOficina(claveAfore, null, NumerosConstants.INT_CERO);
	}
	
	/**
	 * Realiza la carga del combo Sucursales por clave afore
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/public/cargaDescZona.do" , method= RequestMethod.GET)
	@ResponseBody List<Combo> cargarDescZonas(String claveAfore, String zona){
		logger.info("BienvenidoController. Obtiene la descripcion de zonas por clave afore: {} y zona {}", claveAfore, zona);
		return serviciosIntCatalogo.obtenerZonasOficina(claveAfore, zona, NumerosConstants.INT_UNO);
	}
	
	/**
	 * Realiza la carga del combo Sucursales por clave afore
	 * @author mahernan
	 * @param claveAfore
	 * @return
	 */
	@RequestMapping(value = "/public/cargaOficina.do", method= RequestMethod.GET)
	@ResponseBody List<Combo> cargarOficinas(String claveAfore, String zona){
		logger.info("BienvenidoController. Obtiene las oficinas por clave afore: {} y zona {}", claveAfore, zona);
		return serviciosIntCatalogo.obtenerZonasOficina(claveAfore, zona, NumerosConstants.INT_DOS);
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
	 * Obtiene la url de la pagina principal
	 * @return
	 */
	private String getPaginaPrincipal() {
		return utileriaCadena.obtenerCadenaConcatenada(true, ParametrosConstants.DIAGONAL, ParametrosConstants.CONTEXTO_PULSSAR, ParametrosConstants.CONTEXTO_PUBLICO, ParametrosConstants.MAPEO_BIENVENIDO);
	}
	
	/**
	 * MEtodo encargado de obtenr la Afore de la url
	 * 
	 * @param request
	 * @return
	 */
	private String obtenerAforeUrl(HttpServletRequest request) {
		String afore = null;
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
		return afore;
	}
} 