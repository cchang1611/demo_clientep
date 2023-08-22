package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;

/**
 * Exponde los servicios para las operaciones para la <b>Asignación de
 * Turnos</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
public interface AsignaTurnoService {

	/**
	 * Permite crear un turno de un trabajador.
	 * 
	 * @param asignaTurno
	 *            Contiene la información para la asignación del turno.
	 * 
	 * @return El turno generado.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	Respuesta crearCita(final AdministracionTurno asignaTurno);
	
	/**
	 * 
	 * Permite actualizar el folio a estatus con atención
	 * @param sucursal 
	 * @param folioServicio
	 *            Contien el folio de servicio.
	 * @param idUsuario
	 * 
	 * @return El turno actualizado.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	Respuesta actualizarCitaEnAtencion(String sucursal, final String folioServicio, Long idUsuario, Integer horas);

	/**
	 * Actualiza la informacion del turno
	 * 
	 * @param administracionTurno
	 * @param claveAfore
	 * @return
	 */
	Respuesta actualizarTurno(AdministracionTurno administracionTurno, String claveAfore, Integer horas);
}
