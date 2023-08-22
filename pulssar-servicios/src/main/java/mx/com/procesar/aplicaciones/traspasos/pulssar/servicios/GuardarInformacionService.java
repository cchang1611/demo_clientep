package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * interfaz servicio Guardar usuario
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface GuardarInformacionService {
	
	/**
	 * Metodo encargado de guardar el usuario AcceSAR de un alta
	 * 
	 * @param usuarioAcceSAR
	 * @param registro
	 * @param status
	 * @param userMod
	 * @param codigo
	 * @param roles
	 * @param password
	 */
	void guardarUsuarioAcceSAR(String usuarioAcceSAR, DatosRegistro registro, String status, String userMod, CodigoUsuario codigo, List<String> roles, String password, boolean servicioRest);
	
	/**
	 * Metodo encargado de guardar el rechazo de un usuario
	 * 
	 * @param registro
	 * @param codigo
	 * @param claveAfore
	 * @param flujo
	 * @param minutos
	 * @return
	 */
	public RespuestaServicio guardarRechazoUsuario(DatosRegistro registro, String codigo, String claveAfore, Integer flujo, String minutos);
	
	/**
	 * Metodo encargado de realizar el rechazo
	 * 
	 * @param registro
	 * @param idRechazo
	 */
	void guardarRechazoUsuario(DatosRegistro registro, Long idRechazo);
	
	/**
	 * Metodo encargado de guardar la informacion
	 * de usuario pulssar de un agente
	 * 
	 * @param registro
	 * @param estatus
	 */
//	public void guardarCodigo(CodigoUsuario codigo, Long idUsuario);
	
	/**
	 * Metodo encargado de guardar la informacion
	 * de usuario pulssar de un agente
	 * 
	 * @param registro
	 * @param estatus
	 */
//	public void guardarAgente(DatosRegistro registro, String estatus, String userModificador);
	
	/**
	 * Metodo encargado de guardar el alta de un usuario
	 * 
	 * @param registro
	 * @param user
	 */
//	public void guardarUsuario(DatosRegistro registro, String user, CodigoUsuario codigo);
}
