package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.springframework.stereotype.Component;


/**
* Representa la informacion del documento requerido con su descripcion
* @author MMORALES
* @version 1.0
* @since 
*/
@Component
public class DocumentoCompletoRequerido implements Serializable{
	
	
	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 7646792209009482769L;
	
	/**
	 * documentoRequerido
	 */
	private DocumentoRequerido documentoRequerido;
	/**
	 * descripcion
	 */
	private String descripcion;
	/**
	 * @return the documentoRequerido
	 */
	public DocumentoRequerido getDocumentoRequerido() {
		return documentoRequerido;
	}
	/**
	 * @param documentoRequerido the documentoRequerido to set
	 */
	public void setDocumentoRequerido(DocumentoRequerido documentoRequerido) {
		this.documentoRequerido = documentoRequerido;
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
		builder.append("DocumentoCompletoRequerido [documentoRequerido=");
		builder.append(documentoRequerido);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
