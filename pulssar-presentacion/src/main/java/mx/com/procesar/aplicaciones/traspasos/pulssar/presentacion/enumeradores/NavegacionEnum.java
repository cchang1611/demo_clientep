package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores;

/**
 * Enum encgardo de la navegacion de las pantallas
 * 
 * @author JMGUTIER
 *
 */
public enum NavegacionEnum {
	
	/**
	 * Acuse de Conformacion de expediente
	 */
	PERMISO_DENEGADO("/mx/com/procesar/plataforma/servicios/permisoDenegado"),
	
	/**
	 * vista ERROR_INESPERADO
	 */
	ERROR_INESPERADO("/mx/com/procesar/plataforma/servicios/errorInesperado"),
	
	/**
	 * vista ERROR_BUSINESS
	 */
	ERROR_BUSINESS("/mx/com/procesar/plataforma/servicios/errorBusiness"),
	
	/**
	 * vista MODIFICACION_GENERALES
	 */
	MODIFICACION_GENERALES("/mx/com/procesar/plataforma/servicios/modificacion/datosGenerales"),
	
	/**
	 * vista MODIFICACION_COMPLEMENTARIOS
	 */
	MODIFICACION_COMPLEMENTARIOS("/mx/com/procesar/plataforma/servicios/modificacion/datosComplementarios"),
	
	/**
	 * vista MODIFICACION_NOCERTIFICADOS
	 */
	MODIFICACION_NOCERTIFICADOS("/mx/com/procesar/plataforma/servicios/modificacion/datosNoCertificados"),
	
	/**
	 * vista index
	 */
	BIENVENIDA("mx/com/procesar/plataforma/servicios/index"),
	
	/**
	 * vista index
	 */
	LOGOUT("mx/com/procesar/plataforma/servicios/logout"),
	
	/**
	 * vista Alta de usuario
	 */
	ALTA_USUARIO("/mx/com/procesar/plataforma/servicios/administracion/alta_de_usuarios"),
	
	/**
	 * vista asignacion perfiles
	 */
	ASIGNACION_USUARIO("/mx/com/procesar/plataforma/servicios/administracion/asignacion_de_perfiles"),
	
	/**
	 * vista baja de usuarios
	 */
	BAJA_USUARIOS("/mx/com/procesar/plataforma/servicios/administracion/baja_de_usuarios"),
	
	/**
	 * vista modifica usuario
	 */
	MODIFICA_USUARIO("/mx/com/procesar/plataforma/servicios/administracion/modifica_usuario"),
	
	/**
	 * vista modificacion de usuarios
	 */
	MODIFICACION_USUARIO("/mx/com/procesar/plataforma/servicios/administracion/modificacion_de_usuarios"),
	
	/**
	 * vista registrate
	 */
	REGISTRAR_USUARIO("/mx/com/procesar/plataforma/servicios/registrate"),
	 
	 /**
	  * vista datos complementarios
	  */
	CONSULTA_COMPLEMANTARIOS("/mx/com/procesar/plataforma/servicios/consulta/datos_complementarios"),
	
	/**
	 * vista datos generales
	 */
	CONSULTA_GENERALES("/mx/com/procesar/plataforma/servicios/consulta/datos_generales"),
	
	/**
	 * vista expediente biometricos
	 */
	CONSULTA_BIOMETRICOS("/mx/com/procesar/plataforma/servicios/consulta/expediente_biometricos"),
	
	/**
	 * vista expediente de identificacion
	 */
	CONSULTA_IDENTIFICACION("/mx/com/procesar/plataforma/servicios/consulta/expediente_de_identificacion"),
	
	/**
	 * vista expediente de identificacion
	 */
	SALARIOS_ICEFAS("/mx/com/procesar/plataforma/servicios/consulta/icefas"),
	
	/**
	 * vista expediente de identificacion
	 */
	SALDOS("/mx/com/procesar/plataforma/servicios/consulta/salarios_saldos"),
	
	/**
	 * vista menu
	 */
	MENU("/mx/com/procesar/plataforma/servicios/menus/menu"),
	
	/**
	 * vista menu
	 */
	MENU_AGENTE("/mx/com/procesar/plataforma/servicios/menus/menuAgente"),
	
