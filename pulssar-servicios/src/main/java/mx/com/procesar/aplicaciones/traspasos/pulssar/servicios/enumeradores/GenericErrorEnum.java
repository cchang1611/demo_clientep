package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * mensajes de error validaciones de registro usuario
 * 
 * //TODO: VALIDAR CODIGOS DE ERROR CORRECTOS
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public enum GenericErrorEnum {
	
	/**
	 * ACEPTADO
	 */
	ACEPTADO("01"),
	
	/**
	 * RECHAZADO
	 */
	RECHAZADO("02"),
	
	/**
	 * Exception generica
	 */
	EXCEPTION_GENERICA("G001"),
	
	/**
	 * Parametros nulos
	 */
	PARAMETRO_NULO("G002"),

	/**
	 * Parametros nulos
	 */
	ESTRUCTURA_INCORRECTA("G007"),
	
	/**
	 * Estructura incorrecta correo
	 */
	ESTRUCTURA_INCORRECTA_CORREO("G008"),
	
	/**
	 * Codigo no valido
	 */
	CODIGO_NO_VALIDO("G009"),
	
	/**
	 * Password erroneo
	 */
	PASSWORD_IGUALES("G011"),
	/**
	 * Seleccione un usuario para baja
	 */
	SELECCION_USUARIOS_BAJA("G012"),
	
	/**
	 * seleccione un rol o usuario
	 */
	SELECCION_USUARIO_ROL("G013"),
	
	/**
	 * sin expedientes
	 */
	FALTA_EXPEDIENTE_IDENTIFICACION_ENROLAMIENTO("C001"),
	
	/**
	 * sin expedientes
	 */
	FALTA_EXPEDIENTE_ENROLAMIENTO("C002"),
	
	/**
	 * sin expedientes
	 */
	FALTA_EXPEDIENTE_IDENTIFICACION("C003"),
	
	/**
	 * sin expedientes
	 */
	EXPEDIENTE_IDENTIFCIACION_ENROLAMIENTO_TEMPORAL("C011"),
	
	/**
	 * sin expedientes
	 */
	EXPEDIENTE_IDENTIFCIACION_TEMPORAL("C012"),
	
	/**
	 * sin expedientes
	 */
	EXPEDIENTE_ENROLAMIENTO_TEMPORAL("C013"),
	
	/**
	 * seleccione un rol o usuario
	 */
	HUELLAS_NO_CAPTURADAS("G026"),
	
	/**
	 * Agente no capturado
	 */
	AGENTE_NO_CAPTURADO("G027"),
	
	/**
	 * Turno no asignado
	 */
	ERROR_TURNO_NO_ASIGANADO("E001"),
	
	/**
	 * Turno no asignado
	 */
	ERROR_ADMINISTRACION_TURNO_EN_ATENCION("E002"),
	
	/**
	 * archivos faltantes expediente ide
	 */
	ARCHIVOS_FALTANTES_IDE("E015"),
	
	/**
	 * sin archivos cargados
	 */
	SIN_ARCHIVOS_IDE("E016"),
	
	/**
	 * tamanio del archivo excedido
	 */
	TAMANIO_EXCEDIDO("E017"),
	
	/**
	 * Extension incorrecta
	 */
	EXTENSION_ARCHIVO_INCORRECTO_IMAGEN("E018"),
	
	/**
	 * Mensaje de autenticacion ine peis
	 */
	MENSAJE_AUTENTICACION_INE_PEIS("G031"),
	
	/**
	 * Mensaje de autenticacion ine peis
	 */
	AUTENTICACION_INE_ERROR_SOLICITANTE_PEIS("C029"),
	
	/**
	 * Mensaje de autenticacion ine peis
	 */
	AUTENTICACION_INE_ERROR_CONEXION_PEIS("C030");
	
	/**
	 * Variable clave
	 */
	private final String clave;

	/**
	 * @return clave
	 * @return descripcion
	 */
	private GenericErrorEnum(final String clave) {
		this.clave = clave;
	}
	
	/**
	 * @param clave
	 */
	public static GenericErrorEnum obtenerError(String clave) {
		GenericErrorEnum regreso = GenericErrorEnum.EXCEPTION_GENERICA;
		
		for (GenericErrorEnum e : GenericErrorEnum.values()) {
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
