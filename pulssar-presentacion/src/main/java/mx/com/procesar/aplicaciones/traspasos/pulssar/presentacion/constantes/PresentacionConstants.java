package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes;

/**
 * Clase que define las constantes a utilizar en la capa de presentacion
 * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
 * @version 1.0
 * @since 23/12/2019, 18:23:40
 */
public final class PresentacionConstants {

    /**
     * Constante Content type
     */
    public static final String CONTENT_TYPE = "application/octet-stream";

    /**
     * Constante para identificar la ruta del logo Desempleo IMSS
     */
    public static final int ENTERO_ERROR_DESCARGA_ARCHIVO_303 = 303;

    /**
     * Constante para el nombre de pagina en Excel..
     */
    public static final String SHEET = "SHEET";

    /**
     * Formto para fechas del Excel.
     */
    public static final String FORMATO_TMSTP = "dd/MM/yyyy hh:mm:sss";

    /**
     * Referencia a user
     */
    public static final String USER = "user";

    /**
     * Estado de respuesta de exito
     */
    public static final Integer RESPUESTA_EXITO = 1;

    /**
     * Estado de respuesta de error
     */
    public static final Integer RESPUESTA_ERROR = 0;

    /**
     * Mensaje a mostrar de ocurrir algun error en la ejecucion de alguna consulta sobre la
     * base de datos
     */
    public static final String MSG_ERROR_CONSULTA_INFORMACION = "Error al consultar la informacion solicitada.";

    /**
     * Nombre parámetro respuesta 1.
     */
    public static final String RESPUESTA_JASPER = "respuestaJasper";

    /**
     * Constante para identificar el atributo de módulo.
     */
    public static final String ID_MODULO = "idModulo";

    /**
     * Constante para identificar el atributo de idRol.
     */
    public static final String ID_ROLES = "idRoles";

    /**
     * Constante para identificar el atributo de id proceso.
     */
    public static final String ID_PROCESO = "idProceso";

    /**
     * Constante para identificar el atributo de id sub proceso.
     */
    public static final String ID_SUB_PROCESO = "idSubProceso";

    /**
     * Constante para identificar el atributo de id tipo consulta.
     */
    public static final String ID_TIPO_CONSULTA = "idTipoConsulta";

    /**
     * Constante para procesamiento por Linea
     */
    public static final int INT_BANDERA_SERVICIO_LINEA = 0;

    /**
     * Referencia a Plataforma de servicios operativos
     */
    public static final String PLATAFORMA_OPERATIVA = "/mx/com/procesar/plataforma/servicios/plataforma_operativa/plataforma_operativa";

    /**
     * Referencia a Masivos Plataforma de servicios operativos
     */
    public static final String MASIVOS = "/mx/com/procesar/plataforma/servicios/masivos/menuMasivos";

    /**
     * Referencia a form Plataforma de Servicios
     */
    public static final String PLATAFORMA_OPERATIVA_FORM = "plataformaOperativaForm";

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
     * Constante para identificar el atributo nss.
     */
    public static final String NSS = "nss";

    /**
     * Constante para identificar el atributo curp.
     */
    public static final String CURP = "curp";

    /**
     * Constante para identificar el atributo de idProcesar.
     */
    public static final String ID_PROCESAR = "idProcesar";

    /**
     * Mensaje a mostrar en caso de no recuperar informacion de la base de datos
     */
    public static final String MSG_CONSULTA_SIN_INFORMACION = "No se encuentra informacion con los parametros seleccionados";

    /**
     * Constante para identificar el atributo fcInicial.
     */
    public static final String FC_INICIAL = "fcInicial";

    /**
     * Constante para identificar el atributo fcFinal.
     */
    public static final String FC_FINAL = "fcFinal";

    /**
     * Inicializacion de cadena con vacio
     */
    public static final String STR_COMA_SIMPLE = "'";

    /**
     * Constante para procesamiento por Batch
     */
    public static final int INT_BANDERA_SERVICIO_BATCH = 1;

    /**
     * Atributo para identificar el área del usuario.
     */
    public static final String AREA_USUARIO = "areaUsuario";

    /**
     * Inicializacion de cadena con vacio
     */
    public static final String STR_CADENA_NULA = " ";

    // MASIVOS
    /**
     * Estado Recibido de solcitud de reportes masivos
     */
    public static final Long SOLICITUD_ESTADO_RECIBIDO = 1L;

    /**
     * Estado Procesando de solicitud de reportes masivos
     */
    public static final Long SOLICITUD_ESTADO_PROCESANDO = 2L;

    /**
     * Estado Aceptado de solcitud de reportes masivos
     */
    public static final Long SOLICITUD_ESTADO_ACEPTADO = 3L;

    /**
     * Estado Rechazado de solcitud de reportes masivos
     */
    public static final Long SOLICITUD_ESTADO_RECHAZADO = 4L;

    /**
     * Nombre parámetro respuesta 1.
     */
    public static final String RESPUESTA1 = "respuesta1";

    /**
     * Nombre parámetro respuesta Admin.
     */
    public static final String RESPUESTA2 = "respuesta2";

    /**
     * Content type
     */
    public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";

    /**
     * Extension xls
     */
    public static final String EXTENSION_XLS = ".xls";

    /**
     * Constante para bandera de la descarga de archivo y el path
     */
    public static final String FILE_DOWNLOAD_PATH_COOKIE = "fileDownload=true; path=/";

    /**
     * Constante para el setteo de cookie
     */
    public static final String SET_COOKIE = "Set-Cookie";

    /**
     * Atachment
     */
    public static final String ATTACHMENT = "attachment;filename=";

    /**
     * Content disposition
     */
    public static final String CONTENT_DISPOSITION = "Content-Disposition";

    /**
     * Constante para identificar la ruta del logo Desempleo IMSS
     */
    public static final String RUTA_LOGO = "webResources/plataforma_servicios/images/logo-procesar.png";

    /**
     * Cadena que contiene un cero
     */
    public static final String CERO_CADENA = "0";

    /**
     * Formato de fecha para los nombres de reporte
     */
    public static final String FORMATO_FECHA_JASPER = "yyyyMMddHHmmss";

    /**
     * Nombre del atributo que contiene la lista de modulos asignados al usuario
     */
    public static final String MODULOS_USUARIO = "modulosUsuario";

    /**
     * Nombre del atributo que contiene la lista de areas
     */
    public static final String AREAS = "areas";

    /**
     * Constructor privado para prevenir instancias
     */
    private PresentacionConstants() {
        // Vacío por defecto.
    }

}
