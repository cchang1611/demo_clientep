package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Definicion de entidad de catalogo tipo de reporte
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 09:43:51
 */
@Entity
@Table(name = "PSER_TC_TIPO_REPORTE")
public class TipoReporte implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = 3449797682046798410L;

	/**
	 * Identificador unico del tipo de reporte
	 */
	@Id
	@Column(name = "ID_TIPO_REPORTE")
	private Long idTipoReporte;

	/**
	 * Descripcion de tipo de reporte
	 */
	@Column(name = "CH_DESCRIPCION")
	private String descripcion;

	/**
	 * Estado del registro, 1 Activo 0 Inactivo
	 */
	@Column(name = "NU_ACTIVO")
	private int activo;

	/**
	 * Fecha de ultima modificación
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONTROL")
	private Date fcControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * formato de generacion de reporte: 1 : BATCH 0 : LINEA
	 */
	@Column(name = "NU_BATCH_LINEA")
	private int flujoBatch;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public TipoReporte() {
		// Constructor default vacio
	}

	/**
	 * @return el atributo idTipoReporte
	 */
	public Long getIdTipoReporte() {
		return idTipoReporte;
	}

	/**
	 * @param idTipoReporte
	 *            parametro idTipoReporte a actualizar
	 */
	public void setIdTipoReporte(Long idTipoReporte) {
		this.idTipoReporte = idTipoReporte;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el atributo activo
	 */
	public int getActivo() {
		return activo;
	}

	/**
	 * @param activo
	 *            parametro activo a actualizar
	 */
	public void setActivo(int activo) {
		this.activo = activo;
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
	 * @return el atributo flujoBatch
	 */
	public int getFlujoBatch() {
		return flujoBatch;
	}

	/**
	 * @param flujoBatch
	 *            parametro flujoBatch a actualizar
	 */
	public void setFlujoBatch(int flujoBatch) {
		this.flujoBatch = flujoBatch;
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
		builder.append("TipoReporte [idTipoReporte=");
		builder.append(idTipoReporte);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", flujoBatch=");
		builder.append(flujoBatch);
		builder.append("]");
		return builder.toString();
	}

}