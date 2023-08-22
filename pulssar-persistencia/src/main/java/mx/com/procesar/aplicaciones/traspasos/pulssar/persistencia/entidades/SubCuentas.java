package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
/**
 * Datos entrada SubCuentas 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Jun 11, 2021
 */
public class SubCuentas implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 4013337391783870004L;

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
	 * @return el atributo subcuentasDesc
	 */
	public String getSubcuentasDesc() {
		return subcuentasDesc;
	}

	/**
	 * @param subcuentasDesc parametro subcuentasDesc a actualizar
	 */
	public void setSubcuentasDesc(String subcuentasDesc) {
		this.subcuentasDesc = subcuentasDesc;
	}

	/**
	 * @return el atributo claveSubcuenta
	 */
	public String getClaveSubcuenta() {
		return claveSubcuenta;
	}

	/**
	 * @param claveSubcuenta parametro claveSubcuenta a actualizar
	 */
	public void setClaveSubcuenta(String claveSubcuenta) {
		this.claveSubcuenta = claveSubcuenta;
	}

	/**
	 * @return el atributo siefore
	 */
	public String getSiefore() {
		return siefore;
	}

	/**
	 * @param siefore parametro siefore a actualizar
	 */
	public void setSiefore(String siefore) {
		this.siefore = siefore;
	}

	/**
	 * @return el atributo monto
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @param monto parametro monto a actualizar
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}

	/**
	 * @return el atributo acciones
	 */
	public String getAcciones() {
		return acciones;
	}

	/**
	 * @param acciones parametro acciones a actualizar
	 */
	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}

	/**
	 * @return el atributo fechaValor
	 */
	public String getFechaValor() {
		return fechaValor;
	}

	/**
	 * @param fechaValor parametro fechaValor a actualizar
	 */
	public void setFechaValor(String fechaValor) {
		this.fechaValor = fechaValor;
	}

	/**
	 * @return el atributo precioAcciones
	 */
	public String getPrecioAcciones() {
		return precioAcciones;
	}

	/**
	 * @param precioAcciones parametro precioAcciones a actualizar
	 */
	public void setPrecioAcciones(String precioAcciones) {
		this.precioAcciones = precioAcciones;
	}

	/**
	 * @return el atributo campoSar92
	 */
	public String getCampoSar92() {
		return campoSar92;
	}

	/**
	 * @param campoSar92 parametro campoSar92 a actualizar
	 */
	public void setCampoSar92(String campoSar92) {
		this.campoSar92 = campoSar92;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubCuentas [subcuentasDesc=");
		builder.append(subcuentasDesc);
		builder.append(", claveSubcuenta=");
		builder.append(claveSubcuenta);
		builder.append(", siefore=");
		builder.append(siefore);
		builder.append(", monto=");
		builder.append(monto);
		builder.append(", acciones=");
		builder.append(acciones);
		builder.append(", fechaValor=");
		builder.append(fechaValor);
		builder.append(", precioAcciones=");
		builder.append(precioAcciones);
		builder.append(", campoSar92=");
		builder.append(campoSar92);
		builder.append("]");
		return builder.toString();
	}
	
	
}
