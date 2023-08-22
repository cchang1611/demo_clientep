/**
 * ResarcimientoServiceImpl.java
 * Fecha de creación: Mar 31, 2020 12:37:22 PM
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

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FECHA_FORMATO_REINTEGRO_SEMANAS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_FECHA_RENAPO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants.VACIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArregloRespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class ResarcimientoServiceImpl implements ResarcimientoService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReintegroSemanasResarcimientoServiceImpl.class);

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * url consulta historicos retiro
	 */
	@Value("${url.reintegro.semanas.historico.retiros}")
	private String urlHistoricosRetiro;

	/**
	 * url calculo monto integrar
	 */
	@Value("${url.reintegro.calculo.monto.reintegrar}")
	private String urlCalculoMontoIntegrar;

	/**
	 * utilidades de fechas
	 */
	@Autowired
	private FechaUtils fechaUtils;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ResarcimientoService#obtenerResarcimiento(java.lang.String, java.lang.String)
	 */
	@Override
	public List<RespuestaHistoricoRetiros> obtenerResarcimiento(String nss, String claveAfore) {
		String urlServicio = urlHistoricosRetiro.replace("{nss}", nss).replace("{claveAfore}", claveAfore);
		logger.info("url consulta historico retiros: {}", urlServicio);

		ArregloRespuestaHistoricoRetiros respuesta = restTemplate.getForObject(urlServicio,
				ArregloRespuestaHistoricoRetiros.class);
		logger.info("respuesta comunes historico: {}", respuesta);

		List<RespuestaHistoricoRetiros> historicos = new ArrayList<>();

		if (respuesta != null && respuesta.getLayoutRespuestaHistoricoRetiros() != null
				&& !respuesta.getLayoutRespuestaHistoricoRetiros().isEmpty()) {
			historicos.addAll(respuesta.getLayoutRespuestaHistoricoRetiros());
			agregarDatosComplementarios(historicos);
			logger.info("respuesta: {}", historicos);
		}

		return historicos;
	}

	/**
	 * se agregan datos adicionales al historico de retiros
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param historicos
	 */
	private void agregarDatosComplementarios(List<RespuestaHistoricoRetiros> historicos) {
		for (RespuestaHistoricoRetiros historico : historicos) {
			Date fecha = fechaUtils.convertirCadenaAFecha(historico.getFechaRetiroReintegro(),
					FECHA_FORMATO_REINTEGRO_SEMANAS);
			String fechaStr = fechaUtils.convertirFechaACadena(fecha, FORMATO_FECHA_RENAPO);
			historico.setFechaRetiroReintegroVista(fechaStr == null ? VACIO : fechaStr);
		}
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ResarcimientoService#obtenerCalculoMontoReintegrar(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar)
	 */
	@Override
	public BaseRespuesta<RespuestaMontoReintegrar> obtenerCalculoMontoReintegrar(CalculoMontoReintegrar entrada) {
		BaseRespuesta<RespuestaMontoReintegrar> salida = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CalculoMontoReintegrar> entidadEntrada = new HttpEntity<>(entrada, headers);
		ResponseEntity<BaseRespuesta<RespuestaMontoReintegrar>> respuesta = restTemplate.exchange(
				urlCalculoMontoIntegrar, HttpMethod.POST, entidadEntrada,
				new ParameterizedTypeReference<BaseRespuesta<RespuestaMontoReintegrar>>() {
				});

		if (respuesta.hasBody()) {
			salida = respuesta.getBody();
		}

		logger.info("datos de salida obtenerCalculoMontoReintegrar: {}", salida);

		return salida;
	}

}
