package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
/**
 * Interfaz consulta clavePesion
 * @author ANOSORIO
 *
 */
public interface CatalogoClavePensionService {
    
	/**
	 * Metodo consulta clave Pension
	 * @return
	 */
	List<CatalogoIret> consultaClavePension();

}
