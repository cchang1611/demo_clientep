package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Clase de servicio para banorte 
 * @author dhernand
 *
 */
public interface BanorteService {

	/**
	 * Genera la url para iniciar la tablet
	 * @return
	 */
	String generarUrlPeticionTablet(Map<String,String> parametros,UsuarioLogin usuario);
	
}
