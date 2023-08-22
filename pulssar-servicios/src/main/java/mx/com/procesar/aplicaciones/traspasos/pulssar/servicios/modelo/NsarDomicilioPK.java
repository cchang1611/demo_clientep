/**
 * NsarDomicilioPK.java
 * Fecha de creación: Mar 27, 2019, 12:41:14 PM
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
 * llave primaria de la tabla NSAR_TR_DOMICILIO
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 27, 2019
 */
public class NsarDomicilioPK implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1189105528325216447L;

	/**
	 * id de procesar
	 */
	private long idProcesar;

	/**
	 * id del tipo de domicilio
	 */
	private long idTipoDomicilio;

	/**
	 * @return el atributo idProcesar
	 */
	public long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar parametro idProcesar a actualizar
	 */
	public void setIdProcesar(long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return el atributo idTipoDomicilio
	 */
	public long getIdTipoDomicilio() {
		return idTipoDomicilio;
	}

	/**
	 * @param idTipoDomicilio parametro idTipoDomicilio a actualizar
	 */
	public void setIdTipoDomicilio(long idTipoDomicilio) {
		this.idTipoDomicilio = idTipoDomicilio;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NsarDomicilioPK)) {
			return false;
		}
		NsarDomicilioPK castOther = (NsarDomicilioPK)other;
		return 
			(this.idProcesar == castOther.idProcesar)
			&& (this.idTipoDomicilio == castOther.idTipoDomicilio);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idProcesar ^ (this.idProcesar >>> 32)));
		hash = hash * prime + ((int) (this.idTipoDomicilio ^ (this.idTipoDomicilio >>> 32)));
		
		return hash;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("NsarDomicilioPK [idProcesar=");
		cadena.append(idProcesar);
		cadena.append(", idTipoDomicilio=");
		cadena.append(idTipoDomicilio);
		cadena.append("]");
		
		return cadena.toString();
	}
	
	
	
}
