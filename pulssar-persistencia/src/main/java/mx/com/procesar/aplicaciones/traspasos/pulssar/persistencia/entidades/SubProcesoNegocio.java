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
 * Definicion de entidad catalogo de Subproceso
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 09:47:39
 */
@Entity
@Table(name = "PSER_TC_SUBPROCESO")
public class SubProcesoNegocio implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = -6091995128307614506L;

	/**
	 * Identificador unico del subproceso
	 */
	@Id
	@Column(name = "ID_SUBPROCESO")
	private Long idSubProceso;

	/**
	 * Identificador del proceso
	 */
	@Column(name = "ID_PROCESO_NEGOCIO")
	private Long idProcesoNegocio;

	/**
	 * Nombre del Subproceso
	 */
	@Column(name = "CH_NOMBRE_SUBPROCESO")
	private String nombreSubProceso;

	/**
	 * Estado del registro: 1 Activo 0 Inactivo
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
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public SubProcesoNegocio() {
		// Constructor default vacio
	}

	/**
	 * @return el atributo idSubProceso
	 */
	public Long getIdSubProceso() {
		return idSubProceso;
	}

	/**
	 * @param idSubProceso
	 *            parametro idSubProceso a actualizar
	 */
	public void setIdSubProceso(Long idSubProceso) {
		this.idSubProceso = idSubProceso;
	}

	/**
	 * @return el atributo idProcesoNegocio
	 */
	public Long getIdProcesoNegocio() {
		return idProcesoNegocio;
	}

	/**
	 * @param idProcesoNegocio
	 *            parametro idProcesoNegocio a actualizar
	 */
	public void setIdProcesoNegocio(Long idProcesoNegocio) {
		this.idProcesoNegocio = idProcesoNegocio;
	}

	/**
	 * @return el atributo nombreSubProceso
	 */
	public String getNombreSubProceso() {
		return nombreSubProceso;
	}

	/**
	 * @param nombreSubProceso
	 *            parametro nombreSubProceso a actualizar
	 */
	public void setNombreSubProceso(String nombreSubProceso) {
		this.nombreSubProceso = nombreSubProceso;
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

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubProcesoNegocio [idSubProceso=");
		builder.append(idSubProceso);
		builder.append(", idProcesoNegocio=");
		builder.append(idProcesoNegocio);
		builder.append(", nombreSubProceso=");
		builder.append(nombreSubProceso);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}