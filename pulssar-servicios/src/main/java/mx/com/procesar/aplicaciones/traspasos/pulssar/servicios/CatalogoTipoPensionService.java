package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;

/**
 * Interfaz consultar catalogo
 * @author ANOSORIO
 *
 */
public interface CatalogoTipoPensionService {
    /**
     * Metodo para consultar Catalogo Tipo Pension
     * @return
     */
	List<CatalogoIret> consultaTipoPension();

}
