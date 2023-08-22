package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * clase que contiene los atributos de la entrada de consultar roles
 * 
 * @author rarreola
 * @version 1.0
 */
public class DatosEntradaRolesMenu implements Serializable{

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista de roles
	 */
	private List<Long> identificadoresRoles;

	/**
	 * @return the clavesRoles
	 */
	public List<Long> getIdentificadoresRoles() {
		return identificadoresRoles;
	}

	/**
	 * @param clavesRoles the clavesRoles to set
	 */
	public void setIdentificadoresRoles(List<Long> identificadoresRoles) {
		this.identificadoresRoles = identificadoresRoles;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("DatosEntradaRolesMenu [identificadoresRoles=");
		builder.append(identificadoresRoles);
		builder.append("]");

		return builder.toString();
	}

}
