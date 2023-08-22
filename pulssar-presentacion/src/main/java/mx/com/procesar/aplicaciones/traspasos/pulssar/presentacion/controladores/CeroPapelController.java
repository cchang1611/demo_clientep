package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionCeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 *Cero papel
 * @author RARREOLA
 *
 */
@Controller
public class CeroPapelController {
	
	/**
	 * Logger;
	 */
	private static final Logger logger = LoggerFactory.getLogger(CeroPapelController.class);
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * CeroPapelService
	 */
	@Autowired
	private CeroPapelService ceroPapelService;
	
	/**
	 * NotificacionCeroPapelService
	 */
	@Autowired
	private NotificacionCeroPapelService notificacionCeroPapelService;
	
	/**
	 * Inyeccion de servicio folio
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Vista consulta estatus cero papel
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultaEstatusCeroPapel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio consultaEstatusCeroPapel(HttpServletRequest request) {
		logger.info("Inicio consulta estatus cero papel");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			ceroPapelService.consultaEstatusCeroPapel(trabajador.getProcesar());
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al consultar el estatus de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Cancelar estatus
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/activarEstatusCeroPapel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio activarEstatusCeroPapel(HttpServletRequest request) {
		logger.info("Inicio activar estatus cero papel");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CONFIRMACION_CERO_PAPEL.getClave(), user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al activar el estatus de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a  consultar", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Cancelar estatus
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/guardarActivoEstatusCeroPapel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio guardarActivoEstatusCeroPapel(HttpServletRequest request) {
		logger.info("Inicio guardar estatus cero papel");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			Folio folio = generarFolioCeroPapel(trabajador.getDatosCertificables().getCurp(), trabajador.getNss(), ServiciosConstants.DESCRIPCION_ACTIVA_CERO_PAPEL, user.getDatoUsuario());
			
			EntradaCeroPapel entradaCeroPapel = new EntradaCeroPapel();
			
			entradaCeroPapel.setAfore(user.getAforeUsuario());
            entradaCeroPapel.setClaveAgente(user.getUsuario());
            entradaCeroPapel.setCorreoElectronico(trabajador.getDatosComplementarios().getCorreoElectronico());
            entradaCeroPapel.setCurp(trabajador.getDatosCertificables().getCurp());
            entradaCeroPapel.setFolioCeroPapel(folio.getChFolio());
            entradaCeroPapel.setIdentificadorUsuario(user.getDatoUsuario());
            entradaCeroPapel.setIdProcesar(trabajador.getProcesar());
            entradaCeroPapel.setNss(trabajador.getNss());
            entradaCeroPapel.setNuEstatusCeroPapel(ActivacionConstants.UNO);
            entradaCeroPapel.setNuNotificado(NumerosConstants.INT_CERO);
            
            Long idCeroPapel = ceroPapelService.guardarDatosCeroPapel(entradaCeroPapel);
            entradaCeroPapel.setIdCeroPapel(idCeroPapel);
			request.getSession().setAttribute(ParametrosConstants.VALOR_PAPERLESS_JSP, ParametrosConstants.ACTIVO_PAPERLESS);
			respuesta.setDatos(ParametrosConstants.ACTIVO_PAPERLESS);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CORREO_ACTUAL_CERO_PAPEL.getClave(), user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
			notificacionCeroPapelService.guardarDatosNotificacionCeroPapel(entradaCeroPapel, trabajador.getTipoAfiliacion());
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al guardar el estatus de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de realizar la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * 
	 * @return
	 */
	private Folio generarFolioCeroPapel(String curp, String nss, String descripcion, Long idUsuario) {
		FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(curp, nss, descripcion, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
		return servicioFolio.obtenerFolio(folioEntrada, idUsuario, ServiciosConstants.SUCURSAL_FOLIO_DEFAULT, ServiciosConstants.FOLIO_SERVICIO_CERO_PAPEL, ServiciosConstants.FOLIO_PROCESO_CERO_PAPEL);
	}
	
	
	/**
	 * Cancelar estatus
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/mostrarCorreoCeroPapel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio mostrarCorreoCeroPapel(HttpServletRequest request) {
		logger.info("Inicio mostrar correo");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS);
			if(Strings.isNotBlank(trabajador.getDatosComplementarios().getCorreoElectronico())) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CORREO_ACTUAL_CERO_PAPEL.getClave(), user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
				respuesta.setDatos(trabajador.getDatosComplementarios().getCorreoElectronico());
			} else {
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SIN_CORREO_ACTUAL_CERO_PAPEL.getClave(), user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
				respuesta.setDatos("noCorreo");
			}
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al consultar el correo de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a realizar la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Cancelar estatus
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/cancelarEstatusCeroPapel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio cancelarEstatusCeroPapel(HttpServletRequest request) {
		logger.info("Inicio cancelar estatus cero papel");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CANCELAR_CERO_PAPEL.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_UNO, null);
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al cancelar el estatus de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un detalle al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		
		return respuesta;
	}
	
	
	
	/**
	 * Cancelar estatus
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/guardarCanceladoEstatusCeroPapel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio guardarCanceladoEstatusCeroPapel(HttpServletRequest request) {
		logger.info("Inicio cancelar estatus cero papel");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		
		try {
			user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			
			Folio folio = generarFolioCeroPapel(trabajador.getDatosCertificables().getCurp(), trabajador.getNss(), ServiciosConstants.DESCRIPCION_CANCELA_CERO_PAPEL, user.getDatoUsuario());

            EntradaCeroPapel entradaCeroPapel = new EntradaCeroPapel();
			
            entradaCeroPapel.setAfore(user.getAforeUsuario());
            entradaCeroPapel.setClaveAgente(user.getUsuario());
            entradaCeroPapel.setCorreoElectronico(trabajador.getDatosComplementarios().getCorreoElectronico());
            entradaCeroPapel.setCurp(trabajador.getDatosCertificables().getCurp());
            entradaCeroPapel.setFolioCeroPapel(folio.getChFolio());
            entradaCeroPapel.setIdentificadorUsuario(user.getDatoUsuario());
            entradaCeroPapel.setIdProcesar(trabajador.getProcesar());
            entradaCeroPapel.setNss(trabajador.getNss());
            entradaCeroPapel.setNuEstatusCeroPapel(ActivacionConstants.CERO);
            entradaCeroPapel.setNuNotificado(NumerosConstants.INT_CERO);
            logger.info("Guardar objeto cero papel");
			Long idCeroPapel = ceroPapelService.guardarDatosCeroPapel(entradaCeroPapel);
			entradaCeroPapel.setIdCeroPapel(idCeroPapel);
			request.getSession().setAttribute(ParametrosConstants.VALOR_PAPERLESS_JSP, ParametrosConstants.INACTIVO_PAPERLESS);
			respuesta.setDatos(ParametrosConstants.INACTIVO_PAPERLESS);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			logger.info("Se lanza la notificacion");
			notificacionCeroPapelService.guardarDatosNotificacionCeroPapel(entradaCeroPapel, trabajador.getTipoAfiliacion());
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al guardar el estatus cancelado de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un error al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}

}
