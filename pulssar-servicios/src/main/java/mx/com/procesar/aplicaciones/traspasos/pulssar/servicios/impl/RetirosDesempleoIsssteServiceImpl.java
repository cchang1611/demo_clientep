/**
 * RetirosDesempleoIsssteServiceImpl.java
 * Fecha de creación: 29/08/2019, 17:23:18
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_PROCESO_RETIROS_PARCIALES_IMSS_LINEA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.CLAVE_REGIMEN_DT;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.CLAVE_REGIMEN_RO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaTrabajadorRetirosParcialesIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidaActividadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaTrabajadorRetirosParcialesIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretTrMovimientoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionCalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosSalidaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion Retiros Desempleo Issste
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 
 */
@Service
public class RetirosDesempleoIsssteServiceImpl implements RetirosDesempleoIsssteService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetirosDesempleoIsssteServiceImpl.class);
	/**
	 * uri Retiro Desempleo Issste
	 */
	@Value("${uri.consulta.retiro.desempleo.issste.uri}")
	private String uriConsultaRetiroDesempleoIssste;	
	/**
	 * uri Solicitud Cus
	 */
	@Value("${uri.solicitud.retiro.desempleo.issste.uri}")
	private String urisolicitudRetiroDesempleoIssste;	
	 /**
 	 * Ruta url de carpeta de expediente
 	 */
 	@Value("${ruta.carpeta.expediente}")
 	private String urlRutaExpedientes;
	/**
	 * uri Solicitud Cus
	 */
	@Value("${uri.guardar.tipo.retiro.desempleo.issste.uri}")
	private String uriguardaTipoRetiroIssste;	
	
	/**
	 * consultaMarcaOperativaMatrizConvivencia
	 */
	@Value("${comunes.consultaMarcaOperativaMatrizConvivencia}")
	private String consultaMarcaOperativaMatrizConvivencia;
	
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Value("${url.servicio.comunes}")
	private String servicioComunes;
	
	
	/**
	 * url notificacion calculo desempleo
	 */
	@Value("${comunes.exposicion.notificacion.calculodesempleo}")
	private String calculoDesempleo;
	
	
	/**
	 * Inyeccion Rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
  	/**
  	 * Inyeccion dependencia ValidarExpedienteServicio
  	 */
  	@Autowired
  	private ValidarExpedienteServicio validarExpedienteService;
  	
  	/**
  	 * Inyeccion NotificacionService
  	 */
  	@Autowired
  	private NotificacionService notificacionService;

  	
  	@Autowired
  	private ValidaActividadService actividadService;
  	
	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate restService;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	
	@Autowired
	private RechazoService rechazoService;
	
	
	@Autowired
	private ConsultaTrabajadorRetirosParcialesIsssteService consultaTrabRetService;
	
	/**
	 * Inyeccion dependencia JsonUtils
	 */
	@Autowired
	private JsonUtils jsonUtils;
     
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.biometricos.reenrolamiento.servicios.RetirosDesempleoIsssteService#consultarRetiroDesempleoIssste(java.lang.Long)
	 */
	@Override
	public Resolucion consultarRetiroDesempleoIssste(Long idProcesar) {
		StringBuilder url = new StringBuilder();
		url.append(uriConsultaRetiroDesempleoIssste);
		url.append(idProcesar);
		logger.info("uri de consulta de retiro parcial ISSSTE: {}", url.toString());
		ResponseEntity<BaseRespuesta<Resolucion>> response = restService.exchange(url.toString(), HttpMethod.GET, null,  new ParameterizedTypeReference<BaseRespuesta<Resolucion>>() {});
		BaseRespuesta<Resolucion> resolucion = response.getBody();
		resolucion.getDiagnosticoDeRecepcion();
		logger.info("Respuesta de consulta de retiro parcial ISSSTE: {}", resolucion.getObjetoRespuesta());
		if(utileriaValidador.validarObjetoNulo(resolucion)){
			throw new BusinessException("El trabajador no tiene una resolución");
		}
		if("02".equals(resolucion.getResultadoDeLaOperacion())){
			throw new BusinessException(resolucion.getDiagnosticoDeRecepcion());
		}
		return resolucion.getObjetoRespuesta();
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService#solicitarDisposicionParcialIssste(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoIssste, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada)
	 */
	@Override
	public SolicitudDisposicionParcialSalida solicitarDisposicionParcialIssste(DatosTrabajador datos,UsuarioLogin user, RetiroDesempleoIssste retiroDesempleoIssste, FolioEntrada folioEntrada, String tipoTramite) {
		logger.info("Solicitud de desempleo ISSSTE: {}", retiroDesempleoIssste);

		SolicitudDisposicionParcialSalida solicitudDisposicionParcialSalida;
        String estatusExpediente;
        int i = 0;
       	estatusExpediente = validarExpedienteService.validarExpedienteServicioIssste(folioEntrada.getFolioHijo(), datos, user,CLAVE_PROCESO_RETIROS_PARCIALES_IMSS_LINEA);
        logger.info("respuesta{}>>>:{}", i, estatusExpediente);
        if("01".equals(estatusExpediente)){
        	estatusExpediente = null;
        } else {
        	estatusExpediente = "El expediente no se ha generado";
        }
        
        logger.info("respuesta{}>>>:{}", i, estatusExpediente);

        if(!utileriaValidador.isEmpty(estatusExpediente)){
        	solicitudDisposicionParcialSalida = new SolicitudDisposicionParcialSalida();
        	solicitudDisposicionParcialSalida.setResultadoOperacion(ServiciosConstants.RESULTADO_NOK);
        	solicitudDisposicionParcialSalida.setDescripcionDiagnostico(estatusExpediente);
        }else {
            Resolucion resolucion = retiroDesempleoIssste.getResolucion();
			
    		SolicitudDisposicionParcialEntrada solicitud = new SolicitudDisposicionParcialEntrada();
    		solicitud.setClaveAfore(datos.getClaveAfore());
    		solicitud.setCurp(datos.getDatosCertificables().getCurp());
    		solicitud.setNss(datos.getNss());
    		solicitud.setSecuenciaPension(resolucion.getSecuenciaPension());
    		solicitud.setNombreTrabajador(datos.getDatosCertificables().getNombre());
    		solicitud.setApellidoPaternoTrabajador(datos.getDatosCertificables().getApellidoPaterno());
    		solicitud.setApellidoMaternoTrabajador(datos.getDatosCertificables().getApellidoMaterno());
    		solicitud.setTipoPrestacion("05");
    		solicitud.setTipoRegimen(resolucion.getIretMatrizDerecho().getClaveTipoRegimen());
    		solicitud.setTipoRetiro("F");
    		solicitud.setNumeroConcesion(resolucion.getNumeroConcesion());
    		solicitud.setSelloTrabajador(retiroDesempleoIssste.getSelloTrabajador().toString());
    		solicitud.setCurpAgente(user.getCurpAgente());
    		solicitud.setCurpSolicitante(datos.getDatosCertificables().getCurp());
    		solicitud.setTipoSolicitante("01");
    		solicitud.setOrigenSolicitud("01");
    		solicitud.setIdTramite(tipoTramite);
    		solicitud.setFolioRastreo(folioEntrada.getFolio());
    		solicitudDisposicionParcialSalida = enviarSolicitud(solicitud);

    		notificacionService.notificarPeracion52(solicitud, solicitudDisposicionParcialSalida, datos.getFolio().getFolio());
    	}
        
		

		return solicitudDisposicionParcialSalida;
		
	}
	
	/**
	 *  enviar Solicitud
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param solicitud
	 *  @return
	 */
	private SolicitudDisposicionParcialSalida enviarSolicitud(SolicitudDisposicionParcialEntrada solicitud) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("idServicio", "753");
		headers.set("idCliente", "35");
		headers.set("idEbusiness", "29");

		HttpEntity<SolicitudDisposicionParcialEntrada> entity = new HttpEntity<>(solicitud, headers);

		logger.error("json entrada solicitudDisposicionParcialIssste: {}", jsonUtils.parseObjectToJson(entity));
		ResponseEntity<SolicitudDisposicionParcialSalida> respuesta = restService.exchange(urisolicitudRetiroDesempleoIssste,  HttpMethod.POST, entity, SolicitudDisposicionParcialSalida.class);
		logger.error("json salida solicitudDisposicionParcialIssste: {}", jsonUtils.parseObjectToJson(respuesta.getBody()));
		
		SolicitudDisposicionParcialSalida salidasolicitud = respuesta.getBody();
		if(utileriaValidador.validarObjetoNulo(salidasolicitud)) {
			logger.error("salida Solicitar Retiro ISSSTE error, no se pudo generar la certificacion");
		}
		if(!"400".equals(salidasolicitud.getClaveDiagnostico())){
			salidasolicitud.setResultadoOperacion("02");
		} else {
			salidasolicitud.setResultadoOperacion("01");
		}
		return salidasolicitud;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService#consultarTipoRetiro(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Resolucion, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos)
	 */
	@Override
	public Map<String, Object> consultarTipoRetiro(Resolucion resolucion, DatosSaldos datosSaldos) {
		HashMap<String, Object> salida = new HashMap<>();
		DecimalFormat df = new DecimalFormat("###,###,###,###.##");
		df.setRoundingMode(RoundingMode.UP);
		final String MONTO_ESTIMADO = "montoEstimado";
		String regimen = resolucion.getIretMatrizDerecho().getClaveTipoRegimen();
		NotificacionCalculoTipoRetiro guardado= new NotificacionCalculoTipoRetiro();
		
		
		if(utileriaValidador.isEmpty(datosSaldos)){
			throw new BusinessException("Error, el trabajador no tiene valores para el calculo del monto retíro parcial");
		}
		


		if (CLAVE_REGIMEN_DT.equals(regimen) && StringUtils.isNotBlank(datosSaldos.getSaldoRetiro92I())) {

			Double saldo92I = 0.0;
			saldo92I = Double.valueOf(datosSaldos.getSaldoRetiro92I());
			
			Double sarIssste = saldo92I * 0.10;
			
			salida.put("sarissste", df.format(saldo92I)); 
			salida.put("sarissste10Pct", df.format(sarIssste));
			salida.put(MONTO_ESTIMADO, df.format(sarIssste));
			
			guardado.setMontoSarIssste(parseaBigDecimal(sarIssste));
			guardado.setMontoSarIssste10(parseaBigDecimal(sarIssste));
			guardado.setMontoEstimadoPag(parseaBigDecimal(sarIssste));
		}

		if (CLAVE_REGIMEN_RO.equals(regimen) ) {

			Double saldoCVI = 0.0;
			Double saldoI08 = 0.0;

//			datosSaldos = new DatosSaldos();
//			datosSaldos.setSaldoCVI("1");
//			datosSaldos.setSaldoRetiroI08("1");
			saldoCVI = Double.valueOf(datosSaldos.getSaldoCVI());
			saldoI08 = Double.valueOf(datosSaldos.getSaldoRetiroI08());
			Double rcv = saldoI08 + saldoCVI;
			Double rcv10Pct =  rcv * 0.10;
			Double sbc = resolucion.getMontoConstitutivo() / 30;
			Double sbc75 = sbc * 75;
			
			salida.put("rcv", df.format(rcv));
			salida.put("rcv10Pct", df.format(rcv10Pct));
			salida.put("sbc", df.format(sbc));
			salida.put("sbc75", df.format(sbc75));
			if(sbc75 < rcv10Pct) {
				salida.put(MONTO_ESTIMADO, df.format(sbc75));
				guardado.setMontoEstimadoPag(parseaBigDecimal(sbc75));
			}else {
				salida.put(MONTO_ESTIMADO, df.format(rcv10Pct));
				guardado.setMontoEstimadoPag(parseaBigDecimal(rcv10Pct));
			}
			
			guardado.setSalBaseCotizacion(parseaBigDecimal(0.0));
			guardado.setSbc75(parseaBigDecimal(sbc75));
			guardado.setRcv(parseaBigDecimal(rcv));
			guardado.setMontoRcv10(parseaBigDecimal(rcv10Pct));
			
		}
		
		salida.put("calculo", guardado);

		return salida;
	}

	@Override
	public void guardarTipoRetiroIssste(Resolucion resolucion, RetiroDesempleoIssste retiroDesempleoIssste, DatosSaldos datosSaldos) {
		logger.error("guardarTipoRetiroIssste");
		ParametrosRetiroParcialCalculoIssste parcialCalculoIssste = new ParametrosRetiroParcialCalculoIssste(); 
		parcialCalculoIssste.setClaveBanco(retiroDesempleoIssste.getCtrlInstBancariaTipoRetiro());
		parcialCalculoIssste.setClaveProceso("0006");
		parcialCalculoIssste.setCuenta(retiroDesempleoIssste.getCuentaTipoRetiro());
		parcialCalculoIssste.setCuentaClabe(retiroDesempleoIssste.getClabeTipoRetiro());
		parcialCalculoIssste.setEstatus(1);
		parcialCalculoIssste.setFolio(retiroDesempleoIssste.getFolioPadre());
		parcialCalculoIssste.setFormaPago(retiroDesempleoIssste.getFormaPagoTipoRetiro());
		parcialCalculoIssste.setIdDisposicion(resolucion.getIdResolucion());
		parcialCalculoIssste.setParcialidad(1L);
		parcialCalculoIssste.setProcesoReferencia(resolucion.getIdResolucion());
		parcialCalculoIssste.setTipoOperacion("0023");
		parcialCalculoIssste.setUsuarioModificador("PORTAL_PULSSAR");
//		parcialCalculoIssste.setMontoConstitutivo(montoConstitutivo);
		parcialCalculoIssste.setSaldoRetiro92I(Double.valueOf(datosSaldos.getSaldoRetiro92I()));
		parcialCalculoIssste.setSaldoRetiro08I(Double.valueOf(datosSaldos.getSaldoRetiroI08()));
//		parcialCalculoIssste.setSaldoRcv(datosSaldos.get);
//		parcialCalculoIssste.setTotalSaldos(retiroDesempleoIssste.get);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ParametrosRetiroParcialCalculoIssste> entity = new HttpEntity<>(parcialCalculoIssste, headers);

		logger.error("json entrada guardarTipoRetiroIssste: {}", jsonUtils.parseObjectToJson(entity));
		ResponseEntity<String> respuesta = restService.exchange(uriguardaTipoRetiroIssste,  HttpMethod.POST, entity, String.class);
		logger.error("json salida consultarTipoRetiro: {}", jsonUtils.parseObjectToJson(respuesta.getBody()));
	}
	
	

	@Override
	public void validarHorarioHabil() {
		String enServicio = actividadService.validarActividadServicio("P00027", new Date());
		if ("0".equals(enServicio)) {
			throw new BusinessException("Solicitud fuera del horario de servicio.");
		}
	}
	

	@Override
	public String validarIssste(Long procesar, DatosTrabajador trabajador, String claves) {
		
		try {
			validarHorarioHabil();
		}catch (BusinessException e) {
			logger.error(e.getMessage());
			return StringUtils.join("N|", e.getMessage());
		}
		
		if (trabajador.getDatosExpediente().getBanderaExpedienteIdentifiacion() != 1) {
			return "R|El expediente de identificación no tiene estatus Permanente";
		}
		if (trabajador.getDatosExpediente().getBanderaEnrolamiento() != 1) {
			return "R|El expediente Biométrico no tiene estatus Permanente";
		}
		
		if (!"01".equals(trabajador.getTipoSolicitante())) {
			return StringUtils.join("N|El trabajador no es el titular de la cuenta");
		}
		
		ParametrosSalidaMarca salida = marcaOperativaValida(procesar, claves);
		if(!ObjectUtils.isEmpty(salida)) {
			RechazoPulssar rp = rechazoService.obtenerRechazo(salida.getClaveProceso(), trabajador.getClaveAfore());
			if(!ObjectUtils.isEmpty(rp)) {
				return StringUtils.join("N|", rp.getMensaje());
			}
		}
		
		if (!"01".equals(trabajador.getTipoSolicitante())) {
			return StringUtils.join("N|", "El trabajador no es el titular de la cuenta");
		}
		
		if (! movimientoIsssteValida(trabajador.getDatosCertificables().getCurp())) {
			return StringUtils.join("N|",  "Sin derecho a Retiro por Desempleo ISSSTE, no han transcurrido 5 años desde el último retiro");
		}
		
		
		return null;
	}
	
	
	
	/**
	 * @param procesar
	 * @param claves
	 * @return
	 */
	private ParametrosSalidaMarca marcaOperativaValida(Long procesar, String claves) {
		String url = StringUtils.join(consultaMarcaOperativaMatrizConvivencia, procesar, "/", claves);
		try { 
			logger.info("Entrada: {}", url);
			return restService.getForObject(url, ParametrosSalidaMarca.class);
		}catch(RestClientException e) {
			logger.error("Error al llamar {}", url, e);
		}
		return null;
	}
	
	
	/**
	 * @param curp
	 * @return
	 */
	private boolean movimientoIsssteValida(String curp) {
		logger.info("Entrada: prueba");

		String  url = StringUtils.join(servicioComunes, "movimientoIssste/consulta/", curp, "/", "365");
		try { 
			
			logger.info("Entrada: {}", url);
			ResponseEntity<List<IretTrMovimientoIssste>> response =  restService.exchange(url, HttpMethod.GET, null,  new ParameterizedTypeReference<List<IretTrMovimientoIssste>>(){});
			List<IretTrMovimientoIssste> list = response.getBody();
			if(!list.isEmpty()) {
				return false;
			}
			
		}catch(RestClientException e) {
			logger.error("Error al llamar {}", url, e);
		}
		return true;
	}
	
	
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService#obtenerParametroOpcionTramite(java.lang.String)
	 */
	@Override
	public String obtenerParametroOpcionTramite(String claveAfore) {
		String url = StringUtils.join(servicioComunes,  "/parametro/{parametro}/clave/{clave}");
		url = StringUtils.replace(url, "{clave}", ServiciosConstants.T00077_PEIS);
		url = StringUtils.replace(url, "{parametro}", claveAfore);
		logger.info("Consulta parametro: {}", url);
		return restService.getForObject(url, String.class);
		
	}

	

	/**
	 * @param url
	 * @return
	 */
	private Resolucion consultaDerecho(String url) {
		
		logger.info("uri de consulta de retiro parcial ISSSTE: {}", url.toString());
		
		ResponseEntity<BaseRespuesta<Resolucion>> response = restService.exchange(url, HttpMethod.GET, null,  new ParameterizedTypeReference<BaseRespuesta<Resolucion>>() {});
		BaseRespuesta<Resolucion> resolucion = response.getBody();
		resolucion.getDiagnosticoDeRecepcion();
		
		logger.info("Respuesta de consulta de retiro parcial ISSSTE: {}", resolucion.getObjetoRespuesta());
		
		if(ObjectUtils.isEmpty(resolucion)){
			return null;
		}
		if("02".equals(resolucion.getResultadoDeLaOperacion())){
			throw new BusinessException(resolucion.getDiagnosticoDeRecepcion());
		}
		return resolucion.getObjetoRespuesta();
	}
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService#consultaTipoTramiteValido(java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Resolucion consultaTipoTramiteValido(Long procesar, String tramite) {
		
		final String DT = "DT";
		final String RO = "RO";
		final String  dt = "/NA/CD1/DT/05/CD";
		final String  tci = "/CV/CD1/RO/05/CD";
		final String SERVICIO = "retirosParcialesIssste/retirosParciales/cadenaDerecho/";
		
		String  url = null; 
		Resolucion resolucion = null;
		
		if(StringUtils.equals(tramite, RO)) {
			url = StringUtils.join(servicioComunes, SERVICIO, procesar, tci);
			resolucion = consultaDerecho(url);
			
			if(ObjectUtils.isEmpty(resolucion)) {
				url = StringUtils.join(servicioComunes, SERVICIO, procesar, dt);
				resolucion = consultaDerecho(url);
				if(ObjectUtils.isEmpty(resolucion)){
					throw new BusinessException("El trabajador no tiene una resolución");
				}
			}
		}
		
		if(StringUtils.equals(tramite, DT)) {
			
			url = StringUtils.join(servicioComunes, SERVICIO, procesar, dt);
			resolucion = consultaDerecho(url);
			if(ObjectUtils.isEmpty(resolucion)){
				throw new BusinessException("El trabajador no tiene una resolución");
			}
		}
		
		return resolucion;
	}
	
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * RetirosDesempleoImssService#validarSaldos(java.lang.String,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * DatosSaldos)
	 */
	@Override
	public String validarSaldos(String resultado, DatosSaldos saldos) {
		logger.info("Datos saldos prevalidacion Retiros desempleo ISSSTE: {}", saldos);
		if (utileriaValidador.isEmpty(resultado)){
			if(utileriaValidador.isEmpty(saldos) || !utileriaValidador.isEmpty(saldos.getMotivoRechazo())){
				return "N|Por el momento el servicio de consulta de saldos no se encuentra disponible, por favor inténtalo más tarde";
			} else if(validarSaldos(saldos.getSaldoCesantiaVejez())
						&& validarSaldos(saldos.getSaldoCuotaSocial())
						&& validarSaldos(saldos.getSaldoRetiro97())) {
				return "N|El trabajador no cuenta con el saldo suficiente para realizar la operación";
			}
		}
		return resultado;
	}

	
	
	@Override
	public String validarSaldosPorRegimen(String tramite, DatosSaldos saldos) {
		String respuesta= "El trabajador no cuenta con el saldo suficiente para realizar la operación";
		logger.info("validarSaldosRegimenOrdinario: {}", respuesta);
		
		switch(tramite) {
			case "RO":
				if(validarSaldos(saldos.getSaldoRetiroI08()) && validarSaldos(saldos.getSaldoCVI()) && validarSaldos(saldos.getSaldoCuotaSocial())) 
					return respuesta;
			case "DT":
				if(validarSaldos(saldos.getSaldoAhorroRetiroIB()) )
					return respuesta;
			default:
				return "";
		}
	}
	
	/**
	 *  validar Saldos
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param saldo
	 *  @return
	 */
	private boolean validarSaldos(String saldo){
		if(utileriaValidador.isEmpty(saldo)){
			return true;
		} else {
			BigDecimal saldoInt =new BigDecimal(saldo);
			if(saldoInt.compareTo(BigDecimal.ZERO)<=0){
				return true;
			}
		}
		return false;
	}
	@Override
	public void guardarCalculoTipoRetiroIssste(NotificacionCalculoTipoRetiro calculo) {
		StringBuilder urlGuardaCalculo = new StringBuilder();
		urlGuardaCalculo.append(calculoDesempleo);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<NotificacionCalculoTipoRetiro> entidadActualizaEstatus = new HttpEntity<>(calculo, httpHeaders);
		
		ResponseEntity<NotificacionCalculoTipoRetiro> respuesta = servicioCliente.exchange(urlGuardaCalculo.toString(), HttpMethod.PUT, entidadActualizaEstatus, NotificacionCalculoTipoRetiro.class);
		
		
		respuesta.getBody();
	}
	
	
	private BigDecimal parseaBigDecimal(Double valor) {
		try {
			return new BigDecimal(valor);
		}catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}	
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoIsssteService#consultaRegimen(java.lang.String)
	 */
	public String consultaRegimen(String curp) {
		ConsultaTrabajadorRetirosParcialesIssste obj = consultaTrabRetService.consultaTrabajadorRetiroParcialIssste(curp);
		if(obj.getDiagnostico().equals("000")) {
			return obj.getNti();
		}else {
			return StringUtils.join("N|",  obj.getDescripcionDiagnostico());
		}
		
	}
	
	
	
}
