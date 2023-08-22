package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum MensajesExitoEnum {
	
	/**
	 * Usuario registrado correctamente
	 */
	USUARIO_REGISTRADO_CORRECTAMENTE("OK01"),
	/**
	 * Usuario alta registro
	 */
	USUARIO_ALTA_REGISTRO_CORRECTAMENTE("OK02"),
	/**
	 * recuperacion de contrasenia por correo
	 */
	RECUPERACION_CONTRASENIA_CORREO_CORRECTAMENTE("OK03"),
	/**
	 * recuperacion de contrasenia por celular
	 */
	RECUPERACION_CONTRASENIA_CELULAR_CORRECTAMENTE("OK04"),
	/**
	 * Usuario modificado correctamente
	 */
	USUARIO_MODIFICADO_CORRECTAMENTE("OK05"),
	/**
	 * Usuario baja correctamente
	 */
	USUARIOS_BAJA_CORRECTAMENTE("OK06"),
	/**
	 * Perfil asignado correctamente
	 */
	PERFIL_ASIGNADO_CORRECTAMENTE("OK07"),
	/**
	 * Correo registrado correctamente
	 */
	CORREO_REGISTRADO_CORRECTAMENTE("OK08"),
	/**
	 * Correo actualizado correctamente
	 */
	CORREO_ACTUALIZADO_CORRECTAMENTE("OK09"),
	
	/**
	 * Correo actualizado correctamente
	 */
	USUARIO_ACTIVADO_CORRECTAMENTE("OK10"),
	
	/**
	 * usuario desbloqueado correctamente
	 */
	USUARIO_DESBLOQUEADO_CORRECTAMENTE("OK11"),
	
	/**
	 * Credenciales renviadas correctamente
	 */
	CREDENCIALES_REENVIADAS_CORRECTAMENTE("OK12"),
	
	/**
	 * codigo renviado correctamente
	 */
	CODIGO_RENVIADO_CORRECTAMENTE("OK13"),
	
	/**
	 * Expediente enviado
	 */
	EXPEDIENTE_ENVIADO("OK14"),
	
	/**
	 * Expediente enviado
	 */
	EXPEDIENTE_ENROLAMIENTO_ENVIADO("OK15"),
	
	/**
	 * Expediente enviado
	 */
	EXPEDIENTE_ENROLAMIENTO_ERROR("E001"),
	
	/**
	 * Expediente enviado
	 */
	TIENE_EXPEDIENTE_ENROLAMIENTO_PERMANENTE("E002"),
	
	/**
	 * Excepcion de biometrico
	 */
	EXCEPCION_BIOMETRICO("E003"),
	
	/**
	 * Diferencias con Renapo
	 */
	EXPEDIENTE_DIFERENCIAS_RENAPO("E004"),
	
	/**
	 * No cuenta con Domicilio
	 */
	EXPEDIENTE_SIN_DOMICILIO("E005"),
	
	/**
	 * Acuse de biometrico
	 */
	ACUSE_BIOMETRICO("E010"),
	
	/**
	 * Acuse de biometricos
	 */
	CONFIRMACION_EXPEDIENTE("E006"),
	
	/**
	 * Mensajes de Huella
	 */
	MENSAJE_HUELLA_EMPLEADO("H001"),
	
	/**
	 * Mensajes de Huella
	 */
	MENSAJE_HUELLA_TRABAJADOR("H002"),
	
	/**
	 * Mensajes de Huella empleado no verificado
	 */
	VERIFICAR_EMPLEADO_OBLIGATORIO("H005"),
	
	/**
	 * Estatus usuario activo
	 */
	USUARIO_ACTIVO("01"),
	
	/**
	 * Estatus usuario activo requiere cambio de password
	 */
	USUARIO_ACTIVO_CAMBIO_PASSWORD("02"),	
	
	/**  SECCION DE ADMINISTRACION DE FILAS  */	
	/**
	 * Estatus de finalizar turno
	 */
	FINALIZAR_TURNO("OK16"),
	
	/**
	 * Estatus para la Finalización de registro de turno.
	 */
	FINALIZA_REGISTRO_TURNO("OK17"),
	
	/**
	 * Solicitud en proceso
	 */
	SOLICITUD_EN_PROCESO("E007"),
	
	/**
	 * fINALIZA LA CONFORMACION DE EXPEDIENTE
	 */
	FINALIZA_CONFORMACION_EXPEDIENTE("OK18"),
	
	/**
	 * Solicitud pendiente de finalizar
	 */
	PROCESO_PENDIENTE_EXPEDIENTE("E009"),
	
	/**
	 * Proceso finalizado de verificacion de empleado
	 */
	FINALIZA_VERIFICACION_EMPLEADO("OK19"),
	
	/**
	 * Proceso finalizado de verificacion de empleado
	 */
	FINALIZA_VERIFICACION_TRABAJADOR("OK20"),
	
	/**
	 * Confirmacion cero papel
	 */
	CONFIRMACION_CERO_PAPEL("MCP1"),
	
	
	/**
	 * Correo actual
	 */
	CORREO_ACTUAL_CERO_PAPEL("MCP2"),
	
	/**
	 * Correo actual
	 */
	SIN_CORREO_ACTUAL_CERO_PAPEL("MCP3"),
	
	/**
	 *CANCELAR
	 */
	CANCELAR_CERO_PAPEL("MCP4"),
	
	/**
	 *Validar filtros
	 */
	VALIDAR_FILTROS_PLATAFORMA("MPS1"),
	
	
	/**
	 *EXCEL
	 */
	EXCEL_PLATAFORMA("MPS2"),
	
	/**
	 * Expediente en Transito
	 */
	EXPEDIENTE_EN_TRANSITO("E032"),
	
	/**
	 * Expediente Identificacion En Transito o Temporal
	 */
	EXPEDIENTE_TRANS_TEMP("E033");
	
	/**
	 * Atributo estatus
	 */
	private String clave;
	
	/**
	 * Contructor
	 * @param codigoError
	 */
	private MensajesExitoEnum(final String clave) {
		this.clave = clave;

	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
}