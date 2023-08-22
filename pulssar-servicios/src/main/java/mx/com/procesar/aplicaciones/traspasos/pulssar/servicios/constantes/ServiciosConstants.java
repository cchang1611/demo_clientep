package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de constantes para el servicio de registro usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public final class ServiciosConstants {
	
	/**
	 * Servicio de agente
	 */
	public static final String SERVICIO_AGENTE = "agentePromotor/";
	
	/**
	 * Metodo consulta del servicio de agente
	 */
	public static final String METODO_CONSULTA_AGENTE = "consultarAgente";
	
	/**
	 * Metodo para el cambio de contrasenia
	 */
	public static final String RECUPERA_CONTRASENIA_USUARIO = "/password?username=";
	
	/**
	 * Parametro para el cambio de contrasenia
	 */
	public static final String RECUPERA_CONTRASENIA_PASSWORD = "&password=";
	
	/**
	 * Metodo para cambio de contrasenia con password anterior
	 */
	public static final String CAMBIO_PASSWORD_ACTUAL = "/password?password=";
	
	/**
	 * Metodo del servicio
	 */
	public static final String CAMBIO_PASSWORD_NUEVO = "&passwordNuevo=";
	/**
	 * consulta roles
	 */
	public static final String DIAGONAL_ROLES = "/roles";
	
	/**
	 * consulta roles
	 */
	public static final String DIAGONAL_CURP = "/curp/";
	/**
	 * Diagonal Nss
	 */
	public static final String DIAGONAL_NSS = "/nss/";
	
	/**
	 * Id cleinte mensaje
	 */
	public static final int ID_CLIENTE = 35;
	
	/**
	 * id servicio mensjae
	 */
	public static final int ID_SERVICIO = 725;
	
	/**
	 * Id business mensaje
	 */
	public static final int ID_EBUSINESS = 12;
	
	/**
	 * Pais mensaje
	 */
	public static final String PAIS = "MX";
	
	/**
	 * Resultado de la operacion ok
	 */
	public static final String RESULTADO_OK = "01";
	
	/**
	 * Resultado de la operacion no ok
	 */
	public static final String RESULTADO_NOK = "02";
	
	/**
	 * Valor de servicio 00
	 */
	public static final String VALOR_SERVICIO_00 = "00";
	
	/**
	 * Valor de servicio 0
	 */
	public static final String VALOR_SERVICIO_0 = "0";
	
	/**
	 * Texto de sin expediente
	 */
	public static final String TEXTO_PERMANENTE = "PERMANENTE";
	
	/**
	 * Texto de sin expediente
	 */
	public static final String TEXTO_SIN_EXPEDIENTE = "SIN EXPEDIENTE";
	
	/**
	 * Texto de sin enrolamiento
	 */
	public static final String TEXTO_SIN_ENROLAMIENTO = "SIN ENROLAMIENTO";
	
	/**
	 * Texto de no definido
	 */
	public static final String TEXTO_SIN_TIPOIDE = "NO DEFINIDO";
	
	/**
	 * Texto de sin movil
	 */
	public static final String TEXTO_SIN_APP_MOVIL = "NO ACTIVO";
	
	/**
	 * Texto de con movil
	 */
	public static final String TEXTO_CON_APP_MOVIL = "ACTIVO";
	
	/**
	 * Clave de proceso de foto
	 */
	public static final String CLAVES_PROCESO_FOTO = "01,02";
	
	/**
	 * Diagnostivo servicio de saldo no disponible
	 */
	public static final String DIAGNOSTICO_SERVICIO_SALDO = "Servicio de la administradora no disponible";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_OPERACION_CONSULTA = "C";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_OPERACION_SERVICIO = "S";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_SERVICIO_CONSULTA = "C";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_SERVICIO_ENROLAMIENTO = "S8";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_PROCESO_ENROLAMIENTO = "S8P1";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_SERVICIO_IDENTIFICACION = "S9";
	
	/**
	 * Servicio modificacion datos
	 */
	public static final String FOLIO_SERVICIO_MODIFICACION_DATOS = "S4";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_PROCESO_IDENTIFICACION = "S9P1";
	
	/**
	 * Operacion Folio proceso modificacion Datos
	 */
	public static final String FOLIO_PROCESO_MODIFICACION_DATOS = "S4P1";
	
	/**
	 * Operacion Folio proceso IDENTIFICACION MODIFICACION DE DATOS
	 */
	public static final String FOLIO_PROCESO_MDIDENTIFICACION = "S4P2";
	
	/**
	 * Operacion Folio proceso BIOMETRICOS MODIFICACION DE DATOS
	 */
	public static final String FOLIO_PROCESO_MDBIOMETRICO = "S4P3";
	
	/**
	 * Operacion Folio proceso VALIDACION 4 HUELLAS MODIFICACION DE DATOS
	 */
	public static final String FOLIO_PROCESO_MDVERIFICACION = "S4P4";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_SERVICIO_VERIFICACION_4_HUELLAS = "S10";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_SERVICIO_VERIFICACION_1_HUELLA = "S11";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_PROCESO_VERIFICACION_4_HUELLAS = "S10P1";
	
	/**
	 * Operacion consulta folio
	 */
	public static final String FOLIO_PROCESO_VERIFICACION_1_HUELLA = "S11P1";
	
	/**
	 * Servicio CERO PAPEL
	 */
	public static final String FOLIO_SERVICIO_CERO_PAPEL = "S21";
	
	/**
	 * Proceso Servicio cero papel
	 */
	public static final String FOLIO_PROCESO_CERO_PAPEL = "S21P1";
	
	/**
	 * Servicio CERO PAPEL
	 */
	public static final String FOLIO_SERVICIO_AUTENTICACION_INE = "S26";
	
	/**
	 * Proceso Servicio cero papel
	 */
	public static final String FOLIO_PROCESO_AUTENTICACION_INE = "S26P1";
	
	/**
	 * Diagnostivo servicio de saldo no disponible
	 */
	public static final String CREDENCIALES_USUARIO_VALIDO = "Credenciales invalidas para Usuario:";
	
	/**
	 * Diagnostivo servicio de saldo no disponible
	 */
	public static final String CREDENCIALES_USUARIO_VALIDO_PARAMETRO = "seguridad.mensaje.excepcion.configuracion.error.credenciales";
	
	/**
	 * Cadena con claves de tipos de solicitante
	 */
	public static final String CADENA_TIPOS_SOLICITANTES = "02,03,04";
	
	/**
	 * Clave de autenticacion basica
	 */
	public static final String AUTENTICACION_BASICA = "Basic";
	
	/**
	 * Clave de documentos digitalizados
	 */
	public static final String CLAVE_HUELLAS_DIGITALES = "01";
	
	/**
	 * Clave de documentos digitalizados
	 */
	public static final String CLAVE_VERIFICACION_HUELLAS_4 = "04";
	
	/**
	 * Clave de documentos digitalizados
	 */
	public static final String CLAVE_VERIFICACION_HUELLAS_1 = "03";
	
	/**
	 * Clave de documentos digitalizados
	 */
	public static final String CLAVE_DOCUMENTOS_DIGITALIZADOS = "02";
	
	/**
	 * Clave expediente tipo titular
	 */
	public static final String PROCESO_TIPO_SOLICITANTE_TITULAR = "01";
	
	/**
	 * Clave expediente tipo beneficiario
	 */
	public static final String PROCESO_TIPO_SOLICITANTE_BENEFICIARIO = "02";
	
	/**
	 * Clave expediente tipo representante
	 */
	public static final String PROCESO_TIPO_SOLICITANTE_REPRESENTANTE = "04";
	
	/**
	 * Clave expediente tipo Curador
	 */
	public static final String PROCESO_TIPO_SOLICITANTE_CURADOR = "10";
	
	/**
	 * parametro para subDocumentos
	 */
	public static final String PARAMETRO_SUBDOCUMENTOS = "P02559";
	
	/**
	 * Operacion actualiza
	 */
	public static final String FOLIO_SERVICIO_ACTUALIZA = "S";
	
	/**
	 * Operacion actualiza servicio
	 */
	public static final String FOLIO_SERVICIO_ACTUALIZA_SERVICIO = "S4";
	
	/**
	 * Operacion actualiza proceso
	 */
	public static final String FOLIO_SERVICIO_ACTUALIZA_PROCESO = "S4P1";
	
	/**
	 * Operacion actualiza descripcion
	 */
	public static final String FOLIO_SERVICIO_ACTUALIZA_DESCRIPCION = "Modificacion de datos";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_BIOMETRICOS = "Servicio de Biometricos";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_VERIFICACION_HUELLA = "Verificacion de 1 Huella";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_VERIFICACION_HUELLAS = "Verificacion Trabajador 4 Huellas";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_MDVERIFICACION= "Modificacion de Datos Verificacion 4 Huellas";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_IDENTIFICACION = "Servicio de Identificacion";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_MDBIOMETRICOS = "Biometricos Modificacion de Datos";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_SERVICIO_MDIDENTIFICACION = "Identificacion Modificacion de Datos";
	
	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_ACTIVA_CERO_PAPEL = "Activacion Cero Papel";

	/**
	 * Descripcion de operacion
	 */
	public static final String DESCRIPCION_CANCELA_CERO_PAPEL = "Cancelar Cero Papel";
	
	/**
	 * Operacion actualiza descripcion
	 */
	public static final String STATUS_EXPEDIENTE_ENPROCESO = "2";
	
	/**
	 * Operacion actualiza descripcion
	 */
	public static final String STATUS_EXPEDIENTE_PERMANENTE = "5";
	
	/**
	 * Operacion actualiza descripcion
	 */
	public static final String STATUS_SERVICIO_URL = "/estatus/";
	
	/**
	 * Operacion actualiza descripcion
	 */
	public static final Integer FOLIO_TERMINADO = 3;
	
	/**
	 * constante para la clave de proceso del retiro parcial calculo
	 */
	public static final String CLAVE_PROCESO_RETIRO_PARCIAL_CALCULO = "201";	

	/**
	 * constante para rl tipo de operacion del retiro parcial calculo
	 */
	public static final String TIPO_OPERACION_RETIRO_PARCIAL_CALCULO = "20800";	

	/**
	 * constante para rl tipo de operacion del retiro parcial calculo
	 */
	public static final String TIPO_OPERACION_RETIRO_PARCIAL_MATRIMONIO = "20200";	
	
	/**
	 * código de exito de guardar el retiro parcial calculo
	 */
	public static final Integer CODIGO_EXITO_GUARDAR_RETIRO_PARCIAL_CALCULO = 200;
	
	/**
	 * constante del estatus retiro parcial calculo
	 */
	public static final int ESTATUS_RETIRO_PARCIAL_CALCULO = 1;
	
	/**
	 * constante para el usuario modificador
	 */
	public static final String USUARIO_MODIFICADOR = "SOLICITUD_DISPOSICION";
	
	/**
	 * constante para el tipo de retiro A
	 */
	public static final String TIPO_RETIRO_A = "1";
	
	/**
	 * constante para el tipo de retiro B
	 */
	public static final String TIPO_RETIRO_B = "2";

	/**
	 * constante para el valor tipo de retiro A
	 */
	public static final String TIPO_RETIRO_A_VALOR = "A";
	
	/**
	 * constante para el valor tipo de retiro B
	 */
	public static final String TIPO_RETIRO_B_VALOR = "B";
	
	/**
	 * constante para el tipo de mensualidad en 6 meses
	 */
	public static final int MENSUALIDAD_SEIS_MESES_PROPOCIONALES = 1;

	/**
	 * constante para el tipo de mensualidad en 6 meses
	 */
	public static final int MENSUALIDAD_SEIS_MESES_1RO_30_SBC = 2;
	
	/**
	 * constante para el tipo de mensualidad en 2 meses
	 */
	public static final int MENSUALIDAD_DOS_MESES = 3;

	/**
	 * constante para el tipo de mensualidad en 1 mes
	 */
	public static final int MENSUALIDAD_UN_MES = 4;
	
	/**
	 * constante para la clave del derecho de pago
	 */
	public static final int CLAVE_DERECHO_PAGO_CALCULO = 2;
	
	/**
	 * Estatus en incompleto o temporal
	 */
	public static final String EXPEDIENTE_INCOMPLETO_TEMPORAL = "1,2";
	
	/**
	 * Estatus en incompleto o temporal
	 */
	public static final String EXPEDIENTE_TEMPORAL = "0,2";
	
	/**
	 * Clave 06
	 */
	public static final String CLAVE_06 = "06";
	
	/**
	 * Clave 09
	 */
	public static final String CLAVE_09 = "09";
	
	/**
	 * Clave 09
	 */
	public static final String CLAVE_08 = "08";
	
	/**
	 * Clave 81
	 */
	public static final String CLAVE_81 = "81";
	
	/**
	 * Clave 02
	 */
	public static final String CLAVE_02="02";
	
	/**
	 * Clave 01
	 */
	public static final String CLAVE_01="01";
	
	/**
	 * Jar Biometrico
	 */
	public static final String JAR_BIOMETRICO = "Biometrico";
	
	/**
	 * Palabra Banorte Jar
	 */
	public static final String JAR_BANORTE = "Banorte";
	
	/**
	 * Clase Main Banorte
	 */
	public static final String CLASE_BANORTE_MAIN = "mx.com.procesar.servicios.institutos.biometricoBanorte.main.BiometricoBanorteMainApplication";
	
	/**
	 * Clase Main
	 */
	public static final String CLASE_MAIN = "mx.com.procesar.aplicaciones.institutos.biometrico.presentacion.grafica.main.BiometricoMain";
	
	/**
	 * parametro motivo
	 */
	public static final String PARAMETRO_MOTIVO = "motivo=";
	
	/**
	 * llave de idEbusiness
	 */
	public static final String HISTORICO_IDEBUSINESS = "29";
	/**
	 * llave de idServicio
	 */
	public static final String HISTORICO_IDSERVICIO = "786";
	/**
	 * llave de idCliente
	 */
	public static final String HISTORICO_IDCLIENTE = "35";
	
	/**
	 * tIPO DE tRABAJADOR
	 */
	public static final String TIPO_HUELLAS_TRABAJADOR = "3";
	
	/**
	 * tIPO DE eMPLEADO
	 */
	public static final String TIPO_HUELLAS_EMPLEADO = "2";
	
	/**
	 * tIPO DE eMPLEADO
	 */
	public static final String BIOMETRICO_FINGER = "Finger";
	
	/**
	 * tIPO DE eMPLEADO
	 */
	public static final String BIOMETRICO_TEN = "Ten";
	
	/**
	 * tIPO DE eMPLEADO
	 */
	public static final String BIOMETRICO_FOUR = "Four";
	
	/**
	 * nombre del archivo jnlp para la web
	 */
	public static final String ARCHIVO_JNLP_WEB = "inline; filename=\"biometricos.jnlp\"";
	
	/**
	 * nombre del archivo jnlp para la web
	 */
	public static final String CONTENT_TYPE_WEB = "application/x-java-jnlp-file";
	
	/**
	 * Encabezado Pragma
	 */
	public static final String ENCABEZADO_WEB_JNLP_PRAGMA = "Pragma";
	
	/**
	 * Encabezado Pragma
	 */
	public static final String ENCABEZADO_WEB_JNLP_VALOR_PRAGMA = "no-cache";
	
	/**
	 * Encabezado Expires
	 */
	public static final String ENCABEZADO_WEB_JNLP_EXPIRES = "Expires";
	
	/**
	 * Encabezado Disposition
	 */
	public static final String ENCABEZADO_WEB_JNLP_DISPOSITION = "Content-disposition";
	
	/**
	 * Replace host url
	 */
	public static final String VALOR_URL_HOST_REPLACE = "{urlHost}";
	
	/**
	 * Replace afore
	 */
	public static final String VALOR_URL_AFORE_REPLACE = "{tAfore}";
	
	/**
	 * Replace jarbio
	 */
	public static final String VALOR_URL_JARBIO_REPLACE = "{JarBio}";
	
	/**
	 * Nombre del archivo txt para recepcion de archivos
	 */
	public static final String NOMBRE_ARCHIVO_TXT_RECEPCION = "procesar.pulssar.txt";
	
	/**
	 * Ruta archivos expediente para recepcion de archivos
	 */
	public static final String RUTA_EXPEDIENTE = "expediente/";
	
	/**
	 * Ruta archivos huellas para recepcion de archivos
	 */
	public static final String RUTA_HUELLA = "huellas/";
	
	/**
	 * HORA LLEGADA CERO
	 */
	public static final String HORA_LLEGADA_CERO = "00:00";
	
	/**
	 * HORA LLEGADA CERO
	 */
	public static final String SUCURSAL_FOLIO_DEFAULT = "SUC";
	
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
	 * Operacion Folio proceso EXPEDIENTE SERVICIO MODIFICACION DE DATOS
	 */
	public static final String FOLIO_PROCESO_MDEXPESERVICIO = "S4P5";
	
	/**
	 * Descripcion para folio de modificacion de datos
	 */
	public static final String DESCRIPCION_FOLIO_MODIFICACION = "Modificacion de Datos P";
	
	/**
	 * Descripcion para folio expediente servicio modificacion de datos
	 */
	public static final String DESCRIPCION_FOLIO_EXPESERVICIO_MODIFICACION = "Expediente de servicio de Modificacion de datos";
	/**
	 * Folio
	 */
	public static final String FOLIO = "folio";
	
	/**
	 * resultado mesa de control
	 */
	public static final String MESA_CONTROL = "MESA CONTROL";
	
	/**
	 * Palabra Zona
	 */
	public static final String ZONA = "ZONA";
	
	/**
	 * CON_INDICADOR_SALDO
	 */
	public static final String CON_INDICADOR_SALDO = "SI";
	
	/**
	 * SIN_INDICADOR_SALDO
	 */
	public static final String SIN_INDICADOR_SALDO = "NO";
	
	/**
	 * parametro para indicador Saldo Icefa
	 */
	public static final String PARAMETRO_INDICADOR_SALDO_ICEFA = "P02580";

	public static final Integer MENSUALIDAD_ULTIMA = 6;
	
	/**
	 * servicio recepcion imagenes
	 */
	public static final String SERVICIO_CONSULTA_RECEPCION_IMAGENES = "recepcionImagenes/consultarRecepcionProceso/";
	
	/**
     * RESPUSTA_532
     */
    public static final String RESPUESTA_532="532";
    
    
    /**
	 * TIEMPO_LLEGADA
	 */
	public static final String TIEMPO_LLEGADA="00:00";
	
    /**
	 * PARAMETRO T00035 RECEPCION DE IMAGNES
	 */
	public static final String T00035="T00035";
	
    /**
	 * COMA
	 */
	public static final String COMA=",";
	
	/**
	 * PUNTO
	 */
	public static final String PUNTO=".";
	
	/**
	 * PUNTO_ESCAPE
	 */
	public static final String PUNTO_ESCAPE="\\.";
	
	/**
	 * Parametro numero intentos consulta recepcion imagenes
	 */
	public static final String PARAMETRO_INTENTOS_CONSULTA_IMAGENES = "P02005";
	
	/**
	 * Tipo expediente modificacion datos
	 */
	public static final String TIPO_EXPEDIENTE_SERVICIO_MDD = "tipoExpedienteMdd";
	
	/**
	 * Tipo expediente modificacion datos
	 */
	public static final String SERVICIO_ENROLAMIENTO_DOCUMENTO = "6796";	
	
	/**
	 * Parametro para consulta de servicio de modificacion de datos
	 */
	public static final String PARAMETRO_SERVICIO_MODIFICACION = "P00008";
	
	/**
	 * Parametro para consulta de servicio de modificacion de datos
	 */
	public static final String PARAMETRO_CLAVE_PASO_EXPE_SERVICIO = "P00012";
	
	/**
	 * clave afore coppel
	 */
	public static final String CLAVE_AFORE_COPPEL = "568";
	
	/**
	 * Clave afore banorte
	 */
	public static final String CLAVE_AFORE_BANORTE = "530";
	
	/**
	 * Paso expedinete de identificacion en modificacion de datos
	 */
	public static final String PARAMETRO_PASO_IDENTIFICACION_MDD = "P02009";
	
	/**
	 * log nacionalidades
	 */
	public static final String LOG_NACIONALIDADES = "Se presento un problema al consulta la informacion de nacionalidad";
	
	/**
	 * Homolagicion de ID nulo para ID_SOLICITUD de reportes masivos
	 */
	public static final Long SOLICITUD_ID_NULO = Long.valueOf(-1);
	
	/**
	 * Constante para cabecera Accept en peticiones.
	 */
	public static final String HEADER_ACCEPT = "Accept";
	
	/**
	 * Constante para identificar el atributo usuarioLogueado.
	 */
	public static final String USUARIO_LOGUEADO = "usuarioLogueado";
	
	/**
	 * Constante para identificar el atributo fechaInicial.
	 */
	public static final String FECHA_INICIAL = "fechaInicial";

	/**
	 * Constante para identificar el atributo fechaFinal.
	 */
	public static final String FECHA_FINAL = "fechaFinal";

	/**
	 * Constante para identificar el atributo nombreReporte.
	 */
	public static final String NOMBRE_REPORTE = "nombreReporte";
	
	/**
	 * Constante para identificar el atributo curp.
	 */
	public static final String CURP = "curp";
	
	/**
	 * Constante para identificar el atributo nss.
	 */
	public static final String NSS = "nss";
	
	/**
	 * Constante para identificar el atributo de idProcesar.
	 */
	public static final String ID_PROCESAR = "idProcesar";
	
	/**
	 * Constante para bandera de catalogo activo
	 */
	public static final int CONST_CATALOGO_ACTIVO = 1;
	
	/**
	 * Estado Recibido de solcitud de reportes masivos 
	 */
	public static final Long SOLICITUD_ESTADO_RECIBIDO = 1L;
	
	/**
	 * Codigo para un dedo o mano amputada
	 */
	public static final String CODIGO_XX = "XX";
	
	/**
	 * Codigo para un dedo o mano lesionada
	 */
	public static final String CODIGO_UP = "UP";
	
	/**
	 * Codigo de excepcion acuse
	 */
	public static final String MENSAJE_EXCEPCION_ACUSE = "E01";
	
	/**
	 * Parametro afore Excepcion
	 */
	public static final String PARAMETRO_AFORE_EXCEPCION = "P02012";
	
	/**
	 * Tramite biometrico tablet
	 */
	public static final String TRAMITE_BIOMETRICO_TABLET = "67";
	
	/**
	 * Tramite no presenciañ
	 */
	public static final String TRAMITE_NO_PRESENCIAL = "N";
	
	/**
	 * Tramite no presenciañ
	 */
	public static final String URI_REDIREC_BANAMEX = "URI552";
	
	/**
	 * Tramite no presenciañ
	 */
	public static final String URI_REDIREC_PEIS = "URI578";
	
	/**
	 * Usuario Modificador para proceso de Reportes Masivos  
	 */
	public static final String STR_USUARIO_MODIFICADOR_MASIVOS = "PLATAFORMA-OPERATIVA-MASIVOS";
	
	/**
	 * Datos firma
	 */
	public static final List<String> DATOS_FIRMA = new ArrayList<>();
	
	static {
		DATOS_FIRMA.add("40");
		DATOS_FIRMA.add("52");
		DATOS_FIRMA.add("10");
	}
	
	/**
	 * parametro bandera para incluir o no campos digitalizacion coppel
	 */
	public static final String PARAMETRO_INCLUYE_CAMPOS_COPPEL_DIGITA = "P02023";
	
	/**
	 * Parametro para validar numero de beneficiarios aceptados
	 */
	public static final String PARAMETRO_NUMERO_BENEFICIARIOS_ACEPTADO = "P02027";
	
	
	/**
	 * FolioService folio Pulssar
	 */
	public static final String ID_FOLIO_PULSSAR = "{idFolioPulssar}";
			
	
	/**
	 * Constante validaExpedienteServiceImpl
	 */
	public static final String FOLIO_PULSSAR = "{foliopulssar}";
	
	
	/**
	 * Tipo Archivo
	 */
	public static final String TIPO_ARCHIVO =  "{tipoArchivo}";
	
	
	/**
	 * Constante consulta parametro
	 */
	public static final String T00077_PEIS =  "T00077";
	
	/**
	 * Constante consulta parametro
	 */
	public static final String AFORE_PEIS =  "578";
	
	/**
	   * Path consultar sesion activa
	   */
	  public static final String URL_CONSULTA_SESION_USUARIO = "session/consultaSesionUsuario";
	  
	  /**
	   * Path consultar sesion activa
	   */
	  public static final String URL_GUARDAR_SESION_USUARIO = "session/guardarSesion";
	

	/**
	 * Clave del regimen RO REGIMEN ORDINARIO (CUENTA INDIVIDUAL)
	 */
	public static final String CLAVE_REGIMEN_RO = "RO";
	
	/**
	 * Clave del regimen DT ARTICULO DECIMO TRANSITORIO
	 */
	public static final String CLAVE_REGIMEN_DT = "DT";
	
	/**
	 * Url filenet
	 */
	public static final String URL_FILENET="serviciorest/consultarexpe";
	
	/**
	 * Consulta Arachivo Biometrico
	 */
	public static final String CONSULTA_ARCHIVO_BIOMETRICO="archivorecibido/consultarArchivoBiometrico/";
	
	/**
	 * Consulta Arachivo Biometrico
	 */
	public static final String CONSULTA_GUARDAR_BITACORA_REIMPRESION="reimpresionDocumentos/guardarBitacoraReimpresion";
	
	/**
	 * Consulta de tramites concluidos
	 */
	public static final String CONSULTA_TRAMITES_CONCLUIDOS="reimpresionDocumentos/tramitesConcluidos";
	
	/**
	 * Servicio parametro
	 */
	public static final String SERVICIO_PARAMETRO="parametro/";
	
	/**
	 * clave
	 */
	public static final String CLAVE = "clave";
	
	/**
	 * clave
	 */
	public static final String CATALOGO = "catalogo/";
	
	/**
	 * servicio que registra tramites concluidos
	 */
	public static final String REGISTRA_TRAMITE_CONCLUIDO = "reimpresionDocumentos/guardarTramiteConcluidoReimpresion";
	
	/**
	 * SERVICIO NOTIFICACION INE
	 */
	public static final String SERVICIO_NOTIFICACION_INE = "notificacionAutenticacionIne";
	
	/**
	 * Path consultar sesion activa
	 */
	public static final String URI_GUARDAR_DETALLE_RESULTADO_AUTENTICA_INE = "autenticacionine/resultadoDetalle";
	
	/**
	 * Path consultar sesion activa
	 */
	public static final String URI_CONSULTA_RESULTADO_AUTENTICA_INE = "autenticacionine/consultar/{curp}";
	
	/**
	 * Path consultar sesion activa
	 */
	public static final String URI_NOTIFICACION_AUTENTICA_INE = "notificacionAutenticacionIne";
	
	/**
	 * Path consultar sesion activa
	 */
	public static final String URI_OBTENER_FOLIO_PROCESAR = "archivorecibido/obtenerFolioProcesarByCurp/";
	
	/**
	 * Path notificion tramites concluidos
	 */
	public static final String NOTIFICACIONES_TRAMITES_CONCLUIDOS = "tramitesConcluidos/notificacionTramitesConcluidos";
	
	/**
	 * Path consultar sesion activa
	 */
	public static final String DIAGONAL = "/";
	
	/**
	 * url para servicio actualizacion de folios
	 */
	public static final String ACTUALIZA_FOLIO = "/servicio";
	
	/**
	 * Parametro para obtener bandera para ocultar boton editar mdd
	 */
	public static final String PARAMETRO_BLOQUEO_BOTON_EDITAR = "P02034";
	
	/**
	 * Path consultar sesion activa
	 */
	public static final String URI_SERVICIO_CONTROL_USUARIOS = "controlUsuarios/";

	/**
	 * url para validar la carga de usuarios
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Jun 6, 2022 
	 */
	public static final String URL_VALIDAR_CARGA_USUARIOS = "validarCargaUsuarios.do";

	/**
	 * guardar vcarga de usuarios 
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Jun 6, 2022 
	 */
	public static final String URL_GUARDAR_CARGA_USUARIOS = "guardarCargaUsuarios.do";
	
	/**
	 * obtener el archivo de los usuarios 
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Jun 6, 2022 
	 */
	public static final String URL_ARCHIVO_USUARIOS = "archivoUsuarios.do";
	
	/**
	 * Path notificion tramites concluidos
	 */
	public static final String TIPO_PROCESO_EXPEDIENTE = "catalogo/tipoProceso/";
	
	/**
	 * consulta expediente
	 */
	public static final String CONSULTA_EXPEDIENTE="visorExpedientesIdentificacionMovil/V2/consultaExpediente";
	
	/**
	 * resultado rechazo
	 */
	public static final String RESULTADO_RECHAZO="02";
	
	/**
	 * dignostico no existen expedientes
	 */
	public static final String DIAGNOSTICO_NO_EXISTEN_EXPEDIENTES="600";
	
	/**
	 * no existen expedientes
	 */
	public static final String MENSAJE_NO_EXISTEN_EXPEDIENTES="No se encontraron resultados para los criterios capturados/seleccionados, por el siguiente motivo: 600 no existe expediente";
	/**
	 * intente mas tarde
	 */
	public static final String MENSAJE_INTENTE_MAS_TARDE="Existe un problema con el servicio, intenta más tarde.";
	
	/**
	 * no se encontraron resultados
	 */
	public static final String MENSAJE_NO_SE_ENCONTRARON_RESULATDOS="No se encontraron resultados para los criterios capturados/seleccionados, por el siguiente motivo: ";
	
	/**
	 * no existen expededientes a mostrar
	 */
	public static final String MENSAJE_NO_EXISTEN_EXPEDIENTES_A_MOSTRAR="No existen expedientes a mostrar.";
	
	/**
	 * fuera de horario de servicio
	 */
	public static final String MENSAJE_SOLICITUD_FUERA_SERVICIO="Solicitud fuera del horario de servicio.";
	
	/**
	 * rechazo
	 */
	public static final String DIAGNOSTICO_RECHAZO="999";
	
	/**
	 * actividad servicio
	 */
	public static final String PARAMETRO_ACTIVIDAD_SERVICIO="P02011";
	
	/**
	 * folio
	 */
	public static final String PARAMETRO_FOLIO="folio";
	
	/**
	 * cero
	 */
	public static final String FUERA_HORARIO_SERVCIO="0";
	
	/**
	 * expedienmte 03
	 */
	public static final String TIPO_SERVICIO_EXPEDIENTE_03="03";
	
	/**
	 * expediente 02
	 */
	public static final String TIPO_SERVICIO_EXPEDIENTE_02="02";
	
	/**
	 * role
	 */
	public static final String PARAMETRO_ROL="role";
	
	/**
	 * operativo procesar
	 */
	public static final String OPERATIVO_PROCESAR="OPERATIVO PROCESAR";
	
	/**
	 * listaImagenes
	 */
	public static final String PARAMETRO_LISTA_IMAGENES="listaImagenesExpedienteServicio";
	
	/**
	 * actividadCarruselUno
	 */
	public static final String PARAMETRO_ACTIVA_CARRUSEL_UNO="activaCarruselUno";
	
	/**
	 * actividad carruisel dos
	 */
	public static final String PARAMETRO_ACTIVA_CARRUSEL_DOS="activaCarruselDos";
	
	/**
	 * listaexpedientes
	 */
	public static final String PARAMETRO_LISTA_EXPEDIENTES="listaExpedientes";
	
	/**
	 * afore
	 */
	public static final String PARAMETRO_AFORE="afore";
	
	/**
	 * curp
	 */
	public static final String PARAMETRO_CURP="curp";
	
	/**
	 * tiposervciio
	 */
	public static final String PARAMETRO_TIPO_SERVICIO="tipoServicio";
	
	/**
	 * bandera error
	 */
	public static final String PARAMETRO_BANDERA_ERROR="banderaError";
	
	/**
	 * error
	 */
	public static final String MENSAJE_ERROR="Error";
	
	/**
	 * respuesta
	 */
	public static final String RESPUESTA="respuesta";
	
	/**
	 * mensaje captura
	 */
	public static final String MENSAJE_CAPTURA="La captura/selección de todos los criterios de búsqueda es obligatoria, favor de validar.";
	
	/**
	 * mensjae curp
	 */
	public static final String MENSAJE_CURP="\"La CURP debe encontrarse a 18 posiciones, favor de validar.";
	
	/**
	 * parametro captura
	 */
	public static final String PARAMETRO_MENSAJE_CAPTUAR="mensajeCaptura";
	
	/**
	 * expediente 01
	 */
	public static final String EXPEDIENTE_01="01";
	
	/**
	 * expediente 77
	 */
	public static final String EXPEDIENTE_77="77";
	
	/**
	 * expediente 78
	 */
	public static final String EXPEDIENTE_78="78";
	
	/**
	 * mayuscula
	 */
	public static final String FORMATO_TIF_MAYUSCULA="TIF";
	
	/**
	 * minuscula
	 */
	public static final String FORMATO_TIF_MINUSCULA="tif";
	
	/**
	 * jpg
	 */
	public static final String FORMATO_JPG="jpg";
	
	/**
	 * banderaAforeDiferente
	 */
	public static final String BANDERA_AFORE_DIFERENTE="banderaAforeDiferente";
	
	/**
	 * amenu.do
	 */
	public static final String AMENU_DO="amenu.do";
	
	/**
	 * consultaPrincipal.do
	 */
	public static final String CONSULTA_PRINCIPAL= "consultaPrincipal.do";
	
	/**
	 * persona
	 */
	public static final String PERSONA= "persona";
	
	/**
	 * persona
	 */
	public static final String EXISTE_PERSONA= "existePersona";
	
	/**
	 * lista afore
	 */
	public static final String LISTA_AFORE= "lstAfore";
	
	/**
	 * lista afore
	 */
	public static final String LISTA_TIPO_EXPEDIENTE= "lstTipoExpediente";
	
	/**
	 * mayuscula
	 */
	public static final String FORMATO_TIFF_MAYUSCULA="TIFF";
	
	/**
	 * minuscula
	 */
	public static final String FORMATO_TIFF_MINUSCULA="tiff";
	
	/**
	 * nombre exediente
	 */
	public static final String NOMBRE_EXPEDIENTE="nombreExpediente";
	
	/**
	 * operativo procesar
	 */
	public static final String CLAVE_OPERATIVO_CORE="18";
	
	/**
	 * role
	 */
	public static final String BANDERA_CLAVE_ROL="banderaClaveRol";
	
	/**
	 * Clave Consulta Consar
	 */
	public static final String CLAVE_CONSAR = "003";

	/**
	 * origen de matrimonio
	 */
	public static final String ORIGEN_MATRIMONIO="matrimonio_imss";
	
	/**
	 * origen de matrimonio
	 */
	public static final String DIGITALIZADOR_MATRIMONIO="07";
	
	/**
	 * ruta de actualizacion de sello
	 */
	public static final String RUTA_ACTUALIZAR_SELLO_UTILIZADO = "actualiza/estatus/folioDactilar";
	
	/**
	 * CNSTATNTE MENSAJE
	 */
	public static final String MENSAJE = "{MENSAJE}";
	
	/**
	 * CONSTANTE PARA CHAVE DE MENSAJE DE RECHAZO PARA MARCAS Y SALDOS
	 */
	public static final String RECHAZO_MARCAS_SALDOS_PEIS = "RP01";
	
	/**
	 * CONSTANTE PARA CHAVE DE MENSAJE DE RECHAZO PARA MARCAS Y SALDOS
	 */
	public static final String RECHAZO_SALDOS_NO_DISPONIBLE_PEIS = "RP02";
}