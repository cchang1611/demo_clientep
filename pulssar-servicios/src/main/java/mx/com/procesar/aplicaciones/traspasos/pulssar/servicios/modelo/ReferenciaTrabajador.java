package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * Representa una referencia
 * 
 * @author OJBALBUE
 * 
 */
public class ReferenciaTrabajador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9036718822283990585L;

	/**
	 * identificadores id
	 */
	private ReferenciaTrabajadorPK id;

	/**
	 * identificador de la referencia
	 */
	private Parentesco parentesco;

	/**
	 * identificador de la referencia
	 */
	private Participante participante;

	/**
	 * Nombre
	 */
	private String nombre;

	/**
	 * Telefono
	 */
	private String telefono;

	/**
	 * Apellido Paterno
	 */
	private String apellidoPaterno;

	/**
	 * Apellido Materno
	 */
	private String apellidoMaterno;
	/**
	 * ocupacion
	 */
	private String ocupacion;
	/**
	 * Fecha de última modificación del registro
	 */
	private Date fechaModificacion;

	/**
	 * Usuario/Programa o Ente que hizo la última modificación del registro.
	 */
	private String usuarioModificador;

	/**
	 * @return the id
	 */
	public ReferenciaTrabajadorPK getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ReferenciaTrabajadorPK id) {
		this.id = id;
	}

	/**
	 * @return the parentesco
	 */
	public Parentesco getParentesco() {
		return parentesco;
	}

	/**
	 * @param parentesco
	 *            the parentesco to set
	 */
	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return the participante
	 */
	public Participante getParticipante() {
		return participante;
	}

	/**
	 * @param participante
	 *            the participante to set
	 */
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
