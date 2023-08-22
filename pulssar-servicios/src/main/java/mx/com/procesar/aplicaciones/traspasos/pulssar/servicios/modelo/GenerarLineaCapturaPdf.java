/**
 * GenerarLineaCapturaPdf.java
 * Fecha de creación: Mar 23, 2020 11:24:15 AM
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
 * Clase solicitud de PDF para generar Linea de Captura
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class GenerarLineaCapturaPdf implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6260488641997693887L;

	/**
	 * NSS
	 */
	private String nss;

	/**
	 * CURP
	 */
	private String curp;

	/**
	 * Apellido Paterno
	 */
	private String apellidoPaterno;

	/**
	 * Apellido Materno
	 */
	private String apellidoMaterno;

	/**
	 * Nombre
	 */
	private String nombre;

	/**
	 * Nombre del Banco
	 * 
	 */
	private String nombreBanco;

	/**
	 * Numero de Cuenta Bancaria
	 */
	private String numeroCuentaBancaria;

	/**
	 * Cuenta CLABE
	 */
	private String cuentaClabe;

	/**
	 * Numero de semnas
	 */
	private String numeroSemanas;

	/**
	 * Numero de Resolucion
	 */
	private String numeroResolucion;

	/**
	 * Monto en Pesos
	 */
	private Double montoPesos;
	
	/**
	 * Clave Afore
	 */
	private String claveAfore;

	/**
	 * Obtener nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * Setear nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * Obtener curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * Setear curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * Obtener apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Setear apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Obtener apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Setear apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtener nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setear nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * Obtener numeroCuentaBancaria
	 */
	public String getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}

	/**
	 * Setear numeroCuentaBancaria
	 */
	public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}

	/**
	 * Obtener cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * Setear cuentaClabe
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

	/**
	 * Obtener numeroSemanas
	 */
	public String getNumeroSemanas() {
		return numeroSemanas;
	}

	/**
	 * Setear numeroSemanas
	 */
	public void setNumeroSemanas(String numeroSemanas) {
		this.numeroSemanas = numeroSemanas;
	}

	/**
	 * Obtener numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * Setear numeroResolucion
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * Obtener montoPesos
	 */
	public Double getMontoPesos() {
		return montoPesos;
	}

	/**
	 * Setear montoPesos
	 */
	public void setMontoPesos(Double montoPesos) {
		this.montoPesos = montoPesos;
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
	
	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GenerarLineaCapturaPdf [nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", nombreBanco=");
		builder.append(nombreBanco);
		builder.append(", numeroCuentaBancaria=");
		builder.append(numeroCuentaBancaria);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", numeroSemanas=");
		builder.append(numeroSemanas);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", montoPesos=");
		builder.append(montoPesos);
		builder.append("]");
		return builder.toString();
	}
}
