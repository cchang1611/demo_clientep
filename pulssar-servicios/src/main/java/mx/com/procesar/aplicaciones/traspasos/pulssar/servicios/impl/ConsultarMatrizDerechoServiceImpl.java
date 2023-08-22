/**
 * ConsultarMatrizDerechoServiceImpl.java
 * Fecha de creación: Aug 12, 2020 5:46:58 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseSalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class ConsultarMatrizDerechoServiceImpl implements ConsultarMatrizDerechoService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarMatrizDerechoService.class);

	/**
	 * Atributo restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Atributo url
	 */
	@Value("${url.consulta.obtener.matriz.derecho}")
	private String url;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarMatrizDerechoService#validarMatrizDerechos(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public BaseSalidaGenerica<MatrizDerecho> validarMatrizDerechos(String tipoRetiro, String tipoPrestacion) {
		logger.info("validarMatrizDerechos tipoRetiro - {} tipoPrestacion {}", tipoRetiro, tipoPrestacion);
		return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<BaseSalidaGenerica<MatrizDerecho>>() {
				}, tipoRetiro, tipoPrestacion).getBody();
	}

}
