/**
 * CusService.java
 * Fecha de creación: 08/08/2019, 17:58:23
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;

/**
 * Interfaz relacionada con cus
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 08/08/2019
 */
public interface CusService {
	/**
	 *  solicitarConsultaCus
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param curp
	 *  @param estatus
	 *  @param folio
	 *  @param afore
	 *  @param extra
	 *  @return
	 */
	ConsultaCusSalida solicitarConsultaCus(String curp, String estatus, String folio, String afore, String extra);
	
	/**
	 *  Generacion de cus mismo dia
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param entrada
	 *  @return
	 */
	RespuestaGeneraCusSalida generarCus(EntradaCus entrada);

	/**
	 * <p>Metodo que realiza la busqueda de los datos de la cus por los filtros
	 * 	-Cus y Estatus
	 *  -Curp y Estatus
	 * </p>
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * @param curp
	 * @param cus
	 * @param estatus
	 * @return
	 */
	ConsultaCusSalida consultaCus(String curp, Long cus, String estatus);

}
