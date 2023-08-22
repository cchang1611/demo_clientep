/**
 * NsarBeneficiario.java
 * Fecha de creación: Mar 27, 2019, 11:48:39 AM
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
 * mapeo de la tabla NSAR_TR_BENEFICIARIO
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 27, 2019
 */
public class NsarBeneficiario implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1594029049430032192L;

	/**
	 * id
	 */
	private NsarBeneficiarioPK id;

	/**
	 * apellido materno
	 */
	private String apellidoMaterno;

	/**
	 * apellido paterno
	 */
	private String apellidoPaterno;

	/**
	 * nombre
	 */
	private String nombre;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * fechaControl
	 */
	private Date fechaControl;

	/**
	 * porcentaje
	 */
	private BigDecimal porcentaje;

	/**
	 * parentesco
	 */
	private Parentesco parentesco;


	/**
	 * @return el atributo id
	 */
	public NsarBeneficiarioPK getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(NsarBeneficiarioPK id) {
		this.id = id;
	}

	/**
	 * @return el atributo apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return el atributo apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno parametro apellidoPaterno a actualizar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

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
	 * @return el atributo porcentaje
	 */
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje parametro porcentaje a actualizar
	 */
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return el atributo parentesco
	 */
	public Parentesco getParentesco() {
		return parentesco;
	}

	/**
	 * @param parentesco parametro parentesco a actualizar
	 */
	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}


	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("NsarBeneficiario [id=");
		cadena.append(id);
		cadena.append(", apellidoMaterno=");
		cadena.append(apellidoMaterno);
		cadena.append(", apellidoPaterno=");
		cadena.append(apellidoPaterno);
		cadena.append(", nombre=");
		cadena.append(nombre);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", porcentaje=");
		cadena.append(porcentaje);
		cadena.append(", parentesco=");
		cadena.append(parentesco);
		cadena.append("]");
		
		return cadena.toString();
	}
	
	
}
