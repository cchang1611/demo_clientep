package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config;

import java.util.Properties;

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
			basePackages = { "mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl",
					"mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl"
					})
public class PulssarCorreoAplicationContextTest {
	
	/**
	 *  return JavaMailSender
	 */
	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("192.168.6.138");
        mailSender.setPassword("Procesar1$");
        mailSender.setUsername("prueba_notifica");
        mailSender.setPort(25);
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");
        return mailSender;

	}		
}