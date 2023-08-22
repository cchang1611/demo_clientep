/**
 * ValidarAutenticacionIneServiceImpl.java
 * Fecha de creación: Jun 24, 2021, 12:43:44 PM
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

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAutenticacionIneService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.IDSSNS;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionContrato;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionPort;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionSalida;

/**
 * Implementacion ValidarAutenticacionIneService
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Jun 24, 2021
 */
@Service
public class ValidarAutenticacionIneServiceImpl implements ValidarAutenticacionIneService {
	
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidarAutenticacionIneServiceImpl.class);
	/**
	 * Inyeccion NotificarAutenticacionPort
	 */
	@Autowired
	private NotificarAutenticacionPort notificarAutenticacionPort;
	/**
	 * Inyeccion dependencia FechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAutenticacionIneService#validarIne(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionEntrada, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar)
	 */
	@Override
	public String validarIne(NotificarAutenticacionEntrada notificarAutenticacionEntrada,
			HuellaDactilar huellaDactilar) {
		if("2".equals(huellaDactilar.getIdDedo())){
			notificarAutenticacionEntrada.setMinucia2(huellaDactilar.getHuella64());
		} else {
			notificarAutenticacionEntrada.setMinucia7(huellaDactilar.getHuella64());
		}
		notificarAutenticacionEntrada.setOrigen("2");
		notificarAutenticacionEntrada.setTipoProceso("1");
		notificarAutenticacionEntrada.setFechaConsulta(fechaUtils.convertirFechaACadena(new Date(), "dd-MM-yyyy"));
		NotificarAutenticacionContrato notificarAutenticacionContrato = new NotificarAutenticacionContrato();
		notificarAutenticacionContrato.setCuerpo(notificarAutenticacionEntrada);
		IDSSNS idssns = new IDSSNS();
		idssns.setIdCliente(35);
		idssns.setIdEbusiness(53);
		idssns.setIdServicio(879);
		notificarAutenticacionContrato.setIdssn(idssns);
		String respuesta = null;
		try{
			logger.info("Entrada NotificarAutenticacion: {}", notificarAutenticacionContrato);
			NotificarAutenticacionRespuesta notificarAutenticacionRespuesta= notificarAutenticacionPort.notificarAutenticacion(notificarAutenticacionContrato);
			logger.info("Salida NotificarAutenticacion: {}", notificarAutenticacionRespuesta);
			NotificarAutenticacionSalida salida = notificarAutenticacionRespuesta.getObjetoRespuesta();
			validarSimilitudes(salida.getAnioRegistro(), respuesta);
			validarSimilitudes(salida.getClaveElector(), respuesta);
			validarSimilitudes(salida.getCurp(), respuesta);
			validarSimilitudes(salida.getOcr(), respuesta);
			validarSimilitudesNumerico(salida.getSimilitud2(), respuesta);
			validarSimilitudesNumerico(salida.getSimilitud2(), respuesta);
		} catch (Exception e) {
			logger.error("error",e);
			respuesta = "Existe un problema con el servicio, intenta más tarde";
		}
		return respuesta;
	}
	
	/**
	 *  validar Similitudes candena
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param valor
	 *  @param coincidencia
	 *  @return
	 */
	private String validarSimilitudes(String valor, String coincidencia){
		String respuesta = coincidencia;
		if(StringUtils.isBlank(coincidencia)){
			logger.info("validando valor: {}", valor);
			if(!"TRUE".equals(valor)){
				respuesta = "No se pudo autenticar al solicitante";
			}
		}
		return respuesta;
	}
	/**
	 *  validar Similitudes candena
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param valor
	 *  @param coincidencia
	 *  @return
	 */
	private String validarSimilitudesNumerico(String valor, String coincidencia){
		BigDecimal numero = new BigDecimal(valor.replace("%", ""));
		String respuesta = coincidencia;
		if(StringUtils.isBlank(coincidencia)){
			logger.info("validando valor: {}", valor);
			if(numero.compareTo(BigDecimal.ZERO) > 0 && numero.compareTo(new BigDecimal("99.9")) >= 0){
				respuesta = "No se pudo autenticar al solicitante";
			}
		}
		return respuesta;
	}

}
