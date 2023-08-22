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
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de Contexto de Spring para Servicios
 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since 
 */
@Configuration
@ComponentScan(
	includeFilters = { @Filter(type = FilterType.ANNOTATION, value = Service.class),
		@Filter(type = FilterType.ANNOTATION, value = Component.class) },
	basePackages = {"mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl",
			"mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl",
			"mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl"})
@EnableTransactionManagement
public class PulssarServiceApplicationContext{

	/**
	 * Objeto EntityManagerFactory
	 */
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	/**
	 *  Metodo Bean de Transaction Manager
	 *  @author Rodolfo Damian Rojas Rodriguez (rrojasr@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	/**
	 * bean restTemplate
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}