package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * clase de constantes para la creacion, cambio, recupereacion y activacion de
 * cuenta del usuario
 * 
 * @author esolanor
 * @version 1.0
 * @since
 */
public class ActivacionConstants {

	/**
	 * constante BigDecimal uno
	 */
	public static final BigDecimal INT_UNO = new BigDecimal("1");

	/**
	 * constante UNO
	 */
	public static final int CERO = 0;

	/**
	 * constante UNO
	 */
	public static final int UNO = 1;

	/**
	 * constante DOS
	 */
	public static final int DOS = 2;

	/**
	 * constante TRES
	 */
	public static final int TRES = 3;

	/**
	 * constante cuatro
	 */
	public static final int CUATRO = 4;

	/**
	 * constante CINCO
	 */
	public static final int CINCO = 5;

	/**
	 * constante SEIS
	 */
	public static final int SEIS = 6;

	/**
	 * constante SIETE
	 */
	public static final int SIETE = 7;

	/**
	 * constante OCHO
	 */
	public static final int OCHO = 8;

	/**
	 * constante NUEVE
	 */
	public static final int NUEVE = 9;

	/**
	 * constante DIEZ
	 */
	public static final int DIEZ = 10;

	/**
	 * constante ONCE
	 */
	public static final int ONCE = 11;

	/**
	 * constante DOCE
	 */
	public static final int DOCE = 12;

	/**
	 * constante TRECE
	 */
	public static final int TRECE = 13;

	/**
	 * constante CATORCE
	 */
	public static final int CATORCE = 14;

	/**
	 * constante QUINCE
	 */
	public static final int QUINCE = 15;

	/**
	 * constante DIECISEIS
	 */
	public static final int DIECISEIS = 16;

	/**
	 * DIECISIETE
	 */
	public static final int DIECISIETE = 17;

	/**
	 * constante DIECIOCHO
	 */
	public static final int DIECIOCHO = 18;
	
	/**
	 * constante DIECINUEVE
	 */
	public static final int DIECINUEVE = 19;
	
	/**
	 * constante VEINTE
	 */
	public static final int VEINTE = 20;
	
	/**
	 * constante VEINTEOCHO
	 */
	public static final int VEINTEOCHO = 28;
	
	/**
	 * constante TREINTADOS
	 */
	public static final int TREINTADOS = 32;
	
	/**
	 * constante 52
	 */
	public static final int CINCUENTA_DOS = 52;

	/**
	 * constante 64
	 */
	public static final int SESENTA_CUATRO = 64;
	
	/**
	 * constante 65
	 */
	public static final int SESENTA_CINCO = 65;
	
	/**
	 * constante 80
	 */
	public static final int OCHENTA= 80;
	
	/**
	 * constante 88
	 */
	public static final int OCHENTA_OCHO= 88;
	
	/**
	 * constante A
	 */
	public static final char A = 'a';
	
	/**
	 * constante B
	 */
	public static final char B = 'b';
	
	/**
	 * constante C
	 */
	public static final char C = 'c';
	
	/**
	 * constante D
	 */
	public static final char D = 'd';
	
	/**
	 * constante E
	 */
	public static final char E = 'e';
	
	/**
	 * constante F
	 */
	public static final char F = 'f';
	
	/**
	 * constante G
	 */
	public static final char G = 'g';

	/**
	 * constante H
	 */
	public static final char H = 'h';
	
	/**
	 * constante Z
	 */
	public static final char Z = 'z';

	/**
	 * constante 1 char
	 */
	public static final char UNO_CH = '1';
	
	/**
	 * constante 2 char
	 */
	public static final char DOS_CH = '2';
	
	/**
	 * constante 3 char
	 */
	public static final char TRES_CH = '3';

	/**
	 * constante 4 char
	 */
	public static final char CUATRO_CH = '4';
	
	/**
	 * constante 5 char
	 */
	public static final char CINCO_CH = '5';
	
	/**
	 * constante 6 char
	 */
	public static final char SEIS_CH = '6';
	
	/**
	 * constante 7 char 
	 */
	public static final char SIETE_CH = '7';
	
	/**
	 * constante 8 char
	 */
	public static final char OCHO_CH = '8';
	
	/**
	 * constante 9 char
	 */
	public static final char NUEVE_CH = '9';
	
	/**
	 * constante 0 char
	 */
	public static final char CERO_CH = '0';

	/**
	 * Formato de fecha para correo
	 */
	public static final String FORMATO_FECHA_CORREO =
		"dd ' de ' MMMM ' del ' yyyy', 'HH':'mm ' hrs.'";
	
	/**
	 * validacion horas
	 */
	public static final String VAL_HORA_EXCESO = "01";
	
	/**
	 * Mensaje para envío código SMS de activación de usuario
	 */
	public static final String MENSAJE_SMS_ACTIVACION_USUARIO = "P02510";
	
	/**
	 * Vigencia del código SMS de activación de usuario
	 */
	public static final String VIGENCIA_CODIGO_ACTIVACION_USUARIO = "P02511";
	
