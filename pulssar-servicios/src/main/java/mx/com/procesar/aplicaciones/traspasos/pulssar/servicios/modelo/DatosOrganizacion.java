package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;




/**
 * Representa la entidad de Organizaciones, mapeado a la tabla PSER_TC_ORGANIZACION
 * 
 * @author DBARBOSA
 */

public class DatosOrganizacion extends CorreoCorporativo implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2486531843812453465L;
	
	/**
	 * Identificador de la Organización.
	 */
	private String clave;
	
	/**
	 * Nombre de organización.
	 */
	private String descripcionOrganizacion;
	
	/**
	 * Fecha de ultima modificación.
	 */
	private Date fecha;
	
	/**
	 * Indicador de activo/inactivo
	 */
	private String usuario;
	
	/**
	 * @return the claveOrganizacion
	 */
	@Override
	public String getClave() {
		return clave;
	}
	
	/**
	 * constructor super
	 */
	public DatosOrganizacion(){
		super();
	}
	
	/**
	 * constructor super
	 */
	public DatosOrganizacion(CorreoCorporativo correo){
		super(correo.getClave(),correo.getEmail(),correo.getEstatus(),
				correo.getFecha(),correo.getUsuario());
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaven(String clave) {
		this.clave = clave;
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
	@Override
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	@Override
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuario
	 */
	@Override
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	/**
	 * @param clave the clave to set
	 */
	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Organizacion [clave=");
		builder.append(clave);
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