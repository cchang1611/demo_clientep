package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Definicio de Entidad para Detalle de solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 10:31:44
 */
@Entity
public class DetalleSolicitud implements Serializable {

	/**
	 * Identificador de serializacion
	 */
	private static final long serialVersionUID = -587903541157821038L;

	/**
	 * id de solicitud de reporte
	 */
	@Id
	@Column(name = "ID_SOLICITUD_REPORTE")
	private Long idSolicitudReporte;

	/**
	 * numero de solicitud
	 */
	@Column(name = "CH_NUMERO_SOLICITUD_REPORTE")
	private String numeroSolicitud;

	/**
	 * ID del rporte generico
	 */
	@Column(name = "ID_REPORTE_GENERICO")
	private Long idReporteGenerico;

	/**
	 * Nombre del reporte generico
	 */
	@Column(name = "CH_NOMBRE_REPORTE")
	private String nombreReporte;

	/**
	 * Estado de la solicitud
	 */
	@Column(name = "ID_ESTADO_SOLICITUD")
	private Long idEstadoSolicitud;

	/**
	 * descripcion del estado de la solicitud
	 */
	@Column(name = "CH_DESC_ESTADO_SOLICITUD")
	private String descripcionEstado;

	/**
	 * Fecha de envio
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_ENVIO")
	private Date fechaEnvio;

	/**
	 * Fecha de proceso
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_PROCESO")
	private Date fechaProceso;

	/**
	 * Ruta del archivo de solicitud
	 */
	@Column(name = "CH_RUTA_ARCHIVO_SOLICITUD")
	private String rutaArchivoSolicitud;

	/**
	 * Nombr del archivo solicitud
	 */
	@Column(name = "CH_NOMBRE_ARCHIVO_SOLICITUD")
	private String nombreArchivoSolicitud;

	/**
	 * Ruta de archivo respuesta
	 */
	@Column(name = "CH_RUTA_ARCHIVO_RESPUESTA")
	private String rutaArchivoRespuesta;

	/**
	 * Nombre del archivo respuesta
	 */
	@Column(name = "CH_NOMBRE_ARCHIVO_RESPUESTA")
	private String nombreArchivoRespuesta;

	/**
	 * Fecha de ultima modificación
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONTROL")
	private Date fechaControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * Bandera que determina si el reporte ya ha sido descargado
	 */
	@Column(name = "NU_EXPORT_REPORTE")
	private Integer exportado;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public DetalleSolicitud() {
		// Constructor default vacio
	}

	/**
	 * @return el atributo idSolicitudReporte
	 */
	public Long getIdSolicitudReporte() {
		return idSolicitudReporte;
	}

	/**
	 * @param idSolicitudReporte
	 *            parametro idSolicitudReporte a actualizar
	 */
	public void setIdSolicitudReporte(Long idSolicitudReporte) {
		this.idSolicitudReporte = idSolicitudReporte;
	}

