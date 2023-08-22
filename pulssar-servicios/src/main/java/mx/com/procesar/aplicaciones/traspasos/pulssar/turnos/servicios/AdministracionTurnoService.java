package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.TurnoRegistrado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;

/**
 * <p>
 * Expone los servicios para <b>Administración de Filas y Citas -
 * Citibanamex</b>.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface AdministracionTurnoService {
	
	/**
	 * <p>
	 * Permite construir la respuesta para las los Turnos registrados.
	 * </p>
	 * 
	 * @param claveOrgaizacion Clave de la Organización.
	 * @param idUsuario Usuario en sesion.
	 * @paran sucursal Numero y/o clave de la sucursal
	 * 
	 * @return Objeto de respuesta.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	Respuesta construirRespuestaTurnosRegistrados(final String claveOrgaizacion,
			final Long idUsuario, final String sucursal);
	
	/**
	 * <p>
	 * Permite buscar las Turnos para la cita a través de tipo de registro (con
	 * cita o sin cita) y la fecha de registro.
	 * </p>
	 * 
	 * <p>
	 * Para determinar es estado del turno Registrado se realiza por el estatus
	 * <b>03 - Registrado</b>.
	 * </p>
	 * 
	 * @param tipoCita
	 *            El tipo de Cita: Sin Cita o Con Cita.
	 * @param fechaDeRegistro
	 *            Fecha para el registro de consulta.
	 * @param numeroSucursal
	 *            Numero de Sucursal
	 * 
	 * @return Las citas registradas.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * 
	 */
	List<TurnoRegistrado> buscarTurnosRegistrados(final String tipoCita, final String numeroSucursal);

	/**
	 * Metodo que permite realizar las validaciones correspondientes de acuerdo con los datos del turno.
	 * @param asgTurno
	 * 			Cus -- Datos a llenar en caso de tener una cita 
	 * 			Curp -- Campo necesario en caso de no contar con una cus de cita o para nuevo tramite sin cita
	 * 			NSS -- Campo necesario en caso de no tener cita y tener NSS puede tambien ser opcional.
	 * @return Los datos de la persona para la siguiente pantalla
	 */
	AdministracionTurno validarDatosCita(AdministracionTurno asgTurno);

	/**
	 * Metodo para obtener el turno en atencion por idUsuario, claveAfore y sucursal
	 * 
	 * @param idUsuario
	 * @param claveAfore
	 * @param sucursal
	 * @return
	 */
	Respuesta obtenerTurno(Long idUsuario, String claveAfore, String sucursal);

	/**
	 * Metodo para obtener datos del trabajador
	 * @param entrada
	 * @param salidaCus
	 * @param citaSalida
	 * @param flagTipoCita
	 * @return
	 */
	AdministracionTurno obtenerDatosTrabajador(AdministracionTurno entrada, ConsultaCusSalida salidaCus,
			CitaNotificacion citaSalida, Integer flagTipoCita);

	/**
	 * Metodo que retorna la diferencia de horas de una sucursal 
	 * @param sucursal
	 * @return
	 */
	Integer obtenterDiferenciaHoras(String sucursal);
}
