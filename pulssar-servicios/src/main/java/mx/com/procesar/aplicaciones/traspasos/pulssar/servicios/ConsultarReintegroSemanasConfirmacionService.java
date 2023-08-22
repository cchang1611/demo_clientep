package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConfirmacionMontoSalida;

/**
 * Interfaz para la confirmacion reintegro
 * @author ANOSORIO
 *
 */
public interface ConsultarReintegroSemanasConfirmacionService {

	/**
	 * Metodo para realizar la Confirmacion Reintegro Semanas
	 * @param calculoReintegro
	 * @return
	 */
	ConfirmacionMontoSalida realizarConfirmacionReintegro(CalculoReintegroSalida calculoReintegro);
}
