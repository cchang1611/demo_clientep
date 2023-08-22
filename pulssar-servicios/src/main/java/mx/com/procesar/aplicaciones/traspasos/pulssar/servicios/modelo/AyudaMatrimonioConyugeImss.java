/**
 * AyudaMatrimonioConyugeImss.java
 * Fecha de creación: Aug 18, 2020 12:42:35 PM
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
public class AyudaMatrimonioConyugeImss implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 8328184164985036250L;

	/**
	 * fechaMatrimonio
	 */
	private String fechaMatrimonio;
	/**
	 * nombre
	 */
	private String nombre;
	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;
	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;
	/**
	 * sexo
	 */
	private String sexo;
	/**
	 * entidadEmisionActa
	 */
	private String entidadEmisionActa;
	/**
	 *  getFechaMatrimonio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getFechaMatrimonio() {
		return fechaMatrimonio;
	}
	/**
	 *  setFechaMatrimonio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaMatrimonio
	 */
	public void setFechaMatrimonio(String fechaMatrimonio) {
		this.fechaMatrimonio = fechaMatrimonio;
	}
	/**
	 *  getNombre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *  setNombre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 *  getApellidoMaterno
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 *  setApellidoMaterno
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 *  getApellidoPaterno
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 *  setApellidoPaterno
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 *  getSexo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 *  setSexo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 *  getEntidadEmisionActa
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getEntidadEmisionActa() {
		return entidadEmisionActa;
	}
	/**
	 *  setEntidadEmisionActa
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param entidadEmisionActa
	 */
	public void setEntidadEmisionActa(String entidadEmisionActa) {
		this.entidadEmisionActa = entidadEmisionActa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		
		sb.append("fechaMatrimonio ");
		sb.append(fechaMatrimonio);
		sb.append("nombre ");
		sb.append(nombre);
		sb.append("apellidoMaterno ");
		sb.append(apellidoMaterno);
		sb.append("apellidoPaterno ");
		sb.append(apellidoPaterno);
		sb.append("sexo ");
		sb.append(sexo);
		sb.append("entidadEmisionActa ");
		sb.append(entidadEmisionActa);
		
		return sb.toString(); 
	}

	
	
}