	/**
	 * formato fecha yyyy/MM/dd
	 */
	public static final String FORMATO_FECHA = "yyyy/MM/dd";
	
	/**
	 * constante local zona horaria
	 */
	public static final String LOCALE_ES = "es_ES";
	
	/**
	 * formato fecha con horas
	 */
	public static final String FORMATO_FECHA_HORAS = "yyyy/MM/dd HH:mm";

	/**
	 * Contante de diagonal
	 */
	public static final String CONSTANTE_DIAGONAL = "/";
	
	/**
	 * tipo Servicio 1 alta
	 */
	public static final String TIPO_SERVICIO_1 = "1";
	
	/**
	 * tipo servicio 2 cambio de contrasenia
	 */
	public static final String TIPO_SERVICIO_2 = "2";
	
	/**
	 * tipo servicio 3 recuperacion de contraseña
	 */
	public static final String TIPO_SERVICIO_3 = "3";
	
	/**
	 * MAIL
	 */
	public static final String CORREO = "mail";

	/**
	 * MOBILE
	 */
	public static final String TELEFONO = "mobile";

	/**
	 * clase usuario 
	 */
	public static final String CLASE_USUARIO = "top,person,organizationalPerson,inetOrgPerson,sarPerson";

	/**
	 * URL_GUARDAR
	 */
	public static final String URL_GUARDAR = "uriGuardar";
	

	/**
	 * '/'
	 */
	public static final String DIAGONAL = "/";

	/**
	 * URL_SEGURIDAD_DESACTIVAR
	 */
	public static final String URL_SEGURIDAD_DESACTIVAR = "uriConsultaUsuario";

	/**
	 * ADMIN_USUARIO_CONFIRMACION
	 */
	public static final String ADMIN_USUARIO_CONFIRMACION = "ADMIN_USUARIO_CONFIRMACION";

	/**
	 * ADMIN_USUARIO_RECUPERACION
	 */
	public static final String ADMIN_USUARIO_RECUPERACION = "ADMIN_USUARIO_RECUPERACION";

	/**
	 * ADMIN_USUARIO_CAMBIO
	 */
	public static final String ADMIN_USUARIO_CAMBIO = "ADMIN_USUARIO_CAMBIO";
	
	/**
	 * ADMIN_USUARIO_CANCELADO
	 */
	public static final String ADMIN_USUARIO_CANCELADO = "ADMIN_USUARIO_CANCELADO";
	
	/**
	 * key para map consulta de de telefono afore
	 */
	public static final String TEL_AFORE = "telAfore";

	/**
	 * key para map consulta de url afore
	 */
	public static final String URI_AFORE = "urlAfore";

	/**
	 * key para map para consultar afore
	 */
	public static final String AFORE = "afore";
	
	/**
	 * identificador para el mapa en consulta de usuario esar
	 */
	public static final String NOMBRE_COMPLETO = "nombreCompleto";

	/**
	 * constante 1 nueva cuenta no activa
	 */
	public static final String CUENTA_USUARIO_ACTIVA = "NUEVO_NO_ACTIVO";

	/**
	 * constante 2 cambio de contraseña
	 */
	public static final String CUENTA_CAMBIO_ACTIVA = "CAMBIO_NO_ACTIVO";
	
	/**
	 * constante 3 recupera de contraseña
	 */
	public static final String CUENTA_RECUPERA_ACTIVA = "RECUPERA_NO_ACTIVO";
	
	/**
	 * identificador CURP para el mapa validacion de tipo servicio crear cuenta
	 */
	public static final String MAP_CURP = "curp";

	/**
	 * identificador TIPOSERVICIO para el mapa validacion de tipo servicio crear cuenta
	 */
	public static final String MAP_TIPO_SERVICIO = "tiposervicio";
	
	/**
	 * identificador CORREO para el mapa validacion de tipo servicio crear cuenta
	 */
	public static final String MAP_CORREO = "correo";
	
	/**
	 * Servicio usuario a invocar
	 */
	public static final String SERVICIO_USUARIO = "validar/";
	
	/**
	 * Servicio catalogo a invocar
	 */
	public static final String SERVICIO_CATALOGO = "catalogo/";
	
	/**
	 * Metodo del servicio
	 */
	public static final String METODO_VALIDA_CURP = "cambioCurp/";
	
	/**
	 * Metodo del servicio
	 */
	public static final String METODO_OBTIENE_DATOS = "datosCurp/";
	
	/**
	 * Metodo del servicio
	 */
	public static final String METODO_CATALOGO_RECHAZO = "rechazo";
	
	/**
	 * Metodo del servicio
	 */
	public static final String METODO_VALIDA_DATOS_USUARIO = "datosUsuario";

	/**
	 * Flag para validacion de constancia paso 1
	 */
	public static final int VALIDACION_DATOS_CONSTANCIA_1 = 1;

