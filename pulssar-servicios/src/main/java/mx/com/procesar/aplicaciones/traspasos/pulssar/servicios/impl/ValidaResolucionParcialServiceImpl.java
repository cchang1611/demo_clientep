/**
 * ValidaResolucionParcialServiceImpl.java
 * Fecha de creación: Aug 12, 2020 10:48:08 PM
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

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidaResolucionParcialService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class ValidaResolucionParcialServiceImpl implements ValidaResolucionParcialService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidaResolucionParcialService.class);
	
	/**
	 * Atributo restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Atributo url
	 */
	@Value("${url.consulta.obtener.resolucion.parcial}")
	private String url;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ValidaResolucionParcialService#obtenerResolucion(java.math.BigDecimal,
	 * java.lang.Long, java.math.BigDecimal)
	 */
	@Override
	public SalidaGenerica obtenerResolucion(BigDecimal idProcesar, Long idMatrizDerecho, BigDecimal idEstatus) {
		logger.info("validarMatrizDerechos idProcesar - {} idMatrizDerecho - {} idEstatus - {}", idProcesar, idMatrizDerecho, idEstatus);
		return restTemplate.getForEntity(url, SalidaGenerica.class, idProcesar, idMatrizDerecho, idEstatus).getBody();
	}

}
