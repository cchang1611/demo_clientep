package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;


import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramiteComparadorInformacionGenerico;

/**
 * Interfaz ProcesoPendienteService
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Dec 13, 2021
 */
public interface ProcesoPendienteService {
	
	/**
	 * Insertar datos de proceso pendiente
	 */
	<T> void insertarProcesoPendiente(ProcesoPendienteEntrada<T> procesoPendiente);

	/**
	 * Metodo encargado de insertar solicitud de comparador generico
	 * @param solicitud
	 */
	<T> RespuestaSolicitud insertarProcesoSolicitudComparador(TramiteComparadorInformacionGenerico<T> solicitud);

	/**
	 * Metodo encargado de consultar registro de procesos pendientes
	 * @param idFolio
	 * @param estatus
	 * @return
	 */
	ProcesoPendiente consultaProcesoPendienteIdfolio(String idFolio, String estatus);
	
	/**
	 *  eliminar Proceso Pendiente
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param curp
	 *  @param procesos
	 */
	void eliminarProcesoPendiente(String curp, String procesos);

}
