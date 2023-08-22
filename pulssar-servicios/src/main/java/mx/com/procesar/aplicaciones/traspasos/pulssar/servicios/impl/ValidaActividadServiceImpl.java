/**
 * ValidaActividadServiceImpl.java
 * Fecha de creación: Jan 21, 2021 8:43:31 AM
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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidaActividadService;

/**
 * Clase ValidaActividadServiceImpl
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
@Service
public class ValidaActividadServiceImpl implements ValidaActividadService {

	/**
	 * Atributo ISO_DATE_FORMAT
	 */
	private static final String ISO_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * Atributo restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Atributo urlValidarActividad
	 */
	@Value("${url.validar.horario.servicio}")
	private String urlValidarActividad;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ValidaActividadService#validarActividadServicio(java.lang.String,
	 * java.util.Date)
	 */
	@Override
	public String validarActividadServicio(String parametro, Date dia) {
		SimpleDateFormat formato = new SimpleDateFormat(ISO_DATE_FORMAT);
		String dateIso = formato.format(dia);
		return restTemplate.getForEntity(urlValidarActividad, String.class, parametro, dateIso).getBody();
	}

}
