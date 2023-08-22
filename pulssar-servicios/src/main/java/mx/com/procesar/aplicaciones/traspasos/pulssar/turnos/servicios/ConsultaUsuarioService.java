/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;

/**
 * Expone las operaciones de consulta para el Usuario
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface ConsultaUsuarioService {
	
	/**
	 * Permite obtener el usuario a partir de la clave de la organizaci�n y el
	 * usuario en sesi�n.
	 * 
	 * @param claveOrganizacion Clave de la Organizaci�n Afore.
	 * @param usuarioLogueado USuario Logueado.
	 * 
	 * @return La entidad del usuario en sesion.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	UsuarioPulssar buscarPorOrganizacionYUsuarioSesion(final String claveOrganizacion, final String usuarioLogueado);
	
}
