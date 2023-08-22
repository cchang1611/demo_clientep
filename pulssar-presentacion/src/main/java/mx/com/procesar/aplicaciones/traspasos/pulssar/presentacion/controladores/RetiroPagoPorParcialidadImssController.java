package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.NotificacionParcialidadIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RetiroParcialCalculoImssList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ActualizaEstatusParcialidadesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPagoParcialidadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionPagoParcialidadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parcialidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroParcialCalculoImssSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Servicio para obtener los pagos por parcialidades
 * @author ANOSORIO
 *
 */
@Controller
public class RetiroPagoPorParcialidadImssController extends BaseController{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetiroPagoPorParcialidadImssController.class);

	/**
	 * Inyeccion pagoParcialidadService
	 */
	@Autowired
	private ConsultarPagoParcialidadService pagoParcialidadService; 

	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	@Autowired
	private FechaUtils fechasUtils;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;

	/**
	 * servicio de catalogos
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * Inyeccion notificacionService
	 */
	@Autowired
	private NotificacionPagoParcialidadService notificacionService;

	/**
	 * Inyeccion actualizaEstatusServcie
	 */
	@Autowired
	private ActualizaEstatusParcialidadesService actualizaEstatusServcie;
	
  	/**
	 * Inyeccion rechazoService
	 */
	@Autowired
	private RechazoService rechazoService;
			
	/**
	 * Metodo para obtener los pagos por Parcialidades
	 * @param request
	 * @param map
	 * @param mensaje
	 * @return
	 */
	@GetMapping(value="/private/pagoPorParcialidad.do")
	public ModelAndView pagoPorParcialidad(HttpServletRequest request, ModelMap map, @ModelAttribute String mensaje) {
		ModelAndView modelAndView;  
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(usuarioLogin.getDatoUsuario());
		folio.setOperacion("S");
		folio.setServicio("S12");
		folio.setProceso("S12P1");
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada("00:00");
		folio.setOrigen("O");
		folio.addFolios(trabajador.getFolio().getFolio());
		RetiroParcialCalculoImssList listaParcialidades= new RetiroParcialCalculoImssList();
		List<RetiroParcialCalculoImssSalida> listaSalida;
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try {	 
			listaParcialidades = pagoParcialidadService.consultarPagoParcialidades(trabajador.getProcesar().toString());
			List<Parametro> listaControlInstitucionBancaria = catalogoService.obtenerParametroDdbpose(Constants.T00003);
			Long idProcessar=trabajador.getProcesar();
			listaSalida = validarConsultarParcialidades(listaParcialidades,map);
			String nombreBanco=null;
			String idNombreBanco=null;
			for (Parametro parametro : listaControlInstitucionBancaria) {
				if(listaSalida.get(0).getCuentaClabe().substring(0, 3).contains(parametro.getChParametro())) {
					idNombreBanco= parametro.getChParametro();
					nombreBanco = parametro.getChValorParametro();
				}
			}
			if(utileriaValidador.isEmpty(listaSalida)){
				logger.error("Error,no existen datos en la consulta de pagos parcialidades");
			}
			List<Parametro> formasPago = catalogoService.obtenerParametroDdbpose(Constants.T00005);
			String formaDePago=null;	
			String idFormaPago=null;
			for (Parametro parametro : formasPago) {
				if(listaSalida.get(0).getFormaPago().contains(parametro.getChParametro())) {
					idFormaPago = parametro.getChParametro();
					formaDePago = parametro.getChValorParametro();
				}
			}
			FolioEntrada folioRespuesta = folioService.generarFolio(folio);
			request.getSession().setAttribute("folioRespuesta",folioRespuesta);
			map.addAttribute("folio", folioRespuesta);
			map.addAttribute("formasPago", formasPago);
			map.addAttribute("formaDePago", formaDePago);
			map.addAttribute("nombreBanco", nombreBanco);
			map.addAttribute("idProcessar", idProcessar);
			map.addAttribute("idFormaPago", idFormaPago);
			map.addAttribute("idNombreBanco", idNombreBanco);
			logger.info("PAGO POR PARCIALIDAD {}", mensaje);
			modelAndView = new ModelAndView(NavegacionEnum.PAGO_POR_PARCIALIDAD.getNavegacion());
			modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, usuarioLogin);
		}catch (Exception e) {
			logger.error("error en pago por parcialidad", e);
			map.addAttribute("error", e.getMessage());
			modelAndView = new ModelAndView(NavegacionEnum.VENTANA_CONFIRMACION.getNavegacion());
			respuestaServicio.setFlujo(3);
			respuestaServicio.setTitulo("CONSULTA PARCIALIDADES ");
			respuestaServicio.setMensaje("NO EXISTEN PARCIALIDADES A PAGAR ");
		}   
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuestaServicio);
		return modelAndView;

	}

   

	/**
	 * Metodo para obtener la descripcion del estatus
	 *  1.-ACTIVO
	 * 2.-PAGADO
	 * 3.-TRANSITORIO
	 * 4.-CANCELADO
	 * .-POR PAGAR
	 * .-PENDIENTE
	 * @param salida
	 * @param pagosParcial
	 * @return
	 */
	private String validarEstatus(RetiroParcialCalculoImss pagosParcial) {
		String resultado=null;
		if(!utileriaValidador.validarObjetoNulo(pagosParcial.getEstatus())) {
			if(ActivacionConstants.CERO_CANCELADO.equals(pagosParcial.getEstatus())){
				resultado =ActivacionConstants.CANCELADO;
			}else if(ActivacionConstants.UNO_ACTIVO.equals(pagosParcial.getEstatus())){
				resultado =ActivacionConstants.ACTIVO;
			}else if(ActivacionConstants.DOS_PAGADO.equals(pagosParcial.getEstatus())){
				resultado =ActivacionConstants.PAGADO;
			}else if(ActivacionConstants.TRES_TRANSITORIO.equals(pagosParcial.getEstatus())){
				resultado =ActivacionConstants.TRANSITORIO;
			}
		}
		return resultado;

	}

	/**
	 * Metodo para realizar la Notificacion Pago Parcial
	 * @param request
	 * @param map
	 * @return
	 */
	@PostMapping(value="/private/notificacionParcialidad.do")
	public ModelAndView notificacionParcialidad(HttpServletRequest request, ModelMap map) {
		ModelAndView modelAndView;  
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin usuarioLogin = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		FolioEntrada folioEntrada = (FolioEntrada) request.getSession().getAttribute(ParametrosConstants.SESSION_FOLIORESPUESTA);
		StringBuilder cadena = new StringBuilder();
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss = obtenerParametrosEntrada(request);
		RetiroParcialCalculoImssList listaParcialidades= new RetiroParcialCalculoImssList();
		RetiroParcialCalculoImssSalida salida = new RetiroParcialCalculoImssSalida();
		List<RetiroParcialCalculoImssSalida> listaSalida;
		List<String> listaDes= new ArrayList<>();
		List<Parametro> listaControlInstitucionBancaria = new ArrayList<>();
		Integer numeroParcialidad = 0;
		String cuenta=null;
		Long idProcessar=null;
		String numResolucion = request.getParameter("numeroResolucionParcial");
		String numParcialPorPagar =request.getParameter(ParametrosConstants.PARCIAL_POR_PAGAR); 
		Parcialidad parcialidad = new Parcialidad();
		RechazoPulssar rechazo = new RechazoPulssar();
		NotificacionParcialidadIssste notificacionParcialIssste = new NotificacionParcialidadIssste();
		notificacionParcialIssste.setAfore(trabajador.getClaveAfore());
		notificacionParcialIssste.setClaveBanco(parametrosRetiroParcialCalculoImss.getCuentaClabe().substring(0, 3));
		notificacionParcialIssste.setCurp(trabajador.getDatosCertificables().getCurp());
		notificacionParcialIssste.setDescDiagnosticoRecepcion("");
		notificacionParcialIssste.setDiagnosticoRecepcion("");
		notificacionParcialIssste.setFechaControl(new Date());
		notificacionParcialIssste.setFechaNotificado(new Date());
		notificacionParcialIssste.setFolio(trabajador.getFolio().getFolio());
		notificacionParcialIssste.setFolioAdministradora("");
		notificacionParcialIssste.setNotificado(new BigDecimal(1)); 
		notificacionParcialIssste.setNss(trabajador.getNss());
		notificacionParcialIssste.setNumeroCuenta(parametrosRetiroParcialCalculoImss.getCuenta());
		notificacionParcialIssste.setNumeroResolucion(numResolucion);
		notificacionParcialIssste.setNumParcialidades(new BigDecimal(numParcialPorPagar)   );
		notificacionParcialIssste.setUsuarioModificador(usuarioLogin.getRoles().get(0).getDescripcionRol());
		notificacionParcialIssste.setCuentaClabe(parametrosRetiroParcialCalculoImss.getCuentaClabe());
		notificacionParcialIssste.setResultadoOperacion(ActivacionConstants.RESULTADO_RESPUESTA_01);
		logger.info("notificacionParcialIssste:{}",notificacionParcialIssste);
		try {
			 HttpStatus notificacion = notificacionService.notificarPagoParcialidad(notificacionParcialIssste);
			 logger.info("Respuesta Notificacion:{}",notificacion);
			listaControlInstitucionBancaria = catalogoService.obtenerParametroDdbpose(Constants.T00003);
			idProcessar=trabajador.getProcesar();
			rechazo = rechazoService.obtenerRechazo(Constants.PARAMETRO_PARCIAL,trabajador.getClaveAfore());
			if(ActivacionConstants.RESULTADO_RESPUESTA_200OK == notificacion.value()) {
				folioService.cerrarFolio(folioEntrada.getIdFolio(), 3);
				request.getSession().removeAttribute(ParametrosConstants.SESSION_FOLIORESPUESTA);
				logger.info("!!Cerro el folio correcto!!!");
				parcialidad.setIdProcesar(parametrosRetiroParcialCalculoImss.getIdProcesar());
				parcialidad.setEstatusBuscar(1);
				parcialidad.setEstatus(2);
				parcialidad.setNumeroParcialidad(new Integer(numParcialPorPagar));
				actualizaEstatusServcie.actualizarEstatusParcialidad(parcialidad);
				logger.info("LOS PAGOS SE APLICARON CORRECTAMENTE DE LAS PARCIALIDADES");
				respuestaServicio.setFlujo(1);
				cadena.append("SU FOLIO DE ATENCIÓN ES  <br>").append(folioEntrada.getFolio()).append("<br>");
				cadena.append(rechazo.getMensaje());
				respuestaServicio.setTitulo(rechazo.getTituloMensaje());
				respuestaServicio.setMensaje(cadena.toString());
				listaParcialidades = pagoParcialidadService.consultarPagoParcialidades(trabajador.getProcesar().toString());
				listaSalida = validarConsultarParcialidades(listaParcialidades,map);
			} else {
				folioService.cerrarFolio(folioEntrada.getIdFolio(), 2);
				request.getSession().removeAttribute(ParametrosConstants.SESSION_FOLIORESPUESTA);
				respuestaServicio.setFlujo(2);
				respuestaServicio.setTitulo("NOTIFICACION PARCIAL");
				respuestaServicio.setMensaje("OCURRIO UN RECHAZO EN LA NOTIFICACION PARCIAL");
				listaParcialidades = pagoParcialidadService.consultarPagoParcialidades(trabajador.getProcesar().toString());
				listaSalida = validarConsultarParcialidades(listaParcialidades,map);
				logger.info("OCURRIO UN RECHAZO EN LA NOTIFICACION PARCIAL");
			}
			List<Parametro> formasPago = catalogoService.obtenerParametroDdbpose(Constants.T00005);
			String formaDePago=null;	
			String idFormaPago=null;
			for (Parametro parametro : formasPago) {
				if(listaSalida.get(0).getFormaPago().contains(parametro.getChParametro())) {
					idFormaPago = parametro.getChParametro();
					formaDePago = parametro.getChValorParametro();
				}

			}
			String nombreBanco=null;
			String idNombreBanco=null;
			for (Parametro parametro : listaControlInstitucionBancaria) {
				if(listaSalida.get(0).getCuentaClabe().substring(0, 3).contains(parametro.getChParametro())) {
					idNombreBanco= parametro.getChParametro();
					nombreBanco = parametro.getChValorParametro();
				}
			}
			if(utileriaValidador.isEmpty(listaSalida)){
				logger.error("Error,no existen datos en la consulta de pagos parcialidades");
			}
			
			map.addAttribute("descripcionEstatus", salida.getDescripcionEstatus());
			map.addAttribute("listaDescripcion", listaDes);
			map.addAttribute("formasPago", formasPago);

			map.addAttribute("formaDePago", formaDePago);
			map.addAttribute("nombreBanco", nombreBanco);
			map.addAttribute("numeroParcialidad", numeroParcialidad);
			map.addAttribute("cuentaCLABE", listaSalida.get(0).getCuentaClabe());
			map.addAttribute("listaSalida", listaSalida);
			map.addAttribute("idProcessar", idProcessar);
			map.addAttribute("cuenta", cuenta);
			map.addAttribute("idFormaPago", idFormaPago);
			map.addAttribute("idNombreBanco", idNombreBanco);
			map.addAttribute("folio",folioEntrada);
		}catch (Exception e) {
			logger.error("Error notificacionParcialidad", e);
			respuestaServicio.setFlujo(2);
			respuestaServicio.setTitulo("NOTIFICACION PARCIAL");
			respuestaServicio.setMensaje("SE PRESENTO UN PROBLEMA AL REALIZAR LA NOTIFICACION PARCIAL");
			listaParcialidades = pagoParcialidadService.consultarPagoParcialidades(trabajador.getProcesar().toString());
			validarConsultarParcialidades(listaParcialidades,map);
		}

		modelAndView = new ModelAndView(NavegacionEnum.PAGO_POR_PARCIALIDAD.getNavegacion());
		modelAndView = utileriaConversion.obtenerImagenNombreUsuario(modelAndView, usuarioLogin);
		modelAndView = utileriaConversion.agregarRespuestaModel(modelAndView, respuestaServicio);
		return modelAndView;

	}

	/**
	 * Valida cuenta
	 * @param clabe
	 * @param mascara
	 * @return
	 */
	protected String obtenerCuentaCLABE(String clabe,char mascara) {
		final String clabeLocal = checkNotNull(emptyToNull(clabe),
				"");
		checkArgument(clabeLocal.length() > ActivacionConstants.CUATRO, "La cuenta con longitud no permitida");
		int indiceUltimoElementoReplazar = clabeLocal.length() - ActivacionConstants.CUATRO;
		return reemplazarCaracteres(clabeLocal, mascara, ActivacionConstants.CERO, indiceUltimoElementoReplazar);
	}

	/**
	 * Reemplaza los caracteres de una cadena por un caracter nuevo de un indice
	 * inical hasta un indice final.
	 * @param cadena
	 * @param nuevoCadena
	 * @param de
	 * @param hasta
	 * @return nueva cadena remplzada.
	 */
	protected String reemplazarCaracteres(final String cadena, final char mascara, final int de, final int hasta) {

		char[] caracteresCadeana = cadena.toCharArray();

		StringBuilder correoEnmascarado = new StringBuilder();
		for (int i = 0; i < caracteresCadeana.length; i++) {

			if (i >= de && i < hasta) {
				correoEnmascarado.append(mascara);
			} else {
				correoEnmascarado.append(caracteresCadeana[i]);
			}
		}
		return correoEnmascarado.toString();
	}

	/**
	 * Metodo para obtener los datos 
	 * @param request
	 * @return
	 */
	private ParametrosRetiroParcialCalculoImss obtenerParametrosEntrada(HttpServletRequest request) {
		ParametrosRetiroParcialCalculoImss entrada = new ParametrosRetiroParcialCalculoImss();
		entrada.setFormaPago(request.getParameter(ParametrosConstants.FORMA_PAGO_RETIRO_DESEMPLEO));
		entrada.setClaveBanco(request.getParameter(ParametrosConstants.CLABE_BANCO_NOTIFICACION));
		entrada.setDescripcionCtrlInstBancaria(request.getParameter(ParametrosConstants.CONTROL_INSTITUCION_BANCARIA));	
		entrada.setCuentaClabe(request.getParameter(ParametrosConstants.CUENTA_CLABE_NOTIFICACION));
		entrada.setCuenta(request.getParameter(ParametrosConstants.CUENTA_RETIRO_DESEMPLEO));
		String parcialidad = request.getParameter(ParametrosConstants.NUMERO_PARCIALIDAD);
		Integer numParcialidad= Integer.valueOf(parcialidad);
		entrada.setNumeroParcialidad(numParcialidad);
		String procesar= request.getParameter(ParametrosConstants.ID_PROCESAR);
		Long idProcesar = Long.valueOf(procesar);
		entrada.setIdProcesar(idProcesar);
		entrada.setCuenta(request.getParameter(ParametrosConstants.CUENTA));
		entrada.setFormaPago(request.getParameter(ParametrosConstants.ID_FORMA_PAGO));
		entrada.setDescripcionCtrlInstBancaria(request.getParameter(ParametrosConstants.ID_NOMBRE_BANCO));
        logger.info("obtenerParametrosEntrada:{}",entrada);
		return entrada;
	}

	 /**
     * Validacion de fechas de pago
     *  @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
     *  @param listaParcialidades
     *  @param map
     *  @return
     */
	private List<RetiroParcialCalculoImssSalida> validarConsultarParcialidades(RetiroParcialCalculoImssList listaParcialidades,ModelMap map) {
		String estatusDescripcion;
		List<RetiroParcialCalculoImssSalida> listaSalida =new ArrayList<>();
		List<RetiroParcialCalculoImssSalida> listaPagos = new ArrayList<>();
		List<String> totalPorPagar=new ArrayList<>();
		List<String> listaFechasPagar=new ArrayList<>();
		RetiroParcialCalculoImssSalida salida;
		List<String> listaDes= new ArrayList<>();
		RetiroParcialCalculoImssSalida datosCuenta;
		Collections.sort(listaParcialidades.getListaRetiroParcial(),new Comparator<RetiroParcialCalculoImss>(){
			public int compare(RetiroParcialCalculoImss p1,RetiroParcialCalculoImss p2){
				 return  p1.getParcialidad().compareTo(p2.getParcialidad());
			 }
			});
		for (RetiroParcialCalculoImss pagosParcial : listaParcialidades.getListaRetiroParcial()) {
		salida = new RetiroParcialCalculoImssSalida();
		salida.setIdRetiroParcialCalculo(pagosParcial.getIdRetiroParcialCalculo());
		salida.setParcialidad(pagosParcial.getParcialidad());
		salida.setFechaPago(fechasUtils.obtenerFechaActualFormato(pagosParcial.getFechaPago()));
		salida.setMontoParcialidad(pagosParcial.getMontoParcialidad());
		estatusDescripcion =validarEstatus(pagosParcial);
		salida.setDescripcionEstatus(estatusDescripcion);
		salida.setCuenta(pagosParcial.getCuenta());
		salida.setCuentaClabe(pagosParcial.getCuentaClabe());
		salida.setClaveBanco(pagosParcial.getClaveBanco());
		salida.setFormaPago(pagosParcial.getFormaPago());
		salida.setNumeroResolucion(String.valueOf(pagosParcial.getIdResolucionParcial()));
        logger.info("Parcialidades:{}",pagosParcial.getParcialidad());
        
		listaSalida.add(salida);
		
		if(pagosParcial.getEstatus().equals(ActivacionConstants.UNO_ACTIVO)) {
			listaPagos.add(salida);

			Integer numeroParcialidad = listaPagos.size();
			datosCuenta = listaSalida.get(0);
			String enmascarCuenta = obtenerCuentaCLABE(datosCuenta.getCuenta(),ActivacionConstants.MASCARA_POR_DEFECTO);
			String cuenta = datosCuenta.getCuenta();
  		    String numeroResolucionParcial = datosCuenta.getNumeroResolucion();
			Date fechaActual = new Date();
			if(pagosParcial.getFechaPago().equals(fechaActual) || pagosParcial.getFechaPago().before(fechaActual)) {
				salida.setDescripcionEstatus(ActivacionConstants.POR_PAGAR);
				totalPorPagar.add(salida.getDescripcionEstatus());
				listaFechasPagar.add(salida.getFechaPago());
			}else if(pagosParcial.getFechaPago().after(fechaActual)) {
				salida.setDescripcionEstatus(ActivacionConstants.PENDIENTE);
			}
		
			listaDes.add(salida.getDescripcionEstatus().trim());
			map.addAttribute("estatus", pagosParcial.getEstatus());
			map.addAttribute("NumPorPagar", totalPorPagar.size());
 			map.addAttribute("fechaPago", listaFechasPagar); 
			map.addAttribute("numeroParcialidad", numeroParcialidad);
			map.addAttribute("cuentaCLABE", datosCuenta.getCuentaClabe());
			map.addAttribute("enmascarCuenta", enmascarCuenta);
			map.addAttribute("cuenta", cuenta);
			map.addAttribute("numeroResolucionParcial", numeroResolucionParcial);
			map.addAttribute("listaDescripcion", listaDes);
			map.addAttribute("listaSalida", listaSalida);
			map.addAttribute("descripcionEstatus", salida.getDescripcionEstatus());
		}
		
	  }
		return listaSalida;
	}
}
