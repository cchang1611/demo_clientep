/**
 * NsarDomicilio.java
 * Fecha de creación: Mar 27, 2019, 12:47:24 PM
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
import java.util.Date;

/**
 * mapeo de la tabla NSAR_TR_DOMICILIO
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 27, 2019
 */

public class NsarDomicilio implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 7166505195113215351L;

	/**
	 * id
	 */
	private NsarDomicilioPK id;

	/**
	 * calle
	 */
	private String calle;

	/**
	 * ciudad
	 */
	private String ciudad;

	/**
	 * codigo postal
	 */
	private String codigoPostal;

	/**
	 * colonia
	 */
	private String colonia;

	/**
	 * numero exterior
	 */
	private String numeroExterior;

	/**
	 * numero interior
	 */
	private String numeroInterior;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * fecha actualiza datos el trabajador
	 */
	private Date fechaActualizaTrabajador;

	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * municipio
	 */
	private NsarMunicipio nsarMunicipio;


	/**
	 * @return el atributo id
	 */
	public NsarDomicilioPK getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(NsarDomicilioPK id) {
		this.id = id;
	}

	/**
	 * @return el atributo calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle parametro calle a actualizar
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return el atributo ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad parametro ciudad a actualizar
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return el atributo codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal parametro codigoPostal a actualizar
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return el atributo colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia parametro colonia a actualizar
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return el atributo numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}

	/**
	 * @param numeroExterior parametro numeroExterior a actualizar
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	/**
	 * @return el atributo numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}

	/**
	 * @param numeroInterior parametro numeroInterior a actualizar
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo fechaActualizaTrabajador
	 */
	public Date getFechaActualizaTrabajador() {
		return fechaActualizaTrabajador;
	}

	/**
	 * @param fechaActualizaTrabajador parametro fechaActualizaTrabajador a actualizar
	 */
	public void setFechaActualizaTrabajador(Date fechaActualizaTrabajador) {
		this.fechaActualizaTrabajador = fechaActualizaTrabajador;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo nsarMunicipio
	 */
	public NsarMunicipio getNsarMunicipio() {
		return nsarMunicipio;
	}

	/**
	 * @param nsarMunicipio parametro nsarMunicipio a actualizar
	 */
	public void setNsarMunicipio(NsarMunicipio nsarMunicipio) {
		this.nsarMunicipio = nsarMunicipio;
	}



	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("NsarDomicilio [id=");
		cadena.append(id);
		cadena.append(", calle=");
		cadena.append(calle);
		cadena.append(", ciudad=");
		cadena.append(ciudad);
		cadena.append(", codigoPostal=");
		cadena.append(codigoPostal);
		cadena.append(", colonia=");
		cadena.append(colonia);
		cadena.append(", numeroExterior=");
		cadena.append(numeroExterior);
		cadena.append(", numeroInterior=");
		cadena.append(numeroInterior);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaActualizaTrabajador=");
		cadena.append(fechaActualizaTrabajador);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", nsarMunicipio=");
		cadena.append(nsarMunicipio);
		cadena.append("]");
		
		return cadena.toString();
	}

	
}
