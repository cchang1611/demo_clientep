/**
 * DatosNombreArchivoPdf.java
 * Fecha de creación: Sep 10, 2019, 1:10:24 PM
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

import java.util.Date;

/**
 * clase que contiene los datos del nombre del archivo PDF
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Sep 10, 2019
 */
public class DatosNombreArchivoPdf {
	/**
	 * clave afore
	 */
	String claveAfore;
	
	/**
	 * clave del proceso
	 */
	String claveProceso;
	
	/**
	 * curp
	 */
	String curp;
	
	/**
	 * tipo de trabajador
	 */
	String tipoTrabajador;
	
	/**
	 * clave del tipo de archivo
	 */
	String claveTipoArchivo;
	
	/**
	 * consecutivo del archivo
	 */
	String consecutivo;
	
	/**
	 * fecha de la operacion del proceso
	 */
	Date fechaOperacion;
	
	/**
	 * folio del archivo del trabajador
	 */
	String folioArchivo;
	
	/**
	 * extension del archivo
	 */
	String extension;

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

	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

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
	 * @return el atributo tipoTrabajador
	 */
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	/**
	 * @param tipoTrabajador parametro tipoTrabajador a actualizar
	 */
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	/**
	 * @return el atributo claveTipoArchivo
	 */
	public String getClaveTipoArchivo() {
		return claveTipoArchivo;
	}

	/**
	 * @param claveTipoArchivo parametro claveTipoArchivo a actualizar
	 */
	public void setClaveTipoArchivo(String claveTipoArchivo) {
		this.claveTipoArchivo = claveTipoArchivo;
	}

	/**
	 * @return el atributo consecutivo
	 */
	public String getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo parametro consecutivo a actualizar
	 */
	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	/**
	 * @return el atributo folioArchivo
	 */
	public String getFolioArchivo() {
		return folioArchivo;
	}

	/**
	 * @param folioArchivo parametro folioArchivo a actualizar
	 */
	public void setFolioArchivo(String folioArchivo) {
		this.folioArchivo = folioArchivo;
	}

	/**
	 * @return el atributo extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension parametro extension a actualizar
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return el atributo fechaOperacion
	 */
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion parametro fechaOperacion a actualizar
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder("DatosNombreArchivoPdf [claveAfore=");
		cadena.append(claveAfore).append(", claveProceso=").append(claveProceso);
		cadena.append(", curp=").append(curp).append(", tipoTrabajador=").append(tipoTrabajador);
		cadena.append(", claveTipoArchivo=").append(claveTipoArchivo).append(", consecutivo=");
		cadena.append(consecutivo).append(", folioArchivo=").append(", fechaOperacion=");
		cadena.append(fechaOperacion).append(", folioArchivo=").append(folioArchivo);
		cadena.append(", extension=").append(extension).append("]");
		
		return cadena.toString();
	}
	
	
}
