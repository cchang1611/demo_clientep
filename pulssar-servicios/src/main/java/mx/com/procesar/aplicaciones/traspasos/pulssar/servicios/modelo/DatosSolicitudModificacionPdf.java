package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Arrays;

public class DatosSolicitudModificacionPdf implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4089059349575656563L;

	private String contenido;
	
	private String pagina1;
	
	private String pagina2;
	
	private byte[] contenidoBytes;
	
	private String ruta;
	
	private String rutaPdf;
	
	private int numeroPaginas;

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @return the pagina1
	 */
	public String getPagina1() {
		return pagina1;
	}

	/**
	 * @param pagina1 the pagina1 to set
	 */
	public void setPagina1(String pagina1) {
		this.pagina1 = pagina1;
	}

	/**
	 * @return the pagina2
	 */
	public String getPagina2() {
		return pagina2;
	}

	/**
	 * @param pagina2 the pagina2 to set
	 */
	public void setPagina2(String pagina2) {
		this.pagina2 = pagina2;
	}

	/**
	 * @return the contenidoBytes
	 */
	public byte[] getContenidoBytes() {
		return contenidoBytes;
	}

	/**
	 * @param contenidoBytes the contenidoBytes to set
	 */
	public void setContenidoBytes(byte[] contenidoBytes) {
		this.contenidoBytes = contenidoBytes;
	}	

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the rutaPdf
	 */
	public String getRutaPdf() {
		return rutaPdf;
	}

	/**
	 * @param rutaPdf the rutaPdf to set
	 */
	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}

	/**
	 * @return the numeroPaginas
	 */
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * @param numeroPaginas the numeroPaginas to set
	 */
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosSolicitudModificacionPdf [contenido=");
		builder.append(contenido);
		builder.append(", pagina1=");
		builder.append(pagina1);
		builder.append(", pagina2=");
		builder.append(pagina2);
		builder.append(", contenidoBytes=");
		builder.append(Arrays.toString(contenidoBytes));
		builder.append(", ruta=");
		builder.append(ruta);
		builder.append(", rutaPdf=");
		builder.append(rutaPdf);
		builder.append(", numeroPaginas=");
		builder.append(numeroPaginas);
		builder.append("]");
		return builder.toString();
	}


	

}
