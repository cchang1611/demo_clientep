package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import org.springframework.http.HttpHeaders;

/**
 * Interfaz para inilizar cabeceras
 * @author ANOSORIO
 *
 */
public interface InicializarHeadersService {
    
	/**
	 * Meto que iniciliza Cabeceras
	 * @return
	 */
	HttpHeaders inicializarCabeceras();
}
