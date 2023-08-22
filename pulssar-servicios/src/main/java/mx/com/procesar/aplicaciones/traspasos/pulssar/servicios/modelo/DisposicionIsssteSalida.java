package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Datos entrada disposicion issste
 * @author RARREOLA
 *
 */
public class DisposicionIsssteSalida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * clave
	 */
	private String clave;
	
	/**
	 * descripcion
	 */
	private String descripcion;
	
	
	
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}



	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}



	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}



	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("DisposicionIsssteSalida [clave=");
			builder.append(clave);
			builder.append(", descripcion=");
			builder.append(descripcion);
		
			builder.append("]");
			return builder.toString();
		}
	
	
	
	
	

}
