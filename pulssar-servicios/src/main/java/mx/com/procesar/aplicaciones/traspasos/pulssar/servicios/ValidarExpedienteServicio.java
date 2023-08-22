package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Interfaz para la validacion expediente
 * @author ANOSORIO
 *
 */
public interface ValidarExpedienteServicio {

	/**
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @param datos
	 *  @param usuarioLogin
	 *  @param retiroDesempleoImss
	 *  @return
	 */
	String validarExpedienteServicio(String folio,  DatosTrabajador datos, UsuarioLogin usuarioLogin, RetiroDesempleoImss retiroDesempleoImss);

	
	/**
	 * @param folio
	 * @param datos
	 * @param user
	 * @param cveProceso
	 * @return
	 */
	String validarExpedienteServicioIssste(String folio, DatosTrabajador datos, UsuarioLogin user, String cveProceso);
	
	/**
	 *  consultar Respuesta Archivo
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @return
	 */
	String consultarRespuestaArchivo(String folio);
}
