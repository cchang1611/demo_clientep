/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad Saldo SARISSSTE
 * @author lvgonzal
 *
 */
public class SaldoSarIssste implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 609286246799351190L;
	
	/**
	 * idSaldoSarIssste
	 */
	private Long idSaldoSarIssste;
	
	/**
	 * consecutivoMovimiento
	 */
	private Long consecutivoMovimiento;
	
	/**
	 * indicadorDeSaldo
	 */
	private Long indicadorDeSaldo;
	
	/**
	 * claveSaldoSar
	 */
	private String claveSaldoSar;
	
	/**
	 * participaciones
	 */
	private Long participaciones;
	
	/**
	 * periodoPago
	 */
	private String periodoPago;
	
	/**
	 * fechaMovimiento
	 */
	private Date fechaMovimiento;
	
	/**
	 * fechaValor
	 */
	private Date fechaValor;
	
	/**
	 * criterio
	 */
	private String criterio;
	
	/**
	 * movimientoRealizado
	 */
	private String movimientoRealizado;
	
	/**
	 * movimientoActual
	 */
	private String movimientoActual;
	
	/**
	 * saldoIncialSar
	 */
	private BigDecimal saldoIncialSar;
	
	/**
	 * saldoInicialVivienda
	 */
	private BigDecimal saldoInicialVivienda;
	
	/**
	 * saldoActualVivienda
	 */
	private BigDecimal saldoActualVivienda;
	
	/**
	 * saldoActualSar
	 */
	private BigDecimal saldoActualSar;
	
	/**
	 * saldoAhorroLargoPlazo
	 */
	private BigDecimal saldoAhorroLargoPlazo;
	
	/**
	 * saldoAportacionVoluntaria
	 */
	private BigDecimal saldoAportacionVoluntaria;
	
	/**
	 * saldoPensionarioSar
	 */
	private BigDecimal saldoPensionarioSar;
	
	/**
	 * saldoVivienda
	 */
	private BigDecimal saldoVivienda;
	
	/**
	 * saldoAportaComplemRtiro
	 */

	private BigDecimal saldoAportaComplemRtiro;
	
	/**
	 * fechaControl
	 */
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;
	
	/**
	 * idTrabajadorSarISSSTE
	 */
	private Long idTrabajadorSarISSSTE;

	/**
	 * @return the idSaldoSarIssste
	 */
	public Long getIdSaldoSarIssste() {
		return idSaldoSarIssste;
	}

	/**
	 * @param idSaldoSarIssste the idSaldoSarIssste to set
	 */
	public void setIdSaldoSarIssste(Long idSaldoSarIssste) {
		this.idSaldoSarIssste = idSaldoSarIssste;
	}

	/**
	 * @return the consecutivoMovimiento
	 */
	public Long getConsecutivoMovimiento() {
		return consecutivoMovimiento;
	}

	/**
	 * @param consecutivoMovimiento the consecutivoMovimiento to set
	 */
	public void setConsecutivoMovimiento(Long consecutivoMovimiento) {
		this.consecutivoMovimiento = consecutivoMovimiento;
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
	 * @return the claveSaldoSar
	 */
	public String getClaveSaldoSar() {
		return claveSaldoSar;
	}

	/**
	 * @param claveSaldoSar the claveSaldoSar to set
	 */
	public void setClaveSaldoSar(String claveSaldoSar) {
		this.claveSaldoSar = claveSaldoSar;
	}

	/**
	 * @return the participaciones
	 */
	public Long getParticipaciones() {
		return participaciones;
	}

	/**
	 * @param participaciones the participaciones to set
	 */
	public void setParticipaciones(Long participaciones) {
		this.participaciones = participaciones;
	}

	/**
	 * @return the periodoPago
	 */
	public String getPeriodoPago() {
		return periodoPago;
	}

	/**
	 * @param periodoPago the periodoPago to set
	 */
	public void setPeriodoPago(String periodoPago) {
		this.periodoPago = periodoPago;
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
	 * @return the fechaValor
	 */
	public Date getFechaValor() {
		return fechaValor;
	}

	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(Date fechaValor) {
		this.fechaValor = fechaValor;
	}

	/**
	 * @return the criterio
	 */
	public String getCriterio() {
		return criterio;
	}

	/**
	 * @param criterio the criterio to set
	 */
	public void setCriterio(String criterio) {
		this.criterio = criterio;
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
	 * @return the saldoIncialSar
	 */
	public BigDecimal getSaldoIncialSar() {
		return saldoIncialSar;
	}

	/**
	 * @param saldoIncialSar the saldoIncialSar to set
	 */
	public void setSaldoIncialSar(BigDecimal saldoIncialSar) {
		this.saldoIncialSar = saldoIncialSar;
	}

	/**
	 * @return the saldoInicialVivienda
	 */
	public BigDecimal getSaldoInicialVivienda() {
		return saldoInicialVivienda;
	}

	/**
	 * @param saldoInicialVivienda the saldoInicialVivienda to set
	 */
	public void setSaldoInicialVivienda(BigDecimal saldoInicialVivienda) {
		this.saldoInicialVivienda = saldoInicialVivienda;
	}

	/**
	 * @return the saldoActualVivienda
	 */
	public BigDecimal getSaldoActualVivienda() {
		return saldoActualVivienda;
	}

	/**
	 * @param saldoActualVivienda the saldoActualVivienda to set
	 */
	public void setSaldoActualVivienda(BigDecimal saldoActualVivienda) {
		this.saldoActualVivienda = saldoActualVivienda;
	}

	/**
	 * @return the saldoActualSar
	 */
	public BigDecimal getSaldoActualSar() {
		return saldoActualSar;
	}

	/**
	 * @param saldoActualSar the saldoActualSar to set
	 */
	public void setSaldoActualSar(BigDecimal saldoActualSar) {
		this.saldoActualSar = saldoActualSar;
	}

	/**
	 * @return the saldoAhorroLargoPlazo
	 */
	public BigDecimal getSaldoAhorroLargoPlazo() {
		return saldoAhorroLargoPlazo;
	}

	/**
	 * @param saldoAhorroLargoPlazo the saldoAhorroLargoPlazo to set
	 */
	public void setSaldoAhorroLargoPlazo(BigDecimal saldoAhorroLargoPlazo) {
		this.saldoAhorroLargoPlazo = saldoAhorroLargoPlazo;
	}

	/**
	 * @return the saldoAportacionVoluntaria
	 */
	public BigDecimal getSaldoAportacionVoluntaria() {
		return saldoAportacionVoluntaria;
	}

	/**
	 * @param saldoAportacionVoluntaria the saldoAportacionVoluntaria to set
	 */
	public void setSaldoAportacionVoluntaria(BigDecimal saldoAportacionVoluntaria) {
		this.saldoAportacionVoluntaria = saldoAportacionVoluntaria;
	}

	/**
	 * @return the saldoPensionarioSar
	 */
	public BigDecimal getSaldoPensionarioSar() {
		return saldoPensionarioSar;
	}

	/**
	 * @param saldoPensionarioSar the saldoPensionarioSar to set
	 */
	public void setSaldoPensionarioSar(BigDecimal saldoPensionarioSar) {
		this.saldoPensionarioSar = saldoPensionarioSar;
	}

	/**
	 * @return the saldoVivienda
	 */
	public BigDecimal getSaldoVivienda() {
		return saldoVivienda;
	}

	/**
	 * @param saldoVivienda the saldoVivienda to set
	 */
	public void setSaldoVivienda(BigDecimal saldoVivienda) {
		this.saldoVivienda = saldoVivienda;
	}

	/**
	 * @return the saldoAportaComplemRtiro
	 */
	public BigDecimal getSaldoAportaComplemRtiro() {
		return saldoAportaComplemRtiro;
	}

	/**
	 * @param saldoAportaComplemRtiro the saldoAportaComplemRtiro to set
	 */
	public void setSaldoAportaComplemRtiro(BigDecimal saldoAportaComplemRtiro) {
		this.saldoAportaComplemRtiro = saldoAportaComplemRtiro;
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
	 * @return the idTrabajadorSarISSSTE
	 */
	public Long getIdTrabajadorSarISSSTE() {
		return idTrabajadorSarISSSTE;
	}

	/**
	 * @param idTrabajadorSarISSSTE the idTrabajadorSarISSSTE to set
	 */
	public void setIdTrabajadorSarISSSTE(Long idTrabajadorSarISSSTE) {
		this.idTrabajadorSarISSSTE = idTrabajadorSarISSSTE;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaldoSarIssste [idSaldoSarIssste=");
		builder.append(idSaldoSarIssste);
		builder.append(", consecutivoMovimiento=");
		builder.append(consecutivoMovimiento);
		builder.append(", indicadorDeSaldo=");
		builder.append(indicadorDeSaldo);
		builder.append(", claveSaldoSar=");
		builder.append(claveSaldoSar);
		builder.append(", participaciones=");
		builder.append(participaciones);
		builder.append(", periodoPago=");
		builder.append(periodoPago);
		builder.append(", fechaMovimiento=");
		builder.append(fechaMovimiento);
		builder.append(", fechaValor=");
		builder.append(fechaValor);
		builder.append(", criterio=");
		builder.append(criterio);
		builder.append(", movimientoRealizado=");
		builder.append(movimientoRealizado);
		builder.append(", movimientoActual=");
		builder.append(movimientoActual);
		builder.append(", saldoIncialSar=");
		builder.append(saldoIncialSar);
		builder.append(", saldoInicialVivienda=");
		builder.append(saldoInicialVivienda);
		builder.append(", saldoActualVivienda=");
		builder.append(saldoActualVivienda);
		builder.append(", saldoActualSar=");
		builder.append(saldoActualSar);
		builder.append(", saldoAhorroLargoPlazo=");
		builder.append(saldoAhorroLargoPlazo);
		builder.append(", saldoAportacionVoluntaria=");
		builder.append(saldoAportacionVoluntaria);
		builder.append(", saldoPensionarioSar=");
		builder.append(saldoPensionarioSar);
		builder.append(", saldoVivienda=");
		builder.append(saldoVivienda);
		builder.append(", saldoAportaComplemRtiro=");
		builder.append(saldoAportaComplemRtiro);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", idTrabajadorSarISSSTE=");
		builder.append(idTrabajadorSarISSSTE);
		builder.append("]");
		return builder.toString();
	}
	
}
