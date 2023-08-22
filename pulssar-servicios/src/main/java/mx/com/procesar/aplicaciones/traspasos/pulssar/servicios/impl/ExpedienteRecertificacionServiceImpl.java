/**
 * ExpedienteRecertificacionServiceImpl.java
 * Fecha de creación: 27/05/2020, 11:00:38
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteRecertificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteRecertificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Imlementacion Expediente Recertificacion
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 27/05/2020
 */
@Service
public class ExpedienteRecertificacionServiceImpl implements ExpedienteRecertificacionService {
	
	/**
	 * Logger
	 */
	private static final Logger logger =  LoggerFactory.getLogger(ExpedienteRecertificacionServiceImpl.class);
	
	/**
	 * recuperacion de valor servicio valida persona
	 */
	@Value("${comunes.obtener.recertificacion.uri}")
	private String uriRecertificacion;

	/**
	 * dependencia cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * dependencia utilidad validador
	 */
	@Autowired 
	private ValidadorUtils validadorUtilidad;
	
	/**
	 * dependencia utilidad fecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;

	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteRecertificacionService#obtenerDatoRecertificacion(java.lang.Long)
	 */
	@Override
	public ExpedienteRecertificacion obtenerDatoRecertificacion(Long id) {
		logger.info("Consulta del dato de recertifciacion {}", id);
		ExpedienteRecertificacion respuesta;
		String servicioRecertificacion = utileriaCadena.obtenerCadenaConcatenada(true, uriRecertificacion, String.valueOf(id));
		respuesta = clienteServicio.getForObject(servicioRecertificacion, ExpedienteRecertificacion.class);
		if(!validadorUtilidad.isEmpty(respuesta)){
			respuesta.setFechaInicio(utileriaFecha.convertirFechaACadena(respuesta.getFcInicioRecertificacion(), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
			respuesta.setFechaFin(utileriaFecha.convertirFechaACadena(respuesta.getFcFinRecertifiaccion(), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
		}
		
		return respuesta;
	}

}
