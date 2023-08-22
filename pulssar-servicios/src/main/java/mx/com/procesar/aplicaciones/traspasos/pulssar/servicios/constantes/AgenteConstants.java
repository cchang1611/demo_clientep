package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase de constantes para el servicio de agente promotor
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public final class AgenteConstants {
	
	/**
	 * IMG_ALTO
	 */
	public static final int IMG_ALTO = 130;
	
	/**
	 * IMG_ANCHO
	 */
	public static final int IMG_ANCHO = 130;
	
	/**
	 * IMG_FORMATO
	 */
	public static final String IMG_FORMATO = "png";
	
	/**
	 * CV_IMAGEN
	 */
	public static final String CV_IMAGEN = "31";
	
	/**
	 * CV_PROCESO 
	 */
	public static final String CV_PROCESO = "cveProceso";

	/**
	 * CV_PROCESO REGISTRO EXPEDIENTE ELECTRONICO AGENTE PROMOTOR/ AGENTE DE SERVICIO / FUNCIONARIO AUTORIZADO EN BATCH
	 */
	public static final String CV_PROCESO_27 = "27";
	
	/**
	 * CV_PROCESO EXPEDIENTE ELECTRONICO AGENTE PROMOTOR/ AGENTE DE SERVICIO / FUNCIONARIO AUTORIZADO EN LÔøΩNEA 
	 */
	public static final String CV_PROCESO_05 = "05";
	
	/**
	 * Digito base nombre imagen
	 */
	public static final String NOMBRE_BASE_IMAGEN = "5";
	
	/**
	 * Key del nombre de la imagen
	 */
	public static final String CLAVE_NOMBRE_IMAGEN = "filename=";
	
	/**
	 * IMAGE HEADER
	 */
	public static final String IMAGE_ENCABEZADO = "Content-Disposition";
	
	/**
	 * PDF Format
	 */
	public static final String PDF_FORMATO = ".PDF";

    /**
     * Estructura del nombre
     */
    public static final String EXP_REGULAR_ALFANUMERICO = "^[a-zA-Z0-9Ò—·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ƒÀœ÷‹\\s]*$";
    
    /**
     * Estructura de validacion de caracteres
     */
    public static final String EXP_REGULAR_VALIDA_CARACTER = "^[a-zA-Z0-9]*$";
    
    /**
     * curp
     */
	public static final String ER_CURP = "^[a-zA-Z]{4}[0-9]{6}[a-zA-Z]{6}[0-9A-Za-z]{2}$";
	
	/**
     * Caracteres Especiales
     */
    public static final String CARACTER_ESP_N = "—";
    
    /**
     * Caracteres Especiales
     */
    public static final String CARAC_ESP = "[^a-zA-Z\u00D1\u00F1\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u0020]";
    
    /**
     * Constante para inicializar una cadena vacia
     */
    public static final String INICIALIZA_VACIO = "";
    
    /**
     * Caracteres especiales original
     */
    public static final String ASCII_ORIGINAL = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹Á«—";
    /**
     * Caracteres especiales reemplazar
     */
    public static final String ASCII_REEMPLAZAR = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUcCN";
    
    /**
     * Caracteres adicionales
     */
    public static final String ASCII_ORIGINAL_ESP = ".-_#!?~'";
    
    /**
     * Constante punto
     */
    public static final String PUNTO = ".";
    
    /**
	 * Formato de fecha para correo
	 */
	public static final String TIPO_PRINCIPAL_CADENA_01 = "01";
	
	/**
	 * Formato de fecha para correo
	 */
	public static final String TIPO_PRINCIPAL_CADENA_GE = "GE";

	/**
	 * zona horaria formato es_ES
	 */
	public static final String ES_ES = "es_ES";
	
	/**
	 * zona horaria formato es
	 */
	public static final String ES = "es";

	/**
	 * constante MX
	 */
	public static final String MX = "MX";

	/**
	 * constante clave imagen
	 */
	public static final String CVE_IMAGEN = "cveImagen";

	/**
	 * constante curp
	 */
	public static final String CURP = "curp";

	/**
	 * constante afore
	 */
	public static final String AFORE = "afore";
	
	/**
	 * Parametro con los estauts del agente promotor
	 */
	public static final String PARAMETRO_ESTADO_AGENTE = "T02417";

	/**
	 * constante coma para los splits arreglos
	 */
	public static final String COMA = ",";

	/**
	 * constante utf8
	 */
	public static final String UTF_8 = "UTF-8";

	/**
	 * clave de parametro homologado
	 */
	public static final String CARACTER_HOMOLOGADO = "P02100";
	
	/**
	 * Formato de fecha para correo
	 */
	public static final String FORMATO_FECHA = "yyMMddhhmmssSSSS";
	/**
	 * Parametro con contenido para mensaje
	 */
	public static final String PARAMETRO_MENSAJE = "T02416";
	/**
	 * parametro para lista de roles
	 */
	public static final String PARAMETRO_ROLES = "T02418";
	/**
	 * Parametro para Codigos
	 */
	public static final String PARAMETRO_CODIGO = "T02419";
	/**
	 * Parametro para limite de intentos
	 */
	public static final String PARAMETRO_LIMITE_INTENTOS = "T02424";
	
	/**
	 * Parametro para tipos de solicitantes
	 */
	public static final String PARAMETRO_TIPO_SOLICITANTE = "T02430";
	
	/**
	 * Parametro para tipos de afiliacion
	 */
	public static final String PARAMETRO_TIPO_AFILIACION = "P02556";
	
	/**
	 * Parametro para tipos de afiliacion
	 */
	public static final String PARAMETRO_AFORES_CONSULTA_SALDO = "T02432";
	
	/**
	 * Parametro para tipos de afiliacion
	 */
	public static final String PARAMETRO_AFORES_CONSULTA_EXTRA = "T02454";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_REDIRECCION = "T02436";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_ACCESO_AFORES = "P02028";
	
	/**
	 * url de la pagina de plataforma
	 */
	public static final String PARAMETRO_URL_PLATAFORMA = "P02575";
	
	/**
	 * Descripcion de parametro para url de pagina plataforma
	 */
	public static final String PARAMETRO_CH_CORREO = "Uri Pulssar";
	
	/**
	 * CLAVE PARAMETRO SECUNDARIO
	 */
	public static final String SALDOS_ISSSTE = "SaldoIssste";
	
	/**
	 * Afores consulta saldos issste
	 */
	public static final String CLAVE_AFORES_SALDOS_IMSS = "saldosPreliminares";
	
	/**
	 * Afores consulta saldos issste
	 */
	public static final String CLAVE_AFORES_SALDOS_ISSSTE = "saldosPrevioIssste";
	
	/**
	 * afiliacion de imss
	 */
	public static final String TIPO_AFILIACION_IMSS = "IMSS";
	
	/**
	 * afiliacion de issste
	 */
	public static final String TIPO_AFILIACION_ISSSTE = "ISSSTE";
	
	/**
	 * LOGO ACCESAR
	 */
	public static final String LOGO_ACCESAR = "logo_accesar";
	
	/**
	 * Parametro para las afores de paperless
	 */
	public static final String PARAMETRO_AFORES_PAPERLESS = "P02010";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_URI_IE = "T00056";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_AMBIENTE_BANAMEX_COMPARADOR = "P02016";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_AMBIENTE_PEIS_AUTENTICA_INE = "P02016";
	
	/**
	 * Parametro Valida Coppel
	 */
	public static final String PARAMETRO_VALIDA_COPPEL = "P02017";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_ROLES_COMPARADOR_BANAMEX = "P02018";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String PARAMETRO_ROLES_RELACION_PROCESAR_COMPARADOR_BANAMEX = "T00062";
	
	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String CHPARAMETRO_IE_URI = "URI";
	

	/**
	 * PARAMETRO REDIRECCIONAMIENTO
	 */
	public static final String CHPARAMETRO_IE_CLSID = "CLSID";
	
	/**
	 * Tipo de afiliacion ISSSTE
	 */
	public static final String AFILIACION_ISSSTE = "4,5";
	
	/**
	 * Dato SamlResponse
	 */
	public static final String PARAMETRO_SAMLRESPONSE = "SAMLResponse";
	
	/**
	 * Cadena separacion buffer
	 */
	public static final String CADENA_SEPARACION_A552 = "A552Buf";
	
	/**
	 * Clave usuario banamex
	 */
	public static final String CLAVE_USUARIO_BANAMEX = "userBanamex";
	
	/**
	 * Clave rol banamex
	 */
	public static final String ROL_USUARIO_BANAMEX = "rolBanamex";
	
	/**
	 * USUARIO COMPARADOR RESPONSE
	 */
	public static final String USUARIO_COMPARADOR_RESPONSE = "usuarioComparador";
	
	/**
	 * valores afiliacion de issste
	 */
	public static final List<String> VALOR_AFILIACION_ISSSTE = new ArrayList<>();
	
	/**
	 * valores afiliacion de imss
	 */
	public static final List<String> VALOR_AFILIACION_IMSS = new ArrayList<>();
	
	/**
	 * roles del comparador banamex
	 */
	public static final List<String> ROLES_COMPARADOR_BANAMEX = new ArrayList<>();
	
	   /**
     * Estructura de validacion de caracteres
     */
    public static final String EXP_REGULAR_VALIDA_CARACTER_BLANCO = "^[a-zA-Z0-9\\s]*$";
    
    /**
	 * EJECUCION DE JAVA LAUNCHER
	 */
	public static final String PARAMETRO_EJECUCION_JAVA_LAUNCHER = "P02019";
	
	/**
	 * VALOR CH_PARAMETRO LAUNCHER JAVA
	 */
	public static final String CH_FLAG_LAUNCHER = "FLAGLAUNCH";
	
	/**
	 * Opcion de expediente movil
	 */
	public static final String PARAMETRO_OPCION_EXPEDIENTE_MOVIL = "P02026";
	
	/**
	 * CH_PARAMETRO opcion expediente movil
	 */
	public static final String CH_PARAMETRO_EXPEDIENTE_MOVIL = "AFOMOVIL";
	
	/**
	 * URL PORTAL ACCESAR
	 */
	public static final String URL_ACCESAR_CLAVE_AFORE = "https://www.tramitesar.com/pulssar/{contextoAfore}public/bienvenido.do";
	
	/**
	 * Descripcion de parametro para parametro de aviso de privacidad
	 */
	public static final String PARAMETRO_AVISO_PRIVACIDAD = "T00080"; 
	
	/**
	 * Parametro para tipos de solicitantes
	 */
	public static final String PARAMETRO_AUTENTICACION_INE = "P02030";
	
	/**
	 * Descripcion de parametro para parametro de aviso de privacidad
	 */
	public static final String URL_ACCESAR_AVISO_PRIVACIDAD = "/private/avisoPrivacidad.do";
	
	/**
	 * Parametro para tipos de afiliacion
	 */
	public static final String VALOR_SALDOS_PREVIOS_IMSS = "saldosPrevioImss";
	
	/**
	 * Parametro que indica cuando debe ocultarse boton editar
	 */
	public static final String PARAMETRO_OCULTAR_BOTON_EDITAR = "P02033";
	
	/**
	 * parametro de estatus enrolamiento
	 */
	public static final String PARAMETRO_ENROLAMIENTO_NO_PERMANENTE = "P02057";
	
	/**
	 * Parametro para las afores de prospectos
	 */
	public static final String PARAMETRO_AFORES_PROSPECTOS = "P02061";
	
	/**
	 * Valores static
	 */
	static {
		VALOR_AFILIACION_IMSS.addAll(Arrays.asList("2", "10"));
		VALOR_AFILIACION_ISSSTE.addAll(Arrays.asList("4", "5"));
		
		ROLES_COMPARADOR_BANAMEX.addAll(Arrays.asList("10", "11", "12", "14", "15", "17"));
	}
}
