package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que contiene los datos base para la administración de turnos.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class TurnoBase implements Serializable {

	/**
	 * Serializaión de la clase.
	 */
	private static final long serialVersionUID = -8098629200176044804L;

	/**
	 * Determina el usuario en sesion.
	 */
	private Long idUsuario;
	
	/**
	 * Determina los roles de los usuarios en sesion.
	 */
	private List<String> rolesDelUsuarioEnSesion;

	/**
	 * Clave de la organización que es equivalente a la clave de la afore.
	 */
	private String claveOrganizacion;
	
	/**
	 * Numero de sucursal.
	 */
	private String numeroSucursal;

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the rolesDelUsuarioEnSesion
	 */
	public List<String> getRolesDelUsuarioEnSesion() {
		return rolesDelUsuarioEnSesion;
	}

	/**
	 * @param rolesDelUsuarioEnSesion the rolesDelUsuarioEnSesion to set
	 */
	public void setRolesDelUsuarioEnSesion(List<String> rolesDelUsuarioEnSesion) {
		this.rolesDelUsuarioEnSesion = rolesDelUsuarioEnSesion;
	}

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
	 * @return the numeroSucursal
	 */
	public String getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * @param numeroSucursal the numeroSucursal to set
	 */
	public void setNumeroSucursal(String numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
