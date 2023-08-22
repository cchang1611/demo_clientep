package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author medoming
 *
 */
public class DatosSalidaPermanencia implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 58799734776003211L;
	
	/**
	 * entidadOrigen
	 */
	private String entidadOrigen;
	
	/**
	 * curpTrabajador
	 */
	private String curpTrabajador;
	
	/**
	 * nssTrabajador
	 */
	private String nssTrabajador;
	
	/**
	 * resultadoDeLaOperacion
	 */
	private String resultadoDeLaOperacion;
	
	/**
	 * diagnosticoDeRecepcion
	 */
	private String diagnosticoDeRecepcion;
	
	/**
	 * claveActualizacion
	 */
	private String claveActualizacion;

	
	private List<HashMap<String,String>> listaDiagnosticos; 
	
	/**
	 * @return entidadOrigen
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
	 * @return curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	/**
	 * @return nssTrabajador
	 */
	public String getNssTrabajador() {
		return nssTrabajador;
	}

	/**
	 * @param nssTrabajador the nssTrabajador to set
	 */
	public void setNssTrabajador(String nssTrabajador) {
		this.nssTrabajador = nssTrabajador;
	}

	/**
	 * @return resultadoDeLaOperacion
	 */
	public String getResultadoDeLaOperacion() {
		return resultadoDeLaOperacion;
	}

	/**
	 * @param resultadoDeLaOperacion the resultadoDeLaOperacion to set
	 */
	public void setResultadoDeLaOperacion(String resultadoDeLaOperacion) {
		this.resultadoDeLaOperacion = resultadoDeLaOperacion;
	}

	/**
	 * @return diagnosticoDeRecepcion
	 */
	public String getDiagnosticoDeRecepcion() {
		return diagnosticoDeRecepcion;
	}

	/**
	 * @param diagnosticoDeRecepcion the diagnosticoDeRecepcion to set
	 */
	public void setDiagnosticoDeRecepcion(String diagnosticoDeRecepcion) {
		this.diagnosticoDeRecepcion = diagnosticoDeRecepcion;
	}

	/**
	 * @return claveActualizacion
	 */
	public String getClaveActualizacion() {
		return claveActualizacion;
	}

	/**
	 * @param claveActualizacion the claveActualizacion to set
	 */
	public void setClaveActualizacion(String claveActualizacion) {
		this.claveActualizacion = claveActualizacion;
	}

	public List<HashMap<String, String>> getListaDiagnosticos() {
		return listaDiagnosticos;
	}

	public void setListaDiagnosticos(List<HashMap<String, String>> listaDiagnosticos) {
		this.listaDiagnosticos = listaDiagnosticos;
	}

	
	
}
