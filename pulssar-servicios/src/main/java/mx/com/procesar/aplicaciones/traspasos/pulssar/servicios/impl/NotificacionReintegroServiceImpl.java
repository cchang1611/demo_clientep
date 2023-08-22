/**
 * NotificacionReintegroServiceImpl.java
 * Fecha de creación: Mar 24, 2020 1:16:35 PM
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

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.COD_NO_NOTIFICADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.COD_PENDIENTE_CONFIRMACION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.USER_REGISTRO;

import java.util.Date;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ReintegroEstatusEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase guardar la notificacion de Reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class NotificacionReintegroServiceImpl implements NotificacionReintegroService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(NotificacionReintegroService.class);

	/**
	 * Url para guardar las notificacion
	 */
	@Value("${url.reintegro.generar.notificacion}")
	private String urlNotificacionReintegro;

	/**
	 * Url buscar solicitud por numero reintegro y resolucion
	 */
	@Value("${url.reintegro.buscar.notificaciones.reintegro.resolucion}")
	private String urlBuscarNotificacioneReintegroResolucion;

	/**
	 * RestTemplate para los servicios
	 */
	@Autowired
	private RestTemplate restTemplate;


	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * NotificacionReintegroService#notificarReintegro(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro)
	 */
	@Override
	public void notificarReintegro(SolicitudReintegroResarcimiento entrada) {
		NotificacionReintegro salida = new NotificacionReintegro();
		salida.setApellidoMaterno(entrada.getTrabajador().getRenapo().getApellidoMaterno());
		salida.setApellidoPaterno(entrada.getTrabajador().getRenapo().getApellidoPaterno());
		salida.setCurp(entrada.getTrabajador().getRenapo().getCurp());
		salida.setEstatusReintegro(ReintegroEstatusEnum.REGISTRADO.getClave());
		salida.setFechaRetiro(entrada.getMontoReintegrar().getFechaRetiro());
		salida.setMontoTotalReintegrar(entrada.getMontoReintegrar().getMontoReintegrar());
		salida.setNombre(entrada.getTrabajador().getRenapo().getNombre());
		salida.setNss(entrada.getTrabajador().getNss());
		salida.setNumeroNotificado(COD_NO_NOTIFICADO);
		salida.setNumeroResolucion(entrada.getMontoReintegrar().getNumeroResolucion());
		salida.setResultadoOperacion(COD_PENDIENTE_CONFIRMACION);
		salida.setSemanasReintegrar(Integer.valueOf(entrada.getMontoReintegrar().getNumeroSemanasReintegrar()));
		salida.setUsuarioModificador(USER_REGISTRO);
		salida.setValorIntegrar(obtenerHistorico(entrada));
		salida.setFolioTramPlataforma(entrada.getTrabajador().getFolio().getFolio());
		salida.setFechaSolicitudReintegro(new Date());

		restTemplate.put(urlNotificacionReintegro, salida);
	}

	/**
	 * Obtiene el valor del dia a reitengrar
	 * 
	 * @param entrada
	 * @return
	 */
	private Double obtenerHistorico(SolicitudReintegroResarcimiento entrada) {
		String valorDiaReintegrar = null;

		for (RespuestaHistoricoRetiros historico : entrada.getLstHistoricos()) {
			if (historico.getNumeroResolucion().equals(entrada.getMontoReintegrar().getNumeroResolucion())) {
				valorDiaReintegrar = historico.getValorDiaReintegrar();
			}
		}

		return valorDiaReintegrar == null ? null : Double.parseDouble(valorDiaReintegrar);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * NotificacionReintegroService#notificarReintegro(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro)
	 */
	@Override
	public void notificarReintegro(NotificacionReintegro entrada) {
		restTemplate.put(urlNotificacionReintegro, entrada);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * NotificacionReintegroService#buscarNotificacion(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public NotificacionReintegro buscarNotificacion(String numeroReintegro, String numeroResolucion) {
		String urlServicio = urlBuscarNotificacioneReintegroResolucion.replace("{numeroReintegro}", numeroReintegro)
				.replace("{numeroResolucion}", numeroResolucion);
		logger.info("url buscarNotificacion: {}", urlServicio);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BaseRespuesta<SolicitudReintegroEntrada>> entidadEntrada = new HttpEntity<>(headers);
		ResponseEntity<BaseRespuesta<NotificacionReintegro>> respuesta = restTemplate.exchange(urlServicio,
				HttpMethod.GET, entidadEntrada, new ParameterizedTypeReference<BaseRespuesta<NotificacionReintegro>>() {
				});

		if (respuesta.getBody() != null) {
			logger.info("datos de salida buscarNotificacion: {}", respuesta);
		}

		return respuesta.getBody().getObjetoRespuesta();
	}

}
