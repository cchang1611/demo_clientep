package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author jajimene
 * Datos de entrada Notificacion Expediente 
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EntradaNotificacionActualiza implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6818676421636792082L;
	
	/**
	 * afore
	 */
	private String afore;
	
	/**
	 * folioCliente
	 */
	private String folioCliente;
	
	/**
	 * entidadOrigen
	 */
	private String entidadOrigen;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * datosBaseCurp
	 */
	private DatosBaseCurpSalida datosBaseCurp;
	
	/**
	 * datosDomicilioParticularTrabajador
	 */
	private DatosDomicilioParticularTrabajadorSalida datosDomicilioParticularTrabajador;
	
	/**
	 * datosDomicilioLaboralTrabajador
	 */
	private DatosDomicilioLaboralTrabajadorSalida datosDomicilioLaboralTrabajador;
	
	/**
	 * datosReferenciasTrabajador
	 */
	private DatosReferenciasTrabajadorSalida datosReferenciasTrabajador;
	
	/**
	 * listaBeneficiariosTrabajador
	 */
	private ListaBeneficiariosTrabajadorSalida listaBeneficiariosTrabajador;
	
	/**
	 * folio origen de servicio
	 */
	private String folioOrigen;
	
	/**
	 * indicador enrolamiento
	 */
	private Long indicadorEnrolamiento;
	
	/**
	 * indicador de aceptacion flujo 9B
	 */
	private Long indicadorAceptaFlujo;
	
	/**
	 * indicador movimiento beneficiario
	 */
	private String movBeneficiario;

	public EntradaNotificacionActualiza() {
		super();
	}

	public String getAfore() {
		return afore;
	}

	public void setAfore(String afore) {
		this.afore = afore;
	}

	public String getFolioCliente() {
		return folioCliente;
	}

	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

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

	/**
	 * @return the folioOrigen
	 */
	public String getFolioOrigen() {
		return folioOrigen;
	}

	/**
	 * @param folioOrigen the folioOrigen to set
	 */
	public void setFolioOrigen(String folioOrigen) {
		this.folioOrigen = folioOrigen;
	}

	/**
	 * @return the indicadorEnrolamiento
	 */
	public Long getIndicadorEnrolamiento() {
		return indicadorEnrolamiento;
	}

	/**
	 * @param indicadorEnrolamiento the indicadorEnrolamiento to set
	 */
	public void setIndicadorEnrolamiento(Long indicadorEnrolamiento) {
		this.indicadorEnrolamiento = indicadorEnrolamiento;
	}

	/**
	 * @return the indicadorAceptaFlujo
	 */
	public Long getIndicadorAceptaFlujo() {
		return indicadorAceptaFlujo;
	}

	/**
	 * @param indicadorAceptaFlujo the indicadorAceptaFlujo to set
	 */
	public void setIndicadorAceptaFlujo(Long indicadorAceptaFlujo) {
		this.indicadorAceptaFlujo = indicadorAceptaFlujo;
	}

	/**
	 * @return the movBeneficiario
	 */
	public String getMovBeneficiario() {
		return movBeneficiario;
	}

	/**
	 * @param movBeneficiario the movBeneficiario to set
	 */
	public void setMovBeneficiario(String movBeneficiario) {
		this.movBeneficiario = movBeneficiario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaNotificacionActualiza [afore=");
		builder.append(afore);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", entidadOrigen=");
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
		builder.append(", folioOrigen=");
		builder.append(folioOrigen);
		builder.append(", indicadorEnrolamiento=");
		builder.append(indicadorEnrolamiento);
		builder.append(", indicadorAceptaFlujo=");
		builder.append(indicadorAceptaFlujo);
		builder.append(", movBeneficiario=");
		builder.append(movBeneficiario);
		builder.append("]");
		return builder.toString();
	}
	
}
