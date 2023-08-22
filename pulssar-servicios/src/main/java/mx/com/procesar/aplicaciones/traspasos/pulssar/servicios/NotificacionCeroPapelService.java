package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;

/**
 * Notificacion service
 * @author RARREOLA
 *
 */
public interface NotificacionCeroPapelService {
	
	
	/**
	 * Guardar datos de cero papel
	 * 
	 * @param principalCeroPapel
	 * @param tipoAfiliacion
	 */
	void guardarDatosNotificacionCeroPapel(EntradaCeroPapel entradaCeroPapel, String tipoAfiliacion);

}
