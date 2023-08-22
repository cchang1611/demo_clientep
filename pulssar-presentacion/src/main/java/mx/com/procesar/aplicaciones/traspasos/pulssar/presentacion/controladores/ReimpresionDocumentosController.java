package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MenuReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceTramiteImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;



/**
 * Reimpresion Documentos Controller
 * @author jmordone
 *
 */
@Controller
public class ReimpresionDocumentosController extends BaseController {
	
	/**
	 * Logger para el controlador Reimpresion Documentos Controller
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReimpresionDocumentosController.class);
	
	/**
	 * menuReimpresionService
	 */
	@Autowired
	private MenuReimpresionService menuReimpresionService;
	
	/**
	 * reimpresionServiceTramiteImpl
	 */
	@Autowired
	private ReimpresionServiceTramiteImpl reimpresionServiceTramiteImpl;
	
	/**
	 * reimpresionServiceSaldosYMovimientos
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	/**
	 * Direcciona a la pantalla reimpresión del documento
	 * @return
	 */
	@GetMapping(value = "/private/reimpresionDocumento.do")
	public ModelAndView direccionarPantallaReimpresionDocumento(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model= new ModelAndView(NavegacionEnum.MENU_REIMPRESION_DOCUMENTO.getNavegacion());
		try {
			DatosTrabajador trabajador=(DatosTrabajador)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			model.addObject(Constants.MENU_REIMPRESION,menuReimpresionService.obtenerMenuReimpresion());
			model.addObject(Constants.FOLIO, trabajador.getFolio());
			model.addObject(Constants.EXPEDIENTE_B, trabajador.getDatosExpediente());
		}catch(Exception e) {
			LOGGER.error(Constants.ERROR_DIRECCIONAR_PANTALLA_REIMPRESION,e);
		}
		
		return model;
		
	}
	
	/**
	 * Direcciona a la pantalla reimpresión del documento
	 * @return
	 */
	@GetMapping(value = "/private/obtieneArchivosPDFPorTipoTramite.do")
	public ModelAndView obtieneArchivosPDFPorTipoTramite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model= new ModelAndView(NavegacionEnum.TIPO_REIMPRESION_DOCUMENTO.getNavegacion());
		DatosTrabajador trabajador=(DatosTrabajador)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Integer modulo=(Integer)request.getSession().getAttribute(Constants.MODULO_REIMPRESION_SESSION);
		String obtenerDescripcionModulo=MenuReimpresionEnum.obtenerDescripcion(modulo).getDescripcion();
		try {
			DatosArchivos archivos=reimpresionServiceTramiteImpl.obtenerArchivos(trabajador, modulo);
			model.addObject(Constants.ARCHIVOS_REIMPRESION_SESSION, archivos);
			model.addObject(Constants.MODULO_REIMPRESION_SESSION, obtenerDescripcionModulo);
			model.addObject(Constants.ID_MODULO, modulo);
			model.addObject(Constants.FOLIO, trabajador.getFolio());
			model.addObject(Constants.ES_SALDOS, false);
			model.addObject(Constants.EXPEDIENTE_B, trabajador.getDatosExpediente());
			request.getSession().setAttribute(Constants.PDF_REIMPRESION_SESSION, archivos);
		}catch(BusinessException be) {
			model.addObject(Constants.MODULO_REIMPRESION_SESSION, obtenerDescripcionModulo);
			model.addObject(Constants.ID_MODULO, modulo);
			model.addObject(Constants.FOLIO, trabajador.getFolio());
			model.addObject(Constants.ARCHIVOS_REIMPRESION_SESSION, reimpresionTramitesService.obtenerMensajeSinDatos());
			model.addObject(Constants.EXPEDIENTE_B, trabajador.getDatosExpediente());
			LOGGER.error(Constants.ERROR_OBTENER_PDF,be);
			return model;
		}catch(Exception e) {
			model.addObject(Constants.MODULO_REIMPRESION_SESSION, obtenerDescripcionModulo);
			model.addObject(Constants.ID_MODULO, modulo);
			model.addObject(Constants.FOLIO, trabajador.getFolio());
			model.addObject(Constants.ARCHIVOS_REIMPRESION_SESSION, reimpresionTramitesService.obtenerMensajeSinDatos());
			model.addObject(Constants.EXPEDIENTE_B, trabajador.getDatosExpediente());
			LOGGER.error(Constants.ERROR_OBTENER_PDF,e);
		}
		