	/**
	 * vista princital
	 */
	PRINCIPAL("/mx/com/procesar/plataforma/servicios/consulta/principal"),
	
	/**
	 * vista asigna contrasenia
	 */
	ACTIVA_USUARIO("mx/com/procesar/plataforma/servicios/activacion_de_usuario"),
	
	/**
	 * vista asigna contrasenia
	 */
	OLVIDA_PASSWORD("mx/com/procesar/plataforma/servicios/olvide_password"),
	
	/**
	 * vista asigna contrasenia
	 */
	CAMBIO_PASSWORD("mx/com/procesar/plataforma/servicios/cambio_pasword"),

	/**
	 * vista consulta aviso de privacidad general
	 */
	AVISO_PRIVACIDAD_GRAL("mx/com/procesar/plataforma/servicios/avisoPrivacidadGral"),
	
	/**
	 * vista correo corporativo
	 */
	CORREO_CORPORATIVO("/mx/com/procesar/plataforma/servicios/administracion/admin_correos"),
	
	/**
	 * vista cambio password agente
	 */
	CAMBIO_PASSWORD_AGENTE("/mx/com/procesar/plataforma/servicios/administracion/cambio_pasword_agente"),
	
	/**
	 * vista para reactivar usuarios
	 */
	REACTIVACION_USUARIO("/mx/com/procesar/plataforma/servicios/administracion/admin_reactivacion"),
	
	/**
	 * vista para reenvio de credenciales
	 */
	REENVIO_USUARIO("/mx/com/procesar/plataforma/servicios/administracion/admin_reenvio_creadenciales"),
	
	/**pa que me la pasaras, pero ya me la pasaron
	 * vista menu retiro parcial
	 */
	MENU_RETIRO_PARCIAL("/mx/com/procesar/plataforma/servicios/menus/menuRetiroParcial"),
	
	
	/**
	 * SUB_MENU_DISPOSICION_TOTAL
	 */
	SUB_MENU_DISPOSICION_TOTAL("/mx/com/procesar/plataforma/servicios/menus/subMenuDisposicionTotal"),
	
	
	/**
	 * Disposicion Total IMMS
	 */
	DISPOSICION_TOTAL_IMSS("/mx/com/procesar/plataforma/servicios/disposicion_total/disposicion_total_imss"),
	
	/**
	 * vista menu retiro parcial
	 */
	SUB_MENU_RETIRO_PARCIAL("/mx/com/procesar/plataforma/servicios/menus/subMenuRetiroParcial"),

	/**
	 * vista menu retiro parcial
	 */
	SUB_MENU_RETIRO_PARCIAL_AYUDA_MATRIMONIO("/mx/com/procesar/plataforma/servicios/menus/subMenuRetiroParcialAyudaMatrimonio"),
	
	/**
	 * vista ayuda por desempleo
	 */
	AYUDA_DESEMPLEO("/mx/com/procesar/plataforma/servicios/retiro/ayuda_desempleo"),
	
	/**
	 * vista ayuda por matrimonio
	 */
	MATRIMONIO_CUS("/mx/com/procesar/plataforma/servicios/retiro/matrimonio/matrimonio_cus"),
	
	/**
	 * vista ayuda por matrimonio salida
	 */
	MATRIMONIO_CAPTURA_CONYUGE("/mx/com/procesar/plataforma/servicios/retiro/matrimonio/matrimonio_captura_conyuge"),
	
	/**
	 * salida ayuda desempleo
	 */
	MATRIMONIO_SALIDA("/mx/com/procesar/plataforma/servicios/retiro/matrimonio/ayuda_matrimonio_salida"),

	
	
	/**
	 * salida ayuda desempleo
	 */
	AYUDA_DESEMPLEO_SALIDA("/mx/com/procesar/plataforma/servicios/retiro/ayuda_desempleo_salida"),
	
	/**
	 * vista menu
	 */
	EXPEDIENTE_BIOMETRICO("/mx/com/procesar/plataforma/servicios/biometricos_expediente/biometrico"),
	
	/**
	 * vista menu
	 */
	EXPEDIENTE_IDENTIFICACION("/mx/com/procesar/plataforma/servicios/biometricos_expediente/identificacion"),
	
