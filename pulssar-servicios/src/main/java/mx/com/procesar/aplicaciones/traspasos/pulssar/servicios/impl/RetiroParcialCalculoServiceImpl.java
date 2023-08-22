/**
 * RetiroParcialCalculoServiceImpl.java
 * Fecha de creación: Oct 7, 2019, 5:31:48 PM
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

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.CLAVE_PROCESO_RETIRO_PARCIAL_CALCULO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.ESTATUS_RETIRO_PARCIAL_CALCULO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.TIPO_OPERACION_RETIRO_PARCIAL_CALCULO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.TIPO_OPERACION_RETIRO_PARCIAL_MATRIMONIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants.USUARIO_MODIFICADOR;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetiroParcialCalculoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioRetiroParcialCalculo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils;


/**
 * implementacion de los servicios para la tabla RETI_TR_RETIRO_PARCIAL_CALCULO
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Oct 7, 2019
 */
@Service
public class RetiroParcialCalculoServiceImpl implements RetiroParcialCalculoService {

	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetiroParcialCalculoServiceImpl.class);
	
	/**
	 * template para los llamados REST
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${guardar.calculo.retiroparcial.uri}")
	private String urlGuardarCalculoRetiroParcial;
	
	/**
	 * Inyeccion dependencia
	 */
	@Autowired
	private NotificacionService notificacionService;
	
	/**
	 * Inyeccion dependencia JsonUtils
	 */
	@Autowired
	private JsonUtils jsonUtils;
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetiroParcialCalculoService#guardarCalculo(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, java.lang.String, java.lang.Boolean)
	 */
	@Override
	public void guardarCalculo(ParametrosRetiroParcialCalculoImss entrada, DatosTrabajador trabajador, String origen, Boolean notifica) {
		double totalSaldos = entrada.getSaldoCuotaSocial();
		totalSaldos += entrada.getSaldoRetiro97();
		totalSaldos += entrada.getSaldoRcv();
		entrada.setTotalSaldos(totalSaldos);
		entrada.setEstatus(ESTATUS_RETIRO_PARCIAL_CALCULO);
		entrada.setClaveProceso(CLAVE_PROCESO_RETIRO_PARCIAL_CALCULO);
		if ("matrimonio_imss".equals(origen)) {
			entrada.setTipoOperacion(TIPO_OPERACION_RETIRO_PARCIAL_MATRIMONIO);
		} else {
			entrada.setTipoOperacion(TIPO_OPERACION_RETIRO_PARCIAL_CALCULO);
		}
		entrada.setUsuarioModificador(USUARIO_MODIFICADOR);
		entrada.setFechaControl(new Date());
		RespuestaServicioRetiroParcialCalculo salida = null;

		logger.info("servicio: {}", urlGuardarCalculoRetiroParcial);
		logger.info("parametros a enviar al servicio guardar el cálculo de retiro parcial: {}", jsonUtils.parseObjectToJson(entrada));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<ParametrosRetiroParcialCalculoImss> entidadEntrada = new HttpEntity<>(entrada, headers);
		try{
			restTemplate.exchange(urlGuardarCalculoRetiroParcial, HttpMethod.POST, entidadEntrada, RespuestaServicioRetiroParcialCalculo.class);		
			if(!notifica){
				notificacionService.notificarTipoRetiro(entrada, salida, trabajador.getNss(), trabajador.getDatosCertificables().getCurp(), trabajador.getClaveAfore());
				logger.info("Notificado exitosamente");
			}
			logger.info("Cálculo de retiro parcial guardado exitosamente");
		} catch(Exception e){
			logger.error("Error al guardar el cálculo de retiro parcial", e);
			throw new BusinessException("Error al guardar el cálculo de retiro parcial");
		}
	}

}
