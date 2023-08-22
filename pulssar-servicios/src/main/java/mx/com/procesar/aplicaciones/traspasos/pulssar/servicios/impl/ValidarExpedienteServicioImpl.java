package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.IOException;
import java.util.HashMap;

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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Peticion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramiteComparadorInformacionGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Servicio para la validacion del expediente
 * @author ANOSORIO
 *
 */
@Service
public class ValidarExpedienteServicioImpl implements ValidarExpedienteServicio{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidarExpedienteServicioImpl.class);
     /**
 	 * Inyeccion de utileria validador
 	 */
 	 @Autowired
 	 private ValidadorUtils utileriaValidador;

 	/**
 	 * Inyeccion de rest
 	 */
 	@Autowired
 	private RestTemplate servicioCliente;

	/**
	 * Variable consulta Recepcion arcvhios
	 */
	@Value("#{propiedades['url.consulta.archivo.recepcion']}")
	private String consultaRecepcionArchivo;
	
	
	/**
	 * consultaComparador
	 */
	@Value("#{propiedades['url.consulta.comparador']}")
	private String consultaComparador;

	/**
	 * Inyeccion dependencia JsonUtils
	 */
	@Autowired
	private JsonUtils jsonUtils;

	@Override
	public String validarExpedienteServicioIssste(String folio, DatosTrabajador datos, UsuarioLogin user, String cveProceso) {
		logger.info("Datos entrada metodo validarExpedienteServicio: {}, {}, {}, {}", folio, datos.getDatosCertificables().getCurp(), user.getAforeUsuario(), cveProceso);
		String respuesta = "02";
		String url = consultaRecepcionArchivo;
		url = url.replace(ServiciosConstants.FOLIO_PULSSAR, folio);
		url = url.replace(ServiciosConstants.TIPO_ARCHIVO, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		logger.info("validarExpedienteServicioIssste -> Peticion de validacion de archivo {}", url);
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadValidacion = new HttpEntity<>(headerMedia);
		ResponseEntity<ArchivoRecibido> respuestaArchivo = servicioCliente.exchange(url, HttpMethod.GET, entidadValidacion,
				ArchivoRecibido.class);
		if (!utileriaValidador.validarObjetoNulo(respuestaArchivo.getBody())) {
			ArchivoRecibido archivoRecibido = respuestaArchivo.getBody();
			if("01".equals(archivoRecibido.getResultadoOperacion()) && "500".equals(archivoRecibido.getDiagnostico())){
				respuesta = "01";
			} else if("02".equals(archivoRecibido.getResultadoOperacion())) {
				respuesta = "02";	
			}
		}

		return respuesta;

	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio#validarExpedienteServicio(java.lang.String, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss)
	 */
	@Override
	public String validarExpedienteServicio(String folio, DatosTrabajador datos, UsuarioLogin user, RetiroDesempleoImss retiroDesempleoImss) {
		logger.info("Datos entrada metodo validarExpedienteServicio: {}, {}, {}", folio, datos.getDatosCertificables().getCurp(), user.getAforeUsuario());
		String respuesta = "02";
		String url = consultaRecepcionArchivo;
		url = url.replace(ServiciosConstants.FOLIO_PULSSAR, folio);
		url = url.replace(ServiciosConstants.TIPO_ARCHIVO, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		logger.info("validarExpedienteServicio -> Peticion de validacion de archivo {}", url);
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadValidacion = new HttpEntity<>(headerMedia);
		ResponseEntity<ArchivoRecibido> respuestaArchivo = servicioCliente.exchange(url, HttpMethod.GET, entidadValidacion,
				ArchivoRecibido.class);
		if (!utileriaValidador.validarObjetoNulo(respuestaArchivo.getBody())) {
			ArchivoRecibido archivoRecibido = respuestaArchivo.getBody();
			if("01".equals(archivoRecibido.getResultadoOperacion()) && "500".equals(archivoRecibido.getDiagnostico())){
//				guardarProcesoPendiente(retiroDesempleoImss, datos, user, null);
				respuesta = "01";
			} else if("02".equals(archivoRecibido.getResultadoOperacion()) && "030".equals(archivoRecibido.getDiagnostico())){
//				guardarProcesoPendiente(retiroDesempleoImss, datos, user, salida);
				preparaSolicitud(folio, datos, user, retiroDesempleoImss);
				respuesta = "03";
			} else if("02".equals(archivoRecibido.getResultadoOperacion())) {
				respuesta = archivoRecibido.getMotivoRechazo();
			} else {
				respuesta = "04";
			}
		}

		return respuesta;

	}
	/**
	 *  Prepara solicitud de comparador
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @param datos
	 *  @param user
	 *  @param retiroDesempleoImss
	 */
	private void preparaSolicitud(String folio, DatosTrabajador datos, UsuarioLogin user, RetiroDesempleoImss retiroDesempleoImss) {


		TramiteComparadorInformacionGenerico<String> solicitud = new TramiteComparadorInformacionGenerico<>();
		solicitud.setFolioProcesar(folio);
		solicitud.setFolioServicio(ModificacionTrabajadorConstants.CLAVE_SERVICIO_RETIROS);
		solicitud.setCurp(datos.getDatosCertificables().getCurp());
		solicitud.setNss(datos.getNss());
		solicitud.setNombreTrabajador(datos.getDatosCertificables().getNombre());
		solicitud.setApellidoPaterno(datos.getDatosCertificables().getApellidoPaterno());
		solicitud.setApellidoMaterno(datos.getDatosCertificables().getApellidoMaterno());
		solicitud.setOrganizacion(user.getAforeUsuario());
		solicitud.setTipoSolicitud(ModificacionTrabajadorConstants.CLAVE_SOLICITUD_PRESENCIAL);
		solicitud.setClaveAgentePromotor(user.getUsuario());
		solicitud.setCurpAgentePromotor(user.getCurpAgente());
		solicitud.setClaveTipoAsignacion(ModificacionTrabajadorConstants.CLAVE_SOLICITUD_PRESENCIAL);
		String json = jsonUtils.parseObjectToJsonSC(retiroDesempleoImss.getPeticion12().getPeticion());
		if("matrimonio_imss".equals(retiroDesempleoImss.getOrigen())) {
			solicitud.setClaveServicio("S18");
			Peticion<SolicitarCertificacionMatrimonioEntrada> agm =  (Peticion<SolicitarCertificacionMatrimonioEntrada>) retiroDesempleoImss.getPeticion07().getPeticion();
			try {
				json = agregaDatosMatrimonio(json, agm.getPeticion());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}else {
			solicitud.setClaveServicio("S1");
		}
		solicitud.setPeticion(json);
		
		
		solicitud.setClaveTipoSolicitante(datos.getTipoSolicitante());
		// obtener de sesion la pteicion 12
		
		guardarTramite(solicitud);

	}
	/**
	 *  Guardado del tramite en comparador
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param solicitud
	 */
	public void guardarTramite(TramiteComparadorInformacionGenerico<String> solicitud) {
		logger.info("Entrada proceso solicitud comparador {}", solicitud);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		logger.error("Url insercion solicitud comparador generico: {}", consultaComparador);
		HttpEntity<TramiteComparadorInformacionGenerico<String>> entity = new HttpEntity<>(solicitud, headers);
		logger.error("json entrada guardarTramite: {}", jsonUtils.parseObjectToJson(entity));
		ResponseEntity<String> response = servicioCliente.exchange(consultaComparador, HttpMethod.POST, entity, String.class);
		logger.error("Respuesta insertarProcesoSolicitudComparador: {}", response);
	}


	private String agregaDatosMatrimonio(String json, SolicitarCertificacionMatrimonioEntrada agm) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = null;
		map = mapper.readValue(json, new TypeReference<HashMap<String, String>>(){});
		
		map.put("apPaternoConyuge", agm.getApellidoPaternoConyuge());
		map.put("apMaternoConyuge", agm.getApellidoMaternoConyuge());
		map.put("nombreConyuge", agm.getNombreConyuge());
		map.put("fechaMatrimonio", agm.getFechaMatrimonio());
		map.put("entidadEmisionActa", agm.getEntidadEmisionActa());
		map.put("claveSexoConyuge", agm.getSexoConyuge().toString());
		
		return  mapper.writeValueAsString(map);
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio#consultarRespuestaArchivo(java.lang.String)
	 */
	@Override
	public String consultarRespuestaArchivo(String folio) {
		String respuesta = "{\"resultadoOperacion\":\"02\"}";
		String url = consultaRecepcionArchivo;
		url = url.replace(ServiciosConstants.FOLIO_PULSSAR, folio);
		url = url.replace(ServiciosConstants.TIPO_ARCHIVO, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		logger.info("consultarRespuestaArchivo -> Peticion de validacion de archivo {}", url);
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadValidacion = new HttpEntity<>(headerMedia);
		ResponseEntity<ArchivoRecibido> respuestaArchivo = servicioCliente.exchange(url, HttpMethod.GET, entidadValidacion,
				ArchivoRecibido.class);
		if (!utileriaValidador.validarObjetoNulo(respuestaArchivo.getBody())) {
			if("01".equals(respuestaArchivo.getBody().getResultadoOperacion()) && "500".equals(respuestaArchivo.getBody().getDiagnostico())){
				respuesta = "{\"resultadoOperacion\":\"01\"}";
			} else if("02".equals(respuestaArchivo.getBody().getResultadoOperacion()) && "030".equals(respuestaArchivo.getBody().getDiagnostico())){
			
				respuesta = "{\"resultadoOperacion\":\"03\"}";
			} else if("02".equals(respuestaArchivo.getBody().getResultadoOperacion())) {
				respuesta = "{\"resultadoOperacion\":\"02\"}";
			}
		}
		return respuesta;
	}
	
	
	

}
