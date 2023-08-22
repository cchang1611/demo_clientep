package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.net.URI;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionesTotalesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizConvivencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosSalidaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Service
public class DisposicionesTotalesServiceImpl implements DisposicionesTotalesService {

	private static final Logger logger = LoggerFactory.getLogger(DisposicionesTotalesServiceImpl.class);
	
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * consultaMarcaOperativaMatrizConvivencia
	 */
	@Value("${comunes.consultaMarcaOperativaMatrizConvivencia}")
	private String consultaMarcaOperativaMatrizConvivencia;
	
	/**
	 * consultaMarcaOperativaMatrizConvivencia
	 */
	@Value("${comunes.obtenerMarcaOperativaMatrizConvivencia}")
	private String obtenerMarcaOperativaMatrizConvivencia;
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionesTotalesIsssteService#validarMarcaOperativa(java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean validarMarcaOperativa(Long procesar, DatosExpediente datosExpediente, List<String> claves) {
		String url;
		for (String clavesMarcas : claves) {
			url = StringUtils.join(consultaMarcaOperativaMatrizConvivencia, procesar, "/", clavesMarcas);
			if (marcaOperativaValida(url) 
					|| datosExpediente.getBanderaExpedienteIdentifiacion() != 1
					|| datosExpediente.getBanderaEnrolamiento() != 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 *  marcaOperativaValida
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param uri
	 *  @return
	 */
	private boolean marcaOperativaValida(String uri) {
		boolean respuestaSalida = false;
		try { 
			logger.info("Entrada: {}", uri);
			ParametrosSalidaMarca respuesta = restTemplate.getForObject(uri, ParametrosSalidaMarca.class);
			logger.info("Respuesta: {}", respuesta);
			if(!utileriaValidador.isEmpty(respuesta)) {
				respuestaSalida = true;
			}
		}catch(RestClientException e) {
			logger.error("Error al llamar {}", uri, e);
		}
		return respuestaSalida;
	}
	
	/**
	 *  Obtener Marca Operativa
	 *  @param uri
	 *  @return
	 */
	private List<MatrizConvivencia> obtenerMarcaOperativa(String uri) {
		List<MatrizConvivencia> salida = null;
		
		try { 
			logger.info("Entrada: {}", uri);
			RequestEntity<Void> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(uri));
			ResponseEntity<List<MatrizConvivencia>> respuesta = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<MatrizConvivencia>>() {});
			salida = respuesta.getBody();
			logger.info("Respuesta: {}", respuesta);
		}catch(RestClientException e) {
			logger.error("Error al llamar {}", uri, e);
		}
		
		return salida;
	}


	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * DisposicionesTotalesService#validarMarcaOperativaExpediente(java.lang.Long,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * DatosExpediente, java.util.List)
	 */
	@Override
	public boolean validarMarcaOperativaExpediente(Long procesar, DatosExpediente datosExpediente,
			List<String> claves) {

		String url;
		for (String clavesMarcas : claves) {
			url = StringUtils.<String>join(obtenerMarcaOperativaMatrizConvivencia, String.valueOf(procesar), "/",
					clavesMarcas);
			List<MatrizConvivencia> marcas = obtenerMarcaOperativa(url);
			if (marcas != null && !marcas.isEmpty()) {
				throw new BusinessException("La cuenta del trabajador se encuentra en un proceso de "
						.concat(marcas.get(0).getTipoProcesoActual().getDescripcion()));
			}
		}
		return true;
	}

}
