package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Mensajes de error o informativos del servicio de 
 * Constancia de Implicaciones 
 * 
 * @author DBARBOSA
 */
public enum UsuarioErrorEnum {
	
	/**
	 * Parametros nulos
	 */
	PARAMETRO_NULO("014", 3),
	
	/**
	 * Estructura incorrecta curp
	 */
	ESTRUCTURA_INCORRECTA_CURP("015", 3),
	
	/**
	 * Estructura incorrecta nombre
	 */
	ESTRUCTURA_INCORRECTA_NOMBRE("016", 3),
	
	/**
	 * Estructura incorrecta correo
	 */
	ESTRUCTURA_INCORRECTA_CORREO("017", 3),
	
	/**
	 * Estructura incorrecta codigo postal
	 */
	ESTRUCTURA_INCORRECTA_CP("022", 3),
	
	/**
	 * Estructura incorrecta celular
	 */
	ESTRUCTURA_INCORRECTA_CELULAR("025", 3),
	
	/**
	 * Confirmacion de celular
	 */
	CONFIRMACION_CELULAR("026", 3),
	
	/**
	 * Estructura incorrecta nss
	 */
	ESTRUCTURA_INCORRECTA_NSS("034", 3),
	
	/**
	 * Estructura incorrecta nss
	 */
	ESTRUCTURA_INCORRECTA_CONTRASENIA("035", 3),
	
	/**
	 * Estructura incorrecta correo
	 */
	ESTRUCTURA_INCORRECTA_CORREO_DOMINIO("055", 3),
	
	/**
	 * Exception ya registrado telefono
	 */
	EXCEPTION_TELEFONO_REGISTRADO("036", 2),
	
	/**
	 * Exception ya registrado el correo
	 */
	EXCEPTION_CORREO_REGISTRADO("037", 2),
	
	/**
	 * CODIGO_VENCIDO_ACTIVACION
	 */
	CODIGO_VENCIDO_ACTIVACION("038", 2),
	
	/**
	 * CODIGO_VENCIDO_CAMBIO
	 */
	CODIGO_VENCIDO_CAMBIO("039", 2),
	
	/**
	 * CODIGO_VENCIDO_RECUPERACION
	 */
	CODIGO_VENCIDO_RECUPERACION("040", 2),
	
	/**
	 * Exception para recuperar contrasenia
	 */
	CONTRASENIA_CONFIRMACION("041",3),
	
	/**
	 * Proceso pendiente por terminar
	 */
	PROCESO_PENDIENTE("042", 2),
	
	/**
	 * excepcion codigo quemado
	 */
	EXCEPTION_CODIGO_QUEMADO_INDEX("043", 5),
	
	/**
	 * excepcion codigo quemado
	 */
	EXCEPTION_CODIGO_QUEMADO("043", 2),
	
	/**
	 * excepcion codigo activo
	 */
	EXCEPTION_CODIGO_ACTIVO("044", 2),
	
	/**
	 * Exception generica con titulo
	 */
	EXCEPTION_GENERICA("001", 2),
	
	/**
	 * Cus Activa
	 */
	TRANSACCION_OK("200", 1);
	/**
	 * Variable clave
	 */
	private final String clave;
	
	/**
	 * Variable codigo
	 */
	private final int flujo;

	/**
	 * @return clave
	 * @return descripcion
	 */
	private UsuarioErrorEnum(final String clave, final int flujo) {
		this.clave = clave;
		this.flujo = flujo;
	}

	/**
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @return the flujo
	 */
	public int getFlujo() {
		return flujo;
	}
}