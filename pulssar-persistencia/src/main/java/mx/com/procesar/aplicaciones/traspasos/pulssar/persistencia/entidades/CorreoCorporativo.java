package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa la entidad de Correos de Organizacion, mapeado a la tabla PSER_TR_CORREO_CORP_PULSSAR
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TR_CORREO_CORP_PULSSAR")
@IdClass(CorreoCorporativoPK.class)
public class CorreoCorporativo implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1575952515569341996L;

	/**
	 * Identificador de la Organizacion.
	 */
	@Id
	@Column(name = "CV_ORGANIZACION")
	private String claveOrganizacion;
	
	/**
	 * Dominio de Correo Corporativo.
	 */
	@Id
	@Column(name = "CH_EMAIL_CORP")
	private String email;
	
	/**
	 * Estatus del registro de dominio (1- Activo, 0 Inactivo).
	 */
	@Column(name = "NU_ESTATUS")
	private Integer estatus;
	
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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
		builder.append("CorreoCorporativo [claveOrganizacion=");
		builder.append(claveOrganizacion);
		builder.append(", email=");
		builder.append(email);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append("[fecha=");
		builder.append(fecha);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		builder.append("]");
		return builder.toString();
	}
}