package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
/**
 *  Para mostrar clave y descripcin de los combos
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 22, 2021
 */
public class ProcesoDerechoCargadoSalida implements Serializable{

	/**
	 * TODO [Agregar documentación del atributo]
	 */
	private static final long serialVersionUID = 6877005207665393250L;

	/**
	 * clave
	 */
	private String clave;
	
	/**
	 * descripcion
	 */
	private String descripcion;

	/**
	 * @return el atributo clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave parametro clave a actualizar
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoDerechoCargadoSalida [clave=");
		builder.append(clave);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
