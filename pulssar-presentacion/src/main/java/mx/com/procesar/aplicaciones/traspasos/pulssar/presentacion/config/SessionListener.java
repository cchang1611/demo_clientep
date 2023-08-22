package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.config;
/**
 * SessionListener.java
 * Fecha de creaci�n: 13/06/2017, 18:35:06
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Value;


/**
 * Clase Listener de Sesion HTTP
 * @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com)
 * @version 1.0
 * @since 
 */
public class SessionListener implements HttpSessionListener {
	
	/**
	 * Tiempo en minutos de duracion de sesion HTTP
	 */
	@Value("${seguridad.http.sesion.tiempo.minutos}")
	private int TIEMPO_SESION_MINUTOS;
	
	/**
	 * Tiempo 60
	 */
	private static final int TIEMPO_60 = 60;

	/* La documentaci�n de este m�todo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		if(TIEMPO_SESION_MINUTOS == 0) {
			TIEMPO_SESION_MINUTOS = 60;
		}
		event.getSession().setMaxInactiveInterval(TIEMPO_SESION_MINUTOS * TIEMPO_60);
	}

	/* La documentaci�n de este m�todo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		//sessionDestroyed
	}

}
