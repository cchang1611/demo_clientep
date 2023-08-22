package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;
/**
 * Datos entrada disposicion issste
 * @author RARREOLA
 *
 */
public class DisposicionIsssteEntrada implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * primero combo
	 */
	private String primerCombo;

	/**
	 * claveTipoRegimen
	 */
	private String claveTipoRegimen;
	
	/**
	 * claveTipoRetiro
	 */
	private String claveTipoRetiro;
	
	/**
	 * claveTipoSeguro
	 */
	private String claveTipoSeguro;
	
	/**
	 * claveTipoPension
	 */
	private String claveTipoPension;
	
	/**
	 * claveTipoPrestacion
	 */
	private String claveTipoPrestacion;
	
	/**
	 * clavePension
	 */
	private String clavePension;
	
	/**
	 * claveMovimiento
	 */
	private String claveMovimiento;
	
	
	/**
	 * claveTipoRegimen
	 */
	private String seleccionadoTipoRegimen;
	
	/**
	 * claveTipoRetiro
	 */
	private String seleccionadoRetiro;
	
	/**
	 * claveTipoSeguro
	 */
	private String seleccionadoSeguro;
	
	/**
	 * claveTipoPension
	 */
	private String seleccionadoPension;
	
	/**
	 * seleccionadoTipoPrestacion
	 */
	private String seleccionadoTipoPrestacion;
	
	/**
	 * seleccionadoClavePension
	 */
	private String seleccionadoClavePension;
	
	
	/**
	 * Tipo retiros
	 */
	private List<String> tipoRetiros;
	
	/**
	 * Tipo recurso
	 */
	private String tipoRecurso;
	
	/**
	 * Siefore
	 */
	private String claveSiefore;
	
	

	/**
	 * @return the claveSiefore
	 */
	public String getClaveSiefore() {
		return claveSiefore;
	}

	/**
	 * @param claveSiefore the claveSiefore to set
	 */
	public void setClaveSiefore(String claveSiefore) {
		this.claveSiefore = claveSiefore;
	}

	/**
	 * @return the tipoRecurso
	 */
	public String getTipoRecurso() {
		return tipoRecurso;
	}

	/**
	 * @param tipoRecurso the tipoRecurso to set
	 */
	public void setTipoRecurso(String tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}

	/**
	 * @return the claveTipoRegimen
	 */
	public String getClaveTipoRegimen() {
		return claveTipoRegimen;
	}

	/**
	 * @param claveTipoRegimen the claveTipoRegimen to set
	 */
	public void setClaveTipoRegimen(String claveTipoRegimen) {
		this.claveTipoRegimen = claveTipoRegimen;
	}

	/**
	 * @return the claveTipoRetiro
	 */
	public String getClaveTipoRetiro() {
		return claveTipoRetiro;
	}

	/**
	 * @param claveTipoRetiro the claveTipoRetiro to set
	 */
	public void setClaveTipoRetiro(String claveTipoRetiro) {
		this.claveTipoRetiro = claveTipoRetiro;
	}

	/**
	 * @return the claveTipoSeguro
	 */
	public String getClaveTipoSeguro() {
		return claveTipoSeguro;
	}

	/**
	 * @param claveTipoSeguro the claveTipoSeguro to set
	 */
	public void setClaveTipoSeguro(String claveTipoSeguro) {
		this.claveTipoSeguro = claveTipoSeguro;
	}

	/**
	 * @return the claveTipoPension
	 */
	public String getClaveTipoPension() {
		return claveTipoPension;
	}

	/**
	 * @param claveTipoPension the claveTipoPension to set
	 */
	public void setClaveTipoPension(String claveTipoPension) {
		this.claveTipoPension = claveTipoPension;
	}
	
	

	/**
	 * @return the primerCombo
	 */
	public String getPrimerCombo() {
		return primerCombo;
	}

	/**
	 * @param primerCombo the primerCombo to set
	 */
	public void setPrimerCombo(String primerCombo) {
		this.primerCombo = primerCombo;
	}
	
	

		/**
	 * @return the claveTipoPrestacion
	 */
	public String getClaveTipoPrestacion() {
		return claveTipoPrestacion;
	}

	/**
	 * @param claveTipoPrestacion the claveTipoPrestacion to set
	 */
	public void setClaveTipoPrestacion(String claveTipoPrestacion) {
		this.claveTipoPrestacion = claveTipoPrestacion;
	}
	
	
	

		/**
	 * @return the seleccionadoTipoRegimen
	 */
	public String getSeleccionadoTipoRegimen() {
		return seleccionadoTipoRegimen;
	}

	/**
	 * @param seleccionadoTipoRegimen the seleccionadoTipoRegimen to set
	 */
	public void setSeleccionadoTipoRegimen(String seleccionadoTipoRegimen) {
		this.seleccionadoTipoRegimen = seleccionadoTipoRegimen;
	}

	/**
	 * @return the seleccionadoRetiro
	 */
	public String getSeleccionadoRetiro() {
		return seleccionadoRetiro;
	}

	/**
	 * @param seleccionadoRetiro the seleccionadoRetiro to set
	 */
	public void setSeleccionadoRetiro(String seleccionadoRetiro) {
		this.seleccionadoRetiro = seleccionadoRetiro;
	}

	/**
	 * @return the seleccionadoSeguro
	 */
	public String getSeleccionadoSeguro() {
		return seleccionadoSeguro;
	}

	/**
	 * @param seleccionadoSeguro the seleccionadoSeguro to set
	 */
	public void setSeleccionadoSeguro(String seleccionadoSeguro) {
		this.seleccionadoSeguro = seleccionadoSeguro;
	}

	/**
	 * @return the seleccionadoPension
	 */
	public String getSeleccionadoPension() {
		return seleccionadoPension;
	}

	/**
	 * @param seleccionadoPension the seleccionadoPension to set
	 */
	public void setSeleccionadoPension(String seleccionadoPension) {
		this.seleccionadoPension = seleccionadoPension;
	}

	

		/**
	 * @return the clavePension
	 */
	public String getClavePension() {
		return clavePension;
	}

	/**
	 * @param clavePension the clavePension to set
	 */
	public void setClavePension(String clavePension) {
		this.clavePension = clavePension;
	}

	/**
	 * @return the claveMovimiento
	 */
	public String getClaveMovimiento() {
		return claveMovimiento;
	}

	/**
	 * @param claveMovimiento the claveMovimiento to set
	 */
	public void setClaveMovimiento(String claveMovimiento) {
		this.claveMovimiento = claveMovimiento;
	}

	/**
	 * @return the seleccionadoTipoPrestacion
	 */
	public String getSeleccionadoTipoPrestacion() {
		return seleccionadoTipoPrestacion;
	}

	/**
	 * @param seleccionadoTipoPrestacion the seleccionadoTipoPrestacion to set
	 */
	public void setSeleccionadoTipoPrestacion(String seleccionadoTipoPrestacion) {
		this.seleccionadoTipoPrestacion = seleccionadoTipoPrestacion;
	}

	/**
	 * @return the seleccionadoClavePension
	 */
	public String getSeleccionadoClavePension() {
		return seleccionadoClavePension;
	}

	/**
	 * @param seleccionadoClavePension the seleccionadoClavePension to set
	 */
	public void setSeleccionadoClavePension(String seleccionadoClavePension) {
		this.seleccionadoClavePension = seleccionadoClavePension;
	}
	
	
	

	

		/**
	 * @return the tipoRetiros
	 */
	public List<String> getTipoRetiros() {
		return tipoRetiros;
	}

	/**
	 * @param tipoRetiros the tipoRetiros to set
	 */
	public void setTipoRetiros(List<String> tipoRetiros) {
		this.tipoRetiros = tipoRetiros;
	}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("DisposicionIsssteEntrada [claveTipoRegimen=");
			builder.append(claveTipoRegimen);
			builder.append(", claveTipoRetiro=");
			builder.append(claveTipoRetiro);
			builder.append(", claveTipoSeguro=");
			builder.append(claveTipoSeguro);
			builder.append(", claveTipoPension=");
			builder.append(claveTipoPension);
			builder.append(", claveTipoPrestacion=");
			builder.append(claveTipoPrestacion);
			builder.append(", primerCombo=");
			builder.append(primerCombo);
			builder.append(", seleccionadoTipoRegimen=");
			builder.append(seleccionadoTipoRegimen);
			builder.append(", seleccionadoRetiro=");
			builder.append(seleccionadoRetiro);
			builder.append(", seleccionadoSeguro=");
			builder.append(seleccionadoSeguro);
			builder.append(", seleccionadoPension=");
			builder.append(seleccionadoPension);
			builder.append(", clavePension=");
			builder.append(clavePension);
			builder.append(", claveMovimiento=");
			builder.append(claveMovimiento);
			builder.append(", seleccionadoTipoPrestacion=");
			builder.append(seleccionadoTipoPrestacion);
			builder.append(", seleccionadoClavePension=");
			builder.append(seleccionadoClavePension);
			builder.append(", tipoRetiros=");
			builder.append(tipoRetiros);
			builder.append(", tipoRecurso=");
			builder.append(tipoRecurso);
			builder.append("]");
			return builder.toString();
		}
}
