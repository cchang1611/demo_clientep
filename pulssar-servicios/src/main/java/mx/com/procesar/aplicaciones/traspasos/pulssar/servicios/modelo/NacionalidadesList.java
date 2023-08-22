package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Nacionalidades
 * 
 * @author MEDOMING
 *
 */
public class NacionalidadesList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = 8289728372690038319L;
	
	/**
	 * listaNacionalidades
	 */
	private List<Nacionalidad> listaNacionalidades;
	
	/**
	 * @return listaNacionalidades
	 */
	public List<Nacionalidad> getListaNacionalidades() {
		return listaNacionalidades;
	}

	/**
	 * @param listaNacionalidades the listaNacionalidades to set
	 */
	public void setListaNacionalidades(List<Nacionalidad> listaNacionalidades) {
		this.listaNacionalidades = listaNacionalidades;
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
		builder.append("NacionalidadesList [listaNacionalidades=");
		builder.append(listaNacionalidades);
		builder.append("]");
		return builder.toString();
	}

}
