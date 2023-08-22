package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * The persistent class for the IRET_TC_SUBCUENTA database table.
 * 
 */
@Entity
public class IrecTcSubcuenta implements Serializable {

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * CV_SUBCUENTA
	 */
	private String cvSubCuenta;
	

	/**
	 * CH_CLASIFICACION
	 */
	private String chClasificacion;
	
	/**
	 * CH_DESC_SUBCUENTA
	 */
	private String descSubcuenta;
	
	
	/**
	 * CH_DESC_SUBCUENTA
	 */
	private String subcuentaSaldo;
	
	/**
	 * FC_CONTROL
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;
	
	/**
	 * CH_USUARIO_MODIFICADOR
	 */
	private String chUsuarioModificador;
	
	
	
	

	/**
	 * @return the cvSubCuenta
	 */
	public String getCvSubCuenta() {
		return cvSubCuenta;
	}



	/**
	 * @param cvSubCuenta the cvSubCuenta to set
	 */
	public void setCvSubCuenta(String cvSubCuenta) {
		this.cvSubCuenta = cvSubCuenta;
	}



	/**
	 * @return the chClasificacion
	 */
	public String getChClasificacion() {
		return chClasificacion;
	}



	/**
	 * @param chClasificacion the chClasificacion to set
	 */
	public void setChClasificacion(String chClasificacion) {
		this.chClasificacion = chClasificacion;
	}



	/**
	 * @return the descSubcuenta
	 */
	public String getDescSubcuenta() {
		return descSubcuenta;
	}



	/**
	 * @param descSubcuenta the descSubcuenta to set
	 */
	public void setDescSubcuenta(String descSubcuenta) {
		this.descSubcuenta = descSubcuenta;
	}



	/**
	 * @return the subcuentaSaldo
	 */
	public String getSubcuentaSaldo() {
		return subcuentaSaldo;
	}



	/**
	 * @param subcuentaSaldo the subcuentaSaldo to set
	 */
	public void setSubcuentaSaldo(String subcuentaSaldo) {
		this.subcuentaSaldo = subcuentaSaldo;
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



	


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IrecTcSubcuenta [cvSubCuenta=");
		builder.append(cvSubCuenta);
		builder.append(", chClasificacion=");
		builder.append(chClasificacion);
		builder.append(", descSubcuenta=");
		builder.append(descSubcuenta);
		builder.append(", subcuentaSaldo=");
		builder.append(subcuentaSaldo);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	

	
	

}
