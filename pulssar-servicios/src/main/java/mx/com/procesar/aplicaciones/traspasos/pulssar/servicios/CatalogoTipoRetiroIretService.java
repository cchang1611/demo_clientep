package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
/**
 * Interfaz consulta catalog Tipo Retiro
 * @author ANOSORIO
 *
 */
public interface CatalogoTipoRetiroIretService {

	/**
	 * Mettodo consulta catalogo tipo retiro
	 * @return
	 */
     List<CatalogoIret> consultaTipoRetiro();

}
