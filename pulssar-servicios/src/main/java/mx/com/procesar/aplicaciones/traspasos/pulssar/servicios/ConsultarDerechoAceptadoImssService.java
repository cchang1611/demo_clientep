package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
/**
 *  Interfaz Consulta derecho Aceptado 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 17, 2021
 */
public interface ConsultarDerechoAceptadoImssService {

    /**
     *  Metodo consulta derecho Aceptado 
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param entradaDatos
     *  @return
     */
	SalidaGenerica consultarDerechoAceptado(ProcesoDerechoNoCargado entradaDatos);
}
