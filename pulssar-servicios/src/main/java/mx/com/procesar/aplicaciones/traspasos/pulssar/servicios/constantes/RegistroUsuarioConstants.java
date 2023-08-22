package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import java.util.ArrayList;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;

/**
 * Clase de constantes para el servicio de registro usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public final class RegistroUsuarioConstants {
	
	/**
	 * Estatus bloqueo 00
	 */
	public static final String ESTATUS_BLOQUEO = "00";
	
	/**
	 * Estatus bloqueo 01
	 */
	public static final String ESTATUS_BLOQUEO_PRIMER_BLOQUEO = "01";
	
	/**
	 * Estatus bloqueo 02
	 */
	public static final String ESTATUS_BLOQUEO_SEGUNDO_BLOQUEO = "02";
	
	/**
	 * constante utf8
	 */
	public static final String UTF_8 = "UTF-8";
	
	/**
	 * Clase usuario para alta en oid 
	 */
	public static final String CLASE_USUARIO = "top,person,organizationalPerson,inetOrgPerson,sarPerson";
	
	/**
	 * MAIL
	 */
	public static final String CORREO = "mail";

	/**
	 * MOBILE
	 */
	public static final String TELEFONO = "mobile";
	
	/**
	 * MOBILE
	 */
	public static final String EMPLEADO_TYPE_SICI = "employeeType";
	
	/**
	 * Contraseña incorrecta
	 */
	public static final String ERROR_HTTP_CLIENT = "Contraseña no coincide";
	
	/**
	 * Mensaje sms codigo activacion
	 */
	public static final String MENSAJE_SMS = "Codigo Portal Servicios: {codigo}";
	
	/**
	 * Mensaje sms usuario y password
	 */
	public static final String MENSAJE_SMS_USUARIO_PASSWORD = "Portal Servicios usuario: {usuario}, password: {password}";
	
	/**
	 * Mensaje password
	 */
	public static final String MENSAJE_SMS_PASSWORD = "Portal Servicios Nuevo Password: {password}";
	
	/**
	 * Replace usuario
	 */
	public static final String SMS_USUARIO = "{usuario}";
	
	/**
	 * Replace password
	 */
	public static final String SMS_PASSWORD = "{password}";
	
	/**
	 * Replace codigo
	 */
	public static final String SMS_CODIGO = "{codigo}";
	
	/**
	 * Replace datos
	 */
	public static final String DATOS_RESPUESTA = "{datos}";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_ALTA = "usuario_alta";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_ACTIVACION = "usuario_activacion";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_PULSSAR = "usuario_Pulssar";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_REGISTRO = "usuario_registro";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_VENCIDO = "usuario_vencido";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_RECHAZO = "usuario_rechazo";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_RECUPERACION = "usuario_recuperacion";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_BLOQUEO = "usuario_bloqueo";
	
	/**
	 * Cadena Correo
	 */
	public static final String CADENA_USUARIO = "usuario";
	
	/**
	 * Cadena Celular
	 */
	public static final String CADENA_CELULAR = "celular";
	
	/**
	 * Cadena Correo
	 */
	public static final String CADENA_CORREO = "correo";
	
	/**
	 * Cadena codigo
	 */
	public static final String CADENA_CODIGO = "codigo";
	
	/**
	 * Tipo de Codigo alta
	 */
	public static final String TIPO_CODIGO_ALTA = "01";
	
	/**
	 * Recuperación de Contrasenia
	 */
	public static final String TIPO_CODIGO_RECUPERACION = "02";
	
	/**
	 * Tipo de sms alta
	 */
	public static final String TIPO_SMS_ALTA = "01";
	
	/**
	 * Recuperación de Contrasenia
	 */
	public static final String TIPO_SMS_RECUPERACION = "02";
	
	/**
	 * Nuevo Password
	 */
	public static final String TIPO_SMS_NUEVO_PASSWORD = "03";
	
	/**
	 * Recuperación de Contrasenia
	 */
	public static final String DIAS_VIGENCIA = "PC01";
	
	/**
	 * Nuevo Password
	 */
	public static final String INTENTOS = "PC02";
	
	/**
	 * Intentos estatus 01
	 */
	public static final String BLOQUEADO_TEMPORALMENTE = "01";
	
	/**
	 * Intentos estatus 02
	 */
	public static final String BLOQUEADO_PERMANENTE = "02";
	
	/**
	 * Intentos y tiempo para estatus 01
	 */
	public static final String INTENTOS_TIEMPO = "3,5";
	
	/**
	 * Intentos para estatus 02
	 */
	public static final String INTENTOS_PERMANENETE = "3";
	
	/**
	 * Usuario registro
	 */
	public static final String USUARIO_FEDERADOS_PORTAL = "BANAMEX_FEDERADOS_PORTAL";
	
	/**
	 * Estatus usuario agente
	 */
	public static final List<String> ESTATUS_USUARIO_AGENTE = new ArrayList<>();
	
	/**
	 * Estatus usuario agente baja
	 */
	public static final List<String> ESTATUS_USUARIO_BAJA = new ArrayList<>();
	
	/**
	 * Estatus usuario no agente
	 */
	public static final List<String> ESTATUS_USUARIO = new ArrayList<>();
	
	/**
	 * Estatus usuario no agente
	 */
	public static final List<String> ESTATUS_USUARIOS = new ArrayList<>();
	
	/**
	 * Clave menu reimpresion
	 */
	public static final String CLAVE_MENU_REIMPRESION="P02029";
	
	/**
	 * pipe
	 */
	public static final String COMA=",";
	
	/**
	 * Definicion de valores staticos
	 */
	static {
		ESTATUS_USUARIO_AGENTE.add(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
		ESTATUS_USUARIO_AGENTE.add(EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario());
		ESTATUS_USUARIO_AGENTE.add(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario());
		ESTATUS_USUARIO_AGENTE.add(EstatusUsuarioEnum.USUARIO_REACTIVADO.getEstatusUsuario());
		
		ESTATUS_USUARIO_BAJA.add(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario());
		ESTATUS_USUARIO_BAJA.add(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
		ESTATUS_USUARIO_BAJA.add(EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario());
		ESTATUS_USUARIO_BAJA.add(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario());
		ESTATUS_USUARIO_BAJA.add(EstatusUsuarioEnum.USUARIO_REACTIVADO.getEstatusUsuario());
		
		ESTATUS_USUARIO.add(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
		ESTATUS_USUARIO.add(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario());
		
		ESTATUS_USUARIOS.add(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
		ESTATUS_USUARIOS.add(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario());
		ESTATUS_USUARIOS.add(EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario());
		ESTATUS_USUARIOS.add(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario());
		ESTATUS_USUARIOS.add(EstatusUsuarioEnum.USUARIO_REACTIVADO.getEstatusUsuario());
		
	}
	/**
	 * Clave menu reimpresion
	 */
	public static final String CLAVE_MENU_EXPE_UNICO_COOPEL="P02040";
}