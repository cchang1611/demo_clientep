package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Dato entrada
 * @author ANICOLAS
 *
 */
public class ProcesoDerechoCargado implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -4518797289574819550L;

	/**
	 * ch_numero_resolucion
	 */
	private String numeroResolucion;
	
	/**
	 * secuenciaPension
	 */
	private String secuenciaPension;
	
	/**
	 * fcInicioPension
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
	 * cvTipoPrestacion
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
	 * cvTipoRetiro
	 */
	private String cvTipoRetiro;
	
	/**
	 * primerTipoRetiro
	 */
	private String primerTipoRetiro;
	
	/**
	 * radioCargado
	 */
	private String radioCargado;
    /**
     *  Constructor Argumentos
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param numeroResolucion
     *  @param secuenciaPension
     *  @param fcInicioPension
     *  @param fcEmisionResolucion
     *  @param porcentajeValuacion
     *  @param semanasCotizadas
     *  @param descTipoRetiro
     *  @param descTipoSeguro
     *  @param cvTipoSeguro
     *  @param descTipoPension
     *  @param cvTipoPrestacion
     *  @param descTipoPrestacion
     *  @param cvTipoPension
     *  @param descTipoRegimen
     *  @param cvTipoRegimen
     *  @param cvTipoRetiro
     *  @param primerTipoRetiro
     *  @param radioCargado
     */
	public ProcesoDerechoCargado(String numeroResolucion, String secuenciaPension, Date fcInicioPension,
			Date fcEmisionResolucion, Long porcentajeValuacion, Long semanasCotizadas, String descTipoRetiro,
			String descTipoSeguro, String cvTipoSeguro, String descTipoPension, String cvTipoPrestacion,
			String descTipoPrestacion, String cvTipoPension, String descTipoRegimen, String cvTipoRegimen,
			String cvTipoRetiro, String primerTipoRetiro, String radioCargado) {
		this.numeroResolucion = numeroResolucion;
		this.secuenciaPension = secuenciaPension;
		this.fcInicioPension = fcInicioPension;
		this.fcEmisionResolucion = fcEmisionResolucion;
		this.porcentajeValuacion = porcentajeValuacion;
		this.semanasCotizadas = semanasCotizadas;
		this.descTipoRetiro = descTipoRetiro;
		this.descTipoSeguro = descTipoSeguro;
		this.cvTipoSeguro = cvTipoSeguro;
		this.descTipoPension = descTipoPension;
		this.cvTipoPrestacion = cvTipoPrestacion;
		this.descTipoPrestacion = descTipoPrestacion;
		this.cvTipoPension = cvTipoPension;
		this.descTipoRegimen = descTipoRegimen;
		this.cvTipoRegimen = cvTipoRegimen;
		this.cvTipoRetiro = cvTipoRetiro;
		this.primerTipoRetiro = primerTipoRetiro;
		this.radioCargado = radioCargado;
	}

	/**
	 *  Contructor
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	
	public ProcesoDerechoCargado() {
		
	}
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
	 * @return el atributo radioCargado
	 */
	public String getRadioCargado() {
		return radioCargado;
	}

	/**
	 * @param radioCargado parametro radioCargado a actualizar
	 */
	public void setRadioCargado(String radioCargado) {
		this.radioCargado = radioCargado;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoDerechoCargado [numeroResolucion=");
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
		builder.append(", cvTipoRetiro=");
		builder.append(cvTipoRetiro);
		builder.append(", primerTipoRetiro=");
		builder.append(primerTipoRetiro);
		builder.append(", radioCargado=");
		builder.append(radioCargado);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
