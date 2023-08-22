package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;

/**
 * Expone los servicios para los tipos de servicios.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface TipoServicioService {
	
	/**
	 * Obtiene los Tipos de Servicios para Turnos.
	 * 
	 * @return Una lista de servicios.
	 */
	List<Servicio> buscarServiciosTurnos();

}
