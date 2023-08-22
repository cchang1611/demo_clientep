package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Municipios
 * 
 * @author MEDOMING
 *
 */
public class MunicipiosList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -2029197011066821454L;
	
	/**
	 * listaMunicipios
	 */
	private List<NsarMunicipio> listaMunicipios;
	
	/**
	 * @return listaMunicipios
	 */
	public List<NsarMunicipio> getListaMunicipios() {
		return listaMunicipios;
	}

	/**
	 * @param listaMunicipios the listaMunicipios to set
	 */
	public void setListaMunicipios(List<NsarMunicipio> listaMunicipios) {
		this.listaMunicipios = listaMunicipios;
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
		builder.append("MunicipiosList [listaMunicipios=");
		builder.append(listaMunicipios);
		builder.append("]");
		return builder.toString();
	}

}

