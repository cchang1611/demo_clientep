package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import java.util.HashMap;
import java.util.Map;

/**
 * clase de constantes para el modulo de usuarios
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class ServiciosUsuariosConstants {

	/**
	 * Servicio de catalgoo de plataforma
	 */
	public static final String CATALOGO_PLATAFORMA = "accesar/catalogos/plataformas";
	
	/**
	 * Servicio de roles administrador
	 */
	public static final String CATALOGO_ROLES_ADMINISTRADOR = "accesar/catalogos/roles/administrador/%s/%s/%s/%s";
	
	/**
	 * Servicio de catalofo de rol acceso
	 */
	public static final String CATALOGO_ROL_MODULO_ACCESO = "accesar/catalogos/rol/accesoModulo/%s/%s/%s";
	
	/**
	 * Servicio de consula de modulos
	 */
	public static final String CATALOGO_MODULO_REPORTES = "catalogo/moduloReportes";
	
	/**
	 * Servicio de guardar usuario
	 */
	public static final String GUARDADO_USUARIO = "usuario/guardado/%s/";
	
	/**
	 * Servicio consulta IPs
	 */
	public static final String CONSULTA_IPS = "accesar/catalogos/ips/%s/%s";
	
	/**
	 * servicio validar ips
	 */
	public static final String VALIDAR_IPS = "accesar/catalogos/validar/ips/%s/%s/";
	
	/**
	 * servicio validar ips
	 */
	public static final String GUARDAR_IPS = "guardar/ips/%s/%s/%s/";
	
	/**
	 * Servicio de roles administrador
	 */
	public static final String CATALOGO_ROLES_ADMINISTRADOR_MODIFICACION = "accesar/catalogos/roles/adminMod/%s/%s";
	
	/**
	 * Servicio de catalofo de rol acceso
	 */
	public static final String CATALOGO_ROL_MODULO_ACCESO_MODIFICACION = "accesar/catalogos/rol/accesoModuloMod/%s/%s";
	
	/**
	 * Servicio de catalofo de rol acceso
	 */
	public static final Map<String, String> MAP_PAGINAS = new HashMap<>();
	
	/**
	 * Static
	 */
	static {
		MAP_PAGINAS.put("consultaTrabajadorConsar.do", "1");
		MAP_PAGINAS.put("consultaTrabajador.do", "1");
		MAP_PAGINAS.put("plataforma-operativa.do", "2");
	}
}