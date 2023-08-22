package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * clase que contiene los atributos de la entrada de consultar roles
 * 
 * @author rarreola
 * @version 1.0
 */
public class DatosEntradaRolesMenuLista implements Serializable{

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista de roles
	 */
	private List<Long> identificadoresRoles;
	
	/**
	 * Clave de afore
	 */
	private String claveAfore;

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
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append("]");

		return builder.toString();
	}

}
