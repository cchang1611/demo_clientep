package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoValidaCitaEsar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisponibilidadTurno;

/**
 * <p>
 * Expone los servicios para la consulta  de las <b>Citas Agendadas</b>.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface CitaAgendaService {
	
	/**
	 * <p>
	 * Servicio rest que obtiene la lista de las citas asignadas ese mismo dia  
	 * </p>
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * @return Lista de CitaNotificacion
	 */
	List<CitaNotificacion> obtenerDatosCita(String idSucursal);
	
	/**
	 * <p>
	 * Servicio que obtiene los datos de la cita para la disponibilidad.  
	 * </p>
	 * 
	 * @return Una lista de {@link DisponibilidadTurno}.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	List<DisponibilidadTurno> obtenerDatosCitaDisponibilidad(String idSucursal);

	/**
	 * Metodo para recuperar los datos del codigo para obtener la informacion
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Nov 11, 2019
	 * @return
	 */
	List<CodigoValidaCitaEsar> obtenerDatosCodigoCita(String curp, Integer estado);

}
