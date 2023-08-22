package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Input del servicio ConsultarCatalogos
 * 
 * @author JMGUTIEG
 * 
 */
public class EntradaCatalogoCodigoPostal implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Filtros
	 */
	private List<FiltroData> filtros;

	/**
	 * Nombre del catalogo
	 */
	@JsonProperty("nombre-catalogo")
	private String nombreCatalogo;
	
	/**
	 * Constructor
	 */
	public EntradaCatalogoCodigoPostal(){
		
	}

	/**
	 * @return the filtros
	 */
	public List<FiltroData> getFiltros() {
		return filtros;
	}

	/**
	 * @param filtros the filtros to set
	 */
	public void setFiltros(List<FiltroData> filtros) {
		this.filtros = filtros;
	}

	/**
	 * @return the nombreCatalogo
	 */
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	/**
	 * @param nombreCatalogo the nombreCatalogo to set
	 */
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaCatalogoCodigoPostal [filtros=");
		builder.append(filtros);
		builder.append(", nombreCatalogo=");
		builder.append(nombreCatalogo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
