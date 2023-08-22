package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DatosBeneficiarioTrabajadorSalida implements Serializable{

    /**
	 * Serializacion 
	 */
	private static final long serialVersionUID = 3155090667756541367L;
	
	private String apellidoPaternoDeBeneficiario;
	private String apellidoMaternoDeBeneficiario;
	private String nombreDeBeneficiario;
	private String curpDeBeneficiario;
	private String parentescoORelacion;
	private String porcentajeDeBeneficiario;
	private String resultadoDeLaOperacion;
	private String diagnosticoDeRecepcion;
    protected List<HashMap<String,String>> listaDiagnosticos;

    /**
     * 
     * @return the listaDiagnosticos
     */
    public List<HashMap<String, String>> getListaDiagnosticos() {
		return listaDiagnosticos;
	}

    /**
     * 
     * @param listaDiagnosticos the listaDiagnosticos to set
     */
	public void setListaDiagnosticos(List<HashMap<String, String>> listaDiagnosticos) {
		this.listaDiagnosticos = listaDiagnosticos;
	}
	
	public String getApellidoPaternoDeBeneficiario() {
		return apellidoPaternoDeBeneficiario;
	}
	public void setApellidoPaternoDeBeneficiario(String apellidoPaternoDeBeneficiario) {
		this.apellidoPaternoDeBeneficiario = apellidoPaternoDeBeneficiario;
	}
	public String getApellidoMaternoDeBeneficiario() {
		return apellidoMaternoDeBeneficiario;
	}
	public void setApellidoMaternoDeBeneficiario(String apellidoMaternoDeBeneficiario) {
		this.apellidoMaternoDeBeneficiario = apellidoMaternoDeBeneficiario;
	}
	public String getNombreDeBeneficiario() {
		return nombreDeBeneficiario;
	}
	public void setNombreDeBeneficiario(String nombreDeBeneficiario) {
		this.nombreDeBeneficiario = nombreDeBeneficiario;
	}
	public String getCurpDeBeneficiario() {
		return curpDeBeneficiario;
	}
	public void setCurpDeBeneficiario(String curpDeBeneficiario) {
		this.curpDeBeneficiario = curpDeBeneficiario;
	}
	public String getParentescoORelacion() {
		return parentescoORelacion;
	}
	public void setParentescoORelacion(String parentescoORelacion) {
		this.parentescoORelacion = parentescoORelacion;
	}
	public String getPorcentajeDeBeneficiario() {
		return porcentajeDeBeneficiario;
	}
	public void setPorcentajeDeBeneficiario(String porcentajeDeBeneficiario) {
		this.porcentajeDeBeneficiario = porcentajeDeBeneficiario;
	}
	public String getResultadoDeLaOperacion() {
		return resultadoDeLaOperacion;
	}
	public void setResultadoDeLaOperacion(String resultadoDeLaOperacion) {
		this.resultadoDeLaOperacion = resultadoDeLaOperacion;
	}
	public String getDiagnosticoDeRecepcion() {
		return diagnosticoDeRecepcion;
	}
	public void setDiagnosticoDeRecepcion(String diagnosticoDeRecepcion) {
		this.diagnosticoDeRecepcion = diagnosticoDeRecepcion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosBeneficiarioTrabajadorSalida [apellidoPaternoDeBeneficiario=");
		builder.append(apellidoPaternoDeBeneficiario);
		builder.append(", apellidoMaternoDeBeneficiario=");
		builder.append(apellidoMaternoDeBeneficiario);
		builder.append(", nombreDeBeneficiario=");
		builder.append(nombreDeBeneficiario);
		builder.append(", curpDeBeneficiario=");
		builder.append(curpDeBeneficiario);
		builder.append(", parentescoORelacion=");
		builder.append(parentescoORelacion);
		builder.append(", porcentajeDeBeneficiario=");
		builder.append(porcentajeDeBeneficiario);
		builder.append(", resultadoDeLaOperacion=");
		builder.append(resultadoDeLaOperacion);
		builder.append(", diagnosticoDeRecepcion=");
		builder.append(diagnosticoDeRecepcion);
		builder.append(", listaDiagnosticos=");
		builder.append(listaDiagnosticos);
		builder.append("]");
		return builder.toString();
	}
	
	

}
