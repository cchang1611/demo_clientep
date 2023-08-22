/**
 * NotificarAutenticacionPortImpl.java
 * Fecha de creaci�n: May 17, 2021 11:38:22 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionContrato;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionPort;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionRespuesta;

/**
 * Clase NotificarAutenticacionPortImpl
 *
 * @author Williams Alejandro Mart�nez (walejand)
 * @version 1.0
 */
@Service
public class NotificarAutenticacionPortImpl implements NotificarAutenticacionPort {

	/**
	 * Atributo cadenasUtils
	 */
	@Autowired
	private CadenasUtils cadenasUtils;

	/**
	 * Atributo endpoint
	 */
	@Value("${url.servicios.internos.notificar.autenticacion}")
	private String endpoint;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.
	 * NotificarAutenticacionPort#notificarAutenticacion(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionContrato)
	 */
	@Override
	public NotificarAutenticacionRespuesta notificarAutenticacion(
			NotificarAutenticacionContrato notificarAutenticacionRequest) {
		NotificarAutenticacion port = new NotificarAutenticacion(cadenasUtils.createURL(endpoint));
		return port.getNotificarAutenticacionPort().notificarAutenticacion(notificarAutenticacionRequest);
	}

}
