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
 * Representa la entidad de Roles, mapeado a la tabla PSER_TC_ROL_PULSSAR
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TC_ROL_PULSSAR")
@SequenceGenerator(name = "SEQ_ROL_PULSSAR", sequenceName = "PSER_SEQ_ROL_PULSSAR", allocationSize = 1)
public class RolesCatalogo implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4638139850243038221L;
	
	/**
	 * Identificador unico de registro.
	 */
	@Id
	@Column(name = "ID_ROL_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_ROL_PULSSAR")
	private Long identificadorRol;
		
	/**
	 * Clave del Rol.
	 */
	@Column(name = "CV_ROL_PULSSAR")
	private String claveRol;
	
	/**
	 * Descripcion de ROL.
	 */
	@Column(name = "CH_DESC_ROL_PULSSAR")
	private String descripcionRol;
	
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
	 * Clave de la AFORE.
	 */
	@Column(name = "CH_AFORE")
	private String claveAfore;
	
	/**
	/**
	 * @return the identificadorRol
	 */
	public Long getIdentificadorRol() {
		return identificadorRol;
	}

	/**
	 * @param identificadorRol the identificadorRol to set
	 */
	public void setIdentificadorRol(Long identificadorRol) {
		this.identificadorRol = identificadorRol;
	}

	/**
	 * @return the claveRol
	 */
	public String getClaveRol() {
		return claveRol;
	}

	/**
	 * @param claveRol the claveRol to set
	 */
	public void setClaveRol(String claveRol) {
		this.claveRol = claveRol;
	}

	/**
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}

	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
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

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RolesCatalogo [");
		if (identificadorRol != null) {
			builder.append("identificadorRol=");
			builder.append(identificadorRol);
			builder.append(", ");
		}
		if (claveRol != null) {
			builder.append("claveRol=");
			builder.append(claveRol);
			builder.append(", ");
		}
		if (descripcionRol != null) {
			builder.append("descripcionRol=");
			builder.append(descripcionRol);
			builder.append(", ");
		}
		if (fecha != null) {
			builder.append("fecha=");
			builder.append(fecha);
			builder.append(", ");
		}
		if (usuario != null) {
			builder.append("usuario=");
			builder.append(usuario);
			builder.append(", ");
		}
		if (claveAfore != null) {
			builder.append("claveAfore=");
			builder.append(claveAfore);
		}
		builder.append("]");
		return builder.toString();
	}
		
}