	/**
	 * Flag para validacion de constancia paso 2
	 */
	public static final int VALIDACION_DATOS_CONSTANCIA_2 = 2;
	
	/**
	 * Tipo de registro 1
	 */
	public static final int REGISTRO_PRINCIPAL = 1;
	
	/**
	 * Tipo de registro 1
	 */
	public static final int REGISTRO_SECUNDARIO = 2;
	
	/**
	 * Tipo de registro 1
	 */
	public static final int CODIGO_CONFIRMACION = 3;
	
	/**
	 * Constante que define la expresion regular para CURP
	 */
	public static final String ER_CURP = "^[a-zA-Z]{4}[0-9]{6}[a-zA-Z]{6}[0-9]{2}$";
	
	/**
	 * Exprsion para validar el telfono
	 */
	public static final String FORMAT_TEL="[0-9]{10}";
	
	/**
	 * Exprsion para validar el telfono
	 */
	public static final String FORMAT_CORREO="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
	
	/**
	 * Expresion regular que valida nombre y apellidos con acentos y la letra
	 */
	public static final String ER_NOMBRE_APELLIDOS = "^[a-zA-Z\\s\\u00C1\\u00E1\\u00C9\\u00E9\\u00CD\\u00ED\\u00D3\\u00F3\\u00DA\\u00FA\\u00DC\\u00FC\\u00D1\\u00F1\\.]{0,40}$";

	/**
	 * Formato para el contraseña
	 */
	public static final String FORMATO_NSS = "^\\d{11}$+";
	
	/**
	 * Expresion regular que valida el codigo postal
	 */
	public static final String ER_CODIGO_POSTAL = "^[0-9]{1,5}$";

	/**
	 * es 
	 */
	public static final String ES = "es_ES";
	
	/**
	 * Titulo Generico
	 */
	public static final String TITULO_GENERICO = "Tu solicitud no fue aceptada";
	
	/**
	 * Mensaje Generico
	 */
	public static final String MENSAJE_GENERICO = "Por el momento no es posible validar tu solicitud. Por favor, inténtalo más tarde.";
	
	/**
	 * Metodo del servicio
	 */
	public static final String METODO_PASS_ACTUAL = "/password?password=";
	
	/**
	 * Metodo del servicio
	 */
	public static final String METODO_PASS_NUEVO = "&passwordNuevo=";
	
	/**
	 * Contraseña incorrecta
	 */
	public static final String ERROR_HTTP_CLIENT = "Contraseña no coincide";
	
	/**
	 * link para la activacion del usuario
	 */
	public static final String ACTIVACION_USUARIO = "activacionusuario.do?key=";
	
	/**
	 * link para la recuperacion del usuario
	 */
	public static final String ACTIVACION_CAMBIO_CONTRASENIA = "cambiocontrasena.do?key=";
	
	/**
	 * link para cambio de contaseña
	 */
	public static final String ACTIVACION_RECUPERA_CONTRASENIA = "recuperacontrasena.do?key=";
	
	/**
	 * URL_SEGURIDAD_CAMBIO
	 */
	public static final String METODO_CAMBIO_CONTRASENIA = "/password?username=";
	
	/**
	 * identificador en map para obtener parametro del properties path actulizar contrasenia
	 */
	public static final String PARAM_CONTRASENIA = "&password=";
	
	/**
	 * unicode transormation format
	 */
	public static final String UTF_8 = "UTF-8";
	
	/**
	 * unicode transormation format
	 */
	public static final String ISO88591 = "ISO-8859-1";
	
	/**
	 * Matche de digitos
	 */
	public static final String DIGITO_CONTRASENIA = "^.*\\d.*$";

	/**
	 * constante para validar dominios
	 */
	public static final String ARROBA = "@";

	/**
	 * constante para validar diminio 
	 */
	public static final String PUNTO_DOMINIO = ".";

	/**
	 * consnte AES
	 */
	public static final String AES = "AES";

	/**
	 * constante punto para separar cadenas
	 */
	public static final String PUNTO = " ";

	/**
	 * constante coma para separar cadenas
	 */
	public static final String COMA = ",";

	/**
	 * constante es
	 */
	public static final String ES_SIMPLE = "es";

	/**
	 * constante mx
	 */
	public static final String MX = "MX";

	/**
	 * tipo encriptacion
	 */
	public static final String SHA = "SHA";

	/**
	 * constante cero String
	 */
	public static final Object CERO_ST = "0";

	/**
	 * constante codigo activacion formato 
	 */
	public static final String FORMATO_CODIGO_ACTIVACION = "yyddSS";
	
	/**
	 * Parametro de dominio no valido
	 */
	public static final String CLAVE_PROCESAR = "999";
	
	/**
	 * Clave tipo solicitante titular
	 */
	public static final String CV_TIPO_SOLICITANTE_TITULAR = "01";
	
	/**
	 * '_'
	 */
	public static final String GUION_BAJO = "_";
	
	/**
	 * Respuesta sin huellas
	 */
	public static final String RESPUESTA_SIN_HUELLAS = "SHuellas";
	
