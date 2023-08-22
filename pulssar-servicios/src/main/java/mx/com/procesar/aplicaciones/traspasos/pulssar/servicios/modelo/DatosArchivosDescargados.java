package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * 
 * Clase datos archivo descargados
 *
 */
public class DatosArchivosDescargados implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 8564253903690248684L;
	
	
	/**
	 * 	nombre del archivos
	 */
	private String nombreArchivo;
	
	/**
	 * byte del archivo 
	 */
	private String byteArchivo;
	
	/**
	 * formato del archivo
	 */
	private String formato;
	
	/**
	 * Titulo Archivo
	 */
	private String tituloArchivo;

	/**
	 * @return el atributo nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo parametro nombreArchivo a actualizar
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return el atributo byteArchivo
	 */
	public String getByteArchivo() {
		return byteArchivo;
	}

	/**
	 * @param byteArchivo parametro byteArchivo a actualizar
	 */
	public void setByteArchivo(String byteArchivo) {
		this.byteArchivo = byteArchivo;
	}

	/**
	 * @return el atributo formato
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * @param formato parametro formato a actualizar
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * @return el atributo tituloArchivo
	 */
	public String getTituloArchivo() {
		return tituloArchivo;
	}

	/**
	 * @param tituloArchivo parametro tituloArchivo a actualizar
	 */
	public void setTituloArchivo(String tituloArchivo) {
		this.tituloArchivo = tituloArchivo;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosArchivosDescargados [nombreArchivo=");
		builder.append(nombreArchivo);
		builder.append(", formato=");
		builder.append(formato);
		builder.append(", tituloArchivo=");
		builder.append(tituloArchivo);
		builder.append("]");
		return builder.toString();
	}	

}
