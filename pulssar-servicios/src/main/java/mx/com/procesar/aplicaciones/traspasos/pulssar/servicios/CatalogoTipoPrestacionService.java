package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;

/**
 * Interdaz de catalogo
 * @author ANOSORIO
 *
 */
public interface CatalogoTipoPrestacionService {

	/**
	 * Metodo consulta tipoPrestacion
	 * @return
	 */
	List<CatalogoIret> consultaTipoPrestacion();

}
