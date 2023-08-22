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
 * Definicion de entidad catalogo Proceso de Negocio
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 09:58:43
 */
@Entity
@Table(name = "PSER_TC_PROCESO_NEGOCIO")
public class ProcesoNegocio implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = 5514517033841713964L;

	/**
	 * Identificador unico del proceso
	 */
	@Id
	@Column(name = "ID_PROCESO_NEGOCIO")
	private Long idProcesoNegocio;

	/**
	 * Identificador del modulo
	 */
	@Column(name = "ID_MODULO_REPORTE")
	private Long idModulo;

	/**
	 * Nombre del proceso
	 */
	@Column(name = "CH_NOMBRE_PROCESO")
	private String nombreProceso;

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
	public ProcesoNegocio() {
		// Constructor vacio
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
	 * @return el atributo idModulo
	 */
	public Long getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo
	 *            parametro idModulo a actualizar
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return el atributo nombreProceso
	 */
	public String getNombreProceso() {
		return nombreProceso;
	}

	/**
	 * @param nombreProceso
	 *            parametro nombreProceso a actualizar
	 */
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
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
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoNegocio [idProcesoNegocio=");
		builder.append(idProcesoNegocio);
		builder.append(", idModulo=");
		builder.append(idModulo);
		builder.append(", nombreProceso=");
		builder.append(nombreProceso);
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