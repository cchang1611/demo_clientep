package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase datos de entrada
 * @author ANOSORIO
 *
 */
public class ParametrosRetiroParcialCalculoIssste implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -6873682039573039992L;

	
	/**
	 * claveProceso
	 */
	private String claveProceso;
	
	/**
	 * tipoOperacion
	 */
	private String tipoOperacion;
	
	
	/**
	 * proceso de referencia
	 */
	private Long procesoReferencia;
	
	/**
	 * folio de proceso del expediente
	 */
	private String folio;
	
	/**
	 * cuenta
	 */
	private String cuenta;
	
		
	/**
	 * cuentaClabe
	 */
	private String cuentaClabe;
	
	/**
	 * formaPago
	 */
	private String formaPago;
	
	/**
	 * claveBanco
	 */
	private String claveBanco;
	
	/**
	 * estatus
	 */
	private Integer estatus;

	/**
	 * idDisposicion
	 */
	private Long idDisposicion;
	
	
	/**
	 * Monto constitutivo
	 */
	private Double montoConstitutivo;
	
	/**
	 * saldoRetiro92I
	 */
	private Double saldoRetiro92I;
	
	/**
	 * saldoRetiro08I
	 */
	private Double saldoRetiro08I;
	
	/**
	 * saldoRcv
	 */
	private Double saldoRcv;
	
	
	/**
	 * totalSaldos
	 */
	private Double totalSaldos;
	
	/**
	 * parcialidad
	 */
	private Long parcialidad; 
	
	/**
	 * usuarioModificador 
	 */
	private String usuarioModificador;
	
	
	/**
	 * @return the claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}


	/**
	 * @param claveProceso the claveProceso to set
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}


	/**
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}


	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}


	/**
	 * @return the procesoReferencia
	 */
	public Long getProcesoReferencia() {
		return procesoReferencia;
	}


	/**
	 * @param procesoReferencia the procesoReferencia to set
	 */
	public void setProcesoReferencia(Long procesoReferencia) {
		this.procesoReferencia = procesoReferencia;
	}


	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}


	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}


	/**
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}


	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}


	/**
	 * @return the cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}


	/**
	 * @param cuentaClabe the cuentaClabe to set
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}


	/**
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}


	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}


	/**
	 * @return the claveBanco
	 */
	public String getClaveBanco() {
		return claveBanco;
	}


	/**
	 * @param claveBanco the claveBanco to set
	 */
	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}


	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}


	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	/**
	 * @return the idDisposicion
	 */
	public Long getIdDisposicion() {
		return idDisposicion;
	}


	/**
	 * @param idDisposicion the idDisposicion to set
	 */
	public void setIdDisposicion(Long idDisposicion) {
		this.idDisposicion = idDisposicion;
	}



	/**
	 * @return the saldoRcv
	 */
	public Double getSaldoRcv() {
		return saldoRcv;
	}


	/**
	 * @param saldoRcv the saldoRcv to set
	 */
	public void setSaldoRcv(Double saldoRcv) {
		this.saldoRcv = saldoRcv;
	}


	/**
	 * @return the totalSaldos
	 */
	public Double getTotalSaldos() {
		return totalSaldos;
	}


	/**
	 * @param totalSaldos the totalSaldos to set
	 */
	public void setTotalSaldos(Double totalSaldos) {
		this.totalSaldos = totalSaldos;
	}


	/**
	 * @return the parcialidad
	 */
	public Long getParcialidad() {
		return parcialidad;
	}


	/**
	 * @param parcialidad the parcialidad to set
	 */
	public void setParcialidad(Long parcialidad) {
		this.parcialidad = parcialidad;
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
	 * @return the montoConstitutivo
	 */
	public Double getMontoConstitutivo() {
		return montoConstitutivo;
	}


	/**
	 * @param montoConstitutivo the montoConstitutivo to set
	 */
	public void setMontoConstitutivo(Double montoConstitutivo) {
		this.montoConstitutivo = montoConstitutivo;
	}


	/**
	 * @return the saldoRetiro92I
	 */
	public Double getSaldoRetiro92I() {
		return saldoRetiro92I;
	}


	/**
	 * @param saldoRetiro92I the saldoRetiro92I to set
	 */
	public void setSaldoRetiro92I(Double saldoRetiro92I) {
		this.saldoRetiro92I = saldoRetiro92I;
	}


	/**
	 * @return the saldoRetiro08I
	 */
	public Double getSaldoRetiro08I() {
		return saldoRetiro08I;
	}


	/**
	 * @param saldoRetiro08I the saldoRetiro08I to set
	 */
	public void setSaldoRetiro08I(Double saldoRetiro08I) {
		this.saldoRetiro08I = saldoRetiro08I;
	}


	/**
     * Constructor
     */
	public ParametrosRetiroParcialCalculoIssste() {
		//Contructor default
	}


	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParametrosRetiroParcialCalculoIssste [claveProceso=");
		builder.append(claveProceso);
		builder.append(", tipoOperacion=");
		builder.append(tipoOperacion);
		builder.append(", procesoReferencia=");
		builder.append(procesoReferencia);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", cuenta=");
		builder.append(cuenta);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", formaPago=");
		builder.append(formaPago);
		builder.append(", claveBanco=");
		builder.append(claveBanco);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", idDisposicion=");
		builder.append(idDisposicion);
		builder.append(", montoConstitutivo=");
		builder.append(montoConstitutivo);
		builder.append(", saldoRetiro92I=");
		builder.append(saldoRetiro92I);
		builder.append(", saldoRetiro08I=");
		builder.append(saldoRetiro08I);
		builder.append(", saldoRcv=");
		builder.append(saldoRcv);
		builder.append(", totalSaldos=");
		builder.append(totalSaldos);
		builder.append(", parcialidad=");
		builder.append(parcialidad);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
}
