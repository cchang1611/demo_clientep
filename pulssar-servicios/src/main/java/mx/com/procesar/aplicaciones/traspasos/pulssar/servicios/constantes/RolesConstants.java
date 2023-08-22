package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import java.util.ArrayList;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;

/**
 * Clase de constantes con la lista de roles
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class RolesConstants {
	
	/**
	 * Perfiles de super admin
	 */
	public static final List<String> PERFILES_SUPER = new ArrayList<>();
	
	/**
	 * Perfiles de asignar primera vez
	 */
	public static final List<String> PERFILES_ASIGNAR = new ArrayList<>();
	
	/**
	 * Perfiles actualizar datos
	 */
	public static final List<String> PERFILES_EDITAR_USUARIO = new ArrayList<>();
	
	/**
	 * Perfiles actualizar datos
	 */
	public static final List<String> PERFILES_EDITAR_USUARIO_ADMIN = new ArrayList<>();
	
	/**
	 * Perfiles de super admin
	 */
	public static final List<String> PERFILES_USUARIOS = new ArrayList<>();
	
	/**
	 * Clave Procesar
	 */
	public static final String CLAVE_PROCESAR = "999";
	
	/**
	 * Clave Banamex
	 */
	public static final String CLAVE_BANAMEX = "552";
	
	/**
	 * Constante de menu principal
	 */
	public static final Long MENU_PRINCIPAL = 1L;
	
	/**
	 *  Constante de menu
	 */
	public static final Long MENU_BASICO = 0L;
	
	/**
	 * Perfiles de super admin
	 */
	public static final String PARAM_ALTA_USUARIOS = "ALTA";
	
	/**
	 * Perfiles de super admin
	 */
	public static final String PERFILES_ALTA_ADMIN = "03,04,05,07,08,09";
	
	/**
	 * Perfiles de administradores
	 */
	public static final String PARAM_PERFILES_ADMIN = "ADMINS";
	
	/**
	 * Perfiles administradores
	 */
	public static final String PERFILES_ADMIN = "01,03";
	
	/**
	 * Perfiles de administradores
	 */
	public static final String PARAM_PERFILES_AGENTE = "AGENTE";
	
	/**
	 * Perfiles administradores
	 */
	public static final String PERFILES_AGENTE = "05";
	
	/**
	 * Perfiles de asignar primera vez
	 */
	public static final String PARAM_PERFILES_ASIGNAR = "ASIGNA";
	
	/**
	 * Perfiles de asignar primera vez
	 */
	public static final String PARAM_PERFILES_ALTA = "ALTA";
	
	/**
	 * Perfiles administradores
	 */
	public static final String PERFIL_ASIGNAR = "05,07,08,09";
	
	/**
	 * Perfiles administradores
	 */
	public static final String PERFIL_ALTA = "'01,02,03,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20'";
	
	/**
	 * Perfiles actualizar datos
	 */
	public static final String PARAM_PERFILES_EDITAR_USUARIO = "PR04";
	
	/**
	 * Perfiles actualizar datos
	 */
	public static final String PARAM_PERFILES_EDITAR_USUARIO_ADMIN = "PR05";
	
	/**
	 * Perfiles actualizar datos
	 */
	public static final String PERFIL_OPERATIVO_SICI = "OPERATIVO SICI";
	
	/**
	 *  Constante de sub menu 
	 */
	public static final Long SUB_MENU_BASICO = 5L;
	
	/**
	 * ASIGNACION DE VALORES
	 */
	static {
		
		PERFILES_SUPER.add(RolesEnum.SUPER_ADMINISTRADOR.getRol());
		PERFILES_SUPER.add(RolesEnum.OPERATIVO_PROCESAR.getRol());
		PERFILES_SUPER.add(RolesEnum.ADMINISTRADOR_AFORE.getRol());
		PERFILES_SUPER.add(RolesEnum.OPERATIVO_AFORE.getRol());
		
		PERFILES_ASIGNAR.add(RolesEnum.AGENTE_VENTANILLA.getRol());
		
		PERFILES_EDITAR_USUARIO.add(RolesEnum.ADMINISTRADOR_AFORE.getRol());
		PERFILES_EDITAR_USUARIO.add(RolesEnum.OPERATIVO_AFORE.getRol());
		PERFILES_EDITAR_USUARIO.add(RolesEnum.AGENTE_VENTANILLA.getRol());
		
		PERFILES_EDITAR_USUARIO_ADMIN.add(RolesEnum.SUPER_ADMINISTRADOR.getRol());
		PERFILES_EDITAR_USUARIO_ADMIN.add(RolesEnum.OPERATIVO_PROCESAR.getRol());
		PERFILES_EDITAR_USUARIO_ADMIN.add(RolesEnum.ADMINISTRADOR_AFORE.getRol());
		PERFILES_EDITAR_USUARIO_ADMIN.add(RolesEnum.OPERATIVO_AFORE.getRol());
		PERFILES_EDITAR_USUARIO_ADMIN.add(RolesEnum.AGENTE_VENTANILLA.getRol());
		
		PERFILES_USUARIOS.add(RolesEnum.OPERATIVO_AFORE.getRol());
		PERFILES_USUARIOS.add(RolesEnum.OPERATIVO_PROCESAR.getRol());
		PERFILES_USUARIOS.add(RolesEnum.AGENTE_VENTANILLA.getRol());
	}
}