	/**
	 * vista certificacion
	 */
	CERTIFICACION("/mx/com/procesar/plataforma/servicios/retiro/certificacion"),

	/**
	 * vista certificacion
	 */
	TIPO_RETIRO("/mx/com/procesar/plataforma/servicios/retiro/tipo_retiro"),
	
	
	/**
	 * solicitud disposicion
	 */
	SOLICITUD_DISPOSICION("/mx/com/procesar/plataforma/servicios/retiro/solicitud_disposicion"),

	/**
	 * solicitud disposicion
	 */
	SOLICITUD_PARCIAL_ISSSTE("/mx/com/procesar/plataforma/servicios/retiro/solicitud_parcial_issste"),

	/**
	 * solicitud disposicion
	 */
	GENERAR_CUS("/mx/com/procesar/plataforma/servicios/cus/generar_cus"),
	/**
	 * historial tramites
	 */
	HISTORIAL_TRAMITES("/mx/com/procesar/plataforma/servicios/consulta/historial_tramites"),

	/**
	 * historial tramites detalle
	 */
	HISTORIAL_TRAMITES_DETALLE("/mx/com/procesar/plataforma/servicios/consulta/historial_tramites_detalle"),

	/**
	 * vista menu
	 */
	EXPEDIENTE_RETIRO_IMSS("/mx/com/procesar/plataforma/servicios/retiro/expedienteRetiroImss"),
	
	/**
	 * ventana que muestra los pdf de retiro
	 */
	VENTANA_PDFS_RETIRO("/mx/com/procesar/plataforma/servicios/retiro/ventanaPdfs"),

	/**
	 * forward al pdf solicitud de retiro por desempleo del imss
	 */
	FORWARD_PDF_SOLICITUD_RETIRO_IMSS("forward:/private/pdf/id/1"),
	
	/**
	 * FORWARD_PDF_SOLICITUD_RETIRO_IMSS_GEN
	 */
	FORWARD_PDF_SOLICITUD_RETIRO_IMSS_GEN("/private/pdf/id/1"),
	
	
	/**
	 * FORWARD_PDF_SOLICITUD_RETIRO_IMSS_GEN
	 */
	FORWARD_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS_GEN("/private/pdf/id/3"),
	
	/**
	 * procesa subir un archivo al servidor
	 */
	RESPUESTA_ADJUNTAR_ARCHIVO("/mx/com/procesar/plataforma/servicios/respuestaAdjuntarArchivo"),
	
	/**
	 * pagina siguiente solicitud disposicion parcial salida 
	 */
	SOLICITUD_DISPOSICION_PARCIAL_SALIDA("/private/solicituddisposicionsalida.do"),
	
	/**
	 * forward al pdf solicitud de retiro por desempleo del issste
	 */
	FORWARD_PDF_SOLICITUD_RETIRO_ISSSTE("forward:/private/pdf/retiroDesempleoIssste"),
	
	
	FORWARD_PDF_SOLICITUD_RETIRO_ISSSTE_GEN("forward:/private/pdf/retiroDesempleoIssste"),
	
	
	/**
	 * FORWARD_UPLD_DOCTOS_GENERICO
	 */
	FORWARD_UPLD_DOCTOS_GENERICO("redirect:/private/upldDocumentosGen"),
	
	/**
	 * UPLD_DOCTOS_GENERICO
	 */
	UPLD_DOCTOS_GENERICO("/mx/com/procesar/plataforma/servicios/retiro/solicitud_parcial_upld_generico"),

	/**
	 * pagina siguiente solicitud disposicion parcial salida 
	 */
	SOLICITUD_DISPOSICION_PARCIAL_ISSSTE_SALIDA("/private/solicitudParcialIsssteSalida.do"),

	/**
	 * página Reintegro de recursos por un retiro
	 * parcial por desempleo
	 */
	REINTEGRO_RECURSOS_IMSS("/mx/com/procesar/plataforma/servicios/retiro/reintegroRecursosImss"),
	
	/**
	 * página Reintegro de recursos por un retiro
	 * parcial por desempleo
	 */
	REINTEGRO_DATOS_PAGO_IMSS("/mx/com/procesar/plataforma/servicios/retiro/reintegroDatosPagoImss"),
	
