/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad Trabajador SARISSSTE
 * @author lvgonzal
 *
 */
public class TrabajadorSaldoSarIssste implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2381767646913907890L;
	
    /**
	 * idTrabajadorSaldoSarIssste
	 */
    private Long idTrabajadorSaldoSarIssste;
	
	/**
	 * idProcesar
	 */
	private Long idProcesar;
	
	/**
	 * idTrabajadorSarIssste
	 */
	private Long idTrabajadorSarIssste;
	
	/**
	 * descripcionIcefa
	 */
	private String descripcionIcefa ;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * existeEnDisweb
	 */
	private Integer existeEnDisweb;
	
	/**
	 * entidadOrigen
	 */
	private String entidadOrigen;
	
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
	 * primerApellido
	 */
	private String primerApellido;
	
	/**
	 * segundoApellido
	 */
	private String segundoApellido;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * fechaNacimiento
	 */
	private Date fechaNacimiento;
	
	/**
	 * creditoVivienda
	 */
	private String creditoVivienda;
	
	/**
	 * retiro
	 */
	private String retiro;
	
	/**
	 * bimestresAcumulados
	 */
	private String bimestresAcumulados;
	
	/**
	 * rfcPatronal
	 */
	private String rfcPatronal;
	
	/**
	 *ramoPagaduria 
	 */
	private String ramoPagaduria;
	
	/**
	 * nombrePatron
	 */
	private String nombrePatron;
	
	/**
	 * fechaUltimaAportacion
	 */
	private Date fechaUltimaAportacion;
	
	/**
	 * nombreIcefa
	 */
	private String nombreIcefa;
	
	/**
	 * icefaActual
	 */
	private String icefaActual;
	
	/**
	 * fechaUltimoMovimiento
	 */
	private Date fechaUltimoMovimiento;
	
	/**
	 * procesarUnificador
	 */
	private String procesarUnificador;
	
	/**
	 * aportacionesAcumuladas
	 */
	private Integer aportacionesAcumuladas;
	
	/**
	 * ipc
	 */
	private String ipc;
	
	/**
	 * claveReparto
	 */
	private String claveReparto;
	
	/**
	 * curpAsociada
	 */
	private String curpAsociada;
	
	/**
	 * curpUnificador
	 */
	private String curpUnificador;
	
	/**
	 * idSaldoSarIssste
	 */
	private Long idSaldoSarIssste;
	
	/**
	 * consecutivo
	 */
	private Long consecutivo;
	
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
	 * saldoAportaCompRetiro
	 */
	private BigDecimal saldoAportaCompRetiro;
	
	/**
	 * fechaControl
	 */
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * @return the idTrabajadorSaldoSarIssste
	 */
	public Long getIdTrabajadorSaldoSarIssste() {
		return idTrabajadorSaldoSarIssste;
	}

	/**
	 * @param idTrabajadorSaldoSarIssste the idTrabajadorSaldoSarIssste to set
	 */
	public void setIdTrabajadorSaldoSarIssste(Long idTrabajadorSaldoSarIssste) {
		this.idTrabajadorSaldoSarIssste = idTrabajadorSaldoSarIssste;
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
	 * @return the idTrabajadorSarIssste
	 */
	public Long getIdTrabajadorSarIssste() {
		return idTrabajadorSarIssste;
	}

	/**
	 * @param idTrabajadorSarIssste the idTrabajadorSarIssste to set
	 */
	public void setIdTrabajadorSarIssste(Long idTrabajadorSarIssste) {
		this.idTrabajadorSarIssste = idTrabajadorSarIssste;
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
	 * @return the existeEnDisweb
	 */
	public Integer getExisteEnDisweb() {
		return existeEnDisweb;
	}

	/**
	 * @param existeEnDisweb the existeEnDisweb to set
	 */
	public void setExisteEnDisweb(Integer existeEnDisweb) {
		this.existeEnDisweb = existeEnDisweb;
	}

	/**
	 * @return the entidadOrigen
	 */
	public String getEntidadOrigen() {
		return entidadOrigen;
	}

	/**
	 * @param entidadOrigen the entidadOrigen to set
	 */
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
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
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the creditoVivienda
	 */
	public String getCreditoVivienda() {
		return creditoVivienda;
	}

	/**
	 * @param creditoVivienda the creditoVivienda to set
	 */
	public void setCreditoVivienda(String creditoVivienda) {
		this.creditoVivienda = creditoVivienda;
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
	 * @return the bimestresAcumulados
	 */
	public String getBimestresAcumulados() {
		return bimestresAcumulados;
	}

	/**
	 * @param bimestresAcumulados the bimestresAcumulados to set
	 */
	public void setBimestresAcumulados(String bimestresAcumulados) {
		this.bimestresAcumulados = bimestresAcumulados;
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
	 * @return the ramoPagaduria
	 */
	public String getRamoPagaduria() {
		return ramoPagaduria;
	}

	/**
	 * @param ramoPagaduria the ramoPagaduria to set
	 */
	public void setRamoPagaduria(String ramoPagaduria) {
		this.ramoPagaduria = ramoPagaduria;
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
	 * @return the fechaUltimaAportacion
	 */
	public Date getFechaUltimaAportacion() {
		return fechaUltimaAportacion;
	}

	/**
	 * @param fechaUltimaAportacion the fechaUltimaAportacion to set
	 */
	public void setFechaUltimaAportacion(Date fechaUltimaAportacion) {
		this.fechaUltimaAportacion = fechaUltimaAportacion;
	}

	/**
	 * @return the nombreIcefa
	 */
	public String getNombreIcefa() {
		return nombreIcefa;
	}

	/**
	 * @param nombreIcefa the nombreIcefa to set
	 */
	public void setNombreIcefa(String nombreIcefa) {
		this.nombreIcefa = nombreIcefa;
	}

	/**
	 * @return the icefaActual
	 */
	public String getIcefaActual() {
		return icefaActual;
	}

	/**
	 * @param icefaActual the icefaActual to set
	 */
	public void setIcefaActual(String icefaActual) {
		this.icefaActual = icefaActual;
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
	 * @return the procesarUnificador
	 */
	public String getProcesarUnificador() {
		return procesarUnificador;
	}

	/**
	 * @param procesarUnificador the procesarUnificador to set
	 */
	public void setProcesarUnificador(String procesarUnificador) {
		this.procesarUnificador = procesarUnificador;
	}

	/**
	 * @return the aportacionesAcumuladas
	 */
	public Integer getAportacionesAcumuladas() {
		return aportacionesAcumuladas;
	}

	/**
	 * @param aportacionesAcumuladas the aportacionesAcumuladas to set
	 */
	public void setAportacionesAcumuladas(Integer aportacionesAcumuladas) {
		this.aportacionesAcumuladas = aportacionesAcumuladas;
	}

	/**
	 * @return the ipc
	 */
	public String getIpc() {
		return ipc;
	}

	/**
	 * @param ipc the ipc to set
	 */
	public void setIpc(String ipc) {
		this.ipc = ipc;
	}

	/**
	 * @return the claveReparto
	 */
	public String getClaveReparto() {
		return claveReparto;
	}

	/**
	 * @param claveReparto the claveReparto to set
	 */
	public void setClaveReparto(String claveReparto) {
		this.claveReparto = claveReparto;
	}

	/**
	 * @return the curpAsociada
	 */
	public String getCurpAsociada() {
		return curpAsociada;
	}

	/**
	 * @param curpAsociada the curpAsociada to set
	 */
	public void setCurpAsociada(String curpAsociada) {
		this.curpAsociada = curpAsociada;
	}

	/**
	 * @return the curpUnificador
	 */
	public String getCurpUnificador() {
		return curpUnificador;
	}

	/**
	 * @param curpUnificador the curpUnificador to set
	 */
	public void setCurpUnificador(String curpUnificador) {
		this.curpUnificador = curpUnificador;
	}

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
	 * @return the consecutivo
	 */
	public Long getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
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
	 * @return the saldoAportaCompRetiro
	 */
	public BigDecimal getSaldoAportaCompRetiro() {
		return saldoAportaCompRetiro;
	}

	/**
	 * @param saldoAportaCompRetiro the saldoAportaCompRetiro to set
	 */
	public void setSaldoAportaCompRetiro(BigDecimal saldoAportaCompRetiro) {
		this.saldoAportaCompRetiro = saldoAportaCompRetiro;
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
		builder.append("TrabajadorSaldoSarIssste [idTrabajadorSaldoSarIssste=");
		builder.append(idTrabajadorSaldoSarIssste);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idTrabajadorSarIssste=");
		builder.append(idTrabajadorSarIssste);
		builder.append(", descripcionIcefa=");
		builder.append(descripcionIcefa);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", existeEnDisweb=");
		builder.append(existeEnDisweb);
		builder.append(", entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", controlInterno=");
		builder.append(controlInterno);
		builder.append(", primerApellido=");
		builder.append(primerApellido);
		builder.append(", segundoApellido=");
		builder.append(segundoApellido);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", creditoVivienda=");
		builder.append(creditoVivienda);
		builder.append(", retiro=");
		builder.append(retiro);
		builder.append(", bimestresAcumulados=");
		builder.append(bimestresAcumulados);
		builder.append(", rfcPatronal=");
		builder.append(rfcPatronal);
		builder.append(", ramoPagaduria=");
		builder.append(ramoPagaduria);
		builder.append(", nombrePatron=");
		builder.append(nombrePatron);
		builder.append(", fechaUltimaAportacion=");
		builder.append(fechaUltimaAportacion);
		builder.append(", nombreIcefa=");
		builder.append(nombreIcefa);
		builder.append(", icefaActual=");
		builder.append(icefaActual);
		builder.append(", fechaUltimoMovimiento=");
		builder.append(fechaUltimoMovimiento);
		builder.append(", procesarUnificador=");
		builder.append(procesarUnificador);
		builder.append(", aportacionesAcumuladas=");
		builder.append(aportacionesAcumuladas);
		builder.append(", ipc=");
		builder.append(ipc);
		builder.append(", claveReparto=");
		builder.append(claveReparto);
		builder.append(", curpAsociada=");
		builder.append(curpAsociada);
		builder.append(", curpUnificador=");
		builder.append(curpUnificador);
		builder.append(", idSaldoSarIssste=");
		builder.append(idSaldoSarIssste);
		builder.append(", consecutivo=");
		builder.append(consecutivo);
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
		builder.append(", saldoAportaCompRetiro=");
		builder.append(saldoAportaCompRetiro);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
}
