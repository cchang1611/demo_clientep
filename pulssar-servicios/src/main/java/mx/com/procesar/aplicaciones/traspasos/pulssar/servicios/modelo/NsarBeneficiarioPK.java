/**
 * NsarBeneficiarioPK.java
 * Fecha de creación: Mar 27, 2019, 11:43:40 AM
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
 * clave primaria de la tabla NSAR_TR_BENEFICIARIO
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 27, 2019
 */

public class NsarBeneficiarioPK implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -8333434608372737491L;

	/**
	 * id de procesar
	 */
	private long idProcesar;

	/**
	 * curp
	 */
	private String curp;

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
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
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
		if (!(other instanceof NsarBeneficiarioPK)) {
			return false;
		}
		NsarBeneficiarioPK castOther = (NsarBeneficiarioPK)other;
		return 
			(this.idProcesar == castOther.idProcesar)
			&& this.curp.equals(castOther.curp);
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
		hash = hash * prime + this.curp.hashCode();
		
		return hash;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("NsarBeneficiarioPK [idProcesar=");
		cadena.append(idProcesar);
		cadena.append(", curp=");
		cadena.append(curp);
		cadena.append("]");
		
		return cadena.toString();
	}
	
	
}
