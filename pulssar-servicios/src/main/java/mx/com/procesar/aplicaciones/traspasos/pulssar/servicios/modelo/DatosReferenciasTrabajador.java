package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DatosReferenciasTrabajador implements Serializable{

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(Include.ALWAYS)
	private String apellidoPaternoDeReferencia1;
	
	@JsonInclude(Include.ALWAYS)
    private String apellidoMaternoDeReferencia1;
	
	@JsonInclude(Include.ALWAYS)
	private String nombreDeReferencia1;
	
	@JsonInclude(Include.ALWAYS)
    private String curpDeReferencia1;
	
	@JsonInclude(Include.ALWAYS)
    private String telefonoDeReferencia1;
	
	@JsonInclude(Include.ALWAYS)
	private String parentescoORelacionDeReferencia1;
	
	@JsonInclude(Include.ALWAYS)
	private String apellidoPaternoDeReferencia2;
	
	@JsonInclude(Include.ALWAYS)
    private String apellidoMaternoDeReferencia2;
	
	@JsonInclude(Include.ALWAYS)
	private String nombreDeReferencia2;
	
	@JsonInclude(Include.ALWAYS)
    private String curpDeReferencia2;
    
	@JsonInclude(Include.ALWAYS)
	private String telefonoDeReferencia2;
	
	@JsonInclude(Include.ALWAYS)
    private String parentescoORelacionDeReferencia2;
	
    public String getApellidoPaternoDeReferencia1() {
		return apellidoPaternoDeReferencia1;
	}
	public void setApellidoPaternoDeReferencia1(String apellidoPaternoDeReferencia1) {
		this.apellidoPaternoDeReferencia1 = apellidoPaternoDeReferencia1;
	}
	public String getApellidoMaternoDeReferencia1() {
		return apellidoMaternoDeReferencia1;
	}
	public void setApellidoMaternoDeReferencia1(String apellidoMaternoDeReferencia1) {
		this.apellidoMaternoDeReferencia1 = apellidoMaternoDeReferencia1;
	}
	public String getNombreDeReferencia1() {
		return nombreDeReferencia1;
	}
	public void setNombreDeReferencia1(String nombreDeReferencia1) {
		this.nombreDeReferencia1 = nombreDeReferencia1;
	}
	public String getCurpDeReferencia1() {
		return curpDeReferencia1;
	}
	public void setCurpDeReferencia1(String curpDeReferencia1) {
		this.curpDeReferencia1 = curpDeReferencia1;
	}
	public String getTelefonoDeReferencia1() {
		return telefonoDeReferencia1;
	}
	public void setTelefonoDeReferencia1(String telefonoDeReferencia1) {
		this.telefonoDeReferencia1 = telefonoDeReferencia1;
	}
	public String getParentescoORelacionDeReferencia1() {
		return parentescoORelacionDeReferencia1;
	}
	public void setParentescoORelacionDeReferencia1(String parentescoORelacionDeReferencia1) {
		this.parentescoORelacionDeReferencia1 = parentescoORelacionDeReferencia1;
	}
	public String getApellidoPaternoDeReferencia2() {
		return apellidoPaternoDeReferencia2;
	}
	public void setApellidoPaternoDeReferencia2(String apellidoPaternoDeReferencia2) {
		this.apellidoPaternoDeReferencia2 = apellidoPaternoDeReferencia2;
	}
	public String getApellidoMaternoDeReferencia2() {
		return apellidoMaternoDeReferencia2;
	}
	public void setApellidoMaternoDeReferencia2(String apellidoMaternoDeReferencia2) {
		this.apellidoMaternoDeReferencia2 = apellidoMaternoDeReferencia2;
	}
	public String getNombreDeReferencia2() {
		return nombreDeReferencia2;
	}
	public void setNombreDeReferencia2(String nombreDeReferencia2) {
		this.nombreDeReferencia2 = nombreDeReferencia2;
	}
	public String getCurpDeReferencia2() {
		return curpDeReferencia2;
	}
	public void setCurpDeReferencia2(String curpDeReferencia2) {
		this.curpDeReferencia2 = curpDeReferencia2;
	}
	public String getTelefonoDeReferencia2() {
		return telefonoDeReferencia2;
	}
	public void setTelefonoDeReferencia2(String telefonoDeReferencia2) {
		this.telefonoDeReferencia2 = telefonoDeReferencia2;
	}
	public String getParentescoORelacionDeReferencia2() {
		return parentescoORelacionDeReferencia2;
	}
	public void setParentescoORelacionDeReferencia2(String parentescoORelacionDeReferencia2) {
		this.parentescoORelacionDeReferencia2 = parentescoORelacionDeReferencia2;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosReferenciasTrabajador [apellidoPaternoDeReferencia1=");
		builder.append(apellidoPaternoDeReferencia1);
		builder.append(", apellidoMaternoDeReferencia1=");
		builder.append(apellidoMaternoDeReferencia1);
		builder.append(", nombreDeReferencia1=");
		builder.append(nombreDeReferencia1);
		builder.append(", curpDeReferencia1=");
		builder.append(curpDeReferencia1);
		builder.append(", telefonoDeReferencia1=");
		builder.append(telefonoDeReferencia1);
		builder.append(", parentescoORelacionDeReferencia1=");
		builder.append(parentescoORelacionDeReferencia1);
		builder.append(", apellidoPaternoDeReferencia2=");
		builder.append(apellidoPaternoDeReferencia2);
		builder.append(", apellidoMaternoDeReferencia2=");
		builder.append(apellidoMaternoDeReferencia2);
		builder.append(", nombreDeReferencia2=");
		builder.append(nombreDeReferencia2);
		builder.append(", curpDeReferencia2=");
		builder.append(curpDeReferencia2);
		builder.append(", telefonoDeReferencia2=");
		builder.append(telefonoDeReferencia2);
		builder.append(", parentescoORelacionDeReferencia2=");
		builder.append(parentescoORelacionDeReferencia2);
		builder.append("]");
		return builder.toString();
	}
	
	
}
