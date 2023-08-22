/**
 * MarcaOperativaServiceImpl.java
 * Fecha de creación: Nov 26, 2021, 2:45:23 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MarcaOperativaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizConvivencia;

/**
 * Implementacion MarcaOperativaService
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Nov 26, 2021
 */
@Service
public class MarcaOperativaServiceImpl implements MarcaOperativaService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MarcaOperativaServiceImpl.class);

	/**
	 * Inyeccion utileria cadenas
	 */
	@Value("${url.servicio.comunes}")
	private String servicioComunes;
  	
	/**
	 * servicio restService
	 */
	@Autowired
	private RestTemplate restService;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MarcaOperativaService#marcaOperativaValida(java.lang.Long, java.lang.String)
	 */
	@Override
	public MatrizConvivencia marcaOperativaValida(Long procesar, String claves) {
		StringBuilder url = new StringBuilder(servicioComunes).append("validar/consultamarcaoperativamatrizconvivenciadetalle/").append(procesar).append("/").append(claves);
		try { 
			logger.info("Entrada: {}", url);
			return restService.getForObject(url.toString(), MatrizConvivencia.class);
		}catch(RestClientException e) {
			logger.error("Error al llamar {}", url, e);
		}
		return null;
	}

}
