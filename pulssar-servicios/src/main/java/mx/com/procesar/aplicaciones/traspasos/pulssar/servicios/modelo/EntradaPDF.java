package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase encargada del objeto de entrada para la generación del pdf de biometricos
 * @author DBARBOSA
 *
 */
public class EntradaPDF implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -2486272995161911295L;
	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 * nombre trabajador
	 */
	private String nombreTrabajador;
	
	/**
	 * clave Afore
	 */
	private String cvAfore;
	
	/**
	 * imagen firma
	 */
	private String imagenFirma;
	
	/**
	 * imagen firma empleado
	 */
	private String imagenFirmaEmpleado;
	
	/**
	 * contiene excepcion
	 */
	private boolean isExcepcion;
	
	/**
	 * enviar consentimiento
	 */
	private boolean isConsentimiento;
	
	/**
	 * id folio
	 */
	private Long idFolio;
	
	/**
	 * Motivos de excepcion
	 */
	private String motivos;
	
	/**
	 * Nombre Agente
	 */
	private String nombreAgente;
	
	/**
	 * Clave agente
	 */
	private String claveAgente;
	
	/**
	 * Folio biometrico
	 */
	private String folio;

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
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return the cvAfore
	 */
	public String getCvAfore() {
		return cvAfore;
	}

	/**
	 * @param cvAfore the cvAfore to set
	 */
	public void setCvAfore(String cvAfore) {
		this.cvAfore = cvAfore;
	}

	/**
	 * @return the imagenFirma
	 */
	public String getImagenFirma() {
		return imagenFirma;
	}

	/**
	 * @param imagenFirma the imagenFirma to set
	 */
	public void setImagenFirma(String imagenFirma) {
		this.imagenFirma = imagenFirma;
	}

	/**
	 * @return the imagenFirmaEmpleado
	 */
	public String getImagenFirmaEmpleado() {
		return imagenFirmaEmpleado;
	}

	/**
	 * @param imagenFirmaEmpleado the imagenFirmaEmpleado to set
	 */
	public void setImagenFirmaEmpleado(String imagenFirmaEmpleado) {
		this.imagenFirmaEmpleado = imagenFirmaEmpleado;
	}

	/**
	 * @return the isExcepcion
	 */
	public boolean isExcepcion() {
		return isExcepcion;
	}

	/**
	 * @param isExcepcion the isExcepcion to set
	 */
	public void setExcepcion(boolean isExcepcion) {
		this.isExcepcion = isExcepcion;
	}

	/**
	 * @return the isConsentimiento
	 */
	public boolean isConsentimiento() {
		return isConsentimiento;
	}

	/**
	 * @param isConsentimiento the isConsentimiento to set
	 */
	public void setConsentimiento(boolean isConsentimiento) {
		this.isConsentimiento = isConsentimiento;
	}

	/**
	 * @return the idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}

	/**
	 * @param idFolio the idFolio to set
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
	}

	/**
	 * @return the motivos
	 */
	public String getMotivos() {
		return motivos;
	}

	/**
	 * @param motivos the motivos to set
	 */
	public void setMotivos(String motivos) {
		this.motivos = motivos;
	}

	/**
	 * @return the nombreAgente
	 */
	public String getNombreAgente() {
		return nombreAgente;
	}

	/**
	 * @param nombreAgente the nombreAgente to set
	 */
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	/**
	 * @return the claveAgente
	 */
	public String getClaveAgente() {
		return claveAgente;
	}

	/**
	 * @param claveAgente the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
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
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("EntradaPDF [");
		cadena.append("curp =");
		cadena.append(curp);
		cadena.append(" nombreTrabajador =");
		cadena.append(nombreTrabajador);
		cadena.append(" cvAfore =");
		cadena.append(cvAfore);
		cadena.append(" imagenFirma =");
		cadena.append(imagenFirma);
		cadena.append(" imagenFirmaEmpleado =");
		cadena.append(imagenFirmaEmpleado);
		cadena.append(" isExcepcion =");
		cadena.append(isExcepcion);
		cadena.append(" isConsentimiento =");
		cadena.append(isConsentimiento);
		cadena.append(" idFolio =");
		cadena.append(idFolio);
		cadena.append(" motivos =");
		cadena.append(motivos);
		cadena.append(" nombreAgente =");
		cadena.append(nombreAgente);
		cadena.append(" claveAgente =");
		cadena.append(claveAgente);
		cadena.append(" folio =");
		cadena.append(folio);
		cadena.append("]");
		
		return cadena.toString();
	}
}