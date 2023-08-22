package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants.DDMMYYYY;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_CHEQUES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_ORDEN_PAGO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_OTROS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_TRANSFERENCIA_BANCARIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_UNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.CLAVE_DERECHO_PAGO_CALCULO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.MENSUALIDAD_DOS_MESES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.MENSUALIDAD_SEIS_MESES_1RO_30_SBC;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.MENSUALIDAD_SEIS_MESES_PROPOCIONALES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.MENSUALIDAD_UN_MES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.TIPO_RETIRO_A;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.TIPO_RETIRO_A_VALOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.TIPO_RETIRO_B_VALOR;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDigitoVerificadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetiroParcialCalculoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Mensualidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaValidarDigitoVerificador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


@Controller
public class TipoRetiroController {

	private static final Logger logger = LoggerFactory.getLogger(RetiroDesempleoImssController.class);

	/**
	 * constante del atributo calculo tipo de retiro
	 */
	private static final String ATRIBUTO_CALCULO_TIPO_RETIRO = "calculoTipoRetiro";

	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;

	/**
	 * servicio de RetiroParcialCalculo
	 */
	@Autowired
	private RetiroParcialCalculoService retiroParcialCalculoService;

	/**
	 * servicio de catalogos
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * utilidades de fecha
	 */
	@Autowired
	private FechaUtils fechaUtils;

	/**
	 * Inyeccion digitoVerificadorService
	 */
	@Autowired
	private ConsultarDigitoVerificadorService digitoVerificadorService;

