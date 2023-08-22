package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ModuloNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;



/**
 * Definicion de servicios de operacion sobre catalogo de modulo
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 09:11:45
 */
public interface ModuloService {

	/**
	 * Metodo que recupera informacion de catalogo de modulos a partir del area de
	 * usuario que se encuentre confgurada en el OID
	 * 
	 * @author hjramire
	 * @param areaUsuario
	 * @return
	 * @throws PlataformaServiciosOperativaServiceException
	 *             List<ModuloNegocio>
	 * @since 03/01/2020, 09:12:04
	 */
	List<ModuloNegocio> recuperarModulosPorArea(String areaUsuario) throws PlataformaServiciosOperativaServiceException;

}
