package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Definicion de entidad de Solicitud de Reporte Masivo
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 09:48:03
 */
@Entity
@Table(name = "PSER_TR_SOLICITUD_REPORTE")
@SequenceGenerator(name = "SEQ_SOLICITUD_REPORTE", sequenceName = "PSER_SEQ_SOLICITUD_REPORTE", initialValue = 1, allocationSize = 1)
public class SolicitudReporte implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = -1887107835240622705L;

	/**
	 * ID de la entidad
	 */
	@Id
	@Column(name = "ID_SOLICITUD_REPORTE")
	@GeneratedValue(generator = "SEQ_SOLICITUD_REPORTE", strategy = GenerationType.SEQUENCE)
	private Long idSolicitud;

	/**
	 * Numero de reporte
	 */
	@Column(name = "CH_NUMERO_SOLICITUD_REPORTE")
	private String numeroSolicitud;

	/**
	 * ID del rporte generico
	 */
	@Column(name = "ID_REPORTE_GENERICO")
	private Long idReporteGenerico;

	/**
	 * Estado de la solicitud
	 */
	@Column(name = "ID_ESTADO_SOLICITUD")
	private Long idEstadoSolicitud;

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
	private String rutaArchivoReporte;

	/**
	 * Nombre del archivo respuesta
	 */
	@Column(name = "CH_NOMBRE_ARCHIVO_RESPUESTA")
	private String nombreArchivoReporte;

	/**
	 * Fecha de ultima modificación
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_CONTROL")
	private Date fechaControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * ID de la entidad de bitacor
	 */
	@Column(name = "ID_BITACORA_REPORTE")
	private Long idBitacora;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public SolicitudReporte() {
		// Constructor Vacio
	}

	/**
	 * @return el atributo idSolicitud
	 */
	public Long getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * @param idSolicitud
	 *            parametro idSolicitud a actualizar
	 */
	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
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
	 * @return el atributo rutaArchivoReporte
	 */
	public String getRutaArchivoReporte() {
		return rutaArchivoReporte;
	}

	/**
	 * @param rutaArchivoReporte
	 *            parametro rutaArchivoReporte a actualizar
	 */
	public void setRutaArchivoReporte(String rutaArchivoReporte) {
		this.rutaArchivoReporte = rutaArchivoReporte;
	}

	/**
	 * @return el atributo nombreArchivoReporte
	 */
	public String getNombreArchivoReporte() {
		return nombreArchivoReporte;
	}

	/**
	 * @param nombreArchivoReporte
	 *            parametro nombreArchivoReporte a actualizar
	 */
	public void setNombreArchivoReporte(String nombreArchivoReporte) {
		this.nombreArchivoReporte = nombreArchivoReporte;
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
	 * @return el atributo idBitacora
	 */
	public Long getIdBitacora() {
		return idBitacora;
	}

	/**
	 * @param idBitacora
	 *            parametro idBitacora a actualizar
	 */
	public void setIdBitacora(Long idBitacora) {
		this.idBitacora = idBitacora;
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
		builder.append("SolicitudReporte [idSolicitud=");
		builder.append(idSolicitud);
		builder.append(", numeroSolicitud=");
		builder.append(numeroSolicitud);
		builder.append(", idReporteGenerico=");
		builder.append(idReporteGenerico);
		builder.append(", idEstadoSolicitud=");
		builder.append(idEstadoSolicitud);
		builder.append(", fechaEnvio=");
		builder.append(fechaEnvio);
		builder.append(", fechaProceso=");
		builder.append(fechaProceso);
		builder.append(", rutaArchivoSolicitud=");
		builder.append(rutaArchivoSolicitud);
		builder.append(", nombreArchivoSolicitud=");
		builder.append(nombreArchivoSolicitud);
		builder.append(", rutaArchivoReporte=");
		builder.append(rutaArchivoReporte);
		builder.append(", nombreArchivoReporte=");
		builder.append(nombreArchivoReporte);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", idBitacora=");
		builder.append(idBitacora);
		builder.append("]");
		return builder.toString();
	}

	
}
