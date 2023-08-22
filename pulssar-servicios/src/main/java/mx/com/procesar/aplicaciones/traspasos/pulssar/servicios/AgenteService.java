package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;

/**
 * Interfaz para la administracion de Agentes
 * @author DBARBOSA
 *
 */
public interface AgenteService {
	
	/**
	 * Metodo encargado de validar y obtener los datos de Agente
	 * 
	 * @param datosRegistro
	 * @param isFoto
	 * @return
	 */
	AgentePromotor validarAgentePromotor(DatosRegistro datosRegistro, boolean isFoto);
}
