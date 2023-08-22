/**
 * ValidaActividadService.java
 * Fecha de creación: Jan 21, 2021 8:41:38 AM
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

import java.util.Date;

/**
 * Clase ValidaActividadService
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public interface ValidaActividadService {

	/**
	 * Validar dia habil
	 * 
	 * @param parametro clave de parametro de PSER_TC_PARAMETRO
	 * @param dia       ISO Date Format yyyy-MM-dd, e.g. "2000-10-31".
	 * @return
	 */
	String validarActividadServicio(String parametro, Date dia);
}
