/**
 * ExpedienteIdentificacionMovil.java
 * Fecha de creación: Feb 2, 2021 7:56:39 AM
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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VisorExpedientesIdentificacionMovilService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProcesoExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
@Controller
public class ExpedienteIdentificacionMovil extends BaseController {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExpedienteIdentificacionMovil.class);

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;

	/**
	 * Atributo catalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;
	

	/**
	 * visorExpedientesIdentificacionMovilService
	 */
	@Autowired
	private VisorExpedientesIdentificacionMovilService visorExpedientesIdentificacionMovilService;

	/**
	 * Metodo para mostrar la vista Consulta Expediente
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/private/expedienteIdentificacionMovil.do", method = RequestMethod.GET)
	public ModelAndView mostrarSubMenuConsultaExpediente(HttpServletRequest request, ModelMap map) {
		logger.info("Sub menu de Consulta Expediente");
		ModelAndView model = new ModelAndView(
				NavegacionEnum.SUB_MENU_OPERATIVO_PROCESAR_CONSULTA_EXPEDIENTE.getNavegacion());
		
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		logger.error("Roles {}", user.getRoles());
		List<Rol> lstRoles = user.getRoles();
		String roleActual="";
		
		if (lstRoles != null && !lstRoles.isEmpty()) {
			roleActual = lstRoles.get(0).getDescripcionRol();
			model.addObject("role", roleActual);
		}
		
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		model = utileriaConversion.obtenerImagenNombreUsuario(model, user);
		model.addObject(ServiciosConstants.LISTA_AFORE, null);
		model.addObject("folio", trabajador.getFolio());
		obtenerTipoServicio(roleActual,model);
		
		List<Parametro> parametros = catalogoService.obtenerParametroDdbpose("T00053");
		List<String> idTipoProceso = new ArrayList<>();
		for (Parametro p : parametros) {
			idTipoProceso.add(p.getChValorParametro());
		}
		
		model.addObject("urlSalir", "datosGenerales.do");

		List<TipoProcesoExpediente> lstTipoExpediente = catalogoService.buscarTipoProceso(idTipoProceso);
		logger.info("lstTipoExpediente {}", lstTipoExpediente);
		model.addObject(ServiciosConstants.LISTA_TIPO_EXPEDIENTE, visorExpedientesIdentificacionMovilService.listaExpedienteFiltrada(lstTipoExpediente));
	
		return model;
	}

	
	/**
	 * obtenerTipoServicio
	 * @param roleActual
	 * @return
	 */
	 private void obtenerTipoServicio(String roleActual,ModelAndView model) {	
		if (roleActual.equals(ServiciosConstants.OPERATIVO_PROCESAR)) {
			model.addObject(ServiciosConstants.LISTA_AFORE, catalogoService.obtenerAfores());
		}else {
			model.addObject(ServiciosConstants.LISTA_AFORE, null);
		}
		
	}
}
