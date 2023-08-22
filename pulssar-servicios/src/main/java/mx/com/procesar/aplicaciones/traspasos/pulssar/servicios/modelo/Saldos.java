/**
 * SalidaSaldos.java
 * Fecha de creación: 19/02/2020, 12:26:04
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de Salida, Datos response del servicio de 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 19/02/2020
 */
public class Saldos implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -401864966829102080L;
	
	/**
	 * saldo CuotaSocialI
	 *
	**/
	private  String saldoCuotaSocialI;

	/**
	 * saldo RetiroI08
	 *
	**/
	private  String saldoRetiroI08;

	/**
	 * saldo CVI
	 */
	private  String saldoCVI;

	/**
	 *
	 * saldo Retiro92I
	 *
	**/
	private  String saldoRetiro92I;
	/**
	 * tipo Regimen
	 */
	private String tipoRegimen;
	
	/**
	 * monto Constitutivo
	 */
	private Double montoConstitutivo;

	/**
	 * @return el atributo saldoCuotaSocialI
	 */
	public String getSaldoCuotaSocialI() {
		return saldoCuotaSocialI;
	}

	/**
	 * @param saldoCuotaSocialI parametro saldoCuotaSocialI a actualizar
	 */
	public void setSaldoCuotaSocialI(String saldoCuotaSocialI) {
		this.saldoCuotaSocialI = saldoCuotaSocialI;
	}

	/**
	 * @return el atributo saldoRetiroI08
	 */
	public String getSaldoRetiroI08() {
		return saldoRetiroI08;
	}

	/**
	 * @param saldoRetiroI08 parametro saldoRetiroI08 a actualizar
	 */
	public void setSaldoRetiroI08(String saldoRetiroI08) {
		this.saldoRetiroI08 = saldoRetiroI08;
	}

	/**
	 * @return el atributo saldoCVI
	 */
	public String getSaldoCVI() {
		return saldoCVI;
	}

	/**
	 * @param saldoCVI parametro saldoCVI a actualizar
	 */
	public void setSaldoCVI(String saldoCVI) {
		this.saldoCVI = saldoCVI;
	}

	/**
	 * @return el atributo saldoRetiro92I
	 */
	public String getSaldoRetiro92I() {
		return saldoRetiro92I;
	}

	/**
	 * @param saldoRetiro92I parametro saldoRetiro92I a actualizar
	 */
	public void setSaldoRetiro92I(String saldoRetiro92I) {
		this.saldoRetiro92I = saldoRetiro92I;
	}

	/**
	 * @return el atributo tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}

	/**
	 * @param tipoRegimen parametro tipoRegimen a actualizar
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	/**
	 * @return el atributo montoConstitutivo
	 */
	public Double getMontoConstitutivo() {
		return montoConstitutivo;
	}

	/**
	 * @param montoConstitutivo parametro montoConstitutivo a actualizar
	 */
	public void setMontoConstitutivo(Double montoConstitutivo) {
		this.montoConstitutivo = montoConstitutivo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Saldos [saldoCuotaSocialI=");
		builder.append(saldoCuotaSocialI);
		builder.append(", saldoRetiroI08=");
		builder.append(saldoRetiroI08);
		builder.append(", saldoCVI=");
		builder.append(saldoCVI);
		builder.append(", saldoRetiro92I=");
		builder.append(saldoRetiro92I);
		builder.append(", tipoRegimen=");
		builder.append(tipoRegimen);
		builder.append(", montoConstitutivo=");
		builder.append(montoConstitutivo);
		builder.append("]");
		return builder.toString();
	}
	
}