	/**
	 * @return el atributo numeroSolicitud
	 */
	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}

	/**
	 * @param numeroSolicitud
	 *            parametro numeroSolicitud a actualizar
	 */
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	/**
	 * @return el atributo idReporteGenerico
	 */
	public Long getIdReporteGenerico() {
		return idReporteGenerico;
	}

	/**
	 * @param idReporteGenerico
	 *            parametro idReporteGenerico a actualizar
	 */
	public void setIdReporteGenerico(Long idReporteGenerico) {
		this.idReporteGenerico = idReporteGenerico;
	}

	/**
	 * @return el atributo nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}

	/**
	 * @param nombreReporte
	 *            parametro nombreReporte a actualizar
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	/**
	 * @return el atributo idEstadoSolicitud
	 */
	public Long getIdEstadoSolicitud() {
		return idEstadoSolicitud;
	}

	/**
	 * @param idEstadoSolicitud
	 *            parametro idEstadoSolicitud a actualizar
	 */
	public void setIdEstadoSolicitud(Long idEstadoSolicitud) {
		this.idEstadoSolicitud = idEstadoSolicitud;
	}

	/**
	 * @return el atributo descripcionEstado
	 */
	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	/**
	 * @param descripcionEstado
	 *            parametro descripcionEstado a actualizar
	 */
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	/**
	 * @return el atributo fechaEnvio
	 */
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio
	 *            parametro fechaEnvio a actualizar
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * @return el atributo fechaProceso
	 */
	public Date getFechaProceso() {
		return fechaProceso;
	}

	/**
	 * @param fechaProceso
	 *            parametro fechaProceso a actualizar
	 */
	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	/**
	 * @return el atributo rutaArchivoSolicitud
	 */
	public String getRutaArchivoSolicitud() {
		return rutaArchivoSolicitud;
	}

	/**
	 * @param rutaArchivoSolicitud
	 *            parametro rutaArchivoSolicitud a actualizar
	 */
	public void setRutaArchivoSolicitud(String rutaArchivoSolicitud) {
		this.rutaArchivoSolicitud = rutaArchivoSolicitud;
	}

	/**
	 * @return el atributo nombreArchivoSolicitud
	 */
	public String getNombreArchivoSolicitud() {
		return nombreArchivoSolicitud;
	}

	/**
	 * @param nombreArchivoSolicitud
	 *            parametro nombreArchivoSolicitud a actualizar
	 */
	public void setNombreArchivoSolicitud(String nombreArchivoSolicitud) {
		this.nombreArchivoSolicitud = nombreArchivoSolicitud;
	}

	/**
	 * @return el atributo rutaArchivoRespuesta
	 */
	public String getRutaArchivoRespuesta() {
		return rutaArchivoRespuesta;
	}

	/**
	 * @param rutaArchivoRespuesta
	 *            parametro rutaArchivoRespuesta a actualizar
	 */
	public void setRutaArchivoRespuesta(String rutaArchivoRespuesta) {
		this.rutaArchivoRespuesta = rutaArchivoRespuesta;
	}

	/**
	 * @return el atributo nombreArchivoRespuesta
	 */
	public String getNombreArchivoRespuesta() {
		return nombreArchivoRespuesta;
	}

	/**
	 * @param nombreArchivoRespuesta
	 *            parametro nombreArchivoRespuesta a actualizar
	 */
	public void setNombreArchivoRespuesta(String nombreArchivoRespuesta) {
		this.nombreArchivoRespuesta = nombreArchivoRespuesta;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo exportado
	 */
	public Integer getExportado() {
		return exportado;
	}

	/**
	 * @param exportado
	 *            parametro exportado a actualizar
	 */
	public void setExportado(Integer exportado) {
		this.exportado = exportado;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetalleSolicitud [idSolicitudReporte=");
		builder.append(idSolicitudReporte);
		builder.append(", numeroSolicitud=");
		builder.append(numeroSolicitud);
		builder.append(", idReporteGenerico=");
		builder.append(idReporteGenerico);
		builder.append(", nombreReporte=");
		builder.append(nombreReporte);
		builder.append(", idEstadoSolicitud=");
		builder.append(idEstadoSolicitud);
		builder.append(", descripcionEstado=");
		builder.append(descripcionEstado);
		builder.append(", fechaEnvio=");
		builder.append(fechaEnvio);
		builder.append(", fechaProceso=");
		builder.append(fechaProceso);
		builder.append(", rutaArchivoSolicitud=");
		builder.append(rutaArchivoSolicitud);
		builder.append(", nombreArchivoSolicitud=");
		builder.append(nombreArchivoSolicitud);
		builder.append(", rutaArchivoRespuesta=");
		builder.append(rutaArchivoRespuesta);
		builder.append(", nombreArchivoRespuesta=");
		builder.append(nombreArchivoRespuesta);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", exportado=");
		builder.append(exportado);
		builder.append("]");
		return builder.toString();
	}
}
