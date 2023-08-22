/**
 * NotificacionReintegroService.java
 * Fecha de creación: Mar 24, 2020 1:12:57 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase service la notificacion de Reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public interface NotificacionReintegroService {
	/**
	 * Notificacion solicitud reintegro
	 * 
	 * @param entrada
	 */
	void notificarReintegro(SolicitudReintegroResarcimiento entrada);

	/**
	 * Notificacion solicitud reintegro
	 * 
	 * @param entrada
	 */
	void notificarReintegro(NotificacionReintegro entrada);

	/**
	 * Busca notificaciones por numero de reintegro y numero de resolucion
	 * 
	 * @param numeroReintegro
	 * @param numeroResolucion
	 * @return
	 */
	NotificacionReintegro buscarNotificacion(String numeroReintegro, String numeroResolucion);
}
