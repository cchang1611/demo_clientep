package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AnexoATrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraMovimientoModificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CanaseService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GeneroEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AnexoATrabajadorIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CURPStruct;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Canase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CargaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CuerpoPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CuerpoPermanenciaProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurp;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseFormulario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioLaboralTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioParticularTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosReferenciasTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DomicilioLaboral;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivoDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioFechas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTiempoTramiteMod;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Proceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RechazoBloque;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencias;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExpedienteDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * @author medoming
 *
 */
@Service
public class ModificacionTrabajadorServiceImpl implements ModificacionTrabajadorService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ModificacionTrabajadorServiceImpl.class);
	
	/**
	 * Constante con la url de rest Flujo de modificacion
	 */	
	@Value("${url.obtenerFlujo}")
	private String restObtenerFlujo;
	
	/**
	 * Url Servicio OP13
	 */
	@Value("${url.operacion13}")
	private String urlActualizaTrabajador;
	
	/**
	 * Url Servicio Permanencia
	 */
	@Value("${url.permanencia}")
	private String urlPermanenciaExp;
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
    /**
     * ConsultaSelloProxyService
     */
    @Autowired
	private ConsultaSelloService consultaSelloService;
	
	/**
	 * Inyeccion de dependencia fechaUtils
	 */
    @Autowired
	private FechaUtils fechaUtils;
    
	/**
	 * dependencia utilidad fecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	/**
	 * dependencia utilidad validador
	 */
	@Autowired 
	private ValidadorUtils validadorUtils;
	/**
	 * Utileria Cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;

	/**
	 * recuperacion de informacion de renapo
	 */
	@Value("${comunes.obtener.renapo.uri}")
	private String uriRenapo;
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	/**
	 * Constante con la url de rest Validacion Marca Operativa
	 */	
	@Value("${url.validacion.marca.operativa}")
	private String urlValidacionMarca;
	
	/**
	 * Inyeccion de service expediente
	 */
	@Autowired
	private EstatusExpedienteService expedienteService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Service bitacora movimiento
	 */
	@Autowired
	private BitacoraMovimientoModificacionService bitacoraMovimientoModificacionService;
	
	/**
	 * Notificacio de actualizacion de datos
	 */
	@Autowired
	private NotificacionService notificacionService;
	
	/**
	 * servicio folio
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * url comunes
	 */
	@Value("${uri.comunes}")
	private String urlComunes;
	
	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Inyeccion notificacion expediente service
	 */
	@Autowired
	private NotificacionExpedienteService notificacionExpedienteService;

	/**
	 * Inyeccion servicio proceso pendiente
	 */
	@Autowired
	private ProcesoPendienteService serviceProcesoPendiente;
	
	/**
	 * Inyeccion canace service
	 */
	@Autowired
	private CanaseService canaceService;
	
	/**
	 * Inyeccion anexo service
	 */
	@Autowired
	private AnexoATrabajadorService anexoService;
	
	/**
	 * Inyeccion reimpresion tramite service
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService#obtenerRespuestaFlujo(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion)
	 */
	@Override
	public FlujosEntrada obtenerRespuestaFlujo(EntradaModificacion entradaModificacion, DatosTrabajador trabajador, ExpedienteSalida expediente){
		FlujosEntrada entrada = new FlujosEntrada();
		FlujosEntrada salida = null;
		entrada.setIdProcesar(trabajador.getProcesar());
		entrada.setEstatusBiometrico(expediente.getEstatusEnrolamiento());
		entrada.setEstatusIdentificacion(expediente.getEstatusExpedienteIdentificacion());
		entrada.setCurpNueva(entradaModificacion.getDatosBaseCurp().getCurpNueva());
		entrada.setCurpSolicitante(entradaModificacion.getDatosBaseCurp().getCurpSolicitante());
		entrada.setTipoSolicitante(entradaModificacion.getDatosBaseCurp().getTipoSolicitante());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JsonUtilsImpl<FlujosEntrada> json = new JsonUtilsImpl<>();
		String jsonRequest = json.parseObjectToJsonSC(entrada);
		HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
		logger.info(ModificacionTrabajadorConstants.PETICION,jsonRequest);
		ResponseEntity<String> response = restTemplate.exchange(restObtenerFlujo,HttpMethod.POST, entity,String.class);
		logger.error("La respuesta de Flujo validacion {} ", response.getBody());
		if (!validadorUtils.validarObjetoNulo(response) && !validadorUtils.validarObjetoNulo(response.getBody())){
			JsonUtilsImpl<FlujosEntrada> jsonSalida = new JsonUtilsImpl<>();
			salida = jsonSalida.parseJsonToObject(response.getBody(),FlujosEntrada.class);
		}else{
			throw new BusinessException("ERROR OBTENIENDO FLUJO");
		}
		logger.error("El flujo de validacion obtenido es: {} con tipoMovimiento: {} ",salida.getFlujoValidacion(), salida.getMovimiento());
		return salida;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService#ejecutarModificacion(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador)
	 */
	@Override
	public SalidaActualizaDatos ejecutarModificacion(EntradaModificacion entradaModificacion, DatosTrabajador trabajador,String banderaRelanzamiento){
		SalidaActualizaDatos salida = new SalidaActualizaDatos();
		try{
		entradaModificacion.setCurp(validadorUtils.isEmpty(trabajador.getDatosCertificables().getCurp()) ? null : utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()));
		entradaModificacion.getDatosBaseCurp().setIndicadorDeDuplicidad(ModificacionTrabajadorConstants.INDICADOR_DE_DUPLICIDAD);
		entradaModificacion.getDatosBaseCurp().setIndicadorDeServicioBiometrico(ModificacionTrabajadorConstants.INDICADOR_BIOMETRICO);
		
		if(!trabajador.getTipoAfiliacion().equals(ModificacionTrabajadorConstants.TIPO_AFILIACION_ISSSTE) &&
				!trabajador.getTipoAfiliacion().equals(ModificacionTrabajadorConstants.TIPO_AFILIACION_INDEPENDIENTE_ISSSTE) &&
				!trabajador.getTipoAfiliacion().equals(ModificacionTrabajadorConstants.TIPO_AFILIACION_ISSSTE_ASIGNADO)){
			entradaModificacion.setNss(trabajador.getNss());
		}
		logger.info("Entrada modificacion: {} ",entradaModificacion);
		String fechaNacimiento = fechaUtils.ObtenerFechas(entradaModificacion.getDatosBaseCurp().getFechaDeNacimiento());
		entradaModificacion.getDatosBaseCurp().setFechaDeNacimiento(fechaNacimiento);
		if(validadorUtils.validarObjetoNulo(banderaRelanzamiento)){
			Nacionalidad nacionalidad = servicioCatalogo.obtenerNacionalidadPorClave(entradaModificacion.getDatosBaseCurp().getNacionalidad());
			if(!validadorUtils.validarObjetoNulo(nacionalidad)) {
				entradaModificacion.getDatosBaseCurp().setNacionalidad(nacionalidad.getChValorDespliegue());
			}
		}
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			logger.error("urlActualizaTrabajador:::: {}", urlActualizaTrabajador);
			JsonUtilsImpl<EntradaModificacion> json = new JsonUtilsImpl<>();
			String jsonRequest = json.parseObjectToJsonSC(entradaModificacion);
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
			logger.info(ModificacionTrabajadorConstants.PETICION, jsonRequest);
			
			ResponseEntity<String> response = restTemplate.exchange(urlActualizaTrabajador, HttpMethod.POST, entity,String.class);
			if(!validadorUtils.validarObjetoNulo(response)){
				logger.error("La respuesta de Op13 {} ", response.getBody());
				JsonUtilsImpl<SalidaActualizaDatos> jsonSalida = new JsonUtilsImpl<>();
				salida = jsonSalida.parseJsonToObject(response.getBody(), SalidaActualizaDatos.class);
				if(ModificacionTrabajadorConstants.RESULTADO_OK.equals(salida.getSsnrop().getCodRespuesta())){	
					this.obtenerRechazos(salida);
					salida.setResultadoActualizacion("OK");				
					if(ServiciosConstants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())) {
						consultaSelloService.guardarSello(Long.valueOf(entradaModificacion.getDatosBaseCurp().getSelloVoluntadTramite()), "46");
					}
				}else{
					salida.setResultadoActualizacion(ModificacionTrabajadorConstants.ERROR);
					logger.error("Error: {}", salida.getSsnrop().getDescRespuesta());
				}
			}else{
				salida.setResultadoActualizacion(ModificacionTrabajadorConstants.ERROR);
				logger.error("Error: Se presento un error inesperado en el servicio de actualización de datos op13.");
			}
			
		} catch (HttpClientErrorException ex) {
			salida.setResultadoActualizacion(ModificacionTrabajadorConstants.ERROR);
			logger.error("Se presento problema en el servicio de actualizacion de datos", ex);
		} catch (Exception e){
			salida.setResultadoActualizacion(ModificacionTrabajadorConstants.ERROR);
			logger.error("Error en modificacion de datos", e);
		}
		return salida;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService#ejecutarPermanencia(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia)
	 */
	@Override
	public SalidaPermanencia ejecutarPermanencia(EntradaPermanencia entradaPermanencia){
		SalidaPermanencia salida = new SalidaPermanencia();
		try{
			entradaPermanencia = validarEntradaPermanencia(entradaPermanencia);
			entradaPermanencia.setFechaDeNacimiento(fechaUtils.ObtenerFechas(entradaPermanencia.getFechaDeNacimiento()));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			logger.error("urlPermanenciaExp:::: {}", urlPermanenciaExp);
			JsonUtilsImpl<EntradaPermanencia> json = new JsonUtilsImpl<>();
			String jsonRequest = json.parseObjectToJsonSC(entradaPermanencia);
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
			logger.error("Peticion:::: {}", jsonRequest);
			
			ResponseEntity<String> response = restTemplate.exchange(urlPermanenciaExp, HttpMethod.POST, entity,String.class);
			if(!validadorUtils.validarObjetoNulo(response)){
			   logger.error("La respuesta de Permanencia {} ", response.getBody());
			   JsonUtilsImpl<SalidaPermanencia> jsonSalida = new JsonUtilsImpl<>();
			   salida = jsonSalida.parseJsonToObject(response.getBody(), SalidaPermanencia.class);
			}else{
				throw new BusinessException("ERROR INVOCAR PERMANENCIA");
			}
		} catch (HttpClientErrorException ex) {
			logger.error("Se presento problema en el servicio de permanencia de expediente", ex);
		}
		
		return salida;
	}
	
	/**
     * @param entradaModificacion
     * @param user
     * @return
     */
	@Override
	public String consultarSellos(EntradaModificacion entradaModificacion, UsuarioLogin user,String tipoSolicitante){
		logger.info("Entrada consulta sellos tipo solicitante: {}",tipoSolicitante);
    	String respuesta = null;
    	if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante)) {
	    	Sello sello = consultaSelloService.obtenerSelloTrabajador(user.getCurpAgente(),entradaModificacion.getDatosBaseCurp().getCurpNueva(),entradaModificacion.getEntidadOrigen());
			if(!validadorUtils.validarObjetoNulo(sello)){
			    if("01".equals(sello.getClaveStatusSello())){
					entradaModificacion.getDatosBaseCurp().setSelloVoluntadTramite(sello.getId().toString());
					respuesta = "OK";
			    }
			}else{
				 respuesta =  "No se encontro sello de voluntad";
			}
    	}else {
    		entradaModificacion.getDatosBaseCurp().setSelloVoluntadTramite("00000000000000");
    		respuesta = "OK";
    		logger.info("seteo de sello diferente a titular: {}",entradaModificacion.getDatosBaseCurp().getSelloVoluntadTramite());
    	}
    	Sello selloEmpleado = consultaSelloService.obtenerSelloEmpleado(user.getCurpAgente(), user.getAforeUsuario());
		if(!validadorUtils.validarObjetoNulo(selloEmpleado)){
		    if("01".equals(selloEmpleado.getClaveStatusSello())){
				entradaModificacion.getDatosBaseCurp().setSelloVerificacionBiometrica(selloEmpleado.getId().toString());
				respuesta = "OK";
		    }
		}else{
			respuesta =  "No se encontro sello de verificación biometrica";
		}
		logger.error(respuesta);
	    return respuesta;
    }  
    
    /**
     * @param salida
     */
    private void obtenerRechazos(SalidaActualizaDatos salida){
    	List<RechazoBloque> rechazos = new ArrayList<>();
    	if(!validadorUtils.validarObjetoNulo(salida.getObjetoRespuesta().getDatosBaseCurp())){
    		obtenerRechazoBloque(rechazos,ModificacionTrabajadorConstants.LABEL_DATOS_BASE_CURP,salida.getObjetoRespuesta().getDatosBaseCurp().getResultadoDeLaOperacion(),salida.getObjetoRespuesta().getDatosBaseCurp().getListaDiagnosticos());
    	}
    	if(!validadorUtils.validarObjetoNulo(salida.getObjetoRespuesta().getDatosDomicilioLaboralTrabajador())){
    		obtenerRechazoBloque(rechazos,ModificacionTrabajadorConstants.LABEL_DATOS_DOM_LABORAL,salida.getObjetoRespuesta().getDatosDomicilioLaboralTrabajador().getResultadoDeLaOperacion(),salida.getObjetoRespuesta().getDatosDomicilioLaboralTrabajador().getListaDiagnosticos());
    	}
    	
    	if(!validadorUtils.validarObjetoNulo(salida.getObjetoRespuesta().getDatosDomicilioParticularTrabajador())){    		
    		obtenerRechazoBloque(rechazos,ModificacionTrabajadorConstants.LABEL_DATOS_DOM_PARTICULAR,salida.getObjetoRespuesta().getDatosDomicilioParticularTrabajador().getResultadoDeLaOperacion(),salida.getObjetoRespuesta().getDatosDomicilioParticularTrabajador().getListaDiagnosticos());
    	}
    	
    	if(!validadorUtils.validarObjetoNulo(salida.getObjetoRespuesta().getDatosReferenciasTrabajador())){
    		obtenerRechazoBloque(rechazos,ModificacionTrabajadorConstants.LABEL_DATOS_REF_TRABAJADOR,salida.getObjetoRespuesta().getDatosReferenciasTrabajador().getResultadoDeLaOperacion(),salida.getObjetoRespuesta().getDatosReferenciasTrabajador().getListaDiagnosticos());
    	}
		
    	if(!validadorUtils.validarObjetoNulo(salida.getObjetoRespuesta().getListaBeneficiariosTrabajador())){
    		for(DatosBeneficiarioTrabajadorSalida beneficiario :salida.getObjetoRespuesta().getListaBeneficiariosTrabajador().getBeneficiario()) {
        		obtenerRechazoBloque(rechazos,utileriaCadena.obtenerCadenaConcatenada(false, ModificacionTrabajadorConstants.LABEL_DATOS_BENEFICIARIOS_TRABAJADOR,ExpresionesConstants.ESPACIO,beneficiario.getCurpDeBeneficiario()),beneficiario.getResultadoDeLaOperacion(),beneficiario.getListaDiagnosticos());
    		}
    	}
		salida.setRechazosBloque(rechazos);
		for(RechazoBloque rech : rechazos) {
			logger.error("Rechazo Bloque:::::{} :::: Diagnostico {}",rech.getBloque(),rech.getRechazos());
		}
    }
    
    
    
    
    /**
	 * Metodo encarga de obtener datos de renapo
	 * @param curp
	 * @return
	 */
    @Override
	public Renapo obtenerDatosRenapo(DatosTrabajador trabajador){
		logger.info("Inicio se obtienen datos de renapo {}", trabajador.getDatosCertificables().getCurp());
		logger.info(">>Curp: {}",trabajador.getDatosCertificables().getCurp());
		logger.info(">>Nombre: {}",trabajador.getDatosCertificables().getNombre());
		logger.info(">>ApellidoPaterno: {}",trabajador.getDatosCertificables().getApellidoPaterno());
		logger.info(">>ApellidoMaterno: {}",trabajador.getDatosCertificables().getApellidoMaterno());
		logger.info(">>Sexo: {}",trabajador.getDatosCertificables().getGenero());
		logger.info(">>FechaNacimiento: {}",trabajador.getDatosCertificables().getFechaNacimiento());
		logger.info(">>EntidadNacimiento: {}",trabajador.getDatosCertificables().getEntidadNacimiento());
		logger.info(">>Nacionalidad: {}",trabajador.getDatosNoCertificables().getClaveNacionalidad());
		
		CURPStruct datos = null;
		Renapo renapo = new Renapo();
			renapo.setNombre(ExpresionesConstants.VACIO);
			renapo.setApellidoPaterno(ExpresionesConstants.VACIO);
			renapo.setApellidoMaterno(ExpresionesConstants.VACIO);
			renapo.setCurp(ExpresionesConstants.VACIO);
			renapo.setFechaNacmiento(ExpresionesConstants.VACIO);
			renapo.setEntidadNacimiento(ExpresionesConstants.VACIO);
			renapo.setSexo(ExpresionesConstants.VACIO);
			renapo.setCurpsHistoricas(ExpresionesConstants.VACIO);
			renapo.setNacionalidad(ExpresionesConstants.VACIO);
		try{
			datos = this.obtenerDatosCurp(trabajador.getDatosCertificables().getCurp());
			if(!validadorUtils.validarObjetoNulo(datos)) {
				renapo.setNombre(datos.getNombres());
				renapo.setApellidoPaterno(datos.getApellido1());
				renapo.setApellidoMaterno(datos.getApellido2());
				renapo.setCurp(datos.getCurp());
				renapo.setNacionalidad(datos.getNacionalidad());
				Date auxiliarFecha = utileriaFecha.convertirCadenaAFecha(datos.getFechNac(), FormatoConstants.FORMATO_FECHA_RENAPO);
				String fechaNacimientoRenapo = utileriaFecha.convertirFechaACadena(auxiliarFecha, FormatoConstants.FORMATO_FECHA_NACIMIENTO);
				renapo.setFechaNacmiento(fechaNacimientoRenapo);
				renapo.setCveEntidadNacimiento(datos.getCveEntidadNac());
				EntidadFederativa entidad = servicioCatalogo.obtenerEntidad(datos.getCveEntidadNac());
				renapo.setEntidadNacimiento(validadorUtils.validarObjetoNulo(entidad) ? ExpresionesConstants.VACIO : entidad.getDescripcion());
				GeneroEnum genero = GeneroEnum.obtenerGenero(utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getSexo(), ExpresionesConstants.VACIO));
				renapo.setSexo(genero.getDscripcion());
				String nombreRenapo = utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getNombres(), ExpresionesConstants.VACIO);
				String apellidoPaternoRenapo = utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getApellido1(), ExpresionesConstants.VACIO);
				String apellidoMaternoRenapo = utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getApellido2(), ExpresionesConstants.VACIO);
				
				
				renapo.setBanderaNombre(this.validarNombreRenapoCurp(nombreRenapo, trabajador.getDatosCertificables().getNombre(), NumerosConstants.INT_UNO));
				renapo.setBanderaApellidoPaterno(this.validarNombreRenapoCurp(apellidoPaternoRenapo, trabajador.getDatosCertificables().getApellidoPaterno(), NumerosConstants.INT_UNO));
				renapo.setBanderaApellidoMaterno(this.validarNombreRenapoCurp(apellidoMaternoRenapo, trabajador.getDatosCertificables().getApellidoMaterno(), NumerosConstants.INT_UNO));
				renapo.setBanderaCurp(this.validarNombreRenapoCurp(datos.getCurp(), trabajador.getDatosCertificables().getCurp(), NumerosConstants.INT_DOS));
				renapo.setBanderaGenero(this.validarNombreRenapoCurp(renapo.getSexo(),trabajador.getDatosCertificables().getGenero(), NumerosConstants.INT_TRES));
				renapo.setBanderaFechaNacimiento(this.validarNombreRenapoCurp(renapo.getFechaNacmiento(), trabajador.getDatosCertificables().getFechaNacimiento(), NumerosConstants.INT_CUATRO));
				renapo.setBanderaEntidadNacimiento(this.validarNombreRenapoCurp(renapo.getEntidadNacimiento(), trabajador.getDatosCertificables().getEntidadNacimiento(), NumerosConstants.INT_CINCO));
				if(!validadorUtils.validarObjetoNulo(trabajador.getDatosNoCertificables().getClaveNacionalidad())){
					renapo.setBanderaNacionalidad(this.validarNombreRenapoCurp(renapo.getNacionalidad(), servicioCatalogo.obtenerNacionalidadPorClave(String.valueOf(trabajador.getDatosNoCertificables().getClaveNacionalidad())).getChValorDespliegue(), NumerosConstants.INT_CINCO));
				}
				if(!validadorUtils.validarObjetoNulo(datos.getCurpHistoricas()) && datos.getCurpHistoricas().length > 0) {
					renapo.setListaCurpHistoricas(Arrays.asList(datos.getCurpHistoricas()));
				}
			}
			if(validadorUtils.validarObjetoNulo(datos.getCurp()) && validadorUtils.validarObjetoNulo(datos.getNombres()) && validadorUtils.validarObjetoNulo(datos.getApellido1())){
				renapo.setBanderaNoExisteCurp(NumerosConstants.INT_UNO);
			}else{
				renapo.setBanderaNoExisteCurp(NumerosConstants.INT_CERO);
			}
		}catch(Exception e){
			logger.error("Se ha presentado un fallo al consultar datos renapo", e);
		}
		logger.info(":: result renapo: {}",renapo);
		return renapo;
	}
	
	
	/**
	 * Metodo encargaso de consultar datos de renapo por medio de curp
	 * @param curp
	 * @return
	 */
	private CURPStruct obtenerDatosCurp(String curp){
		logger.info("Se obtienen datos de curp trabajador");
		CURPStruct renapo = null;
		try{
			String urlRenapo = utileriaCadena.obtenerCadenaConcatenada(true, uriRenapo, curp); 
			renapo = restTemplate.getForObject(urlRenapo, CURPStruct.class);
		}catch(Exception e){
			logger.error("Se ha presentado un fallo al consultar datos renapo", e);
		}
		return renapo;
		
	}
	
	
	
	/**
	 * Validacion de diferencias de Renapo
	 * @param datosRenapo
	 * @param nombreTrabajador
	 * @return
	 */
	private Integer validarNombreRenapoCurp(String nombre, String nombreTrabajador, int tipo) {
		Integer valor = NumerosConstants.INT_CERO;
		try {
			logger.info("Validando datos de renapo distinto {} {} {}", tipo, nombre, nombreTrabajador);
			String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
			String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
			if(!validadorUtils.validarListaVacia(listaParametro)) {
				caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
			}
			
			utileriaCadena.validarCadenasIguales(nombreTrabajador, nombre, BusinessErrorEnum.DIFERENCIAS_RENAPO, caracterHomologado);
		} catch (BusinessException be) {
			logger.error("Datos de renapo o imss distinto {} {} {}", tipo, nombre, nombreTrabajador, be);
			valor = NumerosConstants.INT_UNO;
		}
		return valor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio validarMarcasOperativasTrabajador(Long idProcesar, String cveProceso,Folio folio) {
		logger.info("Inicio validarMarcasOperativasTrabajador");
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try{
			ParametrosMarca entrada = new ParametrosMarca();
			entrada.setIdentificador(idProcesar);
			entrada.setProceso(cveProceso);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			JsonUtilsImpl<ParametrosMarca> json = new JsonUtilsImpl<>();
			String jsonRequest = json.parseObjectToJsonSC(entrada);
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
			logger.error(ModificacionTrabajadorConstants.PETICION, jsonRequest);
			ResponseEntity<String> respuesta = restTemplate.exchange(urlValidacionMarca,HttpMethod.POST, entity, String.class);
			if(respuesta != null){
				respuestaServicio.setFlujo(1);
				logger.error("Respuesta de Validar Marcas Operativas: {} ",respuesta.getStatusCode());
			}
		}catch(Exception e){
			respuestaServicio.setFlujo(2);
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS);
			logger.error("Ocurrio un error existen marcas operativas que impiden la operacion " , e);
		}
		return respuestaServicio;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarExpedienteBiometrico(ExpedienteSalida expediente,UsuarioLogin user,DatosTrabajador trabajador,EntradaModificacion entradaModificacion,FlujoModificacion flujoModificacion,String bandera9B){
		String controlador = null;
		if(ServiciosConstants.TIPO_SOLICITANTE_TITULAR.equals(trabajador.getTipoSolicitante())){
			logger.info("Entrando a validar expediente Biometrico");

			controlador = validarFlujoExpedienteErolamiento(user,ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO,expediente.getEstatusEnrolamiento(),expediente.getClaveAforeExpBiometrico());
			if(!validadorUtils.validarObjetoNulo(entradaModificacion) && !utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()).equals(entradaModificacion.getDatosBaseCurp().getCurpNueva()) && !validadorUtils.validarObjetoNulo(controlador) || !validadorUtils.validarObjetoNulo(entradaModificacion) && !utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()).equals(entradaModificacion.getDatosBaseCurp().getCurpNueva()) && !validadorUtils.isEmpty(bandera9B)){
				ExpedienteDetail respuesta = validaExpedienteBiometricoCurpExistente(trabajador,"2,5");
				controlador = validarExpedientesCambioCurp(respuesta,entradaModificacion,"67",user,ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO,"2,5",flujoModificacion);
				controlador = validaExpedientesFlujo9B(bandera9B, trabajador, entradaModificacion, "67", controlador, flujoModificacion, user, ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO,"2,5");
			}
		}
		return controlador;
	}
	

	
	/**
	 * Metodo que valida 
	 * @param trabajador
	 * @return
	 */
	private ExpedienteDetail validaExpedienteBiometricoCurpExistente(DatosTrabajador trabajador,String estatusExpediente) {
		ExpedienteDetail respuesta =null;
			respuesta = expedienteService.consultarExpedienteProcesoSinAfore(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()), "67", estatusExpediente);
			if(validadorUtils.validarObjetoNulo(respuesta)) {
				respuesta = expedienteService.consultarExpedienteProcesoSinAfore(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()), "68", estatusExpediente);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarExpedienteIdentificacion(ExpedienteSalida expediente,UsuarioLogin user,DatosTrabajador trabajador,EntradaModificacion entradaModificacion,FlujoModificacion flujoModificacion,String bandera9B){
			logger.info("Entrando a validar expediente identificacion");
			
			String controlador = validarFlujoExpedienteIdentificacion(user,ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION,expediente.getEstatusExpedienteIdentificacion(),expediente.getClaveAforeExpIdentificacion());

			
			if(!validadorUtils.validarObjetoNulo(entradaModificacion) && !utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()).equals(entradaModificacion.getDatosBaseCurp().getCurpNueva()) && !validadorUtils.validarObjetoNulo(controlador) || !validadorUtils.validarObjetoNulo(entradaModificacion) && !utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()).equals(entradaModificacion.getDatosBaseCurp().getCurpNueva()) && !validadorUtils.isEmpty(bandera9B)){
				String cvProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
				ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()), cvProceso, "1,5");
				controlador = validarExpedientesCambioCurp(respuesta,entradaModificacion,cvProceso,user,ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION,"1,5",flujoModificacion);
				controlador = validaExpedientesFlujo9B(bandera9B, trabajador, entradaModificacion, cvProceso, controlador, flujoModificacion, user, ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION,"1");
			}
		return controlador;
		
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalidaActualizaDatos validarRespuestaModificacion(SalidaActualizaDatos entradaRespuesta,EntradaModificacion entrada,DatosTrabajador trabajador){
		logger.info("Entrada modificacion validarRespuestaModificacion :: {}",entrada);
		Parametro parametroDiagnosticos = expedienteServicio.obtenerValorParametro(ModificacionTrabajadorConstants.PARAMETRO_RECHAZO_RELANZAMIENTO);
		String estatus = entradaRespuesta.getObjetoRespuesta().getDatosBaseCurp().getResultadoDeLaOperacion();
		String diagnostrico = entradaRespuesta.getObjetoRespuesta().getDatosBaseCurp().getDiagnosticoDeRecepcion();
		String respuestaDiagnostico = obtenerDiagnosticoCorto(diagnostrico);
		String restoDiagnostico = diagnostrico.substring(3,15);
		boolean comparacionPrimerDiagnostico = true;
		boolean comparacionRestoDiagnostico = true;
		
		SalidaActualizaDatos salidaModificacion = ejecutaProcesoE83(entrada, trabajador, estatus, respuestaDiagnostico, restoDiagnostico,null);
		if(!validadorUtils.validarObjetoNulo(salidaModificacion)) {
			diagnostrico = salidaModificacion.getObjetoRespuesta().getDatosBaseCurp().getDiagnosticoDeRecepcion();
			respuestaDiagnostico = obtenerDiagnosticoCorto(diagnostrico);
			restoDiagnostico = diagnostrico.substring(3,15);
		}
		
		if(ModificacionTrabajadorConstants.RESULTADO_OPERACION.equals(utileriaCadena.obtenerContenidoCadenaSinEspacios(estatus, ExpresionesConstants.VACIO)) && parametroDiagnosticos.getChValorParametro().contains(utileriaCadena.obtenerContenidoCadenaSinEspacios(respuestaDiagnostico, ExpresionesConstants.VACIO)) && ModificacionTrabajadorConstants.RESTO_DIAGNOSTICO.equals(restoDiagnostico)) {
			int contador = 0;
			int intentos = Integer.parseInt(parametroDiagnosticos.getChParametro());
			do {
				contador++;
				String banderaRelanzamiento = NumerosConstants.C_UNO;
				
				salidaModificacion = this.ejecutarModificacion(entrada,trabajador,banderaRelanzamiento);
				diagnostrico = salidaModificacion.getObjetoRespuesta().getDatosBaseCurp().getDiagnosticoDeRecepcion();
				respuestaDiagnostico = obtenerDiagnosticoCorto(diagnostrico);
				restoDiagnostico = diagnostrico.substring(3,15);
				comparacionPrimerDiagnostico = parametroDiagnosticos.getChValorParametro().contains(respuestaDiagnostico);
				comparacionRestoDiagnostico = ModificacionTrabajadorConstants.RESTO_DIAGNOSTICO.equals(restoDiagnostico);
				
			} while (comparacionPrimerDiagnostico  && comparacionRestoDiagnostico &&  intentos != contador);
		}
		
		if(!validadorUtils.validarObjetoNulo(salidaModificacion)) {
			entradaRespuesta = salidaModificacion;
		}
		salidaModificacion = ejecutaProcesoE83(entrada, trabajador, estatus, respuestaDiagnostico, restoDiagnostico,entradaRespuesta);
		
		logger.error("respuestaDiagnostico: {}",respuestaDiagnostico);
		logger.error("restoDiagnostico: {}",restoDiagnostico);
		return salidaModificacion;
	}
	
	
	/**
	 * Regresa el numero de proceso de expediente de identificacion por el tipo de solicitante
	 * @param tipoSolicitante
	 * @return
	 */
	public String obtenerProcesoTipoExpedienteIdentificacion(String tipoSolicitante){
		logger.info("tipoSolicitante: {}",tipoSolicitante);
		String proceso = null;
		if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante.trim())){
			proceso = "01";
		}else if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(tipoSolicitante.trim())){
			proceso = "02";
		}else if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_REPRESENTANTE_LEGAL.equals(tipoSolicitante.trim())){
			proceso = "04";
		}else if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_CURADOR.equals(tipoSolicitante.trim())){
			proceso = "10";
		}
		logger.info("Proceso Expediente Identificacion: {}",proceso);
		return proceso;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String consultarRecepcionExpeIdentificacion(Folio folio,String tipo){
		logger.info("Entrando validacion recepcion :: Modificacion");
		 String banderaMesaControl = null;
		ArchivoRecibido respuesta =  servicioArchivos.validarRecepcionArchivoModificacion(folio, tipo);
		if(!validadorUtils.validarObjetoNulo(respuesta) && ModificacionTrabajadorConstants.RECHAZO_MESA_CONTROL.equals(respuesta.getDiagnostico())){
				banderaMesaControl = NumerosConstants.C_UNO;			
		}
		return banderaMesaControl;
	}
	
	/**
	 * Metodo encargado de obtener rechazos para bloques
	 * @param rechazos
	 * @param labelBloque
	 * @param resultadoBloqueOperacion
	 * @param listaDiagnosticos
	 * @return
	 */
	private List<RechazoBloque> obtenerRechazoBloque(List<RechazoBloque> rechazos,String labelBloque,String resultadoBloqueOperacion,List<HashMap<String,String>> listaDiagnosticos){
    	if(ModificacionTrabajadorConstants.RESULTADO_OPERACION.equals(resultadoBloqueOperacion)){
			RechazoBloque rechazo = new RechazoBloque();
			rechazo.setBloque(labelBloque);
			rechazo.setEstatus(ModificacionTrabajadorConstants.RECHAZADO);
			rechazo.setRechazos(listaDiagnosticos);
			rechazos.add(rechazo);
		}else{
			RechazoBloque rechazo = new RechazoBloque();
			rechazo.setBloque(labelBloque);
			rechazo.setEstatus(ModificacionTrabajadorConstants.ACEPTADO);
			rechazos.add(rechazo);
		}
		return rechazos;    	
	}
	
	/**
	 * Metodo que valida Flujo para expediente
	 * @param expediente
	 * @param user
	 * @param controladorRespuesta
	 * @param validacion
	 * @return
	 */
	private String validarFlujoExpedienteIdentificacion(UsuarioLogin user,String controladorRespuesta,String validacion,String validacionAfore){
		String controlador = null;
		switch (validacion) {
		case NumerosConstants.C_CERO:
			controlador = controladorRespuesta;
			break;
		case NumerosConstants.C_UNO:
			if(!user.getAforeUsuario().equals(validacionAfore)){
				controlador = controladorRespuesta;
			}
			break;
		case NumerosConstants.C_DOS:
			controlador = controladorRespuesta;
			break;
		case NumerosConstants.C_CINCO:
			break;
		default:
			controlador = controladorRespuesta;
			break;
		}
		return controlador;
	}
	
	
	/**
	 * Metodo que valida Flujo para expediente
	 * @param expediente
	 * @param user
	 * @param controladorRespuesta
	 * @param validacion
	 * @return
	 */
	private String validarFlujoExpedienteErolamiento(UsuarioLogin user,String controladorRespuesta,String validacion,String validacionAfore){
		String controlador = null;
		switch (validacion) {
		case NumerosConstants.C_CERO:
			controlador = controladorRespuesta;
			break;
		case NumerosConstants.C_DOS:
			if(!user.getAforeUsuario().equals(validacionAfore)){
				controlador = controladorRespuesta;
			}
			break;
		case NumerosConstants.C_CINCO:
			break;
		default:
			controlador = controladorRespuesta;
			break;
		}
		return controlador;
	}
	
	/**
	 * Metodo que valida expedientes y valida casos de cambio curp
	 * @param respuesta
	 * @param entradaModificacion
	 * @param claveProceso
	 * @param user
	 * @param movimientoControlador
	 * @return
	 */
	private String validarExpedientesCambioCurp(ExpedienteDetail respuesta,EntradaModificacion entradaModificacion,String claveProceso,UsuarioLogin user,String movimientoControlador,String estatusExpedientes,FlujoModificacion flujoModificacion){
		String controlador = null;
		if(validadorUtils.validarObjetoNulo(respuesta)){
			 respuesta = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), claveProceso, estatusExpedientes);
			 if(validadorUtils.validarObjetoNulo(respuesta) && "67".equals(claveProceso)) {
				 respuesta = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), "68", estatusExpedientes);
			 }
		}
		if(!validadorUtils.validarObjetoNulo(respuesta)){
			controlador = null;
			if(!NumerosConstants.C_CINCO.contains(respuesta.getCvEstatusExpe()) && !user.getAforeUsuario().equals(respuesta.getAfore().getClaveAfore())){
				controlador = movimientoControlador;
			}
		}else{
			controlador = movimientoControlador;
		}
		
		if(validadorUtils.isEmpty(controlador)) {
			if("67,68".contains(claveProceso)) {
				flujoModificacion.setEstatusExpeBiometrico(respuesta.getCvEstatusExpe());
				flujoModificacion.setCvAforeExpeBiometrico(respuesta.getAfore().getClaveAfore());
			}else {
				flujoModificacion.setEstatusExpeIdentificacion(respuesta.getCvEstatusExpe());
				flujoModificacion.setCvAforExpeIdentificacion(respuesta.getAfore().getClaveAfore());
			}
		}
		
		return controlador;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificacionSello validaSelloPermanencia(String curpEmpleado, String curpTrabajador, String claveAfore,String tipoSolicitante) {
		if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante)) {
			return   consultaSelloService.consultarSelloFlujoModificacion(curpEmpleado, curpTrabajador, claveAfore);
		}else {
			return  new VerificacionSello();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guardarFlujoBitacora(String controlador,EntradaModificacion entradaModificacion,Folio folioPadre,EntradaPermanencia entradaPermanencia,String bandera13,String banderaP) {
		if(!validadorUtils.validarVacio(bandera13)) {
			if(ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO.equals(controlador)) {
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDBIOMETRICO, "Inicio Proceso Biometrico", null, utileriaCadena.obtenerCadenaConcatenada(true, "13+-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), null, null);
	
			}else if (ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION.equals(controlador)) {
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION, "Inicio Proceso Identificacion", null, utileriaCadena.obtenerCadenaConcatenada(true, "13+-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), null, null);
	
			}else if (ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR.equals(controlador)) {
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDVERIFICACION, "Inicio Proceso Verificacion", null, utileriaCadena.obtenerCadenaConcatenada(true, "13+-",entradaModificacion.getDatosBaseCurp().getFlujoDeValidacion()), entradaModificacion.getNss(), entradaModificacion.getDatosBaseCurp().getCurpNueva(), folioPadre.getChFolio(), null, null);
			}
		}else if(!validadorUtils.validarVacio(banderaP)) {
			if(ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO.equals(controlador)) {
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDBIOMETRICO, "Inicio Proceso Biometrico", null, "Op 17 Permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), null, null);
	
			}else if (ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION.equals(controlador)) {
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDIDENTIFICACION, "Inicio Proceso Identificacion", null, "Op 17 Permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), null, null);
	
			}else if (ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR.equals(controlador)) {
				bitacoraMovimientoModificacionService.generaObjetoModificacion(ServiciosConstants.FOLIO_PROCESO_MDVERIFICACION, "Inicio Proceso Verificacion", null, "Op 17 Permanencia", entradaPermanencia.getNssTrabajador(), entradaPermanencia.getCurpTrabajador(), folioPadre.getChFolio(), null, null);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public  String obtenerDiagnosticoCorto(String diagnostrico) {
		 return diagnostrico.substring(0,3);
		 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notificarTiempoTramite(String folioProcesar,FolioEntrada folioConsulta,String claveAfore) {
		NotificacionTiempoTramiteMod notificacionTiempo = new NotificacionTiempoTramiteMod();
		try {
			FolioFechas folioConsultado = servicioFolio.consultarFechasFolio(folioConsulta.getIdFolio());
			String tiempoEspera = utileriaFecha.calcularTiempoTranscurrido(folioConsultado.getFechaLlegadaSn(), folioConsultado.getFechaGeneracionSn());
			String tiempoAtencion = utileriaFecha.calcularTiempoTranscurrido(folioConsultado.getFechaGeneracionSn(),new Date());
			String tiempoTotalTramite = utileriaFecha.calcularTiempoTranscurrido(folioConsultado.getFechaLlegadaSn(),new Date());
	
			notificacionTiempo.setFolioProcesar(folioProcesar);
			notificacionTiempo.setTiempoAtencion(tiempoAtencion);
			notificacionTiempo.setTiempoEspera(tiempoEspera);
			notificacionTiempo.setTiempoTotalTramite(tiempoTotalTramite);
			notificacionTiempo.setClaveAfore(claveAfore);
			notificacionService.notificarTiempoTramite(notificacionTiempo);
		}catch (Exception e) {
			logger.error("Ocurrio un error al notificar tiempo tramite: {}",e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean validaPendientePersona(String curp) {
		Boolean respuesta = true;
		try{
			String urlPendiente = utileriaCadena.obtenerCadenaConcatenada(true, urlComunes,"op13/consultaPendiente/", curp); 
			logger.info("url valida pendiente persona: {}",urlPendiente);
			Long valor = restTemplate.getForObject(urlPendiente, Long.class);
			if(valor > 0) {
				respuesta = false;
			}
		}catch(Exception e){
			logger.error("Se ha presentado un fallo al consultar pendiente persona", e);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarRespuestaPendiente(Boolean entrada) {
		if(!entrada) {
			throw new BusinessException(BusinessErrorEnum.PROCESO_PENDIENTE_CONFRONTA);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @return 
	 */
	@Override
	public  FolioActivoDetalle consultaFolioActivo(String curp,String nss,String claveAfore,boolean banderaValidacionFolioPermanencia){
		logger.info("Entrada consultaFolioActivo: {} {}",curp,nss);
		String claveServicioModificacion = null;
		String claveServicioPermanencia = null;
		FolioActivoDetalle folioDetalle = null;
		FolioActivo folioActivo = null;
			Parametro claveServicio = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_SERVICIO_MODIFICACION);
			String[] arregloClaves = claveServicio.getChValorParametro().split(ExpresionesConstants.COMA);
			claveServicioModificacion = arregloClaves[NumerosConstants.INT_CERO];
			claveServicioPermanencia = arregloClaves[NumerosConstants.INT_UNO];
			Parametro clavePasoIdentificacion = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_PASO_IDENTIFICACION_MDD);
			folioActivo = servicioFolio.consultarFolioActivo(curp, nss,claveServicioModificacion);
			if(banderaValidacionFolioPermanencia) {
				folioActivo = servicioFolio.consultarFolioActivo(curp, nss,claveServicioPermanencia);
			}
			if(!validadorUtils.validarObjetoNulo(folioActivo)){			
				if(!validadorUtils.validarListaVacia(folioActivo.getFoliosHijo())){				
					for (int i = 0; folioActivo.getFoliosHijo().size() > i; i++) {
						String idProceso = String.valueOf(folioActivo.getFoliosHijo().get(i).getIdProceso());
						Proceso proceso = obtenerProcesoPorId(idProceso);
						if(clavePasoIdentificacion.getChValorParametro().contains(proceso.getClaveProceso())) {
							Long folioHijoIdentificacion = folioActivo.getFoliosHijo().get(i).getIdFolioPulssar();
							Folio folioConsultado = servicioFolio.consultarFolioHijo(folioHijoIdentificacion);
							ArchivoRecibido consultaRecepcion = servicioArchivos.validarRecepcionArchivoModificacion(folioConsultado, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
							if(validarRespuestaRecepcionIdentificacion(consultaRecepcion,folioHijoIdentificacion)) {
								throw new BusinessException(BusinessErrorEnum.PROCESO_ABIERTO_MDD);
							}else {
								folioDetalle = folioActivo.getFoliosHijo().get(i);
							}
						}else {
							folioDetalle = folioActivo.getFoliosHijo().get(i);

						}
					}
				}
			}
		logger.error("Lista folioActivo {} ",folioActivo);
		return folioDetalle;
	}
	
	
	/**
	 * Metodo encargado de consultar proceso por idProceso
	 * @param idProceso
	 * @return
	 */
	public Proceso obtenerProcesoPorId(String idProceso){
		logger.error("Se obtiene proceso de id");
		String url = utileriaCadena.obtenerCadenaConcatenada(true, urlComunes,"catalogo/consultarProceso/",idProceso);
		Proceso proceso = null;
		try{
			logger.error("Url para consultar clave proceso por id: {}",url);
			proceso = restTemplate.getForObject(url, Proceso.class);
		}catch(Exception e){
			logger.error("Se presento un problema al consultar la informacion de proceso: {}",e);
		}
		return proceso;
	}
	
	/**
	 * 
	 * @param consultaRecepcion
	 * @return
	 */
	private Boolean validarRespuestaRecepcionIdentificacion(ArchivoRecibido consultaRecepcion,Long idFolio) {
		Boolean respuesta = false;
		if(!validadorUtils.validarObjetoNulo(consultaRecepcion)) {
			if(ServiciosConstants.RESULTADO_NOK.equals(consultaRecepcion.getResultadoOperacion()) && ModificacionTrabajadorConstants.RECHAZO_MESA_CONTROL.equals(consultaRecepcion.getDiagnostico())) {
				ProcesoPendiente respuestaProceso = serviceProcesoPendiente.consultaProcesoPendienteIdfolio(String.valueOf(idFolio), "0,1");
				if(!validadorUtils.validarObjetoNulo(respuestaProceso)) {
					respuesta = true;
				}
			}
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarBanderaFlujo(String controlador,String bandera13,String banderaP){
			if(!validadorUtils.validarVacio(bandera13)){
				controlador = ModificacionTrabajadorConstants.CONTROLLER_EXPE_SERVICIO;
			}else if(!validadorUtils.validarVacio(banderaP)){
				controlador = ModificacionTrabajadorConstants.CONTINUAR_PERMANENCIA;
			}
		return controlador;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteSalida validarExpedientesNoTitularInicio(DatosTrabajador trabajador) {
		ExpedienteSalida salidaTipoSolicitante = new ExpedienteSalida();
		String cveProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
		ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(utileriaCadena.asignarValor(trabajador.getDatosCertificables().getCurp()), cveProceso, "1,5");
		if(validadorUtils.validarObjetoNulo(respuesta)){
			salidaTipoSolicitante.setEstatusExpedienteIdentificacion(NumerosConstants.C_CERO);

		}else{
			salidaTipoSolicitante.setEstatusExpedienteIdentificacion(respuesta.getCvEstatusExpe());
			salidaTipoSolicitante.setClaveExpedienteIdentificacion(respuesta.getCvTipoProceso());
			salidaTipoSolicitante.setClaveAforeExpIdentificacion(respuesta.getAfore().getClaveAfore());
			salidaTipoSolicitante.setClaveTipoProcesoExpIdentificacion(cveProceso);
			salidaTipoSolicitante.setTipoIDE(NumerosConstants.C_CERO);
		}
		
		return salidaTipoSolicitante;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntradaModificacion validaDatosModificacionComparador(EntradaModificacion objetoEntrada) {
		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!validadorUtils.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
		}
		EntradaModificacion objetoFiltrado = new EntradaModificacion();
		DatosBaseCurp datosBase = validaDatosBaseCurp(objetoEntrada, caracterHomologado);
		DatosDomicilioParticularTrabajador datosParticular = validaEntradaDatosParticulares(objetoEntrada, caracterHomologado);
		DatosDomicilioLaboralTrabajador datosLaboral = validaDomicilioLaboralModificacion(objetoEntrada, caracterHomologado);
		DatosReferenciasTrabajador datosReferencias = validaReferenciasModificacion(objetoEntrada, caracterHomologado);
		ListaBeneficiariosTrabajador listaBeneficiarios = validaBeneficiariosModificacion(objetoEntrada, caracterHomologado);
		
		objetoFiltrado.setFolioCliente(objetoEntrada.getFolioCliente());
		objetoFiltrado.setEntidadOrigen(objetoEntrada.getEntidadOrigen());
		objetoFiltrado.setTipoDeMovimiento(objetoEntrada.getTipoDeMovimiento());
		objetoFiltrado.setNss(objetoEntrada.getNss());
		objetoFiltrado.setCurp(objetoEntrada.getCurp());
		objetoFiltrado.setDatosBaseCurp(datosBase);
		objetoFiltrado.setDatosDomicilioParticularTrabajador(datosParticular);
		objetoFiltrado.setDatosDomicilioLaboralTrabajador(datosLaboral);
		objetoFiltrado.setDatosReferenciasTrabajador(datosReferencias);
		objetoFiltrado.setListaBeneficiariosTrabajador(listaBeneficiarios);	
		return objetoFiltrado;
		
	}
	
	private DatosBaseCurp validaDatosBaseCurp(EntradaModificacion objetoEntrada,String caracterHomologado) {
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva(objetoEntrada.getDatosBaseCurp().getCurpNueva());
		datosBase.setRfc(objetoEntrada.getDatosBaseCurp().getRfc());
		datosBase.setApellidoPaterno(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosBaseCurp().getApellidoPaterno(), caracterHomologado) );
		datosBase.setApellidoMaterno(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosBaseCurp().getApellidoMaterno(),caracterHomologado));
		datosBase.setNombreTrabajador(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosBaseCurp().getNombreTrabajador(),caracterHomologado));
		datosBase.setFechaDeNacimiento(objetoEntrada.getDatosBaseCurp().getFechaDeNacimiento());
		datosBase.setSexo(objetoEntrada.getDatosBaseCurp().getSexo());
		datosBase.setEntidadFederativaDeNacimiento(objetoEntrada.getDatosBaseCurp().getEntidadFederativaDeNacimiento());
		datosBase.setNacionalidad(objetoEntrada.getDatosBaseCurp().getNacionalidad());
		datosBase.setClaveDeTipoDeDocumentoProbatorio(objetoEntrada.getDatosBaseCurp().getClaveDeTipoDeDocumentoProbatorio());
		datosBase.setFolioDeLaSolicitud(objetoEntrada.getDatosBaseCurp().getFolioDeLaSolicitud());
		datosBase.setDocumentoProbatorio(objetoEntrada.getDatosBaseCurp().getDocumentoProbatorio());
		datosBase.setFolioDeDocumentoProbatorio(objetoEntrada.getDatosBaseCurp().getFolioDeDocumentoProbatorio());
		datosBase.setOcupacionOProfesionTrabajador(objetoEntrada.getDatosBaseCurp().getOcupacionOProfesionTrabajador());
		datosBase.setActividadOGiroNegocioTrabajador(objetoEntrada.getDatosBaseCurp().getActividadOGiroNegocioTrabajador());
		datosBase.setNivelDeEstudioTrabajador(objetoEntrada.getDatosBaseCurp().getNivelDeEstudioTrabajador());
		datosBase.setFlujoDeValidacion(objetoEntrada.getDatosBaseCurp().getFlujoDeValidacion());
		datosBase.setSelloVerificacionBiometrica(objetoEntrada.getDatosBaseCurp().getSelloVerificacionBiometrica());
		datosBase.setSelloVoluntadTramite(objetoEntrada.getDatosBaseCurp().getSelloVoluntadTramite());
		datosBase.setIndicadorDeDuplicidad(objetoEntrada.getDatosBaseCurp().getIndicadorDeDuplicidad());
		datosBase.setIndicadorEnrolamiento(objetoEntrada.getDatosBaseCurp().getIndicadorEnrolamiento());
		datosBase.setIndicadorDeServicioBiometrico(objetoEntrada.getDatosBaseCurp().getIndicadorDeServicioBiometrico());
		datosBase.setCurpSolicitante(objetoEntrada.getDatosBaseCurp().getCurpSolicitante());
		datosBase.setTipoSolicitante(objetoEntrada.getDatosBaseCurp().getTipoSolicitante());
		datosBase.setMovimientoBeneficiario(objetoEntrada.getDatosBaseCurp().getMovimientoBeneficiario());
		return datosBase;
	}
	
	private DatosDomicilioParticularTrabajador validaEntradaDatosParticulares(EntradaModificacion objetoEntrada,String caracterHomologado) {
		DatosDomicilioParticularTrabajador datosParticulares = null;
		if(!validadorUtils.validarObjetoNulo(objetoEntrada.getDatosDomicilioParticularTrabajador())) {
			datosParticulares = new DatosDomicilioParticularTrabajador();
			datosParticulares.setCalle(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioParticularTrabajador().getCalle(), caracterHomologado));
			datosParticulares.setNumeroExterior(objetoEntrada.getDatosDomicilioParticularTrabajador().getNumeroExterior());
			datosParticulares.setNumeroInterior(objetoEntrada.getDatosDomicilioParticularTrabajador().getNumeroInterior());
			datosParticulares.setColonia(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioParticularTrabajador().getColonia(), caracterHomologado));
			datosParticulares.setDelegacionOMunicipio(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioParticularTrabajador().getDelegacionOMunicipio(), caracterHomologado));
			datosParticulares.setCodigoPostal(objetoEntrada.getDatosDomicilioParticularTrabajador().getCodigoPostal());
			datosParticulares.setEntidadFederativa(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioParticularTrabajador().getEntidadFederativa(), caracterHomologado));
			datosParticulares.setPais(objetoEntrada.getDatosDomicilioParticularTrabajador().getPais());
			datosParticulares.setIndicadorDeTelefono1(objetoEntrada.getDatosDomicilioParticularTrabajador().getIndicadorDeTelefono1());
			datosParticulares.setTelefono1(objetoEntrada.getDatosDomicilioParticularTrabajador().getTelefono1());
			datosParticulares.setExtension1(objetoEntrada.getDatosDomicilioParticularTrabajador().getExtension1());
			datosParticulares.setIndicadorDeTelefono2(objetoEntrada.getDatosDomicilioParticularTrabajador().getIndicadorDeTelefono2());
			datosParticulares.setTelefono2(objetoEntrada.getDatosDomicilioParticularTrabajador().getTelefono2());
			datosParticulares.setExtension2(objetoEntrada.getDatosDomicilioParticularTrabajador().getExtension2());
			datosParticulares.setCorreoElectronicoDelTrabajador(objetoEntrada.getDatosDomicilioParticularTrabajador().getCorreoElectronicoDelTrabajador());
			datosParticulares.setClaveEntidad(objetoEntrada.getDatosDomicilioParticularTrabajador().getClaveEntidad());
		}
		return datosParticulares;
	}
	
	private DatosDomicilioLaboralTrabajador validaDomicilioLaboralModificacion(EntradaModificacion objetoEntrada,String caracterHomologado) {
		DatosDomicilioLaboralTrabajador domicilioLaboral = null;		
		if(!validadorUtils.validarObjetoNulo(objetoEntrada.getDatosDomicilioLaboralTrabajador())) {
			domicilioLaboral = new DatosDomicilioLaboralTrabajador();
			domicilioLaboral.setCalle(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioLaboralTrabajador().getCalle(), caracterHomologado));
			domicilioLaboral.setNumeroExterior(objetoEntrada.getDatosDomicilioLaboralTrabajador().getNumeroExterior());
			domicilioLaboral.setNumeroInterior(objetoEntrada.getDatosDomicilioLaboralTrabajador().getNumeroInterior());
			domicilioLaboral.setColonia(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioLaboralTrabajador().getColonia(), caracterHomologado));
			domicilioLaboral.setDelegacionOMunicipio(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioLaboralTrabajador().getDelegacionOMunicipio(), caracterHomologado));
			domicilioLaboral.setCodigoPostal(objetoEntrada.getDatosDomicilioLaboralTrabajador().getCodigoPostal());
			domicilioLaboral.setEntidadFederativa(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosDomicilioLaboralTrabajador().getEntidadFederativa(), caracterHomologado));
			domicilioLaboral.setPais(objetoEntrada.getDatosDomicilioLaboralTrabajador().getPais());
		}
		return domicilioLaboral;
	}
	
	private DatosReferenciasTrabajador validaReferenciasModificacion(EntradaModificacion objetoEntrada,String caracterHomologado){
		DatosReferenciasTrabajador referencias = null;
		if(!validadorUtils.validarObjetoNulo(objetoEntrada.getDatosReferenciasTrabajador())) {
			referencias = new DatosReferenciasTrabajador();
			referencias.setApellidoPaternoDeReferencia1(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia1(), caracterHomologado));
			referencias.setApellidoMaternoDeReferencia1(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia1(), caracterHomologado));
			referencias.setNombreDeReferencia1(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosReferenciasTrabajador().getNombreDeReferencia1(), caracterHomologado));
			referencias.setCurpDeReferencia1(objetoEntrada.getDatosReferenciasTrabajador().getCurpDeReferencia1());
			referencias.setTelefonoDeReferencia1(objetoEntrada.getDatosReferenciasTrabajador().getTelefonoDeReferencia1());
			referencias.setParentescoORelacionDeReferencia1(objetoEntrada.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia1());
			referencias.setApellidoPaternoDeReferencia2(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia2(), caracterHomologado));
			referencias.setApellidoMaternoDeReferencia2(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia2(), caracterHomologado));
			referencias.setNombreDeReferencia2(notificacionExpedienteService.eliminarAcentos(objetoEntrada.getDatosReferenciasTrabajador().getNombreDeReferencia2(), caracterHomologado));
			referencias.setCurpDeReferencia2(objetoEntrada.getDatosReferenciasTrabajador().getCurpDeReferencia2());
			referencias.setTelefonoDeReferencia2(objetoEntrada.getDatosReferenciasTrabajador().getTelefonoDeReferencia2());
			referencias.setParentescoORelacionDeReferencia2(objetoEntrada.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia2());
		}
		return referencias;
	}
	
	public ListaBeneficiariosTrabajador validaBeneficiariosModificacion(EntradaModificacion objetoEntrada,String caracterHomologado) {
		ListaBeneficiariosTrabajador beneficiarios = null;
		DatosBeneficiarioTrabajador datosBeneficiario = null;
		List<DatosBeneficiarioTrabajador> listaBeneficiarios = new ArrayList<>();
		if(!validadorUtils.validarObjetoNulo(objetoEntrada.getListaBeneficiariosTrabajador()) && !validadorUtils.validarListaVacia(objetoEntrada.getListaBeneficiariosTrabajador().getBeneficiario())) {
				for(DatosBeneficiarioTrabajador beneficiario : objetoEntrada.getListaBeneficiariosTrabajador().getBeneficiario()) {
					datosBeneficiario = new DatosBeneficiarioTrabajador();
					datosBeneficiario.setApellidoPaternoDeBeneficiario(notificacionExpedienteService.eliminarAcentos(beneficiario.getApellidoPaternoDeBeneficiario(),caracterHomologado));
					datosBeneficiario.setApellidoMaternoDeBeneficiario(notificacionExpedienteService.eliminarAcentos(beneficiario.getApellidoMaternoDeBeneficiario(),caracterHomologado));
					datosBeneficiario.setNombreDeBeneficiario(notificacionExpedienteService.eliminarAcentos(beneficiario.getNombreDeBeneficiario(),caracterHomologado));
					datosBeneficiario.setCurpDeBeneficiario(beneficiario.getCurpDeBeneficiario());
					datosBeneficiario.setParentescoORelacion(beneficiario.getParentescoORelacion());
					datosBeneficiario.setPorcentajeDeBeneficiario(beneficiario.getPorcentajeDeBeneficiario());
					listaBeneficiarios.add(datosBeneficiario);
				}
				beneficiarios = new ListaBeneficiariosTrabajador();
				 beneficiarios.setBeneficiario(listaBeneficiarios);
		}
		return beneficiarios;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String acortarMotivoRechazo(String motivoRechazo) {
		String nuevoMotivo = motivoRechazo;
		if(!validadorUtils.validarVacio(motivoRechazo) && motivoRechazo.length() > NumerosConstants.INT_TRES) {
			nuevoMotivo = motivoRechazo.substring(NumerosConstants.INT_UNO,NumerosConstants.INT_TRES);
		}
		return nuevoMotivo;
	}
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validaActualizacionModificacion(boolean validaNombre,boolean validaBaseCurp,boolean validaDomicilio,boolean validaRfc) {
		boolean respuesta = false;
		if(validaNombre || validaBaseCurp || validaDomicilio || validaRfc) {
			respuesta = true;
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarNombreCompleto(DatosTrabajador datosTrabajador,Object entradaProceso) {
		String caracterHomologado = consultarCaracterHomologado();
		String nombreFormulario = null;
		String apellidoPaternoFormulario = null;
		String apellidoMaternoFormulario = null;
		
		boolean resultado = false;
		DatosCertificables certificables = datosTrabajador.getDatosCertificables();
		String nombreDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getNombre(), ExpresionesConstants.VACIO);
		nombreDB = notificacionExpedienteService.eliminarAcentos(nombreDB, caracterHomologado);
		String apellidoPaternoDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getApellidoPaterno(), ExpresionesConstants.VACIO);
		apellidoPaternoDB = notificacionExpedienteService.eliminarAcentos(apellidoPaternoDB, caracterHomologado);
		String apellidoMaternoDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getApellidoMaterno(), ExpresionesConstants.VACIO);
		apellidoMaternoDB = notificacionExpedienteService.eliminarAcentos(apellidoMaternoDB, caracterHomologado);
		if(entradaProceso instanceof EntradaModificacion) {
			DatosBaseCurp datosBase = ((EntradaModificacion) entradaProceso).getDatosBaseCurp();
			nombreFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getNombreTrabajador(), ExpresionesConstants.VACIO);
			nombreFormulario = notificacionExpedienteService.eliminarAcentos(nombreFormulario, caracterHomologado);
			apellidoPaternoFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getApellidoPaterno(), ExpresionesConstants.VACIO);
			apellidoPaternoFormulario = notificacionExpedienteService.eliminarAcentos(apellidoPaternoFormulario, caracterHomologado);
			apellidoMaternoFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getApellidoMaterno(), ExpresionesConstants.VACIO);
			apellidoMaternoFormulario = notificacionExpedienteService.eliminarAcentos(apellidoMaternoFormulario, caracterHomologado);
			
			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreFormulario,ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreDB,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoFormulario,ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoDB,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoDB,ExpresionesConstants.VACIO))){
				resultado = true;
			}
		}else if (entradaProceso instanceof EntradaPermanencia) {
			EntradaPermanencia entradaPermanencia = (EntradaPermanencia) entradaProceso;
			nombreFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getNombreTrabajador(), ExpresionesConstants.VACIO);
			nombreFormulario = notificacionExpedienteService.eliminarAcentos(nombreFormulario, caracterHomologado);
			apellidoPaternoFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getApellidoPaterno(), ExpresionesConstants.VACIO);
			apellidoPaternoFormulario = notificacionExpedienteService.eliminarAcentos(apellidoPaternoFormulario, caracterHomologado);
			apellidoMaternoFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getApellidoMaterno(), ExpresionesConstants.VACIO);
			apellidoMaternoFormulario = notificacionExpedienteService.eliminarAcentos(apellidoMaternoFormulario, caracterHomologado);
			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreFormulario,ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreDB,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoFormulario,ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoDB,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoFormulario,ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoDB,ExpresionesConstants.VACIO))) {
				resultado = true;
			}
		}
		logger.error("respuesta validarNombreCompleto :: {}",resultado);
		return resultado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean varlidarDatosBaseMasNacionalidad(DatosTrabajador datosTrabajador, Object entradaProceso) {
		boolean resultado = false;
		DatosCertificables certificables = datosTrabajador.getDatosCertificables();
		String curpActual = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getCurp(), ExpresionesConstants.VACIO);
		String generoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getClaveGenero(), ExpresionesConstants.VACIO);
		Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(certificables.getFechaNacimiento(),  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;
		String fechaNacimientoTrabajador = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_SERVICIO_MODIFICACION);		
		String fechaNacimientoBD = fechaUtils.ObtenerFechas(validadorUtils.validarVacio(fechaNacimientoTrabajador) ? "0000-00-00" : fechaNacimientoTrabajador);
		String entidadNacimientoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getClaveEntidadN(), ExpresionesConstants.VACIO);
		String nacionalidadBd =  validadorUtils.isEmpty(datosTrabajador.getDatosNoCertificables().getClaveNacionalidad()) ? ExpresionesConstants.VACIO : utileriaCadena.obtenerContenidoCadenaSinEspacios(String.valueOf(datosTrabajador.getDatosNoCertificables().getClaveNacionalidad()), ExpresionesConstants.VACIO);
		if(entradaProceso instanceof EntradaModificacion) {
			DatosBaseCurp baseCurp = ((EntradaModificacion) entradaProceso).getDatosBaseCurp();
			String fechaNacimientoModificacion = fechaUtils.ObtenerFechas(baseCurp.getFechaDeNacimiento());
			String generoModificacion = NumerosConstants.C_UNO.equals(baseCurp.getSexo()) ? "M" : "F";
			Nacionalidad nacionalidad = servicioCatalogo.obtenerNacionalidadPorClave(baseCurp.getNacionalidad());
			String nacionalidadModificada = utileriaCadena.obtenerContenidoCadenaSinEspacios(nacionalidad.getCvNacionalidad(), ExpresionesConstants.VACIO);
			if(!baseCurp.getCurpNueva().equalsIgnoreCase(curpActual) || !generoModificacion.equalsIgnoreCase(generoBd) || !fechaNacimientoModificacion.equalsIgnoreCase(fechaNacimientoBD) || !baseCurp.getEntidadFederativaDeNacimiento().equalsIgnoreCase(entidadNacimientoBd) || !nacionalidadModificada.equalsIgnoreCase(nacionalidadBd)) {
				resultado = true;
			}
		}else if(entradaProceso instanceof EntradaPermanencia) {
			EntradaPermanencia entradaPermanencia = (EntradaPermanencia) entradaProceso;
			String nacionalidadPermanencia = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getNacionalidad(), ExpresionesConstants.VACIO);
			if(!nacionalidadPermanencia.equalsIgnoreCase(nacionalidadBd)) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validaDomicilio(DatosTrabajador datosTrabajador,Object entradaProceso) {
		boolean resultado = false;
		
		String caracterHomologado = consultarCaracterHomologado();
		
		Domicilio particular = datosTrabajador.getDatosComplementarios().getParticular();
		if(validadorUtils.validarObjetoNulo(particular)){
			particular = new Domicilio();
		}
		
		String calleDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getCalle(), ExpresionesConstants.VACIO);
		calleDB = notificacionExpedienteService.eliminarAcentos(calleDB, caracterHomologado);
		String coloniaDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getColonia(), ExpresionesConstants.VACIO);
		coloniaDB = notificacionExpedienteService.eliminarAcentos(coloniaDB, caracterHomologado);
		String municipioDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getMunicipio(), ExpresionesConstants.VACIO);
		municipioDB = notificacionExpedienteService.eliminarAcentos(municipioDB, caracterHomologado);
		String entidadDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getEntidadFederativa(), ExpresionesConstants.VACIO);
		entidadDB = notificacionExpedienteService.eliminarAcentos(entidadDB, caracterHomologado);
		String noExteriorDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getNoExterior(), ExpresionesConstants.VACIO);
		noExteriorDB = notificacionExpedienteService.eliminarAcentos(noExteriorDB, caracterHomologado);
		String noInteriorDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getNoInterior(), ExpresionesConstants.VACIO);
		noInteriorDB = notificacionExpedienteService.eliminarAcentos(noInteriorDB, caracterHomologado);
		String codigoPostalDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getCodigoPostal(), ExpresionesConstants.VACIO);
		String clavePaisDB = utileriaCadena.obtenerContenidoCadenaSinEspacios(particular.getClavePais(), ExpresionesConstants.VACIO);

		if(entradaProceso instanceof EntradaModificacion) {
			DatosDomicilioParticularTrabajador domicilioParticular = ((EntradaModificacion) entradaProceso).getDatosDomicilioParticularTrabajador();			
			if(!validadorUtils.validarObjetoNulo(domicilioParticular)) {
				Boolean resultadoBloqueUno = validarBloqueDomicilioUnoModificacion(calleDB, coloniaDB, municipioDB, entidadDB, domicilioParticular,caracterHomologado);
				Boolean resultadoBloqueDos =validarBloqueDomicilioDosModificacion(noExteriorDB, noInteriorDB, codigoPostalDB, clavePaisDB, domicilioParticular,caracterHomologado);
				if(resultadoBloqueUno.equals(true) || resultadoBloqueDos.equals(true)) {
					resultado = true;
				}
			}
		}else if(entradaProceso instanceof EntradaPermanencia) {
			DatosParticulares domicilioParticular = ((EntradaPermanencia) entradaProceso).getDatosParticulares();
			if(!validadorUtils.validarObjetoNulo(domicilioParticular)) {
				Boolean resultadoBloqueUno = validarBloqueDomicilioUnoModificacion(calleDB, coloniaDB, municipioDB, entidadDB, domicilioParticular,caracterHomologado);
				Boolean resultadoBloqueDos =validarBloqueDomicilioDosModificacion(noExteriorDB, noInteriorDB, codigoPostalDB, clavePaisDB, domicilioParticular,caracterHomologado);
				if(resultadoBloqueUno.equals(true) || resultadoBloqueDos.equals(true)) {
					resultado = true;
				}
			}
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que valida bloque uno de domicilio particular
	 * @param calleDB
	 * @param coloniaDB
	 * @param municipioDB
	 * @param entidadDB
	 * @param domicilioParticular
	 * @return
	 */
	private boolean validarBloqueDomicilioUnoModificacion(String calleDB,String coloniaDB,String municipioDB,String entidadDB,Object domicilioParticular,String caracterHomologado) {
		boolean resultado = false;
		String calleFormulario = null;
		String coloniaFormulario = null;
		String delegacionMunicipioFormulario = null;
		String entidadFormulario = null;
		if(domicilioParticular instanceof DatosDomicilioParticularTrabajador) {
			DatosDomicilioParticularTrabajador domicilio = (DatosDomicilioParticularTrabajador) domicilioParticular;
			calleFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO);
			calleFormulario = notificacionExpedienteService.eliminarAcentos(calleFormulario, caracterHomologado);
			coloniaFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO);
			coloniaFormulario = notificacionExpedienteService.eliminarAcentos(coloniaFormulario, caracterHomologado);
			delegacionMunicipioFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getDelegacionOMunicipio(), ExpresionesConstants.VACIO);
			delegacionMunicipioFormulario = notificacionExpedienteService.eliminarAcentos(delegacionMunicipioFormulario,caracterHomologado);
			entidadFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getEntidadFederativa(), ExpresionesConstants.VACIO);
			entidadFormulario = notificacionExpedienteService.eliminarAcentos(entidadFormulario, caracterHomologado);
			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(calleFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(calleDB, ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(coloniaFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(coloniaDB, ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(delegacionMunicipioFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(municipioDB,ExpresionesConstants.VACIO)) ||!utileriaCadena.obtenerContenidoCadenaSinEspacios(entidadFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(entidadDB,ExpresionesConstants.VACIO))) {
				resultado = true;
			}
		}else if(domicilioParticular instanceof DatosParticulares) {
			DatosParticulares domicilio = (DatosParticulares) domicilioParticular;
			calleFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO);
			calleFormulario = notificacionExpedienteService.eliminarAcentos(calleFormulario, caracterHomologado);
			coloniaFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO);
			coloniaFormulario = notificacionExpedienteService.eliminarAcentos(coloniaFormulario, caracterHomologado);
			delegacionMunicipioFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getDelegacionOMunicipio(), ExpresionesConstants.VACIO);
			delegacionMunicipioFormulario = notificacionExpedienteService.eliminarAcentos(delegacionMunicipioFormulario,caracterHomologado);
			entidadFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getEntidadFederativa(), ExpresionesConstants.VACIO);
			entidadFormulario = notificacionExpedienteService.eliminarAcentos(entidadFormulario, caracterHomologado);
			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(calleFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(calleDB, ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(coloniaFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(coloniaDB, ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(delegacionMunicipioFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(municipioDB,ExpresionesConstants.VACIO)) ||!utileriaCadena.obtenerContenidoCadenaSinEspacios(entidadFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(entidadDB,ExpresionesConstants.VACIO))) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida bloque dos de domicilio particular
	 * @param noExteriorDB
	 * @param noInteriorDB
	 * @param codigoPostalDB
	 * @param clavePaisDB
	 * @param domicilioParticular
	 * @return
	 */
	private boolean validarBloqueDomicilioDosModificacion(String noExteriorDB,String noInteriorDB,String codigoPostalDB,String clavePaisDB,Object domicilioParticular,String caracterHomologado) {
		boolean resultado = false;
		String noExteriorFormulario = null;
		String noInteriorFormulario = null;
		if(domicilioParticular instanceof DatosDomicilioParticularTrabajador) {
			DatosDomicilioParticularTrabajador domicilio = (DatosDomicilioParticularTrabajador) domicilioParticular;
			noExteriorFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroExterior(), ExpresionesConstants.VACIO);
			noExteriorFormulario = notificacionExpedienteService.eliminarAcentos(noExteriorFormulario, caracterHomologado);
			noInteriorFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroInterior(), ExpresionesConstants.VACIO);
			noInteriorFormulario = notificacionExpedienteService.eliminarAcentos(noInteriorFormulario, caracterHomologado);

			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(noExteriorFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(noExteriorDB,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(noInteriorFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(noInteriorDB,ExpresionesConstants.VACIO)) || !domicilio.getCodigoPostal().equals(codigoPostalDB) || !domicilio.getPais().equalsIgnoreCase(clavePaisDB)) {
				resultado = true;
			}
		}else if(domicilioParticular instanceof DatosParticulares) {
			DatosParticulares domicilio = (DatosParticulares) domicilioParticular;
			noExteriorFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroExterior(), ExpresionesConstants.VACIO);
			noExteriorFormulario = notificacionExpedienteService.eliminarAcentos(noExteriorFormulario, caracterHomologado);
			noInteriorFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroInterior(), ExpresionesConstants.VACIO);
			noInteriorFormulario = notificacionExpedienteService.eliminarAcentos(noInteriorFormulario, caracterHomologado);
			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(noExteriorFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(noExteriorDB,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(noInteriorFormulario, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(noInteriorDB,ExpresionesConstants.VACIO)) || !domicilio.getCodigoPostal().equals(codigoPostalDB) || !domicilio.getPais().equalsIgnoreCase(clavePaisDB)) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarCambiosRfc(DatosTrabajador datosTrabajador, Object entradaProceso) {
		Boolean resultado = false;
		String rfcBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosNoCertificables().getRfc(), ExpresionesConstants.VACIO);
		if(entradaProceso instanceof EntradaModificacion) {
			DatosBaseCurp baseCurp = ((EntradaModificacion) entradaProceso).getDatosBaseCurp();
			String rfcModificada = utileriaCadena.obtenerContenidoCadenaSinEspacios(baseCurp.getRfc(), ExpresionesConstants.VACIO);			
			if(!rfcModificada.equalsIgnoreCase(rfcBd)) {
				resultado = true;
			}
		}else if(entradaProceso instanceof EntradaPermanencia) {
			String rfcModificada = ((EntradaPermanencia) entradaProceso).getRfc();
			rfcModificada = utileriaCadena.obtenerContenidoCadenaSinEspacios(rfcModificada, ExpresionesConstants.VACIO);
			if(!rfcModificada.equalsIgnoreCase(rfcBd)) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarCambioCurpCoppel(String estatusExpeIde, String claveAfore,DatosTrabajador trabajador,EntradaModificacion entradaModificacion,String bandera13) {
		String estatusExpeIdentificacion = utileriaCadena.obtenerContenidoCadenaSinEspacios(estatusExpeIde,ExpresionesConstants.VACIO);
		String estatusExpedienteIdentificacion = estatusExpeIdentificacion;
		if(!validadorUtils.validarObjetoNulo(bandera13) && NumerosConstants.C_UNO.equals(bandera13) && ServiciosConstants.CLAVE_AFORE_COPPEL.equals(claveAfore)){
			String curpActual = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO);
			String curpNueva = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaModificacion.getDatosBaseCurp().getCurpNueva(),ExpresionesConstants.VACIO);
			if(!curpNueva.equalsIgnoreCase(curpActual) && !NumerosConstants.C_CINCO.equals(estatusExpeIdentificacion)) {
				String cvProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
				ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(curpNueva, cvProceso, "5");
				if(!validadorUtils.validarObjetoNulo(respuesta)) {
					estatusExpedienteIdentificacion = respuesta.getCvEstatusExpe();
				}
			}
		}
		return estatusExpedienteIdentificacion;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean varlidarDatosBase(DatosTrabajador datosTrabajador, EntradaModificacion entradaModificacion) {
		boolean resultado = false;
		DatosCertificables certificables = datosTrabajador.getDatosCertificables();
		String curpActual = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getCurp(), ExpresionesConstants.VACIO);
		String generoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getClaveGenero(), ExpresionesConstants.VACIO);
		Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(certificables.getFechaNacimiento(),  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;
		String fechaNacimientoTrabajador = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_SERVICIO_MODIFICACION);		
		String fechaNacimientoBD = fechaUtils.ObtenerFechas(validadorUtils.validarVacio(fechaNacimientoTrabajador) ? "0000-00-00" : fechaNacimientoTrabajador);
		String entidadNacimientoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(certificables.getClaveEntidadN(), ExpresionesConstants.VACIO);
			DatosBaseCurp baseCurp = entradaModificacion.getDatosBaseCurp();
			String fechaNacimientoModificacion = fechaUtils.ObtenerFechas(baseCurp.getFechaDeNacimiento());
			String generoModificacion = NumerosConstants.C_UNO.equals(baseCurp.getSexo()) ? "M" : "F";
			if(!baseCurp.getCurpNueva().equalsIgnoreCase(curpActual) || !generoModificacion.equalsIgnoreCase(generoBd) || !fechaNacimientoModificacion.equalsIgnoreCase(fechaNacimientoBD) || !baseCurp.getEntidadFederativaDeNacimiento().equalsIgnoreCase(entidadNacimientoBd)) {
				resultado = true;
			}
		logger.info("respuesta varlidarDatosBase :: {}",resultado);
		return resultado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntradaModificacion regresaDatosBaseModificacion(DatosBaseFormulario datosBaseFormulario) {
		DatosBaseCurp datosBase = new DatosBaseCurp();
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		
		datosBase.setCurpNueva(datosBaseFormulario.getCurpNueva());
		datosBase.setNombreTrabajador(datosBaseFormulario.getNombreNuevo());
		datosBase.setApellidoPaterno(datosBaseFormulario.getApellidoPaternoNuevo());
		datosBase.setApellidoMaterno(datosBaseFormulario.getApellidoMaternoNuevo());
		datosBase.setFechaDeNacimiento(datosBaseFormulario.getFechaNacimientoNuevo());
		datosBase.setSexo(datosBaseFormulario.getGeneroNuevo());
		datosBase.setEntidadFederativaDeNacimiento(datosBaseFormulario.getEntidadNacimientoNuevo());
		entradaModificacion.setDatosBaseCurp(datosBase);
		
		logger.info("salida regresaDatosBaseModificacion :: {}",entradaModificacion);
		return entradaModificacion;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String regresarRespuestaValidaDatosBase(boolean validaNombre,boolean validaDatosBase) {
		logger.info("Entrada regresarRespuestaValidaDatosBase: {} {}",validaNombre,validaDatosBase);
		String respuesta = NumerosConstants.C_CERO;
		if(validaNombre || validaDatosBase) {
			respuesta = NumerosConstants.C_UNO;
		}
		logger.info("respuesta regresarRespuestaValidaDatosBase: {}",respuesta);
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validaMarcasProcesoPermanencia(Integer respuestaValidacion) {
		if(NumerosConstants.INT_DOS.equals(respuestaValidacion)) {
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * Metodo encargado de consultar caracter de homologacion en base de datos
	 * @return
	 */
	@Override
	public String consultarCaracterHomologado() {
		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!validadorUtils.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
		}
		return caracterHomologado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String regresarCurpActualNueva(String curpActual,String curpNueva) {
		curpActual = utileriaCadena.obtenerContenidoCadenaSinEspacios(curpActual, ExpresionesConstants.VACIO);
		curpNueva = utileriaCadena.obtenerContenidoCadenaSinEspacios(curpNueva, ExpresionesConstants.VACIO);
		String curp = curpActual;
		
		if(!curpNueva.equalsIgnoreCase(curpActual)) {
			curp = curpNueva;
		}
		
		return curp;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String recuperaFolioPadreOrigen(String curp,String proceso,String claveAfore,String resultadoOperacion,FlujoModificacion flujo) {
		logger.info("entrada recuperaFolioPadreOrigen :: curp :: {} proceso :: {} afore :: {} roperacion :: {}",curp,proceso,claveAfore,resultadoOperacion);
		ArchivoRecibido resultadoArchivo = null;
		String folioPadre = null;
		Long idfolioHijo = null;
		resultadoArchivo = servicioArchivos.validaExistenciaRecepcionExpediente(curp, proceso, claveAfore, resultadoOperacion);
		logger.info("resultado validaExistenciaRecepcionExpediente recuperaFolioPadreOrigen :: {}",resultadoArchivo);
		if(!validadorUtils.validarObjetoNulo(resultadoArchivo)) {
			Folio objetoFolioPadre = servicioFolio.consultarFolioPadrePorFolioHijo(resultadoArchivo.getFolioProcesarRecibido());
			logger.info("respuesta consultarFolioPadrePorFolioHijo :: recuperaFolioPadreOrigen :: {}",objetoFolioPadre);
			if(!validadorUtils.validarObjetoNulo(objetoFolioPadre)) {
				String estatusComparacion = NumerosConstants.C_TRES;
				String estatusFolioPadre = String.valueOf(objetoFolioPadre.getEstatusPadre());
				boolean respuestaBuscarExtediente = buscarExpedientePorTipo(proceso, claveAfore, curp, resultadoArchivo.getId());
				if(!estatusComparacion.equals(estatusFolioPadre) && respuestaBuscarExtediente) {
					folioPadre = objetoFolioPadre.getChFolio();
					idfolioHijo = resultadoArchivo.getFolioPulsar().getIdFolioPulssar();
					flujo.setIdFolioHijoPulssarOrigen(idfolioHijo);
				}
			}
		}
		
		logger.info("respuesta final recuperaFolioPadreOrigen :: {}",folioPadre);
		return folioPadre;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String recuperarFolioOrigenPorProceso(UsuarioLogin user,DatosTrabajador trabajador,String bandera13,String banderaP,EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia,FlujoModificacion flujo) {
		String folioRecuperado = null;
		String cveProceso = this.obtenerProcesoTipoExpedienteIdentificacion(trabajador.getTipoSolicitante());
		if(!validadorUtils.validarObjetoNulo(bandera13)) {
		   
		  String curp = regresarCurpActualNueva(trabajador.getDatosCertificables().getCurp() , entradaModificacion.getDatosBaseCurp().getCurpNueva());
			folioRecuperado = recuperaFolioPadreOrigen(curp, "67", user.getAforeUsuario(), "01",flujo);
			logger.info("resultado 67 13 recuperarFolioOrigenPorProceso :: {}",folioRecuperado);
			if(validadorUtils.validarObjetoNulo(folioRecuperado)) {
				folioRecuperado = recuperaFolioPadreOrigen(curp, cveProceso, user.getAforeUsuario(), "01",flujo);
				logger.info("resultado 01 13 recuperarFolioOrigenPorProceso :: {}",folioRecuperado);
			}
	   }else if (!validadorUtils.validarObjetoNulo(banderaP)) {
			folioRecuperado = recuperaFolioPadreOrigen(entradaPermanencia.getCurpTrabajador(), "67", user.getAforeUsuario(), "01",flujo);
			logger.info("resultado 67 17 recuperarFolioOrigenPorProceso :: {}",folioRecuperado);
			if(validadorUtils.validarObjetoNulo(folioRecuperado)) {
				folioRecuperado = recuperaFolioPadreOrigen(entradaPermanencia.getCurpTrabajador(), cveProceso, user.getAforeUsuario(), "01",flujo); 
				logger.info("resultado 01 17 recuperarFolioOrigenPorProceso :: {}",folioRecuperado);
			}
	   }
		logger.info("salida recuperarFolioOrigenPorProceso :: {}",folioRecuperado);
		return folioRecuperado;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalidaActualizaDatos ejecutaProcesoE83(EntradaModificacion entrada,DatosTrabajador trabajador,String estatus,String respuestaDiagnostico,String restoDiagnostico,SalidaActualizaDatos respuestaSalidaModificacion) {
		logger.info("datos entrada ejecutaProcesoE83 {} {} {} {} {} {}",entrada,trabajador,estatus,respuestaDiagnostico,restoDiagnostico,respuestaSalidaModificacion);
		SalidaActualizaDatos salidaModificacion = respuestaSalidaModificacion;
		if(ModificacionTrabajadorConstants.RESULTADO_OPERACION.equals(estatus) && ModificacionTrabajadorConstants.DIAGNOSTICO_E83.equals(respuestaDiagnostico) && ModificacionTrabajadorConstants.RESTO_DIAGNOSTICO.equals(restoDiagnostico)){
			entrada.setTipoDeMovimiento(ModificacionTrabajadorConstants.TIPO_MOVIMIENTO);
			entrada.getDatosBaseCurp().setFlujoDeValidacion(ModificacionTrabajadorConstants.FLUJO_9A);
			String banderaRelanzamiento = NumerosConstants.C_UNO;
			salidaModificacion = this.ejecutarModificacion(entrada,trabajador,banderaRelanzamiento);
		}
		logger.info("salida ejecutaProcesoE83 {}",salidaModificacion);
		return salidaModificacion;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cerrarFolioOrigen(FlujoModificacion flujoModificacion) {
		logger.info("entrada cerrarFolioOrigen :: {}",flujoModificacion);
		if(!validadorUtils.validarObjetoNulo(flujoModificacion)) {
			if(!validadorUtils.validarObjetoNulo(flujoModificacion.getIdFolioHijoPulssarOrigen())) {
				servicioFolio.cerrarFolio(flujoModificacion.getIdFolioHijoPulssarOrigen(), NumerosConstants.INT_TRES);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean buscarExpedientePorTipo(String proceso,String claveAfore,String curpTrabajador,Long idArchivoRecibido) {
		boolean respuesta = false;
		if("67".equals(proceso)) {
			ExpedienteDetail respuestaExpedienteSolicitud = expedienteService.consultaExpedienteSolicitud(proceso, "0305", claveAfore, curpTrabajador, NumerosConstants.C_DOS);
			if(!validadorUtils.validarObjetoNulo(respuestaExpedienteSolicitud)) {
				respuesta = true;
				return respuesta;
			}
		}else {
			List<RespuestaExpedienteDetalle> listaRespuestaExpedienteDetalle = expedienteService.buscarExpendienteServ(idArchivoRecibido);
			if(!validadorUtils.validarListaVacia(listaRespuestaExpedienteDetalle)) {
				RespuestaExpedienteDetalle respuestaExpedienteDetalle = listaRespuestaExpedienteDetalle.get(NumerosConstants.INT_CERO);
				if(!validadorUtils.validarObjetoNulo(respuestaExpedienteDetalle)) {
					List<ExpedienteDetail> listaRespuestaExpediente = expedienteService.buscarExpediente(curpTrabajador, respuestaExpedienteDetalle.getFolioAfore(), claveAfore, NumerosConstants.C_UNO, proceso);
					if(!validadorUtils.validarListaVacia(listaRespuestaExpediente)) {
						respuesta = true;
						return respuesta;
					}
				}
			}
		}
		return respuesta;
	}
	

	public boolean validaDatosRenapo(String curpActualLimpia,String curpNuevaLimpia) {
		logger.info("entrada validaDatosRenapo curpActual :: {} curpNueva :: {}",curpActualLimpia,curpNuevaLimpia);
		boolean banderaLigaRenapo = true;
		CURPStruct respuestaRenapo =  obtenerDatosCurp(curpNuevaLimpia);
		logger.info("respuesta obtenerDatosCurp :: validaDatosRenapo {}",respuestaRenapo);
		if(!validadorUtils.validarObjetoNulo(respuestaRenapo) && !validadorUtils.isEmpty(respuestaRenapo.getCurp()) && !validadorUtils.isEmpty(respuestaRenapo.getNombres())) {
			List<String> listaCurpHistoricas = Arrays.asList(respuestaRenapo.getCurpHistoricas());
			if(!validadorUtils.validarListaVacia(listaCurpHistoricas)) {
				for(String curp : listaCurpHistoricas) {
					if(curpActualLimpia.equalsIgnoreCase(curp)) {
						banderaLigaRenapo = false;
						logger.info("salida validaDatosRenapo :: {}",banderaLigaRenapo);
						return banderaLigaRenapo;
					}
				}
			}
		}
		logger.info("salida validaDatosRenapo :: {}",banderaLigaRenapo);
		return banderaLigaRenapo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validaFlujo9B(DatosTrabajador datosTrabajador,String curpNueva,String nombre,String apellidoPaterno,String apellidoMaterno,String cvAfore) {
		String respuesta = NumerosConstants.C_CERO;
		
		String curpNuevaLimpia = utileriaCadena.obtenerContenidoCadenaSinEspacios(curpNueva, ExpresionesConstants.VACIO);
		String curpActualLimpia = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO);
		
		String nombreActualLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getNombre(), ExpresionesConstants.VACIO);
		String apellidoPaternoActualLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getApellidoPaterno(), ExpresionesConstants.VACIO);
		String apellidoMaternoActualLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getApellidoMaterno(), ExpresionesConstants.VACIO);
		
		String nombreNuevoLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(nombre, ExpresionesConstants.VACIO);
		String apellidoPaternoNuevoLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaterno, ExpresionesConstants.VACIO);
		String apellidoMaternoNuevoLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaterno, ExpresionesConstants.VACIO);
	
		if(!validadorUtils.validarVacio(curpActualLimpia) && !validadorUtils.validarVacio(curpNuevaLimpia) && !curpActualLimpia.equalsIgnoreCase(curpNuevaLimpia)) {
			boolean respuestaValidaRenapo = validaDatosRenapo(curpActualLimpia, curpNuevaLimpia);
			if(respuestaValidaRenapo) {
				String curpRaizActual = curpActualLimpia.substring(0,16);
				String curpRaizNueva = curpNuevaLimpia.substring(0,16);
				String inicioCurpRaizActual = curpRaizActual.substring(0, 10);
				String inicioCurpRaizNueva = curpRaizNueva.substring(0, 10);
				String sexoCurpRaizActual = curpActualLimpia.substring(10, 11);
				String sexoCurpRaizNueva = curpNuevaLimpia.substring(10,11);
				String restoCurpRaizActual = curpRaizActual.substring(11,16);
				String restoCurpRaizNueva = curpRaizNueva.substring(11,16);
				logger.info("raiz actual:: {}, raiz nueva:: {}, sexo actual:: {}, sexo nuevo:: {},resto curp actual:: {},resto curp nueva:: {}",curpRaizActual,curpRaizNueva,sexoCurpRaizActual,sexoCurpRaizNueva,restoCurpRaizActual,restoCurpRaizNueva);
				if(!inicioCurpRaizActual.equalsIgnoreCase(inicioCurpRaizNueva) || !restoCurpRaizActual.equalsIgnoreCase(restoCurpRaizNueva)) {
						respuesta = NumerosConstants.C_UNO;
					if(!nombreNuevoLimpio.equalsIgnoreCase(nombreActualLimpio) || !apellidoPaternoNuevoLimpio.equalsIgnoreCase(apellidoPaternoActualLimpio) || !apellidoMaternoNuevoLimpio.equalsIgnoreCase(apellidoMaternoActualLimpio)) {
						respuesta = validaCambioTotalNombre9B(datosTrabajador, respuesta, apellidoPaternoNuevoLimpio, apellidoMaternoNuevoLimpio, nombreNuevoLimpio, curpActualLimpia, curpNuevaLimpia);
					}
				}
			}
		}
		
		respuesta = validaListaAforesPermitidas9B(respuesta, cvAfore);
		logger.info("respuesta validaFlujo9B :: {}",respuesta);
		return respuesta;
	}
	
	/**
	 * Metodo que valida cambio completo en nombre
	 * @param datosTrabajador
	 * @param respuestaPrincipal
	 * @param apellidoPaternoFormulario
	 * @param apellidoMaternoFormulario
	 * @param nombreFormulario
	 * @param curpActual
	 * @param curpNueva
	 * @return
	 */
	private String validaCambioTotalNombre9B(DatosTrabajador datosTrabajador,String respuestaPrincipal,String apellidoPaternoFormulario,String apellidoMaternoFormulario,String nombreFormulario,String curpActual,String curpNueva) {
		logger.info("entrando validaCambioTotalNombre9B");
		String respuesta = respuestaPrincipal;
		
		String apellidoPaternoFormularioLimplio = null;
		String apellidoMaternoFormularioLimpio = null;
		String nombreFormularioLimpio = null;
		
		String caracterHomologado = consultarCaracterHomologado();
		
		apellidoPaternoFormularioLimplio = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoFormulario, ExpresionesConstants.VACIO);
		apellidoPaternoFormularioLimplio = notificacionExpedienteService.eliminarAcentos(apellidoPaternoFormularioLimplio, caracterHomologado);
		logger.info("apellidoPaternoFormularioLimplio :: {}",apellidoPaternoFormularioLimplio);
		
		apellidoMaternoFormularioLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoFormulario, ExpresionesConstants.VACIO);
		apellidoMaternoFormularioLimpio = notificacionExpedienteService.eliminarAcentos(apellidoMaternoFormularioLimpio, caracterHomologado);
		logger.info("apellidoMaternoFormularioLimpio :: {}",apellidoMaternoFormularioLimpio);
		
		nombreFormularioLimpio = utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreFormulario, ExpresionesConstants.VACIO);
		nombreFormularioLimpio = notificacionExpedienteService.eliminarAcentos(nombreFormularioLimpio, caracterHomologado);
		logger.info("nombreFormularioLimpio :: {}",nombreFormularioLimpio);
		
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametroDdbpose(ModificacionTrabajadorConstants.PARAMETRO_AFILIACION_ISSSTE);
		List<String> valoresIssste = validadorUtils.obtenerListaParametro(listaParametro, AgenteConstants.TIPO_AFILIACION_ISSSTE, null);
		if(!valoresIssste.contains(datosTrabajador.getTipoAfiliacion())) {
			respuesta = validaConsultaCanase(datosTrabajador, caracterHomologado, respuesta, apellidoPaternoFormularioLimplio, apellidoMaternoFormularioLimpio, nombreFormularioLimpio,curpNueva);
			logger.info("salida validaConsultaCanase :: {}",respuesta);

		}else {
			respuesta = validaConsultaAnexo(curpActual, curpNueva, apellidoPaternoFormularioLimplio, apellidoMaternoFormularioLimpio, nombreFormularioLimpio, respuesta, caracterHomologado);
			logger.info("respuesta validaConsultaAnexo :: {}",respuesta);
		}
		logger.info("salida validaCambioTotalNombre9B :: {}",respuesta);
		return respuesta;
	}
	
	/**
	 * Metodo que valida consulta canase
	 * @param datosTrabajador
	 * @param caracterHomologado
	 * @param respuestaInicial
	 * @param apellidoPaternoFormularioLimplio
	 * @param apellidoMaternoFormularioLimpio
	 * @param nombreFormularioLimpio
	 * @return
	 */
	private String validaConsultaCanase(DatosTrabajador datosTrabajador,String caracterHomologado,String respuestaInicial,String apellidoPaternoFormularioLimplio,String apellidoMaternoFormularioLimpio,String nombreFormularioLimpio,String curpNueva) {
		String respuesta = respuestaInicial;
		String apellidoPaternoServicio = null;
		String apellidoMaternoServicio = null;
		String nombreServicio = null;
		String curpServicio = null;
		Canase canase = canaceService.consultarCanase(datosTrabajador.getNss());
		if(!validadorUtils.validarObjetoNulo(canase)) {
			if(!validadorUtils.isEmpty(canase.getNombreImss())) {
				String  nombreCanaseSustituido = utileriaCadena.obtenerContenidoCadenaSinEspacios(canase.getNombreImss(), ExpresionesConstants.VACIO).replace("$","#");
				String[] arregloNombreCanase = nombreCanaseSustituido.split("#");
				apellidoPaternoServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(arregloNombreCanase[NumerosConstants.INT_CERO], ExpresionesConstants.VACIO); 
				apellidoPaternoServicio = notificacionExpedienteService.eliminarAcentos(apellidoPaternoServicio,caracterHomologado);
				logger.info("validaConsultaCanase apellidoPaternoServicio: {}",apellidoPaternoServicio);
				apellidoMaternoServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(arregloNombreCanase[NumerosConstants.INT_UNO],ExpresionesConstants.VACIO);
				apellidoMaternoServicio = notificacionExpedienteService.eliminarAcentos(apellidoMaternoServicio,caracterHomologado);
				logger.info("validaConsultaCanase apellidoMaternoServicio: {}",apellidoMaternoServicio);

				nombreServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(arregloNombreCanase[NumerosConstants.INT_DOS],ExpresionesConstants.VACIO);
				nombreServicio = notificacionExpedienteService.eliminarAcentos(nombreServicio,caracterHomologado);
				logger.info("validaConsultaCanase nombreServicio: {}",nombreServicio);

				curpServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(canase.getCurp(), ExpresionesConstants.VACIO);
				logger.info("validaConsultaCanase curpServicio: {}",curpServicio);

				if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoFormularioLimplio, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoServicio, ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoFormularioLimpio, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoServicio,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreFormularioLimpio, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreServicio, ExpresionesConstants.VACIO)) || !curpNueva.equalsIgnoreCase(curpServicio)) {
					respuesta = NumerosConstants.C_CUATRO;
					return respuesta;
				}
			}else {
				respuesta = NumerosConstants.C_DOS;
				return respuesta;
			}
		}else {
			respuesta = NumerosConstants.C_DOS;
			return respuesta;
		}		
		return respuesta;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validaConsultaAnexo(String curpActual,String curpNueva,String apellidoPaternoFormularioLimplio,String apellidoMaternoFormularioLimpio,String nombreFormularioLimpio,String respuestaInicial,String caracterHomologado) {
		String respuesta = respuestaInicial;
		String apellidoPaternoServicio = null;
		String apellidoMaternoServicio = null;
		String nombreServicio = null;
		String curpServicio = null;
		List<AnexoATrabajadorIssste> listaAnexo = anexoService.consultaAnexoTrabajador(curpNueva);
		if(validadorUtils.validarListaVacia(listaAnexo)) {
			listaAnexo = anexoService.consultaAnexoTrabajador(curpActual);
		}
		if(!validadorUtils.validarListaVacia(listaAnexo)) {
			for(AnexoATrabajadorIssste anexo : listaAnexo ) {
				apellidoPaternoServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(anexo.getChApellidoPaterno(), ExpresionesConstants.VACIO); 
				apellidoPaternoServicio = notificacionExpedienteService.eliminarAcentos(apellidoPaternoServicio,caracterHomologado);
				logger.info("validaConsultaAnexo apellidoPaternoServicio: {}",apellidoPaternoServicio);
				
				apellidoMaternoServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(anexo.getChApellidoMaterno(),ExpresionesConstants.VACIO);
				apellidoMaternoServicio = notificacionExpedienteService.eliminarAcentos(apellidoMaternoServicio,caracterHomologado);
				logger.info("validaConsultaAnexo apellidoMaternoServicio: {}",apellidoMaternoServicio);

				nombreServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(anexo.getChNombre(),ExpresionesConstants.VACIO);
				nombreServicio = notificacionExpedienteService.eliminarAcentos(nombreServicio,caracterHomologado);
				logger.info("validaConsultaAnexo nombreServicio: {}",nombreServicio);

				curpServicio = utileriaCadena.obtenerContenidoCadenaSinEspacios(anexo.getCurp(), ExpresionesConstants.VACIO);
				logger.info("validaConsultaAnexo curpServicio: {}",curpServicio);

				
				if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoFormularioLimplio, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoServicio, ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoFormularioLimpio, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoServicio,ExpresionesConstants.VACIO)) || !utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreFormularioLimpio, ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreServicio, ExpresionesConstants.VACIO)) || !curpNueva.equalsIgnoreCase(curpServicio)) {
					respuesta = NumerosConstants.C_CUATRO;
					return respuesta;
				}
			}
		}else {
			respuesta = NumerosConstants.C_DOS;
			return respuesta;
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarIndicadorEnrolamiento9B(String banderaFlujo9B,String estatusEnrolamiento) {
		logger.info("Entrada validarIndicadorEnrolamiento9B : {} {}",banderaFlujo9B,estatusEnrolamiento);
		String indicadorEnrolamiento = null;
		String enrolamientoEstatus = utileriaCadena.obtenerContenidoCadenaSinEspacios(estatusEnrolamiento, ExpresionesConstants.VACIO);

		if(!validadorUtils.isEmpty(banderaFlujo9B)) {
			indicadorEnrolamiento = NumerosConstants.C_UNO;
			if(NumerosConstants.C_CINCO.equals(enrolamientoEstatus)) {
				indicadorEnrolamiento = NumerosConstants.C_DOS;
			}
		}
		logger.info("salida validarIndicadorEnrolamiento9B : {}",indicadorEnrolamiento);
		return indicadorEnrolamiento;
	}
	
	/**
	 * {@inheritDo}
	 */
	@Override
	public FlujosEntrada asignarFlujoCaso9B(String banderaFlujo9B) {
		FlujosEntrada flujoSalida = null;
		if(!validadorUtils.isEmpty(banderaFlujo9B)) {
			flujoSalida = new FlujosEntrada();
			flujoSalida.setMovimiento(ModificacionTrabajadorConstants.TIPO_MOVIMIENTO);
			flujoSalida.setFlujoValidacion(ModificacionTrabajadorConstants.FLUJO_9B);
		}
		return flujoSalida;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteSalida validarEstatusExpedientes(FlujoModificacion flujoModificacion,ExpedienteSalida expedienteSalida) {
		ExpedienteSalida salidaExpediente = expedienteSalida;
		if(!validadorUtils.validarObjetoNulo(flujoModificacion) && !validadorUtils.validarObjetoNulo(expedienteSalida)) {
			salidaExpediente.setEstatusExpedienteIdentificacion(!validadorUtils.isEmpty(flujoModificacion.getEstatusExpeIdentificacion()) ? flujoModificacion.getEstatusExpeIdentificacion() : expedienteSalida.getEstatusExpedienteIdentificacion());
			salidaExpediente.setClaveAforeExpIdentificacion(!validadorUtils.isEmpty(flujoModificacion.getEstatusExpeIdentificacion()) ? flujoModificacion.getCvAforExpeIdentificacion() : expedienteSalida.getClaveAforeExpIdentificacion());
			salidaExpediente.setEstatusEnrolamiento(!validadorUtils.isEmpty(flujoModificacion.getEstatusExpeBiometrico()) ? flujoModificacion.getEstatusExpeBiometrico() : expedienteSalida.getEstatusEnrolamiento());
			salidaExpediente.setClaveAforeExpBiometrico(!validadorUtils.isEmpty(flujoModificacion.getEstatusExpeBiometrico()) ? flujoModificacion.getCvAforeExpeBiometrico() : expedienteSalida.getClaveAforeExpBiometrico());
		}
		return salidaExpediente;
	}
	
	
	public String validaListaAforesPermitidas9B(String respuestaEntrada,String claveAfore) {
		String respuestaSalida = respuestaEntrada;
		logger.info("entrada validaListaAforesPermitidas9B :: {} {}",respuestaEntrada,claveAfore);
		Parametro parametroAfores = expedienteServicio.obtenerValorParametro(ModificacionTrabajadorConstants.PARAMETRO_AFORES_AUTORIZADAS_9B);
		String afores = parametroAfores.getChValorParametro();
		logger.info("respuesta parametro afores :: {}",afores);
		if(NumerosConstants.C_UNO.equals(respuestaEntrada) && !afores.contains(claveAfore) || NumerosConstants.C_DOS.equals(respuestaEntrada) && !afores.contains(claveAfore) || NumerosConstants.C_CUATRO.equals(respuestaEntrada) && !afores.contains(claveAfore)) {
			respuestaSalida = NumerosConstants.C_TRES;
		}
		return respuestaSalida;
	}
	
	private String validaExpedientesFlujo9B(String bandera9B,DatosTrabajador trabajador,EntradaModificacion entradaModificacion,String claveProceso,String controladorInicial,FlujoModificacion flujoModificacion,UsuarioLogin user,String controladorRedireccion,String estatusValidacion) {
		String controlador = controladorInicial;
		ExpedienteDetail respuesta =null;
		if(!validadorUtils.isEmpty(bandera9B) && validadorUtils.isEmpty(controladorInicial)) {
			if("67,68".contains(claveProceso)) { 
				respuesta = validaExpedienteBiometricoCurpExistente(trabajador,"5");
			}
			 if(validadorUtils.validarObjetoNulo(respuesta)) {
					controlador = validarExpedientesCambioCurp(respuesta,entradaModificacion,claveProceso,user,controladorRedireccion,estatusValidacion,flujoModificacion);
				
			}
		}
		
		return controlador;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteDetail validaExpedienteEnrolamientoNoTitular9B(DatosTrabajador trabajador,EntradaModificacion entradaModificacion,String banderaFlujo9B) {
		ExpedienteDetail respuesta = null;
		if(!validadorUtils.isEmpty(banderaFlujo9B)) {
			 respuesta = validaExpedienteBiometricoCurpExistente(trabajador,"5");
			 if(validadorUtils.validarObjetoNulo(respuesta)) {
				respuesta = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), "67", "5");
				if(validadorUtils.validarObjetoNulo(respuesta)) {
					respuesta = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), "68", "5");
				}
			 }
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteDetail validaExpedienteIdentificacionNoTitularCurpNueva(DatosTrabajador trabajador,EntradaModificacion entradaModificacion,ExpedienteDetail respuesta,String cveProceso) {
		ExpedienteDetail respuestaExpediente = respuesta;
		if(!validadorUtils.validarObjetoNulo(entradaModificacion) && validadorUtils.validarObjetoNulo(respuesta)) {
			if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaModificacion.getDatosBaseCurp().getCurpNueva(), ExpresionesConstants.VACIO).equalsIgnoreCase(utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO))) {
				respuestaExpediente = expedienteService.consultarExpedienteProcesoSinAfore(entradaModificacion.getDatosBaseCurp().getCurpNueva(), cveProceso, "1,5");
			}
		}
		return respuestaExpediente;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer obtenerNumeroBeneficiariosPermitido() {
		Integer numeroBeneficiariosPermitido = NumerosConstants.INT_CINCO;
		Parametro resultadoParametro = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_NUMERO_BENEFICIARIOS_ACEPTADO);
		if(!validadorUtils.validarObjetoNulo(resultadoParametro)) {
			numeroBeneficiariosPermitido = Integer.valueOf(resultadoParametro.getChValorParametro());
		}
		return numeroBeneficiariosPermitido;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validaNumeroMovimientoBeneficiario(EntradaModificacion entradaModificacion) {
		String movimiento = entradaModificacion.getDatosBaseCurp().getMovimientoBeneficiario();
		if(NumerosConstants.C_TRES.equals(movimiento)) {
			entradaModificacion.setListaBeneficiariosTrabajador(null);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registraSolicitudReimpresionModificacion(EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia,String diagnostico,String folioProcesar,String selloPermanencia) {
		logger.error("Se registraSolicitudReimpresionModificacion entrada modificaccion::{} ", entradaModificacion);
		logger.error("Se registraSolicitudReimpresionModificacion entrada modificaccion::{} ", entradaPermanencia);
		RespuestaServicioNotificacion notificacion=null;
		if(ModificacionTrabajadorConstants.DIAGNOSTICO_COMPLETO_ACEPTADO.equals(diagnostico)) {
			logger.error("Se registraSolicitudReimpresionModificacion aceptado::{} ", diagnostico);
			notificacion=reimpresionTramitesService.envioNotificacionTramites(obtenerEntradaTramitesConcluidos(entradaModificacion,entradaPermanencia,folioProcesar,selloPermanencia,FormatoConstants.RESULTADO_OPERACION_ACEPTADO,""));
			logger.error("Se envio notificacion modificador de datos ::{} ", notificacion);
		}else {
			logger.error("Se registraSolicitudReimpresionModificacion rechazado::{} ", diagnostico);
			notificacion=reimpresionTramitesService.envioNotificacionTramites(obtenerEntradaTramitesConcluidos(entradaModificacion,entradaPermanencia,folioProcesar,selloPermanencia,FormatoConstants.RESULTADO_OPERACION_RECHAZADO,diagnostico));
			logger.error("Se envio notificacion modificador de datos ::{} ", notificacion);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validaExpedienteCambioCurp(DatosTrabajador datosTrabajador,EntradaModificacion entradaModificacion,String bandera13,String controladorEntrante,String controladorRedireccion,String claveAfore) {
		logger.info("Entrando validaExpedienteCambioCurp: {}",controladorEntrante);
		String controladorRespuesta = controladorEntrante;
		if(!validadorUtils.validarObjetoNulo(bandera13)) {
			String curpActual = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO);
			String curpNueva = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaModificacion.getDatosBaseCurp().getCurpNueva(),ExpresionesConstants.VACIO);
			logger.info("curpActual: {},curpNueva: {}",curpActual,curpNueva);
			if(!curpNueva.equalsIgnoreCase(curpActual)) {
				String cvProceso = this.obtenerProcesoTipoExpedienteIdentificacion(datosTrabajador.getTipoSolicitante());
				ExpedienteDetail respuesta = expedienteService.consultarExpedienteProcesoSinAfore(curpNueva, cvProceso, "1");
				logger.info("salida Exp validaExpedienteCambioCurp: {}",respuesta);
				if(!validadorUtils.validarObjetoNulo(respuesta)) {
					if(!claveAfore.equals(respuesta.getAfore().getClaveAfore())) {
						controladorRespuesta = controladorRedireccion;
					}
				}else {
					controladorRespuesta = controladorRedireccion;
				}


			}
		}
		logger.info("salida validaExpedienteCambioCurp: {}",controladorRespuesta);
		return controladorRespuesta;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validaFlujoDigitalizador(FlujoModificacion flujoModificacion,ExpedienteSalida expedienteSalida,EntradaModificacion entradaModificacion,DatosTrabajador trabajador,String bandera13,String banderaFlujo9B) {
		String valorFlujo = NumerosConstants.C_CERO;
		if(!validadorUtils.validarObjetoNulo(bandera13)) {
			ExpedienteSalida salidaExpediente = validarEstatusExpedientes(flujoModificacion, expedienteSalida);
			FlujosEntrada flujo = obtenerRespuestaFlujo(entradaModificacion, trabajador, salidaExpediente);
			if(!validadorUtils.validarVacio(banderaFlujo9B)) {
				flujo = asignarFlujoCaso9B(banderaFlujo9B);
			}
			if(!validadorUtils.validarObjetoNulo(flujo)) {
				valorFlujo = flujo.getFlujoValidacion();
			}
		}
		return valorFlujo;

	}
	
	private TramitesConcluidosEntrada obtenerEntradaTramitesConcluidos(EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia,
			String folioProcesar,String selloPermanencia,String resultadoOperacion,String diagnostico) {
		TramitesConcluidosEntrada entradaTramiteConcluido = new TramitesConcluidosEntrada();
		String curp = null;
		String tipoSolicitante = null;
		String subTipoSolicitante = null;
		String organizacion = null;
		String chPeticion = null;
		if(!validadorUtils.validarObjetoNulo(entradaModificacion)) {
			logger.error("Peticion modificador de datos organizacion:{} ", entradaModificacion.getEntidadOrigen());
			curp = entradaModificacion.getDatosBaseCurp().getCurpNueva();
			tipoSolicitante = entradaModificacion.getDatosBaseCurp().getTipoSolicitante();
			subTipoSolicitante = ModificacionTrabajadorConstants.OPERACION_13;
			organizacion = entradaModificacion.getEntidadOrigen();
			
		}else {
			logger.error("Peticion permanencia organizacion:{} ", entradaPermanencia.getEntidadOrigen());
			CuerpoPermanenciaProcesoPendiente cuerpoPermanencia = new CuerpoPermanenciaProcesoPendiente();
			cuerpoPermanencia.setFolioCliente(folioProcesar);
			cuerpoPermanencia.setSelloVoluntadTrabajador(selloPermanencia);
			cuerpoPermanencia.setCuerpo(entradaPermanencia);
			curp = entradaPermanencia.getCurpTrabajador();
			tipoSolicitante = entradaPermanencia.getTipoSolicitante();
			subTipoSolicitante = ModificacionTrabajadorConstants.OPERACION_17;
			organizacion = entradaPermanencia.getEntidadOrigen();
			JsonUtilsImpl<CuerpoPermanencia> json = new JsonUtilsImpl<>();
			chPeticion = json.parseObjectToJsonSC(cuerpoPermanencia); 
		}
		entradaTramiteConcluido.setCurp(curp);
		entradaTramiteConcluido.setTipoSolicitante(tipoSolicitante);
		entradaTramiteConcluido.setSubTipoSolicitante(subTipoSolicitante);
		entradaTramiteConcluido.setAfore(organizacion);
		entradaTramiteConcluido.setFolioProcesar(folioProcesar);
		entradaTramiteConcluido.setPeticion(chPeticion);
		entradaTramiteConcluido.setUsuarioModificador(ModificacionTrabajadorConstants.OP13_CODOPER);
		entradaTramiteConcluido.setFcControl(new Date());
		entradaTramiteConcluido.setResultadoOperacion(resultadoOperacion);
		entradaTramiteConcluido.setDiagnostico(diagnostico!=null && !diagnostico.isEmpty()?diagnostico.substring(0,3):"");
		logger.error("Peticion modificador de datos:{} ", entradaTramiteConcluido);
		return entradaTramiteConcluido;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validaDetalleFolioModifcacionPermanencia(FolioActivoDetalle detalleFolioModificacion,FolioActivoDetalle detalleFolioPermanencia) {
		if(!validadorUtils.validarObjetoNulo(detalleFolioModificacion)){
			logger.info("Entrda cierre folio detalleFolioModificacion");
			servicioFolio.cerrarFolio(detalleFolioModificacion.getIdFolioPulssar(), 2);
		}
		
		if(!validadorUtils.validarObjetoNulo(detalleFolioPermanencia)){
			logger.info("Entrda cierre folio detalleFolioPermanencia");
			servicioFolio.cerrarFolio(detalleFolioPermanencia.getIdFolioPulssar(), 2);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validaBeneficiarioDesignado(List<Beneficiario> listaBeneficiario,EntradaConsulta consulta,String cvAfore) {
		if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(consulta.getCvTipoSolicitante())){
			String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;

			String curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(consulta.getCurpSolicitante(), ExpresionesConstants.VACIO).toUpperCase();
			
			String nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(consulta.getNombre(), ExpresionesConstants.VACIO).toUpperCase();
			nombre = notificacionExpedienteService.eliminarAcentos(nombre, caracterHomologado);
			nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(nombre, ExpresionesConstants.VACIO).toUpperCase();
	
			
			String apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(consulta.getApellidoPaterno(), ExpresionesConstants.VACIO).toUpperCase();
			apellidoPaterno = notificacionExpedienteService.eliminarAcentos(apellidoPaterno, caracterHomologado);
			apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaterno, ExpresionesConstants.VACIO).toUpperCase();
	
			
			String apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(consulta.getApellidoMaterno(), ExpresionesConstants.VACIO).toUpperCase();
			apellidoMaterno = notificacionExpedienteService.eliminarAcentos(apellidoMaterno, caracterHomologado);
			apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaterno, ExpresionesConstants.VACIO).toUpperCase();
	
			if(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(consulta.getCvTipoSolicitante()) && validadorUtils.validarListaVacia(listaBeneficiario)) {
				return false;
			}
			
			if(!validadorUtils.validarListaVacia(listaBeneficiario) && ModificacionTrabajadorConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(consulta.getCvTipoSolicitante())) {
				for(Beneficiario beneficiario : listaBeneficiario) {
					String curpBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiario.getCurp(), ExpresionesConstants.VACIO).toUpperCase();
					
					String nombreBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiario.getNombre(), ExpresionesConstants.VACIO).toUpperCase();
					nombreBd = notificacionExpedienteService.eliminarAcentos(nombreBd, caracterHomologado);
					nombreBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(nombreBd, ExpresionesConstants.VACIO).toUpperCase();
	
					String apellidoPaternoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiario.getApellidoPaterno(), ExpresionesConstants.VACIO).toUpperCase();
					apellidoPaternoBd = notificacionExpedienteService.eliminarAcentos(apellidoPaternoBd, caracterHomologado);
					apellidoPaternoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoPaternoBd, ExpresionesConstants.VACIO).toUpperCase();
	
					String apellidoMaternoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiario.getApellidoMaterno(), ExpresionesConstants.VACIO).toUpperCase();
					apellidoMaternoBd = notificacionExpedienteService.eliminarAcentos(apellidoMaternoBd, caracterHomologado);
					apellidoMaternoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(apellidoMaternoBd, ExpresionesConstants.VACIO).toUpperCase();
	
					if(curp.equals(curpBd) && nombre.equals(nombreBd) && apellidoPaterno.equals(apellidoPaternoBd) && apellidoMaterno.equals(apellidoMaternoBd)) {
						return true;
					}
					
				}
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntradaPermanencia validarEntradaPermanencia(EntradaPermanencia entradaPermanencia) {
		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!validadorUtils.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
		}
		
		DatosParticulares datosParticulares = notificacionExpedienteService.validaEntradaDatosParticulares(entradaPermanencia, caracterHomologado);
		DomicilioLaboral domicilioLaboral = notificacionExpedienteService.validaDomicilioLaboralPermanencia(entradaPermanencia, caracterHomologado);
		Referencias referencias = notificacionExpedienteService.validaReferenciasPermanencia(entradaPermanencia, caracterHomologado);
		Beneficiarios beneficiarios = notificacionExpedienteService.validaBeneficiariosPermanencia(entradaPermanencia, caracterHomologado);
		EntradaPermanencia entradaPermanenciaComparador = new EntradaPermanencia();
		entradaPermanenciaComparador.setEntidadOrigen(entradaPermanencia.getEntidadOrigen());
		entradaPermanenciaComparador.setCurpTrabajador(entradaPermanencia.getCurpTrabajador());
		entradaPermanenciaComparador.setNssTrabajador(entradaPermanencia.getNssTrabajador());
		entradaPermanenciaComparador.setRfc(entradaPermanencia.getRfc());
		entradaPermanenciaComparador.setApellidoPaterno(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getApellidoPaterno(), caracterHomologado));
		entradaPermanenciaComparador.setApellidoMaterno(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getApellidoMaterno(),caracterHomologado));
		entradaPermanenciaComparador.setNombreTrabajador(notificacionExpedienteService.eliminarAcentos(entradaPermanencia.getNombreTrabajador(),caracterHomologado));
		entradaPermanenciaComparador.setFechaDeNacimiento(entradaPermanencia.getFechaDeNacimiento());
		entradaPermanenciaComparador.setGenero(entradaPermanencia.getGenero());
		entradaPermanenciaComparador.setEntidadFederativaDeNacimiento(entradaPermanencia.getEntidadFederativaDeNacimiento());
		entradaPermanenciaComparador.setNacionalidad(entradaPermanencia.getNacionalidad());
		entradaPermanenciaComparador.setOcupacionOProfesionTrabajador(entradaPermanencia.getOcupacionOProfesionTrabajador());
		entradaPermanenciaComparador.setActividadOGiroNegocioTrabajador(entradaPermanencia.getActividadOGiroNegocioTrabajador());
		entradaPermanenciaComparador.setNivelDeEstudioTrabajador(entradaPermanencia.getNivelDeEstudioTrabajador());
		entradaPermanenciaComparador.setCurpSolicitante(entradaPermanencia.getCurpSolicitante());
		entradaPermanenciaComparador.setTipoSolicitante(entradaPermanencia.getTipoSolicitante());
		entradaPermanenciaComparador.setDatosParticulares(datosParticulares);
		entradaPermanenciaComparador.setDomicilioLaboral(domicilioLaboral);
		entradaPermanenciaComparador.setReferencias(referencias);
		entradaPermanenciaComparador.setBeneficiarios(beneficiarios);
		return entradaPermanenciaComparador;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerBotonEditarPermitido() {
		String resultado = NumerosConstants.C_CERO;
		Parametro resultadoParametro = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_BLOQUEO_BOTON_EDITAR);
		if(!validadorUtils.validarObjetoNulo(resultadoParametro)) {
			resultado = resultadoParametro.getChValorParametro();
		}
		return resultado;
	}
}
