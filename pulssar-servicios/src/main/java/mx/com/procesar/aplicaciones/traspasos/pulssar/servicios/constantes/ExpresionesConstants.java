package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

/**
 * Clase de constantes con expresiones regulares para validaciones
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class ExpresionesConstants {
	
	/**
	 * Constante Exp para espacios vacÌos.
	 */
	public static final String EXPRESION_REGULAR_VACIO = "\\s";

	/**
	 * Constante Exp para correo electrÛnico
	 */
	public static final String EXPRESION_CORREO_ELECTRONICO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * Constante Exp para NUMEROS
	 */
	public static final String EXPRESION_NUMEROS = "^\\d*$";
	
	/**
	 * Diagonal
	 */
	public static final String DIAGONAL = "/";
	
	/**
	 * Espacio
	 */
	public static final String ESPACIO = " ";
	
	/**
	 * Espacio
	 */
	public static final String VACIO = "";
	
	/**
	 * constante para validar dominios
	 */
	public static final String ARROBA = "@";
	
	/**
	 * constante para validar diminio 
	 */
	public static final String PUNTO_DOMINIO = ".";
	
	/**
	 * contante parametro
	 */
	public static final String VALOR_PARAMETRO = "!";
	
	/**
	 * contante coma
	 */
	public static final String COMA = ",";
	
	/**
	 * constante guion bajo 
	 */
	public static final String GUION_BAJO = "_";
	
	/**
	 * contante comillas
	 */
	public static final String COMILLA = "\"";
	
	/**
	 * contante Key inicio
	 */
	public static final String KEY_APERTURA = "{";
	
	/**
	 * contante Key inicio
	 */
	public static final String KEY_CERRAR = "}";
	
	/**
	 * constante salto de linea
	 */
	public static final String SALTO = "\n";
	
	/**
	 * constante tabulador
	 */
	public static final String TABULADOR = "\t";
	
	/**
	 * contante parametro
	 */
	public static final String DOS_PUNTOS = ":";
	
	/**
	 * Cadena de masculino
	 */
	public static final String C_MASCULINO = "MASCULINO";
	
	/**
	 * Cadena de masculino
	 */
	public static final String C_FEMENINO = "FEMENINO";
	
	/**
	 * Cadena credenciales
	 */
	public static final String TEXTO_CREDENCIALES = "credenciales";
	
	/**
	 * Extension archivo zip
	 */
	public static final String EXTENSION_ZIP = ".zip";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String EXTENSION_PDF = ".pdf";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String VALOR_PNG = "png";
	
	/**
	 * Extension archivo JPG
	 */
	public static final String VALOR_JPG = ".jpg";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String VALOR_JNLP = ".jnlp";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String EXTENSION_XML = ".xml";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String PALABRA_ACUSE = "ACUSE_";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String PALABRA_EXCEPCION = "EXCEPCION_";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String PALABRA_HUELLAS = "HUELLAS_";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String RESPUESTA_SIN_HUELLAS = "[{'respuesta':'001','cadena':'";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String RESPUESTA_HUELLAS_LESIONADAS = "[{'respuesta':'004','cadena':'";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String RESPUESTA_ZIP_HUELLAS = "[{'respuesta':'01','cadena':'";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String RESPUESTA_ZIP_HUELLASB = "[{'respuesta':'','cadena':'";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String FIN_RESPUESTA_HUELLAS = "'}]";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String BIOMETRICO_RESULTADO_BANORTE = "BiometricoResultado: ";
	
	/**
	 * Inicio de calidad huellas
	 */
	public static final String INICIO_CALIDAD_HUELLAS = "[";
	
	/**
	 * Inicio de calidad huellas
	 */
	public static final String FIN_CALIDAD_HUELLAS = "]";
	
	/**
	 * Extension archivo pdf
	 */
	public static final String ARGUMENTOS_HUELLAS = "\n<argument>{huellas}</argument>";
	
	/**
	 * signo interrogacion sierre
	 */
	public static final String SIGNO_INTERROGACION_SIERRE = "?";
	
	/**
	 * SIGNO DE PORCENTAJE
	 */
	public static final String SIGNO_PORCENTAJE = " %";
	
	/**
	 * No aplica
	 */
	public static final String SIGLAS_NO_APLICA = "N/A";
	
	/**
	 * Url actualizar
	 */
	public static final String URL_ACTUALIZAR = "Url actualizar:{}";
	
	/**
	 * Respuesta actualizar
	 */
	public static final String RESPUESTA_ACTUALIZAR = "Respuesta Servicio Actualiza:{}";
	
	/**
	 * Descripcion de excepcion
	 */
	public static final String DESCRIPCION_EXCEPCION = "Se presento un problema en la Actualizacion del Estatus {}";
	
	/**
	 * Datos de entrada del trabajador
	 */
	public static final String ENTRADA_DATOS_TRABAJADOR = "==datosTrabajador== {}";
	
	/**
	 * Datos entrada modificacion de datos
	 */
	public static final String ENTRADA_DATOS_MODIFICACION = "==datosModificacion== {}";
	
	/**
	 * Bandera modificacion de datos
	 */
	public static final String BANDERA_DATOS_MODIFICACION = "==banderaDatosModif== {}";
	
	/**
	 * Objeto modificacion de datos
	 */
	public static final String OBJETO_MODIFICACION = ":: objeto modificacion :: {}";
	
	/**
	 * solicitud modificacion de datos
	 */
	public static final String SOLICITUD_MODIFICACION_DATOS = "SolModifDatos_";
	
	/**
	 * Formato de fecha con guines
	 */
	public static final String FORMATO_FEHCA_GUION = "dd-MMM-yyyy";
	
	/**
	 * Error al leer temporal de pdf
	 */
	public static final String ERROR_LEER_TEMPORAL = "error al leer el archivo temporal del pdf";
	
	/**
	 * Error inesperado al generar pdf
	 */
	public static final String ERROR_INESPERADO_PDF = "Ocurrio un error inesperado generarSolicitudDatosPDF";
	
	/**
	 * Texto selecicone
	 */
	public static final String TEXTO_SELECCIONE = "Seleccione";
	
	/**
	 * Tipo Solicitante Titular
	 */
	public static final String TIPO_SOLICITANTE_TITULAR = "01";
	
	/**
	 * Tipo Solicitante Beneficiario
	 */
	public static final String TIPO_SOLICITANTE_BENEFICIARIO = "02";
	
	/**
	 * Tipo Solicitante Representante Legal
	 */
	public static final String TIPO_SOLICITANTE_REPRESENTANTE_LEGAL = "03";
	
	/**
	 * Tipo Solicitante Curador
	 */
	public static final String TIPO_SOLICITANTE_CURADOR = "04";
	
	/**
	 * Tipo Solicitante Curador
	 */
	public static final String PUNTO_COMA = ";";
	
	/**
	 * Bitacora movimiento
	 */
	public static final String BITACORA_MOVIMIENTO = "bitacoraMovimiento";
	
	/**
	 * Guardar paso bitacora
	 */
	public static final String PASO_BITACORA = "guardarPasoBitacora";
	
	/**
	 * Expresion regular formato usuario
	 */
	public static final String REG_EXP_FORMATO_USUARIO = "([0-9]{10})";
	
	/**
	 * Expresion regular formato curp
	 */
	public static final String REG_EXP_FORMATO_CURP = "([A-Z]{4}[0-9]{6}[H,M][A-Z]{5}[A-Z0-9]{1}[0-9]{1})";
	
	/**
	 * Expresion regular formato NSS
	 */
	public static final String REG_EXP_FORMATO_NSS = "([0-9]{11})";
	
	/**
	 * Expresion regular formato tipo solicitante
	 */
	public static final String REG_EXP_FORMATO_TIPO_SOLICITANTE = "(0[0-5]{1})";
	
	/**
	 * Expresion regular formato timePicker
	 */
	public static final String REG_EXP_FORMATO_TIME_PICKER = "([0-9]{2}:[0-9]{2})";
	
	/**
	 * Expresion regular formato nombre
	 */
	public static final String REG_EXP_FORMATO_NOMBRE = "(^([a-zA-Z0-9Ò—·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ƒÀœ÷‹\\s])*$)";
	
	/**
	 * nss vacio
	 */
	public static final String NSS_VACIO = "00000000000";
	
	/**
	 * Diagonal r
	 */
	public static final String DIAGONAL_R = "\r";
	
	/**
	 * Cadena roja
	 */
	public static final String CADENA_IGUAL = "=";
	
	/**
	 * derechoNoCargado
	 */
    public static final String DERECHO_NO_CARGADO ="derechoNoCargado";
	
	/**
	 * consultaNoCargado
	 */
    public static final String CONSULTA_NO_CARGADO ="consultaNoCargado";
    
   /**
    *  derechoCarga
    */
    public static final String DERECHO_CARGA="derechoCarga";
    
    /**
     * catalogo
     */
    public static final String CATALOGO="catalogo";
    
    /**
     * actuario
     */
    public static final String ACTUARIO_TODOS="/actuario/todos";
   
   
    /**
	 * cvProceso_401
	 */
	public static final String cvProceso_401="401";
	
	/**
	 * cvProceso_402
	 */
	public static final String cvProceso_402="402";
		
	/**
	 * cvProceso_403
	 */
	public static final String cvProceso_403="403";
	
	
	
	/**
	 * SIGNO DE PESOS
	 */
	public static final String SIGNO_PESOS = "$";
	
	/**
	 * resolucionParcial
	 */
	public static final String RESOLUCION_PARCIAL ="resolucionParcial";
	
	/**
	 * derechoNoCargado
	 */
    public static final String VALIDAR_DERECHO_ACEPTADO ="validarDerechoAceptado";
    
    /**
     * diagnostico
     */
    public static final String DIAGNOSTICO="diagnostico";
    
	/**
	 * consultaDiagnostico
	 */
    public static final String CONSULTAR_DIAGNOSTICO="consultaDiagnostico";
    
    /**
	 * modulo de reportes
	 */
    public static final String MODULO_REPORTES = "/moduloReportes";
    
    /**
	 * validar vip de acceso
	 */
    public static final String VALIDAR_ACCESO_VIP = "/validarVIP/%s/%s";
    
    /**
 	 * validar vip de acceso
 	 */
     public static final String GUION = " - ";
     
     
     /**
      * sustitucion para afore
      */
     public static final String AFORE_SUSTITUCION = "{afore}";
     
     /**
      * sustitucion para proceso
      */
     public static final String PROCESO_SUSTITUCION = "{proceso}";
}