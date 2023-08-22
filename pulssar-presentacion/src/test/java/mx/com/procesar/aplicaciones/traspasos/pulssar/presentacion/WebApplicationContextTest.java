package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Clase de configuracion del contexto para los Test
 * 
 * @author David Hernández (dhernand@inet.procesar.com)
 * @version 1.0
 * @since
 */
@Configuration
@ComponentScan(includeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = Component.class) }, 
		basePackages = { "mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl" })
public class WebApplicationContextTest extends WebMvcConfigurerAdapter {

}
