/**
 * DatosDocumentoPdf.java
 * Fecha de creación: Jul 26, 2019, 2:44:02 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;


/**
 * clase que engloba los datos de todos los PDF's que se van a generar
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jul 26, 2019
 */
public class DatosDocumentoPdf implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -259253297254877825L;

	/**
	 * objeto con los datos del documento
	 */
	private Object datos;
	
	/**
	 * URL de la página a la que se va a dirigir
	 * despues de mostrar el PDF
	 */
	private String urlPaginaSiguiente;
	
	/**
	 * metodo http de la pagina siguiente
	 */
	private String metodoPaginaSiguiente;

	/**
	 * @return el atributo datos
	 */
	public Object getDatos() {
		return datos;
	}

	/**
	 * @param datos parametro datos a actualizar
	 */
	public void setDatos(Object datos) {
		this.datos = datos;
	}

	/**
	 * @return el atributo urlPaginaSiguiente
	 */
	public String getUrlPaginaSiguiente() {
		return urlPaginaSiguiente;
	}

	/**
	 * @param urlPaginaSiguiente parametro urlPaginaSiguiente a actualizar
	 */
	public void setUrlPaginaSiguiente(String urlPaginaSiguiente) {
		this.urlPaginaSiguiente = urlPaginaSiguiente;
	}
	
	/**
	 * @return el atributo metodoPaginaSiguiente
	 */
	public String getMetodoPaginaSiguiente() {
		return metodoPaginaSiguiente;
	}

	/**
	 * @param metodoPaginaSiguiente parametro metodoPaginaSiguiente a actualizar
	 */
	public void setMetodoPaginaSiguiente(String metodoPaginaSiguiente) {
		this.metodoPaginaSiguiente = metodoPaginaSiguiente;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosDocumentoPdf [datos=");
		builder.append(datos);
		builder.append(", urlPaginaSiguiente=");
		builder.append(urlPaginaSiguiente);
		builder.append(", metodoPaginaSiguiente=");
		builder.append(metodoPaginaSiguiente);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
