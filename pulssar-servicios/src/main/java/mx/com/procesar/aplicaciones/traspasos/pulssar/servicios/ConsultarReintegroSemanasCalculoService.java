package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;

/**
 * Interfaz para realizar el calculo Reintegro semanas
 * @author ANOSORIO
 *
 */

public interface ConsultarReintegroSemanasCalculoService{

	/**
	 * Metodo para para realizar el calculo Reintegro semanas
	 * @param consultaHistorico
	 * @return
	 */
	CalculoReintegroSalida realizarCalculoReintegro(ConsultaHistoricoSalida consultaHistorico);
}
