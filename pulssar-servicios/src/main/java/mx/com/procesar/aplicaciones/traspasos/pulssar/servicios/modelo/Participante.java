/**
 * Participante.java
 * Fecha de creación: Mar 8, 2019, 4:53:51 PM
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
import java.math.BigDecimal;
import java.util.Date;


/**
 * mapeo de la tabla NSAR_TR_PARTICIPANTE
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 8, 2019
 */
public class Participante implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 742503676755798135L;

	/**
	 * id
	 */
	private long idProcesar;

	/**
	 * correo electronico
	 */
	private String chCorreoElectronico;

	/**
	 * usuario modificador
	 */
	private String chUsuarioModificador;

	/**
	 * fecha
	 */
	private Date fcControl;

	/**
	 * activo
	 */
	private BigDecimal nuActivo;

	/**
	 * rfc
	 */
	private String rfc;


	
	/**
	 * @return the idProcesar
	 */
	public long getIdProcesar() {
		return idProcesar;
	}



	/**
	 * @param idProcesar the idProcesar to set
	 */
	public void setIdProcesar(long idProcesar) {
		this.idProcesar = idProcesar;
	}



	/**
	 * @return the chCorreoElectronico
	 */
	public String getChCorreoElectronico() {
		return chCorreoElectronico;
	}



	/**
	 * @param chCorreoElectronico the chCorreoElectronico to set
	 */
	public void setChCorreoElectronico(String chCorreoElectronico) {
		this.chCorreoElectronico = chCorreoElectronico;
	}



	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}



	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}



	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}



	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}



	/**
	 * @return the nuActivo
	 */
	public BigDecimal getNuActivo() {
		return nuActivo;
	}



	/**
	 * @param nuActivo the nuActivo to set
	 */
	public void setNuActivo(BigDecimal nuActivo) {
		this.nuActivo = nuActivo;
	}



	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}



	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Participante [idProcesar=");
		builder.append(idProcesar);
		builder.append(", chCorreoElectronico=");
		builder.append(chCorreoElectronico);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append("]");
		return builder.toString();
	}
	

}
