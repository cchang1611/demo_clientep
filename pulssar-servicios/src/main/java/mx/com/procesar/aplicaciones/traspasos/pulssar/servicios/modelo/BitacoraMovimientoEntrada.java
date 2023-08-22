package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase de entrada para bitacora de modificacion de datos
 * @author JMGUTIEG
 *
 */
public class BitacoraMovimientoEntrada implements Serializable{	

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -4668008836785197040L;

	
	/**
	 * proceso
	 */
	private String cvProceso;

	/**
	 * Descripcion
	 */
	private String descripcion;

	/**
	 * Diagnostico
	 */
	private String diagnostico;

	/**
	 * Flujo
	 */
	private String flujo;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * curp
	 */
	private String curp;

	/**
	 * folio hijo
	 */
	private String folioPulsarHijo;

	/**
	 * folio padre
	 */
	private String folioPulsarPadre;

	/**
	 * resultado
	 */
	private String resultado;

	/**
	 * @return the cvProceso
	 */
	public String getCvProceso() {
		return cvProceso;
	}

	/**
	 * @param cvProceso the cvProceso to set
	 */
	public void setCvProceso(String cvProceso) {
		this.cvProceso = cvProceso;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the flujo
	 */
	public String getFlujo() {
		return flujo;
	}

	/**
	 * @param flujo the flujo to set
	 */
	public void setFlujo(String flujo) {
		this.flujo = flujo;
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
	 * @return the folioPulsarHijo
	 */
	public String getFolioPulsarHijo() {
		return folioPulsarHijo;
	}

	/**
	 * @param folioPulsarHijo the folioPulsarHijo to set
	 */
	public void setFolioPulsarHijo(String folioPulsarHijo) {
		this.folioPulsarHijo = folioPulsarHijo;
	}

	/**
	 * @return the folioPulsarPadre
	 */
	public String getFolioPulsarPadre() {
		return folioPulsarPadre;
	}

	/**
	 * @param folioPulsarPadre the folioPulsarPadre to set
	 */
	public void setFolioPulsarPadre(String folioPulsarPadre) {
		this.folioPulsarPadre = folioPulsarPadre;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitacoraMovimientoEntrada [cvProceso=");
		builder.append(cvProceso);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", flujo=");
		builder.append(flujo);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", folioPulsarHijo=");
		builder.append(folioPulsarHijo);
		builder.append(", folioPulsarPadre=");
		builder.append(folioPulsarPadre);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append("]");
		return builder.toString();
	}
	
	

}
