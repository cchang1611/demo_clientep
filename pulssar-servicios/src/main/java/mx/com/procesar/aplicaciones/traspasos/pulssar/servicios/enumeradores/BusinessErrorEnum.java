package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * mensajes de error validaciones de registro usuario
 * 
 * //TODO: VALIDAR CODIGOS DE ERROR CORRECTOS
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public enum BusinessErrorEnum {
	
	/**
	 * Exception generica con titulo
	 */
	EXCEPTION_GENERICA("G001"),
	
	/**
	 * Error al invocar el servicio Agente Promotor
	 */
	EXCEPTION_SERVICIO_AGENTE("G010"),
	
	/**
	 * Error usaurio existente
	 */
	ERROR_USUARIO_EXISTENTE("A06"),
	
	/**
	 * Error correo existe para otro usuario
	 */
	ERROR_CORREO_EXISTENTE("A07"),
	
	/**
	 * Error celular existe para otro usuario
	 */
	ERROR_CELULAR_EXISTENTE("A08"),
	
	/**
	 * Error usaurio con estatus incorrecto
	 */
	ERROR_USUARIO_NO_ACTIVO("A09"),
	
	/**
	 * Password no coincide
	 */
	ERROR_PASSWORD_INCORRECTO("A10"),
	
	/**
	 * Error usaurio no existe
	 */
	ERROR_USUARIO_NO_EXISTE("A11"),
	
	/**
	 * Error correo corporativo invalido
	 */
	ERROR_CORREO_CORPORATIVO_INVALIDO("A12"),
	
	/**
	 * Estructura incorrecta correo
	 */
	ESTRUCTURA_USUARIO_CORREO("A13"),
	
	/**
	 * Correo distinto al registrado
	 */
	CORREO_DISTINTO_REGISTRADO("A14"),
	
	/**
	 * Telefono distinto al registrado
	 */
	TELEFONO_DISTINTO_REGISTRADO("A15"),	
	
	/**
	 * Fecha de Codigo Vigente
	 */
	FECHA_CODIGO_VIGENTE("A16"),
	
	/**
	 * Codigo de usuario usado
	 */
	CODIGO_USUARIO_USADO("A17"),
	
	/**
	 *Usuario Vencido
	 */
	CODIGO_USUARIO_VENCIDO("A18"),
	
	/**
	 * Codigo de usuario usado
	 */
	CODIGO_USUARIO_BLOQUEADO("A19"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	URL_DATOS_ERRONEOS("A20"),
	
	/**
	 * Nick o agente no existente
	 */
	NICK_AGENTE_NO_EXISTE("A21"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	DATOS_NO_CAPTURADOS("G014"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	HORARIO_NO_CAPTURADO("G015"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	USUARIO_PASSWORD_INCORRECTO("G016"),
	
	/**
	 * Usuario bloqueado temporalmente
	 */
	USUARIO_BLOQUEADO_TEMPORALMENTE("G017"),
	
	/**
	 * Usuario bloqueado permanente
	 */
	USUARIO_BLOQUEADO_PERMANENTE("G018"),
	
	/**
	 * Usuario no capturado 
	 */
	USUARIO_NO_CAPTURADO("G019"),
	
	/**
	 * Usuario reactivado
	 */
	ESTATUS_USAURIO_REACTIVADO("G020"),
	
	/**
	 * codigo no valido reenvio  activacion
	 */
	CODIGO_NO_VALIDO_REENVIO_ACTIVACION("G021"),
	
	/**
	 * Codigo no valido, reenvio recuperacion
	 */
	CODIGO_NO_VALIDO_REENVIO_RECUPERACION("G022"),
	
	/**
	 * Codigo no valido, reenvio recuperacion
	 */
	ARCHIVO_NO_PERMITIDO("G024"),
	
	/**
	 * Codigo no valido, reenvio recuperacion
	 */
	ARCHIVO_TAMANIO_NO_PERMITIDO("G025"),
	
	/**
	 * Codigo no valido, reenvio recuperacion
	 */
	ARCHIVOS_FALTANTES("G023"),
		
	/**
	 * Codigo datos incrongruentes
	 */
	TRABAJADOR_NO_ENCONTRADO("C004"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	TRABAJADOR_AFORE_DISTINTA("C005"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	TRABAJADOR_ASIGNADO("C006"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	DIFERENCIAS_RENAPO("C007"),
	
	/**
	 * Codigo datos incrongruentes
	 */
	CUS_NO_ENCONTRADO("C008"),

	/**
	 * Codigo datos incrongruentes
	 */
	CITA_NO_ENCONTRADO("C009"),
	
	/**
	 * Codigo de curp duplicada
	 */
	TRABAJADOR_DUPLICADO("C010"),
	
	/**
	 * Folio activo
	 */
	FOLIO_ACTIVO("F001"),
	
	/**
	 * Solicitud RECHAZADA
	 */
	SOLICITUD_RECHAZADA("E008"),
	
	/**
	 * Afore sin administrador
	 */
	AFORE_SIN_ADMIN("G028"),
	
	/**
	 * Afore sin acceso desde url generica
	 */
	NO_ACCESO_PORTAL("G029"),
	
	/**
	 * Url distinta al usaurio login
	 */
	URL_DISTINTA_USUARIO_LOGIN("G030"),
	
	/**
	 * Url distinta al usaurio login
	 */
	USUARIO_SIN_PRIVILEGIOS_SICI("G031"),
	
	/**
	 * Huella dispositivo Coppel
	 */
	ERROR_DISPOSITIVO_COPPEL("H003"),
	
	/**
	 * Faltan datos en la respuesta de huellas
	 */
	ERROR_DATOS_FALTANTE_PETICION("H004"),
	
	/**
	 * No se capturaron las huellas
	 */
	NO_CAPTURARON_HUELLAS("H005"),
	
	/**
	 * Faltan datos en la respuesta de huellas
	 */
	HUELLAS_TRABAJADOR_CAPTURAR("H007"),
	
	/**
	 * Numero de huellas para empleado
	 */
	HUELLAS_EMPLEDO_CAPTURAR("H008"),
	
	/**
	 * Numero de huellas para trabajador enrolamiento
	 */
	HUELLAS_TRABAJADOR_ENROLAMIENTO("H009"),
	
	/**
	 * usuario faltante
	 */
	USUARIO_FALTANTE("L001"),
	
	/**
	 * usuario formato error
	 */
	USUARIO_FORMATO_ERROR("L002"),
	
	/**
	 * Curp trabajador faltante
	 */
	CURP_FALTANTE("L003"),
	
	/**
	 * Curp trabajador formato error
	 */
	CURP_FORMATO_ERROR("L004"),
	
	/**
	 * curp y nss faltantes
	 */
	CURP_NSS_FALTANTES("L005"),
	
	/**
	 * NSS faltante
	 */
	NSS_FALTANTE("L006"),
	
	/**
	 * NSS formato error
	 */
	NSS_FORMATO_ERROR("L007"),
	
	/**
	 * Tipo Solicitante faltante
	 */
	TIPO_SOLICITANTE_FALTANTE("L008"),
	
	/**
	 * Tipo Solicitante formato error
	 */
	TIPO_SOLICITANTE_FORMATO_ERROR("L009"),
	
	/**
	 * TimePicker faltante
	 */
	TIME_FALTANTE("L010"),
	
	/**
	 * TimePicker formato error
	 */
	TIME_FORMATO_ERROR("L011"),
	
	/**
	 * Curp solicitante faltante
	 */
	CURP_SOLICITANTE_FALTANTE("L012"),
	
	/**
	 * Curp solicitante formato error
	 */
	CURP_SOLICITANTE_FORMATO_ERROR("L013"),
	
	/**
	 * Nombre solicitante faltante
	 */
	NOMBRE_FALTANTE("L014"),
	
	/**
	 * Apellido Paterno solicitante formato error
	 */
	APELLIDO_PATERNO_FALTANTE("L015"),
	
	/**
	 * nombre formato error
	 */
	NOMBRE_FORMATO_ERROR("L016"),
	
	/**
	 * Id session vacio
	 */
	ID_SESION_FALTANTE("L017"),
	
	/**
	 * direcion url vacio
	 */
	DIRECCION_URL_FALTANTE("L018"),
	
	/**
	 * Numero tienda vacio
	 */
	NUMERO_TIENDA_FALTANTE("L019"),
	
	/**
	 * cuenta con proceso pendiente de confronta
	 */
	PROCESO_PENDIENTE_CONFRONTA("MDPE"),
	
	/**
	 * proceso abierto de modificacion de datos
	 */
	PROCESO_ABIERTO_MDD("MDPA"),
	
	/**
	 * aun no se ha conformado expediente biometrico
	 */
	PROCESO_CONFORMACION_BIOMETTICO("MDPB"),
	
	/**
	 * Falta usuario o rol banamex
	 */
	FALTA_USUARIO_GROUP("L020"),
	
	/**
	 * perfil incorrecto
	 */
	PERFIL_INCORRECTO("L021"),
	
	/**
	 * Rol no asignado a oud
	 */
	ROL_NO_ASIGNADO_OUD("L022"),
	
	/**
	 * Beneficiario no designado por titular
	 */
	BENEFICIARIO_NO_DESIGNADO("MA37"),
	
	/**
	 * SIN ENROLAMIENTO PERMANENTE
	 */
	TRABAJADOR_SIN_EXPEDIENTE_ENROLAMIENTO_PERMANENTE("C014");
	
	/**
	 * Variable clave
	 */
	private final String clave;

	/**
	 * @return clave
	 * @return descripcion
	 */
	private BusinessErrorEnum(final String clave) {
		this.clave = clave;
	}
	
	/**
	 * @param clave
	 */
	public static BusinessErrorEnum obtenerError(String clave) {
		BusinessErrorEnum regreso = BusinessErrorEnum.EXCEPTION_GENERICA;
		
		for (BusinessErrorEnum e : BusinessErrorEnum.values()) {
			if (e.getClave().equals(clave)) {
				regreso = e;
			}
		}
		return regreso;
	}

	/**
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}
}