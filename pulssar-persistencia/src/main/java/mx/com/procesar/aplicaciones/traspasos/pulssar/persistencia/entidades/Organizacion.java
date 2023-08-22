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
 * Representa la entidad de Organizaciones, mapeado a la tabla PSER_TC_ORGANIZACION
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TC_ORGANIZACION")
public class Organizacion implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2486531843812453465L;
	
	/**
	 * Identificador de la Organizacion.
	 */
	@Id
	@Column(name = "CV_ORGANIZACION")
	private String claveOrganizacion;
	
	/**
	 * Nombre de organizacion.
	 */
	@Column(name = "CH_DESC_ORGANIZACION")
	private String descripcionOrganizacion;
	
	/**
	 * Fecha de ultima modificacion.
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/**
	 * Indicador de activo/inactivo
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuario;
	
	/**
	 * @return the claveOrganizacion
	 */
	public String getClaveOrganizacion() {
		return claveOrganizacion;
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaveOrganizacion(String claveOrganizacion) {
		this.claveOrganizacion = claveOrganizacion;
	}

	/**
	 * @return the descripcionOrganizacion
	 */
	public String getDescripcionOrganizacion() {
		return descripcionOrganizacion;
	}

	/**
	 * @param descripcionOrganizacion the descripcionOrganizacion to set
	 */
	public void setDescripcionOrganizacion(String descripcionOrganizacion) {
		this.descripcionOrganizacion = descripcionOrganizacion;
	}
	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Organizacion [claveOrganizacion=");
		builder.append(claveOrganizacion);
		builder.append(", descripcionOrganizacion=");
		builder.append(descripcionOrganizacion);
		builder.append("[fecha=");
		builder.append(fecha);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		return builder.toString();
	}
}