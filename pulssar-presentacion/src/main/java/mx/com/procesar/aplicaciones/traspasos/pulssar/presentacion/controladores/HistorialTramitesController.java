package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.HistorialPasosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HistorialTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteCancelacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioProcesoEstatus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroEntrada;

@Controller
public class HistorialTramitesController extends BaseController {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(HistorialTramitesController.class);

	@Autowired
	private HistorialTramitesService service;
	
	/**
	 * disposicionTotalIsssteService
	 */
	@Autowired
	private DisposicionTotalIsssteService disposicionTotalIsssteService;
	
	/**
	 * DisposicionTotalImssService
	 */
	@Autowired
	private DisposicionTotalImssService disposicionTotalImssService;
	
	@GetMapping(value = "/private/historialTramites.do")
	public ModelAndView mostrarHistorialTramites(HttpServletRequest request) {
		ModelAndView mnv = new ModelAndView(NavegacionEnum.HISTORIAL_TRAMITES.getNavegacion());
		logger.info("historial Tramites");
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		
		ArrayList<FolioSalida> folios = (ArrayList<FolioSalida>) service.consultarFoliosPadre(trabajador.getNss(), trabajador.getDatosCertificables().getCurp());
		request.getSession().setAttribute("foliosPadres", folios);
		mnv.addObject("expedienteB", trabajador.getDatosExpediente());
		mnv.addObject("folios", folios);
		return mnv;
	}
	
	@GetMapping(value = "/private/historialTramitesDetalle.do")
	public ModelAndView mostrarHistorialTramitesDetalle(HttpServletRequest request, @RequestParam String id) {
		ModelAndView mnv = new ModelAndView(NavegacionEnum.HISTORIAL_TRAMITES_DETALLE.getNavegacion());
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		logger.info("folio padre alv {}", id);
		mnv.addObject("expedienteB", trabajador.getDatosExpediente());
		List<FolioSalida> folios = service.consultarFolioHijo(id);
		
		//Validar si se realiza la cancelacion para proceso operacion 46 disposicion ISSSTE
		List<FolioSalida> foliosPadres = (List<FolioSalida>) request.getSession().getAttribute("foliosPadres");
		List<DisposicionIsssteCancelacion> listaCancelacion = disposicionTotalIsssteService.validarCancelacion(folios, trabajador,  foliosPadres, id);
		request.getSession().setAttribute("datosCancelacion", listaCancelacion);
		///Se realiza validacion de disposicion IMSS
		List<ParametroEntrada> listaCancelImss =  disposicionTotalImssService.validarCancelacion(folios,  trabajador,
				foliosPadres,  id);
		request.getSession().setAttribute("datosCancelacionImss", listaCancelImss);
		// cveafore clavada para prueba del miercoles valor de la tabla tc_proc_organizacion
		List<FolioProcesoEstatus> grupos = service.consultarGruposEstatus(id, trabajador.getClaveAfore());
		Collections.sort(grupos);
		mnv.addObject("botonCancelacion", disposicionTotalIsssteService.validarDatosCancel(listaCancelacion));
		mnv.addObject("botonCancelacionImss", disposicionTotalImssService.validarDatosCancel(listaCancelImss));
		mnv.addObject("folios", folios);
		mnv.addObject("grupos", grupos);
		mnv.addObject("rojo", HistorialPasosConstants.ROJO);
		mnv.addObject("verde", HistorialPasosConstants.VERDE);
		mnv.addObject("gris", HistorialPasosConstants.GRIS);
		return mnv;
  	}
	
	
	
}