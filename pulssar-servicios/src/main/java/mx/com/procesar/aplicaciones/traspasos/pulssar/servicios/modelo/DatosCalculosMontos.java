package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Campos para mostrar en los calculos de vivienda y rcv
 * @author RARREOLA
 *
 */
public class DatosCalculosMontos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Descripcion subcuenta
	 */
	private String descripcionSubcuenta;
	
	/**
	 * Clave subcuenta
	 */
	private String claveSubcuenta;
	
	/**
	 * Monto
	 */
	private String monto;
	
	/**
	 * Precio de accion
	 */
	private String precioAccion;
	
	/**
	 * Fecha valor
	 */
	private String fechaValor;
	
	/**
	 * acciones
	 */
	private String acciones;
	
	/**
	 * Campo Sar
	 */
	private String campoSar;
	
	/**
	 * Tabla
	 */
	private String tabla;
	
	/**
	 * sinPrecioAccion
	 */
	private String sinPrecioAccion;
	
	/**
	 * Monto total
	 */
	private String montoTotalSuma;
	
	/**
	 * @return the descripcionSubcuenta
	 */
	public String getDescripcionSubcuenta() {
		return descripcionSubcuenta;
	}




	/**
	 * @param descripcionSubcuenta the descripcionSubcuenta to set
	 */
	public void setDescripcionSubcuenta(String descripcionSubcuenta) {
		this.descripcionSubcuenta = descripcionSubcuenta;
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
	 * @return the precioAccion
	 */
	public String getPrecioAccion() {
		return precioAccion;
	}




	/**
	 * @param precioAccion the precioAccion to set
	 */
	public void setPrecioAccion(String precioAccion) {
		this.precioAccion = precioAccion;
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
	 * @return the campoSar
	 */
	public String getCampoSar() {
		return campoSar;
	}




	/**
	 * @param campoSar the campoSar to set
	 */
	public void setCampoSar(String campoSar) {
		this.campoSar = campoSar;
	}




	/**
	 * @return the tabla
	 */
	public String getTabla() {
		return tabla;
	}




	/**
	 * @param tabla the tabla to set
	 */
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}




	/**
	 * @return the sinPrecioAccion
	 */
	public String getSinPrecioAccion() {
		return sinPrecioAccion;
	}




	






	/**
	 * @param sinPrecioAccion the sinPrecioAccion to set
	 */
	public void setSinPrecioAccion(String sinPrecioAccion) {
		this.sinPrecioAccion = sinPrecioAccion;
	}




	/**
	 * @return the montoTotalSuma
	 */
	public String getMontoTotalSuma() {
		return montoTotalSuma;
	}




	/**
	 * @param montoTotalSuma the montoTotalSuma to set
	 */
	public void setMontoTotalSuma(String montoTotalSuma) {
		this.montoTotalSuma = montoTotalSuma;
	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
