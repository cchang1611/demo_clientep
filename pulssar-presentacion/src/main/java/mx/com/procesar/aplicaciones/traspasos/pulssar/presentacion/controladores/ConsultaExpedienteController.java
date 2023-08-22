/**
 * ConsultaExpedienteController.java
 * Fecha de creación: Jan 11, 2021 8:30:35 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.OperativoProcesarConstants.URI_ROL_AUTENTICADO_OPERATIVO_PROCESAR;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidaActividadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VisorExpedientesIdentificacionMovilService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleExpedientes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Imagen;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaConsultaVisorExpedienteMovil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProcesoExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.DesCompresorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
@Controller
@RequestMapping(value = { URI_ROL_AUTENTICADO_OPERATIVO_PROCESAR, "/private" })
public class ConsultaExpedienteController extends BaseController {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaExpedienteController.class);

	/**
	 * Atributo validadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;

	/**
	 * Atributo validaActividadService
	 */
	@Autowired
	private ValidaActividadService validaActividadService;

	/**
	 * Atributo visorExpedientesIdentificacionMovilService
	 */
	@Autowired
	private VisorExpedientesIdentificacionMovilService visorExpedientesIdentificacionMovilService;

	/**
	 * Atributo desCompresorUtils
	 */
	@Autowired
	private DesCompresorUtils desCompresorUtils;

	/**
	 * Atributo catalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * @param request
	 * @param map
	 * @param consultaExpediente
	 * @return
	 */
	@RequestMapping(value = "/consultaExpediente.do", method = RequestMethod.POST)
	public ModelAndView consultaExpediente(HttpServletRequest request, ConsultaExpediente consultaExpediente) {
		ModelAndView salida = new ModelAndView(
				NavegacionEnum.SUB_MENU_OPERATIVO_PROCESAR_CONSULTA_EXPEDIENTE.getNavegacion());
		try {
			String roleActual = "";
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			logger.error("Roles :{}", user.getRoles());
			List<Rol> lstRoles = user.getRoles();

			if (lstRoles != null && !lstRoles.isEmpty()) {
				roleActual = lstRoles.get(0).getDescripcionRol();
				salida.addObject("role", roleActual);
			}

			DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS);
			if (trabajador != null) {
				logger.info("Datos del trabajador Afore {} Curp {}", trabajador.getClaveAfore(),
						trabajador.getDatosCertificables().getCurp());
				salida.addObject("folio", trabajador.getFolio());
				consultaExpediente.setAfore(trabajador.getClaveAfore());
				consultaExpediente.setCurp(trabajador.getDatosCertificables().getCurp());
			}

			// Validar roles
			String tipoServicio = "02";
			salida.addObject("urlSalir", "datosGenerales.do");
			logger.error("Role {}", roleActual);
			if ("OPERATIVO PROCESAR".equals(roleActual)) {
				tipoServicio = "03";
				salida.addObject("urlSalir", "menu.do");
				salida.addObject("lstAfore", catalogoService.obtenerAfores());
			}

			List<Parametro> parametros = catalogoService.obtenerParametroDdbpose("T00053");
			List<String> idTipoProceso = new ArrayList<>();
			for (Parametro p : parametros) {
				idTipoProceso.add(p.getChValorParametro());
			}

			List<TipoProcesoExpediente> lstTipoExpediente = catalogoService.buscarTipoProceso(idTipoProceso);
			logger.info("lstTipoExpediente {}", lstTipoExpediente);
			salida.addObject("lstTipoExpediente", lstTipoExpediente);

			// Validaciones
			if (consultaExpediente == null || validadorUtils.validarVacio(consultaExpediente.getAfore())
					|| validadorUtils.validarVacio(consultaExpediente.getCurp())
					|| validadorUtils.validarVacio(consultaExpediente.getTipoExpediente())) {
				throw new BusinessException(
						"La captura/selección de todos los criterios de búsqueda es obligatoria, favor de validar.");
			}

			if (!new Integer(18).equals(consultaExpediente.getCurp().length())) {
				throw new BusinessException("La CURP debe encontrarse a 18 posiciones, favor de validar.");
			}

			// Validar horario de servicio
			String enServicio = validaActividadService.validarActividadServicio("P02011", new Date());
			if ("0".equals(enServicio)) {
				throw new BusinessException("Solicitud fuera del horario de servicio.");
			}

			// Consulta de servicio
			byte[] archivoZip = visorExpedientesIdentificacionMovilService.consultaExpediente(
					tipoServicio, 
					consultaExpediente.getAfore(), consultaExpediente.getCurp(),
					consultaExpediente.getTipoExpediente());

			// Descomprimir
			Map<String, byte[]> lstDocumentos = desCompresorUtils.descomprimirMultipart(archivoZip);

			// Agregar al modelo
			salida.addObject("imagenesDoc", visorExpedientesIdentificacionMovilService.generarComboDocumentos(lstDocumentos));
			salida.addObject("mostrarModalCarrusel", Boolean.TRUE);
		} catch (BusinessException e) {
			logger.error("Error en la pantalla inicial", e);
			salida.addObject(Constants.ERROR, e.getMessage());
			RespuestaServicio respuesta = new RespuestaServicio();
			respuesta.setTitulo("");
			respuesta.setMensaje(e.getMessage());
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			salida.addObject("respuesta", respuesta);
		}

		return salida;
	}


	/**
	 * @param request
	 * @param map
	 * @param consultaExpediente
	 * @return
	 */
	@RequestMapping(value = "/consultaExpedienteDinamico.do", method = RequestMethod.GET)
	public ModelAndView consultarExpedientesDinamico(HttpServletRequest request,@RequestParam(value="afore",required= false) String afore,
			@RequestParam(value="curp",required= false) String curp,@RequestParam(value="tipoExpediente",required= false) String tipoExpediente) {
		ModelAndView salida = new ModelAndView(
				NavegacionEnum.VISOR_EXPEDIENTES.getNavegacion());
		ConsultaExpediente consultaExpediente= new ConsultaExpediente();
		try {
			
			String roleActual = "";
			String claveRol = "";
			String tipoServicio=null;
			
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			logger.error("Roles :{}", user.getRoles());
			List<Rol> lstRoles = user.getRoles();

			if (lstRoles != null && !lstRoles.isEmpty()) {
				roleActual = lstRoles.get(0).getDescripcionRol();
				claveRol=lstRoles.get(0).getClaveRol();
				salida.addObject(ServiciosConstants.PARAMETRO_ROL, roleActual);
				salida.addObject(ServiciosConstants.BANDERA_CLAVE_ROL, claveRol.equals(ServiciosConstants.CLAVE_OPERATIVO_CORE)?Boolean.TRUE:Boolean.FALSE);
			}
			consultaExpediente.setAfore(afore);
			consultaExpediente.setCurp(curp);
			consultaExpediente.setTipoExpediente(tipoExpediente);
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
					.getAttribute(ParametrosConstants.REQUEST_DATOS);
			llenarTrabajador(trabajador, consultaExpediente,salida);
			visorExpedientesIdentificacionMovilService.validaCamposExpediente(consultaExpediente.getAfore(),consultaExpediente.getCurp(),consultaExpediente.getTipoExpediente());
			tipoServicio=visorExpedientesIdentificacionMovilService.obtenerTipoServicio(claveRol);
			SalidaConsultaVisorExpedienteMovil salidaConsultaVisorExpedienteMovil = visorExpedientesIdentificacionMovilService.obtenerExpedientes(
					tipoServicio, 
					consultaExpediente.getAfore(), consultaExpediente.getCurp(),
					consultaExpediente.getTipoExpediente(),null);

			List<DetalleExpedientes> listaDetalle=visorExpedientesIdentificacionMovilService.obtenerListaDetalle(salidaConsultaVisorExpedienteMovil);
			List<Imagen> listaImagenes=visorExpedientesIdentificacionMovilService.obtenerListaImagenes(salidaConsultaVisorExpedienteMovil.getArchivo());
			visorExpedientesIdentificacionMovilService.validarListaImagenes(listaImagenes, listaDetalle);
			String descipcionExpediente=visorExpedientesIdentificacionMovilService.obtenerNombreExpediente(tipoExpediente);
			llenarModelo(listaImagenes, salida, listaDetalle, consultaExpediente, tipoServicio,descipcionExpediente);
			} catch (Exception e) {
				logger.error("Error en consultaExpedienteDinamico", e);
				if(ServiciosConstants.MENSAJE_CAPTURA.equals(e.getMessage()) || ServiciosConstants.MENSAJE_CURP.equals(e.getMessage()) 
						|| ServiciosConstants.MENSAJE_SOLICITUD_FUERA_SERVICIO.equals(e.getMessage())) {
					salida.addObject(ServiciosConstants.PARAMETRO_MENSAJE_CAPTUAR, Boolean.TRUE);
				}else {
					salida.addObject(ServiciosConstants.PARAMETRO_MENSAJE_CAPTUAR, Boolean.FALSE);
				}
				salida.addObject(ServiciosConstants.PARAMETRO_BANDERA_ERROR, Boolean.TRUE);
				salida.addObject(Constants.ERROR, e.getMessage());
				RespuestaServicio respuesta = new RespuestaServicio();
				respuesta.setTitulo(ServiciosConstants.MENSAJE_ERROR);
				respuesta.setMensaje(e.getMessage());
				respuesta.setFlujo(NumerosConstants.INT_UNO);
				salida.addObject(ServiciosConstants.RESPUESTA, respuesta);
				
			}

		return salida;
	}
	
	

	
	/**
	 * @param request
	 * @param map
	 * @param consultaExpediente
	 * @return
	 */
	@GetMapping(value = "/consultaExpedientesClaveDocumento.do",  produces = { "application/json" })
	@ResponseBody
	public SalidaConsultaVisorExpedienteMovil consultarExpedientesPorClaveDocumento(HttpServletRequest request, @RequestParam("cvTipoProceso") String cvTipoProceso, 
			@RequestParam("chFechaOperacion") String chFechaOperacion,@RequestParam("afore") String afore,@RequestParam("curp") String curp,@RequestParam("tipoServicio") String tipoServicio) {
		SalidaConsultaVisorExpedienteMovil salidaConsultaVisorExpedienteMovil=null;
		try {
			
			UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
			logger.error("Roles {}", user.getRoles());

			salidaConsultaVisorExpedienteMovil = visorExpedientesIdentificacionMovilService.obtenerExpedientes(tipoServicio, afore, curp,cvTipoProceso,chFechaOperacion);
			Map<String, byte[]> lstDocumentos = desCompresorUtils.descomprimirMultipart(salidaConsultaVisorExpedienteMovil.getArchivo());	
			List<Imagen> listaImagenes=visorExpedientesIdentificacionMovilService.generarComboDocumentos(lstDocumentos);
			salidaConsultaVisorExpedienteMovil.setListaImagenes(listaImagenes);
			salidaConsultaVisorExpedienteMovil.setNombreExpediente(visorExpedientesIdentificacionMovilService.obtenerNombreExpediente(cvTipoProceso.trim()));
			} catch (Exception e) {
				logger.error("Error consultarExpedientesPorClaveDocumento :",e);
				salidaConsultaVisorExpedienteMovil= new SalidaConsultaVisorExpedienteMovil();
				salidaConsultaVisorExpedienteMovil.setMensajeError(e.getMessage());
				return salidaConsultaVisorExpedienteMovil;	
			}

		return salidaConsultaVisorExpedienteMovil;
	}

	
	/**
	 * llenarTrabajador
	 * @param trabajador
	 * @param consultaExpediente
	 * @param salida
	 */
	private void  llenarTrabajador(DatosTrabajador trabajador,ConsultaExpediente consultaExpediente,ModelAndView salida) {
		if (trabajador != null) {
			logger.info("Datos del trabajador Afore {} Curp {}", trabajador.getClaveAfore(),
					trabajador.getDatosCertificables().getCurp());
			salida.addObject(ServiciosConstants.PARAMETRO_FOLIO, trabajador.getFolio());
			consultaExpediente.setAfore(trabajador.getClaveAfore());
			consultaExpediente.setCurp(trabajador.getDatosCertificables().getCurp());
		}
	}
	
	
	/**
	 * llenarModelo
	 * @param listaImagenes
	 * @param salida
	 * @param listaDetalle
	 * @param afore
	 * @param curp
	 * @param tipoServicio
	 */
	private void llenarModelo(List<Imagen> listaImagenes,ModelAndView salida,List<DetalleExpedientes> listaDetalle,ConsultaExpediente consultaExpediente,String tipoServicio,String descipcionExpediente){
		if(!listaImagenes.isEmpty()) {	
			salida.addObject(ServiciosConstants.PARAMETRO_LISTA_IMAGENES, visorExpedientesIdentificacionMovilService.convertirObjetoJson(listaImagenes));
			salida.addObject(ServiciosConstants.PARAMETRO_ACTIVA_CARRUSEL_UNO, Boolean.TRUE);
			salida.addObject(ServiciosConstants.NOMBRE_EXPEDIENTE, descipcionExpediente);
		}else {
			salida.addObject(ServiciosConstants.PARAMETRO_ACTIVA_CARRUSEL_UNO, Boolean.FALSE);
		}
		if(!listaDetalle.isEmpty()) {
			salida.addObject(ServiciosConstants.PARAMETRO_ACTIVA_CARRUSEL_DOS, Boolean.TRUE);
			salida.addObject(ServiciosConstants.PARAMETRO_LISTA_EXPEDIENTES,listaDetalle);
		}else {
			salida.addObject(ServiciosConstants.PARAMETRO_ACTIVA_CARRUSEL_DOS, Boolean.FALSE);
		}
		
		salida.addObject(ServiciosConstants.PARAMETRO_AFORE,consultaExpediente.getAfore());
		salida.addObject(ServiciosConstants.PARAMETRO_CURP,consultaExpediente.getCurp());
		salida.addObject(ServiciosConstants.PARAMETRO_TIPO_SERVICIO,tipoServicio);
		salida.addObject(ServiciosConstants.PARAMETRO_BANDERA_ERROR, Boolean.FALSE);
		
	}
	
	
}