	/**
	* Documentos adicionales expediente servicio
	*/
	
	DOCUMENTOS_ADICIONALES_EXPEDIENTE_SERVICIO("/mx/com/procesar/plataforma/servicios/modificacion/expedienteServicio/documentosAdicionales"),
	
	/**
	 * vista menu retiro parcial Pago Parcialidad
	 */
	SUB_MENU_RETIRO_PARCIAL_PAGO_PARCIALIDAD("/mx/com/procesar/plataforma/servicios/menus/subMenuRetiroParcialPagoParcialidad"),
	
	/**
	 * vista menu retiro parcial Reintegro Recursos Desempleo
	 */
	SUB_MENU_RETIRO_PARCIAL_REINTEGRO_RECURSOS_DESEMPLEO("/mx/com/procesar/plataforma/servicios/menus/subMenuRetiroParcialReintegroRecursos"),
	
	/**
	 * vista ayuda por desempleo
	 */
	PAGO_POR_PARCIALIDAD("/mx/com/procesar/plataforma/servicios/retiro/pago_parcialidad"),
	
	/**
	 * Ventana de confirmacion actualizacion estatus parcialidad
	 */
	VENTANA_CONFIRMACION("/mx/com/procesar/plataforma/servicios/retiro/resultado_parcialidad"),	
	
	/**
	 * Vista Reintegro Recursos Desempleo
	 */
	REINTEGRO_RECURSOS_DESEMPLEO("/mx/com/procesar/plataforma/servicios/reintegro/reintegroRecursosDesempleo"),
	
	/**
	 * Vista Confirmacion Reintegro Recursos Desempleo
	 */
	CONFIRMACION_REINTEGRO_RECURSOS_DESEMPLEO("/mx/com/procesar/plataforma/servicios/reintegro/confirmacionReintegroRecursosDesempleo"),
	
	/**
	 * Vista Generar Linea de Captura Reintegro Recursos Desempleo
	 */
	GENERAR_DATOS_REFERENCIA_REINTEGRO_RECURSOS_DESEMPLEO("/mx/com/procesar/plataforma/servicios/reintegro/generarDatosReferenciaReintegroRecursosDesempleo"),
	
	/**
	 * Vista Generar Documentos Requeridos
	 */
	DOCUMENTOS_REQUERIDOS_REINTEGRO_RECURSOS_DESEMPLEO("/mx/com/procesar/plataforma/servicios/reintegro/documentosReintegroRecursosDesempleo"),
	
	/**
	 * Vista generacion expediente servicio modificacion de datos
	 */
	EXPEDIENTE_SERVICIO_MODIFICACION("/mx/com/procesar/plataforma/servicios/modificacion/expedienteServicio/solicitudModificacionDatosPdf"),
	
	/**
	 * vista verificación de empleado
	 */
	VERIFICACION_EMPLEADO("/mx/com/procesar/plataforma/servicios/biometricos_expediente/validaEmpleado"),
	
	/**
	 * vista obtener huellas INE
	 */
	OBTENER_HUELLAS_INE("/mx/com/procesar/plataforma/servicios/biometricos_expediente/obtenerHuellasINE"),
	
	/**
	 * vista verificación de trabajador
	 */
	VERIFICACION_TRABAJADOR("/mx/com/procesar/plataforma/servicios/biometricos_expediente/validaTrabajador"),
	
	/**
	 * vista verificación de trabajador modificacion de datos
	 */
	VERIFICACION_TRABAJADOR_MOD("/mx/com/procesar/plataforma/servicios/biometricos_expediente/verifica4Huellas"),
	
	/**
	* Documentos adicionales expediente servicio
	*/
	
	CONTINUACION_PERMANENCIA("/mx/com/procesar/plataforma/servicios/modificacion/continuacionPermanencia"),
	
	/**
	 * vista menu retiro parcial Pago Parcialidad
	 */
	SUB_MENU_DISPOSICION_TOTAL_IMSS("/mx/com/procesar/plataforma/servicios/menus/subMenuDisposicionTotalImss"),
	
	/**
	 * vista disposicion total imss
	 */
	TRABAJOR_CON_DERECHO_DERECHO_NO_CARGADO_IMSS("/mx/com/procesar/plataforma/servicios/disposicion_total/trabajador_con_derecho_no_cargado_imss"),
	