	/**
	 * Resultado COPPEL
	 */
	public static final String RESPUESTA_RESULTADO_COPPEL = "resultado";
	
	/**
	 * Respuesta pendiente huellas
	 */
	public static final String RESPUESTA_PENDIENTE = "Pending";
	
	
	/**
	 * Bandera ISSSTE
	 */
	public static final String BANDERA_ISSSTE = "banderaIssste";
	
	/**
	 * Respuesta finaliza huellas
	 */
	public static final String RESPUESTA_FINALIZA = "FinalizaHuellas";
	
	
	/**
	 * Constante uno
	 */
	public static final Integer UNO_ACTIVO=1;
	
	
	/**
	 * Constante que detenermina un caracter por defecto.
	 */
	public static final Character MASCARA_POR_DEFECTO = '*';
	
	
	/**
	 * Constante activo
	 */
	public static final String ACTIVO= "ACTIVO";
	
	/**
	 * Constante inactivo
	 */
	public static final Integer DOS_INACTIVO=2;
	
	/**
	 * Constante inactivo
	 */
	public static final String INACTIVO= "INACTIVO";
	
	/**
	 * Constante transitorio igual 3
	 */
	public static final Integer TRES_TRANSITORIO=3;
	
	/**
	 * Constante transitorio
	 */
	public static final String TRANSITORIO= "TRANSITORIO";
	
	/**
	 * Constante cancelado
	 */
	public static final Integer CERO_CANCELADO=4;
	
	/**
	 * Constante cancelado
	 */
	public static final String CANCELADO="CANCELADO";
	
	
	/**
	 * Constante pagado
	 */
	public static final Integer DOS_PAGADO=2;
	
	/**
	 * Constante pagado
	 */
	public static final String PAGADO= "PAGADO";
	
	/**
	 * Constante por pagar
	 */
	public static final String POR_PAGAR="POR PAGAR";
	
	/**
	 * Constante pendiente
	 */
	public static final String PENDIENTE="PENDIENTE";
	
		
	/**
	 * Respuesta 01
	 */
   public static final String RESULTADO_RESPUESTA_01="01";
	
	/**
	 * Constante Respuesta  error=02
	 */
	public static final String RESULTADO_RESPUESTA_02="02";
	
	
	/**
	 * Constante Respuesta  error=02
	 */
	public static final int RESULTADO_RESPUESTA_200OK=200;
	
	/**
	 * 	clave Proceso
	 */
	public static final String CLAVE_PROCCESO="0002";
	
	/**
	 * clave tipoOperacion
	 */
	public static final String CLAVE_TIPO_OPERACION="0003";
	
	/**
	 * Codigo diagnostico
	 */
	public static final String CODIGO_DIAGNOSTICO="DM101";
	
	/**
	 * Activo uno
	 */
	public static final String ACTIVO_UNO="1";
	
	/**
	 * Proceso
	 */
	public static final String PROCESO="39";
	
	/**
	 * Tipo Servicio
	 */
	public static final String TIPO_SEVICIO="0004";
	
	/**
	 * CLAVE_IMSS_RETIRO
	 */
	public static final String CLAVE_IMSS_RETIRO="1601";
	
	/**
	 * CLAVE_1_IMSS_DISPOSICION
	 */
	public static final String CLAVE_1_IMSS_DISPOSICION="1501";
	
	/**
	 * CLAVE_2_IMSS_DISPOSICION
	 */
	public static final String CLAVE_2_IMSS_DISPOSICION="1503";
	
	/**
	 * CLAVE_3_IMSS_DISPOSICION
	 */
	public static final String CLAVE_3_IMSS_DISPOSICION="1504";
	
	/**
	 * CLAVE_1_ISSSTE_DISPOSICION
	 */
	public static final String CLAVE_1_ISSSTE_DISPOSICION="1701";
	
	/**
	 * CLAVE_2_ISSSTE_DISPOSICION
	 */
	public static final String CLAVE_2_ISSSTE_DISPOSICION="1702";
	
	/**
	 * CLAVE_3_ISSSTE_DISPOSICION
	 */
	public static final String CLAVE_3_ISSSTE_DISPOSICION="1703";
	
	
	/**
	 * CLAVE_4_ISSSTE_DISPOSICION
	 */
	public static final String CLAVE_4_ISSSTE_DISPOSICION="1801";
	
	
	/**
	 * ACTIVO_IMSS
	 */
	public static final String ACTIVO_IMSS = "activoIMSS";
	
	/**
	 * ACTIVO_ISSSTE
	 */
    public static final String ACTIVO_ISSSTE ="activoIssste";
    
    /**
	 * ACTIVO_ISSSTE decimo transitorio
	 */
    public static final String TIPO_TRAMITE ="tipoTramite";
	
	/**
	 * IMSS
	 */
	public static final String IMSS = "imss";
	
	/**
	 * ERROR
	 */
	public static final String ERROR = "error";
	
