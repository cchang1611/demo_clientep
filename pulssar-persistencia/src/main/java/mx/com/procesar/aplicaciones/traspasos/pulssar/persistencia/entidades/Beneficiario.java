package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
/**
 * Datos Entrada Beneficiario 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Jun 11, 2021
 */
public class Beneficiario implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 2167488341873845790L;

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
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el atributo apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno parametro apellidoPaterno a actualizar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return el atributo apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return el atributo rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc parametro rfc a actualizar
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return el atributo porcentaje
	 */
	public String getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje parametro porcentaje a actualizar
	 */
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return el atributo banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * @param banco parametro banco a actualizar
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * @return el atributo cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * @param cuentaClabe parametro cuentaClabe a actualizar
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Beneficiario [curp=");
		builder.append(curp);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", porcentaje=");
		builder.append(porcentaje);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append("]");
		return builder.toString();
	}
	
	
}