	/**
	 * vista disposicion total imss
	 */
	TRABAJOR_CON_DERECHO_CARGADO_ISSSTE("/mx/com/procesar/plataforma/servicios/disposicion_total/trabajador_con_derecho_cargado_issste"),
	
	
	/**
	 * vista solicitud tramite
	 */
	DISPOSICION_SOLICITUD_TRAMITE("/mx/com/procesar/plataforma/servicios/disposicion_total/solicitud_tramite"),
	
	/**
	 * vista ayuda por desempleo
	 */
	VISOR_IMAGENES("/mx/com/procesar/plataforma/servicios/visorDocumentos"),
	
	/**
	 * vista para realizar login de usuario coppel
	 */
	LOGIN_COPPEL("/mx/com/procesar/plataforma/servicios/loginCoppel"),
	
	/**
	 * vista paa prueba de biometrico
	 */
	LOGOUT_COPPEL("/mx/com/procesar/plataforma/servicios/logoutCoppel"),
	
	/**
	 * error citi
	 */
	LOGIN_ERROR_BANAMEX("/mx/com/procesar/plataforma/servicios/citiError"),
	
	/**
	 * error citi
	 */
	LOGIN_COMPARADOR("/mx/com/procesar/plataforma/servicios/loginComparador"),
	
	/**
	 * vista ayuda por matrimonio pdf
	 */
	AYUDA_MATRIMONIO_PDF("/mx/com/procesar/plataforma/servicios/retiro/matrimonio/ayuda_matrimonio_pdf"),
	
	/**
	 * vista submenu de consulta expediente para operativos procesar
	 */
	SUB_MENU_OPERATIVO_PROCESAR_CONSULTA_EXPEDIENTE("/mx/com/procesar/plataforma/servicios/menus_operativo_procesar/subMenuConsultaExpediente"),
	
	/**
	 * vista submenu de consulta servicios para operativos procesar
	 */
	SUB_MENU_OPERATIVO_PROCESAR_CONSULTA_SERVICIOS("/mx/com/procesar/plataforma/servicios/menus_operativo_procesar/subMenuConsultaServicios"),
	
	/**
	 * vista plataforma servicios
	 */
	CONSULTA_PLATAFORMA_SERVICIOS("/mx/com/procesar/plataforma/servicios/plataforma_operativa/consulta_plataforma_servicios"),
	
	/**
	 * vista plataforma servicios
	 */
	RESPUESTA_PLATAFORMA_SERVICIOS("/mx/com/procesar/plataforma/servicios/plataforma_operativa/consulta_plataforma_servicios_consulta"),
	
	/**
	 * Disposicion total issste
	 */
	DISPOSICION_TOTAL_ISSSTE("/mx/com/procesar/plataforma/servicios/disposicion_total/disposicion_total_issste"),
	
	/**
	 * vista ayuda por desempleo
	 */
	VISOR_IMAGENES_RETIRO("/mx/com/procesar/plataforma/servicios/retiro/visorDocumentosRetiro"),
	
	/**
	 * Plan Privado Pension IMMS
	 */
	PLAN_PRIVADO_PENSION_IMSS("/mx/com/procesar/plataforma/servicios/disposicion_total/plan_privado_pension_imss"),
	
	/**
	 * FORWARD_PDF_DISPOSICION_TOTAL_IMSS
	 */
	FORWARD_PDF_DISPOSICION_TOTAL_IMSS("/private/pdf/id/4"),
	
	/**
	 * FORWARD_PDF_DISPOSICION_TOTAL_ISSSTE
	 */
	FORWARD_PDF_DISPOSICION_TOTAL_ISSSTE("/private/pdf/id/5"),
	
	/**
	 * FORWARD CERTIFICACION SOLICITUDES TRASPASO
	 */
	FORWARD_CERTIFICACION_SOLICITUDES_TRASPASO("/mx/com/procesar/plataforma/servicios/plataforma_operativa/consulta_plataforma_servicios_certificacion_traspaso"),
	
	/**
	 * Atributo AUTENTICACION_POR_INE
	 */
	INICIO_AUTENTICACION_POR_INE("/mx/com/procesar/plataforma/servicios/autenticacion_Ine/inicioAutenticacionIne"),
	
