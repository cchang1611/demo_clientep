/**
 * TipoOperacionPK.java
 * Fecha de creación: Apr 1, 2019, 1:24:03 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * llave de la tabla RETI_TC_TIPO_OPERACION
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 1, 2019
 */
@Embeddable
public class TipoOperacionPK implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -5421397269249451087L;

	/**
	 * clave del proceso
	 */
	@Column(name = "CV_PROCESO")
	private String claveProceso;

	/**
	 * tipo de operacion
	 */
	@Column(name = "CV_TIPO_OPERACION")
	private String tipoOperacion;

	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso
	 *            parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return el atributo tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion
	 *            parametro tipoOperacion a actualizar
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TipoOperacionPK)) {
			return false;
		}
		TipoOperacionPK castOther = (TipoOperacionPK) other;
		return this.claveProceso.equals(castOther.claveProceso) && this.tipoOperacion.equals(castOther.tipoOperacion);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int hash = 17;
		hash = hash * PRIME + this.claveProceso.hashCode();
		hash = hash * PRIME + this.tipoOperacion.hashCode();

		return hash;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("TipoOperacionPK [claveProceso=");
		cadena.append(claveProceso);
		cadena.append(", tipoOperacion=");
		cadena.append(tipoOperacion);
		cadena.append("]");

		return cadena.toString();
	}

}
