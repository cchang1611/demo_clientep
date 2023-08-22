/**
 * PersistenceApplicationContext.java
 * Fecha de creaci�n: 03/03/2016, 21:56:01
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;


/**
 * Clase de configuraci�n de Contexto de Persistencia
 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since 
 */
@Configuration
@EnableJpaRepositories({"mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios"})
public class PulssarPersistenceApplicationContext extends PulssarPersistenceBaseApplicationContext {
	
	/**
	 * JNDI de Data Source
	 */
	@Value("${jndi.data.source}")
	private String jndiDataSource;

	/* La documentaci�n de este m�todo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.arquitectura.pruebas.concepto.workshop.config.PersistenceBaseApplicationContext#dataSource()
	 */
	@Override
	public DataSource dataSource() {
		DataSource dataSource = null;
		final JndiDataSourceLookup jndiLookup = new JndiDataSourceLookup();
		jndiLookup.setResourceRef(true);
		dataSource = jndiLookup.getDataSource(jndiDataSource);
		
		return dataSource;
	}
	
}
