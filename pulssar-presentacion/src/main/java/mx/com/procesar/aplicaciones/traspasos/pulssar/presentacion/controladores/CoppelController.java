/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador pra dispositivos coppel
 * @author dhernand
 *
 */
@Controller
@RequestMapping(value = {"/public"})
public class CoppelController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BienvenidoController.class);

	/**
	 * servicio de 
	 */
	@Autowired
	private CoppelService coppelService;
	
	/**
	 * servicio de catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * utileria encriptacion
	 */
	@Autowired
	private EncriptacionUtils utileriaEncriptacion;
	
	/**
	 * utileria encriptacion
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Key seguridad
	 */
	@Value("${key.seguridad.encriptacion.usuario}")
	private String keySeguridadEncriptacion;
	
	/**
	 * Inyeccion de utileria
	 */
	@Value("${css.configurables}")
	private String cssConfigurable;
	
	/**
	 * Genera la peticion para el padFirma
	 * @return
	 */
	@RequestMapping(value = "/generaPeticionPadFirma.do", method = RequestMethod.GET, produces = { "application/json" })	
	@ResponseBody
	public LinkedHashMap<String,String> pruebaServicioAfore() {
		return coppelService.generarPeticionPadFirma();
	}
	
	/**
	 * Pagina de acceso y consulta Coppel
	 * 
	 * @return
	 */
	@RequestMapping(value = "/accesarConsulta.do", method = RequestMethod.POST)
	public ModelAndView accesoCoppelConsulta(HttpServletRequest request) {
		ModelAndView model = new ModelAndView(NavegacionEnum.LOGOUT_COPPEL.getNavegacion());
		String usuario = "";
		String passDesencriptado = "";
		try {
			RespuestaServicio respuesta = new RespuestaServicio();
			respuesta.setFlujo(NumerosConstants.INT_TRES);
			usuario = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("usuarioNAP"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {}", usuario);
			String password = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("password"), ExpresionesConstants.VACIO);
			logger.info("encriptado {} >>> {}", usuario, password);
			String curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("curp"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> curp {}", usuario, curp);
			String nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("nss"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> nss {}", usuario, nss);
			String tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("tipoSolicitante"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> tipoSolicitante {}", usuario, tipoSolicitante);
			String timePicker = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("tiempoEspera"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> tiempoEspera {}", usuario, timePicker);
			String idSesion = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("idSesion"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> idSesion {}", usuario, idSesion);
			String direccionUrl = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("direccionUrl"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> direccionUrl {}", usuario, direccionUrl);
			String numTienda = utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("numTienda"), ExpresionesConstants.VACIO);
			logger.info("usuarioNAP {} >>> numTienda {}", usuario, numTienda);
			
			Map<String, String> mapaDatosCoppelRedirect = new HashMap<>();
			mapaDatosCoppelRedirect.put("urlCoppel", direccionUrl);
			mapaDatosCoppelRedirect.put("curp", curp);
			mapaDatosCoppelRedirect.put("nss", nss);
			mapaDatosCoppelRedirect.put("idSesion", idSesion);
			mapaDatosCoppelRedirect.put("opcion", NumerosConstants.C_DOS);
			model.addAllObjects(mapaDatosCoppelRedirect);
			
			coppelService.validarDatosObligatoriosConsulta(usuario, curp, nss, tipoSolicitante, timePicker);
			
			EntradaConsulta consulta = coppelService.validarDatosCurpSolicitante(tipoSolicitante, 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("curpSolicitante"), ExpresionesConstants.VACIO), 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("nombre"), ExpresionesConstants.VACIO), 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("apePaterno"), ExpresionesConstants.VACIO), 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(request.getParameter("apeMaterno"), ExpresionesConstants.VACIO));
			consulta.setCurp(curp);
			consulta.setNss(nss);
			consulta.setCvTipoSolicitante(tipoSolicitante);
			consulta.setTimerPicker(timePicker);
			logger.info("Entrada Coppel Consulta: {}", consulta);
			
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_VALIDA_COPPEL);
			String valor = utileriaValidador.obtenerValorParametro(listaParametro, PdfConstants.COPPEL, NumerosConstants.C_CERO);
			if(NumerosConstants.C_UNO.equals(valor)) {
				model.addObject("bFinaliza", "1");
				request.getSession().setAttribute(ParametrosConstants.REDIRECCION_COPPEL_PORTAL, mapaDatosCoppelRedirect);
				coppelService.validarDatosObligatoriosCoppel(idSesion, direccionUrl, numTienda);
				
				EntradaCoppel extrasCoppel = new EntradaCoppel();
				extrasCoppel.setIdSession(idSesion);
				extrasCoppel.setDireccionUrl(direccionUrl);
				extrasCoppel.setNumeroTienda(numTienda);
				logger.info("Entrada Coppel Extras: {}", extrasCoppel);
				request.getSession().setAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL, extrasCoppel);
			}
			
			request.getSession().setAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL, consulta);
			passDesencriptado = utileriaEncriptacion.obtieneDesencriptacion(password, keySeguridadEncriptacion);
			
			model = new ModelAndView(NavegacionEnum.LOGIN_COPPEL.getNavegacion());
			model.addObject("usuario", usuario);
			model.addObject("pass", passDesencriptado);
		} catch (BusinessException be) {
			logger.error("Error en el login de coppel", be);
			model.addObject("codigo", be.getMessage());
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, PdfConstants.COPPEL);
		} catch(GenericException ge) {
			logger.error("Error en la desencriptacion de password", ge);
			model.addObject("codigo", ge.getMessage());
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, PdfConstants.COPPEL);
		}
		
		request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
		
		return model;
	}
}
