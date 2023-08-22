/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Clase que contiene las constantes para <b>Administración de Filas y Citas
 * Banamex</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public final class TurnoConstants {
	
	/**
	 * Constructor privado para la clase de coonstntes para la <b>Administración
	 * de Filas y Citas Banamex</b>.
	 */
	private TurnoConstants() {

	}
	
	/**
	 * Constante que represnta la clave de tipo con cita.
	 */
	public static final String TIPO_CON_CITA = "FC";

	/**
	 * Constante que represnta la clave de tipo sin cita.
	 */
	public static final String TIPO_SIN_CITA = "FS";

	/**
	 * Constente que contiene los tipos de citas existentes.
	 */
	public static final ImmutableList<String> TIPO_DE_CITAS_EXISTENTE = ImmutableList.of(TIPO_CON_CITA, TIPO_SIN_CITA);

	/**
	 * Constante que contiene el parametro para el proceso de administración de Trunos.
	 */
	public static final String CLAVE_PARAMETRO_ADMINISTRACION_TURNOS = "T00007";
	
	/**
	 * Constante que contiene el descripcion para la cleve del tiempo de espera para clientes con cita.
	 */
	public static final String DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_CON_CITA = "001";
	
	/**
	 * Constante que contiene el descripcion para la cleve del tiempo de espera para clientes sin cita.
	 */
	public static final String DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_SIN_CITA = "002";
	
	/**
	 * Constante que contiene el descripcion para la cleve del tiempo de olgura para clientes con cita.
	 */
	public static final String DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_CON_CITA_PREAVISO = "003";
	
	/**
	 * Constante que contiene el descripcion para la cleve del tiempo de olgura para clientes sin cita.
	 */
	public static final String DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_SIN_CITA_PREAVISO = "004";
	
	/**
	 * Constante que contiene el descripcion para la cleve del tiempo de olgura para clientes sin cita.
	 */
	public static final String DESCRIPCION_PARAMETRO_SMS = "005";
	
	/**
	 * Clave de del rol para el ejecutivo
	 */
	public static final String CLAVE_ROL_EJECUTIVO = "08";
	
	/**
	 * Clave de del rol para el ejecutivo de atención
	 */
	public static final String CLAVE_ROL_EJECUTIVO_ATENCION = "09";
	
	/**
	 * Clave de del rol para el ejecutivo de unitario
	 */
	public static final String CLAVE_ROL_EJECUTIVO_UNITARIO = "07";
	
	/**
	 * Constente que contiene los roles permetidos para consultar las citas registradas.
	 */
	public static final ImmutableList<String> ROLES_PERMITIDOS_PARA_CONSULTAR_CITAS_REGISTRADAS = ImmutableList.of(CLAVE_ROL_EJECUTIVO, CLAVE_ROL_EJECUTIVO_ATENCION, CLAVE_ROL_EJECUTIVO_UNITARIO);
	
	/**
	 * Indicador para la cadena sin espacios.
	 */
	public static final Boolean CADENA_SIN_ESPACIOS = Boolean.TRUE;
	
	/**
	 * Constante que determina el primer elemento de una colección
	 */
	public static final Integer PRIMER_ELEMENTO = Integer.valueOf(0);
	
	/**
	 * Constate que contiene el usuario administrador para el proceso de Administracion de Turnos.
	 */
	public static final String USUARIO_MODIFICADOR = "ADMONISTRACION_TURNOS";
	
	/**
	 * Constante que representa el estatus inicial (registro de turno).
	 */
	public static final String ESTATUS_ROL_REGISTRADO = "01";
	
	/**
	 * Constante que representa el estatus En Atencion .
	 */
	public static final String ESTATUS_ROL_EN_ATENCION = "02";
	
	/**
	 * Constante que representa el estatus finalizado
	 */
	public static final String ESTATUS_FINALIZADO = "03";
	
	/**
	 * Constante que representa el estatus cancelado
	 */
	public static final String ESTATUS_CANCELADO = "04";
	
	/**
	 * Constante para un cliente con cita.
	 */
	public static final String CON_CITA = "FC";
	
	/**
	 * Constante para un cliente sin cita.
	 */
	public static final String SIN_CITA = "FS";
	
	/**
	 * Constante que contiene le valor de un estatus activo de un usuario pulsar.
	 */
	public static final String USUARIO_PULSAR_ESTATUS_ACTIVO = "01";
	
	/**
	 * Constante que contiene la bandera para no recuperar los usuarios con los roles.
	 */
	public static final Boolean USUARIO_PULSAR_CARGA_SIN_ROLES = Boolean.FALSE;
	
	/**
	 * Cuerpo del mensaje para notificación SMS. 
	 */
	public static final String CURPO_MENSAJE_NOTIFICACION_SMS = "Folio de atencion: %s";
	
	/**
	 * Constante que contine el nombre de la clase de css para registros sin limite de tiempo.
	 */
	public static final String PAGINA_REGISTRO_SIN_LIMITE_TIEMPO_EN_ESPERA = "Text__red";
	
	/**
	 * Constante que contine el nombre de la clase de css para registros con limite de tiempo.
	 */
	public static final String PAGINA_REGISTRO_CON_LIMITE_TIEMPO_EN_ESPERA = "Text__black";
	
	/**
	 * Constante que contine el nombre de la clase de css para registros con limite de tiempo.
	 */
	public static final String PAGINA_REGISTRO_CON_LIMITE_TIEMPO_EN_ESPERA_MAYOR = "Text__Green";
	
	/**
	 * Contiene la url que nos lleva a la siguiente pantalla.
	 */
	public static final String PAGINA_REGISTRO_URL_REFERENCIA = "url_temporal/";

	/**
	 * Valor de estatus uno
	 */
	public static final String ESTATUS_UNO = "1";
	
	/**
	 * Clave para el tipo de servicio para Administración de Servicios.
	 */
	public static final String CLAVE_TIPO_SERVICIO_TURNOS = "ADMON_T";
	
	/**
	 * Constante que contiene la relación del indicador de tipo Cita con la
	 * clave de la Cita.
	 */
	public static final ImmutableMap<Integer, String> RELACION_INDICADOR_TIPO_CITA = ImmutableMap.of(1, TIPO_CON_CITA, 2, TIPO_SIN_CITA, 3,
			TIPO_SIN_CITA);
	
	/**
	 * Constante para determinar el color de los registros para la disponibilidad de turno.
	 */
	public static final ImmutableMap<String, String> RELACION_COLOR_DISPONIBILIDAD = ImmutableMap.of(
			"00", "Text__black",
			"01", "Text__red",
			"02", "Text__DarkOrange",
			"03", "Text__Green",
			"04", "Text__Green");
	
	/**
	 * Constante para determinar el color de los registros para la disponibilidad de turno.
	 */
	public static final ImmutableMap<Integer, String> RELACION_COLOR_REGISTRO_DISPONIBILIDAD = ImmutableMap.of(
			1, "Row__3",
			0, "Row__4");
	
	/**
	 * Constante para determinar el color de los registros para la disponibilidad de turno.
	 */
	public static final ImmutableMap<Integer, String> RELACION_COLOR_REGISTRO_REGISTRO = ImmutableMap.of(
			1, "Row__1",
			0, "Row__3");
	
	/**
	 * Constante para denotar un estatus para citass con cus.
	 */
	public static final String DISPONIBILIDAD_TURNO_ESTATUS_CITA_CON_CUS = "00"; 
			
			
				/**
	 * Constante para diferenciar el tipo de cita que lleva
	 * 1 = Con Cita
	 */
	public static final Integer FLAG_TIPO_CITA = 1;
	/**
	 * Constante para diferenciar el tipo de cita que lleva
	 * 2 = Sin Cita
	 */
	public static final Integer FLAG_TIPO_SIN_CITA = 2;
	/**
	 * Constante para diferenciar el tipo de cita que lleva
	 * 3 = Sin Cita
	 */
	public static final Integer FLAG_TIPO_SIN_DATOS_CITA = 3;

	/**
	 * Estatus 1	
	 */
	public static final Integer ESTATUS_INT_UNO = 1;

	/**
	 * Constante diagonal
	 */
	public static final String CARACTER_DIAGONAL = "/";

	/**
	 * tamaño de lista maxima de persona encontrada
	 */
	public static final int INT_TAMANIO_LIST_PERSONA = 1;

	/**
	 * constante tipo de servicio
	 */
	public static final Object CONSTANTE_TIPO_SERVICIO = "tipoServicio";
	/**
	 * constante de curp
	 */
	public static final Object CONSTANTE_CURP = "curp";
	/**
	 * servicio 03
	 */
	public static final String CLAVE_TIPO_SERVICIO_03 = "03";
	/**
	 * servicio 02
	 */
	public static final String CLAVE_TIPO_SERVICIO_02 = "02";
	/**
	 * condigo exitoso
	 */
	public static final String CODIGO_EXITOSO = "01";

}
