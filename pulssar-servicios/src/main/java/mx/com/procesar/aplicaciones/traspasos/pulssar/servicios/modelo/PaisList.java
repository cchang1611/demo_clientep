package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Paises
 * 
 * @author MEDOMING
 *
 */
public class PaisList implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 431604881227903005L;
	
	/**
	 * listaPaises
	 */
	private List<Pais> listaPaises;

	/**
	 * @return listaPaises
	 */
	public List<Pais> getListaPaises() {
		return listaPaises;
	}

	/**
	 * @param listaPaises the listaPaises to set
	 */
	public void setListaPaises(List<Pais> listaPaises) {
		this.listaPaises = listaPaises;
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
		builder.append("PaisList [listaPaises=");
		builder.append(listaPaises);
		builder.append("]");
		return builder.toString();
	}

}