	/**
	 * TIPO_AFILIACION_2
	 */
	public static final String TIPO_AFILIACION_2="2";
	
	/**
	 * TIPO_AFILIACION_3
	 */
	public static final String TIPO_AFILIACION_3="3";
	
	/**
	 * TIPO_AFILIACION_4
	 */
	public static final String TIPO_AFILIACION_4="4";
	
	/**
	 * TIPO_AFILIACION_5
	 */
	public static final String TIPO_AFILIACION_5="5";
	
	/**
	 * FOLIO
	 */
	public static final String FOLIO="folio";
	
	
	
	/**
	 * Constante YYYY/MM/DD
	 */
	public static final String FORMATO_YYYY_MM_DD_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	
	
	
	
	/**
	 * Constante YYYY/MM/DD
	 */
	public static final String FORMATO_YYYYMMDDHH_MM_SS = "ddMMyyyy HH:mm:ss";
	
	
	/**
	 * NOMBRE_EXCEL
	 */
	public static final String NOMBRE_EXCEL = "CONS_ACCESAR_";
	
	
	
	
	/**
	 * FORMATO_EXCEL
	 */
	public static final String FORMATO_EXCEL = ".xlsx";
	
	
	
	/**
	 * Renglon del jasper
	 */
	public static final String COLOR_AZUL = "#E0F0F5";
	
	
	/**
	 * Renglon del jasper
	 */
	public static final String COLOR_AMARILLO = "#FFFFDF";
	
	
	/**
	 * Afores
	 */
	public static final String COMBO_AFORES = "afores";
	
	/**
	 * Respuesta
	 */
	public static final String RESPUESTA = "respuesta";
	
	
	/**
	 * Todos
	 */
	public static final String TODOS = "todos";
	
	/**
	 * Lista consulta
	 */
	public static final String LISTA_CONSULTA = "listas";
	
	/**
	 * Lista excel
	 */
	public static final String LISTA_EXCEL = "listasExcel";
	
	
	/**
	 * Session
	 */
	public static final String NOMBRE_EXCEL_SESSION = "nombreExcel";
	
	
	
	/**
	 * APPLICATION_XLSX
	 */
	public static final String APPLICATION_XLSX = "application/xlsx";
	
	
	/**
	 * CONTENT_DISPOSITION
	 */
	public static final String CONTENT_DISPOSITION = "Content-Disposition";
	/**
	 * ATTACHMENT
	 */
	public static final String ATTACHMENT = "attachment; filename=";
	
	
	
	/**
	 * PARAMETRO PLATAFORMA
	 */
	public static final String PARAMETRO_PLATAFORMA = "P02594";
	
	/**
	 * Clave servicio plataforma
	 */
	public static final String CLAVE_SERVICIO = "claveServicioPlataforma";
	
	/**
	 * dato extra clave servicio
	 */
	public static final String EXTRA_CLAVE_SERVICIO = "datoclaveServicioPlataforma";
	
	/**
	 * PARAMETRO DISPOSICION
	 */
	public static final String PARAMETRO_DISPOSICION = "T00024";
	
	/**
	 * Clave sici
	 */
	public static final String CLAVE_SICI = "002";
	
	/**
	 * 40
	 */
	public static final String NUMERO_40 = "40";
	
	/**
	 * Operacion s
	 */
	public static final String OPERACION_S = "S";
	
	/**
	 * Servicio S1
	 */
	public static final String SERVICIO_S1 = "S1";
	
	/**
	 * Proceso S1P2
	 */
	public static final String PROCESO_S1P2 = "S1P2";
	
	/**
	 * Sucursal 1
	 */
	public static final String SUCURSAL = "SUC1";
	
	
	/**
	 * Origen
	 */
	public static final String ORIGEN = "O";
	
	/**
	 * ISSSTE
	 */
	public static final String ISSSTE = "ISSSTE";
	
	
	/**
	 * issste mensaje no tituar
	 */
	public static final String ISSSTE_MSG_NO_TITULAR = "isssteMsgNoTitular";
	
	
	/**
	 * gENERA CUS
	 */
	public static final String SERVICIO_GENERA_CUS = "04";
	
	/**
	 * fECHA
	 */
	public static final String DDMMYYYY = "dd/MM/yyyy";
	
	/**
	 * kkmm
	 */
	public static final String KKMM = "kk:mm";
	
	/**
	 * obtenerDerechoSubcuentaPorIdMatrizDerecho
	 */
	public static final String DERECHO_SUBCUENTA_ID_MATRIZ ="obtenerDerechoSubcuentaPorIdMatrizDerecho";

	/**
	 * retiroPlanPrivado73
	 */
	public static final String RETIRO_PLAN_PRIVADO_73 ="retiroPlanPrivado73";
	
	/**
	 * obtenerPlanPrivadoPorNss
	 */
	public static final String OBTENER_PLAN_PRIVADO_NSS="obtenerPlanPrivadoPorNss";
	
