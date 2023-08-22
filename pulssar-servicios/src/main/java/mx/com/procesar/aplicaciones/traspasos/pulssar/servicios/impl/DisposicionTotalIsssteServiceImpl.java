package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AccionSieforeIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AportacionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSubcuentasDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuentaIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteCancelacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaMarcasVivienda;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FactorConversion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretEstatusViviendaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretMatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PrecioAccion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIsssteVis;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarDisposicionEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarDisposicionROEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Disposicion total issste
 * @author RARREOLA
 *
 */
@Service
public class DisposicionTotalIsssteServiceImpl implements DisposicionTotalIsssteService{

	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(DisposicionTotalIsssteServiceImpl.class);
	
	
	/**
	 * fechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
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
	 * Resolucion
	 */
	@Value("${url.consulta.iret.resolucion}")
	private String urlConsultaIretResolucion;
	
	/**
	 * dependencia utilidad validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	
	/**
	 * uriIsssteRegimenOrdinario
	 */
	@Value("#{propiedades['disposicionIssste.regimenOrdinario']}")
	private String uriIsssteRegimenOrdinario;
	
	
	/**
	 * uriDisposicionIsssteTotal
	 */
	@Value("#{propiedades['disposicionIssste.total']}")
	private String uriDisposicionIsssteTotal;
	
	
	/**
	 * uriCancelacion
	 */
	@Value("#{propiedades['cancelacion.disposicionTotal']}")
	private String uriCancelacion;
	
	
	/**
	 * Variable consulta Recepcion arcvhios
	 */
	@Value("#{propiedades['url.consulta.archivo.recepcion']}")
	private String consultaRecepcionArchivo;
	
	/**
	 * Generar cus
	 */
	@Override
	public RespuestaGeneraCusSalida generarCus(DatosTrabajador trabajador, UsuarioLogin user, String origen,
			Long folioRespuesta) {
		Calendar hoy = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(ActivacionConstants.DDMMYYYY);
		SimpleDateFormat sdfhora = new SimpleDateFormat(ActivacionConstants.KKMM);
		
		Date fechaNacimiento = fechaUtils.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(), "dd/MMM/yyyy");
		EntradaCus entradaCus = new EntradaCus();
		entradaCus.setServicioGeneraCus(ActivacionConstants.SERVICIO_GENERA_CUS);
		entradaCus.setCurpTitular(trabajador.getDatosCertificables().getCurp());
		entradaCus.setNssTitular(trabajador.getNss());
		
		entradaCus.setRfcTitular(trabajador.getDatosNoCertificables().getRfc());
		entradaCus.setNombreTitular(trabajador.getDatosCertificables().getNombre());
		entradaCus.setApellidoPaternoTitular(trabajador.getDatosCertificables().getApellidoPaterno());
		entradaCus.setApellidoMaternoTitular(trabajador.getDatosCertificables().getApellidoMaterno());
		entradaCus.setFechaNacimiento(sdf.format(fechaNacimiento));
		entradaCus.setNumeroCelularTitular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
		entradaCus.setCveAfore(user.getAforeUsuario());
		entradaCus.setNumeroFijoTitular(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
		entradaCus.setRegimenPensionTitular(ActivacionConstants.RESULTADO_RESPUESTA_02);
		entradaCus.setRolCiudadano(ActivacionConstants.RESULTADO_RESPUESTA_01);
		entradaCus.setTipoRetiroTotal(ActivacionConstants.RESULTADO_RESPUESTA_02);
		entradaCus.setCurpAgenteServicio(user.getCurpAgente());
		entradaCus.setNombreAgenteServicio(user.getSoloNombre());
		entradaCus.setApellidoPaternoAgenteServicio(user.getApellidoPaterno());
		entradaCus.setApellidoMaternoAgenteServicio(user.getApellidoMaterno());
		entradaCus.setNumeroAgenteServicio(user.getUsuario());
// 01-IMSS, 02-ISSSTE
		if(AgenteConstants.TIPO_AFILIACION_ISSSTE.equals(origen)){
			entradaCus.setInstitutoOtorgoDerecho(ActivacionConstants.RESULTADO_RESPUESTA_02);
		} else {
			entradaCus.setInstitutoOtorgoDerecho(ActivacionConstants.RESULTADO_RESPUESTA_01);
		}
		entradaCus.setOrigenSolicitud(ActivacionConstants.RESULTADO_RESPUESTA_01);
		entradaCus.setCveSucursal(ActivacionConstants.SUCURSAL);
		entradaCus.setFechaCita(sdf.format(hoy.getTime()));
		entradaCus.setHorarioCita(sdfhora.format(hoy.getTime()));


		RespuestaGeneraCusSalida salida = cusService.generarCus(entradaCus);
		
		if("01".equals(salida.getResultadoOperacion())){
			folioService.cerrarFolio(folioRespuesta, 1);
		} else {
			folioService.cerrarFolio(folioRespuesta, 3, salida.getDiagnosticoProcesar());
		}
		
		return salida;
	}

