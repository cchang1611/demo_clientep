/**
 * ConsultarBancoAforeServiceImpl.java
 * Fecha de creación: Mar 24, 2020 11:09:21 AM
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

import java.text.MessageFormat;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarBancoAforeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BancoAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;

/**
 * Clase para consultar catalogo de banco afore
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class ConsultarBancoAforeServiceImpl implements ConsultarBancoAforeService {

	/**
	 * Url del servicio de consulta de banco por afore
	 */
	@Value("${url.consulta.banco.afore}")
	private String urlConsultaBancoAfore;

	/**
	 * Bean Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarBancoAforeService#consultaClaveAfore(java.lang.String)
	 */
	@Override
	public BancoAfore consultaClaveAfore(String cvAfore) {
		String url = MessageFormat.format(urlConsultaBancoAfore, new Object[] { cvAfore });

		BaseRespuesta<BancoAfore> salida;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Void> construir = new HttpEntity<>(headers);
		ResponseEntity<BaseRespuesta<BancoAfore>> respuesta = restTemplate.exchange(url, HttpMethod.GET, construir,
				new ParameterizedTypeReference<BaseRespuesta<BancoAfore>>() {
				});

		if (respuesta.hasBody()) {
			salida = respuesta.getBody();
			return salida.getObjetoRespuesta();
		}

		return null;
	}

}
