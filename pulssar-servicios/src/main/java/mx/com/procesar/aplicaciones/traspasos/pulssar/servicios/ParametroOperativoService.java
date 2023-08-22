package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaToken;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;

/**
 * Intrfaz que define los metodos del servicio de guardado del token en la bdnsar
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Marzo 2021
 */
public interface ParametroOperativoService {


    /**
     * Metodo que guarda el token con lod datos del usuario loggeado en las tablas de la BDNSAR
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param datosToken Objeto con los datos del usuario loggeado
     * @return Objeto que contiene el resultado de la ejecucion del servicio de guardado de datos de la sesion
     */
    RespuestaJson guardarTokenUsuario(DatosEntradaToken datosToken);
}
