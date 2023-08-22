/**
 * BancoAfore.java
 * Fecha de creación: Mar 24, 2020 9:34:28 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
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
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class BancoAfore implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 5287139468545801316L;

	/**
	 * Cuenta CLABE
	 */
	private String clabe;

	/**
	 * Clave Afore
	 */
	private String claveAfore;

	/**
	 * Cuenta bancaria
	 */
	private String cuentaBancaria;

	/**
	 * Nombre del banco
	 */
	private String nombreBanco;

	/**
	 * Tipo de cuenta
	 */
	private String tipoCuenta;

	/**
	 * Obtener clabe
	 */
	public String getClabe() {
		return clabe;
	}

	/**
	 * Setear clabe
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	/**
	 * Obtener claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * Setear claveAfore
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * Obtener cuentaBancaria
	 */
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	/**
	 * Setear cuentaBancaria
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	/**
	 * Obtener nombreBanco
	 */
	public String getNombreBanco() {
		return nombreBanco;
	}

	/**
	 * Setear nombreBanco
	 */
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	/**
	 * Obtener tipoCuenta
	 */
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	/**
	 * Setear tipoCuenta
	 */
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BancoAfore [clabe=");
		builder.append(clabe);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", cuentaBancaria=");
		builder.append(cuentaBancaria);
		builder.append(", nombreBanco=");
		builder.append(nombreBanco);
		builder.append(", tipoCuenta=");
		builder.append(tipoCuenta);
		builder.append("]");
		return builder.toString();
	}
}
