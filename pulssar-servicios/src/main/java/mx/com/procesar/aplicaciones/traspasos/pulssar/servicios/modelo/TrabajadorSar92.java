/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad Trabajador SAR92
 * @author lvgonzal
 *
 */
public class TrabajadorSar92 implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -8326191027709717433L;
	
private Long idTrabajadorSar92;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * rfc
	 */
	private String rfc;
	
	/**
	 * controlInterno
	 */
	private String controlInterno;
	
	/**
	 * icefa
	 */
	private String icefa ;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * nombreTrabajador
	 */
	private String nombreTrabajador;
	
	/**
	 * fechaNacimiento
	 */
	private String fechaNacimiento;
	
	/**
	 * creditoVivieda
	 */
	private String creditoVivieda;
	
	/**
	 * 
	 */
	private String retiro;
	
	/**
	 * rfcPatronal
	 */
	private String rfcPatronal;
	
	/**
	 * nssPatronal
	 */
	private String nssPatronal;
	
	/**
	 * nombrePatron
	 */
	private String nombrePatron;
	
	/**
	 * expeInfonavit
	 */
	private String expeInfonavit ;
	
	/**
	 * claveCriterioSar92
	 */
	private String claveCriterioSar92 ;
	
	/**
	 * fechaCancelacion
	 */
	private Date fechaCancelacion;
	
	/**
	 * fechaControl
	 */
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;
	
	/**
	 * SaldoSar92
	 */
	private SaldoSar92 saldoSar92;
	
	/**
	 * bancoIcefa
	 */
	private Icefa bancoIcefa;

	/**
	 * @return the idTrabajadorSar92
	 */
	public Long getIdTrabajadorSar92() {
		return idTrabajadorSar92;
	}

	/**
	 * @param idTrabajadorSar92 the idTrabajadorSar92 to set
	 */
	public void setIdTrabajadorSar92(Long idTrabajadorSar92) {
		this.idTrabajadorSar92 = idTrabajadorSar92;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
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

	/**
	 * @return the controlInterno
	 */
	public String getControlInterno() {
		return controlInterno;
	}

	/**
	 * @param controlInterno the controlInterno to set
	 */
	public void setControlInterno(String controlInterno) {
		this.controlInterno = controlInterno;
	}

	/**
	 * @return the icefa
	 */
	public String getIcefa() {
		return icefa;
	}

	/**
	 * @param icefa the icefa to set
	 */
	public void setIcefa(String icefa) {
		this.icefa = icefa;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the creditoVivieda
	 */
	public String getCreditoVivieda() {
		return creditoVivieda;
	}

	/**
	 * @param creditoVivieda the creditoVivieda to set
	 */
	public void setCreditoVivieda(String creditoVivieda) {
		this.creditoVivieda = creditoVivieda;
	}

	/**
	 * @return the retiro
	 */
	public String getRetiro() {
		return retiro;
	}

	/**
	 * @param retiro the retiro to set
	 */
	public void setRetiro(String retiro) {
		this.retiro = retiro;
	}

	/**
	 * @return the rfcPatronal
	 */
	public String getRfcPatronal() {
		return rfcPatronal;
	}

	/**
	 * @param rfcPatronal the rfcPatronal to set
	 */
	public void setRfcPatronal(String rfcPatronal) {
		this.rfcPatronal = rfcPatronal;
	}

	/**
	 * @return the nssPatronal
	 */
	public String getNssPatronal() {
		return nssPatronal;
	}

	/**
	 * @param nssPatronal the nssPatronal to set
	 */
	public void setNssPatronal(String nssPatronal) {
		this.nssPatronal = nssPatronal;
	}

	/**
	 * @return the nombrePatron
	 */
	public String getNombrePatron() {
		return nombrePatron;
	}

	/**
	 * @param nombrePatron the nombrePatron to set
	 */
	public void setNombrePatron(String nombrePatron) {
		this.nombrePatron = nombrePatron;
	}

	/**
	 * @return the expeInfonavit
	 */
	public String getExpeInfonavit() {
		return expeInfonavit;
	}

	/**
	 * @param expeInfonavit the expeInfonavit to set
	 */
	public void setExpeInfonavit(String expeInfonavit) {
		this.expeInfonavit = expeInfonavit;
	}

	/**
	 * @return the claveCriterioSar92
	 */
	public String getClaveCriterioSar92() {
		return claveCriterioSar92;
	}

	/**
	 * @param claveCriterioSar92 the claveCriterioSar92 to set
	 */
	public void setClaveCriterioSar92(String claveCriterioSar92) {
		this.claveCriterioSar92 = claveCriterioSar92;
	}

	/**
	 * @return the fechaCancelacion
	 */
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	/**
	 * @param fechaCancelacion the fechaCancelacion to set
	 */
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return the saldoSar92
	 */
	public SaldoSar92 getSaldoSar92() {
		return saldoSar92;
	}

	/**
	 * @param saldoSar92 the saldoSar92 to set
	 */
	public void setSaldoSar92(SaldoSar92 saldoSar92) {
		this.saldoSar92 = saldoSar92;
	}

	/**
	 * @return the bancoIcefa
	 */
	public Icefa getBancoIcefa() {
		return bancoIcefa;
	}

	/**
	 * @param bancoIcefa the bancoIcefa to set
	 */
	public void setBancoIcefa(Icefa bancoIcefa) {
		this.bancoIcefa = bancoIcefa;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TrabajadorSar92 [idTrabajadorSar92=");
		builder.append(idTrabajadorSar92);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", controlInterno=");
		builder.append(controlInterno);
		builder.append(", icefa=");
		builder.append(icefa);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", creditoVivieda=");
		builder.append(creditoVivieda);
		builder.append(", retiro=");
		builder.append(retiro);
		builder.append(", rfcPatronal=");
		builder.append(rfcPatronal);
		builder.append(", nssPatronal=");
		builder.append(nssPatronal);
		builder.append(", nombrePatron=");
		builder.append(nombrePatron);
		builder.append(", expeInfonavit=");
		builder.append(expeInfonavit);
		builder.append(", claveCriterioSar92=");
		builder.append(claveCriterioSar92);
		builder.append(", fechaCancelacion=");
		builder.append(fechaCancelacion);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", saldoSar92=");
		builder.append(saldoSar92);
		builder.append(", bancoIcefa=");
		builder.append(bancoIcefa);
		builder.append("]");
		return builder.toString();
	}
	
}
