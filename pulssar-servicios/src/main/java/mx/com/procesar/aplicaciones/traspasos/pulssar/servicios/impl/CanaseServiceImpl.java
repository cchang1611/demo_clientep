/**
 * CanaseServiceImpl.java
 * Fecha de creación: 07/04/2020, 09:58:51
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CanaseService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Canase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion de Metodos Canase
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 07/04/2020
 */
@Service
public class CanaseServiceImpl implements CanaseService {
	
	/**
	 * Logger
	 */
	private static final Logger logger =  LoggerFactory.getLogger(CanaseServiceImpl.class);
	
	/**
	 * uri Consulta Canase
	 */
	@Value("${url.consulta.canase}")
	private String uriConsultaCanase;
	
	/**
	 * Cliente
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion dependencia ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CanaseService#consultarCanase(java.lang.String)
	 */
	@Override
	public Canase consultarCanase(String nss) {
		Canase canase = null;
		if(!validadorUtils.isEmpty(nss)){
			try{
				String urlcanase = uriConsultaCanase.concat(nss);
				logger.info("Consulta Canase: {}", urlcanase);
				canase = servicioCliente.getForObject(urlcanase, Canase.class);
				logger.info("Consulta Canase salida: {}", canase);
			}catch(Exception e){
				logger.error("Se presento un problema al consulta la informacion de nacionalidad",e);
			}
		}
		return canase;
	}

}
