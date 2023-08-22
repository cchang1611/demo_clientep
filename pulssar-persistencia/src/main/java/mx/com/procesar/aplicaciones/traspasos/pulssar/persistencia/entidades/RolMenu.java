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
 * Representa la entidad de relacion de rol menu
 * 
 * @author mahernan
 */
@Entity
@Table(name = "PSER_TC_ROL_MENU")
public class RolMenu implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6584672607563182518L;

	/**
	 * Identificador unico de registro.
	 */
	@Id
	@Column(name = "ID_ROL_MENU")
	private Long identificadorRolMenu;
		
	/**
	 * Identificador de rol
	 */
	@Column(name = "ID_ROL_PULSSAR")
	private Long identificadorRol;
	
	/**
	 * Identificador del menu.
	 */
	@Column(name = "ID_MENU_PAGINA")
	private Long identificadorMenu;
	
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

	
	@Column(name = "NU_ACTIVO")
	private Integer activo;
	
	
	/**
	 * @return
	 */
	public Integer getActivo() {
		return activo;
	}

	/**
	 * @param activo
	 */
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	/**
	 * @return the identificadorRolMenu
	 */
	public Long getIdentificadorRolMenu() {
		return identificadorRolMenu;
	}

	/**
	 * @param identificadorRolMenu the identificadorRolMenu to set
	 */
	public void setIdentificadorRolMenu(Long identificadorRolMenu) {
		this.identificadorRolMenu = identificadorRolMenu;
	}

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
	 * @return the identificadorMenu
	 */
	public Long getIdentificadorMenu() {
		return identificadorMenu;
	}

	/**
	 * @param identificadorMenu the identificadorMenu to set
	 */
	public void setIdentificadorMenu(Long identificadorMenu) {
		this.identificadorMenu = identificadorMenu;
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
		builder.append("RolMenu [");
		if (activo != null) {
			builder.append("activo=");
			builder.append(activo);
			builder.append(", ");
		}
		if (identificadorRolMenu != null) {
			builder.append("identificadorRolMenu=");
			builder.append(identificadorRolMenu);
			builder.append(", ");
		}
		if (identificadorRol != null) {
			builder.append("identificadorRol=");
			builder.append(identificadorRol);
			builder.append(", ");
		}
		if (identificadorMenu != null) {
			builder.append("identificadorMenu=");
			builder.append(identificadorMenu);
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
		}
		builder.append("]");
		return builder.toString();
	}
	
}