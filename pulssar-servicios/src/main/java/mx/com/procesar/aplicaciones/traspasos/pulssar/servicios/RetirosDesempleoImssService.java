/**
 * RetirosDesempleoImssService.java
 * Fecha de creación: Aug 5, 2021, 1:03:36 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;

/**
 * Interfaz RetirosDesempleoImss}
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Aug 5, 2021
 */
public interface RetirosDesempleoImssService {

	/**
	 *  validar Precondiciones Imss
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param datosExpediente
	 *  @param claves
	 *  @param idProcesar
	 *  @param afore
	 *  @param tipoSolicitante
	 *  @return
	 */
	String validarPrecondicionesImss(DatosExpediente datosExpediente, List<String> claves, Long idProcesar, String afore, String tipoSolicitante);
	
	/**
	 *  validar Solicitante
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param solicitante
	 *  @param resultado
	 *  @return
	 */
	String validarSolicitante(String solicitante, String resultado);
	
	/**
	 *  Prevalidacion de saldos
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param resultado
	 *  @param saldos
	 *  @return
	 */
	String validarSaldos(String resultado, DatosSaldos saldos);
	
	/**
	 *  validar Proceso Pendiente
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param curp
	 *  @param resultado
	 *  @param proceso
	 *  @return
	 */
	String validarProcesoPendiente(String curp, String resultado, String proceso);
	/**
	 *  Borrado de proceso pendiente
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param curp
	 */
	void borrarProcesoPendiente(String curp);

}

