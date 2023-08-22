package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;

/**
 * interfaz para las validaciones de un trabajador IMSS
 * @author dbarbosa
 * @version 1.0
 */
public interface SaldosPreliminaresService {
	
	/**
	 * Metodo encargado de obtener los saldos preliminares
	 * 
	 * @param curp
	 * @param nss
	 * @param claveAfore
	 */
	DatosSaldos obtenerSaldosPreliminares(String curp, String nss, String claveAfore);
	
	/**
	 * Metodo encargado de obtener los saldos previos de imss del nuevo metodo
	 * unicamente para el tema de la consulta de coppel
	 * 
	 * @param curp
	 * @param nss
	 * @param claveAfore
	 * @return
	 */
	DatosSaldos obtenerSaldos(String curp, String nss, String claveAfore);
}