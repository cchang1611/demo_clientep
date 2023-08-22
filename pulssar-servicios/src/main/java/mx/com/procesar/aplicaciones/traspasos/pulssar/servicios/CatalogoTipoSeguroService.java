package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;

/**
 * Interfaz catalogo
 * @author ANOSORIO
 *
 */
public interface CatalogoTipoSeguroService {

	/**
	 * Metodo que conmsulta catalogo
	 * @return 
	 */
	List<CatalogoIret> consultaTipoSeguro();

}
