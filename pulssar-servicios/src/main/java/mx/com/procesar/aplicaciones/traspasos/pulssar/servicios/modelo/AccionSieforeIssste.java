package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
public class AccionSieforeIssste implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Clave siefore
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String claveSiefore;
	
	/**
	 * Acciones retiro 2008
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesRetiro2008;
	
	/**
	 * accionesCesantiaVejez
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesCesantiaVejez;
	
	/**
	 * accionesAhorroSolidario
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesAhorroSolidario;
	
	/**
	 * accionesSar92
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesSar92;
	
	/**
	 * accionesComplementariaRetiro
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesComplementariaRetiro;

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
	 * @return the accionesRetiro2008
	 */
	public Double getAccionesRetiro2008() {
		return accionesRetiro2008;
	}

	/**
	 * @param accionesRetiro2008 the accionesRetiro2008 to set
	 */
	public void setAccionesRetiro2008(Double accionesRetiro2008) {
		this.accionesRetiro2008 = accionesRetiro2008;
	}

	/**
	 * @return the accionesCesantiaVejez
	 */
	public Double getAccionesCesantiaVejez() {
		return accionesCesantiaVejez;
	}

	/**
	 * @param accionesCesantiaVejez the accionesCesantiaVejez to set
	 */
	public void setAccionesCesantiaVejez(Double accionesCesantiaVejez) {
		this.accionesCesantiaVejez = accionesCesantiaVejez;
	}

	/**
	 * @return the accionesAhorroSolidario
	 */
	public Double getAccionesAhorroSolidario() {
		return accionesAhorroSolidario;
	}

	/**
	 * @param accionesAhorroSolidario the accionesAhorroSolidario to set
	 */
	public void setAccionesAhorroSolidario(Double accionesAhorroSolidario) {
		this.accionesAhorroSolidario = accionesAhorroSolidario;
	}

	/**
	 * @return the accionesSar92
	 */
	public Double getAccionesSar92() {
		return accionesSar92;
	}

	/**
	 * @param accionesSar92 the accionesSar92 to set
	 */
	public void setAccionesSar92(Double accionesSar92) {
		this.accionesSar92 = accionesSar92;
	}

	/**
	 * @return the accionesComplementariaRetiro
	 */
	public Double getAccionesComplementariaRetiro() {
		return accionesComplementariaRetiro;
	}

	/**
	 * @param accionesComplementariaRetiro the accionesComplementariaRetiro to set
	 */
	public void setAccionesComplementariaRetiro(Double accionesComplementariaRetiro) {
		this.accionesComplementariaRetiro = accionesComplementariaRetiro;
	}
	
	
	
	
	

}
