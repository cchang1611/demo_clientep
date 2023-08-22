package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MarcaOperativaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AccionSieforeImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSubcuentasDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizConvivencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroEntrada;
import  mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoDerechoCargadoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarDisposicionImssEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

@Service
public class DisposicionTotalImssServiceImpl implements DisposicionTotalImssService {

	public static final String DDMMYYYY = "dd/MM/yyyy";
	public static final String KKMM = "kk:mm";
	
	
	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(DisposicionTotalImssServiceImpl.class);
	
	/**
	 * cusService
	 */
	@Autowired
	private CusService cusService;
	
	/**
	 * Inyeccion dependencia FolioService
	 */
	@Autowired
	private FolioService folioService;
	
	/**
	 * fechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	
	/**
	 * uriCancelacion
	 */
	@Value("#{propiedades['cancelacion.disposicionTotalImss']}")
	private String uriCancelacion;
	
	
	/**
	 * template para los llamados REST
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * uriDisposicionIsssteTotal
	 */
	@Value("#{propiedades['disposicion.total.solicitud.imss']}")
	private String uriDisposicionImssTotal;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	/**
	 * Inyeccion dependencia RechazoService
	 */
	@Autowired
	private RechazoService rechazoService;
	/**
	 * inyeccion marcaOperativaService
	 */
	@Autowired
	private MarcaOperativaService marcaOperativaService;
	/**
	 *  generarCus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param user
	 *  @param origen
	 *  @param trabajador
	 */
	@Override
	public FolioEntrada generarFolio(UsuarioLogin user, String origen, DatosTrabajador trabajador) {
		
		FolioEntrada folio = new FolioEntrada();
        folio.setIdUsuario(Long.valueOf(user.getDatoUsuario()));
        folio.setOperacion("S");
        if(AgenteConstants.TIPO_AFILIACION_IMSS.equals(origen)){
            folio.setServicio("S1");
            folio.setProceso("S1P2");
        } else {
            folio.setServicio("S6");
            folio.setProceso("S6P2");
        }
        folio.setSucursal("SUC1");
        folio.setCurp(trabajador.getDatosCertificables().getCurp());
        folio.setTiempoLlegada("00:00");
        folio.setOrigen("O");
        
        return folioService.generarFolio(folio);
	}
	