	/**
	 * Consultar no cargado issste
	 * @param entrada
	 * @return
	 */
	@Override
	public List<DisposicionIsssteSalida> consultarNoCargadoIssste(DisposicionIsssteEntrada entrada) {
		List<DisposicionIsssteSalida> respuestaGenerica = null;
		StringBuilder url = new StringBuilder();
		try{
			String uriDos = url.append(uriComunes).append("matrizderecho/consultarNoCargadoIssste").toString();
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<DisposicionIsssteEntrada> entidad = new HttpEntity<>(entrada, headerMedia);
			
			logger.info(uriDos);
			logger.info("Peticion generacion de folios consulta operativa {}", entrada.toString());

			ResponseEntity<String> respuesta = restTemplate.exchange(uriDos, HttpMethod.POST, entidad, String.class);
			
			JsonUtilsImpl<DisposicionIsssteSalida> json = new JsonUtilsImpl<>();
			 respuestaGenerica  = json.parseJsonToObjectList(respuesta.getBody(), DisposicionIsssteSalida.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a de consultar no cargado", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return respuestaGenerica;
	}
	
	
	
	/**
	 * Seteo de informacion
	 */
	@Override
	public List<ResolucionDisposicionIsssteVis> setearDatosResol(List<ResolucionDisposicionIssste> lista, List<Parametro> lparametro, String tipoSolicitante) {
		List<ResolucionDisposicionIsssteVis> listaNueva = null;
		ResolucionDisposicionIsssteVis salida;
		if(lista != null){
			listaNueva = new ArrayList<>();
			for(ResolucionDisposicionIssste objeto: lista){
				salida = new ResolucionDisposicionIsssteVis();
				salida.setCvClavePension(objeto.getCvClavePension());
				salida.setCvMovimiento(objeto.getCvMovimiento());
				salida.setCvTipoPension(objeto.getCvTipoPension());
				salida.setCvTipoPrestacion(objeto.getCvTipoPrestacion());
				salida.setCvTipoRegimen(objeto.getCvTipoRegimen());
				salida.setCvTipoRetiro(objeto.getCvTipoRetiro());
				salida.setCvTipoSeguro(objeto.getCvTipoSeguro());
				salida.setDescClavePension(objeto.getDescClavePension());
				salida.setDescMovimiento(objeto.getDescMovimiento());
				salida.setDescTipoPension(objeto.getDescTipoPension());
				salida.setDescTipoPrestacion(objeto.getDescTipoPrestacion());
				salida.setDescTipoRegimen(objeto.getDescTipoRegimen());
				salida.setDescTipoRetiro(objeto.getDescTipoRetiro());
				salida.setDescTipoSeguro(objeto.getDescTipoSeguro());
				salida.setFechaEmision(fechaUtils.convertirFechaACadena(objeto.getFechaEmision(), ActivacionConstants.DDMMYYYY));
				salida.setFechaInicioPension(fechaUtils.convertirFechaACadena(objeto.getFechaInicioPension(), ActivacionConstants.DDMMYYYY));
				salida.setIdResolucion(objeto.getIdResolucion());
				salida.setNumeroConcesion(objeto.getNumeroConcesion());
				salida.setSecuenciaPension(objeto.getSecuenciaPension());
				salida.setSemanasCotizadas(objeto.getSemanasCotizadas());
				salida.setNumeroIssste(objeto.getNumeroIssste());
				salida.setBandera(NumerosConstants.C_CERO);
				obtenerPArametro(lparametro, tipoSolicitante, salida, objeto);
				listaNueva.add(salida);
			}
		}
		
		return listaNueva;
	}

	/**
	 * Obtener parametro
	 * @param lparametro
	 * @param tipoSolicitante
	 * @param salida
	 * @param objeto
	 */
	private void obtenerPArametro(List<Parametro> lparametro, String tipoSolicitante,
			ResolucionDisposicionIsssteVis salida, ResolucionDisposicionIssste objeto) {
		for(Parametro obj:lparametro){
			StringBuilder buider = new StringBuilder();
			String var = buider.append(objeto.getCvTipoRegimen()).append(tipoSolicitante).toString();
			if(obj.getChParametro().equals(var)){
				List<String> listaRetiros = new ArrayList<>(Arrays.asList(obj.getChValorParametro().split(",")));
				if(listaRetiros.contains(objeto.getCvTipoRetiro())){
					salida.setBandera(NumerosConstants.C_UNO);
					break;
				}
			}
		}
	}


	
	/**
	 * Consultar issste retiro c
	 * @param entrada
	 * @return
	 */
	@Override
	public List<DisposicionIsssteSalida> consultarIsssteRetiroC(DisposicionIsssteEntrada entrada) {
		List<DisposicionIsssteSalida> respuesta = null;
		StringBuilder url = new StringBuilder();
		try{
			String uriNu = url.append(uriComunes).append("matrizderecho/consultarTipoRetiroC").toString();
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<DisposicionIsssteEntrada> entidad = new HttpEntity<>(entrada, headerMedia);
			
			logger.info(uriNu);
			logger.info("Peticion consulta retiro c {}", entrada.toString());

			ResponseEntity<String> res = restTemplate.exchange(uriNu, HttpMethod.POST, entidad, String.class);
			
			JsonUtilsImpl<DisposicionIsssteSalida> json = new JsonUtilsImpl<>();
			respuesta  = json.parseJsonToObjectList(res.getBody(), DisposicionIsssteSalida.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a de consultar retiro c", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return respuesta;
	}


	/**
	 * Consultar matriz derecho
	 * @param claveTipoRetiro
	 * @param claveTipoPension
	 * @param claveTipoSeguro
	 * @param claveTipoRegimen
	 * @param clavePension
	 * @param claveTipoPrestacion
	 * @param claveMovimiento
	 * @return
	 */
	@Override
	public IretMatrizDerecho consultarMatrizDerecho(String claveTipoRetiro, String claveTipoPension,
			String claveTipoSeguro, String claveTipoRegimen, String clavePension, String claveTipoPrestacion,
			String claveMovimiento) {
		IretMatrizDerecho iretMatrizDerecho = null;
        try{
			
			StringBuilder url = new StringBuilder();
			String uriDos = url.append(uriComunes).append("iretMatrizDerecho/consultarMatrizDerecho/{claveTipoRetiro}/{claveTipoPension}/{claveTipoSeguro}/{claveTipoRegimen}/{clavePension}/{claveTipoPrestacion}/{claveMovimiento}").toString();
			uriDos = uriDos.replace("{claveTipoRetiro}", claveTipoRetiro);
			uriDos = uriDos.replace("{claveTipoPension}", claveTipoPension);
			uriDos = uriDos.replace("{claveTipoSeguro}", claveTipoSeguro);
			uriDos = uriDos.replace("{claveTipoRegimen}", claveTipoRegimen);
			uriDos = uriDos.replace("{clavePension}", clavePension);
			uriDos = uriDos.replace("{claveTipoPrestacion}", claveTipoPrestacion);
			uriDos = uriDos.replace("{claveMovimiento}", claveMovimiento);
			logger.info("uri nueva: {}", uriDos);
			iretMatrizDerecho =  restTemplate.getForObject(uriDos, IretMatrizDerecho.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consultar los datos de matriz derecho", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return iretMatrizDerecho;
	}

	
	/**
	 * Obtener derecho de subcuenta por id matriz de derecho
	 */
	@Override
	public List<DerechoSubcuentaIssste> obtenerDerechoSubcuentaPorIdMatrizDerecho(Long idMatrizDerecho) {
		List<DerechoSubcuentaIssste> respuestaSalida = null; 
		try{
			
			StringBuilder url = new StringBuilder();
			String uriDos = url.append(uriComunes).append("derechoSubcuentaIssste/obtenerDerechoSubcuentaPorIdMatrizDerecho/{idMatrizDerecho}").toString();
			String uriNueva = uriDos.replace("{idMatrizDerecho}", idMatrizDerecho.toString());
			
			logger.info("url: {}", uriNueva);
			String respuesta =  restTemplate.getForObject(uriNueva, String.class);
			JsonUtilsImpl<DerechoSubcuentaIssste> json = new JsonUtilsImpl<>();
			respuestaSalida  = json.parseJsonToObjectList(respuesta, DerechoSubcuentaIssste.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consultar los datos de subcuenta por id matriz de derecho", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return respuestaSalida;
	}
	
	
	
	
	/**
	 * Edad del trabajador
	 */
	@Override
	public Integer obtenerEdadTrabajador(String fechaNacimiento) {
		
		Date fechaNac = fechaUtils.convertirCadenaAFecha(fechaNacimiento, FormatoConstants.FORMATO_FECHA_NACIMIENTO);
		Calendar cumple =Calendar.getInstance();
		Calendar hoy = Calendar.getInstance();
		
		cumple.setTime(fechaNac);
		
		int years= hoy.get(Calendar.YEAR) - cumple.get(Calendar.YEAR);

		
		if(hoy.get(Calendar.DAY_OF_YEAR) < cumple.get(Calendar.DAY_OF_YEAR)){
			years--;
		}
		return years;
	}
	/**
	 * Tipo solicitante no cargado
	 */
	@Override
	public List<String> obtenerTipoRetirosIdSolicitanteNoCargado(List<Parametro> lparametro, String tipoRegimen,
			String tipoSolicitante) {
		List<String> listaRetiros = null;
		if(Strings.isNotBlank(tipoRegimen)){
			listaRetiros = validarRegi(lparametro, tipoRegimen, tipoSolicitante, listaRetiros);
		}
		
		return listaRetiros;
	}

	/**
	 * Validar regimenes
	 * @param lparametro
	 * @param tipoRegimen
	 * @param tipoSolicitante
	 * @param listaRetiros
	 * @return
	 */
	private List<String> validarRegi(List<Parametro> lparametro, String tipoRegimen, String tipoSolicitante,
			List<String> listaRetiros) {
		List<String> listaRetirosAux = listaRetiros;
		boolean bandera = false;
		for(Parametro obj:lparametro){
			bandera = validarReg(tipoRegimen, tipoSolicitante, bandera, obj);
			if(bandera){
		    	listaRetirosAux = new ArrayList<>(Arrays.asList(obj.getChValorParametro().split(ActivacionConstants.COMA)));
				break;
			}
		}
		return listaRetirosAux;
	}

	private boolean validarReg(String tipoRegimen, String tipoSolicitante, boolean bandera, Parametro obj) {
		StringBuilder buider;
		boolean banderaAux = bandera;
		if(ActivacionConstants.REGIMEN_RO.equals(tipoRegimen)){
			buider = new StringBuilder();
			String var = buider.append(ActivacionConstants.REGIMEN_RO).append(tipoSolicitante).toString();
			if(obj.getChParametro().equals(var)){
				banderaAux = true;
			}
		}else{
			buider = new StringBuilder();
			String var = buider.append(ActivacionConstants.REGIMEN_DT).append(tipoSolicitante).toString();
			if(obj.getChParametro().equals(var)){
				banderaAux = true;
			}
		}
		return banderaAux;
	}

	/**
	 * Plan privado
	 */
	@Override
	public boolean validarSolicitantesPlanPrivado(List<Parametro> lparametro, String tipoSolicitante, String tipoRetiro) {
		boolean bandera=false;
		StringBuilder buider = new StringBuilder();
		if(Strings.isNotBlank(tipoRetiro)){
		for(Parametro obj:lparametro){
			String var = buider.append(ActivacionConstants.REGIMEN_RO).append(tipoSolicitante).toString();
			if(obj.getChParametro().equals(var)){
				bandera = true;
				break;
			}
		}
		}else{
			bandera = true;
		}
		
		return bandera;
	}

	/**
	 * Validar si curp existe
	 * @param curp
	 * @return
	 */
	@Override
	public BaseRespuesta<AportacionIssste> validarCurpExiste(String curp) {
		StringBuilder url = new StringBuilder();
		BaseRespuesta<AportacionIssste> resp  = null;
		String uriDos = url.append(uriComunes).append("/aportacion/issste/validarCurpExiste/{curp}").toString();
		String uriNueva = uriDos.replace("{curp}", curp);
		
		logger.info("url nueva: {}", uriNueva);
		try{
			ResponseEntity<BaseRespuesta<AportacionIssste>> respuesta = restTemplate.exchange(uriNueva,
					HttpMethod.GET, null, new ParameterizedTypeReference<BaseRespuesta<AportacionIssste>>() {
					});
	
			if (respuesta.getBody() != null) {
				resp = respuesta.getBody();
			}
		
	} catch(Exception e) {
		logger.error("Se presento un problema en el servicio de consultar los datos de aportacion ISSSTE", e);
		throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
	}

		return resp;
	}

	/**
	 * Obtener estatus vivienda issste
	 * @param tipoPRoceso
	 * @return
	 */
	@Override
	public List<IretEstatusViviendaMarca> obtenerEstatusViviendaIssste(List<String> tipoPRoceso) {
		List<IretEstatusViviendaMarca> respuestaGenerica = null;
		EntradaMarcasVivienda objeto = new EntradaMarcasVivienda();
		objeto.setIdTipoProceso(tipoPRoceso);
		StringBuilder url = new StringBuilder();
		try{
			String uriDos = url.append(uriComunes).append("marcasvivienda/estatus").toString();
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<EntradaMarcasVivienda> entidad = new HttpEntity<>(objeto, headerMedia);
			
			logger.info(uriDos);
			logger.info("Peticion estatus vivienda {}", objeto.toString());

			ResponseEntity<String> respuesta = restTemplate.exchange(uriDos, HttpMethod.POST, entidad, String.class);
			
			JsonUtilsImpl<IretEstatusViviendaMarca> json = new JsonUtilsImpl<>();
			 respuestaGenerica  = json.parseJsonToObjectList(respuesta.getBody(), IretEstatusViviendaMarca.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a de consultar estatus vivienda issste", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return respuestaGenerica;
	}

	/**
	 * Subcuentas rcv
	 * @param lista
	 * @return
	 */
	@Override
	public List<DatosCalculosMontos> obtenerCombinacionSubcuentasSaldosRcv(List<DerechoSubcuentaIssste> lista,
			DatosSaldos saldos, DisposicionIsssteEntrada entradaParams) {
		List<DatosCalculosMontos> listaRcv = null;
		if(lista != null){
			listaRcv = validarSubRcv(lista, saldos, entradaParams);
		}
		
		return listaRcv;
	}

	/**
	 * Validar lista rcv
	 * @param lista
	 * @param saldos
	 * @param entradaParams
	 * @param listaRcv
	 * @return
	 */
	private List<DatosCalculosMontos> validarSubRcv(List<DerechoSubcuentaIssste> lista, DatosSaldos saldos,
			DisposicionIsssteEntrada entradaParams) {
		List<DatosCalculosMontos> listaRcv = null;
		if(!lista.isEmpty()){
			listaRcv = new ArrayList<>();
			for(DerechoSubcuentaIssste objeto:lista){
				if(ActivacionConstants.SUBCUENTAS_ISSSTE_RCV.contains(objeto.getCvSubCuenta().getCvSubCuenta())){
					
					relacionarSaldosSubcuentasRcv(objeto,  saldos,  listaRcv, entradaParams);
					
				}
			}
		}
		return listaRcv;
	}

	/**
	 * Relacionar saldos subcuentas
	 * @param objeto
	 */
	private void relacionarSaldosSubcuentasRcv(DerechoSubcuentaIssste objeto, DatosSaldos saldos, List<DatosCalculosMontos> listaRcv, DisposicionIsssteEntrada entradaParams) {
		DatosCalculosMontos objetoMontos;
		 if(ActivacionConstants.SUBCUENTA_15.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && ActivacionConstants.SIEFORE.equals(entradaParams.getTipoRecurso())  && Strings.isNotBlank(saldos.getSaldoAportaCompRetiro())){
				objetoMontos = new DatosCalculosMontos();
				objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
				objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
				objetoMontos.setMonto(formateaMoneda(saldos.getSaldoAportaCompRetiro()));
				objetoMontos.setCampoSar(NumerosConstants.C_CERO);
				objetoMontos.setTabla(NumerosConstants.C_TRES);
				objetoMontos.setAcciones(ExpresionesConstants.VACIO);
				objetoMontos.setPrecioAccion(ExpresionesConstants.VACIO);
				objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
				listaRcv.add(objetoMontos);
			}
			
			if(ActivacionConstants.SUBCUENTA_22.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && ActivacionConstants.SIEFORE.equals(entradaParams.getTipoRecurso()) && Strings.isNotBlank(saldos.getSaldoRetiro92I())){
				objetoMontos = new DatosCalculosMontos();
				objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
				objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
				objetoMontos.setMonto(formateaMoneda(saldos.getSaldoRetiro92I()));
				objetoMontos.setAcciones(ExpresionesConstants.VACIO);
				objetoMontos.setPrecioAccion(ExpresionesConstants.VACIO);
				objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
				objetoMontos.setCampoSar(NumerosConstants.C_CERO);
				objetoMontos.setTabla(NumerosConstants.C_TRES);
				listaRcv.add(objetoMontos);
			}
			
			if(ActivacionConstants.SUBCUENTA_22.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && Strings.isNotBlank(saldos.getSaldoSar92())){
				objetoMontos = new DatosCalculosMontos();
				objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
				objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
				objetoMontos.setMonto(formateaMoneda(saldos.getSaldoSar92()));
				objetoMontos.setAcciones(ExpresionesConstants.VACIO);
				objetoMontos.setPrecioAccion(ExpresionesConstants.VACIO);
				objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
				if(!ActivacionConstants.SIEFORE.equals(entradaParams.getTipoRecurso())){
					objetoMontos.setMontoTotalSuma(saldos.getSaldoSar92());
				}
				 objetoMontos.setTabla(NumerosConstants.C_TRES);
				objetoMontos.setCampoSar(NumerosConstants.C_UNO);
				
				listaRcv.add(objetoMontos);
			}
			
			relacionarSubcuentasSaldosDos(objeto, saldos, listaRcv, entradaParams.getTipoRecurso());
			
	}


	


	/**
	 * Relacionar saldos y subcuentas
	 * @param objeto
	 * @param saldos
	 * @param listaRcv
	 * @param tipoRecurso
	 * @param listas
	 */
	private void relacionarSubcuentasSaldosDos(DerechoSubcuentaIssste objeto, DatosSaldos saldos,
			List<DatosCalculosMontos> listaRcv, String tipoRecurso) {
		DatosCalculosMontos objetoMontos;
		if(ActivacionConstants.SUBCUENTA_25.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && ActivacionConstants.SIEFORE.equals(tipoRecurso) && Strings.isNotBlank(saldos.getSaldoRetiroI08())){
			objetoMontos = new DatosCalculosMontos();
			objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
			objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
			objetoMontos.setMonto(formateaMoneda(saldos.getSaldoRetiroI08()));
			objetoMontos.setCampoSar(NumerosConstants.C_CERO);
			objetoMontos.setTabla(NumerosConstants.C_TRES);
			objetoMontos.setAcciones(ExpresionesConstants.VACIO);
			objetoMontos.setPrecioAccion(ExpresionesConstants.VACIO);
			objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
			listaRcv.add(objetoMontos);
		}
		
		if(ActivacionConstants.SUBCUENTA_27.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && ActivacionConstants.SIEFORE.equals(tipoRecurso) && Strings.isNotBlank(saldos.getSaldoCVI())){
			objetoMontos = new DatosCalculosMontos();
			objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
			objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
			objetoMontos.setMonto(formateaMoneda(saldos.getSaldoCVI()));
			objetoMontos.setCampoSar(NumerosConstants.C_CERO);
			objetoMontos.setTabla(NumerosConstants.C_TRES);
			objetoMontos.setAcciones(ExpresionesConstants.VACIO);
			objetoMontos.setPrecioAccion(ExpresionesConstants.VACIO);
			objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
			listaRcv.add(objetoMontos);
		}
		
		if(ActivacionConstants.SUBCUENTA_28.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && ActivacionConstants.SIEFORE.equals(tipoRecurso)  && Strings.isNotBlank(saldos.getSaldoAhorroSolidario())){
			objetoMontos = new DatosCalculosMontos();
			objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
			objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
			objetoMontos.setMonto(formateaMoneda(saldos.getSaldoAhorroSolidario()));
			objetoMontos.setCampoSar(NumerosConstants.C_CERO);
			objetoMontos.setTabla(NumerosConstants.C_TRES);
			objetoMontos.setAcciones(ExpresionesConstants.VACIO);
			objetoMontos.setPrecioAccion(ExpresionesConstants.VACIO);
			objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
			listaRcv.add(objetoMontos);
		}
	}
	
	

	/**
	 * Subcuentas rcv
	 * @param lista
	 * @return
	 */
	@Override
	public List<DatosCalculosMontos> obtenerCombinacionSubcuentasSaldosVivienda(List<DerechoSubcuentaIssste> lista,
			DatosSaldos saldos, String tipoRecurso) {
		List<DatosCalculosMontos> listaViv = null;
		StringBuilder buider = new StringBuilder();
			if(!lista.isEmpty()){
				buider.append(NumerosConstants.INT_CERO.toString());
				listaViv = new ArrayList<>();
				for(DerechoSubcuentaIssste objeto:lista){
			       if(ActivacionConstants.SUBCUENTAS_ISSSTE_VIVIENDA.contains(objeto.getCvSubCuenta().getCvSubCuenta())){
			    	   buider = relacionarSaldosSubcuentasViv(objeto,  saldos, listaViv,  tipoRecurso, buider);
					}
				}
				if(!listaViv.isEmpty()){
					listaViv.get(0).setMontoTotalSuma(buider.toString());
				}
				
			}
		return listaViv;
	}

	
	
	
	/**
	 * Relacionar saldos subcuentas
	 * @param objeto
	 */
	private StringBuilder relacionarSaldosSubcuentasViv(DerechoSubcuentaIssste objeto, DatosSaldos saldos, List<DatosCalculosMontos> listaViv, String tipoRecurso, StringBuilder buider) {
		StringBuilder buiderAux = buider;
		DatosCalculosMontos objetoMontos;
		List<FactorConversion> list = this.obtenerFactorConversion(ActivacionConstants.VALOR_AIVS_VIVIENDA, tipoRecurso, NumerosConstants.C_DOS);
		if(ActivacionConstants.SUBCUENTA_16.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && Strings.isNotBlank(saldos.getSaldoViviendaFI92())){
			objetoMontos = new DatosCalculosMontos();
			objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
			objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
			objetoMontos.setMonto(saldos.getSaldoViviendaFI92());
			validarListaPrecioAccionVivienda(objetoMontos, list);
			buiderAux = sumarMontoTotal(saldos.getSaldoViviendaFI92(),  buiderAux, objetoMontos.getSinPrecioAccion());
			objetoMontos.setTabla(NumerosConstants.C_DOS);
			
			listaViv.add(objetoMontos);
		}
		
		
        if(ActivacionConstants.SUBCUENTA_24.equals(objeto.getCvSubCuenta().getCvSubCuenta()) && Strings.isNotBlank(saldos.getSaldoFI08())){
        	objetoMontos = new DatosCalculosMontos();
        	objetoMontos.setClaveSubcuenta(objeto.getCvSubCuenta().getCvSubCuenta());
			objetoMontos.setDescripcionSubcuenta(objeto.getCvSubCuenta().getDescSubcuenta());
			objetoMontos.setMonto(saldos.getSaldoFI08());
			validarListaPrecioAccionVivienda(objetoMontos, list);
			objetoMontos.setTabla(NumerosConstants.C_DOS);
			buiderAux = sumarMontoTotal(saldos.getSaldoFI08(),  buiderAux, objetoMontos.getSinPrecioAccion());
			listaViv.add(objetoMontos);
		}
        
        return buiderAux;
	}
	
	
	/**
	 * Valida el precio accion
	 * @param objetoMontos
	 * @param listas
	 */
	private void validarListaPrecioAccionVivienda(DatosCalculosMontos objetoMontos, List<FactorConversion> listas) {
		if(listas != null){
			if(!listas.isEmpty()){
				objetoMontos.setFechaValor(fechaUtils.convertirFechaACadena(listas.get(0).getFechaValorFactor(), ActivacionConstants.DDMMYYYY));
				objetoMontos.setPrecioAccion(validarPrecioAccion(listas.get(0).getNuValorFactor()));
				objetoMontos.setAcciones(calcularAcciones(objetoMontos.getMonto(), objetoMontos.getPrecioAccion(), objetoMontos));
			}else{
				objetoMontos.setSinPrecioAccion(ActivacionConstants.SIN_PRECIO_ACCION);
				objetoMontos.setAcciones(ExpresionesConstants.VACIO);
				objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
			}
		}else{
			objetoMontos.setSinPrecioAccion(ActivacionConstants.SIN_PRECIO_ACCION);
			objetoMontos.setAcciones(ExpresionesConstants.VACIO);
			objetoMontos.setFechaValor(ExpresionesConstants.VACIO);
		}
	}
	
	/**
	 * Calcular acciones
	 * @param monto
	 * @param precioAccion
	 * @return
	 */
	private String calcularAcciones(String monto, String precioAccion, DatosCalculosMontos objetoMon){
		Double accionesRes;
		String accionCad= null;
		if(Strings.isNotBlank(precioAccion)){
			Double montoD = Double.valueOf(monto); 
		    Double precioA = Double.valueOf(precioAccion); 
		    accionesRes = montoD / precioA;
		    if(accionesRes.toString().indexOf(ActivacionConstants.PUNTO_CHAR) >= 0){
		    	 BigDecimal bd = new BigDecimal(accionesRes).setScale(2, RoundingMode.HALF_UP);
		    	 accionesRes = bd.doubleValue();
		    	accionCad =  extraerAcciones(accionesRes);
		    	 
		    }else{
		    	 if(accionesRes.toString().length() > 8){
		    		 accionCad = accionesRes.toString().substring(0, 8);
				 }
		    }
		  
		}else{
			objetoMon.setSinPrecioAccion(ActivacionConstants.SIN_PRECIO_ACCION);
			objetoMon.setAcciones(ExpresionesConstants.VACIO);
		}
		
		return accionCad;
	}

	/**
	 * Extraer acciones
	 * @param acciones
	 */
	private String extraerAcciones(Double accion) {
		StringBuilder buil = new StringBuilder();
		String acciones = accion.toString();
		String[] parts = acciones.split(ActivacionConstants.PUNTO_DIAGONAL);
		 String parte1 = parts[0];
		 String parte2 =  parts[1];
		 if(parte1.length() > NumerosConstants.INT_OCHO){
			 parte1 = parte1.substring(NumerosConstants.INT_CERO, NumerosConstants.INT_OCHO);
		 }
		 
		 if(parte2.length() > NumerosConstants.INT_SEIS){
			 parte2 = parte2.substring(NumerosConstants.INT_CERO, NumerosConstants.INT_SEIS);
		 }
		 
		 
		 return buil.append(parte1).append(ActivacionConstants.PUNTO_DOMINIO).append(parte2).toString();
	}
	
	
	
	
	/**
	 * Validar precion accion
	 * @param precioAccion
	 * @return
	 */
	private String validarPrecioAccion(Double precioAccion){
		String precioAux = precioAccion.toString();
		if(Strings.isBlank(precioAux)){
			precioAux = null;
		}
		
		return precioAux;
		
	}

	/**
	 * Agrupar lista de subcuentas
	 */
	@Override
	public List<DerechoSubcuentaIssste> agruparListaSubcuentas(List<DerechoSubcuentaIssste> lista) {
		List<DerechoSubcuentaIssste> listaNueva = new ArrayList<>();
		Map<String, List<DerechoSubcuentaIssste>> map = new HashMap<>();
		
		for(DerechoSubcuentaIssste obj: lista){
			String key = obj.getCvSubCuenta().getCvSubCuenta();
			if(map.get(key) == null){
				listaNueva.add(obj);
				map.put(key, new ArrayList<DerechoSubcuentaIssste>());
			}
			map.get(key).add(obj);
		}
		
		
		return listaNueva;
	}

	/**
	 * 
	 */
	@Override
	public List<PrecioAccion> obtenerPrecioAccion(String claveSiefore, String dias) {
		List<PrecioAccion> lista = null;
		StringBuilder url = new StringBuilder();
		try {
			String uriDos = url.append(uriComunes).append("precioAccion/precioAccion/{claveSiefore}/{diasFechaValor}").toString();
			String uriNueva = uriDos.replace("{claveSiefore}", claveSiefore);
			uriNueva = uriNueva.replace("{diasFechaValor}", dias);
			String respuesta = restTemplate.getForObject(uriNueva, String.class);

			if (!utileriaValidador.validarVacio(respuesta)) {
				JsonUtilsImpl<PrecioAccion> utileriaJson = new JsonUtilsImpl<>();
				lista = utileriaJson.parseJsonToObjectList(respuesta, PrecioAccion.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en el servicio de obtener precio accion", e);
		}
		return lista;
	}

	/**
	 * Obtener factor conversion
	 */
	@Override
	public List<FactorConversion> obtenerFactorConversion(String tipoValor, String tipoRecurso, String dias) {
		List<FactorConversion> lista = null;
		StringBuilder url = new StringBuilder();
		try {
			String uriDos = url.append(uriComunes).append("precioAccion/obtenerValorFactor/{tipoFactor}/{tipoRecurso}/{diasFechaValor}").toString();
			String uriNueva = uriDos.replace("{tipoFactor}", tipoValor);
			uriNueva = uriNueva.replace("{tipoRecurso}", tipoRecurso);
			uriNueva = uriNueva.replace("{diasFechaValor}", dias);
			String respuesta = restTemplate.getForObject(uriNueva, String.class);

			if (!utileriaValidador.validarVacio(respuesta)) {
				JsonUtilsImpl<FactorConversion> utileriaJson = new JsonUtilsImpl<>();
				lista = utileriaJson.parseJsonToObjectList(respuesta, FactorConversion.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en el servicio de obtener factor conversion", e);
		}
		return lista;
	}
	
	
	/**
	 * Monto total rcv
	 * @param monto
	 * @return
	 */
	protected StringBuilder sumarMontoTotal(String monto, StringBuilder buider, String precioAccion){
		StringBuilder buiderAu = buider;
		if(!ActivacionConstants.SIN_PRECIO_ACCION.equals(precioAccion)){
			if(buiderAu.toString().equals(NumerosConstants.INT_CERO.toString())){
				buiderAu = new StringBuilder();
				buiderAu.append(monto);
			}else{
				Double montoNuevo = Double.valueOf(monto) + Double.valueOf(buiderAu.toString());
				 BigDecimal bd = new BigDecimal(montoNuevo).setScale(NumerosConstants.INT_DOS, RoundingMode.HALF_UP);
				 montoNuevo = bd.doubleValue();
				 buiderAu = new StringBuilder();
				 buiderAu.append(montoNuevo.toString());
			}
		
		}
		
		return buiderAu;
		
	}

	/**
	 * Obtener siefores
	 */
	@Override
	public List<Siefore> obtenerSiefores(Long afore) {
		List<Siefore>  lista = null;
		StringBuilder url = new StringBuilder();
		try {
			String uriDos = url.append(uriComunes).append("catalogo/sieforeIssste/{afore}/{tipo}/{nuEstatusBloqueo}").toString();
			uriDos = uriDos.replace("{afore}", afore.toString());
			uriDos = uriDos.replace("{tipo}", NumerosConstants.C_UNO);
			uriDos = uriDos.replace("{nuEstatusBloqueo}", NumerosConstants.C_CERO);
			String respuesta = restTemplate.getForObject(uriDos, String.class);

			if (!utileriaValidador.validarVacio(respuesta)) {
				JsonUtilsImpl<Siefore> utileriaJson = new JsonUtilsImpl<>();
				lista = utileriaJson.parseJsonToObjectList(respuesta, Siefore.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en el servicio de obtener siefores", e);
		}
		return lista;
	}
	
	
	
	/**
	 * Consultarregimen ordinario
	 * @param entrada
	 * @return
	 */
	@Override
	public SalidaDisposicionTotalIssste consultarIsssteRegimenOrdinario(DatosGeneralesDispIssste entradaParams) {
		ResponseEntity<SalidaDisposicionTotalIssste> respuesta = null;
		SolicitarDisposicionROEntrada entrada = new SolicitarDisposicionROEntrada();
		SalidaDisposicionTotalIssste salida = null;
		
		setearDisposicionRegimenOrdinario(entradaParams, entrada);
		try{
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.set(ActivacionConstants.ID_SERVICIO, "825");
			headerMedia.set(ActivacionConstants.ID_CLIENTE, "35");
			headerMedia.set(ActivacionConstants.ID_EBUSINESS, "29");
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<SolicitarDisposicionROEntrada> entidad = new HttpEntity<>(entrada, headerMedia);
			
			logger.info(uriIsssteRegimenOrdinario);
			logger.info("Peticion regimen ordinario {}", entrada.toString());

			respuesta = restTemplate.exchange(uriIsssteRegimenOrdinario, HttpMethod.POST, entidad, SalidaDisposicionTotalIssste.class);
			if(respuesta != null){
				salida = respuesta.getBody();
			}
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a mostrar folios consulta regimen ordinario", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		return salida;
	}

	/**
	 * Setear datos de regimen ordinario
	 * @param entradaParams
	 * @param trabajador
	 * @param entrada
	 */
	private void setearDisposicionRegimenOrdinario(DatosGeneralesDispIssste entradaParams,
			SolicitarDisposicionROEntrada entrada) {
		entrada.setApellidoMaternoTrabajador(entradaParams.getApellidoMaterno());
		entrada.setApellidoPaternoTrabajador(entradaParams.getApellidoPaterno());
		entrada.setAseguradora(entradaParams.getClaveAforeCombo());
		entrada.setClaveAfore(entradaParams.getClaveAforeTrabajador());
		entrada.setClaveDoctoProbatorio(entradaParams.getClaveDocProbatorio());
		entrada.setClavePension(entradaParams.getClavePension());
		
		entradaParams.setNumeroConsecutivo("1");
		if(Strings.isNotBlank(entradaParams.getNumeroConsecutivo())){
			entrada.setConsecutivoTrabajador(Integer.valueOf(entradaParams.getNumeroConsecutivo()));
		}
		
		entrada.setCurp(entradaParams.getCurp());
		entrada.setCurpAgenteServicio(entradaParams.getCurpAsesor());
		entrada.setFechaEmisionResolucion(entradaParams.getFechaEmisionPension());
		entrada.setFechaInicioPension(entradaParams.getFechaInicioPension());
		entrada.setFechaPeriodoPago("02/02/2020");
		entrada.setFechaNacimiento(entradaParams.getFechaNacimiento());
		entrada.setFechaSolicitudTrabajador(entradaParams.getFechaSolicitud());
		entrada.setFolioSolicitud(entradaParams.getFolioSol());
		entrada.setIdSolicitante(entradaParams.getTipoSolicitante());
		if(Strings.isNotBlank(entradaParams.getSaldos().getSaldoVivienda92AIVS())){
			entrada.setMontoAivs1992(Double.valueOf(entradaParams.getSaldos().getSaldoVivienda92AIVS()));
		}
		
		if(Strings.isNotBlank(entradaParams.getSaldos().getSaldoFI08AIVS())){
			entrada.setMontoAivs2008(Double.valueOf(entradaParams.getSaldos().getSaldoFI08AIVS()));
		}
		
		setearSar92(entradaParams, entrada);
		entrada.setNombreTrabajador(entradaParams.getNombre());
		entrada.setNoPlanPrivado(entradaParams.getNumeroPlanPensiones());
		entrada.setSelloUnicoVerificacion(entradaParams.getSelloTrabajador());
		entrada.setSemanasCotizadas(Integer.valueOf(entradaParams.getNumeroSemanasCotizadas()));
		entrada.setTipoPension(entradaParams.getClaveTipoPension());
		if(Strings.isNotBlank(entradaParams.getClaveRegimenPlan())){
			entrada.setTipoRegimen(entradaParams.getClaveRegimenPlan());
		}else{
			entrada.setTipoRegimen(entradaParams.getClaveRegimen());
		}
		
		entrada.setTipoPrestacion(entradaParams.getClaveTipoPrestacion());
		entrada.setTipoSeguro(entradaParams.getClaveSeguro());
		entrada.setSecuenciaPension(entradaParams.getSecuenciaPension());
		entrada.setTipoRetiro(entradaParams.getClaveRetiro());
		List<AccionSieforeIssste> accionesSiefore = new ArrayList<>();
		
		setearSubcuentasRegimen(entradaParams, entrada, accionesSiefore);
		
		entrada.setCurpSolicitante(entradaParams.getCurp());
		entrada.setNss(entradaParams.getNss());
		entrada.setActuarioAutorizado(entradaParams.getActuario());
		
				
	}

	/**
	 * Setear sar 92
	 * @param entradaParams
	 * @param entrada
	 */
	private void setearSar92(DatosGeneralesDispIssste entradaParams, SolicitarDisposicionROEntrada entrada) {
		if(entradaParams.getSubcuentasRcv()!= null){
		for(DatosSubcuentasDispIssste obj :entradaParams.getSubcuentasRcv()){
	           if(ActivacionConstants.SUBCUENTA_22.equals(obj.getClaveSubcuenta()) && ActivacionConstants.TIPO_SERVICIO_1.equals(obj.getCampoSar92()) &&  Strings.isNotBlank(obj.getAcciones())){
	        	   entrada.setMontoSar92(Double.valueOf(obj.getMonto()));
	        	   break;
				}
				
			}
		}
	}

	/**
	 * Setear subcuentas regimen
	 * @param entradaParams
	 * @param entrada
	 * @param accionesSiefore
	 */
	private void setearSubcuentasRegimen(DatosGeneralesDispIssste entradaParams, SolicitarDisposicionROEntrada entrada,
			List<AccionSieforeIssste> accionesSiefore) {
		AccionSieforeIssste accion;
		if(entradaParams.getSubcuentasRcv()!= null){
			for(DatosSubcuentasDispIssste obj :entradaParams.getSubcuentasRcv()){
				accion = new AccionSieforeIssste();
				if(ActivacionConstants.SUBCUENTA_28.equals(obj.getClaveSubcuenta()) && Strings.isNotBlank(obj.getAcciones())){
					accion.setAccionesAhorroSolidario(Double.valueOf(obj.getMonto()));
					 accion.setClaveSiefore(this.obtenerGrupoTrabajador(obj.getSiefore(), entradaParams.getSieforesLista()));
					accionesSiefore.add(accion);
				}
				
	           if(ActivacionConstants.SUBCUENTA_27.equals(obj.getClaveSubcuenta()) && Strings.isNotBlank(obj.getAcciones())){
	        	   accion.setAccionesCesantiaVejez(Double.valueOf(obj.getMonto()));
	        	   accion.setClaveSiefore(this.obtenerGrupoTrabajador(obj.getSiefore(), entradaParams.getSieforesLista()));
	   			   accionesSiefore.add(accion);
				}
	           
	           obtenerSubcuentasDispo(entradaParams, accionesSiefore, accion, obj);
				
			}
			entrada.setAccionesSiefore(accionesSiefore);
		}
	}

	/**
	 * Obtener disposicion subcuentas
	 * @param entradaParams
	 * @param accionesSiefore
	 * @param accion
	 * @param obj
	 */
	private void obtenerSubcuentasDispo(DatosGeneralesDispIssste entradaParams,
			List<AccionSieforeIssste> accionesSiefore, AccionSieforeIssste accion, DatosSubcuentasDispIssste obj) {
		if(ActivacionConstants.SUBCUENTA_15.equals(obj.getClaveSubcuenta()) && Strings.isNotBlank(obj.getAcciones())){
        	   accion.setAccionesComplementariaRetiro(Double.valueOf(obj.getMonto()));
        	   accion.setClaveSiefore(this.obtenerGrupoTrabajador(obj.getSiefore(), entradaParams.getSieforesLista()));
   			   accionesSiefore.add(accion);
			}
           
           if(ActivacionConstants.SUBCUENTA_25.equals(obj.getClaveSubcuenta()) && Strings.isNotBlank(obj.getAcciones())){
        	   accion.setAccionesRetiro2008(Double.valueOf(obj.getMonto()));
        	   accion.setClaveSiefore(this.obtenerGrupoTrabajador(obj.getSiefore(), entradaParams.getSieforesLista()));
   			   accionesSiefore.add(accion);
			}
           
           if(ActivacionConstants.SUBCUENTA_22.equals(obj.getClaveSubcuenta()) && ActivacionConstants.TIPO_SERVICIO_1.equals(obj.getCampoSar92())  && Strings.isNotBlank(obj.getAcciones())){
        	   accion.setAccionesSar92(Double.valueOf(obj.getMonto()));
        	   accion.setClaveSiefore(this.obtenerGrupoTrabajador(obj.getSiefore(), entradaParams.getSieforesLista()));
   			   accionesSiefore.add(accion);
			}
	}

	/**
	 * Consultar disposicion total
	 * @param entrada
	 * @return
	 */
	@Override
	public SalidaDisposicionTotalIssste consultarIsssteDisposicionTotal(DatosGeneralesDispIssste entradaParams) {
		ResponseEntity<SalidaDisposicionTotalIssste> respuesta  = null;
		SolicitarDisposicionEntrada entradaSol = new SolicitarDisposicionEntrada();
		SalidaDisposicionTotalIssste salida = null;
		setearDatosDisposicion(entradaParams, entradaSol);
		try{
			
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			headerMedia.set(ActivacionConstants.ID_SERVICIO, "822");
			headerMedia.set(ActivacionConstants.ID_CLIENTE, "35");
			headerMedia.set(ActivacionConstants.ID_EBUSINESS, "29");
			HttpEntity<SolicitarDisposicionEntrada> entidad = new HttpEntity<>(entradaSol, headerMedia);
			
			logger.info(uriDisposicionIsssteTotal);
			logger.info("Peticion disposciion total {}", entradaSol.toString());

			respuesta = restTemplate.exchange(uriDisposicionIsssteTotal, HttpMethod.POST, entidad, SalidaDisposicionTotalIssste.class);
			if(respuesta != null){
				salida = respuesta.getBody();
			}
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio disposicion total", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		return salida;
	}

	/**
	 * Datos de disposicion
	 * @param entradaParams
	 * @param trabajador
	 * @param entrada
	 */
	private void setearDatosDisposicion(DatosGeneralesDispIssste entradaParams,
			SolicitarDisposicionEntrada entradaSol) {
		
		entradaSol.setApellidoMaternoTrabajador(entradaParams.getApellidoMaterno());
		entradaSol.setApellidoPaternoTrabajador(entradaParams.getApellidoPaterno());
		entradaSol.setAseguradora(entradaParams.getClaveAforeCombo());
		entradaSol.setClaveAfore(entradaParams.getClaveAforeTrabajador());
		entradaSol.setClaveDoctoProbatorio(entradaParams.getClaveDocProbatorio());
		entradaSol.setClavePension(entradaParams.getClavePension());
		
		entradaParams.setNumeroConsecutivo("1");
		if(Strings.isNotBlank(entradaParams.getNumeroConsecutivo())){
			entradaSol.setConsecutivoTrabajador(Integer.valueOf(entradaParams.getNumeroConsecutivo()));
		}
		entradaSol.setCurp(entradaParams.getCurp());
		entradaSol.setCurpAgenteServicio(entradaParams.getCurpAsesor());
		entradaSol.setFechaEmisionResolucion(entradaParams.getFechaEmisionPension());
		entradaSol.setFechaInicioPension(entradaParams.getFechaInicioPension());
		entradaSol.setFechaPeriodoPago("02/02/2020");
		entradaSol.setFechaNacimiento(entradaParams.getFechaNacimiento());
		entradaSol.setFechaSolicitudTrabajador(entradaParams.getFechaSolicitud());
		entradaSol.setFolioSolicitud(entradaParams.getFolioSol());
		entradaSol.setIdSolicitante(entradaParams.getTipoSolicitante());
		if(Strings.isNotBlank(entradaParams.getSaldos().getSaldoVivienda92AIVS())){
			entradaSol.setMontoAivs1992(Double.valueOf(entradaParams.getSaldos().getSaldoVivienda92AIVS()));
		}
		
		setearSbucuentasDispo(entradaParams, entradaSol);
		
		entradaSol.setNombreTrabajador(entradaParams.getNombre());
		entradaSol.setNoPlanPrivado(entradaParams.getNumeroPlanPensiones());
		entradaSol.setSelloUnicoVerificacion(entradaParams.getSelloTrabajador());
		entradaSol.setSemanasCotizadas(Integer.valueOf(entradaParams.getNumeroSemanasCotizadas()));
		entradaSol.setTipoPension(entradaParams.getClaveTipoPension());
		if(Strings.isNotBlank(entradaParams.getClaveRegimenPlan())){
			entradaSol.setTipoRegimen(entradaParams.getClaveRegimenPlan());
		}else{
			entradaSol.setTipoRegimen(entradaParams.getClaveRegimen());
		}
		
		entradaSol.setTipoPrestacion(entradaParams.getClaveTipoPrestacion());
		entradaSol.setTipoSeguro(entradaParams.getClaveSeguro());
		entradaSol.setSecuenciaPension(entradaParams.getSecuenciaPension());
		entradaSol.setTipoRetiro(entradaParams.getClaveRetiro());
		entradaSol.setCurpSolicitante(entradaParams.getCurpSolicitante());
		entradaSol.setNss(entradaParams.getNss());
		entradaSol.setActuarioAutorizado(entradaParams.getActuario());
		
				
	}

	/**
	 * Subcuentas dispo
	 * @param entradaParams
	 * @param entradaSol
	 */
	private void setearSbucuentasDispo(DatosGeneralesDispIssste entradaParams, SolicitarDisposicionEntrada entradaSol) {
		if(Strings.isNotBlank(entradaParams.getSaldos().getSaldoFI08AIVS())){
			entradaSol.setMontoAivs2008(Double.valueOf(entradaParams.getSaldos().getSaldoFI08AIVS()));
		}
		
		if(entradaParams.getSubcuentasRcv()!= null){
			for(DatosSubcuentasDispIssste obj :entradaParams.getSubcuentasRcv()){
		           if(ActivacionConstants.SUBCUENTA_22.equals(obj.getClaveSubcuenta()) && ActivacionConstants.TIPO_SERVICIO_1.equals(obj.getCampoSar92())){
		        	   entradaSol.setMontoSar92(Double.valueOf(obj.getMonto()));
		        	   break;
					}
					
				}
		}
	}
	
	
	/**
	 * Obtener grupo trabajador
	 * @param siefore
	 * @param lista
	 * @return
	 */
	private String obtenerGrupoTrabajador(String siefore, List<Siefore> lista){
		String grupoTrabajador = null;
		for(Siefore obj1: lista){
			if(obj1.getClave().equals(siefore)){
				grupoTrabajador = obj1.getClaveGrupoTrabajador();
				break;
			}
		}
		
		return grupoTrabajador;
	}
	
	
	/**
	 * Cancelacion
	 * @param entrada
	 * @return
	 */
	@Override
	public CancelacionSalida consultarCancelacion(DatosGeneralesDispIssste entradaParams) {
    ResponseEntity<CancelacionSalida> respuesta  = null;
    CancelacionEntrada entradaCan = new CancelacionEntrada();
    entradaCan.setCurp(entradaParams.getCurp());
    entradaCan.setCveAfore(entradaParams.getAforeTrabajador());
    entradaCan.setFolioSolicitud(entradaParams.getFolioSol());
    entradaCan.setNss(entradaParams.getNss());
    entradaCan.setSecuenciaPension(entradaParams.getSecuenciaPension());
    CancelacionSalida salidaCa = null;
		try{
			HttpHeaders headerMediaC = new HttpHeaders();
			headerMediaC.setContentType(MediaType.APPLICATION_JSON);
			headerMediaC.set(ActivacionConstants.ID_SERVICIO, "830");
			headerMediaC.set(ActivacionConstants.ID_CLIENTE, "35");
			headerMediaC.set(ActivacionConstants.ID_EBUSINESS, "29");
			HttpEntity<CancelacionEntrada> entidad = new HttpEntity<>(entradaCan, headerMediaC);
			
			logger.info(uriCancelacion);
			logger.info("Peticion disposciion total {}", entradaCan.toString());

			respuesta = restTemplate.exchange(uriCancelacion, HttpMethod.POST, entidad, CancelacionSalida.class);
			if(respuesta != null){
				salidaCa = respuesta.getBody();
			}
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio cancelacion", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return salidaCa;
	}

	/**
	 * Validar expediente servicio
	 */
	@Override
	public String validarExpedienteServicio(String folio, DatosTrabajador datos, UsuarioLogin usuarioLogin) {
		logger.info("Datos entrada metodo validarExpedienteServicio: {}, {}, {}", folio, datos.getDatosCertificables().getCurp(), usuarioLogin.getAforeUsuario());
		String respuesta = ActivacionConstants.RESULTADO_OPERACION_02;
		String url = consultaRecepcionArchivo;
		url = url.replace("{foliopulssar}", folio);
		url = url.replace("{tipoArchivo}", ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		logger.info("Peticion de validacion de archivo {}", url);
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadValidacion = new HttpEntity<>(headerMedia);
		ResponseEntity<ArchivoRecibido> respuestaArchivo = restTemplate.exchange(url, HttpMethod.GET, entidadValidacion,
				ArchivoRecibido.class);
		if (!utileriaValidador.validarObjetoNulo(respuestaArchivo.getBody())) {
			ArchivoRecibido archivoRecibido = respuestaArchivo.getBody();
			if(ActivacionConstants.RESULTADO_OPERACION_01.equals(archivoRecibido.getResultadoOperacion()) && ActivacionConstants.DIAGNOSTICO_500.equals(archivoRecibido.getDiagnostico())){
				respuesta = ActivacionConstants.RESULTADO_OPERACION_01;
			} else if(ActivacionConstants.RESULTADO_OPERACION_02.equals(archivoRecibido.getResultadoOperacion()) && ActivacionConstants.DIAGNOSTICO_030.equals(archivoRecibido.getDiagnostico())){
				
				respuesta = ActivacionConstants.RESULTADO_OPERACION_03;
			} else if(ActivacionConstants.RESULTADO_OPERACION_02.equals(archivoRecibido.getResultadoOperacion())) {
				respuesta = ActivacionConstants.RESULTADO_OPERACION_02;	
			}
		}

		return respuesta;
	}

	/**
	 * Validar si se realiza la cancelacion
	 * @param servicio
	 */
	@Override
	public List<DisposicionIsssteCancelacion>  validarCancelacion(List<FolioSalida> folios, DatosTrabajador trabajador, List<FolioSalida> foliosPadres, String idFolio) {
		boolean bandera = false;
		String folioPadreN;
		List<DisposicionIsssteCancelacion>  listaN = null;
		for(FolioSalida obj: folios){
			if(obj.getFolioDetalles() != null){
				bandera = validarProceso(bandera, obj);
				if(bandera){
					break;
				}
			}
		}
		
		folioPadreN = obtenerFolioPadre(foliosPadres, idFolio);
		
		if(bandera){
			listaN = consultarDispoCancel(trabajador.getNss(), trabajador.getDatosCertificables().getCurp(), folioPadreN);
		}
		
		return listaN;
		
		
	}

	/**
	 * Validar proceso
	 * @param bandera
	 * @param obj
	 * @return
	 */
	private boolean validarProceso(boolean bandera, FolioSalida obj) {
		boolean banderaAuxN = bandera;
		for(FolioDetalle obj1: obj.getFolioDetalles()){
			if(ActivacionConstants.ID_PROCESO_SOLICITUD_OP46.equals(obj1.getIdProceso())){
				banderaAuxN = true;
				break;
			}
		}
		return banderaAuxN;
	}

	/**
	 * Obtener folio padre
	 * @param foliosPadres
	 * @param idFolio
	 * @param folioPadre
	 * @return
	 */
	private String obtenerFolioPadre(List<FolioSalida> foliosPadres, String idFolio) {
		String folioPadreN = null;
		for(FolioSalida objt: foliosPadres){
			if(objt.getIdFolioPulssar().equals(Long.valueOf(idFolio))){
				folioPadreN = objt.getChFolio();
				break;
			}
		}
		return folioPadreN;
	}
	
	/**
	 * Consultar disposicion cancelacion
	 * @return
	 */
	private List<DisposicionIsssteCancelacion>  consultarDispoCancel(String nss, String curp, String folioSol){
		StringBuilder url = new StringBuilder();
		ResponseEntity<String> respuesta;
		List<DisposicionIsssteCancelacion> resp;
		String nssAux = nss;
		if(Strings.isBlank(nssAux)){
			nssAux = NumerosConstants.C_CERO;
		}
		try{
			String uriDos = url.append(uriComunes).append("disposicionissste/consultarDisposicionIssste/{curp}/{nss}/{folioIssste}").toString();
			uriDos = uriDos.replace("{curp}", curp);
			uriDos = uriDos.replace("{nss}", nssAux);
			uriDos = uriDos.replace("{folioIssste}", folioSol);
			respuesta = restTemplate.exchange(uriDos, HttpMethod.GET, null, String.class);
			JsonUtilsImpl<DisposicionIsssteCancelacion> json = new JsonUtilsImpl<>();
			resp  = json.parseJsonToObjectList(respuesta.getBody(), DisposicionIsssteCancelacion.class);
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a validar fecha banxico cancelacion", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		return resp;
	}
	
	/**
	 * Validar si se muestra el cancelar
	 */
	@Override
	public String validarDatosCancel(List<DisposicionIsssteCancelacion> listas) {
		String  bandera = NumerosConstants.C_CERO;
		if(listas != null){
			bandera = validarDatos(listas, bandera);
		}
		return bandera;
	}

	/**
	 * Validar datos
	 * @param listas
	 * @param bandera
	 * @return
	 */
	private String validarDatos(List<DisposicionIsssteCancelacion> listas, String bandera) {
		String banderaAux = bandera;
		if(!listas.isEmpty()){
			banderaAux = NumerosConstants.C_UNO;
		}
		return banderaAux;
	}

	
	/**
	 * formatear a moneda 
	 * @param valor
	 * @return
	 */
	private String formateaMoneda(String valor) {
		Double x = NumberUtils.toDouble(valor, 0d);
		return NumberFormat.getCurrencyInstance(Locale.US).format(x);
	}
	
}
