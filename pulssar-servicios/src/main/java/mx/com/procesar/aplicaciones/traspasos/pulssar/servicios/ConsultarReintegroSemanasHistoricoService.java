package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;

/**
 * Interfaz para la consulta Historico
 * @author ANOSORIO
 *
 */
public interface ConsultarReintegroSemanasHistoricoService {

	/**
	 * Metodo para consultar Historico 
	 * @param contrato
	 */
	ConsultaHistoricoSalida consultarHistorico(DatosTrabajador trabajador);

}
