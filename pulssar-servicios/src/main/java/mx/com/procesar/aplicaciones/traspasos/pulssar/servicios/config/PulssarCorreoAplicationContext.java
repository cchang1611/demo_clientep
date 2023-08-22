package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * Clase de Contexto de MailConfig para Servicios
 * @author esolanor
 * @version 1.0
 * @since
 */
@Configuration
@ComponentScan(includeFilters = { 
				@Filter(type = FilterType.ANNOTATION, value = Service.class)}, 
			basePackages = { "mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl" })
public class PulssarCorreoAplicationContext {
	
	/**
	 * host
	 */
	@Value("${mail.proxy.host}")
	private String host;
	
	/**
	 * port
	 */
	@Value("${mail.smtp.port}")
	private Integer port;

	/**
	 * protocol
	 */
	@Value("${mail.properties.transport.protocol}")
	private String protocol;

	/**
	 * auth
	 */
	@Value("${mail.properties.smtp.auth}")
	private String auth;
	
	/**
	 * starttls
	 */
	@Value("${mail.properties.smtp.starttls.enable}")
	private String starttls;
	
	/**
	 * debug
	 */
	@Value("${mail.properties.smtp.debug}")
	private String debug;

	/**
	 * @return el atributo host
	 */
	@Bean(name = "host")
	public String getHost() {
		return host;
	}

	/**
	 * @return el atributo port
	 */
	@Bean(name = "port")
	public Integer getPort() {
		return port;
	}

	/**
	 * @return el atributo protocol
	 */
	@Bean(name = "protocol")
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @return el atributo auth
	 */
	@Bean(name = "auth")
	public String getAuth() {
		return auth;
	}

	/**
	 * @return el atributo debug
	 */
	@Bean(name = "debug")
	public String getDebug() {
		return debug;
	}
	
	/**
	 * return JavaMailSender
	 */
	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", protocol);
		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.debug", debug);
		return mailSender;
	}	
}