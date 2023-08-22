package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivoDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioFechas;

/**
 * Interfaz para el manejo de folios
 * 
 * @author Omar Balbuena Quinones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 10/05/2019
 */
public interface FolioService {

	/**
	 * 
	 * Invocacion al REST generarFolio para generar un folio
	 * 
	 * @author Omar Balbuena Quinones (OJBALBUE@inet.procesar.com.mx)
	 * @param solicitudFolio
	 * @return
	 */
	FolioEntrada generarFolio(FolioEntrada solicitudFolio);

	/**
	 * Invocacion al REST cerrarFolio para cambiar el estatus del folio
	 * 
	 * 
	 * @author Omar Balbuena Quinones (OJBALBUE@inet.procesar.com.mx)
	 * @param solicitudFolio
	 */
	void cerrarFolio(Long id, Integer estatus);
	
	
	/**
	 *  Cierra y genera un nuevo folio
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param entrada
	 *  @return
	 */
	FolioEntrada generarNuevoFolio(FolioEntrada entrada);
	
	/**
	 * 
	 *  llama al servicio de cancelar el folio
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param id
	 *  @param estatus
	 *  @param diagnosticoProcesar
	 */
	void cerrarFolio(Long id, Integer estatus, String diagnosticoProcesar);
	
	
	/**
	 *  consultaSiFolioPadreActivo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param idFolio
	 *  @return
	 */
	boolean consultaSiFolioPadreActivo(Long idFolio);
	
	
	
	/**
	 *  consultaFolioActivo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param cveServicio
	 *  @param curp
	 *  @param nss
	 *  @param cveProceso
	 *  @return
	 */
	List<FolioActivoDetalle> consultaFolioActivo(String cveServicio, String curp, String nss, String cveProceso);
	
	/**
	 * Metodo encargado de llenar un folioEntrada para la solicitud del folio
	 * 
	 * @param curp
	 * @param nss
	 * @param descripcion
	 * @param tipoOperacion
	 * @param tLlegada
	 * @return
	 */
	FolioEntrada llenarObjetoFolioEntrada(String curp, String nss, String descripcion, String tipoOperacion, String tLlegada);
	
	/**
	 * Obtencion de folio final
	 * 
	 * @param folio
	 * @param idUsuario
	 * @param sucursal
	 * @param servicio
	 * @param proceso
	 * @return
	 */
	Folio obtenerFolio(FolioEntrada folio, Long idUsuario, String sucursal, String servicio, String proceso);
	
	/**
	 * Metodo encargado de obtener el folio hijo
	 * 
	 * @param idFolio
	 * @return
	 */
	Folio consultarFolioHijo(Long idFolio);
	
	
	/**
	 *  procesarFolio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param folio
	 *  @param trabajador
	 *  @return
	 */
	FolioEntrada procesarFolio(FolioEntrada folio, DatosTrabajador trabajador);

	/**
	 * Metodo encargado de consultar fechas de folio
	 * @param idFolio
	 * @return
	 */
	FolioFechas consultarFechasFolio(Long idFolio);

	/**
	 * Metodo encargado de cosultar folio activo
	 * @param curp
	 * @param nss
	 * @param cveServicio
	 * @return
	 */
	FolioActivo consultarFolioActivo(String curp, String nss, String cveServicio);

	/**
	 * Metodo encargado de consultar dolio padre por folio hijo
	 * @param folio
	 * @return
	 */
	Folio consultarFolioPadrePorFolioHijo(String folio);

	/**
	 * Metodo que consulta folio detalle
	 * @param idFolioPulssar
	 * @return
	 */
	FolioDetalle consultaFolioDetalle(Long idFolioPulssar);
	/**
	 * Generar folio de consulta
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param idUser
	 *  @param curp
	 *  @param nss
	 *  @param sucursal
	 *  @return
	 */
	FolioEntrada generarFolioAutoClose(FolioEntrada solicitudFolio);

	/**
	 * Metodo que actualiza folio
	 * @param folioPadre
	 * @param claveServicio
	 * @param descripcion
	 */
	void actualizarFolio(String folioPadre, String claveServicio, String descripcion);
}