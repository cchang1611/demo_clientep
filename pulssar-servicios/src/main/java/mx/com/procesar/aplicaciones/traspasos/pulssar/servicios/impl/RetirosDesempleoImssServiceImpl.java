/**
 * RetirosDesempleoImssServiceImpl.java
 * Fecha de creación: Aug 5, 2021, 1:04:59 PM
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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosSalidaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion RetirosDesempleoImssService
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Aug 5, 2021
 */
@Service
public class RetirosDesempleoImssServiceImpl implements RetirosDesempleoImssService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetirosDesempleoImssServiceImpl.class);
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	/**
	 * Inyeccion dependencia RechazoService
	 */
	@Autowired
	private RechazoService rechazoService;

	/**
	 * consultaMarcaOperativaMatrizConvivencia
	 */
	@Value("${comunes.consultaMarcaOperativaMatrizConvivencia}")
	private String consultaMarcaOperativaMatrizConvivencia;

	/**
	 * url servicio comunes
	 */
	@Value("${url.servicio.comunes}")
	private String servidorComunes;

	/**
	 * uri comunes transaccional
	 */
	@Value("${uri.comunes.transaccional}")
	private String servidorComunesTransaccional;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoImssService#validarPrecondicionesImss(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente, java.util.List, java.lang.Long, java.lang.String, java.lang.String)
	 */
	@Override
	public String validarPrecondicionesImss(DatosExpediente datosExpediente, List<String> claves, Long idProcesar,
			String afore, String tipoSolicitante) {
		String resultado = null;
		if("01".equals(tipoSolicitante)){
			if (datosExpediente.getBanderaExpedienteIdentifiacion() != 1) {
				return "R|El expediente de identificación no tiene estatus Permanente";
			}
			if (datosExpediente.getBanderaEnrolamiento() != 1) {
				return "R|El expediente Biométrico no tiene estatus Permanente";
			}
		}
		for (String clavesMarcas : claves) {
			StringBuilder url = new StringBuilder(consultaMarcaOperativaMatrizConvivencia).append(idProcesar)
					.append("/").append(clavesMarcas);
			logger.info("Entrada: {}", url);
			ParametrosSalidaMarca respuesta = restTemplate.getForObject(url.toString(), ParametrosSalidaMarca.class);
			logger.info("Respuesta: {}", respuesta);
			if (!utileriaValidador.isEmpty(respuesta)) {
				RechazoPulssar rechazo = rechazoService.obtenerRechazo(respuesta.getClaveProceso(), afore);
				return "N|".concat(rechazo.getMensaje());
			}
		}
		return resultado;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * RetirosDesempleoImssService#validarSolicitante(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String validarSolicitante(String solicitante, String resultado) {
		if (utileriaValidador.isEmpty(resultado) && (!solicitante.contains("01") && !solicitante.contains("03"))) {
			return "N|El solicitante no puede realizar el trámite de Retiro Parcial por Desempleo IMSS";
		}
		return resultado;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * RetirosDesempleoImssService#validarSaldos(java.lang.String,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * DatosSaldos)
	 */
	@Override
	public String validarSaldos(String resultado, DatosSaldos saldos) {
		logger.info("Datos saldos prevalidacion Retiros desempleo IMSS", saldos);
		if (utileriaValidador.isEmpty(resultado)){
			if(utileriaValidador.isEmpty(saldos) || !utileriaValidador.isEmpty(saldos.getMotivoRechazo())){
				return "N|Por el momento el servicio de consulta de saldos no se encuentra disponible, por favor inténtalo más tarde";
			} else if(validarSaldos(saldos.getSaldoCesantiaVejez())
						&& validarSaldos(saldos.getSaldoCuotaSocial())
						&& validarSaldos(saldos.getSaldoRetiro97())) {
				return "N|El trabajador no cuenta con el saldo suficiente para realizar la operación";
			}
		}
		return resultado;
	}

	/**
	 *  validar Saldos
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param saldo
	 *  @return
	 */
	private boolean validarSaldos(String saldo){
		if(utileriaValidador.isEmpty(saldo)){
			return true;
		} else {
			BigDecimal saldoInt =new BigDecimal(saldo);
			if(saldoInt.compareTo(BigDecimal.ZERO)<=0){
				return true;
			}
		}
		return false;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoImssService#validarProcesoPendiente(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String validarProcesoPendiente(String curp, String resultado, String proceso) {
		String valor1 = "09";
		String valor2 = "10";
		
		if("desempleo".equals(proceso)){
			valor1 = "03";
			valor2 = "04";
		}
		if (utileriaValidador.isEmpty(resultado)){
			StringBuilder sb = new StringBuilder(servidorComunes).append("procesoPendiente/consultaprocesopendiente/").append(curp).append("/0/").append(valor1);
			logger.info("validarProcesoPendiente:{}", sb);
			String respuesta = restTemplate.getForObject(sb.toString(), String.class);
			logger.info("validarProcesoPendiente 07:{}", respuesta);
			if(utileriaValidador.isEmpty(respuesta)){
				sb.setLength(0);
				sb.append(servidorComunes).append("procesoPendiente/consultaprocesopendiente/").append(curp).append("/0/").append(valor2);
				logger.info("validarProcesoPendiente:{}", sb);
				String respuesta12 = restTemplate.getForObject(sb.toString(), String.class);
				logger.info("validarProcesoPendiente 12:{}", respuesta);
				if(utileriaValidador.isEmpty(respuesta12)){
					return null;
				} else {
					return "R|El trabajador se encuentra en proceso de retiro";
				}
			} else {
				return "R|El trabajador se encuentra en proceso de retiro";
			}
		}
		return resultado;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetirosDesempleoImssService#borrarProcesoPendiente(java.lang.String)
	 */
	@Override
	public void borrarProcesoPendiente(String curp){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SolicitudDisposicionParcialEntrada> entity = new HttpEntity<>(headers);
		StringBuilder sb = new StringBuilder(servidorComunesTransaccional).append("procesoPendiente/").append(curp).append("/4/03,04");

		logger.error("borrarProcesoPendiente: {}", sb);
		ResponseEntity<String> respuesta = restTemplate.exchange(sb.toString(),  HttpMethod.POST, entity, String.class);
		logger.error("json salida solicitudDisposicionParcialIssste: {}", respuesta.getStatusCode());

	}
}
