package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ANICOLAS
 *
 */
public class ProcesoDerechoNoCargado implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -4518797289574819550L;

	/**
	 * ch_numero_resolucion
	 */
	private String numeroResolucion;
	
	/**
	 * 
	 */
	private String secuenciaPension;
	
	/**
	 * secuenciaPension
	 */
	private Date fcInicioPension;
	
	/**
	 * fcEmisionResolucion
	 */
	private Date fcEmisionResolucion;
	
	/**
	 * porcentajeValuacion
	 */
	private Long porcentajeValuacion;
	
	
	/**
	 * semanasCotizadas
	 */
	private Long  semanasCotizadas;
	
	/**
	 * descTipoRetiro
	 */
	private String descTipoRetiro;
	
	/**
	 * cvTipoRetiro
	 */
	private String cvTipoRetiro;
	
	/**
	 * ch_desc_tipo_seguro
	 */
	private String descTipoSeguro;
	
	/**
	 * cvTipoSeguro
	 */
	private String cvTipoSeguro;
	
	/**
	 * ch_desc_tipo_pension
	 */
	private String descTipoPension;
	
	/**
	 * cvTipoRetiro
	 */
	private String cvTipoPrestacion;
	

	/**
	 * descTipoPrestacion
	 */
	private String descTipoPrestacion;
	
	
	/**
	 * cvTipoPension
	 */
	private String cvTipoPension;
	
	/**
	 * ch_desc_tipo_regimen
	 */
	private String descTipoRegimen;

	/**
	 * cvTipoRegimen
	 */
	private String cvTipoRegimen;
	
	/**
	 * primerTipoRetiro
	 */
	private String primerTipoRetiro;
	
	/**
     * seleccionadoTipoRegimen
     */
	private String agregarAuxTipoRegimen;
	
	/**
	 * claveTipoRetiro
	 */
	private String agregarAuxTipoRetiro;
	
	/**
	 * claveTipoSeguro
	 */
	private String agregarAuxTipoSeguro;
	
	/**
	 * claveTipoPension
	 */
	private String agregarAuxTipoPension;
	
	/**
	 * seleccionadoTipoPrestacion
	 */
	private String agregarAuxTipoPrestacion;
	
	/**
	 * diagnostico
	 */
	private String diagnostico;
	
	/**
	 * claveProceso
	 */
	private String claveProceso;
	
	/**
	 * claveTipoPrestacion
	 */
	private String claveTipoPrestacion;
	
	/**
	 * claveTipoEntidad
	 */
	private String claveTipoEntidad;
	
	/**
	 * rjp
	 */
	private String rjp;
	
	/**
	 * @return the numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion the numeroResolucion to set
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
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
	 * @return the fcInicioPension
	 */
	public Date getFcInicioPension() {
		return fcInicioPension;
	}

	/**
	 * @param fcInicioPension the fcInicioPension to set
	 */
	public void setFcInicioPension(Date fcInicioPension) {
		this.fcInicioPension = fcInicioPension;
	}

	/**
	 * @return the fcEmisionResolucion
	 */
	public Date getFcEmisionResolucion() {
		return fcEmisionResolucion;
	}

	/**
	 * @param fcEmisionResolucion the fcEmisionResolucion to set
	 */
	public void setFcEmisionResolucion(Date fcEmisionResolucion) {
		this.fcEmisionResolucion = fcEmisionResolucion;
	}

	/**
	 * @return the porcentajeValuacion
	 */
	public Long getPorcentajeValuacion() {
		return porcentajeValuacion;
	}

	/**
	 * @param porcentajeValuacion the porcentajeValuacion to set
	 */
	public void setPorcentajeValuacion(Long porcentajeValuacion) {
		this.porcentajeValuacion = porcentajeValuacion;
	}

	/**
	 * @return the semanasCotizadas
	 */
	public Long getSemanasCotizadas() {
		return semanasCotizadas;
	}

	/**
	 * @param semanasCotizadas the semanasCotizadas to set
	 */
	public void setSemanasCotizadas(Long semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
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
	 * @return el atributo cvTipoSeguro
	 */
	public String getCvTipoSeguro() {
		return cvTipoSeguro;
	}

	/**
	 * @param cvTipoSeguro parametro cvTipoSeguro a actualizar
	 */
	public void setCvTipoSeguro(String cvTipoSeguro) {
		this.cvTipoSeguro = cvTipoSeguro;
	}

	/**
	 * @return el atributo cvTipoPrestacion
	 */
	public String getCvTipoPrestacion() {
		return cvTipoPrestacion;
	}

	/**
	 * @param cvTipoPrestacion parametro cvTipoPrestacion a actualizar
	 */
	public void setCvTipoPrestacion(String cvTipoPrestacion) {
		this.cvTipoPrestacion = cvTipoPrestacion;
	}

	/**
	 * @return el atributo cvTipoPension
	 */
	public String getCvTipoPension() {
		return cvTipoPension;
	}

	/**
	 * @param cvTipoPension parametro cvTipoPension a actualizar
	 */
	public void setCvTipoPension(String cvTipoPension) {
		this.cvTipoPension = cvTipoPension;
	}

	/**
	 * @return el atributo cvTpoRegimen
	 */
	public String getCvTipoRegimen() {
		return cvTipoRegimen;
	}

	/**
	 * @param cvTpoRegimen parametro cvTpoRegimen a actualizar
	 */
	public void setCvTpoRegimen(String cvTipoRegimen) {
		this.cvTipoRegimen = cvTipoRegimen;
	}

	
	
	
	/**
	 * @return el atributo primerTipoRetiro
	 */
	public String getPrimerTipoRetiro() {
		return primerTipoRetiro;
	}

	/**
	 * @param primerTipoRetiro parametro primerTipoRetiro a actualizar
	 */
	public void setPrimerTipoRetiro(String primerTipoRetiro) {
		this.primerTipoRetiro = primerTipoRetiro;
	}

	/**
	 * @param cvTipoRegimen parametro cvTipoRegimen a actualizar
	 */
	public void setCvTipoRegimen(String cvTipoRegimen) {
		this.cvTipoRegimen = cvTipoRegimen;
	}

	
	
	
	/**
	 * @return el atributo cvTipoRetiro
	 */
	public String getCvTipoRetiro() {
		return cvTipoRetiro;
	}

	/**
	 * @param cvTipoRetiro parametro cvTipoRetiro a actualizar
	 */
	public void setCvTipoRetiro(String cvTipoRetiro) {
		this.cvTipoRetiro = cvTipoRetiro;
	}

	/**
	 * @return el atributo agregarAuxTipoRegimen
	 */
	public String getAgregarAuxTipoRegimen() {
		return agregarAuxTipoRegimen;
	}

	/**
	 * @param agregarAuxTipoRegimen parametro agregarAuxTipoRegimen a actualizar
	 */
	public void setAgregarAuxTipoRegimen(String agregarAuxTipoRegimen) {
		this.agregarAuxTipoRegimen = agregarAuxTipoRegimen;
	}

	/**
	 * @return el atributo agregarAuxTipoRetiro
	 */
	public String getAgregarAuxTipoRetiro() {
		return agregarAuxTipoRetiro;
	}

	/**
	 * @param agregarAuxTipoRetiro parametro agregarAuxTipoRetiro a actualizar
	 */
	public void setAgregarAuxTipoRetiro(String agregarAuxTipoRetiro) {
		this.agregarAuxTipoRetiro = agregarAuxTipoRetiro;
	}

	/**
	 * @return el atributo agregarAuxTipoSeguro
	 */
	public String getAgregarAuxTipoSeguro() {
		return agregarAuxTipoSeguro;
	}

	/**
	 * @param agregarAuxTipoSeguro parametro agregarAuxTipoSeguro a actualizar
	 */
	public void setAgregarAuxTipoSeguro(String agregarAuxTipoSeguro) {
		this.agregarAuxTipoSeguro = agregarAuxTipoSeguro;
	}

	/**
	 * @return el atributo agregarAuxTipoPension
	 */
	public String getAgregarAuxTipoPension() {
		return agregarAuxTipoPension;
	}

	/**
	 * @param agregarAuxTipoPension parametro agregarAuxTipoPension a actualizar
	 */
	public void setAgregarAuxTipoPension(String agregarAuxTipoPension) {
		this.agregarAuxTipoPension = agregarAuxTipoPension;
	}

	/**
	 * @return el atributo agregarAuxTipoPrestacion
	 */
	public String getAgregarAuxTipoPrestacion() {
		return agregarAuxTipoPrestacion;
	}

	/**
	 * @param agregarAuxTipoPrestacion parametro agregarAuxTipoPrestacion a actualizar
	 */
	public void setAgregarAuxTipoPrestacion(String agregarAuxTipoPrestacion) {
		this.agregarAuxTipoPrestacion = agregarAuxTipoPrestacion;
	}

	
	
	
	/**
	 * @return el atributo diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico parametro diagnostico a actualizar
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return el atributo claveTipoPrestacion
	 */
	public String getClaveTipoPrestacion() {
		return claveTipoPrestacion;
	}

	/**
	 * @param claveTipoPrestacion parametro claveTipoPrestacion a actualizar
	 */
	public void setClaveTipoPrestacion(String claveTipoPrestacion) {
		this.claveTipoPrestacion = claveTipoPrestacion;
	}

	/**
	 * @return el atributo rjp
	 */
	public String getRjp() {
		return rjp;
	}

	/**
	 * @param rjp parametro rjp a actualizar
	 */
	public void setRjp(String rjp) {
		this.rjp = rjp;
	}

	
	
	
	/**
	 * @return el atributo claveTipoEntidad
	 */
	public String getClaveTipoEntidad() {
		return claveTipoEntidad;
	}

	/**
	 * @param claveTipoEntidad parametro claveTipoEntidad a actualizar
	 */
	public void setClaveTipoEntidad(String claveTipoEntidad) {
		this.claveTipoEntidad = claveTipoEntidad;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoDerechoNoCargado [numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", fcInicioPension=");
		builder.append(fcInicioPension);
		builder.append(", fcEmisionResolucion=");
		builder.append(fcEmisionResolucion);
		builder.append(", porcentajeValuacion=");
		builder.append(porcentajeValuacion);
		builder.append(", semanasCotizadas=");
		builder.append(semanasCotizadas);
		builder.append(", descTipoRetiro=");
		builder.append(descTipoRetiro);
		builder.append(", cvTipoRetiro=");
		builder.append(cvTipoRetiro);
		builder.append(", descTipoSeguro=");
		builder.append(descTipoSeguro);
		builder.append(", cvTipoSeguro=");
		builder.append(cvTipoSeguro);
		builder.append(", descTipoPension=");
		builder.append(descTipoPension);
		builder.append(", cvTipoPrestacion=");
		builder.append(cvTipoPrestacion);
		builder.append(", descTipoPrestacion=");
		builder.append(descTipoPrestacion);
		builder.append(", cvTipoPension=");
		builder.append(cvTipoPension);
		builder.append(", descTipoRegimen=");
		builder.append(descTipoRegimen);
		builder.append(", cvTipoRegimen=");
		builder.append(cvTipoRegimen);
		builder.append(", primerTipoRetiro=");
		builder.append(primerTipoRetiro);
		builder.append(", agregarAuxTipoRegimen=");
		builder.append(agregarAuxTipoRegimen);
		builder.append(", agregarAuxTipoRetiro=");
		builder.append(agregarAuxTipoRetiro);
		builder.append(", agregarAuxTipoSeguro=");
		builder.append(agregarAuxTipoSeguro);
		builder.append(", agregarAuxTipoPension=");
		builder.append(agregarAuxTipoPension);
		builder.append(", agregarAuxTipoPrestacion=");
		builder.append(agregarAuxTipoPrestacion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", claveProceso=");
		builder.append(claveProceso);
		builder.append(", claveTipoPrestacion=");
		builder.append(claveTipoPrestacion);
		builder.append(", claveTipoEntidad=");
		builder.append(claveTipoEntidad);
		builder.append(", rjp=");
		builder.append(rjp);
		builder.append("]");
		return builder.toString();
	}

	
		
}
