package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa la entidad de Correos de Organizacion, mapeado a la tabla PSER_TR_CORREO_CORP_PULSSAR
 * 
 * @author DBARBOSA
 */

public class CorreoCorporativo implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1575952515569341996L;

	/**
	 * Identificador de la Organización.
	 */
	private String clave;
	
	/**
	 * Dominio de Correo Corporativo.
	 */
	private String email;
	
	/**
	 * Estatus del registro de dominio (1- Activo, 0 Inactivo).
	 */
	private Integer estatus;
	
	/**
	 * Fecha de ultima modificación.
	 */
	private Date fecha;
	
	/**
	 * Indicador de activo/inactivo
	 */
	private String usuario;
	
	
	public CorreoCorporativo(){
		super();
	}
	
	public CorreoCorporativo(String clave,String email,
			Integer estatus,Date fecha,String usuario){
		super();
		this.clave = clave;
		this.email = email;
		this.estatus = estatus;
		this.fecha = fecha;
		this.usuario = usuario;
	}

	/**
	 * @return the claveOrganizacion
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
		builder.append("CorreoCorporativo [clave=");
		builder.append(clave);
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