/**
 * PersistenceBaseApplicationContext.java
 * Fecha de creaci�n: 03/03/2016, 20:03:15
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
//package mx.com.procesar.aplicaciones.traspasos.pulssar.config;
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.eclipse.persistence.jpa.PersistenceProvider;
import org.eclipse.persistence.platform.database.OraclePlatform;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;


/**
 * Clase Base de Configuraci�n
 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since 
 */
@Configuration
public abstract class PulssarPersistenceBaseApplicationContext {

	/**
	 * Caracter coma
	 */
	protected static final String CARACTER_COMA = ",";
	/**
	 * Paquete de entidades a cargar
	 */
	@Value("${paquete.entidades}")
	protected String paqueteEntidades;
	/**
	 * Propiedades de Aplicativo
	 */
	@Resource
	protected Properties propiedades;
	
	/**
	 * Propiedad de locacion de ORM
	 */
	@Value("${orm}")
	private String orm;	
	
	/**
	 *  Declaracion de metodo Bean abstracto para DataSource
	 *  @author Rodolfo Damian Rojas Rodriguez (rrojasr@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean(destroyMethod = "")
	public abstract DataSource dataSource();
	
	/**
	 *  Metodo Bean de Entity Manager Factory
	 *  @author Rodolfo Damian Rojas Rodriguez (rrojasr@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPersistenceProvider(persistenceProvider());
		entityManagerFactory.setPackagesToScan(paqueteEntidades.split(CARACTER_COMA));
		entityManagerFactory.setJpaProperties(propiedades);
		entityManagerFactory.setMappingResources(orm);

		return entityManagerFactory;
	}
	
	/**
	 *  Metodo Bean para Vendor de JPA de EclipseLink
	 *  @author Rodolfo Damian Rojas Rodriguez (rrojasr@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public EclipseLinkJpaVendorAdapter jpaVendorAdapter() {
		final EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setShowSql(Boolean.TRUE);
		vendorAdapter.setDatabasePlatform(OraclePlatform.class.getName());
		
		return vendorAdapter;
	}
	
	/**
	 *  Metodo Bean para Persistence Provider
	 *  @author Rodolfo Damian Rojas Rodriguez (rrojasr@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public PersistenceProvider persistenceProvider() {
		return new PersistenceProvider();
	}
	
}
