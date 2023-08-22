package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Datos generales de disposicion issste
 * @author RARREOLA
 *
 */
public class DatosBenefDispIssste implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129922942388139349L;

	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * apellido paterno
	 */
	private String apellidoPaterno;
	
	/**
	 * apellido materno
	 */
	private String apellidoMaterno;
	
	/**
	 * rfc
	 */
	private String rfc;
	
	/**
	 * porcentaje
	 */
	private String porcentaje;
	
	/**
	 * banco
	 */
	private String banco;
	
	/**
	 * cuenta clabe
	 */
	private String cuentaClabe;
	
	




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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}






	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}






	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}






	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}






	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}






	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}






	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}






	/**
	 * @return the porcentaje
	 */
	public String getPorcentaje() {
		return porcentaje;
	}






	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}






	/**
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}






	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}






	/**
	 * @return the cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}






	/**
	 * @param cuentaClabe the cuentaClabe to set
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}






	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
