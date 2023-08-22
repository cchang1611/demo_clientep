package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;

/**
 * Expone los servicios para la <b>Disponibilidad de Turnos</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface DisponibilidadTurnoService {
	
	/**
	 * Permite obtener la disponiblidad por sucursal y organización.
	 * 
	 * @param sucursal Numero de la Sucursal.
	 * 
	 * @return Regresa los datos de la disponibilidad.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	Respuesta obtenerDiponilidad(final String sucursal);

}
