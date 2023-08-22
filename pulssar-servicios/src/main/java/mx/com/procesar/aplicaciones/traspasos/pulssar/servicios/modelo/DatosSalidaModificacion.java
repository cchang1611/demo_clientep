package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class DatosSalidaModificacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2534854982356696293L;
	
	private String entidadOrigen;
	private String nss;
	private String curp;
	private DatosBaseCurpSalida datosBaseCurp;
	private DatosDomicilioParticularTrabajadorSalida datosDomicilioParticularTrabajador;
	private DatosDomicilioLaboralTrabajadorSalida datosDomicilioLaboralTrabajador;
	private DatosReferenciasTrabajadorSalida datosReferenciasTrabajador;
	/**
	 * listaBeneficiariosTrabajador
	 */
	private ListaBeneficiariosTrabajadorSalida listaBeneficiariosTrabajador;
	
	public String getEntidadOrigen() {
		return entidadOrigen;
	}
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}
	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public DatosBaseCurpSalida getDatosBaseCurp() {
		return datosBaseCurp;
	}
	public void setDatosBaseCurp(DatosBaseCurpSalida datosBaseCurp) {
		this.datosBaseCurp = datosBaseCurp;
	}
	public DatosDomicilioParticularTrabajadorSalida getDatosDomicilioParticularTrabajador() {
		return datosDomicilioParticularTrabajador;
	}
	public void setDatosDomicilioParticularTrabajador(
			DatosDomicilioParticularTrabajadorSalida datosDomicilioParticularTrabajador) {
		this.datosDomicilioParticularTrabajador = datosDomicilioParticularTrabajador;
	}
	public DatosDomicilioLaboralTrabajadorSalida getDatosDomicilioLaboralTrabajador() {
		return datosDomicilioLaboralTrabajador;
	}
	public void setDatosDomicilioLaboralTrabajador(DatosDomicilioLaboralTrabajadorSalida datosDomicilioLaboralTrabajador) {
		this.datosDomicilioLaboralTrabajador = datosDomicilioLaboralTrabajador;
	}
	public DatosReferenciasTrabajadorSalida getDatosReferenciasTrabajador() {
		return datosReferenciasTrabajador;
	}
	public void setDatosReferenciasTrabajador(DatosReferenciasTrabajadorSalida datosReferenciasTrabajador) {
		this.datosReferenciasTrabajador = datosReferenciasTrabajador;
	}
	public ListaBeneficiariosTrabajadorSalida getListaBeneficiariosTrabajador() {
		return listaBeneficiariosTrabajador;
	}
	public void setListaBeneficiariosTrabajador(ListaBeneficiariosTrabajadorSalida listaBeneficiariosTrabajador) {
		this.listaBeneficiariosTrabajador = listaBeneficiariosTrabajador;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosSalidaModificacion [entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", datosBaseCurp=");
		builder.append(datosBaseCurp);
		builder.append(", datosDomicilioParticularTrabajador=");
		builder.append(datosDomicilioParticularTrabajador);
		builder.append(", datosDomicilioLaboralTrabajador=");
		builder.append(datosDomicilioLaboralTrabajador);
		builder.append(", datosReferenciasTrabajador=");
		builder.append(datosReferenciasTrabajador);
		builder.append(", listaBeneficiariosTrabajador=");
		builder.append(listaBeneficiariosTrabajador);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
