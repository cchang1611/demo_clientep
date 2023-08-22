package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretResolucionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AportacionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTipoSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuentaIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteCancelacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionTotalIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretEstatusViviendaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretMatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PrecioAccion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIsssteVis;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoDoctoProbatorio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controller disposicion total issste
 * 
 * @author RARREOLA
 *
 */
@Controller
public class DisposicionTotalIsssteController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DisposicionTotalIsssteController.class);

	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;

	/**
	 * cusService
	 */
	@Autowired
	private CusService cusService;

	/**
	 * Inyeccion resolucionService
	 */
	@Autowired
	private ConsultaIretResolucionService resolucionService;
	/**
	 * DisposicionTotalIsssteService
	 */
	@Autowired
	private DisposicionTotalIsssteService disposicionTotalIsssteService;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;

	/**
	 * CatalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * fechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;

	/**
	 * Inyeccion ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;

	/**
	 * 
	 * Metodo para obtener la disposicon ISSSTE
	 * 
	 * @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
	 * @param request
	 * @param map
	 * @param mensaje
	 * @return
	 */
	@GetMapping(value = "/private/disposicionTotalIssstes.do")
	public ModelAndView disposicionTotalIssste(HttpServletRequest request, ModelMap map, @ModelAttribute String mensaje) {
		RespuestaServicio respuesta = new RespuestaServicio();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		request.getSession().removeAttribute(ActivacionConstants.BANDERA_ISSSTE);
		ModelAndView modelAndView;
		ConsultaCusSalida cusSalida;
		List<Parametro> listaBancosNuevas = new ArrayList<>();
		String jsonInstitucionBanacaria = "";
		ObjectMapper mapeador = new ObjectMapper();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
		FolioEntrada folioGenera = new FolioEntrada();
		folioGenera.setIdUsuario(user.getDatoUsuario());
		folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
		folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_ISSTE_S14);
		folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES14P1);
		folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
		folioGenera.setNss(trabajador.getNss());
		folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
		folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folioGenera.setOrigen(ActivacionConstants.ORIGEN);
		folioGenera = folioService.generarFolio(folioGenera);
		trabajador.setFolio(folioGenera);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		map.addAttribute(ServiciosConstants.FOLIO, trabajador.getFolio());

		RetiroDesempleoIssste retiroDesempleoImss = new RetiroDesempleoIssste();

		DatosCertificables datos = trabajador.getDatosCertificables();

		modelAndView = new ModelAndView(NavegacionEnum.DISPOSICION_TOTAL_ISSSTE.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_PLATAFORMA_SERVICIOS, new DisposicionTotalIssste());
		try {
			respuesta = servicioCatalogo.obtenerRespuesta(null, "MDI1", ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_UNO, null);
			map.addAttribute("respuesta", respuesta);
			List<ResolucionDisposicionIssste> lista = resolucionService.consultarDatosResol(trabajador.getProcesar());

			consultarCargado(request, map, trabajador, lista);

			cusSalida = cusService.solicitarConsultaCus(datos.getCurp(), Constants.ESTATUS, folioGenera.getFolio(), trabajador.getClaveAfore(),"5");

			validarCusIssste(request, map, trabajador, cusSalida, user, folioGenera, retiroDesempleoImss);
			folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
			folioGenera.setIdUsuario(user.getDatoUsuario());
			folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
			folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_ISSTE_S14);
			folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES14P2);
			folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
			folioGenera.setNss(trabajador.getNss());
			folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
			folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
			folioGenera.setOrigen(ActivacionConstants.ORIGEN);
			folioGenera = folioService.generarFolio(folioGenera);
			trabajador.setFolio(folioGenera);
			request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
			map.addAttribute(ServiciosConstants.FOLIO, trabajador.getFolio());
			logger.info("Folio genera :{}", folioGenera.getIdFolio());
			List<BiomTipoSolicitante> infoSol = servicioCatalogo.obtenerTipoSolicitante(trabajador.getTipoSolicitante());
			map.addAttribute("tipoSolicitanteDoc", infoSol.get(0).getChTipoSolicitante());
			List<Parametro> lparametro = servicioCatalogo.obtenerParametroDdbpose(ActivacionConstants.PARAMETRO_DISPOSICION);
			map.addAttribute("parametros", lparametro);
			List<TipoDoctoProbatorio> list = catalogoService.obtenerTiposDoctos();
			map.addAttribute("docProbatorio", list);
			List<Parametro> listaControlInstitucionBancaria = catalogoService.obtenerParametroDdbpose(Constants.T00003);
			List<Parametro> formasPago = catalogoService.obtenerParametroDdbpose(Constants.T00005);
			
			for (Parametro obj : listaControlInstitucionBancaria) {
				if (Constants.CLABES_BANCO_ISSSTE.contains(obj.getChParametro())) {
					listaBancosNuevas.add(obj);
				}
			}
			
			try {
				jsonInstitucionBanacaria = mapeador.writeValueAsString(listaControlInstitucionBancaria);
				logger.info("jsonInstitucionBanacaria: {}", jsonInstitucionBanacaria);
			} catch (JsonProcessingException e) {
				logger.error("Error json", e);
				throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
			}
			
			Date fecha = fechaUtils.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(), FormatoConstants.FORMATO_FECHA_NACIMIENTO);
			map.addAttribute("fechaNacimiento", fechaUtils.convertirFechaACadena(fecha, ActivacionConstants.DDMMYYYY));
			map.addAttribute("tipoSolicitante", trabajador.getTipoSolicitante());
			map.addAttribute("edadTrabajador", disposicionTotalIsssteService.obtenerEdadTrabajador(trabajador.getDatosCertificables().getFechaNacimiento()));
			String curpAgente = "";
			List<Afore> afores = catalogoService.obtenerAfores();
			Long idAfore = null;
			for (Afore obj : afores) {
				if (obj.getClaveAfore().equals(trabajador.getClaveAfore())) {
					idAfore = obj.getId();
					break;

				}
			}
			List<Siefore> siefores = disposicionTotalIsssteService.obtenerSiefores(idAfore);
			if (ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())) {
				curpAgente = user.getCurpAgente();
			}
			
			
			map.addAttribute("jsonInstitucionBancaria", jsonInstitucionBanacaria);
			map.addAttribute("formasPago", formasPago);
			map.addAttribute("listaBancos", listaBancosNuevas);
			map.addAttribute("curpAgenteServicio", curpAgente);
			map.addAttribute("lstAfore", afores);
			map.addAttribute("listaSiefores", siefores);
			map.addAttribute("folio", folioGenera);

			request.getSession().setAttribute("datosSiefore", siefores);
		} catch (BusinessException e) {
			logger.error("Error", e);
			map.addAttribute("error", e.getMessage());
			modelAndView = new ModelAndView(NavegacionEnum.SUB_MENU_DISPOSICION_TOTAL.getNavegacion());

		}

		return modelAndView;
	}

	/***
	 * Validar cus issste
	 * 
	 * @param request
	 * @param map
	 * @param trabajador
	 * @param cusSalida
	 * @param user
	 * @param folioGenera
	 * @param retiroDesempleoImss
	 */
	private void validarCusIssste(HttpServletRequest request, ModelMap map, DatosTrabajador trabajador, ConsultaCusSalida cusSalida, UsuarioLogin user, FolioEntrada folioGenera,
			RetiroDesempleoIssste retiroDesempleoImss) {
		if (!ObjectUtils.isEmpty(cusSalida) && Constants.RESULTADO_OPERACION_01.equals(cusSalida.getCodigo())) {
			logger.info("CUS -EXISTENTE:{}", cusSalida.getRespuesta().get(Constants.CUS));
			retiroDesempleoImss.setCus(cusSalida.getRespuesta().get(Constants.CUS));
			map.addAttribute(Constants.RETIRO_DESEMPLEO_IMSS, retiroDesempleoImss);
			request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoImss);
		} else {
			logger.info("NO Existe CUS:Se generara CUS en Automatico");
			RespuestaGeneraCusSalida salidaGeneraCus = disposicionTotalIsssteService.generarCus(trabajador, user, ActivacionConstants.ISSSTE, folioGenera.getIdFolio());
			retiroDesempleoImss.setCus(salidaGeneraCus.getCus());
			logger.info("CUS -GENERADO:{}", retiroDesempleoImss.getCus());
			map.addAttribute(Constants.RETIRO_DESEMPLEO_IMSS, retiroDesempleoImss);
			request.getSession().setAttribute(ParametrosConstants.CUS, retiroDesempleoImss);

		}
	}

	/**
	 * Consultar cargado
	 * 
	 * @param request
	 * @param map
	 * @param trabajador
	 * @param lista
	 */
	private void consultarCargado(HttpServletRequest request, ModelMap map, DatosTrabajador trabajador, List<ResolucionDisposicionIssste> lista) {
		if (lista != null) {
			if (lista.isEmpty()) {
				request.getSession().setAttribute(ActivacionConstants.BANDERA_ISSSTE, ActivacionConstants.CERO);
			} else {
				List<Parametro> lparametro = servicioCatalogo.obtenerParametroDdbpose(ActivacionConstants.PARAMETRO_COMBINACIONES_REG_SOLICITANTE);
				List<ResolucionDisposicionIsssteVis> listaDos = disposicionTotalIsssteService.setearDatosResol(lista, lparametro, trabajador.getTipoSolicitante());
				request.getSession().setAttribute(ActivacionConstants.BANDERA_ISSSTE, ActivacionConstants.UNO);
				map.addAttribute("datosResolucion", listaDos);
				request.getSession().setAttribute("listaCargado", listaDos);
			}

		} else {
			request.getSession().setAttribute(ActivacionConstants.BANDERA_ISSSTE, ActivacionConstants.CERO);
		}
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarNoCargadoIssste.do" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarNoCargadoIssste(HttpServletRequest request, @RequestBody DisposicionIsssteEntrada entradaParams) {
		logger.info("Inicio de consultar no cargado ISSSTE");
		RespuestaTramite respuesta = new RespuestaTramite();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);

		try {
			List<Parametro> lparametro = servicioCatalogo.obtenerParametroDdbpose(ActivacionConstants.PARAMETRO_COMBINACIONES_REG_SOLICITANTE);
			List<String> retiros = disposicionTotalIsssteService.obtenerTipoRetirosIdSolicitanteNoCargado(lparametro, entradaParams.getClaveTipoRegimen(), trabajador.getTipoSolicitante());
			entradaParams.setTipoRetiros(retiros);
			List<DisposicionIsssteSalida> lista = disposicionTotalIsssteService.consultarNoCargadoIssste(entradaParams);
			respuesta.setLstObRespuesta(lista);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarNoCargadoIssste: Se presento un problema al consultar la informacion de no cargado issste", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de consultar", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarExistenciaCurp.do" }, method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarClaveCentroPago(HttpServletRequest request) {
		logger.info("Inicio de consultar consultarSiefores");
		RespuestaTramite respuesta = new RespuestaTramite();
		BaseRespuesta<AportacionIssste> respuestaDos = null;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		try {
			respuestaDos = disposicionTotalIsssteService.validarCurpExiste(trabajador.getDatosCertificables().getCurp());
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			respuesta.setMensaje(respuestaDos.getDiagnosticoDeRecepcion());
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarClaveCentroPago: Se presento un problema al consultar la informacion de clave centro pago", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a centro pago", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarIsssteRetiroC.do" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarIsssteRetiroC(HttpServletRequest request, @RequestBody DisposicionIsssteEntrada entradaParams) {
		logger.info("Inicio de consultar plan privado ISSSTE");
		RespuestaTramite respuesta = new RespuestaTramite();
		List<DisposicionIsssteSalida> lista = null;
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		try {
			List<Parametro> lparametro = servicioCatalogo.obtenerParametroDdbpose(ActivacionConstants.PARAMETRO_COMBINACIONES_REG_SOLICITANTE);
			if (disposicionTotalIsssteService.validarSolicitantesPlanPrivado(lparametro, trabajador.getTipoSolicitante(), entradaParams.getClaveTipoRetiro())) {
				lista = disposicionTotalIsssteService.consultarIsssteRetiroC(entradaParams);
				respuesta.setLstObRespuesta(lista);
			}

			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarIsssteRetiroC: Se presento un problema al consultar la informacion de cargado issste", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de realizar a la consulta", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * Consultar subcuentas
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarSubcuentas.do" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarSubcuentas(HttpServletRequest request, @RequestBody DisposicionIsssteEntrada entradaParams) {
		logger.info("Inicio de consultar subcuentas ISSSTE");
		RespuestaTramite respuesta = new RespuestaTramite();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		try {

			List<String> tipoProceso = new ArrayList<>();
			tipoProceso.add(ActivacionConstants.TIPO_PROCESO_4000);
			tipoProceso.add(ActivacionConstants.TIPO_PROCESO_9R01);
			tipoProceso.add(ActivacionConstants.TIPO_PROCESO_9501);
			tipoProceso.add(ActivacionConstants.TIPO_PROCESO_0000);
			List<IretEstatusViviendaMarca> marcaEst;
			List<DatosCalculosMontos> listaRcv = null;
			List<DatosCalculosMontos> listaViv = null;
			marcaEst = disposicionTotalIsssteService.obtenerEstatusViviendaIssste(tipoProceso);
			IretMatrizDerecho iretMatrizDerecho = disposicionTotalIsssteService.consultarMatrizDerecho(entradaParams.getClaveTipoRetiro(), entradaParams.getClaveTipoPension(),
					entradaParams.getClaveTipoSeguro(), entradaParams.getClaveTipoRegimen(), entradaParams.getClavePension(), entradaParams.getClaveTipoPrestacion(),
					entradaParams.getClaveMovimiento());
			List<DerechoSubcuentaIssste> lista = disposicionTotalIsssteService.obtenerDerechoSubcuentaPorIdMatrizDerecho(iretMatrizDerecho.getIdMatrizDerecho());
			lista = disposicionTotalIsssteService.agruparListaSubcuentas(lista);
			if (trabajador.getSaldos() != null) {
				listaRcv = disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosRcv(lista, trabajador.getSaldos(), entradaParams);
				if (lista != null) {
					listaViv = disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosVivienda(lista, trabajador.getSaldos(), entradaParams.getTipoRecurso());
				}

			}
			respuesta.setLstObRespuesta(listaRcv);
			respuesta.setLstObRespuestaDos(listaViv);
			respuesta.setObRespuesta(marcaEst);
			validarListas(entradaParams, respuesta, listaRcv, listaViv);
			request.getSession().setAttribute("listaSubcuentas", lista);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultaEstatusCeroPapel: Se presento un problema al consultar la informacion de subcuentas issste", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de realizar  la consulta", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * Validar listas
	 * 
	 * @param entradaParams
	 * @param respuesta
	 * @param listaRcv
	 * @param listaViv
	 */
	private void validarListas(DisposicionIsssteEntrada entradaParams, RespuestaTramite respuesta, List<DatosCalculosMontos> listaRcv, List<DatosCalculosMontos> listaViv) {
		if (listaRcv != null) {
			validarListaRcv(entradaParams, respuesta, listaRcv);
		}
		if (listaViv != null) {
			validarListaVivienda(respuesta, listaViv);
		}
	}

	/**
	 * Validar lista vivienda
	 * 
	 * @param respuesta
	 * @param listaViv
	 */
	private void validarListaVivienda(RespuestaTramite respuesta, List<DatosCalculosMontos> listaViv) {
		if (!listaViv.isEmpty()) {
			respuesta.setMensaje(listaViv.get(0).getMontoTotalSuma());
		}
	}

	/**
	 * Validar lista rcv
	 * 
	 * @param entradaParams
	 * @param respuesta
	 * @param listaRcv
	 */
	private void validarListaRcv(DisposicionIsssteEntrada entradaParams, RespuestaTramite respuesta, List<DatosCalculosMontos> listaRcv) {
		if (!listaRcv.isEmpty() && !ActivacionConstants.SIEFORE.equals(entradaParams.getTipoRecurso())) {
			respuesta.setTitulo(listaRcv.get(0).getMontoTotalSuma());
		}
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarNoCargadoRegimen.do" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarNoCargadoRegimen(HttpServletRequest request, @RequestParam("tipoRegimen") String tipoRegimen) {
		logger.info("Inicio de consultar no cargado regimen");
		RespuestaTramite respuesta = new RespuestaTramite();

		try {
			List<Parametro> lparametro = servicioCatalogo.obtenerParametroDdbpose(ActivacionConstants.PARAMETRO_REGIMEN_ISSSTE);
				Iterator<Parametro> it = lparametro.iterator();
				do {
					Parametro param = it.next();
					if(!StringUtils.contains(param.getChParametro(), tipoRegimen)) {
						it.remove();
					}
				}while(it.hasNext());
			
			respuesta.setLstObRespuesta(lparametro);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarNoCargadoRegimen: Se presento un problema al consultar la informacion de cargado issste", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * Implmentacion expediente
	 * 
	 * @param request
	 * @param map
	 * @param datosGeneralesDispIssste
	 * @return
	 */
	@RequestMapping(value = { "/private/generarExpedienteIsssste.do" }, method = RequestMethod.GET)
	public String generarExpedienteIsssste(HttpServletRequest request, ModelMap map, HttpServletResponse response) {
		StringBuilder builder = new StringBuilder();
		DatosGeneralesDispIssste datosGeneralesDispIssste = (DatosGeneralesDispIssste) request.getSession().getAttribute("datosFormulario");
		List<ResolucionDisposicionIsssteVis> listaCargado = (List<ResolucionDisposicionIsssteVis>) request.getSession().getAttribute("listaCargado");
		datosGeneralesDispIssste.setListaCargado(listaCargado);
		List<Siefore> listaSiefores = (List<Siefore>) request.getSession().getAttribute("datosSiefore");
		RetiroDesempleoIssste retiroDesempleoImss = (RetiroDesempleoIssste) request.getSession().getAttribute(ParametrosConstants.CUS);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		datosGeneralesDispIssste.setSieforesLista(listaSiefores);
		obterDatosSolicitudDisposicionTotalImss(request, datosGeneralesDispIssste);
		datosGeneralesDispIssste.setCus(retiroDesempleoImss.getCus());
		/// Este es mi objeto de session
		request.getSession().setAttribute(ActivacionConstants.DATOS_GENERALES_ISSSTE, datosGeneralesDispIssste);
		try {
			request.getSession().setAttribute("tipoDocumento", "39");
			List<Parametro> adicionales = catalogoService.obtenerParametroDdbpose(Constants.P00021);
			if (!validadorUtils.isEmpty(adicionales) && !validadorUtils.isEmpty(adicionales.get(0).getChValorParametro())) {
				String[] adicional = adicionales.get(0).getChValorParametro().split("\\|");
				request.getSession().setAttribute(ParametrosConstants.DOC_ADICIONAL, adicional);
			}

			DatosDocumentoPdf datosPdf = new DatosDocumentoPdf();
			datosPdf.setDatos(datosGeneralesDispIssste);
			datosPdf.setUrlPaginaSiguiente(NavegacionEnum.SOLICITUD_DISPOSICION_PARCIAL_SALIDA.getNavegacion());
			datosPdf.setMetodoPaginaSiguiente(HttpMethod.POST.toString());

			logger.info("los datos del pdf solicitud de disposicion parcial: {}", datosPdf);

			request.getSession().setAttribute(ParametrosConstants.DATOS_PDF, datosPdf);
			request.getSession().setAttribute("destino", "/private/consultarDisposiciones.do");
		} catch (BusinessException e) {
			logger.error("Error", e);

		}
		request.getSession().setAttribute(ParametrosConstants.ORIGEN, Constants.TOTAL_ISSSTE);
		FolioEntrada folioGenera = new FolioEntrada();
		folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
		folioGenera.setIdUsuario(user.getDatoUsuario());
		folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
		folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_IIMSS_S15);
		folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES15P3);
		folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
		folioGenera.setNss(trabajador.getNss());
		folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
		folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folioGenera.setOrigen(ActivacionConstants.ORIGEN);
		folioGenera = folioService.generarFolio(folioGenera);
		trabajador.setFolio(folioGenera);
		request.getSession().setAttribute("folioEntrada", folioGenera);
		return builder.append("redirect:").append(NavegacionEnum.FORWARD_PDF_DISPOSICION_TOTAL_ISSSTE.getNavegacion()).toString();
	}

	/**
	 * setear datos solicitud
	 * 
	 * @param request
	 * @param datosGeneralesDispIssste
	 */
	private void obterDatosSolicitudDisposicionTotalImss(HttpServletRequest request, DatosGeneralesDispIssste datosGeneralesDispIssste) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		SimpleDateFormat sdf = new SimpleDateFormat(ActivacionConstants.DDMMYYYY);

		datosGeneralesDispIssste.setAforeTrabajador(trabajador.getClaveAfore());
		if (trabajador.getDatosCertificables() != null) {
			Date fechaNacimiento = fechaUtils.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(), "dd/MMM/yyyy");
			datosGeneralesDispIssste.setFechaNacimiento(sdf.format(fechaNacimiento));
			datosGeneralesDispIssste.setNombre(trabajador.getDatosCertificables().getNombre());
			datosGeneralesDispIssste.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
			datosGeneralesDispIssste.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
			datosGeneralesDispIssste.setGenero(trabajador.getDatosCertificables().getClaveGenero());
			datosGeneralesDispIssste.setCurp(trabajador.getDatosCertificables().getCurp());
		}

		if (trabajador.getDatosNoCertificables() != null) {
			datosGeneralesDispIssste.setRfc(trabajador.getDatosNoCertificables().getRfc());
		}
		datosGeneralesDispIssste.setFechaSolicitud(fechaUtils.convertirFechaACadena(new Date(), Constants.DDMMYYYY));
		datosGeneralesDispIssste.setNumeroFolio(request.getParameter("folio1"));
		datosGeneralesDispIssste.setNumeroUnidad("");
		datosGeneralesDispIssste.setNss(trabajador.getNss());
		datosGeneralesDispIssste.setFolioSol(trabajador.getFolio().getFolio());
		datosGeneralesDispIssste.setCurpSolicitante(trabajador.getDatosCertificables().getCurp());
		datosGeneralesDispIssste.setSelloTrabajador(trabajador.getSello().getId().toString());
		datosGeneralesDispIssste.setClaveAforeTrabajador(trabajador.getClaveAfore());
		if (trabajador.getDatosComplementarios() != null) {
			if (trabajador.getDatosComplementarios().getTelefonos() != null) {
				datosGeneralesDispIssste.setTelefono(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
				datosGeneralesDispIssste.setCelular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
				datosGeneralesDispIssste.setExtension(trabajador.getDatosComplementarios().getTelefonos().getExtension());
				datosGeneralesDispIssste.setTelefonoLaboral(trabajador.getDatosComplementarios().getTelefonos().getTelefonoLaboral());
			}

			datosGeneralesDispIssste.setEmail(trabajador.getDatosComplementarios().getCorreoElectronico());

			if (trabajador.getDatosComplementarios().getParticular() != null) {
				datosGeneralesDispIssste.setCalle(trabajador.getDatosComplementarios().getParticular().getCalle());
				datosGeneralesDispIssste.setNumeroExterior(trabajador.getDatosComplementarios().getParticular().getNoExterior());
				datosGeneralesDispIssste.setNumeroInterior(trabajador.getDatosComplementarios().getParticular().getNoInterior());
				datosGeneralesDispIssste.setCodigoPostal(trabajador.getDatosComplementarios().getParticular().getCodigoPostal());
				datosGeneralesDispIssste.setPais(trabajador.getDatosComplementarios().getParticular().getClavePais());
				datosGeneralesDispIssste.setColonia(trabajador.getDatosComplementarios().getParticular().getColonia());
				datosGeneralesDispIssste.setEntidadFederativa(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
				datosGeneralesDispIssste.setDelegacionMunicipio(trabajador.getDatosComplementarios().getParticular().getMunicipio());
				datosGeneralesDispIssste.setPoblacion(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
			}
		}

		datosGeneralesDispIssste.setCompaniaCelular("");
		datosGeneralesDispIssste.setNombreAsesor(user.getNombre());
		datosGeneralesDispIssste.setCurpAsesor(user.getCurpAgente());
		datosGeneralesDispIssste.setTipoSolicitante(trabajador.getTipoSolicitante());
		datosGeneralesDispIssste.setSaldos(trabajador.getSaldos());

	}

	/**
	 * Consultar subcuentas
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/obtenerDatosSessionFormulario.do" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite obtenerDatosSessionFormulario(HttpServletRequest request, @RequestBody DatosGeneralesDispIssste entradaParams) {
		logger.info("Inicio de consultar subcuentas ISSSTE");
		RespuestaTramite respuesta = new RespuestaTramite();

		try {
			request.getSession().setAttribute("datosFormulario", entradaParams);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultaEstatusCeroPapel: Se presento un problema al agregar los datos en session", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a  consultar", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarPrecioAccionSiefore.do" }, method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarPrecioAccionSiefore(HttpServletRequest request, @RequestParam(value = "claveSiefore") String claveSiefore) {
		logger.info("Inicio de consultar consultarSiefores");
		RespuestaTramite respuesta = new RespuestaTramite();

		try {
			List<PrecioAccion> listas = disposicionTotalIsssteService.obtenerPrecioAccion(claveSiefore, "2");

			respuesta.setFlujo(NumerosConstants.INT_UNO);
			if (listas != null) {
				if (!listas.isEmpty()) {
					respuesta.setObRespuesta(listas.get(0));
					respuesta.setTitulo(fechaUtils.convertirFechaACadena(listas.get(0).getFechaValorTitulo(), ActivacionConstants.DDMMYYYY));
				} else {
					respuesta.setMensaje(ActivacionConstants.SIN_PRECIO_ACCION);
				}
			} else {
				respuesta.setMensaje(ActivacionConstants.SIN_PRECIO_ACCION);
			}

		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarPrecioAccionSiefore: Se presento un problema al consultar la informacion de precio accion", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a consulta la informacion", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/consultarDisposiciones.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView consultarDisposiciones(HttpServletRequest request, ModelMap map) {
		logger.info("Inicio de consultar disposiciones");
		DatosGeneralesDispIssste entradaParams = (DatosGeneralesDispIssste) request.getSession().getAttribute(ActivacionConstants.DATOS_GENERALES_ISSSTE);

		RespuestaTramite respuesta = new RespuestaTramite();
		UsuarioLogin user = new UsuarioLogin();
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		ModelAndView model = new ModelAndView(NavegacionEnum.DISPOSICION_RESP_ISSSTE.getNavegacion());
		FolioEntrada folio = (FolioEntrada) request.getSession().getAttribute("folioEntrada");

		try {

			String respuestaExpe = disposicionTotalIsssteService.validarExpedienteServicio(folio.getFolioHijo(), trabajador, user);
			if (!ActivacionConstants.RESULTADO_OPERACION_01.equals(respuestaExpe)) {
				folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), 2);
				respuestaExpe = "El expediente no se ha generado";
				map.addAttribute(ActivacionConstants.RESULTADO_OPERACION_ISSSTE, ActivacionConstants.RESULTADO_OPERACION_02);
				map.addAttribute(ActivacionConstants.DESCRIPCION_ISSSTE, respuestaExpe);
			} else {
				folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
				FolioEntrada folioGenera = new FolioEntrada();
				folioGenera.setIdUsuario(user.getDatoUsuario());
				folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
				folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_ISSTE_S14);
				folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES14P4);
				folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
				folioGenera.setNss(trabajador.getNss());
				folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
				folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
				folioGenera.setOrigen(ActivacionConstants.ORIGEN);
				folioGenera = folioService.generarFolio(folioGenera);
				request.getSession().setAttribute("folioEntrada", folioGenera);
				entradaParams.setFolioSol(folioGenera.getFolio());
				request.getSession().setAttribute(ActivacionConstants.DATOS_GENERALES_ISSSTE, entradaParams);
				trabajador.setFolio(folioGenera);
				request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
				if (ActivacionConstants.SIEFORE.equals(entradaParams.getTipoRecursoClave())) {
					SalidaDisposicionTotalIssste salidaRegimenOrdinarioIsssteDos = disposicionTotalIsssteService.consultarIsssteRegimenOrdinario(entradaParams);
					request.getSession().setAttribute("resultadoDisposicion", salidaRegimenOrdinarioIsssteDos);
					validarRespuestaServicio46(trabajador, salidaRegimenOrdinarioIsssteDos);
					map.addAttribute(ActivacionConstants.RESULTADO_OPERACION_ISSSTE, salidaRegimenOrdinarioIsssteDos.getResultadoOperacion());
					map.addAttribute(ActivacionConstants.DESCRIPCION_ISSSTE, salidaRegimenOrdinarioIsssteDos.getDescripcionDiagnostico());
				} else {
					SalidaDisposicionTotalIssste salidaRegimenOrdinarioIssste = disposicionTotalIsssteService.consultarIsssteDisposicionTotal(entradaParams);
					map.addAttribute(ActivacionConstants.RESULTADO_OPERACION_ISSSTE, salidaRegimenOrdinarioIssste.getResultadoOperacion());
					map.addAttribute(ActivacionConstants.DESCRIPCION_ISSSTE, salidaRegimenOrdinarioIssste.getDescripcionDiagnostico());
					request.getSession().setAttribute("resultadoDisposicion", salidaRegimenOrdinarioIssste);
					validarRespuestaServicio46(trabajador, salidaRegimenOrdinarioIssste);
				}

			}

			String montoRcv = entradaParams.getMontoTotalRcv();
			String montoViv = entradaParams.getMontoTotalViv();
			montoRcv = montoRcv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
			montoViv = montoViv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
			Double sumaLiq = Double.valueOf(montoRcv) + Double.valueOf(montoViv);
			StringBuilder bui = new StringBuilder();
			String sum = bui.append(ExpresionesConstants.SIGNO_PESOS).append(sumaLiq).toString();

			map.addAttribute("datosForm", entradaParams);
			map.addAttribute("montoDisponer", sum);

		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarDisposiciones: Se presento un problema al consultar la informacion de cargado issste", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder al consultar la informacion ", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return model;
	}

	/**
	 * Validar resultado servicio 46
	 * 
	 * @param trabajador
	 * @param salidaRegimenOrdinarioIssste
	 */
	private void validarRespuestaServicio46(DatosTrabajador trabajador, SalidaDisposicionTotalIssste salidaRegimenOrdinarioIssste) {
		if (ActivacionConstants.RESULTADO_OPERACION_01.equals(salidaRegimenOrdinarioIssste.getResultadoOperacion())) {
			folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), 3);
		} else {
			folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), 2);
		}
	}

	/**
	 * No cargado issste
	 * 
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/consultarCancelacion.do" }, method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaTramite consultarCancelacion(HttpServletRequest request) {
		logger.info("Inicio de consultar consultarCancelacion");
		RespuestaTramite respuesta = new RespuestaTramite();
		DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
		try {
			DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
			List<DisposicionIsssteCancelacion> datosCan = (List<DisposicionIsssteCancelacion>) request.getSession().getAttribute("datosCancelacion");

			entradaParams.setCurp(trabajador.getDatosCertificables().getCurp());
			entradaParams.setNss(trabajador.getNss());
			entradaParams.setSecuenciaPension(datosCan.get(0).getSecuenciaPension());
			entradaParams.setFolioSol(datosCan.get(0).getFolioIssste());
			CancelacionSalida cancelacionSalida = disposicionTotalIsssteService.consultarCancelacion(entradaParams);
			respuesta.setMensaje(cancelacionSalida.getResultadoOperacion());
			respuesta.setTitulo(cancelacionSalida.getDescripcionDiagnostico());
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			logger.error("consultarCancelacion: Se presento un problema al consultar la informacion de cancelacion", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a cancelacion", e);
			respuesta.setFlujo(NumerosConstants.INT_CERO);
		}
		return respuesta;
	}
}
