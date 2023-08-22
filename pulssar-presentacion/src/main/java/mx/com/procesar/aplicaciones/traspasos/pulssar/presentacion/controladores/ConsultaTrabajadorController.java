package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.TextoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarIcefaTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionAutenticacionIneService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResultadoNotificacionAutenticacionIneService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SaldosPreliminaresService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NipConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AutenticacionIne;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosHuellas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIcefaTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador para el manejo de peticiones de la consulta de trabajadors
 * 
 * @version 1.0
 * @since
 */
@Controller
public class ConsultaTrabajadorController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaTrabajadorController.class);
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private ConsultarPersonaCertificablesService servicioConsulta;
	
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
	 * Variable para ruta de archivo de aviso de privacidad 
	 */
	@Value("${ruta.pdf.aviso.privacidad}")
	private String rutaAvisoPrivacidad;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private ConsultaSelloService servicioSello;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdmin;
	
	/**
	 * Inyeccion de servicio consultarIcefaTrabajadorService
	 */
	@Autowired
	private ConsultarIcefaTrabajadorService consultarIcefaTrabajadorService;
	
	/**
	 * Inyeccion de servicio consultarIcefaTrabajadorService
	 */
	@Autowired
	private CeroPapelService ceroPapelService;

	/**
	 * Inyeccion de folio 
	 */
	@Autowired
	private FolioService folioService;
	
	/**
	 * Servicio de consulta autenticacion ine
	 */
	@Autowired
	private ResultadoNotificacionAutenticacionIneService servicioResultadoAutenticacion;
	
	/**
	 * Servicio de consulta autenticacion ine
	 */
	@Autowired
	private NotificacionAutenticacionIneService servicioNotificacionAutenticacionIne;
	
	/**
	 * Servicio de consulta autenticacion ine
	 */
	@Autowired
	private SaldosPreliminaresService servicioSaldos;
	
	/**
	 * Cancelar estatus
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/catalogoMensajes.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio consultarCatalogoMensajes(HttpServletRequest request, @RequestParam("codigo") String codigo) {
		logger.info("Consulta de Mensajes");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta = servicioCatalogo.obtenerRespuesta(null, codigo, user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Vista menu agente
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/amenu.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mostrarMenuAgente(HttpServletRequest request) {
		logger.info("Menu de Agente");
		ModelAndView model = new ModelAndView(NavegacionEnum.MENU_AGENTE.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		List<MenuPagina> menuUsuario = servicioAdmin.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
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
		//			respuesta = new RespuestaServicio();
		//			respuesta.setFlujo(NumerosConstants.INT_DOS);
		//			respuesta.setMensaje("Prueba Error de Validación");
		//			respuesta.setTitulo("Validaciones en la generación de NIP");
		
		// malopezt: RFC: WB00288 
		// 2022/02/10
		// Al mostrar la vista amenu: Lanzar la respuesta (modal) encaso de ser diferente de Nulo
		RespuestaServicio respuesta = (RespuestaServicio)request.getAttribute("respuesta");
		if (respuesta != null) {
			
			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		}
		return model;
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
	
	/**
	 * Vista menu agente
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/operativoProcesar/menu.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mostrarMenu(HttpServletRequest request) {
		logger.info("Menu");
		ModelAndView model = new ModelAndView(NavegacionEnum.MENU_AGENTE.getNavegacion());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		List<MenuPagina> menuUsuario = servicioAdmin.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario());
		request.getSession().setAttribute("menuUsuario", menuUsuario);
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		return model;
	}
	
	/**
	 * Vista consutla trabajador
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultaTrabajador.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mostrarDatosConsulta(HttpServletRequest request) {
		logger.info("Inicio consulta trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		RespuestaServicio respuesta = new RespuestaServicio();
		Integer configuracionAviso = ActivacionConstants.AVISO_PRIVACIDAD_INACTIVO;
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			eliminarDatosSesion(request);
			Object objetoCoppel = request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL);
			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_CINCO);
			List<Parametro> listaAutenticacionIne = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_AUTENTICACION_INE, ExpresionesConstants.ESPACIO);
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_SOLICITANTE, ParametrosConstants.TIPOS_SOLICITANTE);
			List<Parametro> parametro = servicioCatalogo.obtenerParametro(ParametrosConstants.PARAMETRO_AFORES_VALIDAR_HUELLA, null);
			List<Parametro> rolesConsulta = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.ROL_CONSULTA_TRABAJADOR, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol());
			
			String tiposSolicitante = utileriaValidador.obtenerValorParametro(listaParametro, ParametrosConstants.TIPOS_SOLICITANTE, ServiciosConstants.CADENA_TIPOS_SOLICITANTES);
			String valor = utileriaValidador.obtenerValorParametro(parametro, null, ParametrosConstants.VALOR_VALIDAR_HUELLAS);
			String rolConsulta = utileriaValidador.obtenerValorParametro(rolesConsulta, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), NumerosConstants.C_CERO);
			String autenticacionINE = utileriaValidador.obtenerValorParametro(listaAutenticacionIne, ExpresionesConstants.ESPACIO, ExpresionesConstants.VACIO);
			
			List<Combo> comboSolicitante = utileriaConversion.obtenerComboTipoSolicitante(servicioCatalogo.obtenerTipoSolicitante(tiposSolicitante));
			
			// AVISO DE PRIVACIDAD
			List<Parametro> confAvisoPrivacidad = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_AVISO_PRIVACIDAD);
			String nombreArchivo = utileriaValidador.obtenerValorParametro(confAvisoPrivacidad, user.getAforeUsuario(), null);
			if( null != nombreArchivo ) {
				configuracionAviso = ActivacionConstants.AVISO_PRIVACIDAD_ACTIVO;
				request.getSession().setAttribute(ParametrosConstants.URL_AVISO_PRIVACIDAD,AgenteConstants.URL_ACCESAR_AVISO_PRIVACIDAD);
				request.getSession().setAttribute(ParametrosConstants.NOMBRE_ARCHIVO_AVISO_PRIVACIDAD, nombreArchivo);
			}
			request.getSession().setAttribute(ParametrosConstants.CONFIG_AVISO_PRIVACIDAD, configuracionAviso);
			//USUARIO COPPEL
			if(!utileriaValidador.validarObjetoNulo(objetoCoppel)) {
				respuesta.setFlujo(NumerosConstants.INT_SIETE);
				EntradaConsulta entrada = (EntradaConsulta) objetoCoppel;
				model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, entrada);
			}
			request.getSession().removeAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean consultaAgente = false;
			//ROL PERMITO DE CONSULTA
			if(NumerosConstants.C_UNO.equals(rolConsulta)) {
				consultaAgente = true;
			}
			request.getSession().setAttribute("consultaAgente", consultaAgente);
			model.addObject(ParametrosConstants.COMBO_SOLICITANTE, comboSolicitante);
			model.addObject(ParametrosConstants.DATO_AUTENTICACION_INE, autenticacionINE);
			
			user = this.validarHuellasEmpleados(user.getCurpAgente(), user.getAforeUsuario(), user, request);
			//AFORE QUE VALIDA SELLO DEL EMPLEADO
			if(!consultaAgente && !utileriaValidador.validarObjetoNulo(valor) && valor.contains(user.getAforeUsuario())) {
				validarObligatoriedadSello(model, user.getAforeUsuario());
				servicioSello.obtenerSelloEmpleado(user.getCurpAgente(), user.getAforeUsuario());
			}
		} catch (BusinessException be) {
			logger.error("consultaTrabajador: Se presento un problema al mostrar los campos de consulta el trabajador", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.MENSAJE_HUELLA_EMPLEADO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista consutla trabajador
	 * @author jogonzal
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultaTrabajadorConsar.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mostrarDatosConsultaConsar(HttpServletRequest request) {
		logger.error("Inicio consulta trabajador Consar (consultaTrabajadorConsar)");
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL_CONSAR.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		RespuestaServicio respuesta = new RespuestaServicio();
		Integer configuracionAviso = ActivacionConstants.AVISO_PRIVACIDAD_INACTIVO;
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta.setFlujo(NumerosConstants.INT_CINCO);
			List<Parametro> rolesConsulta = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.ROL_CONSULTA_TRABAJADOR, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol());

			String rolConsulta = utileriaValidador.obtenerValorParametro(rolesConsulta, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), NumerosConstants.C_CERO);
			
			// AVISO DE PRIVACIDAD
			List<Parametro> confAvisoPrivacidad = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_AVISO_PRIVACIDAD);
			String nombreArchivo = utileriaValidador.obtenerValorParametro(confAvisoPrivacidad, user.getAforeUsuario(), null);
			if( null != nombreArchivo ) {
				configuracionAviso = ActivacionConstants.AVISO_PRIVACIDAD_ACTIVO;
				request.getSession().setAttribute(ParametrosConstants.URL_AVISO_PRIVACIDAD,AgenteConstants.URL_ACCESAR_AVISO_PRIVACIDAD);
				request.getSession().setAttribute(ParametrosConstants.NOMBRE_ARCHIVO_AVISO_PRIVACIDAD, nombreArchivo);
			}
			request.getSession().setAttribute(ParametrosConstants.CONFIG_AVISO_PRIVACIDAD, configuracionAviso);
			request.getSession().removeAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean consultaAgente = true;
			//ROL PERMITO DE CONSULTA
			if(NumerosConstants.C_UNO.equals(rolConsulta)) {
				consultaAgente = true;
			}
			request.getSession().setAttribute("consultaAgente", consultaAgente);
			
			user = this.validarHuellasEmpleados(user.getCurpAgente(), user.getAforeUsuario(), user, request);
		} catch (BusinessException be) {
			logger.error("consultaTrabajador: Se presento un problema al mostrar los campos de consulta el trabajador: {}", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.MENSAJE_HUELLA_EMPLEADO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		logger.error("Model (consultaTrabajadorConsar.do): {}", model);
		return model;
	}
	
	/**
	 * Metodo encargado de validar las huellas de empleado
	 * 
	 * @param curpAgente
	 * @param cvAfore
	 */
	private UsuarioLogin validarHuellasEmpleados(String curpAgente, String cvAfore, UsuarioLogin usuarioLogin, HttpServletRequest request) {
		logger.info("Curp del empleado: {}", curpAgente);
		String dedoEmpleado = NumerosConstants.C_DOS;
		String motivoExcepcion = "";
		String codigoFaltaDedo = "";
		if(!utileriaValidador.validarVacio(curpAgente)) {
			DatosExpediente expEmpleado = servicioConsulta.validarExpediente(curpAgente, cvAfore, null, null, curpAgente);
			logger.info("Expediente empleado: {}", expEmpleado);
			if(!utileriaValidador.validarObjetoNulo(expEmpleado) && !utileriaValidador.validarListaVacia(expEmpleado.getHuellasTrabajador())) {
				List<DatosHuellas> huellasEmpleado = expEmpleado.getHuellasTrabajador();
				DatosHuellas huellaEmpleado = huellasEmpleado.get(NumerosConstants.INT_UNO);
				if(!utileriaValidador.validarVacio(huellaEmpleado.getMotivo())) {
					if(utileriaValidador.validarListaVacia(expEmpleado.getDedosCalidad())) {
						motivoExcepcion = huellaEmpleado.getMotivo();
						codigoFaltaDedo = huellaEmpleado.getCodigoFaltaDedo();
					} else {
						dedoEmpleado = expEmpleado.getDedosCalidad().get(NumerosConstants.INT_CERO);
					}
				}
			}
		}
		usuarioLogin.setDedoSello(dedoEmpleado);
		usuarioLogin.setMotivoSinHuella(motivoExcepcion);
		usuarioLogin.setCodigoFaltaDedo(codigoFaltaDedo);
		request.getSession().setAttribute(ParametrosConstants.ADMIN_PANTALLA, usuarioLogin);
		
		return usuarioLogin;
	}
	
	/**
	 * Verifica si el empleado ya genero su sello y si es obligatorio la huella del empleado
	 * @param afore
	 * @return
	 */
	private RespuestaServicio validarSelloConsultaObligatorio(ModelAndView model, String afore) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			boolean validarSello = validarObligatoriedadSello(model, afore);
			if(validarSello) {
				throw new BusinessException("EL EMPLEADO NO CUENTA CON SELLO");
			}
		} catch (BusinessException be) {
			logger.error("consultaTrabajador: Se presento un problema al mostrar los campos de consulta el trabajador", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.VERIFICAR_EMPLEADO_OBLIGATORIO.getClave(), afore, NumerosConstants.INT_SEIS, null);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar si el sello es obligatorio
	 * 
	 * @param model
	 * @param afore
	 */
	private boolean validarObligatoriedadSello(ModelAndView model, String afore) {
		boolean validarSello = false;
		List<Parametro> parametroObligatorio = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.PARAMETRO_OBLIGATORIEDAD_HUELLA_EMPLEADO);
		String obligatorioSello = utileriaValidador.obtenerValorParametro(parametroObligatorio, ParametrosConstants.DESCRIPCION_PAPERLESS, ExpresionesConstants.VACIO);
		if(!utileriaValidador.validarVacio(obligatorioSello) && obligatorioSello.contains(afore)) {
			model.addObject("selloObligatorio", Boolean.TRUE);
			validarSello = true;
		}
		return validarSello;
	}
	
	/**
	 * Vista consutla trabajador
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultaPrincipal.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView consultarPreviaExpediente(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("consulta") EntradaConsulta consulta) {
		logger.info("Inicio validacion de consulta Trabajador PrevioExpediente: {}", consulta);
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		boolean banderaAforeDistinto = false;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			boolean autenticacionInePeis = false;
			//ES AUTENTICACION POR INE y EXISTE EL TRABAJADOR
			if (consulta.getAutenticacionIne() && !StringUtils.isBlank(consulta.getIdProcesar())) {
				logger.info(">>> Autenticacion por INE -- {}", consulta.getAutenticacionIne());
				consulta.setAutenticacionIne(false);
				request.getSession().setAttribute("consulta", consulta);
				//SI LA AFORE ES PEIS
				if(PdfConstants.PEIS.equals(user.getAforeUsuario())) {
					respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.MENSAJE_AUTENTICACION_INE_PEIS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_QUINIENTOSSETENTAYOCHO, null);
					List<Parametro> uriAutenticacionInePeis = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_AMBIENTE_PEIS_AUTENTICA_INE, ServiciosConstants.URI_REDIREC_PEIS);
					model.addObject("webAutenticaPeis", utileriaValidador.obtenerValorParametro(uriAutenticacionInePeis, ServiciosConstants.URI_REDIREC_PEIS, ExpresionesConstants.VACIO));
					autenticacionInePeis = true;
				} else {
					return new ModelAndView("redirect:/private/consultaPrincipalIne.do");
				}
			}
			
			List<Parametro> listaAutenticacionIne = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_AUTENTICACION_INE, ExpresionesConstants.ESPACIO);
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_SOLICITANTE, ParametrosConstants.TIPOS_SOLICITANTE);
			String tiposSolicitante = utileriaValidador.obtenerValorParametro(listaParametro, ParametrosConstants.TIPOS_SOLICITANTE, ServiciosConstants.CADENA_TIPOS_SOLICITANTES);
			List<Parametro> aforesExpedienteMovil = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_OPCION_EXPEDIENTE_MOVIL, AgenteConstants.CH_PARAMETRO_EXPEDIENTE_MOVIL);
			String autenticacionINE = utileriaValidador.obtenerValorParametro(listaAutenticacionIne, ExpresionesConstants.ESPACIO, ExpresionesConstants.VACIO);
			
			model.addObject(ParametrosConstants.COMBO_SOLICITANTE, utileriaConversion.obtenerComboTipoSolicitante(servicioCatalogo.obtenerTipoSolicitante(tiposSolicitante)));
			model.addObject(ParametrosConstants.DATO_AUTENTICACION_INE, autenticacionINE);
			//NO ES AUTENTICACION INE PEIS
			if(!autenticacionInePeis) {
				
				RespuestaServicio respuestaSello = validarSelloConsultaObligatorio(model, user.getAforeUsuario());
				logger.error("Respuesta Sello: {}", respuestaSello);
				// 6- EL EMPLEADO NO CUENTA CON SELLO
				// REQUIERE VALIDACION  DEL SELLO
				if(NumerosConstants.INT_SEIS != respuestaSello.getFlujo().intValue()) {
					EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
					String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
					
					consulta.setClaveAfore(user.getAforeUsuario());
					DatosTrabajador trabajador = servicioConsulta.consultarPersona(consulta, user.getDatoUsuario(), user.getCurpAgente(), sucursal);
					consulta.setFolioPrevio(trabajador.getFolio());
					
					if(utileriaValidador.validarObjetoNulo(consulta.getCvTipoSolicitante())) {
						consulta.setCvTipoSolicitante(ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR);
					}
					
					trabajador.setTipoSolicitante(consulta.getCvTipoSolicitante());
					trabajador.setCurpSolicitante(consulta.getCurpSolicitante());
					List<Parametro> parametro = servicioCatalogo.obtenerParametro(ParametrosConstants.PARAMETRO_AFORES_VALIDAR_HUELLA, null);
					String valor = utileriaValidador.obtenerValorParametro(parametro, null, ParametrosConstants.VALOR_VALIDAR_HUELLAS);
					
					List<Parametro> rolesConsulta = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.ROL_CONSULTA_TRABAJADOR, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol());
					String rolConsulta = utileriaValidador.obtenerValorParametro(rolesConsulta, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), NumerosConstants.C_CERO);
					boolean consultaAgente = false;
					if(NumerosConstants.C_UNO.equals(rolConsulta)) {
						consultaAgente = true;
					}
					
					if(NumerosConstants.C_UNO.equals(rolConsulta) && !user.getAforeUsuario().equals(trabajador.getClaveAfore())) {
						throw new BusinessException(BusinessErrorEnum.TRABAJADOR_AFORE_DISTINTA);
					}
					
					if(!user.getAforeUsuario().equals(trabajador.getClaveAfore())) {
						consultaAgente = true;
						banderaAforeDistinto = true;
					}
					boolean isSolicitarSello = servicioConsulta.validarExpedienteEnrolamiento(trabajador.getDatosCertificables().getCurp());
					respuesta = this.validarRespuestaConsulta(valor, consulta, trabajador, user.getAforeUsuario(), consultaAgente, isSolicitarSello);
					RespuestaServicio respuestaProspecto = this.validarConsultaProspecto(valor, consulta.getCvTipoSolicitante(), trabajador.getDatosExpediente(), user.getAforeUsuario(), banderaAforeDistinto);
					if(NumerosConstants.INT_DIEZ == respuestaProspecto.getFlujo().intValue()) {
						respuesta = respuestaProspecto;
					}
					request.getSession().setAttribute("consultaAgente", consultaAgente);
					if(NumerosConstants.INT_UNO == respuesta.getFlujo()) {//EXITOSO
						model = new ModelAndView(NavegacionEnum.CONSULTA_GENERALES.getNavegacion());
						trabajador = servicioConsulta.obtenerDatosAdicionales(trabajador, banderaAforeDistinto);
						model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_UNO);
						model = consultarParametroAfores(model, banderaAforeDistinto);//CONTROL CANDADO EDITAR
						validarCeroPapel(request, trabajador, model, banderaAforeDistinto);
						respuesta = this.validarMensajeExpedientes(trabajador);
					}
	
					request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO, consulta);
					request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
					
					String opcionExpedienteMovil = utileriaValidador.obtenerValorParametro(aforesExpedienteMovil, AgenteConstants.CH_PARAMETRO_EXPEDIENTE_MOVIL, ExpresionesConstants.VACIO);
					request.getSession().setAttribute("opcionMovil", opcionExpedienteMovil);
					
					if(banderaAforeDistinto && !user.getAforeUsuario().equals(trabajador.getClaveAfore())) {
						List<Parametro> parametroIds = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.PARAMETRO_ID_MENUS);
						List<MenuPagina> subMenuUsuario = servicioAdmin.obtenerMenuId(parametroIds);
						logger.error("Sub Menu Usuario: {}", subMenuUsuario);
						request.getSession().setAttribute("subMenuUsuario", subMenuUsuario);
					} else {
						List<MenuPagina> subMenuUsuario = servicioAdmin.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario(), RolesConstants.SUB_MENU_BASICO);
						logger.error("Sub Menu Usuario: {}", subMenuUsuario);
						request.getSession().setAttribute("subMenuUsuario", subMenuUsuario);
					}
				} else {
					respuesta = respuestaSello;
				}
			}
		} catch (BusinessException be) {
			logger.error("BusinessException: Se presento un problema en la consulta del trabajador {}", be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("ExcepcionSe presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		//AFORES QUE PUEDEN HACER MODIFICACIONES
		model = consultarParametroAfores(model, banderaAforeDistinto);//CONTROL CANDADO EDITAR (LOGICA DUPLICADA)
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista consutla trabajador
	 * @author jogonzal
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultaPrincipalConsar.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView consultarPreviaExpedienteConsar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("consulta") EntradaConsulta consulta) {
		logger.error("Inicio validacion de consulta Trabajador (consultarPreviaExpediente): {}", consulta);
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL_CONSAR.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
				user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
				logger.error("Usuario (consultarPreviaExpedienteConsar): {}");
	
				List<Parametro> aforesExpedienteMovil = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_OPCION_EXPEDIENTE_MOVIL, AgenteConstants.CH_PARAMETRO_EXPEDIENTE_MOVIL);
						
				String sucursal = ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
				consulta.setClaveAfore(user.getAforeUsuario());
				DatosTrabajador trabajador = servicioConsulta.consultarPersona(consulta, user.getDatoUsuario(), user.getCurpAgente(), sucursal);
				consulta.setFolioPrevio(trabajador.getFolio());
				
				if(utileriaValidador.validarObjetoNulo(consulta.getCvTipoSolicitante())) {
					consulta.setCvTipoSolicitante(ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR);
				}
				
				trabajador.setTipoSolicitante(consulta.getCvTipoSolicitante());
				trabajador.setCurpSolicitante(consulta.getCurpSolicitante());
				boolean consultaAgente = true;
				
				respuesta = this.validarRespuestaConsulta(null, consulta, trabajador, user.getAforeUsuario(), consultaAgente, false);
				
				if(NumerosConstants.INT_UNO == respuesta.getFlujo()) {//EXITOSO
					model = new ModelAndView(NavegacionEnum.CONSULTA_GENERALES.getNavegacion());
					trabajador = servicioConsulta.obtenerDatosAdicionales(trabajador, false);
					model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_UNO);
					model = consultarParametroAfores(model, true);//CONTROL CANDADO EDITAR
					validarCeroPapel(request, trabajador, model, true);
					respuesta = this.validarMensajeExpedientes(trabajador);
				}
	
				request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO, consulta);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
				
				String opcionExpedienteMovil = utileriaValidador.obtenerValorParametro(aforesExpedienteMovil, AgenteConstants.CH_PARAMETRO_EXPEDIENTE_MOVIL, ExpresionesConstants.VACIO);
				request.getSession().setAttribute("opcionMovil", opcionExpedienteMovil);
				
				List<MenuPagina> subMenuUsuario = servicioAdmin.obtenerMenus(user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), user.getAforeUsuario(), RolesConstants.SUB_MENU_BASICO);
				logger.error("Sub Menu Usuario: {}", subMenuUsuario);
				request.getSession().setAttribute("subMenuUsuario", subMenuUsuario);
		} catch (BusinessException be) {
			logger.error("BusinessException: Se presento un problema en la consulta del trabajador {}", be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			
		} catch(Exception e) {
			logger.error("ExcepcionSe presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		//AFORES QUE PUEDEN HACER MODIFICACIONES
		model = consultarParametroAfores(model, true);//CONTROL CANDADO EDITAR (LOGICA DUPLICADA)
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * 
	 * Consulta autenticacion por INE redirect
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value = "/private/validarAutenticacionIne.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio consultaValidacionAutenticacionInePeis(HttpServletRequest request, HttpServletResponse response) {
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute("consulta");
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		logger.info(">>> Autenticacion por INE PEIS -- {}", consulta.getAutenticacionIne());
		
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.AUTENTICACION_INE_ERROR_CONEXION_PEIS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CERO, null);
		AutenticacionIne autenticacion = servicioResultadoAutenticacion.validarResultadoAutenticacionIne(consulta.getCurp());
		respuestaServicio.setDatos("consultaTrabajador.do");
		if(autenticacion != null) {
			if(GenericErrorEnum.RECHAZADO.getClave().equals(autenticacion.getResultadoIne())) {
				respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.AUTENTICACION_INE_ERROR_CONEXION_PEIS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			} else if(!GenericErrorEnum.ACEPTADO.getClave().equals(autenticacion.getResultadoIne())) {
				respuestaServicio = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.AUTENTICACION_INE_ERROR_CONEXION_PEIS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			} else {
				respuestaServicio.setFlujo(NumerosConstants.INT_UNO);
				respuestaServicio.setDatos("consultaAutenticacion.do");
				consulta.setCurpSolicitante(autenticacion.getCurpSolicitante());
				consulta.setCvTipoSolicitante(autenticacion.getTipoSolicitante());
				request.getSession().setAttribute("consulta", consulta);
			}
			request.getSession().setAttribute("objAutenticacionIne", autenticacion);
		}
		
		return respuestaServicio;
	}
	
	/**
	 * 
	 * Consulta autenticacion por INE redirect
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value = "/private/guardarNotificacion.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio guardarNotificacionAutenticacionIne(HttpServletRequest request, HttpServletResponse response) {
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute("consulta");
		AutenticacionIne autenticacionIne = (AutenticacionIne) request.getSession().getAttribute("objAutenticacionIne");
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		request.getSession().removeAttribute("objAutenticacionIne");
		
		logger.info("Se procede a eliminar folios antiguos, {}, {}", consulta.getCurp(), consulta.getNss());
		FolioActivo folioActivo = folioService.consultarFolioActivo(consulta.getCurp(), consulta.getNss(), ServiciosConstants.FOLIO_SERVICIO_AUTENTICACION_INE);
		if(folioActivo != null) {
			folioService.cerrarFolio(folioActivo.getIdFolioPulssar(), NumerosConstants.INT_CERO);
		}
		logger.info("Proceso de cierre de folios finalizado correctamente");
		
		logger.info("Generar folio de autenticacion: {}, {}", consulta.getCurp(), consulta.getNss());
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(user.getDatoUsuario());
		folio.setOperacion(ServiciosConstants.FOLIO_OPERACION_SERVICIO);
		folio.setServicio(ServiciosConstants.FOLIO_SERVICIO_AUTENTICACION_INE);
		folio.setSucursal(ServiciosConstants.SUCURSAL_FOLIO_DEFAULT);
		folio.setCurp(consulta.getCurp());
		folio.setNss(consulta.getNss());
		folio.setTiempoLlegada(ServiciosConstants.TIEMPO_LLEGADA);
		FolioEntrada foliorespuesta = folioService.generarFolio(folio);
		if(ServiciosConstants.RESULTADO_NOK.equals(foliorespuesta.getResultado())) {
			folioService.cerrarFolio(foliorespuesta.getIdFolio(), null);
			foliorespuesta = folioService.generarFolio(folio);
		}
		logger.info("Folio generador correctamente {}", foliorespuesta);
		
		autenticacionIne.setCvAfore(user.getAforeUsuario());
		autenticacionIne.setUsuario(user.getDatoUsuario());
		logger.info(">>> Guardar Autenticacion por INE PEIS -- {}", autenticacionIne.toString());
		servicioResultadoAutenticacion.guardarDetalleAdicionalAutenticacionIne(user.getDatoUsuario(), user.getAforeUsuario(), autenticacionIne.getCurpTrabajador());
		servicioNotificacionAutenticacionIne.guardarDatosNotificacionAutenticacionIne(autenticacionIne, user.getUsuario(), foliorespuesta.getFolio());
		
		folioService.cerrarFolio(foliorespuesta.getIdFolio(), NumerosConstants.INT_TRES);
		
		return new RespuestaServicio();
	}
	
	/**
	 * 
	 * Consulta autenticacion por INE redirect
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value = "/private/consultaPrincipalIne.do")
	public ModelAndView consultarPreviaIne(HttpServletRequest request, HttpServletResponse response) {
		
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute("consulta");
		logger.info(">>> Autenticacion por INE -- {}", consulta.getAutenticacionIne());
		
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

		consulta.setClaveAfore(user.getAforeUsuario());
		
		if(utileriaValidador.validarObjetoNulo(consulta.getCvTipoSolicitante())) {
			consulta.setCvTipoSolicitante(ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR);
		}
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(user.getDatoUsuario());
		folio.setOperacion(ServiciosConstants.FOLIO_OPERACION_CONSULTA);
		folio.setServicio(ServiciosConstants.FOLIO_SERVICIO_CONSULTA);
		folio.setSucursal(ServiciosConstants.SUCURSAL_FOLIO_DEFAULT);
		folio.setNss(consulta.getNss());
		folio.setCurp(consulta.getCurp());
		folio.setTiempoLlegada(consulta.getTimerPicker());
		
		FolioEntrada foliorespuesta = folioService.generarFolio(folio);
		if(ServiciosConstants.RESULTADO_NOK.equals(foliorespuesta.getResultado())) {
			folioService.cerrarFolio(foliorespuesta.getIdFolio(), null);
			foliorespuesta = folioService.generarFolio(folio);
		}
		request.getSession().setAttribute("folio", foliorespuesta);
		ModelAndView model = new ModelAndView(NavegacionEnum.INICIO_AUTENTICACION_POR_INE.getNavegacion());
		model.addObject(Constants.FOLIO, foliorespuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de validar el paperless
	 * 
	 * @param request
	 * @param trabajador
	 * @param model
	 */
	private void validarCeroPapel(HttpServletRequest request, DatosTrabajador trabajador, ModelAndView model, boolean aforeDistinto) {
		request.getSession().removeAttribute(ParametrosConstants.VALOR_PAPERLESS_JSP);
		request.getSession().removeAttribute(ParametrosConstants.PARAMETRO_PAPERLESS_JSP);
		if(!aforeDistinto) {
			List<Parametro> parametroPaperless = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_AFORES_PAPERLESS);
			String paperless = utileriaValidador.obtenerValorParametro(parametroPaperless, ParametrosConstants.DESCRIPCION_PAPERLESS, ExpresionesConstants.VACIO);
			if(!utileriaValidador.validarVacio(paperless)) {
				CeroPapel ceroPapel= ceroPapelService.consultaEstatusCeroPapel(trabajador.getProcesar());
				String valorPapel = ParametrosConstants.INACTIVO_PAPERLESS;
				if(!utileriaValidador.validarObjetoNulo(ceroPapel)) {
					valorPapel = obtenerValorPaperless(ceroPapel);
				}
				request.getSession().setAttribute(ParametrosConstants.VALOR_PAPERLESS_JSP, valorPapel);
				request.getSession().setAttribute(ParametrosConstants.PARAMETRO_PAPERLESS_JSP, paperless);
			}
		}
	}
	
	/**
	 * Validar el valor del objeto encontrado
	 * 
	 * @param ceroPapel
	 * @return
	 */
	private String obtenerValorPaperless(CeroPapel ceroPapel) {
		String valorPapel = ParametrosConstants.INACTIVO_PAPERLESS;
		if(!utileriaValidador.validarObjetoNulo(ceroPapel.getNuEstatusCeroPapel())) {
			if(NumerosConstants.INT_UNO.intValue() == ceroPapel.getNuEstatusCeroPapel().intValue()) {
				valorPapel = ParametrosConstants.ACTIVO_PAPERLESS;
			}
		}
		return valorPapel;
	}
	
	/**
	 * Vista consutla trabajador
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultaAutenticacion.do", method = {RequestMethod.POST})
	public ModelAndView consultaAutenticacionIne(HttpServletRequest request, HttpServletResponse response) {
		logger.error("Entra a (consultaAutenticacionIne)");
		ModelAndView model = new ModelAndView(NavegacionEnum.CONSULTA_GENERALES.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		boolean banderaAforeDistinto = false;
		try {
			EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute("consulta");
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			logger.info(">>> Autenticacion por INE PEIS -- {}", consulta.getAutenticacionIne());
			
			List<Parametro> aforesExpedienteMovil = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_OPCION_EXPEDIENTE_MOVIL, AgenteConstants.CH_PARAMETRO_EXPEDIENTE_MOVIL);
			
			consulta.setClaveAfore(user.getAforeUsuario());
			DatosTrabajador trabajador = servicioConsulta.consultarPersona(consulta, user.getDatoUsuario(), user.getCurpAgente(), ServiciosConstants.SUCURSAL_FOLIO_DEFAULT);
			consulta.setFolioPrevio(trabajador.getFolio());
			
			if(utileriaValidador.validarObjetoNulo(consulta.getCvTipoSolicitante())) {
				consulta.setCvTipoSolicitante(ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR);
			}
			
			trabajador.setTipoSolicitante(consulta.getCvTipoSolicitante());
			trabajador.setCurpSolicitante(consulta.getCurpSolicitante());
			
			List<Parametro> rolesConsulta = servicioCatalogo.obtenerParametroDdbpose(ParametrosConstants.ROL_CONSULTA_TRABAJADOR, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol());
			String rolConsulta = utileriaValidador.obtenerValorParametro(rolesConsulta, user.getRoles().get(NumerosConstants.INT_CERO).getClaveRol(), NumerosConstants.C_CERO);
			boolean consultaAgente = false;
			if(NumerosConstants.C_UNO.equals(rolConsulta)) {
				consultaAgente = true;
			}
			
			if(NumerosConstants.C_UNO.equals(rolConsulta) && !user.getAforeUsuario().equals(trabajador.getClaveAfore())) {
				throw new BusinessException(BusinessErrorEnum.TRABAJADOR_AFORE_DISTINTA);
			}
			
			if(!user.getAforeUsuario().equals(trabajador.getClaveAfore())) {
				consultaAgente = true;
				banderaAforeDistinto = true;
			}
			
			respuesta = this.validarRespuestaConsulta(null, consulta, trabajador, user.getAforeUsuario(), consultaAgente, false);
			
			trabajador = servicioConsulta.obtenerDatosAdicionales(trabajador, banderaAforeDistinto);
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_UNO);
			model = consultarParametroAfores(model, banderaAforeDistinto);
			validarCeroPapel(request, trabajador, model, banderaAforeDistinto);
			respuesta = this.validarMensajeExpedientes(trabajador);
	
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO, consulta);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
			
			String opcionExpedienteMovil = utileriaValidador.obtenerValorParametro(aforesExpedienteMovil, AgenteConstants.CH_PARAMETRO_EXPEDIENTE_MOVIL, ExpresionesConstants.VACIO);
			request.getSession().setAttribute("opcionMovil", opcionExpedienteMovil);
		
		} catch (BusinessException be) {
			logger.error("consultaTrabajador: Se presento un problema al mostrar los campos de consulta el trabajador", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.MENSAJE_HUELLA_EMPLEADO.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista consutla trabajador
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/muestraConsulta.do", method = {RequestMethod.GET})
	public ModelAndView mostrarDatosTrabajadorConsultado(HttpServletRequest request, HttpServletResponse response, @ModelAttribute EntradaConsulta consulta) {
		logger.info("Inicio validacion de consulta Trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.CONSULTA_GENERALES.getNavegacion());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		boolean consultaProspecto = false;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			if(!user.getAforeUsuario().equals(trabajador.getClaveAfore())) {
				consultaProspecto = true;
				Sello selloTrabajadorProspecto = servicioSello.obtenerSelloTrabajador(user.getCurpAgente(), trabajador.getDatosCertificables().getCurp(), user.getAforeUsuario());
				servicioSello.actualizarSelloProspecto(user.getUsuario(), selloTrabajadorProspecto.getId());
			}
			
			trabajador = servicioConsulta.obtenerDatosAdicionales(trabajador, consultaProspecto);
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_UNO);
			respuesta = this.validarMensajeExpedientes(trabajador);
			validarCeroPapel(request, trabajador, model, consultaProspecto);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		} catch (BusinessException be) {
			logger.error("muestraConsulta BE: Se presento un problema en la consulta del trabajador {}", be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("muestraConsulta Exception: Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		model = consultarParametroAfores(model, consultaProspecto);
		return model;
	}
	
	/**
	 * Validar los menasjes de expediente
	 * 
	 * @param trabajador
	 * @return
	 */
	private RespuestaServicio validarMensajeExpedientes(DatosTrabajador trabajador) {
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_TRES);
		
		if(!utileriaValidador.validarObjetoNulo(trabajador.getDatosExpediente())) {
			DatosExpediente expediente = trabajador.getDatosExpediente();
			if(!(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO) && expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO))) {
				String clave = validarExpedientesPermanentes(expediente);
				respuesta = servicioCatalogo.obtenerRespuesta(null, clave, trabajador.getClaveAfore(), NumerosConstants.INT_CUATRO, null);
			}
		}
		
		return respuesta;
	}
	
	/**
	 * Determinar expediente permanente
	 * 
	 * @param expediente
	 * @return
	 */
	private String validarExpedientesPermanentes(DatosExpediente expediente) {
		String clave = GenericErrorEnum.FALTA_EXPEDIENTE_IDENTIFICACION_ENROLAMIENTO.getClave();
		if(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO)) {
			clave = validarMensajeNoPermanente(expediente.getBanderaExpedienteIdentifiacion(), GenericErrorEnum.FALTA_EXPEDIENTE_IDENTIFICACION.getClave(), GenericErrorEnum.EXPEDIENTE_IDENTIFCIACION_TEMPORAL.getClave());
		} else if(expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO)) {
			clave = validarMensajeNoPermanente(expediente.getBanderaEnrolamiento(), GenericErrorEnum.FALTA_EXPEDIENTE_ENROLAMIENTO.getClave(), GenericErrorEnum.EXPEDIENTE_ENROLAMIENTO_TEMPORAL.getClave());
		} else {
			clave = validarExpedientesTemporales(expediente, clave);
		}
		return clave;
	}
	
	/**
	 * Determinar expediente permanente
	 * 
	 * @param expediente
	 * @return
	 */
	private String validarExpedientesTemporales(DatosExpediente expediente, String claveSinExpedientes) {
		String clave = claveSinExpedientes;
		if(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_DOS)) {
			clave = validarMensajeNoPermanente(expediente.getBanderaExpedienteIdentifiacion(), GenericErrorEnum.FALTA_EXPEDIENTE_IDENTIFICACION.getClave(), GenericErrorEnum.EXPEDIENTE_IDENTIFCIACION_ENROLAMIENTO_TEMPORAL.getClave());
		} else if(expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_DOS)) {
			clave = validarMensajeNoPermanente(expediente.getBanderaEnrolamiento(), GenericErrorEnum.FALTA_EXPEDIENTE_ENROLAMIENTO.getClave(), GenericErrorEnum.EXPEDIENTE_IDENTIFCIACION_ENROLAMIENTO_TEMPORAL.getClave());
		}
		return clave;
	}
	
	
	/**
	 * Valida los valores de expediente de identificacion no permanente
	 * 
	 * @param expediente
	 * @return
	 */
	private String validarMensajeNoPermanente(Integer bandera, String claveGenerica, String claveTemporal) {
		String clave = claveGenerica;
		if(bandera.equals(NumerosConstants.INT_DOS)) {//TEMPORAL
			clave = claveTemporal;
		}
		return clave;
	}
	
	/**
	 * Metodo encargado de validar el mensaje de expediente
	 * 
	 * @param trabajador
	 * @return
	 */
	private RespuestaServicio cambiarMensajesExpediente(DatosTrabajador trabajador) {
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_TRES);
		if(!utileriaValidador.validarObjetoNulo(trabajador.getDatosExpediente()) && 
				(!trabajador.getDatosExpediente().getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO) || 
						!trabajador.getDatosExpediente().getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO))) {
			respuesta = this.obtenerMensajeExpediente(trabajador.getDatosExpediente(), trabajador.getClaveAfore());
		}
		return respuesta;
	}
	
	/**
	 * Metodo encagado de validar los expedientes
	 * 
	 * @param expediente
	 * @param claveAfore
	 * @return
	 */
	protected RespuestaServicio obtenerMensajeExpediente(DatosExpediente expediente, String claveAfore) {
		String clave = obtenerMensajeExpedienteTemporal(expediente, claveAfore);
		
		if(utileriaValidador.validarVacio(clave)) {
			clave = GenericErrorEnum.FALTA_EXPEDIENTE_IDENTIFICACION_ENROLAMIENTO.getClave();
			if(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_CERO) && expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO)) {
				clave = GenericErrorEnum.FALTA_EXPEDIENTE_ENROLAMIENTO.getClave();
			} else if(expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_CERO) && expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO)) {
				clave = GenericErrorEnum.FALTA_EXPEDIENTE_IDENTIFICACION.getClave();
			}
		}
		
		return servicioCatalogo.obtenerRespuesta(null, clave, claveAfore, NumerosConstants.INT_CUATRO, null);
	}
	
	/**
	 * Metodo encagado de validar los expedientes
	 * 
	 * @param expediente
	 * @param claveAfore
	 * @return
	 */
	protected String obtenerMensajeExpedienteTemporal(DatosExpediente expediente, String claveAfore) {
		String clave = null;
		
		if(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_DOS) || expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_DOS)) {
			clave = GenericErrorEnum.EXPEDIENTE_IDENTIFCIACION_ENROLAMIENTO_TEMPORAL.getClave();
			if(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_DOS) && !expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_DOS)) {
				clave = GenericErrorEnum.FALTA_EXPEDIENTE_IDENTIFICACION.getClave();
			} else if(!expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_DOS) && expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_DOS)) {
				clave = GenericErrorEnum.FALTA_EXPEDIENTE_ENROLAMIENTO.getClave();
			}
		}
		
		return clave;
	}
	
	/**
	 * Metodo encargado de validar si se realiza la solicitud de huellas del trabajador
	 * 
	 * @param valor
	 * @param consulta
	 * @param trabajador
	 * @param afore
	 * @return
	 */
	protected RespuestaServicio validarConsultaProspecto(String valor, String tipoSolicitante, DatosExpediente expediente, String afore, boolean aforeDistinto) {
		logger.error("Validacion Prospecto");
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_UNO);
		
		if(!utileriaValidador.validarObjetoNulo(valor) && aforeDistinto) {
			if(valor.contains(afore)) {
				respuesta = validarTipoSolicitanteProspecto(tipoSolicitante, expediente, afore);
			}
		}
		
		logger.error("Respuesta (validarConsultaProspecto): {}",respuesta);
		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar si se realiza la solicitud de huellas del trabajador
	 * 
	 * @param valor
	 * @param consulta
	 * @param trabajador
	 * @param afore
	 * @return
	 */
	protected RespuestaServicio validarRespuestaConsulta(String valor, EntradaConsulta consulta, DatosTrabajador trabajador, String afore, boolean consultaOperativo, boolean isSolicitar) {
		logger.error("Entra (validarRespuestaConsulta) Valor: {}, Consulta Operativa: {}", valor, consultaOperativo);
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_UNO);
		
		if(!utileriaValidador.validarObjetoNulo(valor) && !consultaOperativo) {
			DatosExpediente expediente = trabajador.getDatosExpediente();
			if(valor.contains(afore)&& isSolicitar) {
				respuesta = validarTipoSolicitante(consulta, expediente, afore);
			}
		}
		
		logger.error("Respuesta (validarRespuestaConsulta): {}",respuesta);
		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar el tipo solicitante de la consulta
	 * @param consulta
	 * @param expediente
	 * @param afore
	 * @return
	 */
	private RespuestaServicio validarTipoSolicitanteProspecto(String tipoSolicitante, DatosExpediente expediente, String afore) {
		RespuestaServicio respuestaTipoSol = new RespuestaServicio();
		respuestaTipoSol.setFlujo(NumerosConstants.INT_UNO);
		if(utileriaValidador.validarObjetoNulo(tipoSolicitante) || ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante)) {
			List<Integer> lstBiometrico = new ArrayList<>();
			lstBiometrico.add(NumerosConstants.INT_UNO);
			respuestaTipoSol = validarExpediente(expediente, afore, lstBiometrico);
			if(NumerosConstants.INT_UNO.intValue() == respuestaTipoSol.getFlujo().intValue()) {
				throw new BusinessException(BusinessErrorEnum.TRABAJADOR_SIN_EXPEDIENTE_ENROLAMIENTO_PERMANENTE);
			}
		}
		return respuestaTipoSol;
	}
	
	/**
	 * Metodo encargado de validar el tipo solicitante de la consulta
	 * @param consulta
	 * @param expediente
	 * @param afore
	 * @return
	 */
	private RespuestaServicio validarTipoSolicitante(EntradaConsulta consulta, DatosExpediente expediente, String afore) {
		RespuestaServicio respuestaTipoSol = new RespuestaServicio();
		respuestaTipoSol.setFlujo(NumerosConstants.INT_UNO);
		if(utileriaValidador.validarObjetoNulo(consulta.getCvTipoSolicitante()) || ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR.equals(consulta.getCvTipoSolicitante())) {
			List<Integer> lstBiometrico = new ArrayList<>();
			lstBiometrico.add(NumerosConstants.INT_UNO);
			lstBiometrico.add(NumerosConstants.INT_DOS);
			respuestaTipoSol = validarExpediente(expediente, afore, lstBiometrico);
		}
		return respuestaTipoSol;
	}
	
	/**
	 * Metodo encagrado de validar el expediente de la consulta
	 * @param expediente
	 * @param afore
	 * @return
	 */
	private RespuestaServicio validarExpediente(DatosExpediente expediente, String afore, List<Integer> lstBiometrico) {
		RespuestaServicio respuestaExpediente = new RespuestaServicio();
		respuestaExpediente.setFlujo(NumerosConstants.INT_UNO);
		if(!utileriaValidador.validarObjetoNulo(expediente) && lstBiometrico.contains(expediente.getBanderaEnrolamiento()) && expediente.getRol().contains(NumerosConstants.C_UNO)) {
			respuestaExpediente = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.MENSAJE_HUELLA_TRABAJADOR.getClave(), afore, NumerosConstants.INT_DIEZ, null);
		}
		return respuestaExpediente;
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/private/actualizarDatos.do", method = RequestMethod.POST)
	public ModelAndView actualizarDatosTrabajador(HttpServletRequest request, HttpServletResponse response, @ModelAttribute EntradaConsulta consulta) throws IOException {
		logger.info("Inicio consulta trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, consulta);
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			consulta.setClaveAfore(user.getAforeUsuario());
			EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
			String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
			
			DatosTrabajador datos = servicioConsulta.consultarPersona(consulta, user.getDatoUsuario(), user.getCurpAgente(), sucursal);
			DatosTrabajador auxiliar;
			
			consulta.setFolioPrevio(datos.getFolio());
			String tipoSolicitante = consulta.getCvTipoSolicitante();
			if(utileriaValidador.validarVacio(tipoSolicitante)) {
				tipoSolicitante = ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR;
			}
			datos.setTipoSolicitante(tipoSolicitante);
			consulta.setCvTipoSolicitante(tipoSolicitante);
			respuesta.setFlujo(NumerosConstants.INT_SEIS);
			
			auxiliar = servicioConsulta.obtenerDatosAdicionales(datos, false);
			model = new ModelAndView(NavegacionEnum.CONSULTA_GENERALES.getNavegacion());
			model = this.obtenerValoresTrabajador(model, auxiliar, NumerosConstants.INT_UNO);
			
			if(!utileriaValidador.validarObjetoNulo(auxiliar.getDatosExpediente()) && (!auxiliar.getDatosExpediente().getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO) || !auxiliar.getDatosExpediente().getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO))) {
				respuesta = this.obtenerMensajeExpediente(auxiliar.getDatosExpediente(), user.getAforeUsuario());
			}
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, auxiliar);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO, consulta);
		} catch(BusinessException be) {
			logger.error("Se presento un error de negocio", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			respuesta = this.validarRespuestaFolio(be, respuesta, request);
		} catch(GenericException ge) {
			logger.error("Se presento un error generico", ge);
			respuesta = servicioCatalogo.obtenerRespuesta(null, ge.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("Excepcion: Se presento un problema al mostrar los campos de consulta el trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = consultarParametroAfores(model, false);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de validar la repuesta de folio existente
	 * 
	 * @param errorNegocio
	 * @param respuesta
	 * @return
	 */
	private RespuestaServicio validarRespuestaFolio(BusinessException errorNegocio, RespuestaServicio respuesta, HttpServletRequest request) {
		RespuestaServicio auxiliar = respuesta;
		if(BusinessErrorEnum.FOLIO_ACTIVO.getClave().equals(errorNegocio.getCodigo())) {
			auxiliar.setFlujo(NumerosConstants.INT_TRES);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO, errorNegocio.getDatos());
		}
		return auxiliar;
	}
	
	/**
	 * Obtener las curps
	 * 
	 * @param curpsHistoricas
	 * @return
	 */
	protected String obtenerCurps(List<String> curpsHistoricas) {
		String valor = ExpresionesConstants.VACIO;
		
		if(!utileriaValidador.validarListaVacia(curpsHistoricas)) {
			for(String curp : curpsHistoricas) {
				valor = utileriaCadena.obtenerCadenaConcatenada(false, valor, curp, TextoConstants.SALTO_BR);
			
			}
		}
		
		return valor;
	}
	
	/**
	 * finaliza consulta de trabajador
	 * @param idFolio
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/private/finalizaProceso.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView finalizarFolio(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			Object auxiliarDatos = request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			
			EntradaConsulta entradaPrevia = (EntradaConsulta) auxiliarDatos;
			servicioConsulta.cerrarFolio(entradaPrevia.getFolioPrevio());
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			respuesta.setFlujo(NumerosConstants.INT_CINCO);
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_SOLICITANTE, ParametrosConstants.TIPOS_SOLICITANTE);
			String tiposSolicitante = utileriaValidador.obtenerValorParametro(listaParametro, ParametrosConstants.TIPOS_SOLICITANTE, ServiciosConstants.CADENA_TIPOS_SOLICITANTES);
			model.addObject(ParametrosConstants.COMBO_SOLICITANTE, utileriaConversion.obtenerComboTipoSolicitante(servicioCatalogo.obtenerTipoSolicitante(tiposSolicitante)));
			eliminarDatosSesion(request);
		} catch(BusinessException be) {
			logger.error("Se presento un error de negocio en el proceso de finalizar folio", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("Se presento un problema no controlado en el proceso de finalizar folio", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			model = new ModelAndView(NavegacionEnum.LOGOUT_COPPEL.getNavegacion());
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, PdfConstants.COPPEL);
			
			EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
			if(objetoCoppel != null) {
				Map<String, String> mapa = (Map<String, String>) request.getSession().getAttribute(ParametrosConstants.REDIRECCION_COPPEL_PORTAL);
				model.addObject("bFinaliza", "1");
				model.addAllObjects(mapa);
				request.getSession().removeAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
				request.getSession().removeAttribute(ParametrosConstants.REDIRECCION_COPPEL_PORTAL);
			}
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Finaliza Proceso Consar
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/private/finalizaProcesoConsar.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView finalizarFolioConsar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(NavegacionEnum.PRINCIPAL_CONSAR.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			Object auxiliarDatos = request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			
			EntradaConsulta entradaPrevia = (EntradaConsulta) auxiliarDatos;
			servicioConsulta.cerrarFolio(entradaPrevia.getFolioPrevio());
			
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			respuesta.setFlujo(NumerosConstants.INT_CINCO);
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_SOLICITANTE, ParametrosConstants.TIPOS_SOLICITANTE);
			String tiposSolicitante = utileriaValidador.obtenerValorParametro(listaParametro, ParametrosConstants.TIPOS_SOLICITANTE, ServiciosConstants.CADENA_TIPOS_SOLICITANTES);
			model.addObject(ParametrosConstants.COMBO_SOLICITANTE, utileriaConversion.obtenerComboTipoSolicitante(servicioCatalogo.obtenerTipoSolicitante(tiposSolicitante)));
		} catch(BusinessException be) {
			logger.error("Se presento un error de negocio en el proceso de finalizar folio", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(Exception e) {
			logger.error("Se presento un problema no controlado en el proceso de finalizar folio", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
			model = new ModelAndView(NavegacionEnum.LOGOUT_COPPEL.getNavegacion());
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, PdfConstants.COPPEL);
			
		}
		
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	
	
	/**
	 * Vista datos generales get
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/datosGenerales.do", method = RequestMethod.GET)
	public ModelAndView mostrarDatosTrabajador(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CONSULTA_GENERALES.getNavegacion(),ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
		logger.info("Consulta trabajador");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		RespuestaServicio respuestaModificacion = null;
		boolean banderaAfore = false;
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			respuestaModificacion = (RespuestaServicio)request.getSession().getAttribute(ParametrosConstants.ERROR_MODIFICACION);

			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_UNO);
			
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
			if(!ServiciosConstants.CLAVE_CONSAR.equals(user.getAforeUsuario()) && !trabajador.getClaveAfore().equals(user.getAforeUsuario())) {
				banderaAfore = true;
			}

		} catch(Exception e) {
			logger.error("Exception al mostrar Datos Generales", e);
			model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion());
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		model = consultarParametroAfores(model, banderaAfore);
		this.validarRespuestaModificacion(respuestaModificacion,model,request);

		return model;
	}
	
	/**
	 * Vista datos complementarios
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/datosComplementarios.do", method = RequestMethod.GET)
	public ModelAndView mostrarDatosComplementarios(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CONSULTA_COMPLEMANTARIOS.getNavegacion());
		logger.info("Consulta trabajador complementarios");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
						
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_DOS);
			
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		} catch(Exception e) {
			logger.error("Exception al mostrar los datos Complementarios", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista epediente identificacion
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/datosIdentificacion.do", method = RequestMethod.GET)
	public ModelAndView mostrarDatosExpedienteIdentificacion(HttpServletRequest request) {
		ModelAndView modelIdentifacion = new ModelAndView(NavegacionEnum.CONSULTA_IDENTIFICACION.getNavegacion());
		logger.info("Obtener Datos de Identificacion");
		RespuestaServicio respuestaIdentificacion = new RespuestaServicio();
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			usuario = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			DatosTrabajador datos = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			
			DatosExpediente expediente = datos.getDatosExpediente();
			if(!utileriaValidador.validarObjetoNulo(expediente) && !expediente.isConsultaExpediente()) {
				datos.setDatosExpediente(servicioConsulta.validarExpediente(datos.getDatosCertificables().getCurp(), usuario.getAforeUsuario(), expediente.getEstatusExpedienteIdentificacion(), null, usuario.getCurpAgente()));
			}
			modelIdentifacion = this.obtenerValoresTrabajador(modelIdentifacion, datos, NumerosConstants.INT_TRES);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, datos);
		} catch(Exception e) {
			logger.error("Exception al mostrar Datos de Expediente Identificacion", e);
			respuestaIdentificacion = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), usuario.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		modelIdentifacion = utileriaConversion.obtenerImagenNombreUsuario(modelIdentifacion, usuario);
		modelIdentifacion = utileriaConversion.agregarRespuestaModel(modelIdentifacion, respuestaIdentificacion);
		return modelIdentifacion;
	}
	
	/**
	 * Vista epediente biometrico
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/datosBiometricos.do", method = RequestMethod.GET)
	public ModelAndView mostrarDatosExpedienteBIOMETRICO(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.CONSULTA_BIOMETRICOS.getNavegacion());
		logger.info("Obtener Datos Biometricos");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			
			DatosExpediente expediente = trabajador.getDatosExpediente();
			if(!utileriaValidador.validarObjetoNulo(expediente)&& !expediente.isConsultaBiometrico()) {
				trabajador.setDatosExpediente(servicioConsulta.validarExpediente(trabajador.getDatosCertificables().getCurp(), user.getAforeUsuario(), null, expediente.getEstatusEnrolamiento(), user.getCurpAgente()));
			}
			
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_TRES);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		} catch(Exception e) {
			logger.error("Exception al mostrar los datos de biometrico", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista datos icefa
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/datosIcefas.do", method = RequestMethod.GET)
	public ModelAndView mostrarDatosIcefas(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.SALARIOS_ICEFAS.getNavegacion());
		logger.info("Obtener Datos de ICEFAS y Salario");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_CUATRO);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		} catch(Exception e) {
			logger.error("Exception al mostrar los datos de salario e icefas", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Vista datos saldos
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/datosSaldos.do", method = RequestMethod.GET)
	public ModelAndView mostrarSaldos(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.SALDOS.getNavegacion());
		logger.info("Obtener Saldos Preliminares");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			request.getSession().removeAttribute(ParametrosConstants.REQUEST_DATOS);
			model = this.obtenerValoresTrabajador(model, trabajador, NumerosConstants.INT_CINCO);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		} catch(Exception e) {
			logger.error("Se presento un problema no controlado al mostrar los saldos del trabajador", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model = utileriaConversion.agregarRespuestaModel(model, respuesta);
		return model;
	}
	
	/**
	 * Metodo encargado de obtener los valores del trabajador
	 * 
	 * @param model
	 * @param datos
	 * @param tipo
	 * @return
	 */
	protected ModelAndView obtenerValoresTrabajador(ModelAndView model, DatosTrabajador datos, Integer tipo) {
		ModelAndView auxiliarModel = model;
		auxiliarModel.addObject("marcas", this.transformarMarcas(datos.getMarcas()));
		auxiliarModel.addObject("expedienteB", datos.getDatosExpediente());
		auxiliarModel.addObject("folio", datos.getFolio());
		
		if(NumerosConstants.INT_UNO.equals(tipo)) {//DATOS TRABAJADOR
			auxiliarModel.addObject("trabajador", datos);
			auxiliarModel.addObject("certificables", datos.getDatosCertificables());
			auxiliarModel.addObject("domicilio", datos.getDatosComplementarios().getParticular());
			if(datos.getRenapo() != null) {
				datos.getRenapo().setCurpsHistoricas(this.obtenerCurps(datos.getRenapo().getListaCurpHistoricas()));
			}
			auxiliarModel.addObject("renapo", datos.getRenapo());
			auxiliarModel.addObject("correo", datos.getDatosComplementarios().getCorreoElectronico());
			auxiliarModel.addObject("rfc", datos.getDatosNoCertificables().getRfc());
			auxiliarModel.addObject("curpsDuplicadas", this.transformarCurpsDuplicadas(datos.getAforesDuplicadas()));
			auxiliarModel.addObject("certificado", datos.getCertificado());
			if(datos.getSalariosIcefas() != null) {
				auxiliarModel.addObject("indicador", datos.getSalariosIcefas().getIndicador());
			}
		} else if(NumerosConstants.INT_DOS.equals(tipo)) {//DATOS COMPLEMENTARIOS
			auxiliarModel.addObject("domParticular", datos.getDatosComplementarios().getParticular());
			auxiliarModel.addObject("domLaboral", datos.getDatosComplementarios().getLaboral());
			auxiliarModel.addObject("contacto", datos.getDatosComplementarios().getTelefonos());
			auxiliarModel.addObject("correo", datos.getDatosComplementarios().getCorreoElectronico());
			auxiliarModel.addObject("referencias", this.transformarReferencias(datos.getDatosComplementarios().getListaReferencias()));
			auxiliarModel.addObject("beneficiarios", this.transformarBeneficiarios(datos.getDatosComplementarios().getListaBeneficiario()));
			auxiliarModel.addObject("fechaControl", datos.getDatosComplementarios().getFechaControl());
		} else if(NumerosConstants.INT_TRES.equals(tipo)) {//DATOS EXPEDIENTE (IDENTIFICACION/BIOMETRICO)
			auxiliarModel.addObject("expediente", datos.getDatosExpediente());
		} else {//DATOS ICEFAS / SUELDOS Y SALARIOS
			auxiliarModel = this.obtenerValoresTrabajadorContinuacion(auxiliarModel, datos, tipo);
		}
		
		return auxiliarModel;
	}
	
	/**
	 * Metodo encargado de obtener los valores del trabajador
	 * 
	 * @param model
	 * @param datos
	 * @param tipo
	 * 
	 * @return
	 */
	private ModelAndView obtenerValoresTrabajadorContinuacion(ModelAndView model, DatosTrabajador datos, int tipo) {
		ModelAndView auxiliarModel = model;
		
		if(NumerosConstants.INT_CUATRO.equals(tipo)) {//ICEFAS
			List<DatosIcefaTrabajador> icefasTrabajador = consultarIcefaTrabajadorService.obtenerIcefasTrabajadorSaldoSares(datos.getProcesar(), datos.getDatosCertificables().getFechaNacimiento());
			auxiliarModel.addObject("icefas", icefasTrabajador);
		} else if(NumerosConstants.INT_CINCO.equals(tipo)) {//SALDOS
			List<Parametro> parametros = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_AFORES_CONSULTA_EXTRA, null);
			String valueParametro = utileriaValidador.obtenerValorParametro(parametros, datos.getClaveAfore(), ExpresionesConstants.VACIO);
			
			DatosSaldos saldos = datos.getSaldos();
			if(!utileriaValidador.validarVacio(valueParametro)) {
				logger.info("Se consume el nuevo servicio de imss");
				saldos = servicioSaldos.obtenerSaldos(datos.getDatosCertificables().getCurp(), datos.getNss(), datos.getClaveAfore());
			}
			auxiliarModel.addObject("salario", datos.getSalariosIcefas().getSalario());
			auxiliarModel.addObject("periodo", datos.getSalariosIcefas().getPeriodo());
			auxiliarModel.addObject("saldos", saldos);
		}
		
		return auxiliarModel;
	}
	
	/**
	 * Genera la cadena para el html de las referencias
	 * 
	 * @param lista
	 * @return
	 */
	protected String transformarReferencias(List<Referencia> lista) {
		String cadena = utileriaCadena.obtenerCadenaConcatenada(false, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_CERRAR);
		if(!utileriaValidador.validarListaVacia(lista)) {
			cadena = ExpresionesConstants.VACIO;
			for(Referencia referencia : lista) {
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_NOMBRE, TextoConstants.TAG_STRONG_CERRAR, referencia.getNombre(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_APATERNO, TextoConstants.TAG_STRONG_CERRAR, referencia.getApellidoPaterno(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_AMATERNO, TextoConstants.TAG_STRONG_CERRAR, referencia.getApellidoMaterno(), TextoConstants.DIV_CERRAR, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_CURP, TextoConstants.TAG_STRONG_CERRAR, referencia.getCurp(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_PARENTESCO, TextoConstants.TAG_STRONG_CERRAR, referencia.getParentesco(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_TELEFONO, TextoConstants.TAG_STRONG_CERRAR, referencia.getTelefono(), TextoConstants.DIV_CERRAR, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_CAMPO_VACIO, TextoConstants.TAG_STRONG_CERRAR, null, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_CAMPO_VACIO, TextoConstants.TAG_STRONG_CERRAR, null, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_FECHA_CONTROL, TextoConstants.TAG_STRONG_CERRAR, referencia.getFechaControl(), TextoConstants.DIV_CERRAR, TextoConstants.DIV_CERRAR);
			}
		}
		
		return cadena;
	}
	
	/**
	 * Genera la cadena para el html de los beneficiarios
	 * 
	 * @param lista
	 * @return
	 */
	protected String transformarBeneficiarios(List<Beneficiario> lista) {
		String cadena = utileriaCadena.obtenerCadenaConcatenada(false, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_CERRAR);
		if(!utileriaValidador.validarListaVacia(lista)) {
			cadena = ExpresionesConstants.VACIO;
			for(Beneficiario beneficiario : lista) {
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_NOMBRE, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getNombre(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_APATERNO, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getApellidoPaterno(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_AMATERNO, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getApellidoMaterno(), TextoConstants.DIV_CERRAR, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_CURP, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getCurp(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_PARENTESCO, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getParentesco(), TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_PORCENTAJE, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getPorcentaje(), TextoConstants.DIV_CERRAR, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW_CONTENEDOR, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_CAMPO_VACIO, TextoConstants.TAG_STRONG_CERRAR, null, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_CAMPO_VACIO, TextoConstants.TAG_STRONG_CERRAR, null, TextoConstants.DIV_CERRAR);
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_DATOS, TextoConstants.TAG_STRONG, TextoConstants.LABEL_FECHA_CONTROL, TextoConstants.TAG_STRONG_CERRAR, beneficiario.getFechaControl(), TextoConstants.DIV_CERRAR, TextoConstants.DIV_CERRAR);
			}
		}
		
		return cadena;
	}
	
	/**
	 * Genera la cadena para el html de los beneficiarios
	 * 
	 * @param lista
	 * @return
	 */
	protected String transformarMarcas(List<String> lista) {
		String cadena = ExpresionesConstants.VACIO;
		if(!utileriaValidador.validarListaVacia(lista)) {
			for(String marca : lista) {
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, TextoConstants.DIV_ROW, marca, TextoConstants.DIV_CERRAR);
			}
		}
		
		return cadena;
	}
	
	/**
	 * Curps duoplc
	 * @return
	 */
	protected String transformarCurpsDuplicadas(List<String> lista) {
		String cadena = ExpresionesConstants.VACIO;
		if(!utileriaValidador.validarListaVacia(lista)) {
			int valor;
			for(int i = 0 ; i < lista.size(); i++) {
				valor = i % 2;
				String textoDiv = TextoConstants.DIV_ROW2;
				if(valor == 0) {
					textoDiv = TextoConstants.DIV_ROW1;
				}
				cadena = utileriaCadena.obtenerCadenaConcatenada(false, cadena, textoDiv, lista.get(i), TextoConstants.DIV_CERRAR);
			}
		}
		return cadena;
	}
	
	/**
	 * Metodo que valida errores de modificacion de datos
	 * @param respuestaModificacion
	 * @param model
	 * @param request
	 */
	private void validarRespuestaModificacion(RespuestaServicio respuestaModificacion,ModelAndView model,HttpServletRequest request){
		if(!utileriaValidador.validarObjetoNulo(respuestaModificacion)){
			utileriaConversion.agregarRespuestaModel(model, respuestaModificacion);
		}
		request.getSession().removeAttribute(ParametrosConstants.ERROR_MODIFICACION);
	}
	
	/**
	 * Metodo que consulta parametro apra saber que afores pueden hacer modificacion de datos
	 */
	private ModelAndView consultarParametroAfores(ModelAndView model, boolean aforeDistinto) {
		if(!aforeDistinto) {
			String parametroAfores = servicioConsulta.obtenerParametroAforesModificacion();
			return model.addObject("aforesModificacion", parametroAfores);
		}
		return model;
	}
	
	/**
	 * Valida existencia de archivo de PDF para el aviso de privacidad
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/validaAvisoPriv.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarPdfAvisoPrivacidad(HttpServletRequest request) {
		logger.info("validarPdfAvisoPrivacidad");
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_CERO);
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String nombreArchivo = (String) request.getSession().getAttribute(ParametrosConstants.NOMBRE_ARCHIVO_AVISO_PRIVACIDAD);
			StringBuilder pathAvisoPrivacidad = new StringBuilder(rutaAvisoPrivacidad).append(nombreArchivo);
			
			File archivoExiste = new File(pathAvisoPrivacidad.toString());
			logger.info("Se valida la existencia del PDF de aviso de privacidad: {}", pathAvisoPrivacidad.toString());
			if (!archivoExiste.exists()) {
				respuesta.setFlujo(NumerosConstants.INT_UNO);
				respuesta.setTitulo("Aviso de privacidad");
				respuesta.setMensaje("A ocurrido un error al intentar mostrar el Aviso de privacidad");
			}			
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de intentar recuperar el archivo ", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	
	/**
	 * Metodo que recupera el archivo de aviso de privacidad
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/private/avisoPrivacidad.do", method = RequestMethod.GET, produces = { "application/pdf" })
	@ResponseBody
	public byte[] recuperarAvisoPrivacidad(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Recuperar archivo de Aviso de Privacidad");
		String nombreArchivo = (String) request.getSession().getAttribute(ParametrosConstants.NOMBRE_ARCHIVO_AVISO_PRIVACIDAD);
		StringBuilder pathAvisoPrivacidad = new StringBuilder(rutaAvisoPrivacidad).append(nombreArchivo);

		File archivoExiste = new File(pathAvisoPrivacidad.toString());
		int tamanoArchivo = (int) archivoExiste.length();
		byte[] contenido = new byte[tamanoArchivo];
		
		logger.info("Archivo encontrado...");
		try (FileInputStream entrada = new FileInputStream(archivoExiste)) {
			entrada.read(contenido);
		} catch (Exception e) {
			logger.error("error al leer el archivo de avido de privacidad");
			contenido = null;
		}
		return contenido;
	}
	
	/**
	 * Metodo encargado de eliminar datos sesion que no se ocupan para nuevo proceso
	 * @param request
	 */
	private void eliminarDatosSesion(HttpServletRequest request) {
		Enumeration<String> atributos = request.getSession().getAttributeNames();
		String atributo = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_DATOS_GENERICOS_SESION, ActivacionConstants.PARAMETRO_CLAVE_DATOS_GENERICOS_SESION);
		while(atributos.hasMoreElements()) {
			String dato = atributos.nextElement();
			if(!atributo.contains(dato)) {
				request.getSession().removeAttribute(dato);
			}
		}
	}
}