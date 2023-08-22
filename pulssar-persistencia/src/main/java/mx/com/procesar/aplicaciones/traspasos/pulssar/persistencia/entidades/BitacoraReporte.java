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
 * Definicion de entidad bitacora para la ejecucion de reportes
 * 
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
@Entity
@Table(name = "PSER_TB_BITACORA_REPORTE")
@SequenceGenerator(name = "SEQ_BITACORA_REPORTE", sequenceName = "PSER_SEQ_BITACORA_REPORTE", initialValue = 1, allocationSize = 1)
public class BitacoraReporte implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = -6501474555719113350L;

	/**
	 * Identificador unico de bitacora de reporte
	 */
	@Id
	@Column(name = "ID_BITACORA_REPORTE")
	@GeneratedValue(generator = "SEQ_BITACORA_REPORTE", strategy = GenerationType.SEQUENCE)
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
	private int reporteExportado;

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
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public BitacoraReporte() {
		// Constructor default vacio
	}

	/**
	 * @return el atributo idBitacoraReporte
	 */
	public Long getIdBitacoraReporte() {
		return idBitacoraReporte;
	}

	/**
	 * @param idBitacoraReporte
	 *            parametro idBitacoraReporte a actualizar
	 */
	public void setIdBitacoraReporte(Long idBitacoraReporte) {
		this.idBitacoraReporte = idBitacoraReporte;
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
	 * @return el atributo usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            parametro usuario a actualizar
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el atributo fechaEjecucion
	 */
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	/**
	 * @param fechaEjecucion
	 *            parametro fechaEjecucion a actualizar
	 */
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	/**
	 * @return el atributo parametros
	 */
	public String getParametros() {
		return parametros;
	}

	/**
	 * @param parametros
	 *            parametro parametros a actualizar
	 */
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	/**
	 * @return el atributo reporteExportado
	 */
	public int getReporteExportado() {
		return reporteExportado;
	}

	/**
	 * @param reporteExportado
	 *            parametro reporteExportado a actualizar
	 */
	public void setReporteExportado(int reporteExportado) {
		this.reporteExportado = reporteExportado;
	}

	/**
	 * @return el atributo fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl
	 *            parametro fcControl a actualizar
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
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
	 * @return el atributo ipOrigen
	 */
	public String getIpOrigen() {
		return ipOrigen;
	}

	/**
	 * @param ipOrigen
	 *            parametro ipOrigen a actualizar
	 */
	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitacoraReporte [idBitacoraReporte=");
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
		builder.append("]");
		return builder.toString();
	}
}