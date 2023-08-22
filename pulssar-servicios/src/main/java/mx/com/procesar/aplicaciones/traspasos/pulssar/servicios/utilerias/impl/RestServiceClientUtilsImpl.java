package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RestServiceConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.BaseServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;

/**
 * utileria para acceder a servicios rest
 * 
 * @author jcgarces
 * @version 1.0
 * @updated 13-mar-2019 05:57:12 p.m.
 */
@Component("restServiceClientUtils")
public class RestServiceClientUtilsImpl extends BaseServiceImpl implements RestServiceClientUtils {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RestServiceClientUtilsImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.esar.portal.util.RestServiceClientUtils#ejecutaServicio
	 * (java.lang.String)
	 */
	@Override
	public <R> R ejecutarServicioGet(String servidor, String uri, Class<R> clase) {
		String url = obtenUrl(servidor, uri);
		RestTemplate restTemplate = new RestTemplate();
		logger.info(RestServiceConstants.LOG_SERVCIO, url);
		ResponseEntity<R> respuesta = restTemplate.getForEntity(url, clase);
		logger.debug(RestServiceConstants.LOG_RESPUESTA, jsonUtil.parseObjectToJson(respuesta));
		return respuesta.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.recepcionarchivos.servicios.
	 * RestServiceClientUtils#ejecutaServicioGetObjetos(java.lang.String,
	 * java.lang.String, java.lang.Class)
	 */
	@Override
	public <R> List<R> ejecutarServicioGetObjetos(String servidor, String uri, Class<R> claseRespuesta) {
		String url = obtenUrl(servidor, uri);
		logger.info("url {}", url);
		RestTemplate restTemplate = new RestTemplate();
		List<R> regreso;
		List<?> respuesta = restTemplate.getForObject(url, List.class);
		regreso = convertir(respuesta, claseRespuesta);
		logger.debug(RestServiceConstants.LOG_SERVCIO, url);
		logger.debug(RestServiceConstants.LOG_RESPUESTA, regreso);
		return regreso;
	}
	
	
	