	/**
	 * recaudadoraTv
	 */
	public static final String RECAUDADORATV = "recaudadoraTv";
	
	/**
	 * obtenerRecaudadoraTvPorNrp
	 */
	public static final String OBTENER_RECAUDADORA_NRP ="obtenerRecaudadoraTvPorNrp";
	
	/**
	 * derechoSubcuenta
	 */
	public static final String DERECHO_SUBCUENTA="derechoSubcuenta";
	
	/**
	 * matrizderecho
	 */
	public static final String MATRIZ_DERECHO = "matrizderecho";
	
	/**
	 * listaSubCuentas
	 */
	public static final String LISTA_SUBCUENTAS ="listaSubCuentas";
	
	/**
	 * retiroPlanPrivado97
	 */
	public static final String  RETIRO_PLAN_PRIVADO_97 ="retiroPlanPrivado97";
	
	/**
	 * PLAN_PRIVADO_ACTUARIO_NUM_PLAN
	 */
	public static final String PLAN_PRIVADO_ACTUARIO_NUM_PLAN="obtenerPlanPrivadoPorActuarioYNumeroPlan";
	
	/**
	 *  retiroPlanActuario
	 */
	public static final String RETIRO_PLAN_ACTUARIO  ="retiroPlanActuario";
	
	
	/**
	 * PARAMETRO DISPOSICION
	 */
	public static final String PARAMETRO_REGIMEN_ISSSTE = "T00064";
	
	/**
	 * T00065
	 */
	public static final String PARAMETRO_COMBINACIONES_REG_SOLICITANTE = "T00065";
	
	
	/**
	 * formularioNoCargado
	 */
	public static final String FORMULARIO_NO_CARGADO ="formularioNoCargado";
	
	/**
	 * consultaPorNss
	 */
	public static final String CONSULTA_POR_NSS ="consultaPorNss";
	
	/**
	 * TIPO_PROCESO_4000
	 */
	public static final String TIPO_PROCESO_4000 = "4000";
	
	/**
	 * TIPO_PROCESO_9R01
	 */
	public static final String TIPO_PROCESO_9R01 = "9R01";
	
	/**
	 * TIPO_PROCESO_9501
	 */
	public static final String TIPO_PROCESO_9501 = "9501";
	
	
	/**
	 * TIPO_PROCESO_0000
	 */
	public static final String TIPO_PROCESO_0000 = "0000";
	
	/**
	 * Lista de subcuentas issste
	 */
	public static final List<String> SUBCUENTAS_ISSSTE_RCV = Arrays.asList("15",  "22",  "25", "27", "28");
	
	
	/**
	 * Lista de subcuentas issste
	 */
	public static final List<String> SUBCUENTAS_ISSSTE_VIVIENDA = Arrays.asList("16", "24");
	
	/**
	 * subcuenta 15
	 */
	public static final String SUBCUENTA_15 = "15";
	
	
	/**
	 * subcuenta 22
	 */
	public static final String SUBCUENTA_22 = "22";
	
	
	/**
	 * subcuenta 25
	 */
	public static final String SUBCUENTA_25 = "25";
	
	
	/**
	 * SUBCUENTA_275
	 */
	public static final String SUBCUENTA_27 = "27";
	
	
	/**
	 * SUBCUENTA_28
	 */
	public static final String SUBCUENTA_28 = "28";
	
	
	/**
	 * SUBCUENTA_16
	 */
	public static final String SUBCUENTA_16 = "16";
	
	
	/**
	 * SUBCUENTA_24
	 */
	public static final String SUBCUENTA_24 = "24";
	
	
	/**
	 * pUNTO DIAGONAL
	 */
	public static final String PUNTO_DIAGONAL = "\\.";
	
	/**
	 * Valor aivs
	 */
	public static final String VALOR_AIVS_VIVIENDA = "06";
	
	/**
	 * Sin precio accion
	 */
	public static final String SIN_PRECIO_ACCION = "SINPRECIOACCION";
	
	
	
	/**
	 * Servicio S1
	 */
	public static final String SERVICIO_DISPOSICION_ISSTE_S14 = "S14";
	
	/**
	 * Proceso S1P1
	 */
	public static final String PROCESO_DISPOSICION_ISSTES14P1 = "S14P1";
	
	
	/**
	 * Proceso S1P2
	 */
	public static final String PROCESO_DISPOSICION_ISSTES14P2 = "S14P2";
	
	
	/**
	 * Proceso S1P3
	 */
	public static final String PROCESO_DISPOSICION_ISSTES14P3 = "S14P3";
	
	
	
	/**
	 * Proceso S1P4
	 */
	public static final String PROCESO_DISPOSICION_ISSTES14P4 = "S14P4";
	
	/**
	 * Guion resta
	 */
	public static final String GUION_RESTA = "-";
	
	/**
	 * rEGIMEN RO
	 */
	public static final String REGIMEN_RO = "RO";
	
	
	
	/**
	 * rEGIMEN RO
	 */
	public static final String REGIMEN_DT = "DT";
	
