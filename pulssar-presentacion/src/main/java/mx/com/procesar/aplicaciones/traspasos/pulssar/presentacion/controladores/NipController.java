/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import javax.servlet.http.HttpServletRequest;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaGeneraNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipBUUService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipFoliadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipValidadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author malopezt
 * Controlador vista NIPs
 */
@Controller
public class NipController {

	/** Registro */
	private static final Logger logger = LoggerFactory.getLogger(NipController.class);
	
	/** Constante numérica: Define Éxito en la generación de NIP */
	private static final Integer CONTANTE_EXITO = 1;
	
	/** Constante numérica: Describe la existencia de un error en la generación de NIP */
	private static final Integer CONTANTE_ERROR = 0;

	/** Servicio encargado de recuperar información de la BUU - Admon Cuenta */
	@Autowired
	private NipBUUService nipBUUService;
	
	/** Solicitud de generación de Nip */
	@Autowired
	private NipSolicitudService nipSolicitudService;
	
	/** Aplica validaciones de negocio a entrada */
	@Autowired
	private NipValidadorService nipValidadorService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	

	/** Obtiene el folio asociado a la presente solicitud de generaciónd e NIP */
	@Autowired
	private NipFoliadoService nipFoliadoService;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdmin;
	
	/** Genera un NIP con base en la información recibida. */
	@RequestMapping(value = "/private/generarNip", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public RespuestaGeneraNip generarNIP(
			@RequestBody GeneraNIP solicitudDeNIP, HttpServletRequest request) {
		RespuestaGeneraNip salida = null;
		logger.info("[generarNIP] - Inicio Proceso Generacion NIP");
		try {
			// Información del trabajador: Afore
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			solicitudDeNIP.setCveAfore(trabajador.getClaveAfore());
			// Servicio de generación de Nip, establece que el NSS va con un valor (length > 0) o Nulo
			if (solicitudDeNIP.getNss() != null && solicitudDeNIP.getNss().isEmpty()) {
				solicitudDeNIP.setNss(null);
			}
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			
			FolioEntrada folio = (FolioEntrada) request.getSession().getAttribute("folioNip");
			logger.info("[generarNIP] - Folio Nip: {}", folio);
			logger.info("[generarNIP] - Usuario: {} -  Usuario Agente: {}", user.getUsuario(), user.getUsuarioAgente());
			
			salida = nipSolicitudService.solicitarNIP(solicitudDeNIP, user.getUsuario(), folio.getFolio(), user.getSucursal());
			logger.info("[generarNIP] - Datos de entrada: {} - salida: {}",solicitudDeNIP, salida); 
		
			request.getSession().removeAttribute("folioNip");
		} catch (BusinessException e) {
			// TODO: Manejo de mensaje de salida de acuerdo a la excepción
			salida.setFlujo(CONTANTE_ERROR);
			salida.setMensaje(e.getMessage());
			logger.error("[generarNIP] - Error no esperado. ", e);
		}
//		try{
//			logger.info("Haremos 5 segundo de tiempo muerto ...");
//			Thread.sleep(15000);
//		} catch (Exception e) {
//			// Nada por hacer.... excepto gastar tiempo... para prueba del modal de espera
//		}
		
		return salida;
	}
	
	/** Presenta una pantalla de captura de información para generar un Nip */
	@RequestMapping(value = "/private/solicitarNip.do", method = RequestMethod.GET)
	public ModelAndView solicitarNip(HttpServletRequest request ) {
		logger.info("[Controlador][solicitarNip] - Inicio vista Solicitud NIP");
		ModelAndView model = null;
		
		try {
			EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			// Validaciones de datos
			NipConsultaBUU complementoBUU = 
					nipBUUService.consultarDatosBUU(trabajador.getDatosCertificables().getCurp());
			logger.info("[Controlador] - Curp:{} - complementoBUU: {}", 
					trabajador.getDatosCertificables().getCurp(), complementoBUU);
			RespuestaServicio respuesta = nipValidadorService.validarInformacion(trabajador, complementoBUU);
			if (respuesta.getFlujo() == CONTANTE_EXITO) {

			
				model = new ModelAndView(NavegacionEnum.SOLICITUD_NIP.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_COMMAND, new EntradaConsulta());
				GeneraNIP datosSolicitaNIP = new GeneraNIP();
				datosSolicitaNIP.setApMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
				datosSolicitaNIP.setApPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
				datosSolicitaNIP.setCurp(trabajador.getDatosCertificables().getCurp());
				datosSolicitaNIP.setNombre(trabajador.getDatosCertificables().getNombre());
				datosSolicitaNIP.setNss(trabajador.getNss());
				
				// Obtener insumo complementario:
				datosSolicitaNIP.setNumeroCelular(complementoBUU.getTelefono());
				datosSolicitaNIP.setCorreo(complementoBUU.getCorreoElectronico());
				
				// Obtener Sucursal:
				EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
				String sucursal = objetoCoppel != null ? objetoCoppel.getNumeroTienda() : ServiciosConstants.SUCURSAL_FOLIO_DEFAULT;
				logger.info("[Controlador][solicitarNip] - consulta:{} - sucursal:{} - datosSolicitaNIP:{}", consulta, sucursal, datosSolicitaNIP);
				
				logger.info("[Controlador][solicitarNip] - No Nulo: {}", (consulta!= null ? consulta.getTimerPicker() : "20210214"));
				// Obtener Nuevo Folio: Generación NIP				
				FolioEntrada folio = obtenerFolio(consulta.getTimerPicker(), user.getDatoUsuario(), 
						datosSolicitaNIP.getCurp(), datosSolicitaNIP.getNss(), sucursal);
				
				request.getSession().setAttribute("folioNip", folio);
				model.addObject("generaNIP", datosSolicitaNIP);
				model.addObject("trabajador", trabajador);
				logger.info("[Controlador][solicitarNip] - Salida a vista: {}", datosSolicitaNIP);
			
			} else {
				model = new ModelAndView("forward:/private/amenu.do");
				model = utileriaConversion.agregarRespuestaModel(model, respuesta);
			}

			model = utileriaConversion.agregarRespuestaModel(model, respuesta);
			
		} catch(Exception e) {
			logger.error("[Controlador][solicitarNip] - Exception al mostrar Datos Generales", e);
			model = new ModelAndView(NavegacionEnum.PRINCIPAL.getNavegacion());
		}
		return model;
	}
	
	
	
	/**
	 * Devuelve el Folio que será asociado a la solicitud de generación del nip
	 * @param tiempoLlegada
	 * @param idUser
	 * @param curp
	 * @param nss
	 * @param sucursal
	 * @return
	 */
	private FolioEntrada obtenerFolio(String tiempoLlegada, Long idUser,
			String curp, String nss, String sucursal) {
		return nipFoliadoService.generarFolio(tiempoLlegada, idUser, curp, nss, sucursal);
		
		// TODO: Descomentar el servicio de Foliado
//		return new FolioEntrada();
	}
}
