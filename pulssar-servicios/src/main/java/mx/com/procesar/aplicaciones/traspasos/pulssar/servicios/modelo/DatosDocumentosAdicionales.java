package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class DatosDocumentosAdicionales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String curp;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nss;
	
	
	public String getCurp() {
		return curp;
	}




	public void setCurp(String curp) {
		this.curp = curp;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidoPaterno() {
		return apellidoPaterno;
	}




	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}




	public String getApellidoMaterno() {
		return apellidoMaterno;
	}




	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}




	public String getNss() {
		return nss;
	}




	public void setNss(String nss) {
		this.nss = nss;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosDocumentosAdicionales [curp=");
		builder.append(curp);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nss=");
		builder.append(nss);
		builder.append("]");
		return builder.toString();
	}


}