	/**
	 * Atributo AUTENTICACION_POR_INE
	 */
	AUTENTICACION_POR_INE_PDF("/mx/com/procesar/plataforma/servicios/autenticacion_Ine/autenticacionInePdf"),
	
	/**
	 * Atributo AUTENTICACION_POR_INE
	 */
	AUTENTICACION_POR_INE_PDF_FIRMADO("/mx/com/procesar/plataforma/servicios/autenticacion_Ine/autenticacionInePdfFirmado"),
	
	/**
	 * Atributo AUTENTICACION_POR_INE
	 */
	AUTENTICACION_POR_INE_VALIDACION_DATOS("/mx/com/procesar/plataforma/servicios/autenticacion_Ine/autenticacionIneValidacionDatos"),
	
	/**
	 * DISPOSICION_RESP_ISSSTE
	 */
	DISPOSICION_RESP_ISSSTE("/mx/com/procesar/plataforma/servicios/disposicion_total/solicitud_disposicion_issste"),
	
	/**
	 * DISPOSICION_RESP_IMSS
	 */
	DISPOSICION_RESP_IMSS("/mx/com/procesar/plataforma/servicios/disposicion_total/solicitud_disposicion_imss"),
	
	
	/**
	 * vista submenu de consulta servicios para operativos procesar
	 */
	MENU_REIMPRESION_DOCUMENTO("/mx/com/procesar/plataforma/servicios/reimpresion_documentos/reimpresion_documentos"),
	
	/**
	 * vista submenu de consulta servicios para operativos procesar
	 */
	TIPO_REIMPRESION_DOCUMENTO("/mx/com/procesar/plataforma/servicios/reimpresion_documentos/reimpresion_documentos_tipo"),
	
	/**
	 * vista menu saldos y movimientos
	 */
    SALDOS_Y_MOVIMIENTOS("/mx/com/procesar/plataforma/servicios/reimpresion_documentos/reimpresion_documentos_saldos_movimientos"),

	/**
	 * error citi
	 */
	LOGIN_AUX("/mx/com/procesar/plataforma/servicios/menuRedirect"),
	
	/**
	 * Vista menu Solicitud de Nip
	 */
	SOLICITUD_NIP("/mx/com/procesar/plataforma/servicios/nip/solicitudNip"),
	
	/**
	 * pantalla carga masiva 
	 */
	SUB_MENU_CARGA_MASIVA("/mx/com/procesar/plataforma/servicios/menus/subMenuCargaMasiva"),
	/**
	 * pantalla carga masiva 
	 */
	DESCARGA_USUARIOS("/mx/com/procesar/plataforma/servicios/administracion/descargaUsuarios"),
	/**
	 * pantalla carga masiva 
	 */
	CARGA_MASIVA_USURIOS("/mx/com/procesar/plataforma/servicios/administracion/cargarUsuarios"),
	
	/**
	 * vista menu Traspasos Sar
	 */
	SUB_MENU_TRASPASOS_SAR("/mx/com/procesar/plataforma/servicios/menus/subMenuTraspasosSar"),
	
	/**
	 * vista ayuda por desempleo
	 */
	TRASPASOS_SAR92("/mx/com/procesar/plataforma/servicios/sares/traspasoSar92"),
	/**
	 * vista submenu de consulta expediente para operativos procesar
	 */
	VISOR_EXPEDIENTES("/mx/com/procesar/plataforma/servicios/expedientes/visorDocumentos"),
	
	/**
	 * vista principal CONSAR
	 */
	PRINCIPAL_CONSAR("/mx/com/procesar/plataforma/servicios/consulta/principalConsar"),
	
	/**
	 * vista ips corporativo
	 */
	IPS_CORPORATIVO("/mx/com/procesar/plataforma/servicios/administracion/admin_ips"),
	;
	
	/**
	 * atributo navegacion
	 */
	private String navegacion;
	
	/**
	 * Constructor
	 * @param navegacion
	 */
	private NavegacionEnum(final String navegacion){
		this.navegacion = navegacion;
	}

	/**
	 * @return the navegacion
	 */
	public String getNavegacion() {
		return navegacion;
	}
}