	/**
	 * Siefore
	 */
	public static final String SIEFORE = "sief";
	
	
	/**
	 * pUNTO CHAR
	 */
	public static final char PUNTO_CHAR = '.';
	
	
	/**
	 * pDF DISPOSICION_TOTAL_ISSSTE
	 */
	public static final String DISPOSICION_TOTAL_ISSSTE = "dtissste.pdf";
	
	
	
	/**
	 * nOMBRE DEL PDF
	 */
	public static final String PDF_NOMBRE_ISSSTE = "generaSolicitudBanortePdfSalida.pdf";
	
	
	
	public static final char ESPACIO_CHAR = ' ';
	
	
	/**
	 * MARCAS_VIVIENDA_IMSS
	 */
	public static final String MARCAS_VIVIENDA_IMSS ="marcasviviendaImss";
	
	/**
	 * estatus
	 */
	public static final String ESTATUS = "estatus";
	
	
	/**
	 * Lista de subcuentas IMSS
	 */
	public static final List<String> SUBCUENTAS_IMSS_RCV = Arrays.asList("01",  "02",  "03", "08");
	
	
	/**
	 * Lista de subcuentas IMSS
	 */
	public static final List<String> SUBCUENTAS_IMSS_VIVIENDA = Arrays.asList("04", "09","07");

	/**
	 * MARCA_VIVIENDA_IMSS_4000
	 */
	public static final String MARCA_VIVIENDA_IMSS_4000  ="4000";
	
	/**
	 * MARCA_VIVIENDA_IMSS_4100
	 */
	public static final String MARCA_VIVIENDA_IMSS_4100  ="4100";
	
	/**
	 * MARCA_VIVIENDA_IMSS_502
	 */
	public static final String MARCA_VIVIENDA_IMSS_502="502";
	
	
	/**
	 * MARCA_VIVIENDA_IMSS_9C01
	 */
	public static final String MARCA_VIVIENDA_IMSS_9C01="9C01";
	
	/**
	 * MARCA_VIVIENDA_IMSS_9C02
	 */
	public static final String MARCA_VIVIENDA_IMSS_9C02="9C02";
	
	/**
	 * 
	 */
	public static final String MARCA_VIVIENDA_IMSS_9M01="9M01";
	
	/**
	 * MARCA_VIVIENDA_IMSS_9M01
	 */
	public static final String MARCA_VIVIENDA_IMSS_9101="9101";
	
	
	
	/**
	 * MARCA_VIVIENDA_IMSS_9H01
	 */
	public static final String MARCA_VIVIENDA_IMSS_9H01="9H01";
	
	/**
	 * SUBCUENTA_IMSS_VIV_04
	 */
	public static final String SUBCUENTA_IMSS_VIV_04 = "04";
	
	/**
	 * SUBCUENTA_IMSS_VIV_09
	 */
	public static final String SUBCUENTA_IMSS_VIV_09 = "09";
	
	
	/**
	 * SUBCUENTA_IMSS_VIV_07
	 */
	public static final String SUBCUENTA_IMSS_VIV_07 = "07";
	
	
	/**
	 * SUBCUENTA_IMSS_RCV_01
	 */
	public static final String SUBCUENTA_IMSS_RCV_01 ="01";
	
	/**
	 * SUBCUENTA_IMSS_RCV_02
	 */
	public static final String SUBCUENTA_IMSS_RCV_02 ="02";
	
	/**
	 * SUBCUENTA_IMSS_RCV_03
	 */
	public static final String SUBCUENTA_IMSS_RCV_03 ="03";
	
	/**
	 * SUBCUENTA_IMSS_RCV_08
	 */
	public static final String SUBCUENTA_IMSS_RCV_08 ="08";
	
	/**
	 * 
	 * Resultado operacion
	 */
	public static final String RESULTADO_OPERACION_01 = "01";
	
	
	/**
	 * 
	 * Resultado operacion
	 */
	public static final String RESULTADO_OPERACION_02 = "02";
	
	
	/**
	 * 
	 * Resultado operacion
	 */
	public static final String RESULTADO_OPERACION_03 = "03";
	
	
	/**
	 * 
	 * DIAGNOSTICO_500
	 */
	public static final String DIAGNOSTICO_500 = "500";
	
	
	/**
	 * 
	 * DIAGNOSTICO_500
	 */
	public static final String DIAGNOSTICO_030 = "030";
	
	
	/**
	 * Id servicio disposicion
	 */
	public static final Long ID_SERVICIO_DISPOSICION_ISSSTE = 309L;
	
	
	/**
	 * Id Proceso
	 */
	public static final Long ID_PROCESO_SOLICITUD_OP46 = 365L;
	
	
	/**
	 * Id Proceso
	 */
	public static final Long ID_PROCESO_SOLICITUD_IMSS = 368L;
	
	
	/**
	 * Datos generales ISSSTE
	 */
	public static final String DATOS_GENERALES_ISSSTE = "datosGeneralesDispIssste";
	
	
	/**
	 * RESULTADO_OPERACION_ISSSTE
	 */
	public static final String RESULTADO_OPERACION_ISSSTE = "resultadoOperacion";
	
	
	
