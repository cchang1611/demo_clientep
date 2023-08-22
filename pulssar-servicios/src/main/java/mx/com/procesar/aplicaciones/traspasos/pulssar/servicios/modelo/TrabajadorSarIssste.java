/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad Trabajador SARISSSTE
 * @author lvgonzal
 *
 */
public class TrabajadorSarIssste implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 7896294553840132587L;
	
    /**
	 * idTrabajadorSarIssste
	 */
	private Long idTrabajadorSarIssste;
	
	/**
	 * nciProcesar
	 */
	private String nciProcesar;
	
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
	 * fechaControl
	 */
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * SaldoSarIssste
	 */
	private SaldoSarIssste saldoSarIssste;
	
	/**
	 * Icefa
	 */
	private Icefa bancoIcefa;

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
	 * @return the nciProcesar
	 */
	public String getNciProcesar() {
		return nciProcesar;
	}

	/**
	 * @param nciProcesar the nciProcesar to set
	 */
	public void setNciProcesar(String nciProcesar) {
		this.nciProcesar = nciProcesar;
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
	 * @return the saldoSarIssste
	 */
	public SaldoSarIssste getSaldoSarIssste() {
		return saldoSarIssste;
	}

	/**
	 * @param saldoSarIssste the saldoSarIssste to set
	 */
	public void setSaldoSarIssste(SaldoSarIssste saldoSarIssste) {
		this.saldoSarIssste = saldoSarIssste;
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
		builder.append("TrabajadorSarIssste [idTrabajadorSarIssste=");
		builder.append(idTrabajadorSarIssste);
		builder.append(", nciProcesar=");
		builder.append(nciProcesar);
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
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", saldoSarIssste=");
		builder.append(saldoSarIssste);
		builder.append(", bancoIcefa=");
		builder.append(bancoIcefa);
		builder.append("]");
		return builder.toString();
	}
	
}
