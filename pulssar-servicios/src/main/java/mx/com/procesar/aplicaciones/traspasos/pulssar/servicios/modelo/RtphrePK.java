/**
 * RtphrePK.java
 * Fecha de creación: Jul 2, 2019, 5:31:07 PM
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
import java.util.Date;

/**
 * llave primaria de la tabla RTPHRE
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jul 2, 2019
 */
public class RtphrePK implements Serializable {

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -2344748450469598376L;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * fecha de retiro de afore
	 */
	private Date fechaRetiroAfore;


	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo fechaRetAfore
	 */
	public Date getFechaRetiroAfore() {
		return fechaRetiroAfore;
	}

	/**
	 * @param fechaRetAfore parametro fechaRetAfore a actualizar
	 */
	public void setFechaRetiroAfore(Date fechaRetiroAfore) {
		this.fechaRetiroAfore = fechaRetiroAfore;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RtphrePK)) {
			return false;
		}
		RtphrePK castOther = (RtphrePK)other;
		return 
			this.nss.equals(castOther.nss)
			&& this.fechaRetiroAfore.equals(castOther.fechaRetiroAfore);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int hash = 17;
		hash = hash * PRIME + this.nss.hashCode();
		hash = hash * PRIME + this.fechaRetiroAfore.hashCode();
		
		return hash;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("RtphrePK [nss=").append(nss);
		cadena.append(", fechaRetiroAfore=").append(fechaRetiroAfore);
		return cadena.toString();
	}
	
	
}
