/**
 * DatosBeneficiarioIssste.java
 * Fecha de creación: Nov 4, 2019, 7:36:44 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

/**
 * datos del beneficiario issste
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Nov 4, 2019
 */
public class DatosBeneficiarioIssste {
	/**
	 * nombre del beneficiario
	 */
	private String nombre;
	
	/**
	 * banco
	 */
	private String banco;
	
	/**
	 * cuenta
	 */
	private String cuenta;
	
	/**
	 * firma
	 */
	private String firma;

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
	 * @return el atributo cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta parametro cuenta a actualizar
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return el atributo firma
	 */
	public String getFirma() {
		return firma;
	}

	/**
	 * @param firma parametro firma a actualizar
	 */
	public void setFirma(String firma) {
		this.firma = firma;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosBeneficiarioIssste [nombre=");
		builder.append(nombre);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", cuenta=");
		builder.append(cuenta);
		builder.append(", firma=");
		builder.append(firma);
		builder.append("]");
		return builder.toString();
	}
}
