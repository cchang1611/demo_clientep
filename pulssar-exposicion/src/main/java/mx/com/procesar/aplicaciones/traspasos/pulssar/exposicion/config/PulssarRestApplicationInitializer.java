package mx.com.procesar.aplicaciones.traspasos.pulssar.exposicion.config;

import java.net.URI;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.config.PulssarPersistenceApplicationContext;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.config.PulssarCorreoAplicationContext;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.config.PulssarServiceApplicationContext;


/**
 * Clase de configuracion equivalente a web.xml 
 * @author Edgar Alberto Perez Villegas (eaperezv@inet.procesar.com.mx)
 * @version 1.0
 * @since
 */
@Configuration
public class PulssarRestApplicationInitializer implements WebApplicationInitializer {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PulssarRestApplicationInitializer.class);
	
	/**
	 * Nombre de la variable de la ruta donde estan las propiedades
	 */
	private static final String VARIABLE_RUTA_PROPERTIES="mx.com.procesar.configuracion.log4j2";
	
	/**
	 * Nombre del archivo de log4j que se tiene que cargar
	 */
	private static final String NOMBRE_ARCHIVO_LOG4J2="/pulssar-log4j2.properties";
	
	/**
	* Constante File
	 */
	private static final String FILE="file:///";

	/**
	 * Configuracion para el descriptor de despliegue
	 */
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		// ApplicationContext
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
	
		// Listener
		container.addListener(new ContextLoaderListener(applicationContext));

		// Dispatcher servlet application context
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(	PulssarRestPropertiesApplicationContext.class,
										PulssarPersistenceApplicationContext.class,
										PulssarCorreoAplicationContext.class,
										PulssarServiceApplicationContext.class,
										PulssarRestApplicationContext.class );
		
		// Registro de servlet Dispatcher
		ServletRegistration.Dynamic dispatcher =
			container.addServlet("spring-servlet", new DispatcherServlet(webApplicationContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		// Configuracion de archivo log4j2 del proyecto
		LoggerContext context = (LoggerContext)LogManager.getContext(false);
		String rutaPropiedades = System.getProperty(VARIABLE_RUTA_PROPERTIES);
		context.setConfigLocation(URI.create(FILE.concat(rutaPropiedades).concat(NOMBRE_ARCHIVO_LOG4J2)));
		logger.info("log4j2 configuration file reconfigured: ".concat(FILE.concat(rutaPropiedades).concat(NOMBRE_ARCHIVO_LOG4J2)));
		context.reconfigure();
	}
}