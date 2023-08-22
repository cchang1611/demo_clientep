/**
 * ConsultaHistoricoSalida.java
 * Fecha de creación: 08/08/2019, 13:17:08
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

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Objeto de respuesta del servicio de reintegro de semanas
 * @author Carlos Baltazar Ricardo (cbaltaza@procesar.com)
 * @version 1.0
 * @since
 */
public class ConsultaHistoricoEntrada implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7699145939730862062L;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * nss
	 */
	private String claveAfore;

	/**
	 * Importe en Pesos a Reintegrar
	 */
	private BigDecimal importePesosReintegrar;

	/**
	 * Número de resolución
	 */
	private String numeroResolucion;

	/**
	 * tipo de Prestacion
	 */
	private String tipoPrestacion;

	/**
	 * Número para origen
	 */
	private int origen;

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo importePesosReintegrar
	 */
	public BigDecimal getImportePesosReintegrar() {
		return importePesosReintegrar;
	}

	/**
	 * @param importePesosReintegrar parametro importePesosReintegrar a actualizar
	 */
	public void setImportePesosReintegrar(BigDecimal importePesosReintegrar) {
		this.importePesosReintegrar = importePesosReintegrar;
	}

	/**
	 * @return el atributo numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion parametro numeroResolucion a actualizar
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}


	/**
	 * @return el atributo tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion parametro tipoPrestacion a actualizar
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return el atributo origen
	 */
	public int getOrigen() {
		return origen;
	}

	/**
	 * @param origen parametro origen a actualizar
	 */
	public void setOrigen(int origen) {
		this.origen = origen;
	}

	
	/**
	 * @return el atributo claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	
	/**
	 * @param claveAfore parametro claveAfore a actualizar
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsultaHistoricoEntrada [getNss()=");
		builder.append(getNss());
		builder.append(", getImportePesosReintegrar()=");
		builder.append(getImportePesosReintegrar());
		builder.append(", getNumeroResolucion()=");
		builder.append(getNumeroResolucion());
		builder.append(", getTipoPrestacion()=");
		builder.append(getTipoPrestacion());
		builder.append(", getOrigen()=");
		builder.append(getOrigen());
		builder.append(", getClaveAfore()=");
		builder.append(getClaveAfore());
		builder.append("]");
		return builder.toString();
	}
}
