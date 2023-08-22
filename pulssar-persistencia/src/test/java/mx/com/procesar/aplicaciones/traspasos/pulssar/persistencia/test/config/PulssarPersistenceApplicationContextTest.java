/**
 * PersistenceApplicationContextTest.java
 * Fecha de creaci�n: 03/03/2016, 22:12:47
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.eclipse.persistence.jpa.PersistenceProvider;
import org.eclipse.persistence.platform.database.OraclePlatform;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.config.PulssarPersistenceBaseApplicationContext;

/**
 * Clase de prueba de contexto
 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since 
 */
@Configuration
@EnableJpaRepositories({ "mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios" })
public class PulssarPersistenceApplicationContextTest extends PulssarPersistenceBaseApplicationContext {
	
	/**
	 * Caracter coma
	 */
	protected static final String CARACTER_COMA = ",";
	
	/**
	 * Ruta de archivo de configuracion properties
	 */
	private static final String VARIABLE_PROPIEDADES = "mx.com.procesar.configuracion.properties";
	
	/**
	 * Ruta de resources test
	 */
	private static final String RESOURCES = "src/test/resources";
	
	/**
	 * Archivo properties
	 */
	private static final String CARPETA_PROPIEDADES = "/propiedades/pulssar-test.properties";

	/**
	 * Bloque est�tico para definir las propiedades del sistema
	 */
	static {
		System.setProperty(VARIABLE_PROPIEDADES, RESOURCES);
		System.setProperty("log4j.configuratioFile", "file:/src/test/resources/log4j2/log4j2.properties");
	}
	
	/**
	 * Propiedad de locacion de schema de base de datos
	 */
	@Value("${embedded.db.schema.sql}")
	private String embeddedDbSchema;
	
	/**
	 * Propiedad de locacion de dataset de base de datos
	 */
	@Value("${embedded.db.dataset.sql}")
	private String embeddedDbDataset;
	
	/**
	 * Paquete de entidades a cargar 
	 *TODO preguntar sobre este configiracion
	 */
	@Value("${paquete.entidades}")
	protected String paqueteEntidades;
	
	/**
	 * Propiedades de Aplicativo
	 * TODO preguntar sobre esta configuraciones
	 */
	@Resource
	protected Properties propiedades;
	
	/**
	 * Propiedad de locacion de ORM
	 */
	@Value("${orm}")
	private String orm;
	
	/* La documentaci�n de este m�todo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.arquitectura.pruebas.concepto.workshop.config.PersistenceBaseApplicationContext#dataSource()
	 */
	@Override
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase database = builder
				.setType(EmbeddedDatabaseType.H2)
				.addScript(embeddedDbSchema)
				.addScript(embeddedDbDataset)
				.build();
		
		return database;
	}
	
	/**
	 * Local Container
	 */
	@Override
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPersistenceProvider(persistenceProvider());
		entityManagerFactory.setPackagesToScan(paqueteEntidades.split(CARACTER_COMA));
		entityManagerFactory.setJpaProperties(propiedades);
		entityManagerFactory.setMappingResources(orm);

		return entityManagerFactory;
	}
	
	/**
	 *  Metodo Bean de Transaction Manager
	 *  @author Rodolfo Damian Rojas Rodriguez (rrojasr@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager jpaTxManager = new JpaTransactionManager();
	    jpaTxManager.setEntityManagerFactory(entityManagerFactory().getObject());
	    return jpaTxManager;
	}
	
	/**
	 * jpa vendor adapter
	 */
	@Override
	@Bean
	public EclipseLinkJpaVendorAdapter jpaVendorAdapter() {
		final EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setShowSql(Boolean.TRUE);
		vendorAdapter.setDatabasePlatform(OraclePlatform.class.getName());

		return vendorAdapter;
	}
	
	/**
	 * persistence provider
	 */
	@Override
	@Bean
	public PersistenceProvider persistenceProvider() {
		return new PersistenceProvider();
	}
	
	/**
	 *  Metodo Bean para carga de propiedades externalizadas
	 *  @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public PropertiesFactoryBean propiedades() {
		String rutaPropiedades = System.getProperty(VARIABLE_PROPIEDADES);
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new FileSystemResource(rutaPropiedades.concat(CARPETA_PROPIEDADES)));
		
		return bean;
	}
	
	/**
	 *  Metodo Bean para poder utilizar los Placeholders en carga de valores de propiedades
	 *  @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
	 *  @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		String rutaPropiedades = System.getProperty(VARIABLE_PROPIEDADES);
		PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
		bean.setLocation(new FileSystemResource(rutaPropiedades.concat(CARPETA_PROPIEDADES)));
		
		return bean;
	}
}