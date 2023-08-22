package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;

/**
 * Interface para la obtenecion de catalogos internos
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface CatalogosInternosService {
	
	/**
	 * Metodo encargado de buscar las zonas de una afore
	 * 
	 * @param afore
	 * @return
	 */
	List<Combo> obtenerZonas(String afore);
	
	/**
	 * Metodo encargado de obtener las descripciones de zona
	 * 
	 * @param afore
	 * @return
	 */
	List<Combo> obtenerDescripcionesZonas(String afore, String claveZona);
	
	/**
	 * Metodo encargado de obtener las descripciones de zona
	 * 
	 * @param afore
	 * @return
	 */
	List<Combo> obtenerOficinas(String afore, Long zona);
	
	/**
	 * Metodo encargado de obtener los combos de la zona
	 * 
	 * @param clave
	 * @param claveZona
	 * @param flujo
	 * @return
	 */
	List<Combo> obtenerZonasOficina(String clave, String claveZona, Integer flujo);
}