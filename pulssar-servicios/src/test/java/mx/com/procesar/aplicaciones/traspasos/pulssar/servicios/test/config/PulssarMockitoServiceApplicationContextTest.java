/**
 * ServiceApplicationContext.java
 * Fecha de creaci�n: 07/03/2016, 11:49:56
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


/**
 * Clase de Contexto de Spring para Servicios
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 * 
 * @version 1.0
 * @since 
 */
@Configuration
@ComponentScan(includeFilters = {@Filter(type = FilterType.ANNOTATION, value = Service.class),
		@Filter(type = FilterType.ANNOTATION, value = Component.class) }, 
	basePackages = {"mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl",
			        "mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl",
			        "mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl"})
@EnableTransactionManagement
public class PulssarMockitoServiceApplicationContextTest{

	/**
	 * Bloque est�tico para definir las propiedades del sistema
	 */
	static {
		System.setProperty("mx.com.procesar.configuracion.properties", "src/test/resources");
		System.setProperty("log4j.configuratioFile", "file:/src/test/resources/log4j2/log4j2.properties");
	}
	
	/**
	 * Template mock administrado por Mockito framework.
	 * 
	 * @return Un template mock.
	 */
	@Bean
	@Primary
	public RestTemplate restTemplate() {
		return Mockito.mock(RestTemplate.class);
	}
	
}