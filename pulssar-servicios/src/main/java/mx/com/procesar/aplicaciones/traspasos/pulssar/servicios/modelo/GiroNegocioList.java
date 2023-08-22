package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Giros
 * 
 * @author MEDOMING
 *
 */
public class GiroNegocioList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -3167581544789311176L;
	
	/**
	 * listaGiro
	 */
	private List<GiroNegocio> listaGiro;
	
	/**
	 * @return listaGiro
	 */
	public List<GiroNegocio> getListaGiro() {
		return listaGiro;
	}

	/**
	 * @param listaGiro the listaGiro to set
	 */
	public void setListaGiro(List<GiroNegocio> listaGiro) {
		this.listaGiro = listaGiro;
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
		builder.append("GiroNegocioList [listaGiro=");
		builder.append(listaGiro);
		builder.append("]");
		return builder.toString();
	}

}

