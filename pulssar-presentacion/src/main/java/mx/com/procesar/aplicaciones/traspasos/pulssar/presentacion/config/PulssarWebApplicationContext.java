package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Clase de configuracion java de la capa de presentacion
 * @author Edgar Alberto Perez Villegas (eaperezv@inet.procesar.com.mx)
 * @version 1.0
 */

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(includeFilters = {
	@Filter(type = FilterType.ANNOTATION, value = Controller.class),
	@Filter(type = FilterType.ANNOTATION, value = Component.class) }, basePackages = {
		"mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores",
		"mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl"})
public class PulssarWebApplicationContext extends WebMvcConfigurerAdapter {

	/**
	 * Bean que incluye viewResolver para el control de las vistas.
	 * @author Edgar Alberto Perez Villegas (eaperezv@inet.procesar.com.mx)
	 * @return
	 */
	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/views/");
		viewResolve.setSuffix(".jsp");
		return viewResolve;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver MultipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(9 * 1024 * 1024);
		return multipartResolver;
	}

	/**
	 * Habilita la configuracion configureDefaultServletHandling
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}