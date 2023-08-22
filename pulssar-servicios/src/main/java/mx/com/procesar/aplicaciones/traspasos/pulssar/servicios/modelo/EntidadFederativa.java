/**
 * EntidadFederativa.java
 * Fecha de creación: Mar 26, 2019, 12:46:48 PM
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
import java.util.Date;

/**
 * mapeo de la tabla NSAR_TC_ENTIDAD_FEDERATIVA
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 26, 2019
 */

public class EntidadFederativa implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1205389263744839040L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * clave string
	 */
	private String chCvEntidadFederativa;

	/**
	 * descripcion
	 */
	private String descripcion;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * clave corta
	 */
	private String claveCorta;

	/**
	 * fecha control
	 */
	private Date fechaControl;

	/**
	 * pais
	 */	
	private Pais pais;

	/**
	 * clave numerica
	 */
	private BigDecimal nuCvEntidadFederativa;

	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el atributo chCvEntidadFederativa
	 */
	public String getChCvEntidadFederativa() {
		return chCvEntidadFederativa;
	}

	/**
	 * @param chCvEntidadFederativa parametro chCvEntidadFederativa a actualizar
	 */
	public void setChCvEntidadFederativa(String chCvEntidadFederativa) {
		this.chCvEntidadFederativa = chCvEntidadFederativa;
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
	 * @return el atributo claveCorta
	 */
	public String getClaveCorta() {
		return claveCorta;
	}

	/**
	 * @param claveCorta parametro claveCorta a actualizar
	 */
	public void setClaveCorta(String claveCorta) {
		this.claveCorta = claveCorta;
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
	 * @return el atributo pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais parametro pais a actualizar
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return el atributo nuCvEntidadFederativa
	 */
	public BigDecimal getNuCvEntidadFederativa() {
		return nuCvEntidadFederativa;
	}
	
	/**
	 * @param nuCvEntidadFederativa parametro nuCvEntidadFederativa a actualizar
	 */
	public void setNuCvEntidadFederativa(BigDecimal nuCvEntidadFederativa) {
		this.nuCvEntidadFederativa = nuCvEntidadFederativa;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("EntidadFederativa [id=");
		cadena.append(id);
		cadena.append(", chCvEntidadFederativa=");
		cadena.append(chCvEntidadFederativa);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", claveCorta=");
		cadena.append(claveCorta);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", idPais=");
		cadena.append(pais);
		cadena.append(", nuCvEntidadFederativa=");
		cadena.append(nuCvEntidadFederativa);
		cadena.append("]");
		
		return cadena.toString();
	}
	
	
}