	/**
	 *  solicitarCus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 */
	public RespuestaGeneraCusSalida generarCus(DatosTrabajador trabajador, UsuarioLogin user, String origen, Long folioRespuesta) {
		try {
			Calendar hoy = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(DDMMYYYY);
			SimpleDateFormat sdfhora = new SimpleDateFormat(KKMM);

			Date fechaNacimiento = fechaUtils.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(), "dd/MMM/yyyy");
			EntradaCus entrada = new EntradaCus();
			entrada.setServicioGeneraCus("02");
			entrada.setCurpTitular(trabajador.getDatosCertificables().getCurp());
			entrada.setNssTitular(trabajador.getNss());
			entrada.setRfcTitular(trabajador.getDatosNoCertificables().getRfc());
			entrada.setNombreTitular(trabajador.getDatosCertificables().getNombre());
			entrada.setApellidoPaternoTitular(trabajador.getDatosCertificables().getApellidoPaterno());
			entrada.setApellidoMaternoTitular(trabajador.getDatosCertificables().getApellidoMaterno());
			entrada.setFechaNacimiento(sdf.format(fechaNacimiento));
			entrada.setNumeroCelularTitular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
			entrada.setCveAfore(user.getAforeUsuario());
			entrada.setNumeroFijoTitular(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
			entrada.setRegimenPensionTitular("02");
			entrada.setRolCiudadano("01");
			entrada.setCurpAgenteServicio(user.getCurpAgente());
			entrada.setNombreAgenteServicio(user.getSoloNombre());
			entrada.setApellidoPaternoAgenteServicio(user.getApellidoPaterno());
			entrada.setApellidoMaternoAgenteServicio(user.getApellidoMaterno());
			entrada.setNumeroAgenteServicio(user.getUsuario());
// 01-IMSS, 02-ISSSTE
			if (AgenteConstants.TIPO_AFILIACION_ISSSTE.equals(origen)) {
				entrada.setInstitutoOtorgoDerecho("02");
			} else {
				entrada.setInstitutoOtorgoDerecho("01");
			}
			entrada.setOrigenSolicitud("01");
			entrada.setCveSucursal("SUC1");
			entrada.setFechaCita(sdf.format(hoy.getTime()));
			entrada.setHorarioCita(sdfhora.format(hoy.getTime()));

			RespuestaGeneraCusSalida salida = cusService.generarCus(entrada);

			if ("01".equals(salida.getResultadoOperacion())) {
				folioService.cerrarFolio(folioRespuesta, null);
			} else {
//			folioService.cerrarFolio(folioRespuesta, 3, salida.getDiagnosticoProcesar());
				if ("J76".equals(salida.getDiagnosticoProcesar())) {
					ConsultaCusSalida consultaCusSalida = cusService.solicitarConsultaCus(trabajador.getDatosCertificables().getCurp(), "1", null, user.getAforeUsuario(), null);
					salida.setCus(consultaCusSalida.getRespuesta().get("cus"));
					salida.setResultadoOperacion("01");
				}
			}
			return salida;
		} catch (HttpServerErrorException e) {
			logger.error(e.getMessage());
			throw new BusinessException("Servicio CUS no esta disponible");
		}

	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService#obtenerAgruparSuBcuentas(java.util.List)
	 */
	@Override
	public List<DerechoSubcuenta> obtenerAgruparSuBcuentas(List<DerechoSubcuenta> listaSubCuentas) {
		List<DerechoSubcuenta> listaSalida = new ArrayList<>(); 
		Map<String,List<DerechoSubcuenta>> map = new HashMap<>();
		 for (DerechoSubcuenta derechoSubcuenta : listaSubCuentas) {
			String llave = derechoSubcuenta.getCvSubCuenta().getClave();
			 if(map.get(llave)== null ) {
				 listaSalida.add(derechoSubcuenta);
				 map.put(llave, new ArrayList<DerechoSubcuenta>());
			 }
			 map.get(llave).add(derechoSubcuenta);
		}
		
		return listaSalida;
		
	}
	
	
	/**
	 * Cancelacion
	 * @param entrada
	 * @return
	 */
	@Override
	public CancelacionSalida consultarCancelacion(DatosGeneralesDispIssste entradaParams) {
    ResponseEntity<CancelacionSalida> respuesta  = null;
    CancelacionEntrada entrada = new CancelacionEntrada();
	entrada.setCurp(entradaParams.getCurp());
	entrada.setCveAfore(entradaParams.getAforeTrabajador());
	entrada.setFolioSolicitud(entradaParams.getFolioSol());
	entrada.setNss(entradaParams.getNss());
	entrada.setSecuenciaPension(entradaParams.getSecuenciaPension());
    CancelacionSalida salida = null;
		try{
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			headerMedia.set("idServicio", "815");
			headerMedia.set("idCliente", "35");
			headerMedia.set("idEbusiness", "29");
			HttpEntity<CancelacionEntrada> entidad = new HttpEntity<>(entrada, headerMedia);
			
			logger.info(uriCancelacion);
			logger.info("Peticion disposciion total {}", entrada);

			respuesta = restTemplate.exchange(uriCancelacion, HttpMethod.POST, entidad, CancelacionSalida.class);
			if(respuesta != null){
				salida = respuesta.getBody();
			}
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio cancelacion", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return salida;
	}

	/**
	 * Cancelacion
	 * @param entrada
	 * @return
	 */
	@Override
	public List<ParametroEntrada> validarCancelacion(List<FolioSalida> folios, DatosTrabajador trabajador,
			List<FolioSalida> foliosPadres, String idFolio) {
		boolean bandera = false;
		
		List<ParametroEntrada>  lista;
		for(FolioSalida obj: folios){
			if(obj.getFolioDetalles() != null){
				bandera = validarProceso(bandera, obj);
				if(bandera){
					break;
				}
			}
		}
		
		String folioPadre = obtenerFolioPadre(foliosPadres, idFolio);
		
		lista = obtenerDatosCancel(trabajador, bandera,  folioPadre);
		return lista;
	}

	/**
	 * Obtener datos
	 * @param trabajador
	 * @param bandera
	 * @param lista
	 * @param folioPadre
	 * @return
	 */
	protected List<ParametroEntrada> obtenerDatosCancel(DatosTrabajador trabajador, boolean bandera,
			 String folioPadre) {
		List<ParametroEntrada>  lista = null;
		if(bandera){
		  lista = consultarDispoCancel(trabajador.getNss(),  folioPadre);
		}
		return lista;
	}

	/**
	 * Validar proceso
	 * @param bandera
	 * @param obj
	 * @return
	 */
	private boolean validarProceso(boolean bandera, FolioSalida obj) {
		boolean banderaAux = bandera;
		for(FolioDetalle obj1: obj.getFolioDetalles()){
			if(ActivacionConstants.ID_PROCESO_SOLICITUD_IMSS.equals(obj1.getIdProceso())){
				banderaAux = true;
				break;
			}
		}
		return banderaAux;
	}
	
	
	/**
	 * Obtener folio padre
	 * @param foliosPadres
	 * @param idFolio
	 * @param folioPadre
	 * @return
	 */
	private String obtenerFolioPadre(List<FolioSalida> foliosPadres, String idFolio) {
		String folioPadre = null;
		for(FolioSalida objt: foliosPadres){
			if(objt.getIdFolioPulssar().equals(Long.valueOf(idFolio))){
				folioPadre = objt.getChFolio();
				break;
			}
		}
		return folioPadre;
	}
	
	/**
	 * Consultar disposicion cancelacion
	 * @return
	 */
	protected List<ParametroEntrada>  consultarDispoCancel(String nss,  String folioSol){
		StringBuilder url = new StringBuilder();
		List<ParametroEntrada> resp = null;
	
		try{
			String uriDos = url.append(uriComunes).append("resolucionParcial/disposicionImss/{nss}/{folioSolicitud}").toString();
			uriDos = uriDos.replace("{nss}", nss);
			uriDos = uriDos.replace("{folioSolicitud}", folioSol);
			String respuesta = restTemplate.getForObject(uriDos, String.class);
			JsonUtilsImpl<ParametroEntrada> json = new JsonUtilsImpl<>();
			resp  = json.parseJsonToObjectList(respuesta, ParametroEntrada.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a validar siefore cancelacion", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		return resp;
	}
	
	/**
	 * Validar si se muestra el cancelar
	 */
	@Override
	public String validarDatosCancel(List<ParametroEntrada> listas) {
		String  bandera = NumerosConstants.C_CERO;
		if(listas != null){
			bandera = validarListaParametro(listas, bandera);
		}
		return bandera;
	}

	/**
	 * Validar lista parametro
	 * @param listas
	 * @param bandera
	 * @return
	 */
	private String validarListaParametro(List<ParametroEntrada> listas, String bandera) {
		String banderaAux = bandera;
		if(!listas.isEmpty()){
			banderaAux = NumerosConstants.C_UNO;
		}
		return banderaAux;
	}

	/**
	 * Consultar disposicion
	 * @param entradaParams
	 * @return
	 */
	@Override
	public SalidaDisposicionTotalImss consultarImssDisposicionTotal(ProcesoDerechoCargadoEntrada entradaParams, DatosTrabajador trabajador) {
		ResponseEntity<SalidaDisposicionTotalImss> respuesta  = null;
		SolicitarDisposicionImssEntrada entradaSol = new SolicitarDisposicionImssEntrada();
		SalidaDisposicionTotalImss salida = null;
		setearDatosDisposicion(entradaParams, entradaSol, trabajador);
		try{
			
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			headerMedia.set(ActivacionConstants.ID_SERVICIO, "763");
			headerMedia.set(ActivacionConstants.ID_CLIENTE, "35");
			headerMedia.set(ActivacionConstants.ID_EBUSINESS, "29");
			HttpEntity<SolicitarDisposicionImssEntrada> entidad = new HttpEntity<>(entradaSol, headerMedia);
			
			logger.info(uriDisposicionImssTotal);
			logger.info("Peticion disposciion total {}", entradaSol);

			respuesta = restTemplate.exchange(uriDisposicionImssTotal, HttpMethod.POST, entidad, SalidaDisposicionTotalImss.class);
			if(respuesta != null){
				salida = respuesta.getBody();
			}
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio disposicion total", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		return salida;
	}
	
	
	
	/** * Datos de disposicion
	 * @param entradaParams
	 * @param trabajador
	 * @param entrada
	 */
	private void setearDatosDisposicion(ProcesoDerechoCargadoEntrada entradaParams,
			SolicitarDisposicionImssEntrada entradaSol, DatosTrabajador trabajador) {
		if(entradaParams.getSemanasCotizadas() != null){
			entradaSol.setSemanasCotizadas(entradaParams.getSemanasCotizadas().toString());
		}
		if(entradaParams.getPorcentajeValuacion() != null){
			entradaSol.setPorcentajeValuacion(Double.valueOf(entradaParams.getPorcentajeValuacion()));
		}
		entradaSol.setSecuenciaPension(entradaParams.getSecuenciaPension());
		entradaSol.setFechaInicioPension(entradaParams.getFcInicioPension());
		entradaSol.setFechaEmisionResolucion(entradaParams.getFcEmisionResolucion());
		entradaSol.setTipoPension(entradaParams.getCvTipoPension());
		entradaSol.setRegimen(entradaParams.getCvTipoRegimen());
		entradaSol.setTipoPrestacion(entradaParams.getCvTipoPrestacion());
		entradaSol.setTipoSeguro(entradaParams.getCvTipoSeguro());
		entradaSol.setTipoRetiro(entradaParams.getCvTipoRetiro());
		
		List<AccionSieforeImss> montosRCV;
		AccionSieforeImss montosRCVObj;
		if(entradaParams.getSubcuentasRcv() != null){
			montosRCV = new ArrayList<>();
			 for (DatosSubcuentasDispIssste cuentas: entradaParams.getSubcuentasRcv() ) {
				 montosRCVObj = new AccionSieforeImss();
				 obtenerDatosRcv(montosRCV, montosRCVObj, cuentas,  entradaParams);
			 }
				
				entradaSol.setMontosRCV(montosRCV);
		}
		
		obtenerValoresVivienda(entradaParams, entradaSol);
		entradaSol.setFechaSolicitud(entradaParams.getFechaSolicitud());
		entradaSol.setCveDocProbatorio(entradaParams.getCveDocProbatorio());
		entradaSol.setAseguradora(entradaParams.getAseguradora());
		entradaSol.setActuarioAutorizado(entradaParams.getActuarioAutorizado());
		entradaSol.setNumPlanPrivadoPensiones(entradaParams.getNumPlanPrivadoPensiones());
		entradaSol.setFechaPeriodoPagoReingreso(entradaParams.getFechaPeriodoPagoReingreso());
		entradaSol.setConsecutivoTrabajador(entradaParams.getConsecutivoTrabajador());
		entradaSol.setIdSolicitante(entradaParams.getIdSolcitante());
		entradaSol.setCurpSolicitante(trabajador.getDatosCertificables().getCurp());
		entradaSol.setSelloUnico(entradaParams.getSelloUnico());
		entradaSol.setCurpAgenteServicio(entradaParams.getCurpAgenteServicio());
		entradaSol.setIdBeneficiario(entradaParams.getIdBeneficiario());
		entradaSol.setNombreBeneficiario(entradaParams.getNombreBeneficiario());
		entradaSol.setApPaternoBeneficiario(entradaParams.getApPaternoBeneficiario());
		entradaSol.setApMaternoBeneficiario(entradaParams.getApMaternoBeneficiario());
		entradaSol.setClabePago(entradaParams.getClabePago());
		entradaSol.setCurpPago(entradaParams.getCurpPago());
		entradaSol.setRfcPago(entradaParams.getRfcPago());
		entradaSol.setFolioInfonavit(entradaParams.getFolioInfonavit());
		entradaSol.setGrupo(entradaParams.getGrupo());
		entradaSol.setApMaternoTrabajador(trabajador.getDatosCertificables().getApellidoMaterno());
		entradaSol.setApPaternoTrabajador(trabajador.getDatosCertificables().getApellidoPaterno());
		entradaSol.setNombreTrabajador(trabajador.getDatosCertificables().getNombre());
		entradaSol.setCveAfore(trabajador.getClaveAfore());
		entradaSol.setCurp(trabajador.getDatosCertificables().getCurp());
		entradaSol.setNss(trabajador.getNss());
		entradaSol.setFolioSolicitud(trabajador.getFolio().getFolio());
		entradaSol.setOrigenTramite(ActivacionConstants.RESULTADO_OPERACION_01);
		entradaSol.setFechaNacimiento(entradaParams.getFechaNacimiento());
		entradaSol.setTipoVentanilla(entradaParams.getTipoVentanilla());
	
		
	}

	

	/**
	 * Obtener valores vivienda
	 * @param entradaParams
	 * @param entradaSol
	 */
	private void obtenerValoresVivienda(ProcesoDerechoCargadoEntrada entradaParams,
			SolicitarDisposicionImssEntrada entradaSol) {
		if(entradaParams.getSubcuentasViv() != null){
			 for (DatosSubcuentasDispIssste cuentas: entradaParams.getSubcuentasViv()) {
				 obtenerSaldosViv(entradaSol, cuentas);
			 }
		}
	}

	/**
	 * Saldos viv
	 * @param entradaSol
	 * @param cuentas
	 */
	private void obtenerSaldosViv(SolicitarDisposicionImssEntrada entradaSol, DatosSubcuentasDispIssste cuentas) {
		entradaSol.setFondoAhorroViv72(Double.valueOf("0.00"));
		if(ActivacionConstants.SUBCUENTA_IMSS_VIV_04.equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 entradaSol.setAplicacionInteresViv97(Double.valueOf(cuentas.getMonto()));
		 }
		 
		 if(ActivacionConstants.SUBCUENTA_IMSS_VIV_09.equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 entradaSol.setAplicacionInteresViv92(Double.valueOf(cuentas.getMonto()));
		 }
		 
		 
		 if(ActivacionConstants.SUBCUENTA_IMSS_VIV_07.equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 entradaSol.setFondoAhorroViv72(Double.valueOf(cuentas.getMonto()));
		 }
	}
	
	
	
	/**
	 * Obtener rcv
	 * @param montosRCV
	 * @param montosRCVObj
	 * @param cuentas
	 */
	private void obtenerDatosRcv(List<AccionSieforeImss> montosRCV, AccionSieforeImss montosRCVObj,
			DatosSubcuentasDispIssste cuentas, ProcesoDerechoCargadoEntrada entradaParams) {
		if(ActivacionConstants.SUBCUENTA_IMSS_RCV_01 .equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 montosRCVObj.setAccionesRet97(Double.valueOf(cuentas.getMonto()));
			 montosRCVObj.setCveSiefore(this.obtenerGrupoTrabajador(cuentas.getSiefore(), entradaParams.getSieforesLista()));
				
			 montosRCV.add(montosRCVObj);
		 }
		 
		 if(ActivacionConstants.SUBCUENTA_IMSS_RCV_02.equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 montosRCVObj.setAccionesCV(Double.valueOf(cuentas.getMonto()));
			 montosRCVObj.setCveSiefore("01");
			montosRCVObj.setCveSiefore(this.obtenerGrupoTrabajador(cuentas.getSiefore(), entradaParams.getSieforesLista()));
			 montosRCV.add(montosRCVObj);
		 }
		 
		 obtenerRcv(montosRCV, montosRCVObj, cuentas,  entradaParams);
	}

	/**
	 * Rcv
	 * @param montosRCV
	 * @param montosRCVObj
	 * @param cuentas
	 */
	private void obtenerRcv(List<AccionSieforeImss> montosRCV, AccionSieforeImss montosRCVObj, DatosSubcuentasDispIssste cuentas, ProcesoDerechoCargadoEntrada entradaParams) {
		if(ActivacionConstants.SUBCUENTA_IMSS_RCV_03.equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 montosRCVObj.setAccionesCS(Double.valueOf(cuentas.getMonto()));
			 montosRCVObj.setCveSiefore(this.obtenerGrupoTrabajador(cuentas.getSiefore(), entradaParams.getSieforesLista()));
			 montosRCV.add(montosRCVObj);
		 }
		 
		 
		 if(ActivacionConstants.SUBCUENTA_IMSS_RCV_08.equals(cuentas.getClaveSubcuenta()) && Strings.isNotBlank(cuentas.getAcciones())) {
			 montosRCVObj.setCveSiefore(this.obtenerGrupoTrabajador(cuentas.getSiefore(), entradaParams.getSieforesLista()));
			 montosRCVObj.setAccionesRet92(Double.valueOf(cuentas.getMonto()));
			 montosRCV.add(montosRCVObj);
		 }
	}
	
	
	/**
	 * Obtener grupo trabajador
	 * @param siefore
	 * @param lista
	 * @return
	 */
	protected String obtenerGrupoTrabajador(String siefore, List<Siefore> lista){
		String grupoTrabajador = null;
		for(Siefore obj1: lista){
			if(obj1.getClave().equals(siefore)){
				grupoTrabajador = obj1.getClaveGrupoTrabajador();
				break;
			}
		}
		
		return grupoTrabajador;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService#setearDerechoCargado(java.lang.String, java.util.List, java.util.List)
	 */
	@Override
	public List<ProcesoDerechoCargadoEntrada> setearDerechoCargado(String tipoRegimenSol, List<Parametro> listaParametro,List<ProcesoDerechoCargado> listaDerechoCargado) {
		List<ProcesoDerechoCargadoEntrada> listaSolicitante= new ArrayList<>();
		for (ProcesoDerechoCargado procesoDerechoCargado : listaDerechoCargado) {
    		 ProcesoDerechoCargadoEntrada cargado = new ProcesoDerechoCargadoEntrada();
    		 cargado.setCvTipoPension(procesoDerechoCargado.getCvTipoPension());
    		 cargado.setCvTipoPrestacion(procesoDerechoCargado.getCvTipoPrestacion());
    		 cargado.setCvTipoRegimen(procesoDerechoCargado.getCvTipoRegimen());
    		 cargado.setCvTipoRetiro(procesoDerechoCargado.getCvTipoRetiro());
    		 cargado.setCvTipoSeguro(procesoDerechoCargado.getCvTipoSeguro());
    		 cargado.setDescTipoPension(procesoDerechoCargado.getDescTipoPension());
    		 cargado.setDescTipoPrestacion(procesoDerechoCargado.getDescTipoPrestacion());
    		 cargado.setDescTipoRegimen(procesoDerechoCargado.getDescTipoRegimen());
    		 cargado.setDescTipoRetiro(procesoDerechoCargado.getDescTipoRetiro());
    		 cargado.setDescTipoSeguro(procesoDerechoCargado.getDescTipoSeguro());
    		 cargado.setFcInicioPension(fechaUtils.convertirFechaACadena(procesoDerechoCargado.getFcInicioPension(), ActivacionConstants.DDMMYYYY));
    		 cargado.setFcEmisionResolucion(fechaUtils.convertirFechaACadena(procesoDerechoCargado.getFcEmisionResolucion(), ActivacionConstants.DDMMYYYY));
    		 cargado.setNumeroResolucion(procesoDerechoCargado.getNumeroResolucion());
    		 cargado.setPorcentajeValuacion(procesoDerechoCargado.getPorcentajeValuacion());
    		 cargado.setRadioCargado(NumerosConstants.C_CERO);
    		 cargado.setSecuenciaPension(procesoDerechoCargado.getSecuenciaPension());
    		 cargado.setSemanasCotizadas(procesoDerechoCargado.getSemanasCotizadas());
    		   	 for (Parametro parametro : listaParametro) {
	        	obtenerParametroCargado(procesoDerechoCargado,cargado,tipoRegimenSol,parametro);
	        	}
	        	 listaSolicitante.add(cargado);
	        }
		return listaSolicitante;
		
		
	}

	/**
	 *  Metodo que obtiene la lista Cargado
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param procesoDerechoCargado
	 *  @param cargado
	 *  @param tipoRegimenSol
	 *  @param parametro
	 */
	protected void obtenerParametroCargado(ProcesoDerechoCargado procesoDerechoCargado,
			ProcesoDerechoCargadoEntrada cargado, String tipoRegimenSol, Parametro parametro) {
		 if(tipoRegimenSol.equals(parametro.getChParametro())) {
			 List<String> listaRetiros = new ArrayList<>(Arrays.asList(parametro.getChValorParametro().split(",")));
	   		if(listaRetiros.contains(procesoDerechoCargado.getCvTipoRetiro())) {
				  cargado.setRadioCargado(NumerosConstants.C_UNO);
			}
			 
		 } 
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService#validarPrecondicionesDisposicionesImss(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente, java.util.List, java.lang.Long, java.lang.String)
	 */
	@Override
	public String validarPrecondicionesDisposicionesImss(DatosExpediente datosExpediente, List<String> claves,
			Long idProcesar, String afore) {
		String resultado = null;
		if (datosExpediente.getBanderaExpedienteIdentifiacion() != 1) {
			return "R|El expediente de identificación no tiene estatus Permanente";
		}
		if (datosExpediente.getBanderaEnrolamiento() != 1) {
			return "R|El expediente Biométrico no tiene estatus Permanente";
		}
		for (String clavesMarcas : claves) {
			MatrizConvivencia matrizConvivencia = marcaOperativaService.marcaOperativaValida(idProcesar, clavesMarcas);
			logger.info("Respuesta: {}", matrizConvivencia);
			if (!validadorUtils.isEmpty(matrizConvivencia)) {
				RechazoPulssar rechazo = rechazoService.obtenerRechazo(matrizConvivencia.getTipoProcesoActual().getClaveProceso(), afore);
				return "N|".concat(rechazo.getMensaje());
			}
		}
		return resultado;
	}

	
	

}