		return model;
		
	}
	
	
	/**
	 * Direcciona a la pantalla reimpresión del documento
	 * @return
	 */
	@GetMapping(path = "/private/validarArchivoExistente.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarArchivoExistente(HttpServletRequest request,@RequestParam("modulo") Integer modulo) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {	
			request.getSession().setAttribute(Constants.MODULO_REIMPRESION_SESSION, modulo);
			respuesta=menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_CORRECTO_REIMPRESION,Constants.EXITO_REIMPRESION,"");
		}catch(Exception e) {
			LOGGER.error(Constants.ERROR_ARCHIVO_EXISTENTE,e);
			respuesta=menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_INCORRECTO_REIMPRESION,Constants.ERROR_ARCHIVO_EXISTENTE,"");
		}	
		return respuesta;
		
	}
	
	
	/**
	 * enviaCorreoReimpresion
	 * @param request
	 * @param datosUsuario
	 * @return
	 */
	@GetMapping(value = "/private/envioCorreoReimpresionMenu.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio enviaCorreoReimpresionMenu(HttpServletRequest request){   
		DatosTrabajador trabajador=(DatosTrabajador)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		RespuestaServicio respuestaServicio =new RespuestaServicio();
		Integer modulo=(Integer)request.getSession().getAttribute(Constants.MODULO_REIMPRESION_SESSION);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try{
		   DatosArchivos archivos=reimpresionServiceTramiteImpl.obtenerArchivos(trabajador, modulo);			
		   respuestaServicio=reimpresionServiceTramiteImpl.enviarCorreoReimpresion(archivos,trabajador,modulo,archivos.getFolioProcesar(),modulo,user.getUsuario());		
		   return respuestaServicio;
		}catch(BusinessException be) {
			LOGGER.error(Constants.ERROR_ENVIO_DE_CORREO,be);
			return menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_INCORRECTO_NEGOCIO,Constants.ERROR_ENVIO_DE_CORREO,"");	
		}catch(Exception e){
			LOGGER.error(Constants.ERROR_ENVIO_DE_CORREO,e);
			return menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_INCORRECTO_REIMPRESION,Constants.ERROR_ENVIO_DE_CORREO,"");
		}
		
	}
	
	/**
	 * enviaCorreoReimpresion
	 * @param request
	 * @param datosUsuario
	 * @return
	 */
	@GetMapping(value = "/private/envioCorreoReimpresionImpresion.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio enviaCorreoReimpresionImpresion(HttpServletRequest request){   
		DatosArchivos datos=(DatosArchivos)request.getSession().getAttribute(Constants.PDF_REIMPRESION_SESSION);
		DatosTrabajador trabajador=(DatosTrabajador)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		Integer modulo=(Integer)request.getSession().getAttribute(Constants.MODULO_REIMPRESION_SESSION);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try{
			return reimpresionServiceTramiteImpl.enviarCorreoReimpresion(datos,trabajador,modulo, datos.getFolioProcesar() ,modulo,user.getUsuario());
		}catch(BusinessException be) {
			LOGGER.error(Constants.ERROR_ENVIO_DE_CORREO,be);
			return menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_INCORRECTO_NEGOCIO,Constants.ERROR_ENVIO_DE_CORREO,"");	
		}catch(Exception e){
			LOGGER.error(Constants.ERROR_ENVIO_DE_CORREO,e);
			return menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_INCORRECTO_REIMPRESION,Constants.ERROR_ENVIO_DE_CORREO,"");
			
			
		}
		
	}
	
	/**
	 * Direcciona a la pantalla reimpresión del documento
	 * @return
	 */
	@GetMapping(path = "/private/obtieneEmailSolicitante.do", produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio obtieneEmailSolicitante(HttpServletRequest request,@RequestParam("modulo") Integer modulo) {
		RespuestaServicio respuesta = new RespuestaServicio();
		DatosTrabajador trabajador=(DatosTrabajador)request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		try {	
			respuesta=reimpresionServiceTramiteImpl.obtenerExistenciaCorreoElectronico(trabajador,modulo);
			request.getSession().setAttribute(Constants.MODULO_REIMPRESION_SESSION, modulo);
		}catch(Exception e) {
			LOGGER.error(Constants.ERROR_ARCHIVO_EXISTENTE,e);
			respuesta=menuReimpresionService.obtenerRespuestaCorrecta(Constants.FLUJO_INCORRECTO_REIMPRESION,Constants.ERROR_ARCHIVO_EXISTENTE,"");
		}	
		return respuesta;
		
	}
	
	/**
	 * Direcciona a la pantalla reimpresión del documento
	 * @return
	 */
	@GetMapping(path = "/private/guardaBitacoraImpresion.do", produces = { "application/json" })
	@ResponseBody
	public void guardaBitacoraImpresion(HttpServletRequest request,@RequestParam("modulo") Integer modulo) {
		DatosArchivos datos=(DatosArchivos)request.getSession().getAttribute(Constants.PDF_REIMPRESION_SESSION);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try {	
			reimpresionServiceTramiteImpl.guardarBitacoraImpresion(datos, modulo,user.getUsuario());
		}catch(Exception e) {
			LOGGER.error(Constants.ERROR_ARCHIVO_EXISTENTE,e);
		}	
		
	}
	
 
}
