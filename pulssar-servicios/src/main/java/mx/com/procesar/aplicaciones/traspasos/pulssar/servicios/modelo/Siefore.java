/**
 * Siefore.java
 * Fecha de creación: May 3, 2019, 12:30:18 PM
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
 * mapeo de la tabla TRAN_TC_SIEFORE
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since May 3, 2019
 */
public class Siefore implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -4461675951338727376L;

	/**
	 * clave de siefore
	 */
	private String clave;

	/**
	 * nombre siefore
	 */
	private String nombreSiefore;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * clave segun banco de mexico
	 */
	private String claveCasfin;

	/**
	 * grupo del trabajador
	 */
	private String claveGrupoTrabajador;

	/**
	 * fecha de alta
	 */
	private Date fechaAlta;

	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * estatus de bloqueo
	 */
	private Long estatusBloqueo;

	/**
	 * indicador del siefore
	 */
	private Long tipo;

	/**
	 * afore
	 */
	private Long afore;

	/**
	 * @return el atributo clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave parametro clave a actualizar
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return el atributo nombreSiefore
	 */
	public String getNombreSiefore() {
		return nombreSiefore;
	}

	/**
	 * @param nombreSiefore parametro nombreSiefore a actualizar
	 */
	public void setNombreSiefore(String nombreSiefore) {
		this.nombreSiefore = nombreSiefore;
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
	 * @return el atributo claveCasfin
	 */
	public String getClaveCasfin() {
		return claveCasfin;
	}

	/**
	 * @param claveCasfin parametro claveCasfin a actualizar
	 */
	public void setClaveCasfin(String claveCasfin) {
		this.claveCasfin = claveCasfin;
	}

	/**
	 * @return el atributo claveGrupoTrabajador
	 */
	public String getClaveGrupoTrabajador() {
		return claveGrupoTrabajador;
	}

	/**
	 * @param claveGrupoTrabajador parametro claveGrupoTrabajador a actualizar
	 */
	public void setClaveGrupoTrabajador(String claveGrupoTrabajador) {
		this.claveGrupoTrabajador = claveGrupoTrabajador;
	}

	/**
	 * @return el atributo fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta parametro fechaAlta a actualizar
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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
	 * @return el atributo estatusBloqueo
	 */
	public Long getEstatusBloqueo() {
		return estatusBloqueo;
	}

	/**
	 * @param estatusBloqueo parametro estatusBloqueo a actualizar
	 */
	public void setEstatusBloqueo(Long estatusBloqueo) {
		this.estatusBloqueo = estatusBloqueo;
	}

	/**
	 * @return el atributo tipo
	 */
	public Long getTipo() {
		return tipo;
	}

	/**
	 * @param tipo parametro tipo a actualizar
	 */
	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return el atributo afore
	 */
	public Long getAfore() {
		return afore;
	}

	/**
	 * @param afore parametro afore a actualizar
	 */
	public void setAfore(Long afore) {
		this.afore = afore;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("Siefore [clave=").append(clave)
		.append(", nombreSiefore=").append(nombreSiefore)
		.append(", usuarioModificador=").append(usuarioModificador)
		.append(", claveCasfin").append(claveCasfin)
		.append(", claveGrupoTrabajador=").append(claveGrupoTrabajador)
		.append(", fechaAlta=").append(fechaAlta)
		.append(", fechaControl=").append(fechaControl)
		.append(", estatusBloqueo=").append(estatusBloqueo)
		.append(", tipo=").append(tipo)
		.append(", afore=").append(afore)
		.append("]");
		
		return cadena.toString();
	}

	
}
