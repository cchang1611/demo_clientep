package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad que recibe el resultado de la consulta de los accesos en Plataforma Servicios Operativa.
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 20/07/2020
 */
@Entity
public class ReporteBitacora implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 777502202527040515L;

	/**
	 * ID de la bitácora.
	 */
	@Id
	@Column(name = "ID_BITACORA_REPORTE")
	private Long idBitacoraReporte;

	/**
	 * Identificador del reporte
	 */
	@Column(name = "ID_REPORTE_GENERICO")
	private Long idReporteGenerico;

	/**
	 * usuario que consulta reporte
	 */
	@Column(name = "CH_USUARIO")
	private String usuario;

	/**
	 * fecha de ejecucion de reporte
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_EJECUCION")
	private Date fechaEjecucion;

	/**
	 * lista de parametros utilizados
	 */
	@Column(name = "CH_PARAMETRO")
	private String parametros;

	/**
	 * bandera que determina si el reporte fue expoertado: 1 Exportado 0 No
	 * Exportado
	 */
	@Column(name = "NU_EXPORT_REPORTE")
	private String reporteExportado;

	/**
	 * Fecha de ultima modificación
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_CONTROL")
	private Date fcControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * ip origen desde donde se consulta reporte
	 */
	@Column(name = "CH_IP_ORIGEN")
	private String ipOrigen;

	/**
	 * Nombre del Reporte
	 */
	@Column(name = "CH_NOMBRE_REPORTE")
	private String nombreReporte;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author Arturo Eduardo de la Cruz Perez
	 */
	public ReporteBitacora() {
		// Contructor Vacio
	}

	/**
	 * @return el atributo idBitacoraReporte idBitacoraReporte
	 */
	public Long getIdBitacoraReporte() {
		return idBitacoraReporte;
	}

	/**
	 * @param idBitacoraReporte
	 *            parametro idBitacoraReporte a actualizar idBitacoraReporte
	 */
	public void setIdBitacoraReporte(Long idBitacoraReporte) {
		this.idBitacoraReporte = idBitacoraReporte;
	}

	/**
	 * @return el atributo idReporteGenerico idReporteGenerico
	 */
	public Long getIdReporteGenerico() {
		return idReporteGenerico;
	}

	/**
	 * @param idReporteGenerico
	 *            parametro idReporteGenerico a actualizar idReporteGenerico
	 */
	public void setIdReporteGenerico(Long idReporteGenerico) {
		this.idReporteGenerico = idReporteGenerico;
	}

	/**
	 * @return el atributo usuario usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            parametro usuario a actualizar usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el atributo fechaEjecucion fechaEjecucion
	 */
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	/**
	 * @param fechaEjecucion
	 *            parametro fechaEjecucion a actualizar fechaEjecucion
	 */
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	/**
	 * @return el atributo parametros parametros
	 */
	public String getParametros() {
		return parametros;
	}

	/**
	 * @param parametros
	 *            parametro parametros a actualizar parametros
	 */
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	/**
	 * @return el atributo reporteExportado reporteExportado
	 */
	public String getReporteExportado() {
		return reporteExportado;
	}

	/**
	 * @param reporteExportado
	 *            parametro reporteExportado a actualizar reporteExportado
	 */
	public void setReporteExportado(String reporteExportado) {
		this.reporteExportado = reporteExportado;
	}

	/**
	 * @return el atributo fcControl fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl
	 *            parametro fcControl a actualizar fcControl
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return el atributo usuarioModificador usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar usuarioModificador
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo ipOrigen ipOrigen
	 */
	public String getIpOrigen() {
		return ipOrigen;
	}

	/**
	 * @param ipOrigen
	 *            parametro ipOrigen a actualizar ipOrigen
	 */
	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	/**
	 * @return el atributo nombreReporte nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}

	/**
	 * @param nombreReporte
	 *            parametro nombreReporte a actualizar nombreReporte
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReporteBitacora [idBitacoraReporte=");
		builder.append(idBitacoraReporte);
		builder.append(", idReporteGenerico=");
		builder.append(idReporteGenerico);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", fechaEjecucion=");
		builder.append(fechaEjecucion);
		builder.append(", parametros=");
		builder.append(parametros);
		builder.append(", reporteExportado=");
		builder.append(reporteExportado);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", ipOrigen=");
		builder.append(ipOrigen);
		builder.append(", nombreReporte=");
		builder.append(nombreReporte);
		builder.append("]");
		return builder.toString();
	}
}