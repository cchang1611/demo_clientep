package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Datos resolucion
 * @author RARREOLA
 *
 */
public class DatosResolucionMod implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6921601524189409698L;
	
	/**
	 * Resolucion
	 */
	private Long idResolucion;
	
	/**
	 * Numero resolucion
	 */
	private String numeroResolucion;
	
	
	/**
	 * MAtriz convivencia
	 */
	private String matrizConvivencia;


	/**
	 * @return the numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}


	/**
	 * @param numeroResolucion the numeroResolucion to set
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}


	/**
	 * @return the matrizConvivencia
	 */
	public String getMatrizConvivencia() {
		return matrizConvivencia;
	}


	/**
	 * @param matrizConvivencia the matrizConvivencia to set
	 */
	public void setMatrizConvivencia(String matrizConvivencia) {
		this.matrizConvivencia = matrizConvivencia;
	}
	
	
	/**
	 * @return the idResolucion
	 */
	public Long getIdResolucion() {
		return idResolucion;
	}


	/**
	 * @param idResolucion the idResolucion to set
	 */
	public void setIdResolucion(Long idResolucion) {
		this.idResolucion = idResolucion;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("DatosResolucionMod [numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", matrizConvivencia=");
		builder.append(matrizConvivencia);
		builder.append(", idResolucion=");
		builder.append(idResolucion);
		builder.append("]");

		return builder.toString();
	}

}
