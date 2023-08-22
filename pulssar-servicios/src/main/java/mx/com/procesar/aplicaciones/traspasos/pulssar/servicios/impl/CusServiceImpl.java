/**
 * CusServiceImpl.java
 * Fecha de creación: 08/08/2019, 18:03:30
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static org.springframework.util.ObjectUtils.isEmpty;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion servicios CUS
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 08/08/2019
 */
@Service
public class CusServiceImpl implements CusService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CusServiceImpl.class);

	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate rest;
	/**
	 * uri Solicitud Cus
	 */
	@Value("${solicitud.cus.uri}")
	private String uriSolicitudCus;	
	
	/**
	 * uri Genera Cus
	 */
	@Value("${generar.cus.mismo.dia.uri}")
	private String uriGeneracionCus;	
	
	/**
	 * inyeccion de utilerias
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	 /**
   * fechaUtils
   */
	@Autowired
	private FechaUtils fechaUtils;
	/**
	 * inyeccion dependencia NotificacionService
	 */
	@Autowired
	private NotificacionService notificacionService;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService#solicitarConsultaCus(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ConsultaCusSalida solicitarConsultaCus(String curp, String estatus, String folio, String afore, String extra) {

		ConsultaCusEntrada entrada = new ConsultaCusEntrada();
		entrada.setCurp(curp);
		entrada.setEstatus(estatus);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ConsultaCusEntrada> entity = new HttpEntity<>(entrada, headers);
		
		logger.info("solicitarConsultaCus antes de llamar rest: {}", entrada);
		
		ResponseEntity<ConsultaCusSalida> response = rest.exchange(uriSolicitudCus, HttpMethod.POST, entity, ConsultaCusSalida.class);
		logger.info("solicitarConsultaCus despues de llamar rest {}", response);
		RespuestaGeneraCusSalida cusExistente = new RespuestaGeneraCusSalida();
		if (!isEmpty(response.getBody()) && response.getBody().getCodigo().equals("01") && !validadorUtils.isEmpty(folio)) {
			ConsultaCusSalida cusSalida = response.getBody();
			cusExistente.setCus(response.getBody().getRespuesta().get("cus"));
			cusExistente.setFechaGeneracion(fechaUtils.convertirLongAFechaCadena(
					Long.parseLong(cusSalida.getRespuesta().get("fechaCreacion")), FormatoConstants.FORMATO_SERVICIO));
			cusExistente.setFechaRecepNotificacion(fechaUtils.convertirLongAFechaCadena(
					Long.parseLong(cusSalida.getRespuesta().get("fechaModificacion")),
					FormatoConstants.FORMATO_SERVICIO));
			cusExistente.setFechaVigencia(fechaUtils.convertirLongAFechaCadena(
					Long.parseLong(cusSalida.getRespuesta().get("fechaVigencia")), FormatoConstants.FORMATO_SERVICIO));
			notificacionService.notificarCus(cusExistente, afore, folio, extra);
		}
		

		return response.getBody();
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService#generarCus(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus)
	 */
	@Override
	public RespuestaGeneraCusSalida generarCus(EntradaCus entrada) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EntradaCus> entity = new HttpEntity<>(entrada, headers);
		
		logger.info("generarCus antes de llamar rest {}\nDatos de entrada: {}", uriGeneracionCus, entrada);
		ResponseEntity<RespuestaGeneraCusSalida> response = rest.exchange(uriGeneracionCus, HttpMethod.POST, entity, RespuestaGeneraCusSalida.class);
		logger.info("generarCus despues de llamar rest {}", response);

		return response.getBody();
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService#solicitarConsultaCus(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ConsultaCusSalida consultaCus(String curp, Long cus, String estatus) {

		ConsultaCusEntrada entrada = new ConsultaCusEntrada();
		entrada.setCurp(curp);
		entrada.setEstatus(estatus);
		entrada.setCus(cus);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ConsultaCusEntrada> entity = new HttpEntity<>(entrada, headers);
		
		logger.error("\nSolicitarConsultaCus antes de llamar rest, url : {}, entrada: {}",uriSolicitudCus, entrada);
		
		ResponseEntity<ConsultaCusSalida> response = rest.exchange(uriSolicitudCus, HttpMethod.POST, entity, ConsultaCusSalida.class);
		logger.error("\n SolicitarConsultaCus despues de llamar rest {}", response);

		if(validadorUtils.isEmpty(response) || validadorUtils.isEmpty(response.getBody()) || !TurnoConstants.CODIGO_EXITOSO.equals(response.getBody().getCodigo()) ) {
			throw new BusinessException(BusinessErrorEnum.CUS_NO_ENCONTRADO);
		}
		
		return response.getBody();
	}
}
