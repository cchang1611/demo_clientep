/**
 * ConsultarBancoAforeService.java
 * Fecha de creación: Mar 24, 2020 11:06:31 AM
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BancoAfore;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public interface ConsultarBancoAforeService {
	/**
	 * Busca en el catalogo por clave afore
	 * 
	 * @param cvAfore
	 * @return
	 */
	BancoAfore consultaClaveAfore(String cvAfore);

}
