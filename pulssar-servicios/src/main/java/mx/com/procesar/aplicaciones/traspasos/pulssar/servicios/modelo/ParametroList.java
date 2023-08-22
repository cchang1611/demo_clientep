package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Parametros (PSER_TC_PARAMETRO)
 * 
 * @author MEDOMING
 *
 */
public class ParametroList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -6009194846144045947L;
	
	/**
	 * listaParametros
	 */
	private List<Parametro> listaParametros;

	/**
	 * @return listaParametros
	 */
	public List<Parametro> getListaParametros() {
		return listaParametros;
	}

	/**
	 * @param listaParametros the listaParametros to set
	 */
	public void setListaParametros(List<Parametro> listaParametros) {
		this.listaParametros = listaParametros;
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
		builder.append("ParametroList [listaParametros=");
		builder.append(listaParametros);
		builder.append("]");
		return builder.toString();
	}

}
