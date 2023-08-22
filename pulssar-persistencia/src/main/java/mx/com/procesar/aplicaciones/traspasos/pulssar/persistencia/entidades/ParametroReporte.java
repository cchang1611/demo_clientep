package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Definicion de entidad de parametros de reporte
 * 
 * @author hjramire
 * @version 1.0
 * @since 14/01/2020, 20:05:01
 */
@Entity
@Table(name = "PSER_TR_PARAMETRO_REPORTE")
@SequenceGenerator(name = "SEQ_PARAMETRO_REPORTE", sequenceName = "PSER_SEQ_PARAMETRO_REPORTE", initialValue = 1, allocationSize = 1)
public class ParametroReporte implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = 7012589658246422320L;

	/**
	 * ID de la entidad
	 */
	@Id
	@Column(name = "ID_PARAMETRO_REPORTE")
	private Long idParametroReporte;

	/**
	 * ID del reporte generico
	 */
	@Column(name = "ID_REPORTE_GENERICO")
	private Long idReporteGenerico;

	/**
	 * Orden de secuencia de subconsultas
	 */
	@Column(name = "NU_SECUENCIA")
	private Integer secuencia;

	/**
	 * Nombre de variable de JasperReporte
	 */
	@Column(name = "CH_NOMBRE")
	private String nombre;

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
	 * Clave de Identificacion de seccion de reporte.
	 */
	@Column(name="CH_SECCION_PARAMETRO")
	private String seccion;
	
	/**
	 * Tipo de Dato del parametro. FCH : FECHA  STR: CADENA
	 */
	@Column(name="CH_TIPO_DATO")
	private String tipoCampo;
	
	/**
	 * Tipo de parametro.     SQL : CONSULTA  JRX : JASPER
	 */
	@Column(name="CH_TIPO_PARAMETRO")
	private String tipoParametro;
	
	/**
	 * Numero de días maximo permitido en consulta por rango de fechas
	 */
	@Column(name="NU_DIAS_MAXIMO")
	private String nuDiasMaximo;
	
	/**
	 *  Constructor sin argumentos
	 *  @author hjramire
	 */
	public ParametroReporte() {
		// Constructor sin argumentos
	}

	/**
	 * @return the idParametroReporte
	 */
	public Long getIdParametroReporte() {
		return idParametroReporte;
	}

	/**
	 * @param idParametroReporte the idParametroReporte to set
	 */
	public void setIdParametroReporte(Long idParametroReporte) {
		this.idParametroReporte = idParametroReporte;
	}

	/**
	 * @return the idReporteGenerico
	 */
	public Long getIdReporteGenerico() {
		return idReporteGenerico;
	}

	/**
	 * @param idReporteGenerico the idReporteGenerico to set
	 */
	public void setIdReporteGenerico(Long idReporteGenerico) {
		this.idReporteGenerico = idReporteGenerico;
	}

	/**
	 * @return the secuencia
	 */
	public Integer getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia the secuencia to set
	 */
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return the seccion
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * @param seccion the seccion to set
	 */
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	/**
	 * @return the tipoCampo
	 */
	public String getTipoCampo() {
		return tipoCampo;
	}

	/**
	 * @param tipoCampo the tipoCampo to set
	 */
	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	
	/**
	 * @return the tipoParametro
	 */
	public String getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * @param tipoParametro the tipoParametro to set
	 */
	public void setTipoParametro(String tipoParametro) {
		this.tipoParametro = tipoParametro;
	}
	
	/**
	 * 
	 * @return nuDiasMaximo
	 */

	public String getNuDiasMaximo() {
		return nuDiasMaximo;
	}

	/**
	 * 
	 * @param nuDiasMaximo
	 */
	public void setNuDiasMaximo(String nuDiasMaximo) {
		this.nuDiasMaximo = nuDiasMaximo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParametroReporte [idParametroReporte=");
		builder.append(idParametroReporte);
		builder.append(", idReporteGenerico=");
		builder.append(idReporteGenerico);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", seccion=");
		builder.append(seccion);
		builder.append(", tipoCampo=");
		builder.append(tipoCampo);
		builder.append(", tipoParametro=");
		builder.append(tipoParametro);
		builder.append(", nuDiasMaximo=");
		builder.append(nuDiasMaximo);
		builder.append("]");
		return builder.toString();
	}

	
}
