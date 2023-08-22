/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad Trabajador Saldo SAR92
 * @author lvgonzal
 *
 */
public class TrabajadorSaldoSar92 implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -5136994695346318634L;
	
    /**
	 * idTrabajadorSaldoSar92
	 */
	private Long idTrabajadorSaldoSar92;
	
	/**
	 * idProcesar
	 */
	private Long idProcesar;
	
	/**
	 * idTrabajadorSar92
	 */
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
	 * descripcionIcefa
	 */
	private String descripcionIcefa ;
	
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
	 * retiro
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
	 * indicadorDeSaldo
	 */
	private Long indicadorDeSaldo;
	
	/**
	 * afectacionSaldoImss
	 */
	private BigDecimal afectacionSaldoImss;
	
	/**
	 * afectacionSaldoInfonavit
	 */
	private BigDecimal afectacionSaldoInfonavit;
	
	/**
	 * movimientoRealizado
	 */
	private String movimientoRealizado;
	
	/**
	 * movimientoActual
	 */
	private String movimientoActual;
	
	/**
	 * procesoModificador
	 */
	private String procesoModificador;
	
	/**
	 * fechaSolicitudMovimiento
	 */
	private Date fechaSolicitudMovimiento;
	
	/**
	 * fechaMovimiento
	 */
	private Date fechaMovimiento;
	
	/**
	 * fechaUltimoMovimiento
	 */
	private Date fechaUltimoMovimiento;
	
	/**
	 * numeroConsecutivoDeCuenta
	 */
	private Long numeroConsecutivoDeCuenta;
	
	/**
	 * saldoInicialmss
	 */
	private BigDecimal saldoInicialmss;
	
	/**
	 * saldoInicialInfonavit
	 */
	private BigDecimal saldoInicialInfonavit ;
	
	/**
	 * saldoActualImss
	 */
	private BigDecimal saldoActualImss ;
	
	/**
	 * saldoActualInfonavit
	 */
	private BigDecimal saldoActualInfonavit ;
	
	/**
	 * saldoApartadoImss
	 */
	private BigDecimal saldoApartadoImss;
	
	/**
	 * saldoApartadoInfonavit
	 */
	private BigDecimal saldoApartadoInfonavit;
	
	/**
	 * saldoLiquidadoImss
	 */
	private BigDecimal saldoLiquidadoImss;
	
	/**
	 * saldoLiquidoInfonavit
	 */
	private BigDecimal saldoLiquidadoInfonavit;
	
	/**
	 * saldoIncrementoImss
	 */
	private BigDecimal saldoIncrementoImss;
	
	/**
	 * saldoIncrementInfonavit
	 */
	private BigDecimal saldoIncrementInfonavit;	
	
	/**
	 * fechaControl
	 */
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * @return the idTrabajadorSaldoSar92
	 */
	public Long getIdTrabajadorSaldoSar92() {
		return idTrabajadorSaldoSar92;
	}

	/**
	 * @param idTrabajadorSaldoSar92 the idTrabajadorSaldoSar92 to set
	 */
	public void setIdTrabajadorSaldoSar92(Long idTrabajadorSaldoSar92) {
		this.idTrabajadorSaldoSar92 = idTrabajadorSaldoSar92;
	}

	/**
	 * @return the idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar the idProcesar to set
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

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
	 * @return the descripcionIcefa
	 */
	public String getDescripcionIcefa() {
		return descripcionIcefa;
	}

	/**
	 * @param descripcionIcefa the descripcionIcefa to set
	 */
	public void setDescripcionIcefa(String descripcionIcefa) {
		this.descripcionIcefa = descripcionIcefa;
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
	 * @return the indicadorDeSaldo
	 */
	public Long getIndicadorDeSaldo() {
		return indicadorDeSaldo;
	}

	/**
	 * @param indicadorDeSaldo the indicadorDeSaldo to set
	 */
	public void setIndicadorDeSaldo(Long indicadorDeSaldo) {
		this.indicadorDeSaldo = indicadorDeSaldo;
	}

	/**
	 * @return the afectacionSaldoImss
	 */
	public BigDecimal getAfectacionSaldoImss() {
		return afectacionSaldoImss;
	}

	/**
	 * @param afectacionSaldoImss the afectacionSaldoImss to set
	 */
	public void setAfectacionSaldoImss(BigDecimal afectacionSaldoImss) {
		this.afectacionSaldoImss = afectacionSaldoImss;
	}

	/**
	 * @return the afectacionSaldoInfonavit
	 */
	public BigDecimal getAfectacionSaldoInfonavit() {
		return afectacionSaldoInfonavit;
	}

	/**
	 * @param afectacionSaldoInfonavit the afectacionSaldoInfonavit to set
	 */
	public void setAfectacionSaldoInfonavit(BigDecimal afectacionSaldoInfonavit) {
		this.afectacionSaldoInfonavit = afectacionSaldoInfonavit;
	}

	/**
	 * @return the movimientoRealizado
	 */
	public String getMovimientoRealizado() {
		return movimientoRealizado;
	}

	/**
	 * @param movimientoRealizado the movimientoRealizado to set
	 */
	public void setMovimientoRealizado(String movimientoRealizado) {
		this.movimientoRealizado = movimientoRealizado;
	}

	/**
	 * @return the movimientoActual
	 */
	public String getMovimientoActual() {
		return movimientoActual;
	}

	/**
	 * @param movimientoActual the movimientoActual to set
	 */
	public void setMovimientoActual(String movimientoActual) {
		this.movimientoActual = movimientoActual;
	}

	/**
	 * @return the procesoModificador
	 */
	public String getProcesoModificador() {
		return procesoModificador;
	}

	/**
	 * @param procesoModificador the procesoModificador to set
	 */
	public void setProcesoModificador(String procesoModificador) {
		this.procesoModificador = procesoModificador;
	}

	/**
	 * @return the fechaSolicitudMovimiento
	 */
	public Date getFechaSolicitudMovimiento() {
		return fechaSolicitudMovimiento;
	}

	/**
	 * @param fechaSolicitudMovimiento the fechaSolicitudMovimiento to set
	 */
	public void setFechaSolicitudMovimiento(Date fechaSolicitudMovimiento) {
		this.fechaSolicitudMovimiento = fechaSolicitudMovimiento;
	}

	/**
	 * @return the fechaMovimiento
	 */
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	/**
	 * @param fechaMovimiento the fechaMovimiento to set
	 */
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	/**
	 * @return the fechaUltimoMovimiento
	 */
	public Date getFechaUltimoMovimiento() {
		return fechaUltimoMovimiento;
	}

	/**
	 * @param fechaUltimoMovimiento the fechaUltimoMovimiento to set
	 */
	public void setFechaUltimoMovimiento(Date fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}

	/**
	 * @return the numeroConsecutivoDeCuenta
	 */
	public Long getNumeroConsecutivoDeCuenta() {
		return numeroConsecutivoDeCuenta;
	}

	/**
	 * @param numeroConsecutivoDeCuenta the numeroConsecutivoDeCuenta to set
	 */
	public void setNumeroConsecutivoDeCuenta(Long numeroConsecutivoDeCuenta) {
		this.numeroConsecutivoDeCuenta = numeroConsecutivoDeCuenta;
	}

	/**
	 * @return the saldoInicialmss
	 */
	public BigDecimal getSaldoInicialmss() {
		return saldoInicialmss;
	}

	/**
	 * @param saldoInicialmss the saldoInicialmss to set
	 */
	public void setSaldoInicialmss(BigDecimal saldoInicialmss) {
		this.saldoInicialmss = saldoInicialmss;
	}

	/**
	 * @return the saldoInicialInfonavit
	 */
	public BigDecimal getSaldoInicialInfonavit() {
		return saldoInicialInfonavit;
	}

	/**
	 * @param saldoInicialInfonavit the saldoInicialInfonavit to set
	 */
	public void setSaldoInicialInfonavit(BigDecimal saldoInicialInfonavit) {
		this.saldoInicialInfonavit = saldoInicialInfonavit;
	}

	/**
	 * @return the saldoActualImss
	 */
	public BigDecimal getSaldoActualImss() {
		return saldoActualImss;
	}

	/**
	 * @param saldoActualImss the saldoActualImss to set
	 */
	public void setSaldoActualImss(BigDecimal saldoActualImss) {
		this.saldoActualImss = saldoActualImss;
	}

	/**
	 * @return the saldoActualInfonavit
	 */
	public BigDecimal getSaldoActualInfonavit() {
		return saldoActualInfonavit;
	}

	/**
	 * @param saldoActualInfonavit the saldoActualInfonavit to set
	 */
	public void setSaldoActualInfonavit(BigDecimal saldoActualInfonavit) {
		this.saldoActualInfonavit = saldoActualInfonavit;
	}

	/**
	 * @return the saldoApartadoImss
	 */
	public BigDecimal getSaldoApartadoImss() {
		return saldoApartadoImss;
	}

	/**
	 * @param saldoApartadoImss the saldoApartadoImss to set
	 */
	public void setSaldoApartadoImss(BigDecimal saldoApartadoImss) {
		this.saldoApartadoImss = saldoApartadoImss;
	}

	/**
	 * @return the saldoApartadoInfonavit
	 */
	public BigDecimal getSaldoApartadoInfonavit() {
		return saldoApartadoInfonavit;
	}

	/**
	 * @param saldoApartadoInfonavit the saldoApartadoInfonavit to set
	 */
	public void setSaldoApartadoInfonavit(BigDecimal saldoApartadoInfonavit) {
		this.saldoApartadoInfonavit = saldoApartadoInfonavit;
	}

	/**
	 * @return the saldoLiquidadoImss
	 */
	public BigDecimal getSaldoLiquidadoImss() {
		return saldoLiquidadoImss;
	}

	/**
	 * @param saldoLiquidadoImss the saldoLiquidadoImss to set
	 */
	public void setSaldoLiquidadoImss(BigDecimal saldoLiquidadoImss) {
		this.saldoLiquidadoImss = saldoLiquidadoImss;
	}

	/**
	 * @return the saldoLiquidadoInfonavit
	 */
	public BigDecimal getSaldoLiquidadoInfonavit() {
		return saldoLiquidadoInfonavit;
	}

	/**
	 * @param saldoLiquidadoInfonavit the saldoLiquidadoInfonavit to set
	 */
	public void setSaldoLiquidadoInfonavit(BigDecimal saldoLiquidadoInfonavit) {
		this.saldoLiquidadoInfonavit = saldoLiquidadoInfonavit;
	}

	/**
	 * @return the saldoIncrementoImss
	 */
	public BigDecimal getSaldoIncrementoImss() {
		return saldoIncrementoImss;
	}

	/**
	 * @param saldoIncrementoImss the saldoIncrementoImss to set
	 */
	public void setSaldoIncrementoImss(BigDecimal saldoIncrementoImss) {
		this.saldoIncrementoImss = saldoIncrementoImss;
	}

	/**
	 * @return the saldoIncrementInfonavit
	 */
	public BigDecimal getSaldoIncrementInfonavit() {
		return saldoIncrementInfonavit;
	}

	/**
	 * @param saldoIncrementInfonavit the saldoIncrementInfonavit to set
	 */
	public void setSaldoIncrementInfonavit(BigDecimal saldoIncrementInfonavit) {
		this.saldoIncrementInfonavit = saldoIncrementInfonavit;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TrabajadorSaldoSar92 [idTrabajadorSaldoSar92=");
		builder.append(idTrabajadorSaldoSar92);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idTrabajadorSar92=");
		builder.append(idTrabajadorSar92);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", controlInterno=");
		builder.append(controlInterno);
		builder.append(", icefa=");
		builder.append(icefa);
		builder.append(", descripcionIcefa=");
		builder.append(descripcionIcefa);
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
		builder.append(", indicadorDeSaldo=");
		builder.append(indicadorDeSaldo);
		builder.append(", afectacionSaldoImss=");
		builder.append(afectacionSaldoImss);
		builder.append(", afectacionSaldoInfonavit=");
		builder.append(afectacionSaldoInfonavit);
		builder.append(", movimientoRealizado=");
		builder.append(movimientoRealizado);
		builder.append(", movimientoActual=");
		builder.append(movimientoActual);
		builder.append(", procesoModificador=");
		builder.append(procesoModificador);
		builder.append(", fechaSolicitudMovimiento=");
		builder.append(fechaSolicitudMovimiento);
		builder.append(", fechaMovimiento=");
		builder.append(fechaMovimiento);
		builder.append(", fechaUltimoMovimiento=");
		builder.append(fechaUltimoMovimiento);
		builder.append(", numeroConsecutivoDeCuenta=");
		builder.append(numeroConsecutivoDeCuenta);
		builder.append(", saldoInicialmss=");
		builder.append(saldoInicialmss);
		builder.append(", saldoInicialInfonavit=");
		builder.append(saldoInicialInfonavit);
		builder.append(", saldoActualImss=");
		builder.append(saldoActualImss);
		builder.append(", saldoActualInfonavit=");
		builder.append(saldoActualInfonavit);
		builder.append(", saldoApartadoImss=");
		builder.append(saldoApartadoImss);
		builder.append(", saldoApartadoInfonavit=");
		builder.append(saldoApartadoInfonavit);
		builder.append(", saldoLiquidadoImss=");
		builder.append(saldoLiquidadoImss);
		builder.append(", saldoLiquidadoInfonavit=");
		builder.append(saldoLiquidadoInfonavit);
		builder.append(", saldoIncrementoImss=");
		builder.append(saldoIncrementoImss);
		builder.append(", saldoIncrementInfonavit=");
		builder.append(saldoIncrementInfonavit);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
}