	/**
	 * DESCRIPCION_ISSSTE
	 */
	public static final String DESCRIPCION_ISSSTE = "descripcion";
	
	
	/**
	 * ID_SERVICIO
	 */
	public static final String ID_SERVICIO = "idServicio";
	
	
	/**
	 * ID_CLIENTE
	 */
	public static final String ID_CLIENTE = "idCliente";
	
	/**
	 * ID_EBUSINESS
	 */
	public static final String ID_EBUSINESS = "idEbusiness";
	
	/**
	 * marcasVivienda
	 */
	public static final String MARCAS_VIVIENDA="marcasVivienda";
	
	
	/**
	 * Mensaje error
	 */
	public static final String MENSAJE_ERROR = "Tu solicitud no se realizó exitosamente";
	
	/**
	 * IMSS
	 */
	public static final String SERVICIO_S15P4 = "S15P4";
	
	
	/**
	 * Servicio S1
	 */
	public static final String SERVICIO_DISPOSICION_IIMSS_S15 = "S15";
	
	/**
	 * listaViendaImss
	 */
	public static final String LISTA_SUBCUENTAS_VIVIENDA ="listaViendaImss";
	
	
	/**
	 * Proceso S15P1
	 */
	public static final String PROCESO_DISPOSICION_ISSTES15P1 = "S15P1";
	
	
	
	/**
	 * Proceso S15P2
	 */
	public static final String PROCESO_DISPOSICION_ISSTES15P2 = "S15P2";
	
	
	/**
	 * Proceso S15P3
	 */
	public static final String PROCESO_DISPOSICION_ISSTES15P3 = "S15P3";
	
	/**
	 * listaSiefores
	 */
	public static final String LISTA_SIAFORES="listaSiefores";
	
	
	
	
	/**
	 * pDF Banorte
	 */
	public static final String PDF_DISPOSICION_TOTAL_IMSS = "dtimss.pdf";
	
	
	/**
	 * Q
	 */
	public static final String Q_RETIRO = "Q";
	
	/**
	 * 28
	 */
	public static final String TIPO_PRES = "28";
	
	/**
	 * constante rechazo
	 */
	public static final String USUARIO_CIERRE_SESION = "usuario_cierre_sesion";
	
	/**
	 * constante rechazo
	 */
	public static final String USUARIO_ACTUALIZA_SESION = "usuario_actualiza_sesion";
	
	/**
	 * Bandera Apagada para aviso de privacidad
	 */
	public static final Integer AVISO_PRIVACIDAD_INACTIVO = 0;
	
	/**
	 * Bandera Encendida para aviso de privacidad
	 */
	public static final Integer AVISO_PRIVACIDAD_ACTIVO = 1;
	
	/**
	 * SAR92
	 */
	public static final String SAR92 = "sar92";
	
	/**
	 * SARISSSTE
	 */
	public static final String SARISSSTE = "sarissste";
	
	/**
	 * CLAVE_TRASPASO_SAR92
	 */
	public static final String CLAVE_SAR92="0301";
	
	/**
	 * CLAVE_TRASPASO_SARISSSTE
	 */
	public static final String CLAVE_SARISSSTE="0201";
	
	/**
	 * ACTIVO_IMSS
	 */
	public static final String ACTIVO_SAR92 = "activoSar92";
	
	/**
	 * ACTIVO_IMSS
	 */
	public static final String ACTIVO_SARISSSTE = "activoSarIssste";
	
	/**
	 * PARAMETRO DISPOSICION
	 */
	public static final String PARAMETRO_CARGA_MASIVA_AFORES = "T00098";
	
	/**
	 * RUTA ARCHIVOS EXPEDIENTE
	 */
	public static final String PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE = "P02064";
	
	/**
	 * RUTA ARCHIVOS EXPEDIENTE
	 */
	public static final String PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE = "RUTA";
	
	/**
	 * RUTA ARCHIVOS EXPEDIENTE
	 */
	public static final String DATO_RUTA_EXPEDIENTE_AFORE = "{afore}";
	
	/**
	 * RUTA ARCHIVOS EXPEDIENTE
	 */
	public static final String DATO_RUTA_EXPEDIENTE_PROCESO = "{proceso}";
	
	/**
	 * RUTA GUARDADO DE ARCHIVOS
	 */
	public static final String RUTA_GUARDADO_ARCHIVOS = "P02063";
	
	/**
	 * DATOS SESION GENERICOS
	 */
	public static final String PARAMETRO_CLAVE_DATOS_GENERICOS_SESION = "P02067";
	
	/**
	 * RUTA ARCHIVOS EXPEDIENTE
	 */
	public static final String PARAMETRO_DATOS_GENERICOS_SESION = "SESION";
}