	/**
	 * Inyeccion ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * Valida digito verificar de la CLABE
	 * 
	 * @param request
	 * @param clabe
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "private/validarDigitoVerificador.do", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaValidarDigitoVerificador validarDigitoVerificador(HttpServletRequest request,
			@ModelAttribute("clabe") String clabe) {
		logger.info("Valor de CLABE:{}", clabe);
		RespuestaValidarDigitoVerificador salida = digitoVerificadorService.validarDigitoVerificador(clabe);
		logger.info("Respuesta digito:{}", salida);
		return salida;

	}

	/**
	 * retiroSolicitudDisposicion
	 * 
	 * @param request
	 * @param map
	 * @param salida
	 * @param mapping
	 * @return
	 */
	@PostMapping(value = "/private/solicituddisposicion.do", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, String> retiroSolicitudDisposicion(HttpServletRequest request, ModelMap map) {

		logger.info("solicitudDisposicion");

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		Boolean respuesta532 = (Boolean) request.getSession().getAttribute(ParametrosConstants.SESSION_RESPUESTA_532);

		logger.info("respuesta532 -> {}", respuesta532);

		ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss = obtenerParametrosEntrada(request, trabajador.getClaveAfore());
		parametrosRetiroParcialCalculoImss.setIdProcesar(trabajador.getProcesar());

		retiroParcialCalculoService.guardarCalculo(parametrosRetiroParcialCalculoImss, trabajador, origen, respuesta532);
		request.getSession().setAttribute("cuentaClabe", parametrosRetiroParcialCalculoImss.getCuentaClabe());
		folioService.cerrarFolio(Long.parseLong(request.getParameter(Constants.ID_FOLIO)), null);

		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(user.getDatoUsuario());
		folio.setOperacion("S");
		if (Constants.MATRIMONIO.equals(origen)) {
			folio.setServicio("S18");
			folio.setProceso("S18P4");
		} else {
			folio.setServicio("S1");
			folio.setProceso("S1P4");
		}
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folio.setOrigen("O");
		folio.setEstatus(0L);

		FolioEntrada folioRespuesta = folioService.generarNuevoFolio(folio);
		request.getSession().setAttribute("folioEntrada", folioRespuesta);

		parametrosRetiroParcialCalculoImss.setFolio(folioRespuesta.getFolio());
		parametrosRetiroParcialCalculoImss.setFolioHijo(folioRespuesta.getFolioHijo());
		parametrosRetiroParcialCalculoImss.setIdFolio(folioRespuesta.getIdFolio());
		request.getSession().setAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS,
				parametrosRetiroParcialCalculoImss);

		request.getSession().setAttribute("folioEntrada", folioRespuesta);

		
		
		request.getSession().setAttribute("tipoDocumento", "40");
		request.getSession().setAttribute(ParametrosConstants.DOC_OBLIG_A_QUITAR, "62");
		List<Parametro> adicionales = catalogoService.obtenerParametroDdbpose(Constants.P00021);
		logger.info("Adicionales: {}", trabajador.getTipoSolicitante());
		if(!"01".equals(trabajador.getTipoSolicitante())){
			if(validadorUtils.isEmpty(adicionales)){
				Parametro parametro = new Parametro();
				parametro.setChValorParametro("31|0");
				adicionales = new ArrayList<>();
				adicionales.add(parametro);
			} else {
				logger.info("Adicionales: {}", adicionales.get(0).getChValorParametro());
				adicionales.get(0).setChValorParametro(adicionales.get(0).getChValorParametro().concat("|31|0"));
			}
		}
		if(!validadorUtils.isEmpty(adicionales) && !validadorUtils.isEmpty(adicionales.get(0).getChValorParametro())){
			String [] adicional = adicionales.get(0).getChValorParametro().split("\\|");
			request.getSession().setAttribute(ParametrosConstants.DOC_ADICIONAL, adicional);
			logger.info("Adicionales: {}", adicionales.get(0).getChValorParametro());
		}
		
		Boolean flujo532 = (Boolean) request.getSession().getAttribute(ParametrosConstants.SESSION_RESPUESTA_532);
		if (flujo532) {
			request.getSession().setAttribute(Constants.DESTINO, "/private/solicituddisposicionsalida2.do");
		} else {
			request.getSession().setAttribute(Constants.DESTINO, "/private/solicituddisposicionsalida.do");
		}

		Map<String, String> mapa = new HashMap<>();
		DatosSolicitudRetiroParcialDesempleo  datosSolicitudPdf = null;
		
		if(Constants.MATRIMONIO.equals(origen)) {
			mapa.put(Constants.DESTINO, NavegacionEnum.FORWARD_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS_GEN.getNavegacion());
		}else {
			mapa.put(Constants.DESTINO, NavegacionEnum.FORWARD_PDF_SOLICITUD_RETIRO_IMSS_GEN.getNavegacion());
			datosSolicitudPdf = obterDatosSolicitudRetiroParcialDesempleo(request, parametrosRetiroParcialCalculoImss);
			request.getSession().setAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS, datosSolicitudPdf);
		}
		
		DatosDocumentoPdf datosPdf = new DatosDocumentoPdf();
		datosPdf.setDatos(datosSolicitudPdf);
		datosPdf.setUrlPaginaSiguiente(NavegacionEnum.SOLICITUD_DISPOSICION_PARCIAL_SALIDA.getNavegacion());
		datosPdf.setMetodoPaginaSiguiente(HttpMethod.POST.toString());
		
		logger.info("los datos del pdf solicitud de disposicion parcial: {}", datosPdf);
		
		
		
		request.getSession().setAttribute(ParametrosConstants.DATOS_PDF, datosPdf);

