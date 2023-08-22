package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author medoming
 * Datos de Entrada Op13
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EntradaModificacion implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5108756587330971629L;

	/**
	 * folioCliente
	 */
	private String folioCliente;
	
	/**
	 * entidadOrigen
	 */
	private String entidadOrigen;
	
	/**
	 * tipoDeMovimiento
	 */
	private String tipoDeMovimiento;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * Firma trabajador solicitud de modificacion de datos
	 */
	private String firmaTrabajador;
	
	/**
	 * Firma agente solicitud de modificacion de datos
	 */
	private String firmaAgente;
	
	/**
	 * datosBaseCurp
	 */
	private DatosBaseCurp datosBaseCurp;
	
	/**
	 * datosDomicilioParticularTrabajador
	 */
	private DatosDomicilioParticularTrabajador datosDomicilioParticularTrabajador;
	
	/**
	 * datosDomicilioLaboralTrabajador
	 */
	private DatosDomicilioLaboralTrabajador datosDomicilioLaboralTrabajador;
	
	/**
	 * datosReferenciasTrabajador
	 */
	private DatosReferenciasTrabajador datosReferenciasTrabajador;
	
	/**
	 * listaBeneficiariosTrabajador
	 */
	private ListaBeneficiariosTrabajador listaBeneficiariosTrabajador;

	public String getEntidadOrigen() {
		return entidadOrigen;
	}

	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}

	public String getTipoDeMovimiento() {
		return tipoDeMovimiento;
	}

	public void setTipoDeMovimiento(String tipoDeMovimiento) {
		this.tipoDeMovimiento = tipoDeMovimiento;
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

	public DatosBaseCurp getDatosBaseCurp() {
		return datosBaseCurp;
	}

	public void setDatosBaseCurp(DatosBaseCurp datosBaseCurp) {
		this.datosBaseCurp = datosBaseCurp;
	}

	public DatosDomicilioParticularTrabajador getDatosDomicilioParticularTrabajador() {
		return datosDomicilioParticularTrabajador;
	}

	public void setDatosDomicilioParticularTrabajador(
			DatosDomicilioParticularTrabajador datosDomicilioParticularTrabajador) {
		this.datosDomicilioParticularTrabajador = datosDomicilioParticularTrabajador;
	}

	public DatosDomicilioLaboralTrabajador getDatosDomicilioLaboralTrabajador() {
		return datosDomicilioLaboralTrabajador;
	}

	public void setDatosDomicilioLaboralTrabajador(DatosDomicilioLaboralTrabajador datosDomicilioLaboralTrabajador) {
		this.datosDomicilioLaboralTrabajador = datosDomicilioLaboralTrabajador;
	}

	public DatosReferenciasTrabajador getDatosReferenciasTrabajador() {
		return datosReferenciasTrabajador;
	}

	public void setDatosReferenciasTrabajador(DatosReferenciasTrabajador datosReferenciasTrabajador) {
		this.datosReferenciasTrabajador = datosReferenciasTrabajador;
	}

	public ListaBeneficiariosTrabajador getListaBeneficiariosTrabajador() {
		return listaBeneficiariosTrabajador;
	}

	public void setListaBeneficiariosTrabajador(ListaBeneficiariosTrabajador listaBeneficiariosTrabajador) {
		this.listaBeneficiariosTrabajador = listaBeneficiariosTrabajador;
	}
	


	public String getFirmaTrabajador() {
		return firmaTrabajador;
	}

	public void setFirmaTrabajador(String firmaTrabajador) {
		this.firmaTrabajador = firmaTrabajador;
	}

	public String getFirmaAgente() {
		return firmaAgente;
	}

	public void setFirmaAgente(String firmaAgente) {
		this.firmaAgente = firmaAgente;
	}

	/**
	 * @return the folioCliente
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * @param folioCliente the folioCliente to set
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaModificacion [entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", tipoDeMovimiento=");
		builder.append(tipoDeMovimiento);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", firmaTrabajador=");
		builder.append(firmaTrabajador);
		builder.append(", firmaAgente=");
		builder.append(firmaAgente);
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
