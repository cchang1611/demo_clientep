/**
 * PropertiesApplicationContext.java
 * Fecha de creaciï¿½n: 23/05/2016, 18:19:08
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaciï¿½n confidencial, propiedad del
 * Procesar S A de C V. Esta informaciï¿½n confidencial
 * no deberï¿½ ser divulgada y solo se podrï¿½ utilizar de acuerdo
 * a los tï¿½rminos que determine la propia empresa.
 */

package mx.com.procesar.aplicaciones.traspasos.pulssar.exposicion.config;

import java.util.Arrays;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;


/**
 * Clase para cargar el place holder y el properties.
 * @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since 
 */
@Configuration
@EnableCaching
public class PulssarRestPropertiesApplicationContext {
	/**
	 * Nombre de variable de JVM para Propiedades
	 */
	private static final String VARIABLE_PROPIEDADES = "mx.com.procesar.configuracion.properties";
	
	/**
	 * Carpeta de propieades con archivo
	 */
	private static final String CARPETA_PROPIEDADES = "/propiedades/pulssar.properties";
	
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
	
    @Bean
    public CacheManager cacheManager() {
          SimpleCacheManager cacheManager = new SimpleCacheManager();
          
        cacheManager.setCaches(Arrays.asList(
        new ConcurrentMapCache("cacheBuscarPorIdentificadorRolUrl"), 
          new ConcurrentMapCache("cacheBuscarPorIdentificadoresRoles"),  new ConcurrentMapCache("cacheBuscarPorIdentificadorRolesControlador"), new ConcurrentMapCache("cacheBuscarUrl")));
        
       
        return cacheManager;
    }

     
     /**
     *  Borra el cache cada 3 segundos
     *  @author David Abraham Hernández Ojeda (dhernand@procesar.com)
     */
    @CacheEvict(allEntries = true, value = {"cacheBuscarPorIdentificadorRolUrl"})
    public void reportCacheEvict() {
          System.out.println("LIMPIANDO *************************");
    }
     
     /**
     *  Borra el cache cada 3 segundos
     *  @author David Abraham Hernández Ojeda (dhernand@procesar.com)
     */
     @CacheEvict(allEntries = true, value = {"cacheBuscarPorIdentificadoresRoles"})
    public void reportCacheEvictService() {
          System.out.println("LIMPIANDO *************************");
    }
     
     /**
      *  Borra el cache cada 3 segundos
      *  @author David Abraham Hernández Ojeda (dhernand@procesar.com)
      */
      @CacheEvict(allEntries = true, value = {"cacheBuscarPorIdentificadorRolesControlador"})
     public void reportCacheEvictServices() {
           System.out.println("LIMPIANDO *************************");
     }

      /**
       *  Borra el cache cada 3 segundos
       *  @author David Abraham Hernández Ojeda (dhernand@procesar.com)
       */
       @CacheEvict(allEntries = true, value = {"cacheBuscarUrl"})
      public void reportCacheEvictServicesUrl() {
            System.out.println("LIMPIANDO *************************");
      }

	
}
