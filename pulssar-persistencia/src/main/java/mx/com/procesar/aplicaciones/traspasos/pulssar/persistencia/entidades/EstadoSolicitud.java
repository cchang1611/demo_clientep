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
 * Entidad de Estados de Solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 10:31:22
 */
@Entity
@Table(name = "PSER_TC_ESTADO_SOLICITUD")
public class EstadoSolicitud implements Serializable {

	/**
	 * Identificador de serializacion
	 */
	private static final long serialVersionUID = 8137683905563474318L;

	/**
	 * ID del estado de la solicitud
	 */
	@Id
	@Column(name = "ID_ESTADO_SOLICITUD")
	private Long isEstadoSolicitud;

	/**
	 * Descripcion del estado
	 */
	@Column(name = "CH_DESC_ESTADO_SOLICITUD")
	private String descripcion;

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
	private String ususarioModificador;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public EstadoSolicitud() {
		// Constructor default vacio
	}

	/**
	 * @return el atributo isEstadoSolicitud
	 */
	public Long getIsEstadoSolicitud() {
		return isEstadoSolicitud;
	}

	/**
	 * @param isEstadoSolicitud
	 *            parametro isEstadoSolicitud a actualizar
	 */
	public void setIsEstadoSolicitud(Long isEstadoSolicitud) {
		this.isEstadoSolicitud = isEstadoSolicitud;
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
	 * @return el atributo ususarioModificador
	 */
	public String getUsusarioModificador() {
		return ususarioModificador;
	}

	/**
	 * @param ususarioModificador
	 *            parametro ususarioModificador a actualizar
	 */
	public void setUsusarioModificador(String ususarioModificador) {
		this.ususarioModificador = ususarioModificador;
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
		builder.append("EstadoSolicitud [isEstadoSolicitud=");
		builder.append(isEstadoSolicitud);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", ususarioModificador=");
		builder.append(ususarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
