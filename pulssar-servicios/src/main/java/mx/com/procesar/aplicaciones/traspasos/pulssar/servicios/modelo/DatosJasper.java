package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Map;

/**
 * Objeto archivos jasper
 */
public class DatosJasper implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -3632589715638928498L;

	/**
	 * Nombre Jasper
	 */
	private String docJasper;
	
	/**
	 * Nombre Jasper
	 */
	private String docPdf;
	
	/**
	 * Mapa de objetos
	 */
	private Map<String, Object> mapObjects;
	
	/**
	 * Mapa de objetos
	 */
	private Map<String, String> mapImagenes;
	
	/**
	 * Objeto del Pdf
	 */
	private Object oPdf;
	
	/**
	 * @return the docJasper
	 */
	public String getDocJasper() {
		return docJasper;
	}

	/**
	 * @param docJasper the docJasper to set
	 */
	public void setDocJasper(String docJasper) {
		this.docJasper = docJasper;
	}

	/**
	 * @return the docPdf
	 */
	public String getDocPdf() {
		return docPdf;
	}

	/**
	 * @param docPdf the docPdf to set
	 */
	public void setDocPdf(String docPdf) {
		this.docPdf = docPdf;
	}

	/**
	 * @return the mapObjects
	 */
	public Map<String, Object> getMapObjects() {
		return mapObjects;
	}

	/**
	 * @param mapObjects the mapObjects to set
	 */
	public void setMapObjects(Map<String, Object> mapObjects) {
		this.mapObjects = mapObjects;
	}

	/**
	 * @return the mapImagenes
	 */
	public Map<String, String> getMapImagenes() {
		return mapImagenes;
	}

	/**
	 * @param mapImagenes the mapImagenes to set
	 */
	public void setMapImagenes(Map<String, String> mapImagenes) {
		this.mapImagenes = mapImagenes;
	}

	/**
	 * @return the oPdf
	 */
	public Object getoPdf() {
		return oPdf;
	}

	/**
	 * @param oPdf the oPdf to set
	 */
	public void setoPdf(Object oPdf) {
		this.oPdf = oPdf;
	}

	/**
	 * Convierte a cadena todo el objeto
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosJasper [docJasper=");
		builder.append(docJasper);
		builder.append(", docPdf=" );
		builder.append(docPdf);
		builder.append(", mapObjects=" );
		builder.append(mapObjects);
		builder.append(", mapImagenes=" );
		builder.append(mapImagenes);
		builder.append(", oPdf=" );
		builder.append(oPdf);
		builder.append("]");
		return builder.toString();
	}
}