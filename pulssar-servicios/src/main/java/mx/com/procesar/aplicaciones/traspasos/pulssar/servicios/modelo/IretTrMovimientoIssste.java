package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Entidad IRET_TR_MOVIMIENTO_ISSSTE
 * @author Hugo Cesar Garza Montoya (hucgarza@procesar.com)
 * @version 1.0
 * @since 09/08/2021
 */
public class IretTrMovimientoIssste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 822795173481075114L;

	
	/**
	 * ID_MOVIMIENTO_ISSSTE
	 */
	private Long idMovimientoIssste;
	/**
	 * Clave única de la entidad de movimientos ISSSTE.
	 */
	private String cvMovimientoIssste;
	/**
	 * Clave única de movimientos ISSSTE.
	 */
	private String chSecuenciaPension;
	/**
	 * Consecutivo enviado por el Instituto de Seguridad Social en la Resolución.
	 */
	private String curp;
	/**
	 * Clave única de registro de población (CURP).
	 */
	private int nuNumeroIssste;
	/**
	 * Número Número de Control único para derechohabientes Dato obligatorio..
	 */
	private int nuNumeroPension;
	/**
	 * Número de Resolución (Concesión).
	 */
	private String chNumeroResolucion;
	/**
	 * Clave asociada al movimiento.
	 */
	private String chMovimiento;
	/**
	 * Consecutivo del movimiento.
	 */
	private int nuConsecutivoMovimiento;
	/**
	 * Fecha en la que se realizó el movimiento.
	 */
	private Date fcMovimiento;
	/**
	 * Clave de AFORE.
	 */
	private String chAfore;
	/**
	 * Clave de la aseguradora.
	 */
	private String chAseguradora;
	/**
	 * Clave de resultado RCV.
	 */
	private String chResultadoRCV;
	/**
	 * Clave del diagnóstico de RCV.
	 */
	private String chDiagnosticoRCV;
	/**
	 * Fecha en la que se obtuvo el resultado de RCV.
	 */
	private Date fcResultadoRCV;
	/**
	 * Monto del retiro ISSSTE 2008.
	 */
	private long nuMontoRetiro2008;
	/**
	 * Monto o importe de la subcuenta de Cesantia y Vejez (CV).
	 */
	private long nuMontoCV;
	/**
	 * Monto o importe de la subcuenta de cuota social.
	 */
	private long nuMontoCS;
	/**
	 * Monto o Importe de Bono.
	 */
	private long nuMontoBono;
	/**
	 * Clave asociada al resultado de vivienda.
	 */
	private String chResultadoVivienda;
	/**
	 * Clave asociada al diagnóstico de vivienda.
	 */
	private String chDiagnosticoVivienda;
	/**
	 * Fecha en al que se dió el resultado de vivienda.
	 */
	private Date fcResultadoVivienda;
	/**
	 * Monto o Importe de Vivienda 92.
	 */
	private long nuMontoVivienda92;
	/**
	 * Monto o Importe de Vivienda 2008.
	 */
	private long nuMontoVivienda2008;
	/**
	 * Clave asociada al Ahorro Solidario.
	 */
	private String chResultadoAhorroSolidario;
	/**
	 * Monto o Importe de Ahorro Solidario.
	 */
	private long nuMontoAhorroSolidario;
	/**
	 * Clave asociada al resultado de Retiro.
	 */
	private String chResultadoRetiro92;
	/**
	 * Monto o Importe de Retiro 92.
	 */
	private long nuMontoRetiro92;
	/**
	 * Monto ISSSTE.
	 */
	private long nuMontoIssste;
	/**
	 * Monto o Importe de RCV.
	 */
	private long nuMontoRCV;
	/**
	 * Fecha en la que se realizó la actualización en el Datamart compartido con el Instituto.
	 */
	private String fcActualizacionDataMart;
	/**
	 * Clave del diagnóstico realizado por PROCESAR.
	 */
	private String chDiagnosticoProcesar;
	/**
	 * Número de folio de ISSSTE.
	 */
	private String chFolioIssste;
	/**
	 * Clave de banco.
	 */
	private String chBanco;
	/**
	 * Número de cuenta bancaria.
	 */
	private String chCuentaBanco;
	/**
	 * Número de cuenta CLABE.
	 */
	private String clabe;
	/**
	 * Clave asociada al estatus.
	 */
	private String chEstatus;
	/**
	 * Fecha de última modificación del registro
	 */
	private Date fcControl;
	/**
	 * Usuario/Programa o Ente que hizo la última modificación del registro.
	 */
	private String chUsuarioModificador;
	/**
	 * Clave única del catálogo de estatus de los procesos ISSSTE.
	 */
	private int idEstatus;
	/**
	 * Clave asociada al Ahorro Complementario
	 */
	private String chResultadoAhorroComple;
	/**
	 * Monto o Importe de Ahorro Complementario
	 */
	private long nuMontoAhorroComple;
	/**
	 * @return
	 */
	public long getIdMovimientoIssste() {
		return idMovimientoIssste;
	}
	/**
	 * @param idMovimientoIssste
	 */
	public void setIdMovimientoIssste(long idMovimientoIssste) {
		this.idMovimientoIssste = idMovimientoIssste;
	}
	/**
	 * @return
	 */
	public String getCvMovimientoIssste() {
		return cvMovimientoIssste;
	}
	/**
	 * @param cvMovimientoIssste
	 */
	public void setCvMovimientoIssste(String cvMovimientoIssste) {
		this.cvMovimientoIssste = cvMovimientoIssste;
	}
	/**
	 * @return
	 */
	public String getChSecuenciaPension() {
		return chSecuenciaPension;
	}
	/**
	 * @param chSecuenciaPension
	 */
	public void setChSecuenciaPension(String chSecuenciaPension) {
		this.chSecuenciaPension = chSecuenciaPension;
	}
	/**
	 * @return
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return
	 */
	public int getNuNumeroIssste() {
		return nuNumeroIssste;
	}
	/**
	 * @param nuNumeroIssste
	 */
	public void setNuNumeroIssste(int nuNumeroIssste) {
		this.nuNumeroIssste = nuNumeroIssste;
	}
	/**
	 * @return
	 */
	public int getNuNumeroPension() {
		return nuNumeroPension;
	}
	/**
	 * @param nuNumeroPension
	 */
	public void setNuNumeroPension(int nuNumeroPension) {
		this.nuNumeroPension = nuNumeroPension;
	}
	/**
	 * @return
	 */
	public String getChNumeroResolucion() {
		return chNumeroResolucion;
	}
	/**
	 * @param chNumeroResolucion
	 */
	public void setChNumeroResolucion(String chNumeroResolucion) {
		this.chNumeroResolucion = chNumeroResolucion;
	}
	/**
	 * @return
	 */
	public String getChMovimiento() {
		return chMovimiento;
	}
	/**
	 * @param chMovimiento
	 */
	public void setChMovimiento(String chMovimiento) {
		this.chMovimiento = chMovimiento;
	}
	/**
	 * @return
	 */
	public int getNuConsecutivoMovimiento() {
		return nuConsecutivoMovimiento;
	}
	/**
	 * @param nuConsecutivoMovimiento
	 */
	public void setNuConsecutivoMovimiento(int nuConsecutivoMovimiento) {
		this.nuConsecutivoMovimiento = nuConsecutivoMovimiento;
	}
	/**
	 * @return
	 */
	public Date getFcMovimiento() {
		return fcMovimiento;
	}
	/**
	 * @param fcMovimiento
	 */
	public void setFcMovimiento(Date fcMovimiento) {
		this.fcMovimiento = fcMovimiento;
	}
	/**
	 * @return
	 */
	public String getChAfore() {
		return chAfore;
	}
	/**
	 * @param chAfore
	 */
	public void setChAfore(String chAfore) {
		this.chAfore = chAfore;
	}
	/**
	 * @return
	 */
	public String getChAseguradora() {
		return chAseguradora;
	}
	/**
	 * @param chAseguradora
	 */
	public void setChAseguradora(String chAseguradora) {
		this.chAseguradora = chAseguradora;
	}
	/**
	 * @return
	 */
	public String getChResultadoRCV() {
		return chResultadoRCV;
	}
	/**
	 * @param chResultadoRCV
	 */
	public void setChResultadoRCV(String chResultadoRCV) {
		this.chResultadoRCV = chResultadoRCV;
	}
	/**
	 * @return
	 */
	public String getChDiagnosticoRCV() {
		return chDiagnosticoRCV;
	}
	/**
	 * @param chDiagnosticoRCV
	 */
	public void setChDiagnosticoRCV(String chDiagnosticoRCV) {
		this.chDiagnosticoRCV = chDiagnosticoRCV;
	}
	/**
	 * @return
	 */
	public Date getFcResultadoRCV() {
		return fcResultadoRCV;
	}
	/**
	 * @param fcResultadoRCV
	 */
	public void setFcResultadoRCV(Date fcResultadoRCV) {
		this.fcResultadoRCV = fcResultadoRCV;
	}
	/**
	 * @return
	 */
	public long getNuMontoRetiro2008() {
		return nuMontoRetiro2008;
	}
	/**
	 * @param nuMontoRetiro2008
	 */
	public void setNuMontoRetiro2008(long nuMontoRetiro2008) {
		this.nuMontoRetiro2008 = nuMontoRetiro2008;
	}
	/**
	 * @return
	 */
	public long getNuMontoCV() {
		return nuMontoCV;
	}
	/**
	 * @param nuMontoCV
	 */
	public void setNuMontoCV(long nuMontoCV) {
		this.nuMontoCV = nuMontoCV;
	}
	/**
	 * @return
	 */
	public long getNuMontoCS() {
		return nuMontoCS;
	}
	/**
	 * @param nuMontoCS
	 */
	public void setNuMontoCS(long nuMontoCS) {
		this.nuMontoCS = nuMontoCS;
	}
	/**
	 * @return
	 */
	public long getNuMontoBono() {
		return nuMontoBono;
	}
	/**
	 * @param nuMontoBono
	 */
	public void setNuMontoBono(long nuMontoBono) {
		this.nuMontoBono = nuMontoBono;
	}
	/**
	 * @return
	 */
	public String getChResultadoVivienda() {
		return chResultadoVivienda;
	}
	/**
	 * @param chResultadoVivienda
	 */
	public void setChResultadoVivienda(String chResultadoVivienda) {
		this.chResultadoVivienda = chResultadoVivienda;
	}
	/**
	 * @return
	 */
	public String getChDiagnosticoVivienda() {
		return chDiagnosticoVivienda;
	}
	/**
	 * @param chDiagnosticoVivienda
	 */
	public void setChDiagnosticoVivienda(String chDiagnosticoVivienda) {
		this.chDiagnosticoVivienda = chDiagnosticoVivienda;
	}
	/**
	 * @return
	 */
	public Date getFcResultadoVivienda() {
		return fcResultadoVivienda;
	}
	/**
	 * @param fcResultadoVivienda
	 */
	public void setFcResultadoVivienda(Date fcResultadoVivienda) {
		this.fcResultadoVivienda = fcResultadoVivienda;
	}
	/**
	 * @return
	 */
	public long getNuMontoVivienda92() {
		return nuMontoVivienda92;
	}
	/**
	 * @param nuMontoVivienda92
	 */
	public void setNuMontoVivienda92(long nuMontoVivienda92) {
		this.nuMontoVivienda92 = nuMontoVivienda92;
	}
	/**
	 * @return
	 */
	public long getNuMontoVivienda2008() {
		return nuMontoVivienda2008;
	}
	/**
	 * @param nuMontoVivienda2008
	 */
	public void setNuMontoVivienda2008(long nuMontoVivienda2008) {
		this.nuMontoVivienda2008 = nuMontoVivienda2008;
	}
	/**
	 * @return
	 */
	public String getChResultadoAhorroSolidario() {
		return chResultadoAhorroSolidario;
	}
	/**
	 * @param chResultadoAhorroSolidario
	 */
	public void setChResultadoAhorroSolidario(String chResultadoAhorroSolidario) {
		this.chResultadoAhorroSolidario = chResultadoAhorroSolidario;
	}
	/**
	 * @return
	 */
	public long getNuMontoAhorroSolidario() {
		return nuMontoAhorroSolidario;
	}
	/**
	 * @param nuMontoAhorroSolidario
	 */
	public void setNuMontoAhorroSolidario(long nuMontoAhorroSolidario) {
		this.nuMontoAhorroSolidario = nuMontoAhorroSolidario;
	}
	/**
	 * @return
	 */
	public String getChResultadoRetiro92() {
		return chResultadoRetiro92;
	}
	/**
	 * @param chResultadoRetiro92
	 */
	public void setChResultadoRetiro92(String chResultadoRetiro92) {
		this.chResultadoRetiro92 = chResultadoRetiro92;
	}
	/**
	 * @return
	 */
	public long getNuMontoRetiro92() {
		return nuMontoRetiro92;
	}
	/**
	 * @param nuMontoRetiro92
	 */
	public void setNuMontoRetiro92(long nuMontoRetiro92) {
		this.nuMontoRetiro92 = nuMontoRetiro92;
	}
	/**
	 * @return
	 */
	public long getNuMontoIssste() {
		return nuMontoIssste;
	}
	/**
	 * @param nuMontoIssste
	 */
	public void setNuMontoIssste(long nuMontoIssste) {
		this.nuMontoIssste = nuMontoIssste;
	}
	/**
	 * @return
	 */
	public long getNuMontoRCV() {
		return nuMontoRCV;
	}
	/**
	 * @param nuMontoRCV
	 */
	public void setNuMontoRCV(long nuMontoRCV) {
		this.nuMontoRCV = nuMontoRCV;
	}
	/**
	 * @return
	 */
	public String getFcActualizacionDataMart() {
		return fcActualizacionDataMart;
	}
	/**
	 * @param fcActualizacionDataMart
	 */
	public void setFcActualizacionDataMart(String fcActualizacionDataMart) {
		this.fcActualizacionDataMart = fcActualizacionDataMart;
	}
	/**
	 * @return
	 */
	public String getChDiagnosticoProcesar() {
		return chDiagnosticoProcesar;
	}
	/**
	 * @param chDiagnosticoProcesar
	 */
	public void setChDiagnosticoProcesar(String chDiagnosticoProcesar) {
		this.chDiagnosticoProcesar = chDiagnosticoProcesar;
	}
	/**
	 * @return
	 */
	public String getChFolioIssste() {
		return chFolioIssste;
	}
	/**
	 * @param chFolioIssste
	 */
	public void setChFolioIssste(String chFolioIssste) {
		this.chFolioIssste = chFolioIssste;
	}
	/**
	 * @return
	 */
	public String getChBanco() {
		return chBanco;
	}
	/**
	 * @param chBanco
	 */
	public void setChBanco(String chBanco) {
		this.chBanco = chBanco;
	}
	/**
	 * @return
	 */
	public String getChCuentaBanco() {
		return chCuentaBanco;
	}
	/**
	 * @param chCuentaBanco
	 */
	public void setChCuentaBanco(String chCuentaBanco) {
		this.chCuentaBanco = chCuentaBanco;
	}
	/**
	 * @return
	 */
	public String getClabe() {
		return clabe;
	}
	/**
	 * @param clabe
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	/**
	 * @return
	 */
	public String getChEstatus() {
		return chEstatus;
	}
	/**
	 * @param chEstatus
	 */
	public void setChEstatus(String chEstatus) {
		this.chEstatus = chEstatus;
	}
	/**
	 * @return
	 */
	public Date getFcControl() {
		return fcControl;
	}
	/**
	 * @param fcControl
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}
	/**
	 * @return
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}
	/**
	 * @param chUsuarioModificador
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}
	/**
	 * @return
	 */
	public int getIdEstatus() {
		return idEstatus;
	}
	/**
	 * @param idEstatus
	 */
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	/**
	 * @return
	 */
	public String getChResultadoAhorroComple() {
		return chResultadoAhorroComple;
	}
	/**
	 * @param chResultadoAhorroComple
	 */
	public void setChResultadoAhorroComple(String chResultadoAhorroComple) {
		this.chResultadoAhorroComple = chResultadoAhorroComple;
	}
	/**
	 * @return
	 */
	public long getNuMontoAhorroComple() {
		return nuMontoAhorroComple;
	}
	/**
	 * @param nuMontoAhorroComple
	 */
	public void setNuMontoAhorroComple(long nuMontoAhorroComple) {
		this.nuMontoAhorroComple = nuMontoAhorroComple;
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}	

}