		return mapa;
	}

	/**
	 * 
	 * obtiene los parametros de entrada para el servicio para guardar el calculo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param request
	 * @return
	 */
	private ParametrosRetiroParcialCalculoImss obtenerParametrosEntrada(HttpServletRequest request, String afore) {
		ParametrosRetiroParcialCalculoImss entrada = new ParametrosRetiroParcialCalculoImss();
		entrada.setClave(request.getParameter(ParametrosConstants.TIPO_RETIRO_DESEMPLEO));
		entrada.setFormaPago(request.getParameter(ParametrosConstants.FORMA_PAGO_RETIRO_DESEMPLEO));
		entrada.setClaveBanco(request.getParameter(ParametrosConstants.INSTITUCION_BANCARIA_RETIRO_DESEMPLEO));
		entrada.setCuentaClabe(request.getParameter(ParametrosConstants.CLABE_RETIRO_DESEMPLEO));
		entrada.setCuenta(request.getParameter(ParametrosConstants.CUENTA_RETIRO_DESEMPLEO));
		entrada.setFolio(request.getParameter("folio1"));
		entrada.setFolioHijo(request.getParameter("folioHijo"));
		entrada.setIdFolio(NumberUtils.isNumber(request.getParameter(Constants.ID_FOLIO))?Long.parseLong(request.getParameter(Constants.ID_FOLIO)) : 0L);
		String numeroResolucion = request.getParameter("numeroResolucion");

		entrada.setProcesoReferencia(
				!isEmpty(numeroResolucion) ? request.getParameter("numeroResolucion") : null);

		List<String> mensualidades = null;
		List<Mensualidad> mensualidadesEnviar = new ArrayList<>();
		
		DatosSaldos datosSaldos = (DatosSaldos) request.getSession()
				.getAttribute("datosSaldos");
		CalculoTipoRetiro calculoTipoRetiro = (CalculoTipoRetiro) request.getSession()
				.getAttribute(ATRIBUTO_CALCULO_TIPO_RETIRO);
//		DatosSaldos datosSaldos = new DatosSaldos();
//		datosSaldos.setSaldoCesantiaVejez("168248.64");
//		datosSaldos.setSaldoCuotaSocial("61077.12");
//		datosSaldos.setSaldoRetiro97("74803.91");
		if (datosSaldos != null) {
			entrada.setSaldoCuotaSocial(obtenerMonto(datosSaldos.getSaldoCuotaSocial()));
			entrada.setSaldoRetiro97(obtenerMonto(datosSaldos.getSaldoRetiro97()));
			entrada.setSaldoRcv(obtenerMonto(datosSaldos.getSaldoCesantiaVejez()));
		}

		if (calculoTipoRetiro != null) {
			if (TIPO_RETIRO_A.equals(entrada.getClave())) {
				entrada.setMontoCalculoA(Double.parseDouble(calculoTipoRetiro.getMontoADisponerA()));
				entrada.setTipoRetiro(TIPO_RETIRO_A_VALOR);
				Mensualidad mensualidadEnviar = new Mensualidad();
				mensualidadEnviar.setParcialidad(INT_UNO);
				mensualidadEnviar.setMontoParcialidad(entrada.getMontoCalculoA());
				mensualidadEnviar.setFechaPago(new Date());
				mensualidadEnviar.setDerechoPago(CLAVE_DERECHO_PAGO_CALCULO);
				mensualidadesEnviar.add(mensualidadEnviar);
				entrada.setNumeroParcialidad(1);
				validarDatos(entrada.getMontoCalculoA(), entrada.getFormaPago(), afore);
			} else {
				validarDatos(Double.parseDouble(calculoTipoRetiro.getMontoADisponerB()), entrada.getFormaPago(), afore);
				Integer tipoPlaso = Integer.parseInt(request.getParameter(ParametrosConstants.TIPO_PLASO_RETIRO_DESEMPLEO));
				entrada.setMontoCalculoB(Double.parseDouble(calculoTipoRetiro.getMontoADisponerB()));
				entrada.setTipoRetiro(TIPO_RETIRO_B_VALOR);
				logger.info("tipoPlaso: {}", tipoPlaso);
				switch (tipoPlaso) {
				case MENSUALIDAD_SEIS_MESES_PROPOCIONALES:
					mensualidades = calculoTipoRetiro.getSeisMensualidadesIguales();
					entrada.setNumeroParcialidad(6);
					break;
				case MENSUALIDAD_SEIS_MESES_1RO_30_SBC:
					mensualidades = calculoTipoRetiro.getSeisMensualidades();
					entrada.setNumeroParcialidad(6);
					break;
				case MENSUALIDAD_DOS_MESES:
					mensualidades = calculoTipoRetiro.getDosMensualidades();
					entrada.setNumeroParcialidad(2);
					break;
				case MENSUALIDAD_UN_MES:
					mensualidades = new ArrayList<>();
					mensualidades.add(calculoTipoRetiro.getUnaMensualidad());
					entrada.setNumeroParcialidad(1);
					break;
				default:
					break;

				}
				int numMensualidad = 1;
				for (String mensualidad : mensualidades) {

					Mensualidad mensualidadEnviar = new Mensualidad();
					mensualidadEnviar.setParcialidad(numMensualidad++);
					mensualidadEnviar.setMontoParcialidad(Double.valueOf(mensualidad));
					mensualidadEnviar.setFechaPago(new Date());
					mensualidadEnviar.setDerechoPago(CLAVE_DERECHO_PAGO_CALCULO);
					mensualidadesEnviar.add(mensualidadEnviar);
				}
			}

			entrada.setMensualidad(mensualidadesEnviar);
		} else {
			throw new BusinessException("Error al obtener el cálculo del tipo de retiro");
		}

		return entrada;
	}

	/**
	 * 
	 * obtiene el monto en double a partir de una cadena
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param montoCadena
	 * @return
	 */
	protected double obtenerMonto(String montoCadena) {
		if (montoCadena == null || montoCadena.isEmpty()) {
			return 0;
		}

		return Double.parseDouble(montoCadena);
	}

	/**
	 * 
	 * obtiene los datos para generar el pdf de solicitud de retiro parcial por
	 * desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param request
	 * @return
	 */
	private DatosSolicitudRetiroParcialDesempleo obterDatosSolicitudRetiroParcialDesempleo(HttpServletRequest request,
			ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss) {
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

		DatosSolicitudRetiroParcialDesempleo solicitud = new DatosSolicitudRetiroParcialDesempleo();

		if (trabajador.getDatosCertificables() != null) {
			solicitud.setFechaNacimiento(trabajador.getDatosCertificables().getFechaNacimiento());
			solicitud.setGenero(trabajador.getDatosCertificables().getClaveGenero());
			solicitud.setCurp(trabajador.getDatosCertificables().getCurp());
			solicitud.setNombre(trabajador.getDatosCertificables().getNombre());
			solicitud.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
			solicitud.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
			if(!trabajador.getTipoSolicitante().equals("01") && "568".equals(user.getAforeUsuario())){
				EntradaConsulta entradaConsulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL);
				solicitud.setNombreFirma(entradaConsulta.getNombre());
				solicitud.setApFirma(entradaConsulta.getApellidoPaterno());
				solicitud.setAmFirma(entradaConsulta.getApellidoMaterno());
			} else {
				solicitud.setNombreFirma(trabajador.getDatosCertificables().getNombre());
				solicitud.setApFirma(trabajador.getDatosCertificables().getApellidoPaterno());
				solicitud.setAmFirma(trabajador.getDatosCertificables().getApellidoMaterno());
			}

		}

		if (trabajador.getDatosNoCertificables() != null) {
			solicitud.setRfc(trabajador.getDatosNoCertificables().getRfc());
		}

		solicitud.setFechaSolicitud(fechaUtils.convertirFechaACadena(new Date(), DDMMYYYY));

		solicitud.setNumeroFolio(request.getParameter("folio1"));

		solicitud.setNumeroUnidad("");
		solicitud.setNss(trabajador.getNss());
		solicitud.setClabe(parametrosRetiroParcialCalculoImss.getCuentaClabe());

		if (trabajador.getDatosComplementarios() != null) {
			if (trabajador.getDatosComplementarios().getTelefonos() != null) {
				solicitud.setTelefono(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
				solicitud.setCelular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
			}

			solicitud.setEmail(trabajador.getDatosComplementarios().getCorreoElectronico());

			if (trabajador.getDatosComplementarios().getParticular() != null) {
				solicitud.setCalle(trabajador.getDatosComplementarios().getParticular().getCalle());
				solicitud.setNumeroExterior(trabajador.getDatosComplementarios().getParticular().getNoExterior());
				solicitud.setNumeroInterior(trabajador.getDatosComplementarios().getParticular().getNoInterior());
				solicitud.setCodigoPostal(trabajador.getDatosComplementarios().getParticular().getCodigoPostal());
				solicitud.setPais(trabajador.getDatosComplementarios().getParticular().getPais());
				solicitud.setColonia(trabajador.getDatosComplementarios().getParticular().getColonia());
				solicitud.setEntidadFederativa(
						trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
				solicitud.setDelegacionMunicipio(trabajador.getDatosComplementarios().getParticular().getMunicipio());
				solicitud.setPoblacion(trabajador.getDatosComplementarios().getParticular().getEntidadFederativa());
			}
		}

		solicitud.setCompaniaCelular("");

		agregarFormaPago(solicitud, parametrosRetiroParcialCalculoImss);
		agregarTipoRetiro(solicitud, parametrosRetiroParcialCalculoImss, request);
		solicitud.setNombreAsesor(user.getNombre());
		solicitud.setCurpAsesor(user.getCurpAgente());
		logger.info("solicitud entrada : ##### {}", solicitud);

		return solicitud;
	}

	/**
	 * @param solicitud
	 * @param parametrosRetiroParcialCalculo
	 */
	private void agregarFormaPago(DatosSolicitudRetiroParcialDesempleo solicitud,
			ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculo) {
		solicitud.setFormaPago(parametrosRetiroParcialCalculo.getFormaPago());

		switch (parametrosRetiroParcialCalculo.getFormaPago()) {
		case PAGO_TRANSFERENCIA_BANCARIA:
			solicitud.setInstitucionBancaria(
					obtenerNombreInstitucionBancaria(parametrosRetiroParcialCalculo.getClaveBanco()));
			solicitud.setNumeroSucursalBancaria("");
			solicitud.setClabe(parametrosRetiroParcialCalculo.getCuentaClabe());
			break;
		case PAGO_ORDEN_PAGO:
			solicitud.setReferenciaPago("");
			break;
		case PAGO_CHEQUES:
			solicitud.setReferenciaPago("");
			break;
		case PAGO_OTROS:
			solicitud.setOtroMedioPago("");
			break;
		default:
			return;
		}
	}

	protected String obtenerNombreInstitucionBancaria(String claveBanco) {
		String nombre = "";
		List<Parametro> listaControlInstitucionBancaria = catalogoService.obtenerParametroDdbpose(Constants.T00003);

		if (listaControlInstitucionBancaria != null) {
			for (Parametro parametro : listaControlInstitucionBancaria) {
				if (parametro.getChParametro().equals(claveBanco)) {
					return parametro.getChValorParametro();
				}
			}
		}

		return nombre;
	}

	private void agregarTipoRetiro(DatosSolicitudRetiroParcialDesempleo solicitud,
			ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculo, HttpServletRequest request) {
		solicitud.setModalidadRetiro(parametrosRetiroParcialCalculo.getTipoRetiro());

		if (TIPO_RETIRO_B_VALOR.equals(parametrosRetiroParcialCalculo.getTipoRetiro())) {
			solicitud.setFormaEntrega(request.getParameter(ParametrosConstants.TIPO_PLASO_RETIRO_DESEMPLEO));
		}

		solicitud.setAsesorado(Boolean.TRUE);
	}
	private void validarDatos(Double monto, String formaPago, String afore ){
		if(monto>10000 && formaPago.equals("01") && afore.equals("568")){	
			logger.info("monto: {}\nformaPago:{}\nafore:{}", monto, formaPago, afore);
			throw new BusinessException("Los datos con los que se esta realizando el calculo son incorrectos");
		}
	}
	

}
