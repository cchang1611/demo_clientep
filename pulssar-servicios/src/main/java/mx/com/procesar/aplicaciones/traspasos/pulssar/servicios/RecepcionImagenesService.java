package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;

/**
 * Interface de servicio recepcion imagenes
 * @author JMGUTIEG
 *
 */
public interface RecepcionImagenesService {
	
	/**
	 * Metodo encargado de consultar registro recpecion de imagenes
	 * @param folioPadre
	 * @param cvProceso
	 * @param estatus
	 * @return
	 */
	RecepcionImagenes consultarRecepcionImagenes(String folioPadre, String cvProceso, String estatus);

	/**
	 * Metodo para obtener el contenido de las imagenes recibidas
	 * @param imagenRecibida
	 * @param cveAfore
	 * @return
	 */
	List<ImagenDocumento> obtenerDocumentos(RecepcionImagenes imagenRecibida, String cveAfore);
	
	/**
	 * Metodo que filtra imagenes por proceso 
	 *  TODO [Agregar documentacion al método]
	 *  @author Juan Manuel Gutierrez Gadea (jmgutieg@procesar.com)
	 *  @param imagenRecibida
	 *  @param cveAfore
	 *  @param imagenes
	 *  @return
	 */
	List<ImagenDocumento> filtrarDocumentos(List<ImagenDocumento> imagenRecibida,String cveAfore, RecepcionImagenes imagenes);

}
