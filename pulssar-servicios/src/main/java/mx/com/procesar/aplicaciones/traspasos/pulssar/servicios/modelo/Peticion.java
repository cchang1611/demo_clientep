package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Datos de entrada de la peticion
 * @author ANOSORIO
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Peticion<T> implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8382524334954041260L;
	
	/**
	 * foliohijo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long foliohijo;
	/**
	 * peticion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private T peticion;
	/**
	 * @return el atributo folioHijo
	 */
	public Long getFoliohijo() {
		return foliohijo;
	}
	/**
	 * @param folioHijo parametro folioHijo a actualizar
	 */
	public void setFoliohijo(Long foliohijo) {
		this.foliohijo = foliohijo;
	}
	/**
	 * @return el atributo peticion
	 */
	public T getPeticion() {
		return peticion;
	}
	/**
	 * @param peticion parametro peticion a actualizar
	 */
	public void setPeticion(T peticion) {
		this.peticion = peticion;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Peticion [foliohijo=");
		builder.append(foliohijo);
		builder.append(", peticion=");
		builder.append(peticion);
		builder.append("]");
		return builder.toString();
	}

}
