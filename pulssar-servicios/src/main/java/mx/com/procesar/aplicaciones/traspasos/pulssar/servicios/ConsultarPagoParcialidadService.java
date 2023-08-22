package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RetiroParcialCalculoImssList;

/**
 * Interfaz para el llamado de pagos parcialidades
 * @author ANOSORIO
 *
 */
public interface ConsultarPagoParcialidadService {

	/**
	 * Metodo para consultar pagos por parcialidades
	 * @param idProcesar
	 * @return
	 */
	RetiroParcialCalculoImssList consultarPagoParcialidades(String idProcesar);
	
}
