package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Objeto de Respuesta
 * 
 * @author mahernan
 */
public class Respuesta extends RespuestaServicio implements Serializable  {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -4040515038936027951L;

	/**
	 * Objeto de respuesta
	 */
	private Object objetoRespuesta;

	/**
	 * Lista de objectos
	 */
	private List<?> listaRespuesta;

	/**
	 * Flujo del mensaje
	 */
	private Map<String, Object> mapaRespuesta;

	/**
	 * @return the objetoRespuesta
	 */
	public Object getObjetoRespuesta() {
		return objetoRespuesta;
	}

	/**
	 * @param objetoRespuesta the objetoRespuesta to set
	 */
	public void setObjetoRespuesta(Object objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	/**
	 * @return the listaRespuesta
	 */
	public List<?> getListaRespuesta() {
		return listaRespuesta;
	}

	/**
	 * @param listaRespuesta the listaRespuesta to set
	 */
	public void setListaRespuesta(List<?> listaRespuesta) {
		this.listaRespuesta = listaRespuesta;
	}

	/**
	 * @return the mapaRespuesta
	 */
	public Map<String, Object> getMapaRespuesta() {
		return mapaRespuesta;
	}

	/**
	 * @param mapaRespuesta the mapaRespuesta to set
	 */
	public void setMapaRespuesta(Map<String, Object> mapaRespuesta) {
		this.mapaRespuesta = mapaRespuesta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Respuesta [");
		if (objetoRespuesta != null) {
			builder.append("objetoRespuesta=");
			builder.append(objetoRespuesta);
			builder.append(", ");
		}
		if (listaRespuesta != null) {
			builder.append("listaRespuesta=");
			builder.append(toString(listaRespuesta, maxLen));
			builder.append(", ");
		}
		if (mapaRespuesta != null) {
			builder.append("mapaRespuesta=");
			builder.append(toString(mapaRespuesta.entrySet(), maxLen));
		}
		builder.append("]");
		return builder.toString();
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	
}
