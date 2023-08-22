package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerechoProceso;
/**
 *  Servicio Matriz Derecho 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 5, 2021
 */
public interface ConsultarMatrizDerechoImmsService {
    
	/**
	 *  Consulta Matriz Derecho
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param regimen
	 *  @param retiro
	 *  @param seguro
	 *  @param pension
	 *  @param prestacion
	 *  @return
	 */
	MatrizDerecho consultarMatrizDerecho(String regimen,String retiro,String seguro,String pension,String prestacion);

	/**
	 *   Consulta Matriz Derecho por idMatrizDerecho
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param idMatrizDerechoProceso
	 *  @return
	 */
	List<MatrizDerechoProceso> consultarMatrizDerechoProceso(Long idMatrizDerecho);
}
