/**
 * ReintegroConstants.java
 * Fecha de creaci�n: May 11, 2020 12:55:53 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

/**
 * Clase constants para Reintegro
 *
 * @author Williams Alejandro Mart�nez (WALEJAND)
 * @version 1.0
 */
public class ReintegroConstants {

	/**
	 * Atributo session solicitud
	 */
	public static final String SOLICITUD = "solicitud";

	/**
	 * Atributo model
	 */
	public static final String SESSION_SOLICITUD = "solicitudReintegro";

	/**
	 * Atributo folio
	 */
	public static final String ATRIBUTO_FOLIO = "folio";

	/**
	 * Atributo resolucion
	 */
	public static final String ATRIBUTO_RESOLUCION = "resolucion";

	/**
	 * Atributo numero reintegro
	 */
	public static final String ATRIBUTO_NUMERO_REINTEGRO = "numeroReintegro";

	/**
	 * Codigo numero notificado
	 */
	public static final Integer COD_NO_NOTIFICADO = 0;

	/**
	 * Codigo pendiente de confirmacion
	 */
	public static final String COD_PENDIENTE_CONFIRMACION = "02";

	/**
	 * Usuario de registro
	 */
	public static final String USER_REGISTRO = "USER_REINTEGRO";

	/**
	 * Constante tipo trabajador IMSS
	 */
	public static final String TIPO_TRABAJADOR = "1";

	/**
	 * Folio del archivo trabajador
	 */
	public static final String FOLIO_ARCHIVO_TRABAJADOR = "000";

	/**
	 * Mensaje de documentos obligatorios
	 */
	public static final String MSJ_DOCUMENTOS_OBLIGATORIOS = "Debe cargar los documentos obligatorios";

	/**
	 * Mensaje permitidos
	 */
	public static final String MSJ_MEGAS_PERMITIDOS = "El tama�o del archivo excede lo permitido";

	/**
	 * Codigo error
	 */
	public static final Integer CODIGO_FLUJO_ERROR = 2;

	/**
	 * Codigo exitoso
	 */
	public static final Integer CODIGO_FLUJO_OK = 0;

	/**
	 * Formato de fechas para el nombre de archivos
	 */
	public static final String FORMATO_FECHA = "yyyyMMdd";

	/**
	 * Formato de generacion de nombre del archivo
	 */
	public static final String FORMATO_NOMBRE_ARCHIVO = "{0}{1}{2}{3}{4}{5}{6}{7}";

	/**
	 * Formato de generacion de nombre del archivo
	 */
	public static final String FORMATO_NOMBRE_ARCHIVO_ZIP = "{0}{1}{2}{3}{4}{5}";

	/**
	 * Mensaje documentos guardados
	 */
	public static final String MSJ_DOCUMENTOS_GUARDADOS = "Documentos guardados";

	/**
	 * Clave documentos obligatorios
	 */
	public static final Integer DOC_OBLIGATORIOS = 1;

	/**
	 * Clave documentos no obligatorios
	 */
	public static final Integer DOC_NO_OBLIGATORIOS = 0;

	/**
	 * Tama�o maximo para los archivos adjunto
	 */
	public static final Long TAMANIO_MAXIMO_ARCHIVO = 1000000L;

	/**
	 * Clave tipo proceso para reintegro
	 */
	public static final String CLAVE_TIPO_PROCES_REINTEGRO = "06";
	
	
	/**
	 * Atributo model mensaje
	 */
	public static final String ATRIBUTO_MENSAJE = "mensaje";

}