	@Override
	public <R> List<R> ejecutarServicioGetObjetosList(String uri, Class<R> claseRespuesta) {
		logger.info("url {}", uri);
		RestTemplate restTemplate = new RestTemplate();
		List<R> regreso;
		List<?> respuesta = restTemplate.getForObject(uri, List.class);
		String json = jsonUtil.parseListObjectToJson(respuesta);
		regreso = jsonUtil.parseJsonToObjectList(json, claseRespuesta);
		
		logger.debug(RestServiceConstants.LOG_SERVCIO, uri);
		logger.debug(RestServiceConstants.LOG_RESPUESTA, regreso);
		return regreso;
	}
	
	
	/**
	 * convierte la lista de mapas a lista de objetos
	 * @param lista
	 * @param claseRespuesta
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <R> List<R> convertir(List<?> lista,  Class<R> claseRespuesta){
		List<R> regreso;
		if (!validadorUtils.validarListaVacia(lista) && !lista.get(0).getClass().equals(claseRespuesta)) {
			regreso = new ArrayList<>();
			for (Object actual : lista) {
				R r = jsonUtil.parseJsonToObject(jsonUtil.parseObjectToJson(actual), claseRespuesta);
				regreso.add(r);
			}
		} else {
			regreso = (List<R>) lista;
		}
		return regreso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.recepcionarchivos.servicios.
	 * RestServiceClientUtils#ejecutaServicioPost(java.lang.String,
	 * java.lang.String, java.lang.Object, java.lang.Class)
	 */
	@Override
	public <P, R> R ejecutarServicioPost(String servidor, String uri, P peticion, Class<R> claseRespuesta) {
		String url = obtenUrl(servidor, uri);
		return ejecutarServicioPost(url, peticion, claseRespuesta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.recepcionarchivos.utilerias.
	 * RestServiceClientUtils#ejecutarServicioPostwithHeaders(java.lang.String,
	 * java.lang.Object, org.springframework.http.HttpHeaders, java.lang.Class)
	 */
	@Override
	public <P, R> R ejecutarServicioPostwithHeaders(String url, P peticion, HttpHeaders headers,
			Class<R> claseRespuesta) {
		HttpHeaders header = new HttpHeaders();
		if (!validadorUtils.validarObjetoNulo(headers)) {
			header = headers;
		}
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<P> parametro = new HttpEntity<>(peticion, header);
		RestTemplate restTemplate = new RestTemplate();
		logger.info(RestServiceConstants.LOG_SERVCIO, url);
		logger.debug(RestServiceConstants.LOG_PETICION, jsonUtil.parseObjectToJson(peticion));
		ResponseEntity<R> respuesta = restTemplate.postForEntity(url, parametro, claseRespuesta);
		logger.debug(RestServiceConstants.LOG_RESPUESTA, jsonUtil.parseObjectToJson(respuesta));
		return respuesta.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.recepcionarchivos.utilerias.
	 * RestServiceClientUtils#ejecutarServicioPost(java.lang.String,
	 * java.lang.Object, java.lang.Class)
	 */
	@Override
	public <P, R> R ejecutarServicioPost(String url, P peticion, Class<R> claseRespuesta) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<P> parametro = new HttpEntity<>(peticion, headers);
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Servicio : {}, \npeticion {}", url, jsonUtil.parseObjectToJson(peticion));
		ResponseEntity<R> respuesta = restTemplate.postForEntity(url, parametro, claseRespuesta);
		logger.info(RestServiceConstants.LOG_RESPUESTA, jsonUtil.parseObjectToJson(respuesta));
		return respuesta.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.recepcionarchivos.servicios.
	 * RestServiceClientUtils#ejecutaServicioPostParaObjetos(java.lang.String,
	 * java.lang.String, java.lang.Object, java.lang.Class)
	 */
	@Override
	public <P, R> List<R> ejecutarServicioPostParaObjetos(String servidor, String uri, P peticion, Class<R> claseRespuesta) {
		String url = obtenUrl(servidor, uri);
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Servicio : {}, peticion {}", url, jsonUtil.parseObjectToJson(peticion));
		List<?> respuesta = (List<?>) restTemplate.postForObject(url, peticion, List.class);
		List<R> regreso = convertir(respuesta, claseRespuesta);
		logger.info(RestServiceConstants.LOG_SERVCIO, url);
		logger.debug(RestServiceConstants.LOG_RESPUESTA, jsonUtil.parseObjectToJson(respuesta));
		return regreso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.consultatuafore.servicios.
	 * RestServiceClientUtils#ejecutaServicioPut(java.lang.String,
	 * java.lang.String, java.lang.Class)
	 */
	@Override
	public <P, R> R ejecutarServicioPut(String servidor, String uri, P parametro, Class<R> claseRespuesta) {
		String url = obtenUrl(servidor, uri);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<P> peticion = new HttpEntity<>(parametro, headers);
		logger.info("accediendo a url {}, peticion {}, clase esperada {}", url, peticion, claseRespuesta);
		restTemplate.put(url, peticion);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.consultatuafore.servicios.
	 * RestServiceClientUtils#ejecutaServicioDelete(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void ejecutarServicioDelete(String servidor, String uri) {
		String url = obtenUrl(servidor, uri);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.portalservicios.servicios.
	 * RestServiceClientUtils#ejecutaSslPostXml(java.lang.String,
	 * java.lang.String, java.lang.Object, java.lang.Class)
	 */
	@Override
	public <P, R> R ejecutarServicePostXml(String servidor, String uri, P peticion, Class<R> claseRespuesta)
			throws GenericException {
		String url = obtenUrl(servidor, uri);
		return ejecutarServicePostXml(url, peticion, claseRespuesta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.portalservicios.servicios.
	 * RestServiceClientUtils#ejecutaPostXml(java.lang.String, java.lang.Object,
	 * java.lang.Class)
	 */
	@Override
	public <P, R> R ejecutarServicePostXml(String url, P peticion, Class<R> claseRespuesta) throws GenericException {

		ResponseEntity<R> respuesta = null;
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		HttpComponentsClientHttpRequestFactory rf = (HttpComponentsClientHttpRequestFactory) restTemplate
				.getRequestFactory();
		rf.setBufferRequestBody(true);
		restTemplate.setRequestFactory(rf);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		String requestXml = jsonUtil.convertirObjetoAXml(peticion);
		logger.debug("peticion {}", requestXml);
		Long inicio = System.currentTimeMillis();
		logger.info("Llamando a servicio {}", url);
		try {
			respuesta = restTemplate.postForEntity(url, peticion, claseRespuesta);
			logger.debug("respuesta {}", respuesta);

		} catch (Exception e) {
			logger.error("Fallo al consumir servicio ", e);
			throw new GenericException("Error al consumir servicio ", e);
		} finally {
			Long fin = System.currentTimeMillis();
			logger.info("Tiempo {} segundos.\n ", (fin - inicio) / RestServiceConstants.MIL);
		}
		logger.debug("Respuesta {}", respuesta.getBody());

		return respuesta.getBody();

	}

	/**
	 * obtiene la ruta completa del servicio
	 * 
	 * @param ipServidor
	 * @param servicio
	 * @return
	 */
	private String obtenUrl(String ipServidor, String servicio) {
		StringBuilder regreso = new StringBuilder();
		regreso.append(ipServidor).append(servicio);
		return regreso.toString();
	}

}
