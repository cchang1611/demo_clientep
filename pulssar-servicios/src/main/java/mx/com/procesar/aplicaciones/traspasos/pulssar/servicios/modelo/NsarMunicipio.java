/**
 * NsarMunicipio.java
 * Fecha de creación: Mar 27, 2019, 12:02:47 PM
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
 * mapeo de la tabla NSAR_TC_MUNICIPIO
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 27, 2019
 */
public class NsarMunicipio implements Serializable {

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 6491737297600352997L;

	/**
	 * id
	 */
	private long id;

	/**
	 * descripcion
	 */
	private String descripcion;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * clave del municipio
	 */
	private String claveMunicipio;

	/**
	 * fecha control
	 */
	private Date fechaControl;

	/**
	 * entidad federativa
	 */
	private EntidadFederativa entidadFederativa;

	/**
	 * @return el atributo id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return el atributo claveMunicipio
	 */
	public String getClaveMunicipio() {
		return claveMunicipio;
	}

	/**
	 * @param claveMunicipio parametro claveMunicipio a actualizar
	 */
	public void setClaveMunicipio(String claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
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
	 * @return el atributo entidadFederativa
	 */
	public EntidadFederativa getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa parametro entidadFederativa a actualizar
	 */
	public void setEntidadFederativa(EntidadFederativa entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("NsarMunicipio [id=");
		cadena.append(id);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", claveMunicipio=");
		cadena.append(claveMunicipio);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", entidadFederativa=");
		cadena.append(entidadFederativa);
		cadena.append("]");
		
		return cadena.toString();
	}
	
	
}
