/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Nace como simple objeto de tralado de información
 * Viaja del controlador al Servicio De generación de NIP
 * Viaja del controlador a la vista
 * @author malopezt
 * 
 */
public class GeneraNIP implements Serializable {

	/** Serial ID*/
	private static final long serialVersionUID = -7782018752816202855L;

	/** Apellido paterno*/
	private String apPaterno;
	
	/** Apellido materno*/
	private String apMaterno;
	
	/** Nombres*/
	private String nombre;
	
	/** curp */
	private String curp;
	
	/** nss */
	private String nss;
	
	/** Correo electrónico*/
	private String correo;
	
	/** Teléfono celular */
	private String numeroCelular;
	
	/** Clave afore */
	private String cveAfore;
	
	/** Sobrecarga toString */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ 'apPaterno' : '").append(apPaterno).append("',");
		sb.append("'apMaterno' : '").append(apMaterno).append("',");
		sb.append("'nombre' : '").append(nombre).append("',");
		sb.append("'curp' : '").append(curp).append("',");
		sb.append("'nss' : '").append(nss).append("' ,");
		sb.append("'nss' : '").append(nss).append("' ,");
		sb.append("'cveAfore' : '").append(cveAfore).append("',");
		sb.append("'numeroCelular' : '").append(numeroCelular).append("' }");
		return sb.toString();
	}
	
	/**
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * @return the nombres
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the numeroCelular
	 */
	public String getNumeroCelular() {
		return numeroCelular;
	}

	/**
	 * @param numeroCelular the numeroCelular to set
	 */
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	/**
	 * @return the cveAfore
	 */
	public String getCveAfore() {
		return cveAfore;
	}

	/**
	 * @param cveAfore the cveAfore to set
	 */
	public void setCveAfore(String cveAfore) {
		this.cveAfore = cveAfore;
	}
}
