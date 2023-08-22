/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;

/**
 * Genera el Folio ligado a la solicitud de generación de NIP
 * @author MALOPEZT
 * @since 2022/02/08
 */
public interface NipFoliadoService {

	/**
	 * Genera el Folio ligado a la solicitud de generación de NIP
	 * @param tiempoLlegada
	 * @param idUser
	 * @param curp
	 * @param nss
	 * @param sucursal
	 * @return FolioEntrada
	 */
	public FolioEntrada generarFolio(String tiempoLlegada, Long idUser, String curp, String nss, String sucursal);
}
