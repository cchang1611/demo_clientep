package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Resolucion disposicion issste
 * @author RARREOLA
 *
 */
public class ResolucionDisposicionIsssteVis implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * resolucion
	 */
	private Long idResolucion;
	
	/**
	 * Numero consecion
	 */
	private String numeroConcesion;
	
	
	/**
	 * Tipo prestacion
	 */
	private String cvTipoPrestacion;
	
	/**
	 * Tipo prestacion
	 */
	private String descTipoPrestacion;
	
	/**
	 * Tipo seguro
	 */
	private String cvTipoSeguro;
	
	/**
	 * Tipo seguro
	 */
	private String descTipoSeguro;
	
	/**
	 * Tipo retiro
	 */
	private String cvTipoRetiro;
	
	/**
	 * Tipo retiro
	 */
	private String descTipoRetiro;
	
	/**
	 * Tipo pension
	 */
	private String cvTipoPension;
	
	/**
	 * Tipo pension
	 */
	private String descTipoPension;
	
	/**
	 * Tipo regimen
	 */
	private String cvTipoRegimen;
	
	/**
	 * Tipo regimen
	 */
	private String descTipoRegimen;
	
	/**
	 * Tipo pension
	 */
	private String cvClavePension;
	
	
	/**
	 * Tipo pension
	 */
	private String descClavePension;
	
	/**
	 * Tipo movimiento
	 */
	private String cvMovimiento;
	
	
	/**
	 * Tipo movimiento
	 */
	private String descMovimiento;
	
	
	/**
	 * Secuencia pension
	 */
	
	
	private String secuenciaPension;
	
	/**
	 * Fecha emision resolucion
	 */
	private String fechaEmision;
	
	/**
	 * Fecha inicion pension
	 */
	private String fechaInicioPension;
	
	/**
	 * semanas cotizadas
	 */
	private Integer semanasCotizadas;
	
	/**
	 * Bandera
	 */
	private String bandera;
	
	
	/**
	 * Numero issste
	 */
	private String numeroIssste;
	
	
	
	

	/**
	 * @return the numeroIssste
	 */
	public String getNumeroIssste() {
		return numeroIssste;
	}

	/**
	 * @param numeroIssste the numeroIssste to set
	 */
	public void setNumeroIssste(String numeroIssste) {
		this.numeroIssste = numeroIssste;
	}
	
	
	
	/**
	 * @return the bandera
	 */
	public String getBandera() {
		return bandera;
	}

	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return the numeroConcesion
	 */
	public String getNumeroConcesion() {
		return numeroConcesion;
	}

	/**
	 * @param numeroConcesion the numeroConcesion to set
	 */
	public void setNumeroConcesion(String numeroConcesion) {
		this.numeroConcesion = numeroConcesion;
	}

	/**
	 * @return the cvTipoPrestacion
	 */
	public String getCvTipoPrestacion() {
		return cvTipoPrestacion;
	}

	/**
	 * @param cvTipoPrestacion the cvTipoPrestacion to set
	 */
	public void setCvTipoPrestacion(String cvTipoPrestacion) {
		this.cvTipoPrestacion = cvTipoPrestacion;
	}

	/**
	 * @return the descTipoPrestacion
	 */
	public String getDescTipoPrestacion() {
		return descTipoPrestacion;
	}

	/**
	 * @param descTipoPrestacion the descTipoPrestacion to set
	 */
	public void setDescTipoPrestacion(String descTipoPrestacion) {
		this.descTipoPrestacion = descTipoPrestacion;
	}

	/**
	 * @return the cvTipoSeguro
	 */
	public String getCvTipoSeguro() {
		return cvTipoSeguro;
	}

	/**
	 * @param cvTipoSeguro the cvTipoSeguro to set
	 */
	public void setCvTipoSeguro(String cvTipoSeguro) {
		this.cvTipoSeguro = cvTipoSeguro;
	}

	/**
	 * @return the descTipoSeguro
	 */
	public String getDescTipoSeguro() {
		return descTipoSeguro;
	}

	/**
	 * @param descTipoSeguro the descTipoSeguro to set
	 */
	public void setDescTipoSeguro(String descTipoSeguro) {
		this.descTipoSeguro = descTipoSeguro;
	}

	/**
	 * @return the cvTipoRetiro
	 */
	public String getCvTipoRetiro() {
		return cvTipoRetiro;
	}

	/**
	 * @param cvTipoRetiro the cvTipoRetiro to set
	 */
	public void setCvTipoRetiro(String cvTipoRetiro) {
		this.cvTipoRetiro = cvTipoRetiro;
	}

	/**
	 * @return the descTipoRetiro
	 */
	public String getDescTipoRetiro() {
		return descTipoRetiro;
	}

	/**
	 * @param descTipoRetiro the descTipoRetiro to set
	 */
	public void setDescTipoRetiro(String descTipoRetiro) {
		this.descTipoRetiro = descTipoRetiro;
	}

	/**
	 * @return the cvTipoPension
	 */
	public String getCvTipoPension() {
		return cvTipoPension;
	}

	/**
	 * @param cvTipoPension the cvTipoPension to set
	 */
	public void setCvTipoPension(String cvTipoPension) {
		this.cvTipoPension = cvTipoPension;
	}

	/**
	 * @return the descTipoPension
	 */
	public String getDescTipoPension() {
		return descTipoPension;
	}

	/**
	 * @param descTipoPension the descTipoPension to set
	 */
	public void setDescTipoPension(String descTipoPension) {
		this.descTipoPension = descTipoPension;
	}

	/**
	 * @return the cvTipoRegimen
	 */
	public String getCvTipoRegimen() {
		return cvTipoRegimen;
	}

	/**
	 * @param cvTipoRegimen the cvTipoRegimen to set
	 */
	public void setCvTipoRegimen(String cvTipoRegimen) {
		this.cvTipoRegimen = cvTipoRegimen;
	}

	/**
	 * @return the descTipoRegimen
	 */
	public String getDescTipoRegimen() {
		return descTipoRegimen;
	}

	/**
	 * @param descTipoRegimen the descTipoRegimen to set
	 */
	public void setDescTipoRegimen(String descTipoRegimen) {
		this.descTipoRegimen = descTipoRegimen;
	}

	/**
	 * @return the cvClavePension
	 */
	public String getCvClavePension() {
		return cvClavePension;
	}

	/**
	 * @param cvClavePension the cvClavePension to set
	 */
	public void setCvClavePension(String cvClavePension) {
		this.cvClavePension = cvClavePension;
	}

	/**
	 * @return the descClavePension
	 */
	public String getDescClavePension() {
		return descClavePension;
	}

	/**
	 * @param descClavePension the descClavePension to set
	 */
	public void setDescClavePension(String descClavePension) {
		this.descClavePension = descClavePension;
	}

	/**
	 * @return the cvMovimiento
	 */
	public String getCvMovimiento() {
		return cvMovimiento;
	}

	/**
	 * @param cvMovimiento the cvMovimiento to set
	 */
	public void setCvMovimiento(String cvMovimiento) {
		this.cvMovimiento = cvMovimiento;
	}

	/**
	 * @return the descMovimiento
	 */
	public String getDescMovimiento() {
		return descMovimiento;
	}

	/**
	 * @param descMovimiento the descMovimiento to set
	 */
	public void setDescMovimiento(String descMovimiento) {
		this.descMovimiento = descMovimiento;
	}
	
	
	/**
	 * @return the idResolucion
	 */
	public Long getIdResolucion() {
		return idResolucion;
	}

	/**
	 * @param idResolucion the idResolucion to set
	 */
	public void setIdResolucion(Long idResolucion) {
		this.idResolucion = idResolucion;
	}
	
	
	

	/**
	 * @return the secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}

	/**
	 * @param secuenciaPension the secuenciaPension to set
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
	}

	

	

	/**
	 * @return the fechaEmision
	 */
	public String getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the fechaInicioPension
	 */
	public String getFechaInicioPension() {
		return fechaInicioPension;
	}

	/**
	 * @param fechaInicioPension the fechaInicioPension to set
	 */
	public void setFechaInicioPension(String fechaInicioPension) {
		this.fechaInicioPension = fechaInicioPension;
	}

	/**
	 * @return the semanasCotizadas
	 */
	public Integer getSemanasCotizadas() {
		return semanasCotizadas;
	}

	/**
	 * @param semanasCotizadas the semanasCotizadas to set
	 */
	public void setSemanasCotizadas(Integer semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}

	
	

	/**
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResolucionDisposicionIssste [numeroConcesion=");
		builder.append(numeroConcesion);
		builder.append(", cvTipoPrestacion=");
		builder.append(cvTipoPrestacion);
		builder.append(", descTipoPrestacion=");
		builder.append(descTipoPrestacion);
		builder.append(", cvTipoSeguro=");
		builder.append(cvTipoSeguro);
		builder.append(", descTipoSeguro=");
		builder.append(descTipoSeguro);
		builder.append(", cvTipoRetiro=");
		builder.append(cvTipoRetiro);
		builder.append(", descTipoRetiro=");
		builder.append(descTipoRetiro);
		builder.append(", cvTipoPension=");
		builder.append(cvTipoPension);
		builder.append(", descTipoPension=");
		builder.append(descTipoPension);
		builder.append(", cvTipoRegimen=");
		builder.append(cvTipoRegimen);
		builder.append(", descTipoRegimen=");
		builder.append(descTipoRegimen);
		builder.append(", cvClavePension=");
		builder.append(cvClavePension);
		builder.append(", descClavePension=");
		builder.append(descClavePension);
		builder.append(", cvMovimiento=");
		builder.append(cvMovimiento);
		builder.append(", descMovimiento=");
		builder.append(descMovimiento);
		builder.append(", idResolucion=");
		builder.append(idResolucion);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", fechaEmision=");
		builder.append(fechaEmision);
		builder.append(", fechaInicioPension=");
		builder.append(fechaInicioPension);
		builder.append(", semanasCotizadas=");
		builder.append(semanasCotizadas);
		builder.append(", bandera=");
		builder.append(bandera);
		builder.append(", numeroIssste=");
		builder.append(numeroIssste);
		
		builder.append("]");
		return builder.toString();
	}


}
