package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parcialidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaEstatusServicio;

/**
 * Interfaz que realiza la actualizacion del estatus
 * @author ANOSORIO
 *
 */
public interface ActualizaEstatusParcialidadesService {
     
	/**
	 * Metodo que actualiza el estatus
	 * @param idProcesar
	 * @param numeroParcialidad
	 * @return
	 */
	RespuestaEstatusServicio actualizarEstatusParcialidad(Parcialidad parcialidad);
}
