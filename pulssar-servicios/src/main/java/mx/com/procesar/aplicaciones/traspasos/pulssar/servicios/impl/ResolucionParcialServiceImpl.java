/**
 * ResolucionParcialServiceImpl.java
 * Fecha de creación: 27/05/2020, 12:42:25
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResolucionParcialService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretTrDisposicion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion Resolucion Parcial
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 27/05/2020
 */
@Service
public class ResolucionParcialServiceImpl implements ResolucionParcialService {
	
	/**
	 * Logger
	 */
	private static final Logger logger =  LoggerFactory.getLogger(ResolucionParcialServiceImpl.class);
	/**
	 * recuperacion de valor servicio valida persona
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResolucionParcialService#obtenerResolucionParcial(java.lang.Long, java.lang.String)
	 */
	@Override
	public String obtenerResolucionParcial(Long idProcesar, String tipoPrestacion) {
		ResolucionParcial respuesta;
		String resultado = null;
		StringBuilder complemento = new StringBuilder();
		complemento.append("resolucionParcial/consultarLiquidacionHistorica/");
		complemento.append(idProcesar);
		complemento.append("/20500,20560/");
		complemento.append(tipoPrestacion);
		String servicioResolucionParcial = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, complemento.toString());
		logger.info("Consulta del dato de resolucion parcial {}", servicioResolucionParcial);
		respuesta = clienteServicio.getForObject(servicioResolucionParcial, ResolucionParcial.class);
		logger.info("Salida resolucion parcial {}", respuesta);
		if(!validadorUtilidad.isEmpty(respuesta)){
			resultado = utileriaFecha.convertirFechaACadena(respuesta.getFechaFinVigencia(), FormatoConstants.FORMATO_FECHA_NACIMIENTO);
		}
		
		return resultado;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResolucionParcialService#obtenerDisposicion(java.lang.Long, java.lang.String, java.lang.String)
	 */
	@Override
	public String obtenerDisposicion(Long idProcesar, String proceso, String tipoOperacion) {
		IretTrDisposicion respuesta;
		String resultado = null;
		StringBuilder complemento = new StringBuilder();
		complemento.append("disposicionissste/");
		complemento.append(idProcesar);
		complemento.append("/0006/0032");
		logger.info("Consulta del dato de disposicion: {}", complemento);
		respuesta = clienteServicio.getForObject(complemento.toString(), IretTrDisposicion.class);
		logger.info("Salida disposicion: {}", respuesta);
		if(!validadorUtilidad.isEmpty(respuesta)){
			resultado = utileriaFecha.convertirFechaACadena(respuesta.getFechaResolucion(), FormatoConstants.FORMATO_FECHA_NACIMIENTO);
		}
		
		return resultado;
	}

}
