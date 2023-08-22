/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Datos de entrada para Recepcion de Imaganes
 * @author lvgonzal
 *
 */
public class EntradaRecepcionImagenes implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 6222765071198009025L;
	
	/**
	 * folio Padre
	 */
	private String folioPadre;
	
	/**
	 * folio Hijo
	 */
	private String folioHijo;
	
	/**
	 * clave tipo proceso
	 */
	private String tipoProceso;
	
	/**
	 * Estatus recepcion de imagenes
	 */
	private String estatusRecepcion;
	
	/**
	 * url Siguiente accion
	 */
	private String urlSiguiente;
	
	/**
	 * tipo
	 */
	private String tipo;

	/**
	 * @return the folioPadre
	 */
	public String getFolioPadre() {
		return folioPadre;
	}

	/**
	 * @param folioPadre the folioPadre to set
	 */
	public void setFolioPadre(String folioPadre) {
		this.folioPadre = folioPadre;
	}

	/**
	 * @return the folioHijo
	 */
	public String getFolioHijo() {
		return folioHijo;
	}

	/**
	 * @param folioHijo the folioHijo to set
	 */
	public void setFolioHijo(String folioHijo) {
		this.folioHijo = folioHijo;
	}

	/**
	 * @return the tipoProceso
	 */
	public String getTipoProceso() {
		return tipoProceso;
	}

	/**
	 * @param tipoProceso the tipoProceso to set
	 */
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	/**
	 * @return the estatusRecepcion
	 */
	public String getEstatusRecepcion() {
		return estatusRecepcion;
	}

	/**
	 * @param estatusRecepcion the estatusRecepcion to set
	 */
	public void setEstatusRecepcion(String estatusRecepcion) {
		this.estatusRecepcion = estatusRecepcion;
	}

	/**
	 * @return the urlSiguiente
	 */
	public String getUrlSiguiente() {
		return urlSiguiente;
	}

	/**
	 * @param urlSiguiente the urlSiguiente to set
	 */
	public void setUrlSiguiente(String urlSiguiente) {
		this.urlSiguiente = urlSiguiente;
	}

	/**
	 * @return el atributo tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo parametro tipo a actualizar
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaRecepcionImagenes [folioPadre=");
		builder.append(folioPadre);
		builder.append(", folioHijo=");
		builder.append(folioHijo);
		builder.append(", tipoProceso=");
		builder.append(tipoProceso);
		builder.append(", estatusRecepcion=");
		builder.append(estatusRecepcion);
		builder.append(", urlSiguiente=");
		builder.append(urlSiguiente);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
}
