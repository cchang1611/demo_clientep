package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Datos generales de disposicion issste
 * @author RARREOLA
 *
 */
public class DatosSubcuentasDispIssste implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129922942388139349L;

	
	
	/**
	 * subcuentas desc
	 */
	private String subcuentasDesc;
	
	/**
	 * clave subcuenta
	 */
	private String claveSubcuenta;
	
	/**
	 * siefore
	 */
	private String siefore;
	
	/**
	 * monto
	 */
	private String monto;
	
	/**
	 * acciones
	 */
	private String acciones;
	
	/**
	 * fecha valor
	 */
	private String fechaValor;
	
	/**
	 * precio acciones
	 */
	private String precioAcciones;
	
	/**
	 * Monto
	 */
	private String campoSar92;
	
	
	
	


	/**
	 * @return the campoSar92
	 */
	public String getCampoSar92() {
		return campoSar92;
	}






	/**
	 * @param campoSar92 the campoSar92 to set
	 */
	public void setCampoSar92(String campoSar92) {
		this.campoSar92 = campoSar92;
	}






	/**
	 * @return the subcuentasDesc
	 */
	public String getSubcuentasDesc() {
		return subcuentasDesc;
	}






	/**
	 * @param subcuentasDesc the subcuentasDesc to set
	 */
	public void setSubcuentasDesc(String subcuentasDesc) {
		this.subcuentasDesc = subcuentasDesc;
	}






	/**
	 * @return the claveSubcuenta
	 */
	public String getClaveSubcuenta() {
		return claveSubcuenta;
	}






	/**
	 * @param claveSubcuenta the claveSubcuenta to set
	 */
	public void setClaveSubcuenta(String claveSubcuenta) {
		this.claveSubcuenta = claveSubcuenta;
	}






	/**
	 * @return the siefore
	 */
	public String getSiefore() {
		return siefore;
	}






	/**
	 * @param siefore the siefore to set
	 */
	public void setSiefore(String siefore) {
		this.siefore = siefore;
	}






	/**
	 * @return the monto
	 */
	public String getMonto() {
		return monto;
	}






	/**
	 * @param monto the monto to set
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}






	/**
	 * @return the acciones
	 */
	public String getAcciones() {
		return acciones;
	}






	/**
	 * @param acciones the acciones to set
	 */
	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}






	/**
	 * @return the fechaValor
	 */
	public String getFechaValor() {
		return fechaValor;
	}






	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(String fechaValor) {
		this.fechaValor = fechaValor;
	}






	/**
	 * @return the precioAcciones
	 */
	public String getPrecioAcciones() {
		return precioAcciones;
	}






	/**
	 * @param precioAcciones the precioAcciones to set
	 */
	public void setPrecioAcciones(String precioAcciones) {
		this.precioAcciones = precioAcciones;
	}






	











	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
